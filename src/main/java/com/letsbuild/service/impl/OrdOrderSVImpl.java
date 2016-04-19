package com.letsbuild.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.base.util.StringUtil;
import com.letsbuild.constants.ExceptCodeConstants;
import com.letsbuild.constants.SysConstants;
import com.letsbuild.dao.mapper.bo.OrdOrder;
import com.letsbuild.dao.mapper.bo.OrdOrderCriteria;
import com.letsbuild.dao.mapper.bo.OrdOrderCriteria.Criteria;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.IOrdOrderSV;

@Service
public class OrdOrderSVImpl implements IOrdOrderSV {

    @Override
    public void addOrder(OrdOrder order) throws BusinessException {
        if (order.getId() == null) {
            throw new BusinessException(ExceptCodeConstants.SYSTEM_ERROR, "添加订单失败,主键为空");
        }
        MapperFactory.getOrdOrderMapper().insert(order);
    }

    @Override
    public void modOrder(OrdOrder order) throws BusinessException {
        if (order.getId() == null) {
            throw new BusinessException(ExceptCodeConstants.SYSTEM_ERROR, "修改订单失败,主键为空");
        }
        int result = MapperFactory.getOrdOrderMapper().updateByPrimaryKeySelective(order);
        if (result != 1) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "修改订单失败，订单不存在");
        }
    }

    @Override
    public OrdOrder queryOrdOrderById(Long id) throws BusinessException {
        return MapperFactory.getOrdOrderMapper().selectByPrimaryKey(id);
    }

    @Override
    public List<OrdOrder> queryOrdOrder(OrdOrder order, Timestamp start, Timestamp end,
            String timeType) throws BusinessException {
        OrdOrderCriteria example = new OrdOrderCriteria();
        Criteria criteria = example.createCriteria();
        if (order.getId() != null) {// = id
            criteria.andIdEqualTo(order.getId());
        }
        if (!StringUtil.isBlank(order.getProjectCode())) {// like projectCode
            criteria.andProjectCodeLike(order.getProjectCode());
        }
        if (!StringUtil.isBlank(order.getProvinceCode())) {// = provinceCode
            criteria.andProvinceCodeEqualTo(order.getProvinceCode());
        }
        if (!StringUtil.isBlank(order.getCityCode())) { // = cityCode
            criteria.andCityCodeEqualTo(order.getCityCode());
        }
        if (!StringUtil.isBlank(order.getMerchant())) { // like merchant
            criteria.andMerchantLike(order.getMerchant());
        }
        // TODO more

        if (SysConstants.OrderQueryTimeType.RECEIVE_TIME.equals(timeType)) {
            // 接单时间
            if(start!=null){
                criteria.andReceiveTimeGreaterThanOrEqualTo(start);
            }if(end!=null){
                criteria.andReceiveTimeLessThanOrEqualTo(end);
            }
        }

        return MapperFactory.getOrdOrderMapper().selectByExample(example);
    }

}
