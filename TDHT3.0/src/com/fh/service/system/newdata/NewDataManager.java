package com.fh.service.system.newdata;

import java.util.List;

import com.fh.util.PageData;

/** 
 * 说明： 公司污染物小数点限值接口
 * 创建人：FH Q313596790
 * 创建时间：2017-07-03
 * @version
 */
public interface NewDataManager{

	
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAll_pd(PageData pd)throws Exception;
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAll_pd_water(PageData pd)throws Exception;
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAll_water_state(PageData pd)throws Exception;
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> listAll_control(PageData pd)throws Exception;
	

	/**查一个
	 * @param pd
	 * @throws Exception
	 */
	public PageData selectOne(PageData pd)throws Exception;
	
	/**查一个
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> selectListByType(PageData pd)throws Exception;
	
	
	/**查所有的表名
	 * @param pd
	 * @throws Exception
	 */
	public List<PageData> selectAllTabName(PageData pd)throws Exception;
}

