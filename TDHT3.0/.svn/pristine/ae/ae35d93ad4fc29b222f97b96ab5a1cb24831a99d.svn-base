package com.fh.service.system.user_center.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.info.InfoManager;
import com.fh.service.system.quality.QualityManager;
import com.fh.service.system.user_center.UserCenterManager;
import com.fh.util.PageData;

@Service("userCenterService")
public class UserCenterService implements UserCenterManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	public List<PageData> listLogin(PageData pd) throws Exception {
		return (List<PageData>)dao.findForList("UserCenterMapper.listLogin", pd);
	}
	
	public PageData countLogin(PageData pd) throws Exception {
		return (PageData)dao.findForObject("UserCenterMapper.countLogin", pd);
	}
	
	
}