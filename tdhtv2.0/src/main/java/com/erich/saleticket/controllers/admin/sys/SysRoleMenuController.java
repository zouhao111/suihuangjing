package com.erich.saleticket.controllers.admin.sys;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.paoding.rose.web.Invocation;
import org.codehaus.jackson.type.TypeReference;
import com.alibaba.fastjson.JSONArray;
import com.erich.easyframe.util.JsonUtil;
import com.erich.saleticket.biz.sys.SysRoleMenuBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.model.sys.SysRoleMenu;

/**
 * 系统角色菜单控制器
 * @author lv
 *
 */
public class SysRoleMenuController extends BaseController {

	@Resource
	private SysRoleMenuBiz sysRoleMenuBiz;

	/**
	 * 角色权限设置
	 */
	public void setRoleMenu(final Invocation inv, HttpServletRequest request, HttpServletResponse response) {
		try {
			String ids = inv.getParameter("ids");
			String roleid = inv.getParameter("roleid");
			int[] id = null;
			if (ids != null) {
				id = JsonUtil.fromJson(ids, new TypeReference<int[]>() {
				});
			}
			sysRoleMenuBiz.setRoleMenu(Integer.parseInt(roleid), id);
			writerJson(response, successMsg("保存成功"));
		} catch (Exception e) {
			writerJson(response, errorMsg("保存失败"));
		}
	}

	/**
	 * 查询该角色下的所有菜单 转json
	 * @param inv
	 * @param request
	 * @param response
	 * @return
	 */
	public String queryRoleMenuByRoleIdToJson(final Invocation inv, SysRoleMenu sysRoleMenu, HttpServletRequest request, HttpServletResponse response) {
		JSONArray arr = new JSONArray();
		sysRoleMenu.getPager().setOrderField("role_menu_id");
		sysRoleMenu.getPager().setOrderDirection(false);
		
		List<SysRoleMenu> sysRoleMenus = sysRoleMenuBiz.selectByCriteria(sysRoleMenu);
		for (int i = 0; i < sysRoleMenus.size(); i++) {
			arr.add(sysRoleMenus.get(i).getMenuId());
		}
		return "@" + encodeJson(arr);
	}

}
