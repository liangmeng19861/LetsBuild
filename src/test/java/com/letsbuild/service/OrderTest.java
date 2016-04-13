package com.letsbuild.service;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.letsbuild.business.interfaces.IOrderBusiSV;
import com.letsbuild.vo.OrderVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/application.xml" })
public class OrderTest extends TestCase {
    
    private static final Logger logger = LoggerFactory.getLogger(OrderTest.class);
	
	@Autowired
	private IOrderBusiSV orderBusiSV;
	
	/**
	 * 订单接收
	 */
	@Test
	public void testReceive() {
		OrderVo order = new OrderVo();
		order.setProjectCode("ODR_100");
		order.setProjectLeader(1203l);
		order.setProvinceCode("22");
		order.setCityCode("10");
		order.setBrandCode("01");
		order.setMerchant("国贸");
		order.setAddress("国贸三层");
		order.setContactName("张三");
		order.setContactTel("13988888888");
		order.setType("01");
		order.setRemark("测试接单");
		logger.info("测试接单:{}",JSON.toJSONString(order));
		orderBusiSV.receiveOrder(order);
	}
	/**
	 * 报价
	 */
	@Test
	public void testQuote(){
	    OrderVo order = new OrderVo();
	    order.setProjectLeader(1203l);
		order.setId(2l);
		order.setQuotesAmount(1000d);
        logger.info("测试报价:{}",JSON.toJSONString(order));
		orderBusiSV.quoteOrder(order);
	}

}
