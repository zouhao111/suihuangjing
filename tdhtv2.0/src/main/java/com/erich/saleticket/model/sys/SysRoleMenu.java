package com.erich.saleticket.model.sys;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 角色菜单
 * @author Lv
 *
 */
public class SysRoleMenu extends BaseModel {

	private static final long serialVersionUID = 1L;

	private Integer roleMenuId;

	private Integer roleId;

	private Integer menuId;

	private Date createDate;

	private Integer createUserId;

	private String createUserName;

	public Integer getRoleMenuId() {
		return roleMenuId;
	}

	public void setRoleMenuId(Integer roleMenuId) {
		this.roleMenuId = roleMenuId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
}