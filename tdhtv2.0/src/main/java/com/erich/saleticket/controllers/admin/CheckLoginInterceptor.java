package com.erich.saleticket.controllers.admin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.erich.easyframe.util.WebConstants;
import com.erich.saleticket.model.sys.SysUser;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

/**
 * 登录判断拦截器
 * @author ZhengJinLing
 */
public class CheckLoginInterceptor extends ControllerInterceptorAdapter {

	private static Logger logger = LoggerFactory.getLogger(CheckLoginInterceptor.class);

	@Override
	protected Object before(Invocation inv) throws Exception {
		String uri = inv.getRequestPath().getUri();

		//登录和退出不拦截
		if (uri.lastIndexOf("login") > 0 || uri.lastIndexOf("logout") > 0) {
			return true;
		} else {
			
			inv.getRequest().getSession().setMaxInactiveInterval(6000);//设置session的最大有效时间单位为秒
			//System.out.println(inv.getRequest().getSession().getId());
			//当用户登录超时自动跳转登录界面
			SysUser sysUser = (SysUser) inv.getRequest().getSession().getAttribute(WebConstants.CURRENT_USER);
			if (sysUser == null) {//如果是ajax请求响应头会有，x-requested-with；
				if (inv.getRequest().getHeader("x-requested-with") != null
						&& inv.getRequest().getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
					inv.getResponse().setHeader("sessionstatus", "sessionOut");//在响应头设置session状态 
					inv.getResponse().getWriter().print("sessionOut");
					return null;
				} else {
					logger.debug("登录超时");
					String path=inv.getRequest().getContextPath();
					if(path.equals("")||path.equals("/")){
						path="/";
					}else {
						path=path+"/";
					}
					//inv.getResponse().sendRedirect(path);
					inv.getResponse().sendRedirect("/indexs.jsp");
				}
				return false;
			}
			return true;
		}
		
		
		
		
		
		
	};

	/**
	 * @param inv
	 * @Todo 获取客户端ip
	 * @return
	 */
	public String getClientIP(final Invocation inv) {
		HttpServletRequest request = inv.getRequest();
		String address = request.getHeader("X-Forwarded-For");
		if (address != null && isIpAddress(address)) {
			return address;
		}
		
		return request.getRemoteAddr();
	}

	/**
	 * @param s
	 * @return
	 * @Todo ip校验
	 */
	public Boolean isIpAddress(String s) {
		String regex = "(((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.matches();
	}
}
