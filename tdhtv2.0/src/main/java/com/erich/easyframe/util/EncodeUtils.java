package com.erich.easyframe.util;

import org.apache.commons.lang.StringUtils;

public class EncodeUtils {

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;

	public static String encode(String value, String encoding) {
		if (StringUtils.isBlank(value) || StringUtils.isBlank(encoding))
			return null;
		String string = null;
		try {
			if (StringUtils.isNotBlank(value))
				string = new String(java.net.URLEncoder.encode(value, encoding));
			// if(StringUtils.isNotBlank(value)) string = new String(new
			// BASE64Encoder().encode((java.net.URLEncoder.encode(value,encoding)).getBytes()));
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		return string;
	}

	public static String decode(String value, String encoding) {
		if (StringUtils.isBlank(value) || StringUtils.isBlank(encoding))
			return null;
		String result = null;
		try {
			// 解码，然后将字节转换为文件
			// byte[] bytes = new BASE64Decoder().decodeBuffer(value);
			result = java.net.URLDecoder.decode(new String(value), encoding);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getURLEcondString(String str, String econding) {
		String result = "";
		try {
			result = java.net.URLEncoder.encode(str, econding);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getURLDecondString(String str, String econding) {
		String result = "";
		try {
			result = java.net.URLDecoder.decode(str, econding);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
	 */
	public static String entryptPassword(String plainPassword) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
	}

	/**
	 * 验证密码
	 * @param plainPassword 明文密码
	 * @param password 密文密码
	 * @return 验证成功返回true
	 */
	public static boolean validatePassword(String plainPassword, String password) {
		byte[] salt = Encodes.decodeHex(password.substring(0, 16));
		byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, HASH_INTERATIONS);
		return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
	}
	
	
	
	public static void main(String[] args) {
		
		String aa=EncodeUtils.entryptPassword("123456");
		System.out.println(aa);
		System.out.println(EncodeUtils.validatePassword("123456","a08a41ae4ae5c086c9b2f598587b45074da82818c4c53969360f4e41"));
		
//		System.out.println(EncodeUtils.validatePassword("123456", EncodeUtils.entryptPassword("123456")));
//		System.out.println(EncodeUtils.entryptPassword("123456"));
		
	}

}
