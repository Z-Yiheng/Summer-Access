package com.demo.access.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 张以恒
 * @create 2021/8/24-15:08
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //登录成功，存放用户session
        Object loginUser = request.getSession().getAttribute("username");

        //如果没有登录
        if (loginUser==null) {
            request.setAttribute("msg","没有权限，请先登录");
            request.getRequestDispatcher("/background").forward(request,response);
            return false;
        } else {
            return true;
        }
    }
}