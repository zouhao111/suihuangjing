package com.erich.saleticket.controllers.admin.tdht;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test {
	 public static void main(String[] args) {
	        // 启动定时器线程，并在10000毫秒后开始，每隔3000毫秒执行一次定时任务
	        new Timer().schedule(new TimerTask() {// 定时任务

	            @Override
	            public void run() {
	                System.out.println("bombing!");

	            }
	        }, 10000, 3000);

	        while(true) {
	            System.out.println("时钟时间：" + new Date().getSeconds());
	            try {
	                Thread.sleep(1000);// 主线程每隔1秒钟，打印当前时钟时间
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

}
