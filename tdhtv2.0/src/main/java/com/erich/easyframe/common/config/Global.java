package com.erich.easyframe.common.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.erich.easyframe.common.utils.PropertiesLoader;
import com.erich.easyframe.util.LunarCalendar;

/**
 * 全局配置文件 (自定义函数)
 */
public class Global {

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = null;

	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader propertiesLoader = new PropertiesLoader("application.properties");

	static {
		map = new HashMap<String, String>();
		Properties properties = propertiesLoader.getProperties();
		Iterator<?> itr = properties.entrySet().iterator();
		while (itr.hasNext()) {
			@SuppressWarnings("unchecked")
			Entry<String, String> e = (Entry<String, String>) itr.next();
			map.put(e.getKey(), e.getValue());
		}
	}

	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		return value;
	}

	/**
	 * 获取项目名称 （电商系统）
	 */
	public static String getProjectName() {
		return getConfig("projectName");
	}

	/**
	 * 获取当前日期（YYYY年MM月dd日，星期一，农历：四月初一）
	 */
	public static String getNowDate() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy 年 M 月 d 日");
		String date = df.format(new Date());
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		calendar.setTime(new Date());
		int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		String week = weekDays[w];
		LunarCalendar lunarCalendar = new LunarCalendar(new Date());
		return date + "&nbsp;,&nbsp;" + week + "&nbsp;,&nbsp;农历&nbsp;&nbsp;" + lunarCalendar.toString();
	}

	/**
	 * 获取当前时间 （YYYY-MM-dd） 
	 * @return
	 */
	public static String getDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new Date());
		return date;
	}

	/**
	 * 获取当前时间（YYYY-MM-dd mm:dd）
	 * @return
	 */
	public static String getDateTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String date = df.format(new Date());
		return date;
	}

	/**
	 * 充值确认（伤处图片路径）
	 * @return
	 */
	public static String getImgUrl() {
		return getConfig("imgUrl");
	}

	/**
	 * 获取景区名称
	 * @return
	 */
	public static String getScenicName() {
		return getConfig("scenicName");
	}

	/**
	 * 是否同步内部票务系统
	 * @return
	 */
	public static String isSyncTicket() {
		return getConfig("isSyncTicket");
	}

	/*	public static List<SysMenu> getSysMenu(final HttpServletRequest request) {
			//final SysUser loginUser = (SysUser) inv.getRequest().getSession().getAttribute("loginUser");
			SysMenuBiz sysMenuBiz = SpringContextHolder.getBean(SysMenuBiz.class);
			List<SysMenu> menuList = sysMenuBiz.findSubMenuTree(1);
			request.getSession().setAttribute("menuList", menuList);
			return menuList;
		}*/
}
