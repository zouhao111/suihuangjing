package com.erich.saleticket.controllers.admin.tdht;
import java.text.SimpleDateFormat;
import java.util.Date;
public class T {
public  void main(String[] args) throws Exception {
	
	
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
long timeStart=sdf.parse("2016-06-22").getTime();
System.out.println(timeStart);

Date date = new Date(timeStart);
System.out.println(sdf.format(date));
}
}