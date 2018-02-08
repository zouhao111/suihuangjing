package com.erich.saleticket.biz.tdht;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erich.easyframe.common.utils.CacheUtils;
import com.erich.saleticket.dao.tdht.ApiAlarmDAO;
import com.erich.saleticket.model.tdht.Alarm;
import com.erich.saleticket.model.tdht.AlarmType;
import com.erich.saleticket.model.tdht.AlarmType_water;
import com.erich.saleticket.model.tdht.Pollutant;

@Service
public class ApiAlarmBiz {

	@Resource
	private ApiAlarmDAO alarmDAO;
	
	public Object selectByCriteria(final Long rid){
		Object   cacheValue = null;
		if(rid.toString().equals("75501330001")){
			Object   cacheValue_1=CacheUtils.getCache("alarms1");//获取缓存KEY为phwarnings的值
			cacheValue=cacheValue_1;
		}
		if(rid.toString().equals("75501330002")){
			Object   cacheValue_2=CacheUtils.getCache("alarms2");//获取缓存KEY为phwarnings的值
			cacheValue=cacheValue_2;
		}
		if(rid.toString().equals("75501330003")){
			Object   cacheValue_3=CacheUtils.getCache("alarms3");//获取缓存KEY为phwarnings的值
			cacheValue=cacheValue_3;
		}
		if(rid.toString().equals("75501330004")){
			Object   cacheValue_4=CacheUtils.getCache("alarms4");//获取缓存KEY为phwarnings的值
			cacheValue=cacheValue_4;
		}
		if(rid.toString().equals("75501330005")){
			Object   cacheValue_5=CacheUtils.getCache("alarms5");//获取缓存KEY为phwarnings的值
			cacheValue=cacheValue_5;
		}
		
		if(cacheValue==null){//判断缓存区域这个值是不是空
			
			List<Alarm> alarms=alarmDAO.selectByCriteria2(rid);
			if(rid.toString().equals("75501330001")){
				CacheUtils.addCache("alarms1", alarms);//没有查出来后添加进缓存区
			}
			if(rid.toString().equals("75501330002")){
				CacheUtils.addCache("alarms2", alarms);//没有查出来后添加进缓存区
			}
			if(rid.toString().equals("75501330003")){
				CacheUtils.addCache("alarms3", alarms);//没有查出来后添加进缓存区
			}
			if(rid.toString().equals("75501330004")){
				CacheUtils.addCache("alarms4", alarms);//没有查出来后添加进缓存区
			}
			if(rid.toString().equals("75501330005")){
				CacheUtils.addCache("alarms5", alarms);//没有查出来后添加进缓存区
			}
			
			
			
			 // 启动定时器线程，并在10000毫秒后开始，每隔3000毫秒执行一次定时任务
			  new Timer().schedule(new TimerTask() {// 定时任务
		            @Override
		            public void run() {
		            
		    			List<Alarm> alarms=alarmDAO.selectByCriteria2(rid);
		    			if(rid.toString().equals("75501330001")){
		    				CacheUtils.addCache("alarms1", alarms);//没有查出来后添加进缓存区
		    			}
		    			if(rid.toString().equals("75501330002")){
		    				CacheUtils.addCache("alarms2", alarms);//没有查出来后添加进缓存区
		    			}
		    			if(rid.toString().equals("75501330003")){
		    				CacheUtils.addCache("alarms3", alarms);//没有查出来后添加进缓存区
		    			}
		    			if(rid.toString().equals("75501330004")){
		    				CacheUtils.addCache("alarms4", alarms);//没有查出来后添加进缓存区
		    			}
		    			if(rid.toString().equals("75501330005")){
		    				CacheUtils.addCache("alarms5", alarms);//没有查出来后添加进缓存区
		    			}
		            }
		        }, 10000, 60000);
			
			  
			return alarms;
		}
		
		
		return cacheValue;//有就返回缓存区域的值
	}
	
	
	public Object selectByWarningCriteria(final Long rid){
		Object   cacheValueWarn = null;
		if(rid.toString().equals("75501330001")){
			Object   cacheValueWarn_1=CacheUtils.getCache("alarmsWarn1");//获取缓存KEY为phwarnings的值
			cacheValueWarn=cacheValueWarn_1;
		}
		if(rid.toString().equals("75501330002")){
			Object   cacheValueWarn_2=CacheUtils.getCache("alarmsWarn2");//获取缓存KEY为phwarnings的值
			cacheValueWarn=cacheValueWarn_2;
		}
		if(rid.toString().equals("75501330003")){
			Object   cacheValueWarn_3=CacheUtils.getCache("alarmsWarn3");//获取缓存KEY为phwarnings的值
			cacheValueWarn=cacheValueWarn_3;
		}
		if(rid.toString().equals("75501330004")){
			Object   cacheValueWarn_4=CacheUtils.getCache("alarmsWarn4");//获取缓存KEY为phwarnings的值
			cacheValueWarn=cacheValueWarn_4;
		}
		if(rid.toString().equals("75501330005")){
			Object   cacheValueWarn_5=CacheUtils.getCache("alarmsWarn5");//获取缓存KEY为phwarnings的值
			cacheValueWarn=cacheValueWarn_5;
		}
		
		if(cacheValueWarn==null){//判断缓存区域这个值是不是空
			
			List<Alarm> alarms=alarmDAO.selectByWarningCriteria(rid);
			if(rid.toString().equals("75501330001")){
				CacheUtils.addCache("alarmsWarn1", alarms);//没有查出来后添加进缓存区
			}
			if(rid.toString().equals("75501330002")){
				CacheUtils.addCache("alarmsWarn2", alarms);//没有查出来后添加进缓存区
			}
			if(rid.toString().equals("75501330003")){
				CacheUtils.addCache("alarmsWarn3", alarms);//没有查出来后添加进缓存区
			}
			if(rid.toString().equals("75501330004")){
				CacheUtils.addCache("alarmsWarn4", alarms);//没有查出来后添加进缓存区
			}
			if(rid.toString().equals("75501330005")){
				CacheUtils.addCache("alarmsWarn4", alarms);//没有查出来后添加进缓存区
			}
			
			
			
			 // 启动定时器线程，并在10000毫秒后开始，每隔3000毫秒执行一次定时任务
			  new Timer().schedule(new TimerTask() {// 定时任务
		            @Override
		            public void run() {
		            
		    			List<Alarm> alarms=alarmDAO.selectByWarningCriteria(rid);
		    			if(rid.toString().equals("75501330001")){
		    				CacheUtils.addCache("alarmsWarn1", alarms);//没有查出来后添加进缓存区
		    			}
		    			if(rid.toString().equals("75501330002")){
		    				CacheUtils.addCache("alarmsWarn2", alarms);//没有查出来后添加进缓存区
		    			}
		    			if(rid.toString().equals("75501330003")){
		    				CacheUtils.addCache("alarmsWarn3", alarms);//没有查出来后添加进缓存区
		    			}
		    			if(rid.toString().equals("75501330004")){
		    				CacheUtils.addCache("alarmsWarn4", alarms);//没有查出来后添加进缓存区
		    			}
		    			if(rid.toString().equals("75501330005")){
		    				CacheUtils.addCache("alarmsWarn5", alarms);//没有查出来后添加进缓存区
		    			}
		            }
		        }, 10000, 60000);
			
			  
			return alarms;
		}
		
		
		return cacheValueWarn;//有就返回缓存区域的值selectByCriteriawater_type
	}
	
	
	/**
	 * 水环境报警
	 * @param rid
	 * @return
	 */
	public List<AlarmType_water> selectByCriteriawaterType(Long rid){
		List<AlarmType_water> v=alarmDAO.selectByCriteriawater_type(rid);
	return v;
	}
	public AlarmType_water selectByCriteriawater(AlarmType_water alarm){
		AlarmType_water v=alarmDAO.selectByCriteriawater(alarm);
	return v;
	}
	public int selectCountWater(AlarmType_water alarm){
		int v=alarmDAO.selectCountWater(alarm);
	return v;
	}
	public List<AlarmType_water> selectCountWaters(AlarmType_water alarm){
		List<AlarmType_water> v=alarmDAO.selectCountWaters(alarm, alarm.getPager());
	return v;
	}
	public List<AlarmType_water>  selectCountWatersHistory(AlarmType_water alarm){
		return alarmDAO.selectCountWatersHistory(alarm, alarm.getPager());
	}
	
	
	
	public List<AlarmType> selectByCriteriaType(Long rid){
		List<AlarmType> v=alarmDAO.selectByCriteria_type(rid);
	return v;
	}
	
	public List<Pollutant> selectByCriteriaCod(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_cod(alarm, alarm.getPager());
		return v;
	}

	public List<Pollutant> selectByCriteria_all(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_all(alarm, alarm.getPager());
		return v;
	}
	
	public List<Pollutant> selectByCriteria_allAPI(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_allAPI(alarm, alarm.getPager());
		return v;
	}
	public List<Pollutant> selectByCriteria_sourAllAPI(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_sourAllAPI(alarm, alarm.getPager());
		return v;
	}
	public int selectCount_all(Alarm alarm){
		int v=alarmDAO.selectCount_all(alarm);
	return v;
	}
	
	public List<Pollutant> selectByCriteriaCodAPI(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_codAPI(alarm, alarm.getPager());
		return v;
	}
	
	public int selectCountCod(Alarm alarm){
		int v=alarmDAO.selectCount_cod(alarm);
	return v;
	}
	
	
	public List<Pollutant> selectByCriteriaNh4(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_nh4(alarm, alarm.getPager());
	return v;
	}
	
	public List<Pollutant> selectByCriteriaNh4API(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_nh4API(alarm, alarm.getPager());
	return v;
	}
	
	public int selectCountNh4(Alarm alarm){
		int v=alarmDAO.selectCount_nh4(alarm);
	return v;
	}
	public List<Pollutant> selectByCriteriaMlss(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_mlss(alarm, alarm.getPager());
		return v;
		}
	public List<Pollutant> selectByCriteriaMlssAPI(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_mlssAPI(alarm, alarm.getPager());
		return v;
		}
	public int selectCountMlss(Alarm alarm){
		int v=alarmDAO.selectCount_mlss(alarm);
	return v;
	}
	public List<Pollutant> selectByCriteriacu(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_cu(alarm, alarm.getPager());
			return v;
			}
	public int selectCountcu(Alarm alarm){
		int v=alarmDAO.selectCount_cu(alarm);
	return v;
	}
	
	public List<Pollutant> selectByCriteriani(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_ni(alarm, alarm.getPager());
			return v;
			}
	public int selectCountni(Alarm alarm){
		int v=alarmDAO.selectCount_ni(alarm);
	return v;
	}public List<Pollutant> selectByCriteriazn(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_zn(alarm, alarm.getPager());
		return v;
		}
public int selectCountzn(Alarm alarm){
	int v=alarmDAO.selectCount_zn(alarm);
return v;
}

public List<Pollutant> selectByCriteriaTur(Alarm alarm){
	List<Pollutant> v=alarmDAO.selectByCriteria_tur(alarm, alarm.getPager());
	return v;
	}
public int selectCountTur(Alarm alarm){
int v=alarmDAO.selectCount_tur(alarm);
return v;
}
	public List<Pollutant> selectByCriteriacr6(Alarm alarm){
	List<Pollutant> v=alarmDAO.selectByCriteria_cr6(alarm, alarm.getPager());
	return v;
	}
	public List<Pollutant> selectByCriteriacr6API(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_cr6API(alarm, alarm.getPager());
		return v;
		}
	
	public int selectCountcr6(Alarm alarm){
	int v=alarmDAO.selectCount_cr6(alarm);
	return v;
	}
	
	
	
	public List<Pollutant> selectByCriteriaPho(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_pho(alarm, alarm.getPager());
				return v;
				}
	
	public List<Pollutant> selectByCriteriaPhoAPI(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_phoAPI(alarm, alarm.getPager());
				return v;
				}
	public int selectCountPho(Alarm alarm){
		int v=alarmDAO.selectCount_pho(alarm);
	return v;
	}
	public List<Pollutant> selectByCriteriaPh(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_ph(alarm, alarm.getPager());
		return v;
		}
	
	public List<Pollutant> selectByCriteriaPhAPI(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_phAPI(alarm, alarm.getPager());
		return v;
		}
	
	public int selectCountPh(Alarm alarm){
		int v=alarmDAO.selectCount_ph(alarm);
	return v;
	}
     public List<Pollutant> selectByCriteriaZtr(Alarm alarm){
    	 List<Pollutant> v=alarmDAO.selectByCriteria_ztr(alarm, alarm.getPager());
			return v;
			}
     
     public List<Pollutant> selectByCriteriaZtrAPI(Alarm alarm){
    	 List<Pollutant> v=alarmDAO.selectByCriteria_ztrAPI(alarm, alarm.getPager());
			return v;
			}
     
     public int selectCountZtr(Alarm alarm){
 		int v=alarmDAO.selectCount_ztr(alarm);
 	return v;
 	}
     public List<Pollutant> selectByCriteriaVol(Alarm alarm){
    	 List<Pollutant> v=alarmDAO.selectByCriteria_vol(alarm, alarm.getPager());
			return v;
			}
     
     public List<Pollutant> selectByCriteriaVolAPI(Alarm alarm){
    	 List<Pollutant> v=alarmDAO.selectByCriteria_volAPI(alarm, alarm.getPager());
			return v;
			}
     
     public int selectCountVol(Alarm alarm){
 		int v=alarmDAO.selectCount_vol(alarm);
 	return v;
 	}
	
	
	public List<Alarm> selectByCriteria2(Long rid){
		List<Alarm> v=alarmDAO.selectByCriteria2(rid);
	return v;
	}
	public List<Pollutant> selectByCriteria_value(Alarm alarm){
		List<Pollutant> v=alarmDAO.selectByCriteria_value(alarm);
	return v;
	}
	
	public List<Alarm> selectByHistory2(Alarm alarm){
		List<Alarm> list=alarmDAO.selectByHistory2(alarm, alarm.getPager());
		return list;
	}
	
	
	public int selectCount(Alarm alarm){
		return alarmDAO.selectCount(alarm);
	}
	/*预警最新一条*/
	public List<Alarm> selectByWarningCriteria2(Long rid){
		return alarmDAO.selectByWarningCriteria2(rid);
	}
	public List<Alarm> selectByWarningCriteria3(Long rid){
		return alarmDAO.selectByWarningCriteria(rid);
	}
	
	public List<Alarm> selectByWarningHistory(Alarm alarm){
		return alarmDAO.selectByWarningHistory2(alarm, alarm.getPager());
	}
	
	public int selectWarningCount(Alarm alarm){
		return alarmDAO.selectWarningCount(alarm);
	}
	
}
