package com.erich.saleticket.controllers.admin.tdht;


import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.erich.easyframe.util.SystemContext;
import com.erich.saleticket.biz.tdht.HistoryReportBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.model.tdht.HistoryReport;

/**
 *历史报表控制器
 * @author Lv
 */
public class HistoryReportController extends BaseController {

	
	@Resource
	private HistoryReportBiz historyReportBiz;
	
	
	/**
	 * 永艺发统计报表查询列表
	 */
	public String historyReportList(HistoryReport historyReport, HttpServletRequest request, HttpServletResponse response) {
		
		String sTime=historyReport.getStartingTime();
		String eTime=historyReport.getEndTime();
		Integer minates=historyReport.getMinates();
		
		if(sTime==null){
			int offset = SystemContext.getOffset();
			int pagesize = SystemContext.getPagesize();
			historyReport.getPager().setPageOffset(offset);
			historyReport.getPager().setPageSize(pagesize);
			historyReport.getPager().setOrderField("user_id");
			historyReport.getPager().setOrderDirection(false);
			historyReport.getPager().setRowCount(0);
			request.setAttribute("pager", historyReport.getPager());
			return "report/historyReportList";
		}
		int offset = SystemContext.getOffset();
		int pagesize = SystemContext.getPagesize();
		historyReport.getPager().setPageOffset(offset);
		historyReport.getPager().setPageSize(pagesize);
		historyReport.getPager().setOrderField("user_id");
		historyReport.getPager().setOrderDirection(false);
		historyReport.getPager().setRowCount(historyReportBiz.selectCount(historyReport));
		request.setAttribute("pager", historyReport.getPager());
		List<HistoryReport> historyReports = historyReportBiz.selectByCriteria(historyReport);
		request.setAttribute("historyReports", historyReports);
		request.setAttribute("eTime", eTime);
		request.setAttribute("sTime", sTime);
		request.setAttribute("minates", minates);
		StringBuffer webUrl=request.getRequestURL();
		request.setAttribute("webUrls", webUrl);
		return "report/historyReportList";
	}
	
	
}
