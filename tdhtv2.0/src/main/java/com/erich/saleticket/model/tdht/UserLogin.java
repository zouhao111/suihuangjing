package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 * 实时报警
 */
public class UserLogin extends BaseModel {


	private Integer id;
	
	private Integer userId;        		//用户ID

	private String account;	 //账号
	
	private String ip;

	private Date create_date;

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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	
	


}