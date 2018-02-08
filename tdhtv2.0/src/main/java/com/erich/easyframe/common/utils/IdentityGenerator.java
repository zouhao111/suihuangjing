package com.erich.easyframe.common.utils;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * 主键生成器
 * </p>
 * 
 * @version 1.0, 11/02/10
 * @since 1.0
 * @author ZhengJinLing
 */
public class IdentityGenerator {

	public static IdentityGenerator instance = new IdentityGenerator();
	private static final Log log = LogFactory.getLog(IdentityGenerator.class);
	private static Long increaseValue = 10000l;
//	private static Long voucherValue = 1000l;
//	private static Integer voucherCertificateValue = 1000;

	private static Integer increaseDialogValue = 1;

	private IdentityGenerator() {
	}

	public synchronized String getId() {
		String nu = increaseValue.toString();
		if (nu != "10000") {
			nu = nu.substring(nu.length() - 4, nu.length());
		}
//		if (new Integer(nu) == 10000) {//查询数据库初始化 最大喵喵号码
//			SaleTicketDAO orderInfoDAO = SpringContextHolder.getBean(SaleTicketDAO.class);
//			List<String> list = orderInfoDAO.getMaxNumber();
//			if (list.get(0) != null && list.size() > 0) {
//				String n = list.get(0).toString();
//				n = n.substring(n.length() - 4, n.length());
//				if (Long.valueOf(n) > 10000L) {
//					String curDateTime = DateUtils.formatDate(new Date(), DateUtils.PATTERN_DATETIME_NOMAL);
//					String fullC = fill("");
//					String res = curDateTime + fullC;
//					increaseValue = new Long(res);
//				} else {
//					String curDateTime = DateUtils.formatDate(new Date(), DateUtils.PATTERN_DATETIME_NOMAL);
//					String res = curDateTime + n;
//					increaseValue = new Long(res);
//				}
//			} else {
//				String curDateTime = DateUtils.formatDate(new Date(), DateUtils.PATTERN_DATETIME_NOMAL);
//				String fullC = fill(increaseValue.toString());
//				String res = curDateTime + fullC;
//				increaseValue = new Long(res);
//			}
//		} else {
//			String curDateTime = DateUtils.formatDate(new Date(), DateUtils.PATTERN_DATETIME_NOMAL);
//			String n = increaseValue.toString();
//			n = n.substring(n.length() - 4, n.length());
//			String res = curDateTime + n;
//			increaseValue = new Long(res);
//		}
//		increaseValue++;
		return increaseValue.toString();
	}

	public synchronized String getDialogId() {
		String res = "";
		String curDateTime = DateUtils.formatDate(new Date(), DateUtils.PATTERN_DATETIME_NOMAL);
		if (increaseDialogValue > 9998) {
			increaseDialogValue = 1;
		}
		String fullC = fill(increaseDialogValue.toString());
		res = curDateTime + fullC;
		increaseDialogValue++;
		if (log.isInfoEnabled())
			log.info("当前生成的主键是：" + res);
		return res;
	}

	/**
	 * 填充字符
	 * @param oriC  原始字符
	 * @param fullC 填充字符
	 * @param size  总长度
	 * @return
	 */
	/*private static final String PK_FILL_CHARACTER = "0";
	private String fillCharacter(String oriC, String fillC, int size) {
		String res = "";
		if (oriC != null) {
			int oriCLen = oriC.length();
			for (int i = size - oriCLen; i > 0; i--) {
				res += fillC;
			}
		}
		res += oriC;
		return res;
	}*/

	/**
	 * 固定长度填充
	 * @param text
	 * @return
	 */
	public static String fill(String text) {
		if (text.length() <= 4)
			return text;
		else {
			return "0000";
		}
	}

	/**
	 * 固定长度填充
	 * @param text
	 * @return
	 */
	public static String fillVoucher(String text) {
		if (text.length() <= 3)
			return text;
		else
			return "000";
	}

	/**
	 * 固定长度填充
	 * @param text
	 * @return
	 */
	public static String fillVoucher1(String text) {
		if (text.length() == 3)
			return text;
		else {
			StringBuffer a = new StringBuffer();
			int y = text.length();
			while (y < 3) {
				a.append('0');
				y++;
			}
			
			
			return a + text;
		}

	}

	/**
	 * 可变长度填充
	 * @param text
	 * @param size
	 * @return
	 */
	public static String fill(String text, int size) {
		StringBuilder builder = new StringBuilder(text);
		while (builder.length() < size) {
			builder.append('0');
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(IdentityGenerator.instance.getId());
			System.out.println(Long.valueOf(IdentityGenerator.instance.getDialogId()));
		}
	}

}
