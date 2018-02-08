package com.erich.saleticket.dto;

/**
 * 返回结果 DTO
 * 
 * @author ZhengJinLing
 * @since 1.0
 */
public class Result implements java.io.Serializable {

	private static final long serialVersionUID = 6298976385983467084L;
	public Integer resultcode;// 结果编码:  参考  Resultcode 
	public String reason;// 操作消息

	public Result() {
	}

	/**
	 * 根据枚举 构造 Result
	 * 
	 * @param rc
	 *            枚举 Resultcode
	 */
	public Result(Resultcode rc) {
		this.resultcode = rc.getCode();
		this.reason = rc.getDesc();
	}

	public Result(Resultcode rc, String reason) {
		this.resultcode = rc.getCode();
		if (reason == null) {
			this.reason = rc.getDesc();
		} else {
			this.reason = reason;
		}
	}

	public Result init(Resultcode rc) {
		this.resultcode = rc.getCode();
		this.reason = rc.getDesc();
		return this;
	}

	public Result init(Resultcode rc, String reason) {
		this.resultcode = rc.getCode();
		if (reason == null) {
			this.reason = rc.getDesc();
		} else {
			this.reason = reason;
		}
		return this;
	}

	public Integer getResultcode() {
		return resultcode;
	}

	public void setResultcode(Integer resultcode) {
		this.resultcode = resultcode;
	}

}