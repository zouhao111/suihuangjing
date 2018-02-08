package com.fh.service.system.control.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.service.system.control.ControlManager;
import com.fh.util.PageData;

/** 
 * 说明： 公司污染物小数点限值
 * 创建人：FH Q313596790
 * 创建时间：2017-07-03
 * @version
 */
@Service("ControlService")
public class ControlService implements ControlManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@Override
	public List<PageData> select_online(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("ControlManager.select_online", pd);
	}
	
	
	
}

