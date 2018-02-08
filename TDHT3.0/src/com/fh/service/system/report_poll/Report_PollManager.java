package com.fh.service.system.report_poll;

import java.util.List;

import com.fh.util.PageData;

/** 
 * 说明： 公司污染物小数点限值接口
 * 创建人：FH Q313596790
 * 创建时间：2017-07-03
 * @version
 */
public interface Report_PollManager{

	
	
	/**污染物汇总
	 * poll_day_avg
	 * @param pd
	 * @throws Exceptionpoll_one_day_max1
	 */
	
	public  List<PageData> poll_day_avg(PageData pd) throws Exception;
	public  List<PageData> poll_day_avg1(PageData pd) throws Exception;
	public  List<PageData> poll_day_avg2(PageData pd) throws Exception;
	public  List<PageData> poll_day_avg3(PageData pd) throws Exception;
	
	public  List<PageData> Max_Poll_day1(PageData pd) throws Exception;
	public  List<PageData> Max_Poll_day2(PageData pd) throws Exception;
	public  List<PageData> Max_Poll_day3(PageData pd) throws Exception;
	public  List<PageData> Min_Poll_day1(PageData pd) throws Exception;
	public  List<PageData> Min_Poll_day2(PageData pd) throws Exception;
	public  List<PageData> Min_Poll_day3(PageData pd) throws Exception;
	
	public  List<PageData> poll_one_day(PageData pd) throws Exception;
	
	
	
	
	
}

