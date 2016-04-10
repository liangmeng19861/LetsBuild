package com.letsbuild.vo;

import java.util.List;

import com.letsbuild.dao.mapper.bo.OrdOrder;

/**
 * 页面表单提交/查询展示
 * @author lilg
 *
 */
public class OrderVo extends OrdOrder {

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * 省份名称
	 */
	private String provinceName;

	/**
	 * 城市名称
	 */
	private String cityName;

	/**
	 * 品牌名称
	 */
	private String brandName;

	/**
	 * 业务类型名称
	 */
	private String typeName;

	/**
	 * 工期列表
	 */
	private List<StageVo> stages;

	public List<StageVo> getStages() {
		return stages;
	}

	public void setStages(List<StageVo> stages) {
		this.stages = stages;
	}
}
