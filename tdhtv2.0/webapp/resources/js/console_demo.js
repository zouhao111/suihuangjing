function  console_demo1(){
	
	var demo={};
	demo.stata=6;
	demo.rid=75501330004;
	demo.deviceType=5;
	demo.deviceNum=2;
	demo.value=2
	var rid=75501330004;
	var url_path='http://211.154.140.180:3313/api/alarm/alarmList?rid=75501330004'
	console.log(demo)
	   $.ajax({
          url:"/admin/tdht/serviceUtils/getJsonContent",
          type:"post",
		async: false,
		data:{url_path:url_path},
		dataType:"json",    
   
   success:function(result){    
       console.log(result);    
   },  
   
	   })
	  }


function  console_demo2(){
	var url_path='http://211.154.140.180:3313/api/alarm/alarmList?rid=75501330004'
	var demo={};
	demo.stata=6;
	demo.rid=75501330004;
	demo.deviceType=5;
	demo.deviceNum=2;
	demo.value=4
	console.log(demo)
	   $.ajax({
          url:"/tdht/serviceUtils/getJsonContent",
		type:"post",
		async: false,
		dataType:"json",
		data:{url_path:url_path},
		success:function(result){
		   console.log("关+++++++"+result)
		    }
	   })
	  }