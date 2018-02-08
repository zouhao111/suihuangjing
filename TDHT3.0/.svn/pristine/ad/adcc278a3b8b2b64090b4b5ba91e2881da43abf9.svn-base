package com.fh.service.system.his_report.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.service.system.his_report.His_ReportManager;
import com.fh.util.PageData;

/** 
 * 说明： 水平衡
 * 创建人：FH Q313596790
 * 创建时间：2017-07-03
 * @version
 */
@Service("His_ReportService")
public class His_ReportService implements His_ReportManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@Override
	public List<PageData> water_type(PageData pd) throws Exception {
		
		return (List<PageData>) dao.findForList("His_ReportService.water_type", pd);
	}

	@Override
	public List<PageData> line_his_water(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("His_ReportService.line_his_water", pd);
	}

	@Override
	public List<PageData> line_his_poll1(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("His_ReportService.line_his_poll1", pd);
	}
	@Override
	public List<PageData> line_his_poll2(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("His_ReportService.line_his_poll2", pd);
	}
	@Override
	public List<PageData> line_his_poll3(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("His_ReportService.line_his_poll3", pd);
	}
	
	
	
	
	
	
}

