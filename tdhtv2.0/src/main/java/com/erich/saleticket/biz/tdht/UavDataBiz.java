package com.erich.saleticket.biz.tdht;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.erich.saleticket.dao.tdht.UavDataDAO;
import com.erich.saleticket.model.tdht.Uav;

@Service
public class UavDataBiz {

	@Resource
	private UavDataDAO uavDataDAO;
	
	public int addUavData(Uav uav){
		return uavDataDAO.addUavData(uav);
	}
	
	
}
