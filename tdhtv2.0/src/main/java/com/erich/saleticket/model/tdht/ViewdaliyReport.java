package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

public class ViewdaliyReport extends BaseModel{
	private Integer id;
	private Integer sytime;					//整型时间
	private Date strTime;						//字符时间
	private String strTime1;
	private Double tabMaxPHf;
	private Double tabMinPHf;
	private Double tabMaxNh3Nf;
	private Double tabMinNh3Nf;
	private Double tabMinConductivityf;
	private Double tabMaxConductivityf;
	private Double tabMaxTemperaturef;
	private Double tabMinTemperaturef;
	private Double tabMaxNTUf;
	private Double tabMinNTUf;
	private Double tabMaxDOf;
	private Double tabMinDOf;
	private Double tabMaxPHs;
	private Double tabMinPHs;
	private Double tabMaxNH3Ns;
	private Double tabMinNH3Ns;
	private Double tabMaxCDf;
	private Double tabMinCDf;
	private Double tabMaxCDs;
	private Double tabMinCDs;
	private Double industrialdrainage;
	private Double livingsupply;
	private Double industrialsupply;
	private Double Losslimit;
	private Double wastage;
	private Double unknown;
	private Double livingsupply1;
	
	public String getStrTime1() {
		return strTime1;
	}
	public void setStrTime1(String strTime1) {
		this.strTime1 = strTime1;
	}
	public Double getLivingsupply1() {
		return livingsupply1;
	}
	public void setLivingsupply1(Double livingsupply1) {
		this.livingsupply1 = livingsupply1;
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
	public Double getTabMaxPHf() {
		return tabMaxPHf;
	}
	public void setTabMaxPHf(Double tabMaxPHf) {
		this.tabMaxPHf = tabMaxPHf;
	}
	public Double getTabMinPHf() {
		return tabMinPHf;
	}
	public void setTabMinPHf(Double tabMinPHf) {
		this.tabMinPHf = tabMinPHf;
	}
	public Double getTabMaxNh3Nf() {
		return tabMaxNh3Nf;
	}
	public void setTabMaxNh3Nf(Double tabMaxNh3Nf) {
		this.tabMaxNh3Nf = tabMaxNh3Nf;
	}
	public Double getTabMinNh3Nf() {
		return tabMinNh3Nf;
	}
	public void setTabMinNh3Nf(Double tabMinNh3Nf) {
		this.tabMinNh3Nf = tabMinNh3Nf;
	}
	public Double getTabMinConductivityf() {
		return tabMinConductivityf;
	}
	public void setTabMinConductivityf(Double tabMinConductivityf) {
		this.tabMinConductivityf = tabMinConductivityf;
	}
	public Double getTabMaxConductivityf() {
		return tabMaxConductivityf;
	}
	public void setTabMaxConductivityf(Double tabMaxConductivityf) {
		this.tabMaxConductivityf = tabMaxConductivityf;
	}
	public Double getTabMaxTemperaturef() {
		return tabMaxTemperaturef;
	}
	public void setTabMaxTemperaturef(Double tabMaxTemperaturef) {
		this.tabMaxTemperaturef = tabMaxTemperaturef;
	}
	public Double getTabMinTemperaturef() {
		return tabMinTemperaturef;
	}
	public void setTabMinTemperaturef(Double tabMinTemperaturef) {
		this.tabMinTemperaturef = tabMinTemperaturef;
	}
	public Double getTabMaxNTUf() {
		return tabMaxNTUf;
	}
	public void setTabMaxNTUf(Double tabMaxNTUf) {
		this.tabMaxNTUf = tabMaxNTUf;
	}
	public Double getTabMinNTUf() {
		return tabMinNTUf;
	}
	public void setTabMinNTUf(Double tabMinNTUf) {
		this.tabMinNTUf = tabMinNTUf;
	}
	public Double getTabMaxDOf() {
		return tabMaxDOf;
	}
	public void setTabMaxDOf(Double tabMaxDOf) {
		this.tabMaxDOf = tabMaxDOf;
	}
	public Double getTabMinDOf() {
		return tabMinDOf;
	}
	public void setTabMinDOf(Double tabMinDOf) {
		this.tabMinDOf = tabMinDOf;
	}
	public Double getTabMaxPHs() {
		return tabMaxPHs;
	}
	public void setTabMaxPHs(Double tabMaxPHs) {
		this.tabMaxPHs = tabMaxPHs;
	}
	public Double getTabMinPHs() {
		return tabMinPHs;
	}
	public void setTabMinPHs(Double tabMinPHs) {
		this.tabMinPHs = tabMinPHs;
	}
	public Double getTabMaxNH3Ns() {
		return tabMaxNH3Ns;
	}
	public void setTabMaxNH3Ns(Double tabMaxNH3Ns) {
		this.tabMaxNH3Ns = tabMaxNH3Ns;
	}
	public Double getTabMinNH3Ns() {
		return tabMinNH3Ns;
	}
	public void setTabMinNH3Ns(Double tabMinNH3Ns) {
		this.tabMinNH3Ns = tabMinNH3Ns;
	}
	public Double getTabMaxCDf() {
		return tabMaxCDf;
	}
	public void setTabMaxCDf(Double tabMaxCDf) {
		this.tabMaxCDf = tabMaxCDf;
	}
	public Double getTabMinCDf() {
		return tabMinCDf;
	}
	public void setTabMinCDf(Double tabMinCDf) {
		this.tabMinCDf = tabMinCDf;
	}
	public Double getTabMaxCDs() {
		return tabMaxCDs;
	}
	public void setTabMaxCDs(Double tabMaxCDs) {
		this.tabMaxCDs = tabMaxCDs;
	}
	public Double getTabMinCDs() {
		return tabMinCDs;
	}
	public void setTabMinCDs(Double tabMinCDs) {
		this.tabMinCDs = tabMinCDs;
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
	
	
}
