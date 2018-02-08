
function  URLstr(rid){
	//alert(rid)
	   var data1url="../admin/tdht/data/doGet?rid="+rid    //监测数据
	   $('#data1').attr('href',data1url); 

	    var data2url="../admin/tdht/data/doGet?rid="+rid    //实时数据
	   $('#data2').attr('href',data2url); 
	   $('#page-change').attr('href',data2url);
	   
	   
	   var data3url="../admin/sys/sysMenu/minMenu?parentId=209&rid="+rid    //日结 报表
	   $('#data3').attr('href',data3url); 
	   
	   var data4url="../admin/sys/sysMenu/minMenu?parentId=210&rid="+rid    //历史报表
	   $('#data4').attr('href',data4url); 
	   
	   var data5url="../admin/sys/sysMenu/minMenu?parentId=199&rid="+rid    //水平衡报表
	   $('#data5').attr('href',data5url); 
	   
	    var data55url="../admin/sys/sysMenu/minMenu?parentId=228&rid="+rid    //水平衡报表
	   $('#data55').attr('href',data55url); 
	   
	    
	    if(rid=='75501330025'){
	    	$('#data6').text("工业进水1")
	    }else{
	    	$('#data6').text("工业进水")
	    }
	   
	   var data6url="../admin/sys/sysMenu/minMenu?parentId=179&rid="+rid    //工业给水
	   $('#data6').attr('href',data6url); 
	   
	   if(rid=='75501330025'){
	    	$('#data7').text("工业进水2")
	    }else{
	    	$('#data7').text("生活给水")	
	    }
	   var data7url="../admin/sys/sysMenu/minMenu?parentId=185&rid="+rid    //生活给水
	   $('#data7').attr('href',data7url); 
	   
	    var data8url="../admin/sys/sysMenu/minMenu?parentId=167&rid="+rid    //工业排水
	   $('#data8').attr('href',data8url); 
	   
	    var data9url="../admin/sys/sysMenu/minMenu?parentId=191&rid="+rid    //流量汇总
	   $('#data9').attr('href',data9url); 
	   
	    var data10url="../admin/sys/sysMenu/minMenu?parentId=216&rid="+rid    //流量系数
	   $('#data10').attr('href',data10url); 
	   
	   var data11url="../admin/sys/sysMenu/minMenu?parentId=216&rid="+rid    //流量日结
	   $('#data11').attr('href',data11url); 
	   
	  
	   
	   var data12url="../admin/sys/sysMenu/minMenu?parentId=97&rid="+rid    //报警
	   $('#data12').attr('href',data12url); 
	   
	   var data13url="../admin/sys/sysMenu/minMenu?parentId=7&rid="+rid    //单元信息
	   $('#data13').attr('href',data13url); 
	  
	   
	    var data16url="../admin/tdht/monitors/monitorList3?word=3&rid="+rid    //设备管理
	   $('#data16').attr('href',data16url); 
	   
	    var data14url="../admin/tdht/monitors/monitorList3?word=3&rid="+rid    //设备状态
	   $('#data14').attr('href',data14url); 
	    
	    if(rid==75506330001||rid==75506330002||rid==75506330003){
	    	var data15url="../admin/tdht/monitors/deviceStatus?rid="+rid    //设备控制
	 	   $('#data15').attr('href',data15url); 
	    }else{
	    var data15url="../admin/tdht/monitors/deviceStatus?rid="+rid    //设备控制
	   $('#data15').attr('href',data15url); 
	    
	    }
	    var data_videourl="../admin/tdht/company/com_video?rid="+rid    //视频
	 	   $('#data_video').attr('href',data_videourl); 
	    
	    
       var data17url="../admin/sys/sysMenu/minMenu?parentId=232&rid="+rid     //污染物汇总
	   $('#data17').attr('href',data17url); 
       var data18url="../admin/tdht/log/logList?rid="+rid    //操作日志
	   $('#data18').attr('href',data18url);
       var data19url="../admin/tdht/log/offlineLogList?rid="+rid    //离线日志
	   $('#data19').attr('href',data19url);
	   } 
function  URLstr2(rid){
	//alert(rid)
	   var data1url="../admin/tdht/data/doGet?rid="+rid    //监测数据
	   $('#data1').attr('href',data1url); 

	    var data2url="../admin/tdht/data/doGet?rid="+rid    //实时数据
	   $('#data2').attr('href',data2url); 
	   $('#page-change').attr('href',data2url);
	   var data2url2="../admin/sys/sysMenu/minMenu?parentId=210&rid="+rid    // 历史数据
	   $('#data20').attr('href',data2url2); 
	   
	   
	   
	   
	   var data3url="../admin/sys/sysMenu/minMenu?parentId=209&rid="+rid    //日结 报表
	   $('#data3').attr('href',data3url); 
	   
	   var data4url="../admin/sys/sysMenu/minMenu?parentId=210&rid="+rid    //历史报表
	   $('#data4').attr('href',data4url); 
	   
	   var data5url="../admin/sys/sysMenu/minMenu?parentId=199&rid="+rid    //水平衡报表
	   $('#data5').attr('href',data5url); 
	   
	    var data55url="../admin/sys/sysMenu/minMenu?parentId=228&rid="+rid    //水平衡报表
	   $('#data55').attr('href',data55url); 
	   
	   
	   var data6url="../admin/sys/sysMenu/minMenu?parentId=179&rid="+rid    //工业给水
	   $('#data6').attr('href',data6url); 
	   
	   var data7url="../admin/sys/sysMenu/minMenu?parentId=185&rid="+rid    //生活给水
	   $('#data7').attr('href',data7url); 
	   
	    var data8url="../admin/sys/sysMenu/minMenu?parentId=167&rid="+rid    //工业排水
	   $('#data8').attr('href',data8url); 
	   
	    var data9url="../admin/sys/sysMenu/minMenu?parentId=191&rid="+rid    //流量汇总
	   $('#data9').attr('href',data9url); 
	   
	    var data10url="../admin/sys/sysMenu/minMenu?parentId=216&rid="+rid    //流量系数
	   $('#data10').attr('href',data10url); 
	   
	   var data11url="../admin/sys/sysMenu/minMenu?parentId=216&rid="+rid    //流量日结
	   $('#data11').attr('href',data11url); 
	   
	  
	   
	   var data12url="../admin/sys/sysMenu/minMenu?parentId=252&rid="+rid    //报警
	   $('#data12').attr('href',data12url); 
	   
	   var data13url="../admin/sys/sysMenu/minMenu?parentId=7&rid="+rid    //单元信息
	   $('#data13').attr('href',data13url); 
	  
	   
	    var data16url="../admin/tdht/monitors/monitorList3?word=3&rid="+rid    //设备管理
	   $('#data16').attr('href',data16url); 
	   
	    var data14url="../admin/tdht/monitors/monitorList3?word=3&rid="+rid    //设备状态
	   $('#data14').attr('href',data14url); 
	    
	    var data15url="../admin/tdht/newMonitorsWater/deviceStatus?&rid="+rid    //设备控制
	   $('#data15').attr('href',data15url); 
       var data17url="../admin/sys/sysMenu/minMenu?parentId=232&rid="+rid     //污染物汇总
	   $('#data17').attr('href',data17url); 
       var data18url="../admin/tdht/log/logList?rid="+rid    //操作日志
	   $('#data18').attr('href',data18url);
       var data19url="../admin/tdht/log/offlineLogList?rid="+rid    //离线日志
	   $('#data19').attr('href',data19url);
       
        var data21url="../admin/sys/sysMenu/minMenu?parentId=96&rid="+rid    //工业排水
	   $('#data21').attr('href',data21url); 
	   } 
function  click_com(){
	var a=$("#a_hidden").attr("href");
	if(a==""){
	   document.getElementById("indexa").click();//打开页面后默认点击
	}else{
		document.getElementById("a_hidden").click();//打开页面后默认点击
	}
	
}
function  click_com2(Rid){
	var a=$("#a_hidden").attr("href");
	if(a==""){
		if(Rid!=""){
			document.getElementById("mapp").click();//打开页面后默认点击
			
		}else{
	   document.getElementById("indexa").click();//打开页面后默认点击
	   }
	}else{
		document.getElementById("a_hidden").click();//打开页面后默认点击
	}}