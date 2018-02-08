package com.erich.saleticket.model.tdht;

import java.util.Date;
import java.util.List;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 污染物
 */
public class Pollutant extends BaseModel {

	private Double tabTraffic;		//工业给水流量速率					//流量速率
	private Double tabWaterLevel;			//工业给水水位
	private Double tabCurrentSpeed;			//	工业给水流速		//流速
	private Double tabZtraffic;	
	private Integer id;
	private int syTime;
	private Date strTime;
	private String  strTime1;
	private Double realph;
	private Double cod;
	private Double toc;   //有机碳
	private Double bod;//需氧量
	private Double nh4;//氨氮
	private Double mlss;//污泥浓度
	private Double cr;  //铬
	private Double cr6;  //六价铬
	private Double ni;   //镍
	private Double cd;   //镉
	private Double lead;   //铅
	private Double silver;  //银
	private Double hg;   //汞
	private Double phosphor;//磷
	private Double cu;//铜
	private Double zn;//锌
	private Double prussiate;
	private Double realcod;
	private Double realtoc;   //有机碳
	private Double realbod;//需氧量
	private Double realnh4;//氨氮
	private Double realmlss;//污泥浓度
	private Double realconductivity;//电导率
	private Double maxconductivity;
	private Double minconductivity;
	private Double realztraffic;
	private Double realcr;  //铬
	private Double realcr6;  //六价铬
	private Double realni;   //镍
	private Double realcd;   //镉
	private Double reallead;   //铅
	private Double realsilver;  //银
	private Double realhg;   //汞
	private Double realphosphor;//磷
	private Double realcu;//铜
	private Double realzn;//锌
	private Double realprussiate;
	private Double mincod;
	private Double mintoc;   
	private Double minbod;
	private Double minnh4;
	private Double minmlss; 
	private Double maxcod;
	private Double maxtoc;   
	private Double maxbod;
	private Double maxnh4;
	private Double maxmlss;
	private Double minph; 
	private Double maxph;
	private Double mincu;
	private Double minzn;
	private Double mincr;
	private Double mincr6;   
	private Double minni;
	private Double mincd;
	private Double minlead; 
	private Double minsilver;
	private Double minhg;   
	private Double minphosphor;
	private Double maxcr;
	private Double maxcr6;   
	private Double maxni;
	private Double maxcd;
	private Double maxlead;
	private Double maxsilver;
	private Double maxhg;  
	private Double maxphosphor;//需氧量
	private Double maxcu;//铜
	private Double maxzn;//锌
	private Double minprussiate;
	private Double maxprussiate;
	
	private Double maxTurbidity;
	private Double minTurbidity;
	private Double realTurbidity;
	private Double maxDo;
	private Double minDo;
	private Double realDo;
	private Double maxTemp;
	private Double minTemp;
	private Double realTemp;
	private Double Flu;
	private Double realFlu;
	private Double minFlu;
	private Double maxFlu;
	private String pollType;
	private Double sub_ztraffic;
	private Double realvoltage;
	private Integer ishave;

	private Integer type_poll;
	private Long rid1;
	private Integer maxSytime;
	private String typeRemark;
	
	
	
	
	public Double getFlu() {
		return Flu;
	}
	public void setFlu(Double flu) {
		Flu = flu;
	}
	public Double getRealFlu() {
		return realFlu;
	}
	public void setRealFlu(Double realFlu) {
		this.realFlu = realFlu;
	}
	public Double getMinFlu() {
		return minFlu;
	}
	public void setMinFlu(Double minFlu) {
		this.minFlu = minFlu;
	}
	public Double getMaxFlu() {
		return maxFlu;
	}
	public void setMaxFlu(Double maxFlu) {
		this.maxFlu = maxFlu;
	}
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
	public String getTypeRemark() {
		return typeRemark;
	}
	public void setTypeRemark(String typeRemark) {
		this.typeRemark = typeRemark;
	}
	public Double getMaxTurbidity() {
		return maxTurbidity;
	}
	public void setMaxTurbidity(Double maxTurbidity) {
		this.maxTurbidity = maxTurbidity;
	}
	public Double getMinTurbidity() {
		return minTurbidity;
	}
	public void setMinTurbidity(Double minTurbidity) {
		this.minTurbidity = minTurbidity;
	}
	public Double getRealTurbidity() {
		return realTurbidity;
	}
	public void setRealTurbidity(Double realTurbidity) {
		this.realTurbidity = realTurbidity;
	}
	public Double getMaxDo() {
		return maxDo;
	}
	public void setMaxDo(Double maxDo) {
		this.maxDo = maxDo;
	}
	public Double getMinDo() {
		return minDo;
	}
	public void setMinDo(Double minDo) {
		this.minDo = minDo;
	}
	public Double getRealDo() {
		return realDo;
	}
	public void setRealDo(Double realDo) {
		this.realDo = realDo;
	}
	public Double getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(Double maxTemp) {
		this.maxTemp = maxTemp;
	}
	public Double getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(Double minTemp) {
		this.minTemp = minTemp;
	}
	public Double getRealTemp() {
		return realTemp;
	}
	public void setRealTemp(Double realTemp) {
		this.realTemp = realTemp;
	}
	public Integer getType_poll() {
		return type_poll;
	}
	public void setType_poll(Integer type_poll) {
		this.type_poll = type_poll;
	}
	public Integer getIshave() {
		return ishave;
	}
	public void setIshave(Integer ishave) {
		this.ishave = ishave;
	}
	public Double getRealvoltage() {
		return realvoltage;
	}
	public void setRealvoltage(Double realvoltage) {
		this.realvoltage = realvoltage;
	}
	public Double getSub_ztraffic() {
		return sub_ztraffic;
	}
	public void setSub_ztraffic(Double sub_ztraffic) {
		this.sub_ztraffic = sub_ztraffic;
	}
	public Double getRealztraffic() {
		return realztraffic;
	}
	public void setRealztraffic(Double realztraffic) {
		this.realztraffic = realztraffic;
	}
	public String getStrTime1() {
		return strTime1;
	}
	public void setStrTime1(String strTime1) {
		this.strTime1 = strTime1;
	}
	public Double getRealph() {
		return realph;
	}
	public void setRealph(Double realph) {
		this.realph = realph;
	}
	public Double getRealconductivity() {
		return realconductivity;
	}
	public void setRealconductivity(Double realconductivity) {
		this.realconductivity = realconductivity;
	}
	public Double getMaxconductivity() {
		return maxconductivity;
	}
	public void setMaxconductivity(Double maxconductivity) {
		this.maxconductivity = maxconductivity;
	}
	public Double getMinconductivity() {
		return minconductivity;
	}
	public void setMinconductivity(Double minconductivity) {
		this.minconductivity = minconductivity;
	}
	public Double getMinph() {
		return minph;
	}
	public void setMinph(Double minph) {
		this.minph = minph;
	}
	public Double getMaxph() {
		return maxph;
	}
	public void setMaxph(Double maxph) {
		this.maxph = maxph;
	}
	public String getPollType() {
		return pollType;
	}
	public void setPollType(String pollType) {
		this.pollType = pollType;
	}
	public Double getPrussiate() {
		return prussiate;
	}
	public void setPrussiate(Double prussiate) {
		this.prussiate = prussiate;
	}
	public Double getMinprussiate() {
		return minprussiate;
	}
	public void setMinprussiate(Double minprussiate) {
		this.minprussiate = minprussiate;
	}
	public Double getMaxprussiate() {
		return maxprussiate;
	}
	public void setMaxprussiate(Double maxprussiate) {
		this.maxprussiate = maxprussiate;
	}
	public Double getCod() {
		return cod;
	}
	public void setCod(Double cod) {
		this.cod = cod;
	}
	public Double getToc() {
		return toc;
	}
	public void setToc(Double toc) {
		this.toc = toc;
	}
	public Double getBod() {
		return bod;
	}
	public void setBod(Double bod) {
		this.bod = bod;
	}
	public Double getNh4() {
		return nh4;
	}
	public void setNh4(Double nh4) {
		this.nh4 = nh4;
	}
	public Double getMlss() {
		return mlss;
	}
	public void setMlss(Double mlss) {
		this.mlss = mlss;
	}
	public Double getCr() {
		return cr;
	}
	public void setCr(Double cr) {
		this.cr = cr;
	}
	public Double getCr6() {
		return cr6;
	}
	public void setCr6(Double cr6) {
		this.cr6 = cr6;
	}
	public Double getNi() {
		return ni;
	}
	public void setNi(Double ni) {
		this.ni = ni;
	}
	public Double getCd() {
		return cd;
	}
	public void setCd(Double cd) {
		this.cd = cd;
	}
	public Double getLead() {
		return lead;
	}
	public void setLead(Double lead) {
		this.lead = lead;
	}
	public Double getSilver() {
		return silver;
	}
	public void setSilver(Double silver) {
		this.silver = silver;
	}
	public Double getHg() {
		return hg;
	}
	public void setHg(Double hg) {
		this.hg = hg;
	}
	public Double getPhosphor() {
		return phosphor;
	}
	public void setPhosphor(Double phosphor) {
		this.phosphor = phosphor;
	}
	public Double getCu() {
		return cu;
	}
	public void setCu(Double cu) {
		this.cu = cu;
	}
	public Double getZn() {
		return zn;
	}
	public void setZn(Double zn) {
		this.zn = zn;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getSyTime() {
		return syTime;
	}
	public void setSyTime(int syTime) {
		this.syTime = syTime;
	}
	
	public Date getStrTime() {
		return strTime;
	}
	public void setStrTime(Date strTime) {
		this.strTime = strTime;
	}
	public Double getRealcod() {
		return realcod;
	}
	public void setRealcod(Double realcod) {
		this.realcod = realcod;
	}
	public Double getRealtoc() {
		return realtoc;
	}
	public void setRealtoc(Double realtoc) {
		this.realtoc = realtoc;
	}
	public Double getRealbod() {
		return realbod;
	}
	public void setRealbod(Double realbod) {
		this.realbod = realbod;
	}
	public Double getRealnh4() {
		return realnh4;
	}
	public void setRealnh4(Double realnh4) {
		this.realnh4 = realnh4;
	}
	public Double getRealmlss() {
		return realmlss;
	}
	public void setRealmlss(Double realmlss) {
		this.realmlss = realmlss;
	}
	public Double getRealcr() {
		return realcr;
	}
	public void setRealcr(Double realcr) {
		this.realcr = realcr;
	}
	public Double getRealcr6() {
		return realcr6;
	}
	public void setRealcr6(Double realcr6) {
		this.realcr6 = realcr6;
	}
	public Double getRealni() {
		return realni;
	}
	public void setRealni(Double realni) {
		this.realni = realni;
	}
	public Double getRealcd() {
		return realcd;
	}
	public void setRealcd(Double realcd) {
		this.realcd = realcd;
	}
	public Double getReallead() {
		return reallead;
	}
	public void setReallead(Double reallead) {
		this.reallead = reallead;
	}
	public Double getRealsilver() {
		return realsilver;
	}
	public void setRealsilver(Double realsilver) {
		this.realsilver = realsilver;
	}
	public Double getRealhg() {
		return realhg;
	}
	public void setRealhg(Double realhg) {
		this.realhg = realhg;
	}
	public Double getRealphosphor() {
		return realphosphor;
	}
	public void setRealphosphor(Double realphosphor) {
		this.realphosphor = realphosphor;
	}
	public Double getRealcu() {
		return realcu;
	}
	public void setRealcu(Double realcu) {
		this.realcu = realcu;
	}
	public Double getRealzn() {
		return realzn;
	}
	public void setRealzn(Double realzn) {
		this.realzn = realzn;
	}
	
	public Double getRealprussiate() {
		return realprussiate;
	}
	public void setRealprussiate(Double realprussiate) {
		this.realprussiate = realprussiate;
	}
	public Double getMincod() {
		return mincod;
	}
	public void setMincod(Double mincod) {
		this.mincod = mincod;
	}
	public Double getMintoc() {
		return mintoc;
	}
	public void setMintoc(Double mintoc) {
		this.mintoc = mintoc;
	}
	public Double getMinbod() {
		return minbod;
	}
	public void setMinbod(Double minbod) {
		this.minbod = minbod;
	}
	public Double getMinnh4() {
		return minnh4;
	}
	public void setMinnh4(Double minnh4) {
		this.minnh4 = minnh4;
	}
	public Double getMinmlss() {
		return minmlss;
	}
	public void setMinmlss(Double minmlss) {
		this.minmlss = minmlss;
	}
	public Double getMaxcod() {
		return maxcod;
	}
	public void setMaxcod(Double maxcod) {
		this.maxcod = maxcod;
	}
	public Double getMaxtoc() {
		return maxtoc;
	}
	public void setMaxtoc(Double maxtoc) {
		this.maxtoc = maxtoc;
	}
	public Double getMaxbod() {
		return maxbod;
	}
	public void setMaxbod(Double maxbod) {
		this.maxbod = maxbod;
	}
	public Double getMaxnh4() {
		return maxnh4;
	}
	public void setMaxnh4(Double maxnh4) {
		this.maxnh4 = maxnh4;
	}
	public Double getMaxmlss() {
		return maxmlss;
	}
	public void setMaxmlss(Double maxmlss) {
		this.maxmlss = maxmlss;
	}
	public Double getMincu() {
		return mincu;
	}
	public void setMincu(Double mincu) {
		this.mincu = mincu;
	}
	public Double getMinzn() {
		return minzn;
	}
	public void setMinzn(Double minzn) {
		this.minzn = minzn;
	}
	public Double getMincr() {
		return mincr;
	}
	public void setMincr(Double mincr) {
		this.mincr = mincr;
	}
	public Double getMincr6() {
		return mincr6;
	}
	public void setMincr6(Double mincr6) {
		this.mincr6 = mincr6;
	}
	public Double getMinni() {
		return minni;
	}
	public void setMinni(Double minni) {
		this.minni = minni;
	}
	public Double getMincd() {
		return mincd;
	}
	public void setMincd(Double mincd) {
		this.mincd = mincd;
	}
	public Double getMinlead() {
		return minlead;
	}
	public void setMinlead(Double minlead) {
		this.minlead = minlead;
	}
	public Double getMinsilver() {
		return minsilver;
	}
	public void setMinsilver(Double minsilver) {
		this.minsilver = minsilver;
	}
	public Double getMinhg() {
		return minhg;
	}
	public void setMinhg(Double minhg) {
		this.minhg = minhg;
	}
	public Double getMinphosphor() {
		return minphosphor;
	}
	public void setMinphosphor(Double minphosphor) {
		this.minphosphor = minphosphor;
	}
	public Double getMaxcr() {
		return maxcr;
	}
	public void setMaxcr(Double maxcr) {
		this.maxcr = maxcr;
	}
	public Double getMaxcr6() {
		return maxcr6;
	}
	public void setMaxcr6(Double maxcr6) {
		this.maxcr6 = maxcr6;
	}
	public Double getMaxni() {
		return maxni;
	}
	public void setMaxni(Double maxni) {
		this.maxni = maxni;
	}
	public Double getMaxcd() {
		return maxcd;
	}
	public void setMaxcd(Double maxcd) {
		this.maxcd = maxcd;
	}
	public Double getMaxlead() {
		return maxlead;
	}
	public void setMaxlead(Double maxlead) {
		this.maxlead = maxlead;
	}
	public Double getMaxsilver() {
		return maxsilver;
	}
	public void setMaxsilver(Double maxsilver) {
		this.maxsilver = maxsilver;
	}
	public Double getMaxhg() {
		return maxhg;
	}
	public void setMaxhg(Double maxhg) {
		this.maxhg = maxhg;
	}
	public Double getMaxphosphor() {
		return maxphosphor;
	}
	public void setMaxphosphor(Double maxphosphor) {
		this.maxphosphor = maxphosphor;
	}
	public Double getMaxcu() {
		return maxcu;
	}
	public void setMaxcu(Double maxcu) {
		this.maxcu = maxcu;
	}
	public Double getMaxzn() {
		return maxzn;
	}
	public void setMaxzn(Double maxzn) {
		this.maxzn = maxzn;
	}
	public Long getRid1() {
		return rid1;
	}
	public void setRid1(Long rid1) {
		this.rid1 = rid1;
	}
	public Integer getMaxSytime() {
		return maxSytime;
	}
	public void setMaxSytime(Integer maxSytime) {
		this.maxSytime = maxSytime;
	}
	
	
	}