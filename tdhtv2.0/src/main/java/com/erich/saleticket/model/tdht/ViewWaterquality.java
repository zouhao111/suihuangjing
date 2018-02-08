package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 实时数据
 * 水质监测视图
 */
public class ViewWaterquality extends BaseModel {

	
	private Integer id;
	private Long rid;							//公司编号
	private Integer syTime;					//整型时间
	private Date strTime;	
	private Date strTime1;//字符时间
	private Integer dateType;
	
	private Double realPh;							//实时PH
	private Double lastDayMinPh;			//最近24小时的最小值PH
	private Double lastDayMaxPh;			//最近24小时最大值PH
	private Double realCod;						//实时COD
	private Double lastDayMinCod;			//最近24小时最小值COD
	private Double lastDayMaxCod;			//最近24小时最大值COD
	private Double realNH3N;						//实时氨氮
	private Double lastDayMinNH3N;			//最近24小时最小值氨氮
	private Double lastDayMaxNH3N;			//最近24小时最大值氨氮
	private Double realConductivity;		//电导率
	private Double lastDayMaxConductivity;		//电导率最大值
	private Double lastDayMinConductivity;		//电导率最小值
	private Double realcr6;		//六价铬
	private Double lastDayMaxCr6;		//六价铬
	private Double lastDayMinCr6;		//六价铬
	private Double  standby1;				//备用1
	private Double  standby2;				//备用2
	private Double  standby3;				//备用3
	private Double  standby4;				//备用4
	private Double  standby5;				//备用5
	private Double  standby6;				//备用6
	private Double  standby7;				//备用7
	private Double  standby8;				//备用8
	private Double  standby9;				//备用9Turbidity
	private Double  standby10;			//备用10
	
	private Double  realTemp;
	private Double  lastDayMinTemp;
	private Double  lastDayMaxTemp;
	private Double  realDo;
	private Double  lastDayMinDo;
	private Double  lastDayMaxDo;

	private Double  realTurbidity;
	private Double  lastDayMinTurbidity;
	private Double  lastDayMaxTurbidity;

	
	
	public Double getRealTurbidity() {
		return realTurbidity;
	}
	public void setRealTurbidity(Double realTurbidity) {
		this.realTurbidity = realTurbidity;
	}
	public Double getLastDayMinTurbidity() {
		return lastDayMinTurbidity;
	}
	public void setLastDayMinTurbidity(Double lastDayMinTurbidity) {
		this.lastDayMinTurbidity = lastDayMinTurbidity;
	}
	public Double getLastDayMaxTurbidity() {
		return lastDayMaxTurbidity;
	}
	public void setLastDayMaxTurbidity(Double lastDayMaxTurbidity) {
		this.lastDayMaxTurbidity = lastDayMaxTurbidity;
	}
	public Double getRealcr6() {
		return realcr6;
	}
	public void setRealcr6(Double realcr6) {
		this.realcr6 = realcr6;
	}
	public Double getRealTemp() {
		return realTemp;
	}
	public void setRealTemp(Double realTemp) {
		this.realTemp = realTemp;
	}
	public Double getLastDayMinTemp() {
		return lastDayMinTemp;
	}
	public void setLastDayMinTemp(Double lastDayMinTemp) {
		this.lastDayMinTemp = lastDayMinTemp;
	}
	public Double getLastDayMaxTemp() {
		return lastDayMaxTemp;
	}
	public void setLastDayMaxTemp(Double lastDayMaxTemp) {
		this.lastDayMaxTemp = lastDayMaxTemp;
	}
	public Double getRealDo() {
		return realDo;
	}
	public void setRealDo(Double realDo) {
		this.realDo = realDo;
	}
	public Double getLastDayMinDo() {
		return lastDayMinDo;
	}
	public void setLastDayMinDo(Double lastDayMinDo) {
		this.lastDayMinDo = lastDayMinDo;
	}
	public Double getLastDayMaxDo() {
		return lastDayMaxDo;
	}
	public void setLastDayMaxDo(Double lastDayMaxDo) {
		this.lastDayMaxDo = lastDayMaxDo;
	}
	public Date getStrTime1() {
		return strTime1;
	}
	public void setStrTime1(Date strTime1) {
		this.strTime1 = strTime1;
	}
	
	public Double getLastDayMaxCr6() {
		return lastDayMaxCr6;
	}
	public void setLastDayMaxCr6(Double lastDayMaxCr6) {
		this.lastDayMaxCr6 = lastDayMaxCr6;
	}
	public Double getLastDayMinCr6() {
		return lastDayMinCr6;
	}
	public void setLastDayMinCr6(Double lastDayMinCr6) {
		this.lastDayMinCr6 = lastDayMinCr6;
	}
	public Double getRealConductivity() {
		return realConductivity;
	}
	public void setRealConductivity(Double realConductivity) {
		this.realConductivity = realConductivity;
	}
	public Double getLastDayMaxConductivity() {
		return lastDayMaxConductivity;
	}
	public void setLastDayMaxConductivity(Double lastDayMaxConductivity) {
		this.lastDayMaxConductivity = lastDayMaxConductivity;
	}
	public Double getLastDayMinConductivity() {
		return lastDayMinConductivity;
	}
	public void setLastDayMinConductivity(Double lastDayMinConductivity) {
		this.lastDayMinConductivity = lastDayMinConductivity;
	}
	public Integer getDateType() {
		return dateType;
	}
	public void setDateType(Integer dateType) {
		this.dateType = dateType;
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
	public Integer getSyTime() {
		return syTime;
	}
	public void setSyTime(Integer syTime) {
		this.syTime = syTime;
	}
	public Double getRealNH3N() {
		return realNH3N;
	}
	public void setRealNH3N(Double realNH3N) {
		this.realNH3N = realNH3N;
	}
	public Double getLastDayMinNH3N() {
		return lastDayMinNH3N;
	}
	public void setLastDayMinNH3N(Double lastDayMinNH3N) {
		this.lastDayMinNH3N = lastDayMinNH3N;
	}
	public Double getLastDayMaxNH3N() {
		return lastDayMaxNH3N;
	}
	public void setLastDayMaxNH3N(Double lastDayMaxNH3N) {
		this.lastDayMaxNH3N = lastDayMaxNH3N;
	}
	public Date getStrTime() {
		return strTime;
	}
	public void setStrTime(Date strTime) {
		this.strTime = strTime;
	}
	public Double getRealPh() {
		return realPh;
	}
	public void setRealPh(Double realPh) {
		this.realPh = realPh;
	}
	public Double getLastDayMinPh() {
		return lastDayMinPh;
	}
	public void setLastDayMinPh(Double lastDayMinPh) {
		this.lastDayMinPh = lastDayMinPh;
	}
	public Double getLastDayMaxPh() {
		return lastDayMaxPh;
	}
	public void setLastDayMaxPh(Double lastDayMaxPh) {
		this.lastDayMaxPh = lastDayMaxPh;
	}
	public Double getRealCod() {
		return realCod;
	}
	public void setRealCod(Double realCod) {
		this.realCod = realCod;
	}
	public Double getLastDayMinCod() {
		return lastDayMinCod;
	}
	public void setLastDayMinCod(Double lastDayMinCod) {
		this.lastDayMinCod = lastDayMinCod;
	}
	public Double getLastDayMaxCod() {
		return lastDayMaxCod;
	}
	public void setLastDayMaxCod(Double lastDayMaxCod) {
		this.lastDayMaxCod = lastDayMaxCod;
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
	public Double getStandby8() {
		return standby8;
	}
	public void setStandby8(Double standby8) {
		this.standby8 = standby8;
	}
	public Double getStandby9() {
		return standby9;
	}
	public void setStandby9(Double standby9) {
		this.standby9 = standby9;
	}
	public Double getStandby10() {
		return standby10;
	}
	public void setStandby10(Double standby10) {
		this.standby10 = standby10;
	}
	
	
}