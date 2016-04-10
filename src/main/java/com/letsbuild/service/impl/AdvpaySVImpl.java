package com.letsbuild.service.impl;

import org.springframework.stereotype.Service;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.constants.ExceptCodeConstants;
import com.letsbuild.dao.mapper.bo.OrdAdvpay;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.IAdvpaySV;

@Service
public class AdvpaySVImpl implements IAdvpaySV {

    @Override
    public void addAdvpay(OrdAdvpay ordAdvpay) throws BusinessException {
        if (ordAdvpay.getId() == null) {
            throw new BusinessException(ExceptCodeConstants.SYSTEM_ERROR, "添加垫付失败,主键为空");
        }
        MapperFactory.getOrdAdvpayMapper().insertSelective(ordAdvpay);
    }

    @Override
    public void modAdvpay(OrdAdvpay ordAdvpay) throws BusinessException {
        if (ordAdvpay.getId() == null) {
            throw new BusinessException(ExceptCodeConstants.SYSTEM_ERROR, "修改垫付失败,主键为空");
        }
        int result = MapperFactory.getOrdAdvpayMapper().updateByPrimaryKeySelective(ordAdvpay);
        if (result != 1) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "修改垫付失败，记录不存在");
        }
    }

    @Override
    public OrdAdvpay queryAdvpayById(Long id) throws BusinessException {
        return MapperFactory.getOrdAdvpayMapper().selectByPrimaryKey(id);
    }

}
