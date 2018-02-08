package com.erich.easyframe.util;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 * 随机生成数据码
 * @author ZhengJinLing
 *
 */
public class RandomString {

	/**
	 * 每位允许的字符
	 */
	//private static final String POSSIBLE_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	//private static final String POSSIBLE_CHARS = "0123456789abcdefghijklmnopqrstuvwxyz";
	private static final String POSSIBLE_CHARS = "0123456789";

	/**
	 * 生产一个指定长度的随机字符串
	 * @param length 字符串长度
	 * @return
	 */
	public String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		SecureRandom random = new SecureRandom();
		for (int i = 1; i <= length; i++) {
			sb.append(POSSIBLE_CHARS.charAt(random.nextInt(POSSIBLE_CHARS.length())));
			//加中划线
			//			if (i % 4 == 0) {
			//				sb.append("-");
			//			}
		}
		//sb.deleteCharAt(sb.length() - 1);
		//		if (Global.isSyncTicket()!=null&&Global.isSyncTicket().equals("1")) {
		//			sb.append("P");
		//		}
		return sb.toString();
	}

	/**
	 * 生成2000000个随机字符串，检查是否出现重复
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> check = new HashSet<String>();
		RandomString obj = new RandomString();
		System.out.println(obj.generateRandomString(16));
		for (int i = 0; i < 2000000; i++) {
			String s = obj.generateRandomString(16);
			if (check.contains(s)) {
				throw new IllegalStateException("Repeated string found : " + s);
			} else {
				if (i % 1000 == 0)
					System.out.println("generated " + i / 1000 + "000 strings.");
				check.add(s);
			}
		}
	}
}
