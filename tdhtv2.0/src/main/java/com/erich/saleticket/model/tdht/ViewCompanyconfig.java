package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

public class ViewCompanyconfig extends BaseModel {
	//private Long rid;							//公司编号
	private String  companyName;					//公司名称
	private Integer travelNum;						//公司人数
	private Date stratTime;		//起算时间
	private Double companyStand;			//人均标准用水
	private Double perCaoitaWater;//人均用水限值
	private Double consumptionCoefficient;		//消耗系数
	private Long principalId;   //负责人Id
	private Integer indrainageNum;//工业排水数量
	private Integer insupplyNum;//工业给水
	private Integer livdrainageNum;//tr
	private Integer livsupplyNum;
	private String mainRID;
	private String lat;//经度
	private String lon;//纬度
	private int waterType;//纬度
private int id;
	

private Long company_id;
private String company_name;
private String description;
private Integer industryInvolved;
private Integer drainage_basin;
private Integer provinceId;
private Integer cityId;
private Integer areaId;
private Integer streetId;
private Integer plateAmount;


	
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
	public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
	private Date PollStrTime;
	
	
	public Date getPollStrTime() {
		return PollStrTime;
	}
	public void setPollStrTime(Date pollStrTime) {
		PollStrTime = pollStrTime;
	}
	public int getWaterType() {
		return waterType;
	}
	public void setWaterType(int waterType) {
		this.waterType = waterType;
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

	/*public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}*/
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public Integer getTravelNum() {
		return travelNum;
	}
	public void setTravelNum(Integer travelNum) {
		this.travelNum = travelNum;
	}
	
	public Date getStratTime() {
		return stratTime;
	}
	public void setStratTime(Date stratTime) {
		this.stratTime = stratTime;
	}
	public Double getCompanyStand() {
		return companyStand;
	}
	public void setCompanyStand(Double companyStand) {
		this.companyStand = companyStand;
	}
	
	public Double getPerCaoitaWater() {
		return perCaoitaWater;
	}
	public void setPerCaoitaWater(Double perCaoitaWater) {
		this.perCaoitaWater = perCaoitaWater;
	}
	public Double getConsumptionCoefficient() {
		return consumptionCoefficient;
	}
	public void setConsumptionCoefficient(Double consumptionCoefficient) {
		this.consumptionCoefficient = consumptionCoefficient;
	}
	public Long getPrincipalId() {
		return principalId;
	}
	public void setPrincipalId(Long principalId) {
		this.principalId = principalId;
	}
	public String getMainRID() {
		return mainRID;
	}
	public void setMainRID(String mainRID) {
		this.mainRID = mainRID;
	}
	public Integer getIndrainageNum() {
		return indrainageNum;
	}
	public void setIndrainageNum(Integer indrainageNum) {
		this.indrainageNum = indrainageNum;
	}
	public Integer getInsupplyNum() {
		return insupplyNum;
	}
	public void setInsupplyNum(Integer insupplyNum) {
		this.insupplyNum = insupplyNum;
	}
	public Integer getLivdrainageNum() {
		return livdrainageNum;
	}
	public void setLivdrainageNum(Integer livdrainageNum) {
		this.livdrainageNum = livdrainageNum;
	}
	public Integer getLivsupplyNum() {
		return livsupplyNum;
	}
	public void setLivsupplyNum(Integer livsupplyNum) {
		this.livsupplyNum = livsupplyNum;
	}

	
	
	
}
