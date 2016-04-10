package com.letsbuild.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.letsbuild.base.exception.SystemException;
import com.letsbuild.base.util.StringUtil;
import com.letsbuild.business.interfaces.IOrderBusiSV;
import com.letsbuild.vo.OrderVo;

@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private IOrderBusiSV orderBusiSV;

    /**
     * 接单立项提交
     * @param request
     * @param response
     * @param order
     */
    @RequestMapping(value = "/receive")
    public void receive(HttpServletRequest request, HttpServletResponse response, OrderVo order) {

        try {
            // 表单提交项
            if (StringUtil.isBlank(order.getProjectCode())) {
                throw new SystemException("项目编号不能为空");
            }
            if (StringUtil.isBlank(order.getProvinceCode())) {
                throw new SystemException("省份编号不能为空");
            }
            if (StringUtil.isBlank(order.getCityCode())) {
                throw new SystemException("城市编号不能为空");
            }
            if (StringUtil.isBlank(order.getBrandCode())) {
                throw new SystemException("品牌编号不能为空");
            }
            if (StringUtil.isBlank(order.getMerchant())) {
                throw new SystemException("商户名称不能为空");
            }
            if (StringUtil.isBlank(order.getAddress())) {
                throw new SystemException("商户地址不能为空");
            }
            if (StringUtil.isBlank(order.getContactName())) {
                throw new SystemException("联系人不能为空");
            }
            if (StringUtil.isBlank(order.getContactTel())) {
                throw new SystemException("联系人电话不能为空");
            }
            if (StringUtil.isBlank(order.getType())) {
                throw new SystemException("业务类型不能为空");
            }
            // FIXME 用户角色校验
            order.setProjectLeader(10l);// FIXME 用户ID

            orderBusiSV.receiveOrder(order);
        } catch (Exception e) {
            // FIXME
            responseFailed(response, e.getMessage(), null);
        }

    }
    
    /**
     * 订单报价提交
     * @param request
     * @param response
     * @param order
     */
    @RequestMapping(value = "/quote")
    public void quote(HttpServletRequest request, HttpServletResponse response, OrderVo order) {

        try {
            // 表单提交项
            if (order.getId() == null) {
                throw new SystemException("订单编号不能为空");
            }
            if (order.getQuotesAmount() == null) {
                throw new SystemException("报价金额不能为空");
            }
            
            // FIXME 用户角色校验
            order.setProjectLeader(10l);// FIXME 用户ID

            orderBusiSV.quoteOrder(order);
        } catch (Exception e) {
            // FIXME
        }
    }
}
