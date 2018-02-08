package com.erich.saleticket.model.tdht;

import java.util.Date;
import com.erich.easyframe.common.base.BaseModel;

/**
 *统计 报表
 */
public class ReportForm extends BaseModel {

	  	private Date time;
	    private Double a1;//排水
	    private Double a2;//工业给水
	    private Double a3 ;//生活给水
		private Double minph;
		private Double maxph;
		private Double unknown;//不明用水量
		
		private String startingTime;//开始时间
		private String endTime;//结束时间
		
		
		public Date getTime() {
			return time;
		}
		public void setTime(Date time) {
			this.time = time;
		}
		public Double getA1() {
			return a1;
		}
		public void setA1(Double a1) {
			this.a1 = a1;
		}
		public Double getA2() {
			return a2;
		}
		public void setA2(Double a2) {
			this.a2 = a2;
		}
		public Double getA3() {
			return a3;
		}
		public void setA3(Double a3) {
			this.a3 = a3;
		}
		public Double getMinph() {
			return minph;
		}
		public void setMinph(Double minph) {
			this.minph = minph;
		}
		public Double getMaxph() {
			return maxph;
		}
		public void setMaxph(Double maxph) {
			this.maxph = maxph;
		}
		public Double getUnknown() {
			return unknown;
		}
		public void setUnknown(Double unknown) {
			this.unknown = unknown;
		}
		public String getStartingTime() {
			return startingTime;
		}
		public void setStartingTime(String startingTime) {
			this.startingTime = startingTime;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
	
	
}