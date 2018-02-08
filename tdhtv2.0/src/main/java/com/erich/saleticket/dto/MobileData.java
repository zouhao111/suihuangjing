package com.erich.saleticket.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.ViewData;
import com.erich.saleticket.model.tdht.ViewLineReport;
import com.erich.saleticket.model.tdht.ViewLog;
import com.erich.saleticket.model.tdht.ViewdaliyReport;


/**
 * 带数据的返回结果
 * @author Administrator
 *
 * @param <T>
 */
public class MobileData<T> extends PlaceResult {
	
	
	
private static final long serialVersionUID = 2055801862853973721L;
	
	private Date date;
	
	public Date getDate() {
		if(date == null){
			date = new Date();
		}
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 返回的结果
	 */
	private T result;

	private List<Object> list;
	
	
	private List<Object> waterquality;//水质监测
	private List<Object> ztraffic;//水平衡分析
	private List<Object> ztraffic2;//流量汇总系数
	private List<Object> companyconfig;//公司信息
	private List<Object> url;//URL
	private List<Object> sam1;//手动采样
	private List<Object> sam2;//自动采样
	private List<Object> sam3;//报警采样
	private List<Object> sam4;//远程采样
	private List<Object> pollutants;//污染物汇总信息
	private List<Object> pollutantss;//WTW基本信息
	private List<Object> data;//实时监测数据


	private List<Object>currentSpeed;//流速
	private List<Object>traffic;//流量速率
	private List<Object>waterleve;//水位
	private List<Object>ph;//ph
	private List<Object>conductivity;//电导率
	private List<Object>sytime;//系统时间
	private List<Object>cod;//cod
	private List<Object>NH3N;//氨氮
	private List<Object>cr6;//生活给水总流量
	private List<Object>toc;//cod
	private List<Object>bod;//氨氮
	private List<Object>mlss;//生活给水总流量
	private List<Object>cr;//cod
	private List<Object>ni;//氨氮
	private List<Object>cd;//cod
	private List<Object>lead;//氨氮
	private List<Object>silver;//生活给水总流量
	private List<Object>hg;//cod
	private List<Object>phosphor;//氨氮
	private List<Object>cu;//cod
	private List<Object>zn;//氨氮
	private List<Object > data_name1;//曲线污染物显示拼接
	private List<Object>LossLimit;//限值
	private List<Object>unknown;//不明用水
	private List<Object>wastage;//耗损
	private List<Object>industrialdrainage;//工业给水总流量
	private List<Object>livingsupply;//工业排水总流量
	private List<Object>industrialsupply;//生活给水总流量
	
	private  List<Object> doo;//溶解氧
	private  List<Object>turbidity;//浊度
    private  List<Object>tn;//总氮
	private List<Object>tp;//总磷
	private List<Object>no3;//硝酸盐氮
	private List<Object>an;//阴离子表面活性剂
	private List<Object>phe;//挥发酚
    private List<Object>cn;//氰化物
	private List<Object>pb;//铅
	private List<Object>as;//砷
	private List<Object>fe;//铁
	private List<Object>mn;//锰
	private List<Object>f;//氟化物
	private List<Object>S;//硫化物
	private List<Object>poison;//水质综合毒性
	private List<Object>oc;//有机物水质
	private List<Object>temp;//水温
	private List<Object>flu;//氟化物
	
	
	private Object phLimit;
	private Object codLimit;
	private Object NH3NLimit;
	private Object cr6Limit;
	private Object tocLimit;
	private Object mlssLimit;
	private Object crLimit;
	private Object niLimit;
	private Object cdLimit;
	private Object cuLimit;
	private Object phosphorLimit;
	private Object znLimit;
	private Object tempLimit;
	private Object turbidityLimit;
	private Object doLimit;
	private Object fluLimit;
	
	private List<Object>supplyLiving;//生活给水总流量
	private List<Object>drainageIndustrial;//排水
	private List<Object>supplyIndustrial;
	
	private List<Object>nh4;//生活给水总流量
	private List<ViewData> ztraffics;//水平衡分析
	private List<List<Object>> lists;
	private List<ViewLog> log;//操作日志
	private List<ViewLineReport> waters;//水量历史
	private List<ViewdaliyReport> waterss;//水量报表
	private List<Pollutant> datass;//水质报表
	private List<Object>sytime2;
	
	public List<Object> getSytime2() {
		return sytime2;
	}
	public void setSytime2(List<Object> sytime2) {
		this.sytime2 = sytime2;
	}
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public MobileData() {
		super(ApiResultcode._0);
	}

	public MobileData(ApiResultcode rc) {
		super(rc);
	}
	
	public MobileData(ApiResultcode rc, String reason) {
		super(rc,reason);
	}

	public T getResult() {
		return result;
	} 
	public void setResult(T result) {
		this.result = result;
	}
	public List<Object> getWaterquality() {
		return waterquality;
	}
	public void setWaterquality(List<Object> waterquality) {
		this.waterquality = waterquality;
	}
	public List<Object> getZtraffic() {
		return ztraffic;
	}
	public void setZtraffic(List<Object> ztraffic) {
		this.ztraffic = ztraffic;
	}
	public List<Object> getZtraffic2() {
		return ztraffic2;
	}
	public void setZtraffic2(List<Object> ztraffic2) {
		this.ztraffic2 = ztraffic2;
	}
	public List<Object> getCompanyconfig() {
		return companyconfig;
	}
	public void setCompanyconfig(List<Object> companyconfig) {
		this.companyconfig = companyconfig;
	}
	public List<Object> getUrl() {
		return url;
	}
	public void setUrl(List<Object> url) {
		this.url = url;
	}
	public List<Object> getSam1() {
		return sam1;
	}
	public void setSam1(List<Object> sam1) {
		this.sam1 = sam1;
	}
	public List<Object> getSam2() {
		return sam2;
	}
	public void setSam2(List<Object> sam2) {
		this.sam2 = sam2;
	}
	public List<Object> getSam3() {
		return sam3;
	}
	public void setSam3(List<Object> sam3) {
		this.sam3 = sam3;
	}
	public List<Object> getSam4() {
		return sam4;
	}
	public void setSam4(List<Object> sam4) {
		this.sam4 = sam4;
	}
	public List<Object> getPollutants() {
		return pollutants;
	}
	public void setPollutants(List<Object> pollutants) {
		this.pollutants = pollutants;
	}
	public List<Object> getPollutantss() {
		return pollutantss;
	}
	public void setPollutantss(List<Object> pollutantss) {
		this.pollutantss = pollutantss;
	}
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	public List<List<Object>> getLists() {
		return lists;
	}
	public void setLists(List<List<Object>> lists) {
		this.lists = lists;
	}
	public List<Object> getCurrentSpeed() {
		return currentSpeed;
	}
	public void setCurrentSpeed(List<Object> currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	public List<Object> getTraffic() {
		return traffic;
	}
	public void setTraffic(List<Object> traffic) {
		this.traffic = traffic;
	}
	public List<Object> getWaterleve() {
		return waterleve;
	}
	public void setWaterleve(List<Object> waterleve) {
		this.waterleve = waterleve;
	}
	public List<Object> getPh() {
		return ph;
	}
	public void setPh(List<Object> ph) {
		this.ph = ph;
	}
	public List<Object> getConductivity() {
		return conductivity;
	}
	public void setConductivity(List<Object> conductivity) {
		this.conductivity = conductivity;
	}
	public List<Object> getSytime() {
		return sytime;
	}
	public void setSytime(List<Object> sytime) {
		this.sytime = sytime;
	}
	public List<Object> getCod() {
		return cod;
	}
	public void setCod(List<Object> cod) {
		this.cod = cod;
	}
	public List<Object> getNH3N() {
		return NH3N;
	}
	public void setNH3N(List<Object> nH3N) {
		NH3N = nH3N;
	}
	public List<Object> getCr6() {
		return cr6;
	}
	public void setCr6(List<Object> cr6) {
		this.cr6 = cr6;
	}
	public List<Object> getToc() {
		return toc;
	}
	public void setToc(List<Object> toc) {
		this.toc = toc;
	}
	public List<Object> getBod() {
		return bod;
	}
	public void setBod(List<Object> bod) {
		this.bod = bod;
	}
	public List<Object> getMlss() {
		return mlss;
	}
	public void setMlss(List<Object> mlss) {
		this.mlss = mlss;
	}
	public List<Object> getCr() {
		return cr;
	}
	public void setCr(List<Object> cr) {
		this.cr = cr;
	}
	public List<Object> getNi() {
		return ni;
	}
	public void setNi(List<Object> ni) {
		this.ni = ni;
	}
	public List<Object> getCd() {
		return cd;
	}
	public void setCd(List<Object> cd) {
		this.cd = cd;
	}
	public List<Object> getLead() {
		return lead;
	}
	public void setLead(List<Object> lead) {
		this.lead = lead;
	}
	public List<Object> getSilver() {
		return silver;
	}
	public void setSilver(List<Object> silver) {
		this.silver = silver;
	}
	public List<Object> getHg() {
		return hg;
	}
	public void setHg(List<Object> hg) {
		this.hg = hg;
	}
	public List<Object> getPhosphor() {
		return phosphor;
	}
	public void setPhosphor(List<Object> phosphor) {
		this.phosphor = phosphor;
	}
	public List<Object> getCu() {
		return cu;
	}
	public void setCu(List<Object> cu) {
		this.cu = cu;
	}
	public List<Object> getZn() {
		return zn;
	}
	public void setZn(List<Object> zn) {
		this.zn = zn;
	}
	public List<Object> getData_name1() {
		return data_name1;
	}
	public void setData_name1(List<Object> data_name1) {
		this.data_name1 = data_name1;
	}
	public List<Object> getLossLimit() {
		return LossLimit;
	}
	public void setLossLimit(List<Object> lossLimit) {
		LossLimit = lossLimit;
	}
	public List<Object> getUnknown() {
		return unknown;
	}
	public void setUnknown(List<Object> unknown) {
		this.unknown = unknown;
	}
	public List<Object> getWastage() {
		return wastage;
	}
	public void setWastage(List<Object> wastage) {
		this.wastage = wastage;
	}
	public List<Object> getIndustrialdrainage() {
		return industrialdrainage;
	}
	public void setIndustrialdrainage(List<Object> industrialdrainage) {
		this.industrialdrainage = industrialdrainage;
	}
	public List<Object> getLivingsupply() {
		return livingsupply;
	}
	public void setLivingsupply(List<Object> livingsupply) {
		this.livingsupply = livingsupply;
	}
	public List<Object> getIndustrialsupply() {
		return industrialsupply;
	}
	public void setIndustrialsupply(List<Object> industrialsupply) {
		this.industrialsupply = industrialsupply;
	}
	public List<Object> getNh4() {
		return nh4;
	}
	public void setNh4(List<Object> nh4) {
		this.nh4 = nh4;
	}
	public List<ViewData> getZtraffics() {
		return ztraffics;
	}
	public void setZtraffics(List<ViewData> ztraffics) {
		this.ztraffics = ztraffics;
	}
	public List<ViewLog> getLog() {
		return log;
	}
	public void setLog(List<ViewLog> log) {
		this.log = log;
	}
	public List<ViewLineReport> getWaters() {
		return waters;
	}
	public void setWaters(List<ViewLineReport> waters) {
		this.waters = waters;
	}
	public List<ViewdaliyReport> getWaterss() {
		return waterss;
	}
	public void setWaterss(List<ViewdaliyReport> waterss) {
		this.waterss = waterss;
	}
	public List<Pollutant> getDatass() {
		return datass;
	}
	public void setDatass(List<Pollutant> datass) {
		this.datass = datass;
	}
	public List<Object> getSupplyLiving() {
		return supplyLiving;
	}
	public void setSupplyLiving(List<Object> supplyLiving) {
		this.supplyLiving = supplyLiving;
	}
	public List<Object> getDrainageIndustrial() {
		return drainageIndustrial;
	}
	public void setDrainageIndustrial(List<Object> drainageIndustrial) {
		this.drainageIndustrial = drainageIndustrial;
	}
	public List<Object> getSupplyIndustrial() {
		return supplyIndustrial;
	}
	public void setSupplyIndustrial(List<Object> supplyIndustrial) {
		this.supplyIndustrial = supplyIndustrial;
	}
	public List<Object> getDoo() {
		return doo;
	}
	public void setDoo(List<Object> doo) {
		this.doo = doo;
	}
	public List<Object> getTurbidity() {
		return turbidity;
	}
	public void setTurbidity(List<Object> turbidity) {
		this.turbidity = turbidity;
	}
	public List<Object> getTn() {
		return tn;
	}
	public void setTn(List<Object> tn) {
		this.tn = tn;
	}
	public List<Object> getTp() {
		return tp;
	}
	public void setTp(List<Object> tp) {
		this.tp = tp;
	}
	public List<Object> getNo3() {
		return no3;
	}
	public void setNo3(List<Object> no3) {
		this.no3 = no3;
	}
	public List<Object> getAn() {
		return an;
	}
	public void setAn(List<Object> an) {
		this.an = an;
	}
	public List<Object> getPhe() {
		return phe;
	}
	public void setPhe(List<Object> phe) {
		this.phe = phe;
	}
	public List<Object> getCn() {
		return cn;
	}
	public void setCn(List<Object> cn) {
		this.cn = cn;
	}
	public List<Object> getPb() {
		return pb;
	}
	public void setPb(List<Object> pb) {
		this.pb = pb;
	}
	public List<Object> getAs() {
		return as;
	}
	public void setAs(List<Object> as) {
		this.as = as;
	}
	public List<Object> getFe() {
		return fe;
	}
	public void setFe(List<Object> fe) {
		this.fe = fe;
	}
	public List<Object> getMn() {
		return mn;
	}
	public void setMn(List<Object> mn) {
		this.mn = mn;
	}
	public List<Object> getF() {
		return f;
	}
	public void setF(List<Object> f) {
		this.f = f;
	}
	public List<Object> getS() {
		return S;
	}
	public void setS(List<Object> s) {
		S = s;
	}
	public List<Object> getPoison() {
		return poison;
	}
	public void setPoison(List<Object> poison) {
		this.poison = poison;
	}
	public List<Object> getOc() {
		return oc;
	}
	public void setOc(List<Object> oc) {
		this.oc = oc;
	}
	public Object getPhLimit() {
		return phLimit;
	}
	public void setPhLimit(Object phLimit) {
		this.phLimit = phLimit;
	}
	public Object getCodLimit() {
		return codLimit;
	}
	public void setCodLimit(Object codLimit) {
		this.codLimit = codLimit;
	}
	public Object getNH3NLimit() {
		return NH3NLimit;
	}
	public void setNH3NLimit(Object nH3NLimit) {
		NH3NLimit = nH3NLimit;
	}
	public Object getCr6Limit() {
		return cr6Limit;
	}
	public void setCr6Limit(Object cr6Limit) {
		this.cr6Limit = cr6Limit;
	}
	public Object getTocLimit() {
		return tocLimit;
	}
	public void setTocLimit(Object tocLimit) {
		this.tocLimit = tocLimit;
	}
	public Object getMlssLimit() {
		return mlssLimit;
	}
	public void setMlssLimit(Object mlssLimit) {
		this.mlssLimit = mlssLimit;
	}
	public Object getCrLimit() {
		return crLimit;
	}
	public void setCrLimit(Object crLimit) {
		this.crLimit = crLimit;
	}
	public Object getNiLimit() {
		return niLimit;
	}
	public void setNiLimit(Object niLimit) {
		this.niLimit = niLimit;
	}
	public Object getCdLimit() {
		return cdLimit;
	}
	public void setCdLimit(Object cdLimit) {
		this.cdLimit = cdLimit;
	}
	public Object getCuLimit() {
		return cuLimit;
	}
	public void setCuLimit(Object cuLimit) {
		this.cuLimit = cuLimit;
	}
	public Object getPhosphorLimit() {
		return phosphorLimit;
	}
	public void setPhosphorLimit(Object phosphorLimit) {
		this.phosphorLimit = phosphorLimit;
	}
	public Object getZnLimit() {
		return znLimit;
	}
	public void setZnLimit(Object znLimit) {
		this.znLimit = znLimit;
	}
	public Object getTempLimit() {
		return tempLimit;
	}
	public void setTempLimit(Object tempLimit) {
		this.tempLimit = tempLimit;
	}
	public Object getTurbidityLimit() {
		return turbidityLimit;
	}
	public void setTurbidityLimit(Object turbidityLimit) {
		this.turbidityLimit = turbidityLimit;
	}
	public Object getDoLimit() {
		return doLimit;
	}
	public void setDoLimit(Object doLimit) {
		this.doLimit = doLimit;
	}
	public List<Object> getTemp() {
		return temp;
	}
	public void setTemp(List<Object> temp) {
		this.temp = temp;
	}
	public List<Object> getFlu() {
		return flu;
	}
	public void setFlu(List<Object> flu) {
		this.flu = flu;
	}
	public Object getFluLimit() {
		return fluLimit;
	}
	public void setFluLimit(Object fluLimit) {
		this.fluLimit = fluLimit;
	}
	

}
