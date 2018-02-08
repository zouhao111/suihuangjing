package com.erich.saleticket.model.tdht;

import java.util.Date;
import com.erich.easyframe.common.base.BaseModel;

/**
 * 实时数据
 * 流量监测数据视图
 */
public class ViewfirstTab extends BaseModel {
	
	private Integer id;
	private Integer syTime;//整型时间
	private Date strTime;//系统时间
	private Long rid;//公司关联ID
	private Double waterlevel; //水位
	private Double is_waterlevel; //水位生活
	private Double id_waterlevel; //水位工业
	private Double ls_waterlevel; //水位排水
	
	private Double id_traffic ; //流量速率工业排水
	private Double ls_traffic ; //流量速率 生活给水
	private Double is_traffic ; //流量速率 工业给水
	private Double id_CurrentSpeed ; //流速
	private Double ls_CurrentSpeed ; //流速
	private Double is_CurrentSpeed ; //流速
	private Double realPh;						//实时PH
	private Double id_voltage; //电压
	private Double ls_voltage; //电压
	private Double is_voltage; //电压
	private Double id_ztraffic;//总流量
	private Double ls_ztraffic;//总流量
	private Double is_ztraffic;//总流量
	private Double id_key;//采集板在线报警
	private Double ls_key;//采集板在线报警
	private Double is_key;//采集板在线报警
	private Double id_sub_ztraffic;
	private Double ls_sub_ztraffic;
	private Double is_sub_ztraffic;
	private Double industrialdrainage;
	private Double livingsupply;
	private Double industrialsupply;
	private Double livingsupply1;
	private Double Losslimit;
	private Double wastage;
	private Double unknown;
	private Double id_temp;
	private Double id_do;
	private Double id_turbidity;
	
	private Double waterLevel1; //水位
	
	
	public Double getIs_waterlevel() {
		return is_waterlevel;
	}

	public void setIs_waterlevel(Double is_waterlevel) {
		this.is_waterlevel = is_waterlevel;
	}

	public Double getId_waterlevel() {
		return id_waterlevel;
	}

	public void setId_waterlevel(Double id_waterlevel) {
		this.id_waterlevel = id_waterlevel;
	}

	public Double getLs_waterlevel() {
		return ls_waterlevel;
	}

	public void setLs_waterlevel(Double ls_waterlevel) {
		this.ls_waterlevel = ls_waterlevel;
	}

	public Double getWaterLevel1() {
		return waterLevel1;
	}

	public void setWaterLevel1(Double waterLevel1) {
		this.waterLevel1 = waterLevel1;
	}

	public ViewfirstTab()
	{
		
	}
	
	public Double getLivingsupply1() {
		return livingsupply1;
	}
	public void setLivingsupply1(Double livingsupply1) {
		this.livingsupply1 = livingsupply1;
	}
	public Double getId_temp() {
		return id_temp;
	}
	public void setId_temp(Double id_temp) {
		this.id_temp = id_temp;
	}
	public Double getId_do() {
		return id_do;
	}
	public void setId_do(Double id_do) {
		this.id_do = id_do;
	}
	public Double getId_turbidity() {
		return id_turbidity;
	}
	public void setId_turbidity(Double id_turbidity) {
		this.id_turbidity = id_turbidity;
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
	public Double getIndustrialdrainage() {
		return industrialdrainage;
	}
	public void setIndustrialdrainage(Double industrialdrainage) {
		this.industrialdrainage = industrialdrainage;
	}
	public Double getLivingsupply() {
		return livingsupply;
	}
	public void setLivingsupply(Double livingsupply) {
		this.livingsupply = livingsupply;
	}
	public Double getIndustrialsupply() {
		return industrialsupply;
	}
	public void setIndustrialsupply(Double industrialsupply) {
		this.industrialsupply = industrialsupply;
	}
	public Double getId_sub_ztraffic() {
		return id_sub_ztraffic;
	}
	public void setId_sub_ztraffic(Double id_sub_ztraffic) {
		this.id_sub_ztraffic = id_sub_ztraffic;
	}
	public Double getLs_sub_ztraffic() {
		return ls_sub_ztraffic;
	}
	public void setLs_sub_ztraffic(Double ls_sub_ztraffic) {
		this.ls_sub_ztraffic = ls_sub_ztraffic;
	}
	public Double getIs_sub_ztraffic() {
		return is_sub_ztraffic;
	}
	public void setIs_sub_ztraffic(Double is_sub_ztraffic) {
		this.is_sub_ztraffic = is_sub_ztraffic;
	}
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
	public Double getWaterlevel() {
		return waterlevel;
	}
	public void setWaterlevel(Double waterlevel) {
		this.waterlevel = waterlevel;
	
	}
	public Double getId_traffic() {
		return id_traffic;
	}
	public void setId_traffic(Double id_traffic) {
		this.id_traffic = id_traffic;
	}
	public Double getLs_traffic() {
		return ls_traffic;
	}
	public void setLs_traffic(Double ls_traffic) {
		this.ls_traffic = ls_traffic;
	}
	public Double getIs_traffic() {
		return is_traffic;
	}
	public void setIs_traffic(Double is_traffic) {
		this.is_traffic = is_traffic;
	}
	public Double getId_CurrentSpeed() {
		return id_CurrentSpeed;
	}
	public void setId_CurrentSpeed(Double id_CurrentSpeed) {
		this.id_CurrentSpeed = id_CurrentSpeed;
	}
	public Double getLs_CurrentSpeed() {
		return ls_CurrentSpeed;
	}
	public void setLs_CurrentSpeed(Double ls_CurrentSpeed) {
		this.ls_CurrentSpeed = ls_CurrentSpeed;
	}
	public Double getIs_CurrentSpeed() {
		return is_CurrentSpeed;
	}
	public void setIs_CurrentSpeed(Double is_CurrentSpeed) {
		this.is_CurrentSpeed = is_CurrentSpeed;
	}
	public Double getId_voltage() {
		return id_voltage;
	}
	public void setId_voltage(Double id_voltage) {
		this.id_voltage = id_voltage;
	}
	public Double getLs_voltage() {
		return ls_voltage;
	}
	public void setLs_voltage(Double ls_voltage) {
		this.ls_voltage = ls_voltage;
	}
	public Double getIs_voltage() {
		return is_voltage;
	}
	public void setIs_voltage(Double is_voltage) {
		this.is_voltage = is_voltage;
	}
	public Double getId_ztraffic() {
		return id_ztraffic;
	}
	public void setId_ztraffic(Double id_ztraffic) {
		this.id_ztraffic = id_ztraffic;
	}
	public Double getLs_ztraffic() {
		return ls_ztraffic;
	}
	public void setLs_ztraffic(Double ls_ztraffic) {
		this.ls_ztraffic = ls_ztraffic;
	}
	public Double getIs_ztraffic() {
		return is_ztraffic;
	}
	public void setIs_ztraffic(Double is_ztraffic) {
		this.is_ztraffic = is_ztraffic;
	}
	public Double getId_key() {
		return id_key;
	}
	public void setId_key(Double id_key) {
		this.id_key = id_key;
	}
	public Double getLs_key() {
		return ls_key;
	}
	public void setLs_key(Double ls_key) {
		this.ls_key = ls_key;
	}
	public Double getIs_key() {
		return is_key;
	}
	public void setIs_key(Double is_key) {
		this.is_key = is_key;
	}
	public Double getRealPh() {
		return realPh;
	}
	public void setRealPh(Double realPh) {
		this.realPh = realPh;
	}
	
	
}