package com.fh.service.system.quality;

import java.util.List;

import com.fh.entity.Page;
import com.fh.util.PageData;


/**
 * 水量接口
 *
 */
public interface QualityManager {

	/**
	 * 查看水量列表
	 */
	public List<PageData> list(Page page)throws Exception;
	
}
