package com.letsbuild.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.base.util.BeanUtil;
import com.letsbuild.base.util.BeanUtil.Prop;
import com.letsbuild.base.util.DateUtil;
import com.letsbuild.business.interfaces.IOrderBusiSV;
import com.letsbuild.constants.DbConstants;
import com.letsbuild.dao.mapper.bo.OrdOrder;
import com.letsbuild.dao.mapper.bo.OrdStage;
import com.letsbuild.service.interfaces.IOrdOrderSV;
import com.letsbuild.service.interfaces.IOrdStageSV;

@Service
@Transactional
public class OrderBusiSVImpl implements IOrderBusiSV {

	@Autowired
	private IOrdOrderSV ordOrderSV;

	@Autowired
	private IOrdStageSV ordStageSV;

	@Override
	public void receiveOrder(OrdOrder order) throws BusinessException {
		OrdOrder bo = new OrdOrder();
		// 接单订单属性
		Prop[] props = { new Prop("projectCode"), new Prop("projectLeader"),
				new Prop("provinceCode"), new Prop("cityCode"),
				new Prop("brandCode"), new Prop("merchant"),
				new Prop("address"), new Prop("contactName"),
				new Prop("contactTel"), new Prop("type"),
				new Prop("remark", false) };
		BeanUtil.copySelectProperties(order, bo, props);
		bo.setId(1l);// FIXME 序列怎么弄
		bo.setReceiveTime(DateUtil.getSysDate());
		bo.setStatus(DbConstants.OrdOrder.Status.RECEIVE);
		bo.setSubmitTime(DateUtil.getSysDate());
		ordOrderSV.addOrder(bo);
	}

	@Override
	public void quoteOrder(OrdOrder order) throws BusinessException {
		OrdOrder bo = new OrdOrder();
		// 报价订单属性
		Prop[] props = { new Prop("id"), new Prop("quotesAmount"),
				new Prop("remark", false) };
		BeanUtil.copySelectProperties(order, bo, props);
		bo.setStatus(DbConstants.OrdOrder.Status.QUOTES);
		bo.setStatusTime(DateUtil.getSysDate());
		ordOrderSV.modOrder(bo);
	}

	@Override
	public void submitOrder(OrdOrder order, OrdStage... stages)
			throws BusinessException {
		OrdOrder bo = new OrdOrder();
		// 下单订单属性
		Prop[] props = { new Prop("id"), new Prop("submitAmount"),
				new Prop("remark", false) };
		BeanUtil.copySelectProperties(order, bo, props);
		bo.setStatus(DbConstants.OrdOrder.Status.SUBMIT);
		bo.setStatusTime(DateUtil.getSysDate());
		bo.setSubmitTime(DateUtil.getSysDate());
		ordOrderSV.modOrder(bo);

		// 下单工期属性
		props = new Prop[] { new Prop("orderId"), new Prop("stageNo"),
				new Prop("planAmount"), new Prop("planIncomeTime") };
		for (OrdStage stage : stages) {
			OrdStage stageBo = new OrdStage();
			BeanUtil.copySelectProperties(stage, stageBo, props);
			stage.setId(1l);// FIXME 主键
			ordStageSV.addOrdStage(stageBo);
		}

	}

	@Override
	public void acceptanceOrder(OrdOrder order) throws BusinessException {
		OrdOrder bo = new OrdOrder();
		// 验收订单属性
		Prop[] props = { new Prop("id"), new Prop("completeAmount"),
				new Prop("installTime"), new Prop("remark", false) };
		BeanUtil.copySelectProperties(order, bo, props);
		bo.setStatus(DbConstants.OrdOrder.Status.ACCEPTANCE);
		bo.setStatusTime(DateUtil.getSysDate());
		bo.setSubmitTime(DateUtil.getSysDate());
		ordOrderSV.modOrder(bo);
	}

}
