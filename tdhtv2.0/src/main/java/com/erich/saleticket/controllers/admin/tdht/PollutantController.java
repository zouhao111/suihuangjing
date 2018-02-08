package com.erich.saleticket.controllers.admin.tdht;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erich.saleticket.biz.tdht.CurveReportBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.biz.tdht.PollutantBiz;
import com.erich.saleticket.biz.tdht.ReportFormBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewLineReport;
import com.erich.saleticket.model.tdht.ViewZtraffic;

/**
 *污染物控制器
 * @author Lv
 */
public class PollutantController extends BaseController {

	
	@Resource
	private PollutantBiz pollutantBiz;
	@Resource
	private CurveReportBiz curveReportBiz;
	@Resource
	private DataBiz dataBiz;
	/**
	 *基本信息
	 * @throws ParseException 
	 */
	

	
	
	
	public String pollutantList(Pollutant pollutant,HttpServletRequest request, HttpServletResponse response) throws ParseException {
		
		String sTime=pollutant.getStartingTime();
		String eTime=pollutant.getEndTime();
		
		Pollutant pollutant2=new Pollutant();
		pollutant2.setRid(pollutant.getRid());
		pollutant2.setStartingTime(pollutant.getStartingTime());
		pollutant2.setEndTime(pollutant.getEndTime());
		pollutant2.setDateTypes(pollutant.getDateTypes());
		Integer type=pollutant.getType();//查询日期类型
		Long rid=pollutant.getRid();//公司ID
		String dateTypes=pollutant.getDateTypes();
		
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
		viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
		
		Date str=viewCompanyconfig.getStratTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");  
		SimpleDateFormat sdfs=new SimpleDateFormat("yyyy-MM-dd");  
		String startTime=sdf.format(str);  
		StringDataLongTime s=new StringDataLongTime();
		
		 
		List<Pollutant> data_name=curveReportBiz.selectByPollutant_Pollname(pollutant);
		List<Pollutant> data_name1=new ArrayList<Pollutant>();
		List<Pollutant> data_name2=new ArrayList<Pollutant>();
		List<Pollutant> data_name3=new ArrayList<Pollutant>();
		for(int i=0;i<data_name.size();i++){
			if(data_name.get(i).getType_poll()!=null){
				
			
			if(data_name.get(i).getType_poll()==1){
				data_name1.add(data_name.get(i));
			}else{
				data_name2.add(data_name.get(i));
			}
			}
		}
		data_name3.addAll(data_name1);
		data_name3.addAll(data_name2);
		request.setAttribute("data_name1", data_name1);
		request.setAttribute("data_name2", data_name2);
		request.setAttribute("data_name3", data_name3);
		request.setAttribute("num1", data_name1.size());
		request.setAttribute("num2", data_name2.size());
		if(sTime==null & dateTypes==null ){
		
			
			Calendar cal = Calendar.getInstance(); 
			cal.set(Calendar.HOUR_OF_DAY, 0); 
			
			cal.set(Calendar.MINUTE, 0); 
			sTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(cal.getTime()); 
			cal.set(Calendar.HOUR_OF_DAY, 23); 
			
			cal.set(Calendar.MINUTE, 59);
			
			
			
			if(type==5){
			
			eTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(cal.getTime()); 
			
		
			
			Long sTimeL=s.stringToLong(sTime,"yyyy-MM-dd HH:mm");
			Long eTimeL=s.stringToLong(eTime,"yyyy-MM-dd HH:mm");
			pollutant2.setStartingTimeL(sTimeL/1000/60+480);
			pollutant2.setEndTimeL(eTimeL/1000/60+480);
			}
			if(type==3){
				/*if (zTime.compareTo(sTime)>0) {
					
				}*/
				sTime=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
				 
				String sTime1=sTime+"-01 00:00";
				
				if (sTime1.compareTo(startTime)>0) {
					//pollutant.setStartingTime(sTime1);
					Long sTimeL=s.stringToLong(sTime1,"yyyy-MM-dd HH:mm");
					pollutant2.setStartingTimeL(sTimeL/1000/60+480);
				}else{
					Long sTimeL=s.stringToLong(startTime,"yyyy-MM-dd HH:mm");
					pollutant2.setStartingTimeL(sTimeL/1000/60+480);
					//pollutant.setStartingTime(startTime);
				}
				Calendar calendar = new GregorianCalendar();  
				/* calendar.set(Calendar.DAY_OF_MONTH, 1);  
			        calendar.getTime()  ;*/
			        // 4.当前月的最后一天  
			        calendar.add(Calendar.MONTH, 1);  
			        calendar.set(Calendar.DAY_OF_MONTH, 0);  
			        Date d2 = calendar.getTime();
				/*Calendar cd = Calendar.getInstance();   
	            cd.setTime(sdf.parse(sTime1));   
	            cd.add(Calendar.DATE, 1);//增加一天 
	            Date d2 = cd.getTime();*/
	            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	            eTime=df.format(d2);
			
				
			
				//Long sTimeL=s.stringToLong(sTime1,"yyyy-MM-dd HH:mm");
				Long eTimeL=s.stringToLong(eTime+" 23:59","yyyy-MM-dd HH:mm");
				//pollutant2.setStartingTimeL(sTimeL/1000/60+480);
				pollutant2.setEndTimeL(eTimeL/1000/60+480);
				
			}
			if(type==6){
				sTime=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
               String sTime1=sTime+"-01-01 00:00";
               String eTime1=sTime+"-12-31 23:59";
				if (sTime1.compareTo(startTime)>0) {
					//pollutant.setStartingTime(sTime1);
					Long sTimeL=s.stringToLong(sTime1,"yyyy-MM-dd HH:mm");
					pollutant2.setStartingTimeL(sTimeL/1000/60+480);
				}else{
					//pollutant.setStartingTime(startTime);
					Long sTimeL=s.stringToLong(startTime,"yyyy-MM-dd HH:mm");
					pollutant2.setStartingTimeL(sTimeL/1000/60+480);
				}
				/*Calendar cd = Calendar.getInstance();   
	            cd.setTime(sdf.parse(sTime1));   
	            cd.add(Calendar.DATE, 1);//增加一天 
	            Date d2 = cd.getTime();
	            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	            eTime=df.format(d2);*/
			//	pollutant.setEndTime(eTime);
				
				
				Long eTimeL=s.stringToLong(eTime1,"yyyy-MM-dd HH:mm");
				pollutant2.setEndTimeL(eTimeL);
			}
			
			
		
			Pollutant pollutants=pollutantBiz.selectByPollutant2(pollutant2);
			
			if(type==3){
				dateTypes=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
				pollutant.setDateTypes(dateTypes);
			}
			if(type==6){
				dateTypes=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
				pollutant.setDateTypes(dateTypes);
			}
			if(type==5){
				Calendar cal1 = Calendar.getInstance(); 
				cal.set(Calendar.HOUR_OF_DAY, 0); 
				cal.set(Calendar.SECOND, 0); 
				cal.set(Calendar.MINUTE, 0); 
				sTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
				cal.set(Calendar.HOUR_OF_DAY, 23); 
				cal.set(Calendar.SECOND, 59); 
				cal.set(Calendar.MINUTE, 59);
				eTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
				
				pollutant.setStartingTime(sTime);
				pollutant.setEndTime(eTime);
			}
			
			
			ViewZtraffic ztraffic2=pollutantBiz.selectByPollutant4(pollutant);
			
			if(type==3){
				sTime=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
				String sTime1;
				if(rid==75501330004l){
					 sTime1=sTime+"-04";
				}else{
					sTime1=sTime+"-01";
				}
				
			
				
				if (sTime1.compareTo(startTime)>0) {
					pollutant.setStartingTime(sTime1);
					Calendar cd = Calendar.getInstance();   
		            cd.setTime(sdfs.parse(sTime1));   
		            cd.add(Calendar.DATE, 1);//增加一天 
		            Date d2 = cd.getTime();
		            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		            eTime=df.format(d2);
					pollutant.setEndTime(eTime);
				}else{
					pollutant.setStartingTime(startTime);
					Calendar cd = Calendar.getInstance();   
		            cd.setTime(sdfs.parse(startTime));   
		            cd.add(Calendar.DATE, 1);//增加一天 
		            Date d2 = cd.getTime();
		            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		            eTime=df.format(d2);
					pollutant.setEndTime(eTime);
				}
				
			}
			if(type==6){
				sTime=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
				String sTime1;
				if(rid==75501330004l){
					 sTime1=sTime+"-08-04";
				}else{
					sTime1=sTime+"-01-01";
				}
	               
					
					if (sTime1.compareTo(startTime)>0) {
						pollutant.setStartingTime(sTime1);
						Calendar cd = Calendar.getInstance();   
			            cd.setTime(sdfs.parse(sTime1));   
			            cd.add(Calendar.DATE, 1);//增加一天 
			            Date d2 = cd.getTime();
			            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			            eTime=df.format(d2);
						pollutant.setEndTime(eTime);
					}else{
						pollutant.setStartingTime(startTime);
						Calendar cd = Calendar.getInstance();   
			            cd.setTime(sdfs.parse(startTime));   
			            cd.add(Calendar.DATE, 1);//增加一天 
			            Date d2 = cd.getTime();
			            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			            eTime=df.format(d2);
						pollutant.setEndTime(eTime);
					}
					
			}
			if(type==5){
				Calendar cal1 = Calendar.getInstance(); 
				cal.set(Calendar.HOUR_OF_DAY, 0); 
				cal.set(Calendar.SECOND, 0); 
				cal.set(Calendar.MINUTE, 0); 
				sTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
				cal.set(Calendar.HOUR_OF_DAY, 23); 
				cal.set(Calendar.SECOND, 59); 
				cal.set(Calendar.MINUTE, 59);
				eTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
				
				pollutant.setStartingTime(sTime);
				pollutant.setEndTime(eTime);
			}
			List<ViewZtraffic> ztraffics=pollutantBiz.selectByPollutant5(pollutant);
			ViewZtraffic ztraffic=new ViewZtraffic();
			if(ztraffics.size()>0){
				 ztraffic=ztraffics.get(0);
			}else{
				ztraffic=null;
			}
			
		Double sub_ztraffic;
		
		if(type==5){
			dateTypes=sTime;
		}
		if(dateTypes.equals("2016")&&ztraffic2!=null){
			 sub_ztraffic=ztraffic2.getDrainageIndustrial()-0;
		}else{
			if(ztraffic2!=null||ztraffic!=null){
				sub_ztraffic=ztraffic2.getDrainageIndustrial()-ztraffic.getDrainageIndustrial();
			}else{
				sub_ztraffic=1.0;
			}
		 
		}
		
		
		
			request.setAttribute("sub_ztraffic", sub_ztraffic);
			request.setAttribute("cod", pollutants.getCod());//COD
			request.setAttribute("bod", pollutants.getBod());//bod
			request.setAttribute("cr6", pollutants.getCr6());//Cr6
			request.setAttribute("phosphor", pollutants.getPhosphor());//ni
			request.setAttribute("mlss", pollutants.getMlss());//固体悬浮物
			request.setAttribute("nh4", pollutants.getNh4());//nh4
			request.setAttribute("cu", pollutants.getCu());//nh4
			
			request.setAttribute("ni", pollutants.getNi());//nh4
			request.setAttribute("zn", pollutants.getZn());//nh4
			
			request.setAttribute("strTime", pollutants.getStrTime());//时间
			request.setAttribute("sTime", sTime);
			request.setAttribute("eTime", eTime);
			request.setAttribute("type", type);
			request.setAttribute("rid", rid);
			StringBuffer webUrl=request.getRequestURL();
			String url=webUrl+"?type="+type;
			request.setAttribute("webUrls", url);
			request.setAttribute("dateTypes", dateTypes);
			request.setAttribute("Companyconfig", viewCompanyconfig);
			
			
			return "water/pollutantList";
		}
		
		Double sub_ztraffic;
		
	if(type==5){
			
			
			
		
			
			Long sTimeL=s.stringToLong(sTime,"yyyy-MM-dd HH:mm");
			Long eTimeL=s.stringToLong(eTime,"yyyy-MM-dd HH:mm");
			pollutant2.setStartingTimeL(sTimeL/1000/60+480);
			pollutant2.setEndTimeL(eTimeL/1000/60+480);
			}
			if(type==3){
				
				/*if (zTime.compareTo(sTime)>0) {
					
				}*/
				
				/* 
				String sTime1=dateTypes+"-01 00:00";
				
				if (sTime1.compareTo(startTime)>0) {
					//pollutant.setStartingTime(sTime1);
					Long sTimeL=s.stringToLong(sTime1,"yyyy-MM-dd HH:mm");
					pollutant2.setStartingTimeL(sTimeL/1000/60+480);
				}else{
					Long sTimeL=s.stringToLong(startTime,"yyyy-MM-dd HH:mm");
					pollutant2.setStartingTimeL(sTimeL/1000/60+480);
					//pollutant.setStartingTime(startTime);
				}
				Calendar calendar = new GregorianCalendar();  
				 calendar.set(Calendar.DAY_OF_MONTH, 1);  
			        calendar.getTime()  ;
			        // 4.当前月的最后一天  
			        calendar.add(Calendar.MONTH, 1);  
			        calendar.set(Calendar.DAY_OF_MONTH, 0);  
			        Date d2 = calendar.getTime();
				Calendar cd = Calendar.getInstance();   
	            cd.setTime(sdf.parse(sTime1));   
	            cd.add(Calendar.DATE, 1);//增加一天 
	            Date d2 = cd.getTime();
	            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	            eTime=df.format(d2);
			
				
			
				//Long sTimeL=s.stringToLong(sTime1,"yyyy-MM-dd HH:mm");
				Long eTimeL=s.stringToLong(eTime+" 23:59","yyyy-MM-dd HH:mm");
				//pollutant2.setStartingTimeL(sTimeL/1000/60+480);
				pollutant2.setEndTimeL(eTimeL/1000/60+480);
				*/
			}
			if(type==6){
              /* String sTime1=dateTypes+"-01-01 00:00";
               String eTime1=dateTypes+"-12-31 23:59";
				if (sTime1.compareTo(startTime)>0) {
					//pollutant.setStartingTime(sTime1);
					Long sTimeL=s.stringToLong(sTime1,"yyyy-MM-dd HH:mm");
					pollutant2.setStartingTimeL(sTimeL/1000/60+480);
				}else{
					//pollutant.setStartingTime(startTime);
					Long sTimeL=s.stringToLong(startTime,"yyyy-MM-dd HH:mm");
					pollutant2.setStartingTimeL(sTimeL);
				}
				Long eTimeL=s.stringToLong(eTime1,"yyyy-MM-dd HH:mm");
				pollutant2.setEndTimeL(eTimeL/1000/60+480);*/
			}
				Pollutant pollutants=pollutantBiz.selectByPollutant2(pollutant2);//基本信息
				
				
				ViewZtraffic ztraffic2=pollutantBiz.selectByPollutant4(pollutant2);
				
				
		if(type==3){
			String sTime11=dateTypes+"-01";
			
			if (sTime11.compareTo(startTime)>0) {
				pollutant.setStartingTime(sTime11);
				Calendar cd = Calendar.getInstance();   
	            cd.setTime(sdfs.parse(sTime11));   
	            cd.add(Calendar.DATE, 1);//增加一天 
	            Date d2 = cd.getTime();
	            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	            eTime=df.format(d2);
				pollutant.setEndTime(eTime);
			}else{
				pollutant.setStartingTime(startTime);
				Calendar cd = Calendar.getInstance();   
	            cd.setTime(sdfs.parse(startTime));   
	            cd.add(Calendar.DATE, 1);//增加一天 
	            Date d2 = cd.getTime();
	            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	            eTime=df.format(d2);
				pollutant.setEndTime(eTime);
			}
		}
		if(type==6){
			
			String sTime11=dateTypes+"-01-01";
			if (sTime11.compareTo(startTime)>0) {
				pollutant.setStartingTime(sTime11);
				Calendar cd = Calendar.getInstance();   
	            cd.setTime(sdfs.parse(sTime11));   
	            cd.add(Calendar.DATE, 1);//增加一天 
	            Date d2 = cd.getTime();
	            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	            eTime=df.format(d2);
				pollutant.setEndTime(eTime);
			}else{
				pollutant.setStartingTime(startTime);
				Calendar cd = Calendar.getInstance();   
	            cd.setTime(sdfs.parse(startTime));   
	            cd.add(Calendar.DATE, 1);//增加一天 
	            Date d2 = cd.getTime();
	            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	            eTime=df.format(d2);
				pollutant.setEndTime(eTime);
			}
			
		}
		
		
		if(type==5){
			dateTypes=sTime;
		}
		
		
		
		List<ViewZtraffic> ztraffics=pollutantBiz.selectByPollutant5(pollutant);
		
		
		
		ViewZtraffic ztraffic=ztraffics.get(0);
		
		
		if(dateTypes.equals("2016")){
			 sub_ztraffic=ztraffic2.getDrainageIndustrial()-0;
		}else{
		 sub_ztraffic=ztraffic2.getDrainageIndustrial()-ztraffic.getDrainageIndustrial();
		}
		StringBuffer webUrl=request.getRequestURL();
		String url=webUrl+"?type="+type;
		request.setAttribute("webUrls", url);
		request.setAttribute("sub_ztraffic", sub_ztraffic);
		request.setAttribute("sTime", sTime);
		request.setAttribute("eTime", eTime);
		request.setAttribute("type", type);
		request.setAttribute("rid", rid);
		request.setAttribute("dateTypes", dateTypes);
		request.setAttribute("Companyconfig", viewCompanyconfig);
		request.setAttribute("pollutant", pollutants);
		request.setAttribute("cod", pollutants.getCod());//COD
		request.setAttribute("bod", pollutants.getBod());//bod
		request.setAttribute("cr6", pollutants.getCr6());//Cr6
		request.setAttribute("phosphor", pollutants.getPhosphor());//ni
		request.setAttribute("mlss", pollutants.getMlss());//固体悬浮物
		request.setAttribute("nh4", pollutants.getNh4());//nh4
		request.setAttribute("cu", pollutants.getCu());//nh4
		
		request.setAttribute("ni", pollutants.getNi());//nh4
		request.setAttribute("zn", pollutants.getZn());//nh4
		
		request.setAttribute("strTime", pollutants.getStrTime());//时间
		
		
		return "water/pollutantList";
	}
	
	
}
