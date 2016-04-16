package com.letsbuild.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.letsbuild.base.util.StringUtil;

public class UserInterceptor extends HandlerInterceptorAdapter {
    
    private static final String ROLE_LEADER = "1";
    private static final String ROLE_CUSTMANAGER = "2";
    private static final String ROLE_FINANCIAL = "3";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        String username = (String) request.getSession().getAttribute("username");
        String userrole = (String) request.getSession().getAttribute("userrole");
        if (StringUtil.isBlank(username)||StringUtil.isBlank(userrole)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }/*
        if(userrole.equals(ROLE_CUSTMANAGER)&&!request.getServletPath().startsWith("/order")){
            return false;
        }
        if(userrole.equals(ROLE_FINANCIAL)&&!request.getServletPath().startsWith("/fund")){
            return false;
        }*/
        return true;
    }
}
