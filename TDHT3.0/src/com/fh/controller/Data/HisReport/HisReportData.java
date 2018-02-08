package com.fh.controller.Data.HisReport;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
@Controller
public class HisReportData  extends BaseController {

	@Resource(name="His_ReportService")
	private His_ReportManager His_ReportService;
	@Resource(name="NewDataService")
	private NewDataManager NewDataService;
	
	/**
	 * 进入首页后的默认页面
	 * @return
	 * @throws Exception 
	 */
	
	@RequestMapping(value="/listHisReport")
	public ModelAndView HisListReport(String R_ID,String ROLE_NAME,String MENU_ID,String MENU_IDS) throws Exception{
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
		//List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表
		List<PageData>	varList = NewDataService.listAll_pd_water(pd);	//列出Conf_param列表
		
		List<PageData>	water_types=His_ReportService.water_type(pd);
		List<PageData>	water_type=new ArrayList<PageData>();
		if(varList!=null&&water_types!=null){
			for(int i=0;i<water_types.size();i++){
				PageData pds=new PageData();
				for(int j=0;j<varList.size();j++){
					if(water_types.get(i).getInteger("param_type")==varList.get(j).getInteger("param_type")){
						pds.put("water_type",water_types.get(i).get("tab_name_cn"));
						pds.put("param_type",water_types.get(i).get("param_type"));
						water_type.add(pds);
						break;
					}
					
				}
			}
		
		}
		
		mv.addObject("pd",pd);
		mv.addObject("R_ID",R_ID);
		mv.addObject("water_type",water_type);
		mv.addObject("list",allmenuListss);
		mv.addObject("ROLE_NAME",ROLE_NAME);
		mv.addObject("varList",varList);
		mv.addObject("menuUrl","listHisReport.do?MENU_ID="+MENU_ID+"&MENU_IDS="+MENU_IDS+"&R_ID=");
		mv.setViewName("report/hisRoport_list");
		return mv;
	} 
	public Double fixed(Double d,int i){
		BigDecimal   b1   =   new   BigDecimal(d);  
		Double   num   =   b1.setScale(i,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
		return num;
	}
	
	
	@RequestMapping(value="/line_his_water")
	@ResponseBody
	public Object Line_his_water(String R_ID,int from,String startTime0,String endTime0,int waterSelect) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("select", waterSelect);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		long startTime=0;
		long endTime=0;
		if(from==1){
			String startstrTime=startTime0+ " 00:00";
			 startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			
			String endstrTime=startTime0+" 23:59";
		     endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
			pd.put("time_space", 5);   
		}
		if(from==2){
			String startstrTime=startTime0+"-01 00:00";
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
		    pd.put("time_space", 30);         
		}
		
		if(from==4){
			String startstrTime=startTime0+"-01-01 00:00";
			 startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=startTime0+"-12-31 00:00";
		     endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
		    pd.put("time_space", 60);         
		}
		if(from==5){
			String startstrTime=startTime0+" 00:00";
			 startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=endTime0+" 23:59";
		     endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
		    pd.put("time_space", 60);       
		}
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "success";
	
		List<PageData>	selectList = NewDataService.selectListByType(pd);	//列出Conf_param列表
		
		List<PageData>	water_types=His_ReportService.water_type(pd);  //查询所有水类型
		
		List<PageData>his_water=new ArrayList<PageData>();
		List<PageData>his_water_s=new ArrayList<PageData>();
		
		List<String>water_cof=new ArrayList<String>(); 
		List<String>strTimes=new ArrayList<String>();	
		
		
		
		String tabName=null;
		for(int i=0;i<water_types.size();i++){
			if(water_types.get(i).getInteger("param_type")==waterSelect){
				tabName=water_types.get(i).getString("tab_name");
			}
		}
		String  str="";
		if(from==4){
			Date date =StringDataLongTime.stringToDate(startTime0,"yyyy");
			   str=StringDataLongTime.dateToString(date,"yyyy");
			 	
		} else if(from==5){
			str="_";
			   
		}else{
			Date date =StringDataLongTime.stringToDate(startTime0,"yyyy-MM");
			   str=StringDataLongTime.dateToString(date,"yyyyMM");
		} 
		
		List<PageData>	TabName=new ArrayList<PageData>();
		if(tabName!=null){
			pd.put("tabAllName", tabName+"_%%");
			TabName=NewDataService.selectAllTabName(pd);	
			
			if(TabName!=null){
				for(int i=0;i<TabName.size();i++){
					List<PageData>his_waters=new ArrayList<PageData>();
				 if(TabName.get(i).getString("TABLE_NAME").contains(str)){
					 pd.put("tabName", TabName.get(i).getString("TABLE_NAME"));
					 his_waters=	His_ReportService.line_his_water(pd);
				}
				 if(his_waters!=null){
					 his_water_s.addAll(his_waters);
				 }
				 
			}
			
			
		}
			 if(from==5){
				 if(his_water_s!=null){
					 for(int a=0;a<his_water_s.size();a++){
						 long l=(long)his_water_s.get(a).getInteger("sy_time");
						 if(l>=startTime&&l<endTime){
							 his_water.add(his_water_s.get(a)); 
						 }
					 }
				 }
				 
			 }else{
				 his_water= his_water_s;
				 
			 }
		if(his_water!=null){
			for(int a=0;a<his_water.size();a++){
				strTimes.add(sdf.format(his_water.get(a).get("str_time")));
			}
		}
		
	}else{
		his_water=null;
	}
	
		if(selectList!=null&&his_water!=null){
			for(int b=0;b<selectList.size();b++){
				water_cof.add(selectList.get(b).getString("param_name_cn"));
				
			List<Double>list1=new ArrayList<Double>();
			for(int c=0;c<his_water.size();c++){
				list1.add(fixed(his_water.get(c).getDouble(selectList.get(b).getString("param_name_sql")),selectList.get(b).getInteger("decimal_number")));
			}
			selectList.get(b).put("dataList", list1);
		  }
		}
        map.put("water_cof", water_cof);
		
		map.put("strTimes", strTimes);
		map.put("selectList", selectList);
		map.put("result", errInfo);	
		return AppUtil.returnObject(new PageData(), map);
	}
	
	
	@RequestMapping(value="/line_his_poll")
	@ResponseBody
	public Object Line_his_poll(String R_ID,int from,String startTime2,String endTime2) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		long startTime=0;
		 long endTime=0;
		if(from==1){
			String startstrTime=startTime2+ " 00:00";
			 startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			
			String endstrTime=startTime2+" 23:59";
		     endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
			pd.put("time_space", 5);   
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
		    pd.put("time_space", 30);         
		}
		
		if(from==4){
			String startstrTime=startTime2+"-01-01 00:00";
			 startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=startTime2+"-12-31 00:00";
		     endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
		    pd.put("time_space", 60);         
		}
		if(from==5){
			String startstrTime=startTime2+" 00:00";
			 startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=endTime2+" 23:59";
		     endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
		    pd.put("time_space", 60);       
		}
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "success";
	
		List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表
		
		
		List<String>water_cof=new ArrayList<String>(); 
		List<String>strTimes=new ArrayList<String>();	
		List<PageData>	poll1=new ArrayList<PageData>();
		List<PageData>	poll2=new ArrayList<PageData>();
		List<PageData>	poll3=new ArrayList<PageData>();
		List<PageData>	poll1_s=new ArrayList<PageData>();
		List<PageData>	poll2_s=new ArrayList<PageData>();
		List<PageData>	poll3_s=new ArrayList<PageData>();
		List<String>poll_type=new ArrayList<String>();
		List<String>poll_type_select=new ArrayList<String>();
		String  str="";
		String  str2="";
		if(from==4){
			Date date =StringDataLongTime.stringToDate(startTime2,"yyyy");
			   str=StringDataLongTime.dateToString(date,"yyyy");
			 	
		} else if(from==5){
			str="_";
			   
		}else{
			Date date =StringDataLongTime.stringToDate(startTime2,"yyyy-MM");
			   str=StringDataLongTime.dateToString(date,"yyyyMM");
		}
		
		 for(int a=1;a<=3;a++){
				
				List<PageData>	TabName=new ArrayList<PageData>();
				if(a==1){
					pd.put("tabAllName", "src_quality_01_%%");
					TabName=NewDataService.selectAllTabName(pd);	
					if(TabName!=null){
						for(int i=0;i<TabName.size();i++){
							List<PageData>	poll1s=new ArrayList<PageData>();
						 if(TabName.get(i).getString("TABLE_NAME").contains(str)){
							 pd.put("tabName", TabName.get(i).getString("TABLE_NAME"));
								 poll1s=His_ReportService.line_his_poll1(pd);
							 if(poll1s!=null){
								 poll1_s.addAll(poll1s); 
							 }
							
							  }
						}
					}
					
				}else if(a==2){
					pd.put("tabAllName", "src_quality_02_%%");
						TabName=NewDataService.selectAllTabName(pd);
						if(TabName!=null){
							for(int i=0;i<TabName.size();i++){
								List<PageData>	poll1s=new ArrayList<PageData>();
							 if(TabName.get(i).getString("TABLE_NAME").contains(str)){
								 pd.put("tabName", TabName.get(i).getString("TABLE_NAME"));
								 poll1s=His_ReportService.line_his_poll2(pd);
								 if(poll1s!=null){
									 poll2_s.addAll(poll1s); 
								 }
								  }
							}
						}
				}else if(a==3){
					pd.put("tabAllName", "src_quality_03_%%");
						TabName=NewDataService.selectAllTabName(pd);
						if(TabName!=null){
							for(int i=0;i<TabName.size();i++){
								List<PageData>	poll1s=new ArrayList<PageData>();
							 if(TabName.get(i).getString("TABLE_NAME").contains(str)){
								 pd.put("tabName", TabName.get(i).getString("TABLE_NAME"));
								 poll1s=His_ReportService.line_his_poll3(pd);
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
		
		
		
		  
			for(int i=0;i<varList.size();i++){
				poll_type.add(varList.get(i).getString("param_name_cn"));
				/*if(i==0){
					poll_type_select.add(varList.get(i).getString("param_name_cn")+":true");
				}else{
				poll_type_select.add(varList.get(i).getString("param_name_cn")+":false");
				}*/
				if(varList.get(i).getInteger("param_type")==7&&poll1!=null){
					List<Double>list1=new ArrayList<Double>();
					for(int a=0;a<poll1.size();a++){
						
						
					   list1.add(fixed(poll1.get(a).getDouble(varList.get(i).getString("param_name_sql")),varList.get(i).getInteger("decimal_number")));
					}	
					 
					varList.get(i).put("dataList", list1);
					
					
				}else if(varList.get(i).getInteger("param_type")==8&&poll2!=null){
					List<Double>list1=new ArrayList<Double>();
					for(int a=0;a<poll2.size();a++){
					   list1.add(fixed(poll2.get(a).getDouble(varList.get(i).getString("param_name_sql")),varList.get(i).getInteger("decimal_number")));
					}	
					
					varList.get(i).put("dataList", list1);
					
				}else if(varList.get(i).getInteger("param_type")==9&&poll3!=null){
					List<Double>list1=new ArrayList<Double>();
					for(int a=0;a<poll3.size();a++){
						
						
					   list1.add(fixed(poll3.get(a).getDouble(varList.get(i).getString("param_name_sql")),varList.get(i).getInteger("decimal_number")));
					}	
					
					varList.get(i).put("dataList", list1);
				}
			}
		
			
			if(poll1!=null){
				for(int a=0;a<poll1.size();a++){
					
						strTimes.add(sdf.format(poll1.get(a).get("str_time")));
					
				}
			}else if(poll1==null&&poll2!=null){
				for(int a=0;a<poll2.size();a++){
				if(strTimes.size()==0){
					
						strTimes.add(sdf.format(poll2.get(a).get("str_time")));
					
				}
				}
			}else if(poll1==null&&poll2==null&&poll3!=null){
				for(int a=0;a<poll3.size();a++){
				if(strTimes.size()==0){
					
						strTimes.add(sdf.format(poll3.get(a).get("str_time")));
					
				}
				}
			}
		
	
        map.put("varList", varList);
		
		map.put("strTimes", strTimes);
		map.put("poll_type", poll_type);
		map.put("poll_type_select", poll_type_select);
		map.put("result", errInfo);	
		return AppUtil.returnObject(new PageData(), map);
	}
	
	

}
