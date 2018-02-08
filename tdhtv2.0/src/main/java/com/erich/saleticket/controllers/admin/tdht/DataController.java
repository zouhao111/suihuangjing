package com.erich.saleticket.controllers.admin.tdht;


import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import net.paoding.rose.web.annotation.Param;
import com.erich.easyframe.util.WebConstants;
import com.erich.saleticket.biz.tdht.BalanceWaterBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.model.sys.SysUserCompany;
import com.erich.saleticket.model.tdht.BalanceWater;
import com.erich.saleticket.model.tdht.Console;
import com.erich.saleticket.model.tdht.KeyState;
import com.erich.saleticket.model.tdht.MapData;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;
import com.erich.saleticket.model.tdht.ViewData;
import com.erich.saleticket.model.tdht.ViewLog;
import com.erich.saleticket.model.tdht.ViewSampling;
import com.erich.saleticket.model.tdht.ViewTraffic;
import com.erich.saleticket.model.tdht.ViewWaterquality;
import com.erich.saleticket.model.tdht.ViewZtraffic;
import com.erich.saleticket.model.tdht.ViewfirstTab;

/**
 * 实时数据控制器
 * @author Lv
 */
public class DataController extends BaseController {

	
	@Resource
	private DataBiz dataBiz;
	@Resource
	private BalanceWaterBiz balanceBizs;
	Pollutant pollutant_copy=new Pollutant();
	/**
	 * 公司信息静态页面
	 */
	public String liveHtml() {
		return "data/liveHtml";
	}
	
	/**
	 * 地图
	 */
	public String mapHtml() {
		return "data/bdMap";
	}
	/**
	 * 地区
	 */
	public String areaHtml( @Param("area") String area,@Param("rid") Long rid,HttpServletRequest request, HttpServletResponse response) {
		StringBuffer webUrl=request.getRequestURL();
		
		String path = request.getContextPath();
		String urls= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		String ulxs=urls+"admin/tdht/data/indexHtml?nameId=1&state=3";//进入公司详细地图
		
		SysUserCompany	sysUserCompany=getUserCompany(request);
		Integer companyId=sysUserCompany.getCompanyId();
		List<KeyState> allstaty = null;
		if(companyId==3000){
			long rids=0;
		    allstaty=dataBiz.selectByState2(rids);
			
		}
		List<KeyState> keyState=dataBiz.selectByMapState();// 查询地图气泡状态颜色
		
		List<MapData> mapdatas=dataBiz.selectByCriteriaAllPH();// 查询PH和COD的 实时值
		
		Integer company1=0;//0正常1掉线2预警3报警
		Integer company2=0;
		Integer company3=0;
		Integer company4=0;
		Integer company5=0;
		Integer company6=0;//0正常1掉线2预警3报警
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
		Integer company19=0;
		Integer company20=0;
		if(companyId!=3000){
			for(MapData ma:mapdatas){
						
						if(ma.getRid().toString().equals("75501330001")){
							if(ma.getRealPh()<=6.5 && ma.getRealPh()>=6 || ma.getRealPh()>=8.5 && ma.getRealPh()<=9 || ma.getRealCod()<=280 && ma.getRealCod() >=224){
								company1=2;
							}
							if(ma.getRealPh()<6 || ma.getRealPh()>9  || ma.getRealCod()>280 || ma.getRealCod()<224 && ma.getRealCod() != 0.0){
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
				company13=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75506330002") && keyStates.getBitOnline()==1){
				company14=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75506330003") && keyStates.getBitOnline()==1){
				company15=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330022") && keyStates.getBitOnline()==1){
				company16=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330023") && keyStates.getBitOnline()==1){
				company17=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330024") && keyStates.getBitOnline()==1){
				company18=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330025") && keyStates.getBitOnline()==1){
				company19=keyStates.getBitOnline();
			}
			if(keyStates.getRid().toString().equals("75501330026") && keyStates.getBitOnline()==1){
				company20=keyStates.getBitOnline();
			}
		}
	
		if(companyId==3000){
			for(KeyState keyStates : allstaty){
				if(keyStates.getRid().toString().equals("75503780001") && keyStates.getBitOnline()==1 ){
					company1=keyStates.getBitOnline();
				}
				if(keyStates.getRid().toString().equals("75503780002") && keyStates.getBitOnline()==1 ){
					company2=keyStates.getBitOnline();
				}
				
			}
		}
	
		if(companyId==1600){
			company2=company13;
			company3=company14;
			company4=company15;
			company5=company16;
			company7=company17;
			company8=company18;
			company10=company19;
			company13=company20;
		}
		
		
		String url=webUrl+"?nameId=1&state=3";
		area="baoan";
		request.setAttribute("webUrls", ulxs);
		request.setAttribute("area", area);
		request.setAttribute("keyState", keyState);
		request.setAttribute("company1", company1);
		request.setAttribute("company2", company2);
		request.setAttribute("company3", company3);
		request.setAttribute("company4", company4);
		
		request.setAttribute("company5", company5);
		request.setAttribute("company6", company6);
		request.setAttribute("company7", company7);
		request.setAttribute("company8", company8);
		request.setAttribute("company9", company9);
		request.setAttribute("company10", company10);
		request.setAttribute("company11", company11);
		request.setAttribute("company12", company12);
		request.setAttribute("company13", company13);
		request.setAttribute("company14", company14);
		request.setAttribute("company15", company15);
		request.setAttribute("company16", company16);
		request.setAttribute("company17", company17);
		request.setAttribute("company18", company18);
		request.setAttribute("company19", company19);
		request.setAttribute("company20", company20);
		
		
		
		request.setAttribute("areatype","1" );
		
		
		
		if(companyId==2000){
			return "data/areaMap2";
			//return "r:indexHtml?state="+company5+"&rid="+rid+"";
		}else if(companyId==3000){
			area="futian";
			request.setAttribute("area", area);
			return "data/areaMap3";
		}else{
			return "data/areaMap";
		}	
		
	}
	
	
	
	
	
	
	/**
	 * 详细信息
	 */
	public String indexHtml(@Param("rid") Long rid,@Param("state") Integer state, HttpServletRequest request, HttpServletResponse response) {
		
		StringBuffer webUrl=request.getRequestURL();
		String url=webUrl+"?nameId=1&state=3";
		MapData datas2 = dataBiz.selectByCriteriaPH(rid);
		ViewfirstTab datas = dataBiz.selectByCriteria(rid);
		request.setAttribute("webUrls", url);
		request.setAttribute("dataOne", datas);
		request.setAttribute("rid", rid);
		request.setAttribute("datas2", datas2);
		request.setAttribute("state", state);
		request.setAttribute("areatype","1" );
		return "data/indexMap";
	}
/*public MapData indexHtml1(@Param("rid") Long rid, HttpServletRequest request, HttpServletResponse response) {
		
		MapData datas = dataBiz.selectByCriteria(rid);
		
		request.setAttribute("rid", rid);
		request.setAttribute("dataOne", datas);
		
		return datas;
	}
	*/
	
	/**
	 * 实时监测数据
	 */
	public String dataNew(ViewCompanyconfig companyconfigs, HttpServletRequest request, HttpServletResponse response) {
		StringBuffer webUrl=request.getRequestURL();
		Long rid=companyconfigs.getRid();
		ViewZtraffic ztraffic=dataBiz.selectByztraffic(rid);// 流量汇总
		ViewWaterquality waterquality=dataBiz.selectByWaterquality(rid);//查询水质监测
		ViewCompanyconfig viewCompanyconfig=dataBiz.selectBycompanyconfig(companyconfigs);//根据ID查询公司名称

		
		SysUserCompany sysUserCompanys=getUserCompany(request);
		sysUserCompanys.setWebUrl(webUrl);
		request.getSession().setAttribute(WebConstants.USER_COMPANY,sysUserCompanys);
		String url=webUrl+"?nameId=1";
		request.setAttribute("webUrls", url);
		request.setAttribute("ztraffic", ztraffic);
		request.setAttribute("waterquality", waterquality);
		request.setAttribute("viewCompanyconfig", viewCompanyconfig);
		
		return "data/dataNewList";
	}  
	Data<Console> result2 = new Data<Console>(ApiResultcode._0);
	private Object key1;
	
	
	public String dataNew2(ViewCompanyconfig companyconfigs, HttpServletRequest request, HttpServletResponse response) {
		SysUserCompany sysUserCompany=getUserCompany(request);
		Integer  companyId=sysUserCompany.getCompanyId();
		if(companyId==1000){
			StringBuffer webUrl=request.getRequestURL();
			Long rid=companyconfigs.getRid();
			List<ViewZtraffic> ztraffic=dataBiz.selectByztraffic();// 流量汇总
			List<ViewWaterquality> waterquality=dataBiz.selectByWaterquality();//查询水质监测
			List<Pollutant> waterquality2=dataBiz.selectByWaterquality2();//查询水质监测
			List<ViewCompanyconfig> viewCompanyconfig=dataBiz.selectBycompanyconfig1(companyconfigs);//根据ID查询公司名称
			if(waterquality.size()!=0&&waterquality2.size()!=0){
				for(int i=0;i<waterquality.size();i++){
					for(int j=0;j<waterquality2.size();j++){
						if(waterquality.get(i).getRid().toString().equals(waterquality2.get(j).getRid().toString())){
							waterquality.get(i).setRealcr6(waterquality2.get(j).getRealcr6());
							waterquality.get(i).setRealCod(waterquality2.get(j).getRealcod());
							waterquality.get(i).setRealNH3N(waterquality2.get(j).getRealnh4());
						}
					}
				}
				
			}
			
			
			String url=webUrl+"?nameId=1"; 
			request.setAttribute("webUrls", url);
			List<Object>list=new ArrayList<Object>();
			list.add(0, waterquality);
			list.add(1, ztraffic);
			list.add(2, url);
			list.add(3, viewCompanyconfig);
			result2.setList(list);
			 result2.init(ApiResultcode._1, "成功");
			return "@" + encodeJson(result2);
			
			
		}else{
		StringBuffer webUrl=request.getRequestURL();
		Long rid=companyconfigs.getRid();
		List<ViewZtraffic> ztraffic=dataBiz.selectByztraffic1(rid);// 流量汇总
		List<ViewWaterquality> waterquality=dataBiz.selectByWaterquality1(rid);//查询水质监测
		List<ViewCompanyconfig> viewCompanyconfig=dataBiz.selectBycompanyconfigone(companyconfigs);//根据ID查询公司名称
		
		
		
		String url=webUrl+"?nameId=1";
		request.setAttribute("webUrls", url);
		List<Object>list=new ArrayList<Object>();
		list.add(0, waterquality);
		list.add(1, ztraffic);
		list.add(2, url);
		list.add(3, viewCompanyconfig);
		result2.setList(list);
		 result2.init(ApiResultcode._1, "成功");
		return "@" + encodeJson(result2);
		}
	}  

	
		/**
		 * 实时数据
		 */
			public String doGet(ViewCompanyconfig companyconfigs,HttpServletRequest request, HttpServletResponse response) {
		
								//response.setHeader("refresh", "20");//设置refresh响应头控制浏览器每隔20秒钟刷新一次
								Long rid=companyconfigs.getRid();
								String mainRID=companyconfigs.getMainRID();
								 ViewCompanyconfig company=null;
								if(mainRID != null){
									boolean isNum = mainRID.matches("[0-9]+");  //用正则表达式判断里面是不是数字
									
									if (isNum==true) {//判断首页传来的查询参数是什么类型
										
									    Long value = Long.parseLong(mainRID);
									    rid=value;
									   
									   } else if (isNum == false) {
									    companyconfigs.setCompanyName(mainRID);
									    company=dataBiz.selectBycompanyconfig(companyconfigs);
									    
									   } 
									
									
									}
								if(rid!=null){
									company=dataBiz.selectBycompanyconfig(companyconfigs);
								}
						if(company !=null){
								rid=company.getRid();
								List<ViewSampling>  sampling=dataBiz.selectBySampling(rid);//查询水质采样
								ViewWaterquality waterquality=dataBiz.selectByWaterquality(rid);//查询水质监测
								List<ViewTraffic>	dataTraffic=dataBiz.selectByTraffic(rid);//查询流量监测数据  数据类型 1、工业给水,2、生活给水，3、工业排水，4、生活排水
								/*ViewfirstTab	data=dataBiz.selectFirstTab(rid);//
								ViewfirstTab	datas=dataBiz.selectFirstTab2(rid);//昨日流量
								ViewfirstTab	datass=dataBiz.selectFirstTab3(rid);//今日流量
*/								ViewZtraffic ztraffic=dataBiz.selectByztraffic(rid);//流量汇总
								ViewZtraffic ztraffic2=dataBiz.selectBycoeffiztraffic(rid);// 流量汇总系数
								ViewCompanyconfig companyconfig=dataBiz.selectBycompanyconfig(companyconfigs);
								
								 List<Integer> list=new ArrayList<Integer>();
								
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
									
								}
								 list=dataBiz.selectcomType(rid);	
								/*if(rid==75501330006l){
									String url_path="http://120.76.233.59:8089/api/apitwo/data/wateDataList?rid=75501330006";
									
									String str=HttpUtils.getJsonContent(url_path);
									String strs=null;
									try {
										strs = new String(str.getBytes("GBK"),"UTF-8");
									} catch (UnsupportedEncodingException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									request.setAttribute("strs", strs);
								}
							*/
									request.setAttribute("IndrainageNum", company.getIndrainageNum());
									request.setAttribute("InsupplyNum", company.getInsupplyNum());
									request.setAttribute("LivsupplyNum", company.getLivsupplyNum());
								request.setAttribute("rid", rid);
								request.setAttribute("sam1", sam1);
								request.setAttribute("sam2", sam2);
								request.setAttribute("sam3", sam3);
								request.setAttribute("waterquality", waterquality);
								request.setAttribute("ztraffic", ztraffic);
								request.setAttribute("ztraffic2", ztraffic2);
								request.setAttribute("companyconfig", companyconfig);
								request.setAttribute("data1", data1);
								request.setAttribute("data2", data2);
								request.setAttribute("data3", data3);
								request.setAttribute("data4", data4);
								request.setAttribute("list", list);
								StringBuffer webUrl=request.getRequestURL();
								String url=webUrl+"?nameId=1";
								request.setAttribute("webUrls", url);
								String ridd=rid.toString();
								if(ridd.equals("75501330003")){
									return "data/dataList_tdht";	
								}else if(ridd.equals("75501330008")||ridd.equals("75501330009")||ridd.equals("75501330006")||ridd.equals("75501330010")||ridd.equals("75501330011")||ridd.equals("75501330012")){
									return "data/dataList_bt";	
								}else{
								return "data/dataList";
								}
							}else{
								return "mains";
							}
	}

			public String doGet2(ViewCompanyconfig companyconfigs,HttpServletRequest request, HttpServletResponse response) throws ParseException {
				Data<Console> result = new Data<Console>(ApiResultcode._0);
					//response.setHeader("refresh", "20");//设置refresh响应头控制浏览器每隔20秒钟刷新一次
					Long rid=companyconfigs.getRid();
					
					List<ViewSampling>  sampling=dataBiz.selectBySampling(rid);//查询水质采样
					ViewWaterquality waterquality=dataBiz.selectByWaterquality(rid);//查询水质监测
					List<ViewTraffic>	dataTraffic=dataBiz.selectByTraffic(rid);//查询流量监测数据  数据类型 1、工业给水,2、生活给水，3、工业排水，4、生活排水
					ViewfirstTab	data=new ViewfirstTab();//
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
						data.setLs_sub_ztraffic(data_ls.getLs_sub_ztraffic());
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
					
					
					List<BalanceWater>balances=balanceBizs.BalanceList(balance);
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
					ViewCompanyconfig companyconfig=dataBiz.selectBycompanyconfig(companyconfigs);
					
					if(ztraffic!=null&&data!=null){
					ztraffic.setDrainageIndustrial(data.getId_ztraffic());
					ztraffic.setSupplyLiving(data.getLs_ztraffic());
					ztraffic.setSupplyIndustrial(data.getIs_ztraffic());
					if(companyconfig.getLivsupplyNum()==null&&companyconfig.getIndrainageNum()==1&&companyconfig.getInsupplyNum()==1){
					//if(rid.toString().equals("75501330004")||rid.toString().equals("75501330008")||rid.toString().equals("75501330009")||rid.toString().equals("75506330001")||rid.toString().equals("75506330002")||rid.toString().equals("75506330003")){
						if(!rid.toString().equals("75506330001")){
						ztraffic.setLossLimit(data.getIs_ztraffic()*0.15);
						}
					}
					}
					//ViewZtraffic ztraffic2=dataBiz.selectBycoeffiztraffic(rid);// 流量汇总系数
					ViewZtraffic ztraffic2=new ViewZtraffic();// 流量汇总系数
					if(ztraffic!=null&&ztraffic2!=null){
						Double d=0.0;
						if(companyconfig.getLivsupplyNum()==null&&companyconfig.getIndrainageNum()==1&&companyconfig.getInsupplyNum()==1||rid.toString().equals("75501330004")){
						//if(rid.toString().equals("75501330004")||rid.toString().equals("75501330008")||rid.toString().equals("75501330009")||rid.toString().equals("75506330001")||rid.toString().equals("75506330002")||rid.toString().equals("75506330003")){
							d=ztraffic.getSupplyIndustrial();
						}else if(companyconfig.getLivsupplyNum()==1&&companyconfig.getIndrainageNum()==1&&companyconfig.getInsupplyNum()==1){
					 d=ztraffic.getSupplyIndustrial()+ztraffic.getSupplyLiving();
						}
					    if(d!=null&&d!=0.0){
					    	ztraffic2.setSupplyIndustrial(ztraffic.getSupplyIndustrial()/d);
							ztraffic2.setSupplyLiving(ztraffic.getSupplyLiving()/d);
							ztraffic2.setDrainageIndustrial(ztraffic.getDrainageIndustrial()/d);
							ztraffic2.setLossLimit(ztraffic.getLossLimit()/d);
							ztraffic2.setLossAmount(ztraffic.getLossAmount()/d);
							ztraffic2.setUnknown(ztraffic.getUnknown()/d);
					    }
					
					}
					
					List<Pollutant> pollutantName=dataBiz.selectByPollutant_names(rid);//查询该公司监测的污染物


					Pollutant pollutantss= dataBiz.selectByPollutant3(rid);//基本信息
					
					if(pollutantss==null){
						pollutantss=pollutant_copy;
					}else{
						pollutant_copy=	pollutantss;
					}
					//Pollutant pollutants=dataBiz.selectByPollutant2(rid);//基本信息
					Pollutant pollutants=null;//基本信息
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
				
					/*request.setAttribute("sam1", sam1);
					request.setAttribute("sam2", sam2);
					request.setAttribute("sam3", sam3);
					request.setAttribute("waterquality", waterquality);
					request.setAttribute("ztraffic", ztraffic);
					request.setAttribute("ztraffic2", ztraffic2);
					request.setAttribute("companyconfig", companyconfig);
					request.setAttribute("data1", data1);
					request.setAttribute("data2", data2);
					request.setAttribute("data3", data3);
					request.setAttribute("data4", data4);
					
					request.setAttribute("webUrls", url);*/
					StringBuffer webUrl=request.getRequestURL();
					String url=webUrl+"?nameId=1";
					
					List<Object>list=new ArrayList<Object>();
					list.add(0, data1);
					list.add(1, data2);
					list.add(2, data3);
					list.add(3, data4);
					list.add(4, waterquality);
					list.add(5, ztraffic);
					list.add(6, ztraffic2);
					list.add(7, companyconfig);
					list.add(8, url);
					list.add(9, sam1);
					list.add(10, sam2);
					list.add(11, sam3);
					list.add(12, sam4);
					list.add(13, pollutants);
					list.add(14, pollutantss);
					list.add(15, data);
					list.add(16, pollutantName);
					result.setList(list);
					 result.init(ApiResultcode._1, "成功");
					return "@" + encodeJson(result);
		
		
	}
			Data<String> result = new Data<String>(ApiResultcode._0);
			public String  doGet_water(ViewCompanyconfig companyconfigs,HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
			       Long rid=companyconfigs.getRid();
			       List<Pollutant> pollutantName=new ArrayList<Pollutant>();
			       if(rid==75501330006l){
						
						 pollutantName=dataBiz.selectByPollutant_names(rid);//查询该公司监测的污染物
						
						}
			   	ViewCompanyconfig companyconfig=dataBiz.selectBycompanyconfig(companyconfigs);
			       
			       
					String url_path="http://120.76.233.59:8089/api/apitwo/data/wateDataList?rid=75501330006";
					
					JSONObject json = readJsonFromUrl(url_path);
					
					 String str=json.toString();
					 List<Object>list=new ArrayList<Object>();
					 
					    list.add(0, str);
						list.add(1, companyconfig);
						list.add(2, pollutantName);
					result.setList(list);
					 result.init(ApiResultcode._1, "成功");
					return "@" + encodeJson(result);
					
				}
			public String doGet3(ViewCompanyconfig companyconfigs,HttpServletRequest request, HttpServletResponse response) {
				Data<Console> result = new Data<Console>(ApiResultcode._0);
				Long rid=companyconfigs.getRid();
				
				
				List<Pollutant> pollutantName=dataBiz.selectByPollutant_names(rid);//查询该公司监测的污染物
				
				ViewCompanyconfig pollTime=dataBiz.selectByPollutant_Time(rid);
				Date StrTime=pollTime.getPollStrTime();
				
				 ViewData pollsour= dataBiz.selectByPollSour(rid,StrTime);
				
				
				
				Pollutant pollutants=dataBiz.selectByPollutant2_sum(rid);//基本信息
				
				List<ViewLog> log = dataBiz.selectByCriteriaData(rid);
				
				List<KeyState>key=dataBiz.selectkeyState(rid);
				KeyState key_is=new KeyState();
				KeyState key_id=new KeyState();
				KeyState key_ls=new KeyState();
				for(int i=0;i<key.size();i++){
					if(key.get(i).getType()==1){
						if(key.get(i).getBitOnline()==1){
							int type=1;
							 key_id=dataBiz.selectkeyState1(rid,type);
						}
					}
					if(rid==75501330004l||rid==75501330003l||rid==75501330002l||rid==75501330001l){
						
					
					if(key.get(i).getType()==2){
						if(key.get(i).getBitOnline()==1){
							int type=2;
						key_ls=dataBiz.selectkeyState1(rid,type);
						}
					}
					}
					if(key.get(i).getType()==3){
						if(key.get(i).getBitOnline()==1){
							int type=3;
						key_is=dataBiz.selectkeyState1(rid,type);
						}
					}
				}
				
				List<KeyState>key2=new ArrayList<KeyState>();
				key2.add(0,key_id);
				key2.add(1,key_ls);
				key2.add(2,key_is);
				List<Object>list=new ArrayList<Object>();
				list.add(0, key2);
				list.add(1, log);
				list.add(2, pollutants);
				list.add(3, pollutantName);
				list.add(4, pollsour);
				result.setList(list);
				 result.init(ApiResultcode._1, "成功");
				return "@" + encodeJson(result);
			}
}
