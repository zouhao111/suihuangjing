/**
 * 拦截器放在controllers包下，称为局部拦截器，局部拦截器只作用于所在目录以及子目录的控制器
 */
package com.erich.saleticket.controllers.admin;

//import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;
import com.erich.easyframe.util.SystemContext;

/**
 * 页面分页参数拦截器
 * @author ZhengJinLing
 */
public class PagerInterceptor extends ControllerInterceptorAdapter {

	private static Logger logger = LoggerFactory.getLogger(PagerInterceptor.class);

	//	private Cache cache;
	//	public void setCache(Cache cache) {
	//	this.cache = cache;
	//	}

	@Override
	protected Object before(Invocation inv) throws Exception {
		logger.debug("<<<<<<<<<<<<<<<<pager拦截器<<<<<<<<<<<<<<<");
		
		logger.debug("进入方法："+inv.getRequestPath());
		
	
		SystemContext.setOffset(getOffset(inv.getRequest()));
		SystemContext.setPagesize(getPagesize(inv.getRequest()));
		
		       /* String targetName = inv.getClass().getName();
		        String methodName = inv.getMethod().getName();
		        Object[] arguments =inv.getMethodParameters();
		        Object result;
		       logger.debug("Find object from cache is " + cache.getName());
		        String cacheKey = getCacheKey(targetName, methodName, arguments);
		        Element element = cache.get(cacheKey);
		        if (element == null) {
		        	result = inv.
		        logger.debug("Hold up method , Get method result and create cache........!");
		        element = new Element(cacheKey, (Serializable) result);
		        cache.put(element);
		        }*/

		return true;
	};
	
	/*@Override
	public void afterCompletion(final Invocation inv, Throwable ex) throws Exception {
		logger.debug("退出方法："+inv.getRequestPath());
	}
	*/
	
	
	//	private String getCacheKey(String targetName, String methodName, Object[] arguments) {
	//		StringBuffer sb = new StringBuffer();
	//		sb.append(targetName).append(".").append(methodName);
	//		if ((arguments != null) && (arguments.length != 0)) {
	//		for (int i = 0; i < arguments.length; i++) {
	//		sb.append(".").append(arguments[i]);
	//		}
	//		}
	//		return sb.toString();
	//		}

	protected int getOffset(HttpServletRequest request) {
		int offset = 0;
		try {
			offset = Integer.parseInt(request.getParameter("pager.offset"));
		} catch (NumberFormatException ignore) {
		}
		return offset;
	}

	protected int getPagesize(HttpServletRequest request) {
		return 10;
	}
	
	
	
}
