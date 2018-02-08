package com.erich.saleticket.controllers.api;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.apache.commons.lang.StringUtils;

import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.model.sys.SysUser;
import com.erich.saleticket.model.tdht.Console;
import com.erich.saleticket.model.tdht.ViewLog;


/**
 *在线监控
 * @author Lv
 */
public class MonitorController extends BaseController {

	@Resource
	private DataBiz dataBiz;

	

	   //我要读的数据
	    Console console1=new Console();
		Console console_yyf=new Console();
		Console console_odk=new Console();
		Console console_tdht=new Console();
		
		Console console_1=new Console();
		Console console_2=new Console();
		
		//我要给网关的数据
		Console console2_yyf=new Console();
		Console console2_odk=new Console();
		Console console2_tdht=new Console();
		
		Console console2_1=new Console();
		Console console2_2=new Console();
		

        Lock lock = new ReentrantLock();// 锁 
		
		Data<Console> result = new Data<Console>(ApiResultcode._0);
		ViewLog user=new ViewLog();
			
	/**
	 *设备状态
	 */
		@Get("monitorList")
		@Post("monitorList")
	public String monitorList(Console console,HttpServletRequest request, HttpServletResponse response) {
	//	System.out.println(console.toString());
			  
		try {
		//	System.out.println(console.getWord()+"!!!!!!!!");
			if(console.getWord()==3){
				if(console.getRid().toString().equals("75501330001")){
					console_yyf=console;
					
				//	System.out.println(console2_yyf.getWord());
		    		if(console2_yyf.getWord()!=3&&console2_yyf.getWord()!=6){
		    			/*console2.setWord(3);
		    			console2.setWelllid1(welllid1);*/
		    			console2_yyf=console;
		    			console2_yyf.setWord(3);
		    			
		    		}
		    		
		    		//System.out.println(console2_yyf.toString()+"##################");
		    		result.setResult(console2_yyf);
		    		 result.init(ApiResultcode._1, "成功");
		    		return "@" + encodeJson(result);
				}
				if(console.getRid().toString().equals("75501330002")){
					console_odk=console;
					
				//	System.out.println(console2_odk.getWord());
		    		if(console2_odk.getWord()!=3&&console2_odk.getWord()!=6){
		    			/*console2.setWord(3);
		    			console2.setWelllid1(welllid1);*/
		    			console2_odk=console;
		    			console2_odk.setWord(3);
		    			
		    		}
		    		
		    	//	System.out.println(console2_odk.toString()+"##################");
		    		result.setResult(console2_odk);
		    		 result.init(ApiResultcode._1, "成功");
		    		return "@" + encodeJson(result);
					
				}
				if(console.getRid().toString().equals("75501330003")){
					console_tdht=console;
					
				//	System.out.println(console2_tdht.getWord());
		    		if(console2_tdht.getWord()!=3&&console2_tdht.getWord()!=6){
		    			/*console2.setWord(3);
		    			console2.setWelllid1(welllid1);*/
		    			console2_tdht=console;
		    			console2_tdht.setWord(3);
		    			
		    		}
		    		
		    	//	System.out.println(console2_tdht.toString()+"##################");
		    		result.setResult(console2_tdht);
		    		 result.init(ApiResultcode._1, "成功");
		    		return "@" + encodeJson(result);
				}
				if(console.getRid().toString().equals("75501330004")){
					console_1=console;
					
			//		System.out.println(console2_1.getWord());
		    		if(console2_1.getWord()!=3&&console2_1.getWord()!=6){
		    			/*console2.setWord(3);
		    			console2.setWelllid1(welllid1);*/
		    			console2_1=console;
		    			console2_1.setWord(3);
		    			
		    		}
		    		
		    	//	System.out.println(console2_1.toString()+"##################");
		    		result.setResult(console2_1);
		    		 result.init(ApiResultcode._1, "成功");
		    		return "@" + encodeJson(result);
				}
				if(console.getRid().toString().equals("75501330005")){
					console_2=console;
					
			//		System.out.println(console2_2.getWord());
		    		if(console2_2.getWord()!=3&&console2_2.getWord()!=6){
		    			/*console2.setWord(3);
		    			console2.setWelllid1(welllid1);*/
		    			console2_2=console;
		    			console2_2.setWord(3);
		    			
		    		}
		    		
		   	//	System.out.println(console2_2.toString()+"##################");
		    		result.setResult(console2_2);
		    		 result.init(ApiResultcode._1, "成功");
		    		return "@" + encodeJson(result);
				}
				
	    		
	    		
	    		
	    		
	    	}
	         if(console.getWord()==6){
	        	 

					//向数据库写入操作日志
					
					dataBiz.Insertlog(user);	
	        	 
	        	 
	        	 if(console.getRid().toString().equals("75501330001")){
						console_yyf=console;
						console2_yyf=console;
					//	 System.out.println("-----------"+console.getWord());
			    		 console2_yyf.setWord(3);
			    		
			    		 result.setResult(console2_yyf);
			    		 result.init(ApiResultcode._1, "成功");
			    		 return "@" + encodeJson(result);
					}
					if(console.getRid().toString().equals("75501330002")){
						console_odk=console;
						console2_odk=console;
					//	 System.out.println("-----------"+console.getWord());
			    		 console2_odk.setWord(3);
			    		 
			    			
			    		 result.setResult(console2_odk);
			    		 result.init(ApiResultcode._1, "成功");
			    		 return "@" + encodeJson(result);
					}
					if(console.getRid().toString().equals("75501330003")){
						console_tdht=console;
						console2_tdht=console;
				//		 System.out.println("-----------"+console.getWord());
			    		 console2_tdht.setWord(3);
			    			
			    		 result.setResult(console2_tdht);
			    		 result.init(ApiResultcode._1, "成功");
			    		 return "@" + encodeJson(result);
					}
					if(console.getRid().toString().equals("75501330004")){
						console_1=console;
						console2_1=console;
				//		 System.out.println("-----------"+console.getWord());
			    		 console2_1.setWord(3);
			    			
			    		 result.setResult(console2_1);
			    		 result.init(ApiResultcode._1, "成功");
			    		 return "@" + encodeJson(result);
					}
					if(console.getRid().toString().equals("75501330005")){
						console_2=console;
						console2_2=console;
				//		 System.out.println("-----------"+console.getWord());
			    		 console2_2.setWord(3);
			    			
			    		 result.setResult(console2_2);
			    		 result.init(ApiResultcode._1, "成功");
			    		 return "@" + encodeJson(result);
					}
					
	        	
	    	}
			
           
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			result.init(ApiResultcode._0, e.getMessage());
		}
	
		return null;
		
		
		
	}
		@Get("monitorList2")
		@Post("monitorList2")
public String monitorList2(Console console,String name,int value,HttpServletRequest request, HttpServletResponse response) {
		String strRid=console.getRid()+"";
		
	if(console.getWord()==3){
		    if(strRid.equals("75501330001")){
				console1=console_yyf;
			}
			if(strRid.equals("75501330002")){
				console1=console_odk;
			}
			if(strRid.equals("75501330003")){
				console1=console_tdht;
			}
			if(strRid.equals("75501330004")){
				console1=console_1;
			}
			if(strRid.equals("75501330005")){
				console1=console_2;
			}
			StringBuffer webUrl=request.getRequestURL();
			String url=webUrl+"?nameId=1";
			request.setAttribute("webUrls", url);
			request.setAttribute("console", console1);
			
			result.setResult(console1);
   		 result.init(ApiResultcode._1, "成功");
   		 return "@" + encodeJson(result);
	}
     
	return null;
	
	
		
	
	}

		
		public String monitorList3(Console console,HttpServletRequest request, HttpServletResponse response) {
			String strRid=console.getRid().toString();
			if(strRid==null){
				result.setResult(console);
		   		 result.init(ApiResultcode._0, "失败");
		   		 return "@" + encodeJson(result);
			}
			
			int i=insertLog(console,request,response);
			if(i==0){
				result.setResult(console);
		   		 result.init(ApiResultcode._2, "失败");
		   		 return "@" + encodeJson(result);
			}else{
				
			
			if(console.getManholeMac1()==null||console.getManholeMac2()==null||console.getManholeMac3()==null){
				result.setResult(console);
		   		 result.init(ApiResultcode._0, "失败");
		   		 return "@" + encodeJson(result);
			}
			
			if(console.getWord()==6){
	    	 
			/*console2.setWord(word);
			console2.setWelllid1(welllid1);*/
	    	  StringBuffer webUrl=request.getRequestURL();
				String url=webUrl+"?nameId=1";
				request.setAttribute("webUrls", url);
				request.setAttribute("console1", console1);
				
				if(strRid.equals("75501330001")){
					console1=console_yyf;
					 console2_yyf=console;
					 console2_yyf.setWord(6);
				}
				if(strRid.equals("75501330002")){
					console1=console_odk;
					
					 console2_odk=console;
					 console2_odk.setWord(6);
				}
				if(strRid.equals("75501330003")){
					console1=console_tdht;
					
					 console2_tdht=console;
					 console2_tdht.setWord(6);
				}
				if(strRid.equals("75501330004")){
					console1=console_1;
					
					 console2_1=console;
					 console2_1.setWord(6);
				}
				if(strRid.equals("75501330005")){
					console1=console_2;
					
					 console2_2=console;
					 console2_2.setWord(6);
				}
				result.setResult(console1);
		   		 result.init(ApiResultcode._1, "成功");
		   		 return "@" + encodeJson(result);
		}
			}
		return null;
		
		}	

public int  insertLog(Console console,HttpServletRequest request, HttpServletResponse response){
	
	Long rid=console.getRid();
	Integer name=console.getOperationtype();
	Integer value=console.getValue();
	String userIp=getIpAddr(request);
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
	String time =df.format(new Date());// new Date()为获取当前系统时间
	
	SysUser sysUser = getUser(request);
  if(sysUser==null){
	  return 0; 
  }else{
	String username=sysUser.getAccount();
	
	user.setUserIp(userIp);
	user.setStrTime(time);
	user.setOperationRid(rid);
	user.setOperationtype(name);
	user.setOperationvalue(value);
	user.setUserName(username);
	return 1;
  }
	
}
public static String getIpAddr(HttpServletRequest request, HttpServletResponse response) {
    String ip = request.getHeader("X-Real-IP");
    if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
        return ip;
    }
    ip = request.getHeader("X-Forwarded-For");
    if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
        // 多次反向代理后会有多个IP值，第一个为真实IP。
        int index = ip.indexOf(',');
        if (index != -1) {
            return ip.substring(0, index);
        } else {
            return ip;
        }
    } else {
        return request.getRemoteAddr();
    }
}



}
