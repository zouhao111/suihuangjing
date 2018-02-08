package com.erich.saleticket.model.sys;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 用户菜单
 * @author Lv
 *
 */
public class SysUserMenu extends BaseModel {

	private static final long serialVersionUID = 1L;

	private Integer userMenuId;

	private Integer userId;

	private Integer menuId;

	private Date createDate;

	private Integer createUserId;

	private String createUserName;

	public Integer getUserMenuId() {
		return userMenuId;
	}

	public void setUserMenuId(Integer userMenuId) {
		this.userMenuId = userMenuId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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