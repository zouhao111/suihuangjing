package com.erich.saleticket.controllers.api.bitou;
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
import com.erich.saleticket.biz.tdht.ApiAlarmBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.MobileData;
import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.tdht.Alarm;
import com.erich.saleticket.model.tdht.AlarmType;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewWaterquality;


/**
 * 报警控制器
 * @author Lv
 */
public class AlarmController extends BaseController {

	private  List<Pollutant> aaa=new ArrayList<Pollutant>();
	private  List<Pollutant> bbb=new ArrayList<Pollutant>();
	private  List<Pollutant> ccc=new ArrayList<Pollutant>();
	private  List<Pollutant> ddd=new ArrayList<Pollutant>();
	private  List<Pollutant> eee=new ArrayList<Pollutant>();
	private  List<Pollutant> fff=new ArrayList<Pollutant>();
	private  List<Pollutant> ggg=new ArrayList<Pollutant>();
	private  List<Pollutant> hhh=new ArrayList<Pollutant>();
	
	private  List<Pollutant> iii=new ArrayList<Pollutant>();
	private  List<Pollutant> jjj=new ArrayList<Pollutant>();
	private  List<Pollutant> kkk=new ArrayList<Pollutant>();
	private  List<Pollutant> lll=new ArrayList<Pollutant>();
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
			aaa=apialarmBiz.selectByCriteria_allAPI(alarm1);	
		}
		if(alarm2.isHave()){
			bbb=apialarmBiz.selectByCriteria_allAPI(alarm2);
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
			ccc=apialarmBiz.selectByCriteria_allAPI(alarm1);	
		}
		if(alarm2.isHave()){
			ddd=apialarmBiz.selectByCriteria_allAPI(alarm2);
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
	    	 eee=apialarmBiz.selectByCriteria_allAPI(alarm1);	
			}
			if(alarm2.isHave()){
				fff=apialarmBiz.selectByCriteriaPhAPI(alarm2);
			}
			if(alarm3.isHave()){
				 ggg=apialarmBiz.selectByCriteriaZtrAPI(alarm3);
			}
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程3结束时间");// new Date()为获取当前系统时间
	    }

	}
	public class MyThread5 extends Thread
	{
		private Alarm alarm1;
	    private Alarm alarm2;
	    private Alarm alarm3;
	    public MyThread5(Alarm alarm,Alarm alarms,Alarm alarmss)
	    {
	    	alarm1=alarm;
	    	alarm2=alarms;
	    	alarm3=alarmss;
	    }
	    public void run()
	    {SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date())+"*********进程5时间");// new Date()为获取当前系统时间
	    
	     
	    
	     if(alarm1.isHave()){
	    	 iii=apialarmBiz.selectByCriteria_allAPI(alarm1);	
			}
			if(alarm2.isHave()){
				jjj=apialarmBiz.selectByCriteria_allAPI(alarm2);
			}
			if(alarm3.isHave()){
				 kkk=apialarmBiz.selectByCriteria_allAPI(alarm3);
			}
	    	SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(df2.format(new Date())+"*********进程5结束时间");// new Date()为获取当前系统时间
	    }

	}
	public class MyThread4 extends Thread
	{
		private Alarm alarm1;
		private Alarm alarm2;
	    public MyThread4( Alarm alarm ,Alarm alarms )
	    {	alarm1=alarm;
	    alarm2=alarms;
	    }
	    public void run()
	    {SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date())+"*********进程4时间");// new Date()为获取当前系统时间
		
			if(alarm1.isHave()){
				hhh=apialarmBiz.selectByCriteria_sourAllAPI(alarm1);
			}
			if(alarm2.isHave()){
				lll=apialarmBiz.selectByCriteria_sourAllAPI(alarm2);
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
	private ApiAlarmBiz apialarmBiz;
	@Resource
	private DataBiz dataBiz;
			
			/**
			 * 实时报警记录列表
			 */
	@Get("alarmList")
	@Post("alarmList")
	public String alarmList(Alarm alarm, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		MobileData<List<Object>> result = new MobileData<List<Object>>(ApiResultcode._0);
		if(alarm.getRid()==75501330008l){
			alarm.setRid(75501330008l);
		}else if(alarm.getRid()==75501330009l){
			alarm.setRid(75501330009l);
		}else if(alarm.getRid()==75501330010l){
			alarm.setRid(75501330010l);
		}else if(alarm.getRid()==75501330011l){
			alarm.setRid(75501330011l);
		}else if(alarm.getRid()==75501330012l){
			alarm.setRid(75501330012l);
		}else{
			alarm.setRid(75501330008l);
		}
		
		int datasize = 0;
		Alarm alarm1=new Alarm();
		
		Alarm alarm2=new Alarm();
		Alarm alarm3=new Alarm();
		Alarm alarm4=new Alarm();
		Long rid=alarm.getRid();
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
		viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
		/**
		 * 根据rid查询该公司的污染物种类和限值
		 */
		List<AlarmType>  alarmType=apialarmBiz.selectByCriteriaType(rid);
		List<Pollutant>  alarms=new ArrayList<Pollutant>();
		/**
		 * 创建各个污染物的实体  limit在实时报警中会用  要先将pager设为null
		 * have  判断该公司有没有该污染物    
		 */
		Alarm alarmcod=new Alarm();
		alarmcod.setLimit(1);
		alarmcod.setPager(null);
		Alarm alarmnh4=new Alarm();
		alarmnh4.setLimit(1);
		alarmnh4.setPager(null);
		Alarm alarmmlss=new Alarm();
		alarmmlss.setLimit(1);
		alarmmlss.setPager(null);
		Alarm alarmphos=new Alarm();
		alarmphos.setLimit(1);
		alarmphos.setPager(null);
		Alarm alarmcr6=new Alarm();
		alarmcr6.setLimit(1);
		alarmcr6.setPager(null);
		Alarm alarmph=new Alarm();
		alarmph.setLimit(1);
		alarmph.setPager(null);
		Alarm alarmztr=new Alarm();
		alarmztr.setLimit(1);
		alarmztr.setPager(null);
		Alarm alarmvol=new Alarm();
		alarmvol.setLimit(1);
		alarmvol.setPager(null);
		
		Alarm alarmcu=new Alarm();
		alarmcu.setLimit(1);
		alarmcu.setPager(null);
		
		Alarm alarmni=new Alarm();
		alarmni.setLimit(1);
		alarmni.setPager(null);
		
		Alarm alarmzn=new Alarm();
		alarmzn.setLimit(1);
		alarmzn.setPager(null);
		
		Alarm alarmTur=new Alarm();//tabTurbidity
		alarmTur.setLimit(1);
		alarmTur.setPager(null);
		
		
		Double codMax=null;
		Double NH4Max=null;
		Double mlssMax=null;
		Double phosMax=null;
		Double cr6Max=null;
		Double phMax=null;
		Double phMin=null;
		Double ztraMax=null;
		Double volMax=null;
		Double cuMax=null;
		Double niMax=null;
		Double znMax=null;
		Double TurMax=null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
         
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, - 1);
        Date d = c.getTime();
        String days= format.format(d)+" 00:00:00";//七天后时间
        String day = format.format(new Date())+" 23:59:59";//当前时间
		
		/**
		 * 填入各个污染物的实体的参数
		 * 如果有该污染物  have改为true   默认false
		 */
        for(int i=0;i<alarmType.size();i++){
			if(alarmType.get(i).getType().equals("COD")){
				codMax=	alarmType.get(i).getMaxValue();
				
				alarmcod.setAlarmtype("COD");
				alarmcod.setMaxValue(codMax);
				alarmcod.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmcod.setStartingTime(days);
				alarmcod.setEndTime(day);
				alarmcod.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmcod.setHave(have);
				String n="realcod";
				alarmcod.setAlarm_name(n);
			}
			if(alarmType.get(i).getType().equals("氨氮")){
				NH4Max=	alarmType.get(i).getMaxValue();
				alarmnh4.setAlarmtype("氨氮");
				alarmnh4.setMaxValue(NH4Max);
				alarmnh4.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmnh4.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmnh4.setHave(have);
				alarmnh4.setStartingTime(days);
				alarmnh4.setEndTime(day);
				alarmnh4.setAlarm_name("realnh4");
			}
			if(alarmType.get(i).getType().equals("固体悬浮物")){
				mlssMax=	alarmType.get(i).getMaxValue();
				alarmmlss.setAlarmtype("固体悬浮物");
				alarmmlss.setMaxValue(mlssMax);
				alarmmlss.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmmlss.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmmlss.setHave(have);
				alarmmlss.setStartingTime(days);
				alarmmlss.setEndTime(day);
				alarmmlss.setAlarm_name("realmlss");
			}
			if(alarmType.get(i).getType().equals("总磷")){
				 phosMax=	alarmType.get(i).getMaxValue();
				 alarmphos.setAlarmtype("总磷");
				 alarmphos.setMaxValue(phosMax);
				 alarmphos.setCompanyName(viewCompanyconfig.getCompanyName());
				 alarmphos.setRid(rid);
				 boolean have=(alarmType.get(i).getHave())==1?true:false;
				 alarmphos.setHave(have);
				 alarmphos.setStartingTime(days);
				 alarmphos.setEndTime(day);
				 alarmphos.setAlarm_name("realphosphor");
			}
			if(alarmType.get(i).getType().equals("六价铬")){
				cr6Max=	alarmType.get(i).getMaxValue();
				alarmcr6.setAlarmtype("六价铬");
				alarmcr6.setMaxValue(cr6Max);
				alarmcr6.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmcr6.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmcr6.setHave(have);
				alarmcr6.setStartingTime(days);
				alarmcr6.setEndTime(day);
				alarmcr6.setAlarm_name("realcr6");
			}
			if(alarmType.get(i).getType().equals("ph")){
				phMax=	alarmType.get(i).getMaxValue();
				phMin=	alarmType.get(i).getMinValue();
				alarmph.setAlarmtype("ph");
				alarmph.setMaxValue(phMax);
				alarmph.setMinValue(phMin);
				alarmph.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmph.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmph.setHave(have);
				alarmph.setStartingTime(days);
				alarmph.setEndTime(day);
				alarmph.setAlarm_name("tabph");
			}
			if(alarmType.get(i).getType().equals("总流量")){
				ztraMax=	alarmType.get(i).getMaxValue();
				alarmztr.setAlarmtype("总流量");
				alarmztr.setMaxValue(ztraMax);
				alarmztr.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmztr.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmztr.setHave(have);
				alarmztr.setStartingTime(days);
				alarmztr.setEndTime(day);
				alarmztr.setAlarm_name("a1");
			}
			if(alarmType.get(i).getType().equals("电压")){
				volMax=	alarmType.get(i).getMinValue();
				alarmvol.setAlarmtype("电压");
				alarmvol.setMinValue(volMax);
				alarmvol.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmvol.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmvol.setHave(have);
				alarmvol.setStartingTime(days);
				alarmvol.setEndTime(day);
				alarmvol.setAlarm_name("tabVoltage");
			}
			
			if(alarmType.get(i).getType().equals("总铜")){
				cuMax=	alarmType.get(i).getMaxValue();
				alarmcu.setAlarmtype("总铜");
				alarmcu.setMaxValue(cuMax);
				alarmcu.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmcu.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmcr6.setHave(have);
				alarmcu.setStartingTime(days);
				alarmcu.setEndTime(day);
				alarmcu.setAlarm_name("realcu");
			}
			if(alarmType.get(i).getType().equals("总镍")){
				niMax=	alarmType.get(i).getMaxValue();
				alarmni.setAlarmtype("总镍");
				alarmni.setMaxValue(niMax);
				alarmni.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmni.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmni.setHave(have);
				alarmni.setStartingTime(days);
				alarmni.setEndTime(day);
				alarmni.setAlarm_name("realni");
			}
			if(alarmType.get(i).getType().equals("总锌")){
				znMax=	alarmType.get(i).getMaxValue();
				alarmzn.setAlarmtype("总锌");
				alarmzn.setMaxValue(znMax);
				alarmzn.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmzn.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmzn.setHave(have);
				alarmzn.setStartingTime(days);
				alarmzn.setEndTime(day);
				alarmzn.setAlarm_name("realzn");
			}
			if(alarmType.get(i).getType().equals("浊度")){
				TurMax=	alarmType.get(i).getMaxValue();
				alarmTur.setAlarmtype("浊度");
				alarmTur.setMaxValue(TurMax);
				alarmTur.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmTur.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmTur.setHave(have);
				alarmTur.setStartingTime(days);
				alarmTur.setEndTime(day);
				alarmTur.setAlarm_name("tabTurbidity");
			}
			
		}
		
		/**
		 * 启动线程  将给个污染物放到不同的线程 
		 */
		Thread	thread1 = new MyThread1(alarmcod,alarmnh4);
             thread1.start();
		
             Thread thread2 = new MyThread2(alarmmlss,alarmphos);
              thread2.start(); 
		
              Thread	 thread3 = new MyThread3(alarmcr6,alarmph,alarmztr);
            thread3.start();  
		
           Thread  thread4 = new MyThread4(alarmvol,alarmTur);
	    thread4.start(); 
	    Thread  thread5 = new MyThread5(alarmcu,alarmni,alarmzn);
	    thread5.start();
	    while(true)
        {
		   /**
		    * 判断三个线程是否跑完
		    */
			if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive()&&!thread4.isAlive()&&!thread5.isAlive())
		    {
				
				if(aaa.size()!=0){
					alarmcod.setRealValue(fixed(aaa.get(0).getRealcod(), 0));
					alarmcod.setStrTime(aaa.get(0).getStrTime());
				}
				
					
				if(bbb.size()!=0){
					alarmnh4.setRealValue(fixed(bbb.get(0).getRealnh4(), 1));
					alarmnh4.setStrTime(bbb.get(0).getStrTime());
				}
				
				if(ccc.size()!=0){
					alarmmlss.setRealValue(fixed(ccc.get(0).getRealmlss(), 1));
					alarmmlss.setStrTime(ccc.get(0).getStrTime());
				}
				if(ddd.size()!=0){
					alarmphos.setRealValue(fixed(ddd.get(0).getRealphosphor(), 1));
					alarmphos.setStrTime(ddd.get(0).getStrTime());
				}
				if(eee.size()!=0){
					alarmcr6.setRealValue(fixed(eee.get(0).getRealcr6(), 4));
					alarmcr6.setStrTime(eee.get(0).getStrTime());
				}
				if(fff.size()!=0){
					alarmph.setRealValue(fixed(fff.get(0).getRealph(),1));
					alarmph.setStrTime(fff.get(0).getStrTime());
				}
				if(ggg.size()!=0){
					alarmztr.setRealValue(fixed(ggg.get(0).getRealztraffic(), 1));
					alarmztr.setStrTime(ggg.get(0).getStrTime());
				}
				if(hhh.size()!=0){
					alarmvol.setRealValue(fixed(hhh.get(0).getRealvoltage(), 1));
					alarmvol.setStrTime(hhh.get(0).getStrTime());
				}
				if(iii.size()!=0){
					alarmcu.setRealValue(fixed(iii.get(0).getRealcu(), 1));
					alarmcu.setStrTime(iii.get(0).getStrTime());
				}
				if(jjj.size()!=0){
					if(jjj.get(0).getRealni()==null){
						
					}else{
						alarmni.setRealValue(fixed(jjj.get(0).getRealni(), 1));
						alarmni.setStrTime(jjj.get(0).getStrTime());
					}
				}
				if(kkk.size()!=0){
					alarmzn.setRealValue(fixed(kkk.get(0).getRealzn(), 1));
					alarmzn.setStrTime(kkk.get(0).getStrTime());
				}
				if(lll.size()!=0){
					alarmTur.setRealValue(fixed(lll.get(0).getRealTurbidity(), 1));
					alarmTur.setStrTime(lll.get(0).getStrTime());
				}
				break;	
        }
        }
		
	    List<Object>list=new ArrayList<Object>();
	    /**
	     * 如果该公司有该污染物  放入  没有跳过
	     */
	    if(alarmztr.isHave()){
	    	list.add(alarmztr);
	    }
	    if(alarmph.isHave()){
	    	list.add(alarmph);
	    }
	    if(alarmcr6.isHave()){
	    	list.add(alarmcr6);
	    }
	    if(alarmphos.isHave()){
	    	list.add(alarmphos);
	    }
	    if(alarmmlss.isHave()){
	    	list.add(alarmmlss);
	    }
	    if(alarmvol.isHave()){
	    	list.add(alarmvol);
	    }
	    if(alarmcu.isHave()){
	    	list.add(alarmcu);
	    }
	    if(alarmni.isHave()){
	    	list.add(alarmni);
	    }
	    if(alarmzn.isHave()){
	    	list.add(alarmzn);
	    }
		
		if(!rid.toString().equals("75501330004")){
			 if(alarmnh4.isHave()){
				 list.add(alarmnh4);
			    }
		}
		 if(alarmcod.isHave()){
			 list.add(alarmcod);
		    }
		 if(alarmTur.isHave()){
			 list.add(alarmTur);
		    }
		 
		 result.setResult(list);
		 result.init(ApiResultcode._1, "成功");
		 return "@" + encodeJson(result);
	}
			
			
	/**
	 * 实时预警
	 */
	@Get("warningList")
	@Post("warningList")
	public String warningList(ViewWaterquality alarm, HttpServletRequest request, HttpServletResponse response) {
		
		MobileData<List<Object>> result = new MobileData<List<Object>>(ApiResultcode._0);
		
		if(alarm.getRid()==75501330008l){
			alarm.setRid(75501330008l);
		}else if(alarm.getRid()==75501330009l){
			alarm.setRid(75501330009l);
		}else if(alarm.getRid()==75501330010l){
			alarm.setRid(75501330010l);
		}else if(alarm.getRid()==75501330011l){
			alarm.setRid(75501330011l);
		}else if(alarm.getRid()==75501330012l){
			alarm.setRid(75501330012l);
		}else{
			alarm.setRid(75501330008l);
		}
		
				int datasize = 0;
				Alarm alarm1=new Alarm();
				Alarm alarm2=new Alarm();
				Alarm alarm3=new Alarm(); 
				Alarm alarm4=new Alarm();
				Long rid=alarm.getRid();
				ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
				viewCompanyconfig.setRid(rid);
				viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
				List<AlarmType>  alarmType=apialarmBiz.selectByCriteriaType(rid);
				List<Pollutant>  alarms=new ArrayList<Pollutant>();
				Alarm alarmcod=new Alarm();
				alarmcod.setLimit(1);
				alarmcod.setPager(null);
				Alarm alarmTur=new Alarm();//tabTurbidity
				alarmTur.setLimit(1);
				alarmTur.setPager(null);
				Alarm alarmnh4=new Alarm();
				alarmnh4.setLimit(1);
				alarmnh4.setPager(null);
				Alarm alarmmlss=new Alarm();
				alarmmlss.setLimit(1);
				alarmmlss.setPager(null);
				Alarm alarmphos=new Alarm();
				alarmphos.setLimit(1);
				alarmphos.setPager(null);
				Alarm alarmcr6=new Alarm();
				alarmcr6.setLimit(1);
				alarmcr6.setPager(null);
				Alarm alarmph=new Alarm();
				alarmph.setLimit(1);
				alarmph.setPager(null);
				Alarm alarmztr=new Alarm();
				alarmztr.setLimit(1);
				alarmztr.setPager(null);
				Alarm alarmvol=new Alarm();
				alarmvol.setLimit(1);
				alarmvol.setPager(null);
				
				Alarm alarmcu=new Alarm();
				alarmcu.setLimit(1);
				alarmcu.setPager(null);
				
				Alarm alarmni=new Alarm();
				alarmni.setLimit(1);
				alarmni.setPager(null);
				
				Alarm alarmzn=new Alarm();
				alarmzn.setLimit(1);
				alarmzn.setPager(null);
				
				
				Double codMax=null;
				Double NH4Max=null;
				Double mlssMax=null;
				Double phosMax=null;
				Double cr6Max=null;
				Double phMax=null;
				Double phMin=null;
				Double ztraMax=null;
				Double volMax=null;
				Double codMaxs=null;
				Double NH4Maxs=null;
				Double mlssMaxs=null;
				Double phosMaxs=null;
				Double cr6Maxs=null;
				Double phMaxs=null;
				Double phMins=null;
				Double ztraMaxs=null;
				Double volMaxs=null;
				
				Double cuMax=null;
				Double niMax=null;
				Double znMax=null;
				Double cuMaxs=null;
				Double niMaxs=null;
				Double znMaxs=null;
				Double TurMax=null;
				Double TurMaxs=null;
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		        Calendar c = Calendar.getInstance();
		         
		        //过去七天
		        c.setTime(new Date());
		        c.add(Calendar.DATE, - 1);
		        Date d = c.getTime();
		        String days= format.format(d)+" 00:00:00";//七天后时间
		        String day = format.format(new Date())+" 23:59:59";//当前时间
				
		        for(int i=0;i<alarmType.size();i++){
					if(alarmType.get(i).getType().equals("COD")){
						codMax=	alarmType.get(i).getEarlyvalue();
						codMaxs=alarmType.get(i).getMaxValue();
						alarmcod.setAlarmtype("COD");
						alarmcod.setMin_early(codMax);
						alarmcod.setMax_early(codMaxs);
						alarmcod.setCompanyName(viewCompanyconfig.getCompanyName());
						alarmcod.setRid(rid);
						boolean have=(alarmType.get(i).getHave())==1?true:false;
						alarmcod.setHave(have);
						alarmcod.setStartingTime(days);
						alarmcod.setEndTime(day);
						alarmcod.setAlarm_name("realcod");
					}
					if(alarmType.get(i).getType().equals("氨氮")){
						NH4Max=	alarmType.get(i).getEarlyvalue();
						NH4Maxs=alarmType.get(i).getMaxValue();
						alarmnh4.setAlarmtype("氨氮");
						alarmnh4.setMin_early(NH4Max);
						alarmnh4.setMax_early(NH4Maxs);
						alarmnh4.setCompanyName(viewCompanyconfig.getCompanyName());
						alarmnh4.setRid(rid);
						boolean have=(alarmType.get(i).getHave())==1?true:false;
						alarmnh4.setHave(have);
						alarmnh4.setStartingTime(days);
						alarmnh4.setEndTime(day);
						alarmnh4.setAlarm_name("realnh4");
					}
					if(alarmType.get(i).getType().equals("固体悬浮物")){
						mlssMax=	alarmType.get(i).getEarlyvalue();
						mlssMaxs=	alarmType.get(i).getMaxValue();
						alarmmlss.setAlarmtype("固体悬浮物");
						alarmmlss.setMin_early(mlssMax);
						alarmmlss.setMax_early(mlssMaxs);
						alarmmlss.setCompanyName(viewCompanyconfig.getCompanyName());
						alarmmlss.setRid(rid);
						boolean have=(alarmType.get(i).getHave())==1?true:false;
						alarmmlss.setHave(have);
						alarmmlss.setStartingTime(days);
						alarmmlss.setEndTime(day);
						alarmmlss.setAlarm_name("realmlss");
					}
					if(alarmType.get(i).getType().equals("总磷")){
						 phosMax=	alarmType.get(i).getEarlyvalue();
						 phosMaxs=	alarmType.get(i).getMaxValue();
						 alarmphos.setAlarmtype("总磷");
						 alarmphos.setMin_early(phosMax);
						 alarmphos.setMax_early(phosMaxs);
						 alarmphos.setCompanyName(viewCompanyconfig.getCompanyName());
						 alarmphos.setRid(rid);
						 boolean have=(alarmType.get(i).getHave())==1?true:false;
						 alarmphos.setHave(have);
						 alarmphos.setStartingTime(days);
						 alarmphos.setEndTime(day);
						 alarmphos.setAlarm_name("realphosphor");
					}
					if(alarmType.get(i).getType().equals("六价铬")){
						cr6Max=	alarmType.get(i).getEarlyvalue();
						cr6Maxs=	alarmType.get(i).getMaxValue();
						alarmcr6.setAlarmtype("六价铬");
						alarmcr6.setMin_early(cr6Max);
						alarmcr6.setMax_early(cr6Maxs);
						alarmcr6.setCompanyName(viewCompanyconfig.getCompanyName());
						alarmcr6.setRid(rid);
						boolean have=(alarmType.get(i).getHave())==1?true:false;
						alarmcr6.setHave(have);
						alarmcr6.setStartingTime(days);
						alarmcr6.setEndTime(day);
						alarmcr6.setAlarm_name("realcr6");
					}
					if(alarmType.get(i).getType().equals("ph")){
						phMax=	alarmType.get(i).getMax_early();
						phMin=	alarmType.get(i).getMin_early();
						phMaxs=	alarmType.get(i).getMaxValue();
						phMins=	alarmType.get(i).getMinValue();
						alarmph.setAlarmtype("ph");
						alarmph.setMax_earlys(phMaxs);
						alarmph.setMin_earlys(phMins);
						alarmph.setMax_early(phMax);
						alarmph.setMin_early(phMin);
						alarmph.setCompanyName(viewCompanyconfig.getCompanyName());
						alarmph.setRid(rid);
						boolean have=(alarmType.get(i).getHave())==1?true:false;
						alarmph.setHave(have);
						alarmph.setStartingTime(days);
						alarmph.setEndTime(day);
						alarmph.setAlarm_name("tabph");
					}
					if(alarmType.get(i).getType().equals("总流量")){
						ztraMax=	alarmType.get(i).getEarlyvalue();
						ztraMaxs=	alarmType.get(i).getMaxValue();
						alarmztr.setAlarmtype("总流量");
						alarmztr.setMax_early(ztraMaxs);
						alarmztr.setMin_early(ztraMax);
						alarmztr.setCompanyName(viewCompanyconfig.getCompanyName());
						alarmztr.setRid(rid);
						boolean have=(alarmType.get(i).getHave())==1?true:false;
						alarmztr.setHave(have);
						alarmztr.setStartingTime(days);
						alarmztr.setEndTime(day);
						alarmztr.setAlarm_name("a1");
					}
					if(alarmType.get(i).getType().equals("电压")){
						volMax=	alarmType.get(i).getEarlyvalue();
						volMaxs=	alarmType.get(i).getMaxValue();
						alarmvol.setAlarmtype("电压");
						alarmvol.setMin_early(volMax);
						alarmvol.setMax_early(volMaxs);
						alarmvol.setCompanyName(viewCompanyconfig.getCompanyName());
						alarmvol.setRid(rid);
						boolean have=(alarmType.get(i).getHave())==1?true:false;
						alarmvol.setHave(have);
						alarmvol.setStartingTime(days);
						alarmvol.setEndTime(day);
						alarmvol.setAlarm_name("tabVoltage");
					}
					
					
					if(alarmType.get(i).getType().equals("总铜")){
						cuMax=	alarmType.get(i).getEarlyvalue();
						cuMaxs=	alarmType.get(i).getMaxValue();
						alarmcu.setAlarmtype("总铜");
						alarmcu.setMin_early(cuMax);
						alarmcu.setMax_early(cuMaxs);
						alarmcu.setCompanyName(viewCompanyconfig.getCompanyName());
						alarmcu.setRid(rid);
						boolean have=(alarmType.get(i).getHave())==1?true:false;
						alarmcu.setHave(have);
						alarmcu.setStartingTime(days);
						alarmcu.setEndTime(day);
						alarmcu.setAlarm_name("realcu");
					}
					if(alarmType.get(i).getType().equals("总镍")){
						niMax=	alarmType.get(i).getEarlyvalue();
						niMaxs=	alarmType.get(i).getMaxValue();
						alarmni.setAlarmtype("总镍");
						alarmni.setMin_early(niMax);
						alarmni.setMax_early(niMaxs);
						alarmni.setCompanyName(viewCompanyconfig.getCompanyName());
						alarmni.setRid(rid);
						boolean have=(alarmType.get(i).getHave())==1?true:false;
						alarmni.setHave(have);
						alarmni.setStartingTime(days);
						alarmni.setEndTime(day);
						alarmni.setAlarm_name("realni");
					}
					if(alarmType.get(i).getType().equals("总锌")){
						znMax=	alarmType.get(i).getEarlyvalue();
						znMaxs=	alarmType.get(i).getMaxValue();
						alarmzn.setAlarmtype("总锌");
						alarmzn.setMin_early(znMax);
						alarmzn.setMax_early(znMaxs);
						alarmzn.setCompanyName(viewCompanyconfig.getCompanyName());
						alarmzn.setRid(rid);
						boolean have=(alarmType.get(i).getHave())==1?true:false;
						alarmzn.setHave(have);
						alarmzn.setStartingTime(days);
						alarmzn.setEndTime(day);
						alarmzn.setAlarm_name("realzn");
					}
					if(alarmType.get(i).getType().equals("浊度")){
						TurMax=	alarmType.get(i).getEarlyvalue();
						TurMaxs=	alarmType.get(i).getMaxValue();
						alarmTur.setAlarmtype("浊度");
						alarmTur.setMax_early(TurMaxs);
						alarmTur.setMin_early(TurMax);
						alarmTur.setCompanyName(viewCompanyconfig.getCompanyName());
						alarmTur.setRid(rid);
						boolean have=(alarmType.get(i).getHave())==1?true:false;
						alarmTur.setHave(have);
						alarmTur.setStartingTime(days);
						alarmTur.setEndTime(day);
						alarmTur.setAlarm_name("tabTurbidity");
					}
				}
				
				Thread	thread1 = new MyThread1(alarmcod,alarmnh4);
	             thread1.start();  
	             Thread  thread2 = new MyThread2(alarmmlss,alarmphos);
	              thread2.start(); 
	             Thread thread3 = new MyThread3(alarmcr6,alarmph,alarmztr);
		            thread3.start();  
		        Thread  thread4 = new MyThread4(alarmvol,alarmTur);
			    thread4.start();  
			    Thread  thread5 = new MyThread5(alarmcu,alarmni,alarmzn);
			    thread5.start(); 
			    while(true)
		        {
				   
					if (!thread1.isAlive()&&!thread2.isAlive()&&!thread3.isAlive())
				    {
						
						if(aaa.size()!=0){
							alarmcod.setRealValue(fixed(aaa.get(0).getRealcod(), 0));
							alarmcod.setStrTime(aaa.get(0).getStrTime());
						}
						if(bbb.size()!=0){
							alarmnh4.setRealValue(fixed(bbb.get(0).getRealnh4(), 1));
							alarmnh4.setStrTime(bbb.get(0).getStrTime());
						}
						if(ccc.size()!=0){
							alarmmlss.setRealValue(fixed(ccc.get(0).getRealmlss(), 1));
							alarmmlss.setStrTime(ccc.get(0).getStrTime());
						}
						if(ddd.size()!=0){
							alarmphos.setRealValue(fixed(ddd.get(0).getRealphosphor(), 1));
							alarmphos.setStrTime(ddd.get(0).getStrTime());
						}
						if(eee.size()!=0){
							alarmcr6.setRealValue(fixed(eee.get(0).getRealcr6(), 4));
							alarmcr6.setStrTime(eee.get(0).getStrTime());
						}
						if(fff.size()!=0){
							alarmph.setRealValue(fixed(fff.get(0).getRealph(), 1));
							alarmph.setStrTime(fff.get(0).getStrTime());
						}
						if(ggg.size()!=0){
							alarmztr.setRealValue(fixed(ggg.get(0).getRealztraffic(), 1));
							alarmztr.setStrTime(ggg.get(0).getStrTime());
						}
						if(hhh.size()!=0){
							alarmvol.setRealValue(fixed(hhh.get(0).getRealvoltage(), 1));
							alarmvol.setStrTime(hhh.get(0).getStrTime());
						}
						if(iii.size()!=0){
							alarmcu.setRealValue(fixed(iii.get(0).getRealcu(), 1));
							alarmcu.setStrTime(iii.get(0).getStrTime());
						}
						if(jjj.size()!=0){
						
								alarmni.setRealValue(fixed(jjj.get(0).getRealni(), 1));
								alarmni.setStrTime(jjj.get(0).getStrTime());
							
							
						}
						if(kkk.size()!=0){
							alarmzn.setRealValue(fixed(kkk.get(0).getRealzn(), 1));
							alarmzn.setStrTime(kkk.get(0).getStrTime());
						}
						if(lll.size()!=0){
							alarmTur.setRealValue(fixed(lll.get(0).getRealTurbidity(), 1));
							alarmTur.setStrTime(lll.get(0).getStrTime());
						}
						break;	
		        }
		        }
			    List<Object>list=new ArrayList<Object>();
			    if(alarmztr.isHave()){
			    	list.add(alarmztr);
			    }
			    if(alarmph.isHave()){
			    	list.add(alarmph);
			    }
			    if(alarmcr6.isHave()){
			    	list.add(alarmcr6);
			    }
			    if(alarmphos.isHave()){
			    	list.add(alarmphos);
			    }
			    if(alarmmlss.isHave()){
			    	list.add(alarmmlss);
			    }
			    if(alarmvol.isHave()){
			    	list.add(alarmvol);
			    }
				
			    if(alarmvol.isHave()){
			    	list.add(alarmvol);
			    }
			    if(alarmvol.isHave()){
			    	list.add(alarmvol);
			    }
			    if(alarmvol.isHave()){
			    	list.add(alarmvol);
			    }
			    if(alarmcu.isHave()){
			    	list.add(alarmcu);
			    }
			    if(alarmni.isHave()){
			    	list.add(alarmni);
			    }
			    if(alarmzn.isHave()){
			    	list.add(alarmzn);
			    }
				
				if(!rid.toString().equals("75501330004")){
					 if(alarmnh4.isHave()){
						 list.add(alarmnh4);
					    }
				
				}
				 if(alarmcod.isHave()){
					 list.add(alarmcod);
				    }
				 if(alarmTur.isHave()){
					 list.add(alarmTur);
				    }
				 
				 result.setResult(list);
				 result.init(ApiResultcode._1, "成功");
				 return "@" + encodeJson(result);
			}
			
			
			/**
			 *历史报警记录查询列表
			 * @throws ParseException 
			 */ 
	@Get("historyList")
	@Post("historyList")
	public String historyList(Alarm alarm, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		MobileData<List<Object>> result = new MobileData<List<Object>>(ApiResultcode._0);
		
		if(alarm.getRid()==75501330008l){
			alarm.setRid(75501330008l);
		}else if(alarm.getRid()==75501330009l){
			alarm.setRid(75501330009l);
		}else if(alarm.getRid()==75501330010l){
			alarm.setRid(75501330010l);
		}else if(alarm.getRid()==75501330011l){
			alarm.setRid(75501330011l);
		}else if(alarm.getRid()==75501330012l){
			alarm.setRid(75501330012l);
		}else{
			alarm.setRid(75501330008l);
		}
		String sTime=alarm.getStartingTime();
		String eTime=alarm.getEndTime();
		Integer type=alarm.getType();//查询日期类型
		Long rid=alarm.getRid();//公司ID
		String dateType=alarm.getDateTypes();
		String companyName=alarm.getCompanyName();
		/**
		 * waterType 为用户在页面选择的污染物种类   默认ph
		 * 
		 */
		String waterType=alarm.getWaterType();
		
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
		viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
		Date zeroTime=viewCompanyconfig.getStratTime();
		/**
		 * 根据rid查询该公司有的污染物种类和限值
		 */
		List<AlarmType>  alarmType=apialarmBiz.selectByCriteriaType(rid);
		List<AlarmType>alarm_types=new ArrayList<AlarmType>();
		for(int i=0;i<alarmType.size();i++){
			AlarmType a =new AlarmType();
			a.setAlarm_type(alarmType.get(i).getAlarm_type());
			a.setType(alarmType.get(i).getType());
			alarm_types.add(a);
		}
		
		request.setAttribute("alarm_types", alarm_types);
		List<Pollutant>  alarms=new ArrayList<Pollutant>();
		Alarm alarmcod=new Alarm();
		alarmcod.setLimit(null);
		Alarm alarmnh4=new Alarm();
		alarmnh4.setLimit(null);
		Alarm alarmmlss=new Alarm();
		alarmmlss.setLimit(null);
		Alarm alarmphos=new Alarm();
		alarmphos.setLimit(null);
		Alarm alarmcr6=new Alarm();
		alarmcr6.setLimit(null);
		Alarm alarmph=new Alarm();
		alarmph.setLimit(null);
		Alarm alarmztr=new Alarm();
		alarmztr.setLimit(null);
		Alarm alarmvol=new Alarm();
		alarmvol.setLimit(null);
		
		Alarm alarmcu=new Alarm();
		alarmcu.setLimit(null);
		Alarm alarmni=new Alarm();
		alarmni.setLimit(null);
		Alarm alarmzn=new Alarm();
		alarmzn.setLimit(null);
		
		Alarm alarmTur=new Alarm();
		alarmTur.setLimit(null);
		Double TurMax=null;
		
		
		Double codMax=null;
		Double NH4Max=null;
		Double mlssMax=null;
		Double phosMax=null;
		Double cr6Max=null;
		Double phMax=null;
		Double phMin=null;
		Double ztraMax=null;
		Double volMax=null;
		Double cuMax=null;
		Double niMax=null;
		Double znMax=null;
		for(int i=0;i<alarmType.size();i++){
			if(alarmType.get(i).getType().equals("COD")){
				codMax=	alarmType.get(i).getMaxValue();
				alarmcod.setAlarmtype("COD");
				alarmcod.setMaxValue(codMax);
				alarmcod.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmcod.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmcod.setHave(have);
			}
			if(alarmType.get(i).getType().equals("氨氮")){
				NH4Max=	alarmType.get(i).getMaxValue();
				alarmnh4.setAlarmtype("氨氮");
				alarmnh4.setMaxValue(NH4Max);
				alarmnh4.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmnh4.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmnh4.setHave(have);
			}
			if(alarmType.get(i).getType().equals("固体悬浮物")){
				mlssMax=	alarmType.get(i).getMaxValue();
				alarmmlss.setAlarmtype("固体悬浮物");
				alarmmlss.setMaxValue(mlssMax);
				alarmmlss.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmmlss.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmmlss.setHave(have);
			}
			if(alarmType.get(i).getType().equals("总磷")){
				 phosMax=	alarmType.get(i).getMaxValue();
				 alarmphos.setAlarmtype("总磷");
				 alarmphos.setMaxValue(phosMax);
				 alarmphos.setCompanyName(viewCompanyconfig.getCompanyName());
				 alarmphos.setRid(rid);
				 boolean have=(alarmType.get(i).getHave())==1?true:false;
				 alarmphos.setHave(have);
			}
			if(alarmType.get(i).getType().equals("六价铬")){
				cr6Max=	alarmType.get(i).getMaxValue();
				alarmcr6.setAlarmtype("六价铬");
				alarmcr6.setMaxValue(cr6Max);
				alarmcr6.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmcr6.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmcr6.setHave(have);
			}
			if(alarmType.get(i).getType().equals("ph")){
				phMax=	alarmType.get(i).getMaxValue();
				phMin=	alarmType.get(i).getMinValue();
				alarmph.setAlarmtype("ph");
				alarmph.setMaxValue(phMax);
				alarmph.setMinValue(phMin);
				alarmph.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmph.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmph.setHave(have);
			}
			if(alarmType.get(i).getType().equals("总流量")){
				ztraMax=	alarmType.get(i).getMaxValue();
				alarmztr.setAlarmtype("总流量");
				alarmztr.setMaxValue(ztraMax);
				alarmztr.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmztr.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmztr.setHave(have);
			}
			if(alarmType.get(i).getType().equals("电压")){
				volMax=	alarmType.get(i).getMaxValue();
				alarmvol.setAlarmtype("电压");
				alarmvol.setMaxValue(volMax);
				alarmvol.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmvol.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmvol.setHave(have);
			}
			if(alarmType.get(i).getType().equals("总铜")){
				cuMax=	alarmType.get(i).getMaxValue();
				alarmcu.setAlarmtype("总铜");
				alarmcu.setMin_early(cuMax);
				alarmcu.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmcu.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmcr6.setHave(have);
			}
			if(alarmType.get(i).getType().equals("总镍")){
				niMax=	alarmType.get(i).getMaxValue();
				alarmni.setAlarmtype("总镍");
				alarmni.setMaxValue(niMax);
				alarmni.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmni.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmni.setHave(have);
			}
			if(alarmType.get(i).getType().equals("总锌")){
				znMax=	alarmType.get(i).getMaxValue();
				alarmzn.setAlarmtype("总锌");
				alarmzn.setMaxValue(znMax);
				alarmzn.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmzn.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmzn.setHave(have);
			}
			if(alarmType.get(i).getType().equals("浊度")){
				znMax=	alarmType.get(i).getMaxValue();
				alarmTur.setAlarmtype("浊度");
				alarmTur.setMaxValue(TurMax);
				alarmTur.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmTur.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmTur.setHave(have);
			}
		}
		
		Alarm alarmsss=new Alarm();
		
		if(sTime==null & dateType==null ){
			waterType="ph";
			
			if(waterType.equals("ph")){
				alarmsss=alarmph;
			}
			if(waterType.equals("cod")){
				alarmsss=alarmcod;
			}
			if(waterType.equals("mlss")){
				alarmsss=alarmmlss;
			}
			if(waterType.equals("pho")){
				alarmsss=alarmphos;
			}
			if(waterType.equals("ztraffic")){
				alarmsss=alarmztr;
			}
			if(waterType.equals("vol")){
				alarmsss=alarmvol;
			}
			if(waterType.equals("nh4")){
				alarmsss=alarmnh4;
			}
			if(waterType.equals("ni")){
				alarmsss=alarmni;
			}
			if(waterType.equals("Tur")){
				alarmsss=alarmTur;
			}
			if(waterType.equals("cu")){
				alarmsss=alarmcu;
			}
			if(waterType.equals("zn")){
				alarmsss=alarmzn;
			}
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
						
							alarmsss.setStartingTime(sTime);
							alarmsss.setEndTime(eTime);
							String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
							alarmsss.setZeroTime(zeroTime1);
							  dateType=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
								request.setAttribute("dateType", dateType);
						}
						if(type==3){
							sTime=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
							Calendar cal3 = Calendar.getInstance(); 
							sTime=sTime+"-01";
							eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
							alarmsss.setStartingTime(sTime);
							cal3.add(Calendar.MONTH, 1);//增加一天 
							cal3.add(Calendar.DAY_OF_MONTH, -1);//增加一天 
							 eTime=sdf.format(cal3.getTime());  
							alarmsss.setEndTime(eTime);
							String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
							alarmsss.setZeroTime(zeroTime1);
							dateType=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
							request.setAttribute("dateType", dateType);
						}
						if(type==6){
							
							sTime=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
							Calendar cal3 = Calendar.getInstance(); 
							
							String eTime1=sTime+"-12-31";
							String sTime1=sTime+"-01-01";
							String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
							alarmsss.setZeroTime(zeroTime1);
							alarmsss.setStartingTime(sTime1);
							alarmsss.setEndTime(eTime1);
							
							dateType=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
							request.setAttribute("dateType", dateType);
						}
						if(type==5){
							alarmsss.setStartingTime(sTime);
							alarmsss.setEndTime(eTime);
							request.setAttribute("sTime", sTime);
							request.setAttribute("eTime", eTime);
							String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
							alarmsss.setZeroTime(zeroTime1);
						}
				
			
			
			
		}else{
			if(waterType.equals("ph")){
				alarmsss=alarmph;
			}
			if(waterType.equals("cod")){
				alarmsss=alarmcod;
			}
			if(waterType.equals("mlss")){
				alarmsss=alarmmlss;
			}
			if(waterType.equals("pho")){
				alarmsss=alarmphos;
			}
			if(waterType.equals("cr6")){
				alarmsss=alarmcr6;
			}
			if(waterType.equals("ztraffic")){
				alarmsss=alarmztr;
			}
			if(waterType.equals("vol")){
				alarmsss=alarmvol;
			}
			if(waterType.equals("nh4")){
				alarmsss=alarmnh4;
			}
			if(waterType.equals("ni")){
				alarmsss=alarmni;
			}
			if(waterType.equals("Tur")){
				alarmsss=alarmTur;
			}
			if(waterType.equals("cu")){
				alarmsss=alarmcu;
			}
			if(waterType.equals("zn")){
				alarmsss=alarmzn;
			}
			if(type==1){
			sTime=dateType;
			String sTime1=dateType+" 00:00:00";
			eTime=dateType+" 23:59:59";
			  Calendar cal = Calendar.getInstance(); 
			String   eTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime());
			String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
			alarmsss.setZeroTime(zeroTime1);
			if (eTime1.compareTo(eTime)>0) {
				alarmsss.setStartingTime(sTime1);
				alarmsss.setEndTime(eTime);
				} else {
					alarmsss.setStartingTime(sTime1);
					alarmsss.setEndTime(eTime1);
				}
			alarmsss.setDateTypes(null);
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
              
	            alarmsss.setStartingTime(sTime);
	            alarmsss.setEndTime(eTime);
				String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
				alarmsss.setZeroTime(zeroTime1);
				alarmsss.setDateTypes(null);
				request.setAttribute("dateType", dateType);
			}
			if(type==6){
				sTime=dateType; 
				Calendar cal3 = Calendar.getInstance(); 
				eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
				String eTime1=dateType+"-12-31";
				String sTime1=sTime+"-01-01";
				String zTime=(new SimpleDateFormat("yyyy-MM-dd")).format(zeroTime);
				
				alarmsss.setEndTime(eTime1);
					
				alarmsss.setStartingTime(sTime1);
					
				String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
				alarmsss.setZeroTime(zeroTime1);
				
				
				alarmsss.setDateTypes(null);
				request.setAttribute("dateType", dateType);
			}
			if(type==5){
				alarmsss.setStartingTime(sTime);
				alarmsss.setEndTime(eTime);
				request.setAttribute("sTime", sTime);
				request.setAttribute("eTime", eTime);
				
				String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
				alarmsss.setZeroTime(zeroTime1);
			}
		}
		int offset = SystemContext.getOffset();
		int pagesize = SystemContext.getPagesize();
		alarmsss.getPager().setPageOffset(offset);
		alarmsss.getPager().setPageSize(pagesize);
		alarmsss.getPager().setOrderField("user_id");
		alarmsss.getPager().setOrderDirection(false);
		List<Pollutant> historys=new ArrayList<Pollutant>();
		List<Object> codAlarm=new ArrayList<Object>();
		 int pagenum=0;
		 Pager pagers = new Pager();
		if(alarmsss.isHave()){
		if(waterType.equals("ph")){
			
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountPh(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaPh(alarmsss);
		}
		if(waterType.equals("cod")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountCod(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaCod(alarmsss);
		}
		if(waterType.equals("mlss")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountMlss(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaMlss(alarmsss);
		}
		if(waterType.equals("pho")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountPho(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaPho(alarmsss);
		}
		if(waterType.equals("ztraffic")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountZtr(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaZtr(alarmsss);
		}
		if(waterType.equals("cr6")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountcr6(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriacr6(alarmsss);
		}
		if(waterType.equals("vol")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountVol(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaVol(alarmsss);
		}
		if(waterType.equals("cu")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountcu(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriacu(alarmsss);
		}
		if(waterType.equals("ni")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountni(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriani(alarmsss);
		}
		if(waterType.equals("zn")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountzn(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriazn(alarmsss);
		}

		if(waterType.equals("Tur")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountTur(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaTur(alarmsss);
		}
		for(int i=0;i<historys.size();i++){
			Alarm alarmss=new Alarm();
			//codAlarm=new ArrayList<Alarm>();
			alarmss.setAlarmtype(alarmsss.getAlarmtype());
			alarmss.setMaxValue(alarmsss.getMaxValue());
			
			alarmss.setCompanyName(alarmsss.getCompanyName());
			alarmss.setRid(alarmsss.getRid());
			if(waterType.equals("ph")){
				alarmss.setMinValue(alarmsss.getMinValue());
				alarmss.setRealValue(fixed(historys.get(i).getRealph(), 1));
			}
			if(waterType.equals("cod")){
				alarmss.setRealValue(fixed(historys.get(i).getRealcod(), 0));
			}
			if(waterType.equals("mlss")){
				alarmss.setRealValue(fixed(historys.get(i).getRealmlss(), 1));
			}
			if(waterType.equals("pho")){
				alarmss.setRealValue(fixed(historys.get(i).getRealphosphor(), 1));
			}
			if(waterType.equals("ztraffic")){
				alarmss.setRealValue(fixed(historys.get(i).getRealztraffic(), 1));
			}
			if(waterType.equals("cr6")){
				alarmss.setRealValue(fixed(historys.get(i).getRealcr6(), 4));
			}
			if(waterType.equals("vol")){
				alarmss.setRealValue(fixed(historys.get(i).getRealvoltage(), 1));
			}
			if(waterType.equals("cu")){
				alarmss.setRealValue(fixed(historys.get(i).getRealcu(), 1));
			}
			if(waterType.equals("ni")){
				alarmss.setRealValue(fixed(historys.get(i).getRealni(), 1));
			}
			if(waterType.equals("zn")){
				alarmss.setRealValue(fixed(historys.get(i).getRealzn(), 1));
			}
			if(waterType.equals("Tur")){
				alarmss.setRealValue(fixed(historys.get(i).getRealTurbidity(), 1));
			}
			alarmss.setStrTime(historys.get(i).getStrTime());	
			codAlarm.add(alarmss);
		}
		}else{
		pagers.setRowCount(pagenum);
		}
				result.setResult(codAlarm);
				 result.init(ApiResultcode._1, "成功");
				 return "@" + encodeJson(result);
	}
		
			
			
	/**
	 *历史预警记录查询列表
	 * @throws ParseException 
	 */ 
	@Get("warninghistoryList")
	@Post("warninghistoryList")
	public String warninghistoryList(Alarm alarm, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		MobileData<List<Object>> result = new MobileData<List<Object>>(ApiResultcode._0);
		if(alarm.getRid()==75501330008l){
			alarm.setRid(75501330008l);
		}else if(alarm.getRid()==75501330009l){
			alarm.setRid(75501330009l);
		}else if(alarm.getRid()==75501330010l){
			alarm.setRid(75501330010l);
		}else if(alarm.getRid()==75501330011l){
			alarm.setRid(75501330011l);
		}else if(alarm.getRid()==75501330012l){
			alarm.setRid(75501330012l);
		}else{
			alarm.setRid(75501330008l);
		}
		String sTime=alarm.getStartingTime();
		String eTime=alarm.getEndTime();
		Integer type=alarm.getType();//查询日期类型
		Long rid=alarm.getRid();//公司ID
		String dateType=alarm.getDateTypes();
		String companyName=alarm.getCompanyName();
		
		String waterType=alarm.getWaterType();
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
		viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
		Date zeroTime=viewCompanyconfig.getStratTime();
		List<AlarmType>  alarmType=apialarmBiz.selectByCriteriaType(rid);
		List<AlarmType>alarm_types=new ArrayList<AlarmType>();
		for(int i=0;i<alarmType.size();i++){
			AlarmType a =new AlarmType();
			a.setAlarm_type(alarmType.get(i).getAlarm_type());
			a.setType(alarmType.get(i).getType());
			alarm_types.add(a);
		}
		
		request.setAttribute("alarm_types", alarm_types);
		
		
		
		List<Pollutant>  alarms=new ArrayList<Pollutant>();
		Alarm alarmcod=new Alarm();
		alarmcod.setLimit(null);
		Alarm alarmnh4=new Alarm();
		alarmnh4.setLimit(null);
		Alarm alarmmlss=new Alarm();
		alarmmlss.setLimit(null);
		Alarm alarmphos=new Alarm();
		alarmphos.setLimit(null);
		Alarm alarmcr6=new Alarm();
		alarmcr6.setLimit(null);
		Alarm alarmph=new Alarm();
		alarmph.setLimit(null);
		Alarm alarmztr=new Alarm();
		alarmztr.setLimit(null);
		Alarm alarmvol=new Alarm();
		alarmvol.setLimit(null);
		Alarm alarmcu=new Alarm();
		alarmcu.setLimit(null);
		
		Alarm alarmni=new Alarm();
		alarmni.setLimit(null);
		
		Alarm alarmzn=new Alarm();
		alarmzn.setLimit(null);
		Alarm alarmTur=new Alarm();
		alarmTur.setLimit(null);
		Double TurMaxs=null;
		Double TurMax=null;
		Double cuMax=null;
		Double niMax=null;
		Double znMax=null;
		Double cuMaxs=null;
		Double niMaxs=null;
		Double znMaxs=null;
		
		Double codMax=null;
		Double NH4Max=null;
		Double mlssMax=null;
		Double phosMax=null;
		Double cr6Max=null;
		Double phMax=null;
		Double phMin=null;
		Double ztraMax=null;
		Double volMax=null;
		Double codMaxs=null;
		Double NH4Maxs=null;
		Double mlssMaxs=null;
		Double phosMaxs=null;
		Double cr6Maxs=null;
		Double phMaxs=null;
		Double phMins=null;
		Double ztraMaxs=null;
		Double volMaxs=null;
		for(int i=0;i<alarmType.size();i++){
			if(alarmType.get(i).getType().equals("COD")){
				codMax=	alarmType.get(i).getEarlyvalue();
				codMaxs=alarmType.get(i).getMaxValue();
				alarmcod.setAlarmtype("COD");
				alarmcod.setMin_early(codMax);
				alarmcod.setMax_early(codMaxs);
				alarmcod.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmcod.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmcod.setHave(have);
			}
			if(alarmType.get(i).getType().equals("氨氮")){
				NH4Max=	alarmType.get(i).getEarlyvalue();
				NH4Maxs=alarmType.get(i).getMaxValue();
				alarmnh4.setAlarmtype("氨氮");
				alarmnh4.setMin_early(NH4Max);
				alarmnh4.setMax_early(NH4Maxs);
				alarmnh4.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmnh4.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmnh4.setHave(have);
			}
			if(alarmType.get(i).getType().equals("固体悬浮物")){
				mlssMax=	alarmType.get(i).getEarlyvalue();
				mlssMaxs=	alarmType.get(i).getMaxValue();
				alarmmlss.setAlarmtype("固体悬浮物");
				alarmmlss.setMin_early(mlssMax);
				alarmmlss.setMax_early(mlssMaxs);
				alarmmlss.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmmlss.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmmlss.setHave(have);
			}
			if(alarmType.get(i).getType().equals("总磷")){
				 phosMax=	alarmType.get(i).getEarlyvalue();
				 phosMaxs=	alarmType.get(i).getMaxValue();
				 alarmphos.setAlarmtype("总磷");
				 alarmphos.setMin_early(phosMax);
				 alarmphos.setMax_early(phosMaxs);
				 alarmphos.setCompanyName(viewCompanyconfig.getCompanyName());
				 alarmphos.setRid(rid);
				 boolean have=(alarmType.get(i).getHave())==1?true:false;
				 alarmphos.setHave(have);
			}
			if(alarmType.get(i).getType().equals("六价铬")){
				cr6Max=	alarmType.get(i).getEarlyvalue();
				cr6Maxs=	alarmType.get(i).getMaxValue();
				alarmcr6.setAlarmtype("六价铬");
				alarmcr6.setMin_early(cr6Max);
				alarmcr6.setMax_early(cr6Maxs);
				alarmcr6.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmcr6.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmcr6.setHave(have);
			}
			if(alarmType.get(i).getType().equals("ph")){
				phMax=	alarmType.get(i).getMax_early();
				phMin=	alarmType.get(i).getMin_early();
				phMaxs=	alarmType.get(i).getMaxValue();
				phMins=	alarmType.get(i).getMinValue();
				alarmph.setAlarmtype("ph");
				alarmph.setMax_earlys(phMaxs);
				alarmph.setMin_earlys(phMins);
				alarmph.setMax_early(phMax);
				alarmph.setMin_early(phMin);
				alarmph.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmph.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmph.setHave(have);
			}
			if(alarmType.get(i).getType().equals("总流量")){
				ztraMax=	alarmType.get(i).getEarlyvalue();
				ztraMaxs=	alarmType.get(i).getMaxValue();
				alarmztr.setAlarmtype("总流量");
				alarmztr.setMax_early(ztraMaxs);
				alarmztr.setMin_early(ztraMax);
				alarmztr.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmztr.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmztr.setHave(have);
			}
			if(alarmType.get(i).getType().equals("电压")){
				volMax=	alarmType.get(i).getEarlyvalue();
				volMaxs=	alarmType.get(i).getMaxValue();
				alarmvol.setAlarmtype("电压");
				alarmvol.setMax_early(volMax);
				alarmvol.setMin_early(volMaxs);
				alarmvol.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmvol.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmvol.setHave(have);
			}
			if(alarmType.get(i).getType().equals("总铜")){
				cuMax=	alarmType.get(i).getEarlyvalue();
				cuMaxs=	alarmType.get(i).getMaxValue();
				
				alarmcu.setAlarmtype("总铜");
				alarmcu.setMin_early(cuMax);
				alarmcu.setMax_early(cuMaxs);
				alarmcu.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmcu.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmcr6.setHave(have);
			}
			if(alarmType.get(i).getType().equals("总镍")){
				niMax=	alarmType.get(i).getEarlyvalue();
				niMaxs=	alarmType.get(i).getMaxValue();
				
				alarmni.setAlarmtype("总镍");
				alarmni.setMin_early(niMax);
				alarmni.setMax_early(niMaxs);
				alarmni.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmni.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmni.setHave(have);
			}
			if(alarmType.get(i).getType().equals("总锌")){
				znMax=	alarmType.get(i).getEarlyvalue();
				znMaxs=	alarmType.get(i).getMaxValue();
				
				alarmzn.setAlarmtype("总锌");
				alarmzn.setMin_early(znMax);
				alarmzn.setMax_early(znMaxs);
				
				alarmzn.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmzn.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmzn.setHave(have);
			}
			
			if(alarmType.get(i).getType().equals("浊度")){
				TurMax=	alarmType.get(i).getEarlyvalue();
				TurMaxs=	alarmType.get(i).getMaxValue();
				
				alarmTur.setAlarmtype("浊度");
				alarmTur.setMin_early(TurMax);
				alarmTur.setMax_early(TurMaxs);
				
				
				alarmTur.setCompanyName(viewCompanyconfig.getCompanyName());
				alarmTur.setRid(rid);
				boolean have=(alarmType.get(i).getHave())==1?true:false;
				alarmTur.setHave(have);
			}
		}
		
		Alarm alarmsss=new Alarm();
		
		if(sTime==null & dateType==null ){
			waterType="ph";
			
			if(waterType.equals("ph")){
				alarmsss=alarmph;
			}
			if(waterType.equals("cod")){
				alarmsss=alarmcod;
			}
			if(waterType.equals("mlss")){
				alarmsss=alarmmlss;
			}
			if(waterType.equals("pho")){
				alarmsss=alarmphos;
			}
			if(waterType.equals("ztraffic")){
				alarmsss=alarmztr;
			}
			if(waterType.equals("cr6")){
				alarmsss=alarmcr6;
			}
			if(waterType.equals("vol")){
				alarmsss=alarmvol;
			}
			
			if(waterType.equals("cu")){
				alarmsss=alarmcu;
			}
			if(waterType.equals("ni")){
				alarmsss=alarmni;
			}
			if(waterType.equals("zn")){
				alarmsss=alarmzn;
			}
			if(waterType.equals("Tur")){
				alarmsss=alarmTur;
			}
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
							
							alarmsss.setStartingTime(sTime);
							alarmsss.setEndTime(eTime);
							String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
							alarmsss.setZeroTime(zeroTime1);
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
							alarmsss.setStartingTime(sTime);
							alarmsss.setEndTime(eTime);
							String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
							alarmsss.setZeroTime(zeroTime1);
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
							alarmsss.setZeroTime(zeroTime1);
							alarmsss.setStartingTime(sTime1);
							alarmsss.setEndTime(eTime1);
							
							dateType=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
							request.setAttribute("dateType", dateType);
						}
						if(type==5){
							alarmsss.setStartingTime(sTime);
							alarmsss.setEndTime(eTime);
							request.setAttribute("sTime", sTime);
							request.setAttribute("eTime", eTime);
							String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
							alarmsss.setZeroTime(zeroTime1);
						}
				
			
			
			
		}else{
			if(waterType.equals("ph")){
				alarmsss=alarmph;
			}
			if(waterType.equals("cod")){
				alarmsss=alarmcod;
			}
			if(waterType.equals("mlss")){
				alarmsss=alarmmlss;
			}
			if(waterType.equals("pho")){
				alarmsss=alarmphos;
			}
			if(waterType.equals("ztraffic")){
				alarmsss=alarmztr;
			}
			if(waterType.equals("cr6")){
				alarmsss=alarmcr6;
			}
			if(waterType.equals("vol")){
				alarmsss=alarmvol;
			}
			
			if(waterType.equals("cu")){
				alarmsss=alarmcu;
			}
			if(waterType.equals("ni")){
				alarmsss=alarmni;
			}
			if(waterType.equals("zn")){
				alarmsss=alarmzn;
			}
			if(waterType.equals("Tur")){
				alarmsss=alarmTur;
			}
			if(type==1){
			sTime=dateType;
			String sTime1=dateType+" 00:00:00";
			eTime=dateType+" 23:59:59";
			  Calendar cal = Calendar.getInstance(); 
			String   eTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime());
			String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
			alarmsss.setZeroTime(zeroTime1);
			if (eTime1.compareTo(eTime)>0) {
				alarmsss.setStartingTime(sTime1);
				alarmsss.setEndTime(eTime);
				} else {
					alarmsss.setStartingTime(sTime1);
					alarmsss.setEndTime(eTime1);
				}
			alarmsss.setDateTypes(null);
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
              
	            alarmsss.setStartingTime(sTime);
	            alarmsss.setEndTime(eTime);
				String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
				alarmsss.setZeroTime(zeroTime1);
				alarmsss.setDateTypes(null);
				request.setAttribute("dateType", dateType);
			}
			if(type==6){
				sTime=dateType; 
				Calendar cal3 = Calendar.getInstance(); 
				eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
				String eTime1=dateType+"-12-31";
				String sTime1=sTime+"-01-01";
				String zTime=(new SimpleDateFormat("yyyy-MM-dd")).format(zeroTime);
				
				alarmsss.setEndTime(eTime1);
					
				alarmsss.setStartingTime(sTime1);
					
				String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
				alarmsss.setZeroTime(zeroTime1);
				
				
				alarmsss.setDateTypes(null);
				request.setAttribute("dateType", dateType);
			}
			if(type==5){
				alarmsss.setStartingTime(sTime);
				alarmsss.setEndTime(eTime);
				request.setAttribute("sTime", sTime);
				request.setAttribute("eTime", eTime);
				
				String zeroTime1=(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(zeroTime);
				alarmsss.setZeroTime(zeroTime1);
			}
		}
		int offset = SystemContext.getOffset();
		int pagesize = SystemContext.getPagesize();
		alarmsss.getPager().setPageOffset(offset);
		alarmsss.getPager().setPageSize(pagesize);
		alarmsss.getPager().setOrderField("user_id");
		alarmsss.getPager().setOrderDirection(false);
		List<Pollutant> historys=new ArrayList<Pollutant>();
		List<Object> codAlarm=new ArrayList<Object>();
		int pagenum=0;
		 Pager pagers = new Pager();
		if(alarmsss.isHave()){
		if(waterType.equals("ph")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountPh(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaPh(alarmsss);
		}
		if(waterType.equals("cod")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountCod(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaCod(alarmsss);
		}
		if(waterType.equals("mlss")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountMlss(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaMlss(alarmsss);
		}
		if(waterType.equals("pho")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountPho(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaPho(alarmsss);
		}
		if(waterType.equals("ztraffic")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountZtr(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaZtr(alarmsss);
		}
		if(waterType.equals("cr6")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountcr6(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriacr6(alarmsss);
		}
		if(waterType.equals("vol")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountVol(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaVol(alarmsss);
		}
		if(waterType.equals("cu")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountcu(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriacu(alarmsss);
		}
		if(waterType.equals("ni")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountni(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriani(alarmsss);
		}
		if(waterType.equals("zn")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountzn(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriazn(alarmsss);
		}
		if(waterType.equals("Tur")){
			alarmsss.getPager().setRowCount(apialarmBiz.selectCountTur(alarmsss));
			request.setAttribute("pager", alarmsss.getPager());
			int size=alarmsss.getPager().getRowCount();
			if(size==0){
				alarmsss.setPager(null);
			}
			 historys = apialarmBiz.selectByCriteriaTur(alarmsss);
		}
		for(int i=0;i<historys.size();i++){
			Alarm alarmss=new Alarm();
			//codAlarm=new ArrayList<Alarm>();
			alarmss.setAlarmtype(alarmsss.getAlarmtype());
			alarmss.setMaxValue(alarmsss.getMaxValue());
			alarmss.setMin_early(alarmsss.getMin_early());
			alarmss.setMax_early(alarmsss.getMax_early());
			alarmss.setCompanyName(alarmsss.getCompanyName());
			alarmss.setRid(alarmsss.getRid());
			if(waterType.equals("ph")){
				alarmss.setMin_early(alarmsss.getMin_early());
				alarmss.setMax_early(alarmsss.getMax_early());
				alarmss.setRealValue(fixed(historys.get(i).getRealph(), 1));
			}
			if(waterType.equals("cod")){
				alarmss.setRealValue(fixed(historys.get(i).getRealcod(), 0));
			}
			if(waterType.equals("mlss")){
				alarmss.setRealValue(fixed(historys.get(i).getRealmlss(), 1));
			}
			if(waterType.equals("pho")){
				alarmss.setRealValue(fixed(historys.get(i).getRealphosphor(),1));
			}
			if(waterType.equals("ztraffic")){
				alarmss.setRealValue(fixed(historys.get(i).getRealztraffic(), 1));
			}
			if(waterType.equals("cr6")){
				alarmss.setRealValue(fixed(historys.get(i).getRealcr6(), 4));
			}
			if(waterType.equals("vol")){
				alarmss.setRealValue(fixed(historys.get(i).getRealvoltage(), 1));
			}
			if(waterType.equals("cu")){
				alarmss.setRealValue(fixed(historys.get(i).getRealcu(), 1));
			}
			if(waterType.equals("ni")){
				alarmss.setRealValue(fixed(historys.get(i).getRealni(), 1));
			}
			if(waterType.equals("zn")){
				alarmss.setRealValue(fixed(historys.get(i).getRealzn(), 1));
			}
			if(waterType.equals("Tur")){
				alarmss.setRealValue(fixed(historys.get(i).getRealTurbidity(), 1));
			}
			alarmss.setStrTime(historys.get(i).getStrTime());	
			codAlarm.add(alarmss);
		}
		}else{
			pagers.setRowCount(pagenum);
			request.setAttribute("pager", pagers);
		}
			result.setResult(codAlarm);
			result.init(ApiResultcode._1, "成功");
				 return "@" + encodeJson(result);
	}
	
	

	

}
