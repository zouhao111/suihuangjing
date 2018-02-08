

function  console2(data){
	
	   $.ajax({
          url:"/admin/tdht/newMonitorsWater/monitorList4",
		type:"post",
		async: true,
		dataType:"json",
		data:data, 
		success:function(result){
		    $(this).jqLoading("destroy");
		   console.log(result)
		   
		   if(result.resultcode==300){
			   alert("不好意思！操作失败，请刷新页面后重新操作")
			   window.location.reload();
		   }
		   if(result.resultcode==100){
			   alert("登录超时！操作失败，请重新登陆后操作")
			   window.location.reload();
		   }
		  
		    
		    result=result.result;
		    
		var datass=eval(result)
		    console.log(datass)
		     for(i=0;i<datass.length;i++){
		    	 if(datass[i].Rid==75501330001){
		    		 result_yyf=datass[i];
		    	 }else  if(datass[i].Rid==75501330002){
		    		 result_odk=datass[i];
		    	 }else  if(datass[i].Rid==75501330003){
		    		 result_tdht=datass[i];
		    	 }else  if(datass[i].Rid==75501330004){
		    		 result_zckj=datass[i];
		    	 }else  if(datass[i].Rid==75501330005){
		    		 result_tdht2=datass[i];
		    	 }
		     }
		  
		    	 data_tdht=datass[0];
		    var DeviceValue1=data_tdht.DeviceValue1;
		    var DeviceValue2=data_tdht.DeviceValue2;
		    var door;
		    var removal;
		    var light_MA;
		      var light2;//灯光回路2
		    var conditioning;//空调
		     var fan1_hei;//风机1 高
		    var fan1_low;//风机1 低
		    var fan2_hei;//风机2 高
		    var fan2_low;//风机2 低
		     var QJ;//风机2 高
		    
           var byteNumber=[];
           var byteNumber2=[];
		   if(DeviceValue1==0){
			   door=0;
			   removal=0;
			   light_MA=0;
		   }else{
			 byteNumber=intToByte(DeviceValue1);
			 door=byteNumber[8];
			 removal=byteNumber[6];
			  light_MA=byteNumber[7];
		   }
		    if(DeviceValue2==0){
		    	light2=0;
			    conditioning=0;
		     fan1_low=0;
		     fan1_hei=0;
		    fan2_low=0;
		   fan2_hei=0;
		    QJ=0;
		    
		   }else{
			 byteNumber2=intToByte(DeviceValue2);
			 console.log(byteNumber2);
			 light2=byteNumber2[0];
			 conditioning=byteNumber2[3];
			  fan1_hei=byteNumber2[4];
		     fan1_low=byteNumber2[5];
		    fan2_hei=byteNumber2[6];
		    fan2_low=byteNumber2[7];
		    QJ=byteNumber2[15];
		    
		   }
		    
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		 if(door==0){
			     $("#button1_tdht").text("开启");
			   $("#button1_tdht").removeClass("btn_off")
			    $("#button1_tdht").addClass("btn_on")
			     $("#button1_tdht").val("1")
		   }
		   if(door==1){
			   $("#button1_tdht").text("关闭");
			   $("#button1_tdht").removeClass("btn_on")
			    $("#button1_tdht").addClass("btn_off")
			     $("#button1_tdht").val("0")
		   }
		   if(removal==1){
			   $("#button2_tdht").text("开启");
			   $("#button2_tdht").removeClass("btn_off")
			    $("#button2_tdht").addClass("btn_on")
			     $("#button2_tdht").val("0")
		   }
		   if(removal==0){
			   $("#button2_tdht").text("关闭");
			   $("#button2_tdht").removeClass("btn_on")
			    $("#button2_tdht").addClass("btn_off")
			     $("#button2_tdht").val("1")
		   }
		   if(light_MA==1){
			     $("#button3_tdht").text("手动模式");
			 
			   $("#button3_tdht").removeClass("btn_off")
			    $("#button3_tdht").addClass("btn_on")
			     $("#button3_tdht").val("0")
		   }
		   if(light_MA==0){
			   $("#button3_tdht").text("自动模式");
			    
			   $("#button3_tdht").removeClass("btn_on")
			    $("#button3_tdht").addClass("btn_off")
			     $("#button3_tdht").val("1")
		   }
		   
		   if(light2==1){
			    $("#light2").text("开启");
			   $("#light2").removeClass("btn_off")
			    $("#light2").addClass("btn_on")
			     $("#light2").val("0")
		   }
		   if(light2==0){
			    $("#light2").text("关闭");
			   $("#light2").removeClass("btn_on")
			    $("#light2").addClass("btn_off")
			     $("#light2").val("1")
		   }
		      if(conditioning==1){
		    	  $("#conditioning").text("开启");
			   $("#conditioning").removeClass("btn_off")
			    $("#conditioning").addClass("btn_on")
			     $("#conditioning").val("0")
		   }
		   if(conditioning==0){
			   $("#light2").text("关闭");
			   $("#conditioning").removeClass("btn_on")
			    $("#conditioning").addClass("btn_off")
			     $("#conditioning").val("1")
		   }
		   if(fan_MA==1){
		    	$("#fan").text("手动模式");
		    	$("#fan").removeClass("btn_off")
			    $("#fan").addClass("btn_on")
			   
			     $("#fan").val("0")
		   }
		    if(fan_MA==0){
		    	$("#fan").text("自动模式");
			   $("#fan").removeClass("btn_on")
			    $("#fan").addClass("btn_off")
			     $("#fan").val("1")
		   }
		    if(fan1_hei==1){
		    	$("#fan1").text("开启");
			   $("#fan1").removeClass("btn_off")
			    $("#fan1").addClass("btn_on")
			     $("#fan1").val("0")
		   }
		    
		   if(fan1_hei==0){
			   $("#fan1").text("关闭");
			   $("#fan1").removeClass("btn_on")
			    $("#fan1").addClass("btn_off")
			     $("#fan1").val("1")
		   }
		   if(fan1_low==1){
			   $("#fan2").removeClass("btn_off")
			    $("#fan2").addClass("btn_on")
			     $("#fan2").val("0")
		   }
		   if(fan1_low==0){
			   $("#fan2").removeClass("btn_on")
			    $("#fan2").addClass("btn_off")
			     $("#fan2").val("1")
		   }
		   if(fan2_hei==1){
			    $("#fan3").text("开启");
			   $("#fan3").removeClass("btn_off")
			    $("#fan3").addClass("btn_on")
			     $("#fan3").val("0")
		   }
		   if(fan2_hei==0){
			   $("#fan3").text("关闭");
			   $("#fan3").removeClass("btn_on")
			    $("#fan3").addClass("btn_off")
			     $("#fan3").val("1")
		   }
		   if(fan2_low==1){
			   $("#fan4").removeClass("btn_off")
			    $("#fan4").addClass("btn_on")
			     $("#fan4").val("0")
		   }
		   if(fan2_low==0){
			   $("#fan4").removeClass("btn_on")
			    $("#fan4").addClass("btn_off")
			     $("#fan4").val("1")
		   }
		   if(QJ_MA==1){
			   $("#QJ1").text("手动模式");
			   $("#QJ1").removeClass("btn_off")
			    $("#QJ1").addClass("btn_on")
			     $("#QJ1").val("1")
		   }
		   if(QJ_MA==0){
			   $("#QJ1").text("自动模式");
			   $("#QJ1").removeClass("btn_off")
			    $("#QJ1").addClass("btn_on")
			     $("#QJ1").val("0")
		   }
		   if(QJ==1){
			   $("#QJ").text("开启");
			   $("#QJ").removeClass("btn_off")
			    $("#QJ").addClass("btn_on")
			     $("#QJ").val("0")
		   }
		   if(QJ==0){
			     $("#QJ").text("关闭");
			   $("#QJ").removeClass("btn_on")
			    $("#QJ").addClass("btn_off")
			     $("#QJ").val("1")
		   } 
		 
		      $(this).jqLoading("destroy"); 
		    
		   }
	})
}   