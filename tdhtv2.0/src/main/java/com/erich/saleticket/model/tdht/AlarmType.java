package com.erich.saleticket.model.tdht;

import java.util.Date;

public class AlarmType {
	private int id;
     private Long rid;
	
	private Date strTime;        		//时间

	private Double minValue;				//最小值

	private Double maxValue;				//最大值

	private Double earlyvalue;			//报警值
	
	private Double min_early;				//板ID
	
	private Double  max_early; 	 //开始时间
	private Double  early_ph; 
	private String type;			//结束时间
	 private String alarm_type;
	 public String getAlarm_type() {
	 		return alarm_type;
	 	}

	 	public void setAlarm_type(String alarm_type) {
	 		this.alarm_type = alarm_type;
	 	}
	private int have;
	
	public int getHave() {
		return have;
	}

	public void setHave(int have) {
		this.have = have;
	}

	public int getId() {
		return id;
	}

	public Double getEarly_ph() {
		return early_ph;
	}

	public void setEarly_ph(Double early_ph) {
		this.early_ph = early_ph;
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

	public Date getStrTime() {
		return strTime;
	}

	public void setStrTime(Date strTime) {
		this.strTime = strTime;
	}

	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public Double getEarlyvalue() {
		return earlyvalue;
	}

	public void setEarlyvalue(Double earlyvalue) {
		this.earlyvalue = earlyvalue;
	}

	public void setMin_early(Double min_early) {
		this.min_early = min_early;
	}

	

	
	public Double getMax_early() {
		return max_early;
	}

	public Double getMin_early() {
		return min_early;
	}

	public void setMax_early(Double max_early) {
		this.max_early = max_early;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	}
