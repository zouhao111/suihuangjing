package com.erich.easyframe.common.utils;

/**
 * 清除缓存
 * @author Administrator
 *
 */
public class ClearCache {
	
	//清除菜单缓存
	public static  void clearMenu(){
		CacheUtils.addCache("menuList", null);//首页菜单
		CacheUtils.addCache("sysMenuList", null);//系统管理里面菜单
	}
	//清除产品缓存
	public static  void clearProduct(){
		CacheUtils.addCache("productinfoList", null);//产品
	}
	//清除产品类型缓存
	public static void clearProductType(){
		CacheUtils.addCache("productTypeList", null);//产品类型.
	}
	//清除省份缓存
	public static void clearProvince(){
		CacheUtils.addCache("provincelist1", null);//省份
	}
	//清除部门缓存
	public static void clearOrganization(){
		CacheUtils.addCache("sysOrganizationList", null);//部门
	}
	//清除角色缓存
	public static void clearSysRole(){
		CacheUtils.addCache("sysRoleList", null);//角色
	}
	//清除用户缓存
	public static void clearUser(){
		CacheUtils.addCache("userList", null);//用户
	}
	
	
	
}
