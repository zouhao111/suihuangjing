package com.erich.saleticket.controllers.admin.tdht;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.model.tdht.Console;
import com.erich.saleticket.model.tdht.Console_water;
import com.erich.saleticket.model.tdht.ViewLog;


/**
 *在线监控
 * @author Lv
 */
public class NewMonitorsWaterController extends BaseController {

	@Resource
	private DataBiz dataBiz;

	

	  
	


/**
 * 设备控制
 */
	/**
	 * 设备控制
	 */
			@Get("deviceStatus")
			@Post("deviceStatus")	
	public String deviceStatus(Console console,HttpServletRequest request, HttpServletResponse response) {
		StringBuffer webUrl=request.getRequestURL();
		String url=webUrl+"?nameId=1";
		request.setAttribute("webUrls", url);
		return "monitor/deviceStatus_water";
	}
	
	Data<String> result = new Data<String>(ApiResultcode._0);
	ViewLog user=new ViewLog();
		@Get("monitorList3")
		@Post("monitorList3")	

//http:// 120.76.233.59:3337/?stata=7&rid=0&deviceAddress=0&bitNum=0&value=0
public String  monitorList3(HttpServletRequest request, HttpServletResponse response) {
	HttpUtils http=new HttpUtils();
	String url_path="http://120.76.233.59:3337/?stata=7&rid=0&deviceAddress=0&bitNum=0&value=0";
	String str=HttpUtils.getJsonContent(url_path);
	result.setResult(str);
	 result.init(ApiResultcode._1, "成功");
	return "@" + encodeJson(result);
	
}
public String  monitorList4(Console_water console,HttpServletRequest request, HttpServletResponse response) {
	       Long rid=console.getRid();
	        int deviceAddress=console.getDeviceAddress();
	        int bitNum=console.getBitNum();
	        int value=console.getValue();
	
			String url_path="http://120.76.233.59:3337/?stata=8&rid=0&deviceAddress="+deviceAddress+"&bitNum="+bitNum+"&value="+value;
			
			
			String str=HttpUtils.getJsonContent(url_path);
			result.setResult(str);
			 result.init(ApiResultcode._1, "成功");
			return "@" + encodeJson(result);
			
		}
/*public int  num(int i){
	Client c=new Client();
	c.connect(i);
	
	return i;
}*/


/*public static int[] intToByteArray1(int i) {   
	   int[] result = new int[4];   
	   result[0] = (int)((i >> 24) & 0xFF); 
	 //必须把我们要的值弄到最低位去，有人说不移位这样做也可以，  result[0] = (byte)(i  & 0xFF000000); 
	 //，这样虽然把第一个字节取出来了，但是若直接转换为byte类型，会超出byte的界限，出现error。再提下数//之间转换的原则（不管两种类型的字节大小是否一样，原则是不改变值，内存内容可能会变，比如int转为//float肯定会变）所以此时的int转为byte会越界，只有int的前三个字节都为0的时候转byte才不会越界。虽//然  result[0] = (byte)(i  & 0xFF000000); 这样不行，但是我们可以这样  result[0] = (byte)((i  & //0xFF000000) >>24);
	   result[1] = (int)((i >> 16) & 0xFF);
	   result[2] = (int)((i >> 8) & 0xFF); 
	   result[3] = (int)(i & 0xFF);
	   
	   return result;
	 } */





}
