package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

public class ViewLineReport extends BaseModel{
	private Integer id;
	private Integer sytime;					//整型时间
	private Date strTime;						//字符时间
	private Double tabTraffic;		//工业给水流量速率					//流量速率
	private Double tabWaterLevel;			//工业给水水位
	private Double tabCurrentSpeed;			//	工业给水流速		//流速
	private Double tabZtraffic;	
	private Double tabTrafficIS1;		//工业给水流量速率					//流量速率
	private Double tabWaterLevelIS1;			//工业给水水位
	private Double tabCurrentSpeedIS1;			//	工业给水流速		//流速
	private Double tabZtrafficIS1;			//工业给水总流量
	private Double tabTrafficDS1;		//生活给水流量速率					//流量速率
	private Double tabWaterLevelDS1;			//生活给水水位
	private Double tabCurrentSpeedDS1;			//	生活给水流速		//流速
	private Double tabZtrafficDS1;			//生活给水总流量
	private Double tabTrafficID1;		//工业排水流量速率					//流量速率
	private Double tabWaterLevelID1;			//工业排水水位
	private Double tabCurrentSpeedID1;			//	工业排水流速		//流速
	private Double tabZtrafficID1;			//工业排水1总流量
	private Double tabTrafficID2;		//工业排水2流量速率					//流量速率
	private Double tabWaterLevelID2;			//工业排水2水位
	private Double tabCurrentSpeedID2;			//	工业排水2流速		//流速
	private Double tabZtrafficID2;			//工业排水2总流量
	private Double tabTrafficID3;		//工业排水3流量速率					//流量速率
	private Double tabWaterLevelID3;			//工业排水3水位
	private Double tabCurrentSpeedID3;			//	工业排水3流速		//流速
	private Double tabZtrafficID3;			//工业排水3总流量
	private Double tabPHID1;			//工业排水PH
	private Double tabCodf;
	private Double tabNh3NID1;//氨氮
	private Double tabPHID2;			//工业排水PH
	private Double tabCods;			//COD
	private Double tabNh3NID2;//氨氮
	private Double tabPHID3;			//工业排水PH
	private Double tabCodt;			//COD
	private Double tabNh3NID3;//氨氮
	private Double  Losslimit;
	private Double wastage;   //耗损值
	private Double unknown;   //不明用水
	private Double tabKeyIS1;
	private Double tabKeyDS1;
	private Double tabKeyID1;
	private Double tabKeyID2;
	private Double tabKeyID3;
	private Double  value1;				//备用1
	private Double  value2;				//备用2
	private Double  value3;				//备用3
	private Double  value4;				//备用4
	private Double  value5;				//备用5
	private String times;//年月日单个查询时间

	
	
	
	
	public Double getTabTraffic() {
		return tabTraffic;
	}
	public void setTabTraffic(Double tabTraffic) {
		this.tabTraffic = tabTraffic;
	}
	public Double getTabWaterLevel() {
		return tabWaterLevel;
	}
	public void setTabWaterLevel(Double tabWaterLevel) {
		this.tabWaterLevel = tabWaterLevel;
	}
	public Double getTabCurrentSpeed() {
		return tabCurrentSpeed;
	}
	public void setTabCurrentSpeed(Double tabCurrentSpeed) {
		this.tabCurrentSpeed = tabCurrentSpeed;
	}
	public Double getTabZtraffic() {
		return tabZtraffic;
	}
	public void setTabZtraffic(Double tabZtraffic) {
		this.tabZtraffic = tabZtraffic;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getSytime() {
		return sytime;
	}
	public void setSytime(Integer sytime) {
		this.sytime = sytime;
	}
	public Date getStrTime() {
		return strTime;
	}
	public void setStrTime(Date strTime) {
		this.strTime = strTime;
	}
	public Double getTabTrafficIS1() {
		return tabTrafficIS1;
	}
	public void setTabTrafficIS1(Double tabTrafficIS1) {
		this.tabTrafficIS1 = tabTrafficIS1;
	}
	public Double getTabWaterLevelIS1() {
		return tabWaterLevelIS1;
	}
	public void setTabWaterLevelIS1(Double tabWaterLevelIS1) {
		this.tabWaterLevelIS1 = tabWaterLevelIS1;
	}
	public Double getTabCurrentSpeedIS1() {
		return tabCurrentSpeedIS1;
	}
	public void setTabCurrentSpeedIS1(Double tabCurrentSpeedIS1) {
		this.tabCurrentSpeedIS1 = tabCurrentSpeedIS1;
	}
	public Double getTabZtrafficIS1() {
		return tabZtrafficIS1;
	}
	public void setTabZtrafficIS1(Double tabZtrafficIS1) {
		this.tabZtrafficIS1 = tabZtrafficIS1;
	}
	public Double getTabTrafficDS1() {
		return tabTrafficDS1;
	}
	public void setTabTrafficDS1(Double tabTrafficDS1) {
		this.tabTrafficDS1 = tabTrafficDS1;
	}
	public Double getTabWaterLevelDS1() {
		return tabWaterLevelDS1;
	}
	public void setTabWaterLevelDS1(Double tabWaterLevelDS1) {
		this.tabWaterLevelDS1 = tabWaterLevelDS1;
	}
	public Double getTabCurrentSpeedDS1() {
		return tabCurrentSpeedDS1;
	}
	public void setTabCurrentSpeedDS1(Double tabCurrentSpeedDS1) {
		this.tabCurrentSpeedDS1 = tabCurrentSpeedDS1;
	}
	public Double getTabZtrafficDS1() {
		return tabZtrafficDS1;
	}
	public void setTabZtrafficDS1(Double tabZtrafficDS1) {
		this.tabZtrafficDS1 = tabZtrafficDS1;
	}
	public Double getTabTrafficID1() {
		return tabTrafficID1;
	}
	public void setTabTrafficID1(Double tabTrafficID1) {
		this.tabTrafficID1 = tabTrafficID1;
	}
	public Double getTabWaterLevelID1() {
		return tabWaterLevelID1;
	}
	public void setTabWaterLevelID1(Double tabWaterLevelID1) {
		this.tabWaterLevelID1 = tabWaterLevelID1;
	}
	public Double getTabCurrentSpeedID1() {
		return tabCurrentSpeedID1;
	}
	public void setTabCurrentSpeedID1(Double tabCurrentSpeedID1) {
		this.tabCurrentSpeedID1 = tabCurrentSpeedID1;
	}
	public Double getTabZtrafficID1() {
		return tabZtrafficID1;
	}
	public void setTabZtrafficID1(Double tabZtrafficID1) {
		this.tabZtrafficID1 = tabZtrafficID1;
	}
	public Double getTabTrafficID2() {
		return tabTrafficID2;
	}
	public void setTabTrafficID2(Double tabTrafficID2) {
		this.tabTrafficID2 = tabTrafficID2;
	}
	public Double getTabWaterLevelID2() {
		return tabWaterLevelID2;
	}
	public void setTabWaterLevelID2(Double tabWaterLevelID2) {
		this.tabWaterLevelID2 = tabWaterLevelID2;
	}
	public Double getTabCurrentSpeedID2() {
		return tabCurrentSpeedID2;
	}
	public void setTabCurrentSpeedID2(Double tabCurrentSpeedID2) {
		this.tabCurrentSpeedID2 = tabCurrentSpeedID2;
	}
	public Double getTabZtrafficID2() {
		return tabZtrafficID2;
	}
	public void setTabZtrafficID2(Double tabZtrafficID2) {
		this.tabZtrafficID2 = tabZtrafficID2;
	}
	public Double getTabTrafficID3() {
		return tabTrafficID3;
	}
	public void setTabTrafficID3(Double tabTrafficID3) {
		this.tabTrafficID3 = tabTrafficID3;
	}
	public Double getTabWaterLevelID3() {
		return tabWaterLevelID3;
	}
	public void setTabWaterLevelID3(Double tabWaterLevelID3) {
		this.tabWaterLevelID3 = tabWaterLevelID3;
	}
	public Double getTabCurrentSpeedID3() {
		return tabCurrentSpeedID3;
	}
	public void setTabCurrentSpeedID3(Double tabCurrentSpeedID3) {
		this.tabCurrentSpeedID3 = tabCurrentSpeedID3;
	}
	public Double getTabZtrafficID3() {
		return tabZtrafficID3;
	}
	public void setTabZtrafficID3(Double tabZtrafficID3) {
		this.tabZtrafficID3 = tabZtrafficID3;
	}
	public Double getTabPHID1() {
		return tabPHID1;
	}
	public void setTabPHID1(Double tabPHID1) {
		this.tabPHID1 = tabPHID1;
	}
	
	public Double getTabNh3NID1() {
		return tabNh3NID1;
	}
	public void setTabNh3NID1(Double tabNh3NID1) {
		this.tabNh3NID1 = tabNh3NID1;
	}
	public Double getTabPHID2() {
		return tabPHID2;
	}
	public void setTabPHID2(Double tabPHID2) {
		this.tabPHID2 = tabPHID2;
	}
	
	public Double getTabNh3NID2() {
		return tabNh3NID2;
	}
	public void setTabNh3NID2(Double tabNh3NID2) {
		this.tabNh3NID2 = tabNh3NID2;
	}
	public Double getTabPHID3() {
		return tabPHID3;
	}
	public void setTabPHID3(Double tabPHID3) {
		this.tabPHID3 = tabPHID3;
	}
	
	public Double getTabCodf() {
		return tabCodf;
	}
	public void setTabCodf(Double tabCodf) {
		this.tabCodf = tabCodf;
	}
	public Double getTabCods() {
		return tabCods;
	}
	public void setTabCods(Double tabCods) {
		this.tabCods = tabCods;
	}
	public Double getTabCodt() {
		return tabCodt;
	}
	public void setTabCodt(Double tabCodt) {
		this.tabCodt = tabCodt;
	}
	public Double getTabNh3NID3() {
		return tabNh3NID3;
	}
	public void setTabNh3NID3(Double tabNh3NID3) {
		this.tabNh3NID3 = tabNh3NID3;
	}
	public Double getLosslimit() {
		return Losslimit;
	}
	public void setLosslimit(Double losslimit) {
		Losslimit = losslimit;
	}
	public Double getWastage() {
		return wastage;
	}
	public void setWastage(Double wastage) {
		this.wastage = wastage;
	}
	public Double getUnknown() {
		return unknown;
	}
	public void setUnknown(Double unknown) {
		this.unknown = unknown;
	}
	public Double getTabKeyIS1() {
		return tabKeyIS1;
	}
	public void setTabKeyIS1(Double tabKeyIS1) {
		this.tabKeyIS1 = tabKeyIS1;
	}
	public Double getTabKeyDS1() {
		return tabKeyDS1;
	}
	public void setTabKeyDS1(Double tabKeyDS1) {
		this.tabKeyDS1 = tabKeyDS1;
	}
	public Double getTabKeyID1() {
		return tabKeyID1;
	}
	public void setTabKeyID1(Double tabKeyID1) {
		this.tabKeyID1 = tabKeyID1;
	}
	public Double getTabKeyID2() {
		return tabKeyID2;
	}
	public void setTabKeyID2(Double tabKeyID2) {
		this.tabKeyID2 = tabKeyID2;
	}
	public Double getTabKeyID3() {
		return tabKeyID3;
	}
	public void setTabKeyID3(Double tabKeyID3) {
		this.tabKeyID3 = tabKeyID3;
	}
	public Double getValue1() {
		return value1;
	}
	public void setValue1(Double value1) {
		this.value1 = value1;
	}
	public Double getValue2() {
		return value2;
	}
	public void setValue2(Double value2) {
		this.value2 = value2;
	}
	public Double getValue3() {
		return value3;
	}
	public void setValue3(Double value3) {
		this.value3 = value3;
	}
	public Double getValue4() {
		return value4;
	}
	public void setValue4(Double value4) {
		this.value4 = value4;
	}
	public Double getValue5() {
		return value5;
	}
	public void setValue5(Double value5) {
		this.value5 = value5;
	}
	
	
	
}
