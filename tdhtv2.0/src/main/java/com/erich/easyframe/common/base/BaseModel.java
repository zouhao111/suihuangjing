package com.erich.easyframe.common.base;

import com.erich.saleticket.dto.Pager;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "condition", "pager"})  
public abstract class BaseModel implements Serializable, Cloneable {
    
	private Integer type;//查询类型日周月 1日 2周  3月  4季度  5自定义 6年         11历史报表
	private String  viewName;//视图名称
	private String  companyName;//公司名称
	private Integer form;//查询类型 排水  给水   1工业排水   2工业给水  3生活给水  4 流量汇总5 流量汇总系数 6 污染物
	private String dateTypes;//年月日单个查询时间
	private Long rid;//公司ID
	private String startingTime;//开始时间
	private String endTime;//结束时间
	private Long startingTimeL;//开始时间
	private Long endTimeL;//结束时间
	private Integer minates;//查询分钟
	private StringBuffer webUrl;//网页路径
    private String strRid;
    private Integer remainder;//余数
    private Integer travelNum;						//公司人数
	private Date stratTime;		//起算时间
	private Double companyStand;			//人均标准用水
	private Double perCaoitaWater;//人均用水限值
	private Double consumptionCoefficient;		//消耗系数
	private Long principalId;   //负责人Id
	private Integer indrainageNum;//工业排水数量
	private Integer insupplyNum;//工业给水
	private Integer livdrainageNum;//
	private Integer livsupplyNum;
	private String mainRID;
	private String lat;//经度
	private String lon;//纬度
	private String address;
	private String photo;
	private String install;
	private String telephone;
	private String province;
	private String  city;
	private String region;
	private String monitor;
	private String build;
	private String operating;
	private String  contact;
    
	
	

	public Long getStartingTimeL() {
		return startingTimeL;
	}

	public void setStartingTimeL(Long startingTimeL) {
		this.startingTimeL = startingTimeL;
	}

	public Long getEndTimeL() {
		return endTimeL;
	}

	public void setEndTimeL(Long endTimeL) {
		this.endTimeL = endTimeL;
	}

	public Integer getRemainder() {
		return remainder;
	}

	public void setRemainder(Integer remainder) {
		this.remainder = remainder;
	}

	public Integer getTravelNum() {
		return travelNum;
	}

	public void setTravelNum(Integer travelNum) {
		this.travelNum = travelNum;
	}

	public Date getStratTime() {
		return stratTime;
	}

	public void setStratTime(Date stratTime) {
		this.stratTime = stratTime;
	}

	public Double getCompanyStand() {
		return companyStand;
	}

	public void setCompanyStand(Double companyStand) {
		this.companyStand = companyStand;
	}

	public Double getPerCaoitaWater() {
		return perCaoitaWater;
	}

	public void setPerCaoitaWater(Double perCaoitaWater) {
		this.perCaoitaWater = perCaoitaWater;
	}

	public Double getConsumptionCoefficient() {
		return consumptionCoefficient;
	}

	public void setConsumptionCoefficient(Double consumptionCoefficient) {
		this.consumptionCoefficient = consumptionCoefficient;
	}

	public Long getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(Long principalId) {
		this.principalId = principalId;
	}

	public Integer getIndrainageNum() {
		return indrainageNum;
	}

	public void setIndrainageNum(Integer indrainageNum) {
		this.indrainageNum = indrainageNum;
	}

	public Integer getInsupplyNum() {
		return insupplyNum;
	}

	public void setInsupplyNum(Integer insupplyNum) {
		this.insupplyNum = insupplyNum;
	}

	public Integer getLivdrainageNum() {
		return livdrainageNum;
	}

	public void setLivdrainageNum(Integer livdrainageNum) {
		this.livdrainageNum = livdrainageNum;
	}

	public Integer getLivsupplyNum() {
		return livsupplyNum;
	}

	public void setLivsupplyNum(Integer livsupplyNum) {
		this.livsupplyNum = livsupplyNum;
	}

	public String getMainRID() {
		return mainRID;
	}

	public void setMainRID(String mainRID) {
		this.mainRID = mainRID;
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

	public String getStrRid() {
		return strRid;
	}

	public void setStrRid(String strRid) {
		this.strRid = strRid;
	}

	public StringBuffer getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(StringBuffer webUrl) {
		this.webUrl = webUrl;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getDateTypes() {
		return dateTypes;
	}

	public void setDateTypes(String dateTypes) {
		this.dateTypes = dateTypes;
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

	public Integer getForm() {
		return form;
	}

	public void setForm(Integer form) {
		this.form = form;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	private static final long serialVersionUID = 5382765219097354400L;

	//	private Integer page = 1;1
	//	private Integer rows =10;
	//	private String sort;
	//	private String order;
	private Map<String, Object> condition = new HashMap<String, Object>();

	/**
	 * 分页导航
	 */
	private Pager pager = new Pager();

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public Map<String, Object> getCondition() {
		return condition;
	}

	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getInstall() {
		return install;
	}

	public void setInstall(String install) {
		this.install = install;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public String getOperating() {
		return operating;
	}

	public void setOperating(String operating) {
		this.operating = operating;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
