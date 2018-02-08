package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 实时数据
 * 水质采样记录视图
 */
public class ViewZtraffic extends BaseModel {
	
	private Integer id;
	private Long rid;							//公司编号
	private Integer syTime;					//整型时间
	private Date strTime;
	private Date strTime1;//字符时间//字符时间
	private Double supplyIndustrial;		//工业给水
	private Double supplyLiving;			//生活给水
	private Double drainageIndustrial;//工业排水
	private Double drainageLiving;		//生活排水
	private Double lossLimit;          //损耗限值
	private Double unknown;          //不明
	private Double lossAmount;//损耗值
	private Double industrialdrainage;//工业给水
	private Double livingsupply;//生活给水
	private Double livingsupply1;//生活给水
	private Double industrialsupply;//工业排水
	private Double wastage;//损耗值
	private Long rid1;
	private Double ztraffic;
	
	
	public Double getZtraffic() {
		return ztraffic;
	}
	public void setZtraffic(Double ztraffic) {
		this.ztraffic = ztraffic;
	}
	public Long getRid1() {
		return rid1;
	}
	public void setRid1(Long rid1) {
		this.rid1 = rid1;
	}
	public Double getLivingsupply1() {
		return livingsupply1;
	}
	public void setLivingsupply1(Double livingsupply1) {
		this.livingsupply1 = livingsupply1;
	}
	public Double getWastage() {
		return wastage;
	}
	public void setWastage(Double wastage) {
		this.wastage = wastage;
	}
	public Double getIndustrialdrainage() {
		return industrialdrainage;
	}
	public void setIndustrialdrainage(Double industrialdrainage) {
		this.industrialdrainage = industrialdrainage;
	}
	public Double getLivingsupply() {
		return livingsupply;
	}
	public void setLivingsupply(Double livingsupply) {
		this.livingsupply = livingsupply;
	}
	public Double getIndustrialsupply() {
		return industrialsupply;
	}
	public void setIndustrialsupply(Double industrialsupply) {
		this.industrialsupply = industrialsupply;
	}
	public Date getStrTime1() {
		return strTime1;
	}
	public void setStrTime1(Date strTime1) {
		this.strTime1 = strTime1;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public Integer getSyTime() {
		return syTime;
	}
	public void setSyTime(Integer syTime) {
		this.syTime = syTime;
	}
	public Date getStrTime() {
		return strTime;
	}
	public void setStrTime(Date strTime) {
		this.strTime = strTime;
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
	public Double getDrainageLiving() {
		return drainageLiving;
	}
	public void setDrainageLiving(Double drainageLiving) {
		this.drainageLiving = drainageLiving;
	}
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
	
	
	
	
	
	
}