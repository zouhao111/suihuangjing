package com.fh.service.system.user_center;

import java.util.List;

import com.fh.entity.Page;
import com.fh.util.PageData;


/**
 *监测单元信息
 *
 */
public interface UserCenterManager {

	/**
	 * 查看
	 */
	public List<PageData> listLogin(PageData pd)throws Exception;
	
	public PageData countLogin(PageData pd)throws Exception;
	
}
