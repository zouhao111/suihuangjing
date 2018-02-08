package com.erich.saleticket.controllers.admin.sys;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.Invocation;

import org.codehaus.jackson.type.TypeReference;

import com.alibaba.fastjson.JSONArray;
import com.erich.easyframe.util.JsonUtil;
import com.erich.saleticket.biz.sys.SysUserMenuBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.model.sys.SysUserMenu;

/**
 * 系统用户菜单控制器
 * @author Lv
 *
 */
public class SysUserMenuController extends BaseController {

	@Resource
	private SysUserMenuBiz sysUserMenuBiz;

	/**
	 * 用户菜单设置
	 */
	public void setUserMenu(final Invocation inv, SysUserMenu sysUserMenu, HttpServletRequest request, HttpServletResponse response) {
		try {
			String ids = inv.getParameter("ids");
			int[] id = null;
			if (ids != null) {
				id = JsonUtil.fromJson(ids, new TypeReference<int[]>() {
				});
			}
			sysUserMenuBiz.setUserMenu(sysUserMenu, id);
			writerJson(response, successMsg("保存成功"));
		} catch (Exception e) {
			writerJson(response, errorMsg("保存失败"));
		}
	}

	/**
	 * 查询该用户下的所有菜单 转json
	 * @param inv
	 * @param request
	 * @param response
	 * @return
	 */
	public String queryUserMenuByUserIdToJson(final Invocation inv, SysUserMenu sysUserMenu, HttpServletRequest request, HttpServletResponse response) {
		JSONArray arr = new JSONArray();
		sysUserMenu.getPager().setOrderField("user_menu_id");
		sysUserMenu.getPager().setOrderDirection(false);
		List<SysUserMenu> sysUserMenus = sysUserMenuBiz.selectByCriteria(sysUserMenu);
		for (int i = 0; i < sysUserMenus.size(); i++) {
			arr.add(sysUserMenus.get(i).getMenuId());
		
		}
		return "@" + encodeJson(arr);
	}

}
