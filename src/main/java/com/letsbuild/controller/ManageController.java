package com.letsbuild.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.letsbuild.dao.mapper.bo.User;
import com.letsbuild.service.interfaces.IUserSV;

@Controller
@RequestMapping(value = "/manage")
public class ManageController extends BaseController {
	
	private static final Logger logger = LogManager.getLogger(ManageController.class);
	
	@Autowired
	private IUserSV iUserSV;
	
	@RequestMapping(value = "/userlist")
	public String queryuser(HttpServletRequest request, HttpServletResponse response){
		logger.info("开始用户查询");
		List<User> userList = iUserSV.queryUser();
		logger.info(JSON.toJSONString(userList));
		logger.info("用户查询结束");
		return "/index";
	}
}
