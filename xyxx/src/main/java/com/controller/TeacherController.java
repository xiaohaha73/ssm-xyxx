package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 教师模块控制器
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @RequestMapping("/index")
    public String index() {
        return "teacher/index";
    }
}
