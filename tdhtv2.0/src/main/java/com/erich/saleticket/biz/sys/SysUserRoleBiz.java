package com.erich.saleticket.biz.sys;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erich.saleticket.dao.sys.SysUserRoleDAO;
import com.erich.saleticket.model.sys.SysUserRole;

@Service
public class SysUserRoleBiz {
	@Resource
	private SysUserRoleDAO sysUserRoleDAO;

	public List<SysUserRole> selectByCriteria(SysUserRole sysUserRole) {
		return sysUserRoleDAO.selectByCriteria(sysUserRole, sysUserRole.getPager());
	}

	public int insert(SysUserRole sysUserRole) {
		return sysUserRoleDAO.insert(sysUserRole);
	}

	public SysUserRole selectByPrimaryKey(int id) {
		return sysUserRoleDAO.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKey(SysUserRole sysUserRole) {
		return sysUserRoleDAO.updateByPrimaryKey(sysUserRole);
	}

	public int deleteBatch(int[] ids) {
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			result = sysUserRoleDAO.deleteBatch(ids[i]);
		}
		return result;
	}

	public void setUserRole(int userId, int[] ids) {
		SysUserRole sysUserRole = new SysUserRole();
		sysUserRole.setUserId(userId);
		sysUserRoleDAO.deleteByCriteria(sysUserRole);//删除该用户下所有角色
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				sysUserRole = new SysUserRole();
				sysUserRole.setCreateDate(new Date());
				sysUserRole.setRoleId(ids[i]);
				sysUserRole.setUserId(userId);
				sysUserRoleDAO.insert(sysUserRole);
			}
		}

	}

}
