package com.erich.saleticket.controllers.api.bitou;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import com.erich.saleticket.biz.tdht.BalanceWaterBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.controllers.admin.tdht.HttpUtils;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.MobileData;
import com.erich.saleticket.model.tdht.BalanceWater;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewLog;
import com.erich.saleticket.model.tdht.ViewSampling;
import com.erich.saleticket.model.tdht.ViewTraffic;
import com.erich.saleticket.model.tdht.ViewWaterquality;
import com.erich.saleticket.model.tdht.ViewZtraffic;
import com.erich.saleticket.model.tdht.ViewfirstTab;

public class DataController extends BaseController{

	
	@Resource
	private DataBiz dataBiz;
	@Resource
	private BalanceWaterBiz balanceBizs;
	
	
	@Get("dataList")
	@Post("dataList")
	public String DataControllerPollutant(ViewCompanyconfig companyconfigs, HttpServletRequest request, HttpServletResponse response)throws ParseException   {
		MobileData<Object> result = new MobileData<Object>(ApiResultcode._0);
		
		if(companyconfigs.getRid()==75501330008l){
			companyconfigs.setRid(75501330008l);
		}else if(companyconfigs.getRid()==75501330009l){
			companyconfigs.setRid(75501330009l);
		}else if(companyconfigs.getRid()==75501330010l){
			companyconfigs.setRid(75501330010l);
		}else if(companyconfigs.getRid()==75501330011l){
			companyconfigs.setRid(75501330011l);
		}else if(companyconfigs.getRid()==75501330012l){
			companyconfigs.setRid(75501330012l);
		}else{
			companyconfigs.setRid(75501330008l);
		}
		
		Pollutant pollutant_copy=new Pollutant();
		//response.setHeader("refresh", "20");//设置refresh响应头控制浏览器每隔20秒钟刷新一次
		Long rid=companyconfigs.getRid();
		
		
		
		ViewWaterquality waterquality=dataBiz.selectByWaterquality(rid);//查询水质监测
		List<ViewTraffic>	dataTraffic=dataBiz.selectByTraffic(rid);//查询流量监测数据  数据类型 1、工业给水,2、生活给水，3、工业排水，4、生活排水
		ViewfirstTab	data;//
		if(rid==75501330008l||rid==75501330009l){
			data=dataBiz.selectFirstTab3(rid);//
		}else{
			data=dataBiz.selectFirstTab(rid);//
		}
		ViewfirstTab	datas=dataBiz.selectFirstTab2(rid);//昨日流量
		ViewfirstTab	data_id=dataBiz.selectFirstTab_id(rid);//今日流量
		ViewfirstTab	data_is=dataBiz.selectFirstTab_is(rid);//今日流量
		ViewfirstTab	data_ls=dataBiz.selectFirstTab_ls(rid);//今日流量
		if(datas!=null&&data!=null){
		data.setIndustrialdrainage(datas.getIndustrialdrainage());
		data.setIndustrialsupply(datas.getIndustrialsupply());
		data.setLivingsupply(datas.getLivingsupply());
		}
		if(data_ls!=null){
			data.setIs_sub_ztraffic(data_is.getIs_sub_ztraffic());
			}
		if(data_id!=null){
			data.setId_sub_ztraffic(data_id.getId_sub_ztraffic());
			
			}
		if(data_is!=null){
			data.setIs_sub_ztraffic(data_is.getIs_sub_ztraffic());
			}
		
		//ViewZtraffic ztraffic=dataBiz.selectByztraffic(rid);//流量汇总
		ViewZtraffic ztraffic=new ViewZtraffic();
		BalanceWater balance=new BalanceWater();
		balance.setRid(rid);
		
		List<BalanceWater>	balances = balanceBizs.BalanceList(balance);
		
		if(balances.size()>0){
		int s=balances.size()-1;
		ztraffic.setLossAmount(balances.get(s).getTotalwastage());
		ztraffic.setUnknown(balances.get(s).getTotalunknow());
		ztraffic.setLossLimit(balances.get(s).getTotalLossLimit());
		}else{
			ztraffic.setLossAmount(0.0);
			ztraffic.setUnknown(0.0);
			ztraffic.setLossLimit(0.0);
		}
		if(ztraffic!=null){
		ztraffic.setDrainageIndustrial(data.getId_ztraffic());
		ztraffic.setSupplyLiving(data.getLs_ztraffic());
		ztraffic.setSupplyIndustrial(data.getIs_ztraffic());
		if(rid.toString().equals("75501330004")||rid.toString().equals("75501330008")||rid.toString().equals("75501330009")){
			ztraffic.setLossLimit(data.getIs_ztraffic()*0.15);
		}
		}
		//ViewZtraffic ztraffic2=dataBiz.selectBycoeffiztraffic(rid);// 流量汇总系数
		ViewZtraffic ztraffic2=new ViewZtraffic();// 流量汇总系数
		if(ztraffic!=null&&ztraffic2!=null){
			Double d;
			if(rid.toString().equals("75501330004")||rid.toString().equals("75501330008")||rid.toString().equals("75501330009")){
				d=ztraffic.getSupplyIndustrial();
			}else{
		 d=ztraffic.getSupplyIndustrial()+ztraffic.getSupplyLiving();
			}
		    if(d!=0){
		    	ztraffic2.setSupplyIndustrial(fixed(ztraffic.getSupplyIndustrial()/d, 2));
				ztraffic2.setSupplyLiving(fixed(ztraffic.getSupplyLiving()/d, 2));
				ztraffic2.setDrainageIndustrial(fixed(ztraffic.getDrainageIndustrial()/d, 2));
				ztraffic2.setLossLimit(fixed(ztraffic.getLossLimit()/d, 2));
				ztraffic2.setLossAmount(fixed(ztraffic.getLossAmount()/d, 2));
				ztraffic2.setUnknown(fixed(ztraffic.getUnknown()/d, 2));
		    }
		
		}
		ViewCompanyconfig companyconfig=dataBiz.selectBycompanyconfig(companyconfigs);
		


		Pollutant pollutantss= dataBiz.selectByPollutant3(rid);//基本信息
		
		if(pollutantss==null){
			pollutantss=pollutant_copy;
		}else{
			pollutant_copy=	pollutantss;
		}
		//Pollutant pollutants=dataBiz.selectByPollutant2(rid);//基本信息
		//List<Pollutant> pollutantss=dataBiz.selectByPollutant3(rid);//基本信息
		ViewTraffic data1=null;
		ViewTraffic data2=null;
		ViewTraffic data3=null;
		ViewTraffic data4=null;
		
		for(ViewTraffic vt: dataTraffic){
			if(vt.getDateType()==1){
				data1=vt;//工业给水
				}
			if(vt.getDateType()==2){
				data2=vt;//生活给水
			}
			if(vt.getDateType()==3){
				data3=vt;//工业排水
			}
			if(vt.getDateType()==4){
				data4=vt;//生活排水
			}
		}
		
		StringBuffer webUrl=request.getRequestURL();
		
		List<Object>list=new ArrayList<Object>();

		List<Object> list0= new ArrayList<Object>();
		list0.add(waterquality);//水质监测
		waterquality.setRealPh(fixed(waterquality.getRealPh(), 1));//ph
		waterquality.setLastDayMaxPh(fixed(waterquality.getLastDayMaxPh(), 1));//ph最大
		waterquality.setLastDayMinPh(fixed(waterquality.getLastDayMinPh(), 1));//ph最小
		waterquality.setRealConductivity(fixed(waterquality.getRealConductivity(), 1));//电导率
		waterquality.setLastDayMaxConductivity(fixed(waterquality.getLastDayMaxConductivity(), 1));//
		waterquality.setLastDayMinConductivity(fixed(waterquality.getLastDayMinConductivity(), 1));
		waterquality.setRealCod(fixed(waterquality.getRealCod(), 0));//COD
		waterquality.setLastDayMaxCod(fixed(waterquality.getLastDayMaxCod(), 0));
		waterquality.setLastDayMinCod(fixed(waterquality.getLastDayMinCod(), 0));
		
		try {
		pollutantss.setRealcod(fixed(pollutantss.getRealcod(), 0));//cod
		pollutantss.setMaxcod(fixed(pollutantss.getMaxcod(), 0));
		pollutantss.setMincod(fixed(pollutantss.getMincod(), 0));
		/*if(rid.toString().equals("75501330004")){
			pollutantss.setRealnh4(-9999.99);//氨氮
			pollutantss.setMaxnh4(-9999.99);
			pollutantss.setMinnh4(-9999.99);
		}else{*/
			pollutantss.setRealnh4(fixed(pollutantss.getRealnh4(), 3));//氨氮
			pollutantss.setMaxnh4(fixed(pollutantss.getMaxnh4(), 3));
			pollutantss.setMinnh4(fixed(pollutantss.getMinnh4(), 3));
		//}
		
			
			pollutantss.setRealcr6(fixed(pollutantss.getRealcr6(), 4));//六价铬
			pollutantss.setMaxcr6(fixed(pollutantss.getMaxcr6(), 4));
			pollutantss.setMincr6(fixed(pollutantss.getMincr6(), 4));
			pollutantss.setRealmlss(fixed(pollutantss.getRealmlss(), 0));//固体悬浮物
			pollutantss.setMaxmlss(fixed(pollutantss.getMaxmlss(), 0));
			pollutantss.setMinmlss(fixed(pollutantss.getMinmlss(), 0));
			waterquality.setRealTemp(fixed(waterquality.getRealTemp(), 1));//温度
			waterquality.setLastDayMaxTemp(fixed(waterquality.getLastDayMaxTemp(), 1));
			waterquality.setLastDayMaxTemp(fixed(waterquality.getLastDayMaxTemp(), 1));
			pollutantss.setRealphosphor(fixed(pollutantss.getRealphosphor(), 3));//总磷
			pollutantss.setMaxphosphor(fixed(pollutantss.getMaxphosphor(), 3));
			pollutantss.setMinphosphor(fixed(pollutantss.getMinphosphor(), 3));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//list.add(list0);
		
		List<Object> list1= new ArrayList<Object>();
		list1.add(ztraffic);//水平衡分析
		if(ztraffic !=null){
			ztraffic.setSupplyIndustrial(fixed(ztraffic.getSupplyIndustrial(), 1));
			ztraffic.setSupplyLiving(fixed(ztraffic.getSupplyLiving(), 1));
			ztraffic.setDrainageIndustrial(fixed(ztraffic.getDrainageIndustrial(), 1));
			ztraffic.setLossLimit(fixed(ztraffic.getLossLimit(), 1));
			ztraffic.setLossAmount(fixed(ztraffic.getLossAmount(), 1));
			ztraffic.setUnknown(fixed(ztraffic.getUnknown(), 1));
		}
		
		//list.add(list1);
		
		List<Object> list2= new ArrayList<Object>();
		list2.add(ztraffic2);//流量汇总系数
		//list.add(list2);
		
		List<Object> list3= new ArrayList<Object>();
		list3.add(companyconfig);//公司信息
		//list.add(list3);
		
		List<Object> list10= new ArrayList<Object>();
		list10.add(pollutantss);//WTW基本信息
		//list.add(list10);
		
		
		List<Object> list11= new ArrayList<Object>();
		data.setLs_waterlevel(0.00);
		data.setWaterlevel(fixed(data.getWaterlevel(), 3));//水位
		data.setIs_CurrentSpeed(fixed(data.getIs_CurrentSpeed(), 3));//流速
		data.setLs_CurrentSpeed(fixed(data.getLs_CurrentSpeed(),3));//流速
		data.setId_CurrentSpeed(fixed(data.getId_CurrentSpeed(), 3));//流速
		data.setIs_traffic(fixed(data.getIs_traffic(), 4));//流量速率
		data.setLs_traffic(fixed(data.getLs_traffic(), 4));//流量速率
		data.setId_traffic(fixed(data.getId_traffic(), 4));//流量速率
		if(data.getIs_sub_ztraffic()!=null){
			data.setIs_sub_ztraffic(fixed(data.getIs_sub_ztraffic(), 1));//今日流量
		}else{
			data.setIs_sub_ztraffic(0.0);//今日流量
		}
		if(data.getLs_sub_ztraffic()!=null){
			data.setLs_sub_ztraffic(fixed(data.getLs_sub_ztraffic(), 1));//今日流量
		}else{
			data.setLs_sub_ztraffic(0.0);
		}
		if(data.getId_sub_ztraffic()!=null){
			data.setId_sub_ztraffic(fixed(data.getId_sub_ztraffic(), 1));//今日流量
		}else{
			data.setId_sub_ztraffic(0.0);
		}
		
		
		if(data.getIndustrialsupply()!=null){
			data.setIndustrialsupply(fixed(data.getIndustrialsupply(),1));//昨日流量
		}else{
			data.setIndustrialsupply(0.0);//昨日流量
		}
		if(data.getLivingsupply()!=null){
			data.setLivingsupply(fixed(data.getLivingsupply(),1));//昨日流量
		}else{
			data.setLivingsupply(0.0);//昨日流量
		}
		if(data.getIndustrialdrainage()!=null){
			data.setIndustrialdrainage(fixed(data.getIndustrialdrainage(),1));//昨日流量
		}else{
			data.setIndustrialdrainage(0.0);//昨日流量
		}
		
		data.setIs_ztraffic(fixed(data.getIs_ztraffic(), 1));//总流量
		data.setLs_ztraffic(fixed(data.getLs_ztraffic(), 1));//总流量
		data.setId_ztraffic(fixed(data.getId_ztraffic(), 1));//总流量
		data.setIs_waterlevel(fixed(data.getIs_waterlevel(), 3));
		data.setId_waterlevel(fixed(data.getId_waterlevel(), 3));
		data.setLs_waterlevel(fixed(data.getLs_waterlevel(), 3));
		
		list11.add(data);//实时监测数据
		//list.add(list11);

		/*list.add(0, waterquality);//水质监测
		list.add(1, ztraffic);//水平衡分析
		list.add(2, ztraffic2);//流量汇总系数
		list.add(3, companyconfig);//公司信息
		list.add(4, url);//URL
		list.add(5, sam1);//手动采样
		list.add(6, sam2);//自动采样
		list.add(7, sam3);//报警采样
		list.add(8, sam4);//远程采样
		list.add(9, pollutants);//污染物汇总信息
		list.add(10, pollutantss);//WTW基本信息
		list.add(11, data);//实时监测数据
*/	
		result.setWaterquality(list0);
		result.setZtraffic(list1);
		result.setZtraffic2(list2);
		result.setCompanyconfig(list3);
		result.setPollutantss(list10);
		result.setData(list11);
		result.init(ApiResultcode._1, "成功");
		return "@" + encodeJson(result);
		
		
	}
	
	
	@Get("dataLists")
	@Post("dataLists")
	public String DataController(ViewCompanyconfig companyconfigs, HttpServletRequest request, HttpServletResponse response)throws ParseException   {
		MobileData<Object> result = new MobileData<Object>(ApiResultcode._0);
		
		if(companyconfigs.getRid()==75501330008l){
			companyconfigs.setRid(75501330008l);
		}else if(companyconfigs.getRid()==75501330009l){
			companyconfigs.setRid(75501330009l);
		}else if(companyconfigs.getRid()==75501330010l){
			companyconfigs.setRid(75501330010l);
		}else if(companyconfigs.getRid()==75501330011l){
			companyconfigs.setRid(75501330011l);
		}else if(companyconfigs.getRid()==75501330012l){
			companyconfigs.setRid(75501330012l);
		}else{
			companyconfigs.setRid(75501330008l);
		}
		
		Pollutant pollutant_copy=new Pollutant();
		//response.setHeader("refresh", "20");//设置refresh响应头控制浏览器每隔20秒钟刷新一次
		Long rid=companyconfigs.getRid();
		
		if(rid==75501330006l){
			String str=HttpUtils.httpURLConectionGET("http://120.76.233.59:8089/api/apitwo/data/wateDataList?rid="+rid+"");
			return "@"+str;
		}
		
		List<ViewSampling>  sampling=dataBiz.selectBySampling(rid);//查询水质采样
		ViewWaterquality waterquality=dataBiz.selectByWaterquality(rid);//查询水质监测
		List<ViewTraffic>	dataTraffic=dataBiz.selectByTraffic(rid);//查询流量监测数据  数据类型 1、工业给水,2、生活给水，3、工业排水，4、生活排水
		ViewfirstTab	data;//
		if(rid==75501330008l||rid==75501330009l){
			data=dataBiz.selectFirstTab3(rid);//
		}else{
			data=dataBiz.selectFirstTab(rid);//
		}
		ViewfirstTab	datas=dataBiz.selectFirstTab2(rid);//昨日流量
		ViewfirstTab	data_id=dataBiz.selectFirstTab_id(rid);//今日流量
		ViewfirstTab	data_is=dataBiz.selectFirstTab_is(rid);//今日流量
		ViewfirstTab	data_ls=dataBiz.selectFirstTab_ls(rid);//今日流量
		if(datas!=null&&data!=null){
		data.setIndustrialdrainage(datas.getIndustrialdrainage());
		data.setIndustrialsupply(datas.getIndustrialsupply());
		data.setLivingsupply(datas.getLivingsupply());
		}
		if(data_ls!=null){
			data.setIs_sub_ztraffic(data_is.getIs_sub_ztraffic());
			}
		if(data_id!=null){
			data.setId_sub_ztraffic(data_id.getId_sub_ztraffic());
			
			}
		if(data_is!=null){
			data.setIs_sub_ztraffic(data_is.getIs_sub_ztraffic());
			}
		
		//ViewZtraffic ztraffic=dataBiz.selectByztraffic(rid);//流量汇总
		ViewZtraffic ztraffic=new ViewZtraffic();
		BalanceWater balance=new BalanceWater();
		balance.setRid(rid);
		
		List<BalanceWater>	balances = balanceBizs.BalanceList(balance);
		
		if(balances.size()>0){
		int s=balances.size()-1;
		ztraffic.setLossAmount(balances.get(s).getTotalwastage());
		ztraffic.setUnknown(balances.get(s).getTotalunknow());
		ztraffic.setLossLimit(balances.get(s).getTotalLossLimit());
		}else{
			ztraffic.setLossAmount(0.0);
			ztraffic.setUnknown(0.0);
			ztraffic.setLossLimit(0.0);
		}
		if(ztraffic!=null){
		ztraffic.setDrainageIndustrial(data.getId_ztraffic());
		ztraffic.setSupplyLiving(data.getLs_ztraffic());
		ztraffic.setSupplyIndustrial(data.getIs_ztraffic());
		if(rid.toString().equals("75501330004")||rid.toString().equals("75501330008")||rid.toString().equals("75501330009")){
			ztraffic.setLossLimit(data.getIs_ztraffic()*0.15);
		}
		}
		//ViewZtraffic ztraffic2=dataBiz.selectBycoeffiztraffic(rid);// 流量汇总系数
		ViewZtraffic ztraffic2=new ViewZtraffic();// 流量汇总系数
		if(ztraffic!=null&&ztraffic2!=null){
			Double d;
			if(rid.toString().equals("75501330004")||rid.toString().equals("75501330008")||rid.toString().equals("75501330009")){
				d=ztraffic.getSupplyIndustrial();
			}else{
		 d=ztraffic.getSupplyIndustrial()+ztraffic.getSupplyLiving();
			}
		    if(d!=0){
		    	ztraffic2.setSupplyIndustrial(fixed(ztraffic.getSupplyIndustrial()/d, 2));
				ztraffic2.setSupplyLiving(fixed(ztraffic.getSupplyLiving()/d, 2));
				ztraffic2.setDrainageIndustrial(fixed(ztraffic.getDrainageIndustrial()/d, 2));
				ztraffic2.setLossLimit(fixed(ztraffic.getLossLimit()/d, 2));
				ztraffic2.setLossAmount(fixed(ztraffic.getLossAmount()/d, 2));
				ztraffic2.setUnknown(fixed(ztraffic.getUnknown()/d, 2));
		    }
		
		}
		ViewCompanyconfig companyconfig=dataBiz.selectBycompanyconfig(companyconfigs);
		


		Pollutant pollutantss= dataBiz.selectByPollutant3(rid);//基本信息
		
		if(pollutantss==null){
			pollutantss=pollutant_copy;
		}else{
			pollutant_copy=	pollutantss;
		}
		//Pollutant pollutants=dataBiz.selectByPollutant2(rid);//基本信息
		Pollutant pollutants=dataBiz.selectByPollutant2(rid);//污染物排放总量
		//List<Pollutant> pollutantss=dataBiz.selectByPollutant3(rid);//基本信息
		ViewTraffic data1=null;
		ViewTraffic data2=null;
		ViewTraffic data3=null;
		ViewTraffic data4=null;
		
		for(ViewTraffic vt: dataTraffic){
			if(vt.getDateType()==1){
				data1=vt;//工业给水
				}
			if(vt.getDateType()==2){
				data2=vt;//生活给水
			}
			if(vt.getDateType()==3){
				data3=vt;//工业排水
			}
			if(vt.getDateType()==4){
				data4=vt;//生活排水
			}
		}
		ViewSampling sam1=null;
		ViewSampling sam2=null;
		ViewSampling sam3=null;
		ViewSampling sam4=null;
		for(ViewSampling vs: sampling){
			if(vs.getSamplingMode()==1){
				sam1=vs;//手动采样
				}
			if(vs.getSamplingMode()==2){
				sam2=vs;//自动采样
			}
			if(vs.getSamplingMode()==3){
				sam3=vs;//报警采样
			}
			if(vs.getSamplingMode()==4){
				sam4=vs;//远程采样
			}
			
		}
	
		
		StringBuffer webUrl=request.getRequestURL();
		String url=webUrl+"?nameId=1";
		
		List<Object>list=new ArrayList<Object>();

		List<Object> list0= new ArrayList<Object>();
		list0.add(waterquality);//水质监测
		waterquality.setRealPh(fixed(waterquality.getRealPh(), 1));//ph
		waterquality.setLastDayMaxPh(fixed(waterquality.getLastDayMaxPh(), 1));//ph最大
		waterquality.setLastDayMinPh(fixed(waterquality.getLastDayMinPh(), 1));//ph最小
		waterquality.setRealConductivity(fixed(waterquality.getRealConductivity(), 1));//电导率
		waterquality.setLastDayMaxConductivity(fixed(waterquality.getLastDayMaxConductivity(), 1));//
		waterquality.setLastDayMinConductivity(fixed(waterquality.getLastDayMinConductivity(), 1));
		waterquality.setRealCod(fixed(waterquality.getRealCod(), 0));//COD
		waterquality.setLastDayMaxCod(fixed(waterquality.getLastDayMaxCod(), 0));
		waterquality.setLastDayMinCod(fixed(waterquality.getLastDayMinCod(), 0));
		
		try {
		pollutantss.setRealcod(fixed(pollutantss.getRealcod(), 0));//cod
		pollutantss.setMaxcod(fixed(pollutantss.getMaxcod(), 0));
		pollutantss.setMincod(fixed(pollutantss.getMincod(), 0));
		/*if(rid.toString().equals("75501330004")){
			pollutantss.setRealnh4(-9999.99);//氨氮
			pollutantss.setMaxnh4(-9999.99);
			pollutantss.setMinnh4(-9999.99);
		}else{*/
			pollutantss.setRealnh4(fixed(pollutantss.getRealnh4(), 3));//氨氮
			pollutantss.setMaxnh4(fixed(pollutantss.getMaxnh4(), 3));
			pollutantss.setMinnh4(fixed(pollutantss.getMinnh4(), 3));
		//}
		
			
			pollutantss.setRealcr6(fixed(pollutantss.getRealcr6(), 4));//六价铬
			pollutantss.setMaxcr6(fixed(pollutantss.getMaxcr6(), 4));
			pollutantss.setMincr6(fixed(pollutantss.getMincr6(), 4));
			pollutantss.setRealmlss(fixed(pollutantss.getRealmlss(), 0));//固体悬浮物
			pollutantss.setMaxmlss(fixed(pollutantss.getMaxmlss(), 0));
			pollutantss.setMinmlss(fixed(pollutantss.getMinmlss(), 0));
			waterquality.setRealTemp(fixed(waterquality.getRealTemp(), 1));//温度
			waterquality.setLastDayMaxTemp(fixed(waterquality.getLastDayMaxTemp(), 1));
			waterquality.setLastDayMaxTemp(fixed(waterquality.getLastDayMaxTemp(), 1));
			pollutantss.setRealphosphor(fixed(pollutantss.getRealphosphor(), 3));//总磷
			pollutantss.setMaxphosphor(fixed(pollutantss.getMaxphosphor(), 3));
			pollutantss.setMinphosphor(fixed(pollutantss.getMinphosphor(), 3));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//list.add(list0);
		
		List<Object> list1= new ArrayList<Object>();
		list1.add(ztraffic);//水平衡分析
		if(ztraffic !=null){
			ztraffic.setSupplyIndustrial(fixed(ztraffic.getSupplyIndustrial(), 1));
			ztraffic.setSupplyLiving(fixed(ztraffic.getSupplyLiving(), 1));
			ztraffic.setDrainageIndustrial(fixed(ztraffic.getDrainageIndustrial(), 1));
			ztraffic.setLossLimit(fixed(ztraffic.getLossLimit(), 1));
			ztraffic.setLossAmount(fixed(ztraffic.getLossAmount(), 1));
			ztraffic.setUnknown(fixed(ztraffic.getUnknown(), 1));
		}
		
		//list.add(list1);
		
		List<Object> list2= new ArrayList<Object>();
		list2.add(ztraffic2);//流量汇总系数
		//list.add(list2);
		
		List<Object> list3= new ArrayList<Object>();
		list3.add(companyconfig);//公司信息
		//list.add(list3);
		
		List<Object> list4= new ArrayList<Object>();
		list4.add(url);//URL
		//list.add(list4);
		
		List<Object> list5= new ArrayList<Object>();
		list5.add(sam1);//手动采样
		//list.add(list5);
		
		List<Object> list6= new ArrayList<Object>();
		list6.add(sam2);//自动采样
		//list.add(list6);
		
		List<Object> list7= new ArrayList<Object>();
		list7.add(sam3);//报警采样
		//list.add(list7);
		
		List<Object> list8= new ArrayList<Object>();
		list8.add(sam4);//远程采样
		//list.add(list8);
		
		List<Object> list9= new ArrayList<Object>();
		list9.add(pollutants);//污染物汇总信息
		
		if(pollutants !=null){
			pollutants.setCod(fixed(pollutants.getCod(), 0));
			pollutants.setToc(fixed(pollutants.getToc(), 2)); //有机碳
			pollutants.setBod(fixed(pollutants.getBod(), 3));//需氧量
			if(rid.toString().equals("75501330004")){
				pollutants.setNh4(-9999.99);
			}else{
				pollutants.setNh4(fixed(pollutants.getNh4(), 3));
			}
			pollutants.setMlss(fixed(pollutants.getMlss(), 1));//污泥浓度
			pollutants.setCr(fixed(pollutants.getCr(), 5)); //铬
			pollutants.setCr6(fixed(pollutants.getCr6(), 4)); //六价铬
			pollutants.setNi(fixed(pollutants.getNi(), 3)); //镍
			pollutants.setCd(fixed(pollutants.getCd(), 2)); //镉
			pollutants.setLead(fixed(pollutants.getLead(), 5)); //铅
			pollutants.setSilver(fixed(pollutants.getSilver(), 3)); //银
			pollutants.setHg(fixed(pollutants.getHg(), 5)); //汞
			pollutants.setPhosphor(fixed(pollutants.getPhosphor(), 3));//磷
			pollutants.setCu(fixed(pollutants.getCu(), 3)); //铜
			pollutants.setZn(fixed(pollutants.getZn(), 3));//锌
			pollutants.setPrussiate(fixed(pollutants.getPrussiate(), 4)); //氰化物
		}
		
		
		List<Object> list10= new ArrayList<Object>();
		list10.add(pollutantss);//WTW基本信息
		//list.add(list10);
		
		List<ViewLog> log = dataBiz.selectByCriteriaData(rid);//操作日志
		
		List<Object> list11= new ArrayList<Object>();
		data.setLs_waterlevel(0.00);
		data.setWaterlevel(fixed(data.getWaterlevel(), 3));//水位
		data.setIs_CurrentSpeed(fixed(data.getIs_CurrentSpeed(), 3));//流速
		data.setLs_CurrentSpeed(fixed(data.getLs_CurrentSpeed(),3));//流速
		data.setId_CurrentSpeed(fixed(data.getId_CurrentSpeed(), 3));//流速
		data.setIs_traffic(fixed(data.getIs_traffic(), 4));//流量速率
		data.setLs_traffic(fixed(data.getLs_traffic(), 4));//流量速率
		data.setId_traffic(fixed(data.getId_traffic(), 4));//流量速率
		if(data.getIs_sub_ztraffic()!=null){
			data.setIs_sub_ztraffic(fixed(data.getIs_sub_ztraffic(), 1));//今日流量
		}else{
			data.setIs_sub_ztraffic(0.0);//今日流量
		}
		if(data.getLs_sub_ztraffic()!=null){
			data.setLs_sub_ztraffic(fixed(data.getLs_sub_ztraffic(), 1));//今日流量
		}else{
			data.setLs_sub_ztraffic(0.0);
		}
		if(data.getId_sub_ztraffic()!=null){
			data.setId_sub_ztraffic(fixed(data.getId_sub_ztraffic(), 1));//今日流量
		}else{
			data.setId_sub_ztraffic(0.0);
		}
		
		
		if(data.getIndustrialsupply()!=null){
			data.setIndustrialsupply(fixed(data.getIndustrialsupply(),1));//昨日流量
		}else{
			data.setIndustrialsupply(0.0);//昨日流量
		}
		if(data.getLivingsupply()!=null){
			data.setLivingsupply(fixed(data.getLivingsupply(),1));//昨日流量
		}else{
			data.setLivingsupply(0.0);//昨日流量
		}
		if(data.getIndustrialdrainage()!=null){
			data.setIndustrialdrainage(fixed(data.getIndustrialdrainage(),1));//昨日流量
		}else{
			data.setIndustrialdrainage(0.0);//昨日流量
		}
		
		data.setIs_ztraffic(fixed(data.getIs_ztraffic(), 1));//总流量
		data.setLs_ztraffic(fixed(data.getLs_ztraffic(), 1));//总流量
		data.setId_ztraffic(fixed(data.getId_ztraffic(), 1));//总流量
		data.setIs_waterlevel(fixed(data.getIs_waterlevel(), 3));
		data.setId_waterlevel(fixed(data.getId_waterlevel(), 3));
		data.setLs_waterlevel(fixed(data.getLs_waterlevel(), 3));
		
		list11.add(data);//实时监测数据
		//list.add(list11);

		/*list.add(0, waterquality);//水质监测
		list.add(1, ztraffic);//水平衡分析
		list.add(2, ztraffic2);//流量汇总系数
		list.add(3, companyconfig);//公司信息
		list.add(4, url);//URL
		list.add(5, sam1);//手动采样
		list.add(6, sam2);//自动采样
		list.add(7, sam3);//报警采样
		list.add(8, sam4);//远程采样
		list.add(9, pollutants);//污染物汇总信息
		list.add(10, pollutantss);//WTW基本信息
		list.add(11, data);//实时监测数据
*/	
		result.setWaterquality(list0);
		result.setZtraffic(list1);
		result.setZtraffic2(list2);
		result.setCompanyconfig(list3);
		result.setUrl(list4);
		result.setSam1(list5);
		result.setSam2(list6);
		result.setSam3(list7);
		result.setSam4(list8);
		result.setPollutants(list9);
		result.setPollutantss(list10);
		result.setData(list11);
		result.setLog(log);
		result.init(ApiResultcode._1, "成功");
		return "@" + encodeJson(result);
		
		
	}

	
	
}
