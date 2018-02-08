package com.erich.saleticket.controllers.api;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.controllers.admin.tdht.HttpUtils;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.MobileData;
import com.erich.saleticket.model.tdht.KeyState;
import com.erich.saleticket.model.tdht.MapData;
import com.mysql.fabric.xmlrpc.base.Array;
public class MapDataController extends BaseController{

	
	@Resource
	private DataBiz dataBiz;
	/*地图数据
	 */
	@Get("mapList")
	@Post("mapList")
	public String mapList(MapData mapData, HttpServletRequest request, HttpServletResponse response)   {
		MobileData<List<MapData>> result = new MobileData<List<MapData>>(ApiResultcode._0);
		
		
		List<KeyState> keyState=dataBiz.selectByMapState();// 查询地图气泡状态颜色
		
		List<MapData> mapdatas=dataBiz.selectByCriteriaAllPH();
		
		Integer company1=0;
		Integer company2=0;
		Integer company3=0;
		Integer company4=0;
		Integer company5=0;
		Integer company6=0;
		Integer company7=0;
		Integer company8=0;
		Integer company9=0;
		Integer company10=0;
		Integer company11=0;
		Integer company12=0;
		Integer company13=0;
		Integer company14=0;
		Integer company15=0;
		Integer company16=0;
		Integer company17=0;
		Integer company18=0;
		
for(MapData ma:mapdatas){
			
			if(ma.getRid().toString().equals("75501330001")){
				if(ma.getRealPh()<=6.5 && ma.getRealPh()>=6 || ma.getRealPh()>=8.5 && ma.getRealPh()<=9 || ma.getRealCod()<=280 && ma.getRealCod() >=224){
					company1=2;
				}
				if(ma.getRealPh()<6 || ma.getRealPh()>9 || ma.getRealCod()>280 || ma.getRealCod()<224 && ma.getRealCod() != 0.0){
					company1=3;
				}
			}
			if(ma.getRid().toString().equals("75501330002")){
				if(ma.getRealPh()<=6.5 && ma.getRealPh()>=6 || ma.getRealPh()>=8.5 && ma.getRealPh()<=9 || ma.getRealCod()<=280 && ma.getRealCod() >=224){
					company2=2;
				}
				if(ma.getRealPh()<6 || ma.getRealPh()>9 || ma.getRealCod()>280 || ma.getRealCod()<224 && ma.getRealCod() != 0.0){
					company2=3;
				}
			}
			if(ma.getRid().toString().equals("75501330003")){
				if(ma.getRealPh()<=6.5 && ma.getRealPh()>=6 || ma.getRealPh()>=8.5 && ma.getRealPh()<=9 || ma.getRealCod()<=280 && ma.getRealCod() >=224){
					company3=2;
				}
				if(ma.getRealPh()<6 || ma.getRealPh()>9 || ma.getRealCod()>280 || ma.getRealCod()<224 && ma.getRealCod() != 0.0){
					company3=3;
				}
			}
			if(ma.getRid().toString().equals("75501330004")){
				if(ma.getRealPh()<=6.5 && ma.getRealPh()>=6 || ma.getRealPh()>=8.5 && ma.getRealPh()<=9 || ma.getRealCod()<=280 && ma.getRealCod() >=224){
					company4=2;
				}
				if(ma.getRealPh()<6 || ma.getRealPh()>9 || ma.getRealCod()>280 || ma.getRealCod()<224 && ma.getRealCod() != 0.0){
					company4=3;
				}
			}
			if(ma.getRid().toString().equals("75501330005")){
				if(ma.getRealPh()<=6.5 && ma.getRealPh()>=6 || ma.getRealPh()>=8.5 && ma.getRealPh()<=9 || ma.getRealCod()<=280 && ma.getRealCod() >=224){
					company5=2;
				}
				if(ma.getRealPh()<6 || ma.getRealPh()>9 || ma.getRealCod()>280 || ma.getRealCod()<224 && ma.getRealCod() != 0.0){
					company5=3;
				}
			}
		}
		
		for(KeyState keyStates : keyState){
			if(keyStates.getRid().toString().equals("75501330001") && keyStates.getBitOnline()==1 ){
				company1=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330002") && keyStates.getBitOnline()==1 ){
				company2=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330003") && keyStates.getBitOnline()==1){
				company3=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330004") && keyStates.getBitOnline()==1){
				company4=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330005") && keyStates.getBitOnline()==1){
				company5=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330008") && keyStates.getBitOnline()==1){
				company6=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330009") && keyStates.getBitOnline()==1){
				company7=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330010") && keyStates.getBitOnline()==1){
				company8=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330011") && keyStates.getBitOnline()==1){
				company9=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330012") && keyStates.getBitOnline()==1){
				company10=keyStates.getBitOnline();
			}
	
			if(keyStates.getRid().toString().equals("75506330001") && keyStates.getBitOnline()==1){
				company11=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75506330002") && keyStates.getBitOnline()==1){
				company12=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75506330003") && keyStates.getBitOnline()==1){
				company13=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330022") && keyStates.getBitOnline()==1){
				company14=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330023") && keyStates.getBitOnline()==1){
				company15=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330024") && keyStates.getBitOnline()==1){
				company16=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330025") && keyStates.getBitOnline()==1){
				company17=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330026") && keyStates.getBitOnline()==1){
				company18=keyStates.getBitOnline();
			}
		}
		if(mapData.getParentCode()!=null){
			if(mapData.getParentCode().equals("1500")){
				mapData.setWaterType(10);
			}
			if(mapData.getParentCode().equals("1000")){
				mapData.setWaterType(0);
			}
			if(mapData.getParentCode().equals("1600")){
				mapData.setWaterType(20);
			}
		}

		 List<MapData> mdata = dataBiz.selectMapAll(mapData);
		 List<MapData> mapList=null;
		 
		 for(int i=0;i<mdata.size();i++){
			 if(mdata.get(i).getRid()==75501330001l){
				 mdata.remove(i);
			 }
		 }
		 
		 List<MapData> mdatas=new ArrayList();
		 if(mapData.getParentCode().equals("1500")){
			 for(int i=0;i<mdata.size();i++){
				 if(mdata.get(i).getRid()==75501330012l || mdata.get(i).getRid()==75501330010l || mdata.get(i).getRid()==75501330009l || mdata.get(i).getRid()==75501330008l){
					 mdatas.add(mdata.get(i));
				 }
			 }
		 }
		 
		 if(mapData.getParentCode().equals("1600")){
			 
		 }else{
			 
			//调用水环境地图接口查询碧头数据并插入到水污染源里面
				String str=HttpUtils.httpURLConectionGET("http://120.76.233.59:8089/api/apitwo/mapData/mapList");
				if(str !=null){
					JSONObject jsonObject = JSONObject.fromObject(str);
					 String mapdata = jsonObject.getString("result");
					JSONArray jsonArray2= JSONArray.fromObject(mapdata);
					mapList=JSONArray.toList(jsonArray2, MapData.class);
					for(MapData datas : mapList){
						 if(datas.getRid()==75501330006l){
							 mdata.add(datas);
						 }
					 }
				}
		 }
		
			
		for(MapData datas : mdata){
				
				datas.setTabCurrentSpeed(fixed(datas.getTabCurrentSpeed(), 3));//流速
				datas.setTabWaterLevel(fixed(datas.getTabWaterLevel(), 3));//水位
				datas.setTabTraffic(fixed(datas.getTabTraffic(),4));//流量速率
				datas.setTabZtraffic(fixed(datas.getTabZtraffic(), 1));//总流量
				if(datas.getTabPh()!=null){
					datas.setTabPh(fixed(datas.getTabPh(), 1));//ph
				}else{
					datas.setTabPh(0.00);
				}
				
				datas.setLat(datas.getLat());
				datas.setLon(datas.getLon());
				if(datas.getRid().toString().equals("75501330001")){
					datas.setSysState(company1);
				}
				if(datas.getRid().toString().equals("75501330002")){
					datas.setSysState(company2);
				}
				if(datas.getRid().toString().equals("75501330003")){
					datas.setSysState(company3);
				}
				if(datas.getRid().toString().equals("75501330004")){
					datas.setSysState(company4);
				}
				if(datas.getRid().toString().equals("75501330008")){
					datas.setSysState(company6);
				}
				if(datas.getRid().toString().equals("75501330009")){
					datas.setSysState(company7);
				}
				if(datas.getRid().toString().equals("75501330010")){
					datas.setSysState(company8);
				}
				if(datas.getRid().toString().equals("75501330011")){
					datas.setSysState(company9);
				}
				if(datas.getRid().toString().equals("75501330012")){
					datas.setSysState(company10);
				}
				if(datas.getRid().toString().equals("75506330001")){
					datas.setSysState(company11);
				}
				if(datas.getRid().toString().equals("75506330002")){
					datas.setSysState(company12);
				}
				if(datas.getRid().toString().equals("75506330003")){
					datas.setSysState(company13);
				}
				if(datas.getRid().toString().equals("75501330022")){
					datas.setSysState(company14);
				}
				if(datas.getRid().toString().equals("75501330023")){
					datas.setSysState(company15);
				}
				if(datas.getRid().toString().equals("75501330024")){
					datas.setSysState(company16);
				}
				if(datas.getRid().toString().equals("75501330025")){
					datas.setSysState(company17);
				}
				if(datas.getRid().toString().equals("75501330026")){
					datas.setSysState(company18);
				}
			}
		 if(mapData.getParentCode().equals("1500")){
			 result.setResult(mdatas);
		 }else{
			 result.setResult(mdata);
		 }
		
		
		
		if(mdata !=null){
			result.init(ApiResultcode._1, "成功");
		}
  		 return "@" + encodeJson(result);
	}

}
