package com.erich.saleticket.dao.tdht;


import java.util.List;

import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.tdht.Feedback;
import com.erich.saleticket.model.tdht.HistoryReport;
import com.erich.saleticket.model.tdht.UserLogin;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

@DAO
public interface FeedbackDAO {

	@SQL("INSERT into feedback(userId,real_name,account,dateTime,content,title,emil)  " +
			"value(:1.userId,:1.realName,:1.account,:1.stringTime,:1.content,:1.title,:1.emil)")
	public int insert(Feedback feedback);
	
	
	@SQL("SELECT * from sys_login_log where 1=1" +
			" #if(!empty(:1.account)){ and account= '##(:1.account)' }"+
			" #if(!empty(:1.startingTime)){ and create_date>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and create_date<= '##(:1.endTime)' }"+
			" ORDER BY create_date desc  limit :2.pageOffset, :2.pageSize ")
	public List<UserLogin> findUserLogin(UserLogin userLogin,Pager pager);
	
	
	@SQL("SELECT count(id) from sys_login_log where 1=1 " +
			" #if(!empty(:1.account)){ and account= '##(:1.account)' }"+
			" #if(!empty(:1.startingTime)){ and create_date>= '##(:1.startingTime)' }"+
			" #if(!empty(:1.endTime)){and create_date<= '##(:1.endTime)' }"+
			"ORDER BY create_date desc  ")
	public int selectCount(UserLogin userLogin);
	
	
}
