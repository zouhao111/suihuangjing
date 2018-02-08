package com.erich.saleticket.model.sys;

import java.util.Date;
import java.util.List;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 用户
 */
public class SysUser extends BaseModel {

	private static final long serialVersionUID = 1L;

	private Integer userId;

	private String code;

	private String account;	 //账号

	private String password;  //密码
	
	private String secretKey;

	private String realName;

	private String spell;

	private String alias;

	private Integer roleId;

	private String gender;

	private String mobile;

	private String telephone;

	private Date birthday;

	private String email;

	private String oicq;

	private Integer dutyId;

	private Integer titleId;

	private Integer companyId;

	private Integer departmentId;

	private Integer workgroupId;

	private String description;

	private String securityLevel;

	private Date changePasswordDate;

	private Integer openId;

	private String ipAddress;

	private String macAddress;

	private Integer logOnCount;

	private Date firstVisit;

	private Date previousVisit;

	private Date lastVisit;

	private Integer enabled;

	private Integer sortCode;

	private Integer deleteMark;

	private Date createDate;

	private Integer createUserId;

	private String createUserName;

	private Date modifyDate;

	private Integer modifyUserId;

	private String modifyUserName;

	private List<SysMenu> menuList;

	private List<SysRoles> sysRolesList;

	public List<SysRoles> getSysRolesList() {
		return sysRolesList;
	}

	public void setSysRolesList(List<SysRoles> sysRolesList) {
		this.sysRolesList = sysRolesList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey == null ? null : secretKey.trim();
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName == null ? null : realName.trim();
	}

	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell == null ? null : spell.trim();
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias == null ? null : alias.trim();
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender == null ? null : gender.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getOicq() {
		return oicq;
	}

	public void setOicq(String oicq) {
		this.oicq = oicq == null ? null : oicq.trim();
	}

	public Integer getDutyId() {
		return dutyId;
	}

	public void setDutyId(Integer dutyId) {
		this.dutyId = dutyId;
	}

	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Integer getWorkgroupId() {
		return workgroupId;
	}

	public void setWorkgroupId(Integer workgroupId) {
		this.workgroupId = workgroupId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public String getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel == null ? null : securityLevel.trim();
	}

	public Date getChangePasswordDate() {
		return changePasswordDate;
	}

	public void setChangePasswordDate(Date changePasswordDate) {
		this.changePasswordDate = changePasswordDate;
	}

	public Integer getOpenId() {
		return openId;
	}

	public void setOpenId(Integer openId) {
		this.openId = openId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress == null ? null : ipAddress.trim();
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress == null ? null : macAddress.trim();
	}

	public Integer getLogOnCount() {
		return logOnCount;
	}

	public void setLogOnCount(Integer logOnCount) {
		this.logOnCount = logOnCount;
	}

	public Date getFirstVisit() {
		return firstVisit;
	}

	public void setFirstVisit(Date firstVisit) {
		this.firstVisit = firstVisit;
	}

	public Date getPreviousVisit() {
		return previousVisit;
	}

	public void setPreviousVisit(Date previousVisit) {
		this.previousVisit = previousVisit;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Integer getSortCode() {
		return sortCode;
	}

	public void setSortCode(Integer sortCode) {
		this.sortCode = sortCode;
	}

	public Integer getDeleteMark() {
		return deleteMark;
	}

	public void setDeleteMark(Integer deleteMark) {
		this.deleteMark = deleteMark;
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
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Integer getModifyUserId() {
		return modifyUserId;
	}

	public void setModifyUserId(Integer modifyUserId) {
		this.modifyUserId = modifyUserId;
	}

	public String getModifyUserName() {
		return modifyUserName;
	}

	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName == null ? null : modifyUserName.trim();
	}

	public List<SysMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}

}