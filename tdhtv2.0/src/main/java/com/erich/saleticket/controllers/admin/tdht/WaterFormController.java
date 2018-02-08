package com.erich.saleticket.controllers.admin.tdht;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erich.easyframe.util.SystemContext;
import com.erich.saleticket.biz.tdht.BalanceWaterBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.biz.tdht.ReportFormBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.model.sys.SysUserCompany;
import com.erich.saleticket.model.tdht.BalanceComfig;
import com.erich.saleticket.model.tdht.BalanceWater;
import com.erich.saleticket.model.tdht.Console;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewLineReport;
import com.erich.saleticket.model.tdht.ViewdaliyReport;

/**
 * 水量控制器
 * @author Lv
 */
public class WaterFormController extends BaseController {

	
	@Resource
	private ReportFormBiz reportFormBiz;
	@Resource
	private DataBiz dataBiz;
	Data<Console> result2 = new Data<Console>(ApiResultcode._0);
	@Resource
	private BalanceWaterBiz balanceBizs;
	/**
	 * 统计报表查询列表
	 * @throws ParseException 
	 */
	public String waterFormList_pdf(ViewdaliyReport viewdaliyReport,HttpServletRequest request, HttpServletResponse response) throws ParseException {
		
		String sTime=viewdaliyReport.getStartingTime();
		String eTime=viewdaliyReport.getEndTime();
		Integer minates=viewdaliyReport.getMinates();
		Integer type=viewdaliyReport.getType();//查询日期类型
		Long rid=viewdaliyReport.getRid();//公司ID
		String dateType=viewdaliyReport.getDateTypes();
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
		viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
		BalanceComfig comfig=new BalanceComfig();
		comfig.setRid(rid);
		BalanceWater balance=new BalanceWater();
		balance.setRid(rid);
		if(sTime==null  & dateType==null){
			minates=5;
			int offset = SystemContext.getOffset();
			
			Calendar cal = Calendar.getInstance(); 
			cal.set(Calendar.HOUR_OF_DAY, 0); 
			cal.set(Calendar.SECOND, 0); 
			cal.set(Calendar.MINUTE, 0); 
			sTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
			cal.set(Calendar.HOUR_OF_DAY, 23); 
			cal.set(Calendar.SECOND, 59); 
			cal.set(Calendar.MINUTE, 59);
			eTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
			
			dateType=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
			//ViewdaliyReport.setMinates(5);
			
			if(type==1){
				Calendar cal2 = Calendar.getInstance(); 
				  cal2.add(Calendar.DATE,   -1);
				  dateType=(new SimpleDateFormat("yyyy-MM-dd")).format(cal2.getTime()); 
				  comfig.setqStTime(dateType);
				  viewdaliyReport.setDateTypes(dateType);
				  balance.setDateTypes(dateType);
			}
			if(type==3){
				
				cal.set(Calendar.DAY_OF_MONTH, 1); 
				String  firstDate = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
				 comfig.setqStTime(firstDate);
				dateType=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
				viewdaliyReport.setDateTypes(dateType);
				 balance.setDateTypes(dateType);
			}
			if(type==6){
				
				dateType=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
				if(dateType.toString().equals("2016")){
					Date  sTime1=viewCompanyconfig.getStratTime();	
					sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
					 comfig.setqStTime(sTime);
				}else{
					cal.set(Calendar.MONTH, 1); 
					cal.set(Calendar.DAY_OF_MONTH, 1); 
					String  firstDate = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
					 comfig.setqStTime(firstDate);
					 
				}
				viewdaliyReport.setDateTypes(dateType);
				 balance.setDateTypes(dateType);
			}
			if(type==5){
				
			Date  sTime1=viewCompanyconfig.getStratTime();
				
				/*Calendar cal2 = Calendar.getInstance(); 
				  cal2.add(Calendar.DATE,   -7);
				  sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal2.getTime()); 
				   sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(viewCompanyconfig.getStartingTime());
				*/
			sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
				 comfig.setqStTime(sTime);
					
				eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
				  viewdaliyReport.setStartingTime(sTime);
				  viewdaliyReport.setEndTime(eTime);
				request.setAttribute("eTime", eTime);
				request.setAttribute("sTime", sTime);
				  balance.setStartingTime(sTime);
				  balance.setEndTime(eTime);
			}else if(type==11){
				viewdaliyReport.setStartingTime(sTime);
				viewdaliyReport.setEndTime(eTime);
			}
				
		}else{
			if(type==1){
				comfig.setqStTime(dateType);
				balance.setDateTypes(dateType);
			}
              if(type==3){
            	 String  dateType1=dateType+"-01";
				 comfig.setqStTime(dateType1);
				 balance.setDateTypes(dateType);
				viewdaliyReport.setDateTypes(dateType);
			}
              if(type==6){
            	 
  				
  				
  				if(dateType.toString().equals("2016")){
  					Date  sTime1=viewCompanyconfig.getStratTime();	
  					sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
  					 comfig.setqStTime(sTime);
  				}else{
  					
  				String	dateType1=dateType+"-01-01";
  	  	    comfig.setqStTime(dateType1);
  					
  					
  					 
  				}
  				viewdaliyReport.setDateTypes(dateType);
  				balance.setDateTypes(dateType);
  			}
              if(type==5){
            	  comfig.setqStTime(sTime);  
            	  balance.setStartingTime(sTime);
				  balance.setEndTime(eTime);
              }
		}	
		
		if(type!=11){
			
			
			
			
			
			String viewName="daliy_6";//日统计
			viewdaliyReport.setViewName(viewName);
			int i=reportFormBiz.insertBalanceTime(comfig);
			if(i>0){
				List<BalanceWater>balances=balanceBizs.BalanceList(balance);
			//  List<ViewdaliyReport> waters = reportFormBiz.selectByCriteria_pdf(viewdaliyReport);
			
              List<String>sytime=new ArrayList<String>();//系统时间
			
			for(int i1=0;i1<balances.size();i1++){
			
				String[] split = balances.get(i1).getStrTime().toString().split("\\s+");
				balances.get(i1).setStrTime1(split[0]);

			}
			
			List<Object>list=new ArrayList<Object>();
			list.add(0, balances);
			
			list.add(1, viewCompanyconfig);
			result2.setList(list);
			 result2.init(ApiResultcode._1, "成功");
			return "@" + encodeJson(result2);
			
			}
			
			return null;
			
			
		}else{
			String viewName="min_report";//历史统计
			viewdaliyReport.setViewName(viewName);	
			viewdaliyReport.setMinates(minates);
			
			if(minates==1440){
				
				 SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");  
			        Date date = null;  
			        date = formatter.parse(viewdaliyReport.getStartingTime());  
			      long ts=( date.getTime() - 60000 * date.getTimezoneOffset())/1000/60;
			      int times= (int)(ts%1440);
				viewdaliyReport.setRemainder(times);
			}else{
				viewdaliyReport.setRemainder(0);
			}
			
			/*int offset = SystemContext.getOffset();
			int pagesize = SystemContext.getPagesize();
			viewdaliyReport.getPager().setPageOffset(offset);
			viewdaliyReport.getPager().setPageSize(pagesize);
			viewdaliyReport.getPager().setOrderField("user_id");
			viewdaliyReport.getPager().setOrderDirection(false);
			viewdaliyReport.getPager().setRowCount(reportFormBiz.selectCountDay(viewdaliyReport));
			request.setAttribute("pager", viewdaliyReport.getPager());*/
			List<ViewLineReport> waters = reportFormBiz.selectByCriterias_pdf(viewdaliyReport);
			/*StringBuffer webUrl=request.getRequestURL();
			String url=webUrl+"?type="+type;
			request.setAttribute("webUrls", url);
			request.setAttribute("water", waters);
			request.setAttribute("minates", minates);
			request.setAttribute("eTime", eTime);
			request.setAttribute("sTime", sTime);
			request.setAttribute("type", type);
			request.setAttribute("rid", rid);
			request.setAttribute("dateTypes", dateType);
			request.setAttribute("Companyconfig", viewCompanyconfig);*/
			
			
			List<Object>list=new ArrayList<Object>();
			list.add(0, waters);
			
			list.add(1, viewCompanyconfig);
			result2.setList(list);
			 result2.init(ApiResultcode._1, "成功");
			return "@" + encodeJson(result2);
			
			
		}
	}
	
	/**
	 * 统计报表查询列表
	 * @throws ParseException 
	 */
public String waterFormList(ViewdaliyReport viewdaliyReport,HttpServletRequest request, HttpServletResponse response) throws ParseException {
		
		String sTime=viewdaliyReport.getStartingTime();
		String eTime=viewdaliyReport.getEndTime();
		Integer minates=viewdaliyReport.getMinates();
		Integer type=viewdaliyReport.getType();//查询日期类型
		Long rid=viewdaliyReport.getRid();//公司ID
		String dateType=viewdaliyReport.getDateTypes();
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
		viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
		BalanceComfig comfig=new BalanceComfig();
		comfig.setRid(rid);
		String  month=viewdaliyReport.getLat();//获取是查询前月还是后月
		BalanceWater balance=new BalanceWater();
		balance.setRid(rid);
		if(month != null){
			if(month.equals("前月")){
				DateFormat df = new SimpleDateFormat("yyyy-MM");
				 Date d1 = df.parse(dateType);
				 Calendar  g = Calendar.getInstance();
				 g.setTime(d1);  
				 g.add(Calendar.MONTH,-1);
				 Date d2 = g.getTime();
				 dateType=df.format(d2);
			}
			if(month.equals("后月")){
				DateFormat df = new SimpleDateFormat("yyyy-MM");
				 Date d1 = df.parse(dateType);
				 Calendar  g = Calendar.getInstance();
				 g.setTime(d1);  
				 g.add(Calendar.MONTH,+1);
				 Date d2 = g.getTime();
				 dateType=df.format(d2);
			}
		}
		
		
		if(sTime==null  & dateType==null){
			minates=5;
			int offset = SystemContext.getOffset();
			
			Calendar cal = Calendar.getInstance(); 
			cal.set(Calendar.HOUR_OF_DAY, 0); 
			cal.set(Calendar.SECOND, 0); 
			cal.set(Calendar.MINUTE, 0); 
			sTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
			cal.set(Calendar.HOUR_OF_DAY, 23); 
			cal.set(Calendar.SECOND, 59); 
			cal.set(Calendar.MINUTE, 59);
			eTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
			
			dateType=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
			//ViewdaliyReport.setMinates(5);
			
			if(type==1){
				Calendar cal2 = Calendar.getInstance(); 
				  cal2.add(Calendar.DATE,   -1);
				  dateType=(new SimpleDateFormat("yyyy-MM-dd")).format(cal2.getTime()); 
				  comfig.setqStTime(dateType);
				  viewdaliyReport.setDateTypes(dateType);
				  balance.setDateTypes(dateType);
			}
			if(type==3){
				
				cal.set(Calendar.DAY_OF_MONTH, 1); 
				String  firstDate = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
				 comfig.setqStTime(firstDate);
				dateType=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
				viewdaliyReport.setDateTypes(dateType);
				  balance.setDateTypes(dateType);
			}
			if(type==6){
				
				
				dateType=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
				if(dateType.toString().equals("2016")){
					Date  sTime1=viewCompanyconfig.getStratTime();	
					sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
					 comfig.setqStTime(sTime);
					 
				}else{
					cal.set(Calendar.MONTH, 1); 
					cal.set(Calendar.DAY_OF_MONTH, 1); 
					String  firstDate = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
					 comfig.setqStTime(firstDate);
					 
				}
				viewdaliyReport.setDateTypes(dateType);
				  balance.setDateTypes(dateType);
			}
			if(type==5){
				
			Date  sTime1=viewCompanyconfig.getStratTime();
				
				/*Calendar cal2 = Calendar.getInstance(); 
				  cal2.add(Calendar.DATE,   -7);
				  sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal2.getTime()); 
				   sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(viewCompanyconfig.getStartingTime());
				*/
			sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
				 comfig.setqStTime(sTime);
					
				eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
				  viewdaliyReport.setStartingTime(sTime);
				  viewdaliyReport.setEndTime(eTime);
				request.setAttribute("eTime", eTime);
				request.setAttribute("sTime", sTime);
				  balance.setStartingTime(sTime);
				  balance.setEndTime(eTime);
			}else if(type==11){
				viewdaliyReport.setStartingTime(sTime);
				viewdaliyReport.setEndTime(eTime);
			}
				
		}else{
			if(type==1){
				comfig.setqStTime(dateType);
				balance.setDateTypes(dateType);
			}
              if(type==3){
            	 String  dateType1=dateType+"-01";
				 comfig.setqStTime(dateType1);
				 balance.setDateTypes(dateType);
				viewdaliyReport.setDateTypes(dateType);
			}
              if(type==6){
            	 
  				
  				
  				if(dateType.toString().equals("2016")){
  					Date  sTime1=viewCompanyconfig.getStratTime();	
  					sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
  					 comfig.setqStTime(sTime);
  				}else{
  					
  				String	dateType1=dateType+"-01-01";
  	  	    comfig.setqStTime(dateType1);
  					
  					
  					 
  				}
  				balance.setDateTypes(dateType);
  				viewdaliyReport.setDateTypes(dateType);
  			}
              if(type==5){
            	  comfig.setqStTime(sTime); 
            	  balance.setStartingTime(sTime);
				  balance.setEndTime(eTime);
              }
		}	
		
		if(type!=11){
			
			
			
			/*WaterBalanceController waterBalance=new WaterBalanceController();
			waterBalance.BalanceList(balance, request, response);*/
			
			String viewName="daliy_6";//日统计
			viewdaliyReport.setViewName(viewName);
			int i=reportFormBiz.insertBalanceTime(comfig);
			if(i>0){
			
				
				
				//Long rid=balance.getRid();
				List<BalanceWater>balances=balanceBizs.BalanceList(balance);
				int offset = SystemContext.getOffset();
				int pagesize = SystemContext.getPagesize();
				viewdaliyReport.getPager().setPageOffset(offset);
				viewdaliyReport.getPager().setPageSize(pagesize); 
				viewdaliyReport.getPager().setOrderField("user_id");
				viewdaliyReport.getPager().setOrderDirection(false);
				//viewdaliyReport.getPager().setRowCount(reportFormBiz.selectCountDay(viewdaliyReport));
				viewdaliyReport.getPager().setRowCount(balances.size());
				request.setAttribute("pager", viewdaliyReport.getPager());
			//	List<ViewdaliyReport> waters = reportFormBiz.selectByCriteria(viewdaliyReport);
				
				request.setAttribute("water", balances);
			
			}
			
			if(type==5){
				request.setAttribute("eTime", eTime);
				request.setAttribute("sTime", sTime);
			}
			StringBuffer webUrl=request.getRequestURL();
			String url=webUrl+"?type="+type;
			request.setAttribute("webUrls", url);
			request.setAttribute("type", type);
			request.setAttribute("rid", rid);
			request.setAttribute("dateTypes", dateType);
			request.setAttribute("Companyconfig", viewCompanyconfig);
			
		}else{
			String viewName="min_report";//历史统计
			viewdaliyReport.setViewName(viewName);	
			viewdaliyReport.setMinates(minates);
			if(minates==1440){
				
				 SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");  
			        Date date = null;  
			        date = formatter.parse(viewdaliyReport.getStartingTime());  
			      long ts=( date.getTime() - 60000 * date.getTimezoneOffset())/1000/60;
			      int times= (int)(ts%1440);
				viewdaliyReport.setRemainder(times);
			}else{
				viewdaliyReport.setRemainder(0);
			}
			SysUserCompany sysUserCompany=getUserCompany(request);
			
			int offset = SystemContext.getOffset();
			int pagesize = SystemContext.getPagesize();
			viewdaliyReport.getPager().setPageOffset(offset);
			viewdaliyReport.getPager().setPageSize(pagesize);
			viewdaliyReport.getPager().setOrderField("user_id");
			viewdaliyReport.getPager().setOrderDirection(false);
			viewdaliyReport.getPager().setRowCount(reportFormBiz.selectCountDay(viewdaliyReport));
			request.setAttribute("pager", viewdaliyReport.getPager());

			if(sysUserCompany.getCompanyId()==2000){
				List<ViewLineReport> waters = reportFormBiz.selectByCriteria2_water(viewdaliyReport);
				StringBuffer webUrl=request.getRequestURL();
				String url=webUrl+"?type="+type;
				request.setAttribute("webUrls", url);
				request.setAttribute("water", waters);
				request.setAttribute("minates", minates);
				request.setAttribute("eTime", eTime);
				request.setAttribute("sTime", sTime);
				request.setAttribute("type", type);
				request.setAttribute("rid", rid);
				request.setAttribute("dateTypes", dateType);
				request.setAttribute("Companyconfig", viewCompanyconfig);
				return "water/waterList2";
				}else{

					List<ViewLineReport> waters = reportFormBiz.selectByCriteria2(viewdaliyReport);
					StringBuffer webUrl=request.getRequestURL();
					String url=webUrl+"?type="+type;
					request.setAttribute("webUrls", url);
					request.setAttribute("water", waters);
					request.setAttribute("minates", minates);
					request.setAttribute("eTime", eTime);
					request.setAttribute("sTime", sTime);
					request.setAttribute("type", type);
					request.setAttribute("rid", rid);
					request.setAttribute("dateTypes", dateType);
					request.setAttribute("Companyconfig", viewCompanyconfig);
					return "water/waterList";
				}
			
	
		}
		
		
		return "water/waterList";
	}
	
	
}
