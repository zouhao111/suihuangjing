package com.erich.saleticket.controllers.admin.tdht;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.erich.easyframe.util.SystemContext;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.biz.tdht.LogBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.model.tdht.Console;
import com.erich.saleticket.model.tdht.KeyState;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewLog;

/**
 *操作日志控制器
 * @author Lv
 */
public class LogController extends BaseController {

	
	@Resource
	private LogBiz logBiz;
	@Resource
	private DataBiz dataBiz;
	
	Data<Console> result2 = new Data<Console>(ApiResultcode._0);
	public String logListpdf(ViewLog viewLog,HttpServletRequest request, HttpServletResponse response) {
		String sTime=viewLog.getStartingTime();
		String eTime=viewLog.getEndTime();
		String companyName=viewLog.getCompanyName();//公司名
		String userName=viewLog.getUserName();//用户名
		Long  rid=viewLog.getRid();//RID
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
		
		
		if(sTime==null & eTime==null & companyName==null & userName==null){
			viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID获取公司名
			
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat formats=new SimpleDateFormat("yyyy-MM-dd");
			eTime=format.format(date);
			sTime=formats.format(date)+" 00:00:00";
			viewLog.setEndTime(eTime);
			viewLog.setStartingTime(sTime);
			viewLog.setCompanyName(viewCompanyconfig.getCompanyName());
			companyName=viewCompanyconfig.getCompanyName();
		}
		
		
		
		
		List<ViewLog> log = logBiz.selectByCriteriapdf(viewLog);

		
		
		List<Object>list=new ArrayList<Object>();
		list.add(0, log);
		
		result2.setList(list);
		 result2.init(ApiResultcode._1, "成功");
		return "@" + encodeJson(result2);
		
	}
	/**
	 *操作日志列表
	 */
	public String logList(ViewLog viewLog,HttpServletRequest request, HttpServletResponse response) {
		String sTime=viewLog.getStartingTime();
		String eTime=viewLog.getEndTime();
		String companyName=viewLog.getCompanyName();//公司名
		String userName=viewLog.getUserName();//用户名
		Long  rid=viewLog.getRid();//RID
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
		
		
		if(sTime==null & eTime==null & companyName==null & userName==null){
			viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID获取公司名
			
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat formats=new SimpleDateFormat("yyyy-MM-dd");
			eTime=format.format(date);
			sTime=formats.format(date)+" 00:00:00";
			viewLog.setEndTime(eTime);
			viewLog.setStartingTime(sTime);
			viewLog.setCompanyName(viewCompanyconfig.getCompanyName());
			companyName=viewCompanyconfig.getCompanyName();
		}
		
		
		
		int offset = SystemContext.getOffset();
		int pagesize = SystemContext.getPagesize();
		viewLog.getPager().setPageOffset(offset);
		viewLog.getPager().setPageSize(pagesize);
		viewLog.getPager().setOrderField("user_id");
		viewLog.getPager().setOrderDirection(false);
		viewLog.getPager().setRowCount(logBiz.selectCount(viewLog));
		request.setAttribute("pager", viewLog.getPager());
		List<ViewLog> log = logBiz.selectByCriteria(viewLog);
		
		request.setAttribute("log", log);
		request.setAttribute("sTime", sTime);
		request.setAttribute("eTime", eTime);
		request.setAttribute("rid", rid);
		request.setAttribute("userName", userName);
		request.setAttribute("companyName", companyName);
		StringBuffer webUrl=request.getRequestURL();
		request.setAttribute("webUrls", webUrl+"?name=1");
		
		
		return "log/logList";
	}
	

	/**
	 *设备日志列表
	 */
	public String offlineLogList(KeyState keyState,HttpServletRequest request, HttpServletResponse response) {
		String sTime=keyState.getStartingTime();
		String eTime=keyState.getEndTime();
		String companyName=keyState.getCompanyName();//公司名
		Long macId=keyState.getMacId();
		Long  rid=keyState.getRid();//RID
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
	
		
		if(sTime==null & eTime==null & companyName==null){
			viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID获取公司名
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat formats=new SimpleDateFormat("yyyy-MM-dd");
			eTime=format.format(date);
			sTime=formats.format(date)+" 00:00:00";
			  keyState.setEndTime(eTime); 
			  keyState.setStartingTime(sTime);
			keyState.setCompanyName(viewCompanyconfig.getCompanyName());
			companyName=viewCompanyconfig.getCompanyName();
		}
		
		/*int offset = SystemContext.getOffset();
		int pagesize = SystemContext.getPagesize();
		keyState.getPager().setPageOffset(offset);
		keyState.getPager().setPageSize(pagesize);
		keyState.getPager().setOrderField("user_id");
		keyState.getPager().setOrderDirection(false);
		keyState.getPager().setRowCount(logBiz.selectOFCount(keyState));
		request.setAttribute("pager", keyState.getPager());*/
		List<KeyState> log = logBiz.selectByOFCriteria(keyState);
		
		List<KeyState> logs=new ArrayList<KeyState>();
		
		//logs.add(log.get(0));
	for(int i=0;i<log.size()-1;i++){
		if(log.get(i).getMacId().equals(log.get(i+1).getMacId())){//判断第二条和第一条的板ID是否相同
			if(log.get(i).getBitOnline()!=log.get(i+1).getBitOnline()){//判断相同板子的状态如果不相同取上面一条
				logs.add(log.get(i));
			}
		}else{
			//logs.add(log.get(i));//板子ID不相同的话取出上下2条
			//logs.add(log.get(i+1));
		}
	}
		//logs.add(log.get(log.size()-1));
		
		Collections.sort(logs,new Comparator<KeyState>(){//根据时间降序
            public int compare(KeyState arg0, KeyState arg1) {
                return arg1.getStrTime().compareTo(arg0.getStrTime());
            }
        });
		request.setAttribute("log", logs);
		request.setAttribute("sTime", sTime);
		request.setAttribute("macId", macId);
		request.setAttribute("eTime", eTime);
		request.setAttribute("companyName", companyName);
		StringBuffer webUrl=request.getRequestURL();
		request.setAttribute("webUrls", webUrl+"?name=1");
		
		return "log/offlinelogList";
	}
	
	
	
}
