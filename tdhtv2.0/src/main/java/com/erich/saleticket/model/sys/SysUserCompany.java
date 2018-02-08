package com.erich.saleticket.model.sys;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 用户公司
 */
public class SysUserCompany extends BaseModel {


	private Integer id;//id

	private Integer userId;//用户ID
	
	private Long rid;//公司ID

	private String companyName;//公司名称

	private Integer companyId;//公司编号
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	
}