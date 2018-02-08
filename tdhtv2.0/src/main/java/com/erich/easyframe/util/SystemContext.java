package com.erich.easyframe.util;

public class SystemContext {

	@SuppressWarnings("rawtypes")
	private static ThreadLocal offset = new ThreadLocal();
	@SuppressWarnings("rawtypes")
	private static ThreadLocal pagesize = new ThreadLocal();

	/** 
	 * 从线程中获取offset字段 
	 * @return 
	 */
	public static int getOffset() {
		Integer os = (Integer) offset.get();
		if (os == null) {
			return 0;
		}
		return os;
	}

	@SuppressWarnings("unchecked")
	public static void setOffset(int offsetvalue) {
		offset.set(offsetvalue);
	}

	public static void removeOffset() {
		offset.remove();
	}

	public static int getPagesize() {
		Integer ps = (Integer) pagesize.get();
		if (ps == null) {
			return Integer.MAX_VALUE;
		}
		return ps;
	}

	@SuppressWarnings("unchecked")
	public static void setPagesize(int pagesizevalue) {
		pagesize.set(pagesizevalue);
	}

	public static void removePagesize() {
		pagesize.remove();
	}

}
