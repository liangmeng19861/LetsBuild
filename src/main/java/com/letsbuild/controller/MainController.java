package com.letsbuild.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letsbuild.base.exception.SystemException;
import com.letsbuild.base.util.CollectionUtil;
import com.letsbuild.base.util.StringUtil;
import com.letsbuild.business.interfaces.ISysBusiSV;
import com.letsbuild.dao.mapper.bo.SysRole;
import com.letsbuild.dao.mapper.bo.SysUser;
import com.letsbuild.service.interfaces.ISysRoleSV;
import com.letsbuild.service.interfaces.ISysUserSV;
import com.letsbuild.vo.UserVo;

@Controller
public class MainController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private ISysBusiSV sysBusiSV;

    @RequestMapping(value = "/login")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        logger.info("开始登录");
        try {
            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            if (StringUtil.isBlank(username) || StringUtil.isBlank(password)) {
                throw new SystemException("登录名或密码为空");
            }
            UserVo user = sysBusiSV.queryUser(username);
            if (user == null || !password.equals(user.getPassword())) {
                throw new SystemException("登录名或密码错误");
            }
            if (CollectionUtil.isEmpty(user.getRoles())) {
                throw new SystemException("登录用户没有角色");
            }
            List<SysRole> roleList = user.getRoles();
            StringBuffer authority = new StringBuffer();
            Long[] roles;
            if (CollectionUtil.isEmpty(roleList)) {
                roles = new Long[0];
                authority.append("");
            } else {
                int i = 0;
                roles = new Long[roleList.size()];
                for (SysRole role : roleList) {
                    for (String auth : role.getAuthority().split(",")) {
                        if (authority.indexOf(auth) < 0) {
                            authority.append(auth);
                        }
                    }
                    roles[i] = role.getId();
                }
            }
            request.getSession().setAttribute("userid", user.getId());
            request.getSession().setAttribute("username", user.getLoginname());
            request.getSession().setAttribute("fullname", user.getName());
            request.getSession().setAttribute("authority", authority.toString());
            request.getSession().setAttribute("roleids", roles);
            logger.info("登录成功");
            responseSuccess(response, "登录成功", null);
        } catch (Exception e) {
            logger.info("登录失败:{}", e.getMessage());
            responseSuccess(response, "登录失败", null);
        }
    }
    
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().invalidate();
        return "redirect："+request.getContextPath();
    }

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "index";
    }

}
