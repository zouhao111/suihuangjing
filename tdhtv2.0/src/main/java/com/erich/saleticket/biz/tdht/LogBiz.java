package com.erich.saleticket.biz.tdht;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.erich.saleticket.dao.tdht.LogDAO;
import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.sys.SysUser;
import com.erich.saleticket.model.tdht.Alarm;
import com.erich.saleticket.model.tdht.KeyState;
import com.erich.saleticket.model.tdht.ViewLog;

@Service
public class LogBiz {

	@Resource
	private LogDAO logDAO;
	 public List<ViewLog>  selectByCriteriapdf(ViewLog  viewLog){
		 return logDAO.selectByCriteriapdf(viewLog);
	 }
	 public List<ViewLog>  selectByCriteriaNEW(ViewLog  viewLog){
		 return logDAO.selectByCriteriaNEW(viewLog);
	 }
	 
	 public List<ViewLog>  selectByCriteria(ViewLog  viewLog){
		 return logDAO.selectByCriteria(viewLog, viewLog.getPager());
	 }
	 
	 public int selectCount(ViewLog viewLog){
		 return logDAO.selectCount(viewLog);
	 }
	 
	 public int addLoginLog(SysUser sysUser){
		 return logDAO.addLoginLog(sysUser);
	 }
	 
	 public List<KeyState>  selectByOFCriteria(KeyState  keyState){
		 return logDAO.selectByOFCriteria(keyState, keyState.getPager());
	 }
	 
	 public int selectOFCount(KeyState keyState){
		 return logDAO.selectOFCount(keyState);
	 }
}
