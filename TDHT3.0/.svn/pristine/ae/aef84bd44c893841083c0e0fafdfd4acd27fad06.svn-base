package com.fh.controller.system.user_center;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.system.Menu;
import com.fh.entity.system.StringDataLongTime;
import com.fh.service.system.user_center.impl.UserCenterService;
import com.fh.util.Const;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;

@Controller
public class UserCenterController extends BaseController {
	
	String menuUrl = "user_center/listCenter.do"; //菜单地址(权限用)
	@Resource(name="userCenterService")
	private UserCenterService userCenterService;
	
	
	/**
	 * 进入用户中心页面
	 * @return
	 */
	@RequestMapping(value="/listCenter")
	public ModelAndView listQuality(HttpServletRequest request,Page page,String ROLE_NAME,String MENU_ID,String R_ID,String MENU_IDS) throws Exception{
		
		ModelAndView mv = this.getModelAndView();
		Session session = Jurisdiction.getSession();
		
		List<Menu> allmenuList = new ArrayList<Menu>();
		List<Menu> allmenuLists = new ArrayList<Menu>();
		allmenuList = (List<Menu>)session.getAttribute(ROLE_NAME + Const.SESSION_allmenuList);
		for(int i=0;i<allmenuList.size();i++){
			if(allmenuList.get(i).getMENU_ID().equals(MENU_ID)){
				allmenuLists=allmenuList.get(i).getSubMenu();
			}
		}
		
		for(int a=0;a<allmenuLists.size();a++){
			mv.addObject("list"+a,allmenuLists.get(a));
		}
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("R_ID", R_ID);
		
		
		mv.addObject("menuUrl","listCenter.do?MENU_ID="+MENU_ID+"R_ID=");
		mv.setViewName("system/user_center/user_center_list");
		mv.addObject("R_ID",R_ID);
		return mv;
	}
	
	
	/**
	 * 查询登录日志
	 */
	@RequestMapping(value="/listlogin")
	@ResponseBody
	public Object listControl(int limit,int offset,String R_ID,int from,String strTime,String strTime2) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		
		if(strTime.equals("")){
			Calendar calendar = Calendar.getInstance();  
		       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) -1);  
		       Date today = calendar.getTime();  
		       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		       String intstartTime = format.format(today);  
		       Date date=new Date();
		      String  intendTime=format.format(date);
		      pd.put("endTime", intendTime+" 23:59");
		      pd.put("startTime", intstartTime+" 00:00");
		}
		
		if(from==1 && strTime!="" ){
			String startTime=strTime+" 00:00";
			String endTime=strTime+" 23:59";
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==2 && strTime!="" ){
			String startTime=strTime+"-01 00:00";
			
			Calendar calendar = new GregorianCalendar();  
			  calendar.add(Calendar.MONTH, 1);  
		        calendar.set(Calendar.DAY_OF_MONTH, 0);  
		        Date enddateTime=calendar.getTime();
		        String endTime= StringDataLongTime.dateToString(enddateTime,"yyyy-MM-dd");
		        endTime=endTime+" 00:00";
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==4 && strTime!=""){
			String startTime=strTime+"-01-01 00:00";
			String endTime=strTime+"-12-31 00:00";
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==5 && strTime!=""){
			String startTime=strTime+" 00:00";
			String endTime=strTime2+" 23:59";
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		
		  pd.put("limit", limit);
	      pd.put("offset", offset);
	      String userName= Jurisdiction.getUsername();//获取当前用户名
	      pd.put("USERNAME", userName);
		
		
		List<PageData> varLists=userCenterService.listLogin(pd);
		PageData varSize=userCenterService.countLogin(pd);
		map.put("rows", varLists);
		map.put("total", varSize.get("USERNAME"));
		JSONObject json = JSONObject.fromObject(map);
		return  json;
	}
	
	
}
