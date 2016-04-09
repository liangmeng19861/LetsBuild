package com.letsbuild.service.interfaces;

import java.util.List;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.dao.mapper.bo.SysLabel;

public interface ISysLabelSV {
	public List<SysLabel> querySysLabel(String table,String column) throws BusinessException;
}
