package com.fh.service.system.monitoring.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.service.system.monitoring.MonitoringManager;
import com.fh.util.PageData;

@Service("monitoringService")
public class MonitoringService implements MonitoringManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/**
	 * 公司单个污染物报警预警
	 */
	public List<PageData>  warning_poll_r_id(PageData pd)throws Exception{
		return (List<PageData> )dao.findForList("MonitoringMapper.warning_poll_r_id", pd);
	}
	/**
	 * 公司在线情况
	 */
	public PageData map_online(PageData pd)throws Exception{
		return (PageData)dao.findForObject("MonitoringMapper.map_online", pd);
	}
	
	public List<PageData> map_video(PageData pd) throws Exception {
		return (List<PageData>)dao.findForList("MonitoringMapper.map_video", pd);
	}
	public List<PageData> com_water_type(PageData pd) throws Exception {
		return (List<PageData>)dao.findForList("MonitoringMapper.com_water_type", pd);
	}
	public List<PageData> water_day(PageData pd) throws Exception {
		return (List<PageData>)dao.findForList("MonitoringMapper.water_day", pd);
	}
	public PageData sumReal(PageData pd) throws Exception {
		return (PageData)dao.findForObject("MonitoringMapper.sumReal", pd);
	}
	
	public PageData sumEarly(PageData pd) throws Exception {
		return (PageData)dao.findForObject("MonitoringMapper.sumEarly", pd);
	}
	@SuppressWarnings("unchecked")
	public List<PageData> warning_r_id(PageData pd) throws Exception {
		return (List<PageData>)dao.findForList("MonitoringMapper.warning_r_id", pd);
	}
	@SuppressWarnings("unchecked")
	public List<PageData> early_r_id(PageData pd) throws Exception {
		return (List<PageData>)dao.findForList("MonitoringMapper.early_r_id", pd);
	}
	public List<PageData> listReal(PageData pd) throws Exception {
		return (List<PageData>)dao.findForList("MonitoringMapper.listReal", pd);
	}
	
	public List<PageData> listEarly(PageData pd) throws Exception {
		return (List<PageData>)dao.findForList("MonitoringMapper.listEarly", pd);
	}
	
	public PageData realRid(PageData pd) throws Exception {
		return (PageData)dao.findForObject("MonitoringMapper.realRid", pd);
	}
	
	public PageData earlyRid(PageData pd) throws Exception {
		return (PageData)dao.findForObject("MonitoringMapper.earlyRid", pd);
	}
}