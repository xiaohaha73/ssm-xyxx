package com.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TeacherInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断是否存在Session
        HttpSession session = request.getSession();

        String role = (String) session.getAttribute("role");

        if (role != null && role.equals("teacher")) {
            //放行  访问目标资源
            return true;
        }

        //没有权限，设置状态码，跳转403页面
        response.sendError(403);
        return false;
    }
}
