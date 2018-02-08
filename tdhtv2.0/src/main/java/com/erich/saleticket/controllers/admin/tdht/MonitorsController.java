package com.erich.saleticket.controllers.admin.tdht;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.model.sys.SysUserCompany;
import com.erich.saleticket.model.tdht.Console;
import com.erich.saleticket.model.tdht.KeyState;
import com.erich.saleticket.model.tdht.SamplingRecord;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewData;


/**
 *在线监控
 * @author Lv
 */
public class MonitorsController extends BaseController {

	@Resource
	private DataBiz dataBiz;

	

	  
	


/**
 * 设备控制
 */
		@Get("deviceStatus")
		@Post("deviceStatus")	
public String deviceStatus(Console console,HttpServletRequest request, HttpServletResponse response) {
			SysUserCompany sysUserCompany=getUserCompany(request);
			Integer  companyId=1000;
			if(sysUserCompany.getCompanyId()!=null){
				companyId=sysUserCompany.getCompanyId();
			}
	StringBuffer webUrl=request.getRequestURL();
	String url=webUrl+"?nameId=1";
	request.setAttribute("webUrls", url);
	request.setAttribute("companyId", companyId);
	Long rid=console.getRid();
	request.setAttribute("rid", rid);
	if(rid==75506330001l||rid==75506330002l||rid==75506330003l||rid==75501330022l||rid==75501330023l||rid==75501330024l||rid==75501330025l||rid==75501330026l){
		return "monitor/deviceStatus_new";	
	}
	return "monitor/deviceStatus";
}
		@Get("monitorList3")
		@Post("monitorList3")	
public String monitorList3(Console console,HttpServletRequest request, HttpServletResponse response) {
	Long rid=console.getRid();
	StringBuffer webUrl=request.getRequestURL();
	String url=webUrl+"?nameId=1";
	request.setAttribute("webUrls", url);
	request.setAttribute("rid", rid);
	return "monitor/monitorList";
}
		Data<Console> result2 = new Data<Console>(ApiResultcode._0);
		@Get("monitorLists")
		@Post("monitorLists")	
public String monitorLists(Console console,HttpServletRequest request, HttpServletResponse response) {
	Long rid=console.getRid();
	SysUserCompany sysUserCompany=getUserCompany(request);
	Integer  companyId=sysUserCompany.getCompanyId();
	if(companyId!=null){
		if(companyId==1000||companyId==2000){
			StringBuffer webUrl=request.getRequestURL();
			List<ViewData> ztraffic=dataBiz.selectByState(rid);// 温度湿度keyState 
			List<KeyState> key=dataBiz.selectByState2(rid);
			ViewCompanyconfig companyconfigs=new ViewCompanyconfig();
			companyconfigs.setRid(rid);
			List<ViewCompanyconfig> viewCompanyconfig=dataBiz.selectBycompanyconfig2(companyconfigs);//根据ID查询公司名称
			
			for(int i=0;i<key.size();i++){
				for(int j=0;j<ztraffic.size();j++){
				if(key.get(i).getRid().equals(ztraffic.get(j).getRid())){
					if(key.get(i).getType()==1){
					ztraffic.get(j).setBitOnline1(key.get(i).getBitOnline());
					}else if(key.get(i).getType()==2){
						ztraffic.get(j).setBitOnline2(key.get(i).getBitOnline());
					}else if(key.get(i).getType()==3){
						ztraffic.get(j).setBitOnline3(key.get(i).getBitOnline());
					}
				}
				}
			}
			
			
			
			String url=webUrl+"?nameId=1";
			/*request.setAttribute("webUrls", url);
			request.setAttribute("viewCompanyconfig", viewCompanyconfig);
			request.setAttribute("waterquality", waterquality);*/
			List<Object>list=new ArrayList<Object>();
			list.add(0, ztraffic);
			list.add(1, url);
			list.add(2, viewCompanyconfig);
			list.add(3, companyId);
			result2.setList(list);
			 result2.init(ApiResultcode._1, "成功");
			return "@" + encodeJson(result2);
			
			//return "monitor/monitorList";
		}else{
		StringBuffer webUrl=request.getRequestURL();
		List<ViewData> ztraffic=dataBiz.selectByState(rid);// 流量汇总
		
		String url=webUrl+"?nameId=1";
		/*request.setAttribute("webUrls", url);
		request.setAttribute("webUrls", url);
		request.setAttribute("waterquality", waterquality);*/
		List<Object>list=new ArrayList<Object>();
		list.add(0, ztraffic);
		list.add(1, url);
		
		result2.setList(list);
		 result2.init(ApiResultcode._1, "成功");
		return "@" + encodeJson(result2);
		 
		//return "monitor/monitorList";
		}
    }
	return null;
}
		
		Data<Console> result2s = new Data<Console>(ApiResultcode._0);
		@Get("monitorListss")
		@Post("monitorListss")	
public String monitorListss(Console console,HttpServletRequest request, HttpServletResponse response) {
	Long rid=console.getRid();
	SysUserCompany sysUserCompany=getUserCompany(request);
	Integer  companyId=1000;
	if(sysUserCompany.getCompanyId()!=null){
		companyId=sysUserCompany.getCompanyId();
	}
	
	if(companyId>=1000&&companyId<=2000||companyId==0){
		Integer waterType;
		if(companyId==1000){
			 waterType=1;
		}else if(companyId==0){
			waterType=-1;
		}else if(companyId>=1600&&companyId<1700){
			 waterType=20;
		}else if(companyId>=1500&&companyId<1600){
			 waterType=10;
		}else {
			 waterType=2;
		}
		
		StringBuffer webUrl=request.getRequestURL();
		List<ViewData> ztraffic=dataBiz.selectByState(rid);// 温度湿度keyState 
		List<KeyState> key=dataBiz.selectByState2(rid);
		ViewCompanyconfig companyconfigs=new ViewCompanyconfig();
		companyconfigs.setRid(rid);
		companyconfigs.setWaterType(waterType);
		List<ViewCompanyconfig> viewCompanyconfig=new ArrayList<ViewCompanyconfig>();
		if(companyId==1000){
			viewCompanyconfig=dataBiz.selectBycompanyconfig2ss(companyconfigs);//根据ID查询公司名称
		}else if(companyId==0){
			viewCompanyconfig=dataBiz.selectBycompanyconfig2sa(companyconfigs);//根据ID查询公司名称
			}else if(companyId>=1500&&companyId<=2000){
		viewCompanyconfig=dataBiz.selectBycompanyconfig2s(companyconfigs);//根据ID查询公司名称
		}else {
			 viewCompanyconfig=dataBiz.selectBycompanyconfig2s(companyconfigs);//根据ID查询公司名称
		}
		//List<ViewCompanyconfig> viewCompanyconfig=dataBiz.selectBycompanyconfig2s(companyconfigs);//根据ID查询公司名称
		
		
		List<ViewData> ztraffics=new ArrayList<ViewData>();
		Long rids=0l;
		int b=-1;
		for(int a=0;a<key.size();a++){
			
			if(a>0&&key.get(a).getRid().equals(rids)){
				
				
				
				if(key.get(a).getType()==1){
					ztraffics.get(b).setBitOnline1(key.get(a).getBitOnline());
					ztraffics.get(b).setNote1(key.get(a).getNote());
					}else if(key.get(a).getType()==2){
						ztraffics.get(b).setBitOnline2(key.get(a).getBitOnline());
						ztraffics.get(b).setNote2(key.get(a).getNote());
					}else if(key.get(a).getType()==3){
						ztraffics.get(b).setBitOnline3(key.get(a).getBitOnline());
						ztraffics.get(b).setNote3(key.get(a).getNote());
					}else if(key.get(a).getType()==0){
						ztraffics.get(b).setBitOnline(key.get(a).getBitOnline());
						ztraffics.get(b).setNote(key.get(a).getNote());
					}
			}else{
			ViewData z=new ViewData();
			rids=key.get(a).getRid();
			b++;
			z.setRid(key.get(a).getRid());
			z.setStrTime(key.get(a).getStrTime());
			if(key.get(a).getType()==1){
				z.setBitOnline1(key.get(a).getBitOnline());
				z.setNote1(key.get(a).getNote());
				}else if(key.get(a).getType()==2){
					z.setBitOnline2(key.get(a).getBitOnline());
					z.setNote2(key.get(a).getNote());
				}else if(key.get(a).getType()==3){
					z.setBitOnline3(key.get(a).getBitOnline());
					z.setNote3(key.get(a).getNote());
				}else if(key.get(a).getType()==0){
					z.setBitOnline(key.get(a).getBitOnline());
					z.setNote(key.get(a).getNote());
				}
			ztraffics.add(z);
			}
		}
		for(int z=0;z<ztraffics.size();z++){
			for(int j=0;j<ztraffic.size();j++){
				if(ztraffics.get(z).getRid().equals(ztraffic.get(j).getRid())){
					ztraffics.get(z).setTabTemperature(ztraffic.get(j).getTabTemperature());
					ztraffics.get(z).setTabHumidity(ztraffic.get(j).getTabHumidity());
					ztraffics.get(z).setTabVoltage(ztraffic.get(j).getTabVoltage());
				}
			}
		}
		
		
		
		
		
		/*
		for(int i=0;i<key.size();i++){
			for(int j=0;j<ztraffic.size();j++){
			if(key.get(i).getRid().equals(ztraffic.get(j).getRid())){
				if(key.get(i).getType()==1){
				ztraffic.get(j).setBitOnline1(key.get(i).getBitOnline());
				}else if(key.get(i).getType()==2){
					ztraffic.get(j).setBitOnline2(key.get(i).getBitOnline());
				}else if(key.get(i).getType()==3){
					ztraffic.get(j).setBitOnline3(key.get(i).getBitOnline());
				}
			}
			}
		}
		
		*/
		
		String url=webUrl+"?nameId=1";
		/*request.setAttribute("webUrls", url);
		request.setAttribute("viewCompanyconfig", viewCompanyconfig);
		request.setAttribute("waterquality", waterquality);*/
		List<Object>list=new ArrayList<Object>();
		list.add(0, ztraffics);
		list.add(1, url);
		list.add(2, viewCompanyconfig);
		list.add(3, companyId);
		result2.setList(list);
		 result2.init(ApiResultcode._1, "成功");
		return "@" + encodeJson(result2);
		
		//return "monitor/monitorList";
	}else{
	StringBuffer webUrl=request.getRequestURL();
	List<ViewData> ztraffic=dataBiz.selectByState(rid);// 流量汇总
	
	String url=webUrl+"?nameId=1";
	/*request.setAttribute("webUrls", url);
	request.setAttribute("webUrls", url);
	request.setAttribute("waterquality", waterquality);*/
	List<Object>list=new ArrayList<Object>();
	list.add(0, ztraffic);
	list.add(1, url);
	
	result2.setList(list);
	 result2.init(ApiResultcode._1, "成功");
	return "@" + encodeJson(result2);
	 
	//return "monitor/monitorList";
}
}
		
		
		
		Data<Console> result3 = new Data<Console>(ApiResultcode._0);
		@Get("insertSam")
		@Post("insertSam")	
public String insertSam(SamplingRecord sam,HttpServletRequest request, HttpServletResponse response) {
	Long rid=sam.getRid();
	if(rid.toString().equals("75501330001")){
		sam.setCompanyName("永艺发");
	}
	if(rid.toString().equals("75501330002")){
		sam.setCompanyName("殴达可");
	}
	if(rid.toString().equals("75501330003")){
		sam.setCompanyName("天地互通");
	}
	if(rid.toString().equals("75501330004")){
		sam.setCompanyName("中村科技");
	}
	if(rid.toString().equals("75501330005")){
		sam.setCompanyName("瑞云峰");
	}
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


/*public Console monitorList3(Console console,HttpServletRequest request, HttpServletResponse response) {
	
	if(console.getWord()==3){
		//System.out.println(data1.getWord());
		
		console1.setWord(console1.getWord());
		//console3.setWe lllid1(console1.getWelllid1());
		return console1;
	}
      if(console.getWord()==6){
    	//  System.out.println(data1.getWord());
    	// System.out.println(data1.getPumpValue1());
    	  console2=console;
		console2.setWord(word);
	//	console2.setWelllid1(welllid1);
		return console1;
	}
      StringBuffer webUrl=request.getRequestURL();
  	String url=webUrl+"?nameId=1";
  	request.setAttribute("webUrls", url);
	return null;
	
}*/
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
