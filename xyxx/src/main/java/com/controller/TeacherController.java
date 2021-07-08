package com.controller;

import com.pojo.*;
import com.service.*;
import com.utils.StaticMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

// 教师模块控制器
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private XuankeService xuankeService;
    @Autowired
    private KechengService kechengService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ChengjiService chengjiService;
    @Autowired
    private ZpcjService zpcjService;

    @RequestMapping("/index")
    public String index() {
        return "teacher/index";
    }


    // 选课列表页面
    @RequestMapping("/xuankepage")
    public String xuankePage (Model model) {
        List<Xuanke> xuankes = xuankeService.listAll();
        model.addAttribute("list",xuankes);
        return "/teacher/xuanke/xuankelist";
    }

    // 选课删除接口
    @RequestMapping("/delxuanke")
    public String delXuanke (HttpServletRequest request) {
        int keyid = Integer.parseInt(request.getParameter("keyid"));
        int ret = xuankeService.delete(keyid);

        if (ret > 0) {
            // 删除成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }

        return "redirect:/teacher/xuankepage";

    }


    // 选课编辑界面
    @RequestMapping("/editxuanpage")
    public String editXuanPage (HttpServletRequest request, Model model) {
        int keyid = Integer.parseInt(request.getParameter("keyid"));
        // 查询出选课表
        Xuanke xuanke = xuankeService.getById(keyid);
        model.addAttribute("xkid",xuanke.getXkid());
        model.addAttribute("kc",xuanke.getKc());
        model.addAttribute("xs",xuanke.getXs());
        model.addAttribute("xksj",xuanke.getXksj());
        model.addAttribute("xkid",xuanke.getXkid());
        model.addAttribute("zt",xuanke.getZt());
        return "/teacher/xuanke/editxuanke";
    }


    // 提交更改选课请求
    @RequestMapping("/updatexuanke")
    public String updateXuanke (Xuanke xuanke,HttpServletRequest request) {
        int ret = xuankeService.update(xuanke);
        if (ret > 0) {
            // 更新成功
            request.setAttribute("msg", "<script>alert('更新成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('更新失败');</script>");
        }
        return "redirect:/teacher/xuankepage";
    }


    // 选课详情界面
    @RequestMapping("/xuankedetail")
    public String detailXuanke (HttpServletRequest request,Model model) {
        int keyid = Integer.parseInt(request.getParameter("keyid"));
        // 查询出选课表
        Xuanke xuanke = xuankeService.getById(keyid);
        model.addAttribute("xkid",xuanke.getXkid());
        model.addAttribute("kc",xuanke.getKc());
        model.addAttribute("xs",xuanke.getXs());
        model.addAttribute("xksj",xuanke.getXksj());
        model.addAttribute("xkid",xuanke.getXkid());
        model.addAttribute("zt",xuanke.getZt());

        return "/teacher/xuanke/xuankedetail";
    }


    // 添加成绩界面
    @RequestMapping("/addscorepage")
    public String addScorePage (Model model) {

        // 获取所有的课程信息
        List<Kecheng> kechengs = kechengService.listAll();
        model.addAttribute("kelist",kechengs);

        // 获取所有的学生
        List<Student> students = studentService.getStudents();
        model.addAttribute("stuList",students);
        return "/teacher/chengji/chengjiadd";
    }


    // 提交成绩接口
    @PostMapping("/addscore")
    public String addScore (Chengji chengji, HttpServletRequest request) {
        // System.out.println(chengji);
        // 添加登记时间
        chengji.setDjsj(StaticMethod.getStringDate());
        int ret = chengjiService.insert(chengji);

        if (ret > 0) {
            // 更新成功
            request.setAttribute("msg", "<script>alert('添加成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('添加失败');</script>");
        }
        return "redirect:/teacher/scorelist";
    }


    // 成绩列表展示
    @RequestMapping("/scorelist")
    public String scoreList (Model model) {

        // 查询出所有的成绩信息
        List<Chengji> chengjis = chengjiService.listAll();
        model.addAttribute("list",chengjis);
        return "/teacher/chengji/scorelist";
    }


    // 删除成绩操作
    @RequestMapping("/delscore")
    public String delScore (HttpServletRequest request) {

        // 获取id值
        int keyid = Integer.parseInt(request.getParameter("keyid"));
        int ret = chengjiService.delete(keyid);
        if (ret > 0) {
            // 更新成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }

        return "redirect:/teacher/scorelist";
    }


    // 编辑成绩界面
    @RequestMapping("/editscore")
    public String editScorePage (Model model,HttpServletRequest request) {
        // 获取所有的课程信息
        List<Kecheng> kechengs = kechengService.listAll();
        model.addAttribute("kelist",kechengs);

        // 获取所有的学生
        List<Student> students = studentService.getStudents();
        model.addAttribute("stuList",students);

        // 获取id值
        int keyid = Integer.parseInt(request.getParameter("keyid"));
        Chengji chengji = chengjiService.getById(keyid);
        model.addAttribute("cjid", chengji.getCjid());
        model.addAttribute("kc", chengji.getKc());
        model.addAttribute("xs", chengji.getXs());
        model.addAttribute("djsj", chengji.getDjsj());
        model.addAttribute("lx", chengji.getLx());
        model.addAttribute("cj", chengji.getCj());
        model.addAttribute("lb", chengji.getLb());
        return "/teacher/chengji/editscore";

    }


    // 提交成绩修改
    @PostMapping("/updatescore")
    public String updateScore (Chengji chengji, HttpServletRequest request) {
        int ret = chengjiService.update(chengji);
        if (ret > 0) {
            // 更新成功
            request.setAttribute("msg", "<script>alert('更新成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('更新失败');</script>");
        }
        return "redirect:/teacher/scorelist";
    }

    // 成绩详情页面
    @RequestMapping("/scoredetail")
    public String scoreDetail (Model model, HttpServletRequest request) {
        // 获取id值
        int keyid = Integer.parseInt(request.getParameter("keyid"));
        Chengji chengji = chengjiService.getById(keyid);
        model.addAttribute("cjid", chengji.getCjid());
        model.addAttribute("kc", chengji.getKc());
        model.addAttribute("xs", chengji.getXs());
        model.addAttribute("djsj", chengji.getDjsj());
        model.addAttribute("lx", chengji.getLx());
        model.addAttribute("cj", chengji.getCj());
        model.addAttribute("lb", chengji.getLb());
        return "/teacher/chengji/scoredetail";
    }

    // 添加总评成绩界面
    @RequestMapping("/finalscorepage")
    public String finalScorePage (Model model) {
        // 查询出所有的学生
        List<Student> stuList = studentService.getStudents();
        model.addAttribute("stuList",stuList);
        // 获取所有的课程信息
        List<Kecheng> kechengs = kechengService.listAll();
        model.addAttribute("kelist",kechengs);
        return "/teacher/zpcj/zpcjadd";
    }

    // 添加总评成绩接口
    @PostMapping("/addfinalscore")
    public String addFinalScore (Zpcj zpcj,HttpServletRequest request) {
        // 添加总评成绩的时间
        zpcj.setDjsj(StaticMethod.getStringDate());
//        System.out.println(zpcj);
        int ret = zpcjService.insert(zpcj);
        if (ret > 0) {
            // 更新成功
            request.setAttribute("msg", "<script>alert('添加成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('添加失败');</script>");
        }

        return "redirect:/teacher/finalscorelist";
    }



    // 总评成绩列表
    @RequestMapping("/finalscorelist")
    public String finalScoreList (Model model) {

        // 查询出所有的总评成绩
        List<Zpcj> zpcjs = zpcjService.listAll();
        model.addAttribute("list",zpcjs);
        return "/teacher/zpcj/zpcjlist";
    }


    // 删除总评成绩接口
    @RequestMapping("/delfinsco")
    public String delFinalScore (HttpServletRequest request,Model model) {
        Integer keyid = Integer.parseInt(request.getParameter("keyid"));
        int ret = zpcjService.delete(keyid);

        if (ret > 0) {
            // 更新成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }
        return "redirect:/teacher/finalscorelist";
    }


    // 编辑总评成绩接口
    @RequestMapping("/updatefinsco")
    public String updateFinalScore (HttpServletRequest request, Model model) {
        Integer keyid = Integer.parseInt(request.getParameter("keyid"));

        // 查询出这个总评成绩
        Zpcj zpcj = zpcjService.getById(keyid);
        model.addAttribute("zpcjid",zpcj.getZpcjid());
        model.addAttribute("kc",zpcj.getKc());
        model.addAttribute("xs",zpcj.getXs());
        model.addAttribute("pscj",zpcj.getPscj());
        model.addAttribute("qmcj",zpcj.getQmcj());
        model.addAttribute("zcj",zpcj.getZcj());


        // 获取所有课程kelist
        // 获取所有学生 stuList
        List<Student> stuList = studentService.getStudents();
        model.addAttribute("stuList",stuList);
        List<Kecheng> kechengs = kechengService.listAll();
        model.addAttribute("kelist",kechengs);

        return "/teacher/zpcj/zpcjedit";
    }


    // 总评成绩修改接口
    @PostMapping("/editfinsc")
    public String editFinalScore (Zpcj zpcj,HttpServletRequest request) {

        int ret = zpcjService.updateIgnoreNull(zpcj);
        if (ret > 0) {
            // 更新成功
            request.setAttribute("msg", "<script>alert('更新成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('更新失败');</script>");
        }
        return "redirect:/teacher/finalscorelist";
    }


    // 总评成绩详情界面
    @RequestMapping("/zpcjdetail")
    public String zpcjDetail (HttpServletRequest request, Model model) {

        Integer keyid = Integer.parseInt(request.getParameter("keyid"));

        // 查询出这个总评成绩
        Zpcj zpcj = zpcjService.getById(keyid);
        model.addAttribute("zpcjid",zpcj.getZpcjid());
        model.addAttribute("kc",zpcj.getKc());
        model.addAttribute("xs",zpcj.getXs());
        model.addAttribute("pscj",zpcj.getPscj());
        model.addAttribute("qmcj",zpcj.getQmcj());
        model.addAttribute("zcj",zpcj.getZcj());
        model.addAttribute("djsj",zpcj.getDjsj());

        return "/teacher/zpcj/zpcjdetail";
    }



}
