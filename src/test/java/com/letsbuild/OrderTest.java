package com.letsbuild;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.letsbuild.business.interfaces.IOrderBusiSV;
import com.letsbuild.dao.mapper.bo.OrdOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/application.xml" })
public class OrderTest extends TestCase {
	
	@Autowired
	private IOrderBusiSV orderBusiSV;
	
	/**
	 * 订单接收
	 */
	@Test
	public void testReceive() {
		OrdOrder order = new OrdOrder();
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
		orderBusiSV.receiveOrder(order);
	}
	/**
	 * 报价
	 */
	@Test
	public void testQuote(){
		OrdOrder order = new OrdOrder();
		order.setId(1l);
		order.setQuotesAmount(1000d);
		orderBusiSV.quoteOrder(order);
	}

}
