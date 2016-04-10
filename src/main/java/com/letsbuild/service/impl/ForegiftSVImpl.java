package com.letsbuild.service.impl;

import org.springframework.stereotype.Service;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.constants.ExceptCodeConstants;
import com.letsbuild.dao.mapper.bo.OrdForegift;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.IForegiftSV;

@Service
public class ForegiftSVImpl implements IForegiftSV {

    @Override
    public void addForegift(OrdForegift foregift) throws BusinessException {
        if (foregift.getId() == null) {
            throw new BusinessException(ExceptCodeConstants.SYSTEM_ERROR, "添加押金失败,主键为空");
        }
        MapperFactory.getOrdForegiftMapper().insertSelective(foregift);
    }

    @Override
    public void modForegift(OrdForegift foregift) throws BusinessException {
        if (foregift.getId() == null) {
            throw new BusinessException(ExceptCodeConstants.SYSTEM_ERROR, "修改押金失败,主键为空");
        }
        int result = MapperFactory.getOrdForegiftMapper().updateByPrimaryKeySelective(foregift);
        if (result != 1) {
            throw new BusinessException(ExceptCodeConstants.NO_DATA, "修改押金失败，记录不存在");
        }
    }

    @Override
    public OrdForegift queryForegiftById(Long id) throws BusinessException {
        return MapperFactory.getOrdForegiftMapper().selectByPrimaryKey(id);
    }

}
