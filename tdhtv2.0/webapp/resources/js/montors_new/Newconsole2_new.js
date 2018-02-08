

function  console2s(data){
	
	   $.ajax({
          url:"/admin/tdht/newMonitors/monitorList4_new",
		type:"post",
		async: true,
		dataType:"json",
		data:data, 
		success:function(result){
		    $(this).jqLoading("destroy");
		  // console.log(result)
		   
		   if(result.resultcode==300){
			   alert("不好意思！操作失败，请刷新页面后重新操作")
			   window.location.reload();
		   }
		   if(result.resultcode==100){
			   alert("登录超时！操作失败，请重新登陆后操作")
			   window.location.reload();
		   }
		  
		   results=result.result;
		    result="{"+results;
		   // console.log(result)
              
		     datass=eval("("+result+")");  
		    datass=datass.锘縶result;
		    
   	 
   	 data_tdht=datass[0];
	    var DeviceValue1=data_tdht.DeviceValue1;
	    var DeviceValue2=data_tdht.DeviceValue2;
	   var door1;
	   var door2;
	   var yangan;
	   var wengan;
	   var hongwai;
	   var louye1;
	   var louye2;
	   var fangchai1;
	   var fangchai2;
	   var UPS;
	   var light1;
	   var light2;
	   var zhendong1;
	   var zhendong2;
	   var shouzi;
	   var kongtiao;
	   var shuaka;
	  var anfang;
       var byteNumber=[];
       var byteNumber2=[];
	   if(DeviceValue1==0){
		    door1=0;
		    door2=0;
		    yangan=0;
		    wengan=0;
		    hongwai=0;
		    louye1=0;
		    louye2=0;
		    fangchai1=0;
		    fangchai2=0;
		    
		    UPS=0;
		    light1=0;
	    	  light2=0;
			  zhendong1=0;
			  zhendong2=0;
			  shouzi=0;
			  kongtiao=0;
			  shuaka=0;
			  anfang=0;
	   }else{
		 byteNumber=intToByte(DeviceValue1);
		 door1=byteNumber[0];
		    door2=byteNumber[1];
		    yangan=byteNumber[2];
		    wengan=byteNumber[3];
		    hongwai=byteNumber[4];
		    louye1=byteNumber[5];
		    louye2=byteNumber[6];
		    fangchai1=byteNumber[7];
		    fangchai2=byteNumber[8];
		    
		    shuaka=byteNumber[9];


		    //UPS=byteNumber2[0];
			   light2=byteNumber[10];
				  zhendong1=byteNumber[11];
				  zhendong2=byteNumber[12];
				  shouzi=byteNumber[13];
				  light1=byteNumber[14];
				  anfang=byteNumber[15];
	   }
	  
	   
	   
	    if(DeviceValue2==0){
	    	 
			  kongtiao=0;
	   }else{
		   byteNumber2=intToByte(DeviceValue2);
		  
			  kongtiao=byteNumber2[5];
			 
	   }
	    var tabTemperature=data_tdht.tabTemperature==null?0:parseInt(data_tdht.tabTemperature).toFixed(2)
			    var tabHumidity=data_tdht.tabHumidity==null?0:parseInt(data_tdht.tabHumidity).toFixed(2)
			    var tabAirCCurrent=data_tdht.tabAirCCurrent==null?0:parseInt(data_tdht.tabAirCCurrent).toFixed(2)
			    var tabCurrentW=data_tdht.tabCurrentW==null?0:parseInt(data_tdht.tabCurrentW).toFixed(2)
			    var tabVoltageW=data_tdht.tabVoltageW==null?0:parseInt(data_tdht.tabVoltageW).toFixed(2)
			    var  tabCurrentV=data_tdht.tabCurrentV==null?0:parseInt(data_tdht.tabCurrentV).toFixed(2)
			    var tabVoltageV=data_tdht.tabVoltageV==null?0:parseInt(data_tdht.tabVoltageV).toFixed(2)
			    var tabCurrentU=data_tdht.tabCurrentU==null?0:parseInt(data_tdht.tabCurrentU).toFixed(2)
			    var tabVoltageU=data_tdht.tabVoltageU==null?0:parseInt(data_tdht.tabVoltageU).toFixed(2)
			    var tabSample=data_tdht.tabSample
			    var TemSv=data_tdht.TemSv==null?0:parseInt(data_tdht.TemSv).toFixed(2)
			    var AirVolume=data_tdht.AirVolume
			    var mode=data_tdht.mode
			    var tabElectric=data_tdht.tabElectric==null?0:parseInt(data_tdht.tabElectric).toFixed(2)
			    var  tabPumpValue=data_tdht.tabPumpValue==null?0:parseInt(data_tdht.tabPumpValue).toFixed(2)
			    
			    
			    var  lowTemp=data_tdht.lowTemp==null?0:parseInt(data_tdht.lowTemp).toFixed(2)
			    var  hightTemp=data_tdht.hightTemp==null?0:parseInt(data_tdht.hightTemp).toFixed(2)
			    
	    $("#lowTemp").text(lowTemp);
	    $("#hightTemp").text(hightTemp);
	   
	    
	    
	    
	    $("#tabTemperature").text(tabTemperature);
	    $("#tabHumidity").text(tabHumidity);
	    
	    $("#tabAirCCurrent").text(tabAirCCurrent);
	   /* $("#tabCurrentW").text(tabCurrentW);
	    $("#tabVoltageW").text(tabVoltageW);
	    $("#tabCurrentV").text(tabCurrentV);
	    $("#tabVoltageV").text(tabVoltageV);*/
	    
	    $("#tabElectric").text(tabElectric);
	    $("#tabCurrentU").text(tabCurrentU);
	    $("#tabVoltageU").text(tabVoltageU);
	    $("#TemSv").text(TemSv);
	
	   /* $("#tabSample").text(tabSample);
	    $("#TemSv").text(TemSv);
	    $("#AirVolume").text(AirVolume);*/
	    
	    
	    
	    
	    
	    /*  var manholeValue1=0;
	    var manholeValue3=1;
	    var manholeValue2=0;
	     var pumpValue1=1*/
	    
	    
	    
	 /*   if(mode=0){
	    	$("#mode").text("自动");
	    }else if(mode=1){
	    	$("#mode").text("送风");
	    }else if(mode=2){
	    	$("#mode").text("制冷");
	    }else if(mode=3){
	    	$("#mode").text("制热");
	    }else if(mode=4){
	    	$("#mode").text("除湿");
	    }
	    if(AirVolume=0){
	    	$("#AirVolume").text("自动");
	    }else if(AirVolume=1){
	    	$("#AirVolume").text("L");
	    }else if(AirVolume=2){
	    	$("#AirVolume").text("LL");
	    }else if(AirVolume=3){
	    	$("#AirVolume").text("H");
	    }else if(AirVolume=4){
	    	$("#AirVolume").text("HH");
	    }*/
	   /* if(tabPumpValue==1){
		     $("#tabPumpValue").text("开启");
		   
	   }
	   if(tabPumpValue==0){
		   $("#tabPumpValue").text("关闭");
		   
	   }*/
	   if(door1==1){
		     $("#button1_tdht").text("开启");
		   
	   }
	   if(door1==0){
		   $("#button1_tdht").text("关闭");
		   
	   }
	   if(door2==1){
		     $("#button2_tdht").text("开启");
		  
	   }
	   if(door2==0){
		   $("#button2_tdht").text("关闭");
		  
	   }
	  /* if(fan1==1){
		     $("#fan1").text("开启");
		  
	   }
	   if(fan1==0){
		   $("#fan1").text("关闭");
		  
	   }*/
	   
	   
	   if(yangan==0){
		   $("#yangan").text("正常");
	   }
       if(yangan==1){
    	   $("#yangan").text("报警");
	   }
      /* if(yangan==0){
		   $("#wengan").text("正常");
	   }
       if(yangan==1){
    	   $("#wengan").text("报警");
	   }*/
       if(wengan==0){
		   $("#wengan").text("正常");
	   }
       if(wengan==1){
    	   $("#wengan").text("报警");
	   }
       if(hongwai==0){
		   $("#hongwai").text("正常");
	   }
       if(hongwai==1){
    	   $("#hongwai").text("报警");
	   }
       if(louye1==0){
		   $("#louye1").text("正常");
	   }
       if(louye1==1){
    	   $("#louye1").text("报警");
	   }
       if(louye2==0){
		   $("#louye2").text("正常");
	   }
       if(louye2==1){
    	   $("#louye2").text("报警");
	   }
       if(fangchai1==0){
		   $("#fangchai1").text("正常");
	   }
       if(fangchai1==1){
    	   $("#fangchai1").text("报警");
	   }
       if(fangchai2==0){
		   $("#fangchai2").text("正常");
	   }
       if(fangchai2==1){
    	   $("#fangchai2").text("报警");
	   }
       if(anfang==0){
		   $("#anfang").text("正常");
	   }
       if(fangchai2==1){
    	   $("#anfang").text("报警");
	   }
       /*if(UPS=0){
		   $("#UPS").text("正常");
	   }
       if(UPS=1){
    	   $("#UPS").text("报警");
	   }*/
       if(light1==0){
		   $("#light1").text("关闭");
	   }
       if(light1==1){
    	   $("#light1").text("开启");
	   }
       if(light2==0){
		   $("#light2").text("关闭");
	   }
       if(light2==1){
    	   $("#light2").text("开启");
	   }
       if(zhendong1==0){
		   $("#zhendong1").text("正常");
	   }
       if(zhendong1==1){
    	   $("#zhendong1").text("报警");
	   }
       if(zhendong2==0){
		   $("#zhendong2").text("正常");
	   }
       if(zhendong2==1){
    	   $("#zhendong2").text("报警");
	   }
       
       if(shouzi==0){
		   $("#shouzi").text("自动");
	   }
       if(shouzi==1){
    	   $("#shouzi").text("手动");
	   }
       
       if(kongtiao==0){
		   $("#conditioning").text("开启");
	   }
       if(kongtiao==1){
    	   $("#conditioning").text("关闭");
	   }
	    
      /* if(shuaka==1){
    	   $("#shuaka").text("刷卡");
	   }*/
	    
       
  
		      $(this).jqLoading("destroy"); 
		    
		   }
	})
}   