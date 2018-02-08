package com.erich.saleticket.biz.sys;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.erich.saleticket.dao.sys.SysMenuDAO;
import com.erich.saleticket.dao.sys.SysRoleMenuDAO;
import com.erich.saleticket.dao.sys.SysUserMenuDAO;
import com.erich.saleticket.model.sys.SysMenu;
import com.erich.saleticket.model.sys.SysRoleMenu;
import com.erich.saleticket.model.sys.SysUserCompany;
import com.erich.saleticket.model.sys.SysUserMenu;
import com.erich.saleticket.model.tdht.ViewCompanyconfig;

@Service
public class SysMenuBiz{
	/*@Resource  
	private SysMenuMapper sysMenuMapper;*/
	/*@Resource
	private SysUserMenuMapper sysUserMenuMapper;
	@Resource
	private SysRoleMenuMapper sysRoleMenuMapper;*/
	
	@Resource
	SysMenuDAO sysMenuMapper;
	
	@Resource
	SysRoleMenuDAO sysRoleMenuDAO;
	
	@Resource
	SysUserMenuDAO sysUserMenuDAO;
	

	public List<SysMenu> selectByCriteria(SysMenu sysMenu) {
		return sysMenuMapper.selectByCriteria(sysMenu,sysMenu.getPager());
	}

	//@Override
	public JSONArray selectByCriteriaToJsonForMenuList(SysMenu sysMenu) {
		List<SysMenu> menus = sysMenuMapper.selectByCriteria(sysMenu,sysMenu.getPager());
	    JSONArray arr = new JSONArray();
	    for (int i = 0; i < menus.size(); i++) {
	    	SysMenu menu = menus.get(i);
	    	JSONObject obj = new JSONObject();
	    	obj.put("id", menu.getMenuId());
	    	
	    	SysMenu tempMenu = new SysMenu();
	    	tempMenu.setParentId(menu.getMenuId());
	    	tempMenu.getPager().setOrderField("t.sort_code");
	    	tempMenu.getPager().setOrderDirection(false);
//	    	List<SysMenu> tempmenus = sysMenuMapper.selectByCriteria(tempMenu);
//	    	if(menu.getParentId() == 0){//如果有子模块
//	    		JSONObject userObject = new JSONObject();
//	    		userObject.put("isGroup", true);
//	    		obj.put("userObject", userObject);
//	    		obj.put("isOpen", true);
//	    	}else{
//	    		obj.put("pid", menu.getParentId());
//	    		if(tempmenus.size() > 0){
//	    			JSONObject userObject = new JSONObject();
//		    		userObject.put("isGroup", true);
//		    		obj.put("userObject", userObject);
//		    		obj.put("isOpen", true);
//	    		}
//	    	}
	    	if(menu.getParentId() != 0)
	    	obj.put("pid", menu.getParentId());
//    		if(tempmenus.size() > 0){
    			JSONObject userObject = new JSONObject();
	    		userObject.put("isGroup", true);
	    		obj.put("userObject", userObject);
	    		obj.put("isOpen", true);
//    		}
	    	JSONObject dataObject = new JSONObject();//页面数据的封装
	    	dataObject.put("fullName", menu.getFullName());
	    	dataObject.put("code", menu.getCode());
	    	dataObject.put("target", menu.getTarget());
	    	dataObject.put("navigateUrl", menu.getNavigateUrl());
	    	dataObject.put("sortCode", menu.getSortCode());
	    	dataObject.put("enabled", menu.getEnabled() == 1 ? "有效" : "无效");
	    	obj.put("dataObject", dataObject);
	    	obj.put("order", menu.getSortCode());
	    	arr.add(obj);
		}
		return arr;
	}

	public JSONArray selectByCriteriaToJsonForAdd(SysMenu sysMenu) {
		List<SysMenu> menus = sysMenuMapper.selectByCriteria(sysMenu,sysMenu.getPager());
		return treeMenuList(menus, 0);
	}
	
	/**
	 * 生成菜单树 递归
	 * @param list
	 * @param parentId
	 * @return
	 */
	public JSONArray treeMenuList(List<SysMenu> list, int parentId) {  
	       JSONArray childMenu = new JSONArray();  
	       for (SysMenu menu : list) {  
	    	   JSONObject obj = new JSONObject();
	           int menuId = menu.getMenuId();
	           int pid = menu.getParentId();
	           if (parentId == pid) {  
	               JSONArray c_node = treeMenuList(list, menuId);  
	               obj.put("id", menu.getMenuId());
	               obj.put("name", menu.getFullName());
	               obj.put("children", c_node);  
	               obj.put("open", true);
	               childMenu.add(obj);  
	           }  
	       }  
	       return childMenu;  
	   }  

	public int insert(SysMenu sysMenu) {
		return sysMenuMapper.insert(sysMenu);
	}

	public int selectMaxSortCode() {
		return sysMenuMapper.selectMaxSortCode();
	}

	public int deleteByPrimaryKey(int id) {
		//删除角色菜单关系
	SysRoleMenu sysRoleMenu = new SysRoleMenu();
		sysRoleMenu.setMenuId(id);
		//sysRoleMenuDAO.deleteByCriteria(sysRoleMenu);
		//删除用户菜单关系
		SysUserMenu sysUserMenu = new SysUserMenu();
		sysUserMenu.setMenuId(id);
		//sysUserMenuDAO.deleteByCriteria(sysUserMenu);
		return sysMenuMapper.deleteByPrimaryKey(id);
	}

	public SysMenu selectByPrimaryKey(int id) {
		return sysMenuMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKey(SysMenu sysMenu) {
		return sysMenuMapper.updateByPrimaryKey(sysMenu);
	}

	public JSONArray menuListJson(SysMenu sysMenu) {
		sysMenu.getPager().setOrderField("t.sort_code");
		sysMenu.getPager().setOrderDirection(false);
		List<SysMenu> menus = sysMenuMapper.selectByCriteria(sysMenu,sysMenu.getPager());
		JSONArray arr = new JSONArray();  
	       for (SysMenu menu : menus) {  
	    	   JSONObject obj = new JSONObject();
               obj.put("id", menu.getMenuId());
               obj.put("pId", menu.getParentId());
               obj.put("name", menu.getFullName());
               obj.put("open", true);
               arr.add(obj);  
	       }  
		return arr;
	}
	
	public List<SysMenu> selectMenuByUserId(SysMenu sysMenu) {
		String userId = sysMenu.getCondition().get("userId").toString();
		return sysMenuMapper.selectMenuByUserId(sysMenu,userId);
	}
	
	

	public List<SysMenu> selectMenuByUserId2(SysMenu sysMenu) {
		int pid = sysMenu.getParentId();
		sysMenu.setParentId(null);
		String userId = sysMenu.getCondition().get("userId").toString();
		List<SysMenu> list = sysMenuMapper.selectMenuByUserId(sysMenu,userId);
		list = menuList(list, pid);
		return list;
	}
	
	
	
	/**
	 * 将菜单集合迭代成父子层级的集合
	 * @param list
	 * @param parentId
	 * @return
	 */
	public List<SysMenu> menuList(List<SysMenu> list, int parentId) {  
		List<SysMenu> returnList = new ArrayList<SysMenu>();
	       for (SysMenu menu : list) {  
	           int menuId = menu.getMenuId();
	           int pid = menu.getParentId();
	           
	           if (parentId == pid) {  
	        	   List<SysMenu> childList = menuList(list, menuId);
	        	   for (SysMenu child : childList) {
	        		   menu.getChildMenuList().add(child);
	        	   }
	        	   returnList.add(menu);
	           } 
	       }
	       return returnList;  
	   }  
	
	public List<SysMenu> selectMenuByParenId(Integer parentId,int userId){
	
		if(parentId==null){
			parentId=-1;
		}
		
		return sysMenuMapper.selectMenuByParenId(parentId,userId);
	}
	public List<SysMenu> selectMenuByParenId2(Integer parentId,int userId){
		if(parentId==null){
			parentId=-1;
		}
		List<SysMenu> list = sysMenuMapper.selectMenuByParenId(parentId,userId);
		List<SysMenu> returnList = new ArrayList<SysMenu>();
		for(SysMenu menu:list){
			if(menu.getTarget().equals("Click")){
				int pid=menu.getMenuId();
				List<SysMenu> childList = sysMenuMapper.selectMenuByParenId(pid,userId);
				 for (SysMenu child : childList) {
	        		   menu.getChildMenuList().add(child);
	        	   }
				 
			}
			 returnList.add(menu);
		}
		
		return returnList;
	}
	
	
	
	/**
	 * 根据用户ID查询公司
	 * @param userId
	 * @return
	 */
	public List<SysUserCompany> selectCompanyUserId(Integer userId){
		return sysMenuMapper.selectCompanyUserId(userId);
	}
	
	/**
	 * 左侧导航查询所有公司
	 * @param userId
	 * @return
	 */
	public List<ViewCompanyconfig> selectCompany(){
		return sysMenuMapper.selectCompany();
	}
	public List<ViewCompanyconfig> selectCompany2(){
		return sysMenuMapper.selectCompany2();
	}
	public List<ViewCompanyconfig> selectCompanys(Integer waterType){
		return sysMenuMapper.selectCompanys(waterType);
	}
	public List<ViewCompanyconfig> selectCompanys2(){
		return sysMenuMapper.selectCompanys2();
	}
	public List<ViewCompanyconfig> selectCompany3(Integer waterType){
		return sysMenuMapper.selectCompany3(waterType);
	}
	/**
	 * 左侧导航查询所有公司
	 * @param userId
	 * @return
	 */
	public List<ViewCompanyconfig> selectCompanyOne(long rid){
		return sysMenuMapper.selectCompanyOne(rid);
	}
	
	
}
