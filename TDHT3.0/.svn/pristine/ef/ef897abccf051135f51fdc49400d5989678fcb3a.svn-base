package com.fh.service.system.poll_sum.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.service.system.poll_sum.Poll_SumManager;
import com.fh.util.PageData;

/** 
 * 说明： 水平衡
 * 创建人：FH Q313596790
 * 创建时间：2017-07-03
 * @version
 */
@Service("Poll_SumService")
public class Poll_SumService implements Poll_SumManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	
	
	@Override
	public PageData list_Poll_Sum(PageData pd) throws Exception {
		return (PageData) dao.findForObject("Poll_SumService.list_poll_all_sum", pd);
	}



	@Override
	public PageData list_Poll_Sum2(PageData pd) throws Exception {
		return (PageData) dao.findForObject("Poll_SumService.list_poll_all_sum2", pd);
	}
	@Override
	public PageData list_Poll_Sum3(PageData pd) throws Exception {
		return (PageData) dao.findForObject("Poll_SumService.list_poll_all_sum3", pd);
	}
	
	@Override
	public List<PageData> list_poll_hour_sum1(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Poll_SumService.list_poll_hour_sum1", pd);
	}
	@Override
	public List<PageData> list_poll_hour_sum2(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Poll_SumService.list_poll_hour_sum2", pd);
	}
	@Override
	public List<PageData> list_poll_hour_sum3(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Poll_SumService.list_poll_hour_sum3", pd);
	}
	
	@Override
	public List<PageData> list_poll_day_sum1(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Poll_SumService.list_poll_day_sum1", pd);
	}
	@Override
	public List<PageData> list_poll_day_sum2(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Poll_SumService.list_poll_day_sum2", pd);
	}
	@Override
	public List<PageData> list_poll_day_sum3(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Poll_SumService.list_poll_day_sum3", pd);
	}



	@Override
	public PageData selectMaxCyc(PageData pd) throws Exception {
		return (PageData) dao.findForObject("Poll_SumService.selectMaxCyc", pd);
	}
	
}

