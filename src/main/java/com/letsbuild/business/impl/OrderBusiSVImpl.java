package com.letsbuild.business.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.base.util.BeanUtil;
import com.letsbuild.base.util.BeanUtil.Prop;
import com.letsbuild.base.util.CollectionUtil;
import com.letsbuild.base.util.DateUtil;
import com.letsbuild.base.util.SeqUtil;
import com.letsbuild.business.interfaces.IOrderBusiSV;
import com.letsbuild.constants.DbConstants;
import com.letsbuild.constants.ExceptCodeConstants;
import com.letsbuild.dao.mapper.bo.OrdOrder;
import com.letsbuild.dao.mapper.bo.OrdStage;
import com.letsbuild.service.interfaces.IOrdOrderSV;
import com.letsbuild.service.interfaces.IOrdStageSV;
import com.letsbuild.vo.OrderVo;
import com.letsbuild.vo.StageVo;

@Service
@Transactional
public class OrderBusiSVImpl implements IOrderBusiSV {
    
    private static final Logger logger = LoggerFactory.getLogger(OrderBusiSVImpl.class);

    @Autowired
    private IOrdOrderSV ordOrderSV;

    @Autowired
    private IOrdStageSV ordStageSV;

    @Override
    public void receiveOrder(OrderVo vo) throws BusinessException {
        logger.info("开始订单接受:{}",JSON.toJSONString(vo));
        OrdOrder bo = new OrdOrder();
        // 接单订单属性
        Prop[] props = { new Prop("projectCode"), new Prop("projectLeader"),
                new Prop("provinceCode"), new Prop("cityCode"), new Prop("brandCode"),
                new Prop("merchant"), new Prop("address"), new Prop("contactName"),
                new Prop("contactTel"), new Prop("type"), new Prop("remark", false) };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setId(SeqUtil.getNewOrderId());
        bo.setReceiveTime(DateUtil.getSysDate());
        bo.setStatus(DbConstants.OrdOrder.Status.RECEIVE);
        bo.setStatusTime(DateUtil.getSysDate());
        ordOrderSV.addOrder(bo);
        logger.info("订单接受完成");
    }

    @Override
    public void quoteOrder(OrderVo vo) throws BusinessException {
        logger.info("开始订单报价:{}",JSON.toJSONString(vo));
        OrdOrder order = ordOrderSV.queryOrdOrderById(vo.getId());
        if (order == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "订单不存在");
        }
        if (!order.getProjectLeader().equals(vo.getProjectLeader())) {
            throw new BusinessException(ExceptCodeConstants.NO_PERMISSION, "用户不能操作该订单");
        }
        if (!DbConstants.OrdOrder.Status.RECEIVE.equals(order.getStatus())) {
            throw new BusinessException(ExceptCodeConstants.ORDER_STATE, "订单状态不允许报价");
        }
        // 报价订单属性
        OrdOrder bo = new OrdOrder();
        Prop[] props = { new Prop("id"), new Prop("quotesAmount"), new Prop("projectLeader"),
                new Prop("remark", false) };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setStatus(DbConstants.OrdOrder.Status.QUOTES);
        bo.setStatusTime(DateUtil.getSysDate());
        ordOrderSV.modOrder(bo);
        logger.info("订单报价完成");
    }

    @Override
    public void submitOrder(OrderVo vo) throws BusinessException {
        logger.info("开始下单:{}",JSON.toJSONString(vo));
        OrdOrder order = ordOrderSV.queryOrdOrderById(vo.getId());
        if (order == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "订单不存在");
        }
        if (!order.getProjectLeader().equals(vo.getProjectLeader())) {
            throw new BusinessException(ExceptCodeConstants.NO_PERMISSION, "用户不能操作该订单");
        }
        if (!DbConstants.OrdOrder.Status.QUOTES.equals(order.getStatus())) {
            throw new BusinessException(ExceptCodeConstants.ORDER_STATE, "订单状态不允许下单");
        }
        // 下单订单属性
        OrdOrder bo = new OrdOrder();
        Prop[] props = { new Prop("id"), new Prop("submitAmount"), new Prop("projectLeader"),
                new Prop("remark", false) };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setStatus(DbConstants.OrdOrder.Status.SUBMIT);
        bo.setStatusTime(DateUtil.getSysDate());
        bo.setSubmitTime(DateUtil.getSysDate());
        ordOrderSV.modOrder(bo);
        // 下单工期属性
        props = new Prop[] { new Prop("stageNo"), new Prop("planAmount"),
                new Prop("planIncomeTime") };
        for (StageVo stageVo : vo.getStages()) {
            OrdStage stageBo = new OrdStage();
            BeanUtil.copySelectProperties(stageVo, stageBo, props);
            stageBo.setId(SeqUtil.getNewStageId());
            stageBo.setOrderId(vo.getId());
            ordStageSV.addOrdStage(stageBo);
        }
        logger.info("下单结束");
    }

    @Override
    public void acceptanceOrder(OrderVo vo) throws BusinessException {
        logger.info("开始订单验收:{}",JSON.toJSONString(vo));
        OrdOrder order = ordOrderSV.queryOrdOrderById(vo.getId());
        if (order == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "订单不存在");
        }
        if (!order.getProjectLeader().equals(vo.getProjectLeader())) {
            throw new BusinessException(ExceptCodeConstants.NO_PERMISSION, "用户不能操作该订单");
        }
        if (!DbConstants.OrdOrder.Status.SUBMIT.equals(order.getStatus())) {
            throw new BusinessException(ExceptCodeConstants.ORDER_STATE, "订单状态不允许验收");
        }
        // 验收订单属性
        OrdOrder bo = new OrdOrder();
        Prop[] props = { new Prop("id"), new Prop("completeAmount"), new Prop("projectLeader"),
                new Prop("installTime"), new Prop("remark", false) };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setStatus(DbConstants.OrdOrder.Status.ACCEPTANCE);
        bo.setStatusTime(DateUtil.getSysDate());

        ordOrderSV.modOrder(bo);
        logger.info("订单验收完成");
    }

    @Override
    public void invoiceOrder(OrderVo vo) throws BusinessException {
        logger.info("开始订单开票:{}",JSON.toJSONString(vo));
        OrdOrder order = ordOrderSV.queryOrdOrderById(vo.getId());
        if (order == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "订单不存在");
        }
        if (!DbConstants.OrdOrder.Status.ACCEPTANCE.equals(order.getStatus())) {
            throw new BusinessException(ExceptCodeConstants.ORDER_STATE, "订单状态不允许开具发票");
        }
        // 订单属性
        OrdOrder bo = new OrdOrder();
        Prop[] props = { new Prop("id"), new Prop("remark", false) };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setStatus(DbConstants.OrdOrder.Status.INVOICE);
        bo.setStatusTime(DateUtil.getSysDate());
        ordOrderSV.modOrder(bo);

        // 工期开票属性
        props = new Prop[] { new Prop("id"), new Prop("invoiceAmount"), new Prop("invoiceTime"),
                new Prop("invoiceNo") };
        for (StageVo stageVo : vo.getStages()) {
            OrdStage stageBo = new OrdStage();
            BeanUtil.copySelectProperties(stageVo, stageBo, props);
            ordStageSV.modOrdStage(stageBo);
        }
        logger.info("订单开票完成");
    }

    @Override
    public void incomeOrder(OrderVo vo) throws BusinessException {
        logger.info("开始订单回款:{}",JSON.toJSONString(vo));
        OrdOrder order = ordOrderSV.queryOrdOrderById(vo.getId());
        if (order == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "订单不存在");
        }
        if (!DbConstants.OrdOrder.Status.INVOICE.equals(order.getStatus())) {
            throw new BusinessException(ExceptCodeConstants.ORDER_STATE, "订单状态不允许回款");
        }
        // 订单属性
        OrdOrder bo = new OrdOrder();
        Prop[] props = { new Prop("id"), new Prop("contractNo"), new Prop("remark", false) };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setStatus(DbConstants.OrdOrder.Status.INCOME);
        bo.setStatusTime(DateUtil.getSysDate());
        ordOrderSV.modOrder(bo);

        // 工期回款属性
        props = new Prop[] { new Prop("id"), new Prop("incomeAmount"), new Prop("incomeTime") };
        for (StageVo stageVo : vo.getStages()) {
            OrdStage stageBo = new OrdStage();
            BeanUtil.copySelectProperties(stageVo, stageBo, props);
            ordStageSV.modOrdStage(stageBo);
        }
        logger.info("订单回款完成");
    }

    @Override
    public void modifyOrder(OrderVo vo) throws BusinessException {
        logger.info("开始修改订单:{}",JSON.toJSONString(vo));
        OrdOrder order = ordOrderSV.queryOrdOrderById(vo.getId());
        if (order == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "订单不存在");
        }
        if (!DbConstants.OrdOrder.Status.INCOME.equals(order.getStatus())) {
            throw new BusinessException(ExceptCodeConstants.ORDER_STATE, "订单状态不允许修改");
        }
        // 订单属性
        OrdOrder bo = new OrdOrder();
        Prop[] props = { new Prop("id"), new Prop("contractNo"), new Prop("remark", false) };
        BeanUtil.copySelectProperties(vo, bo, props);
        // bo.setStatus(DbConstants.OrdOrder.Status.INVOICE); 修改订单不修改状态
        bo.setStatusTime(DateUtil.getSysDate());
        ordOrderSV.modOrder(bo);

        // 工期属性
        props = new Prop[] { new Prop("id"), new Prop("invoiceAmount"), new Prop("invoiceTime"),
                new Prop("invoiceNo"), new Prop("incomeAmount"), new Prop("incomeTime") };
        for (StageVo stageVo : vo.getStages()) {
            OrdStage stageBo = new OrdStage();
            BeanUtil.copySelectProperties(stageVo, stageBo, props);
            ordStageSV.modOrdStage(stageBo);
        }
        logger.info("订单修改完成");
    }

    @Override
    public OrderVo queryOrder(Long id) throws BusinessException {
        logger.info("开始查询订单");
        // 查询订单
        OrdOrder order = ordOrderSV.queryOrdOrderById(id);
        if (order == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "查询的订单不存在");
        }
        OrderVo orderVo = new OrderVo();
        BeanUtil.copyProperties(order, orderVo);
        // FIXME 翻译订单属性
        // 查询工期
        List<OrdStage> stages = ordStageSV.queryOrdStageByOrderId(id);
        if (CollectionUtil.isEmpty(stages)) {
            return orderVo;
        }
        orderVo.setStages(new ArrayList<StageVo>());
        for (OrdStage stage : stages) {
            StageVo stageVo = new StageVo();
            BeanUtil.copyProperties(stage, stageVo);
            // FIXME 翻译工期属性
            orderVo.getStages().add(stageVo);
        }
        logger.info("订单查询完成:{}",JSON.toJSONString(orderVo));
        return orderVo;
    }

    @Override
    public List<OrderVo> queryOrder(Long projectLeader, String brandCode, String projectCode,
            String provinceCode, String cityCode, String merchant, Timestamp start, Timestamp end,
            String timeType) throws BusinessException {
        logger.info("开始查询订单");
        OrdOrder order = new OrdOrder();
        order.setProjectLeader(projectLeader);
        order.setBrandCode(brandCode);
        order.setProjectCode(projectCode);
        order.setProvinceCode(provinceCode);
        order.setCityCode(cityCode);
        order.setMerchant(merchant);
        List<OrdOrder> orderList = ordOrderSV.queryOrdOrder(order, start, end, timeType);
        if (CollectionUtil.isEmpty(orderList)) {
            return new ArrayList<OrderVo>();
        }
        List<OrderVo> voList = new ArrayList<OrderVo>();
        for (OrdOrder o : orderList) {
            OrderVo vo = new OrderVo();
            BeanUtil.copyProperties(o, vo);
            // FIXME 翻译订单属性
            voList.add(vo);
        }
        logger.info("订单查询完成:{}",JSON.toJSONString(voList));
        return voList;
    }

}
