package com.erich.saleticket.controllers.admin.tdht;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erich.easyframe.util.SystemContext;
import com.erich.saleticket.biz.tdht.FeedbackBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.model.tdht.Feedback;
import com.erich.saleticket.model.tdht.UserLogin;

/**
 * 意见反馈
 */
public class FeedbackController extends BaseController{

	@Resource
	private FeedbackBiz feedbackBiz;
	
	
	public String findFeedback(){
		return "feedback/add";
	}
	
	/**
	 * 添加意见反馈
	 */
	public void saveFeedback(Feedback feedback,HttpServletRequest request, HttpServletResponse response){
		
		feedback.setUserId(getUser(request).getUserId());
		feedback.setAccount(getUser(request).getAccount());
		feedback.setRealName(getUser(request).getRealName());
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		feedback.setStringTime(format.format(date)); 
		
		
		int result = feedbackBiz.insert(feedback);
		if (result > 0) {
			writerJson(response, successMsg("添加成功"));
		} else {
			writerJson(response, errorMsg("添加失败"));
		}
	}
	
	/**
	 * 用户登录信息
	 */
	public String findUserLogin(UserLogin userLogin,HttpServletRequest request, HttpServletResponse response){
		String sTime=userLogin.getStartingTime();
		String eTime=userLogin.getEndTime();
		String account=userLogin.getAccount();//用户名
		
		if(sTime==null||eTime==null||account==null){
			
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat formats=new SimpleDateFormat("yyyy-MM-dd");
			eTime=format.format(date);
			sTime=formats.format(date)+" 00:00:00";
			userLogin.setEndTime(eTime);
			userLogin.setStartingTime(sTime);
		}
		
		
		int offset = SystemContext.getOffset();
		int pagesize = SystemContext.getPagesize();
		userLogin.getPager().setPageOffset(offset);
		userLogin.getPager().setPageSize(pagesize);
		userLogin.getPager().setOrderField("user_id");
		userLogin.getPager().setOrderDirection(false);
		userLogin.getPager().setRowCount(feedbackBiz.selectCount(userLogin));
		
		List<UserLogin>  userLogins=feedbackBiz.findUserLogin(userLogin);
		
		request.setAttribute("pager", userLogin.getPager());
		request.setAttribute("userLogins", userLogins);
		request.setAttribute("sTime", sTime);
		request.setAttribute("eTime", eTime);
		request.setAttribute("account", account);
		return "feedback/userLoginList";
	}
	

}
