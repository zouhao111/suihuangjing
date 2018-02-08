package com.erich.saleticket.biz.tdht;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erich.saleticket.dao.tdht.ReportFormDAO;
import com.erich.saleticket.model.tdht.BalanceComfig;
import com.erich.saleticket.model.tdht.Pollutant;
import com.erich.saleticket.model.tdht.Pollutant_Water;
import com.erich.saleticket.model.tdht.ViewData;
import com.erich.saleticket.model.tdht.ViewLineReport;
import com.erich.saleticket.model.tdht.ViewdaliyReport;

@Service
public class ReportFormBiz {

	@Resource
	private ReportFormDAO reportFormDAO;
	
	//日报表的水质
	public int insertBalanceTime(BalanceComfig comfig){
		return reportFormDAO.insertBalanceTime(comfig);
	}
	public List<ViewdaliyReport> selectByCriteria(ViewdaliyReport viewdaliyReport){
		return reportFormDAO.selectByCriteria(viewdaliyReport,viewdaliyReport.getPager());
	}
	public List<ViewdaliyReport> selectByCriteria_pdf(ViewdaliyReport viewdaliyReport){
		return reportFormDAO.selectByCriteria2(viewdaliyReport);
	}
	public List<Pollutant> selectByCriterias(ViewdaliyReport viewdaliyReport){
		return reportFormDAO.selectByCriterias(viewdaliyReport,viewdaliyReport.getPager());
	}
	public List<Pollutant> selectByCriteria2_pdf(ViewdaliyReport viewdaliyReport){
		return reportFormDAO.selectByCriteriass_pdf(viewdaliyReport,viewdaliyReport.getPager());
	}
	public List<ViewLineReport> selectByCriteria2(ViewdaliyReport viewdaliyReport){
		return reportFormDAO.selectByCriteria2(viewdaliyReport,viewdaliyReport.getPager());
	}
	/**
	 * 水环境查询
	 * @param viewdaliyReport
	 * @return
	 */
	public List<ViewLineReport> selectByCriteria2_water(ViewdaliyReport viewdaliyReport){
		return reportFormDAO.selectByCriteria2_water(viewdaliyReport,viewdaliyReport.getPager());
	}
	
	
	public List<ViewLineReport> selectByCriterias_pdf(ViewdaliyReport viewdaliyReport){
		return reportFormDAO.selectByCriteria_pdf(viewdaliyReport);
	}
	public List<Pollutant> selectByCriteria3(ViewdaliyReport viewdaliyReport){
		return reportFormDAO.selectByCriteria3(viewdaliyReport,viewdaliyReport.getPager());
	}
	public List<Pollutant> selectByCriteria3_pdf(ViewdaliyReport viewdaliyReport){
		return reportFormDAO.selectByCriteria3_pdf(viewdaliyReport);
	}
	
	public List<Pollutant_Water> selectByCriteria_water(ViewdaliyReport viewdaliyReport){
		return reportFormDAO.selectByCriteria_water(viewdaliyReport,viewdaliyReport.getPager());
	}
	public List<Pollutant_Water> selectByCriteria_water_pdf(ViewdaliyReport viewdaliyReport){
		return reportFormDAO.selectByCriteria_water_pdf(viewdaliyReport);
	}
	public int selectCount_water(ViewdaliyReport data){
		return reportFormDAO.selectCount_water(data);
	}
	
	
	public List<Pollutant> selectByCriteria4(ViewdaliyReport viewdaliyReport){
		return reportFormDAO.selectByCriteria4(viewdaliyReport,viewdaliyReport.getPager());
	}
	public int selectCount(ViewdaliyReport data){
		return reportFormDAO.selectCount(data);
	}
	public int selectCountDay(ViewdaliyReport data){
		return reportFormDAO.selectCountDay(data);
	}
	
}
