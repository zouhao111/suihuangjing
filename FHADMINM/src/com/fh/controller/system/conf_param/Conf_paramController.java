package com.fh.controller.system.conf_param;

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
import com.fh.service.system.conf_param.Conf_paramManager;
import com.fh.service.system.poll_type.POLL_TYPEManager;
import com.fh.service.system.rid_device.Rid_DeviceManager;
import com.fh.util.AppUtil;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;

/** 
 * 说明：公司污染物小数点限值
 * 创建人：FH Q313596790
 * 创建时间：2017-07-03
 */
@Controller
@RequestMapping(value="/conf_param")
public class Conf_paramController extends BaseController {
	
	String menuUrl = "conf_param/list.do"; //菜单地址(权限用)
	@Resource(name="conf_paramService")
	private Conf_paramManager conf_paramService;
	@Resource(name="rid_deviceService")
	private Rid_DeviceManager rid_deviceService;
	@Resource(name="poll_typeService")
	private POLL_TYPEManager poll_typeService;
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Conf_param");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String DEVICE_ID= pd.getString("DEVICE_ID");
		
		List<PageData> DevList=conf_paramService.listAllByDev(pd);
		if(DevList.size()!=0){
			pd.put("PARAM_ID", (Long)DevList.get(0).get("PARAM_ID")+1);	//主键
			
		}else{
			pd.put("PARAM_ID", Long.parseLong(DEVICE_ID+"0001") );	//主键
			
		}
		
	//	pd.put("CONF_PARAM_ID", this.get32UUID());	//主键
		conf_paramService.save(pd);
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
		logBefore(logger, Jurisdiction.getUsername()+"删除Conf_param");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		conf_paramService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Conf_param");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		conf_paramService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表 水质
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Conf_param");
		
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String s=pd.getString("TYPES");
		int ss=Integer.parseInt(s);
		if(ss==1){
		return	list_water(page);
		}else if(ss==2){
			return	list_poll(page);
		}else if(ss==5){
			return	list_other(page);
		}else {
			return	list_control(page);
		}
		
		
	}
	/**列表 水质
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list_poll")
	public ModelAndView list_poll(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Conf_param");
		
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		//pd.put("TYPES", pd.getString("TYPES"));
		page.setPd(pd);
		List<PageData>	varList = conf_paramService.list(page);	//列出Conf_param列表
		mv.setViewName("system/conf_param/conf_param_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("page", page);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	/**列表 水量
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list_water")
	public ModelAndView list_water(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Conf_param");
		
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		//pd.put("TYPES", pd.getString("TYPES"));
		page.setPd(pd);
		List<PageData>	varList = conf_paramService.list_water(page);	//列出Conf_param列表
		mv.setViewName("system/conf_param/conf_param_list_water");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("page", page);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	/**列表 其他参数
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list_other")
	public ModelAndView list_other(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Conf_param");
		
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		//pd.put("TYPES", pd.getString("TYPES"));
		page.setPd(pd);
		List<PageData>	varList = conf_paramService.list_other(page);	//列出Conf_param列表
		mv.setViewName("system/conf_param/conf_param_list_other");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("page", page);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	/**列表 水量
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list_control")
	public ModelAndView list_control(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Conf_param");
		
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		//pd.put("TYPES", pd.getString("TYPES"));
		page.setPd(pd);
		List<PageData>	varList = conf_paramService.list_control(page);	//列出Conf_param列表
		mv.setViewName("system/conf_param/conf_param_list_control");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
		mv.addObject("page", page);
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
		
		List<PageData>	varList = rid_deviceService.listAllByR_Id(pd);	//列出Rid_Device列表
		
		List<PageData>	pd_List = conf_paramService.listAll_pd(pd);	//列出Conf_param列表
		
		List<PageData>	pollList = poll_typeService.listAll_poll(pd);	//列出Poll_Type列表
	//	List<PageData>	pollList =new ArrayList<PageData>(pollLists.size());
		
		
		List<String>data_TypesList=new ArrayList<String>();
		data_TypesList.add("INT");
		data_TypesList.add("UINT");
		data_TypesList.add("DINT");
		data_TypesList.add("UDINT");
		data_TypesList.add("FLOAT");
		List<String>byte_orderList=new ArrayList<String>();
		byte_orderList.add("FFH1 FFH2 FFH3 FFH4");
		byte_orderList.add("FFH2 FFH1 FFH4 FFH3");
		byte_orderList.add("FFH3 FFH4 FFH1 FFH2");
		byte_orderList.add("FFH4 FFH3 FFH2 FFH1");
		/*for(int a=0;a<varList.size();a++){
			varList.get(a).put("data_TypesList", data_TypesList);
			varList.get(a).put("byte_orderList", byte_orderList);
			
		}*/
		
		
		for(int i=0;i<pd_List.size();i++){
			for(int j=0;j<pollList.size();j++){
				if(pd_List.get(i).getString("PARAM_NAME").equals(pollList.get(j).getString("PARAM_NAME"))){
					pollList.remove(j);
				}
			}
		}
		
		mv.setViewName("system/conf_param/conf_param_Addedit");
		mv.addObject("msg", "save");
		mv.addObject("varList", varList);
		mv.addObject("pd_List", pd_List);
		mv.addObject("pollList", pollList);
		mv.addObject("data_TypesList", data_TypesList);
		mv.addObject("byte_orderList", byte_orderList);
		mv.addObject("pd", pd);
		return mv;
	}	
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd_water")
	public ModelAndView goAdd_water()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		List<PageData>	varList = rid_deviceService.listAllByR_Id(pd);	//列出Rid_Device列表
		
		List<PageData>	pd_List = conf_paramService.listAll_pd_water(pd);	//列出Conf_param列表
		
		List<PageData>	pollList = poll_typeService.listAll_water(pd);	//列出Poll_Type列表
	//	List<PageData>	pollList =new ArrayList<PageData>(pollLists.size());
		
			
		
		for(int i=0;i<pd_List.size();i++){
			for(int j=0;j<pollList.size();j++){
				if(pd_List.get(i).getString("PARAM_NAME").equals(pollList.get(j).getString("PARAM_NAME"))){
					pollList.remove(j);
				}
			}
		}
		List<String>data_TypesList=new ArrayList<String>();
		data_TypesList.add("INT");
		data_TypesList.add("UINT");
		data_TypesList.add("DINT");
		data_TypesList.add("UDINT");
		data_TypesList.add("FLOAT");
		List<String>byte_orderList=new ArrayList<String>();
		byte_orderList.add("FFH1 FFH2 FFH3 FFH4");
		byte_orderList.add("FFH2 FFH1 FFH4 FFH3");
		byte_orderList.add("FFH3 FFH4 FFH1 FFH2");
		byte_orderList.add("FFH4 FFH3 FFH2 FFH1");
		mv.addObject("data_TypesList", data_TypesList);
		mv.addObject("byte_orderList", byte_orderList);
		mv.setViewName("system/conf_param/conf_param_Addedit");
		mv.addObject("msg", "save");
		mv.addObject("varList", varList);
		mv.addObject("pd_List", pd_List);
		mv.addObject("pollList", pollList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd_other")
	public ModelAndView goAdd_other()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		List<PageData>	varList = rid_deviceService.listAllByR_Id(pd);	//列出Rid_Device列表
		
		List<PageData>	pd_List = conf_paramService.listAll_pd_other(pd);	//列出Conf_param列表
		
		List<PageData>	pollList = poll_typeService.listAll_other(pd);	//列出Poll_Type列表
	//	List<PageData>	pollList =new ArrayList<PageData>(pollLists.size());
		
			
		
		for(int i=0;i<pd_List.size();i++){
			for(int j=0;j<pollList.size();j++){
				if(pd_List.get(i).getString("PARAM_NAME").equals(pollList.get(j).getString("PARAM_NAME"))){
					pollList.remove(j);
				}
			}
		}
		List<String>data_TypesList=new ArrayList<String>();
		data_TypesList.add("INT");
		data_TypesList.add("UINT");
		data_TypesList.add("DINT");
		data_TypesList.add("UDINT");
		data_TypesList.add("FLOAT");
		List<String>byte_orderList=new ArrayList<String>();
		byte_orderList.add("FFH1 FFH2 FFH3 FFH4");
		byte_orderList.add("FFH2 FFH1 FFH4 FFH3");
		byte_orderList.add("FFH3 FFH4 FFH1 FFH2");
		byte_orderList.add("FFH4 FFH3 FFH2 FFH1");
		mv.addObject("data_TypesList", data_TypesList);
		mv.addObject("byte_orderList", byte_orderList);
		mv.setViewName("system/conf_param/conf_param_Addedit");
		mv.addObject("msg", "save");
		mv.addObject("varList", varList);
		mv.addObject("pd_List", pd_List);
		mv.addObject("pollList", pollList);
		mv.addObject("pd", pd);
		return mv;
	}
	
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd_control")
	public ModelAndView goAdd_control()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		
		List<PageData>	varList = rid_deviceService.listAllByR_Id(pd);	//列出Rid_Device列表
		
		List<PageData>	pd_List = conf_paramService.listAll_pd_control(pd);	//列出Conf_param列表
		
		List<PageData>	pollList = poll_typeService.listAll_control(pd);	//列出Poll_Type列表
	//	List<PageData>	pollList =new ArrayList<PageData>(pollLists.size());
		
			
		
		for(int i=0;i<pd_List.size();i++){
			for(int j=0;j<pollList.size();j++){
				if(pd_List.get(i).getString("PARAM_NAME").equals(pollList.get(j).getString("PARAM_NAME"))){
					pollList.remove(j);
				}
			}
		}
		List<String>data_TypesList=new ArrayList<String>();
		data_TypesList.add("INT");
		data_TypesList.add("UINT");
		data_TypesList.add("DINT");
		data_TypesList.add("UDINT");
		data_TypesList.add("FLOAT");
		List<String>byte_orderList=new ArrayList<String>();
		byte_orderList.add("FFH1 FFH2 FFH3 FFH4");
		byte_orderList.add("FFH2 FFH1 FFH4 FFH3");
		byte_orderList.add("FFH3 FFH4 FFH1 FFH2");
		byte_orderList.add("FFH4 FFH3 FFH2 FFH1");
		mv.addObject("data_TypesList", data_TypesList);
		mv.addObject("byte_orderList", byte_orderList);
		mv.setViewName("system/conf_param/conf_param_Addedit");
		mv.addObject("msg", "save");
		mv.addObject("varList", varList);
		mv.addObject("pd_List", pd_List);
		mv.addObject("pollList", pollList);
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
		pd = conf_paramService.findById(pd);	//根据ID读取
		List<PageData>	varList = rid_deviceService.listAllByR_Id(pd);	//列出Rid_Device列表
		List<String>data_TypesList=new ArrayList<String>();
		data_TypesList.add("INT");
		data_TypesList.add("UINT");
		data_TypesList.add("DINT");
		data_TypesList.add("UDINT");
		data_TypesList.add("FLOAT");
		List<String>byte_orderList=new ArrayList<String>();
		byte_orderList.add("FFH1 FFH2 FFH3 FFH4");
		byte_orderList.add("FFH2 FFH1 FFH4 FFH3");
		byte_orderList.add("FFH3 FFH4 FFH1 FFH2");
		byte_orderList.add("FFH4 FFH3 FFH2 FFH1");
		mv.addObject("data_TypesList", data_TypesList);
		mv.addObject("byte_orderList", byte_orderList);
		mv.setViewName("system/conf_param/conf_param_edit");
		mv.addObject("msg", "edit");
		mv.addObject("varList", varList);
		
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
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Conf_param");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			conf_paramService.deleteAll(ArrayDATA_IDS);
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
		logBefore(logger, Jurisdiction.getUsername()+"导出Conf_param到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("参数中文名称");	//1
		titles.add("参数ID");	//2
		titles.add("modbus点位");	//3
		titles.add("数据类型");	//4
		titles.add("高低位排序");	//5
		titles.add("scale_factor");	//6
		titles.add("偏移值");	//7
		titles.add("预警上限");	//8
		titles.add("报警上限");	//9
		titles.add("报警上限");	//10
		titles.add("报警下限");	//11
		titles.add("参数初始值");	//12
		titles.add("时间类型");	//13
		titles.add("时间整形");	//14
		titles.add("可见1  不可见0");	//15
		titles.add("1有上下限  0没有上下限");	//16
		titles.add("decimal_number");	//17
		dataMap.put("titles", titles);
		List<PageData> varOList = conf_paramService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).getString("PARAM_NAME"));	    //1
			vpd.put("var2", varOList.get(i).get("PARAM_NAME_NUMB").toString());	//2
			vpd.put("var3", varOList.get(i).get("MODBUS_ADDR").toString());	//3
			vpd.put("var4", varOList.get(i).getString("DATA_TYPES"));	    //4
			vpd.put("var5", varOList.get(i).getString("BYTE_ORDER"));	    //5
			vpd.put("var6", varOList.get(i).getString("SCALE_FACTOR"));	    //6
			vpd.put("var7", varOList.get(i).getString("OFFSET_VALUE"));	    //7
			vpd.put("var8", varOList.get(i).getString("LIMITH"));	    //8
			vpd.put("var9", varOList.get(i).getString("LIMITHH"));	    //9
			vpd.put("var10", varOList.get(i).getString("LIMITL"));	    //10
			vpd.put("var11", varOList.get(i).getString("LIMITLL"));	    //11
			vpd.put("var12", varOList.get(i).getString("PARAM_VALUE"));	    //12
			vpd.put("var13", varOList.get(i).getString("STR_TIME"));	    //13
			vpd.put("var14", varOList.get(i).get("SY_TIME").toString());	//14
			vpd.put("var15", varOList.get(i).get("PARAM_ABLE").toString());	//15
			vpd.put("var16", varOList.get(i).get("LIMIT_ABLE").toString());	//16
			vpd.put("var17", varOList.get(i).get("DECIMAL_NUMBER").toString());	//17
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
