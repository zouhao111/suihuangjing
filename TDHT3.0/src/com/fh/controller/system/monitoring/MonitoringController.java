package com.fh.controller.system.monitoring;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.system.Role;
import com.fh.entity.system.StringDataLongTime;
import com.fh.service.system.conf_config.Conf_ConfigManager;
import com.fh.service.system.monitoring.impl.MonitoringService;
import com.fh.service.system.newdata.NewDataManager;
import com.fh.service.system.poll_sum.Poll_SumManager;
import com.fh.service.system.role.RoleManager;
import com.fh.service.system.user.UserManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.PageData;
import com.fh.util.RightsHelper;

@Controller
public class MonitoringController extends BaseController {
	
	String menuUrl = "log/listMonitoring.do"; //菜单地址(权限用)
	@Resource(name="userService")
	private UserManager userService;
	@Resource(name="conf_configService")
	private Conf_ConfigManager conf_configService;
	@Resource(name="roleService")
	private RoleManager roleService;
	@Resource(name="monitoringService")
	private MonitoringService monitoringService;
	@Resource(name="NewDataService")
	private NewDataManager NewDataService;
	@Resource(name="Poll_SumService")
	private Poll_SumManager Poll_SumService;
	/**
	 * 进入参数报警页面
	 * @return
	 */
	@RequestMapping(value="/listMonitoring")
	public ModelAndView listWarning(HttpServletRequest request,Page page,String ROLE_NAME,String MENU_ID,String R_ID,String MENU_IDS) throws Exception{
		
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("R_ID", R_ID);
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
		String ridList="";
		int userRid=0;
		for(Role role:roleLists){
			ridList=role.getRID()+","+ridList;
			userRid=userRid+1;
		}
		ridList=ridList.substring(0, ridList.length()-1);//将用户下拥有的RID拼接
		
		pds.put("ridList", ridList);
		
		List<PageData> conf=conf_configService.findByRids(pds);//查询该角色下所以公司的信息
		PageData warning_rids=warning_rid();
		List<PageData>warning_rid=(List<PageData>)warning_rids.get("warning_r_id");
		/*String conJson="";
		String conJsons="";
		boolean n=false;
		for(int i=0;i<conf.size();i++){
			n=false;
		for(int a=0; a<warning_rid.size();a++){
			
			if(conf.get(i).getLong("R_ID").equals(warning_rid.get(a).getLong("r_id"))){
				conJson="["+conf.get(i).getDouble("R_LAT")+","+conf.get(i).getDouble("R_LON")+",\""+conf.get(i).getString("R_NAME_CN")+"\",\""+"水质"+warning_rid.get(a).getString("param_name_cn")+"报警"+"\",1,"+conf.get(i).getLong("R_ID")+"],";
				conJsons=conJsons+conJson;
				n=true;
				break;
			}
			continue;
			
		}
		if(!n){
		conJson="["+conf.get(i).getDouble("R_LAT")+","+conf.get(i).getDouble("R_LON")+",\""+conf.get(i).getString("R_NAME_CN")+"\",\""+"各类设备正常"+"\",0,"+conf.get(i).getLong("R_ID")+"],";
		conJsons=conJsons+conJson;
		n=false;
		}
		}
		conJsons="["+conJsons+"]";//拼接成地图点位显示格式
		*/
		pd.put("R_ID", R_ID);
		
		mv.addObject("menuUrl","listMonitoring.do?MENU_ID="+MENU_ID+"&R_ID=");
		mv.setViewName("system/monitoring/monitoring_list");
		mv.addObject("R_ID",R_ID);
		
		//mv.addObject("conJsons",conJsons);
		mv.addObject("warning_rid",warning_rid);
		return mv;
	}
	
	@RequestMapping(value="/map_select_choose")
	@ResponseBody
	public Object map_select_choose(String mySelect) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		String errInfo = "success";
		
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
		String ridList="";
		int userRid=0;
		for(Role role:roleLists){
			ridList=role.getRID()+","+ridList;
			userRid=userRid+1;
		}
		ridList=ridList.substring(0, ridList.length()-1);//将用户下拥有的RID拼接
		
		pds.put("ridList", ridList);
		pds.put("mySelect", mySelect);
		List<PageData> conf=conf_configService.findByRids(pds);//查询该角色下所以公司的信息
		List<PageData>  warning_poll_r_id=monitoringService.warning_poll_r_id(pds);
		
		String conJson="";
		String conJsons="";
		boolean n=false;
		for(int i=0;i<conf.size();i++){
			n=false;
			for(int a=0; a<warning_poll_r_id.size();a++){
				
				if(conf.get(i).getLong("R_ID").equals(warning_poll_r_id.get(a).getLong("r_id"))){
					if(warning_poll_r_id.get(a).getInteger("waring_tag")==1){
						conf.get(i).put("param_name_cn", warning_poll_r_id.get(a).getString("param_name_cn"));
						conf.get(i).put("warning_state", 2);
					}else if(warning_poll_r_id.get(a).getInteger("early_waring_tag")==1){
						//conJson="["+conf.get(i).getDouble("R_LAT")+","+conf.get(i).getDouble("R_LON")+",\""+conf.get(i).getString("R_NAME_CN")+"\",\""+"水质"+warning_rid.get(a).getString("param_name_cn")+"预警"+"\",3,"+conf.get(i).getLong("R_ID")+"],";	
						conf.get(i).put("param_name_cn", warning_poll_r_id.get(a).getString("param_name_cn"));
						conf.get(i).put("warning_state", 3);
					}
					n=true;
					break;
				}
			}
			if(!n){
				conf.get(i).put("warning_state", 0);
				n=false;
			}
		}
		
		for(int i=0;i<conf.size();i++){
			
				if(conf.get(i).getInteger("warning_state")==0){
					conJson="["+conf.get(i).getDouble("R_LAT")+","+conf.get(i).getDouble("R_LON")+",\""+conf.get(i).getString("R_NAME_CN")+"\",\""+"该水质正常"+"\",0,"+conf.get(i).getLong("R_ID")+"]";
				}else if(conf.get(i).getInteger("warning_state")==2){
					conJson="["+conf.get(i).getDouble("R_LAT")+","+conf.get(i).getDouble("R_LON")+",\""+conf.get(i).getString("R_NAME_CN")+"\",\""+"水质"+conf.get(i).getString("param_name_cn")+"报警"+"\",2,"+conf.get(i).getLong("R_ID")+"]";
				}else if(conf.get(i).getInteger("warning_state")==3){
					conJson="["+conf.get(i).getDouble("R_LAT")+","+conf.get(i).getDouble("R_LON")+",\""+conf.get(i).getString("R_NAME_CN")+"\",\""+"水质"+conf.get(i).getString("param_name_cn")+"报警"+"\",2,"+conf.get(i).getLong("R_ID")+"]";
				}
				if(conJsons!=""){
					conJsons=conJsons+","+conJson;	
				}else{
					conJsons=conJsons+conJson;	
				}
		}
		
       conJsons="["+conJsons+"]";//拼接成地图点位显示格式
		map.put("conJsons",conJsons);
    	map.put("result", errInfo);		
        return AppUtil.returnObject(new PageData(), map);
	}
	
	@RequestMapping(value="/map_marker")
	@ResponseBody
	public Object map_marker(String R_ID) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		String errInfo = "success";
		pd.put("R_ID", R_ID);
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
		Long R_IDS;
		
		List<PageData> onLines = new ArrayList<PageData>();
		for(Role ss:roleList){
			PageData onLine=userService.findByUsername(pd);
			R_IDS=ss.getRID();
			pd.put("R_ID", R_IDS)	;
			
			onLine=monitoringService.map_online(pd);
			if(onLine!=null){
				onLines.add(onLine);
			}
		}
		String conJson="";
		String conJsons="";
		String ridList="";
		int userRid=0;
		for(Role role:roleLists){
			ridList=role.getRID()+","+ridList;
			userRid=userRid+1;
		}
		ridList=ridList.substring(0, ridList.length()-1);//将用户下拥有的RID拼接
		pds.put("ridList", ridList);
		List<PageData> conf=conf_configService.findByRids(pds);//查询该角色下所以公司的信息
		PageData warning_rids=warning_rid();
		List<PageData>warning_rid=(List<PageData>)warning_rids.get("warning_r_id");
		
		boolean n=false;
		for(int i=0;i<conf.size();i++){
			for(int b=0;b<onLines.size();b++){
				if(conf.get(i).getLong("R_ID").equals(onLines.get(b).getLong("r_id"))){
					if(onLines.get(b).getInteger("device_state")==1){
						conf.get(i).put("device_state", 1);
					}else{
						conf.get(i).put("device_state", 0);
					}
				}
			}
		}	
		for(int i=0;i<conf.size();i++){
			for(int a=0; a<warning_rid.size();a++){
				 n=false;
				if(conf.get(i).getLong("R_ID").equals(warning_rid.get(a).getLong("r_id"))){
					if(warning_rids.getInteger("type")==0){
						//	
						conf.get(i).put("param_name_cn", warning_rid.get(a).getString("param_name_cn"));
						conf.get(i).put("warning_state", 2);
					}else{
						//conJson="["+conf.get(i).getDouble("R_LAT")+","+conf.get(i).getDouble("R_LON")+",\""+conf.get(i).getString("R_NAME_CN")+"\",\""+"水质"+warning_rid.get(a).getString("param_name_cn")+"预警"+"\",3,"+conf.get(i).getLong("R_ID")+"],";	
						conf.get(i).put("param_name_cn", warning_rid.get(a).getString("param_name_cn"));
						conf.get(i).put("warning_state", 3);
					}
					n=true;
					break;
				}
			}
			if(!n){
				conf.get(i).put("warning_state", 0);
				n=false;
			}
			
		}
		for(int z=0;z<conf.size();z++){
			for(int x=0;x<roleList.size();x++){
				if(conf.get(z).getLong("R_ID")==roleList.get(x).getRID()){
					conf.get(z).put("RIGHTS", roleList.get(x).getRIGHTS());
				}
			}
			
		}
		
		
		for(int i=0;i<conf.size();i++){
			if(conf.get(i).getInteger("device_state")==1){
				conJson="["+conf.get(i).getDouble("R_LAT")+","+conf.get(i).getDouble("R_LON")+",\""+conf.get(i).getString("R_NAME_CN")+"\",\""+"设备离线"+"\",1,"+conf.get(i).getLong("R_ID")+",\""+conf.get(i).getString("RIGHTS")+"\"]";	
				
				if(conJsons!=""){
					conJsons=conJsons+","+conJson;	
				}else{
					conJsons=conJsons+conJson;	
				}
			}else{
				if(conf.get(i).getInteger("warning_state")==0){
					conJson="["+conf.get(i).getDouble("R_LAT")+","+conf.get(i).getDouble("R_LON")+",\""+conf.get(i).getString("R_NAME_CN")+"\",\""+"各类设备正常"+"\",0,"+conf.get(i).getLong("R_ID")+",\""+conf.get(i).getString("RIGHTS")+"\"]";
					
				}else if(conf.get(i).getInteger("warning_state")==2){
					conJson="["+conf.get(i).getDouble("R_LAT")+","+conf.get(i).getDouble("R_LON")+",\""+conf.get(i).getString("R_NAME_CN")+"\",\""+"水质"+conf.get(i).getString("param_name_cn")+"报警"+"\",2,"+conf.get(i).getLong("R_ID")+",\""+conf.get(i).getString("RIGHTS")+"\"]";
				}else if(conf.get(i).getInteger("warning_state")==3){
					conJson="["+conf.get(i).getDouble("R_LAT")+","+conf.get(i).getDouble("R_LON")+",\""+conf.get(i).getString("R_NAME_CN")+"\",\""+"水质"+conf.get(i).getString("param_name_cn")+"报警"+"\",2,"+conf.get(i).getLong("R_ID")+",\""+conf.get(i).getString("RIGHTS")+"\"]";
				}
				if(conJsons!=""){
					conJsons=conJsons+","+conJson;	
				}else{
					conJsons=conJsons+conJson;	
				}
			}
		}
		conJsons="["+conJsons+"]";//拼接成地图点位显示格式
		map.put("conJsons",conJsons);
    	map.put("result", errInfo);		
        return AppUtil.returnObject(new PageData(), map);
	}
	@RequestMapping(value="/map_pie")
	@ResponseBody
	public Object map_pie(String R_ID) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		String errInfo = "success";
		pd.put("R_ID", R_ID);
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
		String ridList="";
		int userRid=0;
		for(Role role:roleLists){
			ridList=role.getRID()+","+ridList;
			userRid=userRid+1;
		}
		ridList=ridList.substring(0, ridList.length()-1);//将用户下拥有的RID拼接
		
		pds.put("ridList", ridList);
		PageData sumEarly=monitoringService.sumEarly(pds);//预警总数
		PageData sumReal=monitoringService.sumReal(pds);//报警总数
		
		PageData earlyRid=monitoringService.earlyRid(pds);//预警公司数量
		int earlyRids=0;
		if(earlyRid!=null){
			earlyRids=Integer.parseInt(earlyRid.get("earlyRid").toString());
		}
		PageData realRid=monitoringService.realRid(pds);//报警公司数量
		int realRids=0;
		if(realRid!=null){
			realRids=Integer.parseInt(realRid.get("realRid").toString());
		}
		double pie1=((userRid-earlyRids-realRids)/userRid)*100;//正常单位
		double pie2=100-pie1;
		
		double pie3=0.75;//报警单位
		double pie4=100-pie3;
		
		double pie5=(earlyRids/userRid)*100;//预警单位
		double pie6=100-pie5;
		map.put("userRid",userRid);
		map.put("realRids",realRids);
		map.put("earlyRids",earlyRids);
        	
		map.put("pie1",pie1);
		map.put("pie2",pie2);
		map.put("pie3",pie3);
		map.put("pie4",pie4);
		map.put("pie5",pie5);
		map.put("pie6",pie6);
		map.put("sumReal",sumReal.get("sumReal"));
		map.put("sumEarly", sumEarly.get("sumEarly"));
    	map.put("result", errInfo);		
        
        return AppUtil.returnObject(new PageData(), map);
	}
	
	public Double fixed(Double d,int i){
		BigDecimal   b1   =   new   BigDecimal(d);  
		Double   num   =   b1.setScale(i,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
		return num;
	}
	@RequestMapping(value="/map_select")
	@ResponseBody
	public Object map_select(String R_ID) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		String errInfo = "success";
		pd.put("R_ID", R_ID);
		 List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表
		 List<PageData>	varLists =new ArrayList<PageData>();
        if(varList!=null&&varList.size()>0){
        	map.put("data", varList);
    		map.put("result", errInfo);		
        }
        return AppUtil.returnObject(new PageData(), map);
	}
	
	@RequestMapping(value="/map_com_conf")
	@ResponseBody
	public Object map_com_conf(String R_ID) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		String errInfo = "success";
		pd.put("R_ID", R_ID);

		 List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表
		 List<PageData>	varLists =new ArrayList<PageData>();
        if(varList!=null&&varList.size()>0){
    		for(int i=0;i<varList.size();i++){
    			PageData pdata=new PageData();
    			
    				pdata.put("param_name", varList.get(i).getString("param_name_cn"));
    				if(varList.get(i).getString("param_name_cn").equals("PH值")){
    					pdata.put("limitLL",""+varList.get(i).getDouble("limitLL")+"-"+varList.get(i).getDouble("limitHH"));
    				}else{
    				pdata.put("limitLL", varList.get(i).getDouble("limitHH"));
    				}		
    			
    			varLists.add(pdata);
    		}
        	map.put("data", varLists);
    		map.put("result", errInfo);		
        }
        
        return AppUtil.returnObject(new PageData(), map);
	}
	
	
	@RequestMapping(value="/map_video")
	@ResponseBody
	public Object map_video(String R_ID) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		String errInfo = "success";
		List<PageData>	varList = monitoringService.map_video(pd);	//列出Conf_param列表
        if(varList!=null&&varList.size()>0){
        	map.put("varList", varList);
    		map.put("result", errInfo);		
        }else{
        	errInfo = "error";
        	map.put("result", errInfo);		
        }
        
		return AppUtil.returnObject(new PageData(), map);
	}
	
	@RequestMapping(value="/map_day_poll_line")
	@ResponseBody
	public Object map_day_poll_line(String R_ID) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		String errInfo = "success";
		long startTime=0;
		long endTime=0;
		List<String>strTimes=new ArrayList<String>();	
		List<String>poll_type=new ArrayList<String>();
		
		Date d=new Date();
		String endstrTime=StringDataLongTime.dateToString(d, "yyyy-MM-dd hh:mm");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar c = Calendar.getInstance();
        List<PageData>	varList = NewDataService.listAll_pd(pd);	//列出Conf_param列表
        if(varList!=null){
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, - 7);
        Date ds = c.getTime();
        String day = format.format(ds);
        String str_startTime=day+" 00:00";
        startTime =StringDataLongTime.stringToLong(str_startTime,"yyyy-MM-dd hh:mm");
        endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
        pd.put("start_sy_time", startTime);
	    pd.put("end_sy_time", endTime);
        String  str="";
        List<PageData>	poll1=new ArrayList<PageData>();
		List<PageData>	poll2=new ArrayList<PageData>();
		List<PageData>	poll3=new ArrayList<PageData>();
        List<PageData>	poll1_s=new ArrayList<PageData>();
		List<PageData>	poll2_s=new ArrayList<PageData>();
		List<PageData>	poll3_s=new ArrayList<PageData>();
			pd.put("tabAllName", "calc_quality_01_5min_w_%%");
			
			 for(int a=1;a<=3;a++){
					
					List<PageData>	TabName=new ArrayList<PageData>();
					if(a==1){
						pd.put("tabAllName", "calc_quality_01_5min_w_%%");
						TabName=NewDataService.selectAllTabName(pd);	
						if(TabName!=null){
							for(int i=0;i<TabName.size();i++){
								List<PageData>	poll1s=new ArrayList<PageData>();
							 if(TabName.get(i).getString("TABLE_NAME").contains(str)){
								 pd.put("tabName", TabName.get(i).getString("TABLE_NAME"));
									 poll1s=Poll_SumService.list_poll_day_sum1(pd); 
								 if(poll1s!=null){
									 poll1_s.addAll(poll1s); 
								 }
								  }
							}
						}
						
					}else if(a==2){
						pd.put("tabAllName", "calc_quality_02_5min_w_%%");
							TabName=NewDataService.selectAllTabName(pd);
							if(TabName!=null){
								for(int i=0;i<TabName.size();i++){
									List<PageData>	poll1s=new ArrayList<PageData>();
								 if(TabName.get(i).getString("TABLE_NAME").contains(str)){
									 		pd.put("tabName", TabName.get(i).getString("TABLE_NAME"));
											 poll1s=Poll_SumService.list_poll_day_sum2(pd); 
									 if(poll1s!=null){
										 poll2_s.addAll(poll1s); 
									 }
									  }
								}
							}
					}else if(a==3){
						pd.put("tabAllName", "calc_quality_03_5min_w_%%");
							TabName=NewDataService.selectAllTabName(pd);
							if(TabName!=null){
								for(int i=0;i<TabName.size();i++){
									List<PageData>	poll1s=new ArrayList<PageData>();
								 if(TabName.get(i).getString("TABLE_NAME").contains(str)){
									 pd.put("tabName", TabName.get(i).getString("TABLE_NAME"));
											 poll1s=Poll_SumService.list_poll_day_sum3(pd); 
									 if(poll1s!=null){
										 poll3_s.addAll(poll1s); 
									 }
								 }
							   }
							}
					}
			 }
			
				 if(poll1_s!=null){
					 for(int a=0;a<poll1_s.size();a++){
						 long l=(long)poll1_s.get(a).getInteger("sy_time");
						 if(l>=startTime&&l<endTime){
							 poll1.add(poll1_s.get(a)); 
						 }
					 }
				 }
				 if(poll2_s!=null){
					 for(int a=0;a<poll2_s.size();a++){
						 long l=(long)poll2_s.get(a).getInteger("sy_time");
						 if(l>=startTime&&l<endTime){
							 poll2.add(poll2_s.get(a)); 
						 }
					 }
				 }
				 if(poll3_s!=null){
					 for(int a=0;a<poll3_s.size();a++){
						 long l=(long)poll3_s.get(a).getInteger("sy_time");
						 if(l>=startTime&&l<endTime){
							 poll3.add(poll3_s.get(a)); 
						 }
					 }
				 }
					
					for(int i=0;i<varList.size();i++){
						poll_type.add(varList.get(i).getString("param_name_cn"));
						if(varList.get(i).getInteger("param_type")==7&&poll1!=null){
							
     						List<Double>list1=new ArrayList<Double>();
							List<Double>list2=new ArrayList<Double>();
							for(int a=0;a<poll1.size();a++){
							   list1.add(fixed(poll1.get(a).getDouble(varList.get(i).getString("param_name_sql")),varList.get(i).getInteger("decimal_number")));
							   Double water_sum=poll1.get(a).getDouble("flow_5min");
							   if(water_sum!=0){
								   list2.add(fixed(poll1.get(a).getDouble(varList.get(i).getString("param_name_sql"))/water_sum,varList.get(i).getInteger("decimal_number")));
							   }else{
								   list2.add(0.00); 
							   }
							}	
							
							varList.get(i).put("dataList", list1);
							varList.get(i).put("dataList_avg", list2);
							
						}else if(varList.get(i).getInteger("param_type")==8&&poll2!=null){
							List<Double>list1=new ArrayList<Double>();
							List<Double>list2=new ArrayList<Double>();
							for(int a=0;a<poll2.size();a++){
							   list1.add(fixed(poll2.get(a).getDouble(varList.get(i).getString("param_name_sql")),varList.get(i).getInteger("decimal_number")));
							
							   Double water_sum=poll1.get(a).getDouble("flow_5min");
							   if(water_sum!=0){
								   list2.add(fixed(poll1.get(a).getDouble(varList.get(i).getString("param_name_sql"))/water_sum,varList.get(i).getInteger("decimal_number")));
							   }else{
								   list2.add(0.00); 
							   }
							}	
							varList.get(i).put("dataList", list1);
							varList.get(i).put("dataList_avg", list2);
						}else if(varList.get(i).getInteger("param_type")==9&&poll3!=null){
							List<Double>list1=new ArrayList<Double>();
							List<Double>list2=new ArrayList<Double>();
							for(int a=0;a<poll3.size();a++){
							   list1.add(fixed(poll3.get(a).getDouble(varList.get(i).getString("param_name_sql")),varList.get(i).getInteger("decimal_number")));
							   Double water_sum=poll1.get(a).getDouble("flow_5min");
							   if(water_sum!=0){
								   list2.add(fixed(poll1.get(a).getDouble(varList.get(i).getString("param_name_sql"))/water_sum,varList.get(i).getInteger("decimal_number")));
							   }else{
								   list2.add(0.00); 
							   }
							}	
							varList.get(i).put("dataList", list1);
							varList.get(i).put("dataList_avg", list2);
						}
					}
					DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					if(poll1!=null){
						for(int a=0;a<poll1.size();a++){
								strTimes.add(sdf.format(poll1.get(a).get("str_time")));
						}
					}else if(poll1==null&&poll2!=null){
						for(int a=0;a<poll2.size();a++){
						if(strTimes.size()==0){
								strTimes.add(sdf.format(poll2.get(a).get("str_time")));
						}
						}
					}else if(poll1==null&&poll2==null&&poll3!=null){
						for(int a=0;a<poll3.size();a++){
						if(strTimes.size()==0){
								strTimes.add(sdf.format(poll3.get(a).get("str_time")));
						}
						}
					}
					
			List<String>poll_types=new ArrayList<String>();		
			poll_types.addAll(poll_type);
			
			for(int i=0;i<poll_type.size();i++){
				if(poll_type.get(i).equals("PH值")){
					poll_type.remove(i);
				}
				if(poll_type.get(i).equals("水温(℃)")){
					poll_type.remove(i);
				}
				if(poll_type.get(i).equals("浊度(NTU)")){
					poll_type.remove(i);
				}
			}	
			
			map.put("poll_types", poll_types);
			map.put("poll_type", poll_type);
			map.put("strTimes", strTimes);
			map.put("varList", varList);
    		map.put("result", errInfo);		
        }else{
        	errInfo = "error";
        	map.put("result", errInfo);		
        }
        
				//返回结果
		return AppUtil.returnObject(new PageData(), map);
	}
	
	
	
	@RequestMapping(value="/map_day_line")
	@ResponseBody
	public Object map_day_line(String R_ID) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		String errInfo = "success";
		List<String>strTimes=new ArrayList<String>();	
		List<String>poll_type=new ArrayList<String>();
		
		long startTime=0;
		long endTime=0;
		Date d=new Date();
		String endstrTime=StringDataLongTime.dateToString(d, "yyyy-MM-dd hh:mm");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar c = Calendar.getInstance();
		  c.setTime(new Date());
	        c.add(Calendar.DATE, - 7);
	        Date ds = c.getTime();
	        String day = format.format(ds);
	        String str_startTime=day+" 00:00";
	        startTime =StringDataLongTime.stringToLong(str_startTime,"yyyy-MM-dd hh:mm");
	        endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
	        pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
		
		List<PageData>	varList = monitoringService.water_day(pd);	//列出Conf_param列表
		List<PageData>	com_water_type = monitoringService.com_water_type(pd);	//列出Conf_param列表
		if(varList!=null){
		Collections.reverse(varList); // 倒序排列 
		
		for(int a=0;a<com_water_type.size();a++){
			List<Double>list1=new ArrayList<Double>();
			for(int i=0;i<varList.size();i++){
				
			if(com_water_type.get(a).getInteger("device_type")==1){
				poll_type.add("工业排水");	
				com_water_type.get(a).put("param_name_cn", "工业排水");
				 list1.add(fixed(varList.get(i).getDouble("i_drainage_f"),2));	
			}
			if(com_water_type.get(a).getInteger("device_type")==2){
				poll_type.add("工业给水");	
				com_water_type.get(a).put("param_name_cn", "工业给水");
				 list1.add(fixed(varList.get(i).getDouble("i_supply_f"),2));
			}
			if(com_water_type.get(a).getInteger("device_type")==3){
				poll_type.add("生活排水");	
				com_water_type.get(a).put("param_name_cn", "生活排水");
				 list1.add(fixed(varList.get(i).getDouble("l_drainage_f"),2));
			}
			if(com_water_type.get(a).getInteger("device_type")==4){
				poll_type.add("生活给水");	
				com_water_type.get(a).put("param_name_cn", "生活给水");
				 list1.add(fixed(varList.get(i).getDouble("l_supply_f"),2));
			}
		  }
			com_water_type.get(a).put("dataList", list1);
			
		}
		
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<varList.size();i++){
			strTimes.add(sdf.format(varList.get(i).get("str_time")));
		}
        
        	map.put("poll_type", poll_type);
        	map.put("strTimes", strTimes);
        	map.put("varList", com_water_type);
    		map.put("result", errInfo);		
        }else{
        	errInfo = "error";
        	map.put("result", errInfo);		
        }
        
				//返回结果
		return AppUtil.returnObject(new PageData(), map);
	}
	
	@ResponseBody
	public List<PageData> map_day_value(String R_ID) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		String errInfo = "success";
		List<String>strTimes=new ArrayList<String>();	
		List<String>poll_type=new ArrayList<String>();
		
		
		long startTime=0;
		long endTime=0;
		Date d=new Date();
		String endstrTime=StringDataLongTime.dateToString(d, "yyyy-MM-dd hh:mm");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar c = Calendar.getInstance();
		  c.setTime(new Date());
	        c.add(Calendar.DATE, - 7);
	        Date ds = c.getTime();
	        String day = format.format(ds);
	        String str_startTime=day+" 00:00";
	        startTime =StringDataLongTime.stringToLong(str_startTime,"yyyy-MM-dd hh:mm");
	        endTime =StringDataLongTime.stringToLong(endstrTime,"yyyy-MM-dd hh:mm");
	        pd.put("start_sy_time", startTime);
		    pd.put("end_sy_time", endTime);
		    
		List<PageData>	varList = monitoringService.water_day(pd);	//列出Conf_param列表
		List<PageData>	com_water_type = monitoringService.com_water_type(pd);	//列出Conf_param列表
		List<PageData>	list1=new ArrayList<PageData>();
		
		Collections.reverse(varList); // 倒序排列 
		
		for(int a=0;a<com_water_type.size();a++){
				
			if(com_water_type.get(a).getInteger("device_type")==1){
				 list1.add(com_water_type.get(a));	
			}
		}
		
		//返回结果
		return list1;
	}
	@RequestMapping(value="/map_water")
	@ResponseBody
	public Object map_water() throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		String errInfo = "success";
		
		List<PageData>	varList = NewDataService.listAll_pd_water(pd);	//列出Conf_param列表
        if(varList!=null){
        	map.put("varList", varList);
    		map.put("result", errInfo);		
        }else{
        	errInfo = "error";
        	map.put("result", errInfo);		
        }
		return AppUtil.returnObject(new PageData(), map);
	}
	
	//报警
	@RequestMapping(value="/warning_rid")
	@ResponseBody
	public PageData warning_rid() throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
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
		
		String ridList="";
		for(Role role:roleLists){
			ridList=role.getRID()+","+ridList;
		}
		ridList=ridList.substring(0, ridList.length()-1);//将用户下拥有的RID拼接
		
		pds.put("ridList", ridList);
		PageData warning_r_ids=new PageData();
		List<PageData> warning_r_id=monitoringService.warning_r_id(pds);//预警详细
		
		if(warning_r_id.size()>0){
			warning_r_ids.put("type", 0);   //标识  0是报警  1是预警
			warning_r_ids.put("warning_r_id", warning_r_id);
			return warning_r_ids;
		}else{
			List<PageData> early_r_id=monitoringService.early_r_id(pds);//预警详细
			warning_r_ids.put("type", 1);   //标识  0是报警  1是预警
			warning_r_ids.put("warning_r_id", early_r_id);
			return warning_r_ids;
		}
		
	}
	
	//预警详细
	@RequestMapping(value="/listEarly")
	@ResponseBody
	public Object listEarly(int limit,int offset) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		
		pd.put("limit", limit);
	    pd.put("offset", offset);
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
		String ridList="";
		for(Role role:roleLists){
			ridList=role.getRID()+","+ridList;
		}
		ridList=ridList.substring(0, ridList.length()-1);//将用户下拥有的RID拼接
		
		pds.put("ridList", ridList);
		PageData sumEarly=monitoringService.sumEarly(pds);//预警总数
		List<PageData> listEarly=monitoringService.listEarly(pds);//预警详细
		
		/*for(int i=0;i<listEarly.size();i++){
			listEarly.get(i).put("limitL", listEarly.get(i).getDouble("limitL")+"-"+listEarly.get(i).getDouble("limitH"));
		}*/
	    
		/*map.put("rows", listEarly);
		map.put("total",  sumEarly.get("sumEarly"));*/
		map.put("data",listEarly);
		JSONObject json = JSONObject.fromObject(map);
		return  json;
	}
	//报警详细
	@RequestMapping(value="/listReal")
	@ResponseBody
	public Object listReal(int limit,int offset) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		PageData pd=new PageData();
		pd = this.getPageData();
		
		pd.put("limit", limit);
	    pd.put("offset", offset);
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
		String ridList="";
		for(Role role:roleLists){
			ridList=role.getRID()+","+ridList;
		}
		ridList=ridList.substring(0, ridList.length()-1);//将用户下拥有的RID拼接
		
		pds.put("ridList", ridList);
		PageData sumReal=monitoringService.sumReal(pds);//报警总数
		List<PageData> listReal=monitoringService.listReal(pds);//报警详细
		
		/*for(int i=0;i<listReal.size();i++){
			listReal.get(i).put("limitLL", listReal.get(i).getDouble("limitLL")+"-"+listReal.get(i).getDouble("limitHH"));
		}
	    
		map.put("rows", listReal);
		map.put("total",  sumReal.get("sumReal"));*/
		map.put("data",listReal);
		JSONObject json = JSONObject.fromObject(map);
		return  json;
	}
	
		//综合水质评价
		@RequestMapping(value="/qualityEvaluation")
		@ResponseBody
		public Object qualityEvaluation(String R_ID) throws Exception{
			Map<String,Object> map = new HashMap<String,Object>();
			String qe="正常";
			int qeValue=90;
			PageData pd=new PageData();
			pd = this.getPageData();
			pd.put("ridList", R_ID);
			String userName= Jurisdiction.getUsername();//获取当前用户名
			pd.put("USERNAME", userName);
			List<PageData> listEarly=monitoringService.listEarly(pd);//预警详细
			if(listEarly.size()>0){
				qe="预警";
				qeValue=65;
			}
			List<PageData> listReal=monitoringService.listReal(pd);//报警详细
			if(listReal.size()>0){
				qe="报警";
				qeValue=35;
			}
			
		 	pd.put("ROLE_ID", "4");
			PageData pds=userService.findByUsername(pd);//根据用户名获取userID
			pd.put("USER_ID", pds.getString("USER_ID"));
			List<Role> roleList = roleService.listAllRolesByPId(pd);	//列出所有系统用户角色
			pd = userService.findById(pd);	
			//根据ID读取
			String COM_ID=pd.getString("COM_ID");
			roleList = this.readRid(roleList, COM_ID);
			List<PageData> onLines = new ArrayList<PageData>();
			Long R_IDS;
			for(Role ss:roleList){
				PageData onLine=userService.findByUsername(pd);
				R_IDS=ss.getRID();
				pd.put("R_ID", R_IDS)	;
				onLine=monitoringService.map_online(pd);
				if(onLine!=null){
					onLines.add(onLine);
				}
			}
			for(PageData pdsa:onLines ){
				if(pdsa.getInteger("device_state")==1){
					qe="离线";
					qeValue=10;
				}
			}
			
			
			map.put("qe", qe);
			map.put("qeValue", qeValue);
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
