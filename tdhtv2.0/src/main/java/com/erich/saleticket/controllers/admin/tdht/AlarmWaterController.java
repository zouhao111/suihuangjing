package com.erich.saleticket.controllers.admin.tdht;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.chainsaw.Main;

import com.erich.easyframe.util.SystemContext;
import com.erich.saleticket.biz.tdht.AlarmBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread1;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread2;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread3;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread4;
import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.tdht.Alarm;
import com.erich.saleticket.model.tdht.AlarmType;
import com.erich.saleticket.model.tdht.AlarmType_water;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.Pollutant_Water;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewLineReport;
import com.erich.saleticket.model.tdht.ViewWaterquality;
import com.mysql.fabric.xmlrpc.base.Array;


/**
 * 报警控制器
 * @author Lv
 */
public class AlarmWaterController extends BaseController {

	private  List<Pollutant> aaa=new ArrayList<Pollutant>();
	private  List<Pollutant> bbb=new ArrayList<Pollutant>();
	private  List<Pollutant> ccc=new ArrayList<Pollutant>();
	private  List<Pollutant> ddd=new ArrayList<Pollutant>();
	private  List<Pollutant> eee=new ArrayList<Pollutant>();
	private  List<Pollutant> fff=new ArrayList<Pollutant>();
	private  List<Pollutant> ggg=new ArrayList<Pollutant>();
	private  List<Pollutant> hhh=new ArrayList<Pollutant>();
	public class MyThread1 extends Thread
	{
		 private Alarm alarm1;
		    private Alarm alarm2;
	    public MyThread1(Alarm alarm,Alarm alarms)
	    {
	    	alarm1=alarm;
	    	alarm2=alarms;
	    }
	    public void run()
	    {SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date())+"*********进程1时间");// new Date()为获取当前系统时间
		if(alarm1.isHave()){
			System.out.println("ddd ");
			aaa=alarmBiz.selectByCriteriaCod(alarm1);	
		}
		if(alarm2.isHave()){
			bbb=alarmBiz.selectByCriteriaNh4(alarm2);
		}
		
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程1结束时间");// new Date()为获取当前系统时间
	    }

	}
	public class MyThread2 extends Thread
	{
	    private Alarm alarm1;
	    private Alarm alarm2;
	    public MyThread2(Alarm alarm,Alarm alarms)
	    {
	    	alarm1=alarm;
	    	alarm2=alarms;
	    }
	    public void run()
	    {SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date())+"*********进程2时间");// new Date()为获取当前系统时间
		
		
		if(alarm1.isHave()){
			ccc=alarmBiz.selectByCriteriaMlss(alarm1);	
		}
		if(alarm2.isHave()){
			ddd=alarmBiz.selectByCriteriaPho(alarm2);
		}
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程2结束时间");// new Date()为获取当前系统时间
	    }

	}
	public class MyThread3 extends Thread
	{
		private Alarm alarm1;
	    private Alarm alarm2;
	    private Alarm alarm3;
	    public MyThread3(Alarm alarm,Alarm alarms,Alarm alarmss)
	    {
	    	alarm1=alarm;
	    	alarm2=alarms;
	    	alarm3=alarmss;
	    }
	    public void run()
	    {SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date())+"*********进程3时间");// new Date()为获取当前系统时间
	    
	     
	    
	     if(alarm1.isHave()){
	    	 eee=alarmBiz.selectByCriteriacr6(alarm1);	
			}
			if(alarm2.isHave()){
				fff=alarmBiz.selectByCriteriaPh(alarm2);
			}
			if(alarm3.isHave()){
				 ggg=alarmBiz.selectByCriteriaZtr(alarm3);
			}
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程3结束时间");// new Date()为获取当前系统时间
	    }

	}
	public class MyThread4 extends Thread
	{
		private Alarm alarm1;
	  
	    public MyThread4( Alarm alarm)
	    {	alarm1=alarm;
	    	
	    }
	    public void run()
	    {SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date())+"*********进程4时间");// new Date()为获取当前系统时间
		
			if(alarm1.isHave()){
				hhh=alarmBiz.selectByCriteriaVol(alarm1);
			}
			
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程4结束时间");// new Date()为获取当前系统时间
	    }

	}
	
	
	 private  List<String> Time_sub(String sTime,String eTime,int type) throws ParseException{
	    	List<String>times=new ArrayList<String>();
	    	SimpleDateFormat sdf = null;
	    	if(type==5||type==1){
	    	    sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    	}else if(type==3){
	    		sdf=new SimpleDateFormat("yyyy-MM-dd");
	    	}else if(type==6){
	    		sdf=new SimpleDateFormat("yyyy-MM-dd");
	    	}
	    	
	    	long LongsTime=sdf.parse(sTime).getTime();
			long LongeTime=sdf.parse(eTime).getTime();
			if((LongeTime-LongsTime)/60000<1440){
				long sub=(LongeTime-LongsTime)/2;
				long midTime=sub+LongsTime;
				Date date = new Date(midTime);
				String midTimes=sdf.format(date);
				
				times.add(sTime);
				times.add(midTimes);
				times.add(midTimes);
				times.add(eTime);
				
			}else{
			long sub=(LongeTime-LongsTime)/4;
			long midTime=sub+LongsTime;
			long midTime2=sub+sub+LongsTime;
			long midTime3=sub+sub+sub+LongsTime;
			
			Date date = new Date(midTime);
			String midTimes=sdf.format(date);
			Date date2 = new Date(midTime2);
			String midTimes2=sdf.format(date2);
			Date date3 = new Date(midTime3);
			String midTimes3=sdf.format(date3);
			
			
			times.add(sTime);
			times.add(midTimes);
			times.add(midTimes);
			times.add(midTimes2);
			times.add(midTimes2);
			times.add(midTimes3);
			times.add(midTimes3);
			times.add(eTime);
			}
			return times;
		}
	
	
	
	
	@Resource
	private AlarmBiz alarmBiz;
	@Resource
	private DataBiz dataBiz;
			
			/**
			 * 实时报警记录列表
			 * 
			 */
			/*	public String alarmList2(Alarm alarm, HttpServletRequest request, HttpServletResponse response) {
			
					//response.setHeader("refresh", "5");//设置refresh响应头控制浏览器每隔20秒钟刷新一次
				
					Object alarms=alarmBiz.selectByCriteria(alarm);
					StringBuffer webUrl=request.getRequestURL();
					String url=webUrl+"?nameId=1";
					request.setAttribute("webUrls", url);
					request.setAttribute("alarms", alarms);
					return "alarm/alarmList";
				}*/
				
			/**
			 * 实时报警记录列表
			 * @throws ParseException 
			 * 
			 */
	
			public String alarmList(AlarmType_water alarm, HttpServletRequest request, HttpServletResponse response) throws ParseException {
				int datasize = 0;
				Long rid=alarm.getRid();//公司ID
				
				ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
				viewCompanyconfig.setRid(rid);
				viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
				/**
				 * 根据rid查询该公司的污染物种类和限值
				 */
				List<AlarmType_water>  alarmType=alarmBiz.selectByCriteriawaterType(rid);
				List<AlarmType_water>datas=new ArrayList<AlarmType_water>();
				for(int i=0;i<alarmType.size();i++){
					int type=alarmType.get(i).getType();
					String typeName="warningdata"+type;				
					
					alarm.setTabName(typeName);
					AlarmType_water data1=alarmBiz.selectByCriteriawater(alarm);
					alarmType.get(i).setComName(viewCompanyconfig.getCompanyName());
					alarmType.get(i).setStrtime(data1.getStrtime());
					alarmType.get(i).setValue(data1.getValue());
					datas.add(alarmType.get(i));
				}
				
				StringBuffer webUrl=request.getRequestURL();
				String url=webUrl+"?nameId=1";
				request.setAttribute("webUrls", url);
				request.setAttribute("alarms", datas);
				
				request.setAttribute("viewCompanyconfig", viewCompanyconfig);
				return "alarmWater/alarmList";
			}
			
			/**
			 * 实时预警
			 */
			/*public String warningList2(ViewWaterquality viewWaterquality, HttpServletRequest request, HttpServletResponse response) {
		
				//response.setHeader("refresh", "5");//设置refresh响应头控制浏览器每隔20秒钟刷新一次
			
				Object alarms=alarmBiz.selectByWarningCriteria2(viewWaterquality);
				StringBuffer webUrl=request.getRequestURL();
				String url=webUrl+"?nameId=1";
				request.setAttribute("webUrls", url);
				request.setAttribute("alarms", alarms);
				return "alarm/warningList";
			}*/
			/**
			 * 实时预警
			 */
			public String warningList(AlarmType_water alarm, HttpServletRequest request, HttpServletResponse response) {
				int datasize = 0;
                 Long rid=alarm.getRid();//公司ID
				
				ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
				viewCompanyconfig.setRid(rid);
				viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
				/**
				 * 根据rid查询该公司的污染物种类和限值
				 */
				List<AlarmType_water>  alarmType=alarmBiz.selectByCriteriawaterType(rid);
				List<AlarmType_water>datas=new ArrayList<AlarmType_water>();
				for(int i=0;i<alarmType.size();i++){
					int type=alarmType.get(i).getType();
					String typeName="earlywarning"+type;				
					
					alarm.setTabName(typeName);
					AlarmType_water data1=alarmBiz.selectByCriteriawater(alarm);
					alarmType.get(i).setComName(viewCompanyconfig.getCompanyName());
					alarmType.get(i).setStrtime(data1.getStrtime());
					alarmType.get(i).setValue(data1.getValue());
					datas.add(alarmType.get(i));
				}
				
				StringBuffer webUrl=request.getRequestURL();
				String url=webUrl+"?nameId=1";
				request.setAttribute("webUrls", url);
				request.setAttribute("alarms", datas);
				
				request.setAttribute("viewCompanyconfig", viewCompanyconfig);
				return "alarmWater/warningList";
			}
			
			
			/**
			 *历史报警记录查询列表
			 * @throws ParseException 
			 */ 
			public String historyList(AlarmType_water alarm, HttpServletRequest request, HttpServletResponse response) throws ParseException {
				
				String sTime=alarm.getStartingTime();
				String eTime=alarm.getEndTime();
				String dateType=alarm.getDateTypes();
				Integer type=alarm.getType();//查询日期类型
				Long rid=alarm.getRid();//公司ID
				/**
				 * waterType 为用户在页面选择的污染物种类   默认ph
				 * 
				 */
				Integer waterType=alarm.getWaterType();
				
				ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
				viewCompanyconfig.setRid(rid);
				viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
				Date zeroTime=viewCompanyconfig.getStratTime();
				/**
				 * 根据rid查询该公司有的污染物种类和限值
				 */
				List<AlarmType_water>  alarmType=alarmBiz.selectByCriteriawaterType(rid);
				request.setAttribute("alarmType", alarmType);
				AlarmType_water alarms=new AlarmType_water();
				alarms.setRid(rid);
				if(waterType==null){
					waterType=1;                   //默认是ph
				}
				
				
				for(int i = 0;i<alarmType.size();i++){
					if(alarmType.get(i).getType()==waterType){
						alarms=alarmType.get(i);
					}
				}
				
				String typeName="warningdata"+waterType;				
				alarms.setTabName(typeName);
				List<AlarmType_water>datas=new ArrayList<AlarmType_water>();
				
				if(sTime==null & dateType==null ){
					
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
									
									sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
									Calendar cal3 = Calendar.getInstance(); 
									  cal3.add(Calendar.DATE,   +1);
									eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
									
									alarms.setStartingTime(sTime);
									alarms.setEndTime(eTime);
									String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
									alarms.setZeroTime(zeroTime1);
									  dateType=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
										request.setAttribute("dateType", dateType);
								}
								if(type==3){
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
									sTime=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
									Calendar cal3 = Calendar.getInstance(); 
									sTime=sTime+"-01";
									eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
									cal3.add(Calendar.MONTH, 1);//增加一天 
									cal3.add(Calendar.DAY_OF_MONTH, -1);//增加一天 
							           eTime=sdf.format(cal3.getTime());  
							           alarms.setStartingTime(sTime);
							           alarms.setEndTime(eTime);
									String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
									alarms.setZeroTime(zeroTime1);
									dateType=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
									request.setAttribute("dateType", dateType);
								}
								if(type==6){
									
									sTime=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
									Calendar cal3 = Calendar.getInstance(); 
									eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
									String sTime1=sTime+"-01-01";
									String eTime1=eTime+"-12-31";
									String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
									alarms.setZeroTime(zeroTime1);
									alarms.setStartingTime(sTime1);
									alarms.setEndTime(eTime1);
									
									dateType=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
									request.setAttribute("dateType", dateType);
								}
								if(type==5){
									alarms.setStartingTime(sTime);
									alarms.setEndTime(eTime);
									request.setAttribute("sTime", sTime);
									request.setAttribute("eTime", eTime);
									String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
									alarms.setZeroTime(zeroTime1);
								}
						
					
					
					
				}else{
					
					if(type==1){
					sTime=dateType;
					String sTime1=dateType+" 00:00:00";
					eTime=dateType+" 23:59:59";
					  Calendar cal = Calendar.getInstance(); 
					String   eTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime());
					String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
					alarms.setZeroTime(zeroTime1);
					if (eTime1.compareTo(eTime)>0) {
						alarms.setStartingTime(sTime1);
						alarms.setEndTime(eTime);
						} else {
							alarms.setStartingTime(sTime1);
							alarms.setEndTime(eTime1);
						}
					alarms.setDateTypes(null);
					request.setAttribute("dateType", dateType);
					}if(type==3){
						sTime=dateType; 
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
						String sTime1=sTime+"-01";
			            Calendar cd = Calendar.getInstance();   
			            cd.setTime(sdf.parse(sTime1));   
			            cd.add(Calendar.MONTH, 1);//增加一天 
			            cd.add(Calendar.DAY_OF_MONTH, -1);//增加一天 
			            eTime=sdf.format(cd.getTime());  
		              
			            alarms.setStartingTime(sTime);
			            alarms.setEndTime(eTime);
						String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
						alarms.setZeroTime(zeroTime1);
						alarms.setDateTypes(null);
						request.setAttribute("dateType", dateType);
					}
					if(type==6){
						sTime=dateType; 
						Calendar cal3 = Calendar.getInstance(); 
						eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
						String eTime1=dateType+"-12-31";
						String sTime1=sTime+"-01-01";
						String zTime=(new SimpleDateFormat("yyyy-MM-dd")).format(zeroTime);
						
						alarms.setEndTime(eTime1);
							
						alarms.setStartingTime(sTime1);
							
						String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
						alarms.setZeroTime(zeroTime1);
						
						
						alarms.setDateTypes(null);
						request.setAttribute("dateType", dateType);
					}
					if(type==5){
						alarms.setStartingTime(sTime);
						alarms.setEndTime(eTime);
						request.setAttribute("sTime", sTime);
						request.setAttribute("eTime", eTime);
						
						String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
						alarms.setZeroTime(zeroTime1);
					}
				}
				
				int offset = SystemContext.getOffset();
				int pagesize = SystemContext.getPagesize();
				alarms.getPager().setPageOffset(offset);
				alarms.getPager().setPageSize(pagesize);
				alarms.getPager().setOrderField("user_id");
				alarms.getPager().setOrderDirection(false);
				
				alarms.getPager().setRowCount(alarmBiz.selectCountWater(alarms));
				request.setAttribute("pager", alarms.getPager());
				List<AlarmType_water>lists=new ArrayList<AlarmType_water>();
				lists=alarmBiz.selectCountWatersHistory(alarms);
				
				for(int i=0;i<lists.size();i++){
					lists.get(i).setComName(viewCompanyconfig.getCompanyName());
					lists.get(i).setLimitHH(alarms.getLimitHH());
					lists.get(i).setLimitH(alarms.getLimitH());
					lists.get(i).setLimitLL(alarms.getLimitLL());
					lists.get(i).setLimitL(alarms.getLimitL());
					lists.get(i).setTypeRemark(alarms.getTypeRemark());
				}
				
				
				
				StringBuffer webUrl=request.getRequestURL();
				String url=webUrl+"?type="+type;
				request.setAttribute("webUrls", url);
				request.setAttribute("type", type);
				request.setAttribute("dateTypes", dateType);
				request.setAttribute("viewCompanyconfig", viewCompanyconfig);
				request.setAttribute("historys", lists);
				request.setAttribute("rid", rid);
				
				request.setAttribute("waterType", waterType);
				return "alarmWater/historyList";
			}
		
			
			
			/**
			 *历史预警记录查询列表
			 * @throws ParseException 
			 */ 
			public String warninghistoryList(AlarmType_water alarm, HttpServletRequest request, HttpServletResponse response) throws ParseException {
			
				String sTime=alarm.getStartingTime();
				String eTime=alarm.getEndTime();
				String dateType=alarm.getDateTypes();
				Integer type=alarm.getType();//查询日期类型
				Long rid=alarm.getRid();//公司ID
				/**
				 * waterType 为用户在页面选择的污染物种类   默认ph
				 * 
				 */
				Integer waterType=alarm.getWaterType();
				
				ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
				viewCompanyconfig.setRid(rid);
				viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
				Date zeroTime=viewCompanyconfig.getStratTime();
				/**
				 * 根据rid查询该公司有的污染物种类和限值
				 */
				List<AlarmType_water>  alarmType=alarmBiz.selectByCriteriawaterType(rid);
				request.setAttribute("alarmType", alarmType);
				AlarmType_water alarms=new AlarmType_water();
				alarms.setRid(rid);
				if(waterType==null){
					waterType=1;                   //默认是ph
				}
				
				
				for(int i = 0;i<alarmType.size();i++){
					if(alarmType.get(i).getType()==waterType){
						alarms=alarmType.get(i);
					}
				}
				
				String typeName="earlywarning"+waterType;				
				alarms.setTabName(typeName);
				List<AlarmType_water>datas=new ArrayList<AlarmType_water>();
				
				if(sTime==null & dateType==null ){
					
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
									
									sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
									Calendar cal3 = Calendar.getInstance(); 
									  cal3.add(Calendar.DATE,   +1);
									eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
									
									alarms.setStartingTime(sTime);
									alarms.setEndTime(eTime);
									String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
									alarms.setZeroTime(zeroTime1);
									  dateType=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
										request.setAttribute("dateType", dateType);
								}
								if(type==3){
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
									sTime=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
									Calendar cal3 = Calendar.getInstance(); 
									sTime=sTime+"-01";
									eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
									cal3.add(Calendar.MONTH, 1);//增加一天 
									cal3.add(Calendar.DAY_OF_MONTH, -1);//增加一天 
							           eTime=sdf.format(cal3.getTime());  
							           alarms.setStartingTime(sTime);
							           alarms.setEndTime(eTime);
									String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
									alarms.setZeroTime(zeroTime1);
									dateType=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
									request.setAttribute("dateType", dateType);
								}
								if(type==6){
									
									sTime=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
									Calendar cal3 = Calendar.getInstance(); 
									eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
									String sTime1=sTime+"-01-01";
									String eTime1=eTime+"-12-31";
									String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
									alarms.setZeroTime(zeroTime1);
									alarms.setStartingTime(sTime1);
									alarms.setEndTime(eTime1);
									
									dateType=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
									request.setAttribute("dateType", dateType);
								}
								if(type==5){
									alarms.setStartingTime(sTime);
									alarms.setEndTime(eTime);
									request.setAttribute("sTime", sTime);
									request.setAttribute("eTime", eTime);
									String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
									alarms.setZeroTime(zeroTime1);
								}
						
					
					
					
				}else{
					
					if(type==1){
					sTime=dateType;
					String sTime1=dateType+" 00:00:00";
					eTime=dateType+" 23:59:59";
					  Calendar cal = Calendar.getInstance(); 
					String   eTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime());
					String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
					alarms.setZeroTime(zeroTime1);
					if (eTime1.compareTo(eTime)>0) {
						alarms.setStartingTime(sTime1);
						alarms.setEndTime(eTime);
						} else {
							alarms.setStartingTime(sTime1);
							alarms.setEndTime(eTime1);
						}
					alarms.setDateTypes(null);
					request.setAttribute("dateType", dateType);
					}if(type==3){
						sTime=dateType; 
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
						String sTime1=sTime+"-01";
			            Calendar cd = Calendar.getInstance();   
			            cd.setTime(sdf.parse(sTime1));   
			            cd.add(Calendar.MONTH, 1);//增加一天 
			            cd.add(Calendar.DAY_OF_MONTH, -1);//增加一天 
			            eTime=sdf.format(cd.getTime());  
		              
			            alarms.setStartingTime(sTime);
			            alarms.setEndTime(eTime);
						String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
						alarms.setZeroTime(zeroTime1);
						alarms.setDateTypes(null);
						request.setAttribute("dateType", dateType);
					}
					if(type==6){
						sTime=dateType; 
						Calendar cal3 = Calendar.getInstance(); 
						eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
						String eTime1=dateType+"-12-31";
						String sTime1=sTime+"-01-01";
						String zTime=(new SimpleDateFormat("yyyy-MM-dd")).format(zeroTime);
						
						alarms.setEndTime(eTime1);
							
						alarms.setStartingTime(sTime1);
							
						String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
						alarms.setZeroTime(zeroTime1);
						
						
						alarms.setDateTypes(null);
						request.setAttribute("dateType", dateType);
					}
					if(type==5){
						alarms.setStartingTime(sTime);
						alarms.setEndTime(eTime);
						request.setAttribute("sTime", sTime);
						request.setAttribute("eTime", eTime);
						
						String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
						alarms.setZeroTime(zeroTime1);
					}
				}
				
				int offset = SystemContext.getOffset();
				int pagesize = SystemContext.getPagesize();
				alarms.getPager().setPageOffset(offset);
				alarms.getPager().setPageSize(pagesize);
				alarms.getPager().setOrderField("user_id");
				alarms.getPager().setOrderDirection(false);
				
				alarms.getPager().setRowCount(alarmBiz.selectCountWater(alarms));
				request.setAttribute("pager", alarms.getPager());
				List<AlarmType_water>lists=new ArrayList<AlarmType_water>();
				lists=alarmBiz.selectCountWatersHistory(alarms);
				
				for(int i=0;i<lists.size();i++){
					lists.get(i).setComName(viewCompanyconfig.getCompanyName());
					lists.get(i).setLimitHH(alarms.getLimitHH());
					lists.get(i).setLimitH(alarms.getLimitH());
					lists.get(i).setLimitLL(alarms.getLimitLL());
					lists.get(i).setLimitL(alarms.getLimitL());
					lists.get(i).setTypeRemark(alarms.getTypeRemark());
				}
				
				
				
				StringBuffer webUrl=request.getRequestURL();
				String url=webUrl+"?type="+type;
				request.setAttribute("webUrls", url);
				request.setAttribute("type", type);
				request.setAttribute("dateTypes", dateType);
				request.setAttribute("viewCompanyconfig", viewCompanyconfig);
				request.setAttribute("historys", lists);
				request.setAttribute("rid", rid);
				request.setAttribute("waterType", waterType);
				return "alarmWater/warninghistoryList";
			}
	
	

	

}
