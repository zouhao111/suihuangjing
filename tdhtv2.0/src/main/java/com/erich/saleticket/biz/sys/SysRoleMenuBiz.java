package com.erich.saleticket.biz.sys;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erich.saleticket.dao.sys.SysRoleMenuDAO;
import com.erich.saleticket.model.sys.SysRoleMenu;

@Service
public class SysRoleMenuBiz {
	@Resource
	private SysRoleMenuDAO SysRoleMenuDAO;

	public List<SysRoleMenu> selectByCriteria(SysRoleMenu sysRoleMenu) {
		return SysRoleMenuDAO.selectByCriteria(sysRoleMenu, sysRoleMenu.getPager());
	}

	public int insert(SysRoleMenu sysRoleMenu) {
		return SysRoleMenuDAO.insert(sysRoleMenu);
	}

	public SysRoleMenu selectByPrimaryKey(int id) {
		return SysRoleMenuDAO.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKey(SysRoleMenu sysRoleMenu) {
		return SysRoleMenuDAO.updateByPrimaryKey(sysRoleMenu);
	}

	public int deleteBatch(int[] ids) {
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			result = SysRoleMenuDAO.deleteBatch(ids[i]);
		}
		return result;
	}

	public void setRoleMenu(int roleid, int[] id) {
		SysRoleMenuDAO.deleteByRoleId(roleid);//删除该角色下所有菜单
		if (id != null) {
			for (int i = 0; i < id.length; i++) {
				SysRoleMenu sysRoleMenu = new SysRoleMenu();
				sysRoleMenu.setCreateDate(new Date());
				sysRoleMenu.setMenuId(id[i]);
				sysRoleMenu.setRoleId(roleid);
				SysRoleMenuDAO.insert(sysRoleMenu);
			}
		}

	}

}
