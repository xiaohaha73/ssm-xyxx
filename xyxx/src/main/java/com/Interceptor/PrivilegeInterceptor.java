package com.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 登陆拦截器

public class PrivilegeInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断是否存在Session
        HttpSession session = request.getSession();

        String user = (String) session.getAttribute("user");

        if (user == null) {
            //没有登录直接重定向到登陆界面
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }

        //放行  访问目标资源
        return true;
    }
}
