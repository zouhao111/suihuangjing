package com.erich.saleticket.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.apache.commons.lang.ArrayUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.erich.easyframe.util.JsonUtil;
import com.erich.easyframe.util.MyEditor;
import com.erich.easyframe.util.URLUtils;
import com.erich.easyframe.util.WebConstants;
import com.erich.saleticket.controllers.context.ContextHolder;
import com.erich.saleticket.dto.MsgReturn;
import com.erich.saleticket.model.sys.SysUser;
import com.erich.saleticket.model.sys.SysUserCompany;

import net.paoding.rose.web.Invocation;

/**
 * 基类控制器
 * @author lvwei
 *
 */
public class BaseController {

	@Resource
	protected Validator validator;
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	protected String separator = File.separator;

	
	
	
		 
		  private static String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }
		 
		  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		    InputStream is = new URL(url).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONObject json = new JSONObject(jsonText);
		      return json;
		    } finally {
		      is.close();
		     // System.out.println("同时 从这里也能看出 即便return了，仍然会执行finally的！");
		    }
		  }
	
	
	
	
	
	/**
	 * 输出JSON
	 * @param response
	 * @param jsonStr
	 */
	protected void writerJson(HttpServletResponse response, String jsonStr) {
		writer(response, jsonStr);
	}

	/**
	 * 输出JSON
	 * @param response
	 * @param object
	 */
	protected void writerJson(HttpServletResponse response, Object object) {
		try {
			response.setContentType("application/json");
			writer(response, JsonUtil.toJson(object));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Request获取参数值 */
	public String getParameter(String param) {
		// HttpServletRequest request = ((ServletRequestAttributes)
		// RequestContextHolder.getRequestAttributes())
		// .getRequest();
		// ServletRequestAttributes reqAttr = (ServletRequestAttributes)
		// RequestContextHolder.getRequestAttributes();
		// HttpServletRequest request = reqAttr.getRequest();
		return ContextHolder.getRequest().getParameter(param);
	}

	/** 获取Json参数 */
	public String getParam(String name) {
		return decodeJson(getParameter(name));
	}

	/** BASE64解码 */
	public String decodeJson(String parameter) {
		// if (StringUtils.hasText(parameter)) {
		//String param = EncodeUtils.decode(parameter, SystemConfig.JSON_ENCODING);
		String param = parameter, SystemConfig;
		return param;
		// } else {
		// throw new RuntimeException("参数错误");
		// }
	}

	/**
	 * 输出HTML
	 * @param response
	 * @param htmlStr
	 */
	protected void writerHtml(HttpServletResponse response, String htmlStr) {
		writer(response, htmlStr);
	}

	/**
	 * 获取writer
	 * @param response
	 * @param str
	 */
	protected void writer(HttpServletResponse response, String str) {
		try {
			//设置页面不缓存 
			//response.setHeader("Pragma", "No-cache");
			//response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "Pragma");
			response.setHeader("Cache-Control", "public");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = null;
			out = response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 输出xml
	 * @param xmlStr
	 */
	protected void outXMLString(HttpServletResponse response, String xmlStr) {
		response.setContentType("application/xml;charset=UTF-8");
		writer(response, xmlStr);
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		binder.registerCustomEditor(int.class, new MyEditor());
	}

	/**
	 * 获取IP地址
	 * @param request
	 * @return
	 */
	protected String getIpAddr(HttpServletRequest request) {
		
		
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 所有ActionMap 统一从这里获取
	 * @return
	 */
	protected Map<String, Object> getRootMap() {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.putAll(URLUtils.getUrlMap());
		return rootMap;
	}

	/**
	 * 获得当前登录用户
	 * @param request
	 * @return
	 */
	protected SysUser getUser(HttpServletRequest request) {
		SysUser sysUser = (SysUser) request.getSession().getAttribute(WebConstants.CURRENT_USER);
		return sysUser;
	}
	

	/*
	 * 获取当前登录用户对应公司的rid和访问路径
	 */
	protected SysUserCompany getUserCompany(HttpServletRequest request){
		SysUserCompany	sysUserCompany=(SysUserCompany) request.getSession().getAttribute(WebConstants.USER_COMPANY);
		return sysUserCompany;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected ModelAndView forword(String viewName, Map context) {
		return new ModelAndView(viewName, context);
	}

	protected ModelAndView error(String errMsg) {
		return new ModelAndView("error");
	}

	protected String successMsg(String msg) {
		return new MsgReturn(true, msg).toString();
	}

	protected String errorMsg(String msg) {
		return new MsgReturn(false, msg).toString();
	}

	/**
	 * 检查上传文件大小及类型
	 * @param inv
	 * @param maxSizeInByte
	 * @param allowTypes
	 * @param contextType
	 * @return
	 */

	public boolean check(final Invocation inv, long maxSizeInByte, String[] allowTypes, String contextType) {
		int requestContentLength = inv.getRequest().getContentLength();
		if (requestContentLength < maxSizeInByte && ArrayUtils.contains(allowTypes, contextType)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	* 获取当前登录用户Id
	* @param inv
	* @param request
	* @return
	*/
	@SuppressWarnings("unchecked")
	public <T> T getUser(final Invocation inv, Class<T> classz, String key) {
		T loginUser = (T) inv.getRequest().getSession().getAttribute(key);

		return loginUser;
	}
	

	/**
	 * 服务端参数有效性验证
	 * 
	 * @param object 验证的实体对象
	 * @param groups 验证组
	 * @return 验证成功：返回true；严重失败：将错误信息添加到 message 中
	 */
	protected boolean beanValidator(Object object, Class<?>... groups) {
		try {
			validateWithException(validator, object, groups);
		} catch (ConstraintViolationException ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 调用JSR303的validate方法, 验证失败时抛出ConstraintViolationException.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void validateWithException(Validator validator, Object object, Class<?>... groups) throws ConstraintViolationException {
		Set constraintViolations = validator.validate(object, groups);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}

	/** 把对象生成JSON并Base64编码 */
	public String encodeJson(Object o) {
		return JsonUtil.toJson(o);
	}

	/**
	 * 根据请求流获取数据
	 * @param inv
	 * @return
	 */
	public String getRequestString(final Invocation inv) {
		String param = null;
		try {
			InputStream inputStream = inv.getRequest().getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) inputStream));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			param = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return param;
	}

	protected String getCtxPath(HttpServletRequest request) {
		String ctxPath = request.getSession().getServletContext().getRealPath("/") + "excel" + File.separator;
		return ctxPath;
	}

	/**
	 * 下载 
	 * @param storeName 文件名
	 * @param realName 真实名称
	 * @throws Exception
	 */
	protected void download(HttpServletRequest request, HttpServletResponse response, String storeName, String realName) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String ctxPath = request.getSession().getServletContext().getRealPath("/") + "excel" + File.separator;
		String downLoadPath = ctxPath + storeName;
		long fileLength = new File(downLoadPath).length();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment; filename=" + new String(realName.getBytes("utf-8"), "ISO8859-1"));
		response.setHeader("Content-Length", String.valueOf(fileLength));
		bis = new BufferedInputStream(new FileInputStream(downLoadPath));
		bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();
	}

	public Double fixed(Double d,int i){
		BigDecimal   b1   =   new   BigDecimal(d);  
		Double   num   =   b1.setScale(i,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
		return num;
	}
	
	public class Rands {
		public String Rands() {
			Random rd = new Random(); // 创建随机对象
			String n = ""; //保存随机数
			int rdGet; // 取得随机数
			do {
				if (rd.nextInt() % 2 == 1) {
					rdGet = Math.abs(rd.nextInt()) % 10 + 48; // 产生48到57的随机数(0-9的键位值)
				} else {
					rdGet = Math.abs(rd.nextInt()) % 26 + 97; // 产生97到122的随机数(a-z的键位值)
				}
				char num1 = (char) rdGet; //int转换char
				String dd = Character.toString(num1);
				n += dd;
			} while (n.length() < 8);// 设定长度，此处假定长度小于8

			return n;
		}
	}
}
