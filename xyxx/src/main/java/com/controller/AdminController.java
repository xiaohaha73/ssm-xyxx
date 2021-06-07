package com.controller;

import com.service.AdminService;
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


    // 提交修改
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


    // 加载详情页面
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


}
