package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 实时报警
 */
public class Alarm extends BaseModel {


	private Integer id;
	
	private Date strTime;        		//时间

	private Double minValue;				//最小值

	private Double maxValue;				//最大值

	private Double realValue;			//报警值
	
	private Integer macId;				//板ID
	
	private String  startingTime; 	 //开始时间
	
	private String endTime;			//结束时间
	
	private Double max_early;				//预警最大值
	private Double min_early;				//预警最小值
	private Double max_earlys;				//预警最大值
	private Double min_earlys;				//预警最小值
	
	private String alarmtype;			//污染物类型
	private String zeroTime;
/*	private Double realcod;			//COD
	private Double realcr6;			//六价铬
	private Double realmlss;		//悬浮物
	private Double realnh4n;		//氨氮
	private Double realPh;			//PH
	private Double realphosphor;//总磷
	private Double industrialdrainage;//水流量
*/	private Integer limit;
    private boolean have;
    private String alarm_type;
    
    private String alarm_name;


    public String getAlarm_name() {
		return alarm_name;
	}

	public void setAlarm_name(String alarm_name) {
		this.alarm_name = alarm_name;
	}

	public String getAlarm_type() {
    		return alarm_type;
    	}

    	public void setAlarm_type(String alarm_type) {
    		this.alarm_type = alarm_type;
    	}

public boolean isHave() {
		return have;
	}

	public void setHave(boolean have) {
		this.have = have;
	}

private String waterType;


	public Double getMax_earlys() {
	return max_earlys;
}

public void setMax_earlys(Double max_earlys) {
	this.max_earlys = max_earlys;
}

public Double getMin_earlys() {
	return min_earlys;
}

public void setMin_earlys(Double min_earlys) {
	this.min_earlys = min_earlys;
}

	public String getWaterType() {
	return waterType;
}

public void setWaterType(String waterType) {
	this.waterType = waterType;
}

	public String getZeroTime() {
	return zeroTime;
}

public void setZeroTime(String zeroTime) {
	this.zeroTime = zeroTime;
}

	public Integer getLimit() {
	return limit;
}

public void setLimit(Integer limit) {
	this.limit = limit;
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


	public Double getRealValue() {
		return realValue;
	}

	public void setRealValue(Double realValue) {
		this.realValue = realValue;
	}

	public String getAlarmtype() {
		return alarmtype;
	}

	public void setAlarmtype(String alarmtype) {
		this.alarmtype = alarmtype;
	}

	public Integer getMacId() {
		return macId;
	}

	public void setMacId(Integer macId) {
		this.macId = macId;
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

	public Double getMax_early() {
		return max_early;
	}

	public void setMax_early(Double max_early) {
		this.max_early = max_early;
	}

	public Double getMin_early() {
		return min_early;
	}

	public void setMin_early(Double min_early) {
		this.min_early = min_early;
	}

	


}