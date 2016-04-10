package com.letsbuild.business.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.base.util.BeanUtil;
import com.letsbuild.base.util.BeanUtil.Prop;
import com.letsbuild.base.util.CollectionUtil;
import com.letsbuild.base.util.DateUtil;
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

    @Autowired
    private IOrdOrderSV ordOrderSV;

    @Autowired
    private IOrdStageSV ordStageSV;

    @Override
    public void receiveOrder(OrderVo vo) throws BusinessException {
        OrdOrder bo = new OrdOrder();
        // 接单订单属性
        Prop[] props = { new Prop("projectCode"), new Prop("projectLeader"),
                new Prop("provinceCode"), new Prop("cityCode"), new Prop("brandCode"),
                new Prop("merchant"), new Prop("address"), new Prop("contactName"),
                new Prop("contactTel"), new Prop("type"), new Prop("remark", false) };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setId(1l);// FIXME 序列怎么弄
        bo.setReceiveTime(DateUtil.getSysDate());
        bo.setStatus(DbConstants.OrdOrder.Status.RECEIVE);
        bo.setSubmitTime(DateUtil.getSysDate());
        ordOrderSV.addOrder(bo);
    }

    @Override
    public void quoteOrder(OrderVo vo) throws BusinessException {
        OrdOrder bo = new OrdOrder();
        // 报价订单属性
        Prop[] props = { new Prop("id"), new Prop("quotesAmount"), new Prop("projectLeader"),
                new Prop("remark", false) };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setStatus(DbConstants.OrdOrder.Status.QUOTES);
        bo.setStatusTime(DateUtil.getSysDate());
        OrdOrder order = ordOrderSV.queryOrdOrderById(vo.getId());
        if (order == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "报价的订单不存在");
        }
        if (order.getProjectLeader() != bo.getProjectLeader()) {
            throw new BusinessException(ExceptCodeConstants.NO_PERMISSION, "不能对该订单报价");
        }
        ordOrderSV.modOrder(bo);
    }

    @Override
    public void submitOrder(OrderVo vo) throws BusinessException {
        OrdOrder bo = new OrdOrder();
        // 下单订单属性
        Prop[] props = { new Prop("id"), new Prop("submitAmount"), new Prop("projectLeader"),
                new Prop("remark", false) };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setStatus(DbConstants.OrdOrder.Status.SUBMIT);
        bo.setStatusTime(DateUtil.getSysDate());
        bo.setSubmitTime(DateUtil.getSysDate());

        OrdOrder order = ordOrderSV.queryOrdOrderById(vo.getId());
        if (order == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "下单制作的订单不存在");
        }
        if (order.getProjectLeader() != bo.getProjectLeader()) {
            throw new BusinessException(ExceptCodeConstants.NO_PERMISSION, "不能对该订单下单制作");
        }
        ordOrderSV.modOrder(bo);
        // 下单工期属性
        props = new Prop[] { new Prop("orderId"), new Prop("stageNo"), new Prop("planAmount"),
                new Prop("planIncomeTime") };
        for (StageVo stageVo : vo.getStages()) {
            OrdStage stageBo = new OrdStage();
            BeanUtil.copySelectProperties(stageVo, stageBo, props);
            stageBo.setId(1l);// FIXME 主键
            ordStageSV.addOrdStage(stageBo);
        }

    }

    @Override
    public void acceptanceOrder(OrderVo vo) throws BusinessException {
        OrdOrder bo = new OrdOrder();
        // 验收订单属性
        Prop[] props = { new Prop("id"), new Prop("completeAmount"), new Prop("projectLeader"),
                new Prop("installTime"), new Prop("remark", false) };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setStatus(DbConstants.OrdOrder.Status.ACCEPTANCE);
        bo.setStatusTime(DateUtil.getSysDate());
        bo.setSubmitTime(DateUtil.getSysDate());

        OrdOrder order = ordOrderSV.queryOrdOrderById(vo.getId());
        if (order == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "验收的订单不存在");
        }
        if (order.getProjectLeader() != bo.getProjectLeader()) {
            throw new BusinessException(ExceptCodeConstants.NO_PERMISSION, "不能对该订单验收");
        }
        ordOrderSV.modOrder(bo);
    }

    @Override
    public OrderVo queryOrder(Long id) throws BusinessException {
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
        return orderVo;
    }

    @Override
    public List<OrderVo> queryOrder(Long projectLeader, String brandCode, String projectCode,
            String provinceCode, String cityCode, String merchant, Timestamp start, Timestamp end,
            String timeType) throws BusinessException {
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
            //FIXME 翻译订单属性
            voList.add(vo);
        }
        return voList;
    }

}
