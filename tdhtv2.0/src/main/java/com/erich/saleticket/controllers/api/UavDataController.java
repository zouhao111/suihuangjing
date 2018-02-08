package com.erich.saleticket.controllers.api;

import java.text.SimpleDateFormat;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import com.erich.saleticket.biz.tdht.UavDataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.controllers.admin.tdht.HttpUtils;
import com.erich.saleticket.model.tdht.Uav;
public class UavDataController extends BaseController{

	
	@Resource
	private UavDataBiz uavDataBiz;
	
	@Get("addUav")
	@Post("addUav")
	public void addUav(Uav uav, HttpServletRequest request, HttpServletResponse response)   {
		
		String jsond=uav.getJsondata();
		int a=0;
		 
		if(jsond !=null){
			uav=HttpUtils.fromJson(jsond, Uav.class);
			SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			uav.setStrTime(time.format(uav.getTime()));
			a=uavDataBiz.addUavData(uav);
		}
		
			 
	}
		

}
