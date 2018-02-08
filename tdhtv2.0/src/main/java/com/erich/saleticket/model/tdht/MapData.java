package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 实时数据
 * 地图查看公司详情
 */
public class MapData extends BaseModel {
	
	private Long rid;							//公司ID
	private Double waterLevel;					//水位
	private Double flowVelocity;				//流速
	private Double flowRate;					//流量速率
	private Double traffic;						//总量
	private Integer sysState;					//状态
	private Double realPh;						//实时PH
	private Double realCod;						//实时COD
	private Date strTime;						//时间
	
	private Double tabPh;//Ph
	private Double tabWaterLevel;//水位
	private Double tabTraffic;//流量速率
	private Double tabCurrentSpeed;//流速
	private Double tabZtraffic;//总量
	private String parentCode;
	private Integer waterType;
	
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public Double getWaterLevel() {
		return waterLevel;
	}
	public void setWaterLevel(Double waterLevel) {
		this.waterLevel = waterLevel;
	}
	public Double getFlowVelocity() {
		return flowVelocity;
	}
	public void setFlowVelocity(Double flowVelocity) {
		this.flowVelocity = flowVelocity;
	}
	public Double getFlowRate() {
		return flowRate;
	}
	public void setFlowRate(Double flowRate) {
		this.flowRate = flowRate;
	}
	
	public Double getTraffic() {
		return traffic;
	}
	public void setTraffic(Double traffic) {
		this.traffic = traffic;
	}
	public Integer getSysState() {
		return sysState;
	}
	public void setSysState(Integer sysState) {
		this.sysState = sysState;
	}
	public Double getRealPh() {
		return realPh;
	}
	public void setRealPh(Double realPh) {
		this.realPh = realPh;
	}
	
	public Date getStrTime() {
		return strTime;
	}
	public void setStrTime(Date strTime) {
		this.strTime = strTime;
	}
	public Double getTabPh() {
		return tabPh;
	}
	public void setTabPh(Double tabPh) {
		this.tabPh = tabPh;
	}
	public Double getTabWaterLevel() {
		return tabWaterLevel;
	}
	public void setTabWaterLevel(Double tabWaterLevel) {
		this.tabWaterLevel = tabWaterLevel;
	}
	public Double getTabTraffic() {
		return tabTraffic;
	}
	public void setTabTraffic(Double tabTraffic) {
		this.tabTraffic = tabTraffic;
	}
	public Double getTabCurrentSpeed() {
		return tabCurrentSpeed;
	}
	public void setTabCurrentSpeed(Double tabCurrentSpeed) {
		this.tabCurrentSpeed = tabCurrentSpeed;
	}
	public Double getTabZtraffic() {
		return tabZtraffic;
	}
	public void setTabZtraffic(Double tabZtraffic) {
		this.tabZtraffic = tabZtraffic;
	}
	public Double getRealCod() {
		return realCod;
	}
	public void setRealCod(Double realCod) {
		this.realCod = realCod;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public Integer getWaterType() {
		return waterType;
	}
	public void setWaterType(Integer waterType) {
		this.waterType = waterType;
	}
	
	

}