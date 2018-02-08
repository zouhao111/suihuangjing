package com.erich.saleticket.controllers.api;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.erich.easyframe.util.Des;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;

import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

public class TestController extends BaseController{

	@Resource
	private	DataBiz dataBiz;
	
	@Get("text")
	@Post("text")
	public String findMyTrade(ViewCompanyconfig viewCompanyconfig) {
		Data<ViewCompanyconfig> result = new Data<ViewCompanyconfig>(ApiResultcode._0);
		
	long asid=	viewCompanyconfig.getRid();
	
	
	
		try {
			//String phone=getParam("userPhone");
			//String param = getRequestString(inv);
			if (viewCompanyconfig != null) {

				ViewCompanyconfig njtTrades = dataBiz.selectBycompanyconfig(viewCompanyconfig);
				result.setResult(njtTrades);
				Des des = new Des("?DHTwtw9ss.1");//密匙
				String a=des.encrypt(encodeJson(result));//内容
				String b=des.decrypt(a);
				result.init(ApiResultcode._1, "成功");
			} else {//参数错误
				result.init(ApiResultcode._0, "参数错误");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.debug(e.getMessage());
			result.init(ApiResultcode._0, e.getMessage());
		}
		
		return "@" + encodeJson(result);
	}
	
	@Get("textw")
	@Post("textw")
	public String findMyTrades(ViewCompanyconfig viewCompanyconfig) {
	return "redirect:alarm/alarmList";
	}
	
	@Get("ipcs")
	@Post("ipcs")
	 public String getIp2(HttpServletRequest request) {
		
         String sc="";
       
         
         sc=getIPAddress(request);
         return sc;
	}
	
	public static String getIPAddress(HttpServletRequest rq) {
		String ip = rq.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = rq.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = rq.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = rq.getRemoteAddr();
		}
		return ip;
	}
	
	  
	
}
