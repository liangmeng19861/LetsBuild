package com.letsbuild.service.interfaces;

import com.letsbuild.base.exception.BusinessException;

public interface ISysSeqSV {
    /**
     * 取Seq
     * @param seqCode
     * @return
     * @throws BusinessException
     */
    public Long getNewSeq(String seqCode) throws BusinessException;
}
