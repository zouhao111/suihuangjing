package com.erich.saleticket.model.tdht;

import java.util.Date;
import com.erich.easyframe.common.base.BaseModel;

/**
 * 历史报表
 */
public class HistoryReport extends BaseModel {

	private Double waterlevel; //水位
    private Date  sytime;//系统时间
 	private Double traffic ; //流量速率
	private Double ph; 
	private Double currentSpeed ; //流速
	private Double temperature ; //温度
	private Double ztraffic_a1;//总流量
	private Double ztraffic_a2;//总流量
	private Double ztraffic_a3;//总流量
	private Double standard;
	private Double unkonwn;
	private String startingTime;//开始时间
	private String endTime;//结束时间
	private Integer minates;//查询分钟
	
	
	
	public Double getWaterlevel() {
		return waterlevel;
	}
	public void setWaterlevel(Double waterlevel) {
		this.waterlevel = waterlevel;
	}
	public Date getSytime() {
		return sytime;
	}
	public void setSytime(Date sytime) {
		this.sytime = sytime;
	}
	public Double getTraffic() {
		return traffic;
	}
	public void setTraffic(Double traffic) {
		this.traffic = traffic;
	}
	public Double getPh() {
		return ph;
	}
	public void setPh(Double ph) {
		this.ph = ph;
	}
	public Double getCurrentSpeed() {
		return currentSpeed;
	}
	public void setCurrentSpeed(Double currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getZtraffic_a1() {
		return ztraffic_a1;
	}
	public void setZtraffic_a1(Double ztraffic_a1) {
		this.ztraffic_a1 = ztraffic_a1;
	}
	public Double getZtraffic_a2() {
		return ztraffic_a2;
	}
	public void setZtraffic_a2(Double ztraffic_a2) {
		this.ztraffic_a2 = ztraffic_a2;
	}
	public Double getZtraffic_a3() {
		return ztraffic_a3;
	}
	public void setZtraffic_a3(Double ztraffic_a3) {
		this.ztraffic_a3 = ztraffic_a3;
	}
	public Double getStandard() {
		return standard;
	}
	public void setStandard(Double standard) {
		this.standard = standard;
	}
	public Double getUnkonwn() {
		return unkonwn;
	}
	public void setUnkonwn(Double unkonwn) {
		this.unkonwn = unkonwn;
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
	public Integer getMinates() {
		return minates;
	}
	public void setMinates(Integer minates) {
		this.minates = minates;
	}
	
	
}