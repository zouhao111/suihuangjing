package com.erich.saleticket.controllers.admin.sys;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.paoding.rose.web.Invocation;

import org.codehaus.jackson.type.TypeReference;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.erich.easyframe.util.JsonUtil;
import com.erich.easyframe.util.SystemContext;
import com.erich.saleticket.biz.sys.SysUserBiz;
import com.erich.saleticket.controllers.BaseController;
import com.erich.saleticket.model.sys.SysUser;

/**
 * 系统用户控制器
 * @author Lv
 *
 */
public class SysUserController extends BaseController {

	@Resource
	private SysUserBiz sysUserBiz;

	/**
	 * 用户管理
	 * @param sysUser
	 * @param request
	 * @param response
	 * @return
	 */
	public String userList(SysUser sysUser, HttpServletRequest request, HttpServletResponse response) {

		
		String cxName = sysUser.getRealName();
		String cxAccount = sysUser.getAccount();
		/*if (sysUser.getEnabled() == null) {
			sysUser.setEnabled(0);
		}*/
		Integer cxZt = sysUser.getEnabled();

		request.setAttribute("cxName", cxName);
		request.setAttribute("cxAccount", cxAccount);
		request.setAttribute("cxZt", cxZt);

		int offset = SystemContext.getOffset();
		int pagesize = SystemContext.getPagesize();
		sysUser.getPager().setPageOffset(offset);
		sysUser.getPager().setPageSize(pagesize);
		sysUser.getPager().setOrderField("user_id");
		sysUser.getPager().setOrderDirection(false);
		sysUser.getPager().setRowCount(sysUserBiz.countByCriteria(sysUser));
		request.setAttribute("pager", sysUser.getPager());
		List<SysUser> sysUsers = sysUserBiz.selectByCriteria(sysUser);
		request.setAttribute("sysUsers", sysUsers);
		return "user/userList";
	}

	/**
	 * 进入添加界面
	 * @param request
	 * @param response
	 * @return
	 */
	public String add(HttpServletRequest request, HttpServletResponse response) {
		return "user/add";
	}

	/**
	 * 添加用户
	 * @param sysUser
	 * @param request
	 * @param response
	 * @return
	 */
	public void addSave(SysUser sysUser, HttpServletRequest request, HttpServletResponse response) {
		sysUser.setLogOnCount(0);//登录次数默认为0
		sysUser.setCreateDate(new Date());
		sysUser.setCreateUserId(getUser(request).getUserId());
		sysUser.setCreateUserName(getUser(request).getRealName());
		if(sysUser.getEnabled() == null){
			sysUser.setEnabled(0);
		}
		int result = sysUserBiz.insert(sysUser);
		if (result > 0) {
			writerJson(response, successMsg("添加成功"));
		} else {
			writerJson(response, errorMsg("添加失败"));
		}
	}

	/**
	 * 进入修改界面
	 * @param request
	 * @param response 
	 * @return
	 */
	public String edit(final Invocation inv, SysUser sysUser, HttpServletRequest request, HttpServletResponse response) {
		sysUser = sysUserBiz.selectByPrimaryKey(sysUser.getUserId());
		inv.addModel("sysUser", sysUser);
		return "user/edit";
	}

	/**
	 * 编辑保存 
	 * @param request
	 * @param response
	 * @return 
	 */
	public void editSave(SysUser sysUser, HttpServletRequest request, HttpServletResponse response) {
		sysUser.setModifyDate(new Date());
		sysUser.setModifyUserId(getUser(request).getUserId());
		sysUser.setModifyUserName(getUser(request).getRealName());
		sysUser.setLogOnCount(getUser(request).getLogOnCount());
		sysUser.setRoleId(getUser(request).getRoleId());
		if (sysUser.getEnabled() == null) {
			sysUser.setEnabled(0);
		}
		int result = sysUserBiz.updateByPrimaryKey(sysUser);
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
			sysUserBiz.deleteBatch(id);
			writerJson(response, successMsg("删除成功"));
		}
	}

	
	
	/**
	 * 用户列表 json 
	 * @return
	 */
	public String userListJson() {
		JSONArray json = sysUserBiz.userListJson();
	
		return "@" + encodeJson(json);
	}

}
