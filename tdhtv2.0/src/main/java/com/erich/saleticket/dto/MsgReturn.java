package com.erich.saleticket.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 返回消息
 * @author asus
 *
 */
public class MsgReturn {

	public MsgReturn() {
	}

	/**
	 * 是否更新成功的构造方法
	 * 
	 * @param success
	 *            是否成功
	 * @param msg
	 *            消息
	 */
	public MsgReturn(boolean success, Object msg) {
		this.success = success;
		this.msg = msg;
		this.o="";
	}

	/**
	 * 是否更新成功的构造方法
	 * 
	 * @param success
	 *            是否成功
	 * @param msg
	 *            消息
	 * @param other
	 *            其他对象
	 */
	public MsgReturn(boolean success, Object msg, Object other) {
		this.success = success;
		this.msg = msg;
		this.o = other;
	}

	/**
	 * 异常时的构造方法
	 * 
	 * @param msg
	 *            异常消息
	 */
	public MsgReturn(Object errormsg) {
		// 异常情况
		this.success = false;
		this.msg = errormsg;
		this.o = "";
	}

	/**
	 * 是否成功
	 */
	private boolean success;
	/**
	 * 返回消息
	 */
	private Object msg;
	/**
	 * 其他对象
	 */
	private Object o;

	/**
	 * @return 是否成功
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            是否成功
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return 返回消息
	 */
	public Object getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            返回消息
	 */
	public void setMsg(Object msg) {
		this.msg = msg;
	}

	/**
	 * @return 其他对象
	 */
	public Object getO() {
		return o;
	}

	/**
	 * @param o
	 *            其他对象
	 */
	public void setO(Object o) {
		this.o = o;
	}
	public String toString() {

		return JSON.toJSONString(this, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.PrettyFormat);
	}
}

