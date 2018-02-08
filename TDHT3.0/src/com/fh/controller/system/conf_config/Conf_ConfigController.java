package com.fh.controller.system.conf_config;

import java.io.PrintWriter;
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
import com.fh.service.system.conf_config.Conf_ConfigManager;
import com.fh.service.system.rid_device.Rid_DeviceManager;
import com.fh.service.system.role.RoleManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;

/** 
 * 说明：监测点信息
 * 创建人：FH Q313596790
 * 创建时间：2017-07-10
 */
@Controller
@RequestMapping(value="/conf_config")
public class Conf_ConfigController extends BaseController {
	
	String menuUrl = "conf_config/list.do"; //菜单地址(权限用)
	@Resource(name="conf_configService")
	private Conf_ConfigManager conf_configService;
	@Resource(name="rid_deviceService")
	private Rid_DeviceManager rid_deviceService;
	@Resource(name="roleService")
	private RoleManager roleService;
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Conf_Config");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("CONF_CONFIG_ID", this.get32UUID());	//主键
		conf_configService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Conf_Config");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		conf_configService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Conf_Config");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		conf_configService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Conf_Config");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		/*pd.put("ROLE_ID", "4");	
		List<Role> roleList = roleService.listAllRolesByPId(pd);		//列出此组下架角色
*/		page.setPd(pd);
		List<PageData>	varList = conf_configService.list(page);	//列出Conf_Config列表
	/*	boolean r=true;
		for(int i=0;i<roleList.size();i++){ 
			if(r){
				
			
			for(int a=0;a<varList.size();a++){ 
				System.out.println(Long.toString(roleList.get(i).getRID()));
				System.out.println(varList.get(a).get("R_ID"));
				if(!Long.toString(roleList.get(i).getRID()).equals(varList.get(a).get("R_ID"))){
					r=false;
				}else{
					break;
				}
			}
		   }else{
			   PageData pds=new PageData();
			   pds.put("R_ID",roleList.get(i-1).getRID());
			   pds.put("R_NAME_CN", roleList.get(i-1).getROLE_NAME());
			   
			   varList.add(pds);
			   r=true;
		   }
		}*/
		
		mv.setViewName("system/conf_config/conf_config_list");
		mv.addObject("varList", varList);
		//mv.addObject("roleList", roleList);
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
		pd.put("ROLE_ID", "4");	
		List<Role> varList = roleService.listAllRolesByPId(pd);		//列出此组下架角色
		
		mv.setViewName("system/conf_config/conf_config_edit");
		mv.addObject("msg", "save");
		mv.addObject("varList",varList);
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd = conf_configService.findById(pd);	//根据ID读取
		pd.put("ROLE_ID", "4");	
		List<Role> varList = roleService.listAllRolesByPId(pd);		//列出此组下架角色
		
		mv.setViewName("system/conf_config/conf_config_edit");
		mv.addObject("msg", "edit");
		mv.addObject("varList",varList);
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Conf_Config");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			conf_configService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	
	 /**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Conf_Config到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("ID");	//1
		titles.add("监测点ID");	//2
		titles.add("监测点名称");	//3
		titles.add("纬度");	//4
		titles.add("经度");	//5
		titles.add("人数");	//6
		titles.add("人均日水量");	//7
		titles.add("系数");	//8
		titles.add("地址");	//9
		titles.add("照片");	//10
		titles.add("安装形式");	//11
		titles.add("电话");	//12
		titles.add("地区");	//13
		titles.add("运营单位");	//14
		titles.add("运营单位联系人");	//15
		titles.add("建设状态");	//16
		titles.add("监测类型");	//17
		titles.add("流域");	//18
		dataMap.put("titles", titles);
		List<PageData> varOList = conf_configService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).get("ID").toString());	//1
			vpd.put("var2", varOList.get(i).get("R_ID").toString());	//2
			vpd.put("var3", varOList.get(i).getString("R_NAME_CN"));	    //3
			vpd.put("var4", varOList.get(i).getString("R_LAT"));	    //4
			vpd.put("var5", varOList.get(i).getString("R_LON"));	    //5
			vpd.put("var6", varOList.get(i).get("R_N").toString());	//6
			vpd.put("var7", varOList.get(i).getString("R_Q"));	    //7
			vpd.put("var8", varOList.get(i).getString("R_K"));	    //8
			vpd.put("var9", varOList.get(i).getString("R_ADDRESS"));	    //9
			vpd.put("var10", varOList.get(i).getString("R_PHOTO"));	    //10
			vpd.put("var11", varOList.get(i).getString("R_INSTALL"));	    //11
			vpd.put("var12", varOList.get(i).getString("R_TELEPHONE"));	    //12
			vpd.put("var13", varOList.get(i).getString("R_REGION"));	    //13
			vpd.put("var14", varOList.get(i).getString("R_OPERATING"));	    //14
			vpd.put("var15", varOList.get(i).getString("R_CONTACT"));	    //15
			vpd.put("var16", varOList.get(i).getString("R_BUILD"));	    //16
			vpd.put("var17", varOList.get(i).getString("R_WATERTYPE"));	    //17
			vpd.put("var18", varOList.get(i).getString("R_BASIN"));	    //18
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
