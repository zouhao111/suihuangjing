package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 实时报警
 */
public class BalanceWater extends BaseModel {


	private Integer id;
	
	private Date strTime;        		//时间
	private long syTime;        		//时间
	private Double midviewid;				//最小值
	private String strTime1;
	private Double midviewis;				//最大值

	private Double midviewld;			//报警值
	private Double midviewls;
	
	private Double industrialdrainage;			
	private Double industrialsupply;				
	private Double livingdrainage;			
	private Double livingsupply;
	private Double idztraffic;			
	private Double isztraffic;				
	private Double ldztraffic;			
	private Double lsztraffic;
	
	private Double Losslimit;
	private Double totalLossLimit;
	
	
	private Double wastage;
	private Double totalwastage;
	private Double totalunknow;
	private Double unknown;
	private Integer waterType;
	
	
	public Integer getWaterType() {
		return waterType;
	}

	public void setWaterType(Integer waterType) {
		this.waterType = waterType;
	}

	public Double getTotalunknow() {
		return totalunknow;
	}

	public void setTotalunknow(Double totalunknow) {
		this.totalunknow = totalunknow;
	}

	public Double getUnknown() {
		return unknown;
	}

	public void setUnknown(Double unknown) {
		this.unknown = unknown;
	}

	public Double getWastage() {
		return wastage;
	}

	public void setWastage(Double wastage) {
		this.wastage = wastage;
	}

	public Double getTotalwastage() {
		return totalwastage;
	}

	public void setTotalwastage(Double totalwastage) {
		this.totalwastage = totalwastage;
	}

	public Double getLosslimit() {
		return Losslimit;
	}

	public void setLosslimit(Double losslimit) {
		Losslimit = losslimit;
	}

	public Double getTotalLossLimit() {
		return totalLossLimit;
	}

	public void setTotalLossLimit(Double totalLossLimit) {
		this.totalLossLimit = totalLossLimit;
	}

	public Double getIndustrialdrainage() {
		return industrialdrainage;
	}

	public void setIndustrialdrainage(Double industrialdrainage) {
		this.industrialdrainage = industrialdrainage;
	}

	public Double getIndustrialsupply() {
		return industrialsupply;
	}

	public void setIndustrialsupply(Double industrialsupply) {
		this.industrialsupply = industrialsupply;
	}

	public Double getLivingdrainage() {
		return livingdrainage;
	}

	public void setLivingdrainage(Double livingdrainage) {
		this.livingdrainage = livingdrainage;
	}

	public Double getLivingsupply() {
		return livingsupply;
	}

	public void setLivingsupply(Double livingsupply) {
		this.livingsupply = livingsupply;
	}

	public Double getIdztraffic() {
		return idztraffic;
	}

	public void setIdztraffic(Double idztraffic) {
		this.idztraffic = idztraffic;
	}

	public Double getIsztraffic() {
		return isztraffic;
	}

	public void setIsztraffic(Double isztraffic) {
		this.isztraffic = isztraffic;
	}

	public Double getLdztraffic() {
		return ldztraffic;
	}

	public void setLdztraffic(Double ldztraffic) {
		this.ldztraffic = ldztraffic;
	}

	public Double getLsztraffic() {
		return lsztraffic;
	}

	public void setLsztraffic(Double lsztraffic) {
		this.lsztraffic = lsztraffic;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStrTime() {
		return strTime;
	}

	public void setStrTime(Date strTime) {
		this.strTime = strTime;
	}

	public long getSyTime() {
		return syTime;
	}

	public void setSyTime(long syTime) {
		this.syTime = syTime;
	}

	public Double getMidviewid() {
		return midviewid;
	}

	public void setMidviewid(Double midviewid) {
		this.midviewid = midviewid;
	}

	public Double getMidviewis() {
		return midviewis;
	}

	public void setMidviewis(Double midviewis) {
		this.midviewis = midviewis;
	}

	public Double getMidviewld() {
		return midviewld;
	}

	public void setMidviewld(Double midviewld) {
		this.midviewld = midviewld;
	}

	public Double getMidviewls() {
		return midviewls;
	}

	public void setMidviewls(Double midviewls) {
		this.midviewls = midviewls;
	}

	public String getStrTime1() {
		return strTime1;
	}

	public void setStrTime1(String strTime1) {
		this.strTime1 = strTime1;
	}
	
	
    



}