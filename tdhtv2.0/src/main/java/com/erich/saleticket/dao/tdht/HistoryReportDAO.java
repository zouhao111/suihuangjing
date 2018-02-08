package com.erich.saleticket.dao.tdht;

import java.util.List;
import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.tdht.HistoryReport;
import com.erich.saleticket.model.tdht.ReportForm;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface HistoryReportDAO {
	
	
	/**
	 *永艺发历史报表
	 */
	@SQL("select *  from report_defined  as def"+
			" where 1=1 "+
			" #if(!empty(:1.startingTime)){ and def.sytime>= '##(:1.startingTime)' } "+
			" #if(!empty(:1.endTime)){and def.sytime<= '##(:1.endTime)' } "+
			" #if(!empty(:1.minates)){and minute(def.sytime)%##(:1.minates)=1  } "+
			"order by def.sytime desc   limit :2.pageOffset, :2.pageSize")
	public List<HistoryReport> selectByCriteria(HistoryReport historyReport,Pager pager);
	
	
	/**
	 * 永艺发分页统计总数
	 */
	@SQL	("select count(def.sytime) from report_defined as def where 1=1 " +
			" #if(!empty(:1.startingTime)){ and def.sytime>= '##(:1.startingTime)' } "+
			" #if(!empty(:1.endTime)){and def.sytime<= '##(:1.endTime)' } "+
			" #if(!empty(:1.minates)){and minute(def.sytime)%##(:1.minates)=1  } ")
	public int selectCount(HistoryReport historyReport);
	
	
	
}