package com.controller;

import com.pojo.Kcb;
import com.pojo.Xuanke;
import com.service.KcbService;
import com.service.XuankeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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



}
