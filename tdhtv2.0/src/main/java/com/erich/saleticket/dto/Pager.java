package com.erich.saleticket.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "pageId", "pageSize", "rowCount", "pageCount", "pageOffset", "pageTail", "orderField",
		"orderDirection", "firstIndex", "length", "startIndex", "endIndex", "indexs" })
public class Pager implements Serializable {

	private static final long serialVersionUID = 1L;
	private int pageId = 1; // 当前页
	private int rowCount = 0; // 总行数
	private int pageSize = 10; // 页大小
	private int pageCount = 0; // 总页数
	private int pageOffset = 0;// 当前页起始记录
	private int pageTail = 0;// 当前页到达的记录
	private String orderField = "RecID";
	private boolean orderDirection;

	private int firstIndex;

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	/**
	 * 开始页
	 *
	 * @return
	 */
	public int getFirstIndex() {
		return (pageId - 1) * pageSize;
	}

	// 页面显示分页按钮个数
	private int length = 6;
	// 开始分页数字
	private int startIndex = 0;
	// 结束分页数字
	private int endIndex = 0;

	private int[] indexs;

	// int pid = navigate.getPageId() ; //当前页
	// int pcount = navigate.getPageCount(); //总页数
	// int length=8; //共显示几个分页数字
	// int startIndex = pid - (length/2);
	// int endIndex = 0;
	// if( startIndex < 1){
	// startIndex = 1;
	// }
	// endIndex = (startIndex+length) <= pcount ? (startIndex+length) : pcount;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int[] getIndexs() {
		int len = getEndIndex() - getStartIndex() + 1;
		indexs = new int[len];
		for (int i = 0; i < len; i++) {
			indexs[i] = (getStartIndex() + i);
		}
		return indexs;
	}

	public void setIndexs(int[] indexs) {
		this.indexs = indexs;
	}

	public int getStartIndex() {
		startIndex = pageId - (length / 2);
		if (startIndex < 1) {
			startIndex = 1;
		}
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		if (getStartIndex() < 1) {
			setStartIndex(1);          
		}
		endIndex = (getStartIndex() + length) <= getPageCount() ? (getStartIndex() + length) : getPageCount();
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public Pager() {
		this.orderDirection = true;
	}

	protected void doPage() {
		this.pageCount = this.rowCount / this.pageSize + 1;
		if ((this.rowCount % this.pageSize == 0) && pageCount > 1)
			this.pageCount--;
		
			/*// Mysql 算法
				this.pageOffset = (this.pageId - 1) * this.pageSize;
			this.pageTail = this.pageOffset + this.pageSize;
				if ((this.pageOffset + this.pageSize) > this.rowCount)
					this.pageTail = this.rowCount;
				if(this.pageId > this.pageCount)
					this.pageId = this.pageCount;
				if(this.pageId < 1)
					this.pageId = 1;*/
	}

	public void setOrderDirection(boolean orderDirection) {
		this.orderDirection = orderDirection;
	}

	public boolean isOrderDirection() {
		return orderDirection;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderField() {
		return orderField;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public int getPageId() {
		return pageId;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageTail(int pageTail) {
		this.pageTail = pageTail;
	}

	public int getPageTail() {
		return pageTail;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		this.doPage();
	}

	public int getRowCount() {
		return rowCount;
	}

}