package com.erich.saleticket.controllers;

import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import com.erich.easyframe.util.JsonUtil;
import com.erich.easyframe.util.WebConstants;
import com.erich.saleticket.biz.sys.SysUserBiz;
import com.erich.saleticket.biz.tdht.LogBiz;
import com.erich.saleticket.dto.MsgReturn;
import com.erich.saleticket.model.sys.SysUser;

/**
 * 后台登录控制器
 * @author lvwei
 *
 */
@Path("")
public class LoginController extends BaseController {

	@Resource
	private SysUserBiz sysUserBiz;
	@Resource
	private LogBiz logBiz;

	/**
	 * 登录
	 * @return 
	 */
	@Get("login")
	@Post("login")
	public String login(@Param("Rid") Long  Rid,SysUser sysUser, String authCode, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ip=sysUser.getIpAddress();
		sysUser = sysUserBiz.login(sysUser);
		if (null != sysUser && sysUser.getUserId() > 0) {//登录成功
			if (sysUser.getEnabled() == 0) {//如果账号被禁用
				writerJson(response, JsonUtil.toJson(new MsgReturn(false, "登录失败！该用户已被禁用，请联系管理员！")));
			} else {
				SysUser tempUser = new SysUser();
				SysUser logUser = new SysUser();
				
				//String	ip=getIpAddr(request);
				logUser.setIpAddress(ip);
				logUser.setUserId(sysUser.getUserId());
				logUser.setLastVisit(new Date());
				logUser.setAccount(sysUser.getAccount());
				logUser.setType(0);
				logBiz.addLoginLog(logUser);
				
				tempUser.setUserId(sysUser.getUserId());
				tempUser.setLogOnCount(sysUser.getLogOnCount() + 1);
				tempUser.setLastVisit(new Date());
		
				sysUserBiz.updateByPrimaryKey1(tempUser);
				
				if(Rid !=null){
					/*List<SysUserCompany>   sysUserCompany=sysMenuBiz.selectCompanyUserId(sysUser.getUserId());//根据用户ID查询公司
					SysUserCompany sysUserCompanys=sysUserCompany.get(0);//获取对应公司的第一条
					request.getSession().setAttribute(WebConstants.USER_COMPANY,sysUserCompanys);*/
					sysUser.setRid(Rid);
					request.getSession().setAttribute(WebConstants.CURRENT_USER, sysUser);
					return "r:admin/index";
				}else{
					writerJson(response, successMsg(sysUser.getAccount() + "登录成功"));
					request.getSession().setAttribute(WebConstants.CURRENT_USER, sysUser);
				}
				
			}
		} else {//登录失败
			writerJson(response, JsonUtil.toJson(new MsgReturn(false, "登录失败！用户名或密码输入错误！")));
		}
		return null; 
	}
	/**
	 * 退出登录 
	 */
	@Get("logout")
	public String logout(final Invocation inv) {
		try {
			inv.getRequest().getSession().removeAttribute(WebConstants.CURRENT_USER);
			inv.getResponse().sendRedirect(inv.getRequest().getContextPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "indexs";
	}
	@Get("logretrn")
	@Post("logretrn")
	public String logretrn(@Param("rid") Long rid) {
		String url="admin/tdht/data/indexHtml?state=0&rid="+rid;
		return "r:"+url;
	}
	
}
