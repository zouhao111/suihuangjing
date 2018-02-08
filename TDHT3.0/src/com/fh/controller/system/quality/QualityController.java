package com.fh.controller.system.quality;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.fh.entity.Page;
import com.fh.entity.system.Menu;
import com.fh.entity.system.StringDataLongTime;
import com.fh.service.system.balance.BalanceManager;
import com.fh.service.system.newdata.NewDataManager;
import com.fh.service.system.quality.QualityManager;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
public class QualityController extends BaseController {
	
	String menuUrl = "quality/listQuality.do"; //菜单地址(权限用)
	@Resource(name="qualityService")
	private QualityManager qualityService;
	@Resource(name="NewDataService")
	private NewDataManager newDataService;
	@Resource(name="BalanceService")
	private BalanceManager BalanceService;
	/**
	 * 进入水量页面
	 * @return
	 */
	@RequestMapping(value="/listQuality")
	public ModelAndView listQuality(Page page,String ROLE_NAME,String MENU_ID,String R_ID,String MENU_IDS) throws Exception{
		
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
		
		for(int a=0;a<allmenuLists.size();a++){
			mv.addObject("list"+a,allmenuListss.get(a));
		}
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("R_ID", R_ID);
		List<PageData> balance_config=BalanceService.balance_config(pd);
		boolean idHave=false;
		boolean isHave=false;
		boolean lsHave=false;
		boolean ldHave=false;
		
		
		if(balance_config!=null){
			for(int i=0;i<balance_config.size();i++){
				if(balance_config.get(i).getInteger("device_type")==1){
					if(balance_config.get(i).getInteger("balance_calc")==1){
						idHave=true;
					}
				}
				if(balance_config.get(i).getInteger("device_type")==2){
					if(balance_config.get(i).getInteger("balance_calc")==1){
						isHave=true;
					}
				}
				
				if(balance_config.get(i).getInteger("device_type")==3){
					if(balance_config.get(i).getInteger("balance_calc")==1){
						ldHave=true;
					}
				}
				if(balance_config.get(i).getInteger("device_type")==4){
					if(balance_config.get(i).getInteger("balance_calc")==1){
						lsHave=true;
					}
				}
			}
		}
		
		
		
		List<PageData>	quaList =newDataService.listAll_pd_water(pd);
		List<PageData>	quaLists=new ArrayList<PageData>();
			for(int i=0;i<quaList.size();i++){
				if(quaList.get(i).getString("param_name").equals("工业排水总流量(m³)")){
					quaList.get(i).put("param_name_sql", "i_drainage_f");
					quaList.get(i).put("is_Have",idHave);
					quaLists.add(quaList.get(i));
				}
				if(quaList.get(i).getString("param_name").equals("工业给水总流量(m³)")){
					quaList.get(i).put("param_name_sql", "i_supply_f");
					quaList.get(i).put("is_Have",isHave);
					quaLists.add(quaList.get(i));
				}
				if(quaList.get(i).getString("param_name").equals("生活给水总流量(m³)")){
					quaList.get(i).put("param_name_sql", "l_supply_f");
					quaList.get(i).put("is_Have",lsHave);
					quaLists.add(quaList.get(i));
				}
				if(quaList.get(i).getString("param_name").equals("生活排水总流量(m³)")){
					quaList.get(i).put("param_name_sql", "l_drainage_f");
					quaList.get(i).put("is_Have",ldHave);
					quaLists.add(quaList.get(i));
				}
			}
			
		mv.addObject("menuUrl","listQuality.do?MENU_ID="+MENU_ID+"&MENU_IDS="+MENU_IDS+"&R_ID=");
		mv.setViewName("system/quality/quality_list");
		mv.addObject("R_ID",R_ID);
		mv.addObject("quaLists",quaLists);
		return mv;
	}
	
	
	
	/**
	 * 水量报表表格
	 */
	@RequestMapping(value="/listQualityTable")
	@ResponseBody
	public Object listQualityTable(int limit,int offset,String R_ID,int from,String startTime1,String end_strTime1) throws Exception{
		
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Page page=new Page();
		
		/*if(startTime1==null){
			Calendar calendar = Calendar.getInstance();  
		       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) -10);  
		       Date today = calendar.getTime();  
		       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		       String startTime = format.format(today);  
		       Date date=new Date();
		      String  endTime=format.format(date);
		      long intendTime =StringDataLongTime.stringToLong(endTime,"yyyy-MM-dd");
		      long intstartTime =StringDataLongTime.stringToLong(startTime,"yyyy-MM-dd");
		      pd.put("endTime", intendTime);
		      pd.put("startTime", intstartTime);
		}*/
		
		if(from==2 && startTime1!=null ){
			String startstrTime=startTime1+"-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			
			/*Calendar calendar = new GregorianCalendar();  
			  calendar.add(Calendar.MONTH, 1);  
		        calendar.set(Calendar.DAY_OF_MONTH, 0);  
		        Date enddateTime=calendar.getTime();*/
		        String endstrTime= StringDataLongTime.getMaxMonthDate(startstrTime);
		        endstrTime=endstrTime+" 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==4 && startTime1!=null ){
			String startstrTime=startTime1+"-01-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=startTime1+"-12-31 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}if(from==5 && startTime1!=null ){
			String startstrTime=startTime1+" 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=end_strTime1+" 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
	      
	  	  pd.put("r_id", R_ID);
	      pd.put("limit", limit);
	      pd.put("offset", offset);
	      page.setPd(pd);
	      pd.put("R_ID",R_ID);
	      List<PageData>	quaList =newDataService.listAll_pd_water(pd);
			List<PageData>	quaLists=new ArrayList<PageData>();
			for(int i=0;i<quaList.size();i++){
				if(quaList.get(i).getString("param_name").equals("工业排水总流量(m³)")){
					quaList.get(i).put("param_name_sql", "i_drainage_f");
					quaLists.add(quaList.get(i));
				}
				if(quaList.get(i).getString("param_name").equals("工业给水总流量(m³)")){
					quaList.get(i).put("param_name_sql", "i_supply_f");
					quaLists.add(quaList.get(i));
				}
				if(quaList.get(i).getString("param_name").equals("生活给水总流量(m³)")){
					quaList.get(i).put("param_name_sql", "l_supply_f");
					quaLists.add(quaList.get(i));
				}
				if(quaList.get(i).getString("param_name").equals("生活排水总流量(m³)")){
					quaList.get(i).put("param_name_sql", "l_drainage_f");
					quaLists.add(quaList.get(i));
				}
			}
	      
		List<PageData>	varList =qualityService.listCurve(page);//查询水量统计曲线
		List<PageData>	varLists =new ArrayList<PageData>();
		
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for(int i=0;i<varList.size();i++){
			PageData pdata=new PageData();
			pdata.put("str_time",""+ ( sdf.format(varList.get(i).get("str_time")))+"");
			for(int j=0;j<quaLists.size();j++){
				pdata.put(quaLists.get(j).getString("param_name_sql"),fixed( varList.get(i).getDouble(quaLists.get(j).getString("param_name_sql")),quaLists.get(j).getInteger("decimal_number")));
						
			}
			varLists.add(pdata);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		//List<PageData> rows=varLists.subList(offset, offset+limit);
		map.put("rows", varLists);
		map.put("total", varLists.size());
		map.put("data",varLists);
		JSONObject json = JSONObject.fromObject(map);
		return  json;
	}
	
	
	
	/**
	 * 水量曲线
	 */
	@RequestMapping(value="/listQualityCurve")
	@ResponseBody
	public Object listQualityCurve(Page page,String R_ID,int from,String startTime1,String endTime1) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		
		PageData pd = new PageData();
		pd = this.getPageData();
		/*if(strTime==null){
			Calendar calendar = Calendar.getInstance();  
		       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) -10);  
		       Date today = calendar.getTime();  
		       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		       String startTime = format.format(today);  
		       Date date=new Date();
		      String  endTime=format.format(date);
		      long intendTime =StringDataLongTime.stringToLong(endTime,"yyyy-MM-dd");
		      long intstartTime =StringDataLongTime.stringToLong(startTime,"yyyy-MM-dd");
		      pd.put("startTime", intstartTime);
			  pd.put("endTime", intendTime);
		}*/
		
		if(from==2 && startTime1!=null ){
			String startstrTime=startTime1+"-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			
			/*Calendar calendar = new GregorianCalendar();  
			  calendar.add(Calendar.MONTH, 1);  
		        calendar.set(Calendar.DAY_OF_MONTH, 0);  
		        Date enddateTime=calendar.getTime();*/
			 String endstrTime= StringDataLongTime.getMaxMonthDate(startstrTime);
		        endstrTime=endstrTime+" 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==4 && startTime1!=null ){
			String startstrTime=startTime1+"-01-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=startTime1+"-12-31 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==5 && startTime1!=null ){
			String startstrTime=startTime1+" 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=endTime1+" 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		  pd.put("limit", 1000);
	      pd.put("offset", 0);
		  pd.put("r_id", R_ID);
		  page.setPd(pd);
		List<PageData>	varList =qualityService.listCurve(page);//查询水量统计曲线
		ArrayList< Object> data=new ArrayList<Object>();//时间
		ArrayList< Object> i_drainage_f=new ArrayList<Object>();//工业排水
		ArrayList< Object> i_supply_f=new ArrayList<Object>();//工业给水
		ArrayList< Object> l_drainage_f=new ArrayList<Object>();//生活排水
		ArrayList< Object> l_supply_f=new ArrayList<Object>();//生活给水
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		
		for(int i=0;i<varList.size();i++){
			data.add(i, sdf.format(varList.get(i).get("str_time")));
			i_drainage_f.add(i, varList.get(i).get("i_drainage_f"));
			l_drainage_f.add(i, varList.get(i).get("l_drainage_f"));
			i_supply_f.add(i, varList.get(i).get("i_supply_f"));
			l_supply_f.add(i, varList.get(i).get("l_supply_f"));
		}
		map.put("datajson", data);
		map.put("i_drainage_f", i_drainage_f);
		map.put("i_supply_f", i_supply_f);
		map.put("l_drainage_f", l_drainage_f);
		map.put("l_supply_f", l_supply_f);
		String errInfo = "success";
		map.put("result", errInfo);	
		return AppUtil.returnObject(new PageData(), map);
		
	}
	
	public Double fixed(Double d,int i){
		BigDecimal   b1   =   new   BigDecimal(d);  
		Double   num   =   b1.setScale(i,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
		return num;
	}
	
	
	/**
	 * 水量曲线
	 */
	@RequestMapping(value="/list_balance")
	@ResponseBody
	public Object list_balance(int limit,int offset,String R_ID,int from,String startTime2,String endTime2) throws Exception{
		Page page=new Page();
		PageData pd = new PageData();
		pd = this.getPageData();
		/*if(strTime==null){
			Calendar calendar = Calendar.getInstance();  
		       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) -10);  
		       Date today = calendar.getTime();  
		       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		       String startTime = format.format(today);  
		       Date date=new Date();
		      String  endTime=format.format(date);
		      long intendTime =StringDataLongTime.stringToLong(endTime,"yyyy-MM-dd");
		      long intstartTime =StringDataLongTime.stringToLong(startTime,"yyyy-MM-dd");
		      pd.put("startTime", intstartTime);
			  pd.put("endTime", intendTime);
		}*/
		
		if(from==2 && startTime2!=null ){
			String startstrTime=startTime2+"-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			
			/*Calendar calendar = new GregorianCalendar();  
			  calendar.add(Calendar.MONTH, 1);  
		        calendar.set(Calendar.DAY_OF_MONTH, 0);  
		        Date enddateTime=calendar.getTime();*/
			 String endstrTime= StringDataLongTime.getMaxMonthDate(startstrTime);
		        endstrTime=endstrTime+" 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==4 && startTime2!=null ){
			String startstrTime=startTime2+"-01-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=startTime2+"-12-31 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==5 && startTime2!=null ){
			String startstrTime=startTime2+" 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=endTime2+" 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		pd.put("r_id", R_ID);
	      pd.put("limit", limit);
	      pd.put("offset", offset);
	      page.setPd(pd);
	      List<PageData>cyc= BalanceService.select_cyc(pd);
	      if(cyc!=null){
	    	   if(cyc.size()>0){
	    	  pd.put("startTime", (long)cyc.get(cyc.size()-1).getInteger("sy_time"));
	    	   }
	      }
	      
	      List<PageData>dayfollow=BalanceService.list_day_follow3(pd);
	      List<PageData>	BalanceList = new ArrayList<PageData>();
			if(dayfollow!=null){
				pd.put("dayfollow", dayfollow);
				BalanceList = BalanceService.balance(pd);	//列出Conf_param列表
			}
			
			 List<PageData>	quaList =newDataService.listAll_pd_water(pd);
				List<PageData>	quaLists=new ArrayList<PageData>();
				for(int i=0;i<quaList.size();i++){
					if(quaList.get(i).getString("param_name").equals("工业排水总流量(m³)")){
						quaList.get(i).put("param_name_sql", "i_drainage_f");
						quaLists.add(quaList.get(i));
					}
					if(quaList.get(i).getString("param_name").equals("工业给水总流量(m³)")){
						quaList.get(i).put("param_name_sql", "i_supply_f");
						quaLists.add(quaList.get(i));
					}
					if(quaList.get(i).getString("param_name").equals("生活给水总流量(m³)")){
						quaList.get(i).put("param_name_sql", "l_supply_f");
						quaLists.add(quaList.get(i));
					}
					if(quaList.get(i).getString("param_name").equals("生活排水总流量(m³)")){
						quaList.get(i).put("param_name_sql", "l_drainage_f");
						quaLists.add(quaList.get(i));
					}
				}
			
			List<PageData>	balanceLists =new ArrayList<PageData>();
			if(BalanceList.size()>0){
       		for(int i=0;i<BalanceList.size();i++){
       			PageData pdata=new PageData();
    			pdata.put("str_time",  BalanceList.get(i).get("str_time"));
    			for(int a=0;a<quaLists.size();a++){
    				if((Boolean) BalanceList.get(i).get("idHave")){
        				pdata.put(quaLists.get(a).getString("param_name_sql"),fixed(BalanceList.get(i).getDouble("Idztraffic"), quaLists.get(a).getInteger("decimal_number")) );
        			}
    				if((Boolean) BalanceList.get(i).get("isHave")){
        				pdata.put(quaLists.get(a).getString("param_name_sql"),fixed(BalanceList.get(i).getDouble("Isztraffic"), quaLists.get(a).getInteger("decimal_number")) );
        			}
    				if((Boolean) BalanceList.get(i).get("lsHave")){
        				pdata.put(quaLists.get(a).getString("param_name_sql"),fixed(BalanceList.get(i).getDouble("Lsztraffic"), quaLists.get(a).getInteger("decimal_number")) );
        			}
    				if((Boolean) BalanceList.get(i).get("ldHave")){
        				pdata.put(quaLists.get(a).getString("param_name_sql"),fixed(BalanceList.get(i).getDouble("Ldztraffic"), quaLists.get(a).getInteger("decimal_number")) );
        			}
    				pdata.put("Wastage", fixed(BalanceList.get(i).getDouble("Wastage"), 2));
    				pdata.put("Unknow", fixed(BalanceList.get(i).getDouble("Unknow"), 2));
    				
    				
    			}
    			balanceLists.add(pdata);
       		}
       	}
	      
	
		
			Map<String,Object> map = new HashMap<String,Object>();
		//	List<PageData> rows=balanceLists.subList(offset, offset+limit);
		//	map.put("rows", rows);
			map.put("total", balanceLists.size());
			map.put("data", balanceLists);
			JSONObject json = JSONObject.fromObject(map);
			return  json;
		
	}
	/**
	 * 水量曲线
	 */
	@RequestMapping(value="/list_balance_pie")
	@ResponseBody
	public Object list_balance_pie(String R_ID,int from,String startTime2,String endTime2) throws Exception{
		Page page=new Page();
		PageData pd = new PageData();
		Map<String,Object> map = new HashMap<String,Object>();
		
		pd = this.getPageData();
		/*if(strTime==null){
			Calendar calendar = Calendar.getInstance();  
		       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) -10);  
		       Date today = calendar.getTime();  
		       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		       String startTime = format.format(today);  
		       Date date=new Date();
		      String  endTime=format.format(date);
		      long intendTime =StringDataLongTime.stringToLong(endTime,"yyyy-MM-dd");
		      long intstartTime =StringDataLongTime.stringToLong(startTime,"yyyy-MM-dd");
		      pd.put("startTime", intstartTime);
			  pd.put("endTime", intendTime);
		}*/
		
		if(from==2 && startTime2!=null ){
			String startstrTime=startTime2+"-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			
			/*Calendar calendar = new GregorianCalendar();  
			  calendar.add(Calendar.MONTH, 1);  
		        calendar.set(Calendar.DAY_OF_MONTH, 0);  
		        Date enddateTime=calendar.getTime();*/
			 String endstrTime= StringDataLongTime.getMaxMonthDate(startstrTime);
		        endstrTime=endstrTime+" 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==4 && startTime2!=null ){
			String startstrTime=startTime2+"-01-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=startTime2+"-12-31 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==5 && startTime2!=null ){
			String startstrTime=startTime2+" 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=endTime2+" 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		pd.put("r_id", R_ID);
	/*	List<PageData> balance_config=BalanceService.balance_config(pd);
		boolean idHave=false;
		boolean isHave=false;
		boolean lsHave=false;
		boolean ldHave=false;
		
		
		if(balance_config!=null){
			for(int i=0;i<balance_config.size();i++){
				if(balance_config.get(i).getInteger("device_type")==1){
					if(balance_config.get(i).getInteger("balance_calc")==1){
						idHave=true;
					}
				}
				if(balance_config.get(i).getInteger("device_type")==2){
					if(balance_config.get(i).getInteger("balance_calc")==1){
						isHave=true;
					}
				}
				
				if(balance_config.get(i).getInteger("device_type")==3){
					if(balance_config.get(i).getInteger("balance_calc")==1){
						ldHave=true;
					}
				}
				if(balance_config.get(i).getInteger("device_type")==4){
					if(balance_config.get(i).getInteger("balance_calc")==1){
						lsHave=true;
					}
				}
			}
		}
	      */
	      List<PageData>dayfollow=BalanceService.list_day_follow3(pd);
	      List<PageData>	BalanceList = new ArrayList<PageData>();
			if(dayfollow!=null){
				pd.put("dayfollow", dayfollow);
				BalanceList = BalanceService.balance(pd);	//列出Conf_param列表
			}
			
			 List<PageData>	quaList =newDataService.listAll_pd_water(pd);
				List<PageData>	quaLists=new ArrayList<PageData>();
				for(int i=0;i<quaList.size();i++){
					if(quaList.get(i).getString("param_name").equals("工业排水总流量(m³)")){
						quaList.get(i).put("param_name_sql", "i_drainage_f");
						//quaList.get(i).put("is_Have",idHave);
						quaLists.add(quaList.get(i));
					}
					if(quaList.get(i).getString("param_name").equals("工业给水总流量(m³)")){
						quaList.get(i).put("param_name_sql", "i_supply_f");
						//quaList.get(i).put("is_Have",isHave);
						quaLists.add(quaList.get(i));
					}
					if(quaList.get(i).getString("param_name").equals("生活给水总流量(m³)")){
						quaList.get(i).put("param_name_sql", "l_supply_f");
						//quaList.get(i).put("is_Have",lsHave);
						quaLists.add(quaList.get(i));
					}
					if(quaList.get(i).getString("param_name").equals("生活排水总流量(m³)")){
						quaList.get(i).put("param_name_sql", "l_drainage_f");
						//quaList.get(i).put("is_Have",ldHave);
						quaLists.add(quaList.get(i));
					}
				}
			
			List<PageData>	balanceLists =new ArrayList<PageData>();
			PageData pdata=new PageData();
			if(BalanceList.size()>0){
				
				
				
				pdata=BalanceList.get(BalanceList.size()-1);
				
				
       	/*	for(int i=0;i<BalanceList.size();i++){
       			PageData pdata=new PageData();
    			pdata.put("str_time",  BalanceList.get(i).get("str_time"));
    			for(int a=0;a<quaLists.size();a++){
    				if((Boolean) BalanceList.get(i).get("idHave")){
        				pdata.put(quaLists.get(a).getString("param_name_sql"),fixed(BalanceList.get(i).getDouble("Idztraffic"), quaLists.get(a).getInteger("decimal_number")) );
        			}
    				if((Boolean) BalanceList.get(i).get("isHave")){
        				pdata.put(quaLists.get(a).getString("param_name_sql"),fixed(BalanceList.get(i).getDouble("Isztraffic"), quaLists.get(a).getInteger("decimal_number")) );
        			}
    				if((Boolean) BalanceList.get(i).get("lsHave")){
        				pdata.put(quaLists.get(a).getString("param_name_sql"),fixed(BalanceList.get(i).getDouble("Lsztraffic"), quaLists.get(a).getInteger("decimal_number")) );
        			}
    				if((Boolean) BalanceList.get(i).get("ldHave")){
        				pdata.put(quaLists.get(a).getString("param_name_sql"),fixed(BalanceList.get(i).getDouble("Ldztraffic"), quaLists.get(a).getInteger("decimal_number")) );
        			}
    				pdata.put("Wastage", fixed(BalanceList.get(i).getDouble("Wastage"), 2));
    				pdata.put("Unknow", fixed(BalanceList.get(i).getDouble("Unknow"), 2));
    				
    				
    			}
    			balanceLists.add(pdata);
       		}*/
       	}
	      
	
			
			map.put("quaList", quaList);
			map.put("balance_sum", pdata);
			String errInfo = "success";
			
			map.put("result", errInfo);	
			return AppUtil.returnObject(new PageData(), map);
		
	}
}
