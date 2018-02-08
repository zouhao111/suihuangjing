package com.erich.saleticket.biz.tdht;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.erich.saleticket.dao.tdht.HistoryReportDAO;
import com.erich.saleticket.model.tdht.HistoryReport;

@Service
public class HistoryReportBiz {

	@Resource
	private HistoryReportDAO historyReportDAO;
	
	
	public List<HistoryReport> selectByCriteria(HistoryReport historyReport){
		return historyReportDAO.selectByCriteria(historyReport,historyReport.getPager());
	}
	
	public int selectCount(HistoryReport historyReport){
		return historyReportDAO.selectCount(historyReport);
	}
	
}
