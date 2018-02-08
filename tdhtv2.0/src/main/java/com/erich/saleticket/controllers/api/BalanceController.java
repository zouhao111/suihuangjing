package com.erich.saleticket.controllers.api;

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
import com.erich.saleticket.biz.tdht.BalanceBiz;
import com.erich.saleticket.biz.tdht.BalanceWaterBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.biz.tdht.ReportFormBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.MobileData;
import com.erich.saleticket.model.tdht.BalanceComfig;
import com.erich.saleticket.model.tdht.BalanceWater;
import com.erich.saleticket.model.tdht.Balancea;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewLineReport;

public class BalanceController extends BaseController{

	
	@Resource
	private BalanceBiz balanceBiz;
	@Resource
	private  ReportFormBiz reportFormBiz;
	@Resource
	private DataBiz dataBiz;
	@Resource
	private BalanceWaterBiz balanceBizs;
	
	/**
	 *水平衡分析
	 */
	@Get("balanceList")
	@Post("balanceList")
	public String balanceList(Balancea balancea, HttpServletRequest request, HttpServletResponse response)   {
		MobileData<List<Object>> result = new MobileData<List<Object>>(ApiResultcode._0);

		
		String sTime=balancea.getStartingTime();
		String eTime=balancea.getEndTime();
		Integer type=balancea.getType();//查询日期类型
		Long rid=balancea.getRid();//公司ID
		String dateTypes=balancea.getDateTypes();
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
		viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID查公司名
		BalanceComfig comfig=new BalanceComfig();
		comfig.setRid(rid);
		
		BalanceWater balance=new BalanceWater();
		balance.setRid(rid);
		
		
		if(sTime==null  & dateTypes==null){
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
			
			dateTypes=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()); 
			//ViewdaliyReport.setMinates(5);
			
			if(type==1){
				Calendar cal2 = Calendar.getInstance(); 
				  cal2.add(Calendar.DATE,   -1);
				  dateTypes=(new SimpleDateFormat("yyyy-MM-dd")).format(cal2.getTime()); 
				  comfig.setqStTime(dateTypes);
				  balancea.setDateTypes(dateTypes);
				  balance.setDateTypes(dateTypes);
			}
			if(type==3){
				cal.set(Calendar.DAY_OF_MONTH, 1); 
				String  firstDate = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
				 comfig.setqStTime(firstDate);
				 dateTypes=(new SimpleDateFormat("yyyy-MM")).format(cal.getTime()); 
				 balancea.setDateTypes(dateTypes);
				  balance.setDateTypes(dateTypes);
			}
			if(type==6){
				dateTypes=(new SimpleDateFormat("yyyy")).format(cal.getTime()); 
				if(dateTypes.toString().equals("2016")){
					Date  sTime1=viewCompanyconfig.getStratTime();	
					sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
					 comfig.setqStTime(sTime);
				}else{
					cal.set(Calendar.MONTH, 1); 
					cal.set(Calendar.DAY_OF_MONTH, 1); 
					String  firstDate = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
					 comfig.setqStTime(firstDate);
				}
				balancea.setDateTypes(dateTypes);
			}
			if(type==5){
				
			Date  sTime1=viewCompanyconfig.getStratTime();
			
			sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
				 comfig.setqStTime(sTime);
				eTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
				balancea.setStartingTime(sTime);
				balancea.setEndTime(eTime);
				request.setAttribute("eTime", eTime);
				request.setAttribute("sTime", sTime);
				 balance.setStartingTime(sTime);
				 balance.setEndTime(eTime);
			}else if(type==11){
				balancea.setStartingTime(sTime);
				balancea.setEndTime(eTime);
				 balance.setStartingTime(sTime);
				 balance.setEndTime(eTime);
			}
				
		}else{
			if(type==1){
				comfig.setqStTime(dateTypes);
				balancea.setDateTypes(dateTypes);
				balance.setDateTypes(dateTypes);
			}
              if(type==3){
            	 String  dateType1=dateTypes+"-01";
				 comfig.setqStTime(dateType1);
				 balance.setDateTypes(dateTypes);
				 balancea.setDateTypes(dateTypes);
			}
              if(type==6){
  				if(dateTypes.toString().equals("2016")){
  					Date  sTime1=viewCompanyconfig.getStratTime();	
  					sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(sTime1);
  					 comfig.setqStTime(sTime);
  				}else{
  					
  				String	dateType1=dateTypes+"-01-01";
  	  	    comfig.setqStTime(dateType1);
  					 
  				}
  				balancea.setDateTypes(dateTypes);
  				balance.setDateTypes(dateTypes);
  			}
              if(type==5){
            	  comfig.setqStTime(sTime); 
            	//  balance.setDateTypes(sTime);
            	  balance.setStartingTime(sTime);
 				 balance.setEndTime(eTime);
              }
		}		
		int i=reportFormBiz.insertBalanceTime(comfig);
		
		List<BalanceWater>balances=null;
		
		try {
			balances=balanceBizs.BalanceList(balance);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int s=balances.size()-1;
		ViewLineReport balancess=new ViewLineReport();
		Double value=0.0;
		if(balances.size()<=0){
			balancess.setTabZtrafficIS1(value);//工业给水总流量
			balancess.setTabZtrafficDS1(value);//生活给水总流量
			balancess.setTabZtrafficID1(value);//排水总流量
			balancess.setLosslimit(value);
			balancess.setWastage(value);
			balancess.setUnknown(value);
		}else{
			balancess.setTabZtrafficIS1(fixed(balances.get(s).getIsztraffic(), 2));//工业给水总流量
			 balancess.setTabZtrafficDS1(fixed(balances.get(s).getLsztraffic(), 2));//生活给水总流量
			 balancess.setTabZtrafficID1(fixed(balances.get(s).getIdztraffic(), 2));//排水总流量
			 balancess.setLosslimit( fixed(balances.get(s).getTotalLossLimit(), 2));
			 balancess.setWastage(fixed(balances.get(s).getTotalwastage(), 2));
			 balancess.setUnknown(fixed(balances.get(s).getTotalunknow(), 2));
		}
		
		
	/*	request.setAttribute("tabZtrafficIS1", tabZtrafficIS1);
		request.setAttribute("tabZtrafficDS1", tabZtrafficDS1);
		request.setAttribute("tabZtrafficID1", tabZtrafficID1);
		request.setAttribute("lossLimit", losslimit);
		request.setAttribute("wastage", wastage);
		request.setAttribute("unknown", unknown);*/
		
	List<Object> balancesList=new ArrayList<Object>();
	balancesList.add(balancess);
	result.setResult(balancesList);
		if(balancess !=null){
			result.init(ApiResultcode._1, "成功");
		}
  	 return "@" + encodeJson(result);
  	 
	}

}
