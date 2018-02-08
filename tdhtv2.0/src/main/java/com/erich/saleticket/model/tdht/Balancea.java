package com.erich.saleticket.model.tdht;

import java.util.Date;
import java.util.List;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 实时报警
 */
public class Balancea extends BaseModel {


	private Integer id;

	private Integer dateType;        		//数据类型 1：工业给水 2：生活给水 3：工业排水 4：生活排水

	private Double flowRateMin;				//流量速率最小值

	private Double flowRateMax;				//流量速率最大值

	private Double waterLevelMin;			//水位最小值
	
	private Double waterLevelMax;			//水位最大值
	
	private Double flowVelocityMin;			//流速最小值
	
	private Double  flowVelocityMax; 	 	//流速最大值
	
	
	private Double phmin;		//最小ph
	private Double phmax;			//最大ph
	private Double codmin;//最小cod
	private Double codmax;		
	private Double nh3nmin;       //氨氮   
	private Double nh3nmax;         
	
	private Double supplyIndustrial;//工业给水
	private Double supplyLiving;//生活给水
	private Double drainageIndustrial;//工业排水
	private Double lossLimit;
	private Double unknown;
	private Double lossAmount;
	
	
	
	public Double getLossLimit() {
		return lossLimit;
	}

	public void setLossLimit(Double lossLimit) {
		this.lossLimit = lossLimit;
	}

	public Double getUnknown() {
		return unknown;
	}

	public void setUnknown(Double unknown) {
		this.unknown = unknown;
	}

	public Double getLossAmount() {
		return lossAmount;
	}

	public void setLossAmount(Double lossAmount) {
		this.lossAmount = lossAmount;
	}

	public Double getSupplyIndustrial() {
		return supplyIndustrial;
	}

	public void setSupplyIndustrial(Double supplyIndustrial) {
		this.supplyIndustrial = supplyIndustrial;
	}

	public Double getSupplyLiving() {
		return supplyLiving;
	}

	public void setSupplyLiving(Double supplyLiving) {
		this.supplyLiving = supplyLiving;
	}

	public Double getDrainageIndustrial() {
		return drainageIndustrial;
	}

	public void setDrainageIndustrial(Double drainageIndustrial) {
		this.drainageIndustrial = drainageIndustrial;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public Integer getDateType() {
		return dateType;
	}

	public void setDateType(Integer dateType) {
		this.dateType = dateType;
	}

	public Double getFlowRateMin() {
		return flowRateMin;
	}

	public void setFlowRateMin(Double flowRateMin) {
		this.flowRateMin = flowRateMin;
	}

	public Double getFlowRateMax() {
		return flowRateMax;
	}

	public void setFlowRateMax(Double flowRateMax) {
		this.flowRateMax = flowRateMax;
	}

	public Double getWaterLevelMin() {
		return waterLevelMin;
	}

	public void setWaterLevelMin(Double waterLevelMin) {
		this.waterLevelMin = waterLevelMin;
	}

	public Double getWaterLevelMax() {
		return waterLevelMax;
	}

	public void setWaterLevelMax(Double waterLevelMax) {
		this.waterLevelMax = waterLevelMax;
	}

	public Double getFlowVelocityMin() {
		return flowVelocityMin;
	}

	public void setFlowVelocityMin(Double flowVelocityMin) {
		this.flowVelocityMin = flowVelocityMin;
	}

	public Double getFlowVelocityMax() {
		return flowVelocityMax;
	}

	public void setFlowVelocityMax(Double flowVelocityMax) {
		this.flowVelocityMax = flowVelocityMax;
	}

	public Double getPhmin() {
		return phmin;
	}

	public void setPhmin(Double phmin) {
		this.phmin = phmin;
	}

	public Double getPhmax() {
		return phmax;
	}

	public void setPhmax(Double phmax) {
		this.phmax = phmax;
	}

	public Double getCodmin() {
		return codmin;
	}

	public void setCodmin(Double codmin) {
		this.codmin = codmin;
	}

	public Double getCodmax() {
		return codmax;
	}

	public void setCodmax(Double codmax) {
		this.codmax = codmax;
	}

	public Double getNh3nmin() {
		return nh3nmin;
	}

	public void setNh3nmin(Double nh3nmin) {
		this.nh3nmin = nh3nmin;
	}

	public Double getNh3nmax() {
		return nh3nmax;
	}

	public void setNh3nmax(Double nh3nmax) {
		this.nh3nmax = nh3nmax;
	}
	

}