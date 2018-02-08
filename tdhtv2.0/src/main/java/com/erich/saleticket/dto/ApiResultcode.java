package com.erich.saleticket.dto;

/**
 * 返回结果码 定义
 * @author ZhengJinLing
 * 
 */
public enum ApiResultcode {

	/**
	 * 没登录
	 */
	_0("300", "操作失败"),
	_2("100", "登录超时"),
	 
	/**
	 * 路径错误
	 */
	_404("404", "路径错误"),
	 
	/**
	 *成功
	 */
	_1("200", "成功");
	
	// 成员变量
	private String code;
	private String desc;

	// 构造方法
	private ApiResultcode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}