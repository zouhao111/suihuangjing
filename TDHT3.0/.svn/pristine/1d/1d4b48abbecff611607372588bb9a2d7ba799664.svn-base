package com.fh.service.system.report_poll.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.service.system.report_poll.Report_PollManager;
import com.fh.util.PageData;

/** 
 * 说明： 水平衡
 * 创建人：FH Q313596790
 * 创建时间：2017-07-03
 * @version
 */
@Service("Rrport_PollService")
public class Rrport_PollService implements Report_PollManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	
	
	@SuppressWarnings("unchecked")
	public List<PageData> poll_day_avg(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Rrport_PollService.poll_day_avg", pd);
	}
	@SuppressWarnings("unchecked")
	public List<PageData> poll_day_avg1(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Rrport_PollService.poll_day_avg1", pd);
	}
	@SuppressWarnings("unchecked")
	public List<PageData> poll_day_avg2(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Rrport_PollService.poll_day_avg2", pd);
	}
	@SuppressWarnings("unchecked")
	public List<PageData> poll_day_avg3(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Rrport_PollService.poll_day_avg3", pd);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<PageData> Max_Poll_day1(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Rrport_PollService.poll_day_max1", pd);
	}
	@SuppressWarnings("unchecked")
	public List<PageData> Max_Poll_day2(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Rrport_PollService.poll_day_max2", pd);
	}
	@SuppressWarnings("unchecked")
	public List<PageData> Max_Poll_day3(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Rrport_PollService.poll_day_max3", pd);
	}
	
	@SuppressWarnings("unchecked")
	public List<PageData> Min_Poll_day1(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Rrport_PollService.poll_day_min1", pd);
	}
	@SuppressWarnings("unchecked")
	public List<PageData> Min_Poll_day2(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Rrport_PollService.poll_day_min2", pd);
	}
	@SuppressWarnings("unchecked")
	public List<PageData> Min_Poll_day3(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Rrport_PollService.poll_day_min3", pd);
	}
	@SuppressWarnings("unchecked")
	public List<PageData> poll_one_day(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("Rrport_PollService.poll_one_day", pd);
	}
	
	
	
}

