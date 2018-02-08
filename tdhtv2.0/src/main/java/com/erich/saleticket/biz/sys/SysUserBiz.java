package com.erich.saleticket.biz.sys;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.erich.saleticket.dao.sys.SysUserDAO;
import com.erich.saleticket.dao.sys.SysUserMenuDAO;
import com.erich.saleticket.dao.sys.SysUserRoleDAO;
import com.erich.saleticket.model.sys.SysUser;
import com.erich.saleticket.model.sys.SysUserMenu;
import com.erich.saleticket.model.sys.SysUserRole;

@Service
public class SysUserBiz {

	@Resource
	private SysUserDAO sysUserDAO;
	@Resource
	private SysUserMenuDAO sysUserMenuDAO;
	@Resource
	private SysUserRoleDAO sysUserRoleDAO;

	public SysUser login(SysUser sysUser) {
		List<SysUser> list = sysUserDAO.getSysUser(sysUser, sysUser.getPager());
		if (null != list && list.size() > 0) {
			sysUser = list.get(0);
		} else {
			sysUser = null;
		}
		return sysUser;
	}

	public List<SysUser> selectByCriteria(SysUser sysUser) {
		List<SysUser> list = sysUserDAO.selectByCriteria(sysUser, sysUser.getPager());
		return list;
	}

	public int insert(SysUser sysUser) {
		if (sysUser.getEnabled() == null) {
			sysUser.setEnabled(0);
		}
		return sysUserDAO.insert(sysUser);
	}

	public int deleteBatch(int[] ids) {
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			SysUserMenu sysUserMenu = new SysUserMenu();
			sysUserMenu.setUserId(ids[i]);
			//sysUserMenuDAO.deleteByCriteria(sysUserMenu);//删除该用户下所有菜单
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setUserId(ids[i]);
			//sysUserRoleDAO.deleteByCriteria(sysUserRole);//删除该用户下所有角色
			result = sysUserDAO.deleteBatch(ids[i]);
		}

		return result;
	}

	public int updateByPrimaryKey(SysUser sysUser) {
		return sysUserDAO.updateByPrimaryKey(sysUser);
	}
	
	public int updateByPrimaryKey1(SysUser sysUser) {
		return sysUserDAO.updateByPrimaryKey1(sysUser);
	}

	public SysUser selectByPrimaryKey(int id) {
		return sysUserDAO.selectByPrimaryKey(id);
	}

	public int countByCriteria(SysUser sysUser) {
		return sysUserDAO.countByCriteria(sysUser);
	}

	public JSONArray userListJson() {
		SysUser sysUser = new SysUser();
		sysUser.getPager().setOrderField("user_id");
		sysUser.getPager().setOrderDirection(false);
		sysUser.getPager().setPageSize(0);
		sysUser.getPager().setPageOffset(0);
		List<SysUser> sysUsers = sysUserDAO.selectByCriteria(sysUser, sysUser.getPager());

		JSONArray arr = new JSONArray();
		for (SysUser user : sysUsers) {
			JSONObject obj = new JSONObject();
			int id = user.getUserId();
			String name = user.getRealName();
			obj.put("id", id);
			obj.put("name", name);
			arr.add(obj);
		}
		return arr;
	}

}
