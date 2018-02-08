package com.fh.service.system.quality.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.quality.QualityManager;
import com.fh.util.PageData;

@Service("qualityService")
public class QualityService implements QualityManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	public List<PageData> listCurve(Page page) throws Exception {
		return (List<PageData>)dao.findForList("QualityMapper.listCurve", page);
	}
	
	
}