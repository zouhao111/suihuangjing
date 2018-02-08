package com.erich.saleticket.dto;

/**
 * 返回结果码 定义
 * 
 * @author ZhengJinLing
 * 
 */
public enum Resultcode {
	FAIL_PASS(0,"旧密码输入错误，请重新输入"), 
	FAIL(0,"操作失败"),
	SUCCESS(1,"操作成功"), 
	
	FILETOOLARGE(201,"上传文件超过大小"),
	INVALIDPARAM(202,"参数错误"),
	NODATA(203,"查询不到结果");
	
	// 成员变量
	private String desc;
	private Integer code;

	// 构造方法
	private Resultcode( int code,String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	 
}