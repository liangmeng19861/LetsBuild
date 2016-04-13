package com.letsbuild.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.base.util.CollectionUtil;
import com.letsbuild.dao.mapper.bo.SysLabel;
import com.letsbuild.dao.mapper.bo.SysLabelCriteria;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.ISysLabelSV;

@Service
public class SysLabelSVImpl implements ISysLabelSV {

    @Override
    public List<SysLabel> querySysLabel(String table, String column) throws BusinessException {
        SysLabelCriteria example = new SysLabelCriteria();
        example.createCriteria().andTableNameEqualTo(table).andColumnNameEqualTo(column);
        return MapperFactory.getSysLabelMapper().selectByExample(example);
    }

    @Override
    public SysLabel querySysLabel(String table, String column, String value)
            throws BusinessException {
        SysLabelCriteria example = new SysLabelCriteria();
        example.createCriteria().andTableNameEqualTo(table).andColumnNameEqualTo(column)
                .andValueEqualTo(value);
        List<SysLabel> labelList = MapperFactory.getSysLabelMapper().selectByExample(example);
        if (CollectionUtil.isEmpty(labelList)) {
            return null;
        }
        return labelList.get(0);
    }

}
