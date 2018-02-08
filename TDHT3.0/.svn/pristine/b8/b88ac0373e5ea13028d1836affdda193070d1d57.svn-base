package com.fh.controller.Data.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.session.Session;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.system.Menu;
import com.fh.entity.system.User;
import com.fh.service.system.control.ControlManager;
import com.fh.service.system.newdata.NewDataManager;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
@Controller
public class Control extends BaseController{


	@Resource(name="NewDataService")
	private NewDataManager NewDataService;
	@Resource(name="ControlService")
	private ControlManager ControlService;
	
	
	@RequestMapping(value="/controlNew")
	public ModelAndView ControlNew(String R_ID,String ROLE_NAME,String MENU_ID,String MENU_IDS) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd=this.getPageData();
		
		Session session = Jurisdiction.getSession();
		
		List<Menu> allmenuList = new ArrayList<Menu>();
		List<Menu> allmenuLists = new ArrayList<Menu>();
		List<Menu> allmenuListss = new ArrayList<Menu>();
		allmenuList = (List<Menu>)session.getAttribute(ROLE_NAME + Const.SESSION_allmenuList);
		for(int i=0;i<allmenuList.size();i++){
			if(allmenuList.get(i).getMENU_ID().equals(MENU_IDS)){
				allmenuLists=allmenuList.get(i).getSubMenu();
			}
		}
		for(int i=0;i<allmenuLists.size();i++){
			if(allmenuLists.get(i).getMENU_ID().equals(MENU_ID)){
				allmenuListss=allmenuLists.get(i).getSubMenu();
			}
		}
		
		for(int a=0;a<allmenuListss.size();a++){
			mv.addObject("list"+a,allmenuListss.get(a));
		}
		List<PageData>	varList = NewDataService.listAll_control(pd);	//列出Conf_param列表
        
		mv.addObject("pd",pd);
		mv.addObject("R_ID",R_ID);
		mv.addObject("list",allmenuListss);
		mv.addObject("ROLE_NAME",ROLE_NAME);
		mv.addObject("varList",varList);
		mv.addObject("menuUrl","controlNew?MENU_ID="+MENU_ID+"&MENU_IDS="+MENU_IDS+"&R_ID=");
		mv.setViewName("data/control/control_id");
		return mv;
	}
	
	@RequestMapping(value="/controller_state")
	@ResponseBody
	public Object controller_state(String R_ID) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "success";
		
		List<PageData>	varList = NewDataService.listAll_water_state(pd);	//列出Conf_param列表
        	
		List<PageData>	online_list = ControlService.select_online(pd);	//列出Conf_param列表
		
		map.put("varList", varList);
		map.put("online_list", online_list);
		map.put("result", errInfo);				//返回结果
		return AppUtil.returnObject(new PageData(), map);
	}
	@RequestMapping(value="/controller_control")
	@ResponseBody
	public Object controller_control(String R_ID) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "success";
		 JSONObject json = GetPlaceByIp.readJsonFromUrl("http://211.154.140.180:1508/api/TDHTsystem/readControlState2?r_id=75500000001");
		
		return json;
	}
	@RequestMapping(value="/write_acontroller_control")
	@ResponseBody
	public Object write_controller_control(String R_ID,int control_action_id,String ip) throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		Map<String,Object> map = new HashMap<String,Object>();
		String errInfo = "success";
		if(ip==null){
			ip="192.168.0.0";
		}
		
		Session session = Jurisdiction.getSession();
		User user = (User)session.getAttribute(Const.SESSION_USER);						//读取session中的用户信息(单独用户信息)
		if (user != null) {
			String USERNAME = user.getUSERNAME();
		
		 JSONObject json = GetPlaceByIp.readJsonFromUrl("http://211.154.140.180:1508/api/TDHTsystem/setControl2?r_id=75500000001&control_action_id="+control_action_id+"&user_name="+USERNAME+"&user_ip="+ip);
		
		 return json;
		}else {
			mv.setViewName("system/index/login");//session失效后跳转登录页面
		
		}
		return null;
	}
	
}
