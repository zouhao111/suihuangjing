package com.erich.saleticket.controllers.admin.tdht;


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

import com.erich.easyframe.util.SystemContext;
import com.erich.saleticket.biz.tdht.CurveReportBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.biz.tdht.ReportFormBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.model.sys.SysUserCompany;
import com.erich.saleticket.model.tdht.CompanyInfo;
import com.erich.saleticket.model.tdht.Console;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.Pollutant_Water;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewData;
import com.erich.saleticket.model.tdht.ViewLineReport;
import com.erich.saleticket.model.tdht.ViewdaliyReport;

/**
 * 统计报表控制器
 * @author Lv
 */
public class ReportFormController extends BaseController {

	
	@Resource
	private ReportFormBiz reportFormBiz;
	@Resource
	private DataBiz dataBiz;
	@Resource
	private CurveReportBiz curveReportBiz;
	/**
	 * 统计报表查询列表
	 */
	Data<Console> result2 = new Data<Console>(ApiResultcode._0);
	public String reportFormList_pdf(ViewdaliyReport data, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		
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
			Pollutant data1=new Pollutant();
			data1.setRid(rid);
			List<Pollutant> data_name=curveReportBiz.selectByPollutant_name(data1);
			List<Pollutant> data_name1=new ArrayList<Pollutant>();
			for(int i=0;i<data_name.size();i++){
				Pollutant p=new Pollutant();
				p.setPollType(data_name.get(i).getPollType());
				data_name1.add(i, p);
			}
			List<Pollutant> datass = reportFormBiz.selectByCriteria2_pdf(data);
            List<String>sytime=new ArrayList<String>();//系统时间
			
			for(int i=0;i<datass.size();i++){
			
				String[] split = datass.get(i).getStrTime().toString().split("\\s+");
				datass.get(i).setStrTime1(split[0]);

			}
			
			List<Object>list=new ArrayList<Object>();
			list.add(0, datass);
			
			list.add(1, viewCompanyconfig);
			list.add(2, data_name1);
			result2.setList(list);
			
			 result2.init(ApiResultcode._1, "成功");
			return "@" + encodeJson(result2);
		}else{
			
			
			
			
			
			
			
			String viewName="min_report";//历史统计
			data.setViewName(viewName);	
			data.setMinates(minates);
			if(minates==1440){
				
				 SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");  
			        Date date = null;  
			        date = formatter.parse(data.getStartingTime());  
			      long ts=( date.getTime() - 60000 * date.getTimezoneOffset())/1000/60;
			      int times= (int)(ts%1440);
			      data.setRemainder(times);
			}else{
				data.setRemainder(0);
			}
			ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
			viewCompanyconfig.setRid(rid);
			viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
			Pollutant data1=new Pollutant();
			data1.setRid(rid);
			List<Pollutant> data_name=curveReportBiz.selectByPollutant_name(data1);
			List<Pollutant> data_name1=new ArrayList<Pollutant>();
			for(int i=0;i<data_name.size();i++){
				Pollutant p=new Pollutant();
				p.setPollType(data_name.get(i).getPollType());
				data_name1.add(i, p);
			}
			
			
		
			List<Pollutant> datass = reportFormBiz.selectByCriteria3_pdf(data);
			
				List<Object>list=new ArrayList<Object>();
				list.add(0, datass);
				
				list.add(1, viewCompanyconfig);
				list.add(2, data_name1);
				result2.setList(list);
				 result2.init(ApiResultcode._1, "成功");
				return "@" + encodeJson(result2);
		}
		
	}
	/**
	 * 统计报表查询列表
	 * @throws ParseException 
	 */
	public String reportFormList(ViewdaliyReport data, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		
		Long rid =data.getRid();
		CompanyInfo com = new CompanyInfo();
		com.setCompany_id(rid);
		String sTime=data.getStartingTime();
		String eTime=data.getEndTime();
		Integer minates=data.getMinates();
		Integer type=data.getType();
		Integer form =data.getForm();
		String dateTypes=data.getDateTypes();
		String  month=data.getLat();//获取是查询前月还是后月
		
		if(month != null){
			try {
				if(month.equals("前月")){
					DateFormat df = new SimpleDateFormat("yyyy-MM");
					 Date d1 = df.parse(dateTypes);
					 Calendar  g = Calendar.getInstance();
					 g.setTime(d1);  
					 g.add(Calendar.MONTH,-1);
					 Date d2 = g.getTime();
					 dateTypes=df.format(d2);
					 data.setDateTypes(dateTypes);
				}
				if(month.equals("后月")){
					DateFormat df = new SimpleDateFormat("yyyy-MM");
					 Date d1 = df.parse(dateTypes);
					 Calendar  g = Calendar.getInstance();
					 g.setTime(d1);  
					 g.add(Calendar.MONTH,+1);
					 Date d2 = g.getTime();
					 dateTypes=df.format(d2);
					 data.setDateTypes(dateTypes);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
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
			int offset = SystemContext.getOffset();
			int pagesize = SystemContext.getPagesize();
			
			ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
			viewCompanyconfig.setRid(rid);
			viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
			data.getPager().setPageOffset(offset);
			data.getPager().setPageSize(pagesize);
			data.getPager().setOrderField("user_id");
			data.getPager().setOrderDirection(false);
			data.getPager().setRowCount(reportFormBiz.selectCountDay(data));
			request.setAttribute("pager", data.getPager());
			//List<ViewdaliyReport> datas = reportFormBiz.selectByCriteria(data);
			List<Pollutant> datass = reportFormBiz.selectByCriterias(data);
			Pollutant data1=new Pollutant();
			data1.setRid(rid);
			List<Pollutant> data_name=curveReportBiz.selectByPollutant_name(data1);
			List<Pollutant> data_name1=new ArrayList<Pollutant>();
			for(int i=0;i<data_name.size();i++){
				Pollutant p=new Pollutant();
				p.setPollType(data_name.get(i).getPollType());
				data_name1.add(i, p);
			}
			request.setAttribute("data_name1", data_name1);
			request.setAttribute("size", data_name1.size());
			request.setAttribute("datass", datass);
			request.setAttribute("dateTypes", dateTypes);
			request.setAttribute("type", type);
			if(type==5){
				request.setAttribute("eTime", eTime);
				request.setAttribute("sTime", sTime);
			}
			request.setAttribute("rid", rid);
			request.setAttribute("Companyconfig", viewCompanyconfig);
			StringBuffer webUrl=request.getRequestURL();
			String url2=webUrl+"?type="+type;
			request.setAttribute("webUrls", url2);
			return "report/reportList";
		}else{
			
			
			String viewName="min_report";//历史统计
			data.setViewName(viewName);	
			data.setMinates(minates);
			if(minates==1440){
				
				 SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");  
			        Date date = null;  
			        date = formatter.parse(data.getStartingTime());  
			      long ts=( date.getTime() - 60000 * date.getTimezoneOffset())/1000/60;
			      int times= (int)(ts%1440);
			      data.setRemainder(times);
			}else{
				data.setRemainder(0);
			}
			SysUserCompany sysUserCompany=getUserCompany(request);
			if(sysUserCompany.getCompanyId()==2000){
				int offset = SystemContext.getOffset();
				int pagesize = SystemContext.getPagesize();
				
				ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
				viewCompanyconfig.setRid(rid);
				viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
				data.getPager().setPageOffset(offset);
				data.getPager().setPageSize(pagesize);
				data.getPager().setOrderField("user_id");
				data.getPager().setOrderDirection(false);
				data.getPager().setRowCount(reportFormBiz.selectCount_water(data));
				request.setAttribute("pager", data.getPager());
				
				Pollutant data1=new Pollutant();
				data1.setRid(rid);
				List<Pollutant> data_name=curveReportBiz.selectByPollutant_name(data1);
				List<Pollutant_Water> datass = reportFormBiz.selectByCriteria_water(data);
				
				//request.setAttribute("datas", datas);
				request.setAttribute("datass", datass);
				request.setAttribute("data_name", data_name);
				request.setAttribute("size", data_name.size());
				request.setAttribute("minates", minates);
				request.setAttribute("dateTypes", dateTypes);
				request.setAttribute("type", type);
				request.setAttribute("rid", rid);
				request.setAttribute("eTime", eTime);
				request.setAttribute("sTime", sTime);
				request.setAttribute("Companyconfig", viewCompanyconfig);
				StringBuffer webUrl=request.getRequestURL();
				String url2=webUrl+"?type="+type;
				request.setAttribute("webUrls", url2);
				return "report/reportList_water";
			}else{
				int offset = SystemContext.getOffset();
				int pagesize = SystemContext.getPagesize();
				
				ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
				viewCompanyconfig.setRid(rid);
				viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
				data.getPager().setPageOffset(offset);
				data.getPager().setPageSize(pagesize);
				data.getPager().setOrderField("user_id");
				data.getPager().setOrderDirection(false);
				data.getPager().setRowCount(reportFormBiz.selectCount(data));
				request.setAttribute("pager", data.getPager());
				Pollutant data1=new Pollutant();
				data1.setRid(rid);
				List<Pollutant> data_name=curveReportBiz.selectByPollutant_name(data1);
				List<Pollutant> data_name1=new ArrayList<Pollutant>();
				for(int i=0;i<data_name.size();i++){
					Pollutant p=new Pollutant();
					p.setPollType(data_name.get(i).getPollType());
					data_name1.add(i, p);
				}
			List<Pollutant> datass = reportFormBiz.selectByCriteria3(data);
			
			//request.setAttribute("datas", datas);
			request.setAttribute("datass", datass);
			//request.setAttribute("datasss", datasss);
			request.setAttribute("minates", minates);
			request.setAttribute("dateTypes", dateTypes);
			request.setAttribute("type", type);
			request.setAttribute("rid", rid);
			request.setAttribute("eTime", eTime);
			request.setAttribute("sTime", sTime);
			request.setAttribute("data_name1", data_name1);
			request.setAttribute("size", data_name1.size());
			request.setAttribute("Companyconfig", viewCompanyconfig);
			StringBuffer webUrl=request.getRequestURL();
			String url2=webUrl+"?type="+type;
			request.setAttribute("webUrls", url2);
			return "report/reportList";
			}
			
		}
		
	}
	
}
