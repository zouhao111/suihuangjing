package com.erich.saleticket.model.sys;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 用户角色
 * @author Lv
 *
 */
public class SysUserRole extends BaseModel {

	private static final long serialVersionUID = 1L;

	private Integer userRoleId;

	private Integer userId;

	private Integer roleId;

	private Date createDate;

	private Integer createUserId;

	private String createUserName;

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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