package com.fh.service.system.conf_param.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.service.system.conf_param.Conf_paramManager;
import com.fh.util.PageData;

/** 
 * 说明： 公司污染物小数点限值
 * 创建人：FH Q313596790
 * 创建时间：2017-07-03
 * @version
 */
@Service("conf_paramService")
public class Conf_paramService implements Conf_paramManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("Conf_paramMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("Conf_paramMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("Conf_paramMapper.edit", pd);
	}
	
	/**列表 水质
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("Conf_paramMapper.datalistPage", page);
	}
	/**列表水量
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list_water(Page page)throws Exception{
		return (List<PageData>)dao.findForList("Conf_paramMapper.datalistPage_water", page);
	}
	
	/**列表 水质
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list_pd(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("Conf_paramMapper.datalistPage", pd);
	}
	/**列表水量
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list_water_pd(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("Conf_paramMapper.datalistPage_water", pd);
	}
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll_pd(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("Conf_paramMapper.listAll_pd", pd);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll_pd_water(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("Conf_paramMapper.listAll_pd_water", pd);
	}
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("Conf_paramMapper.listAll", pd);
	}
	/**列表(全部)通过设备ID查询
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAllByDev(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("Conf_paramMapper.listAllByDev", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("Conf_paramMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("Conf_paramMapper.deleteAll", ArrayDATA_IDS);
	}
	
}

