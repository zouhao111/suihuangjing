package com.erich.saleticket.controllers.admin.tdht;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erich.easyframe.util.SystemContext;
import com.erich.saleticket.biz.tdht.CurveReportBiz;
import com.erich.saleticket.biz.tdht.ReportFormBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread1;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread2;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread3;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread4;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread5;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread6;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread7;
import com.erich.saleticket.controllers.admin.tdht.CurveReportController.MyThread8;
import com.erich.saleticket.model.tdht.CompanyInfo;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.Pollutant_Water;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewData;
import com.erich.saleticket.model.tdht.ViewLineReport;

public class CurveWaterController extends BaseController  {
	
	
	
	public  List<ViewLineReport> aaa;
	public  List<Pollutant_Water> bbb;
	public  List<ViewLineReport> ccc;
	public  List<Pollutant_Water> ddd;
	public  List<ViewLineReport> eee;
	public  List<Pollutant_Water> fff;
	public  List<ViewLineReport> ggg;
	public  List<Pollutant_Water> hhh;
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
	    	aaa =curveReportBiz.selectByCriteria_water(data2);
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
	    	bbb =curveReportBiz.selectByCriteria_waterph(data2);
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
	    	ccc =curveReportBiz.selectByCriteria_water(data2);
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
	    	ddd =curveReportBiz.selectByCriteria_waterph(data2);
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
	    	eee =curveReportBiz.selectByCriteria_water(data2);
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
	    	fff =curveReportBiz.selectByCriteria_waterph(data2);
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
	    	ggg =curveReportBiz.selectByCriteria_water(data2);
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
	    	hhh =curveReportBiz.selectByCriteria_waterph(data2);
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程8结束时间");// new Date()为获取当前系统时间
	    }

	}
	
	@Resource
	private CurveReportBiz curveReportBiz;
	@Resource
	private  ReportFormBiz reportFormBiz;
	
	
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
	
	
	/**
	 * 永艺发曲线报表查询列表
	 * @throws ParseException 
	 */
	/*ViewLineReport data1;
	 List<ViewLineReport> datas1=new ArrayList<ViewLineReport>();
*/
	@SuppressWarnings("unchecked")
	public String curveReportList(ViewLineReport data, HttpServletRequest request, HttpServletResponse response) throws ParseException, ExecutionException, InterruptedException  {
		//data1=data;
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
		Pollutant data2=new Pollutant();
		data2.setRid(rid);
		String url=null;
		List<ViewLineReport> datas=new ArrayList<ViewLineReport>();
		List<Pollutant_Water> datasss=new ArrayList<Pollutant_Water>();
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
				
				sTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
				eTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal2.getTime()); 
				
				
				
				
				List<String>times=Time_sub(sTime,eTime,type);
					
				
				if(times.size()==4){
					data_1.setStartingTime(times.get(0));
					data_1.setEndTime(times.get(1));
					data_1.setRid(rid);
					
					
					data_2.setStartingTime(times.get(2));
					data_2.setEndTime(times.get(3));
					data_2.setRid(rid);
					datasize=2;
				}else{
				data_1.setStartingTime(times.get(0));
				data_1.setEndTime(times.get(1));
				data_1.setRid(rid);
				
				
				data_2.setStartingTime(times.get(2));
				data_2.setEndTime(times.get(3));
				data_2.setRid(rid);
				
				data_3.setStartingTime(times.get(4));
				data_3.setEndTime(times.get(5));
				data_3.setRid(rid);
				
				
				data_4.setStartingTime(times.get(6));
				data_4.setEndTime(times.get(7));
				data_4.setRid(rid);
				datasize=4;
				}
				dateTypes=null;
				data.setDateTypes(dateTypes);
				sTime = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
				
			}
			if(type==5){
			sTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
			eTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal2.getTime()); 
			
		List<String>times=Time_sub(sTime,eTime,type);
			if(times.size()==4){
				data_1.setStartingTime(times.get(0));
				data_1.setEndTime(times.get(1));
				data_1.setMinates(5);
				data_1.setRid(rid);
				
				
				data_2.setStartingTime(times.get(2));
				data_2.setEndTime(times.get(3));
				data_2.setMinates(5);
				data_2.setRid(rid);
				datasize=2;
			}else{
			data_1.setStartingTime(times.get(0));
			data_1.setEndTime(times.get(1));
			data_1.setMinates(5);
			data_1.setRid(rid);
			
			
			data_2.setStartingTime(times.get(2));
			data_2.setEndTime(times.get(3));
			data_2.setMinates(5);
			data_2.setRid(rid);
			
			data_3.setStartingTime(times.get(4));
			data_3.setEndTime(times.get(5));
			data_3.setMinates(5);
			data_3.setRid(rid);
			
			
			data_4.setStartingTime(times.get(6));
			data_4.setEndTime(times.get(7));
			data_4.setMinates(5);
			data_4.setRid(rid);
			datasize=4;
			}
			}
			if(type==3){
				
				sTime=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
				Calendar cal3 = Calendar.getInstance(); 
				 
				eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
				String sTime1=sTime+"-01";
				
				List<String>times=Time_sub(sTime1,eTime,type);
				if(times.size()==4){
					data_1.setStartingTime(times.get(0));
					data_1.setEndTime(times.get(1));
					data_1.setMinates(30);
					data_1.setRid(rid);
					
					
					data_2.setStartingTime(times.get(2));
					data_2.setEndTime(times.get(3));
					data_2.setMinates(30);
					data_2.setRid(rid);
					datasize=2;
				}else{
				data_1.setStartingTime(times.get(0));
				data_1.setEndTime(times.get(1));
				data_1.setMinates(30);
				data_1.setRid(rid);
				
				
				data_2.setStartingTime(times.get(2));
				data_2.setEndTime(times.get(3));
				data_2.setMinates(30);
				data_2.setRid(rid);
				
				data_3.setStartingTime(times.get(4));
				data_3.setEndTime(times.get(5));
				data_3.setMinates(30);
				data_3.setRid(rid);
				
				
				data_4.setStartingTime(times.get(6));
				data_4.setEndTime(times.get(7));
				data_4.setMinates(30);
				data_4.setRid(rid);
				datasize=4;
				}
				
			}
			if(type==6){
				sTime=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
				Calendar cal3 = Calendar.getInstance(); 
				eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
				String sTime1=sTime+"-01-01";
				String zTime=(new SimpleDateFormat("yyyy-MM-dd")).format(zeroTime);
				List<String>times=new ArrayList<String>();
				if (zTime.compareTo(sTime)>0) {
					times=Time_sub(zTime,eTime,type);
					} else {
					times=Time_sub(sTime1,eTime,type);
					}
				if(times.size()==4){
					data_1.setStartingTime(times.get(0));
					data_1.setEndTime(times.get(1));
					data_1.setMinates(60);
					data_1.setRid(rid);
					
					
					data_2.setStartingTime(times.get(2));
					data_2.setEndTime(times.get(3));
					data_2.setMinates(60);
					data_2.setRid(rid);
					datasize=2;
				}else{
				data_1.setStartingTime(times.get(0));
				data_1.setEndTime(times.get(1));
				data_1.setMinates(60);
				data_1.setRid(rid);
				
				
				data_2.setStartingTime(times.get(2));
				data_2.setEndTime(times.get(3));
				data_2.setMinates(60);
				data_2.setRid(rid);
				
				data_3.setStartingTime(times.get(4));
				data_3.setEndTime(times.get(5));
				data_3.setMinates(60);
				data_3.setRid(rid);
				
				
				data_4.setStartingTime(times.get(6));
				data_4.setEndTime(times.get(7));
				data_4.setMinates(60);
				data_4.setRid(rid);
				datasize=4;
				}
				
			}
			/*request.setAttribute("type", type);
			
			if(form==1){
				return "report/curveReportList";
			}else if(form==2){
				return "report/curveReportList2";
			}else if(form==3){
				return "report/curveReportList3";
			}else if(form==4){
				return "report/curveReportList4";
			}*/
			
		
		/**
		 * 曲线添加
		 */
		
		
			
			String viewName="min_report";
			data.setViewName(viewName);
			Thread	thread1 =null;Thread	thread2 =null;Thread	thread3 =null;Thread	thread4 =null;
			Thread	thread5 =null;Thread	thread6 =null;Thread	thread7 =null;Thread	thread8 =null;
			if(datasize==2){
				thread1 = new MyThread1(data_1);
	             thread1.start();  
	             thread2 = new MyThread2(data_1);
		        thread2.start(); 
		           thread3 = new MyThread3(data_2);
		        thread3.start();  
		         thread4 = new MyThread4(data_2);
			    thread4.start();  
			}else{
				 thread1 = new MyThread1(data_1);
	             thread1.start();  
	              thread2 = new MyThread2(data_1);
		        thread2.start(); 
		         thread3 = new MyThread3(data_2);
		        thread3.start();  
		         thread4 = new MyThread4(data_2);
			    thread4.start();  
			      thread5 = new MyThread5(data_3);
	             thread5.start();  
	              thread6 = new MyThread6(data_3);
		        thread6.start(); 
		         thread7 = new MyThread7(data_4);
		        thread7.start();  
		           thread8 = new MyThread8(data_4);
			    thread8.start();  
			}
		        while(true)
		        {
				    if(datasize==2){
					if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive())
				    {
				    	if(aaa.size()!=0){
				    		datas=aaa;
				    	}
				    	if(ccc.size()!=0){
				    		datas.addAll(ccc);
				    	}
				    	
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
						if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive()&&!thread5.isAlive()&&!thread6.isAlive()&&!thread7.isAlive()&&!thread8.isAlive())
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
			/*datas=curveReportBiz.selectByCriteria(data);
			//	List<Pollutant> datass=curveReportBiz.selectByCriteria_poll(data);
		      datasss=curveReportBiz.selectByCriteria_ph(data);*/
		
		
		
        
		}else{
			
			
			if(type==1){
				List<String>times;
				String viewName="min_report";
				data.setViewName(viewName);
				sTime=dateTypes;
				String sTime1=dateTypes+" 00:00:00";
				eTime=dateTypes+" 23:59:59";
				  Calendar cal = Calendar.getInstance(); 
				String   eTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime());
				if (eTime1.compareTo(eTime)>0) {
					times=Time_sub(sTime1,eTime,type);
					} else {
					times=Time_sub(sTime1,eTime1,type);
					}
				
				if(times.size()==4){
					data_1.setStartingTime(times.get(0));
					data_1.setEndTime(times.get(1));
					data_1.setRid(rid);
					
					
					data_2.setStartingTime(times.get(2));
					data_2.setEndTime(times.get(3));
					data_2.setRid(rid);
					datasize=2;
				}else{
				data_1.setStartingTime(times.get(0));
				data_1.setEndTime(times.get(1));
				data_1.setRid(rid);
				
				
				data_2.setStartingTime(times.get(2));
				data_2.setEndTime(times.get(3));
				data_2.setRid(rid);
				
				data_3.setStartingTime(times.get(4));
				data_3.setEndTime(times.get(5));
				data_3.setRid(rid);
				
				
				data_4.setStartingTime(times.get(6));
				data_4.setEndTime(times.get(7));
				data_4.setRid(rid);
				datasize=4;
				}
				
				
				
				
				
				dateTypes=null;
				data.setDateTypes(dateTypes);
			}else if(type==2){
				String viewName="min_report";
				data.setViewName(viewName);
			}else if(type==3){
				String viewName="min_report";
				data.setViewName(viewName);
				sTime=dateTypes; 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				String sTime1=sTime+"-01";
	            Calendar cd = Calendar.getInstance();   
	            cd.setTime(sdf.parse(sTime1));   
	            cd.add(Calendar.MONTH, 1);//增加一天 
	            cd.add(Calendar.DAY_OF_MONTH, -1);//增加一天 
	            eTime=sdf.format(cd.getTime());  
              
				
				List<String>times=Time_sub(sTime1,eTime,type);
				if(times.size()==4){
					data_1.setStartingTime(times.get(0));
					data_1.setEndTime(times.get(1));
					data_1.setMinates(30);
					data_1.setRid(rid);
					
					
					data_2.setStartingTime(times.get(2));
					data_2.setEndTime(times.get(3));
					data_2.setMinates(30);
					data_2.setRid(rid);
					datasize=2;
				}else{
				data_1.setStartingTime(times.get(0));
				data_1.setEndTime(times.get(1));
				data_1.setMinates(30);
				data_1.setRid(rid);
				
				
				data_2.setStartingTime(times.get(2));
				data_2.setEndTime(times.get(3));
				data_2.setMinates(30);
				data_2.setRid(rid);
				
				data_3.setStartingTime(times.get(4));
				data_3.setEndTime(times.get(5));
				data_3.setMinates(30);
				data_3.setRid(rid);
				
				
				data_4.setStartingTime(times.get(6));
				data_4.setEndTime(times.get(7));
				data_4.setMinates(30);
				data_4.setRid(rid);
				datasize=4;
				}   
				
				dateTypes=null;
				data.setDateTypes(dateTypes);
			}else if(type==6){
				String viewName="min_report";
				data.setViewName(viewName);
				sTime=dateTypes; 
				Calendar cal3 = Calendar.getInstance(); 
				eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
				String eTime1=dateTypes+"-12-31";
				String sTime1=sTime+"-01-01";
				String zTime=(new SimpleDateFormat("yyyy-MM-dd")).format(zeroTime);
				List<String>times=new ArrayList<String>();
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
					data_1.setStartingTime(times.get(0));
					data_1.setEndTime(times.get(1));
					data_1.setMinates(60);
					data_1.setRid(rid);
					
					
					data_2.setStartingTime(times.get(2));
					data_2.setEndTime(times.get(3));
					data_2.setMinates(60);
					data_2.setRid(rid);
					datasize=2;
				}else{
				data_1.setStartingTime(times.get(0));
				data_1.setEndTime(times.get(1));
				data_1.setMinates(60);
				data_1.setRid(rid);
				
				
				data_2.setStartingTime(times.get(2));
				data_2.setEndTime(times.get(3));
				data_2.setMinates(60);
				data_2.setRid(rid);
				
				data_3.setStartingTime(times.get(4));
				data_3.setEndTime(times.get(5));
				data_3.setMinates(60);
				data_3.setRid(rid);
				
				
				data_4.setStartingTime(times.get(6));
				data_4.setEndTime(times.get(7));
				data_4.setMinates(60);
				data_4.setRid(rid);
				datasize=4;
				}
				dateTypes=null;
				data.setDateTypes(dateTypes);
			}else if(type==5){
				String viewName="min_report";
				data.setViewName(viewName);
				List<String>times=Time_sub(sTime,eTime,type);
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
					if(t>7&&t<30){
						minates=30;
						data_1.setMinates(30);
						data_2.setMinates(30);
					}else if(t>30){
						minates=60;
						data_1.setMinates(60);
						data_2.setMinates(60);
					}else{
						minates=5;
						data_1.setMinates(5);
						data_2.setMinates(5);
					}
					data_1.setStartingTime(times.get(0));
					data_1.setEndTime(times.get(1));
					data_1.setRid(rid);
					
					
					data_2.setStartingTime(times.get(2));
					data_2.setEndTime(times.get(3));
					
					data_2.setRid(rid);
					datasize=2;
				}else{
					if(t>7&&t<30){
						minates=30;
						data_1.setMinates(30);
						data_2.setMinates(30);
						data_3.setMinates(30);
						data_4.setMinates(30);
					}else if(t>30){
						minates=60;
						data_1.setMinates(60);
						data_2.setMinates(60);
						data_3.setMinates(60);
						data_4.setMinates(60);
					}else{
						minates=5;
						data_1.setMinates(5);
						data_2.setMinates(5);
						data_3.setMinates(5);
						data_4.setMinates(5);
					}
				data_1.setStartingTime(times.get(0));
				data_1.setEndTime(times.get(1));
				data_1.setRid(rid);
				
				
				data_2.setStartingTime(times.get(2));
				data_2.setEndTime(times.get(3));
				data_2.setRid(rid);
				
				data_3.setStartingTime(times.get(4));
				data_3.setEndTime(times.get(5));
				data_3.setRid(rid);
				
				
				data_4.setStartingTime(times.get(6));
				data_4.setEndTime(times.get(7));
				data_4.setRid(rid);
				datasize=4;
				}
				}
			Thread	thread1 =null;Thread	thread2 =null;Thread	thread3 =null;Thread	thread4 =null;
			Thread	thread5 =null;Thread	thread6 =null;Thread	thread7 =null;Thread	thread8 =null;
			if(datasize==2){
				
				thread1 = new MyThread1(data_1);
	             thread1.start();  
	             thread2 = new MyThread2(data_1);
		        thread2.start(); 
		           thread3 = new MyThread3(data_2);
		        thread3.start();  
		         thread4 = new MyThread4(data_2);
			    thread4.start();  
			}else{
				 thread1 = new MyThread1(data_1);
	             thread1.start();  
	              thread2 = new MyThread2(data_1);
		        thread2.start(); 
		         thread3 = new MyThread3(data_2);
		        thread3.start();  
		         thread4 = new MyThread4(data_2);
			    thread4.start();  
			      thread5 = new MyThread5(data_3);
	             thread5.start();  
	              thread6 = new MyThread6(data_3);
		        thread6.start(); 
		         thread7 = new MyThread7(data_4);
		        thread7.start();  
		           thread8 = new MyThread8(data_4);
			    thread8.start();  
			}  
		    
		        while(true)
		        {
		        	 if(datasize==2){
							if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive())
						    {
						    	if(aaa.size()!=0){
						    		datas=aaa;
						    	}
						    	if(ccc.size()!=0){
						    		datas.addAll(ccc);
						    	}
						    	
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
								if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive()&&!thread5.isAlive()&&!thread6.isAlive()&&!thread7.isAlive()&&!thread8.isAlive())
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
			/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		 datas=curveReportBiz.selectByCriteria(data);
			 SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		      System.out.println(dfs.format(new Date())+"     1111111111111111111");// new Date()为获取当前系统时间
			//	List<Pollutant> datass=curveReportBiz.selectByCriteria_poll(data);
		      datasss=curveReportBiz.selectByCriteria_ph(data);
		      SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		      System.out.println(df2.format(new Date())+"     222222222222222222");// new Date()为获取当前系统时间*/	
		}
		//List<ViewLineReport> datas=curveReportBiz.selectByCriteria(data);
	//	List<Pollutant> datass=curveReportBiz.selectByCriteria_poll(data);
		//List<Pollutant> datasss=curveReportBiz.selectByCriteria_ph(data);
		
		
		
		 
		List<Pollutant> data_name=curveReportBiz.selectByPollutant_name(data2);
		 
		List<String > data_name1=new ArrayList<String>(40);
		data_name1.add("'"+"水位(m)"+"'");
		data_name1.add("'"+"流量速率(m³/s)"+"'");
		data_name1.add("'"+"流速(m/s)"+"'");
		
		
		for(int i=0;i<data_name.size();i++){
			int a=i+3;
			data_name1.add(a,"'"+data_name.get(i).getPollType()+"(mg/l)'");
		}
		
		
		
		
		
		List<Double>ztraffic=new ArrayList<Double>();//工业给水总流量
		List<Double>ztrafficIS=new ArrayList<Double>();//工业给水总流量
		List<Double>ztrafficID=new ArrayList<Double>();//工业排水总流量
		List<Double>ztrafficDS=new ArrayList<Double>();//生活给水总流量
		List<Double>currentSpeed=new ArrayList<Double>();//流速
		List<Double>traffic=new ArrayList<Double>();//流量速率
		List<Double>waterleve=new ArrayList<Double>();//水位
		List<Double>ph=new ArrayList<Double>();//ph
		List<Double>conductivity=new ArrayList<Double>();//电导率
		List<String>sytime=new ArrayList<String>();//系统时间
		List<Double>cod=new ArrayList<Double>();//cod
		List<Double>NH3N=new ArrayList<Double>();//氨氮
		List<Double>cr6=new ArrayList<Double>();//六价铬
		List<String>sytime2=new ArrayList<String>();//系统时间
		
		
		List<Double>Do=new ArrayList<Double>();//溶解氧
		List<Double>Turbidity=new ArrayList<Double>();//浊度
	    List<Double>TN=new ArrayList<Double>();//总氮
		
		List<Double>TP=new ArrayList<Double>();//总磷
		List<Double>NO3=new ArrayList<Double>();//硝酸盐氮
		List<Double>An=new ArrayList<Double>();//阴离子表面活性剂
		List<Double>Phe=new ArrayList<Double>();//挥发酚
	    List<Double>CN=new ArrayList<Double>();//氰化物
		
		List<Double>Pb=new ArrayList<Double>();//铅
		List<Double>Cd=new ArrayList<Double>();//镉
		
		List<Double>Cu=new ArrayList<Double>();//铜
		List<Double>Hg=new ArrayList<Double>();//汞
		
		List<Double>As=new ArrayList<Double>();//砷
		List<Double>Fe=new ArrayList<Double>();//铁
		
		List<Double>Mn=new ArrayList<Double>();//锰
		List<Double>Ni=new ArrayList<Double>();//镍

		List<Double>F=new ArrayList<Double>();//氟化物
		List<Double>S=new ArrayList<Double>();//硫化物
		
		List<Double>Poison=new ArrayList<Double>();//水质综合毒性
		List<Double>OC=new ArrayList<Double>();//有机物水质
		List<Double>Zn=new ArrayList<Double>();//锌
		//循环将前十条数据的单个数据取出来插入对应的集合
		if(form==1){
			for(int i=0;i<datas.size();i++){
				
					/*if(datas.get(i).getStrTime().toString().equals(datass.get(j).getStrTime().toString())){*/
				     
						BigDecimal   b2   =   new   BigDecimal(datas.get(i).getTabCurrentSpeedID1());  
						double   currentSpeedd   =   b2.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
						currentSpeed.add(currentSpeedd);
						BigDecimal   b3   =   new   BigDecimal(datas.get(i).getTabTrafficID1());  
						double   trafficd   =   b3.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
						traffic.add(trafficd);
						BigDecimal   b4   =   new   BigDecimal(datas.get(i).getTabWaterLevelID1());  
						double   waterleved   =   b4.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
						waterleve.add(waterleved);
						
						sytime.add("'"+ datas.get(i).getStrTime()+"'");
						
					//}
				
				
			}
			for(int i=0;i<datasss.size();i++){
				BigDecimal   b1   =   new   BigDecimal(datasss.get(i).getTabph());  
				double   phd   =   b1.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();  
				ph.add(phd);
				
				
				BigDecimal   b2   =   new   BigDecimal(datasss.get(i).getTabconductivity());  
				double   conductivityd   =   b2.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();  
				conductivity.add(conductivityd);
				
		
			BigDecimal   b22   =   new   BigDecimal(datasss.get(i).getTabCOD());  
			double   codd   =   b22.setScale(0,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			cod.add(codd);
			BigDecimal   b3   =   new   BigDecimal(datasss.get(i).getTabNH4());  
			double   NH3Nd   =   b3.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			NH3N.add(NH3Nd);
			
			BigDecimal   b4   =   new   BigDecimal(datasss.get(i).getTabCr6());  
			double   cr6d   =   b4.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			cr6.add(cr6d);
			BigDecimal   b5   =   new   BigDecimal(datasss.get(i).getTabDo());  
			double   Dod   =   b5.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Do.add(Dod);
			BigDecimal   b6   =   new   BigDecimal(datasss.get(i).getTabTurbidity());  
			double   Turbidityd   =   b6.setScale(1,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Turbidity.add(Turbidityd);
			
			BigDecimal   b7   =   new   BigDecimal(datasss.get(i).getTabAn());  
			double   And   =   b7.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			An.add(And);
			BigDecimal   b8   =   new   BigDecimal(datasss.get(i).getTabAs());  
			double   Asd  =   b8.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			As.add(Asd);
			BigDecimal   b9   =   new   BigDecimal(datasss.get(i).getTabCd());  
			double   Cdd  =   b9.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Cd.add(Cdd);
			
			BigDecimal   b10   =   new   BigDecimal(datasss.get(i).getTabCN());  
			double   Cnd  =   b10.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			CN.add(Cnd);
			BigDecimal   b11   =   new   BigDecimal(datasss.get(i).getTabCu());  
			double   Cud =   b11.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Cu.add(Cud);
			BigDecimal   b12   =   new   BigDecimal(datasss.get(i).getTabF());  
			double   Fd  =   b12.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			F.add(Fd);
			BigDecimal   b13   =   new   BigDecimal(datasss.get(i).getTabFe());  
			double   Fed =   b13.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Fe.add(Fed);
			BigDecimal   b14   =   new   BigDecimal(datasss.get(i).getTabHg());  
			double   Hgd  =   b14.setScale(5,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Hg.add(Hgd);
			BigDecimal   b15   =   new   BigDecimal(datasss.get(i).getTabMn());  
			double   Mnd  =   b15.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Mn.add(Mnd);
			BigDecimal   b16   =   new   BigDecimal(datasss.get(i).getTabNi());  
			double   Nid  =   b16.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Ni.add(Nid);
			
			
			BigDecimal   b17   =   new   BigDecimal(datasss.get(i).getTabNO3());  
			double   NO3d =   b17.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			NO3.add(NO3d);
			BigDecimal   b18   =   new   BigDecimal(datasss.get(i).getTabOC());  
			double   OCd  =   b18.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			OC.add(OCd);
			BigDecimal   b19   =   new   BigDecimal(datasss.get(i).getTabPb());  
			double   Pbd  =   b19.setScale(5,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Pb.add(Pbd);
			BigDecimal   b20   =   new   BigDecimal(datasss.get(i).getTabPhe());  
			double   Phed  =   b20.setScale(4,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Phe.add(Phed);
			
			BigDecimal   b21   =   new   BigDecimal(datasss.get(i).getTabPoison());  
			double   Poisond =   b21.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Poison.add(Poisond);
			BigDecimal   b22s   =   new   BigDecimal(datasss.get(i).getTabS());  
			double  Sd  =   b22s.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			S.add(Sd);
			BigDecimal   b23   =   new   BigDecimal(datasss.get(i).getTabTN());  
			double   Tnd  =   b23.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			TN.add(Tnd);
			BigDecimal   b24   =   new   BigDecimal(datasss.get(i).getTabTP());  
			double   TPd  =   b24.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			TP.add(TPd);
			
			BigDecimal   b26   =   new   BigDecimal(datasss.get(i).getTabZn());  
			double  Znd  =   b26.setScale(3,   BigDecimal.ROUND_HALF_UP).doubleValue();  
			Zn.add(Znd);
			
			
			
			
			sytime2.add("'"+datasss.get(i).getStrTime()+"'");
		}
			request.setAttribute("eTime", eTime);
			request.setAttribute("sTime", sTime);
			request.setAttribute("rid", rid);
			request.setAttribute("dateTypes", dateTypes);
			request.setAttribute("type", type);
			request.setAttribute("minates", minates);
			request.setAttribute("ztraffic", ztraffic);
			request.setAttribute("currentSpeed", currentSpeed);
			request.setAttribute("traffic", traffic);
			request.setAttribute("waterleve", waterleve);
			request.setAttribute("ph", ph);
			request.setAttribute("conductivity", conductivity);
			request.setAttribute("cod", cod);
			request.setAttribute("NH3N", NH3N);
			request.setAttribute("cr6", cr6);
			request.setAttribute("companyName", companyName);
			request.setAttribute("Do", Do);
			request.setAttribute("Turbidity", Turbidity);
			request.setAttribute("TP", TP);
			request.setAttribute("TN", TN);
			request.setAttribute("NO3", NO3);
			request.setAttribute("An", An);
			request.setAttribute("Phe", Phe);
			request.setAttribute("CN", CN);
			request.setAttribute("Pb", Pb);
			request.setAttribute("Cd", Cd);
			request.setAttribute("Cu", Cu);
			request.setAttribute("Hg", Hg);
			
			
			request.setAttribute("As", As);
			request.setAttribute("Fe", Fe);
			request.setAttribute("Mn", Mn);
			request.setAttribute("Ni", Ni);
			request.setAttribute("F", F);
			request.setAttribute("S", S);
			request.setAttribute("Poison", Poison);
			request.setAttribute("OC", OC);
			request.setAttribute("Zn", Zn);
			
			request.setAttribute("companyName", companyName);
			request.setAttribute("sytime", sytime);
			request.setAttribute("sytime2", sytime2);
			request.setAttribute("data_name1", data_name1);
			StringBuffer webUrl=request.getRequestURL();
			String url2=webUrl+"?type="+type+"&form="+form;
			request.setAttribute("webUrls", url2);
			 
			 url= "report/curveWaterList";
			return url;
			
		}
		return url;
				
			
		
	}
}