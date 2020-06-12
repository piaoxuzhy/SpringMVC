package com.kkb.ssm.controller.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        // 直接去查询白名单
        System.out.println(requestURI);
        // 1、 如果请求的URL是公开地址（无需登录就可以访问的URL），采取放行。
        if(requestURI.indexOf("login") > -1){
            return true;
        }
        // 2、 如果用户session存在，则放行。
        String username = (String) request.getSession().getAttribute("username");
        if(!StringUtils.isEmpty(username)){
            return true;
        }
        // 3、 如果用户session中不存在，则跳转到登录页面。
        response.sendRedirect("/SpringMVC_01_SSM/login.jsp");
        return false;
    }
}
