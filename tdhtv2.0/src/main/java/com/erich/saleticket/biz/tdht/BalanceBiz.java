package com.erich.saleticket.biz.tdht;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erich.saleticket.dao.tdht.BalanceDAO;
import com.erich.saleticket.dao.tdht.PollutantDAO;
import com.erich.saleticket.model.tdht.Balancea;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.ViewLineReport;

@Service
public class BalanceBiz {

	@Resource
	private BalanceDAO balanceDAO;
	
	@Resource
	private PollutantDAO dao;
	/*//水平衡
	public ViewLineReport selectByCriteria(Balancea balancea){
		return balanceDAO.selectByCriteria(balancea);
	}
	public List<ViewLineReport> selectByCriteria2(Balancea balancea){
		return balanceDAO.selectByCriteriaend(balancea);
	}
	*/
	
	public ViewLineReport selectByCriteria(Balancea balancea){
		return balanceDAO.selectByCriteria(balancea);
	}
	
	
	public Balancea selectByCriteriaPH(Balancea balancea){
		return balanceDAO.selectByCriteriaPH(balancea);
	}
	public Balancea selectMinZtraffic(Balancea balancea){
		return balanceDAO.selectMinZtraffic(balancea);
	}
	
	
	public Balancea selectMaxZtraffic(Balancea balancea){
		return balanceDAO.selectMaxZtraffic(balancea);
	}
	
	public Balancea selectUnknown(Balancea balancea){
		return balanceDAO.selectUnknown(balancea);
	}


	public List<Pollutant> selectPollutant(Pollutant pollutant) {
		return dao.selectByPollutant(pollutant);
	}
	
	
}
