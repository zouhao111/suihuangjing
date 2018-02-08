package com.erich.saleticket.controllers.api.bitou;

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
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.biz.tdht.PollutantBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.controllers.admin.tdht.StringDataLongTime;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.dto.MobileData;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewZtraffic;

public class PollutantController extends BaseController{

	
	@Resource
	private PollutantBiz pollutantBiz;
	@Resource
	private DataBiz dataBiz;
	/**
	 *污染物汇总  
	 */
	@Get("pollutantList")
	@Post("pollutantList")
	public String pollutantList(Pollutant pollutant, HttpServletRequest request, HttpServletResponse response) throws ParseException  {
		MobileData<List<Object>> result = new MobileData<List<Object>>(ApiResultcode._0);
		
		if(pollutant.getRid()==75501330008l){
			pollutant.setRid(75501330008l);
		}else if(pollutant.getRid()==75501330009l){
			pollutant.setRid(75501330009l);
		}else if(pollutant.getRid()==75501330010l){
			pollutant.setRid(75501330010l);
		}else if(pollutant.getRid()==75501330011l){
			pollutant.setRid(75501330011l);
		}else if(pollutant.getRid()==75501330012l){
			pollutant.setRid(75501330012l);
		}else{
			pollutant.setRid(75501330008l);
		}
		
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
			        calendar.add(Calendar.MONTH, 1);  
			        calendar.set(Calendar.DAY_OF_MONTH, 0);  
			        Date d2 = calendar.getTime();
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
				 
				String sTime1=sTime+"-01";
				
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
				 
	               String sTime1=sTime+"-01-01";
					
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
			ViewZtraffic ztraffic=ztraffics.get(0);
			Double sub_ztraffic;
		
		if(type==5){
			dateTypes=sTime;
		}
		if(dateTypes.equals("2016")){
			 sub_ztraffic=ztraffic2.getDrainageIndustrial()-0;
		}else{
			if(ztraffic2!=null||ztraffic!=null){
				sub_ztraffic=ztraffic2.getDrainageIndustrial()-ztraffic.getDrainageIndustrial();
			}else{
				sub_ztraffic=1.0;
			}
		 
		}
			pollutants.setSub_ztraffic(sub_ztraffic);
			pollutants.setCr6(fixed(pollutants.getCr6(), 4));
			pollutants.setCod(fixed(pollutants.getCod(), 2));
			if(rid.toString().equals("75501330004")){
				pollutants.setNh4(-9999.99);
			}else{
				pollutants.setNh4(fixed(pollutants.getNh4(), 2));
			}
			pollutants.setMlss(fixed(pollutants.getMlss(), 2));
			pollutants.setPhosphor(fixed(pollutants.getPhosphor(), 2));
			pollutants.setZn(fixed(pollutants.getZn(), 2));
			pollutants.setCu(fixed(pollutants.getCu(), 2));
			
			List<Object> pollutantsList=new ArrayList<Object>();
			pollutantsList.add(pollutants);
			result.setResult(pollutantsList);
			if(pollutants !=null){
				result.init(ApiResultcode._1, "成功");
			}
	  		 return "@" + encodeJson(result);
			}
			
		Double sub_ztraffic;
		
	if(type==5){
			Long sTimeL=s.stringToLong(sTime,"yyyy-MM-dd HH:mm");
			Long eTimeL=s.stringToLong(eTime,"yyyy-MM-dd HH:mm");
			pollutant2.setStartingTimeL(sTimeL/1000/60+480);
			pollutant2.setEndTimeL(eTimeL/1000/60+480);
			}
			if(type==3){
			}
			if(type==6){
				 String sTime1=dateTypes+"-01-01 00:00";
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
					pollutant2.setEndTimeL(eTimeL/1000/60+480);
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
		pollutants.setSub_ztraffic(sub_ztraffic);
		if(pollutants.getCr6()!=null){
			pollutants.setCr6(fixed(pollutants.getCr6(), 4));
		}else{
			pollutants.setCr6(0.0000);
		}
		if(pollutants.getCod()!=null){
			pollutants.setCod(fixed(pollutants.getCod(), 2));
		}else{
			pollutants.setCod(0.00);
		}
		if(pollutants.getZn()!=null){
			pollutants.setZn(fixed(pollutants.getZn(), 2));
		}else{
			pollutants.setZn(0.00);
		}
		if(pollutants.getCu()!=null){
			pollutants.setCu(fixed(pollutants.getCu(), 2));
		}else{
			pollutants.setCu(0.00);
		}
		if(rid.toString().equals("75501330004")){
			pollutants.setNh4(-9999.99);
		}else{
			if(pollutants.getNh4()!=null){
				pollutants.setNh4(fixed(pollutants.getNh4(), 2));
			}else{
				pollutants.setNh4(0.00);
			}
			
		}
		if(pollutants.getMlss()!=null){
			pollutants.setMlss(fixed(pollutants.getMlss(), 2));
		}else{
			pollutants.setMlss(0.00);
		}
		if(pollutants.getPhosphor()!=null){
			pollutants.setPhosphor(fixed(pollutants.getPhosphor(), 2));
		}else{
			pollutants.setPhosphor(0.00);
		}
		List<Object> pollutantsList=new ArrayList<Object>();
		pollutantsList.add(pollutants);
		result.setResult(pollutantsList);
		if(pollutants !=null){
			result.init(ApiResultcode._1, "成功");
		}
  		 return "@" + encodeJson(result);
		
	}

	
}
