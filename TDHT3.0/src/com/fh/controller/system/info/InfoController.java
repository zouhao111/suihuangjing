package com.fh.controller.system.info;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.system.Menu;
import com.fh.service.system.conf_config.Conf_ConfigManager;
import com.fh.service.system.info.InfoManager;
import com.fh.service.system.rid_device.Rid_DeviceManager;
import com.fh.util.Const;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelRead;
import com.fh.util.PageData;

@Controller
public class InfoController extends BaseController {
	
	String menuUrl = "info/listInfo.do"; //菜单地址(权限用)
	@Resource(name="conf_configService")
	private Conf_ConfigManager configService;
	@Resource(name="rid_deviceService")
	private Rid_DeviceManager deviceService;
	@Resource(name="infoService")
	private InfoManager infoService;
	
	
	/**
	 * 进入水量页面
	 * @return
	 */
	@RequestMapping(value="/listInfo")
	public ModelAndView listQuality(HttpServletRequest request,Page page,String ROLE_NAME,String MENU_ID,String R_ID,String MENU_IDS) throws Exception{
		
		ModelAndView mv = this.getModelAndView();
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
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("R_ID", R_ID);
		

		String filepath="E:/info/"+R_ID; //文件路径
		 String filename=R_ID+".xls"; //文件名
		 int startrow =0;//开始行号
		 int startcol=0; //开始列号
		 int sheetnum=0; //sheet
		
		List<Object> infojson=ObjectExcelRead.readExcel(filepath, filename, startrow, startcol, sheetnum);
		for(int i=0;i<infojson.size();i++){
			mv.addObject("infojson"+i,infojson.get(i));
		}
		 
		PageData com=configService.findById(pd);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		com.put("R_WATER_STR_TIME", sdf.format(com.getDate("R_WATER_STR_TIME")));
		com.put("R_QUALITY_STR_TIME", sdf.format(com.getDate("R_QUALITY_STR_TIME")));
		
		List<PageData>  DID=deviceService.listAllByR_Id(pd);
		String dID="";//控制器ID
		String calc="";//水平衡计算
		String cabin="";//机舱编号

		for(int i=0;i<DID.size();i++){
			long b=DID.get(i).getLong("DEVICE_ID");
			String c=DID.get(i).getString("DEVICE_NAME_CN");
			dID=b+" "+c+";<br />"+dID;
			
			if(DID.get(i).getInteger("BALANCE_CALC")==1){
				calc=DID.get(i).getString("DEVICE_NAME_CN")+";"+calc;
			}
			if(i!=DID.size()-1){
				if(DID.get(i).getString("CABIN_ID").equals(DID.get(i+1).getString("CABIN_ID"))){
					cabin=DID.get(i).getString("CABIN_ID")+";"+cabin;
				}
			}
		}
		page.setPd(pd);
		List<PageData>  qList=infoService.listQuality(page);//污染物种类
		List<PageData>  cList=infoService.listControl(page);//控制
		
		
		mv.addObject("menuUrl","listInfo.do?MENU_ID="+MENU_ID+"&MENU_IDS="+MENU_IDS+"&R_ID=");
		mv.setViewName("system/info/info_list");
		mv.addObject("com",com);
		mv.addObject("R_ID",R_ID);
		mv.addObject("dID",dID);
		mv.addObject("calc",calc);
		mv.addObject("cabin",cabin);
		mv.addObject("qList",qList);
		mv.addObject("cList",cList);
		mv.addObject("infojson",infojson);
		return mv;
	}
	
	
}
