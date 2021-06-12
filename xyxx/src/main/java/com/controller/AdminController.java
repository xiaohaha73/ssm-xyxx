package com.controller;

import com.pojo.Teacher;
import com.service.AdminService;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pojo.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

// 管理员控制器
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;

    // 加载管理员首页
    @RequestMapping("/index")
    public String index() {
        return "admin/index";
    }

    // 添加管理员界面
    @RequestMapping("/addpage")
    public String addPage() {
        return "admin/glyadd";
    }

    // 添加管理员接口
    @PostMapping("/add")
    public String addAdmin(HttpServletRequest req) {
        String yhm = req.getParameter("yhm"); // 用户名
        String mm = req.getParameter("mm"); // 密码
        String xm = req.getParameter("xm"); // 姓名
        if (yhm != null && mm != null && xm != null) {

            // 查询这个管理员是否存在数据库中
            com.pojo.Admin user = adminService.getAdminByYhm(yhm);
            if (user != null) {
                // 用户存在
                req.setAttribute("msg", "<script>alert('用户已经存在');</script>");//操作提示
                return "admin/glyadd";
            }

            com.pojo.Admin admin = new com.pojo.Admin(yhm, mm, xm);
            int ret = adminService.addAdmin(admin);
            if (ret > 0) {
                // 添加成功
                req.setAttribute("msg", "<script>alert('添加成功');</script>");//操作提示
            } else {
                req.setAttribute("msg", "<script>alert('添加失败');</script>");//操作提示
                return "admin/glyadd";
            }
        }

        return "redirect:/admin/listpage";
    }

    // 管理员列表界面
    @RequestMapping("/listpage")
    public String listPage(HttpServletRequest request, Model model) {
        // 获取到的页码
        Integer startIndex = request.getParameter("start") == null ? 0 : Integer.parseInt(request.getParameter("start"));
        // 获取每页显示条数
        Integer pageSize = request.getParameter("size") == null ? 4 : Integer.parseInt(request.getParameter("size"));
        // 查询所有的管理员数据
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        if (pageSize != 0) {
            map.put("startIndex", startIndex);
            map.put("pageSize", pageSize);
        }

        List<Admin> admins = adminService.getAdmins(map);
        model.addAttribute("list", admins);
        return "admin/glylist";
    }

    // 删除管理员
    @RequestMapping("/del")
    public String delAdmin(HttpServletRequest request) {
        // 获取管理员id
        int glyid = Integer.parseInt(request.getParameter("keyid"));
        int ret = adminService.delAdmin(glyid);
        if (ret > 0) {
            // 删除成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        } else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }

        return "redirect:/admin/listpage";
    }


    // 编辑管理员界面
    @RequestMapping("/modifypage")
    public String editPage(HttpServletRequest request, Model model) {

        // 根据id值查询这个管理员
        int glyid = Integer.parseInt(request.getParameter("keyid"));
        Admin admin = adminService.getAdminById(glyid);

        String yhm = admin.getYhm();
        String mm = admin.getMm();
        String xm = admin.getXm();
        int glyid1 = admin.getGlyid();
        model.addAttribute("yhm", yhm);
        model.addAttribute("mm", mm);
        model.addAttribute("xm", xm);
        model.addAttribute("glyid", glyid1);
        return "admin/glymodify";
    }


    // 提交管理员修改
    @PostMapping("/update")
    public String updateAdmin(HttpServletRequest request) {

        String yhm = request.getParameter("yhm");
        String mm = request.getParameter("mm");
        String xm = request.getParameter("xm");
        int glyid = Integer.parseInt(request.getParameter("glyid"));

        Admin admin = new Admin();
        admin.setGlyid(glyid);
        admin.setYhm(yhm);
        admin.setMm(mm);
        admin.setXm(xm);
        int ret = adminService.updateAdmin(admin);
        if (ret > 0) {
            // 更新成功
            request.setAttribute("msg", "<script>alert('更新成功');</script>");
        } else {
            request.setAttribute("msg", "<script>alert('更新失败');</script>");
        }

        return "redirect:/admin/listpage";
    }


    // 加载管理员详情页面
    @RequestMapping("/detail")
    public String detail(HttpServletRequest request, Model model) {
        int glyid = Integer.parseInt(request.getParameter("keyid"));
        Admin admin = adminService.getAdminById(glyid);

        String yhm = admin.getYhm();
        String mm = admin.getMm();
        String xm = admin.getXm();
        model.addAttribute("yhm", yhm);
        model.addAttribute("mm", mm);
        model.addAttribute("xm", xm);
        model.addAttribute("glyid", glyid);

        return "admin/glydetail";
    }


    // 添加老师页面
    @RequestMapping("/addteacher")
    public String addteacher() {
        return "/admin/jiaoshi/jiaoshiadd";
    }

    // 添加教师post请求
    @PostMapping("/addtea")
    public String addTea(HttpServletRequest request, Teacher teacher) {
        System.out.println(teacher);
        // String yhm = request.getParameter("yhm");//用户名

        // 查询是否存在该教师
        Teacher oldTeacher = teacherService.getTeacherByYhm(teacher.getYhm());
        if (oldTeacher != null) {
            request.setAttribute("msg", "<script>alert('该用户已经存在');</script>");
            return "redirect:/admin/addteacher";
        }

        // 存储老师
        int ret = teacherService.addTeacher(teacher);
        if (ret < 0 ) {
            request.setAttribute("msg", "<script>alert('添加失败');</script>");
            return "redirect:/admin/addteacher";
        }

        request.setAttribute("msg", "<script>alert('添加成功');</script>");
        return "redirect:/admin/teacherlist";
    }

    // 教师列表
    @RequestMapping("/teacherlist")
    public String teacherlist(Model model) {
        // 查询所有教师
        List<Teacher> teachers = teacherService.getTeachers();
        model.addAttribute("list",teachers);
        return "/admin/jiaoshi/jiaoshilist";
    }

    // 删除教师操作
    @RequestMapping("/delteacher")
    public String delTeacher(HttpServletRequest request) {
        int jsid = Integer.parseInt(request.getParameter("keyid"));
        // 调用service层
        int ret = teacherService.delTeacher(jsid);
        if (ret > 0 ) {
            // 删除成功
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除失败');</script>");
        }
        return "redirect:/admin/teacherlist";
    }


    // 修改教师页面
    @RequestMapping("/updateteapage")
    public String updateTeaPage(HttpServletRequest request, Model model) {
        // 获取传递过来的教师id
        int jsid = Integer.parseInt(request.getParameter("keyid"));
        // 查询出教师的信息
        Teacher teacher = teacherService.getTeacherById(jsid);
        model.addAttribute("jsid",teacher.getJsid());
        model.addAttribute("yhm",teacher.getYhm());
        model.addAttribute("xm",teacher.getXm());
        model.addAttribute("mm",teacher.getYhm());
        model.addAttribute("lxdh",teacher.getLxdh());
        model.addAttribute("lxdz",teacher.getLxdz());
        model.addAttribute("xy",teacher.getXy());
        return "/admin/jiaoshi/editpage";
    }

    // 更新教师
    @PostMapping("/updateteacher")
    public String updateTeacher(Teacher teacher,HttpServletRequest request) {
        // System.out.println(teacher);
        int ret = teacherService.updateTeacher(teacher);
        if (ret > 0) {
            // 更新成功
            request.setAttribute("msg", "<script>alert('更新成功');</script>");
        }else {
            request.setAttribute("msg", "<script>alert('删除成功');</script>");
        }

        return "redirect:/admin/teacherlist";
    }

    // 展示教师详细信息的页面
    @RequestMapping("/teacherdetail")
    public String teaDetail(Model model,HttpServletRequest request) {
        // 获取传递过来的教师id
        int jsid = Integer.parseInt(request.getParameter("keyid"));
        // 查询出教师的信息
        Teacher teacher = teacherService.getTeacherById(jsid);
        model.addAttribute("jsid",teacher.getJsid());
        model.addAttribute("yhm",teacher.getYhm());
        model.addAttribute("xm",teacher.getXm());
        model.addAttribute("mm",teacher.getYhm());
        model.addAttribute("lxdh",teacher.getLxdh());
        model.addAttribute("lxdz",teacher.getLxdz());
        model.addAttribute("xy",teacher.getXy());
        return "/admin/jiaoshi/jiaoshidetail";
    }



}
