package com.fh.service.system.log;

import java.util.List;

import com.fh.entity.Page;
import com.fh.util.PageData;


/**
 *监测单元信息
 *
 */
public interface LogManager {

	/**
	 * 查看设备日志
	 */
	public List<PageData> listLog(PageData page)throws Exception;
	
	/**
	 * 查看设备日志
	 */
	public PageData countLog(PageData page)throws Exception;
	
	/**
	 * 新增维护记录
	 */
	public void addMaintain(PageData pd)throws Exception;
	
	/**
	 * 查询维护日志
	 */
	public List<PageData> findMaintain(PageData page)throws Exception;
	
	/**
	 * 查询维护日志总条数
	 */
	public PageData countMaintain(PageData page)throws Exception;
	
	/**
	 * 查询操作日志
	 */
	public List<PageData> findControl(PageData page)throws Exception;
	
	/**
	 * 查询操作日志总条数
	 */
	public PageData countControl(PageData page)throws Exception;
}
