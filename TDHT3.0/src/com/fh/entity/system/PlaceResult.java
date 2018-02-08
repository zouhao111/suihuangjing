package com.fh.entity.system;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * 同城网返回结果 父类
 * 
 * @author Administrator
 *
 */
public class PlaceResult implements Serializable, Cloneable {

	private static final long serialVersionUID = -6910819528427242829L;

	/**
	 * 执行结果
	 */
	private String resultcode;
	/**
	 * 执行结果说明
	 */
	private String rspDesc;
	/**
	 * 执行时间 日期格式:yyyy-MM-dd HH:mm:ss
	 */
	private Date rspTime;

	/**
	 * 根据枚举 构造 Result
	 * 
	 * @param rc
	 *            枚举 Resultcode
	 */
	public PlaceResult(ApiResultcode rc) {
		this.resultcode = rc.getCode();
		this.rspDesc = rc.getDesc();
		this.rspTime = Calendar.getInstance().getTime();
	}

	public PlaceResult(ApiResultcode rc, String reason) {
		this.resultcode = rc.getCode();
		if (reason == null) {
			this.rspDesc = rc.getDesc();
		} else {
			this.rspDesc = reason;
		}
		this.rspTime = Calendar.getInstance().getTime();
	}

	/**
	 * 
	 * @param rc
	 * @return
	 */
	public PlaceResult init(ApiResultcode rc) {
		this.resultcode = rc.getCode();
		this.rspDesc = rc.getDesc();
		return this;
	}

	public PlaceResult init(ApiResultcode rc, String reason) {
		this.resultcode = rc.getCode();
		if (reason == null) {
			this.rspDesc = rc.getDesc();
		} else {
			this.rspDesc = reason;
		}
		return this;
	}


	public String getResultcode() {
		return resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public String getRspDesc() {
		return rspDesc;
	}

	public void setRspDesc(String rspDesc) {
		this.rspDesc = rspDesc;
	}

	public Date getRspTime() {
		return rspTime;
	}

	public void setRspTime(Date rspTime) {
		this.rspTime = rspTime;
	}

}
