package com.letsbuild.service.impl;

import org.springframework.stereotype.Service;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.ISysSeqSV;

@Service
public class SysSeqSVImpl implements ISysSeqSV {

    @Override
    public Long getNewSeq(String seqCode) throws BusinessException {
        return MapperFactory.getCustomMapper().getSeqNextval(seqCode);
    }

}
