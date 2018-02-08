package com.erich.saleticket.model.tdht;

import java.util.Date;

import com.erich.easyframe.common.base.BaseModel;

/**
 *操作日志
 */
public class ViewLog extends BaseModel {


	private Long operationRid;		//Rid
	
	private String userIp;        			//IP

	private Integer operationtype;				//操作类型

	private Integer operationvalue;				//操作值

	private String userName;			//账号
	
	private Date updataTime;				//操作时间
	
	private String  describe; 	 //描述
	
	private String strTime;				//操作时间
	
	private String str;				//操作时间
	
	
	public String getStrTime() {
		return strTime;
	}

	public void setStrTime(String strTime) {
		this.strTime = strTime;
	}

	public Long getOperationRid() {
		return operationRid;
	}

	public void setOperationRid(Long operationRid) {
		this.operationRid = operationRid;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public Integer getOperationtype() {
		return operationtype;
	}

	public void setOperationtype(Integer operationtype) {
		this.operationtype = operationtype;
	}

	public Integer getOperationvalue() {
		return operationvalue;
	}

	public void setOperationvalue(Integer operationvalue) {
		this.operationvalue = operationvalue;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUpdataTime() {
		return updataTime;
	}

	public void setUpdataTime(Date updataTime) {
		this.updataTime = updataTime;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	

}