package com.erich.saleticket.controllers.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContextAware;

/**
 * 上下文环境保存器.<br/>
 * 此类用于:<br/>
 * <ul>
 * <li>获取或设置当前用户会话信息{@link FrameworkContext}对象的辅助类.</li>
 * <li>获取当前线程的Request、Response以及特殊的模块ID（mid）</li>
 * <li>由于其被配置到Spring中(bdf-core-configs.xml),且实现了{@link ApplicationContextAware}
 * 接口,因此其内部的唯一实例保存了ApplicationContext,可以据此感知Spring.详情请参见
 * {@link #getSpringBeanFactory}和{@link #getSpringBean}两个函数.</li>
 * </ul>
 *
 * @author ZhengJinLing
 * @since 1.0
 */
public class ContextHolder {

	/**
	 * 保存HttpServletResponse的线程局部变量.
	 */
	private static final ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<HttpServletResponse>();
	/**
	 * 保存HttpServletRequest的线程局部变量.
	 */
	private static final ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<HttpServletRequest>();

	public static HttpServletRequest getRequest() {
		return requestThreadLocal.get();
	}

	/**
	 * 得到当前线程中的HttpServletResponse对象
	 *
	 * @return 返回当前线程的HttpServletResponse对象
	 */
	public static HttpServletResponse getResponse() {
		return responseThreadLocal.get();
	}

	/**
	 * 将一个key-value对放到当前线程Request中的Attribute当中
	 *
	 * @param key key值
	 * @param obj 具体对象
	 */
	public static void setRequestAttribute(String key, Object obj) {
		requestThreadLocal.get().setAttribute(key, obj);
	}

	/**
	 * 从当前线程中Request中取Attribute值
	 *
	 * @param key Attribute值对应的key
	 * @return 返回与该key对应的值对象
	 */
	public static Object getRequestAttribute(String key) {
		return requestThreadLocal.get().getAttribute(key);
	}

	/**
	 * 从当前线程中Request中取parameter值
	 *
	 * @param key parameter的key
	 * @return 与key对象的字符串值
	 */
	public static String getRequestParameter(String key) {
		return requestThreadLocal.get().getParameter(key);
	}

	public static void clearContext() {
		responseThreadLocal.remove();
		requestThreadLocal.remove();
	}

	public static void setHttpRequestResponseHolder(HttpServletRequest request, HttpServletResponse response) {
		requestThreadLocal.set(request);
		responseThreadLocal.set(response);
	}

}
