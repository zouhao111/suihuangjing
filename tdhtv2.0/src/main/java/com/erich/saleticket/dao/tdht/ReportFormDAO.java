package com.erich.saleticket.dao.tdht;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.tdht.BalanceComfig;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.Pollutant_Water;
import com.erich.saleticket.model.tdht.ViewData;
import com.erich.saleticket.model.tdht.ViewLineReport;
import com.erich.saleticket.model.tdht.ViewdaliyReport;

@DAO
public interface ReportFormDAO {
	
	/**
	 *永艺发统计报表   日报表的水质
	 */
	@SQL("INSERT INTO sysridcomfig(qStTime,nowTime,intNowTime,rid)  " +
			"values(:1.qStTime , now(),TIMESTAMPDIFF(MINUTE,'1970-1-1',NOW()),:1.rid ) ") 
			
	public int insertBalanceTime(BalanceComfig comfig);
	
	/**
	 *永艺发统计报表   日报表的水质
	 */
	@SQL("select `report`.`rid` AS `rid`,`report`.`strTime` AS `strTime`,`report`.`sytime` AS `sytime`,`report`.`industrialsupply` AS `industrialsupply`,`report`.`livingsupply` AS `livingsupply`,`report`.`industrialdrainage` AS `industrialdrainage`,`report`.`Losslimit` AS `Losslimit`,`report`.`wastage` AS `wastage`,`report`.`unknown` AS `unknown`  from ##(:1.viewName) as report ,tabcompanyconfig c  " +
			"where 1=1 and strTime>=DATE_FORMAT(c.stratTime,'%Y-%m-%d') and report.rid=c.rid"+
			" #if(!empty(:1.rid)){ and report.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and report.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and report.strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and report.strTime like '##(:1.dateTypes)%' }"+
			" order by report.strTime  limit :2.pageOffset, :2.pageSize ")
	public List<ViewdaliyReport> selectByCriteria(ViewdaliyReport data,Pager pager);
	
	/**
	 *导pdf数据
	 */
	@SQL("select `report`.`rid` AS `rid`,`report`.`strTime` AS `strTime`,`report`.`sytime` AS `sytime`,`report`.`industrialsupply` AS `industrialsupply`,`report`.`livingsupply` AS `livingsupply`,`report`.`industrialdrainage` AS `industrialdrainage`,`report`.`Losslimit` AS `Losslimit`,`report`.`wastage` AS `wastage`,`report`.`unknown` AS `unknown`  from ##(:1.viewName) as report ,tabcompanyconfig c  " +
			"where 1=1 and strTime>=DATE_FORMAT(c.stratTime,'%Y-%m-%d') and report.rid=c.rid"+
			" #if(!empty(:1.rid)){ and report.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and report.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and report.strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and report.strTime like '##(:1.dateTypes)%' }"+
			" order by report.strTime  ")
	public List<ViewdaliyReport> selectByCriteria2(ViewdaliyReport data);
	
	
	@SQL("select *  from daily_report3 as report ,tabcompanyconfig c " +
			"where 1=1"+
			" #if(!empty(:1.rid)){ and report.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and report.strTime>= '##(:1.startingTime)%' }"+
			" #if(!empty(:1.endTime)){and report.strTime<= '##(:1.endTime)%' }"+
			" #if(!empty(:1.dateTypes)){and report.strTime like '##(:1.dateTypes)%' }"+
			"and strTime>=DATE_FORMAT(c.stratTime,'%Y-%m-%d') and report.rid=c.rid order by report.strTime  limit :2.pageOffset, :2.pageSize ")
	public List<Pollutant> selectByCriterias(ViewdaliyReport data,Pager pager);
	@SQL("select *  from daily_report3 as report ,tabcompanyconfig c " +
			"where 1=1"+
			" #if(!empty(:1.rid)){ and report.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and report.strTime>= '##(:1.startingTime)%' }"+
			" #if(!empty(:1.endTime)){and report.strTime<= '##(:1.endTime)%' }"+
			" #if(!empty(:1.dateTypes)){and report.strTime like '##(:1.dateTypes)%' }"+
			"and strTime>=DATE_FORMAT(c.stratTime,'%Y-%m-%d') and report.rid=c.rid order by report.strTime  ")
	public List<Pollutant> selectByCriteriass_pdf(ViewdaliyReport data,Pager pager);
	
	
	
	@SQL("select *  from ##(:1.viewName) as report ,tabcompanyconfig c " +
			"where 1=1"+
			" #if(!empty(:1.rid)){ and report.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and report.strTime>= '##(:1.startingTime)%' }"+
			" #if(!empty(:1.endTime)){and report.strTime<= '##(:1.endTime)%' }"+
			" #if(!empty(:1.dateTypes)){and report.strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.minates)){and report.syTime%'##(:1.minates)'=##(:1.remainder)  }"+
			"and strTime>=c.stratTime and report.rid=c.rid order by report.strTime  limit :2.pageOffset, :2.pageSize ")
	
	public List<ViewLineReport> selectByCriteria2(ViewdaliyReport data,Pager pager);
	/*
	 * 水环境
	 */
	@SQL("select report.Id AS Id,report.Rid AS Rid, report . strTime  AS  strTime , report . syTime  AS  syTime , report . tabWaterLevel  AS  tabWaterLevelID1 , report . tabTraffic  AS  tabTrafficID1 , report . tabCurrentSpeed  AS  tabCurrentSpeedID1 ,report.tabZtraffic as tabZtrafficID1  from sourcemidtabindustrialdrainage as report ,tabcompanyconfig c " +
			"where 1=1"+
			" #if(!empty(:1.rid)){ and report.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and report.strTime>= '##(:1.startingTime)%' }"+
			" #if(!empty(:1.endTime)){and report.strTime<= '##(:1.endTime)%' }"+
			" #if(!empty(:1.dateTypes)){and report.strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.minates)){and report.syTime%'##(:1.minates)'=##(:1.remainder) }"+
			"and strTime>=c.stratTime and report.rid=c.rid order by report.strTime  limit :2.pageOffset, :2.pageSize ")
	
	public List<ViewLineReport> selectByCriteria2_water(ViewdaliyReport data,Pager pager);
	
	
	@SQL("select *  from ##(:1.viewName) as report ,tabcompanyconfig c " +
			"where 1=1"+
			" #if(!empty(:1.rid)){ and report.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and report.strTime>= '##(:1.startingTime)%' }"+
			" #if(!empty(:1.endTime)){and report.strTime<= '##(:1.endTime)%' }"+
			" #if(!empty(:1.dateTypes)){and report.strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.minates)){and report.syTime%'##(:1.minates)'=##(:1.remainder) }"+
			"and strTime>=c.stratTime and report.rid=c.rid order by report.strTime ")
	
	public List<ViewLineReport> selectByCriteria_pdf(ViewdaliyReport data);
	
	@SQL("select  *  from tabnewpollutant as line,tabcompanyconfig as compan  " +
			"where 1=1 and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d') and compan.Rid=line.rid "+
			" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and line.strTime>'##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and line.strTime<'##(:1.endTime)' }"+
			" #if(!empty(:1.minates)){and  line.syTime%'##(:1.minates)'=##(:1.remainder)  }"+
			" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
			"order by line.strTime   limit :2.pageOffset, :2.pageSize ")
	
	
	public List<Pollutant_Water> selectByCriteria_water(ViewdaliyReport data,Pager pager);
	
	@SQL("select  *  from tabnewpollutant as line,tabcompanyconfig as compan  " +
			"where 1=1 and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d') and compan.Rid=line.rid "+
			" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and line.strTime>'##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and line.strTime<'##(:1.endTime)' }"+
			" #if(!empty(:1.minates)){and minute(line.strTime)%'##(:1.minates)'=1 }"+
			" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
			"order by line.strTime   ")
	
	
	public List<Pollutant_Water> selectByCriteria_water_pdf(ViewdaliyReport data);
	@SQL("select  count(line.strTime)  from tabnewpollutant as line,tabcompanyconfig as compan  " +
			"where 1=1 and line.strTime>=DATE_FORMAT(compan.stratTime,'%Y-%m-%d') and compan.Rid=line.rid "+
			" #if(!empty(:1.rid)){ and line.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and line.strTime>'##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and line.strTime<'##(:1.endTime)' }"+
			" #if(!empty(:1.minates)){and  line.syTime%'##(:1.minates)'=##(:1.remainder)  }"+
			" #if(!empty(:1.dateTypes)){and line.strTime like '##(:1.dateTypes)%' }"+
			"order by line.strTime   ")
	
	
	public int selectCount_water(ViewdaliyReport data);
	
	@SQL("select *  from  min_report_ph as report ,tabcompanyconfig c  " +
			"where 1=1"+
			" #if(!empty(:1.rid)){ and report.rid= '##(:1.rid)' }"+
			
			" #if(!empty(:1.startingTime)){ and report.strTime>= '##(:1.startingTime)%' }"+
			" #if(!empty(:1.endTime)){and report.strTime<= '##(:1.endTime)%' }"+
			" #if(!empty(:1.dateTypes)){and report.strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.minates)){and report.syTime%'##(:1.minates)'=##(:1.remainder)  }"+
			"and strTime>=c.stratTime and report.rid=c.rid order by report.strTime  limit :2.pageOffset, :2.pageSize ")
	
	
	
	public List<Pollutant> selectByCriteria3(ViewdaliyReport data,Pager pager);
	
	@SQL("select *  from  min_report_ph as report ,tabcompanyconfig c  " +
			"where 1=1"+
			" #if(!empty(:1.rid)){ and report.rid= '##(:1.rid)' }"+
			
			" #if(!empty(:1.startingTime)){ and report.strTime>= '##(:1.startingTime)%' }"+
			" #if(!empty(:1.endTime)){and report.strTime<= '##(:1.endTime)%' }"+
			" #if(!empty(:1.dateTypes)){and report.strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.minates)){and  report.syTime%'##(:1.minates)'=##(:1.remainder)  }"+
			"and strTime>=c.stratTime and report.rid=c.rid order by report.strTime   ")
	public List<Pollutant> selectByCriteria3_pdf(ViewdaliyReport data);
	
	@SQL("select *  from  tabpollutant as report  ,tabcompanyconfig c ssss" +
			"where 1=1"+
			" #if(!empty(:1.rid)){ and report.rid= '##(:1.rid)' }"+
			
			" #if(!empty(:1.startingTime)){ and report.strTime>= '##(:1.startingTime)%' }"+
			" #if(!empty(:1.endTime)){and report.strTime<= '##(:1.endTime)%' }"+
			" #if(!empty(:1.dateTypes)){and report.strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.minates)){and minute(report.strTime)%'##(:1.minates)'=1 }"+
			"and strTime>=c.stratTime and report.rid=c.rid order by report.strTime  limit :2.pageOffset, :2.pageSize ")
	public List<Pollutant> selectByCriteria4(ViewdaliyReport data,Pager pager);
	
	/**
	 * 分页统计总数
	 */
	@SQL	("select count(report.strTime)  from min_report_ph  as report  ,tabcompanyconfig c " +
			"where 1=1 and strTime>=c.stratTime and report.rid=c.rid "+
			" #if(!empty(:1.rid)){ and report.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and report.strTime>= '##(:1.startingTime)%' }"+
			" #if(!empty(:1.endTime)){and report.strTime<= '##(:1.endTime)%' }"+
			" #if(!empty(:1.minates)){and  report.syTime%'##(:1.minates)'=##(:1.remainder)  }"+
			" #if(!empty(:1.dateTypes)){and report.strTime like '##(:1.dateTypes)%' }"
			)
	public int selectCount(ViewdaliyReport data);
	
	
	
	@SQL	("select count(report.strTime)  from  ##(:1.viewName) as report ,tabcompanyconfig c "  +
			"where 1=1 and strTime>=DATE_FORMAT(c.stratTime,'%Y-%m-%d %H:%i') and  report.rid=c.rid "+
			" #if(!empty(:1.rid)){ and report.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and report.strTime>= '##(:1.startingTime)%' }"+
			" #if(!empty(:1.endTime)){and report.strTime<= '##(:1.endTime)%' }"+
			" #if(!empty(:1.minates)){and report.syTime%'##(:1.minates)'=##(:1.remainder)  }"+
			" #if(!empty(:1.dateTypes)){and report.strTime like '##(:1.dateTypes)%' }"
			)
	public int selectCountDay(ViewdaliyReport data);
	
	
	
	
	
	
}