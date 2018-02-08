package com.fh.service.system.info.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.info.InfoManager;
import com.fh.service.system.quality.QualityManager;
import com.fh.util.PageData;

@Service("infoService")
public class InfoService implements InfoManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	public List<PageData> listQuality(Page page) throws Exception {
		return (List<PageData>)dao.findForList("InfoMapper.listQuality", page);
	}
	
	public List<PageData> listControl(Page page) throws Exception {
		return (List<PageData>)dao.findForList("InfoMapper.listControl", page);
	}
	
}