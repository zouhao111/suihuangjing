package com.erich.saleticket.biz.tdht;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erich.saleticket.dao.tdht.DataDAO;
import com.erich.saleticket.dao.tdht.LogDAO;
import com.erich.saleticket.dao.tdht.PollutantDAO;
import com.erich.saleticket.model.tdht.KeyState;
import com.erich.saleticket.model.tdht.MapData;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.Pollutant_Water;
import com.erich.saleticket.model.tdht.SamplingRecord;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewData;
import com.erich.saleticket.model.tdht.ViewLog;
import com.erich.saleticket.model.tdht.ViewSampling;
import com.erich.saleticket.model.tdht.ViewTraffic;
import com.erich.saleticket.model.tdht.ViewWaterquality;
import com.erich.saleticket.model.tdht.ViewZtraffic;
import com.erich.saleticket.model.tdht.ViewfirstTab;

@Service
public class DataBiz {

	@Resource
	private DataDAO dataDAO;
	@Resource
	private PollutantDAO pollutantDAO;
	@Resource
	private LogDAO logDAO;
	
	
	
	
	
	
	//相关数据库写入操作日志
	public void Insertlog(ViewLog Log){
		dataDAO.InsertLog(Log);
	}
	
	
	
	public void InsertSampling(int i,SamplingRecord sam){
		dataDAO.InsertSampling(i, sam);
	}
	
	public List<ViewSampling> selectBySampling(Long rid){
		return dataDAO.selectBySampling(rid);
	}
	
	public List<ViewTraffic> selectByTraffic(Long rid){
		return dataDAO.selectByTraffic(rid);
	}
	public ViewfirstTab selectFirstTab(Long rid){
		return  dataDAO.selectFirstTab(rid);
	}
	public ViewfirstTab selectFirstTab3(Long rid){
		return  dataDAO.selectFirstTab3(rid);
	}
	//查询昨日流量
	public ViewfirstTab selectFirstTab2(Long rid){
		return  dataDAO.selectFirstTab2(rid);
	}
	//查询当天流量
	public ViewfirstTab selectFirstTab_id(Long rid){
		return  dataDAO.selectFirstTab_id(rid);
	}
	//查询当天流量
	public ViewfirstTab selectFirstTab_is(Long rid){
		return  dataDAO.selectFirstTab_is(rid);
	}
	//查询当天流量
	public ViewfirstTab selectFirstTab_ls(Long rid){
		return  dataDAO.selectFirstTab_ls(rid);
	}
	
	public List<ViewWaterquality> selectByWaterquality1(Long rid){
		return dataDAO.selectByWaterquality1(rid);
	}
	
	public List<ViewZtraffic> selectByztraffic1(Long rid){
		return dataDAO.selectByztraffic1(rid);
	}
	public List<ViewData> selectByState(Long rid){
		return dataDAO.selectByState(rid);
	}
	
	//板子的状态
	public List<KeyState> selectByState2(Long rid){
		return dataDAO.selectByState2(rid);
	}
	
	
	
	public List<ViewCompanyconfig> selectBycompanyconfig2s(ViewCompanyconfig viewCompanyconfig){
		return dataDAO.selectBycompanyconfig2s(viewCompanyconfig);
	}
	public List<ViewCompanyconfig> selectBycompanyconfig2sa(ViewCompanyconfig viewCompanyconfig){
		return dataDAO.selectBycompanyconfig2sa(viewCompanyconfig);
	}
	public List<ViewCompanyconfig> selectBycompanyconfig2ss(ViewCompanyconfig viewCompanyconfig){
		return dataDAO.selectBycompanyconfig2ss(viewCompanyconfig);
	}
	
	public List<ViewCompanyconfig> selectBycompanyconfig2(ViewCompanyconfig viewCompanyconfig){
		return dataDAO.selectBycompanyconfig2(viewCompanyconfig);
	}
	
	public ViewWaterquality selectByWaterquality(Long rid){
		return  dataDAO.selectByWaterquality(rid);
	}
	
	public ViewZtraffic selectByztraffic(Long rid){
		return dataDAO.selectByztraffic(rid);
	}
	/*
	 * 水环境
	 */
	public ViewfirstTab selectByztraffic_water(Long rid){
		return dataDAO.selectByztraffic_water(rid);
	}
	
	/*
	 *新 水环境没有最大最小值的
	 */
	public Pollutant_Water selectByNewWaterquality(Long rid){
		return dataDAO.selectByNewWaterquality(rid);
	}
	
	public List<ViewWaterquality> selectByWaterquality(){
		return dataDAO.selectByWaterquality();
	}
	public List<Pollutant> selectByWaterquality2(){
		return dataDAO.selectByWaterquality2();
	}
	public List<ViewZtraffic> selectByztraffic(){
		return dataDAO.selectByztraffic();
	}
	public List<ViewCompanyconfig> selectBycompanyconfig1(ViewCompanyconfig viewCompanyconfig){
		return dataDAO.selectBycompanyconfig1(viewCompanyconfig);
	}
	
	//相关数据库写入操作日志
	
	
	
	public ViewZtraffic selectBycoeffiztraffic(Long rid){
		return dataDAO.selectBycoeffiztraffic(rid);
	}
	
	public ViewCompanyconfig selectBycompanyconfig(ViewCompanyconfig viewCompanyconfig){
		return dataDAO.selectBycompanyconfig(viewCompanyconfig);
	}
	
	public ViewCompanyconfig selectBycompanyconfig_water(ViewCompanyconfig viewCompanyconfig){
		return dataDAO.selectBycompanyconfig_water(viewCompanyconfig);
	}
	
	
	public List<ViewCompanyconfig> selectBycompanyconfigone(ViewCompanyconfig viewCompanyconfig){
		return dataDAO.selectBycompanyconfigone(viewCompanyconfig);
	}
	
	public List<KeyState> selectByMapState(){
		return dataDAO.selectByMapState();
	}
	
	
	public ViewfirstTab selectByCriteria(Long rid){
		return dataDAO.selectByCriteria(rid);
	}
	public MapData selectByCriteriaPH(Long rid){
		return dataDAO.selectByCriteriaPH(rid);
	}
	
	public List<ViewTraffic> selectByCriteriaODK(ViewTraffic data){
		return dataDAO.selectByCriteriaODK(data);
	}
	

	public  Pollutant selectByPollutant2(Long rid){
		return pollutantDAO.selectByPollutant2(rid);
	}
	public  Pollutant selectByPollutant2_sum(Long rid){
		return pollutantDAO.selectByPollutant2_sum(rid);
	}
	public  Pollutant selectByPollutant3(Long rid){
		return pollutantDAO.selectByPollutant3(rid);
	}
	/*public  Pollutant_Water selectByPollutant_water(Long rid){
		return pollutantDAO.selectByPollutant_water(rid);
	}*/
	
	
	public List<MapData> selectByCriteriaAllPH(){
		return dataDAO.selectByCriteriaAllPH();
	}
	

public List<Pollutant> selectByPollutant_names(Long rid){
		return  dataDAO.selectByPollutant_names(rid);

	}

//查询污染物时间
public  ViewCompanyconfig selectByPollutant_Time(Long rid){
	return  dataDAO.selectByPollutant_Time(rid);

}
//查询污染物时间的流量
public   ViewData selectByPollSour(Long rid,Date StrTime){
	return  dataDAO.selectByPollSour(rid,StrTime);

}

//查询15个公司的有的污染物或者流量
public List<Integer> selectcomType(Long rid){
	 return dataDAO.selectcomType(rid);
} 
	/***
	 * 查询离线最新一条数据
	 */
	public List<KeyState> selectkeyState(Long rid){
		return dataDAO.selectkeyState(rid);
	}
	public KeyState selectkeyState1(Long rid,int type){
		return dataDAO.selectkeyState1(rid,type);
	}
	
	 public List<ViewLog>  selectByCriteriaData(Long rid){
		 return logDAO.selectByCriteriaData(rid);
	 }
	
	 public List<MapData> selectMapAll(MapData data){
		 return dataDAO.selectMapAll(data);
	 }
	
}
