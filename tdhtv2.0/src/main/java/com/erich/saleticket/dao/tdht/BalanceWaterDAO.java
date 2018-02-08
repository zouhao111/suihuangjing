package com.erich.saleticket.dao.tdht;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.erich.saleticket.model.tdht.BalanceComfig;
import com.erich.saleticket.model.tdht.BalanceWater;
import com.erich.saleticket.model.tdht.Balancea;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewLineReport;


/**
 *水平衡
 */

@DAO
public interface BalanceWaterDAO {
	
	
	@SQL("select * from midtodaytotalflow  "+
			"as m  ,tabcompanyconfig_copy as c where 1=1 and c.Rid=m.rid and m.strTime>=date_format(c.stratTime,'%Y-%m-%d')"+
			" #if(!empty(:1.rid)){ and m.rid= '##(:1.rid)'} " +
			" #if(!empty(:1.startingTime)){ and m.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and m.strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and m.strTime like '##(:1.dateTypes)%'} order by sytime ")
		public List<BalanceWater> selectMidtodaytotalflow(BalanceWater balance);
	@SQL("select * from midtodaytotalflow  "+
			"as m  ,tabcompanyconfig_copy as c where 1=1 and c.Rid=m.rid and m.strTime>'2017-08-04'"+
			" #if(!empty(:1.rid)){ and m.rid= '##(:1.rid)'} " +
			" #if(!empty(:1.startingTime)){ and m.strTime>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and m.strTime<= '##(:1.endTime)' }"+
			" #if(!empty(:1.dateTypes)){and m.strTime like '##(:1.dateTypes)%'} order by sytime ")
		public List<BalanceWater> selectMidtodaytotalflow2(BalanceWater balance);
	
	@SQL("select * from tabcompanyconfig_copy as viewws" +
			" where 1=1  " +
			" #if(!empty(:1.rid)){ and viewws.Rid like '##(:1.rid)%' } "+
			" #if(!empty(:1.companyName)){ and viewws.companyName like '##(:1.companyName)%' } ")
	public ViewCompanyconfig selectBycompanyconfig(BalanceWater balance);
	
	
	@SQL("INSERT INTO balance(rid,syTime,industrialdrainage,industrialsupply,livingdrainage,idztraffic,isztraffic,ldztraffic,lsztraffic,Losslimit,totalLossLimit,totalwastage,wastage,totalunknow,unknown)  " +
	"values(:1.rid , 1.syTime,1.industrialdrainage,1.industrialsupply,1.livingdrainage,1.idztraffic,1.isztraffic,1.lsztraffic,1.Losslimit,1.totalLossLimit,1.totalwastage,1.wastage,1.totalunknow,1.unknown" +
	" ")
public int insertBalance(BalanceWater balance);

@SQL("delete from balance;")
	public Object deleteBalance();



}