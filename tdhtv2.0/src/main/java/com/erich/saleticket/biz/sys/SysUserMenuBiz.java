package com.erich.saleticket.biz.sys;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.erich.saleticket.dao.sys.SysUserMenuDAO;
import com.erich.saleticket.model.sys.SysUserMenu;

@Service
public class SysUserMenuBiz {
	@Resource
	private SysUserMenuDAO sysUserMenuDAO;

	public List<SysUserMenu> selectByCriteria(SysUserMenu sysUserMenu) {
		return sysUserMenuDAO.selectByCriteria(sysUserMenu, sysUserMenu.getPager());
	}

	public int insert(SysUserMenu sysUserMenu) {
		return sysUserMenuDAO.insert(sysUserMenu);
	}

	public SysUserMenu selectByPrimaryKey(int id) {
		return sysUserMenuDAO.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKey(SysUserMenu sysUserMenu) {
		return sysUserMenuDAO.updateByPrimaryKey(sysUserMenu);
	}

	public int deleteBatch(int[] ids) {
		int result = 0;
		for (int i = 0; i < ids.length; i++) {
			result = sysUserMenuDAO.deleteBatch(ids[i]);
		}
		return result;
	}

	public void setUserMenu(SysUserMenu sysUserMenu, int[] ids) {
		sysUserMenuDAO.deleteByCriteria(sysUserMenu);//删除该用户下所有菜单
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				SysUserMenu entity = new SysUserMenu();
				entity.setCreateDate(new Date());
				entity.setMenuId(ids[i]);
				entity.setUserId(sysUserMenu.getUserId());
				sysUserMenuDAO.insert(entity);
			}
		}
	}

}
