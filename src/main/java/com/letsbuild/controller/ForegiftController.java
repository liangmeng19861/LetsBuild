package com.letsbuild.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letsbuild.base.exception.SystemException;
import com.letsbuild.base.util.StringUtil;
import com.letsbuild.business.interfaces.IOrderBusiSV;
import com.letsbuild.vo.OrderVo;

@Controller
@RequestMapping(value = "/foregift")
public class ForegiftController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ForegiftController.class);

    @Autowired
    private IOrderBusiSV orderBusiSV;
    
    @RequestMapping
    public String order(HttpServletRequest request, HttpServletResponse response){
        return "order/query";
    }
    
    @RequestMapping(value="/edit")
    public String edit(HttpServletRequest request, HttpServletResponse response, OrderVo order){
        return "order/edit";
    }
}
