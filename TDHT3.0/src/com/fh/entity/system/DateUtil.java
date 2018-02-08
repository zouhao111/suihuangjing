package com.fh.entity.system;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class DateUtil {

	public static Date getDateFromString(String str) {
		Date result = null;
		try {
			if(StringUtils.isNotBlank(str)) {
				SimpleDateFormat formatter = null;
				if(str.length() == 4) {
					formatter = new SimpleDateFormat("yyyy");
					result = formatter.parse(str);
				}else if(str.length() == 7) {
					formatter = new SimpleDateFormat("yyyy-MM");
					result = formatter.parse(str);
				}else if(str.length() == 10) {
					formatter = new SimpleDateFormat("yyyy-MM-dd");
					result = formatter.parse(str);
				}else if(str.length() == 13) {
					formatter = new SimpleDateFormat("yyyy-MM-dd HH");
					result = formatter.parse(str);
				}else if(str.length() == 16) {
					formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					result = formatter.parse(str);
				}else if(str.length() == 19) {
					formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					result = formatter.parse(str);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String getDateTime(Date date) {
		String result = "";
		if(date == null) date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		result = formatter.format(date);
		return result;
	}
	
	//获取当前系统时间的字符串
	public static String getCurrentSystemTime() {
		return String.valueOf(new Date().getTime());
	}
	
	//获取系统时间的后n为数字
	public static String getSystemTimeByReverseLength(int len) {
		StringBuffer result = new StringBuffer();
		String time = String.valueOf(new Date().getTime());
		for(int i=time.length()-1;i>=time.length()-len;i--) result.append(time.charAt(i));
		return result.toString();
	}
}
