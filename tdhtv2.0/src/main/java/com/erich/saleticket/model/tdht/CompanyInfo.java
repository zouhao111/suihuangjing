package com.erich.saleticket.model.tdht;

import com.erich.easyframe.common.base.BaseModel;

public class CompanyInfo extends BaseModel{
	private Long company_id;//  编号
	private String company_name ;// 公司名称
	private String description  ;// 描述
	private Integer industryInvolved ;// 所属行业
	private Integer drainage_basin ;//  所属流域
	
	private Integer provinceId ;// 所在省
	private Integer cityId  ;//    所在市
	private Integer areaId   ;//  所在区
	private Integer streetId  ;// 所在街道
	private Integer plateAmount ;//  采集板数量
	private String lat;//经度
	private String lon;//纬度
	

	
	public Long getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Long company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIndustryInvolved() {
		return industryInvolved;
	}
	public void setIndustryInvolved(Integer industryInvolved) {
		this.industryInvolved = industryInvolved;
	}
	public Integer getDrainage_basin() {
		return drainage_basin;
	}
	public void setDrainage_basin(Integer drainage_basin) {
		this.drainage_basin = drainage_basin;
	}
	public Integer getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getStreetId() {
		return streetId;
	}
	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}
	public Integer getPlateAmount() {
		return plateAmount;
	}
	public void setPlateAmount(Integer plateAmount) {
		this.plateAmount = plateAmount;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	
	
	
	
}
