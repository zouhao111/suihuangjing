package com.erich.saleticket.controllers.admin.tdht;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.erich.easyframe.util.SystemContext;
import com.erich.saleticket.biz.tdht.BalanceBiz;
import com.erich.saleticket.biz.tdht.BalanceWaterBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.biz.tdht.ReportFormBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.model.tdht.BalanceComfig;
import com.erich.saleticket.model.tdht.BalanceWater;
import com.erich.saleticket.model.tdht.Balancea;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewLineReport;
import com.erich.saleticket.model.tdht.ViewTraffic;

/**
 *水平衡控制器
 * @author Lv
 */
public class BalanceController extends BaseController {

	
	@Resource
	private BalanceBiz balanceBiz;
	@Resource
	private  ReportFormBiz reportFormBiz;

	@Resource
	private DataBiz dataBiz;
	@Resource
	private BalanceWaterBiz balanceBizs;
	/**
	 *基本信息
	 * @throws ParseException 
	 */
	public String balanceList(Balancea balancea,HttpServletRequest request, HttpServletResponse response) throws ParseException {
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
				
				/*Calendar cal2 = Calendar.getInstance(); 
				  cal2.add(Calendar.DATE,   -7);
				  sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(cal2.getTime()); 
				   sTime=(new SimpleDateFormat("yyyy-MM-dd")).format(viewCompanyconfig.getStartingTime());
				*/
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
		
		List<BalanceWater>balances=balanceBizs.BalanceList(balance);
		Double tabZtrafficIS1 = 0.0;Double tabZtrafficDS1= 0.0;Double tabZtrafficID1= 0.0;Double losslimit= 0.0;Double wastage= 0.0;Double unknown= 0.0;
		if(balances.size()!=0){
		int s=balances.size()-1;
	//	ViewLineReport balances=balanceBiz.selectByCriteria(balancea);//基本信息
		/*balancea.setEndTime(eTime);
		List<ViewLineReport> balances2=balanceBiz.selectByCriteria2(balancea2);//基本信息
		ViewLineReport balances=balanceBiz.selectByCriteria(balancea);//基本信息
		*/
		/*if(balances==null||balances2.size()==0){
			StringBuffer webUrl=request.getRequestURL();
			String url=webUrl+"?type="+type;
			request.setAttribute("webUrls", url);
			request.setAttribute("sTime", sTime);
			request.setAttribute("eTime", eTime);
			request.setAttribute("type", type);
			request.setAttribute("rid", rid);
			
			request.setAttribute("dateTypes", dateTypes);
			return "water/balanceList";
		}
		
		ViewLineReport balancess=balances2.get(0);
		Double tabZtrafficIS1=balancess.getTabZtrafficIS1()-balances.getTabZtrafficIS1();//工业给水总流量
		Double tabZtrafficDS1=balancess.getTabZtrafficDS1()-balances.getTabZtrafficDS1();//生活给水总流量
		Double tabZtrafficID1=balancess.getTabZtrafficID1()-balances.getTabZtrafficID1();//排水总流量
		Double losslimit=balancess.getLosslimit()-balances.getLosslimit();
		Double wastage=balancess.getWastage()-balances.getWastage();
		
		Double unknown;
		if(rid.toString().equals("75501330004")){
			if(wastage>losslimit){
				wastage=losslimit;
			}
			unknown=tabZtrafficIS1-tabZtrafficID1-wastage;
		}else{
		 unknown=balancess.getUnknown()-balances.getUnknown();
		}
		Date dateTypess=balancess.getStrTime();
*/
		
	if(balances!=null){

		 tabZtrafficIS1=balances.get(s).getIsztraffic();//工业给水总流量
		 tabZtrafficDS1=balances.get(s).getLsztraffic();//生活给水总流量
		 tabZtrafficID1=balances.get(s).getIdztraffic();//排水总流量
		 losslimit=balances.get(s).getTotalLossLimit();
		 wastage=balances.get(s).getTotalwastage();
		 unknown=balances.get(s).getTotalunknow();
	
	/* tabZtrafficIS1=balances.getTabZtrafficIS1();//工业给水总流量
		 tabZtrafficDS1=balances.getTabZtrafficDS1();//生活给水总流量
		 tabZtrafficID1=balances.getTabZtrafficID1();//排水总流量
		 losslimit=balances.getLosslimit();
		 wastage=balances.getWastage();
		 unknown=balances.getUnknown();*/
	}	
		}
		/*if(rid.toString().equals("75501330004")){
			if(wastage>losslimit){
				wastage=losslimit;
			}*/
			//unknown=tabZtrafficIS1-tabZtrafficID1-wastage;
		/*}else{
		 unknown=(tabZtrafficIS1+tabZtrafficDS1)-tabZtrafficID1-wastage;
		}*/
		
		
		
		StringBuffer webUrl=request.getRequestURL();
		String url=webUrl+"?type="+type;
		request.setAttribute("webUrls", url);
		
		request.setAttribute("sTime", sTime);
		request.setAttribute("eTime", eTime);
		request.setAttribute("type", type);
		request.setAttribute("rid", rid);
		request.setAttribute("dateTypes", dateTypes);
	//	request.setAttribute("dateTypess", dateTypess);
		request.setAttribute("viewCompanyconfig", viewCompanyconfig);
		
		request.setAttribute("tabZtrafficIS1", tabZtrafficIS1);
		request.setAttribute("tabZtrafficDS1", tabZtrafficDS1);
		request.setAttribute("tabZtrafficID1", tabZtrafficID1);
		request.setAttribute("lossLimit", losslimit);
		request.setAttribute("wastage", wastage);
		request.setAttribute("unknown", unknown);
		//request.setAttribute("dateshow", balancess.getStrTime());
		
		return "water/balanceList";
	}
	
	
}
