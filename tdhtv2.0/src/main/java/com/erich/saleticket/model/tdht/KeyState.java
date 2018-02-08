package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

public class KeyState extends BaseModel{
	
	private Integer id;
	private Long macId;
	private Long syTime;
	private Date strtime1;
	private Long rid1;
	private Integer type1;
	private Date strTime;
	private Integer bitOnline;
	private String 	note;
	private Integer type;
	private Integer mapColor;//地图气泡状态颜色0.正常1离线2.预警3.报警
	
	private String lat;//经度
	private String lon;//纬度
	
	
	
	public Integer getType() {
		return type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getMacId() {
		return macId;
	}
	public void setMacId(Long macId) {
		this.macId = macId;
	}
	public Long getSyTime() {
		return syTime;
	}
	public void setSyTime(Long syTime) {
		this.syTime = syTime;
	}
	public Date getStrTime() {
		return strTime;
	}
	public void setStrTime(Date strTime) {
		this.strTime = strTime;
	}
	public Integer getBitOnline() {
		return bitOnline;
	}
	public void setBitOnline(Integer bitOnline) {
		this.bitOnline = bitOnline;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public Date getStrtime1() {
		return strtime1;
	}
	public void setStrtime1(Date strtime1) {
		this.strtime1 = strtime1;
	}
	public Long getRid1() {
		return rid1;
	}
	public void setRid1(Long rid1) {
		this.rid1 = rid1;
	}
	public Integer getType1() {
		return type1;
	}
	public void setType1(Integer type1) {
		this.type1 = type1;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public Integer getMapColor() {
		return mapColor;
	}
	public void setMapColor(Integer mapColor) {
		this.mapColor = mapColor;
	}

	

}
