package com.erich.saleticket.controllers.admin.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;

import com.alibaba.fastjson.JSONArray;
import com.erich.easyframe.util.WebConstants;
import com.erich.saleticket.biz.sys.SysMenuBiz;
import com.erich.saleticket.biz.tdht.DataBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.model.sys.SysMenu;
import com.erich.saleticket.model.sys.SysUser;
import com.erich.saleticket.model.sys.SysUserCompany;

/**
 * 系统菜单控制器
 * @author Lv
 *
 */
public class SysMenuController extends BaseController {
	@Resource
	private SysMenuBiz sysMenuBiz;
	@Resource
	private DataBiz dataBiz;
	/**
	 * 进入主界面
	 */
	public String mainMenu(SysMenu sysMenu, HttpServletRequest request, HttpServletResponse response) {
		SysUser sysUser = getUser(request);
		sysMenu.getCondition().put("userId", sysUser.getUserId());
		request.setAttribute("currentFirstMenu", sysMenu.getParentId());
		List<SysMenu> menus = sysMenuBiz.selectMenuByUserId2(sysMenu);
/*       List<SysUserCompany>   sysUserCompany=sysMenuBiz.selectCompanyUserId(sysUser.getUserId());//根据用户ID查询公司
		
		SysUserCompany sysUserCompanys=sysUserCompany.get(0);//获取对应公司的第一条
		Integer companyId=sysUserCompanys.getCompanyId();
		 List<Integer> list=new ArrayList<Integer>();
		 if(companyId==3000){
		 list=dataBiz.selectcomType(rid);*/
		request.setAttribute(WebConstants.CURRENT_USER_SECOND_MENUS, menus);
		//		String defaultMod = request.getParameter("defaultMod");
		//		if(defaultMod != null && StringUtils.isNotEmpty(defaultMod)){
		//			for (int i = 0; i < menus.size(); i++) {
		//				System.out.println(defaultMod.equals(menus.get(i).getMenuId().toString()));
		//				if(defaultMod.equals(menus.get(i).getMenuId().toString())){
		//					request.setAttribute("defaultUrl", menus.get(i).getNavigateUrl());
		//					break;
		//				}
		//			}
		//			request.setAttribute("defaultMod", defaultMod);
		//		}else{
		//			request.setAttribute("defaultUrl", menus.size() > 0 ? menus.get(0).getNavigateUrl() : "");
		//			request.setAttribute("defaultMod", 1);
		//		}
		return "mainmenu";
	}

	
	
	/**
	 * 功能菜单
	 */
	public String minMenu(SysMenu sysMenu, HttpServletRequest request, HttpServletResponse response) {
		SysUser sysUser = getUser(request);
		Long rid=sysMenu.getRid();
		List<SysMenu> lastMenu= sysMenuBiz.selectMenuByParenId2(sysMenu.getParentId(),sysUser.getUserId());
		request.setAttribute("rid", rid);
		request.setAttribute("lastMenu", lastMenu);
		Integer parentId=sysMenu.getParentId();
		StringBuffer webUrl=request.getRequestURL();
		
		String url2=webUrl+"?parentId="+parentId;
		request.setAttribute("webUrls", url2);
		return "minmenu";
	}
	
	/**
	 * 主页
	 */
	public String mains(@Param("Rid") Long Rid,SysMenu sysMenu, HttpServletRequest request, HttpServletResponse response) {
		StringBuffer webUrl=request.getRequestURL();
		String url2=webUrl+"?nameId=1";
		request.setAttribute("webUrls", url2);
	
	/*	if(Rid!=null){
			String url="/admin/tdht/data/indexHtml?state=0"+"&rid="+Rid;
			return "r:"+url;
		}*/
		
		return "mains";
	}
	
	
	
	
	/**
	 * 模块管理
	 * @param sysMenu
	 * @param request
	 * @param response
	 * @return
	 */
	public String menuList(HttpServletRequest request, HttpServletResponse response) {
		return "menu/menuList";
	}

	/**
	 * 异步获取模块列表 返回json数据 主界面列表显示
	 * @param request
	 * @param response
	 */
	public String menuListJsonForMenuList(HttpServletRequest request, HttpServletResponse response) {
		SysMenu sysMenu = new SysMenu();
		sysMenu.getPager().setOrderField("t.sort_code");
		sysMenu.getPager().setOrderDirection(false);
		JSONArray arr = sysMenuBiz.selectByCriteriaToJsonForMenuList(sysMenu);
		return "@" + encodeJson(arr);
	}

	/**
	 * 异步获取模块列表 返回json数据 添加界面 下拉列表显示
	 */
	public String menuListJsonForAdd(HttpServletRequest request, HttpServletResponse response) {
		SysMenu sysMenu = new SysMenu();
		sysMenu.getPager().setOrderField("t.sort_code");
		sysMenu.getPager().setOrderDirection(false);
		JSONArray arr = sysMenuBiz.selectByCriteriaToJsonForAdd(sysMenu);
		return "@" + encodeJson(arr);
	}

	/**
	 * 进入添加界面
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) {
		return "menu/add";
	}

	/**
	 * 进入修改界面
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(final Invocation inv, SysMenu sysMenu, HttpServletRequest request, HttpServletResponse response) {
		sysMenu = sysMenuBiz.selectByPrimaryKey(sysMenu.getMenuId());
		inv.addModel("sysMenu", sysMenu);
		return "menu/edit";
	}

	/**
	 * 查询序列最大值
	 */
	public void selectMaxSortCode(HttpServletResponse response) {
		int maxSortCode = sysMenuBiz.selectMaxSortCode();
		writerJson(response, maxSortCode);
	}

	/**
	 * 添加保存
	 * @param request
	 * @param response
	 * @return
	 */
	public void addSave(SysMenu sysMenu, HttpServletRequest request, HttpServletResponse response) {
		sysMenu.setCreateDate(new Date());
		sysMenu.setCreateUserId(getUser(request).getUserId());
		sysMenu.setCreateUserName(getUser(request).getRealName());
		if(sysMenu.getEnabled() == null){
			sysMenu.setEnabled(0);
		}
		int result = sysMenuBiz.insert(sysMenu);
		if (result > 0) {
			writerJson(response, successMsg("添加成功"));
		} else {
			writerJson(response, errorMsg("添加失败"));
		}
	}

	/**
	 * 编辑保存
	 * @param request
	 * @param response
	 * @return
	 */
	public void editSave(SysMenu sysMenu, HttpServletRequest request, HttpServletResponse response) {
		sysMenu.setModifyDate(new Date());
		sysMenu.setModifyUserId(getUser(request).getUserId());
		sysMenu.setModifyUserName(getUser(request).getRealName());
		if(sysMenu.getEnabled() == null){
			sysMenu.setEnabled(0);
		}
		int result = sysMenuBiz.updateByPrimaryKey(sysMenu);
		if (result > 0) {
			writerJson(response, successMsg("修改成功"));
		} else {
			writerJson(response, errorMsg("修改失败"));
		}
	}

	/**
	 * 删除
	 * @param request  
	 * @param response
	 * @return
	 */
	public void del(SysMenu sysMenu, HttpServletRequest request, HttpServletResponse response) {
		int result = sysMenuBiz.deleteByPrimaryKey(sysMenu.getMenuId());
		if (result > 0) {
			writerJson(response, successMsg("删除成功"));
		} else {
			writerJson(response, errorMsg("删除失败"));
		}
	}

	/**
	 * 角色列表 设置权限 菜单列表json
	 * @param sysMenu
	 * @param request
	 * @param response
	 * @param inv
	 * @return
	 */
	public String queryMenuListJson(SysMenu sysMenu, HttpServletRequest request, HttpServletResponse response, final Invocation inv) {
		JSONArray arr = sysMenuBiz.menuListJson(sysMenu);
		return "@" + encodeJson(arr);
	}

}
