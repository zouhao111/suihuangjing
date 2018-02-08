package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 实时报警
 */
public class Uav {


	private Integer fid;
	
	private String jsondata;
	private String ID;        		//飞机ID
	private Date Time;			//时间
	private String strTime;			//时间
	private String Lat;
	private String Lon;
	private String Alt;
	private String Yaw;
	private String Roll;
	private String Pitch;
	private String Speed;
	private String CO;
	private String SO2;
	private String NO2;
	private String O3;
	private String PM10;
	private String PM25;
	private String NH3;
	private String CO2;
	private String H2S;
	private String Temp;
	private String Dumidity;
	
	
	
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	
	public String getLat() {
		return Lat;
	}
	public void setLat(String lat) {
		Lat = lat;
	}
	public String getLon() {
		return Lon;
	}
	public void setLon(String lon) {
		Lon = lon;
	}
	public String getAlt() {
		return Alt;
	}
	public void setAlt(String alt) {
		Alt = alt;
	}
	public String getYaw() {
		return Yaw;
	}
	public void setYaw(String yaw) {
		Yaw = yaw;
	}
	public String getRoll() {
		return Roll;
	}
	public void setRoll(String roll) {
		Roll = roll;
	}
	public String getPitch() {
		return Pitch;
	}
	public void setPitch(String pitch) {
		Pitch = pitch;
	}
	public String getSpeed() {
		return Speed;
	}
	public void setSpeed(String speed) {
		Speed = speed;
	}
	public String getCO() {
		return CO;
	}
	public void setCO(String cO) {
		CO = cO;
	}
	public String getSO2() {
		return SO2;
	}
	public void setSO2(String sO2) {
		SO2 = sO2;
	}
	public String getNO2() {
		return NO2;
	}
	public void setNO2(String nO2) {
		NO2 = nO2;
	}
	public String getO3() {
		return O3;
	}
	public void setO3(String o3) {
		O3 = o3;
	}
	public String getPM10() {
		return PM10;
	}
	public void setPM10(String pM10) {
		PM10 = pM10;
	}
	public String getPM25() {
		return PM25;
	}
	public void setPM25(String pM25) {
		PM25 = pM25;
	}
	public String getNH3() {
		return NH3;
	}
	public void setNH3(String nH3) {
		NH3 = nH3;
	}
	public String getCO2() {
		return CO2;
	}
	public void setCO2(String cO2) {
		CO2 = cO2;
	}
	public String getH2S() {
		return H2S;
	}
	public void setH2S(String h2s) {
		H2S = h2s;
	}
	public String getTemp() {
		return Temp;
	}
	public void setTemp(String temp) {
		Temp = temp;
	}
	public String getDumidity() {
		return Dumidity;
	}
	public void setDumidity(String dumidity) {
		Dumidity = dumidity;
	}
	public String getJsondata() {
		return jsondata;
	}
	public void setJsondata(String jsondata) {
		this.jsondata = jsondata;
	}
	public String getStrTime() {
		return strTime;
	}
	public void setStrTime(String strTime) {
		this.strTime = strTime;
	}

}