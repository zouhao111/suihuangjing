package com.erich.saleticket.biz.tdht;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erich.easyframe.common.utils.CacheUtils;
import com.erich.saleticket.dao.tdht.CurveReportDAO;
import com.erich.saleticket.model.tdht.CompanyInfo;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.Pollutant_Water;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewData;
import com.erich.saleticket.model.tdht.ViewLineReport;
import com.erich.saleticket.model.tdht.ViewZtraffic;

@Service
public class CurveReportBiz {

	@Resource
	private CurveReportDAO curveReportDAO;
	
	
public Object selectByCriterias1(final ViewLineReport data){
		
		Object   cacheValue=CacheUtils.getCache("datasss1");//获取缓存KEY为phwarnings的值
		if(cacheValue==null){//判断缓存区域这个值是不是空
			List<ViewLineReport> datas=curveReportDAO.selectByCriteria(data);
			List<Pollutant> datass=curveReportDAO.selectByCriteria_ph(data);
			List<Object>datasss=new ArrayList<Object>();
			  datasss.add(datas);
			  datasss.add(datass);
			CacheUtils.addCache("datasss1", datasss);//没有查出来后添加进缓存区
			 // 启动定时器线程，并在10000毫秒后开始，每隔3000毫秒执行一次定时任务
			  new Timer().schedule(new TimerTask() {// 定时任务
		            @Override
		            public void run() {
		            	Calendar cal= Calendar.getInstance();
		            	String sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
						Calendar cal3 = Calendar.getInstance(); 
						  cal3.add(Calendar.DATE,   +1);
						  String eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
						data.setStartingTime(sTime);
						data.setEndTime(eTime);
		            	
		            	
		            	List<ViewLineReport> data1=curveReportDAO.selectByCriteria(data);
		    			List<Pollutant> data2=curveReportDAO.selectByCriteria_ph(data);
		    			List<Object>data3=new ArrayList<Object>();
		    			  data3.add(data1);
		    			  data3.add(data2);
		                CacheUtils.addCache("datasss1", data3);
		            }
		        }, 10000, 60000);
			return datasss;
		}
		return cacheValue;//有就返回缓存区域的值
	}
	
public Object selectByCriterias2(final ViewLineReport data){
	
	Object   cacheValue=CacheUtils.getCache("datasss2");//获取缓存KEY为phwarnings的值
	if(cacheValue==null){//判断缓存区域这个值是不是空
		List<ViewLineReport> datas=curveReportDAO.selectByCriteria(data);
		List<Pollutant> datass=curveReportDAO.selectByCriteria_ph(data);
		List<Object>datasss=new ArrayList<Object>();
		  datasss.add(datas);
		  datasss.add(datass);
		CacheUtils.addCache("datasss2", datasss);//没有查出来后添加进缓存区
		 // 启动定时器线程，并在10000毫秒后开始，每隔3000毫秒执行一次定时任务
		  new Timer().schedule(new TimerTask() {// 定时任务
	            @Override
	            public void run() {
	            	Calendar cal= Calendar.getInstance();
	            	String sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
					Calendar cal3 = Calendar.getInstance(); 
					  cal3.add(Calendar.DATE,   +1);
					  String eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
					data.setStartingTime(sTime);
					data.setEndTime(eTime);
	            	List<ViewLineReport> data1=curveReportDAO.selectByCriteria(data);
	    			List<Pollutant> data2=curveReportDAO.selectByCriteria_ph(data);
	    			List<Object>data3=new ArrayList<Object>();
	    			  data3.add(data1);
	    			  data3.add(data2);
	                CacheUtils.addCache("datasss2", data3);
	            }
	        }, 10000, 60000);
		return datasss;
	}
	return cacheValue;//有就返回缓存区域的值
}
public Object selectByCriterias3(final ViewLineReport data){
	
	Object   cacheValue=CacheUtils.getCache("datasss3");//获取缓存KEY为phwarnings的值
	if(cacheValue==null){//判断缓存区域这个值是不是空
		List<ViewLineReport> datas=curveReportDAO.selectByCriteria(data);
		List<Pollutant> datass=curveReportDAO.selectByCriteria_ph(data);
		List<Object>datasss=new ArrayList<Object>();
		  datasss.add(datas);
		  datasss.add(datass);
		CacheUtils.addCache("datasss3", datasss);//没有查出来后添加进缓存区
		 // 启动定时器线程，并在10000毫秒后开始，每隔3000毫秒执行一次定时任务
		  new Timer().schedule(new TimerTask() {// 定时任务
	            @Override
	            public void run() {
	            	Calendar cal= Calendar.getInstance();
	            	String sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
					Calendar cal3 = Calendar.getInstance(); 
					  cal3.add(Calendar.DATE,   +1);
					  String eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
					data.setStartingTime(sTime);
					data.setEndTime(eTime);
	            	List<ViewLineReport> data1=curveReportDAO.selectByCriteria(data);
	    			List<Pollutant> data2=curveReportDAO.selectByCriteria_ph(data);
	    			List<Object>data3=new ArrayList<Object>();
	    			  data3.add(data1);
	    			  data3.add(data2);
	                CacheUtils.addCache("datasss3", data3);
	            }
	        }, 10000, 60000);
		return datasss;
	}
	return cacheValue;//有就返回缓存区域的值
}
public Object selectByCriterias4(final ViewLineReport data){
	
	Object   cacheValue=CacheUtils.getCache("datasss4");//获取缓存KEY为phwarnings的值
	if(cacheValue==null){//判断缓存区域这个值是不是空
		List<ViewLineReport> datas=curveReportDAO.selectByCriteria(data);
		List<Pollutant> datass=curveReportDAO.selectByCriteria_ph(data);
		List<Object>datasss=new ArrayList<Object>();
		  datasss.add(datas);
		  datasss.add(datass);
		CacheUtils.addCache("datasss4", datasss);//没有查出来后添加进缓存区
		 // 启动定时器线程，并在10000毫秒后开始，每隔3000毫秒执行一次定时任务
		  new Timer().schedule(new TimerTask() {// 定时任务
	            @Override
	            public void run() {
	            	Calendar cal= Calendar.getInstance();
	            	String sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
					Calendar cal3 = Calendar.getInstance(); 
					  cal3.add(Calendar.DATE,   +1);
					  String eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
					data.setStartingTime(sTime);
					data.setEndTime(eTime);
	            	List<ViewLineReport> data1=curveReportDAO.selectByCriteria(data);
	    			List<Pollutant> data2=curveReportDAO.selectByCriteria_ph(data);
	    			List<Object>data3=new ArrayList<Object>();
	    			  data3.add(data1);
	    			  data3.add(data2);
	                CacheUtils.addCache("datasss4", data3);
	            }
	        }, 10000, 60000);
		return datasss;
	}
	return cacheValue;//有就返回缓存区域的值
}
public Object selectByCriterias5(final ViewLineReport data){
	
	Object   cacheValue=CacheUtils.getCache("datasss5");//获取缓存KEY为phwarnings的值
	if(cacheValue==null){//判断缓存区域这个值是不是空
		List<ViewLineReport> datas=curveReportDAO.selectByCriteria(data);
		List<Pollutant> datass=curveReportDAO.selectByCriteria_ph(data);
		List<Object>datasss=new ArrayList<Object>();
		  datasss.add(datas);
		  datasss.add(datass);
		CacheUtils.addCache("datasss5", datasss);//没有查出来后添加进缓存区
		 // 启动定时器线程，并在10000毫秒后开始，每隔3000毫秒执行一次定时任务
		  new Timer().schedule(new TimerTask() {// 定时任务
	            @Override
	            public void run() {
	            	Calendar cal= Calendar.getInstance();
	            	String sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
					Calendar cal3 = Calendar.getInstance(); 
					  cal3.add(Calendar.DATE,   +1);
					  String eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal3.getTime());
					data.setStartingTime(sTime);
					data.setEndTime(eTime);
	            	List<ViewLineReport> data1=curveReportDAO.selectByCriteria(data);
	    			List<Pollutant> data2=curveReportDAO.selectByCriteria_ph(data);
	    			List<Object>data3=new ArrayList<Object>();
	    			  data3.add(data1);
	    			  data3.add(data2);
	                CacheUtils.addCache("datasss5", data3);
	            }
	        }, 10000, 60000);
		return datasss;
	}
	return cacheValue;//有就返回缓存区域的值
}
	
//**********************************************************************************************************	selectByCriteria_water
public List<ViewLineReport> selectByCriteria_water(ViewLineReport data){
	List<ViewLineReport>ww=	curveReportDAO.selectByCriteria_water(data);
	return ww;
}
public List<Pollutant_Water> selectByCriteria_waterph(ViewLineReport data){
	List<Pollutant_Water>ww=	curveReportDAO.selectByCriteria_waterph(data);
	return ww;
}
	
	public List<ViewLineReport> selectByCriteria(ViewLineReport data){
		List<ViewLineReport>ww=	curveReportDAO.selectByCriteria(data);
		return ww;
	}

	public List<ViewLineReport> selectByCriteriaNew(ViewLineReport data){
		List<ViewLineReport>ww=	curveReportDAO.selectByCriteriaNew(data);
		return ww;
	}
	
	public List<Pollutant> selectByCriteria_poll(ViewLineReport data){
		return curveReportDAO.selectByCriteria_poll(data);
	}
	public List<Pollutant> selectByCriteria_ph(ViewLineReport data){
		return curveReportDAO.selectByCriteria_ph(data);
	}
	public List<Pollutant> selectByCriteria_phnew(ViewLineReport data){
		return curveReportDAO.selectByCriteria_phnew(data);
	}
	
	public List<ViewZtraffic> selectByCriteria2(ViewLineReport data){
		return curveReportDAO.selectByCriteria2(data);
	}
	public List<ViewZtraffic> selectByCriteriass(ViewLineReport data){
		return curveReportDAO.selectByCriteriass(data);
	}
	
	
	public List<Pollutant> selectByPollutant(Pollutant data){
		return curveReportDAO.selectByPollutant(data);
	}
	//查询各个公司污染物的种类
	public List<Pollutant> selectByPollutant_name(Pollutant data){
		return curveReportDAO.selectByPollutant_name(data);
	}
	//查询各个公司污染物的种类
	public List<Pollutant> selectByPollutant_Pollnames(Pollutant data){
		return curveReportDAO.selectByPollutant_Pollnames(data);
	}
	//查询各个公司污染物的种类
		public List<Pollutant> selectByPollutant_Pollname_cur(Pollutant data){
			return curveReportDAO.selectByPollutant_Pollname_cur(data);
		}
		//查询各个公司污染物的种类
				public List<Pollutant> selectByPollutant_Pollname(Pollutant data){
					return curveReportDAO.selectByPollutant_Pollname(data);
				}
		//查询各个公司污染物的种类
				public List<Pollutant> selectByPollutant_Poll(){
					return curveReportDAO.selectByPollutant_Poll();
				}
	public ViewCompanyconfig  selectCompanyName2(CompanyInfo com){
		return curveReportDAO.selectCompanyName2(com);
	}
	public CompanyInfo selectCompanyName(CompanyInfo com){
		return curveReportDAO.selectCompanyName(com);
	}
	//小时流量List<Pollutant> selecthourPollutant(Pollutant data);

	public List<ViewZtraffic> selecthourztraffic(ViewLineReport data){
		return curveReportDAO.selecthourztraffic(data);
	}
	public List<ViewZtraffic> selecthourztraffics(ViewLineReport data){
		return curveReportDAO.selecthourztraffics(data);
	}
	//小时流量List<Pollutant> selecthourPollutant(Pollutant data);

	public List<Pollutant> selecthourPollutant(Pollutant data){
		return curveReportDAO.selecthourPollutant(data);
	}
	public List<Pollutant> selecthourPollutant_day(Pollutant data){
		return curveReportDAO.selecthourPollutant_day(data);
	}
	public List<Pollutant> selecthourPollutant_month(Pollutant data){
		return curveReportDAO.selecthourPollutant_month(data);
	}
}
