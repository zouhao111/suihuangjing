package com.erich.saleticket.controllers.api;


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
import com.erich.saleticket.dto.MobileData;
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
 * 设备状态
 */
		
		@Get("monitorLists")
		@Post("monitorLists")	
public String monitorLists(Console console,HttpServletRequest request, HttpServletResponse response) {
			MobileData<List<Console>> result2 = new MobileData<List<Console>>(ApiResultcode._0);
			
			Long rid=console.getRid();
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
		
		for(int i=0;i<ztraffic.size();i++){
			if(ztraffic.get(i).getRid()==75501330003l||ztraffic.get(i).getRid()==75501330005l||ztraffic.get(i).getRid()==75501330011l||ztraffic.get(i).getRid()==75501330001l ){
				ztraffic.remove(i);
			}else{
				ztraffic.get(i).setTabPh(fixed(ztraffic.get(i).getTabPh(), 2));
				ztraffic.get(i).setTabTemperature(fixed(ztraffic.get(i).getTabTemperature(), 2));
				ztraffic.get(i).setTabHumidity(fixed(ztraffic.get(i).getTabHumidity(), 2));
				ztraffic.get(i).setTabVoltage(fixed(ztraffic.get(i).getTabVoltage(), 2));
			}
		}
		List<ViewData> ztraffics=new ArrayList<ViewData>();
			if(console.getValue()==1500 ){
				for(int i=0;i<ztraffic.size();i++){
					if(ztraffic.get(i).getRid()==75501330008l || ztraffic.get(i).getRid()==75501330009l || ztraffic.get(i).getRid()==75501330010l ||  ztraffic.get(i).getRid()==75501330012l){
						//ztraffic.remove(i);
						ztraffics.add(ztraffic.get(i));
					}
				}
			}
			List<ViewData> ztrafficss=new ArrayList<ViewData>();
			for(int i=0;i<ztraffic.size();i++){
				if(ztraffic.get(i).getRid()!=75501330022l && ztraffic.get(i).getRid()!=75501330023l && ztraffic.get(i).getRid()!=75501330024l && ztraffic.get(i).getRid()!=75501330025l && ztraffic.get(i).getRid()!=75501330026l && ztraffic.get(i).getRid()!=75506330001l && ztraffic.get(i).getRid()!=75506330002l && ztraffic.get(i).getRid()!=75506330003l){
					ztrafficss.add(ztraffic.get(i));
				}
			}
			
		
		String url=webUrl+"?nameId=1";
		/*request.setAttribute("webUrls", url);
		request.setAttribute("viewCompanyconfig", viewCompanyconfig);
		request.setAttribute("waterquality", waterquality);*/
		List<Object>list=new ArrayList<Object>();
		//list.add(0, ztraffic);
		//list.add(1, url);
		//list.add(2, viewCompanyconfig);
		//result2.setList(list);
		if(console.getValue()==1500){
			result2.setZtraffics(ztraffics);
		}else{
			result2.setZtraffics(ztrafficss);
		}
		
		 result2.init(ApiResultcode._1, "成功");
		return "@" + encodeJson(result2);
	
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


}
