package com.fh.entity.system;

import java.util.Date;
import java.util.List;


/**
 * 带数据的返回结果
 * @author Administrator
 *
 * @param <T>
 */
public class Data<T> extends PlaceResult {
	
	
	
private static final long serialVersionUID = 2055801862853973721L;
	
	private Date date;
	
	public Date getDate() {
		if(date == null){
			date = new Date();
		}
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 返回的结果
	 */
	private T result;

	private List<Object> list;
	

	
	
	
	public List<Object> getList() {
		return list;
	}
	public void setList(List<Object> list) {
		this.list = list;
	}
	public Data() {
		super(ApiResultcode._0);
	}

	public Data(ApiResultcode rc) {
		super(rc);
	}
	
	public Data(ApiResultcode rc, String reason) {
		super(rc,reason);
	}

	public T getResult() {
		return result;
	} 
	public void setResult(T result) {
		this.result = result;
	}
	
	
	

}
