package com.letsbuild.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.letsbuild.base.exception.BusinessException;
import com.letsbuild.constants.ExceptCodeConstants;
import com.letsbuild.dao.mapper.bo.OrdStage;
import com.letsbuild.dao.mapper.bo.OrdStageCriteria;
import com.letsbuild.dao.mapper.factory.MapperFactory;
import com.letsbuild.service.interfaces.IOrdStageSV;

@Service
public class OrdStageSVImpl implements IOrdStageSV {

	@Override
	public void addOrdStage(OrdStage ordStage) throws BusinessException {
		if (ordStage.getId() == null) {
			throw new BusinessException(ExceptCodeConstants.SYSTEM_ERROR,
					"添加工期失败,主键为空");
		}
		MapperFactory.getOrdStageMapper().insert(ordStage);
	}

	@Override
	public void modOrdStage(OrdStage ordStage) throws BusinessException {
		if (ordStage.getId() == null) {
			throw new BusinessException(ExceptCodeConstants.SYSTEM_ERROR,
					"添加工期失败,主键为空");
		}
		int result = MapperFactory.getOrdStageMapper().updateByPrimaryKey(ordStage);
		if(result!=1){
			throw new BusinessException(ExceptCodeConstants.NO_DATA, "修改工期失败，工期不存在");
		}
	}

	@Override
	public List<OrdStage> queryOrdStageByOrderId(Long orderId)
			throws BusinessException {
		OrdStageCriteria example = new OrdStageCriteria();
		example.createCriteria().andOrderIdEqualTo(orderId);
		return MapperFactory.getOrdStageMapper().selectByExample(example);
	}

}
