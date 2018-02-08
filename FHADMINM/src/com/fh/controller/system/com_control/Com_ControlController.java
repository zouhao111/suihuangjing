package com.fh.controller.system.com_control;

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
import com.fh.service.system.com_control.Com_ControlManager;
import com.fh.service.system.conf_param.Conf_paramManager;
import com.fh.service.system.control_action.Control_ActionManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;

/** 
 * 说明：公司控制参数
 * 创建人：FH Q313596790
 * 创建时间：2017-09-23
 */
@Controller
@RequestMapping(value="/com_control")
public class Com_ControlController extends BaseController {
	
	String menuUrl = "com_control/list.do"; //菜单地址(权限用)
	@Resource(name="com_controlService")
	private Com_ControlManager com_controlService;
	@Resource(name="conf_paramService")
	private Conf_paramManager conf_paramService;
	@Resource(name="control_actionService")
	private Control_ActionManager control_actionService;
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Com_Control");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("COM_CONTROL_ID", this.get32UUID());	//主键
		/*pd.put("C_IS_BIT", "0");	//是否按位  0否  1是
		pd.put("C_BIT_NUM", "0");	//位数
*/		com_controlService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除Com_Control");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		com_controlService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Com_Control");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		com_controlService.edit(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"列表Com_Control");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = com_controlService.list(page);	//列出Com_Control列表
		mv.setViewName("system/com_control/com_control_list");
		mv.addObject("varList", varList);
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
		
		List<PageData>controlList=conf_paramService.listAll_pd_control(pd);
		
		List<PageData>	control_actionList = control_actionService.listAll(pd);	//列出Control_Action列表
		
		for(int i=0;i<controlList.size();i++){
			for(int a=0;a<control_actionList.size();a++){
				if(controlList.get(i).getString("PARAM_NAME").equals(control_actionList.get(a).getString("C_PARAM_NAME"))){
					controlList.get(i).put("ACTION_ORDER",control_actionList.get(a).getString("ACTION_ORDER") );
				}
			}
		}
		
		
		mv.setViewName("system/com_control/com_control_edit");
		mv.addObject("msg", "save");
		mv.addObject("controlList", controlList);
		mv.addObject("control_actionList", control_actionList);
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
		pd = com_controlService.findById(pd);	//根据ID读取
        List<PageData>controlList=conf_paramService.listAll_pd_control(pd);
		List<PageData>	control_actionList = control_actionService.listAll(pd);	//列出Control_Action列表
		
		for(int i=0;i<controlList.size();i++){
			for(int a=0;a<control_actionList.size();a++){
				if(controlList.get(i).getString("PARAM_NAME").equals(control_actionList.get(a).getString("C_PARAM_NAME"))){
					controlList.get(i).put("ACTION_ORDER",control_actionList.get(a).getString("ACTION_ORDER") );
				}
			}
		}
		mv.setViewName("system/com_control/com_control_edit");
		mv.addObject("msg", "edit");
		mv.addObject("controlList", controlList);
		mv.addObject("control_actionList", control_actionList);
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Com_Control");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			com_controlService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出Com_Control到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("id");	//1
		titles.add("rid");	//2
		titles.add("参数名称");	//3
		titles.add("动作描述");	//4
		titles.add("写值");	//5
		titles.add("是否按位  0否  1是");	//6
		titles.add("位数");	//7
		titles.add("状态");	//8
		dataMap.put("titles", titles);
		List<PageData> varOList = com_controlService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).get("ID").toString());	//1
			vpd.put("var2", varOList.get(i).get("R_ID").toString());	//2
			vpd.put("var3", varOList.get(i).getString("PARAM_NAME"));	    //3
			vpd.put("var4", varOList.get(i).getString("CONTROL_ACTION_STR"));	    //4
			vpd.put("var5", varOList.get(i).get("CONTROL_VALUE").toString());	//5
			vpd.put("var6", varOList.get(i).get("C_IS_BIT").toString());	//6
			vpd.put("var7", varOList.get(i).get("C_BIT_NUM").toString());	//7
			vpd.put("var8", varOList.get(i).getString("ACTION_ORDER"));	    //8
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
