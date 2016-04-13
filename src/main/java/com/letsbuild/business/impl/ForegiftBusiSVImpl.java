package com.letsbuild.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.base.util.BeanUtil;
import com.letsbuild.base.util.DateUtil;
import com.letsbuild.base.util.BeanUtil.Prop;
import com.letsbuild.base.util.SeqUtil;
import com.letsbuild.business.interfaces.IForegiftBusiSV;
import com.letsbuild.constants.DbConstants;
import com.letsbuild.constants.ExceptCodeConstants;
import com.letsbuild.dao.mapper.bo.OrdForegift;
import com.letsbuild.service.interfaces.IForegiftSV;
import com.letsbuild.vo.ForegiftVo;

@Service
@Transactional
public class ForegiftBusiSVImpl implements IForegiftBusiSV {

    @Autowired
    private IForegiftSV foregiftSV;

    @Override
    public void applyForegift(ForegiftVo vo) throws BusinessException {
        OrdForegift bo = new OrdForegift();
        // 押金申请属性
        Prop[] props = { new Prop("projectCode"), new Prop("projectLeader"),
                new Prop("provinceCode"), new Prop("cityCode"), new Prop("brandCode"),
                new Prop("merchant"), new Prop("address"), new Prop("contactName"),
                new Prop("contactTel"), new Prop("amount"), new Prop("planRefundTime") };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setId(SeqUtil.getNewForegiftId());
        bo.setCreateTime(DateUtil.getSysDate());
        bo.setStatus(DbConstants.OrdForegift.Status.APPLY);
        bo.setStatusTime(DateUtil.getSysDate());
        foregiftSV.addForegift(bo);
    }

    @Override
    public void payForegift(ForegiftVo vo) throws BusinessException {
        OrdForegift foregift = foregiftSV.queryForegiftById(vo.getId());
        if (foregift == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "押金不存在");
        }
        if (!DbConstants.OrdForegift.Status.APPLY.equals(foregift.getStatus())) {
            throw new BusinessException(ExceptCodeConstants.ORDER_STATE, "押金状态不允许支付");
        }
        // 押金付款属性
        OrdForegift bo = new OrdForegift();
        Prop[] props = { new Prop("id"), new Prop("payTime"), new Prop("payMode"),
                new Prop("payUser"), new Prop("withReceipt") };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setStatus(DbConstants.OrdForegift.Status.PAY);
        bo.setStatusTime(DateUtil.getSysDate());
        foregiftSV.modForegift(bo);
    }

    @Override
    public void refundForegift(ForegiftVo vo) throws BusinessException {
        OrdForegift foregift = foregiftSV.queryForegiftById(vo.getId());
        if (foregift == null) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "押金不存在");
        }
        if (!foregift.getPayUser().equals(vo.getPayUser())) {
            throw new BusinessException(ExceptCodeConstants.ORDER_STATE, "用户不能操作该押金");
        }
        if (!DbConstants.OrdForegift.Status.PAY.equals(foregift.getStatus())) {
            throw new BusinessException(ExceptCodeConstants.ORDER_STATE, "押金状态不允许退还");
        }
        // 押金付款属性
        OrdForegift bo = new OrdForegift();
        Prop[] props = { new Prop("id"), new Prop("payUser"), new Prop("cutAmount"),
                new Prop("unableAmount"), new Prop("refundTime") };
        BeanUtil.copySelectProperties(vo, bo, props);
        bo.setStatus(DbConstants.OrdForegift.Status.REFUND);
        bo.setStatusTime(DateUtil.getSysDate());
        foregiftSV.modForegift(bo);
    }
}
