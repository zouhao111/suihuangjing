package com.erich.saleticket.controllers.admin.tdht;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import com.erich.saleticket.biz.sys.SysMenuBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dao.tdht.DataDAO;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.model.sys.SysUser;
import com.erich.saleticket.model.sys.SysUserCompany;
import com.erich.saleticket.model.tdht.Console;
import com.erich.saleticket.model.tdht.Console_water;
import com.erich.saleticket.model.tdht.SamplingRecord;
import com.erich.saleticket.model.tdht.ViewLog;


/**
 *在线监控
 * @author Lv
 */
public class NewMonitorsController extends BaseController {

	@Resource
	private DataBiz dataBiz;
	@Resource
	private DataDAO dataDAO;
	
	@Resource
	private SysMenuBiz sysMenuBiz;
	  
	


/**
 * 设备控制
 */
	
	
	Data<String> result = new Data<String>(ApiResultcode._0);
	ViewLog user=new ViewLog();
	
	
	
	@Get("sampValue")
	@Post("sampValue")	


public String  sampValue(Console console,HttpServletRequest request, HttpServletResponse response) {
		Long rid=console.getRid();
int samp=console.getSampleValue1();
byte[]sampByte=intToByteArray(samp);
String str=null;
if(sampByte[1]==0&&sampByte[0]>0){
	int cap=sampByte[0];
	str="{'rid':"+rid+",'sampHave':"+0+",'cap':"+cap+"}";
}else{
	str="{'rid':"+rid+",'sampHave':"+1+",'cap':"+0+"}";
}

result.setResult(str);
 result.init(ApiResultcode._1, "成功");
return "@" + encodeJson(result);

}
	  private byte[] intToByteArray(int number)
      {

          byte[] byteNumber = new byte[2];
       
          byteNumber[0]=(byte) (number&0x00FF);//低
          byteNumber[1]=(byte) ((number>>8)&0xFF);//高字节

             return byteNumber;

      }
	  @Get("monitorList3_new")
		@Post("monitorList3_new")	


public String  monitorList3_new(Console_water console,HttpServletRequest request, HttpServletResponse response) {
		  Long rid=console.getRid();
	HttpUtils http=new HttpUtils();
	String url_path="http://211.154.140.180:3337/?stata=9&rid="+rid;
	String str=HttpUtils.getJsonContent(url_path);
	result.setResult(str);
	 result.init(ApiResultcode._1, "成功");
	return "@" + encodeJson(result);
	
}
	  @Get("monitorList4_new")
		@Post("monitorList4_new")	


	  public String  monitorList4_new(Console console,HttpServletRequest request, HttpServletResponse response) {
	       Long rid=console.getRid();
	        int deviceAddress=console.getDeviceAddress();
	        int bitNum=console.getBitNum();
	        String userIp=getIpAddr(request);
	        int userName=console.getDeviceAddress();
	        int value=console.getValue();
	        SysUser sysUser = getUser(request);
	        String username=null;
			 if(sysUser!=null){
				
				 username=sysUser.getAccount();
			  }
			//http://211.154.140.180:3337/?stata=10&rid=75501330013&deviceAddress=1&bitNum=0&value=1&userIP=117.136.79.122&userName=admin 

			
			String url_path="http://211.154.140.180:3337/?stata=10&rid="+rid+"&deviceAddress="+deviceAddress+"&bitNum="+bitNum+"&value="+value+"&userIP="+userIp+"&userName="+username; 
			
			
			String str=HttpUtils.getJsonContent(url_path);
			result.setResult(str);
			 result.init(ApiResultcode._1, "成功");
			return "@" + encodeJson(result);
			
		}


		@Get("monitorList3")
		@Post("monitorList3")	


public String  monitorList3(HttpServletRequest request, HttpServletResponse response) {
			
	HttpUtils http=new HttpUtils();
	String url_path="http://211.154.140.180:3337/?stata=3&rid=0&deviceType=0&deviceNum=0&value=0";
	String str=HttpUtils.getJsonContent(url_path);
	result.setResult(str);
	 result.init(ApiResultcode._1, "成功");
	return "@" + encodeJson(result);
	
}
public String  monitorList4(Console console,HttpServletRequest request, HttpServletResponse response) {
	       Long rid=console.getRid();
	        int deviceType=console.getOperationtype();
	        int value=console.getValue();
	    	//向数据库写入操作日志
	        int i=insertLog(console,request,response);
			dataBiz.Insertlog(user);
			String url_path="http://211.154.140.180:3337/?stata=6&rid="+rid+"&deviceType="+deviceType+"&deviceNum=1&value="+value;
			
			
			String str=HttpUtils.getJsonContent(url_path);
			result.setResult(str);
			 result.init(ApiResultcode._1, "成功");
			return "@" + encodeJson(result);
			
		}


Data<Console> result3 = new Data<Console>(ApiResultcode._0);
@Get("insertSam_new")
@Post("insertSam_new")	
public String insertSam_new(SamplingRecord sam,HttpServletRequest request, HttpServletResponse response) {
Long rid=sam.getRid();

int num=sam.getNum();//杯号
int capacity=sam.getCapacity();//容量
byte bb1= (byte)((capacity) & 0xFF);
byte bb2=(byte)((num ) & 0xFF);
//System.out.println(bb1+"   "+bb2);
byte[] by = new byte[2]; 
by[0]=bb1;
by[1]=bb2;
int value=byteArrayToInt(by, 0);
//System.out.println(inn+"    11");
//dataBiz.InsertSampling(value,sam);
List<Object>list=new ArrayList<Object>();
list.add(0, value);


result3.setList(list);
result3.init(ApiResultcode._1, "成功");
return "@" + encodeJson(result3);
}

public static int byteArrayToInt(byte[] b, int offset) {
int value= 0;
for (int i = 0; i <b.length; i++) {
int shift= (b.length - 1 - i) * 8;
value +=(b[i + offset] & 0x000000FF) << shift;//往高位游
}
return value;
}


//相关数据库写入操作日志
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


public static String getIp(HttpServletRequest request) {
         String remoteAddr = request.getRemoteAddr();
         String forwarded = request.getHeader("X-Forwarded-For");
         String realIp = request.getHeader("X-Real-IP");

         String ip = null;
         if (realIp == null) {
             if (forwarded == null) {
                 ip = remoteAddr;
             } else {
                 ip = remoteAddr + "/" + forwarded;            }
         } else {
             if (realIp.equals(forwarded)) {
                 ip = realIp;
             } else {
                 ip = realIp + "/" + forwarded.replaceAll(", " + realIp, "");
             }
         }
         return ip;
     }


public static String getLocalIp(HttpServletRequest request) {
    String remoteAddr = request.getRemoteAddr();
    String forwarded = request.getHeader("X-Forwarded-For");
    String realIp = request.getHeader("X-Real-IP");

    String ip = null;
    if (realIp == null) {
        if (forwarded == null) {
            ip = remoteAddr;
        } else {
            ip = remoteAddr + "/" + forwarded.split(",")[0];
        }
    } else {
        if (realIp.equals(forwarded)) {
            ip = realIp;
        } else {
            if(forwarded != null){
                forwarded = forwarded.split(",")[0];
            }
            ip = realIp + "/" + forwarded;
        }
    }
    return ip;
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
