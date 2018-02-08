package com.erich.saleticket.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Texts {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt=new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
      /*  rightNow.add(Calendar.YEAR,-1);//日期减1年
        rightNow.add(Calendar.MONTH,3);//日期加3个月
*/        rightNow.add(Calendar.DAY_OF_YEAR,10);//日期加10天
        Date dt1=rightNow.getTime();
        String reStr = sdf.format(dt1);
        System.out.println(reStr);
		
		
	}

}
