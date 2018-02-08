package com.erich.saleticket.biz.sys;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.erich.saleticket.dao.sys.SysRoleMenuDAO;
import com.erich.saleticket.dao.sys.SysRolesDAO;
import com.erich.saleticket.dao.sys.SysUserRoleDAO;
import com.erich.saleticket.model.sys.SysRoles;
import com.erich.saleticket.model.sys.SysUserRole;

@Service
public class SysRolesBiz {

	@Resource
	private SysRolesDAO sysRolesDAO;
	@Resource
	private SysRoleMenuDAO sysRoleMenuDAO;
	@Resource
	private SysUserRoleDAO sysUserRoleDAO;

	public List<SysRoles> selectByCriteria(SysRoles sysRoles) {
		List<SysRoles> list = sysRolesDAO.selectByCriteria(sysRoles, sysRoles.getPager());
		return list;
	}

	public int insert(SysRoles sysRoles) {
		if (sysRoles.getEnabled() == null) {
			sysRoles.setEnabled(0);
		}
		return sysRolesDAO.insert(sysRoles);
	}

	public int deleteBatch(int[] ids) {
		int result = 0;
		for (int roleid : ids) {
			sysRoleMenuDAO.deleteByRoleId(roleid);//删除该角色下所有菜单
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setRoleId(roleid);
			sysUserRoleDAO.deleteByCriteria(sysUserRole);//删除拥有该角色的用户角色关系
			result = sysRolesDAO.deleteBatch(roleid);
		}
		return result;
	}

	public int updateByPrimaryKey(SysRoles sysRoles) {
		if (sysRoles.getEnabled() == null) {
			sysRoles.setEnabled(0);
		}
		return sysRolesDAO.updateByPrimaryKey(sysRoles);
	}

	public SysRoles selectByPrimaryKey(int id) {
		return sysRolesDAO.selectByPrimaryKey(id);
	}

	public JSONArray roleListJson(SysRoles sysRoles) {
		sysRoles.getPager().setOrderField("t.role_id");
		sysRoles.getPager().setOrderDirection(false);
		List<SysRoles> roles = sysRolesDAO.selectByCriteria(sysRoles, sysRoles.getPager());
		JSONArray arr = new JSONArray();
		for (SysRoles role : roles) {
			JSONObject obj = new JSONObject();
			obj.put("id", role.getRoleId());
			obj.put("pId", 0);
			obj.put("name", role.getFullName());
			obj.put("open", true);
			arr.add(obj);
		}
		return arr;
	}

	public int countByCriteria(SysRoles sysRoles) {
		return sysRolesDAO.countByCriteria(sysRoles);
	}

	/**
	 * 根据用户名查询用户角色
	 * @param userName
	 * @return
	 */
	public List<SysRoles> getSysRolesList(String userName){
		return sysRolesDAO.getSysRolesList(userName);
	}
	
}
