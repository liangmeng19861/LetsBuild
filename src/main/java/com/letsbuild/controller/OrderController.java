package com.letsbuild.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.letsbuild.base.exception.SystemException;
import com.letsbuild.base.util.DateUtil;
import com.letsbuild.base.util.StringUtil;
import com.letsbuild.business.interfaces.IOrderBusiSV;
import com.letsbuild.constants.SysConstants;
import com.letsbuild.vo.OrderVo;

@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderBusiSV orderBusiSV;
    
    /**
     * 查询页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method=RequestMethod.GET)
    public String querypage(HttpServletRequest request, HttpServletResponse response) {
        return "order/query";
    }
    /**
     * 接单页面
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/receive",method=RequestMethod.GET)
    public String receivepage(HttpServletRequest request, HttpServletResponse response) {
        return "order/receive";
    }

    /**
     * 订单编辑页面
     * @param request
     * @param response
     * @param opt
     * @param id
     * @return
     */
    @RequestMapping(value="/{opt}/{id}",method=RequestMethod.GET)
    public String opt(HttpServletRequest request, HttpServletResponse response,@PathVariable String opt,@PathVariable Long id) {
        return "order/"+opt;
    }

    /**
     * 订单查询
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "query",method=RequestMethod.POST)
    public String query(HttpServletRequest request, HttpServletResponse response) {
        String brandCode = request.getParameter("brandCode");
        String projectCode = request.getParameter("projectCode");
        String provinceCode = request.getParameter("provinceCode");
        String cityCode = request.getParameter("cityCode");
        String merchantName = request.getParameter("merchantName");
        String receiveTimeStart = request.getParameter("receiveTimeStart");
        String receiveTimeEnd = request.getParameter("receiveTimeEnd");
        // 只能查询本人订单
        Long projectLeader = (Long) request.getSession().getAttribute(
                SysConstants.SessionName.SESSION_NAME_USERID);
        // 接单开始结束时间
        Timestamp start = StringUtil.isBlank(receiveTimeStart) ? null : DateUtil.getTimestamp(
                receiveTimeStart, DateUtil.DATETIME_FORMAT);
        Timestamp end = StringUtil.isBlank(receiveTimeEnd) ? null : DateUtil.getTimestamp(
                receiveTimeEnd, DateUtil.DATETIME_FORMAT);
        List<OrderVo> voList = orderBusiSV.queryOrder(projectLeader, brandCode, projectCode,
                provinceCode, cityCode, merchantName, start, end,
                SysConstants.OrderQueryTimeType.RECEIVE_TIME);
        request.setAttribute("orderList", voList);
        return "order/list";
    }

    /**
     * 接单立项提交
     * 
     * @param request
     * @param response
     * @param order
     */
    @RequestMapping(value = "/receive",method=RequestMethod.POST)
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
     * 
     * @param request
     * @param response
     * @param order
     */
    @RequestMapping(value = "/quote",method=RequestMethod.POST)
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
