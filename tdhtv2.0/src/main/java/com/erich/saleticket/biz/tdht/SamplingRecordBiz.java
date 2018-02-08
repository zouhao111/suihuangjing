package com.erich.saleticket.biz.tdht;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.erich.saleticket.dao.tdht.SamplingRecordDAO;
import com.erich.saleticket.model.tdht.SamplingRecord;

@Service
public class SamplingRecordBiz {

	@Resource
	private SamplingRecordDAO samplingRecordDAO;
	
	
	
	
	public SamplingRecord selectByCriteria(){
		return samplingRecordDAO.selectByCriteria();
	}
	
}
