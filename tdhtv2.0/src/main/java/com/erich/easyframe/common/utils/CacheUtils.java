package com.erich.easyframe.common.utils;

import java.net.URL;
import java.util.List;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 缓存管理
 * @author 
 */
public class CacheUtils {

	private static Object lockObject = new Object();
	private static CacheManager instance = null;
	private static final String CACHE_NAME = "YhyCaches";

	private CacheUtils() {
	}

	/**
	 * 获取换此类实例
	 * @return LForumCache实例
	 */
	private static CacheManager getInstance() {
		if (instance == null) {
			synchronized (lockObject) {
				instance = new CacheManager(CacheUtils.class.getResource("/ehcache.xml"));
			}
		}
		return instance;
	}

	/**
	 * 获取缓存管理类
	 * @return 缓存管理类
	 */
	@SuppressWarnings("unused")
	private CacheManager getCacheManager() {
		URL url = getClass().getResource("/ehcache.xml");
		return CacheManager.create(url);
	}

	/**
	 * 获取缓存
	 * @return 缓存
	 */
	private static Cache getCache() {
		//Cache cache = new Cache("test", 1, true, false, 5, 2);  
		//manager.addCache(cache);  
		return getInstance().getCache(CACHE_NAME);
	}

	/**
	 * 添加缓存对象
	 * @param key 缓存KEY
	 * @param cacheObj 缓存对象
	 */
	public static void addCache(String key, Object cacheObj) {
		Cache cache = getCache();
		cache.put(new Element(key, cacheObj));
	}

	/**
	 * 获取缓存对象
	 * @param key 缓存KEY
	 * @return 缓存对象
	 */
	public static Object getCache(String key) {
		Element element = getCache().get(key);
		if (element == null) {
			return null;
		}
		return element.getValue();
	}

	/**
	 * 获取指定类型缓存对象
	 * @param <T> 指定类型
	 * @param key 缓存KEY
	 * @param classz 类型Class
	 * @return 指定类型缓存对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getCache(String key, Class<T> classz) {
		if (getCache(key) == null) {
			return null;
		}
		return (T) getCache(key);
	}

	/**
	 * 获取指定类型LIST缓存
	 * @param <T> 指定类型
	 * @param key 缓存KEY
	 * @param classz 类型Class
	 * @return  指定类型LIST缓存
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getListCache(String key, Class<T> classz) {
		if (getCache(key) == null) {
			return null;
		}
		return (List<T>) getCache(key);
	}

	/**
	 * 移除指定KEY缓存对象
	 * @param key 缓存KEY
	 */
	public static void removeCache(String key) {
		if (getCache(key) != null) {
			getCache().remove(key);
		}
	}
	
	
	/**
	 * 即时的被输出到磁盘
	 * @param key 缓存KEY
	 */
	public static void flushCache(String key) {
		if (getCache(key) != null) {
			getCache().flush();
		}
	}
	
	
}
