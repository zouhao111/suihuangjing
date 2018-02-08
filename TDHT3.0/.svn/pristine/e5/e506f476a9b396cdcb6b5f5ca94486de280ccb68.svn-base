package com.fh.service.system.log.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.log.LogManager;
import com.fh.util.PageData;

@Service("logService")
public class LogService implements LogManager {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	public List<PageData> listLog(PageData page) throws Exception {
		return (List<PageData>)dao.findForList("LogMapper.listLog", page);
	}
	
	public PageData countLog(PageData page) throws Exception {
		return (PageData)dao.findForObject("LogMapper.countLog", page);
	}
	
	public void addMaintain(PageData pd)throws Exception{
		dao.save("LogMapper.addMaintain",pd);
	}
	
	public List<PageData> findMaintain(PageData page) throws Exception {
		return (List<PageData>)dao.findForList("LogMapper.findMaintain", page);
	}
	
	public PageData countMaintain(PageData page) throws Exception {
		return (PageData)dao.findForObject("LogMapper.countMaintain", page);
	}
	
	public List<PageData> findControl(PageData page) throws Exception {
		return (List<PageData>)dao.findForList("LogMapper.findControl", page);
	}
	
	public PageData countControl(PageData page) throws Exception {
		return (PageData)dao.findForObject("LogMapper.countControl", page);
	}

}