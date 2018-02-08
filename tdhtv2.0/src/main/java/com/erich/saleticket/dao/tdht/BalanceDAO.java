package com.erich.saleticket.dao.tdht;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.erich.saleticket.model.tdht.Balancea;
import com.erich.saleticket.model.tdht.ViewLineReport;


/**
 *水平衡
 */

@DAO
public interface BalanceDAO {
	
	
	@SQL("select m.Rid AS Rid,m.sytime AS sytime,m.strTime AS strTime,idztraffic AS tabZtrafficID1,lsztraffic AS tabZtrafficDS1,isztraffic AS tabZtrafficIS1,totalLossLimit AS Losslimit,totalwastage AS wastage,totalunknow AS unknown  "+
			"from daliy_6 m  where 1=1"+
			" #if(!empty(:1.rid)){ and m.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and m.strTime >= '##(:1.startingTime)%'}" +
			" #if(!empty(:1.endTime)){ and m.strTime <= '##(:1.endTime)%'}" +
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" order by m.sytime  desc limit 1")
		public ViewLineReport selectByCriteria(Balancea alarm);
	/**
	 * 水平衡基本信息
	 *//*
	@SQL("select * "+
			"from min_report m ,tabcompanyconfig c where 1=1"+
			" #if(!empty(:1.rid)){ and m.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and m.strTime >= '##(:1.startingTime)%'}" +
			"and m.strTime>c.stratTime and m.Rid=c.Rid "+
			" order by m.sytime  limit 1")
		public ViewLineReport selectByCriteria(Balancea alarm);
		
	
	@SQL("select * "+
			"from min_report where 1=1"+
			" #if(!empty(:1.rid)){ and rid= '##(:1.rid)' } "+
			"  and syTime> (select( max(sytime)-max(sytime)%1440)as sytime  " +
			" from min_report where 1=1" +
			" #if(!empty(:1.rid)){ and rid= '##(:1.rid)' } "+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.endTime)){and strTime <= '##(:1.endTime)%' } " +
			"GROUP BY rid)limit 1 ")
		public List<ViewLineReport> selectByCriteriaend(Balancea alarm);
	*/
	
	
	/**
	 * 水平衡基本信息
	 */
	@SQL("select dateType, MIN(flowRate) as flowRateMin,max(flowRate) as flowRateMax,MIN(waterLevel) as waterLevelMin,"+
		"MAX(waterLevel) as waterLevelMax,MIN(flowVelocity) as flowVelocityMin,MAX(flowVelocity) as flowVelocityMax,rid "+
		"from midtabtraffic where 1=1"+
		" #if(!empty(:1.rid)){ and rid= '##(:1.rid)' }"+
		" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
		" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
		" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
		"GROUP BY dateType ")
	public List<Balancea> selectByCriteria2(Balancea alarm);
	
	
	
	
	/**
	 *水平衡汇总流量报表
	 */
	@SQL("select tabZtraffic_DS as supplyLiving,tabZtraffic_IS as supplyIndustrial ,tabZtraffic_ID as drainageIndustrial ," +
			"Losslimit as lossLimit from min_report " +
			" where 1=1 " +
	  " #if(!empty(:1)){ and Rid= '##(:1.rid)' } "+
      " #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)%' }"+
      " #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)%' }"+
      " #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
      " order by sytime  limit 1")
	public Balancea selectMinZtraffic(Balancea balancea);
	/**
	 *水平衡汇总流量报表
	 */
	@SQL("select  tabZtraffic_DS as supplyLiving,tabZtraffic_IS as supplyIndustrial ,tabZtraffic_ID as drainageIndustrial ," +
			"Losslimit as lossLimit from min_report " +
			" where 1=1 " +
	  " #if(!empty(:1)){ and Rid= '##(:1.rid)' } "+
      " #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)%' }"+
      " #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)%' }"+
      " #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
      " order by sytime desc limit 1")
	public Balancea selectMaxZtraffic(Balancea balancea);
	
	
	/**
	 *水平衡汇总流量报表      耗损和不明
	 */
	@SQL("select  SUM(d.wastage)as lossAmount ,SUM(d.unknown)as unknown from min_report  d" +
			" where 1=1 " +
	  " #if(!empty(:1)){ and Rid= '##(:1.rid)' } "+
      " #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)%' }"+
      " #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)%' }"+
      " #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
	public Balancea selectUnknown(Balancea balancea);
	
	
	
	/**
	 *水平衡水质报表
	 */
	@SQL("select MIN(realPh) as phMin,Max(realPh) as phMax,MIN(realCod) as codMin,MAX(realCod) as codMax,MAX(realNH3N)as NH3NMax,MIN(realNH3N)as NH3NMin from midtabwaterquality " +
			" where 1=1 " +
	  " #if(!empty(:1)){ and Rid= '##(:1.rid)' } "+
      " #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)%' }"+
      " #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)%' }"+
      " #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
	public Balancea selectByCriteriaPH(Balancea balancea);
}