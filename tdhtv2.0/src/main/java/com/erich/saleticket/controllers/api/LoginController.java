package com.erich.saleticket.controllers.api;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import com.erich.saleticket.biz.sys.SysMenuBiz;
import com.erich.saleticket.biz.sys.SysUserBiz;
import com.erich.saleticket.biz.tdht.LogBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.dto.ApiResultcode;
import com.erich.saleticket.dto.Data;
import com.erich.saleticket.dto.MobileData;
import com.erich.saleticket.model.sys.SysUser;
import com.erich.saleticket.model.sys.SysUserCompany;

public class LoginController extends BaseController{

	@Resource
	private SysUserBiz sysUserBiz;
	@Resource
	private SysMenuBiz sysMenuBiz;
	@Resource
	private LogBiz logBiz;
	
	/**
	 * APP用户登录
	 */
	@Get("login")
	@Post("login")
	public String LoginController(SysUser sysUser, HttpServletRequest request, HttpServletResponse response)   {
		MobileData<Integer> result = new MobileData<Integer>(ApiResultcode._0);
		String ip=sysUser.getIpAddress();
		sysUser=sysUserBiz.login(sysUser);
		
		if(sysUser !=null){
			List<SysUserCompany> userCompany=sysMenuBiz.selectCompanyUserId(sysUser.getUserId());
			
			SysUser logUser = new SysUser();
			
			logUser.setIpAddress(ip);
			logUser.setUserId(sysUser.getUserId());
			logUser.setLastVisit(new Date());
			logUser.setAccount(sysUser.getAccount());
			logUser.setType(1);
			logBiz.addLoginLog(logUser);
			
			result.setResult(userCompany.get(0).getCompanyId());
			result.init(ApiResultcode._1, "成功");
		}
  		 return "@" + encodeJson(result);
	}

}
