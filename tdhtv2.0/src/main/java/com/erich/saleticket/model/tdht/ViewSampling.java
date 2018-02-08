package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 实时数据
 * 水质采样记录视图
 */
public class ViewSampling extends BaseModel {
	
	private Integer id;
	private Long rid;							//公司编号
	private Integer mTime;					//整型时间
	private Date strTime;						//字符时间
	private Double samplingWater;		//采样水量
	private Double samplingPh;			//采样PH
	private Integer samplingCapNum;//采样杯号
	private Integer samplingMode;		//采样模式
	private Integer dataType;
	
	private Double  standby1;				//备用1
	private Double  standby2;				//备用2
	private Double  standby3;				//备用3
	private Double  standby4;				//备用4
	private Double  standby5;				//备用5
	private Double  standby6;				//备用6
	private Integer  standby7;				//备用7
	private Integer  standby8;				//备用8
	private Integer  standby9;				//备用9
	private Integer  standby10;				//备用10
	
	
	
	
	public Integer getDataType() {
		return dataType;
	}
	public void setDataType(Integer dataType) {
		this.dataType = dataType;
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
	public Integer getmTime() {
		return mTime;
	}
	public void setmTime(Integer mTime) {
		this.mTime = mTime;
	}
	public Date getStrTime() {
		return strTime;
	}
	public void setStrTime(Date strTime) {
		this.strTime = strTime;
	}
	public Double getSamplingWater() {
		return samplingWater;
	}
	public void setSamplingWater(Double samplingWater) {
		this.samplingWater = samplingWater;
	}
	public Double getSamplingPh() {
		return samplingPh;
	}
	public void setSamplingPh(Double samplingPh) {
		this.samplingPh = samplingPh;
	}
	
	public Integer getSamplingCapNum() {
		return samplingCapNum;
	}
	public void setSamplingCapNum(Integer samplingCapNum) {
		this.samplingCapNum = samplingCapNum;
	}
	public Integer getSamplingMode() {
		return samplingMode;
	}
	public void setSamplingMode(Integer samplingMode) {
		this.samplingMode = samplingMode;
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
	public Integer getStandby7() {
		return standby7;
	}
	public void setStandby7(Integer standby7) {
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