package com.letsbuild.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.letsbuild.dao.mapper.bo.SysMenu;
import com.letsbuild.dao.mapper.bo.SysUser;
import com.letsbuild.service.interfaces.ISysMenuSV;
import com.letsbuild.service.interfaces.ISysUserSV;

@Controller
@RequestMapping(value = "/manage")
public class ManageController extends BaseController {
	
	private static final Logger logger = LogManager.getLogger(ManageController.class);
	
	@Autowired
	private ISysUserSV iUserSV;
	@Autowired
	private ISysMenuSV iSysMenuSV;
	
	@RequestMapping(value = "/userlist")
	public String queryuser(HttpServletRequest request, HttpServletResponse response){
		logger.info("开始用户查询");
		List<SysUser> userList = iUserSV.querySysUser();
		logger.info(JSON.toJSONString(userList));
		logger.info("用户查询结束");
		return "/index";
	}
	
	@RequestMapping(value="/menulist")
	public void queryMenu(HttpServletRequest request, HttpServletResponse response){
		//List<SysMenu> menuList = iSysMenuSV.querySysMenu(new ArrayList<Long>());
		//responseSuccess(response,"菜单加载完毕",JSON.toJSONString(menuList));
	}
}
