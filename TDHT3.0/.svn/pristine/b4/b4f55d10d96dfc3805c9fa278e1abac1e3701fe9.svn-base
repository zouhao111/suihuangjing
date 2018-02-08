package com.fh.controller.Data.Report;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.system.Menu;
import com.fh.entity.system.StringDataLongTime;
import com.fh.service.system.his_report.His_ReportManager;
import com.fh.service.system.newdata.NewDataManager;
import com.fh.service.system.poll_sum.Poll_SumManager;
import com.fh.service.system.report_poll.Report_PollManager;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
@Controller
public class ReportData  extends BaseController {
	@Resource(name="His_ReportService")
	private His_ReportManager His_ReportService;
	
	@Resource(name="NewDataService")
	private NewDataManager NewDataService;
	@Resource(name="Rrport_PollService")
	private Report_PollManager Rrport_PollService;
	@Resource(name="Poll_SumService")
	private Poll_SumManager Poll_SumService;
	
	/**
	 * 进入首页后的默认页面
	 * @return
	 * @throws Exception 
	 */
	
	@RequestMapping(value="/listReport")
	public ModelAndView ListReport(String R_ID,String ROLE_NAME,String MENU_ID,String MENU_IDS) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd=this.getPageData();
		
		Session session = Jurisdiction.getSession();
		
		List<Menu> allmenuList = new ArrayList<Menu>();
		List<Menu> allmenuLists = new ArrayList<Menu>();
		List<Menu> allmenuListss = new ArrayList<Menu>();
		allmenuList = (List<Menu>)session.getAttribute(ROLE_NAME + Const.SESSION_allmenuList);
		for(int i=0;i<allmenuList.size();i++){
			if(allmenuList.get(i).getMENU_ID().equals(MENU_IDS)){
				allmenuLists=allmenuList.get(i).getSubMenu();
			}
		}
		for(int i=0;i<allmenuLists.size();i++){
			if(allmenuLists.get(i).getMENU_ID().equals(MENU_ID)){
				allmenuListss=allmenuLists.get(i).getSubMenu();
			}
		}
		
		for(int a=0;a<allmenuListss.size();a++){
			mv.addObject("list"+a,allmenuListss.get(a));
		}
		List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表
        
		mv.addObject("pd",pd);
		mv.addObject("R_ID",R_ID);
		mv.addObject("list",allmenuListss);
		mv.addObject("ROLE_NAME",ROLE_NAME);
		mv.addObject("varList",varList);
		mv.addObject("menuUrl","listReport.do?MENU_ID="+MENU_ID+"&MENU_IDS="+MENU_IDS+"&R_ID=");
		mv.setViewName("report/roport_list");
		return mv;
	} 
	public Double fixed(Double d,int i){
		BigDecimal   b1   =   new   BigDecimal(d);  
		Double   num   =   b1.setScale(i,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
		return num;
	}
	@RequestMapping(value="/List_report_poll")
	@ResponseBody
	public Object List_report_poll(int limit,int offset,String R_ID,int from,String strTime,String end_strTime) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("limit", limit);
		pd.put("offset", offset);
		
		if(from==2){
			String startstrTime=strTime+"-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			Date dd=StringDataLongTime.stringToDate(startstrTime, "yyyy-MM-dd hh:mm");
			/*Calendar calendar = new GregorianCalendar();  
			calendar.setTime(dd);
			calendar.add(Calendar.MONTH,1); 
		        calendar.set(Calendar.DAY_OF_MONTH, 0);  
		        Date enddateTime=calendar.getTime();*/
			 String endstrTime= StringDataLongTime.getMaxMonthDate(startstrTime);
		        endstrTime=endstrTime+" 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		if(from==4){
			String startstrTime=strTime+"-01-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=strTime+"-12-31 23:59";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				    
		}
		if(from==5){
			String startstrTime=strTime+" 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=end_strTime+" 23:59";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表
        
		
		
		
		List<PageData>	varList1=new ArrayList<PageData>();
		List<PageData>	varList2=new ArrayList<PageData>();
		List<PageData>	varList3=new ArrayList<PageData>();
		if(varList!=null){
			
		
		for(int a=0;a<varList.size();a++){
			if(varList.get(a).getInteger("param_type")==7){
				varList1.add(varList.get(a));
			}
			if(varList.get(a).getInteger("param_type")==8){
				varList2.add(varList.get(a));
			}
			if(varList.get(a).getInteger("param_type")==9){
				varList3.add(varList.get(a));
			}
		}
		}
		
		
	//List<PageData>	poll_day_avg=Rrport_PollService.poll_day_avg(pd);  //查询所有水类型
		
		
		
		
		
		
		List<PageData>	poll_day_avg1 = Rrport_PollService.poll_day_avg1(pd);	//列出Conf_param列表
		List<PageData>	poll_day_avg2 = Rrport_PollService.poll_day_avg2(pd);	//列出Conf_param列表
		List<PageData>	poll_day_avg3 = Rrport_PollService.poll_day_avg3(pd);	//列出Conf_param列表
		
		
		List<PageData>	poll_day=new ArrayList<PageData>();
		List<PageData>	poll_day_min=new ArrayList<PageData>();
		if(varList1.size()!=0&&poll_day_avg1!=null){
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int j=0;j<poll_day_avg1.size();j++){
			
			PageData pds=new PageData();
		for(int i=0;i<varList1.size();i++){
			    pds.put("str_time",sdf.format(poll_day_avg1.get(j).get("str_time")));
				pds.put(varList1.get(i).getString("param_name_sql"),fixed(poll_day_avg1.get(j).getDouble(varList1.get(i).getString("param_name_sql")),varList1.get(i).getInteger("decimal_number")));
			}
		
		poll_day.add(pds);
		}
		}
		
		if(varList2.size()!=0&&poll_day_avg2!=null){
			
			for(int j=0;j<poll_day_avg2.size();j++){
				
				PageData pds=new PageData();
			for(int i=0;i<varList2.size();i++){
				
					pds.put(varList2.get(i).getString("param_name_sql"),fixed(poll_day_avg2.get(j).getDouble(varList2.get(i).getString("param_name_sql")),varList2.get(i).getInteger("decimal_number")));
				}
			
			poll_day.add(pds);
			}
			}
		
		
		if(varList3.size()!=0&&poll_day_avg3!=null){
			
			for(int j=0;j<poll_day_avg3.size();j++){
				
				PageData pds=new PageData();
			for(int i=0;i<varList3.size();i++){
					pds.put(varList3.get(i).getString("param_name_sql"),fixed(poll_day_avg3.get(j).getDouble(varList3.get(i).getString("param_name_sql")),varList3.get(i).getInteger("decimal_number")));
				}
			
			poll_day.add(pds);
			}
			}
		
	//	List<PageData> rows=poll_day.subList(offset, offset+limit);
		
	//	map.put("rows", rows);
		map.put("total", poll_day.size());
		map.put("data",poll_day);
		JSONObject json = JSONObject.fromObject(map);
		return  json;
	}
	@RequestMapping(value="/Line_report_poll")
	@ResponseBody
	public Object Line_report_poll(String R_ID,int from,String startTime1,String endTime1) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(from==1){
			String startstrTime=startTime1+ " 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			
			String endstrTime=startTime1+" 23:59";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		if(from==2){
			String startstrTime=startTime1+"-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			
			Date dd=StringDataLongTime.stringToDate(startstrTime, "yyyy-MM-dd hh:mm");
			/*Calendar calendar = new GregorianCalendar();  
			calendar.setTime(dd);
			calendar.add(Calendar.MONTH,1); 
		        calendar.set(Calendar.DAY_OF_MONTH, 0);  
		        Date enddateTime=calendar.getTime();*/
			 String endstrTime= StringDataLongTime.getMaxMonthDate(startstrTime);
		        endstrTime=endstrTime+" 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		if(from==4){
			String startstrTime=startTime1+" 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=startTime1+" 23:59";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		if(from==5){
			String startstrTime=startTime1+"-01-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=endTime1+"-12-31 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		List<String>strTimes=new ArrayList<String>();	
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表

		List<PageData>	varList1=new ArrayList<PageData>();
		List<PageData>	varList2=new ArrayList<PageData>();
		List<PageData>	varList3=new ArrayList<PageData>();
		List<String>poll_type=new ArrayList<String>();
		String  str="";
		String  str2="";
		if(from==4){
			Date date =StringDataLongTime.stringToDate(startTime1,"yyyy");
			   str=StringDataLongTime.dateToString(date,"yyyy");
			 	
		} else if(from==5){
			str="_";
			   
		}else{
			Date date =StringDataLongTime.stringToDate(startTime1,"yyyy-MM");
			   str=StringDataLongTime.dateToString(date,"yyyyMM");
		}
		
		/*if(varList!=null){
			
		
		for(int a=0;a<varList.size();a++){
			poll_type.add(varList.get(a).getString("param_name_cn"));
			if(varList.get(a).getInteger("param_type")==7){
				varList1.add(varList.get(a));
			}
			if(varList.get(a).getInteger("param_type")==8){
				varList2.add(varList.get(a));
			}
			if(varList.get(a).getInteger("param_type")==9){
				varList3.add(varList.get(a));
			}
		}
		}*/
		
		List<PageData>	poll_day_avg1 = Rrport_PollService.poll_day_avg1(pd);	//列出Conf_param列表
		List<PageData>	poll_day_avg2 = Rrport_PollService.poll_day_avg2(pd);	//列出Conf_param列表
		List<PageData>	poll_day_avg3 = Rrport_PollService.poll_day_avg3(pd);	//列出Conf_param列表
		
		
		List<PageData>	poll_day=new ArrayList<PageData>();
		List<PageData>	poll_day_min=new ArrayList<PageData>();
		
		for(int i=0;i<varList.size();i++){
			poll_type.add(varList.get(i).getString("param_name_cn"));
			/*if(i==0){
				poll_type_select.add(varList.get(i).getString("param_name_cn")+":true");
			}else{
			poll_type_select.add(varList.get(i).getString("param_name_cn")+":false");
			}*/
			if(varList.get(i).getInteger("param_type")==7&&poll_day_avg1!=null){
				List<Double>list1=new ArrayList<Double>();
				for(int a=0;a<poll_day_avg1.size();a++){
					
					
				   list1.add(fixed(poll_day_avg1.get(a).getDouble(varList.get(i).getString("param_name_sql")),varList.get(i).getInteger("decimal_number")));
				}	
				 
				varList.get(i).put("dataList", list1);
				
				
			}else if(varList.get(i).getInteger("param_type")==8&&poll_day_avg2!=null){
				List<Double>list1=new ArrayList<Double>();
				for(int a=0;a<poll_day_avg2.size();a++){
				   list1.add(fixed(poll_day_avg2.get(a).getDouble(varList.get(i).getString("param_name_sql")),varList.get(i).getInteger("decimal_number")));
				}	
				
				varList.get(i).put("dataList", list1);
				
			}else if(varList.get(i).getInteger("param_type")==9&&poll_day_avg3!=null){
				List<Double>list1=new ArrayList<Double>();
				for(int a=0;a<poll_day_avg3.size();a++){
					
					
				   list1.add(fixed(poll_day_avg3.get(a).getDouble(varList.get(i).getString("param_name_sql")),varList.get(i).getInteger("decimal_number")));
				}	
				
				varList.get(i).put("dataList", list1);
			}
		}
		if(poll_day_avg1!=null){
			for(int a=0;a<poll_day_avg1.size();a++){
				
					strTimes.add(sdf.format(poll_day_avg1.get(a).get("str_time")));
				
			}
		}else if(poll_day_avg1==null&&poll_day_avg2!=null){
			for(int a=0;a<poll_day_avg2.size();a++){
			if(strTimes.size()==0){
				
					strTimes.add(sdf.format(poll_day_avg2.get(a).get("str_time")));
				
			}
			}
		}else if(poll_day_avg1==null&&poll_day_avg2==null&&poll_day_avg3!=null){
			for(int a=0;a<poll_day_avg3.size();a++){
			if(strTimes.size()==0){
				
					strTimes.add(sdf.format(poll_day_avg3.get(a).get("str_time")));
				
			}
			}
		}
		
	/*	if(poll1!=null){
			for(int a=0;a<poll1.size();a++){
				
					strTimes.add(sdf.format(poll1.get(a).get("str_time")));
				
			}
		}else if(poll1==null&&poll2!=null){
			for(int a=0;a<poll1.size();a++){
			if(strTimes.size()==0){
				
					strTimes.add(sdf.format(poll2.get(a).get("str_time")));
				
			}
			}
		}else if(poll1==null&&poll2==null&&poll3!=null){
			for(int a=0;a<poll1.size();a++){
			if(strTimes.size()==0){
				
					strTimes.add(sdf.format(poll3.get(a).get("str_time")));
				
			}
			}
		}
	
		
		
		if(varList1.size()!=0&&poll_day_avg1!=null){
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int j=0;j<poll_day_avg1.size();j++){
			
			PageData pds=new PageData();
		for(int i=0;i<varList1.size();i++){
			    pds.put("str_time",sdf.format(poll_day_avg1.get(j).get("str_time")));
				pds.put(varList1.get(i).getString("param_name_sql"),fixed(poll_day_avg1.get(j).getDouble(varList1.get(i).getString("param_name_sql")),varList1.get(i).getInteger("decimal_number")));
			}
		
		poll_day.add(pds);
		}
		}
		
		if(varList2.size()!=0&&poll_day_avg2!=null){
			
			for(int j=0;j<poll_day_avg2.size();j++){
				
				PageData pds=new PageData();
			for(int i=0;i<varList2.size();i++){
				
					pds.put(varList2.get(i).getString("param_name_sql"),fixed(poll_day_avg2.get(j).getDouble(varList2.get(i).getString("param_name_sql")),varList2.get(i).getInteger("decimal_number")));
				}
			
			poll_day.add(pds);
			}
			}
		
		
		if(varList3.size()!=0&&poll_day_avg3!=null){
			
			for(int j=0;j<poll_day_avg3.size();j++){
				
				PageData pds=new PageData();
			for(int i=0;i<varList3.size();i++){
					pds.put(varList3.get(i).getString("param_name_sql"),fixed(poll_day_avg3.get(j).getDouble(varList3.get(i).getString("param_name_sql")),varList3.get(i).getInteger("decimal_number")));
				}
			
			poll_day.add(pds);
			}
			}*/
		
		/*Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "success";
	//PageData	varOne = NewDataService.selectOne(pd);	//列出Conf_param列表
        
	List<PageData>	max_one_poll =new ArrayList<PageData>();
	List<PageData>	min_one_poll =new ArrayList<PageData>();
		
	
	
	if(varList!=null){
			if(varOne.getInteger("param_type")==7){
			String 	tableName="calc_quality_01_day_max";
			pd.put("tableName", tableName);
					max_one_poll = Rrport_PollService.poll_one_day(pd);	//列出Conf_param列表
				tableName="calc_quality_01_day_min";
				pd.put("tableName", tableName);
					min_one_poll = Rrport_PollService.poll_one_day(pd);	//列出Conf_param列表
			}
			if(varOne.getInteger("param_type")==8){
				String 	tableName="calc_quality_02_day_max";
				pd.put("tableName", tableName);
					max_one_poll = Rrport_PollService.poll_one_day(pd);	//列出Conf_param列表
				tableName="calc_quality_02_day_min";
			    pd.put("tableName", tableName);
					min_one_poll = Rrport_PollService.poll_one_day(pd);	//列出Conf_param列表
			}
			if(varOne.getInteger("param_type")==9){
				String 	tableName="calc_quality_03_day_max";
				pd.put("tableName", tableName);
					max_one_poll = Rrport_PollService.poll_one_day(pd);	//列出Conf_param列表
				tableName="calc_quality_03_day_min";
				pd.put("tableName", tableName);
					min_one_poll = Rrport_PollService.poll_one_day(pd);	//列出Conf_param列表
			}
		
		}
		List<String>strTimes=new ArrayList<String>();//系统时间
		List<Double>max_polls=new ArrayList<Double>();
		List<Double>min_polls=new ArrayList<Double>();
		
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(max_one_poll!=null&&min_one_poll!=null){
			for(int i=0;i<max_one_poll.size();i++){
				strTimes.add(sdf.format(max_one_poll.get(i).get("str_time")));
				max_polls.add(fixed(max_one_poll.get(i).getDouble("value"),varOne.getInteger("decimal_number")));
			}
			for(int i=0;i<min_one_poll.size();i++){
				min_polls.add(fixed(min_one_poll.get(i).getDouble("value"),varOne.getInteger("decimal_number")));
			}
		}
		
		*/
		String errInfo = "success";
		map.put("strTimes", strTimes);
		map.put("poll_day", varList);
		map.put("poll_type", poll_type);
		
		map.put("result", errInfo);	
		return AppUtil.returnObject(new PageData(), map);
	}
	
	@RequestMapping(value="/line_poll_sum")
	@ResponseBody
	public Object line_poll_sum(String R_ID,int from,String startTime2,String endTime2) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		long startTime=0;
		long endTime=0;
		if(from==1){
			String startstrTime=startTime2+ " 00:00";
			 startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			
			String endstrTime=startTime2+" 23:59";
		     endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		if(from==2){
			String startstrTime=startTime2+"-01 00:00";
			 startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			Date dd=StringDataLongTime.stringToDate(startstrTime, "yyyy-MM-dd hh:mm");
			/*Calendar calendar = new GregorianCalendar();  
			calendar.setTime(dd);
			calendar.add(Calendar.MONTH,1); 
		        calendar.set(Calendar.DAY_OF_MONTH, 0);  
		        Date enddateTime=calendar.getTime();*/
			 String endstrTime= StringDataLongTime.getMaxMonthDate(startstrTime);
		        endstrTime=endstrTime+" 00:00";
		     endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		if(from==4){
			String startstrTime=startTime2+"-01-01 00:00";
			 startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=startTime2+"-12-31 00:00";
		     endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		if(from==5){
			String startstrTime=startTime2+" 00:00";
			 startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=endTime2+" 23:59";
		     endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "success";
		List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表
		List<String>strTimes=new ArrayList<String>();//系统时间
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<PageData>	poll1=new ArrayList<PageData>();
		List<PageData>	poll2=new ArrayList<PageData>();
		List<PageData>	poll3=new ArrayList<PageData>();

		List<PageData>	poll1_s=new ArrayList<PageData>();
		List<PageData>	poll2_s=new ArrayList<PageData>();
		List<PageData>	poll3_s=new ArrayList<PageData>();
		String  str="";
		if(from==4){
			Date date =StringDataLongTime.stringToDate(startTime2,"yyyy");
			   str=StringDataLongTime.dateToString(date,"yyyy");
			 	
		}else if(from==5){
			   str="_";
			 	
		}else{
			Date date =StringDataLongTime.stringToDate(startTime2,"yyyy-MM");
			   str=StringDataLongTime.dateToString(date,"yyyyMM");
		} 
			 for(int a=1;a<=3;a++){
					
					List<PageData>	TabName=new ArrayList<PageData>();
					if(a==1){
						pd.put("tabAllName", "calc_quality_01_5min_w_%%");
						TabName=NewDataService.selectAllTabName(pd);	
						if(TabName!=null){
							for(int i=0;i<TabName.size();i++){
								List<PageData>	poll1s=new ArrayList<PageData>();
							 if(TabName.get(i).getString("TABLE_NAME").contains(str)){
								 pd.put("tabName", TabName.get(i).getString("TABLE_NAME"));
								 if(from==1){
									 poll1s=Poll_SumService.list_poll_hour_sum1(pd);
								 }else{
									 poll1s=Poll_SumService.list_poll_day_sum1(pd); 
								 }
								 if(poll1s!=null){
									 poll1_s.addAll(poll1s); 
								 }
								
								  }
							}
						}
						
					}else if(a==2){
						pd.put("tabAllName", "calc_quality_02_5min_w_%%");
							TabName=NewDataService.selectAllTabName(pd);
							if(TabName!=null){
								for(int i=0;i<TabName.size();i++){
									List<PageData>	poll1s=new ArrayList<PageData>();
								 if(TabName.get(i).getString("TABLE_NAME").contains(str)){
									 pd.put("tabName", TabName.get(i).getString("TABLE_NAME"));
									 if(from==1){
										 poll1s=Poll_SumService.list_poll_hour_sum2(pd);
										 }else{
											 poll1s=Poll_SumService.list_poll_day_sum2(pd); 
										 }
									 if(poll1s!=null){
										 poll2_s.addAll(poll1s); 
									 }
									  }
								}
							}
					}else if(a==3){
						pd.put("tabAllName", "calc_quality_03_5min_w_%%");
							TabName=NewDataService.selectAllTabName(pd);
							if(TabName!=null){
								for(int i=0;i<TabName.size();i++){
									List<PageData>	poll1s=new ArrayList<PageData>();
								 if(TabName.get(i).getString("TABLE_NAME").contains(str)){
									 pd.put("tabName", TabName.get(i).getString("TABLE_NAME"));
									
									 if(from==1){
										 poll1s=Poll_SumService.list_poll_hour_sum3(pd);
										 }else{
											 poll1s=Poll_SumService.list_poll_day_sum3(pd); 
										 }
									 if(poll1s!=null){
										 poll3_s.addAll(poll1s); 
									 }
								 }
							   }
							}
					}
					
					
			 }
		
			 if(from==5){
				 if(poll1_s!=null){
					 for(int a=0;a<poll1_s.size();a++){
						 long l=(long)poll1_s.get(a).getInteger("sy_time");
						 if(l>=startTime&&l<endTime){
							 poll1.add(poll1_s.get(a)); 
						 }
					 }
				 }
				 if(poll2_s!=null){
					 for(int a=0;a<poll2_s.size();a++){
						 long l=(long)poll2_s.get(a).getInteger("sy_time");
						 if(l>=startTime&&l<endTime){
							 poll2.add(poll2_s.get(a)); 
						 }
					 }
				 }
				 if(poll3_s!=null){
					 for(int a=0;a<poll3_s.size();a++){
						 long l=(long)poll3_s.get(a).getInteger("sy_time");
						 if(l>=startTime&&l<endTime){
							 poll3.add(poll3_s.get(a)); 
						 }
					 }
				 }
			 }else{
				 poll1= poll1_s;
				 poll2= poll2_s;
				 poll3= poll3_s;
			 }
		
	/*	if(from==1){
||||||| .r658
		if(from==1){
=======
	/*	if(from==1){
>>>>>>> .r660
			
		
			poll1=Poll_SumService.list_poll_hour_sum1(pd);
			poll2=Poll_SumService.list_poll_hour_sum2(pd);
			poll3=Poll_SumService.list_poll_hour_sum3(pd);
		}else{
			poll1=Poll_SumService.list_poll_day_sum1(pd);
			poll2=Poll_SumService.list_poll_day_sum2(pd);
			poll3=Poll_SumService.list_poll_day_sum3(pd);
		}*/
		List<String>poll_type=new ArrayList<String>(); 
		for(int i=0;i<varList.size();i++){
			poll_type.add(varList.get(i).getString("param_name_cn"));
			if(varList.get(i).getInteger("param_type")==7&&poll1!=null){
				List<Double>list1=new ArrayList<Double>();
				for(int a=0;a<poll1.size();a++){
					
					
				   list1.add(fixed(poll1.get(a).getDouble(varList.get(i).getString("param_name_sql")),varList.get(i).getInteger("decimal_number")));
				}	
				 Double sumPoll=0.0;
				for ( Double elem : list1)
					sumPoll += elem;
				varList.get(i).put("sumPoll", sumPoll);
				varList.get(i).put("dataList", list1);
				
				
			}else if(varList.get(i).getInteger("param_type")==8&&poll2!=null){
				List<Double>list1=new ArrayList<Double>();
				for(int a=0;a<poll2.size();a++){
				   list1.add(fixed(poll2.get(a).getDouble(varList.get(i).getString("param_name_sql")),varList.get(i).getInteger("decimal_number")));
				}	
				 Double sumPoll=0.0;
					for ( Double elem : list1)
						sumPoll += elem;
					varList.get(i).put("sumPoll", sumPoll);
				varList.get(i).put("dataList", list1);
				
			}else if(varList.get(i).getInteger("param_type")==9&&poll3!=null){
				List<Double>list1=new ArrayList<Double>();
				for(int a=0;a<poll3.size();a++){
					
					
				   list1.add(fixed(poll3.get(a).getDouble(varList.get(i).getString("param_name_sql")),varList.get(i).getInteger("decimal_number")));
				}	
				 Double sumPoll=0.0;
					for ( Double elem : list1)
						sumPoll += elem;
					varList.get(i).put("sumPoll", sumPoll);
				varList.get(i).put("dataList", list1);
			}
		}
		if(poll1!=null){
			for(int a=0;a<poll1.size();a++){
				if(from==1){
					DateFormat sdfss = new SimpleDateFormat("hh");
					
					 strTimes.add(sdfss.format(poll1.get(a).get("str_time"))+":00");
				}else{
					strTimes.add(sdf.format(poll1.get(a).get("str_time")));
				}
			}
		}else if(poll1==null&&poll2!=null){
			for(int a=0;a<poll2.size();a++){
			if(strTimes.size()==0){
				if(from==1){
					DateFormat sdfss = new SimpleDateFormat("hh");
					
					 strTimes.add(sdfss.format(poll2.get(a).get("str_time"))+":00");
				}else{
					strTimes.add(sdf.format(poll2.get(a).get("str_time")));
				}
			}
			}
		}else if(poll1==null&&poll2==null&&poll3!=null){
			for(int a=0;a<poll3.size();a++){
			if(strTimes.size()==0){
				if(from==1){
					DateFormat sdfss = new SimpleDateFormat("hh");
					
					 strTimes.add(sdfss.format(poll3.get(a).get("str_time"))+":00");
				}else{
					strTimes.add(sdf.format(poll3.get(a).get("str_time")));
				}
			}
			}
		}
		
		map.put("poll_type", poll_type);
		
		map.put("strTimes", strTimes);
		map.put("varList", varList);
		map.put("result", errInfo);	
		return AppUtil.returnObject(new PageData(), map);
	}
	
}
