package com.fh.controller.system.module_role;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.system.Role;
import com.fh.service.system.com_poll.Com_PollManager;
import com.fh.service.system.module_role.Module_RoleManager;
import com.fh.service.system.module_rolemx.Module_RoleMxManager;
import com.fh.service.system.poll_type.POLL_TYPEManager;
import com.fh.service.system.rid_role.RID_ROLEManager;
import com.fh.service.system.role.RoleManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;

/** 
 * 说明：模块管理
 * 创建人：FH Q313596790
 * 创建时间：2017-06-09
 */
@Controller
@RequestMapping(value="/module_role")
public class Module_RoleController extends BaseController {
	
	String menuUrl = "module_role/list.do"; //菜单地址(权限用)
	@Resource(name="module_roleService")
	private Module_RoleManager module_roleService;
	
	@Resource(name="module_rolemxService")
	private Module_RoleMxManager module_rolemxService;
	@Resource(name="roleService")
	private RoleManager roleService;
	
	
	@Resource(name="poll_typeService")
	private POLL_TYPEManager poll_typeService;
	@Resource(name="rid_roleService")
	private RID_ROLEManager rid_roleService;
	
	@Resource(name="com_pollService")
	private Com_PollManager com_pollService;
	
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Module_Role");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("WATER_TYPE_ID", this.get32UUID());	//主键
		
	//	pd.put("TYPE_ID", String.valueOf(Integer.parseInt(water_typeService.findMaxId(pd).get("TYPE_ID").toString())+1));	//查看权限
		
		//water_typeService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Module_Role");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null ;} //校验权限
		Map<String,String> map = new HashMap<String,String>();
		PageData pd = new PageData();
		pd = this.getPageData();
		String errInfo = "success";
		if(Integer.parseInt(module_rolemxService.findCount(pd).get("zs").toString()) > 0){
			errInfo = "false";
		}else{
			module_roleService.delete(pd);
		}
		map.put("result", errInfo);
		return AppUtil.returnObject(new PageData(), map);
	}
	
	/**修改水量
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Module_Role");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String RID=pd.getString("RID");
		long l = Long.parseLong(RID);
		pd.put("RID",l);
		String RID_ROLE=pd.getString("MODULE_ROLE_ID");
		String d=pd.getString("TYPES");
		int types=Integer.parseInt(d);
		if(types==1){
			pd.put("WATER_ROLE",RID_ROLE);
			rid_roleService.edit(pd);
		}else{
			pd.put("POLL_ROLE",RID_ROLE);	
			rid_roleService.edit2(pd);
			
		List<PageData>pds=com_pollService.findByIds(pd);
		/*List<String>a=new ArrayList<String>();
			for(int i=0;i<pds.size();i++){
				a.add(i, pds.get(i).get("TYPE_ID").toString());
			}
			for(int w=0,w<){
				
			}
			
			*/
		}
		
		
		mv.addObject("pd",pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	/**修改水质
	 * @param
	 * @throws Exception
	 *//*
	@RequestMapping(value="/edit_poll")
	public ModelAndView edit_poll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Module_Role");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String RID=pd.getString("RID");
		long l = Long.parseLong(RID);
		pd.put("RID",l);
		String RID_ROLE=pd.getString("MODULE_ROLE_ID");
		
		pd.put("POLL_ROLE",RID_ROLE);
		
		rid_roleService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	*/
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page,int types) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Module_Role");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		pd.put("ROLE_ID", "4");		
		List<PageData>	varList = new ArrayList<PageData>();	//列出Module_Role列表
		List<Role> roleList = roleService.listAllRolesByPId(pd);		//列出此组下架角色
		/*for(int i=0;i<=roleList.size();i++){
			PageData a=new PageData();
			a.put("RID", roleList.get(i).getROLE_NAME());
			varList.add(a);
		}*/
		mv.addObject("TYPES", types);	
		
		mv.setViewName("system/module_role/module_role_list");
		mv.addObject("varList", roleList);
		mv.addObject("pd", pd);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/water_type/water_type_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd2")
	public ModelAndView goAdd2()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("system/poll_type/poll_type_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面  水量
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		//List<PageData>	varList = water_typeService.listAll(pd);	//列出Water_type列表
		
	//	int a=(Integer) varList.get(0).get("TYPE_ID");
	     pd= rid_roleService.findById(pd);	//根据ID读取
		String water_type=pd.getString("WATER_ROLE");
		
		String[] strarr = water_type.split(",");
		int[] table_ids = new int[strarr.length];
		for(int i=0;i<strarr.length;i++){
		table_ids[i]=Integer.parseInt(strarr[i]);
		}
	//	varList=readRole(varList,table_ids);
		mv.addObject("table_ids", table_ids);
	//	mv.addObject("varList", varList);
		pd.put("TYPES", 1);
	//	mv.setViewName("system/water_type/water_type_list");
		//pd = module_roleService.findById(pd);	//根据ID读取
		mv.setViewName("system/module_role/module_role_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	
	
	 /**去修改页面  水质
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit_poll")
	public ModelAndView goEdit_poll()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		List<PageData>	varList = new ArrayList<PageData>();
			//poll_typeService.listAll(pd);	//列出Water_type列表
		
		
		List<PageData>pds=com_pollService.findByIds(pd);
		
		
	//	int a=(Integer) varList.get(0).get("TYPE_ID");
	     pd= rid_roleService.findById(pd);	//根据ID读取
		String poll_type=pd.getString("POLL_ROLE");
		
		String[] strarr = poll_type.split(",");
		int[] table_ids = new int[strarr.length];
		for(int i=0;i<strarr.length;i++){
		table_ids[i]=Integer.parseInt(strarr[i]);
		}
		varList=readRole(varList,table_ids);
		mv.addObject("table_ids", table_ids);
		mv.addObject("varList", varList);
		pd.put("TYPES", 2);
	//	mv.setViewName("system/water_type/water_type_list");
		//pd = module_roleService.findById(pd);	//根据ID读取
		mv.setViewName("system/module_role/module_role_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	
	 /**去修改页面  其他
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit_other")
	public ModelAndView goEdit_other()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		List<PageData>	varList = new ArrayList<PageData>();
			//poll_typeService.listAll(pd);	//列出Water_type列表
		
		
		List<PageData>pds=com_pollService.findByIds(pd);
		
		
	//	int a=(Integer) varList.get(0).get("TYPE_ID");
	     pd= rid_roleService.findById(pd);	//根据ID读取
		String poll_type=pd.getString("POLL_ROLE");
		
		String[] strarr = poll_type.split(",");
		int[] table_ids = new int[strarr.length];
		for(int i=0;i<strarr.length;i++){
		table_ids[i]=Integer.parseInt(strarr[i]);
		}
		varList=readRole(varList,table_ids);
		mv.addObject("table_ids", table_ids);
		mv.addObject("varList", varList);
		pd.put("TYPES", 5);
	//	mv.setViewName("system/water_type/water_type_list");
		//pd = module_roleService.findById(pd);	//根据ID读取
		mv.setViewName("system/module_role/module_role_edit");
		mv.addObject("msg", "edit");
		mv.addObject("pd", pd);
		return mv;
	}	
	/**根据角色权限处理权限状态(递归处理)
	 * @param menuList：传入的总菜单
	 * @param roleRights：加密的权限字符串
	 * @return
	 */
	public List<PageData> readRole(List<PageData> RoleList,int[] table_ids){
		for(int i=0;i<RoleList.size();i++){
			for(int j=0;j<table_ids.length;j++){
				if((Integer)RoleList.get(i).get("TYPE_ID")==table_ids[j]){
					RoleList.get(i).put("HasRole", true);
				}
			}
			
		}
		return RoleList;
	}
	 /**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Module_Role到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("rid");	//1
		dataMap.put("titles", titles);
		List<PageData> varOList = module_roleService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("RID"));	    //1
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
		ObjectExcelView erv = new ObjectExcelView();
		mv = new ModelAndView(erv,dataMap);
		return mv;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
