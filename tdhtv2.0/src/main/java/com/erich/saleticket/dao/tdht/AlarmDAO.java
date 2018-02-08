package com.erich.saleticket.dao.tdht;

import java.util.List;

import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.tdht.Alarm;
import com.erich.saleticket.model.tdht.AlarmType;
import com.erich.saleticket.model.tdht.AlarmType_water;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.ViewWaterquality;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface AlarmDAO {
	
	/**
	 * 水环境报警
	 */
	
	@SQL("select * from pollutantconfig_com where rid=:1")
	 public List<AlarmType_water>  selectByCriteriawater_type(Long rid);
	
	 @SQL("select * from ##( :1.tabName) where rid=:1.rid  order by sytime limit 1")
	 public AlarmType_water  selectByCriteriawater(AlarmType_water alarm);
	
	
		/**
		 * 分页统计总数
		 */
	 @SQL("select count(id) from ##( :1.tabName)   where rid=:1.rid  " +
			
				" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
				" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
				" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
				" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
				
		 public int  selectCountWater(AlarmType_water alarm);
	 
	 @SQL("select wr.rid AS rid,po.Type AS Types,po.typeRemark AS typeRemark,po.limitH AS limitH" +
	 		",po.limitHH AS limitHH,po.limitL AS limitL,po.limitLL AS limitLL from ##( :1.tabName) AS wr,pollutantconfig AS po  where wr.rid=:1.rid  " +
				" #if(!empty(:1.startingTime)){ and wr.strTime>= '##(:1.startingTime)' }"+
				" #if(!empty(:1.endTime)){and wr.strTime<= '##(:1.endTime)' }"+
				" #if(!empty(:1.zeroTime)){ and wr.strTime>= '##(:1.zeroTime)' }"+
				" #if(!empty(:1.dateTypes)){and wr.strTime like '##(:1.dateTypes)%' }" +
				" ORDER BY wr.syTime desc " +
				"#if(!empty( :1.limit)){ limit :1.limit} " +
				" #if(!empty( :2.pageOffset)){ limit :2.pageOffset, :2.pageSize}" )
				
		 public List<AlarmType_water>  selectCountWaters(AlarmType_water alarm,Pager pager);
	 
		 
		 @SQL("select * from ##(:1.tabName)  where rid=:1.rid  " +
					" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
					" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
					" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
					" #if(!empty(:1.dateTypes)){ and strTime like '##(:1.dateTypes)%'} " +
					" ORDER BY syTime desc limit :2.pageOffset, :2.pageSize " ) 
		 public List<AlarmType_water>  selectCountWatersHistory(AlarmType_water alarm,Pager pager);
		 
	
	/**
	 * 查询公司报警类型 
	 */

	@SQL("select * from alarm_limit where have=1 and rid=:1")
	 public List<AlarmType>  selectByCriteria_type(Long rid);
	

	@SQL("select * from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realcod>:1.maxValue } " +
			"#if(!empty(:1.min_early)){and realcod>:1.min_early } " +
			"#if(!empty(:1.max_early)){and realcod<:1.max_early } " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" ORDER BY syTime desc" +
			" #if(!empty( :1.limit)){  limit :1.limit} " +
			"  #if(!empty( :2.pageOffset)){ limit :2.pageOffset, :2.pageSize}" )
	 public List<Pollutant>  selectByCriteria_cod(Alarm alarm,Pager pager);
	@SQL("select count(id) from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realcod>:1.maxValue } " +
			"#if(!empty(:1.min_early)){and realcod>:1.min_early } " +
			"#if(!empty(:1.max_early)){and realcod<:1.max_early } " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
			
	 public int  selectCount_cod(Alarm alarm);

	@SQL("select * from tabpollutant  where rid=:1.rid " +
			"#if(!empty(:1.maxValue)){and realnh4>:1.maxValue} " +
			"#if(!empty(:1.min_early)){and realnh4>:1.min_early} " +
			"#if(!empty(:1.max_early)){and realnh4<:1.max_early} " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			"ORDER BY syTime desc " +
			" #if(!empty( :1.limit)){  limit :1.limit} " +
			" #if(!empty( :2.pageOffset)){ limit :2.pageOffset, :2.pageSize}" )
	 public List<Pollutant>  selectByCriteria_nh4(Alarm alarm,Pager pager);

	@SQL("select count(id) from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realnh4>:1.maxValue } " +
			"#if(!empty(:1.min_early)){and realnh4>:1.min_early } " +
			"#if(!empty(:1.max_early)){and realnh4<:1.max_early } " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
			
	 public int  selectCount_nh4(Alarm alarm);
	@SQL("select * from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realmlss>:1.maxValue} " +
			"#if(!empty(:1.min_early)){and realmlss>:1.min_early}  " +
			"#if(!empty(:1.max_early)){and realmlss<:1.max_early} " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" ORDER BY syTime desc " +
			"#if(!empty( :1.limit)){ limit :1.limit} " +
			" #if(!empty( :2.pageOffset)){ limit :2.pageOffset, :2.pageSize}" )
	 public List<Pollutant>  selectByCriteria_mlss(Alarm alarm,Pager pager);
	@SQL("select count(id) from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realmlss>:1.maxValue } " +
			"#if(!empty(:1.min_early)){and realmlss>:1.min_early } " +
			"#if(!empty(:1.max_early)){and realmlss<:1.max_early } " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
			
	 public int  selectCount_mlss(Alarm alarm);
	@SQL("select * from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realphosphor>:1.maxValue} " +
			"#if(!empty(:1.min_early)){and realphosphor>:1.min_early} " +
			"#if(!empty(:1.max_early)){and realphosphor<:1.max_early}  " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" ORDER BY syTime desc " +
			"#if(!empty( :1.limit)){ limit :1.limit} " +
			" #if(!empty( :2.pageOffset)){ limit :2.pageOffset, :2.pageSize}" )
	 public List<Pollutant>  selectByCriteria_pho(Alarm alarm,Pager pager);
	@SQL("select count(id) from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realphosphor>:1.maxValue } " +
			"#if(!empty(:1.min_early)){and realphosphor>:1.min_early } " +
			"#if(!empty(:1.max_early)){and realphosphor<:1.max_early } " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
			
	 public int  selectCount_pho(Alarm alarm);
	@SQL("select * from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realcr6>:1.maxValue} " +
			"#if(!empty(:1.min_early)){and realcr6>:1.min_early} " +
			"#if(!empty(:1.max_early)){and realcr6<:1.max_early} " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" ORDER BY syTime desc" +
			"#if(!empty( :1.limit)){  limit :1.limit} " +
			" #if(!empty( :2.pageOffset)){ limit :2.pageOffset, :2.pageSize}" )
	 public List<Pollutant>  selectByCriteria_cr6(Alarm alarm,Pager pager);
	@SQL("select count(id) from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realcr6>:1.maxValue } " +
			"#if(!empty(:1.min_early)){and realcr6>:1.min_early } " +
			"#if(!empty(:1.max_early)){and realcr6<:1.max_early } " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
			
	 public int  selectCount_cr6(Alarm alarm);
	@SQL("select rid,strTime,tabph as realph  from midtabindustrialdrainage  where rid=:1.rid  and tabPh>0 and tabPh<14 " +
			"#if(!empty(:1.maxValue)){and (tabph>:1.maxValue or tabph<:1.minValue)}" +
			"#if(!empty(:1.min_early)){and ((tabph>:1.min_earlys and tabph<:1.min_early) or (tabph>:1.max_early and tabph<:1.max_earlys))} " +
		
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" ORDER BY syTime desc " +
			"#if(!empty( :1.limit)){ limit :1.limit} " +
			" #if(!empty( :2.pageOffset)){ limit :2.pageOffset, :2.pageSize}" )
	 public List<Pollutant>  selectByCriteria_ph(Alarm alarm,Pager pager);
	@SQL("select count(id)  from midtabindustrialdrainage  where rid=:1.rid  and tabPh>0 and tabPh<14 " +
			"#if(!empty(:1.maxValue)){and (tabph>:1.maxValue or tabph<:1.minValue)}" +
			"#if(!empty(:1.min_early)){and ((tabph>:1.min_earlys and tabph<:1.min_early) or (tabph>:1.max_early and tabph<:1.max_earlys))} " +
		
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }" )
	 public int    selectCount_ph(Alarm alarm);
	@SQL("select rid,Time as strTime,a1 as realztraffic from ztrafficusub_total_4  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and a1>:1.maxValue} " +
			"#if(!empty(:1.min_early)){and a1>:1.min_early} " +
			"#if(!empty(:1.max_early)){and a1<:1.max_early} " +
			" #if(!empty(:1.startingTime)){ and Time>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and Time<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and Time like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and Time>= '##(:1.zeroTime)' }"+
			"ORDER BY Time desc " +
			" #if(!empty( :1.limit)){  limit :1.limit} " +
			" #if(!empty( :2.pageOffset)){limit :2.pageOffset, :2.pageSize}" )
	 public List<Pollutant>  selectByCriteria_ztr(Alarm alarm,Pager pager);
	@SQL("select count(sytime) from ztrafficusub_total_4  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and a1>:1.maxValue } " +
			"#if(!empty(:1.min_early)){and a1>:1.min_early } " +
			"#if(!empty(:1.max_early)){and a1<:1.max_early } " +
			" #if(!empty(:1.startingTime)){ and Time>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and Time<= '##(:1.endTime)' }"+
			" #if(!empty(:1.zeroTime)){ and Time>= '##(:1.zeroTime)' }"+
			" #if(!empty(:1.dateTypes)){and Time like '##(:1.dateTypes)%' }")
			
	 public int  selectCount_ztr(Alarm alarm);
	
	@SQL("select rid,strTime as strTime,tabVoltage as realvoltage from sourcemidtabindustrialdrainage  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and tabVoltage<:1.maxValue} " +
			"#if(!empty(:1.min_early)){and tabVoltage>:1.min_early} " +
			"#if(!empty(:1.max_early)){and tabVoltage<:1.max_early} " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			"ORDER BY strTime desc " +
			" #if(!empty( :1.limit)){  limit :1.limit} " +
			" #if(!empty( :2.pageOffset)){limit :2.pageOffset, :2.pageSize}" )
	 public List<Pollutant>  selectByCriteria_vol(Alarm alarm,Pager pager);
	@SQL("select count(sytime) from sourcemidtabindustrialdrainage  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and tabVoltage<:1.maxValue } " +
			"#if(!empty(:1.min_early)){and tabVoltage>:1.min_early } " +
			"#if(!empty(:1.max_early)){and tabVoltage<:1.max_early } " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
			
	 public int  selectCount_vol(Alarm alarm);
	
	
	@SQL("select * from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realcu>:1.maxValue} " +
			"#if(!empty(:1.min_early)){and realcu>:1.min_early} " +
			"#if(!empty(:1.max_early)){and realcu<:1.max_early} " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" ORDER BY syTime desc" +
			"#if(!empty( :1.limit)){  limit :1.limit} " +
			" #if(!empty( :2.pageOffset)){ limit :2.pageOffset, :2.pageSize}" )
	 public List<Pollutant>  selectByCriteria_cu(Alarm alarm,Pager pager);
	@SQL("select count(id) from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realcu>:1.maxValue } " +
			"#if(!empty(:1.min_early)){and realcu>:1.min_early } " +
			"#if(!empty(:1.max_early)){and realcu<:1.max_early } " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
			
	 public int  selectCount_cu(Alarm alarm);
	
	
	
	
	@SQL("select * from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realni>:1.maxValue} " +
			"#if(!empty(:1.min_early)){and realni>:1.min_early} " +
			"#if(!empty(:1.max_early)){and realni<:1.max_early} " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" ORDER BY syTime desc" +
			"#if(!empty( :1.limit)){  limit :1.limit} " +
			" #if(!empty( :2.pageOffset)){ limit :2.pageOffset, :2.pageSize}" )
	 public List<Pollutant>  selectByCriteria_ni(Alarm alarm,Pager pager);
	@SQL("select count(id) from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realni>:1.maxValue } " +
			"#if(!empty(:1.min_early)){and realni>:1.min_early } " +
			"#if(!empty(:1.max_early)){and realni<:1.max_early } " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
			
	 public int  selectCount_ni(Alarm alarm);
	
	
	@SQL("select * from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realzn>:1.maxValue} " +
			"#if(!empty(:1.min_early)){and realzn>:1.min_early} " +
			"#if(!empty(:1.max_early)){and realzn<:1.max_early} " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" ORDER BY syTime desc" +
			"#if(!empty( :1.limit)){  limit :1.limit} " +
			" #if(!empty( :2.pageOffset)){ limit :2.pageOffset, :2.pageSize}" )
	 public List<Pollutant>  selectByCriteria_zn(Alarm alarm,Pager pager);
	@SQL("select count(id) from tabpollutant  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and realzn>:1.maxValue } " +
			"#if(!empty(:1.min_early)){and realzn>:1.min_early } " +
			"#if(!empty(:1.max_early)){and realzn<:1.max_early } " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
			
	 public int  selectCount_zn(Alarm alarm);
	@SQL("select rid,strTime as strTime,tabTurbidity as realTurbidity  from sourcemidtabindustrialdrainage  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and tabTurbidity<:1.maxValue} " +
			"#if(!empty(:1.min_early)){and tabTurbidity>:1.min_early} " +
			"#if(!empty(:1.max_early)){and tabTurbidity<:1.max_early} " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			"ORDER BY strTime desc " +
			" #if(!empty( :1.limit)){  limit :1.limit} " +
			" #if(!empty( :2.pageOffset)){limit :2.pageOffset, :2.pageSize}" )
	 public List<Pollutant>  selectByCriteria_tur(Alarm alarm,Pager pager);
	@SQL("select count(sytime) from sourcemidtabindustrialdrainage  where rid=:1.rid  " +
			"#if(!empty(:1.maxValue)){and tabTurbidity<:1.maxValue } " +
			"#if(!empty(:1.min_early)){and tabTurbidity>:1.min_early } " +
			"#if(!empty(:1.max_early)){and tabTurbidity<:1.max_early } " +
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.zeroTime)){ and strTime>= '##(:1.zeroTime)' }"+
			" #if(!empty(:1.dateTypes)){and strTime like '##(:1.dateTypes)%' }")
			
	 public int  selectCount_tur(Alarm alarm);
	
	@SQL("SELECT * from tabpollutant  where rid=:1.rid and id>(select id from tabpollutant where rid=:1.rid " +
			"#if(!empty(:1.startingTime)){ and strTime>='##(:1.startingTime)'  limit 1) } "+
			"and id<=(select id from tabpollutant where rid=75501330004 " +
			"#if(!empty(:1.endTime)){and strTime<='##(:1.endTime)'  ORDER BY id desc limit 1)}order by id desc  ")
	 public List<Pollutant>  selectByCriteria_value(Alarm alarm);
	
	/**
	 * 查询报警记录最新的一条 
	 */
	@SQL("SELECT * from (   " +
			"(SELECT * from alarmcod where Rid=:1 ORDER BY alarmcod.strTime DESC LIMIT 1) " +
			"UNION all " +
			"(SELECT * from alarmcr6 where Rid=:1 ORDER BY alarmcr6.strTime DESC LIMIT 1)  "+
			"UNION all "+
			"(SELECT * from alarmmlss where Rid=:1 ORDER BY alarmmlss.strTime DESC LIMIT 1)"+
			"UNION all "+
			"(SELECT * from alarmph where Rid=:1 ORDER BY alarmph.strTime DESC LIMIT 1)"+
			"UNION all "+
			"(SELECT * from alarmnh4n where Rid=:1 ORDER BY alarmnh4n.strTime DESC LIMIT 1)"+
			"UNION all"+
			"(SELECT * from alarmphosphor where Rid=:1 ORDER BY alarmphosphor.strTime DESC LIMIT 1)"+
			"UNION all"+
			"(SELECT * from alarmztraffic where Rid=:1 ORDER BY alarmztraffic.strTime DESC LIMIT 1)"+
			") as wuranw")
	 public List<Alarm>  selectByCriteria2(Long rid);
	
	
	
	
	
	@SQL("select ph.strTime,ph.`maxValue`,ph.minValue,ph.varValue,sys.company_name from tabalarm as ph,sys_company as sys " +
			"where " +
			"ph.rid=##(:1.rid) and " +
			"ph.rid=sys.company_id and "+
			"ph.varValue>ph.`maxValue` or ph.varValue<ph.minValue order by ph.Id desc limit 1")
	public Alarm selectByCriteria(Alarm alarm);
	
	
	/**
	 * 查询预警记录最新的一条 
	 */
	@SQL("SELECT * from ( " +
			"(SELECT * from warningcod where Rid=:1 ORDER BY warningcod.strTime DESC LIMIT 1) " +
			"UNION all " +
			"(SELECT * from warningcr6 where Rid=:1 ORDER BY warningcr6.strTime DESC LIMIT 1) "+
			"UNION all "+
			"(SELECT * from warningmlss where Rid=:1 ORDER BY warningmlss.strTime DESC LIMIT 1)"+
			"UNION all"+
			"(SELECT * from warningph where Rid=:1 ORDER BY warningph.strTime DESC LIMIT 1)"+
			"UNION all"+
			"(SELECT * from warningphosphor where Rid=:1 ORDER BY warningphosphor.strTime DESC LIMIT 1)"+
			"UNION all"+
			"(SELECT * from warningztraffic where Rid=:1 ORDER BY warningztraffic.strTime DESC LIMIT 1)"+
			") as wuranw")
	public List<Alarm> selectByWarningCriteria(Long rid);
	
	/**
	 * 查询预警记录最新的一条 
	 * select * from midtabwaterquality where ((midtabwaterquality.realPh>=8.5 and midtabwaterquality.realPh<=9)or
	 * (midtabwaterquality.realPh>=6 and midtabwaterquality.realPh<=6.5) ) 
	 * AND midtabwaterquality.realPh>0 and midtabwaterquality.realPh<14 order by   midtabwaterquality.strTime desc limit 1
	 */
	@SQL("select midtabwaterquality.Rid,strTime,realPh,tabcompanyconfig.companyName from midtabwaterquality,tabcompanyconfig   " +
			"where and tabcompanyconfig.stratTime=<midtabwaterquality.rid " +
			"midtabwaterquality.rid=##(:1.rid) and " +
			"((midtabwaterquality.realPh>=8.5 and midtabwaterquality.realPh<=9)or "+
			"(midtabwaterquality.realPh>=6 and midtabwaterquality.realPh<=6.5) ) "+
			"AND midtabwaterquality.realPh>0 and midtabwaterquality.realPh<14 and midtabwaterquality.Rid=tabcompanyconfig.Rid order by   midtabwaterquality.strTime desc limit 1")
	public List<Alarm> selectByWarningCriteria2(Long rid);
	
	/**
	 *查询历史报警记录  
	 */
/*	@SQL("select ph.strTime,ph.`maxValue`,ph.minValue,ph.varValue,ph.rid,sys.company_name from ##(:1.viewName) as ph,sys_company as sys " +
			"where 1=1 "+
			" and ph.varValue<=ph.minValue or ph.varValue>=ph.maxValue"+
			" #if(!empty(:1.rid)){ and ph.rid= '##(:1.rid)' }"+
			" and ph.rid=sys.company_id "+
			" #if(!empty(:1.startingTime)){ and ph.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and ph.strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and ph.strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.companyName)){and sys.company_name like '##(:1.companyName)%' }"+
			"order by ph.strTime desc limit :2.pageOffset, :2.pageSize")
	public List<Alarm> selectByHistory(Alarm alarm,Pager pager);*/
	
	/**
	 *查询历史报警记录  
	 */
	@SQL("SELECT * from (   " +
			"(SELECT * from alarmcod where Rid=:1.rid ORDER BY alarmcod.strTime DESC ) " +
			"UNION all " +
			"(SELECT * from alarmcr6 where Rid=:1.rid ORDER BY alarmcr6.strTime DESC )  "+
			"UNION all "+
			"(SELECT * from alarmmlss where Rid=:1.rid ORDER BY alarmmlss.strTime DESC )"+
			"UNION all "+
			"(SELECT * from alarmph where Rid=:1.rid ORDER BY alarmph.strTime DESC )"+
			"UNION all "+
			"(SELECT * from alarmnh4n where Rid=:1.rid ORDER BY alarmnh4n.strTime DESC )"+
			"UNION all"+
			"(SELECT * from alarmphosphor where Rid=:1.rid ORDER BY alarmphosphor.strTime DESC )"+
			"UNION all"+
			"(SELECT * from alarmztraffic where Rid=:1.rid ORDER BY alarmztraffic.strTime DESC )"+
			") as wuranw ,tabcompanyconfig  " +
			"where 1=1 and wuranw.strTime>=tabcompanyconfig.stratTime and wuranw.Rid=tabcompanyconfig.Rid "+
			" #if(!empty(:1.startingTime)){ and wuranw.strTime>= '##(:1.startingTime)' }  "+
			" #if(!empty(:1.endTime)){and wuranw.strTime<= '##(:1.endTime)' } "+
			" #if(!empty(:1.dateTypes)){and wuranw.strTime like '##(:1.dateTypes)%' } "+
			"order by wuranw.strTime desc limit :2.pageOffset, :2.pageSize")
		public List<Alarm> selectByHistory2(Alarm alarm,Pager pager);
	
	
	/**
	 *查询历史预警记录  
	 */
	/*@SQL("select ph.strTime,ph.`maxValue`,ph.minValue,ph.varValue,ph.rid,sys.company_name from ##(:1.viewName) as ph,sys_company as sys " +
			"where 1=1 "+
			" and ph.varValue<=6.5 and ph.varValue>=6 or ph.varValue>=8.5 and ph.varValue<=9  "+
			" #if(!empty(:1.rid)){ and ph.rid= '##(:1.rid)' }"+
			" and ph.rid=sys.company_id "+
			" #if(!empty(:1.startingTime)){ and ph.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and ph.strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and ph.strTime like '##(:1.dateTypes)%' }"+
			" #if(!empty(:1.companyName)){and sys.company_name like '##(:1.companyName)%' }"+
			"order by ph.strTime desc limit :2.pageOffset, :2.pageSize")
	public List<Alarm> selectByWarningHistory(Alarm alarm,Pager pager);
	*/
	
	/**
	 *查询历史预警记录  
	 */
	@SQL("SELECT * from ( " +
			"(SELECT * from warningcod where Rid=:1.rid ORDER BY warningcod.strTime DESC ) " +
			"UNION all " +
			"(SELECT * from warningcr6 where Rid=:1.rid ORDER BY warningcr6.strTime DESC ) "+
			"UNION all "+
			"(SELECT * from warningmlss where Rid=:1.rid ORDER BY warningmlss.strTime DESC )"+
			"UNION all"+
			"(SELECT * from warningph where Rid=:1.rid ORDER BY warningph.strTime DESC )"+
			"UNION all"+
			"(SELECT * from warningphosphor where Rid=:1.rid ORDER BY warningphosphor.strTime DESC )"+
			"UNION all"+
			"(SELECT * from warningztraffic where Rid=:1.rid ORDER BY warningztraffic.strTime DESC )"+
			") as wuranw   ,tabcompanyconfig   " +
			"where 1=1  and wuranw.strTime>=tabcompanyconfig.stratTime and wuranw.Rid=tabcompanyconfig.Rid "+
			" #if(!empty(:1.startingTime)){ and wuranw.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and wuranw.strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and wuranw.strTime like '##(:1.dateTypes)%' }"+
			"order by wuranw.strTime desc limit :2.pageOffset, :2.pageSize")
	  public List<Alarm> selectByWarningHistory2(Alarm alarm,Pager pager);
	
	
	
	/**
	 * 分页统计总数
	 */
	@SQL("SELECT count(wuranw.Rid) from (   " +
			"(SELECT * from alarmcod where Rid=:1.rid ORDER BY alarmcod.strTime DESC ) " + 
			"UNION all " +
			"(SELECT * from alarmcr6 where Rid=:1.rid ORDER BY alarmcr6.strTime DESC )  "+
			"UNION all "+
			"(SELECT * from alarmmlss where Rid=:1.rid ORDER BY alarmmlss.strTime DESC )"+
			"UNION all "+
			"(SELECT * from alarmph where Rid=:1.rid ORDER BY alarmph.strTime DESC )"+
			"UNION all "+
			"(SELECT * from alarmnh4n where Rid=:1.rid ORDER BY alarmnh4n.strTime DESC )"+
			"UNION all"+
			"(SELECT * from alarmphosphor where Rid=:1.rid ORDER BY alarmphosphor.strTime DESC )"+
			"UNION all"+
			"(SELECT * from alarmztraffic where Rid=:1.rid ORDER BY alarmztraffic.strTime DESC )"+
			") as wuranw ,tabcompanyconfig  " +
			"where 1=1 and wuranw.strTime>=tabcompanyconfig.stratTime and wuranw.Rid=tabcompanyconfig.Rid "+
			" #if(!empty(:1.startingTime)){ and wuranw.strTime>= '##(:1.startingTime)' }  "+
			" #if(!empty(:1.endTime)){and wuranw.strTime<= '##(:1.endTime)' } "+
			" #if(!empty(:1.dateTypes)){and wuranw.strTime like '##(:1.dateTypes)%' } ")
	public int selectCount(Alarm alarm);
	
	
	/**
	 * 分页统计总数
	 */
	@SQL("SELECT count(wuranw.Rid) from ( " +
			"(SELECT * from warningcod where Rid=:1.rid ORDER BY warningcod.strTime DESC ) " +
			"UNION all " +
			"(SELECT * from warningcr6 where Rid=:1.rid ORDER BY warningcr6.strTime DESC ) "+
			"UNION all "+
			"(SELECT * from warningmlss where Rid=:1.rid ORDER BY warningmlss.strTime DESC )"+
			"UNION all"+
			"(SELECT * from warningph where Rid=:1.rid ORDER BY warningph.strTime DESC )"+
			"UNION all"+
			"(SELECT * from warningphosphor where Rid=:1.rid ORDER BY warningphosphor.strTime DESC )"+
			"UNION all"+
			"(SELECT * from warningztraffic where Rid=:1.rid ORDER BY warningztraffic.strTime DESC )"+
			") as wuranw  ,tabcompanyconfig  " +
			"where 1=1 and wuranw.strTime>=tabcompanyconfig.stratTime and wuranw.Rid=tabcompanyconfig.Rid " +
			" #if(!empty(:1.startingTime)){ and wuranw.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and wuranw.strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and wuranw.strTime like '##(:1.dateTypes)%' }")
	public int selectWarningCount(Alarm alarm);
	
	
}