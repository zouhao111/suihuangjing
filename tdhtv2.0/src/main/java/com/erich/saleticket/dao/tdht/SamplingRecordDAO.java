package com.erich.saleticket.dao.tdht;

import com.erich.saleticket.model.tdht.SamplingRecord;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface SamplingRecordDAO {
	
	/**
	 * 查询采样记录的最后一条数据
	 */
	@SQL	("select * from odk_a4 as a4 order by a4.ID desc limit 1 ")
	public SamplingRecord selectByCriteria();
	
	
	
	
}