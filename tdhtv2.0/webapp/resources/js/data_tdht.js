


function  load_data(rid){
	   $.ajax({
          url:"../data/doGet2?rid="+rid,
		type:"post",
		async: true,
		dataType:"json",
		success:function(result){
		   
		   
		   
		   var list=result.list;
		  var data1= list[0];
		  var data2= list[1];
		  var data3= list[2];
		  var data4= list[3];
		  
		  var waterquality= list[4];
		  var ztraffic= list[5];
		  var ztraffic2= list[6];
		  var companyconfig= list[7];
		  var url= list[8];
		  var sam1=list[9];
		  var sam2=list[10];
		  var sam3=list[11];
		  var sam4=list[12];
		  var pollutants=list[13];
		  var pollutantss=list[14];
		  var data=list[15];
		  var waterLevel1; var waterLevel2;var waterLevel2; var waterLevel3; var waterLevel4;//水位
		  var flowVelocity1;var flowVelocity2;var flowVelocity3;var flowVelocity4; //流速
		  var flowRate1; var flowRate2; var flowRate3; var flowRate4;//流量速率
		  var traffic1; var traffic2; var traffic3; var traffic4;//流量
		  var trafficLastDay1; var trafficLastDay2; var trafficLastDay3; var trafficLastDay4;//24小时流量速率
		  var voltage1;var voltage2;var voltage3;var voltage4;//电压
		  var sysState1;var sysState2;var sysState3;var sysState4;
		  var realPh;							//实时PH
	      var lastDayMinPh;			//最近24小时的最小值PH
	      var lastDayMaxPh;			//最近24小时最大值PH
	       var realCod;						//实时COD
	      var lastDayMinCod;			//最近24小时最小值COD
	      var lastDayMaxCod;			//最近24小时最大值COD
	      var realNH3N;						//实时氨氮
	      var lastDayMinNH3N;			//最近24小时最小值氨氮
	      var lastDayMaxNH3N;			//最近24小时最大值氨氮
	      var realConductivity;		//电导率
	      var lastDayMaxConductivity;		//电导率最大值
	      var lastDayMinConductivity;		//电导率最小值
		  var cr6;		//六价铬
	      var lastDayMaxCr6;		//六价铬
	      var lastDayMinCr6;	
	     // console.log(data)
	      
	      
	       var endTime
	      if(data!=null){
	      endTime=data.strTime;
	       var s = endTime.split(".")
	             	//console.log(s)
		             endTime=s[0];
	             $("#endTime").html("");	
			 $("#endTime").append("截止时间："+endTime);
	      }
	      if(companyconfig!=null){
	    	  startTime=companyconfig.stratTime;
	    	 var s = startTime.split(".")
	             	//console.log(s)
		            var startTime=s[0];
	             $("#startTime").html("");	
			 $("#startTime").append("起始时间："+startTime);
			  startTime=startTime.replace(/-/g,"/");
			  endTime=endTime.replace(/-/g,"/");
			 var val = Date.parse(startTime);
			 var val2 = Date.parse(endTime);
			   var time = new Date(val);
			var now =new Date(val2);
	   var s1 = time.getTime();
	   var s2 =now.getTime();
	    // console.log(s1,s2)
	     
	     var total = (s2 - s1)/1000;
	  var day = parseInt(total / (24*60*60));//计算整数天数
      var afterDay = total - day*24*60*60;//取得算出天数后剩余的秒数
      var hour = parseInt(afterDay/(60*60));//计算整数小时数
      var afterHour = total - day*24*60*60 - hour*60*60;//取得算出小时数后剩余的秒数
      var min = parseInt(afterHour/60);//计算整数分
      var afterMin = total - day*24*60*60 - hour*60*60 - min*60;//取得算出分后剩余的秒数
      $("#sub_time").html("");
		$("#sub_time").text(" 计量时间（日）:"+day+"天"+hour+"时"+min+"分") ;
	     
	     
	      }      
	      
	      
	      
	      
	      
	      
	      if(data!=null){
	    	  waterLevel1=data.id_waterlevel.toFixed(3);is_CurrentSpeed=data.is_CurrentSpeed.toFixed(3);
			 is_traffic=data.is_traffic.toFixed(4);yes_is_ztraffic=data.industrialsupply.toFixed(1);
			 is_sub_ztraffic=data.is_sub_ztraffic.toFixed(1);
			// is_key=(data.is_key==0?'正常':'离线')
			 is_voltage=data.is_voltage.toFixed(2);
			 is_ztraffic=data.is_ztraffic.toFixed(1);
			 
			 
			 ls_CurrentSpeed=data.ls_CurrentSpeed.toFixed(3);
			 ls_traffic=data.ls_traffic.toFixed(4);yes_ls_ztraffic=data.livingsupply.toFixed(1);
			 ls_sub_ztraffic=data.ls_sub_ztraffic.toFixed(1);
			// ls_key=(data.ls_key==0?'正常':'离线')
			 ls_voltage=data.ls_voltage.toFixed(2);
			  ls_ztraffic=data.ls_ztraffic.toFixed(1);
			 
			 waterLevel2=data.is_waterlevel.toFixed(3);
			 id_CurrentSpeed=data.id_CurrentSpeed.toFixed(3);
			 id_traffic=data.id_traffic.toFixed(4);yes_id_ztraffic=data.industrialdrainage.toFixed(1);
			 id_sub_ztraffic=data.id_sub_ztraffic.toFixed(1);
			// id_key=(data.id_key==0?'正常':'离线')
			 id_voltage=data.id_voltage.toFixed(2);
			 id_ztraffic=data.id_ztraffic.toFixed(1);
			 
	      }else{
	    	  waterLevel1="-";is_CurrentSpeed="-";is_ztraffic="-";
			 is_traffic="-";traffic1="-";
			 trafficLastDay1="-";voltage1="-";
			// is_key="-";is_sub_ztraffic
			 is_voltage="-";is_sub_ztraffic="-";
			 
			 ls_CurrentSpeed="-";
			 ls_traffic="-";ls_ztraffic="-";
			 trafficLastDay2="-";voltage2="-";
			// ls_key="-"
			 ls_voltage="-";ls_sub_ztraffic="-";
			 waterLevel2="-";
			 id_CurrentSpeed="-";
			 id_traffic="-";id_ztraffic="-";
			 trafficLastDay3="-";voltage="-".voltage;
			// id_key="-"
			 id_voltage="-";id_sub_ztraffic="-";
	    	  
	      }
	    
		  
		/* *if(data1!=null){
			 waterLevel1=data1.waterLevel;flowVelocity1=data1.flowVelocity;
			 flowRate1=data1.flowRate;traffic1=data1.traffic;
			 trafficLastDay1=data1.trafficLastDay;voltage1=data1.voltage;
			 sysState1=(data1.sysState==0?'正常':'离线')
		 }else{
			 waterLevel1="-";flowVelocity1="-";
			 flowRate1="-";traffic1="-";
			 trafficLastDay1="-";voltage1="-";
			 sysState1="-";
		 }
		 if(data2!=null){
			 waterLevel2=data2.waterLevel;flowVelocity2=data2.flowVelocity;
			 flowRate2=data2.flowRate;traffic2=data2.traffic;
			 trafficLastDay2=data2.trafficLastDay;voltage2=data2.voltage;
			 sysState2=(data2.sysState==0?'正常':'离线')
		 }else{
			 waterLevel2="-";flowVelocity2="-";
			 flowRate2="-";traffic2="-";
			 trafficLastDay2="-";voltage2="-";
			 sysState2="-";
		 }
		 if(data3!=null){
			 waterLevel3=data3.waterLevel;flowVelocity3=data3.flowVelocity;
			 flowRate3=data3.flowRate;traffic3=data3.traffic;
			 trafficLastDay3=data3.trafficLastDay;voltage3=data3.voltage;
			 sysState3=(data3.sysState==0?'正常':'离线')
		 }else{
			 waterLevel3="-";flowVelocity3="-";
			 flowRate3="-";traffic3="-";
			 trafficLastDay3="-";voltage3="-";
			 sysState3="-";
		 }*/
		
	      	      var th1="<th align='center' style='font-family: 黑体;font-size: 16px;'>水位(m)</th>";
				th1+=" <th style='color: #0071BC;' align='center'>"+waterLevel2+"</th>";	
				th1+=" <th style='color: #0071BC;' align='center'>-</th>";
				th1+=" <th style='color: #0071BC;' align='center'>"+waterLevel1+"</th>";
				th1+=" <th align='center'>-</th>";
		  $th1 = $(th1);
           //清除数据
           $("#waterLevel").empty();
           //添加td
    		$("#waterLevel").append($th1);
    		
		  var th2="<th align='center' style='font-family: 黑体;font-size: 16px;'>流速(m/s)</th>";
				th2+=" <th style='color: #0071BC;' align='center'>"+is_CurrentSpeed+"</th>";	
				th2+=" <th style='color: #0071BC;' align='center'>"+ls_CurrentSpeed+"</th>";
				//th2+=" <th style='color: blue;' align='center'>-</th>";
				th2+=" <th style='color: #0071BC;' align='center'>"+id_CurrentSpeed+"</th>";
				th2+=" <th style='color: #0071BC;' align='center'>-</th>";
		  $th2 = $(th2);
           //清除数据
           $("#flowVelocity").empty();
           //添加td
    		$("#flowVelocity").append($th2);
    		
		   var th3="<th align='center' style='font-family: 黑体;font-size: 16px;'>流量速率(m<sup>3</sup>/s)</th>";
				th3+=" <th style='color: #0071BC;' align='center'>"+is_traffic+"</th>";	
				th3+=" <th style='color: #0071BC;' align='center'>"+ls_traffic+"</th>";
				//th3+=" <th style='color: blue;' align='center'>-</th>";
				th3+=" <th style='color: #0071BC;' align='center'>"+id_traffic+"</th>";
				th3+=" <th style='color: #0071BC;' align='center'>-</th>";
		  $th3 = $(th3);
           //清除数据
           $("#flowRate").empty();
           //添加td
    		$("#flowRate").append($th3);
		  
    		
    		var th4="<th align='center' style='font-family: 黑体;font-size: 16px;'>今日流量(m<sup>3</sup>)</th>";
				th4+=" <th style='color: #0071BC;' align='center'>"+is_sub_ztraffic+"</th>";	
				th4+=" <th style='color: #0071BC;' align='center'>"+ls_sub_ztraffic+"</th>";
				//th4+=" <th style='color: blue;' align='center'>-</th>";
				th4+=" <th style='color: #0071BC;' align='center'>"+id_sub_ztraffic+"</th>";
				th4+=" <th style='color: #0071BC;' align='center'>-</th>";
		  $th4 = $(th4);
           //清除数据
           $("#traffic").empty();
           //添加td
    		$("#traffic").append($th4);
		  
    		
    		var th5="<th align='center' style='font-family: 黑体;font-size: 16px;'>昨日流量(m<sup>3</sup>)</th>";
				th5+=" <th style='color: red;' align='center'>"+yes_is_ztraffic+"</th>";	
				th5+=" <th style='color: red;' align='center'>"+yes_ls_ztraffic+"</th>";
				//th5+=" <th style='color: blue;' align='center'>-</th>";
					
				th5+=" <th style='color: red;' align='center'>"+yes_id_ztraffic+"</th>";
				th5+=" <th style='color: #0071BC;' align='center'>-</th>";
		  $th5 = $(th5);
           //清除数据
           $("#trafficLastDay").empty();
           //添加td
    		$("#trafficLastDay").append($th5);
    		
    		
    		
    		var th6="<th align='center' style='font-family: 黑体;font-size: 16px;'>总流量(m<sup>3</sup>)</th>";
				th6+=" <th style='color: #0071BC;' align='center'>"+is_ztraffic+"</th>";	
				th6+=" <th style='color: #0071BC;' align='center'>"+ls_ztraffic+"</th>";
				//th6+=" <th style='color: blue;' align='center'>-</th>";
				th6+=" <th id='id_01'style='color: #0071BC;' align='center'>"+id_ztraffic+"</th>";
				th6+=" <th style='color: #0071BC;' align='center'>-</th>";
		  $th6 = $(th6);
           //清除数据
           $("#voltage").empty();
           //添加td
    		$("#voltage").append($th6);
    	//	console.log(waterquality)
    		 if(waterquality!=null){
    			 if(waterquality.realPh!=null&&waterquality.lastDayMinPh!=null&&waterquality.lastDayMaxPh!=null){
    				 if(waterquality.realPh==0&&waterquality.lastDayMinPh==0&&waterquality.lastDayMaxPh==0){
    					 realPh="-";							
	                     lastDayMinPh="-";			
	                     lastDayMaxPh="-";			
    				 }else{
    					realPh=waterquality.realPh.toFixed(2);							
	                    lastDayMinPh=waterquality.lastDayMinPh.toFixed(2);			
	                    lastDayMaxPh=waterquality.lastDayMaxPh.toFixed(2);	
    				 }
    			 }else{
    				    realPh="-";							
	                     lastDayMinPh="-";			
	                     lastDayMaxPh="-";		
    			 }
    			  if(waterquality.realCod!=null&&waterquality.lastDayMinCod!=null&&waterquality.lastDayMaxCod!=null){
    				 if(waterquality.realCod==0&&waterquality.lastDayMinCod==0&&waterquality.lastDayMaxCod==0){
    					 realCod="-";						
	                     lastDayMinCod="-";			
	                     lastDayMaxCod="-";			
    				 }else{
    					 realCod=waterquality.realCod.toFixed(3);						
	                     lastDayMinCod=waterquality.lastDayMinCod.toFixed(3);			
	                     lastDayMaxCod=waterquality.lastDayMaxCod.toFixed(3);	
    				 }
    			 }else{
    				    realCod="-";						
	                     lastDayMinCod="-";			
	                     lastDayMaxCod="-";		
    			 }
    			  if(waterquality.realNH3N!=null&&waterquality.lastDayMinNH3N!=null&&waterquality.lastDayMaxNH3N!=null){
    				 if(waterquality.realNH3N==0&&waterquality.lastDayMinNH3N==0&&waterquality.lastDayMaxNH3N==0){
    					 realNH3N="-";						
	                     lastDayMinNH3N="-";			
	                     lastDayMaxNH3N="-";			
    				 }else{
    					 realNH3N=waterquality.realNH3N.toFixed(2);						
	                     lastDayMinNH3N=waterquality.lastDayMinNH3N.toFixed(2);			
	                     lastDayMaxNH3N=waterquality.lastDayMaxNH3N.toFixed(2);		
    				 }
    			 }else{
    				     realNH3N="-";						
	                     lastDayMinNH3N="-";			
	                     lastDayMaxNH3N="-";			
    			 }
    			   if(waterquality.realConductivity!=null&&waterquality.lastDayMaxConductivity!=null&&waterquality.lastDayMinConductivity!=null){
    				 if(waterquality.realConductivity==0&&waterquality.lastDayMaxConductivity==0&&waterquality.lastDayMinConductivity==0){
    					realConductivity="-";		
	                    lastDayMaxConductivity="-";		
	                       lastDayMinConductivity="-";			
    				 }else{
    					 realConductivity=waterquality.realConductivity.toFixed(0);		
	                     lastDayMaxConductivity=waterquality.lastDayMaxConductivity.toFixed(0);		
	                     lastDayMinConductivity=waterquality.lastDayMinConductivity.toFixed(0);	
    				 }
    			 }else{
    				   realConductivity="-";		
	                    lastDayMaxConductivity="-";		
	                       lastDayMinConductivity="-";		
    			 }
    			    if(waterquality.realcr6!=null&&waterquality.lastDayMaxCr6!=null&&waterquality.lastDayMinCr6!=null){
    				 if(waterquality.realcr6==0&&waterquality.lastDayMaxCr6==0&&waterquality.lastDayMinCr6==0){
    					realcr6="-";		
	                     lastDayMaxCr6="-";		
	                    lastDayMinCr6="-";			
    				 }else{
    					realcr6=waterquality.realcr6.toFixed(3);		
	                    lastDayMaxCr6=waterquality.lastDayMaxCr6.toFixed(2);		
	                    lastDayMinCr6=waterquality.lastDayMinCr6.toFixed(2);
    				 }
    			 }else{
    				    realcr6="-";		
	                     lastDayMaxCr6="-";		
	                    lastDayMinCr6="-";		
    			 }
    			    if(waterquality.realTemp!=null&&waterquality.lastDayMaxTemp!=null&&waterquality.lastDayMinTemp!=null){
    				 if(waterquality.realTemp==0&&waterquality.lastDayMaxTemp==0&&waterquality.lastDayMinTemp==0){
    					realTemp="-";	
	                    lastDayMaxTemp="-";	
	                    lastDayMinTemp="-";		
    				 }else{
    				realTemp=waterquality.realTemp.toFixed(2);	
	                lastDayMaxTemp=waterquality.lastDayMaxTemp.toFixed(2);		
	                lastDayMinTemp=waterquality.lastDayMinTemp.toFixed(2);
    				 }
    			 }else{
    				    realTemp="-";	
	                    lastDayMaxTemp="-";	
	                    lastDayMinTemp="-";		
    			 }
    			     if(waterquality.realDo!=null&&waterquality.lastDayMaxDo!=null&&waterquality.lastDayMaxDo!=null){
    				 if(waterquality.realDo==0&&waterquality.lastDayMinDo==0&&waterquality.lastDayMinDo==0){
    					 realDo="-";
	                     lastDayMaxDo="-";		
	                     lastDayMinDo="-";
    				 }else{
    				realDo=waterquality.realDo==null?"-":waterquality.realDo.toFixed(2);	
	                lastDayMaxDo=waterquality.lastDayMaxDo.toFixed(2);		
	                lastDayMinDo=waterquality.lastDayMinDo.toFixed(2);
    				 }
    			 }else{
    				     realDo="-";
	                     lastDayMaxDo="-";		
	                     lastDayMinDo="-";	
    			 }
    	  /**	 realPh=(waterquality.realPh==null?"-":waterquality.realPh.toFixed(2));							
	       lastDayMinPh=waterquality.lastDayMinPh==null?"-":waterquality.lastDayMinPh.toFixed(2);			
	       lastDayMaxPh=waterquality.lastDayMaxPh==null?"-":waterquality.lastDayMaxPh.toFixed(2);			
	       realCod=waterquality.realCod==null?"-":waterquality.realCod.toFixed(3);						
	       lastDayMinCod=waterquality.lastDayMinCod==null?"-":waterquality.lastDayMinCod.toFixed(3);			
	       lastDayMaxCod=waterquality.lastDayMaxCod==null?"-":waterquality.lastDayMaxCod.toFixed(3);			
	       realNH3N=waterquality.realNH3N==null?"-":waterquality.realNH3N.toFixed(2);						
	       lastDayMinNH3N=waterquality.lastDayMinNH3N==null?"-":waterquality.lastDayMinNH3N.toFixed(2);			
	       lastDayMaxNH3N=waterquality.lastDayMaxNH3N==null?"-":waterquality.lastDayMaxNH3N.toFixed(2);			
	       realConductivity=waterquality.realConductivity==null?"-":waterquality.realConductivity.toFixed(2);		
	       lastDayMaxConductivity=waterquality.lastDayMaxConductivity==null?"-":waterquality.lastDayMaxConductivity.toFixed(2);		
	       lastDayMinConductivity=waterquality.lastDayMinConductivity==null?"-":waterquality.lastDayMinConductivity.toFixed(2);		
		   realcr6=waterquality.realcr6==null?"-":waterquality.realcr6.toFixed(3);		
	       lastDayMaxCr6=waterquality.lastDayMaxCr6==null?"-":waterquality.lastDayMaxCr6.toFixed(2);		
	       lastDayMinCr6=waterquality.lastDayMinCr6==null?'-':waterquality.lastDayMinCr6.toFixed(2);	
	       realTemp=waterquality.realTemp==null?"-":waterquality.realTemp.toFixed(2);	
	       lastDayMaxTemp=waterquality.lastDayMaxTemp==null?"-":waterquality.lastDayMaxTemp.toFixed(2);		
	       lastDayMinTemp=waterquality.lastDayMinTemp==null?'-':waterquality.lastDayMinTemp.toFixed(2);
	       realDo=waterquality.realDo==null?"-":waterquality.realDo.toFixed(2);	
	       lastDayMaxDo=waterquality.lastDayMaxDo==null?"-":waterquality.lastDayMaxDo.toFixed(2);		
	       lastDayMinDo=waterquality.lastDayMinDo==null?'-':waterquality.lastDayMinDo.toFixed(2);
	       
	    	 
	       realPh=(waterquality.realPh==null||waterquality.realPh==0?"-":waterquality.realPh.toFixed(2));							
	       lastDayMinPh=waterquality.lastDayMinPh==null||waterquality.realcod==0?"-":waterquality.lastDayMinPh.toFixed(2);			
	       lastDayMaxPh=waterquality.lastDayMaxPh==null||waterquality.realcod==0?"-":waterquality.lastDayMaxPh.toFixed(2);			
	       realCod=waterquality.realCod==null||waterquality.realcod==0?"-":waterquality.realCod.toFixed(3);						
	       lastDayMinCod=waterquality.lastDayMinCod==null||waterquality.lastDayMinCod==0?"-":waterquality.lastDayMinCod.toFixed(3);			
	       lastDayMaxCod=waterquality.lastDayMaxCod==null||waterquality.lastDayMaxCod==0?"-":waterquality.lastDayMaxCod.toFixed(3);			
	       realNH3N=waterquality.realNH3N==null||waterquality.realNH3N==0?"-":waterquality.realNH3N.toFixed(2);						
	       lastDayMinNH3N=waterquality.lastDayMinNH3N==null||waterquality.lastDayMinNH3N==0?"-":waterquality.lastDayMinNH3N.toFixed(2);			
	       lastDayMaxNH3N=waterquality.lastDayMaxNH3N==null||waterquality.lastDayMaxNH3N==0?"-":waterquality.lastDayMaxNH3N.toFixed(2);			
	       realConductivity=waterquality.realConductivity==null||waterquality.realConductivity==0?"-":waterquality.realConductivity.toFixed(2);		
	       lastDayMaxConductivity=waterquality.lastDayMaxConductivity==null||waterquality.lastDayMaxConductivity==0?"-":waterquality.lastDayMaxConductivity.toFixed(2);		
	       lastDayMinConductivity=waterquality.lastDayMinConductivity==null||waterquality.lastDayMinConductivity==0?"-":waterquality.lastDayMinConductivity.toFixed(2);		
		   realcr6=waterquality.realcr6==null||waterquality.realcr6==0?"-":waterquality.realcr6.toFixed(3);		
	       lastDayMaxCr6=waterquality.lastDayMaxCr6==null||waterquality.lastDayMaxCr6==0?"-":waterquality.lastDayMaxCr6.toFixed(2);		
	       lastDayMinCr6=waterquality.lastDayMinCr6==null||waterquality.lastDayMinCr6==0?'-':waterquality.lastDayMinCr6.toFixed(2);	
	       realTemp=waterquality.realTemp==null||waterquality.realTemp==0?"-":waterquality.realTemp.toFixed(2);	
	       lastDayMaxTemp=waterquality.lastDayMaxTemp==null||waterquality.lastDayMaxTemp==0?"-":waterquality.lastDayMaxTemp.toFixed(2);		
	       lastDayMinTemp=waterquality.lastDayMinTemp==null||waterquality.lastDayMinTemp==0?'-':waterquality.lastDayMinTemp.toFixed(2);
	       realDo=waterquality.realDo==null?"-":waterquality.realDo.toFixed(2);	
	       lastDayMaxDo=waterquality.lastDayMaxDo==null||waterquality.lastDayMaxDo==0?"-":waterquality.lastDayMaxDo.toFixed(2);		
	       lastDayMinDo=waterquality.lastDayMinDo==null||waterquality.lastDayMinDo==0?'-':waterquality.lastDayMinDo.toFixed(2);
	       */
	      }else{
			 realPh="-";							
	       lastDayMinPh="-";			
	       lastDayMaxPh="-";			
	       realCod="-";						
	       lastDayMinCod="-";			
	       lastDayMaxCod="-";			
	       realNH3N="-";						
	       lastDayMinNH3N="-";			
	       lastDayMaxNH3N="-";			
	       realConductivity="-";		
	       lastDayMaxConductivity="-";		
	       lastDayMinConductivity="-";		
		   realcr6="-";		
	       lastDayMaxCr6="-";		
	       lastDayMinCr6="-";	
	       realTemp="-";	
	       lastDayMaxTemp="-";	
	       lastDayMinTemp="-";
	       realDo="-";
	       lastDayMaxDo="-";		
	       lastDayMinDo="-";
		 }
    		
    		var th7="<th align='center' style='font-family: 黑体;font-size: 16px;'>PH值</th>";
				th7+=" <th style='color: #0071BC;' align='center'>"+realPh+"</th>";	
				th7+=" <th style='color: red;' align='center'>"+lastDayMaxPh+"</th>";
				th7+=" <th style='color: red;' align='center'>"+lastDayMinPh+"</th>";
				th7+=" <th style='color: red;' align='center'>-</th>";
		  $th7 = $(th7);
           //清除数据
           $("#PH").empty();
           //添加td
    		$("#PH").append($th7);
    		
    		var th8="<th align='center' style='font-family: 黑体;font-size: 16px;'>电导率(μS/cm)</th>";
				th8+=" <th style='color: #0071BC;' align='center'>"+realConductivity+"</th>";	
				th8+=" <th style='color: red;' align='center'>"+lastDayMaxConductivity+"</th>";
				th8+=" <th style='color: red;' align='center'>"+lastDayMinConductivity+"</th>";
				th8+=" <th style='color: red;' align='center'>-</th>";
		  $th8 = $(th8);
           //清除数据
           $("#realConductivity").empty();
           //添加td
    		$("#realConductivity").append($th8);
    		
    		
    		var th9="<th align='center' style='font-family: 黑体;font-size: 16px;'>COD(mg/l)</th>";
				th9+=" <th style='color: #0071BC;' align='center'>"+(realCod==null?'-':realCod)+"</th>";	
				th9+=" <th style='color: red;' align='center'>"+lastDayMaxCod+"</th>";
				th9+=" <th style='color: red;' align='center'>"+lastDayMinCod+"</th>";
				th9+=" <th style='color: red;' align='center'>-</th>";
		  $th9 = $(th9);
           //清除数据
           $("#realCod").empty();
           //添加td
    		$("#realCod").append($th9);
    		
    		
    		var th10="<th align='center' style='font-family: 黑体;font-size: 16px;'>氨氮(mg/l)</th>";
				th10+=" <th style='color: #0071BC;' align='center'>"+realNH3N+"</th>";	
				th10+=" <th style='color: red;' align='center'>"+lastDayMaxNH3N+"</th>";
				th10+=" <th style='color: red;' align='center'>"+lastDayMinNH3N+"</th>";
				th10+=" <th style='color: red;' align='center'>-</th>";
		  $th10 = $(th10);
           //清除数据
           $("#realNH3N").empty();
           //添加td
    		$("#realNH3N").append($th10);
    		
    		
    		
    		var th11="<th align='center' style='font-family: 黑体;font-size: 16px;'>六价铬(mg/l)</th>";
				th11+=" <th style='color: #0071BC;' align='center'>"+realcr6+"</th>";	
				th11+=" <th style='color: red;' align='center'>"+lastDayMaxCr6+"</th>";
				th11+=" <th style='color: red;' align='center'>"+lastDayMinCr6+"</th>";
				th11+=" <th style='color: red;' align='center'>-</th>";
		  $th11 = $(th11);
           //清除数据
           $("#cr6").empty();
           //添加td
    		$("#cr6").append($th11);
    		
    	/*	var thh11="<th align='center' style='font-family: 黑体;font-size: 16px;'>温度(℃)</th>";
				thh11+=" <th style='color: blue;' align='center'>"+realTemp+"</th>";	
				thh11+=" <th style='color: red;' align='center'>"+lastDayMaxTemp+"</th>";
				thh11+=" <th style='color: red;' align='center'>"+lastDayMinTemp+"</th>";
				thh11+=" <th style='color: red;' align='center'>-</th>";
		  $thh11 = $(thh11);
           清除数据           $("#temp").empty();
           添加td    		$("#temp").append($thh11);
    		
    		var thh22="<th align='center' style='font-family: 黑体;font-size: 16px;'>溶解氧(mg/l)</th>";
				thh22+=" <th style='color: blue;' align='center'>"+realDo+"</th>";	
				thh22+=" <th style='color: red;' align='center'>"+lastDayMaxDo+"</th>";
				thh22+=" <th style='color: red;' align='center'>"+lastDayMinDo+"</th>";
				thh22+=" <th style='color: red;' align='center'>-</th>";
		  $thh22 = $(thh22);
           清除数据           $("#Do").empty();
           添加td    		$("#Do").append($thh22);*/
    		//console.log(pollutantss)
    		if(pollutantss!=null){
    			
    			if(pollutantss.realcod!=null&&pollutantss.mincod!=null&&pollutantss.maxcod!=null){
    				 if(pollutantss.realcod==0&&pollutantss.mincod==0&&pollutantss.maxcod==0){
    					 var realcod='-';
	                    var mincod='-'; //	
	                     var maxcod='-'; //
    				 }else{
    				var realcod=pollutantss.realcod.toFixed(2);	
	                var mincod=pollutantss.mincod.toFixed(2);	
	               var maxcod=pollutantss.maxcod.toFixed(2);
    				 }
    			 }else{
    				     	var realcod='-';
	                    var mincod='-'; //	
	                     var maxcod='-'; //
    			 }
    			if(pollutantss.realtoc!=null&&pollutantss.mintoc!=null&&pollutantss.maxtoc!=null){
    				 if(pollutantss.realtoc==0&&pollutantss.mintoc==0&&pollutantss.maxtoc==0){
    					 var realtoc='-';
	                    var mintoc='-'; //	
	                     var maxtoc='-'; //
    				 }else{
    				var realtoc=pollutantss.realtoc.toFixed(2);   //有机碳
	                var mintoc=pollutantss.mintoc.toFixed(2);   //有机碳
	              var maxtoc=pollutantss.maxtoc.toFixed(2);   //有机碳
    				 }
    			 }else{
    				      var realtoc='-';
	                    var mintoc='-'; //	
	                     var maxtoc='-'; //
    			 }
    			if(pollutantss.realbod!=null&&pollutantss.minbod!=null&&pollutantss.maxbod!=null){
    				 if(pollutantss.realbod==0&&pollutantss.minbod==0&&pollutantss.maxbod==0){
    					 var realbod='-';
	                    var minbod='-'; //	
	                     var maxbod='-'; //
    				 }else{
    				var realbod=pollutantss.realbod.toFixed(2);   //有机碳
	                var minbod=pollutantss.minbod.toFixed(2);   //有机碳
	              var maxbod=pollutantss.maxbod.toFixed(2);   //有机碳
    				 }
    			 }else{
    				      var realbod='-';
	                    var minbod='-'; //	
	                     var maxbod='-'; //
    			 }
    			if(pollutantss.realnh4!=null&&pollutantss.minnh4!=null&&pollutantss.maxnh4!=null){
    				 if(pollutantss.realnh4==0&&pollutantss.minnh4==0&&pollutantss.maxnh4==0){
    					 var realnh4='-';
	                    var minnh4='-'; //	
	                     var maxnh4='-'; //
    				 }else{
    				var realnh4=pollutantss.realnh4.toFixed(2);   //有机碳
	                var minnh4=pollutantss.minnh4.toFixed(2);   //有机碳
	              var maxnh4=pollutantss.maxnh4.toFixed(2);   //有机碳
    				 }
    			 }else{
    				      var realnh4='-';
	                    var minnh4='-'; //	
	                     var maxnh4='-'; //
    			 }
    			if(pollutantss.realmlss!=null&&pollutantss.minmlss!=null&&pollutantss.maxmlss!=null){
    				 if(pollutantss.realmlss==0&&pollutantss.minmlss==0&&pollutantss.maxmlss==0){
    					 var realmlss='-';
	                    var minmlss='-'; //	
	                     var maxmlss='-'; //
    				 }else{
    				var realmlss=pollutantss.realmlss.toFixed(2);   //有机碳
	                var minmlss=pollutantss.minmlss.toFixed(2);   //有机碳
	              var maxmlss=pollutantss.maxmlss.toFixed(2);   //有机碳
    				 }
    			 }else{
    				      var realmlss='-';
	                    var minmlss='-'; //	
	                     var maxmlss='-'; //
    			 }
    			if(pollutantss.realphosphor!=null&&pollutantss.maxphosphor!=null&&pollutantss.minphosphor!=null){
    				 if(pollutantss.realphosphor==0&&pollutantss.maxphosphor==0&&pollutantss.minphosphor==0){
    					 var realphosphor='-';
	                    var maxphosphor='-'; //	
	                     var minphosphor='-'; //
    				 }else{
    				var realphosphor=pollutantss.realphosphor.toFixed(2);   //有机碳
	                var maxphosphor=pollutantss.maxphosphor.toFixed(2);   //有机碳
	              var minphosphor=pollutantss.minphosphor.toFixed(2);   //有机碳
    				 }
    			 }else{
    				      var realphosphor='-';
	                    var maxphosphor='-'; //	
	                     var minphosphor='-'; //
    			 }
	
   /**
    * var realcod=pollutantss.realcod==null||pollutantss.realcod==0?'-':pollutantss.realcod.toFixed(2);
	var realtoc=pollutantss.realtoc==null||pollutantss.realtoc==0?'-':pollutantss.realtoc.toFixed(2);   //有机碳
	var realbod=pollutantss.realbod==null||pollutantss.realbod==0?'-':pollutantss.realbod.toFixed(2);//需氧量
	var realnh4=pollutantss.realnh4==null||pollutantss.realnh4==0?'-':pollutantss.realnh4.toFixed(2);
	var realmlss=pollutantss.realmlss==null||pollutantss.realmlss==0?'-':pollutantss.realmlss.toFixed(2);//污泥浓度
    var mincod=pollutantss.mincod==null||pollutantss.mincod==0?'-':pollutantss.mincod.toFixed(2);
	var mintoc=pollutantss.mintoc==null||pollutantss.mintoc==0?'-':pollutantss.mintoc.toFixed(2);   //有机碳
	var minbod=pollutantss.minbod==null||pollutantss.minbod==0?'-':pollutantss.minbod.toFixed(2);//需氧量
	var minnh4=pollutantss.minnh4==null||pollutantss.minnh4==0?'-':pollutantss.minnh4.toFixed(2);
	var minmlss=pollutantss.minmlss==null||pollutantss.minmlss==0?'-':pollutantss.minmlss.toFixed(2);//污泥浓度
	var maxcod=pollutantss.maxcod==null||pollutantss.maxcod==0?'-':(pollutantss.maxcod).toFixed(2);
	var maxtoc=pollutantss.maxtoc==null||pollutantss.maxtoc==0?'-':pollutantss.maxtoc.toFixed(2);   //有机碳
	var maxbod=pollutantss.maxbod==null||pollutantss.maxbod==0?'-':pollutantss.maxbod.toFixed(2);//需氧量
	var maxnh4=pollutantss.maxnh4==null||pollutantss.maxnh4==0?'-':pollutantss.maxnh4.toFixed(2);
	var maxmlss=pollutantss.maxmlss==null||pollutantss.maxmlss==0?'-':pollutantss.maxmlss.toFixed(2);//污泥浓度
	*/
    		}else{
    			var realcod='-';
				var realtoc='-'; //有机碳
				var realbod='-';//需氧量
				var realnh4='-';
				var realmlss='-';//污泥浓度
				var mincod='-'; //
				var mintoc='-'; //
				var minbod='-'; //
				var minnh4='-'; 
				var minmlss='-'; //
				var maxcod='-'; //
				var maxtoc='-'; //
				var maxbod='-';
				var maxnh4='-'; //
				var maxmlss='-';//
		     	var realphosphor='-';
	                    var maxphosphor='-'; //	
	                     var minphosphor='-'; //
    		}
    	var th77="<th align='center' style='font-family: 黑体;font-size: 16px;'>COD(mg/l)</th>";
				th77+=" <th style='color: #0071BC;' align='center'>"+realcod+"</th>";	
				th77+=" <th style='color: red;' align='center'>"+maxcod+"</th>";
				th77+=" <th style='color: red;' align='center'>"+mincod+"</th>";
				th77+=" <th align='center'>-</th>";
		  $th77 = $(th77);
           //清除数据
           $("#COD").empty();
           //添加td
    		$("#COD").append($th77);
    		
    		/**var th88="<th align='center' style='font-family: 黑体;font-size: 16px;'>TOC(mg/l)</th>";
				th88+=" <th style='color: blue;' align='center'>"+realtoc+"</th>";	
				th88+=" <th style='color: red;' align='center'>"+maxtoc+"</th>";
				th88+=" <th style='color: red;' align='center'>"+mintoc+"</th>";
				th88+=" <th align='center'>-</th>";
		  $th88 = $(th88);
           //清除数据
           $("#TOC").empty();
           //添加td
    		$("#TOC").append($th88);
    		
    		
    		var th99="<th align='center' style='font-family: 黑体;font-size: 16px;'>BOD(mg/l)</th>";
				th99+=" <th style='color: blue;' align='center'>"+realbod+"</th>";	
				th99+=" <th style='color: red;' align='center'>"+maxbod+"</th>style='color: blue;'";
				th99+=" <th style='color: red;' align='center'>"+minbod+"</th>";
				th99+=" <th align='center'>-</th>";
		  $th99 = $(th99);
           //清除数据
           $("#BOD").empty();
           //添加td
    		$("#BOD").append($th99);
    		*/
    		
    		var th100="<th align='center' style='font-family: 黑体;font-size: 16px;'>氨氮(mg/l)</th>";
				th100+=" <th style='color: #0071BC;' align='center'>"+realnh4+"</th>";	
				th100+=" <th style='color: red;' align='center'>"+maxnh4+"</th>";
				th100+=" <th style='color: red;' align='center'>"+minnh4+"</th>";
				th100+=" <th align='center'>-</th>";
		  $th100 = $(th100);
           //清除数据
           $("#NH4").empty();
           //添加td
    		$("#NH4").append($th100);
    		
    		
    		
    		var th111="<th align='center' style='font-family: 黑体;font-size: 16px;'>固体悬浮物(mg/l)</th>";
				th111+=" <th style='color: #0071BC;' align='center'>"+realmlss+"</th>";	
				th111+=" <th style='color: red;' align='center'>"+maxmlss+"</th>";
				th111+=" <th style='color: red;' align='center'>"+minmlss+"</th>";
				th111+=" <th align='center'>-</th>";
		  $th111 = $(th111);
           //清除数据
           $("#mlss").empty();
           //添加td
    		$("#mlss").append($th111);
    		var thp="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>总磷(mg/l)</th>";
				thp+=" <th style='color: #0071BC;' align='center' class='font_num'>"+realphosphor+"</th>";	
				thp+=" <th style='color: red;' align='center' class='font_num'>"+maxphosphor+"</th>";
				thp+=" <th style='color: red;' align='center' class='font_num'>"+minphosphor+"</th>";
				thp+=" <th align='center'>-</th>";
		  $thp = $(thp);
           //清除数据
           $("#phosphor").empty();
           //添加td
    		$("#phosphor").append($thp);
    	
    		 var s3 = document.getElementsByTagName("table")[2]; //获取水质表格   
 	          for(var i=0;i<s3.rows.length;i++){  
 	        	var dataValue=s3.rows[i].cells[1].innerHTML;//获取每行的第二列数据
 	        	if(dataValue =='-'){
 	        		s3.rows[i].style.display= "none";//隐藏数据为NULL的行
 	        	}
 	        }  
    		
    		
    		if(sam1!=null){
	var strTime1=sam1.strTime==null?"-":sam1.strTime;						//字符时间
	var samplingWater1=sam1.samplingWater==null?"-":sam1.samplingWater;		//采样水量
	var samplingPh1=sam1.samplingPh==null?"-":sam1.samplingPh;			//采样PH
	var samplingCapNum1=sam1.samplingCapNum==null?"-":sam1.samplingCapNum;//采样杯号
	//var samplingMode1=sam1.samplingMode==null?"-":sam1.samplingMode;		//采样模式
    	}	else{
    		
    		var strTime1="-";						//字符时间
	var samplingWater1="-";		//采样水量
	var samplingPh1="-";			//采样PH
	var samplingCapNum1="-";//采样杯号
    	}
    		if(sam2!=null){
    var strTime2=sam2.strTime==null?"-":sam2.strTime;						//字符时间
	var samplingWater2=sam2.samplingWater==null?"-":sam2.samplingWater;		//采样水量
	var samplingPh2=sam2.samplingPh==null?"-":sam2.samplingPh;			//采样PH
	var samplingCapNum2=sam2.samplingCapNum==null?"-":sam2.samplingCapNum;//采样杯号
	//var samplingMode2=sam2.samplingMode==null?"-":sam2.samplingMode;		//采样模式
    	}else{
    		
    		var strTime2="-";						//字符时间
	var samplingWater2="-";		//采样水量
	var samplingPh2="-";			//采样PH
	var samplingCapNum2="-";//采样杯号
    	}
    	
	if(sam3!=null){
    var strTime3=sam3.strTime==null?"-":sam3.strTime;						//字符时间
	var samplingWater3=sam3.samplingWater==null?"-":sam3.samplingWater;		//采样水量
	var samplingPh3=sam3.samplingPh==null?"-":sam3.samplingPh;			//采样PH
	var samplingCapNum3=sam3.samplingCapNum==null?"-":sam3.samplingCapNum;//采样杯号
	//var samplingMode3=sam3.samplingMode==null?"-":sam3.samplingMode;		//采样模式
    }	else{
    		
    		var strTime3="-";						//字符时间
	var samplingWater3="-";		//采样水量
	var samplingPh3="-";			//采样PH
	var samplingCapNum3="-";//采样杯号
    	}
    	
	if(sam4!=null){
     var strTime4=sam4.strTime==null?"-":sam4.strTime;						//字符时间
	var samplingWater4=sam4.samplingWater==null?"-":sam4.samplingWater;		//采样水量
	var samplingPh4=sam4.samplingPh==null?"-":sam4.samplingPh;			//采样PH
	var samplingCapNum4=sam4.samplingCapNum==null?"-":sam4.samplingCapNum;//采样杯号
	//var samplingMode4=sam4.samplingMode==null?"-":sam4.samplingMode;		//采样模式
    }	else{
    		
    		var strTime4="-";						//字符时间
	var samplingWater4="-";		//采样水量
	var samplingPh4="-";			//采样PH
	var samplingCapNum4="-";//采样杯号
    	}
    	
	          th12="<th align='center'>"+strTime1+"</th>";
				th12+=" <th style='color: blue;' align='center'>"+samplingWater1+"</th>";	
				th12+=" <th style='color: blue;' align='center'>"+samplingPh1+"</th>";
				th12+=" <th style='color: blue;' align='center'>"+samplingCapNum1+"</th>";
				th12+=" <th align='center'>手动采样</th>";
		  $th12 = $(th12);
           //清除数据
           $("#sam1").empty();
           //添加td
    		$("#sam1").append($th12);
    		th13="<th align='center'>"+strTime2+"</th>";
				th13+=" <th style='color: #0071BC;' align='center'>"+samplingWater2+"</th>";	
				th13+=" <th style='color: #0071BC;' align='center'>"+samplingPh2+"</th>";
				th13+=" <th style='color: #0071BC;' align='center'>"+samplingCapNum2+"</th>";
				th13+=" <th align='center'>自动采样</th>";
		  $th13 = $(th13);
           //清除数据
           $("#sam2").empty();
           //添加td
    		$("#sam2").append($th13);
    		
    		th14="<th align='center'>"+strTime3+"</th>";
				th14+=" <th style='color: #0071BC;' align='center'>"+samplingWater3+"</th>";	
				th14+=" <th style='color: #0071BC;' align='center'>"+samplingPh3+"</th>";
				th14+=" <th style='color: #0071BC;' align='center'>"+samplingCapNum3+"</th>";
				th14+=" <th align='center'>报警采样</th>";
		  $th14 = $(th14);
           //清除数据
           $("#sam3").empty();
           //添加td
    		$("#sam3").append($th14);
    		
    		th15="<th align='center'>"+strTime4+"</th>";
				th15+=" <th style='color: #0071BC;' align='center'>"+samplingWater4+"</th>";	
				th15+=" <th style='color: #0071BC;' align='center'>"+samplingPh4+"</th>";
				th15+=" <th style='color: #0071BC;' align='center'>"+samplingCapNum4+"</th>";
				th15+=" <th align='center'>远程采样</th>";
		  $th15 = $(th15);
           //清除数据
           $("#sam4").empty();
           //添加td
    		$("#sam4").append($th15);
    	
    	if(ztraffic!=null){	
    var supplyIndustrial1=ztraffic.supplyIndustrial==null?'-':ztraffic.supplyIndustrial.toFixed(1);		//工业给水
	var supplyLiving1=ztraffic.supplyLiving==null?'-':ztraffic.supplyLiving.toFixed(1);			//生活给水
	var drainageIndustrial1=ztraffic.drainageIndustrial==null?'-':ztraffic.drainageIndustrial.toFixed(1);//工业排水
	var lossLimit1=ztraffic.lossLimit==null?'-':ztraffic.lossLimit.toFixed(1);         //损耗限值
	var unknown1=ztraffic.unknown==null?'-':ztraffic.unknown.toFixed(1);          //不明
	var lossAmount1=ztraffic.lossAmount==null?'-':ztraffic.lossAmount.toFixed(1);//损耗值
       }else{
    var supplyIndustrial1='-';		//工业给水
	var supplyLiving1='-';			//生活给水
	var drainageIndustrial1='-';//工业排水
	var lossLimit1='-';         //损耗限值
	var unknown1='-';          //不明
	var lossAmount1='-';//损耗值
       } 
	                var th16="   <th align='center' style='font-family: 黑体;font-size: 16px;'>数值</th>";
					th16+="	<th style='color: #0071BC;' align='center'>"+supplyIndustrial1+"</th>";
					th16+="	<th style='color: #0071BC;' align='center'>"+supplyLiving1+"</th>";
					th16+="	<th  id='id_02'style='color: #0071BC;' align='center'>"+drainageIndustrial1+"</th>";
					th16+="	<th style='color: red;' align='center'>-</th>";
					th16+="	<th style='color: red;' align='center'>"+lossLimit1+"</th>";
					th16+="	<th style='color: red;' align='center'>"+lossAmount1+"</th>";
					th16+="	<th style='color: red;' align='center'>"+unknown1+"</th>";
	
	  $th16 = $(th16);
           //清除数据
           $("#ztraffic").empty();
           //添加td
    		$("#ztraffic").append($th16);
	//console.log(ztraffic2)
	if(ztraffic2!=null){	
    		var supplyIndustrial2=ztraffic2.supplyIndustrial==null?'-':ztraffic2.supplyIndustrial.toFixed(2);		//工业给水
	var supplyLiving2=ztraffic2.supplyLiving==null?'-':ztraffic2.supplyLiving.toFixed(2);			//生活给水
	var drainageIndustrial2=ztraffic2.drainageIndustrial==null?'-':ztraffic2.drainageIndustrial.toFixed(2);//工业排水
	var drainageLiving2=ztraffic2.drainageLiving==null?'-':ztraffic2.drainageLiving.toFixed(2);		//生活排水
	var lossLimit2=ztraffic2.lossLimit==null?'-':ztraffic2.lossLimit.toFixed(2);         //损耗限值
	var unknown2=ztraffic2.unknown==null?'-':ztraffic2.unknown.toFixed(2);          //不明
	var lossAmount2=ztraffic2.lossAmount==null?'-':ztraffic2.lossAmount.toFixed(2);//损耗值
	
	 }else{
    var supplyIndustrial2='-';		//工业给水
	var supplyLiving2='-';			//生活给水
	var drainageIndustrial2='-';//工业排水
	var lossLimit2='-';         //损耗限值
	var unknown2='-';          //不明
	var lossAmount2='-';//损耗值
       } 
	
	
	 var th17="   <th align='center' style='font-family: 黑体;font-size: 16px;'>流量系数</th>";
					th17+="	<th style='color: red;' align='center'>"+supplyIndustrial2+"</th>";
					th17+="	<th style='color: red;' align='center'>"+supplyLiving2+"</th>";
					th17+="	<th style='color: red;' align='center'>"+drainageIndustrial2+"</th>";
					th17+="	<th style='color: red;' align='center'>-</th>";
					th17+="	<th style='color: red;' align='center'>"+lossLimit2+"</th>";
					th17+="	<th style='color: red;' align='center'>"+lossAmount2+"</th>";
					th17+="	<th style='color: red;' align='center'>"+unknown2+"</th>";
	
	  $th17 = $(th17);
           //清除数据
           $("#ztraffic2").empty();
           //添加td
    		$("#ztraffic2").append($th17);
	
    		var companyStand=companyconfig.companyStand==null?'-':companyconfig.companyStand;			//人均标准用水
	        var perCaoitaWater=companyconfig.perCaoitaWater==null?'-':companyconfig.perCaoitaWater;//人均用水限值
	        var consumptionCoefficient=companyconfig.consumptionCoefficient==null?'-':companyconfig.consumptionCoefficient;		//消耗系数
      		
    		         var th18="     <th align='center'style='font-family: 黑体;font-size: 16px;'>条件参数</th>";
						th18+="<th style='color: green;' align='center'>"+companyStand+"</th>";
						th18+="<th style='color: green;' align='center'>"+perCaoitaWater+"</th>";
						th18+="<th style='color: green;' align='center'>"+consumptionCoefficient+"</th>";
						th18+="<th align='left'>2、损耗系数K：指水在输送、使用、污水净化处理过程中因泄漏、蒸发以及通过工业废渣等因素而损耗的水量与给水总量的比例关系。 建议K＝0.10～0.15。</th>";
					
    		$th18 = $(th18);
           //清除数据
           $("#com").empty();
           //添加td
    		$("#com").append($th18);
    		

    		
    		
    		
		},
		error:function(){
		   
		} ,
		complete: function (XHR, TS) { XHR = null } 
			
   })
}


function  load_data2(rid){
	   $.ajax({
          url:"../data/doGet3?rid="+rid,
		type:"post",
		async: true,
		dataType:"json",
		success:function(result){
		  var list=result.list;
		  var keystate= list[0];
		   var logs= list[1];
		   var pollutants=list[2];
		     var time_id= keystate[0].strTime;
	      var time_is= keystate[2].strTime;
	       var time_ls= keystate[1].strTime;
		   if(time_id!=undefined&&time_id!=null){
			 $("#id_key").show(); 
			 //  alert('离线时间:'+time_id)
			 $("#id_key").val(time_id)
		  }
		   if(time_ls!=undefined&&time_ls!=null){
			 $("#ls_key").show(); 
			//  alert('离线时间:'+time_ls)
             $("#ls_key").val(time_ls) 
		  }
		   if(time_is!=undefined&&time_is!=null){
			 $("#is_key").show(); 
			 $("#is_key").val(time_is)
			//   alert('离线时间:'+time_is)
		  }
		   
		    $("#log").empty();

		    for(i=0;i<logs.length;i++){
		    	console.log(logs[i])
		    	var log="<tr><th   align='center' '>"+logs[i].updataTime+"</th>";
				log+="  <th  style='color: #0071BC;' align='center'>"+logs[i].userName+"</th>";
				log+="  <th  style='color: #0071BC;' align='center'>"+logs[i].userIp+"</th>";
				log+="  <th  style='color: #0071BC;' align='center'>"+logs[i].companyName+"</th>";
				log+="  <th  style='color: #0071BC;' align='center'>"+logs[i].describe+"</th></tr>";
				 $log = $(log);
           //添加td
    		$("#log").append($log);
		    }
		   
		   
		     		
    		//污染物排放
    		if(pollutants!=null){
    		    //var strTime=pollutants.strTime;
				var cod=pollutants.cod;
				var toc=pollutants.toc; //有机碳
				var bod=pollutants.bod;//需氧量
				var nh4=pollutants.nh4;
				var mlss=pollutants.mlss;//污泥浓度
				var Cr=pollutants.cr; //铬
				var cr6=pollutants.cr6; //六价铬
				var Ni=pollutants.ni; //镍
				var Cd=pollutants.cd; //镉
				var lead=pollutants.lead; //铅
				var silver=pollutants.silver; //银
				var Hg=pollutants.hg; //汞
				var phosphor=pollutants.phosphor;//磷
				var Cu=pollutants.cu; //铜
				var Zn=pollutants.zn;//锌
				var prussiate=pollutants.prussiate; //氰化物
    		}else{
    			var cod=null;
				var toc=null; //有机碳
				var bod=null;//需氧量
				var nh4=null;
				var mlss=null;//污泥浓度
				var Cr=null; //铬
				var cr6=null; //六价铬
				var Ni=null; //镍
				var Cd=null; //镉
				var lead=null; //铅
				var silver=null; //银
				var Hg=null; //汞
				var phosphor=null;//磷
				var Cu=null; //铜
				var Zn=null;//锌
				var prussiate=null; //氰化物
    		}
	        
	        var list1 = [];
	        var list2 = [];
	        var list3 = [];
	        var list4 = [];
	        
	         for(var i=0;i<10;i++){
	        	if(cod!=null&&cod!=0){
	        		list3[i]='COD';
	        	    list4[i]=cod.toFixed(3);
	        		cod=null;
	        		continue
	        	}
	        	if(toc!=null&&toc!=0){
	        		list3[i]='TOC';
	        		list4[i]=toc.toFixed(3);
	        		toc=null;
	        		continue
	        	}
	        	if(bod!=null&&bod!=0){
	        		list3[i]='BOD';
	        		list4[i]=bod.toFixed(3);
	        		bod=null;
	        		continue
	        	}
	        	if(nh4!=null&&nh4!=0){
	        		list3[i]='氨氮';
	        		list4[i]=nh4.toFixed(3);
	        		nh4=null;
	        		continue
	        	}
	        	if(mlss!=null&&mlss!=0){
	        		list3[i]='固体悬浮物';
	        		list4[i]=mlss.toFixed(3);
	        		mlss=null;
	        		continue
	        	}
	        	if(phosphor!=null&&phosphor!=0){
	        		list3[i]='总磷';
	        		list4[i]=phosphor.toFixed(3);
	        		phosphor=null;
	        		continue
	        	}
	        	if(Cu!=null&&Cu!=0){
	        		list3[i]='总铜';
	        		list4[i]=Cu.toFixed(3);
	        		Cu=null;
	        		continue
	        	}
	        	if(Zn!=null&&Zn!=0){
	        		list3[i]='总锌';
	        		list4[i]=Zn.toFixed(3);
	        		Zn=null;
	        		continue
	        	}
	        	
	        	if(prussiate!=null&&prussiate!=0){
	        		list3[i]='总氰化物';
	        		list4[i]=prussiate.toFixed(3);
	        		prussiate=null;
	        		continue
	        	}
	        	
	        	}
	        	for(var i=0;i<10;i++){
	        	if(Cr!=null&&Cr!=0){
	        		list1[i]='总铬';
	        		list2[i]=Cr.toFixed(3);
	        		Cr=null;
	        		continue
	        	}
	        	if(cr6!=null&&cr6!=0){
	        		list1[i]='六价铬';
	        		list2[i]=cr6.toFixed(3);
	        		cr6=null;
	        		continue
	        	}
	        	if(Ni!=null&&Ni!=0){
	        		list1[i]='总镍';
	        		list2[i]=Ni.toFixed(3);
	        		Ni=null;
	        		continue
	        	}
	        	if(Cd!=null&&Cd!=0){
	        		list1[i]='总镉';
	        		list2[i]=Cd.toFixed(3);
	        		Cd=null;
	        		continue
	        	}
	        	if(lead!=null&&lead!=0){
	        		list1[i]='总铅';
	        		list2[i]=lead.toFixed(3);
	        		lead=null;
	        		continue
	        	}
	        	if(silver!=null&&silver!=0){
	        		list1[i]='总银';
	        		list2[i]=silver.toFixed(3);
	        		silver=null;
	        		continue
	        	}
	        	if(Hg!=null&&Hg!=0){
	        		list1[i]='总汞';
	        		list2[i]=Hg.toFixed(3);
	        		Hg=null;
	        		continue
	        	}
	        	}
	        	
	        
	        
      		
      		var th19="<th width='12%' style='font-family: 黑体;font-size: 16px;'>一类污染物名称</th>";
      		 var th20="<th width='12%' style='font-family: 黑体;font-size: 16px;'>排放总量(kg)</th>";
      		 var th23="<th width='12%' style='font-family: 黑体;font-size: 16px;'>平均浓度(mg/l)</th>";
      		 var th21="<th width='12%' style='font-family: 黑体;font-size: 16px;'>二类污染物名称</th>";
      		 var th22="<th width='12%' style='font-family: 黑体;font-size: 16px;'>排放总量(kg)</th>";
      		 var th24="<th width='12%' style='font-family: 黑体;font-size: 16px;'>平均浓度(mg/l)</th>";
      		 
      		  var id_ztraffic=$("#id_01").html();
      		  var drainageIndustrial1=$("#id_02").html();
      		  
      		 if(drainageIndustrial1!='-'){
      		var id_ztr=drainageIndustrial1
      		 }else{
      		var 	id_ztr=id_ztraffic 
      		 }
      		 
      		for(var i=0;i<8;i++){
      		       if(list1.length>0){
      	        	if(i>=list1.length){
      	        	var 	name=" ";
      	        	var	value=" "
      	        		var avg=""
      	        	}else{
      	        	var	name=list1[i];
      	        	var	value=list2[i];
      	        	var avg=((value*1000)/id_ztr).toFixed(3);
      	        	}
      	        	}else{
      	        	var name=" ";
      	        	var	value=" "
      	        	var avg=""
      	        	}
						th19+="<th width='12.5%' style='font-family: 黑体;font-size: 16px;'>"+name+"</th>";
						$th19 = $(th19);
           //清除数据
           $("#pollname").empty();
           //添加td
    		$("#pollname").append($th19);
    		
    		
						th20+="<th style='color: red;' width='12.5%' style='font-family: 黑体;font-size: 16px;'>"+value+"</th>";
      	      $th20 = $(th20);
      	      
						//清除数据
           $("#pollvalue").empty();
           //添加td
    		$("#pollvalue").append($th20);
    		
    		th23+="<th style='color: red;' width='12.5%' style='font-family: 黑体;font-size: 16px;'>"+avg+"</th>";
    		 $th23 = $(th23);
    		//清除数据
           $("#pollvalue_avg").empty();
           //添加td
    		$("#pollvalue_avg").append($th23);
    		        }
    		for(var i=0;i<8;i++){
      		     if(list3.length>0){
      	        	if(i>=list3.length){
      	        		
      	        	var	name=" ";
      	        	var	value=" ";
      	        	var avg="";
      	        	}else{
      	        	var	name=list3[i];
      	        	var	value=list4[i];
      	        	var avg=((value*1000)/id_ztraffic).toFixed(3);
      	        	}
      	        	}else{
      	        	var	name=" ";
      	        	var	value=" "
      	        		var avg="";
      	        	}
						th21+="<th  width='12.5%' style='font-family: 黑体;font-size: 16px;'>"+name+"</th>";
						$th21 = $(th21);
           //清除数据
           $("#pollname2").empty();
           //添加td
    		$("#pollname2").append($th21);
						th22+="<th style='color: red;' width='12.5%' style='font-family: 黑体;font-size: 16px;'>"+value+"</th>";
      	      $th22 = $(th22);
						//清除数据
           $("#pollvalue2").empty();
           //添加td
    		$("#pollvalue2").append($th22);
    		        
    		
    		th24+="<th style='color: red;' width='12.5%' style='font-family: 黑体;font-size: 16px;'>"+avg+"</th>";
    		 $th24 = $(th24);
    		//清除数据
           $("#pollvalue2_avg").empty();
           //添加td
    		$("#pollvalue2_avg").append($th24);
						
      		
    		}
    		
      		
		} ,
		complete: function (XHR, TS) { XHR = null } 
	   })
	   }



