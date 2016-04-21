package com.letsbuild.base.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.letsbuild.base.util.CollectionUtil;
import com.letsbuild.base.util.StringUtil;
import com.letsbuild.cache.CacheFactory;
import com.letsbuild.vo.MenuVo;

public class UserInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(UserInterceptor.class);

    private static final String ROLE_LEADER = "1";

    private static final String ROLE_CUSTMANAGER = "2";

    private static final String ROLE_FINANCIAL = "3";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        logger.debug("拦截到请求:{}", request.getServletPath());

        if ("/login".equals(request.getServletPath())) {
            logger.debug("登录请求通行:{}", request.getServletPath());
            return true;
        }
        // 登录校验
        String username = (String) request.getSession().getAttribute("username");
        String userrole = (String) request.getSession().getAttribute("authority");
        if (StringUtil.isBlank(username) || StringUtil.isBlank(userrole)) {
            logger.debug("Session中未获取到用户信息，跳转至登录页面");
            response.sendRedirect(request.getContextPath() + "/login.html");
            return false;
        }
        // 权限校验
        /*
         * if(userrole.equals(ROLE_CUSTMANAGER)&&!request.getServletPath().startsWith("/order")){
         * return false; }
         * if(userrole.equals(ROLE_FINANCIAL)&&!request.getServletPath().startsWith("/fund")){
         * return false; }
         */
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView) throws Exception {
        if ("/login".equals(request.getServletPath()) || "/logout".equals(request.getServletPath())) {
            return;
        }
        // 用户名
        request.setAttribute("fullnasme", request.getSession().getAttribute("fullname"));
        // 用户菜单
        Long userId = (Long) request.getSession().getAttribute("userid");
        List<MenuVo> menuList = CacheFactory.getMenu(userId);
        if (CollectionUtil.isEmpty(menuList)) {
            return;
        }

        boolean current = false;
        for (MenuVo vo : menuList) {
            vo.setCurrent("NO");
            if (request.getServletPath().startsWith(vo.getUrl())) {
                current = true;
                vo.setCurrent("YES");
                // 只有二级菜单
                if(CollectionUtil.isEmpty(vo.getChildMenu())){
                    continue;
                }
                for (MenuVo child : vo.getChildMenu()) {
                    child.setCurrent("NO");
                    if (request.getServletPath().equals((child.getUrl()))) {
                        current = true;
                        child.setCurrent("YES");
                    }
                }
            }
        }
        if (!current) {
            menuList.get(0).setCurrent("YES");
        }
        logger.debug("用户菜单加载:{}",JSON.toJSONString(menuList));
        request.setAttribute("menulist", menuList);
    }
}
