package com.fh.service.system.newdata.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.service.system.newdata.NewDataManager;
import com.fh.util.PageData;

/** 
 * 说明： 公司污染物小数点限值
 * 创建人：FH Q313596790
 * 创建时间：2017-07-03
 * @version
 */
@Service("NewDataService")
public class NewDataService implements NewDataManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@Override
	
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll_pd(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("NewDataManager.listAll_pd", pd);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll_pd_water(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("NewDataManager.listAll_pd_water", pd);
	}

	@Override
	public List<PageData> listAll_water_state(PageData pd) throws Exception {
		return (List<PageData>)dao.findForList("NewDataManager.listAll_water_state", pd);
	}
	@Override
	public List<PageData> listAll_control(PageData pd) throws Exception {
		return (List<PageData>)dao.findForList("NewDataManager.listAll_control", pd);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public PageData selectOne(PageData pd)throws Exception{
		return (PageData)dao.findForObject("NewDataManager.selectOne", pd);
	}
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> selectListByType(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("NewDataManager.selectListByType", pd);
	}

	@Override
	public List<PageData> selectAllTabName(PageData pd) throws Exception {
		return (List<PageData>)dao.findForList("NewDataManager.selectAllTabName", pd);
	}

	

}

