package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 *采样记录实体
 */
public class SamplingRecord extends BaseModel {

	
	private Integer id ; 			
	private Date strTime; 				//采样时间
	private Integer num; 				//杯号
	private Integer capacity; 				//容量
	
	
	
	
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
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

}