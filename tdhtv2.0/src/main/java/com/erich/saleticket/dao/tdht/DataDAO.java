package com.erich.saleticket.dao.tdht;

import java.util.Date;
import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

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

@DAO
public interface DataDAO {
	
	/**
	 * 查询实时数据最新的一条a1.a2.a3表
	 */
	@SQL("select * from first_tab where 1=1" +
			"#if(!empty(:1)){ and first_tab.Rid='##(:1)' }")
	public ViewfirstTab selectByCriteria(Long rid);
	@SQL(" select rid,a1 as industrialdrainage,a2 as livingsupply,a3 as industrialsupply from ztrafficusub_total_4 where 1=1 #if(!empty(:1)){ and Rid= '##(:1)' }  order by Time desc limit 1 " )

	public ViewfirstTab selectFirstTab2(Long rid);
	
	@SQL(" select * from ta_sub_id_lc viewws where 1=1 #if(!empty(:1)){ and viewws.Rid= '##(:1)' }  " )

	public ViewfirstTab selectFirstTab_id(Long rid);
	@SQL(" select * from ta_sub_is_lc viewws where 1=1 #if(!empty(:1)){ and viewws.Rid= '##(:1)' }  " )

	public ViewfirstTab selectFirstTab_is(Long rid);
	@SQL(" select * from ta_sub_ls_lc viewws where 1=1 #if(!empty(:1)){ and viewws.Rid= '##(:1)' }  " )

	public ViewfirstTab selectFirstTab_ls(Long rid);
	/**
	 * 查询实时数据最新的一条表
	 */
	@SQL("select realPH,tabcompanyconfig.companyName from midtabwaterquality,tabcompanyconfig where 1=1" +
			"#if(!empty(:1)){ and midtabwaterquality.Rid='##(:1)' } "+
			"and tabcompanyconfig.Rid=midtabwaterquality.Rid "+
			" order by sytime desc limit 1")
	public MapData selectByCriteriaPH(Long rid);
	
	
	 
	@SQL("select tabph.strTime,tabph.realPh,tabph.rid,tabCOD.realCod from midtabwaterquality as tabph,first_totalPollutant as tabCOD  " +
			" where tabph.Rid=tabCOD.rid and tabph.sytime=(select max(sytime) from midtabwaterquality  )  group by tabph.Rid")
	public List<MapData> selectByCriteriaAllPH();
	

	
	/*
	 * 根据公司ID查询写采样
	 */
	@SQL("insert INTO webSam (rid,companyName,value) VALUES(:2.rid , :2.companyName,:1 ) ")
	public void InsertSampling(int i,SamplingRecord sam);
	
	
	/*
	 * 根据用户名写操作日志
	 */
	@SQL("INSERT into tabloginstate(operationRid,userIp,operationtype,operationvalue,userName,updataTime)  " +
			"values(:1.operationRid , :1.userIp,:1.operationtype,:1.operationvalue , :1.userName,:1.strTime) ")
	public void InsertLog(ViewLog Log);
	
	
	
	
	
	/*
	 * 根据公司ID查询水质采样
	 * 
select * from (
select * from midtabsampling  where rid='75501330004'ORDER BY mtime)a  GROUP BY samplingMode
	 */
	@SQL("select * from (select * from midtabsampling as midt  where 1=1 #if(!empty(:1)){ and midt.Rid= '##(:1)' } ORDER BY midt.mtime) a GROUP BY a.samplingMode")
	public List<ViewSampling> selectBySampling(Long rid);

	
	
	/*
	 * 根据公司ID查询流量监测数据
	 */
	
	@SQL(" select * from midtabtraffic viewws where 1=1 #if(!empty(:1)){ and viewws.Rid= '##(:1)' }  GROUP BY dateType ORDER BY sytime  desc " )

	public List<ViewTraffic> selectByTraffic(Long rid);
	
	@SQL(" select * from first_tab2 viewws where 1=1 #if(!empty(:1)){ and viewws.Rid= '##(:1)' }   " )

	public ViewfirstTab selectFirstTab(Long rid);
	@SQL(" select * from first_tab4 viewws where 1=1 #if(!empty(:1)){ and viewws.Rid= '##(:1)' }   " )

	public ViewfirstTab selectFirstTab3(Long rid);
	
	/*
	 * 根据公司ID查询水质监测
	 */
	@SQL("select * from midtabwaterquality as viewws" +
			" where 1=1 " +
			" #if(!empty(:1)){ and viewws.Rid= '##(:1)' } "+
			"  order by sytime desc limit 1")
	public List<ViewWaterquality> selectByWaterquality1(Long rid);
	/*
	 * 根据公司ID查询流量汇总
	 */
	@SQL("select * from midtabtotalztraffic as viewws" +
			" where 1=1 " +
			" #if(!empty(:1)){ and viewws.Rid= '##(:1)' } "+
			"  order by sytime desc limit 1")
	public List<ViewZtraffic> selectByztraffic1(Long rid);
	
	
	
	/*
	 * 查询所有公司的温度湿度
	 * select * from midtabindustrialdrainage m,(
select rid ,MAX(syTime)syTime from midtabindustrialdrainage GROUP BY rid )r
where m.Rid=r.rid and m.syTime=r.syTime GROUP BY r.rid
	 */
	@SQL("select *from sourcemidtabindustrialdrainage   " +
			" where  syTime=(select max(syTime)from sourcemidtabindustrialdrainage) GROUP BY rid desc")
	public List<ViewData> selectByState(Long rid);
	@SQL("select * from tabcompanyconfig_copy t,(select rid  from sourcemidtabindustrialdrainage" +
	" group by rid)s where t.Rid=s.rid group by t.rid desc  ")
public List<ViewCompanyconfig> selectBycompanyconfig2(ViewCompanyconfig viewCompanyconfig);
	@SQL("select * from tabcompanyconfig_copy t where 1=1" +
			" #if(!empty(:1)){ and t.waterType= ##(:1.waterType) } "+
			"  group by t.rid desc  ")
		public List<ViewCompanyconfig> selectBycompanyconfig2s(ViewCompanyconfig viewCompanyconfig);
	
	@SQL("select * from tabcompanyconfig_copy t,(select rid  from sourcemidtabindustrialdrainage" +
			" group by rid)s where 1=1" +
			
			" and t.Rid=s.rid group by t.rid desc  ")
		public List<ViewCompanyconfig> selectBycompanyconfig2sa(ViewCompanyconfig viewCompanyconfig);
	@SQL("select * from tabcompanyconfig_copy t,(select rid  from sourcemidtabindustrialdrainage" +
			" group by rid)s where 1=1" +
			" #if(!empty(:1)){ and t.waterType>0 } "+
			" and t.Rid=s.rid group by t.rid desc  ")
		public List<ViewCompanyconfig> selectBycompanyconfig2ss(ViewCompanyconfig viewCompanyconfig);
	
	/**
	 * 查询板子状态
	 * @param rid
	 * @return
	 */
	@SQL("select * from tabmidonline   " +
			" where  syTime=(select max(syTime) from tabmidonline)   GROUP BY rid ,type ")
	public List<KeyState> selectByState2(Long rid);
	
	/**
	 * 地图气泡状态颜色查询
	 * @param rid
	 * @return
	 */
	@SQL("select R.Rid,R.bitOnline,C.lat,C.lon,C.companyName from tabmidonline R,tabcompanyconfig C " +
			"where R.syTime=(select max(syTime) from tabmidonline ) and R.Rid=C.Rid and type=1  GROUP BY R.rid")
	public List<KeyState> selectByMapState();
	
	
	
	
	
	
	/*
	 * 根据公司ID查询水质监测
	 */
	@SQL("select * from midtabwaterquality as viewws" +
			" where 1=1 " +
			" #if(!empty(:1)){ and viewws.Rid= '##(:1)' } "+
			"  order by sytime desc limit 1")
	public ViewWaterquality selectByWaterquality(Long rid);
	/*
	 * 根据公司ID查询流量汇总   
	 */
	@SQL("select * from midrealtabtotalztraffic as viewws" +
			" where 1=1 " +
			" #if(!empty(:1)){ and viewws.Rid= '##(:1)' } "+
			"  order by sytime desc limit 1")
	public ViewZtraffic selectByztraffic(Long rid);
	/*
	 * 水环境
	 */
	@SQL("select viewws.Id AS Id,viewws.Rid AS Rid,viewws.strTime AS strTime,viewws.syTime AS syTime,viewws.tabWaterLevel AS waterlevel,viewws.tabTraffic AS id_Traffic,viewws.tabCurrentSpeed AS id_CurrentSpeed, viewws.tabZtraffic as id_ztraffic from sourcemidtabindustrialdrainage  as viewws" +
			" where 1=1 " +
			" #if(!empty(:1)){ and viewws.Rid= '##(:1)' } "+
			"  order by sytime desc limit 1")
	public ViewfirstTab selectByztraffic_water(Long rid);
	
	/*
	 *水环境的根据公司ID查询水质监测
	 */
	@SQL("select * from tabnewpollutant as viewws" +
			" where 1=1 " +
			" #if(!empty(:1)){ and viewws.Rid= '##(:1)' } "+
			"  order by sytime desc limit 1")
	public Pollutant_Water selectByNewWaterquality(Long rid);
	

	
	@SQL("select viewws.Id AS Id,viewws.Rid AS Rid,viewws.strTime AS strTime,viewws.syTime AS syTime,viewws.tabPh AS realPh,viewws.tabcod AS realcod,viewws.tabnh3n AS realnh3n,viewws.tabcr6 AS realcr6,viewws.tabconductivity AS realconductivity from sourcemidtabindustrialdrainage  from midtabwaterquality as viewws " +
			" where 1=1 " +
			" #if(!empty(:1)){ and viewws.Rid= '##(:1)' } "+
			"  order by sytime desc limit 1")
	public ViewWaterquality selectByWaterquality_water(Long rid);
	
	
	
	
	@SQL("select * from tabcompanyconfig t,(select rid  from midtabwaterquality" +
			" group by rid)s where t.Rid=s.rid group by t.rid asc  ")
	public List<ViewCompanyconfig> selectBycompanyconfig1(ViewCompanyconfig viewCompanyconfig);
	
	/*
	 * 根据查询所有公司水质监测
	 */
	@SQL("select *from midtabwaterquality  " +
	" where syTime=(select max(syTime) from midtabwaterquality ) GROUP BY rid asc")
	public List<ViewWaterquality> selectByWaterquality();
	
	@SQL("select *from tabpollutant  " +
	" where syTime=(select max(syTime) from tabpollutant ) GROUP BY rid asc")
	public List<Pollutant> selectByWaterquality2();
	/*
	 * 根据查询所有公司流量汇总midtabtotalztraffic
	 */
	@SQL("select first_tab.Rid AS Rid,first_tab.strTime AS strTime," +
			"first_tab.sytime AS sytime,first_tab.id_ztraffic AS drainageIndustrial," +
			"first_tab.ls_ztraffic AS supplyLiving,first_tab.is_ztraffic AS supplyIndustrial from first_tab " +
			
			"  GROUP BY first_tab.Rid asc")
	public List<ViewZtraffic> selectByztraffic();
	
	
	
	
	/*
	 * 根据公司ID查询流量系数
	 */
	@SQL("select * from midtabtotalcoeffiztraffic as viewws" +
			" where 1=1 " +
			" #if(!empty(:1)){ and viewws.Rid= '##(:1)' } "+
			"  order by sytime desc limit 1")
	public ViewZtraffic selectBycoeffiztraffic(Long rid);
	
	/*
	 * 根据公司ID查询公司信息
	 */
	
	

	@SQL("select * from tabcompanyconfig_copy as viewws" +
			" where 1=1  " +
			" #if(!empty(:1.rid)){ and viewws.Rid like '##(:1.rid)%' } "+
			" #if(!empty(:1.companyName)){ and viewws.companyName like '##(:1.companyName)%' } ")
	public ViewCompanyconfig selectBycompanyconfig(ViewCompanyconfig viewCompanyconfig);
	@SQL("select * from tabcompanyconfig_copy as viewws" +
			" where waterType=2  " +
			" #if(!empty(:1.rid)){ and viewws.Rid like '##(:1.rid)%' } "+
			" #if(!empty(:1.companyName)){ and viewws.companyName like '##(:1.companyName)%' } ")
	public ViewCompanyconfig selectBycompanyconfig_water(ViewCompanyconfig viewCompanyconfig);
	
	
	/*一个公司查询*/
	@SQL("select * from tabcompanyconfig as viewws" +
			" where 1=1 " +
			" #if(!empty(:1.rid)){ and viewws.Rid= '##(:1.rid)' } "+
			" #if(!empty(:1.companyName)){ and viewws.companyName like '##(:1.companyName)%' } ")
	public List<ViewCompanyconfig> selectBycompanyconfigone(ViewCompanyconfig viewCompanyconfig);
	/**
	 * 欧达可查询实时数据最新的一条odk_a1,odk_a2,odk_a3表
	 */
	@SQL("select * from "+
 "(select  o1.id,o1.datatime,o1.traffic,o1.ph,o1.waterlevel,o1.CurrentSpeed,o1.Temperature,o1.Humidity,o1.Voltage,o1.ztraffic,o1.`key`,o1.cod,o1.warning,o1.strTime,o1.keystate  from odk_a1 as o1 order by   o1.strTime desc limit 1) t1 "+
"union all "+
"select * from (select  o2.id,o2.datatime,o2.traffic,o2.ph,o2.waterlevel,o2.CurrentSpeed,o2.Temperature,o2.Humidity,o2.Voltage,o2.ztraffic,o2.`key`,o2.cod,o2.warning,o2.strTime,o2.keystate  from odk_a2 as o2 order by   o2.strTime desc limit 1) t2 "+ 
"union all "+
"select * from (select  o3.id,o3.datatime,o3.traffic,o3.ph,o3.waterlevel,o3.CurrentSpeed,o3.Temperature,o3.Humidity,o3.Voltage,o3.ztraffic,o3.`key`,o3.cod,o3.warning,o3.strTime,o3.keystate  from odk_a3 as o3 order by   o3.strTime desc limit 1) t3")
	public List<ViewTraffic> selectByCriteriaODK(ViewTraffic data);
	
	/**
	 * 查询最新一条离线时间
	 */
	@SQL("select * from tabmidonline" +
			" where syTime=(select MAX(sytime) from tabmidonline) " +
			" #if(!empty(:1)){ and rid= '##(:1)' } "+
			"  GROUP BY type")
	public List<KeyState> selectkeyState(Long rid);
	
	@SQL("select * from tabmidonline where syTime>( select sytime from tabmidonline" +
			" where  bitOnline=0" +
			" #if(!empty(:1)){ and rid= '##(:1)' } "+
			"  #if(!empty(:2)){ and type= '##(:2)' } ORDER BY syTime desc limit 1)and  type= '##(:2)' and rid= '##(:1)' ORDER BY syTime asc limit 1")
	public KeyState selectkeyState1(Long rid,int type);
	
	/**
	 * 地图查询所有公司最新数据
	 */
	@SQL("SELECT sour.tabPh,sour.tabWaterLevel,sour.tabTraffic,sour.tabCurrentSpeed,sour.tabZtraffic,sour.strTime,sour.Rid,company.companyName,company.lat,company.lon  " +
			" from sourcemidtabindustrialdrainage as sour ,tabcompanyconfig_copy as company " +
			"  where 1=1 and sour.rid=company.Rid  "+
			" #if(!empty(:1.waterType)){ and company.waterType >= '##(:1.waterType)' } "+
			" and  sour.syTime=(select max(syTime) from sourcemidtabindustrialdrainage) GROUP BY sour.rid ")
	public List<MapData> selectMapAll(MapData data);
	

/*
	 * 查询各个公司污染物的种类*/
	@SQL("select *  from tabpollType2  " +
			"where 1=1 and (ishave=1 or ishave=0)"+
			" #if(!empty(:1)){ and rid= '##(:1)' } ")
	public List<Pollutant> selectByPollutant_names(Long rid);
	
	
	@SQL("select *  from PollStrTime  " +
			"where 1=1 "+
			" #if(!empty(:1)){ and rid= '##(:1)' } ")
	public ViewCompanyconfig selectByPollutant_Time(Long rid);
	
	@SQL("select *from sourcemidtabindustrialdrainage   " +
			" where  strTime='##(:2)' and rid= '##(:1)' ")
	public ViewData selectByPollSour(Long rid,Date StrTime);
	
	
	
	/**
	 * 地图查询所有公司最新数据
	 */
	@SQL("select haveType from syscomtype where 1=1" +
			" #if(!empty(:1)){ and rid= '##(:1)' }  ")
	public List<Integer> selectcomType(Long rid);
}