package com.erich.saleticket.controllers.api.qinghua;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.MobileData;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewWaterquality;
import com.erich.saleticket.model.tdht.ViewfirstTab;

public class DataController extends BaseController{

	
	@Resource
	private DataBiz dataBiz;
	/**
	 * 实时数据
	 */
	@Get("dataList222")
	@Post("dataList222")
	public String DataController(ViewCompanyconfig companyconfigs, HttpServletRequest request, HttpServletResponse response)   {
		MobileData<Object> result = new MobileData<Object>(ApiResultcode._0);
		
		
		Pollutant pollutant_copy=new Pollutant();
		Long rid=companyconfigs.getRid();
		
		ViewWaterquality waterquality=dataBiz.selectByWaterquality(rid);//查询水质监测
		ViewfirstTab	data=dataBiz.selectFirstTab(rid);//
		ViewCompanyconfig companyconfig=dataBiz.selectBycompanyconfig(companyconfigs);
		Pollutant pollutantss= dataBiz.selectByPollutant3(rid);//WTW基本信息
		
		if(pollutantss==null){
			pollutantss=pollutant_copy;
		}else{
			pollutant_copy=	pollutantss;
		}
		
		
	
		List<Object> list0= new ArrayList<Object>();
		list0.add(waterquality);//水质监测
		try {
			waterquality.setRealPh(fixed(waterquality.getRealPh(), 2));//ph
			waterquality.setLastDayMaxPh(fixed(waterquality.getLastDayMaxPh(), 2));//ph最大
			waterquality.setLastDayMinPh(fixed(waterquality.getLastDayMinPh(), 2));//ph最小
			waterquality.setRealConductivity(fixed(waterquality.getRealConductivity(), 2));//电导率
			waterquality.setLastDayMaxConductivity(fixed(waterquality.getLastDayMaxConductivity(), 2));//
			waterquality.setLastDayMinConductivity(fixed(waterquality.getLastDayMinConductivity(), 2));
			waterquality.setRealCod(fixed(waterquality.getRealCod(), 2));//COD
			waterquality.setLastDayMaxCod(fixed(waterquality.getLastDayMaxCod(), 2));
			waterquality.setLastDayMinCod(fixed(waterquality.getLastDayMinCod(), 2));
			pollutantss.setRealcod(fixed(pollutantss.getRealcod(), 2));//cod
			pollutantss.setMaxcod(fixed(pollutantss.getMaxcod(), 2));
			pollutantss.setMincod(fixed(pollutantss.getMincod(), 2));
		/*if(rid.toString().equals("75501330004")){
			pollutantss.setRealnh4(-9999.99);//氨氮
			pollutantss.setMaxnh4(-9999.99);
			pollutantss.setMinnh4(-9999.99);
		}else{*/
			pollutantss.setRealnh4(fixed(pollutantss.getRealnh4(), 2));//氨氮
			pollutantss.setMaxnh4(fixed(pollutantss.getMaxnh4(), 2));
			pollutantss.setMinnh4(fixed(pollutantss.getMinnh4(), 2));
		//}
		
			
			pollutantss.setRealcr6(fixed(pollutantss.getRealcr6(), 4));//六价铬
			pollutantss.setMaxcr6(fixed(pollutantss.getMaxcr6(), 4));
			pollutantss.setMincr6(fixed(pollutantss.getMincr6(), 4));
			pollutantss.setRealmlss(fixed(pollutantss.getRealmlss(), 2));//固体悬浮物
			pollutantss.setMaxmlss(fixed(pollutantss.getMaxmlss(), 2));
			pollutantss.setMinmlss(fixed(pollutantss.getMinmlss(), 2));
			waterquality.setRealTemp(fixed(waterquality.getRealTemp(), 2));//温度
			waterquality.setLastDayMaxTemp(fixed(waterquality.getLastDayMaxTemp(), 2));
			waterquality.setLastDayMaxTemp(fixed(waterquality.getLastDayMaxTemp(), 2));
			pollutantss.setRealphosphor(fixed(pollutantss.getRealphosphor(), 2));//总磷
			pollutantss.setMaxphosphor(fixed(pollutantss.getMaxphosphor(), 2));
			pollutantss.setMinphosphor(fixed(pollutantss.getMinphosphor(), 2));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		List<Object> list10= new ArrayList<Object>();
		list10.add(pollutantss);//WTW基本信息
		//list.add(list10);
		
		
		List<Object> list11= new ArrayList<Object>();
		try {
			if(data.getWaterlevel()!=null){
				data.setWaterlevel(fixed(data.getWaterlevel(), 3));//水位
				data.setIs_CurrentSpeed(fixed(data.getIs_CurrentSpeed(), 3));//流速
				data.setLs_CurrentSpeed(fixed(data.getLs_CurrentSpeed(),3));//流速
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(data.getId_CurrentSpeed()!=null){
			data.setId_CurrentSpeed(fixed(data.getId_CurrentSpeed(), 3));//流速
		}
		data.setIs_traffic(fixed(data.getIs_traffic(), 4));//流量速率
		data.setLs_traffic(fixed(data.getLs_traffic(), 4));//流量速率
		data.setId_traffic(fixed(data.getId_traffic(), 4));//流量速率
		if(data.getIs_sub_ztraffic()!=null){
			data.setIs_sub_ztraffic(fixed(data.getIs_sub_ztraffic(), 1));//今日流量
			data.setLs_sub_ztraffic(fixed(data.getLs_sub_ztraffic(), 1));//今日流量
			data.setId_sub_ztraffic(fixed(data.getId_sub_ztraffic(), 1));//今日流量
			
		}else{
			data.setIs_sub_ztraffic(0.0);//今日流量
			data.setLs_sub_ztraffic(0.0);//今日流量
			data.setId_sub_ztraffic(0.0);//今日流量
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
		/*result.setZtraffic(list1);
		result.setZtraffic2(list2);
		result.setCompanyconfig(list3);
		result.setUrl(list4);
		result.setSam1(list5);
		result.setSam2(list6);
		result.setSam3(list7);
		result.setSam4(list8);
		result.setPollutants(list9);*/
		result.setPollutantss(list10);
		result.setData(list11);
		/*result.setLog(log);*/
		 result.init(ApiResultcode._1, "成功");
		return "@" + encodeJson(result);
		
		
	}

	
}
