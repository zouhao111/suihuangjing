package com.erich.saleticket.dao.tdht;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.sys.SysUser;
import com.erich.saleticket.model.tdht.KeyState;
import com.erich.saleticket.model.tdht.ViewLog;


/**
 *操作日志
 */

@DAO
public interface LogDAO {
	
	
	@SQL("INSERT INTO sys_login_log (user_id, account,create_date,ip,type) VALUES (:1.userId, :1.account,:1.lastVisit,:1.ipAddress,:1.type)")
	public int addLoginLog(SysUser sysUser);
	
	
	@SQL("select operationRid,userIp,operationtype,operationvalue,userName,updataTime,`describe`,companyName " +
			"from viewlog,tabcompanyconfig  " +
			"where viewlog.operationRid=tabcompanyconfig.Rid  "+
			" #if(!empty(:1.companyName)){ and companyName like '%##(:1.companyName)%' }  "+
			" #if(!empty(:1.userName)){ and userName like '%##(:1.userName)%' }  "+
			" #if(!empty(:1.startingTime)){ and updataTime>= '##(:1.startingTime)' } "+
			" #if(!empty(:1.endTime)){and updataTime<= '##(:1.endTime)' } "+
			"order by updataTime desc")
	 public List<ViewLog>  selectByCriteriapdf(ViewLog  viewLog);
	
	@SQL("SELECT operationRid,userIp,userName,updataTime,str,companyName " +
			"from tabloginstate2,tabcompanyconfig  " +
			"where tabloginstate2.operationRid=tabcompanyconfig.Rid  "+
			" #if(!empty(:1.companyName)){ and companyName like '%##(:1.companyName)%' }  "+
			" #if(!empty(:1.userName)){ and userName like '%##(:1.userName)%' }  "+
			" #if(!empty(:1.startingTime)){ and updataTime>= '##(:1.startingTime)' } "+
			" #if(!empty(:1.endTime)){and updataTime<= '##(:1.endTime)' } "+
			"order by updataTime desc")
	public List<ViewLog>  selectByCriteriaNEW(ViewLog  viewLog);
	
	/**
	 * 操作日志列表
	 */
	@	SQL("select operationRid,userIp,operationtype,operationvalue,userName,updataTime,`describe`,companyName " +
			"from viewlog,tabcompanyconfig  " +
			"where viewlog.operationRid=tabcompanyconfig.Rid  "+
			" #if(!empty(:1.companyName)){ and companyName like '%##(:1.companyName)%' }  "+
			" #if(!empty(:1.userName)){ and userName like '%##(:1.userName)%' }  "+
			" #if(!empty(:1.startingTime)){ and updataTime>= '##(:1.startingTime)' } "+
			" #if(!empty(:1.endTime)){and updataTime<= '##(:1.endTime)' } "+
			"order by updataTime desc   limit :2.pageOffset, :2.pageSize")
	 public List<ViewLog>  selectByCriteria(ViewLog  viewLog,Pager pager);
	/**
	 * 实时数据操作记录
	 */
	@	SQL("select operationRid,userIp,operationtype,operationvalue,userName,updataTime,`describe`,companyName " +
			"from viewlog,tabcompanyconfig  " +
			"where viewlog.operationRid=tabcompanyconfig.Rid  "+
			" #if(!empty(:1)){ and viewlog.operationRid = '##(:1)%' }  "+
			"order by updataTime desc  limit 4")
	 public List<ViewLog>  selectByCriteriaData(Long rid);
	
	/**
	 * 列表统计
	 */
	@	SQL("select COUNT(operationRid) from viewlog,tabcompanyconfig " +
			"where viewlog.operationRid=tabcompanyconfig.Rid " +
			" #if(!empty(:1.companyName)){ and companyName like '%##(:1.companyName)%' } "+
			" #if(!empty(:1.userName)){ and userName like '%##(:1.userName)%' } "+
			" #if(!empty(:1.startingTime)){ and updataTime>= '##(:1.startingTime)' } "+
			" #if(!empty(:1.endTime)){and updataTime<= '##(:1.endTime)' } ")
	public int selectCount(ViewLog viewLog);
	
	
	/**
	 * 离线日志
	 */
	@SQL("SELECT tabmidonline.Rid,strTime,bitOnline,note,companyName,tabmidonline.macId " +
			"from tabmidonline,tabcompanyconfig " +
			"where tabcompanyconfig.Rid=tabmidonline.Rid " +
			" #if(!empty(:1.rid)){ and tabmidonline.Rid= '##(:1.rid)' }  "+
			" #if(!empty(:1.companyName)){ and companyName like '%##(:1.companyName)%' } "+
			" #if(!empty(:1.macId)){ and tabmidonline.macId like '%##(:1.macId)%' } "+
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' } "+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' } "+
			"order by macId,strTime desc ")
	public List<KeyState>  selectByOFCriteria(KeyState  keyState,Pager pager);
	
	
	
	@SQL("SELECT count(tabmidonline.Rid) from tabmidonline,tabcompanyconfig " +
			"where tabcompanyconfig.Rid=tabmidonline.Rid " +
			" #if(!empty(:1.rid)){ and tabmidonline.Rid= '##(:1.rid)' }  "+
			" #if(!empty(:1.macId)){ and tabmidonline.macId like '%##(:1.macId)%' } "+
			" #if(!empty(:1.companyName)){ and companyName like '%##(:1.companyName)%' } "+
			" #if(!empty(:1.startingTime)){ and strTime>= '##(:1.startingTime)' } "+
			" #if(!empty(:1.endTime)){and strTime<= '##(:1.endTime)' } ")
	public int selectOFCount(KeyState keyState);
	
}