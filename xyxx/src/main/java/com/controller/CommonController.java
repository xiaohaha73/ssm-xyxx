package com.controller;

import com.pojo.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private KechengService kechengService;
    @Autowired
    private KeshiService keshiService;
    @Autowired
    private KcbService kcbService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private BanjiService banjiService;



    // 课程表列表页面
    @RequestMapping("/kcblistpage")
    public String kcblistPage (Model model) {

        List<Kcb> kcbs = kcbService.listAll();
        model.addAttribute("list",kcbs);

        return "common/kcblist";
    }


    // 删除课程表列表操作
    @RequestMapping("/delkcb")
    public String delKcb (HttpServletRequest request) {
        int kcbid = Integer.parseInt(request.getParameter("keyid"));
        int ret = kcbService.delete(kcbid);
        if (ret > 0) {
            // 删除成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }

        return "redirect:/common/kcblistpage";
    }


    // 课程表编辑界面
    @RequestMapping("/editkcb")
    public String editKcbPage (Model model,HttpServletRequest request) {

        // 获取所有的课程名称
        List<Kecheng> kechengList = kechengService.listAll();
        model.addAttribute("keList",kechengList);

        // 获取所有的课程时间
        List<Keshi> keshiList = keshiService.listAll();
        model.addAttribute("keshiList",keshiList);

        // 根据id获取课程表信息
        int kcbid = Integer.parseInt(request.getParameter("keyid"));
        Kcb kcb = kcbService.getById(kcbid);
        model.addAttribute("kcbid",kcb.getKcbid());
        model.addAttribute("kc",kcb.getKc());
        model.addAttribute("skdd",kcb.getSkdd());
        model.addAttribute("sksj",kcb.getSksj());
        model.addAttribute("sm",kcb.getSm());
        model.addAttribute("ks",kcb.getKs());
        return "common/kcbedit";
    }


    // 提交修改请求
    @PostMapping("/editkcb")
    public String editKcb (Kcb kcb,HttpServletRequest request) {
        int ret = kcbService.update(kcb);
        if (ret > 0) {
            // 修改成功
            request.setAttribute("msg", "<script>alert('修改成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('修改失败');</script>");
        }
        return "redirect:/common/kcblistpage";
    }


    // 展示课程表详情
    @RequestMapping("/kcbdetail")
    public String kcbDetail (HttpServletRequest request,Model model) {
        int kcbid = Integer.parseInt(request.getParameter("keyid"));
        Kcb kcb = kcbService.getById(kcbid);
        model.addAttribute("kcbid",kcb.getKcbid());
        model.addAttribute("kc",kcb.getKc());
        model.addAttribute("skdd",kcb.getSkdd());
        model.addAttribute("sksj",kcb.getSksj());
        model.addAttribute("sm",kcb.getSm());
        model.addAttribute("ks",kcb.getKs());
        return "common/kcbdetail";
    }



    // 学生的相关操作
    // 添加学生界面 addStuPage
    @RequestMapping("/addstupage")
    public String addStuPage (Model model) {
        // 查询出所有的班级
        List<Banji> banjis = banjiService.getBanjis();
        model.addAttribute("banjis",banjis);
        return "/common/xuesheng/addStudent";
    }

    // 添加学生接口
    @PostMapping("/addstudent")
    public String addStudent(Student student, HttpServletRequest request) {
        // System.out.println(student);
        int ret = studentService.addStudent(student);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('添加成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('添加失败');</script>");
        }

        return "redirect:/common/studentspage";
    }


    // 学生列表界面 studentList
    @RequestMapping("/studentspage")
    public String studentsPage (Model model) {
        // 查询所有的学生
        List<Student> students = studentService.getStudents();
        model.addAttribute("list",students);
        return "/common/xuesheng/studentsList";
    }


    // 删除学生接口
    @RequestMapping("delstudent")
    public String delStudent (HttpServletRequest request) {
        int xsid = Integer.parseInt(request.getParameter("keyid"));
        int ret = studentService.delStudent(xsid);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }

        return "redirect:/common/studentspage";

    }


    // 跳转学生编辑界面
    @RequestMapping("editstupage")
    public String editStudent (HttpServletRequest request,Model model) {
        // 查询出所有的班级
        List<Banji> banjis = banjiService.getBanjis();
        model.addAttribute("banjis",banjis);

        // 根据id查询这个学生的信息
        int xsid = Integer.parseInt(request.getParameter("keyid"));
        Student student = studentService.getStudentById(xsid);
        model.addAttribute("xsid",student.getXsid());
        model.addAttribute("yhm",student.getYhm());
        model.addAttribute("mm",student.getMm());
        model.addAttribute("xm",student.getXm());
        model.addAttribute("zy",student.getZy());
        model.addAttribute("xy",student.getXy());
        model.addAttribute("nl",student.getNl());
        model.addAttribute("dh",student.getDh());
        model.addAttribute("bj",student.getBj());

        return "/common/xuesheng/editStudent";
    }

    // 提交修改处理
    @PostMapping("/editstudent")
    public String editStu (Student student,HttpServletRequest request) {

        // System.out.println(student);
        int ret = studentService.updateStudent(student);
        if (ret > 0) {
            // 添加成功
            request.setAttribute("msg", "<script>alert('修改成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('修改失败');</script>");
        }

        return "redirect:/common/studentspage";
    }

    // 展示学生的详细信息
    @RequestMapping("/studentdetail")
    public String stuDetail (HttpServletRequest request,Model model) {
        // 根据id查询这个学生的信息
        int xsid = Integer.parseInt(request.getParameter("keyid"));
        Student student = studentService.getStudentById(xsid);
        model.addAttribute("xsid",student.getXsid());
        model.addAttribute("yhm",student.getYhm());
        model.addAttribute("mm",student.getMm());
        model.addAttribute("xm",student.getXm());
        model.addAttribute("zy",student.getZy());
        model.addAttribute("xy",student.getXy());
        model.addAttribute("nl",student.getNl());
        model.addAttribute("dh",student.getDh());
        model.addAttribute("bj",student.getBj());

        return "/common/xuesheng/studentDetail";
    }


}
