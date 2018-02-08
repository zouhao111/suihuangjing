package com.fh.controller.system.warning;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.system.Menu;
import com.fh.entity.system.StringDataLongTime;
import com.fh.service.system.newdata.NewDataManager;
import com.fh.service.system.warning.WarningManager;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
public class WarningController extends BaseController {
	
	String menuUrl = "warning/listWarning.do"; //菜单地址(权限用)
	@Resource(name="NewDataService")
	private NewDataManager NewDataService;
	@Resource(name="WarningService")
	private WarningManager WarningService;
	
	/**
	 * 进入参数报警页面
	 * @return
	 */
	@RequestMapping(value="/listWarning")
	public ModelAndView listWarning(HttpServletRequest request,Page page,String ROLE_NAME,String MENU_ID,String R_ID,String MENU_IDS) throws Exception{
		
		ModelAndView mv = this.getModelAndView();
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
		
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("R_ID", R_ID);
		List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表
		
		mv.addObject("pd",pd);
		mv.addObject("R_ID",R_ID);
		mv.addObject("varList",varList);
		mv.addObject("list",allmenuListss);
		mv.addObject("ROLE_NAME",ROLE_NAME);
		mv.addObject("menuUrl","listWarning.do?MENU_ID="+MENU_ID+"&MENU_IDS="+MENU_IDS+"&R_ID=");
		mv.setViewName("system/warning/warning_list");
		return mv;
	}
	
	@RequestMapping(value="/Now_warning")
	@ResponseBody
	public Object Now_warning(String R_ID) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "success";
		List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表
		
		//List<PageData>	warningList =new ArrayList<PageData>();
		//List<PageData>	early_warningList =new ArrayList<PageData>();
		String tabName="calc_warning_";
		String tabName2="calc_early_warning_";
		if(varList!=null){
		for(int i=0;i<varList.size();i++){
			pd.put("tabName", tabName+varList.get(i).getInteger("limit_type"));
			pd.put("tabName2", tabName2+varList.get(i).getInteger("limit_type"));
			PageData pds=WarningService.select_now_warning(pd);
			PageData pdss=WarningService.select_now_early_warning(pd);
			
			if(pds!=null){
				varList.get(i).put("warning", pds);
			}
			if(pdss!=null){
				varList.get(i).put("early_warning", pdss);
			}
		}
		
		}
		
		//map.put("warningList", warningList);
		//map.put("early_warningList", early_warningList);
		map.put("varList", varList);
		map.put("result", errInfo);	
		return AppUtil.returnObject(new PageData(), map);
	}
	@RequestMapping(value="/Warning_count")
	@ResponseBody
	public Object Warning_count(int from,String startTime1,String endTime1,String R_ID) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
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
			String startstrTime=startTime1+"-01-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=startTime1+"-12-31 23:59";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				    
		}
		if(from==5){
			String startstrTime=startTime1+" 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=endTime1+" 23:59";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "success";
		List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表
		
		List<PageData>	warningList =new ArrayList<PageData>();
		String tabName="calc_warning_";
		if(varList!=null){
		for(int i=0;i<varList.size();i++){
			pd.put("tabName", tabName+varList.get(i).getInteger("limit_type"));
				warningList=WarningService.select_his_warning(pd);
			
			if(warningList!=null){
				varList.get(i).put("warning_count", warningList.size());
			}
		}
		
		}
		
		
		map.put("varList", varList);
		map.put("result", errInfo);	
		return AppUtil.returnObject(new PageData(), map);
	}
	@RequestMapping(value="/Early_Warning_count")
	@ResponseBody
	public Object Early_Warning_count(int from,String startTime2,String endTime2,String R_ID) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		if(from==1){
			String startstrTime=startTime2+ " 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			
			String endstrTime=startTime2+" 23:59";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		if(from==2){
			String startstrTime=startTime2+"-01 00:00";
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
			String startstrTime=startTime2+"-01-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=startTime2+"-12-31 23:59";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				    
		}
		if(from==5){
			String startstrTime=startTime2+" 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=endTime2+" 23:59";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "success";
		List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表
		
		List<PageData>	early_warningList =new ArrayList<PageData>();
		String tabName2="calc_early_warning_";
		if(varList!=null){
		for(int i=0;i<varList.size();i++){
			pd.put("tabName2", tabName2+varList.get(i).getInteger("limit_type"));
				early_warningList=WarningService.select_his_early_warning(pd);
			
			if(early_warningList!=null){
				varList.get(i).put("early_warning_count", early_warningList.size());
			}
		}
		
		}
		
		
		map.put("varList", varList);
		map.put("result", errInfo);	
		return AppUtil.returnObject(new PageData(), map);
	}
	
	@RequestMapping(value="/Warning_His")
	@ResponseBody
	public Object Warning_His(int limit,int offset,int from,String strTime,String end_strTime,String R_ID,int warning_type,String mySelect) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("limit", limit);
		pd.put("offset", offset);
		if(from==1){
			String startstrTime=strTime+ " 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			
			String endstrTime=strTime+" 23:59";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
				        
		}
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
		
		
		PageData	varOne = NewDataService.selectOne(pd);	//列出Conf_param列表
		String tabName="";
		String tabName2="";
		
		
		//List<PageData>	early_warningList =new ArrayList<PageData>();
		List<PageData>	warningList =new ArrayList<PageData>();
		PageData	warningList_count =new PageData();
		if(varOne!=null){
		
			if(warning_type==1){
				tabName="calc_warning_";
				pd.put("tabName", tabName+varOne.getInteger("limit_type"));
				
			}else{
				
				tabName2="calc_early_warning_";
				pd.put("tabName2", tabName2+varOne.getInteger("limit_type"));
			}
			warningList=WarningService.his_early_warning(pd);
			warningList_count=WarningService.his_early_warning_count(pd);
		}
		List<PageData>	warning_his=new ArrayList<PageData>();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		if(warningList!=null){	
			for(int i=0;i<warningList.size();i++){
				PageData pds=new PageData();
				pds.put("str_time", sdf.format(warningList.get(i).get("str_time")));
				pds.put("com_name", varOne.getString("r_name_cn"));
				pds.put("param_name_cn", varOne.getString("param_name_cn"));
				if(warning_type==1){
					pds.put("limitHH", warningList.get(i).getDouble("limitHH"));
					pds.put("limitLL", warningList.get(i).getDouble("limitLL"));
				}else{
					pds.put("limitHH", warningList.get(i).getDouble("limitH"));
					pds.put("limitLL", warningList.get(i).getDouble("limitL"));
				}
				
				pds.put("calc_value", warningList.get(i).getDouble("calc_value"));
				
				warning_his.add(pds);
			}
		}
		
		
		int total=Integer.parseInt(String.valueOf(warningList_count.getLong("count")));
		
		//List<PageData> rows=warning_his.subList(offset, offset+limit);
		
		
		map.put("rows", warning_his);
		map.put("total",total);
		JSONObject json = JSONObject.fromObject(map);
		return  json;
	}
	
	
	
}
