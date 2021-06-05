package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 管理员控制器
@Controller
@RequestMapping("/admin")
public class Admin {

    // 加载管理员首页
    @RequestMapping("/index")
    public String index() {
        return "admin/index";
    }
}
