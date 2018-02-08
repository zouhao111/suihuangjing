package com.erich.saleticket.controllers.api;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import com.erich.easyframe.util.SystemContext;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.biz.tdht.LogBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.dto.MobileData;
import com.erich.saleticket.model.tdht.Alarm;
import com.erich.saleticket.model.tdht.KeyState;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewLog;

/**
 *操作日志控制器
 * @author Lv
 */
public class LogController extends BaseController {

	
	@Resource
	private LogBiz logBiz;
	@Resource
	private DataBiz dataBiz;


	/**
	 *操作日志列表
	 */
	@Get("logList")
	@Post("logList")
	public String logList(ViewLog viewLog,HttpServletRequest request, HttpServletResponse response) {
		MobileData<List<ViewLog>> result = new MobileData<List<ViewLog>>(ApiResultcode._0);
		String sTime=viewLog.getStartingTime();
		String eTime=viewLog.getEndTime();
		String companyName=viewLog.getCompanyName();//公司名
		String userName=viewLog.getUserName();//用户名
		Long  rid=viewLog.getRid();//RID
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
		
		
		if(sTime==null && eTime==null && companyName==null && userName==null){
			viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID获取公司名
			
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat formats=new SimpleDateFormat("yyyy-MM-dd");
			eTime=format.format(date);
			sTime=formats.format(date)+" 00:00:00";
			viewLog.setEndTime(eTime);
			viewLog.setStartingTime(sTime);
			viewLog.setCompanyName(viewCompanyconfig.getCompanyName());
			companyName=viewCompanyconfig.getCompanyName();
		}
		
		
		if(rid==75501330002l || rid==75501330003l || rid==75501330004l || rid==75501330006l || rid==75501330008l || rid==75501330009l || rid==75501330010l || rid==75501330012l ){
			List<ViewLog> log = logBiz.selectByCriteriapdf(viewLog);
			result.setResult(log);
		}else{
			List<ViewLog> logs =logBiz.selectByCriteriaNEW(viewLog);
			for(ViewLog vl:logs){
				vl.setDescribe(vl.getStr());
			}
			result.setResult(logs);
		}
		
		result.init(ApiResultcode._1, "成功");
  		 return "@" + encodeJson(result);
	}
	
	
	/**
	 *设备日志列表
	 */
	@Get("offlineLogList")
	@Post("offlineLogList")
	public String offlineLogList(KeyState keyState,HttpServletRequest request, HttpServletResponse response) {
		MobileData<List<KeyState>> result = new MobileData<List<KeyState>>(ApiResultcode._0);
		String sTime=keyState.getStartingTime();
		String eTime=keyState.getEndTime();
		String companyName=keyState.getCompanyName();//公司名
		Long macId=keyState.getMacId();
		Long  rid=keyState.getRid();//RID 
		ViewCompanyconfig viewCompanyconfig=new ViewCompanyconfig();
		viewCompanyconfig.setRid(rid);
	
		
		if(sTime==null & eTime==null & companyName==null){
			viewCompanyconfig=dataBiz.selectBycompanyconfig(viewCompanyconfig);//根据RID获取公司名
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat formats=new SimpleDateFormat("yyyy-MM-dd");
			eTime=format.format(date);
			sTime=formats.format(date)+" 00:00:00";
			  keyState.setEndTime(eTime); 
			  keyState.setStartingTime(sTime);
			keyState.setCompanyName(viewCompanyconfig.getCompanyName());
			companyName=viewCompanyconfig.getCompanyName();
		}
		
		List<KeyState> log = logBiz.selectByOFCriteria(keyState);
		List<KeyState> logs=new ArrayList<KeyState>();
		
		//logs.add(log.get(0));
	for(int i=0;i<log.size()-1;i++){
		if(log.get(i).getMacId().equals(log.get(i+1).getMacId())){//判断第二条和第一条的板ID是否相同
			if(log.get(i).getBitOnline()!=log.get(i+1).getBitOnline()){//判断相同板子的状态如果不相同取上面一条
				logs.add(log.get(i));
			}
		}else{
			//logs.add(log.get(i));//板子ID不相同的话取出上下2条
			//logs.add(log.get(i+1));
		}
	}
		//logs.add(log.get(log.size()-1));
		Collections.sort(logs,new Comparator<KeyState>(){//根据时间降序
            public int compare(KeyState arg0, KeyState arg1) {
                return arg1.getStrTime().compareTo(arg0.getStrTime());
            }
        });
		result.setResult(logs);
		result.init(ApiResultcode._1, "成功");
		 return "@" + encodeJson(result);
	}
	
	
	
}
