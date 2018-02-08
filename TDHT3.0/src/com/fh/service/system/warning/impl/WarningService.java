package com.fh.service.system.warning.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.service.system.warning.WarningManager;
import com.fh.util.PageData;

/** 
 * 说明： 水平衡
 * 创建人：FH Q313596790
 * 创建时间：2017-07-03
 * @version
 */
@Service("WarningService")
public class WarningService implements WarningManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;


	@Override
	public PageData select_now_warning(PageData pd) throws Exception {
		return (PageData) dao.findForObject("WarningManager.select_now_warning", pd);
	}


	@Override
	public PageData select_now_early_warning(PageData pd) throws Exception {
		return (PageData) dao.findForObject("WarningManager.select_now_early_warning", pd);
	}
	
	@Override
	public List<PageData> select_his_warning(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("WarningManager.select_his_warning", pd);
	}


	@Override
	public List<PageData> select_his_early_warning(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("WarningManager.select_his_early_warning", pd);
	}
	
	@Override
	public List<PageData> his_early_warning(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("WarningManager.his_early_warning", pd);
	}
	@Override
	public PageData his_early_warning_count(PageData pd) throws Exception {
		return (PageData) dao.findForObject("WarningManager.his_early_warning_count", pd);
	}
	
}

