package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

public class AlarmType_water extends BaseModel{
	private int id;
     private Long rid;
	
	   private Integer Types;     		//类型

	private String typeRemark;				//水质名

	private Double limitH;				//预警值

	private Double limitHH;			//报警值
	
	private Double limitL;				//预警
	
	private Double  limitLL; 	 //报警
	
	private Date strtime;
	private int sytime;
	private Double  value;
	
	private String tabName;
	private String comName;
	
	
	private String  startingTime;
	private String  endTime;
	private Integer WaterType;
	private String dateTypes;
	
	private String zeroTime;
	
	
	
	public Integer getTypes() {
		return Types;
	}
	public void setTypes(Integer types) {
		Types = types;
	}
	public String getZeroTime() {
		return zeroTime;
	}
	public void setZeroTime(String zeroTime) {
		this.zeroTime = zeroTime;
	}
	public String getDateTypes() {
		return dateTypes;
	}
	public void setDateTypes(String dateTypes) {
		this.dateTypes = dateTypes;
	}
	public Integer getWaterType() {
		return WaterType;
	}
	public void setWaterType(Integer waterType) {
		WaterType = waterType;
	}
	public String getStartingTime() {
		return startingTime;
	}
	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getTabName() {
		return tabName;
	}
	public void setTabName(String tabName) {
		this.tabName = tabName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	
	public String getTypeRemark() {
		return typeRemark;
	}
	public void setTypeRemark(String typeRemark) {
		this.typeRemark = typeRemark;
	}
	public Double getLimitH() {
		return limitH;
	}
	public void setLimitH(Double limitH) {
		this.limitH = limitH;
	}
	public Double getLimitHH() {
		return limitHH;
	}
	public void setLimitHH(Double limitHH) {
		this.limitHH = limitHH;
	}
	public Double getLimitL() {
		return limitL;
	}
	public void setLimitL(Double limitL) {
		this.limitL = limitL;
	}
	public Double getLimitLL() {
		return limitLL;
	}
	public void setLimitLL(Double limitLL) {
		this.limitLL = limitLL;
	}
	public Date getStrtime() {
		return strtime;
	}
	public void setStrtime(Date strtime) {
		this.strtime = strtime;
	}
	
	public int getSytime() {
		return sytime;
	}
	public void setSytime(int sytime) {
		this.sytime = sytime;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	
	
	}
