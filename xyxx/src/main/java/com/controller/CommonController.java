package com.controller;

import com.pojo.Kcb;
import com.pojo.Kecheng;
import com.pojo.Keshi;
import com.service.KcbService;
import com.service.KechengService;
import com.service.KeshiService;
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
}
