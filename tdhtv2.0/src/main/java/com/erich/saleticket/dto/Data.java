package com.erich.saleticket.dto;

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
	

	
	
	/*private List<Object> waterquality;//水质监测
	private List<Object> ztraffic;//水平衡分析
	private List<Object> ztraffic2;//流量汇总系数
	private List<Object> companyconfig;//公司信息
	private List<Object> url;//URL
	private List<Object> sam1;//手动采样
	private List<Object> sam2;//自动采样
	private List<Object> sam3;//报警采样
	private List<Object> sam4;//远程采样
	private List<Object> pollutants;//污染物汇总信息
	private List<Object> pollutantss;//WTW基本信息
	private List<Object> data;//实时监测数据

	private List<List<Object>> lists;
	*/
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
