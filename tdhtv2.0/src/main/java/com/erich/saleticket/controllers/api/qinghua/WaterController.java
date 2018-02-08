package com.erich.saleticket.controllers.api.qinghua;

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
import com.erich.saleticket.biz.sys.SysUserBiz;
import com.erich.saleticket.biz.tdht.BalanceBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.biz.tdht.ReportFormBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.dto.MobileData;
import com.erich.saleticket.model.sys.SysUser;
import com.erich.saleticket.model.sys.SysUserCompany;
import com.erich.saleticket.model.tdht.BalanceComfig;
import com.erich.saleticket.model.tdht.Balancea;
import com.erich.saleticket.model.tdht.CompanyInfo;
import com.erich.saleticket.model.tdht.Console;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.Pollutant_Water;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewLineReport;
import com.erich.saleticket.model.tdht.ViewdaliyReport;

public class WaterController extends BaseController{

	
	@Resource
	private ReportFormBiz reportFormBiz;
	@Resource
	private DataBiz dataBiz;
	/**
	 *水量报表
	 */
	@Get("waterFormList222")
	@Post("waterFormList222")
	public String waterFormList(ViewdaliyReport viewdaliyReport, HttpServletRequest request, HttpServletResponse response)   {
		MobileData<List<ViewdaliyReport>> result2 = new MobileData<List<ViewdaliyReport>>(ApiResultcode._0);
		String sTime=viewdaliyReport.getStartingTime();
		String eTime=viewdaliyReport.getEndTime();
		Integer minates=5;
		Integer type=11;//查询日期类型
		Long rid=viewdaliyReport.getRid();//公司ID
		String dateType=viewdaliyReport.getDateTypes();
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
		viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
		BalanceComfig comfig=new BalanceComfig();
		comfig.setRid(rid);
		
		if(sTime==null  & dateType==null){
			minates=5;
			int offset = SystemContext.getOffset();
			
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
				Calendar cal2 = Calendar.getInstance(); 
				  cal2.add(Calendar.DATE,   -1);
				  dateType=(new SimpleDateFormat("yyyy-MM-dd")).format(cal2.getTime()); 
				  comfig.setqStTime(dateType);
				  viewdaliyReport.setDateTypes(dateType);
			}
			if(type==3){
				
				cal.set(Calendar.DAY_OF_MONTH, 1); 
				String  firstDate = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
				 comfig.setqStTime(firstDate);
				dateType=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
				viewdaliyReport.setDateTypes(dateType);
			}
			if(type==6){
				
				
				dateType=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
				if(dateType.toString().equals("2016")){
					Date  sTime1=viewCompanyconfig.getStratTime();	
					sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
					 comfig.setqStTime(sTime);
				}else{
					cal.set(Calendar.MONTH, 1); 
					cal.set(Calendar.DAY_OF_MONTH, 1); 
					String  firstDate = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
					 comfig.setqStTime(firstDate);
					 
				}
				viewdaliyReport.setDateTypes(dateType);
			}
			if(type==5){
				
			Date  sTime1=viewCompanyconfig.getStratTime();
				
		
			sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
				 comfig.setqStTime(sTime);
					
				eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
				  viewdaliyReport.setStartingTime(sTime);
				  viewdaliyReport.setEndTime(eTime);
				request.setAttribute("eTime", eTime);
				request.setAttribute("sTime", sTime);
				
			}else if(type==11){
				viewdaliyReport.setStartingTime(sTime);
				viewdaliyReport.setEndTime(eTime);
			}
				
		}else{
			if(type==1){
				comfig.setqStTime(dateType);
			}
              if(type==3){
            	 String  dateType1=dateType+"-01";
				 comfig.setqStTime(dateType1);
				 
				viewdaliyReport.setDateTypes(dateType);
			}
              if(type==6){
            	 
  				
  				
  				if(dateType.toString().equals("2016")){
  					Date  sTime1=viewCompanyconfig.getStratTime();	
  					sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
  					 comfig.setqStTime(sTime);
  				}else{
  					
  				String	dateType1=dateType+"-01-01";
  				comfig.setqStTime(dateType1);
  				}
  				viewdaliyReport.setDateTypes(dateType);
  			}
              if(type==5){
            	  comfig.setqStTime(sTime);  
              }
		}	
		
	if(type!=11){
			
			String viewName="daliy_6";//日统计
			viewdaliyReport.setViewName(viewName);
			int i=reportFormBiz.insertBalanceTime(comfig);
			if(i>0){
			
			
			List<ViewdaliyReport> waters = reportFormBiz.selectByCriteria_pdf(viewdaliyReport);
			
              List<String>sytime=new ArrayList<String>();//系统时间
			
			for(int i1=0;i1<waters.size();i1++){
				String[] split = waters.get(i1).getStrTime().toString().split("\\s+");
				waters.get(i1).setStrTime1(split[0]);
				waters.get(i1).setIndustrialsupply(fixed(waters.get(i1).getIndustrialsupply(), 2)) ;
				waters.get(i1).setLivingsupply(fixed(waters.get(i1).getLivingsupply(), 2));
				waters.get(i1).setIndustrialdrainage( fixed(waters.get(i1).getIndustrialdrainage(),2));
				waters.get(i1).setWastage(fixed(waters.get(i1).getWastage(),2));
				waters.get(i1).setUnknown(fixed(waters.get(i1).getUnknown(), 2));
			}
			
			//result2.setWaterss(waters);
			
			result2.setResult(waters);
			 result2.init(ApiResultcode._1, "成功");
			return "@" + encodeJson(result2);
			}
			return null;
		}else{
			MobileData<List<ViewLineReport>> result = new MobileData<List<ViewLineReport>>(ApiResultcode._0);
			String viewName="min_report";//历史统计
			viewdaliyReport.setViewName(viewName);	
			viewdaliyReport.setMinates(minates);
			
			if(minates==1440){
				 SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");  
			        Date date = null;  
			        try {
						date = formatter.parse(viewdaliyReport.getStartingTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}  
			      long ts=( date.getTime() - 60000 * date.getTimezoneOffset())/1000/60;
			      int times= (int)(ts%1440);
				viewdaliyReport.setRemainder(times);
			}else{
				viewdaliyReport.setRemainder(0);
			}
			
			
			List<ViewLineReport> waters = reportFormBiz.selectByCriterias_pdf(viewdaliyReport);
			
			/*for(int i=0;i<waters.size();i++){
				waters.get(i).setTabZtrafficIS1(fixed(waters.get(i).getTabZtrafficIS1(), 2) );
				waters.get(i).setTabZtrafficDS1(fixed(waters.get(i).getTabZtrafficDS1(), 2) );
				waters.get(i).setTabZtrafficID1(fixed(waters.get(i).getTabZtrafficID1(), 2) );
			}*/
			
			result.setResult(waters);
			 result.init(ApiResultcode._1, "成功");
			return "@" + encodeJson(result);
			
		}
	}

	
	@Get("qualityFormList222")
	@Post("qualityFormList222")
	public String qualityFormList(ViewdaliyReport data, HttpServletRequest request, HttpServletResponse response)   {
		MobileData<List<Pollutant>> result = new MobileData<List<Pollutant>>(ApiResultcode._0);
		Long rid =data.getRid();
		CompanyInfo com = new CompanyInfo();
		com.setCompany_id(rid);
		String sTime=data.getStartingTime();
		String eTime=data.getEndTime();
		Integer minates=5;
		Integer type=11;
		Integer form =data.getForm();
		String dateTypes=data.getDateTypes();
		
		if(sTime==null  & dateTypes==null){
			minates=5;
			int offset = SystemContext.getOffset();
			
			Calendar cal = Calendar.getInstance(); 
			cal.set(Calendar.HOUR_OF_DAY, 0); 
			cal.set(Calendar.SECOND, 0); 
			cal.set(Calendar.MINUTE, 0); 
			sTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
			cal.set(Calendar.HOUR_OF_DAY, 23); 
			cal.set(Calendar.SECOND, 59); 
			cal.set(Calendar.MINUTE, 59);
			eTime = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(cal.getTime()); 
			if(type==1){
				Calendar cal2 = Calendar.getInstance(); 
				  cal2.add(Calendar.DATE,   -1);
				dateTypes=(new SimpleDateFormat("yyyy-MM-dd")).format(cal2.getTime()); 
				data.setDateTypes(dateTypes);
			}
			if(type==3){
				dateTypes=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
				data.setDateTypes(dateTypes);
			}
			if(type==6){
				dateTypes=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
				data.setDateTypes(dateTypes);
			}
			if(type==5){
				Calendar cal2 = Calendar.getInstance(); 
				  cal2.add(Calendar.DATE,   -7);
				  sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal2.getTime()); 
				  eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
				
				data.setStartingTime(sTime);
				data.setEndTime(eTime);
				request.setAttribute("eTime", eTime);
				request.setAttribute("sTime", sTime);
			}else if(type==11){
				data.setStartingTime(sTime);
				data.setEndTime(eTime);
			}
		
		}
		String url=null;
		
		if(type!=11){
			String viewName="daily_report3";//日统计
			data.setViewName(viewName);
			ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
			viewCompanyconfig.setRid(rid);
			viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
			List<Pollutant> datass = reportFormBiz.selectByCriteria2_pdf(data);
            List<String>sytime=new ArrayList<String>();//系统时间
			for(int i=0;i<datass.size();i++){
				String[] split = datass.get(i).getStrTime().toString().split("\\s+");
				datass.get(i).setStrTime1(split[0]);

				datass.get(i).setMinph(fixed(datass.get(i).getMinph(), 2));
				datass.get(i).setMaxph(fixed(datass.get(i).getMaxph(), 2));
				datass.get(i).setMincod(fixed(datass.get(i).getMincod(), 2));
				datass.get(i).setMaxcod(fixed(datass.get(i).getMaxcod(), 2));
				if(rid.toString().equals("75501330004")){
					datass.get(i).setMinnh4(-9999.99);
					datass.get(i).setMaxnh4(-9999.99);
				}else{
					datass.get(i).setMinnh4(fixed(datass.get(i).getMinnh4(), 2));
					datass.get(i).setMaxnh4(fixed(datass.get(i).getMaxnh4(), 2));
				}
				datass.get(i).setMincr6(fixed(datass.get(i).getMincr6(), 4));
				datass.get(i).setMaxcr6(fixed(datass.get(i).getMaxcr6(), 4));
				datass.get(i).setMinconductivity(fixed(datass.get(i).getMinconductivity(), 2));
				datass.get(i).setMaxconductivity(fixed(datass.get(i).getMaxconductivity(), 2));
				datass.get(i).setMinmlss(fixed(datass.get(i).getMinmlss(), 2));
				datass.get(i).setMaxmlss(fixed(datass.get(i).getMaxmlss(), 2));
				datass.get(i).setMinphosphor(fixed(datass.get(i).getMinphosphor(), 2));
				datass.get(i).setMaxphosphor(fixed(datass.get(i).getMaxphosphor(), 2));
			}
			result.setResult(datass);
			 result.init(ApiResultcode._1, "成功");
			return "@" + encodeJson(result);
		}else{
			String viewName="min_report";//历史统计
			data.setViewName(viewName);	
			data.setMinates(minates);
			
			if(minates==1440){
				 SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");  
			        Date date = null;  
			        try {
						date = formatter.parse(data.getStartingTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}  
			      long ts=( date.getTime() - 60000 * date.getTimezoneOffset())/1000/60;
			      int times= (int)(ts%1440);
			      data.setRemainder(times);
			}else{
				data.setRemainder(0);
			}
			
	
			ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
			viewCompanyconfig.setRid(rid);
			viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
		
			List<Pollutant> datass = reportFormBiz.selectByCriteria3_pdf(data);
			for(int i=0;i<datass.size();i++){
				datass.get(i).setRealph(fixed(datass.get(i).getRealph(), 2));
				datass.get(i).setRealcod(fixed(datass.get(i).getRealcod(), 2));
				if(rid.toString().equals("75501330004")){
					datass.get(i).setRealnh4(-9999.99);
				}else{
					datass.get(i).setRealnh4(fixed(datass.get(i).getRealnh4(), 2));
				}
				
				datass.get(i).setRealcr6(fixed(datass.get(i).getRealcr6(), 4));
				datass.get(i).setRealconductivity(fixed(datass.get(i).getRealconductivity(), 2));
				datass.get(i).setRealmlss(fixed(datass.get(i).getRealmlss(), 2));
				datass.get(i).setRealphosphor(fixed(datass.get(i).getRealphosphor(), 2));
			}
			
				result.setResult(datass);
				 result.init(ApiResultcode._1, "成功");
				return "@" + encodeJson(result);
		}
		
	}
	
}