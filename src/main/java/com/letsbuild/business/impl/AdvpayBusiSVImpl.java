package com.letsbuild.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.base.util.BeanUtil;
import com.letsbuild.base.util.DateUtil;
import com.letsbuild.base.util.BeanUtil.Prop;
import com.letsbuild.base.util.SeqUtil;
import com.letsbuild.business.interfaces.IAdvpayBusiSV;
import com.letsbuild.constants.DbConstants;
import com.letsbuild.constants.ExceptCodeConstants;
import com.letsbuild.dao.mapper.bo.OrdAdvpay;
import com.letsbuild.service.interfaces.IAdvpaySV;
import com.letsbuild.vo.AdvpayVo;

@Service
@Transactional
public class AdvpayBusiSVImpl implements IAdvpayBusiSV {

    @Autowired
    private IAdvpaySV advpaySV;

    @Override
    public void applyAdvpay(AdvpayVo vo) throws BusinessException {
        OrdAdvpay bo = new OrdAdvpay();
        // 垫付申请属性
        Prop[] props = { new Prop("projectCode"), new Prop("projectLeader"),
                new Prop("provinceCode"), new Prop("cityCode"), new Prop("brandCode"),
                new Prop("merchant"), new Prop("address"), new Prop("contactName"),
                new Prop("contactTel"), new Prop("amount"), new Prop("planRefundTime"),
                new Prop("accountNo"), new Prop("accountName"), new Prop("openBank") };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setId(SeqUtil.getNewAdvpayId());
        bo.setCreateTime(DateUtil.getSysDate());
        bo.setStatus(DbConstants.OrdAdvpay.Status.APPLY);
        bo.setStatusTime(DateUtil.getSysDate());
        advpaySV.addAdvpay(bo);

    }

    @Override
    public void payAdvpay(AdvpayVo vo) throws BusinessException {
        OrdAdvpay advpay = advpaySV.queryAdvpayById(vo.getId());
        if (advpay == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "垫付不存在");
        }
        if (!DbConstants.OrdAdvpay.Status.APPLY.equals(advpay.getStatus())) {
            throw new BusinessException(ExceptCodeConstants.ORDER_STATE, "垫付状态不允许支付");
        }
        // 垫付付款属性
        OrdAdvpay bo = new OrdAdvpay();
        Prop[] props = { new Prop("id"), new Prop("payTime"), new Prop("payAmount"),
                new Prop("payUser"), new Prop("quotesAmount") };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setStatus(DbConstants.OrdAdvpay.Status.PAY);
        bo.setStatusTime(DateUtil.getSysDate());
        advpaySV.modAdvpay(bo);

    }

    @Override
    public void refundAdvpay(AdvpayVo vo) throws BusinessException {
        OrdAdvpay advpay = advpaySV.queryAdvpayById(vo.getId());
        if (advpay == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "垫付不存在");
        }
        if (!advpay.getPayUser().equals(vo.getPayUser())) {
            throw new BusinessException(ExceptCodeConstants.ORDER_STATE, "用户不能操作该垫付");
        }
        if (!DbConstants.OrdAdvpay.Status.PAY.equals(advpay.getStatus())) {
            throw new BusinessException(ExceptCodeConstants.ORDER_STATE, "垫付状态不允许退还");
        }
        // 垫付回款属性
        OrdAdvpay bo = new OrdAdvpay();
        Prop[] props = { new Prop("id"), new Prop("payUser"), new Prop("invoiceNo"),
                new Prop("invoiceAmount"), new Prop("refundTime"), new Prop("refundAmount") };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setStatus(DbConstants.OrdAdvpay.Status.REFUND);
        bo.setStatusTime(DateUtil.getSysDate());
        advpaySV.modAdvpay(bo);

    }

}
