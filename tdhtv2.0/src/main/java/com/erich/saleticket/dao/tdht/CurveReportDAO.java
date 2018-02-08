package com.erich.saleticket.dao.tdht;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.erich.saleticket.model.tdht.CompanyInfo;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.Pollutant_Water;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewData;
import com.erich.saleticket.model.tdht.ViewLineReport;
import com.erich.saleticket.model.tdht.ViewZtraffic;

@DAO
public interface CurveReportDAO { 
	
	@SQL("select rid from tabpollType where 1=1 and id= 16  " )
			
	public Long selectByCriteria_test();
	
	/***
	 * 水环境sql
	 * @param data
	 * @return
	 */
	@SQL("select line.Id AS Id,line.Rid AS Rid, line . strTime  AS  strTime , line . syTime  AS  syTime , line . tabWaterLevel  AS  tabWaterLevelID1 , line . tabTraffic  AS  tabTrafficID1 , line . tabCurrentSpeed  AS  tabCurrentSpeedID1   from sourcemidtabindustrialdrainage as line,tabcompanyconfig as compan  " +
			"where 1=1 and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d') and compan.Rid=line.rid "+
			" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and line.strTime>'##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and line.strTime<'##(:1.endTime)' }"+
			" #if(!empty(:1.minates)){and minute(line.strTime)%'##(:1.minates)'=1 }"+
			" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
			"order by line.strTime  ")
	public List<ViewLineReport> selectByCriteria_water(ViewLineReport data);
	@SQL("select  *  from tabnewpollutant as line,tabcompanyconfig as compan  " +
			"where 1=1 and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d') and compan.Rid=line.rid "+
			" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and line.strTime>'##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and line.strTime<'##(:1.endTime)' }"+
			" #if(!empty(:1.minates)){and minute(line.strTime)%'##(:1.minates)'=1 }"+
			" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
			"order by line.strTime  ")
	public List<Pollutant_Water> selectByCriteria_waterph(ViewLineReport data);
//*************************************************************************************	
	
	
@SQL("select line.Id AS Id,line.Rid AS Rid, line . strTime  AS  strTime , line . syTime  AS  syTime , line . tabWaterLevel  AS  tabWaterLevel , line . tabTraffic  AS  tabTraffic , line . tabCurrentSpeed  AS  tabCurrentSpeed , line . tabZtraffic  AS  tabZtraffic  from ##(:1.viewName) as line,tabcompanyconfig as compan  " +
				"where 1=1 and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d %H:%i') and compan.Rid=line.rid "+
			" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTimeL)){ and line.syTime>='##(:1.startingTimeL)' }"+
			" #if(!empty(:1.endTimeL)){and line.syTime<='##(:1.endTimeL)' }"+
			" #if(!empty(:1.minates)){and line.syTime%'##(:1.minates)'=##(:1.remainder) }"+
			" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
			"order by line.strTime  ")
	public List<ViewLineReport> selectByCriteria(ViewLineReport data);




@SQL("select line.Id AS Id,line.Rid AS Rid, line . strTime  AS  strTime , line . syTime  AS  syTime , line . tabWaterLevel  AS  tabWaterLevel , line . tabTraffic  AS  tabTraffic , line . tabCurrentSpeed  AS  tabCurrentSpeed , line . tabZtraffic  AS  tabZtraffic  from ##(:1.viewName) as line,tabcompanyconfig as compan  " +
		"where 1=1 and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d %H:%i') and compan.Rid=line.rid "+
		" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
		" #if(!empty(:1.startingTimeL)){ and line.syTime>##(:1.startingTimeL) }"+
		" #if(!empty(:1.endTimeL)){and line.syTime<##(:1.endTimeL) }"+
		" #if(!empty(:1.minates)){and line.syTime%'##(:1.minates)'=##(:1.remainder)}"+
		" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
		"order by line.strTime  ")
public List<ViewLineReport> selectByCriteriaNew(ViewLineReport data);

@SQL("select *  from tabpollutant as line,tabcompanyconfig as compan    " +
		"where 1=1 and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d %H:%i') and compan.Rid=line.rid "+
		" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
		" #if(!empty(:1.startingTimeL)){ and line.syTime>= '##(:1.startingTimeL)%' }"+
		" #if(!empty(:1.endTimeL)){and line.syTime<= '##(:1.endTimeL)%' }"+
		" #if(!empty(:1.minates)){and minute(line.strTime)%'##(:1.minates)'=1 }"+
		" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
		"order by line.strTime  ")
public List<Pollutant> selectByCriteria_poll(ViewLineReport data);
@SQL("select *   from min_report_ph as line,tabcompanyconfig as compan    " +
		"where 1=1 and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d %H:%i') and compan.Rid=line.rid "+
		" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
		" #if(!empty(:1.startingTimeL)){ and line.syTime>= '##(:1.startingTimeL)' }"+
		" #if(!empty(:1.endTimeL)){and line.syTime<= '##(:1.endTimeL)' }"+
		" #if(!empty(:1.minates)){and line.syTime%'##(:1.minates)'=##(:1.remainder) }"+
		" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
		"order by line.strTime  ")
public List<Pollutant> selectByCriteria_ph(ViewLineReport data);
@SQL("select *   from min_report_ph as line,tabcompanyconfig as compan    " +
		"where 1=1 and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d %H:%i') and compan.Rid=line.rid "+
		" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
		" #if(!empty(:1.startingTimeL)){ and line.syTime>= ##(:1.startingTimeL) }"+
		" #if(!empty(:1.endTimeL)){and line.syTime<= ##(:1.endTimeL) }"+
		" #if(!empty(:1.minates)){and line.syTime%'##(:1.minates)'=##(:1.remainder) }"+
		" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
		"order by line.strTime  ")
public List<Pollutant> selectByCriteria_phnew(ViewLineReport data);

/*
@SQL("select *  from ##(:1.viewName) as line,tabcompanyconfig as compan " +
		"where 1=1 and line.strTime>=compan.stratTime and compan.Rid=line.rid "+
		" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
		" #if(!empty(:1.startingTime)){ and line.strTime>= '##(:1.startingTime)%' }"+
		" #if(!empty(:1.endTime)){and line.strTime<= '##(:1.endTime)%' }"+
		" #if(!empty(:1.minates)){and minute(line.strTime)%'##(:1.minates)'=1 }"+
		" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
		"order by line.strTime  ")
public List<ViewZtraffic> selectByCriteria2(ViewLineReport data);*/
@SQL("select `line`.`rid` AS `rid`,`line`.`strTime` AS `strTime`,`line`.`sytime` AS `sytime`,`line`.`industrialsupply` AS `industrialsupply`,`line`.`livingsupply` AS `livingsupply`,`line`.`industrialdrainage` AS `industrialdrainage`,`line`.`Losslimit` AS `Losslimit`,`line`.`wastage` AS `wastage`,`line`.`unknown` AS `unknown`   from daliy_6 as line ,tabcompanyconfig as compan  " +
		"where 1=1  and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d') and compan.Rid=line.rid    "+
		" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
		" #if(!empty(:1.startingTime)){ and line.strTime>= '##(:1.startingTime)%' }"+
		" #if(!empty(:1.endTime)){and line.strTime<= '##(:1.endTime)%' }"+
		" #if(!empty(:1.minates)){and minute(line.strTime)%'##(:1.minates)'=1 }"+
		" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
		"order by line.strTime  ")
public List<ViewZtraffic> selectByCriteria2(ViewLineReport data);
@SQL("select `line`.`rid` AS `rid`,`line`.`strTime` AS `strTime`,`line`.`sytime` AS `sytime`,`line`.`isztraffic` AS `industrialsupply`,`line`.`lsztraffic` AS `livingsupply`,`line`.`idztraffic` AS `industrialdrainage`,`line`.`totalLossLimit` AS `Losslimit`,`line`.`totalwastage` AS `wastage`,`line`.`totalunknow` AS `unknown`    from daliy_6 as line ,tabcompanyconfig as compan " +
		
		"where 1=1  and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d') and compan.Rid=line.rid  "+
		" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
		" #if(!empty(:1.startingTime)){ and line.strTime>= '##(:1.startingTime)%' }"+
		" #if(!empty(:1.endTime)){and line.strTime<= '##(:1.endTime)%' }"+
		" #if(!empty(:1.minates)){and minute(line.strTime)%'##(:1.minates)'=1 }"+
		" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
		"order by line.strTime  ")
public List<ViewZtraffic> selectByCriteriass(ViewLineReport data);

@SQL("select *  from ##(:1.viewName) as line,tabcompanyconfig as compan   " +
		"where 1=1 and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d') and compan.Rid=line.rid "+
		" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
		" #if(!empty(:1.startingTime)){ and line.strTime>= '##(:1.startingTime)%' }"+
		" #if(!empty(:1.endTime)){and line.strTime<= '##(:1.endTime)%' }"+
		" #if(!empty(:1.startingTimeL)){ and line.syTime>= '##(:1.startingTimeL)' }"+
		" #if(!empty(:1.endTimeL)){and line.syTime<= '##(:1.endTimeL)' }"+
		" #if(!empty(:1.minates)){and minute(line.strTime)%'##(:1.minates)'=0 }"+
		" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
		"order by line.strTime  ")
public List<Pollutant> selectByPollutant(Pollutant data);
	

/*
 * 查询各个公司污染物的种类*/
@SQL("select *  from tabpollType2   " +
		"where 1=1  and (ishave=1 or ishave=0)"+
		" #if(!empty(:1.rid)){ and rid= '##(:1.rid)' } ")
public List<Pollutant> selectByPollutant_name(Pollutant data);
/*
 * 查询各个公司污染物的种类*/
@SQL("select *  from tabpollType2   " +
		"where 1=1  and (ishave=1 or ishave=0) and (type_Poll=1 or type_poll=2 ) "+
		" #if(!empty(:1.rid)){ and rid= '##(:1.rid)' } ")
public List<Pollutant> selectByPollutant_Pollnames(Pollutant data);
/*
 * 查询各个公司污染物的种类*/
@SQL("select *  from tabpolltype2_cur   " +
		"where 1=1  and ishave=1 "+
		" #if(!empty(:1.rid)){ and rid= '##(:1.rid)' } ")
public List<Pollutant> selectByPollutant_Pollname_cur(Pollutant data);
/*
 * 查询各个公司污染物的种类*/
@SQL("select *  from tabpolltype2   " +
		"where 1=1  and ishave=1 "+
		" #if(!empty(:1.rid)){ and rid= '##(:1.rid)' } ")
public List<Pollutant> selectByPollutant_Pollname(Pollutant data);

/*
 * 查询各个公司污染物的种类*/
@SQL("select typeRemark  from pollutantconfig   ")
public List<Pollutant> selectByPollutant_Poll();
@SQL("select * from sys_company as sys " +
		"where 1=1"+
		" #if(!empty(:1.company_id)){ and sys.company_id= '##(:1.company_id)' }"
		)
 public CompanyInfo selectCompanyName(CompanyInfo com);

@SQL("select * from tabcompanyconfig as sys " +
		"where 1=1"+
		" #if(!empty(:1.company_id)){ and sys.rid= '##(:1.company_id)' }"
		)
 public ViewCompanyconfig selectCompanyName2(CompanyInfo com);
/***
 * 小时流量	
 */
@SQL(" select line.rid,line.strTime,line.syTime,line.tabZtrafficDS1  as   supplyLiving,line.tabZtrafficIS1 as  supplyIndustrial,line.tabZtrafficID1 as drainageIndustrial from min_report  as line,tabcompanyconfig as compan   " +
		"where 1=1 and line.strTime>=compan.stratTime and compan.Rid=line.rid "+
		" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
		" #if(!empty(:1.dateTypes)){and (DATE_FORMAT(strTime,'%Y-%m-%d')='##(:1.dateTypes)'}" +
		" #if(!empty(:1.startingTimeL)){ and (line.syTime>= '##(:1.startingTimeL)' }"+
		" #if(!empty(:1.endTimeL)){and line.syTime<= '##(:1.endTimeL)' }"+
		" #if(!empty(:1.Times)){ or strTime='##(:1.times)') }"+
		"group by hour(strTime),Day(strTime) order by strTime; ")
 public List<ViewZtraffic> selecthourztraffic(ViewLineReport data);
/***
 * 小时流量	
 */
@SQL(" select line.rid,line.strTime,line.syTime,line.tabZtraffic  as   ztraffic from ##(:1.viewName)  as line,tabcompanyconfig as compan   " +
		"where 1=1 and line.strTime>=compan.stratTime and compan.Rid=line.rid "+
		" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
		" #if(!empty(:1.dateTypes)){and (DATE_FORMAT(strTime,'%Y-%m-%d')='##(:1.dateTypes)'}" +
		" #if(!empty(:1.startingTimeL)){ and (line.syTime>= '##(:1.startingTimeL)' }"+
		" #if(!empty(:1.endTimeL)){and line.syTime<= '##(:1.endTimeL)' }"+
		" #if(!empty(:1.Times)){ or strTime='##(:1.times)') }"+
		"group by hour(strTime),Day(strTime) order by strTime; ")
 public List<ViewZtraffic> selecthourztraffics(ViewLineReport data);


/***
 * 小时污染物	
 */
@SQL("select line.rid,strTime,SUM(Cr) Cr,SUM(cr6) cr6,SUM(Ni) Ni,SUM(Cd) cd,SUM(lead) lead, " +
		"SUM(silver) silver,SUM(Hg) hg,SUM(bod) bod,SUM(cod) cod,SUM(cu) cu, " +
		"SUM(mlss) mlss,SUM(nh4) nh4,SUM(phosphor) phosphor,SUM(prussiate) prussiate, " +
		"SUM(toc) toc,SUM(Zn) Zn  from ##(:1.viewName) as line,pollStrTime as compan   " +
	"where 1=1 and line.strTime>=compan.pollStrTime and compan.Rid=line.rid "+
	" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
	" #if(!empty(:1.startingTimeL)){ and line.syTime>= '##(:1.startingTimeL)' }"+
	" #if(!empty(:1.endTimeL)){and line.syTime<= '##(:1.endTimeL)' }"+
	"group by hour(strTime) order by strTime asc ; ")
 public List<Pollutant> selecthourPollutant(Pollutant data);


/***
 * 天污染物	
 */
@SQL("select line.rid,strTime,SUM(Cr) Cr,SUM(cr6) cr6,SUM(Ni) Ni,SUM(Cd) cd,SUM(lead) lead, " +
		"SUM(silver) silver,SUM(Hg) hg,SUM(bod) bod,SUM(cod) cod,SUM(cu) cu, " +
		"SUM(mlss) mlss,SUM(nh4) nh4,SUM(phosphor) phosphor,SUM(prussiate) prussiate, " +
		"SUM(toc) toc,SUM(Zn) Zn  from ##(:1.viewName) as line,pollStrTime as compan   " +
	"where 1=1 and line.strTime>=compan.pollStrTime and compan.Rid=line.rid "+
	" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
	" #if(!empty(:1.startingTime)){and DATE_FORMAT(strTime,'%Y-%m-%d')>='##(:1.startingTime)'  }"+
	" #if(!empty(:1.endTime)){and DATE_FORMAT(strTime,'%Y-%m-%d')<='##(:1.endTime)'  }"+
	" #if(!empty(:1.startingTimeL)){ and line.syTime>= '##(:1.startingTimeL)' }"+
	" #if(!empty(:1.endTimeL)){and line.syTime<= '##(:1.endTimeL)' }"+
	" #if(!empty(:1.dateTypes)){and DATE_FORMAT(strTime,'%Y-%m')='##(:1.dateTypes)'  }"+
	"group by DATE_FORMAT(strTime,'%Y-%m-%d') order by strTime asc; ")
 public List<Pollutant> selecthourPollutant_day(Pollutant data);

/***
 * 月污染物	
 */
@SQL("select line.rid,strTime,SUM(Cr) Cr,SUM(cr6) cr6,SUM(Ni) Ni,SUM(Cd) cd,SUM(lead) lead, " +
		"SUM(silver) silver,SUM(Hg) hg,SUM(bod) bod,SUM(cod) cod,SUM(cu) cu, " +
		"SUM(mlss) mlss,SUM(nh4) nh4,SUM(phosphor) phosphor,SUM(prussiate) prussiate, " +
		"SUM(toc) toc,SUM(Zn) Zn  from ##(:1.viewName) as line,pollStrTime as compan   " +
	"where 1=1 and line.strTime>=compan.pollStrTime and compan.Rid=line.rid "+
	" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
	" #if(!empty(:1.startingTimeL)){ and line.syTime>= '##(:1.startingTimeL)' }"+
	" #if(!empty(:1.endTimeL)){and line.syTime<= '##(:1.endTimeL)' }"+
	"group by DATE_FORMAT(strTime,'%Y-%m'); ")
 public List<Pollutant> selecthourPollutant_month(Pollutant data);
}