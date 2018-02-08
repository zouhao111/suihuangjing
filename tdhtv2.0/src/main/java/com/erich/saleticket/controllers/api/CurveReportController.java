package com.erich.saleticket.controllers.api;


import java.math.BigDecimal;
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

import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import com.erich.easyframe.util.SystemContext;
import com.erich.saleticket.biz.tdht.AlarmBiz;
import com.erich.saleticket.biz.tdht.BalanceWaterBiz;
import com.erich.saleticket.biz.tdht.CurveReportBiz;
import com.erich.saleticket.biz.tdht.ReportFormBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.controllers.admin.tdht.StringDataLongTime;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread1;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread2;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread3;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread4;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread5;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread6;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread7;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread8;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.MobileData;
import com.erich.saleticket.model.tdht.AlarmType_water;
import com.erich.saleticket.model.tdht.BalanceComfig;
import com.erich.saleticket.model.tdht.BalanceWater;
import com.erich.saleticket.model.tdht.CompanyInfo;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewLineReport;
import com.erich.saleticket.model.tdht.ViewZtraffic;

/**
 *曲线报表控制器
 * @author Lv
 */
public class CurveReportController extends BaseController {
	
	
	
	public  List<ViewLineReport> aaa;
	public  List<Pollutant> bbb;
	public  List<ViewLineReport> ccc;
	public  List<Pollutant> ddd;
	public  List<ViewLineReport> eee;
	public  List<Pollutant> fff;
	public  List<ViewLineReport> ggg;
	public  List<Pollutant> hhh;
	public class MyThread1 extends Thread
	{
	    private ViewLineReport data2;
	    public MyThread1(ViewLineReport data)
	    {
	    	data2 = data;
	    }
	    public void run()
	    {SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date())+"*********进程1时间");// new Date()为获取当前系统时间
	    	aaa =curveReportBiz.selectByCriteriaNew(data2);
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程1结束时间");// new Date()为获取当前系统时间
	    }

	}
	public class MyThread2 extends Thread
	{
	    private ViewLineReport data2;
	    public MyThread2(ViewLineReport data)
	    {
	    	data2 = data;
	    }
	    public void run()
	    {
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df.format(new Date())+"*********进程2时间");// new Date()为获取当前系统时间
	    	bbb =curveReportBiz.selectByCriteria_phnew(data2);
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程2结束时间");// new Date()为获取当前系统时间
	    }

	}
	public class MyThread3 extends Thread
	{ private ViewLineReport data2;
	 public MyThread3(ViewLineReport data)
	    {
	    	data2 = data;
	    }
	    public void run()
	    {SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date())+"*********进程3时间");// new Date()为获取当前系统时间
	    	ccc =curveReportBiz.selectByCriteriaNew(data2);
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程3结束时间");// new Date()为获取当前系统时间
	    }

	}
	public class MyThread4 extends Thread
	{
	    private ViewLineReport data2;
	    public MyThread4(ViewLineReport data)
	    {
	    	data2 = data;
	    }
	    public void run()
	    {
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df.format(new Date())+"*********进程4时间");// new Date()为获取当前系统时间
	    	ddd =curveReportBiz.selectByCriteria_phnew(data2);
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程4结束时间");// new Date()为获取当前系统时间
	    }

	}
	public class MyThread5 extends Thread
	{ private ViewLineReport data2;
	 public MyThread5(ViewLineReport data)
	    {
	    	data2 = data;
	    }
	    public void run()
	    {SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date())+"*********进程5时间");// new Date()为获取当前系统时间
	    	eee =curveReportBiz.selectByCriteriaNew(data2);
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程5结束时间");// new Date()为获取当前系统时间
	    }

	}
	public class MyThread6 extends Thread
	{
	    private ViewLineReport data2;
	    public MyThread6(ViewLineReport data)
	    {
	    	data2 = data;
	    }
	    public void run()
	    {
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df.format(new Date())+"*********进程6时间");// new Date()为获取当前系统时间
	    	fff =curveReportBiz.selectByCriteria_phnew(data2);
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程6结束时间");// new Date()为获取当前系统时间
	    }

	}
	public class MyThread7 extends Thread
	{ private ViewLineReport data2;
	 public MyThread7(ViewLineReport data)
	    {
	    	data2 = data;
	    }
	    public void run()
	    {SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date())+"*********进程7时间");// new Date()为获取当前系统时间
	    	ggg =curveReportBiz.selectByCriteriaNew(data2);
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程7结束时间");// new Date()为获取当前系统时间
	    }

	}
	public class MyThread8 extends Thread
	{
	    private ViewLineReport data2;
	    public MyThread8(ViewLineReport data)
	    {
	    	data2 = data;
	    }
	    public void run()
	    {
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df.format(new Date())+"*********进程8时间");// new Date()为获取当前系统时间
	    	hhh =curveReportBiz.selectByCriteria_phnew(data2);
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程8结束时间");// new Date()为获取当前系统时间
	    }

	}
	
	 private  List<Long> Time_sub(String sTime,String eTime,int type) throws ParseException{
	    	List<String>times=new ArrayList<String>();
	    	List<Long>timesy=new ArrayList<Long>();
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
	             
				long midTime=(sub+LongsTime)/60000;
				//Date date = new Date(midTime);
			//	String midTimes=sdf.format(date);
				 LongsTime=LongsTime/60000;
		 			LongeTime=LongeTime/60000;
				timesy.add(LongsTime+480);
				timesy.add(midTime+480);
				timesy.add(midTime+480);
				timesy.add(LongeTime+480);
				
			}else{
			
			
				
			long sub=(LongeTime-LongsTime)/4;
			long midTime=(sub+LongsTime)/60000;
			long midTime2=(sub+sub+LongsTime)/60000;
			long midTime3=(sub+sub+sub+LongsTime)/60000;
			LongsTime=LongsTime/60000;
			LongeTime=LongeTime/60000;
			timesy.add(LongsTime+480);
			timesy.add(midTime+480);
			timesy.add(midTime+480);
			timesy.add(midTime2+480);
			timesy.add(midTime2+480);
			timesy.add(midTime3+480);
			timesy.add(midTime3+480);
			timesy.add(LongeTime+480);
			
			}
			return timesy;
		}
		

	@Resource
	private CurveReportBiz curveReportBiz;
	@Resource
	private  ReportFormBiz reportFormBiz;
	@Resource
	private AlarmBiz alarmBiz;
	@Resource
	private BalanceWaterBiz balanceBizs;
	
	/**
	 * 曲线报表查询列表
	 * @throws ParseException 
	 */
	@Get("curveReportList")
	@Post("curveReportList")
	public String curveReportList(ViewLineReport data, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		
		MobileData<List<Object>> result = new MobileData<List<Object>>(ApiResultcode._0);
		
		
		int datasize = 0;
		ViewLineReport data_1=new ViewLineReport();
		ViewLineReport data_2=new ViewLineReport();
		ViewLineReport data_3=new ViewLineReport();
		ViewLineReport data_4=new ViewLineReport();
		Long rid =data.getRid();
		CompanyInfo com = new CompanyInfo();
		com.setCompany_id(rid);
		String sTime=data.getStartingTime();
		String eTime=data.getEndTime();
		Integer minates=data.getMinates();
		Integer type=data.getType();
		Integer form =data.getForm();//1工业排水   2工业给水  3生活给水  4 流量汇总5 流量汇总系数 6 污染物
		String dateTypes=data.getDateTypes();
		String month=data.getLat();//查询前一天后一天
		Pollutant data2=new Pollutant();
		data2.setRid(rid);
		String url=null;
		List<ViewLineReport> datas=new ArrayList<ViewLineReport>();
		List<Pollutant> datasss=new ArrayList<Pollutant>();
		ViewCompanyconfig company=curveReportBiz.selectCompanyName2(com);
		String companyName=company.getCompanyName();
		//清零时间
		Date zeroTime=company.getStratTime();
		
		
		
		/**
		 *  当没有选择时间时  设定默认时间
		 */
		if(sTime==null  & dateTypes==null){
			int offset = SystemContext.getOffset();
			
			Calendar cal = Calendar.getInstance(); 
			cal.set(Calendar.HOUR_OF_DAY, 0); 
			cal.set(Calendar.SECOND, 0); 
			cal.set(Calendar.MINUTE, 0); 
			Calendar cal2 = Calendar.getInstance();
			cal2.set(Calendar.HOUR_OF_DAY, 23); 
			cal2.set(Calendar.SECOND, 59); 
			cal2.set(Calendar.MINUTE, 59);
			
			data.setStartingTime(sTime);
			data.setEndTime(eTime);
			if(type==1){
				sTime=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
				Calendar cal3 = Calendar.getInstance(); 
				  cal3.add(Calendar.DATE,   +1);
				eTime=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal3.getTime());
				
				List<Long>times=Time_sub(sTime,eTime,type);
				if(times.size()==4){
					data_1.setStartingTimeL(times.get(0));
					data_1.setEndTimeL(times.get(1));
					data_1.setMinates(5);
					data_1.setRid(rid);
					data_1.setRemainder(0);
					
					data_2.setStartingTimeL(times.get(2));
					data_2.setEndTimeL(times.get(3));
					data_2.setMinates(5);
					data_2.setRid(rid);
					datasize=2;
					data_2.setRemainder(0);
				}else{
				data_1.setStartingTimeL(times.get(0));
				data_1.setEndTimeL(times.get(1));
				data_1.setMinates(5);
				data_1.setRid(rid);
				data_1.setRemainder(0);
				
				data_2.setStartingTimeL(times.get(2));
				data_2.setEndTimeL(times.get(3));
				data_2.setMinates(5);
				data_2.setRid(rid);
				data_2.setRemainder(0);
				data_3.setStartingTimeL(times.get(4));
				data_3.setEndTimeL(times.get(5));
				data_3.setMinates(5);
				data_3.setRid(rid);
				data_3.setRemainder(0);
				
				data_4.setStartingTimeL(times.get(6));
				data_4.setEndTimeL(times.get(7));
				data_4.setMinates(5);
				data_4.setRid(rid);
				datasize=4;
				data_4.setRemainder(0);
				}
				sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
			
				eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
				request.setAttribute("eTime", eTime);
				request.setAttribute("sTime", sTime);
			}
			if(type==5){
			sTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
			eTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal2.getTime()); 
			
		//List<String>times=Time_sub(sTime,eTime,type);
			List<Long>times=Time_sub(sTime,eTime,type);
			if(times.size()==4){
				data_1.setStartingTimeL(times.get(0));
				data_1.setEndTimeL(times.get(1));
				data_1.setMinates(5);
				data_1.setRid(rid);
				data_1.setRemainder(0);
				
				data_2.setStartingTimeL(times.get(2));
				data_2.setEndTimeL(times.get(3));
				data_2.setMinates(5);
				data_2.setRid(rid);
				datasize=2;
				data_2.setRemainder(0);
			}else{
			data_1.setStartingTimeL(times.get(0));
			data_1.setEndTimeL(times.get(1));
			data_1.setMinates(5);
			data_1.setRid(rid);
			data_1.setRemainder(0);
			
			data_2.setStartingTimeL(times.get(2));
			data_2.setEndTimeL(times.get(3));
			data_2.setMinates(5);
			data_2.setRid(rid);
			data_2.setRemainder(0);
			
			data_3.setStartingTimeL(times.get(4));
			data_3.setEndTimeL(times.get(5));
			data_3.setMinates(5);
			data_3.setRid(rid);
			data_3.setRemainder(0);
			
			data_4.setStartingTimeL(times.get(6));
			data_4.setEndTimeL(times.get(7));
			data_4.setMinates(5);
			data_4.setRid(rid);
			datasize=4;
			data_4.setRemainder(0);
			}
			}
			if(type==3){
				
				sTime=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
				Calendar cal3 = Calendar.getInstance(); 
				 
				eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
				String sTime1=sTime+"-01";
				
				//List<String>times=Time_sub(sTime1,eTime,type);
				List<Long>times=Time_sub(sTime1,eTime,type);
				if(times.size()==4){
					data_1.setStartingTimeL(times.get(0));
					data_1.setEndTimeL(times.get(1));
					data_1.setMinates(30);
					data_1.setRid(rid);
					data_1.setRemainder(0);
					
					data_2.setStartingTimeL(times.get(2));
					data_2.setEndTimeL(times.get(3));
					data_2.setMinates(30);
					data_2.setRid(rid);
					datasize=2;
					data_2.setRemainder(0);
				}else{
				data_1.setStartingTimeL(times.get(0));
				data_1.setEndTimeL(times.get(1));
				data_1.setMinates(30);
				data_1.setRid(rid);
				data_1.setRemainder(0);
				
				data_2.setStartingTimeL(times.get(2));
				data_2.setEndTimeL(times.get(3));
				data_2.setMinates(30);
				data_2.setRid(rid);
				data_2.setRemainder(0);
				
				data_3.setStartingTimeL(times.get(4));
				data_3.setEndTimeL(times.get(5));
				data_3.setMinates(30);
				data_3.setRid(rid);
				data_3.setRemainder(0);
				
				data_4.setStartingTimeL(times.get(6));
				data_4.setEndTimeL(times.get(7));
				data_4.setMinates(30);
				data_4.setRid(rid);
				datasize=4;
				data_4.setRemainder(0);
				}
				
			}
			if(type==6){
				sTime=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
				Calendar cal3 = Calendar.getInstance(); 
				eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
				String sTime1=sTime+"-01-01";
				String zTime=(new SimpleDateFormat("yyyy-MM-dd")).format(zeroTime);
				//List<String>times=new ArrayList<String>();
				List<Long>times=new ArrayList<Long>();
				if (zTime.compareTo(sTime)>0) {
					times=Time_sub(zTime,eTime,type);
					} else {
					times=Time_sub(sTime1,eTime,type);
					}
				if(times.size()==4){
					data_1.setStartingTimeL(times.get(0));
					data_1.setEndTimeL(times.get(1));
					data_1.setMinates(60);
					data_1.setRid(rid);
					data_1.setRemainder(0);
					
					data_2.setStartingTimeL(times.get(2));
					data_2.setEndTimeL(times.get(3));
					data_2.setMinates(60);
					data_2.setRid(rid);
					datasize=2;
					data_2.setRemainder(0);
				}else{
				data_1.setStartingTimeL(times.get(0));
				data_1.setEndTimeL(times.get(1));
				data_1.setMinates(60);
				data_1.setRid(rid);
				data_1.setRemainder(0);
				
				data_2.setStartingTimeL(times.get(2));
				data_2.setEndTimeL(times.get(3));
				data_2.setMinates(60);
				data_2.setRid(rid);
				data_2.setRemainder(0);
				
				data_3.setStartingTimeL(times.get(4));
				data_3.setEndTimeL(times.get(5));
				data_3.setMinates(60);
				data_3.setRid(rid);
				data_3.setRemainder(0);
				
				data_4.setStartingTimeL(times.get(6));
				data_4.setEndTimeL(times.get(7));
				data_4.setMinates(60);
				data_4.setRid(rid);
				datasize=4;
				data_4.setRemainder(0);
				}
				
			}
		/**
		 * 曲线添加
		 */
		
			String viewName;
			
			if(form==1){
				 viewName="sourcemidtabindustrialdrainage";
				 data_1.setViewName(viewName);
				 data_2.setViewName(viewName);
				 data_3.setViewName(viewName);
				 data_4.setViewName(viewName);
				}else if(form==2){
						 viewName="sourcemidtabindustrialsupply";
						 data_1.setViewName(viewName);
						 data_2.setViewName(viewName);
						 data_3.setViewName(viewName);
						 data_4.setViewName(viewName);
						}else if(form==3){
							 viewName="sourcemidtablivingsupply";
							 data_1.setViewName(viewName);
							 data_2.setViewName(viewName);
							 data_3.setViewName(viewName);
							 data_4.setViewName(viewName);
							}
			Thread	thread1 =null;Thread	thread2 =null;Thread	thread3 =null;Thread	thread4 =null;
			Thread	thread5 =null;Thread	thread6 =null;Thread	thread7 =null;Thread	thread8 =null;
			if(form==1){
				
				
				
				if(datasize==2){
					//thread1 = new MyThread1(data_1);
		            // thread1.start();  
		             thread2 = new MyThread2(data_1);
			        thread2.start(); 
			      //     thread3 = new MyThread3(data_2);
			     //   thread3.start();  
			         thread4 = new MyThread4(data_2);
				    thread4.start();  
				}else{
				//	 thread1 = new MyThread1(data_1);
		         //    thread1.start();  
		              thread2 = new MyThread2(data_1);
			        thread2.start(); 
			      //   thread3 = new MyThread3(data_2);
			    //    thread3.start();  
			         thread4 = new MyThread4(data_2);
				    thread4.start();  
				//      thread5 = new MyThread5(data_3);
		       //      thread5.start();  
		              thread6 = new MyThread6(data_3);
			        thread6.start(); 
			   //      thread7 = new MyThread7(data_4);
			  //      thread7.start();  
			           thread8 = new MyThread8(data_4);
				    thread8.start();  
	                  
				    
				}
				 }else{
					 if(datasize==2){
							thread1 = new MyThread1(data_1);
				             thread1.start();  
				             //thread2 = new MyThread2(data_1);
					        //thread2.start(); 
					         thread3 = new MyThread3(data_2);
					        thread3.start();  
					        // thread4 = new MyThread4(data_2);
						   // thread4.start();  
						}else{
							 thread1 = new MyThread1(data_1);
				             thread1.start();  
				            //  thread2 = new MyThread2(data_1);
					       // thread2.start(); 
					         thread3 = new MyThread3(data_2);
					        thread3.start();  
					       //  thread4 = new MyThread4(data_2);
						   // thread4.start();  
						      thread5 = new MyThread5(data_3);
				             thread5.start();  
				           //   thread6 = new MyThread6(data_3);
					      //  thread6.start(); 
					        thread7 = new MyThread7(data_4);
					        thread7.start();  
					        //   thread8 = new MyThread8(data_4);
						   // thread8.start();  	
					}
				 }
					 if(form==1){
						 
					
			        while(true)
			        {
					    if(datasize==2){
					//	if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive())
							if (!thread2.isAlive()&&!thread4.isAlive())
					    {
					    	/*if(aaa.size()!=0){
					    		datas=aaa;
					    	}
					    	if(ccc.size()!=0){
					    		datas.addAll(ccc);
					    	}*/
					    	
					    	if(bbb.size()!=0){
					    		datasss=bbb;
					    	}
					    	if(ddd.size()!=0){
					    		datasss.addAll(ddd);
					    	}
					    	
					    	
					    	break;
					    }
			        }else{
			        	if(datasize==4){
						//	if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive()&&!thread5.isAlive()&&!thread6.isAlive()&&!thread7.isAlive()&&!thread8.isAlive())
			        		if (!thread2.isAlive()&&!thread4.isAlive()&&!thread6.isAlive()&&!thread8.isAlive())
			        		{
						    	
						    	
						    	if(bbb.size()!=0){
						    		datasss=bbb;
						    	}
						    	if(ddd.size()!=0){
						    		datasss.addAll(ddd);
						    	}
						    	if(fff.size()!=0){
						    		datasss.addAll(fff);
						    	}
						    	if(hhh.size()!=0){
						    		datasss.addAll(hhh);
						    	}
						    	
						    	break;
						    }
				        }
			        }
			        	
			        }
	        }else{
	        	 while(true)
			        {
					    if(datasize==2){
					//	if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive())
							if (!thread1.isAlive()&&!thread3.isAlive())
					    {
					    	if(aaa.size()!=0){
					    		datas=aaa;
					    	}
					    	if(ccc.size()!=0){
					    		datas.addAll(ccc);
					    	}
					    	
					    	
					    	
					    	break;
					    }
			        }else{
			        	if(datasize==4){
						//	if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive()&&!thread5.isAlive()&&!thread6.isAlive()&&!thread7.isAlive()&&!thread8.isAlive())
			        		if (!thread1.isAlive()&&!thread3.isAlive()&&!thread5.isAlive()&&!thread7.isAlive())
			        		{
						    	if(aaa.size()!=0){
						    		datas=aaa;
						    	}
						    	if(ccc.size()!=0){
						    		datas.addAll(ccc);
						    	}
						    	if(eee.size()!=0){
						    		datas.addAll(eee);
						    	}
						    	if(ggg.size()!=0){
						    		datas.addAll(ggg);
						    	}
						    	
						    
						    	
						    	break;
						    }
				        }
			        }
			        	
			        }	 
					 }
			        
		}else{
			
String viewName;
			
			if(form==1){
				 viewName="sourcemidtabindustrialdrainage";
				 data_1.setViewName(viewName);
				 data_2.setViewName(viewName);
				 data_3.setViewName(viewName);
				 data_4.setViewName(viewName);
				}else if(form==2){
						 viewName="sourcemidtabindustrialsupply";
						 data_1.setViewName(viewName);
						 data_2.setViewName(viewName);
						 data_3.setViewName(viewName);
						 data_4.setViewName(viewName);
						}else if(form==3){
							 viewName="sourcemidtablivingsupply";
							 data_1.setViewName(viewName);
							 data_2.setViewName(viewName);
							 data_3.setViewName(viewName);
							 data_4.setViewName(viewName);
							}
			if(type==1){
				//	List<String>times;
					List<Long>times;
					sTime=dateTypes;
					
					String sTime1=sTime+" 00:00:00";
					eTime=sTime+" 23:59:59";
					  Calendar cal = Calendar.getInstance(); 
					String   eTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime());
					if (eTime1.compareTo(eTime)>0) {
						times=Time_sub(sTime1,eTime,type);
						} else {
						times=Time_sub(sTime1,eTime1,type);
						}
					
					if(times.size()==4){
						data_1.setStartingTimeL(times.get(0));
						data_1.setEndTimeL(times.get(1));
						data_1.setRid(rid);
						data_1.setRemainder(0);
						data_1.setMinates(5);
						data_2.setStartingTimeL(times.get(2));
						data_2.setEndTimeL(times.get(3));
						data_2.setRid(rid);
						data_2.setRemainder(0);
						data_2.setMinates(5);
						datasize=2;
					}else{
					data_1.setStartingTimeL(times.get(0));
					data_1.setEndTimeL(times.get(1));
					data_1.setRid(rid);
					data_1.setRemainder(0);
					data_1.setMinates(5);
					data_2.setStartingTimeL(times.get(2));
					data_2.setEndTimeL(times.get(3));
					data_2.setRid(rid);
					data_2.setRemainder(0);
					data_2.setMinates(5);
					data_3.setStartingTimeL(times.get(4));
					data_3.setEndTimeL(times.get(5));
					data_3.setRid(rid);
					data_3.setRemainder(0);
					data_3.setMinates(5);
					data_4.setStartingTimeL(times.get(6));
					data_4.setEndTimeL(times.get(7));
					data_4.setRid(rid);
					datasize=4;
					data_4.setRemainder(0);
					data_4.setMinates(5);
					}
					
					
					dateTypes=null;
					data.setDateTypes(dateTypes);
				}else if(type==2){
					
					data.setRemainder(0);
				}else if(type==3){
					
					sTime=dateTypes; 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
					String sTime1=sTime+"-01";
		            Calendar cd = Calendar.getInstance();   
		            cd.setTime(sdf.parse(sTime1));   
		            cd.add(Calendar.MONTH, 1);//增加一天 
		            cd.add(Calendar.DAY_OF_MONTH, -1);//增加一天 
		            eTime=sdf.format(cd.getTime());  
		           
					
				//	List<String>times=Time_sub(sTime1,eTime,type);
		            List<Long>times=Time_sub(sTime1,eTime,type);
					if(times.size()==4){
						data_1.setStartingTimeL(times.get(0));
						data_1.setEndTimeL(times.get(1));
						data_1.setMinates(30);
						data_1.setRid(rid);
						data_1.setRemainder(0);
						
						data_2.setStartingTimeL(times.get(2));
						data_2.setEndTimeL(times.get(3));
						data_2.setMinates(30);
						data_2.setRid(rid);
						datasize=2;
						data_2.setRemainder(0);
					}else{
					data_1.setStartingTimeL(times.get(0));
					data_1.setEndTimeL(times.get(1));
					data_1.setMinates(30);
					data_1.setRid(rid);
					data_1.setRemainder(0);
					
					data_2.setStartingTimeL(times.get(2));
					data_2.setEndTimeL(times.get(3));
					data_2.setMinates(30);
					data_2.setRid(rid);
					data_2.setRemainder(0);
					
					data_3.setStartingTimeL(times.get(4));
					data_3.setEndTimeL(times.get(5));
					data_3.setMinates(30);
					data_3.setRid(rid);
					data_3.setRemainder(0);
					
					data_4.setStartingTimeL(times.get(6));
					data_4.setEndTimeL(times.get(7));
					data_4.setMinates(30);
					data_4.setRid(rid);
					datasize=4;
					data_4.setRemainder(0);
					}   
					
					dateTypes=null;
					data.setDateTypes(dateTypes);
				}else if(type==6){
					
					sTime=dateTypes; 
					Calendar cal3 = Calendar.getInstance(); 
					eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
					String eTime1=dateTypes+"-12-31";
					String sTime1=sTime+"-01-01";
					String zTime=(new SimpleDateFormat("yyyy-MM-dd")).format(zeroTime);
				//	List<String>times=new ArrayList<String>();
					 List<Long>times=new ArrayList<Long>();
					if (eTime1.compareTo(eTime)>0) {
						times=Time_sub(zTime,eTime,type);
						} else {
						times=Time_sub(sTime1,eTime1,type);
						}
					if (zTime.compareTo(sTime)>0) {
						times=Time_sub(zTime,eTime,type);
						} else {
						times=Time_sub(sTime1,eTime,type);
						}
					if(times.size()==4){
						data_1.setStartingTimeL(times.get(0));
						data_1.setEndTimeL(times.get(1));
						data_1.setMinates(60);
						data_1.setRid(rid);
						data_1.setRemainder(0);
						
						data_2.setStartingTimeL(times.get(2));
						data_2.setEndTimeL(times.get(3));
						data_2.setMinates(60);
						data_2.setRid(rid);
						datasize=2;
						data_2.setRemainder(0);
					}else{
					data_1.setStartingTimeL(times.get(0));
					data_1.setEndTimeL(times.get(1));
					data_1.setMinates(60);
					data_1.setRid(rid);
					data_1.setRemainder(0);
					
					data_2.setStartingTimeL(times.get(2));
					data_2.setEndTimeL(times.get(3));
					data_2.setMinates(60);
					data_2.setRid(rid);
					data_2.setRemainder(0);
					
					data_3.setStartingTimeL(times.get(4));
					data_3.setEndTimeL(times.get(5));
					data_3.setMinates(60);
					data_3.setRid(rid);
					data_3.setRemainder(0);
					
					data_4.setStartingTimeL(times.get(6));
					data_4.setEndTimeL(times.get(7));
					data_4.setMinates(60);
					data_4.setRid(rid);
					datasize=4;
					data_4.setRemainder(0);
					}
					dateTypes=null;
					data.setDateTypes(dateTypes);
				}else if(type==5){
					
				//	List<String>times=Time_sub(sTime,eTime,type);
					List<Long>times=Time_sub(sTime,eTime,type);
					
					//通过字符串创建两个日期对象
					SimpleDateFormat smdf = new SimpleDateFormat( "yyyy-MM-dd "); 
					int  t=0;
					try { 
					Date start = smdf.parse(sTime); 
					Date end = smdf.parse( eTime); 
					  t = (int) ((end.getTime() - start.getTime()) / (3600 * 24 * 1000)); 
					} catch (ParseException e) { 
					e.printStackTrace(); 
					}
					
					
					if(times.size()==4){
						
						
						data_1.setStartingTimeL(times.get(0));
						data_1.setEndTimeL(times.get(1));
						data_1.setRid(rid);
						data_1.setMinates(minates);
						
						data_2.setStartingTimeL(times.get(2));
						data_2.setEndTimeL(times.get(3));
						data_2.setMinates(minates);
						data_2.setRid(rid);
						datasize=2;
						if(minates==1440){
							
							 SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");  
						        Date date = null;  
						        date = formatter.parse(data_1.getStartingTime());  
						      long ts=( date.getTime() - 60000 * date.getTimezoneOffset())/1000/60;
						      int timess= (int)(ts%1440);
						      data_1.setRemainder(timess);
						      data_2.setRemainder(timess);
						     
						}else{
							 data_1.setRemainder(0);
						      data_2.setRemainder(0);
						     
						}
					}else{
						
						
					data_1.setStartingTimeL(times.get(0));
					data_1.setEndTimeL(times.get(1));
					data_1.setRid(rid);
					data_1.setMinates(minates);
					
					data_2.setStartingTimeL(times.get(2));
					data_2.setEndTimeL(times.get(3));
					data_2.setRid(rid);
					data_2.setMinates(minates);
					
					data_3.setStartingTimeL(times.get(4));
					data_3.setEndTimeL(times.get(5));
					data_3.setRid(rid);
					data_3.setMinates(minates);
					
					data_4.setStartingTimeL(times.get(6));
					data_4.setEndTimeL(times.get(7));
					data_4.setRid(rid);
					datasize=4;
					data_4.setMinates(minates);
				if(minates==1440){
					
					 SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");  
				        Date date = null;  
				        date = formatter.parse(data_1.getStartingTime());  
				      long ts=( date.getTime() - 60000 * date.getTimezoneOffset())/1000/60;
				      int timess= (int)(ts%1440);
				      data_1.setRemainder(timess);
				      data_2.setRemainder(timess);
				      data_3.setRemainder(timess);
				      data_4.setRemainder(timess);
				}else{
					 data_1.setRemainder(0);
				      data_2.setRemainder(0);
				      data_3.setRemainder(0);
				      data_4.setRemainder(0);
				}
				
				}
				}
			Thread	thread1 =null;Thread	thread2 =null;Thread	thread3 =null;Thread	thread4 =null;
			Thread	thread5 =null;Thread	thread6 =null;Thread	thread7 =null;Thread	thread8 =null;
			
			
			if(form==1){
				
				
				
				if(datasize==2){
					//thread1 = new MyThread1(data_1);
		            // thread1.start();  
		             thread2 = new MyThread2(data_1);
			        thread2.start(); 
			      //     thread3 = new MyThread3(data_2);
			     //   thread3.start();  
			         thread4 = new MyThread4(data_2);
				    thread4.start();  
				}else{
				
		              thread2 = new MyThread2(data_1);
			        thread2.start(); 
			         thread4 = new MyThread4(data_2);
				    thread4.start();  
		              thread6 = new MyThread6(data_3);
			        thread6.start(); 
			           thread8 = new MyThread8(data_4);
				    thread8.start();  
	                  
				    
				}
				 }else{
					 if(datasize==2){
							thread1 = new MyThread1(data_1);
				             thread1.start();  
				             //thread2 = new MyThread2(data_1);
					        //thread2.start(); 
					         thread3 = new MyThread3(data_2);
					        thread3.start();  
					        // thread4 = new MyThread4(data_2);
						   // thread4.start();  
						}else{
							 thread1 = new MyThread1(data_1);
				             thread1.start();  
				            //  thread2 = new MyThread2(data_1);
					       // thread2.start(); 
					         thread3 = new MyThread3(data_2);
					        thread3.start();  
					       //  thread4 = new MyThread4(data_2);
						   // thread4.start();  
						      thread5 = new MyThread5(data_3);
				             thread5.start();  
				           //   thread6 = new MyThread6(data_3);
					      //  thread6.start(); 
					        thread7 = new MyThread7(data_4);
					        thread7.start();  
					        //   thread8 = new MyThread8(data_4);
						   // thread8.start();  	
					}
				 } 
					 if(form==1){
						 
					
			        while(true)
			        {
					    if(datasize==2){
					//	if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive())
							if (!thread2.isAlive()&&!thread4.isAlive())
					    {
					    	
					    	if(bbb.size()!=0){
					    		datasss=bbb;
					    	}
					    	if(ddd.size()!=0){
					    		datasss.addAll(ddd);
					    	}
					    	
					    	break;
					    }
			        }else{
			        	if(datasize==4){
						//	if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive()&&!thread5.isAlive()&&!thread6.isAlive()&&!thread7.isAlive()&&!thread8.isAlive())
			        		if (!thread2.isAlive()&&!thread4.isAlive()&&!thread6.isAlive()&&!thread8.isAlive())
			        		{
						    	
						    	if(bbb.size()!=0){
						    		datasss=bbb;
						    	}
						    	if(ddd.size()!=0){
						    		datasss.addAll(ddd);
						    	}
						    	if(fff.size()!=0){
						    		datasss.addAll(fff);
						    	}
						    	if(hhh.size()!=0){
						    		datasss.addAll(hhh);
						    	}
						    	
						    	break;
						    }
				        }
			        }
			        	
			        }
	        }else{
	        	 while(true)
			        {
					    if(datasize==2){
					//	if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive())
							if (!thread1.isAlive()&&!thread3.isAlive())
					    {
					    	if(aaa.size()!=0){
					    		datas=aaa;
					    	}
					    	if(ccc.size()!=0){
					    		datas.addAll(ccc);
					    	}
					    	
					    	
					    	break;
					    }
			        }else{
			        	if(datasize==4){
						//	if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive()&&!thread5.isAlive()&&!thread6.isAlive()&&!thread7.isAlive()&&!thread8.isAlive())
			        		if (!thread1.isAlive()&&!thread3.isAlive()&&!thread5.isAlive()&&!thread7.isAlive())
			        		{
						    	if(aaa.size()!=0){
						    		datas=aaa;
						    	}
						    	if(ccc.size()!=0){
						    		datas.addAll(ccc);
						    	}
						    	if(eee.size()!=0){
						    		datas.addAll(eee);
						    	}
						    	if(ggg.size()!=0){
						    		datas.addAll(ggg);
						    	}
						    	
						    	break;
						    }
				        }
			        }
			        	
			        }	 
					 }
		
		}
	
		 
		List<Pollutant> data_name=curveReportBiz.selectByPollutant_Pollname_cur(data2);
		 
		List<Object > data_name1=new ArrayList<Object>(20);
		data_name1.add("总流量*10^3(m³)");
		data_name1.add("水位*10^-2(m)");
		data_name1.add("流量速率*10^-3(m³/s)");
		data_name1.add("流速*10^-2(m/s)");
		data_name1.add("PH");
		data_name1.add("电导率*10^3(μS/cm)");
		
		for(int i=0;i<data_name.size();i++){
			int a=i+6;
			
			if(data_name.get(i).getPollType().equals("浊度*10^1")){
				data_name1.add(a,data_name.get(i).getPollType()+"(NTU)");
			}else if(data_name.get(i).getPollType().equals("水温")){
				data_name1.add(a,data_name.get(i).getPollType()+"(℃)");
			}else{
			data_name1.add(a,data_name.get(i).getPollType()+"(mg/l)");
			}
			
		}
		
		
		List<AlarmType_water> dataname2=alarmBiz.selectByCriteriawaterType(rid);
		for(int i=0;i<dataname2.size();i++){
			if(dataname2.get(i).getTypeRemark().equals("ph值")){
				result.setPhLimit(dataname2.get(i));
			}
			if(dataname2.get(i).getTypeRemark().equals("固体悬浮物")){
				result.setMlssLimit(dataname2.get(i));
			}
			if(dataname2.get(i).getTypeRemark().equals("总铜")){
				result.setCuLimit(dataname2.get(i));
			}
			if(dataname2.get(i).getTypeRemark().equals("总镍")){
				result.setNiLimit(dataname2.get(i));
			}
			if(dataname2.get(i).getTypeRemark().equals("总磷")){
				result.setPhosphorLimit(dataname2.get(i));
			}
			if(dataname2.get(i).getTypeRemark().equals("氨氮")){
				result.setNH3NLimit(dataname2.get(i));
			}
			if(dataname2.get(i).getTypeRemark().equals("六价铬")){
				result.setCr6Limit(dataname2.get(i));
			}
			if(dataname2.get(i).getTypeRemark().equals("COD")){
				result.setCodLimit(dataname2.get(i));
			}
			if(dataname2.get(i).getTypeRemark().equals("总锌")){
				result.setZnLimit(dataname2.get(i));
			}
			if(dataname2.get(i).getTypeRemark().equals("溶解氧")){
				result.setDoLimit(dataname2.get(i));
			}
			if(dataname2.get(i).getTypeRemark().equals("浊度")){
				result.setTurbidityLimit(dataname2.get(i));
			}
			if(dataname2.get(i).getTypeRemark().equals("水温")){
				result.setTempLimit(dataname2.get(i));
			}
			if(dataname2.get(i).getTypeRemark().equals("氟化物")){
				result.setFluLimit(dataname2.get(i));
			}
		}
		
		
		
		List<Object>ztraffic=new ArrayList<Object>();//工业给水总流量
		List<Object>ztrafficIS=new ArrayList<Object>();//工业给水总流量
		List<Object>ztrafficID=new ArrayList<Object>();//工业排水总流量
		List<Object>ztrafficDS=new ArrayList<Object>();//生活给水总流量
		List<Object>currentSpeed=new ArrayList<Object>();//流速
		List<Object>traffic=new ArrayList<Object>();//流量速率
		List<Object>waterleve=new ArrayList<Object>();//水位
		List<Object>ph=new ArrayList<Object>();//ph
		List<Object>conductivity=new ArrayList<Object>();//电导率
		List<Object>sytime=new ArrayList<Object>();//系统时间
		List<Object>cod=new ArrayList<Object>();//cod
		List<Object>NH3N=new ArrayList<Object>();//氨氮
		List<Object>cr6=new ArrayList<Object>();//生活给水总流量
		List<Object>sytime2=new ArrayList<Object>();//系统时间
		
		List<Object>Turbidity=new ArrayList<Object>();//浊度
		List<Object>Do=new ArrayList<Object>();//溶解氧
		List<Object>Temp=new ArrayList<Object>();//温度
		
		List<Object>toc=new ArrayList<Object>();//cod
		List<Object>bod=new ArrayList<Object>();//氨氮
	    List<Object>mlss=new ArrayList<Object>();//生活给水总流量
		
		List<Object>cr=new ArrayList<Object>();//cod
		List<Object>ni=new ArrayList<Object>();//氨氮
		List<Object>cd=new ArrayList<Object>();//cod
		List<Object>lead=new ArrayList<Object>();//氨氮
	    List<Object>silver=new ArrayList<Object>();//生活给水总流量
		
		List<Object>hg=new ArrayList<Object>();//cod
		List<Object>phosphor=new ArrayList<Object>();//氨氮
		
		List<Object>cu=new ArrayList<Object>();//cod
		List<Object>zn=new ArrayList<Object>();//氨氮
		
		List<Object>flu=new ArrayList<Object>();//氟化物
		
		List<Object>Losslimit=new ArrayList<Object>();//限值
		List<Object>unknown=new ArrayList<Object>();//不明用水
		List<Double>wastage=new ArrayList<Double>();//耗损
		//循环将前十条数据的单个数据取出来插入对应的集合
		if(form==1){
			for(int i=0;i<datasss.size();i++){
				
					/*if(datas.get(i).getStrTime().toString().equals(datass.get(j).getStrTime().toString())){*/
				 BigDecimal   b1   =   new   BigDecimal(datasss.get(i).getTabZtraffic()/1000);  
			        double   ztrafficd   =   b1.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();  
					ztraffic.add(ztrafficd);
					BigDecimal   b2   =   new   BigDecimal(datasss.get(i).getTabCurrentSpeed()*100);  
					double   currentSpeedd   =   b2.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
					currentSpeed.add(currentSpeedd);
					BigDecimal   b3   =   new   BigDecimal(datasss.get(i).getTabTraffic()*1000);  
					double   trafficd   =   b3.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
					traffic.add(trafficd);
					BigDecimal   b4   =   new   BigDecimal(datasss.get(i).getTabWaterLevel()*100);  
					double   waterleved   =   b4.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
					waterleve.add(waterleved);
						
						sytime.add(datasss.get(i).getStrTime());
						
					//}
				
				
			}
			for(int i=0;i<datasss.size();i++){
				BigDecimal   b1   =   new   BigDecimal(datasss.get(i).getRealph());  
				double   phd   =   b1.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();  
				ph.add(phd);
				
				
				BigDecimal   b2   =   new   BigDecimal(datasss.get(i).getRealconductivity()/1000);  
				double   conductivityd   =   b2.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();  
				conductivity.add(conductivityd);
				
			}
		for(int j=0;j<datasss.size();j++){
			
			BigDecimal   c2   =   new   BigDecimal(datasss.get(j).getRealTurbidity()==null?0.0:datasss.get(j).getRealTurbidity()/10);  
			double   Turbidityd   =   c2.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Turbidity.add(Turbidityd);
			BigDecimal   c3   =   new   BigDecimal(datasss.get(j).getRealDo()==null?0.0:datasss.get(j).getRealDo()/10);  
			double   Dod   =   c3.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Do.add(Dod);
			BigDecimal   c4   =   new   BigDecimal(datasss.get(j).getRealTemp()==null?0.0:datasss.get(j).getRealTemp());  
			double   Tempd   =   c4.setScale(0,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Temp.add(Tempd);
			
			BigDecimal   b2   =   new   BigDecimal(datasss.get(j).getRealcod()/10);  
			double   codd   =   b2.setScale(0,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			cod.add(codd);
			BigDecimal   b3   =   new   BigDecimal(datasss.get(j).getRealnh4()*100);  
			double   NH3Nd   =   b3.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			NH3N.add(NH3Nd);
			BigDecimal   b4   =   new   BigDecimal(datasss.get(j).getRealtoc()*10);  
			double   tocd   =   b4.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			toc.add(tocd);
			BigDecimal   b5   =   new   BigDecimal(datasss.get(j).getRealcr6()*100);  
			double   cr6d   =   b5.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			cr6.add(cr6d);
			BigDecimal   b6   =   new   BigDecimal(datasss.get(j).getRealbod());  
			double   bodd   =   b6.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			bod.add(bodd);
			BigDecimal   b7   =   new   BigDecimal(datasss.get(j).getRealmlss()/1000);  
			double   mlssd   =   b7.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			mlss.add(mlssd);
			BigDecimal   b8   =   new   BigDecimal(datasss.get(j).getRealcr()*1000);  
			double   crd  =   b8.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			cr.add(crd);
			BigDecimal   b9   =   new   BigDecimal(datasss.get(j).getRealni()*100);  
			double   nid  =   b9.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			ni.add(nid);
			BigDecimal   b10   =   new   BigDecimal(datasss.get(j).getRealcd()*1000);  
			double   cdd  =   b10.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			cd.add(cdd);
			BigDecimal   b11   =   new   BigDecimal(datasss.get(j).getReallead()*100);  
			double   leadd =   b11.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			lead.add(leadd);
			BigDecimal   b12   =   new   BigDecimal(datasss.get(j).getRealsilver());  
			double   silverd  =   b12.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			silver.add(silverd);
			BigDecimal   b13   =   new   BigDecimal(datasss.get(j).getRealhg()*10);  
			double   hgd =   b13.setScale(5,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			hg.add(hgd);
			BigDecimal   b14   =   new   BigDecimal(datasss.get(j).getRealphosphor()*100);  
			double   phosphord  =   b14.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			phosphor.add(phosphord);
			BigDecimal   b15   =   new   BigDecimal(datasss.get(j).getRealcu()*100);  
			double   cus  =   b15.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			cu.add(cus);
			BigDecimal   b16   =   new   BigDecimal(datasss.get(j).getRealzn()*100);  
			double   znd  =   b16.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			zn.add(znd);
			BigDecimal   b17   =   new   BigDecimal(datasss.get(j).getRealFlu()*1000);  
			double   flus  =   b17.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			flu.add(flus);
			
			
			sytime2.add(datasss.get(j).getStrTime());
		}
		
		
		result.setSytime2(sytime2);
		result.setZtraffic(ztraffic);//工业给水总流量
		result.setCurrentSpeed(currentSpeed);//流速
		result.setTraffic(traffic);//流量速率
		result.setSytime(sytime);//时间
		result.setWaterleve(waterleve);//水位
		result.setPh(ph);//ph
		result.setConductivity(conductivity);//电导率
		result.setCod(cod);//cod
		result.setNH3N(NH3N);//氨氮
		result.setCr6(cr6);//六价铬
		result.setToc(toc);//Toc
		result.setBod(bod);//bod
		result.setMlss(mlss);//固体悬浮物
		result.setCr(cr);//cr
		result.setNi(ni);//ni
		result.setCd(cd);//cd
		result.setLead(lead);
		result.setSilver(silver);
		result.setHg(hg);
		result.setPhosphor(phosphor);
		result.setCu(cu);
		result.setZn(zn);
		result.setTurbidity(Turbidity);
		result.setDoo(Do);
		result.setTemp(Temp);
		result.setFlu(flu);
		
		result.setData_name1(data_name1);
		result.init(ApiResultcode._1, "成功");
		
		return "@" + encodeJson(result);
			
		}else if(form==2){
			for(int i=0;i<datas.size();i++){
				
				BigDecimal   b1   =   new   BigDecimal(datas.get(i).getTabZtraffic());  
		        double   ztrafficd   =   b1.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();  
				ztraffic.add(ztrafficd);
				BigDecimal   b2   =   new   BigDecimal(datas.get(i).getTabCurrentSpeed());  
				double   currentSpeedd   =   b2.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
				currentSpeed.add(currentSpeedd);
				BigDecimal   b3   =   new   BigDecimal(datas.get(i).getTabTraffic());  
				double   trafficd   =   b3.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
				traffic.add(trafficd);
				BigDecimal   b4   =   new   BigDecimal(datas.get(i).getTabWaterLevel());  
				double   waterleved   =   b4.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
				waterleve.add(waterleved);
			
				
				
				sytime.add(datas.get(i).getStrTime());
			}
			
			result.setZtraffic(ztraffic);//工业给水总流量
			result.setCurrentSpeed(currentSpeed);//流速
			result.setTraffic(traffic);//流量速率
			result.setSytime(sytime);//时间
			//request.setAttribute("waterleve", waterleve);
			result.init(ApiResultcode._1, "成功");
			return "@" + encodeJson(result);
			
		}else if(form==3){
			for(int i=0;i<datas.size();i++){
				
				 BigDecimal   b1   =   new   BigDecimal(datas.get(i).getTabZtraffic());  
			        double   ztrafficd   =   b1.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();  
					ztraffic.add(ztrafficd);
					BigDecimal   b2   =   new   BigDecimal(datas.get(i).getTabCurrentSpeed());  
					double   currentSpeedd   =   b2.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
					currentSpeed.add(currentSpeedd);
					BigDecimal   b3   =   new   BigDecimal(datas.get(i).getTabTraffic());  
					double   trafficd   =   b3.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
					traffic.add(trafficd);
					BigDecimal   b4   =   new   BigDecimal(datas.get(i).getTabWaterLevel());  
					double   waterleved   =   b4.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
					waterleve.add(waterleved);
				
				
				
				sytime.add(datas.get(i).getStrTime());
			}
			
			result.setZtraffic(ztraffic);//工业给水总流量
			result.setCurrentSpeed(currentSpeed);//流速
			result.setTraffic(traffic);//流量速率
			result.setSytime(sytime);//时间
			//request.setAttribute("waterleve", waterleve);
			result.init(ApiResultcode._1, "成功");
			
			return "@" + encodeJson(result);
			
		}
		return null;
	}
	
	
/**
 * 汇总和系数
 */
	@Get("curveReportList2")
	@Post("curveReportList2")
	public String curveReportList2(ViewLineReport data, HttpServletRequest request, HttpServletResponse response) throws ParseException {
	
	MobileData<List<Object>> result = new MobileData<List<Object>>(ApiResultcode._0);
	Long rid =data.getRid();
	CompanyInfo com = new CompanyInfo();
	com.setCompany_id(rid);
	String sTime=data.getStartingTime();
	String eTime=data.getEndTime();
	Integer minates=data.getMinates();
	Integer type=data.getType();
	Integer form =data.getForm();
	String dateTypes=data.getDateTypes();
	String Time=data.getTimes();
	ViewCompanyconfig company=curveReportBiz.selectCompanyName2(com);
	String companyName=company.getCompanyName();
	BalanceComfig comfig=new BalanceComfig();
	comfig.setRid(rid);
	StringDataLongTime s=new StringDataLongTime();
	BalanceWater balance=new BalanceWater();
	balance.setRid(rid);
	if(sTime==null  & dateTypes==null){
		Calendar cal = Calendar.getInstance(); 
		cal.set(Calendar.HOUR_OF_DAY, 0); 
		cal.set(Calendar.SECOND, 0); 
		cal.set(Calendar.MINUTE, 0); 
		sTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
		cal.set(Calendar.HOUR_OF_DAY, 23); 
		cal.set(Calendar.SECOND, 59); 
		cal.set(Calendar.MINUTE, 59);
		eTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
		
		dateTypes=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
		//ViewdaliyReport.setMinates(5);
		
		if(type==1){
			cal.set(Calendar.HOUR_OF_DAY, 0); 
			cal.set(Calendar.SECOND, 0); 
			cal.set(Calendar.MINUTE, 0); 
			 
			sTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
			Long sTimeL=s.stringToLong(sTime,"yyyy-MM-dd HH:mm");
			data.setStartingTimeL(sTimeL/1000/60+480);
			cal.set(Calendar.HOUR_OF_DAY, 23); 
			cal.set(Calendar.SECOND, 59); 
			cal.set(Calendar.MINUTE, 59);
			eTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
			Long eTimeL=s.stringToLong(eTime+" 23:59","yyyy-MM-dd HH:mm");
			data.setEndTimeL(eTimeL/1000/60+480);
			dateTypes=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
		}
		if(type==3){
			
			cal.set(Calendar.DAY_OF_MONTH, 1); 
			String  firstDate = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
			 comfig.setqStTime(firstDate);
			 
			 dateTypes=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
			 data.setDateTypes(dateTypes);
			  balance.setDateTypes(dateTypes);
		}
		if(type==6){
			dateTypes=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
			if(dateTypes.toString().equals("2016")){
				Date  sTime1=company.getStratTime();	
				sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
				 comfig.setqStTime(sTime);
			}else{
				cal.set(Calendar.MONTH, 1); 
				cal.set(Calendar.DAY_OF_MONTH, 1); 
				String  firstDate = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
				 comfig.setqStTime(firstDate);
			}
			data.setDateTypes(dateTypes);
			  balance.setDateTypes(dateTypes);
		}
		if(type==5){
			
		Date  sTime1=company.getStratTime();
		sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
			 comfig.setqStTime(sTime);
				
			eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
			data.setStartingTime(sTime);
			data.setEndTime(eTime);
			
			balance.setStartingTime(sTime);
			  balance.setEndTime(eTime);
			request.setAttribute("eTime", eTime);
			request.setAttribute("sTime", sTime);
			
		}else if(type==11){
			data.setStartingTime(sTime);
			data.setEndTime(eTime);
		}
			
	}else{
		if(type==1){
			String start=dateTypes+" 00:00";
			String end=dateTypes+" 23:59";
			Long sTimeL=s.stringToLong(start,"yyyy-MM-dd HH:mm");
			data.setStartingTimeL(sTimeL/1000/60+480);
			Long eTimeL=s.stringToLong(end,"yyyy-MM-dd HH:mm");
			data.setEndTimeL(eTimeL/1000/60+480);
			data.setDateTypes(null);
			
		}
          if(type==3){
        	 String  dateType1=dateTypes+"-01";
			 comfig.setqStTime(dateType1);
			 balance.setDateTypes(dateTypes);
			 data.setDateTypes(dateTypes);
		}
          if(type==6){
				if(dateTypes.toString().equals("2016")){
					Date  sTime1=company.getStratTime();	
					sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
					 comfig.setqStTime(sTime);
				}else{
				String	dateType1=dateTypes+"-01-01";
	  	    comfig.setqStTime(dateType1);
				}
				data.setDateTypes(dateTypes);
				balance.setDateTypes(dateTypes);
			}
          if(type==5){
        	  comfig.setqStTime(sTime);  
        	  balance.setStartingTime(sTime);
			  balance.setEndTime(eTime);
          }
	}		
	
	String url=null;
	List<BalanceWater> datas=new ArrayList<BalanceWater>();
	
	if(type==1){
	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
		Calendar cd = Calendar.getInstance();   
        cd.setTime(sdf.parse(dateTypes));   
        cd.add(Calendar.DATE,   +1);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");   
		  Time=sdf1.format(cd.getTime());   
		data.setTimes(Time);
		
		List<ViewZtraffic>ztraffic_id=new ArrayList<ViewZtraffic>();
		List<ViewZtraffic>ztraffic_is=new ArrayList<ViewZtraffic>();
		List<ViewZtraffic>ztraffic_ls=new ArrayList<ViewZtraffic>();
		String viewName;
		for(int i=1 ;i<=3;i++){
			if(i==1){
				 viewName="sourcemidtabindustrialdrainage";
				 data.setViewName(viewName);
				 List<ViewZtraffic>ztraffics= curveReportBiz.selecthourztraffics(data);
				 ztraffic_id=ztraffics;
				}else if(i==2){
						 viewName="sourcemidtabindustrialsupply";
						 data.setViewName(viewName);
						 List<ViewZtraffic>ztraffics= curveReportBiz.selecthourztraffics(data);
						 ztraffic_is=ztraffics;
						}else if(i==3){
							 viewName="sourcemidtablivingsupply";
							 data.setViewName(viewName);
							 List<ViewZtraffic>ztraffics= curveReportBiz.selecthourztraffics(data);
							 ztraffic_ls=ztraffics;
							}
		}
		
		List<ViewZtraffic>ztraffic= curveReportBiz.selecthourztraffic(data);
		List<Object>supplyLiving=new ArrayList<Object>();//生活给水总流量
		List<Object>drainageIndustrial=new ArrayList<Object>();//排水
		List<Object>supplyIndustrial=new ArrayList<Object>();//工业给水总流量
		List<Object>strTime=new ArrayList<Object>();//系统时间
		
		if(supplyLiving.size()>0){
			
			
			for(int i=0;i<ztraffic_id.size()-1;i++){
				supplyLiving.add(fixed(ztraffic_ls.get(i+1).getZtraffic()-ztraffic_ls.get(i).getZtraffic(),1));
				supplyIndustrial.add(fixed(ztraffic_is.get(i+1).getZtraffic()-ztraffic_is.get(i).getZtraffic(),1));
				drainageIndustrial.add(fixed(ztraffic_id.get(i+1).getZtraffic()-ztraffic_id.get(i).getZtraffic(),1));
				Date ss= ztraffic_id.get(i).getStrTime();
				 int hour=ss.getHours();
				strTime.add(hour+":00");
			}
			}else{
				for(int i=0;i<ztraffic_id.size()-1;i++){
					supplyLiving.add(0.0);
					supplyIndustrial.add(fixed(ztraffic_is.get(i+1).getZtraffic()-ztraffic_is.get(i).getZtraffic(),1));
					drainageIndustrial.add(fixed(ztraffic_id.get(i+1).getZtraffic()-ztraffic_id.get(i).getZtraffic(),1));
					Date ss= ztraffic_id.get(i).getStrTime();
					 int hour=ss.getHours();
					strTime.add(hour+":00");
				}
			}
		
		result.setSupplyLiving(supplyLiving);
		result.setSupplyIndustrial(supplyIndustrial);
		result.setDrainageIndustrial(drainageIndustrial);
		result.setSytime(strTime);
		result.init(ApiResultcode._1, "成功");
		
		return "@" + encodeJson(result);
	}else{
         int i=reportFormBiz.insertBalanceTime(comfig);
         if(form==4){
        	 datas=balanceBizs.BalanceList(balance);
         }else if(form==5){
        	 datas=balanceBizs.BalanceList(balance);
         }
         
		
	}
	
	List<Object>ztraffic=new ArrayList<Object>();//工业给水总流量
	List<Object>industrialdrainage=new ArrayList<Object>();//工业给水总流量
	List<Object>livingsupply=new ArrayList<Object>();//工业排水总流量
	List<Object>industrialsupply=new ArrayList<Object>();//生活给水总流量
	List<Object>currentSpeed=new ArrayList<Object>();//流速
	List<Object>traffic=new ArrayList<Object>();//流量速率
	List<Object>waterleve=new ArrayList<Object>();//水位
	List<Object>ph=new ArrayList<Object>();//ph
	List<Object>sytime=new ArrayList<Object>();//系统时间
	List<Object>cod=new ArrayList<Object>();//cod
	List<Object>NH3N=new ArrayList<Object>();//氨氮
	
	
	List<Object>LossLimit=new ArrayList<Object>();//限值
	List<Object>unknown=new ArrayList<Object>();//不明用水
	List<Object>wastage=new ArrayList<Object>();//耗损
	//循环将前十条数据的单个数据取出来插入对应的集合
	

	if(form==4){
		for(int i=0;i<datas.size();i++){
			industrialdrainage.add(fixed(datas.get(i).getIndustrialdrainage(),1));
			livingsupply.add(fixed(datas.get(i).getLivingsupply(),1));
			industrialsupply.add(fixed(datas.get(i).getIndustrialsupply(),1));
			LossLimit.add(fixed(datas.get(i).getLosslimit(),1));
			wastage.add(fixed(datas.get(i).getWastage(),1));
			unknown.add(fixed(datas.get(i).getUnknown(),1));
			if(type==3||type==6||type==5){
				String[] split = datas.get(i).getStrTime().toString().split("\\s+");
				sytime.add(split[0]);

			}else{
				sytime.add(datas.get(i).getStrTime());
			}
			
		}
		result.setIndustrialdrainage(industrialdrainage);
		result.setLivingsupply(livingsupply);
		result.setIndustrialsupply(industrialsupply);
		result.setLossLimit(LossLimit);
		result.setWastage(wastage);
		result.setUnknown(unknown);
		result.setSytime(sytime);
		
		result.init(ApiResultcode._1, "成功");	
		return "@" + encodeJson(result);
		
	}if(form==5){
		for(int i=0;i<datas.size();i++){
			if(rid.toString().equals("75501330004")){
				if(datas.get(i).getIndustrialsupply()!=0.0){
				industrialdrainage.add(fixed((datas.get(i).getIdztraffic()/datas.get(i).getIsztraffic()),2));
				livingsupply.add(fixed((datas.get(i).getLsztraffic()/datas.get(i).getIsztraffic()),2));
				industrialsupply.add(fixed((datas.get(i).getIsztraffic()/datas.get(i).getIsztraffic()),2));
				LossLimit.add(fixed((datas.get(i).getTotalLossLimit()/datas.get(i).getIsztraffic()),2));
				wastage.add(fixed((datas.get(i).getTotalwastage()/datas.get(i).getIsztraffic()),2));
				unknown.add(fixed((datas.get(i).getTotalunknow()/datas.get(i).getIsztraffic()),2));
				sytime.add(datas.get(i).getStrTime());
				}else{
					industrialdrainage.add(0.0);
					livingsupply.add(0.00);
					industrialsupply.add(0.0);
					LossLimit.add(0.0);
					wastage.add(0.0);
					unknown.add(0.0);
					sytime.add(datas.get(i).getStrTime());	
				}
			}else{
				if(datas.get(i).getIndustrialsupply()!=0.0){
			industrialdrainage.add(fixed((datas.get(i).getIdztraffic()/(datas.get(i).getIsztraffic()+datas.get(i).getLsztraffic())),2));
			livingsupply.add(fixed((datas.get(i).getLsztraffic()/(datas.get(i).getIsztraffic()+datas.get(i).getLsztraffic())),2));
			industrialsupply.add(fixed((datas.get(i).getIsztraffic()/(datas.get(i).getIsztraffic()+datas.get(i).getLsztraffic())),2));
			LossLimit.add(fixed((datas.get(i).getTotalLossLimit()/(datas.get(i).getIsztraffic()+datas.get(i).getLsztraffic())),2));
			wastage.add(fixed((datas.get(i).getTotalwastage()/(datas.get(i).getIsztraffic()+datas.get(i).getLsztraffic())),2));
			unknown.add(fixed((datas.get(i).getTotalunknow()/(datas.get(i).getIsztraffic()+datas.get(i).getLsztraffic())),2));
			sytime.add(datas.get(i).getStrTime());
				}else{
					industrialdrainage.add(0.0);
					livingsupply.add(0.00);
					industrialsupply.add(0.0);
					LossLimit.add(0.0);
					wastage.add(0.0);
					unknown.add(0.0);
					sytime.add(datas.get(i).getStrTime());	
				}
			}
		}
		
		
		result.setIndustrialdrainage(industrialdrainage);
		result.setLivingsupply(livingsupply);
		result.setIndustrialsupply(industrialsupply);
		result.setLossLimit(LossLimit);
		result.setWastage(wastage);
		result.setUnknown(unknown);
		result.setSytime(sytime);
		result.init(ApiResultcode._1, "成功");
		return "@" + encodeJson(result);
	}
	
		return url;
}

	
//污染物
@Get("curveReportList3")
@Post("curveReportList3")
public String curveReportList3(Pollutant data, HttpServletRequest request, HttpServletResponse response) {
	
	MobileData<List<Object>> result = new MobileData<List<Object>>(ApiResultcode._0);
	Long rid =data.getRid();
	CompanyInfo com = new CompanyInfo();
	com.setCompany_id(rid);
	String sTime=data.getStartingTime();
	String eTime=data.getEndTime();
	Integer minates=data.getMinates();
	Integer type=data.getType();
	Integer form =data.getForm();
	String dateTypes=data.getDateTypes();
	
	
	
	if(sTime==null  & dateTypes==null){
		int offset = SystemContext.getOffset();
		
		Calendar cal = Calendar.getInstance(); 
		if(form==6){
			Calendar cal2 = Calendar.getInstance(); 
			cal2.add(Calendar.DATE,   -7);
			sTime = (new SimpleDateFormat("yyyy-MM-dd")).format(cal2.getTime()); 
			Calendar cal3 = Calendar.getInstance(); 
			eTime = (new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime()); 
		
		}else if(form==7){
			cal.set(Calendar.HOUR_OF_DAY, 0); 
			cal.set(Calendar.SECOND, 0); 
			cal.set(Calendar.MINUTE, 0); 
			
			sTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
			cal.set(Calendar.HOUR_OF_DAY, 23); 
			cal.set(Calendar.SECOND, 59); 
			cal.set(Calendar.MINUTE, 59);
			eTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
		
		}
		if(type==1){
			dateTypes=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
			data.setDateTypes(dateTypes);
		}else if(type==5){
			data.setStartingTime(sTime);
			data.setEndTime(eTime);
		}else if(type==3){
			dateTypes=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
			data.setDateTypes(dateTypes);
		}else if(type==6){
			dateTypes=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
			data.setDateTypes(dateTypes);
		}
		
	}
	String url=null;
	
	if(type==1){
		String viewName="totaltabpollutant";
		data.setViewName(viewName);
	}else if(type==2){
		String viewName="totaltabpollutant";
		data.setViewName(viewName);
	}else if(type==3){
		String viewName="totaltabpollutant";
		data.setViewName(viewName);
		data.setMinates(30);
	}else if(type==6){
		String viewName="totaltabpollutant";
		data.setViewName(viewName);
		data.setMinates(60);
	}else if(type==5){
		String viewName="totaltabpollutant";
		data.setViewName(viewName);
	}
	
	
	CompanyInfo company=curveReportBiz.selectCompanyName(com);
	String companyName=company.getCompany_name();
	List<Pollutant> data_name=curveReportBiz.selectByPollutant_Pollname(data);
	List<Pollutant>datas=new ArrayList<Pollutant>();
	if(form==6){
		
	
	if(type==1){
		datas=curveReportBiz.selecthourPollutant(data);
	}else if(type==3){
		datas=curveReportBiz.selecthourPollutant_day(data);
	}else if(type==6){
		datas=curveReportBiz.selecthourPollutant_month(data);
	}else{
	datas=curveReportBiz.selecthourPollutant_day(data);
	}
	}else if(form==7){
		
		datas=curveReportBiz.selectByPollutant(data);
	}
	
	List<Object> data_name1=new ArrayList<Object>();
	
	
	for(int i=0;i<data_name.size();i++){
		/*if(data_name.get(i).getPollType().equals("电导率")){
			data_name.remove(i);
		}
		if(data_name.get(i).getPollType().equals("PH")){
			data_name.remove(i);
		}*/
		
		data_name1.add(i,data_name.get(i).getPollType()+"(kg)");
	}
	
	List<Object>strTime=new ArrayList<Object>();//系统时间
	
	List<Object>cr6=new ArrayList<Object>();//生活给水总流量
	
	List<Object>cod=new ArrayList<Object>();//cod
	
	List<Object>nh4=new ArrayList<Object>();//氨氮
	
	List<Object>toc=new ArrayList<Object>();//cod
	List<Object>bod=new ArrayList<Object>();//氨氮
    List<Object>mlss=new ArrayList<Object>();//生活给水总流量
	
	List<Object>cr=new ArrayList<Object>();//cod
	List<Object>ni=new ArrayList<Object>();//氨氮
	List<Object>cd=new ArrayList<Object>();//cod
	List<Object>lead=new ArrayList<Object>();//氨氮
    List<Object>silver=new ArrayList<Object>();//生活给水总流量
	
	List<Object>hg=new ArrayList<Object>();//cod
	List<Object>phosphor=new ArrayList<Object>();//氨氮
	
	List<Object>cu=new ArrayList<Object>();//cod
	List<Object>zn=new ArrayList<Object>();//氨氮
	List<Object>flu=new ArrayList<Object>();//氟化物
	
	//循环将前十条数据的单个数据取出来插入对应的集合
		if(data_name.size()!=0){
			
		
		for(int i=0;i<datas.size();i++){
			cod.add(fixed(datas.get(i).getCod(),0));
			nh4.add(fixed(datas.get(i).getNh4(),3));
			cr6.add(fixed(datas.get(i).getCr6(),4));
			
			toc.add(fixed(datas.get(i).getToc(),2));
			bod.add(fixed(datas.get(i).getBod(),2));
			mlss.add(fixed(datas.get(i).getMlss(),1));
			
			cr.add(fixed(datas.get(i).getCr(),4));
			ni.add(fixed(datas.get(i).getNi(),3));
			cd.add(fixed(datas.get(i).getCd(),2));
			
			lead.add(fixed(datas.get(i).getCd(),2));
			silver.add(fixed(datas.get(i).getSilver(),2));
			hg.add(fixed(datas.get(i).getSilver(),2));
			
			phosphor.add(fixed(datas.get(i).getPhosphor(),2));
			cu.add(fixed(datas.get(i).getCu(),3));
			zn.add(fixed(datas.get(i).getZn(),3));
			flu.add(fixed(datas.get(i).getFlu(),3));
			
			if(form==6){
				if(type==1){
					Date s= datas.get(i).getStrTime();
					 int hour=s.getHours();
					strTime.add(hour+":00");
				}else{
					String[] split = datas.get(i).getStrTime().toString().split("\\s+");
					strTime.add(split[0]);	
				}

			}else{
				strTime.add(datas.get(i).getStrTime());
			}
		}
		}
	
		result.setSytime(strTime);//时间
		
		result.setNh4(nh4);
		result.setCod(cod);//cod
		result.setCr6(cr6);//六价铬
		result.setToc(toc);//Toc
		result.setBod(bod);//bod
		result.setMlss(mlss);//固体悬浮物
		result.setCr(cr);//cr
		result.setNi(ni);//ni
		result.setCd(cd);//cd
		result.setLead(lead);
		result.setSilver(silver);
		result.setHg(hg);
		result.setPhosphor(phosphor);
		result.setCu(cu);
		result.setZn(zn);
		result.setFlu(flu);
		result.setData_name1(data_name1);
		result.init(ApiResultcode._1, "成功");
		
		return "@" + encodeJson(result);
		
	
}


}
