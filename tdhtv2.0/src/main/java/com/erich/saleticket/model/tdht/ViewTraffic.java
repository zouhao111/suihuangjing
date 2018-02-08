package com.erich.saleticket.model.tdht;

import java.util.Date;
import com.erich.easyframe.common.base.BaseModel;

/**
 * 实时数据
 * 流量监测数据视图
 */
public class ViewTraffic extends BaseModel {
	
	private Integer id;
	private Integer syTime;//整型时间
	private Date strTime;//系统时间
	private Long rid;//公司关联ID
	private Integer dateType;//数据类型 1、工业给水,2、生活给水，3、工业排水，4、生活排水
	private Double flowRate;//流量速率
	private Double flowVelocity;//流速
	private Double waterLevel;//水位
	private Double  traffic;//流量
	private Double trafficLastDay;//最近24小时流量
	private Double voltage;//电压
	private Integer sysState;//系统状态
	
	private Double standby1;//备用1
	private Double standby2;//备用2
	private Double standby3;//备用3
	private Double standby4;//备用4
	private Double standby5;//备用5
	private Double standby6;//备用6
	private Double standby7;//备用7
	private Integer standby8;//备用8
	private Integer standby9;//备用9
	private Integer standby10;//备用10
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public Integer getDateType() {
		return dateType;
	}
	public void setDateType(Integer dateType) {
		this.dateType = dateType;
	}
	public Double getFlowRate() {
		return flowRate;
	}
	public void setFlowRate(Double flowRate) {
		this.flowRate = flowRate;
	}
	public Double getFlowVelocity() {
		return flowVelocity;
	}
	public void setFlowVelocity(Double flowVelocity) {
		this.flowVelocity = flowVelocity;
	}
	public Double getWaterLevel() {
		return waterLevel;
	}
	public void setWaterLevel(Double waterLevel) {
		this.waterLevel = waterLevel;
	}
	public Double getTraffic() {
		return traffic;
	}
	public void setTraffic(Double traffic) {
		this.traffic = traffic;
	}
	public Double getTrafficLastDay() {
		return trafficLastDay;
	}
	public void setTrafficLastDay(Double trafficLastDay) {
		this.trafficLastDay = trafficLastDay;
	}
	public Double getVoltage() {
		return voltage;
	}
	public void setVoltage(Double voltage) {
		this.voltage = voltage;
	}
	public Integer getSysState() {
		return sysState;
	}
	public void setSysState(Integer sysState) {
		this.sysState = sysState;
	}
	public Double getStandby1() {
		return standby1;
	}
	public void setStandby1(Double standby1) {
		this.standby1 = standby1;
	}
	public Double getStandby2() {
		return standby2;
	}
	public void setStandby2(Double standby2) {
		this.standby2 = standby2;
	}
	public Double getStandby3() {
		return standby3;
	}
	public void setStandby3(Double standby3) {
		this.standby3 = standby3;
	}
	public Double getStandby4() {
		return standby4;
	}
	public void setStandby4(Double standby4) {
		this.standby4 = standby4;
	}
	public Double getStandby5() {
		return standby5;
	}
	public void setStandby5(Double standby5) {
		this.standby5 = standby5;
	}
	public Double getStandby6() {
		return standby6;
	}
	public void setStandby6(Double standby6) {
		this.standby6 = standby6;
	}
	public Double getStandby7() {
		return standby7;
	}
	public void setStandby7(Double standby7) {
		this.standby7 = standby7;
	}
	public Integer getStandby8() {
		return standby8;
	}
	public void setStandby8(Integer standby8) {
		this.standby8 = standby8;
	}
	public Integer getStandby9() {
		return standby9;
	}
	public void setStandby9(Integer standby9) {
		this.standby9 = standby9;
	}
	public Integer getStandby10() {
		return standby10;
	}
	public void setStandby10(Integer standby10) {
		this.standby10 = standby10;
	}
	
	
}