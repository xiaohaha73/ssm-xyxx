package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 学生模块控制器
@Controller
@RequestMapping("/student")
public class Student {

    @RequestMapping("/index")
    public String index() {
        return "student/index";
    }
}
