package com.erich.saleticket.biz.tdht;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erich.saleticket.dao.tdht.FeedbackDAO;
import com.erich.saleticket.dto.Pager;
import com.erich.saleticket.model.tdht.Feedback;
import com.erich.saleticket.model.tdht.UserLogin;

@Service
public class FeedbackBiz {

	@Resource
	private FeedbackDAO feedbackDAO;
	
	public int insert(Feedback feedback){
		return feedbackDAO.insert(feedback);
	}
	
	public List<UserLogin> findUserLogin(UserLogin userLogin){
		return feedbackDAO.findUserLogin(userLogin, userLogin.getPager());
	}
	
	public int selectCount(UserLogin userLogin){
		return feedbackDAO.selectCount(userLogin);
	}
	
}
