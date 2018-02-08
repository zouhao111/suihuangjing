package com.erich.saleticket.biz.tdht;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erich.saleticket.dao.tdht.PollutantDAO;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.ViewZtraffic;

@Service
public class PollutantBiz {

	
	@Resource
	private PollutantDAO dao;
	
	public Pollutant selectByPollutant2(Pollutant pollutant){
		return dao.selectByPollutant2(pollutant);
	}
	public  ViewZtraffic selectByPollutant3(Pollutant pollutant){
		return dao.selectByPollutant3(pollutant);
	}
	public  ViewZtraffic selectByPollutant4(Pollutant pollutant){
		return dao.selectByPollutant4(pollutant);
	}
	public  List<ViewZtraffic> selectByPollutant5(Pollutant pollutant){
		return dao.selectByPollutant5(pollutant);
	}
	public  List<ViewZtraffic> selectByPollutant04(Pollutant pollutant){
		return dao.selectByPollutant04(pollutant);
	}
}
