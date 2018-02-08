package com.erich.saleticket.dao.tdht;



import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.ViewZtraffic;


/**
 *污染物
 */

@DAO
public interface PollutantDAO {
	
	/**
	 *污染物
	 */
	@SQL("select dateType, MIN(flowRate) as flowRateMin,max(flowRate) as flowRateMax,MIN(waterLevel) as waterLevelMin,"+
		"MAX(waterLevel) as waterLevelMax,MIN(flowVelocity) as flowVelocityMin,MAX(flowVelocity) as flowVelocityMax,rid "+
		"from midtabtraffic where 1=1"+
		" #if(!empty(:1.rid)){ and rid= '##(:1.rid)' }"+
		" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
		" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
		" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
		"GROUP BY dateType ")
	public List<Pollutant> selectByPollutant(Pollutant pollutant);
	
	
	/**
	 * 查询污染物报表
	 */
	@SQL("SELECT strTime,SUM(Cr) Cr,SUM(cr6) cr6,SUM(Ni) Ni,SUM(Cd) cd,SUM(lead) lead," +
			"SUM(silver) silver,SUM(Hg) hg,SUM(bod) bod,SUM(cod) cod,SUM(cu) cu," +
			"SUM(mlss) mlss,SUM(nh4) nh4,SUM(phosphor) phosphor,SUM(prussiate) prussiate," +
			"SUM(toc) toc,SUM(Zn) Zn  " +
			"from totaltabpollutant t,pollstrtime c where 1=1" +
			" #if(!empty(:1.rid)){ and t.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and t.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and t.strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.startingTimeL)){ and t.syTime>= '##(:1.startingTimeL)' }"+
			" #if(!empty(:1.endTimeL)){and t.syTime<= '##(:1.endTimeL)' }"+
			" #if(!empty(:1.dateTypes)){and t.strTime like '##(:1.dateTypes)%' }"+
			" and t.strTime>c.pollStrTime and t.rid=c.Rid ")
			
	public Pollutant selectByPollutant2(Pollutant pollutant);
	
	/**
	 * 污染物汇总信息
	 */
	@SQL("select * "+
			"from midtabtotalztraffic t,tabcompanyconfig c where 1=1" +
			" #if(!empty(:1.rid)){ and t.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and t.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and t.strTime<= '##(:1.endTime)' }"+
			" and t.strTime>c.stratTime and t.rid=c.Rid "+
			" #if(!empty(:1.dateTypes)){and t.strTime like '##(:1.dateTypes)%' } order by t.sytime asc limit 1" )
	public ViewZtraffic  selectByPollutant3(Pollutant pollutant);
	@SQL("select * "+
			"from midtabtotalztraffic t,tabcompanyconfig c where 1=1" +
			" #if(!empty(:1.rid)){ and t.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and t.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and t.strTime<= '##(:1.endTime)' }"+
			" and t.strTime>c.stratTime and t.rid=c.Rid "+
			" #if(!empty(:1.dateTypes)){and t.strTime like '##(:1.dateTypes)%' } order by t.sytime desc limit 1" )
	public ViewZtraffic  selectByPollutant4(Pollutant pollutant);
	@SQL("select * "+
			"from midtabtotalztraffic t,tabcompanyconfig c where 1=1" +
			" #if(!empty(:1.rid)){ and t.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and t.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and t.strTime<= '##(:1.endTime)' }"+
			" and t.strTime>c.stratTime and t.rid=c.Rid "+
			" #if(!empty(:1.dateTypes)){and t.strTime like '##(:1.dateTypes)%' } order by t.sytime asc " )
	public List<ViewZtraffic>  selectByPollutant5(Pollutant pollutant);
	@SQL("select * "+
			"from midtabtotalztraffic t,tabcompanyconfig c where 1=1" +
			" #if(!empty(:1.rid)){ and t.rid= '##(:1.rid)' }"+
			" #if(!empty(:1.startingTime)){ and t.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and t.strTime<= '##(:1.endTime)' }"+
			" and t.strTime>'2017-08-04' and t.rid=c.Rid "+
			" #if(!empty(:1.dateTypes)){and t.strTime like '##(:1.dateTypes)%' } order by t.sytime asc " )
	public List<ViewZtraffic>  selectByPollutant04(Pollutant pollutant);
	/**
	 * 污染物汇总信息
	 */
	@SQL("select *"+
			"from day_pollutant_sum where 1=1"+
			" #if(!empty(:1)){ and rid= '##(:1)' }"+
			"order by syTime limit 1") 
	public Pollutant selectByPollutant2(Long rid);
	
	/**
	 * 污染物汇总信息
	 */
	@SQL("select *"+
			"from totaltabpollutant_sum where 1=1"+
			" #if(!empty(:1)){ and rid= '##(:1)' }"+
			"order by syTime  desc limit 1") 
	public Pollutant selectByPollutant2_sum(Long rid);
	
	/**
	 * WTW
	 */
	@SQL("select *"+
			"from first_totalPollutant where 1=1"+
			" #if(!empty(:1)){ and rid= '##(:1)' } limit 1")
		public Pollutant selectByPollutant3(Long rid);
		
	
}