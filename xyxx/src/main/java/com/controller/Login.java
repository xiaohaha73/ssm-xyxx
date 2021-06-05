package com.controller;

import com.pojo.Admin;
import com.pojo.Student;
import com.pojo.Teacher;
import com.service.AdminService;
import com.service.StudentService;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Login {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdminService adminService;


    // 加载登陆界面
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg",null);
        return "login";
    }

    // 登陆检查
    @PostMapping("/logincheck")
    // @ResponseBody
    public String logincheck(HttpServletRequest req, Model model) {

        // 接收参数
        String username= req.getParameter("username"); // 用户名
        String password= req.getParameter("password"); // 密码
        String qx= req.getParameter("qx"); // 权限

        // System.out.println(qx);
        if (qx.equals("student")) {
            // System.out.println("学生");
            try {
                // 调用学生查询
                Student student = studentService.getStudentByYhm(username);
                // 匹配密码
                if(password.equals(student.getMm())) {
                    model.addAttribute("msg",null);
                    // 创建session
                    HttpSession session = req.getSession();
                    session.setAttribute("user",username); // 存入用户名
                    session.setAttribute("role","student"); // 存入角色值role用于判断
                    return "redirect:/student/index";
                }
                model.addAttribute("msg","账号或密码错误！");
                return "login";
            } catch (Exception e) {
                e.printStackTrace();
            }

            model.addAttribute("msg","用户名不存在！");
            return "login";

        }else if (qx.equals("teacher")) {

            try {
                // System.out.println("老师");
                Teacher teacher = teacherService.getTeacherByYhm(username);
                // 匹配密码
                if(password.equals(teacher.getMm())) {
                    // 创建session
                    HttpSession session = req.getSession();
                    session.setAttribute("user",username); // 存入用户名
                    session.setAttribute("role","teacher"); // 存入角色值role用于判断
                    return "redirect:/teacher/index";
                }

                model.addAttribute("msg","账号或密码错误！");
                return "login";
            } catch (Exception e) {
                e.printStackTrace();
            }

            model.addAttribute("msg","用户名不存在！");
            return "login";
        }else {
            try {
                // System.out.println("管理员");
                Admin admin = adminService.getAdminByYhm(username);
                // 匹配密码
                if(password.equals(admin.getMm())) {
                    // 创建session
                    HttpSession session = req.getSession();
                    session.setAttribute("user",username); // 存入用户名
                    session.setAttribute("role","admin"); // 存入角色值role用于判断
                    return "redirect:/admin/index";
                }

                model.addAttribute("msg","账号或密码错误！");
                return "login";
            } catch (Exception e) {
                e.printStackTrace();
            }

            model.addAttribute("msg","用户名不存在！");
            return "login";

        }
        // return "";
    }


    // 退出登陆接口
    @RequestMapping("/loginout")
    public String loginout(HttpServletRequest req) {
        // 清除session
        req.getSession().invalidate();
        // 重定向
        return "login";
    }
}
