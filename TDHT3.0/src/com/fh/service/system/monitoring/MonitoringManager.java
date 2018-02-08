package com.fh.service.system.monitoring;

import java.util.List;

import com.fh.util.PageData;


/**
 *监测单元信息
 *
 */
public interface MonitoringManager {
	
	
	
	/**
	 * 公司单个污染物报警预警
	 */
	public List<PageData>  warning_poll_r_id(PageData pd)throws Exception;
	/**
	 * 公司在线情况
	 */
	public PageData map_online(PageData pd)throws Exception;
	/**
	 * 公司视频
	 */
	public List<PageData> map_video(PageData pd)throws Exception;
	/**
	 * 7日流量
	 */
	public List<PageData> com_water_type(PageData pd)throws Exception;
	
	/**
	 * 7日流量
	 */
	public List<PageData> water_day(PageData pd)throws Exception;
	
/**
 * 报警总数
 */
	public PageData sumReal(PageData pd)throws Exception;
	/**
	 * 预警总数
	 */
	public PageData sumEarly(PageData pd)throws Exception;
	/**
	 * 预警详细
	 */
	public List<PageData> listEarly(PageData pd)throws Exception;
	/**
	 * 报警详细
	 */
	public List<PageData> listReal(PageData pd)throws Exception;
	
	/**
	 * 预警公司总数
	 */
	public PageData earlyRid(PageData pd)throws Exception;
	/**
	 * 报警公司总数
	 */
	public PageData realRid(PageData pd)throws Exception;
	/**
	 * 公司水质报警预警
	 */
	public List<PageData> warning_r_id(PageData pd) throws Exception ;
	public List<PageData> early_r_id(PageData pd) throws Exception ;
	
}
