package com.fh.controller.system.log;

import java.text.DateFormat;
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
import com.fh.entity.system.Role;
import com.fh.entity.system.StringDataLongTime;
import com.fh.service.system.log.impl.LogService;
import com.fh.service.system.role.RoleManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.Const;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.RightsHelper;

@Controller
public class LogController extends BaseController {
	
	String menuUrl = "log/listLog.do"; //菜单地址(权限用)
	@Resource(name="logService")
	private LogService logService;
	@Resource(name="userService")
	private UserManager userService;
	@Resource(name="roleService")
	private RoleManager roleService;

	/**
	 * 进入参数报警页面
	 * @return
	 */
	@RequestMapping(value="/listLog")
	public ModelAndView listWarning(HttpServletRequest request,Page page,String ROLE_NAME,String MENU_ID,String R_ID,String MENU_IDS) throws Exception{
		
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
		
		mv.addObject("menuUrl","listLog.do?MENU_ID="+MENU_ID+"&R_ID=");
		mv.setViewName("system/log/log_list");
		mv.addObject("R_ID",R_ID);
		return mv;
	}
	/**
	 * 查询设备日志
	 */
	@RequestMapping(value="/listState")
	@ResponseBody
	public Object listState(int limit,int offset,String R_ID,int from,String strTime,String strTime2) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("R_ID", R_ID);
		
		if(strTime.equals("")){
			Calendar calendar = Calendar.getInstance();  
		       calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) -1);  
		       Date today = calendar.getTime();  
		       SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
		       String startTime = format.format(today);  
		       Date date=new Date();
		      String  endTime=format.format(date);
		      long intendTime =StringDataLongTime.stringToLong(endTime,"yyyy-MM-dd");
		      long intstartTime =StringDataLongTime.stringToLong(startTime,"yyyy-MM-dd");
		      pd.put("endTime", intendTime);
		      pd.put("startTime", intstartTime);
		}
		
		if(from==1 && strTime!="" ){
			String startstrTime=strTime+" 00:00";
			String endstrTime=strTime+" 23:59";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==2 && strTime!="" ){
			String startstrTime=strTime+"-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			
			Calendar calendar = new GregorianCalendar();  
			  calendar.add(Calendar.MONTH, 1);  
		        calendar.set(Calendar.DAY_OF_MONTH, 0);  
		        Date enddateTime=calendar.getTime();
		        String endstrTime= StringDataLongTime.dateToString(enddateTime,"yyyy-MM-dd");
		        endstrTime=endstrTime+" 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==4 && strTime!=""){
			String startstrTime=strTime+"-01-01 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=strTime+"-12-31 00:00";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		if(from==5 && strTime!=""){
			String startstrTime=strTime+" 00:00";
			long startTime =StringDataLongTime.stringToLong(startstrTime,"yyyy-MM-dd hh:mm");
			String endstrTime=strTime2+" 23:59";
		    long endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
		    
		    pd.put("startTime", startTime);
		    pd.put("endTime", endTime);
		}
		
		  pd.put("limit", limit);
	      pd.put("offset", offset);
		
		List<PageData> varLists=logService.listLog(pd);
		PageData varSize=logService.countLog(pd);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i=0;i<varLists.size();i++){
			varLists.get(i).put("str_time", sdf.format(varLists.get(i).get("str_time")));
			if(varLists.get(i).get("device_state").equals("1")){
				varLists.get(i).put("device_state","在线");
			}else{
				varLists.get(i).put("device_state","离线");
			}
		}
		map.put("rows", varLists);
		map.put("total", varSize.get("id"));
		JSONObject json = JSONObject.fromObject(map);
		return  json;
	}
	
	/**
	 * 跳转维护记录页面
	 */
	@RequestMapping(value="/addLog")
	public ModelAndView listWarning(HttpServletRequest request,String R_ID)throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("ROLE_ID", "4");
		String userName= Jurisdiction.getUsername();//获取当前用户名
		pd.put("USERNAME", userName);
		PageData pds=userService.findByUsername(pd);//根据用户名获取userID
		pd.put("USER_ID", pds.getString("USER_ID"));
		List<Role> roleList = roleService.listAllRolesByPId(pd);	//列出所有系统用户角色
		pd = userService.findById(pd);	
		//根据ID读取
		String COM_ID=pd.getString("COM_ID");
		roleList = this.readRid(roleList, COM_ID);
		List<Role> roleLists=new ArrayList<Role>(); 
		for(int i=0;i<roleList.size();i++){
			if(roleList.get(i).isHasrole()==true){
				roleLists.add(roleList.get(i));
			}
		}
		mv.addObject("msg", "editU");
		mv.addObject("pd", pd);
		mv.addObject("roleList", roleLists);
		mv.setViewName("system/log/log_add");
		mv.addObject("R_ID",R_ID);
		return mv;
	}
	/**
	 * 新增维护记录
	 */
	@RequestMapping(value="/addMaintain")
	public ModelAndView addMaintain(HttpServletRequest request,Page page) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String userName= Jurisdiction.getUsername();//获取当前用户名
		
		String ip = "";
		if (request.getHeader("x-forwarded-for") == null) {  
			ip = request.getRemoteAddr();  
	    }else{
	    	ip = request.getHeader("x-forwarded-for");  
	    }
		pd.put("user_ip", ip);
		pd.put("user_name", userName);
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		pd.put("str_time", dateFormater.format(date));
		logService.addMaintain(pd);
		
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 查询维护日志
	 */
	@RequestMapping(value="/listMaintain")
	@ResponseBody
	public Object listMaintain(int limit,int offset,String R_ID,int from,String strTime,String strTime2) throws Exception{
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
		
		List<PageData>  varLists=logService.findMaintain(pd);
		PageData varSize=logService.countMaintain(pd);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i=0;i<varLists.size();i++){
			varLists.get(i).put("str_time", sdf.format(varLists.get(i).get("str_time")));
		}
		
		map.put("rows", varLists);
		map.put("total", varSize.get("id"));
		JSONObject json = JSONObject.fromObject(map);
		return  json;
	}
	
	/**
	 * 查询操作日志
	 */
	@RequestMapping(value="/listControl")
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
		
		List<PageData>  varLists=logService.findControl(pd);
		PageData varSize=logService.countControl(pd);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(int i=0;i<varLists.size();i++){
			varLists.get(i).put("str_time", sdf.format(varLists.get(i).get("str_time")));
		}
		
		map.put("rows", varLists);
		map.put("total", varSize.get("id"));
		JSONObject json = JSONObject.fromObject(map);
		return  json;
	}
	
	
	/**根据角色权限处理权限状态(递归处理)
	 * @param menuList：传入的总菜单
	 * @param roleRights：加密的权限字符串
	 * @return
	 */
	public List<Role> readRid(List<Role> RoleList,String COM_ID){
		for(int i=0;i<RoleList.size();i++){
			RoleList.get(i).setHasrole(RightsHelper.testRights(COM_ID, RoleList.get(i).getCOM_ID()));
			//this.readMenu(RoleList.get(i).getSubMenu(), roleRights);					//是：继续排查其子菜单
		}
		return RoleList;
	}
	
}
