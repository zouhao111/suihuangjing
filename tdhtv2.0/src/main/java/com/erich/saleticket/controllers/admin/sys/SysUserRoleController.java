package com.erich.saleticket.controllers.admin.sys;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.paoding.rose.web.Invocation;
import org.codehaus.jackson.type.TypeReference;
import com.alibaba.fastjson.JSONArray;
import com.erich.easyframe.util.JsonUtil;
import com.erich.saleticket.biz.sys.SysUserRoleBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.model.sys.SysUserRole;

/**
 * 系统用户角色控制器
 * @author Lv
 *
 */
public class SysUserRoleController extends BaseController {

	@Resource
	private SysUserRoleBiz sysUserRoleBiz;

	/**
	 * 用户角色设置
	 */
	public void setUserRole(final Invocation inv, HttpServletRequest request, HttpServletResponse response) {
		try {
			String ids = inv.getParameter("ids");
			String userId = inv.getParameter("userId");
			int[] id = null;
			if (ids != null) {
				id = JsonUtil.fromJson(ids, new TypeReference<int[]>() {
				});
			}
			sysUserRoleBiz.setUserRole(Integer.parseInt(userId), id);
			writerJson(response, successMsg("保存成功"));
		} catch (Exception e) {
			writerJson(response, errorMsg("保存失败"));
		}
	}

	/**
	 * 查询该用户下的所有角色 转json
	 * @param inv
	 * @param request
	 * @param response
	 * @return
	 */
	public String queryUserRoleByUserIdToJson(final Invocation inv, SysUserRole sysUserRole, HttpServletRequest request, HttpServletResponse response) {
		JSONArray arr = new JSONArray();
		sysUserRole.getPager().setOrderField("user_role_id");
		sysUserRole.getPager().setOrderDirection(false);
		List<SysUserRole> sysUserRoles = sysUserRoleBiz.selectByCriteria(sysUserRole);
		for (int i = 0; i < sysUserRoles.size(); i++) {
			arr.add(sysUserRoles.get(i).getRoleId());
		}
		return "@" + encodeJson(arr);
	}

}
