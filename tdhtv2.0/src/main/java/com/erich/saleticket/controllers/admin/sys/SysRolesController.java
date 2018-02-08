package com.erich.saleticket.controllers.admin.sys;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.Invocation;

import org.codehaus.jackson.type.TypeReference;

import com.alibaba.fastjson.JSONArray;
import com.erich.easyframe.util.JsonUtil;
import com.erich.easyframe.util.SystemContext;
import com.erich.saleticket.biz.sys.SysRolesBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.model.sys.SysRoles;

/**
 * 系统角色控制器
 * @author lv
 *
 */
public class SysRolesController extends BaseController {
	@Resource
	private SysRolesBiz sysRolesBiz;

	/**
	 * 角色管理
	 * @param request
	 * @param response
	 * @return
	 */
	public String rolesList(SysRoles sysRoles, HttpServletRequest request, HttpServletResponse response) {
		int offset = SystemContext.getOffset();
		int pagesize = SystemContext.getPagesize();
		sysRoles.getPager().setPageOffset(offset);
		sysRoles.getPager().setPageSize(pagesize);
		sysRoles.getPager().setOrderField("role_id");
		sysRoles.getPager().setOrderDirection(false);
		sysRoles.getPager().setRowCount(sysRolesBiz.countByCriteria(sysRoles));
		request.setAttribute("pager", sysRoles.getPager());
		List<SysRoles> sysRoless = sysRolesBiz.selectByCriteria(sysRoles);
		request.setAttribute("sysRoless", sysRoless);
		return "role/roleList";
	}

	/**
	 * 进入添加界面
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) {
		return "role/add";
	}

	/**
	 * 进入修改界面
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(final Invocation inv, SysRoles sysRoles, HttpServletRequest request, HttpServletResponse response) {
		sysRoles = sysRolesBiz.selectByPrimaryKey(sysRoles.getRoleId());
		inv.addModel("sysRoles", sysRoles);
		return "role/edit";
	}

	/**
	 * 添加保存
	 * @param request
	 * @param response
	 * @return
	 */
	public void addSave(SysRoles sysRoles, HttpServletRequest request, HttpServletResponse response) {
		sysRoles.setCreateDate(new Date());
		sysRoles.setCreateUserId(getUser(request).getUserId());
		sysRoles.setCreateUserName(getUser(request).getRealName());
		int result = sysRolesBiz.insert(sysRoles);
		
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
	public void editSave(SysRoles sysRoles, HttpServletRequest request, HttpServletResponse response) {
		sysRoles.setModifyDate(new Date());
		sysRoles.setModifyUserId(getUser(request).getUserId());
		sysRoles.setModifyUserName(getUser(request).getRealName());
		int result = sysRolesBiz.updateByPrimaryKey(sysRoles);
		if (result > 0) {
			writerJson(response, successMsg("修改成功"));
		} else {
			writerJson(response, errorMsg("修改失败"));
		}
	}

	/**
	 * 删除
	 * @param ids
	 * @param request
	 * @param response
	 */
	public void del(HttpServletRequest request, HttpServletResponse response, final Invocation inv) {
		String ids = inv.getParameter("ids");
		//将json字符串转成int []
		if (ids != null) {
			int[] id = JsonUtil.fromJson(ids, new TypeReference<int[]>() {
			});
			sysRolesBiz.deleteBatch(id);
			writerJson(response, successMsg("删除成功"));
		}
	}

	/**
	 * 用户列表 设置角色 角色列表json
	 * @param sysRoles
	 * @param request
	 * @param response
	 * @param inv
	 * @return
	 */
	public String queryRoleListJson(SysRoles sysRoles, HttpServletRequest request, HttpServletResponse response, final Invocation inv) {
		JSONArray arr = sysRolesBiz.roleListJson(sysRoles);
		return "@" + encodeJson(arr);
	}

}
