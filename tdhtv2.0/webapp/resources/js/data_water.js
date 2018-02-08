

var drainageIndustrial1;
var id_ztraffic;
function  load_data_bt(rid){
	
	rid=75501330006
	
	   $.ajax({
          url:"../data/doGet_water?rid="+rid,
		type:"post",
		async: true,
		dataType:"json",
		success:function(result){
		   
			//console.log(result);
			 var list=result.list;
			  var data1= list[0];
			  var companyconfig= list[1];
			  var pollutantNames= list[2];
		 /* console.log(data1);
		  console.log(data2);
		  console.log(data3);*/
		  var obj = eval('(' + data1 + ')');
		//  console.log(data1)
		  var datas= obj.data;
		// console.log(obj);
		 var waterqualitys=obj.waterquality;
		  data=datas[0];
		  var pollutantss=waterqualitys[0];
		  
		  /*console.log(datas);*/
		  //console.log(data.id_waterlevel);
		   
		   
		 /* var pollutantss=obj.waterquality
		 var pollutant=pollutantss[0];*/
		 // var companyconfig= list[2];
		  /*var url= list[3];
		  var sam1=list[4];
		  var sam2=list[5];
		  var sam3=list[6];
		  var sam4=list[7];
		   var pollutantss=list[8];
		   var pollutantss=list[9];*/
		   var waterLevel1; var waterLevel2; var waterLevel3; var waterLevel4;//水位
			  var flowVelocity1;var flowVelocity2;var flowVelocity3;var flowVelocity4; //流速
			  var flowRate1; var flowRate2; var flowRate3; var flowRate4;//流量速率
			  var traffic1; var traffic2; var traffic3; var traffic4;//流量
			  var trafficLastDay1; var trafficLastDay2; var trafficLastDay3; var trafficLastDay4;//24小时流量速率
			  var voltage1;var voltage2;var voltage3;var voltage4;//电压
			  var sysState1;var sysState2;var sysState3;var sysState4;
			  
			   
		     // console.log(data)
		       var endTime
		      if(data!=null){
		      endTime=data.strTime;
		    //  console.log(endTime)
		      /* var s = endTime.split(".")
		             	//console.log(s)
			             endTime=s[0];*/
		             $("#endTime_bt").html("");	
				 $("#endTime_bt").append("截止时间："+endTime);
		      }
		    //   console.log(companyconfig.stratTime)
		      if(companyconfig!=null){
		    	  startTime=companyconfig.stratTime;
		    	 var s = startTime.split(".")
		             	//console.log(s)
			            var startTime=s[0];
		             $("#startTime_bt").html("");	
				 $("#startTime_bt").append("起始时间："+startTime);
				  startTime=startTime.replace(/-/g,"/");
				  endTime=endTime+"";
				  	endTime=endTime.replace(/-/g,"/");
				 //	alert(endTime)
				 var val = Date.parse(startTime);
				 var val2 = Date.parse(endTime);
				 
				   var startTime = new Date(val);
				var now =new Date(val2);
			
				
		   var s1 = startTime.getTime();
		   var s2 =now.getTime();
		  
		     
		     var total = (s2 - s1)/1000;
		      
		  var day = parseInt(total / (24*60*60));//计算整数天数
	      var afterDay = total - day*24*60*60;//取得算出天数后剩余的秒数
	      var hour = parseInt(afterDay/(60*60));//计算整数小时数
	      var afterHour = total - day*24*60*60 - hour*60*60;//取得算出小时数后剩余的秒数
	      var min = parseInt(afterHour/60);//计算整数分
	      var afterMin = total - day*24*60*60 - hour*60*60 - min*60;//取得算出分后剩余的秒数
	      $("#sub_time_bt").html("");
			$("#sub_time_bt").text(" 计量时间（日）:"+day+"天"+hour+"时"+min+"分") ;
		     
		     
		      }      
		      
		      var yes_ztraffic;
		         var  yes_a1;
		         var  yes_a2;
		         var  yes_a3;
		         var todayid;
			        var  todayid;
			         var todayis;
			        var  todayld;
		    //  console.log(pollutant)
		     if(data!=null){
		    	  id_waterLevel=data.id_waterlevel==null?"-":data.id_waterlevel;
				 
				 id_CurrentSpeed=data.id_CurrentSpeed==null?"-":data.id_CurrentSpeed;
				 id_traffic=data.id_traffic==null?"-":data.id_traffic;
				 id_ztraffic=data.id_ztraffic==null?"-":(data.id_ztraffic);
				 
                    is_waterLevel=data.is_waterlevel==null?"-":data.is_waterlevel;
				 
				 is_CurrentSpeed=data.is_CurrentSpeed==null?"-":data.is_CurrentSpeed;
				 is_traffic=data.is_traffic==null?"-":data.is_traffic;
				is_ztraffic=data.is_ztraffic==null?"-":(data.is_ztraffic);
				 
				 
				 yes_a1 =data.industrialdrainage==null?"-":data.industrialdrainage;
		    		//  yes_a2 =datass.livingsupply==null?"-":datass.livingsupply;
		    		  yes_a3 =data.industrialsupply==null?"-":data.industrialsupply;
				 
		    		// console.log(yes_a1) 
		    		  
		    		  todayid =data.id_sub_ztraffic==null?"-":data.id_sub_ztraffic;
		    		  todayis =data.is_sub_ztraffic==null?"-":data.is_sub_ztraffic;
		    		  
		    		  
		    		  drainage=data.basin;
		  	    	drainages=data.rivers;
		      }else{
		    	  id_waterLevel="-";
				 id_CurrentSpeed="-";
				 id_traffic="-";
			id_ztraffic="-";
				// id_key="-"
			var  yes_a1="-";
	         var  yes_a3="-";
			todayid="-";
	    	  todayis ="-"; 
	    	  is_waterLevel="-";
				 is_CurrentSpeed="-";
				 is_traffic="-";
			is_ztraffic="-";
			 drainage="-";
	  	    	drainages="-";
		      }
		      
			  
		      
		      
		      /*if(rid==75501330006){
		    	 if(datas!=null){
		    	  is_waterLevel=datas.waterlevel;
				 
				 is_CurrentSpeed=datas.is_CurrentSpeed;
				 is_traffic=datas.is_traffic;
				is_ztraffic=(datas.is_ztraffic/10000);
		      }else{
		    	  is_waterLevel="-";
				 is_CurrentSpeed="-";
				 is_traffic="-";
			is_ztraffic="-";
				// id_key="-"
				
		    	  
		      }
		      }
		      */
		   //   console.log(keystate)
		   
			   
			   
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
			// if(rid==75501330006){
				 var th1="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>水位(m)</th>";
					
					th1+=" <th style='color: blue;'class='font_num' align='center'>"+id_waterLevel+"</th>";
					th1+=" <th style='color: blue;'class='font_num' align='center'>"+is_waterLevel+"</th>";
			  $th1 = $(th1);
	           //清除数据
	           $("#waterLevel_bt").empty();
	           //添加td
	    		$("#waterLevel_bt").append($th1);
	    		
			  var th2="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>流速(m/s)</th>";
					th2+=" <th style='color: blue;'class='font_num' align='center'>"+id_CurrentSpeed+"</th>";	
					th2+=" <th style='color: blue;'class='font_num' align='center'>"+is_CurrentSpeed+"</th>";	
					
			  $th2 = $(th2);
	           //清除数据
	           $("#flowVelocity_bt").empty();
	           //添加td
	    		$("#flowVelocity_bt").append($th2);
	    		
			   var th3="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>流量速率(m<sup>3</sup>/s)</th>";
					
					th3+=" <th style='color: blue;'class='font_num' align='center'>"+id_traffic+"</th>";
					th3+=" <th style='color: blue;'class='font_num' align='center'>"+is_traffic+"</th>";
			  $th3 = $(th3);
	           //清除数据
	           $("#flowRate_bt").empty();
	           //添加td
	    		$("#flowRate_bt").append($th3);
			  
	    		var th6="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>总流量(万m<sup>3</sup>)</th>";
				
					th6+=" <th style='color: blue;'class='font_num' align='center'>"+id_ztraffic+"</th>";
					th6+=" <th style='color: blue;'class='font_num' align='center'>"+is_ztraffic+"</th>";
			  $th6 = $(th6);
	         //  清除数据          
	           $("#voltage_bt").empty();
	         //  添加td    		
	           $("#voltage_bt").append($th6);
	           
	           
	       	var th8s="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>昨日流量(m<sup>3</sup>)</th>";
			   // th6+=" <th style='color: blue;'class='font_num' align='center'>"+is_ztraffic+"</th>";
				th8s+=" <th style='color: blue;'class='font_num' align='center'>"+yes_a1+"</th>";
				th8s+=" <th style='color: blue;'class='font_num' align='center'>"+yes_a3+"</th>";
			
				var th9s="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>今日流量(m<sup>3</sup>)</th>";
				th9s+=" <th style='color: blue;'class='font_num' align='center'>"+todayid+"</th>";
				th9s+=" <th style='color: blue;'class='font_num' align='center'>"+todayis+"</th>";
				
				 $th8s = $(th8s);
	    //清除数据
	    $("#trafficLastDay_bt").empty();
	   
	    //添加td
			$("#trafficLastDay_bt").append($th8s);
			
			 $th9s = $(th9s);
	    //清除数据
	    $("#traffic_bt").empty();
			//添加td
			$("#traffic_bt").append($th9s);
			
	    	//	console.log(pollutantss)
	    	
	           	var th7="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>流域</th>";
				
					th7+=" <th colspan='2' style='color: blue;'class='font_num' align='center'>"+drainage+drainages+"</th>";
			  $th7 = $(th7);
	         //  清除数据          
	           $("#drainage_bt").empty();
	         //  添加td    		
	           $("#drainage_bt").append($th7);
	    	//	console.log(pollutantss)
			// }
	   /*else{
		      
			      var th1="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>水位(m)</th>";
					
					th1+=" <th style='color: blue;'class='font_num' align='center'>"+id_waterLevel+"</th>";
			  $th1 = $(th1);
	           //清除数据
	           $("#waterLevel").empty();
	           //添加td
	    		$("#waterLevel").append($th1);
	    		
			  var th2="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>流速(m/s)</th>";
					th2+=" <th style='color: blue;'class='font_num' align='center'>"+id_CurrentSpeed+"</th>";	
			  $th2 = $(th2);
	           //清除数据
	           $("#flowVelocity").empty();
	           //添加td
	    		$("#flowVelocity").append($th2);
	    		
			   var th3="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>流量速率(m<sup>3</sup>/s)</th>";
					
					th3+=" <th style='color: blue;'class='font_num' align='center'>"+id_traffic+"</th>";
			  $th3 = $(th3);
	           //清除数据
	           $("#flowRate").empty();
	           //添加td
	    		$("#flowRate").append($th3);
			 
	    		

				var ths="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>昨日流量(m<sup>3</sup>)</th>";
				ths+=" <th style='color: blue;'class='font_num' align='center'>"+yes_ztraffic+"</th>";	
				
		  $ths = $(ths);
	       //清除数据
	       $("#yes").empty();
	       //添加td
			$("#yes").append($ths);
			
			 var thss="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>今日流量(m<sup>3</sup>)</th>";
				thss+=" <th style='color: blue;'class='font_num' align='center'>"+todayid+"</th>";	
				
		  $thss = $(thss);
	       //清除数据
	       $("#tod").empty();
	       //添加td
			$("#tod").append($thss);
	    		
	    		var th6="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>总流量(万m<sup>3</sup>)</th>";
				
					th6+=" <th style='color: blue;'class='font_num' align='center'>"+id_ztraffic+"</th>";
			  $th6 = $(th6);
	         //  清除数据          
	           $("#voltage").empty();
	         //  添加td    		
	           $("#voltage").append($th6);
	    	//	console.log(pollutantss)
	    	drainage=companyconfigss.drainage;
	    	drainages=companyconfigss.drainages;
	           	var th7="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>流域</th>";
				
					th7+=" <th  style='color: blue;'class='font_num' align='center'>"+drainage+drainages+"</th>";
			  $th7 = $(th7);
	         //  清除数据          
	           $("#drainage").empty();
	         //  添加td    		
	           $("#drainage").append($th7);
	    	//	console.log(pollutantss)
	            }
	    		*/
	    		
	    	/*	if(sam1!=null){
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
					th12+=" <th style='color: blue;'class='font_num'; align='center'>"+samplingWater1+"</th>";	
					th12+=" <th style='color: blue;' class='font_num';align='center'>"+samplingPh1+"</th>";
					th12+=" <th style='color: blue;'class='font_num'; align='center'>"+samplingCapNum1+"</th>";
					th12+=" <th align='center'>手动采样</th>";
			  $th12 = $(th12);
	           //清除数据
	           $("#sam1").empty();
	           //添加td
	    		$("#sam1").append($th12);
	    		th13="<th align='center'>"+strTime2+"</th>";
					th13+=" <th style='color: blue;'class='font_num'; align='center'>"+samplingWater2+"</th>";	
					th13+=" <th style='color: blue;'class='font_num'; align='center'>"+samplingPh2+"</th>";
					th13+=" <th style='color: blue;'class='font_num'; align='center'>"+samplingCapNum2+"</th>";
					th13+=" <th align='center'>自动采样</th>";
			  $th13 = $(th13);
	           //清除数据
	           $("#sam2").empty();
	           //添加td
	    		$("#sam2").append($th13);
	    		
	    		th14="<th align='center'>"+strTime3+"</th>";
					th14+=" <th style='color: blue;'class='font_num'; align='center'>"+samplingWater3+"</th>";	
					th14+=" <th style='color: blue;' class='font_num';align='center'>"+samplingPh3+"</th>";
					th14+=" <th style='color: blue;' class='font_num';align='center'>"+samplingCapNum3+"</th>";
					th14+=" <th align='center'>报警采样</th>";
			  $th14 = $(th14);
	           //清除数据
	           $("#sam3").empty();
	           //添加td
	    		$("#sam3").append($th14);
	    		
	    		th15="<th align='center'>"+strTime4+"</th>";
					th15+=" <th style='color: blue;'class='font_num'; align='center'>"+samplingWater4+"</th>";	
					th15+=" <th style='color: blue;'class='font_num'; align='center'>"+samplingPh4+"</th>";
					th15+=" <th style='color: blue;'class='font_num'; align='center'>"+samplingCapNum4+"</th>";
					th15+=" <th align='center'>远程采样</th>";
			  $th15 = $(th15);
	           //清除数据
	           $("#sam4").empty();
	           //添加td
	    		$("#sam4").append($th15);
	    		
	    		
	    		  $("#log").empty();
	          if(logs.length==0){
	        	 var log="<tr><th   align='center' '>-</th>";
					log+="  <th  style='color: #0071BC;' align='center'class='font_num'>-</th>";
					log+="  <th  style='color: #0071BC;' align='center'class='font_num'>-</th>";
					log+="  <th  style='color: #0071BC;' align='center'class='font_num'>-</th>";
					log+="  <th  style='color: #0071BC;' align='center'class='font_num'>-</th></tr>";
					 $log = $(log);
	           //添加td
	    		$("#log").append($log);
	          }else{
			    for(i=0;i<logs.length;i++){
			    	console.log(logs[i])
			    	var log="<tr><th   align='center' '>"+logs[i].updataTime+"</th>";
					log+="  <th  style='color: #0071BC;' align='center'class='font_num'>"+logs[i].userName+"</th>";
					log+="  <th  style='color: #0071BC;' align='center'class='font_num'>"+logs[i].userIp+"</th>";
					log+="  <th  style='color: #0071BC;' align='center'class='font_num'>"+logs[i].companyName+"</th>";
					log+="  <th  style='color: #0071BC;' align='center'class='font_num'>"+logs[i].str+"</th></tr>";
					 $log = $(log);
	           //添加td
	    		$("#log").append($log);
	    		}
			    }*/
	    /**	*
	    	if(ztraffic!=null){	
	    var supplyIndustrial1=ztraffic.supplyIndustrial==null?'-':ztraffic.supplyIndustrial;		//工业给水
	    if(rid=='75501330004'){
	    var supplyLiving1='-';			//生活给水	
	    }else{
		var supplyLiving1=ztraffic.supplyLiving==null?'-':ztraffic.supplyLiving;			//生活给水
		}
		 drainageIndustrial1=ztraffic.drainageIndustrial==null?'-':ztraffic.drainageIndustrial;//工业排水
		var lossLimit1=ztraffic.lossLimit==null?'-':ztraffic.lossLimit;         //损耗限值
		var unknown1=ztraffic.unknown==null?'-':ztraffic.unknown;          //不明
		var lossAmount1=ztraffic.lossAmount==null?'-':ztraffic.lossAmount;//损耗值
	       }else{
	    var supplyIndustrial1='-';		//工业给水
		var supplyLiving1='-';			//生活给水
		var drainageIndustrial1='-';//工业排水
		var lossLimit1='-';         //损耗限值
		var unknown1='-';          //不明
		var lossAmount1='-';//损耗值
	       } 
		                var th16="   <th align='center' style='font-family: 微软雅黑;font-size: 16px;'>数值</th>";
						th16+="	<th style='color: blue;' align='center'>"+supplyIndustrial1+"</th>";
						th16+="	<th style='color: blue;' align='center'>"+supplyLiving1+"</th>";
						th16+="	<th id='id_02' style='color: blue;' align='center'>"+drainageIndustrial1+"</th>";
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
	    		var supplyIndustrial2=ztraffic2.supplyIndustrial==null?'-':ztraffic2.supplyIndustrial;		//工业给水
	    		 if(rid=='75501330004'){
	    var supplyLiving2='-';			//生活给水	
	    }else{
		var supplyLiving2=ztraffic2.supplyLiving==null?'-':ztraffic2.supplyLiving;			//生活给水
		}
		
		var drainageIndustrial2=ztraffic2.drainageIndustrial==null?'-':ztraffic2.drainageIndustrial;//工业排水
		var drainageLiving2=ztraffic2.drainageLiving==null?'-':ztraffic2.drainageLiving;		//生活排水
		var lossLimit2=ztraffic2.lossLimit==null?'-':ztraffic2.lossLimit;         //损耗限值
		var unknown2=ztraffic2.unknown==null?'-':ztraffic2.unknown;          //不明
		var lossAmount2=ztraffic2.lossAmount==null?'-':ztraffic2.lossAmount;//损耗值
		
		 }else{
	    var supplyIndustrial2='-';		//工业给水
		var supplyLiving2='-';			//生活给水
		var drainageIndustrial2='-';//工业排水
		var lossLimit2='-';         //损耗限值
		var unknown2='-';          //不明
		var lossAmount2='-';//损耗值
	       } 
		
		//console.log(lossLimit2)
		 var th17="   <th align='center' style='font-family: 微软雅黑;font-size: 16px;'>流量系数</th>";
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
	      		
	    		         var th18="     <th align='center'style='font-family: 微软雅黑;font-size: 16px;'>条件参数</th>";
							th18+="<th style='color: green;' align='center'>"+companyStand+"</th>";
							th18+="<th style='color: green;' align='center'>"+perCaoitaWater+"</th>";
							th18+="<th style='color: green;' align='center'>"+consumptionCoefficient+"</th>";
							th18+="<th align='left'>2、损耗系数K：指水在输送、使用、污水净化处理过程中因泄漏、蒸发以及通过工业废渣等因素而损耗的水量与给水总量的比例关系。 建议K＝0.10～0.15。</th>";
						
	    		$th18 = $(th18);
	           //清除数据
	           $("#com").empty();
	           //添加td
	    		$("#com").append($th18);
	    		*/
	    		
	    		
	    		

				  var tabph;
					var tabtemp;
					var tabconductivity;
					var tabDo;
					var tabTurbidity;
					var tabCOD;
					var tabNH4;
					var tabTP;
					var tabTN;
					var tabNO3;
					var tabAn;
					var tabPhe;
					var tabCN;
					var tabPb;
					var tabCd;
					var tabCu;
					var tabHg;
					var tabAs;
					var tabFe;
					var tabCr6;
					var tabMn;
					var tabNi;
					var tabF;
					var tabS;
					var tabPoison;
					var tabOC;
					var tabZn;

					
					var mintabph;
					var mintabtemp;
					var minconductivity;
					var mintabDo;
					var mintabTurbidity;
					var mintabCOD;
					var mintabNH4;
					var mintabTP;
					var mintabTN;
					var mintabNO3;
					var mintabAn;
					var mintabPhe;
					var mintabCN;
					var mintabPb;
					var mintabCd;
					var mintabCu;
					var mintabHg;
					var mintabAs;
					var mintabFe;
					var mintabCr6;
					var mintabMn;
					var mintabNi;
					var mintabF;
					var mintabS;
					var mintabPoison;
					var mintabOC;
					var mintabZn;
					
					
					var maxtabph;
					var maxtabtemp;
					var maxconductivity;
					var maxtabDo;
					var maxtabTurbidity;
					var maxtabCOD;
					var maxtabNH4;
					var maxtabTP;
					var maxtabTN;
					var maxtabNO3;
					var maxtabAn;
					var maxtabPhe;
					var maxtabCN;
					var maxtabPb;
					var maxtabCd;
					var maxtabCu;
					var maxtabHg;
					var maxtabAs;
					var maxtabFe;
					var maxtabCr6;
					var maxtabMn;
					var maxtabNi;
					var maxtabF;
					var maxtabS;
					var maxtabPoison;
					var maxtabOC;
					var maxtabZn;
						  
						  var tabph;							//实时PH
					      var mintabph;			//最近24小时的最小值PH
					      var maxtabph;			//最近24小时最大值PH
					       var tabCOD;						//实时COD
					      var mintabCOD;			//最近24小时最小值COD
					      var maxtabCOD;			//最近24小时最大值COD
					      var tabNH4;						//实时氨氮
					      var mintabNH4;			//最近24小时最小值氨氮
					      var maxtabNH4;			//最近24小时最大值氨氮
					      var tabconductivity;		//电导率
					      var maxconductivity;		//电导率最大值
					      var minconductivity;		//电导率最小值
						  var cr6;		//六价铬
					      var maxtabCr6;		//六价铬
					      var mintabCr6;	
					      console.log(pollutantss)
			  if(pollutantss!=null){
				  
	 			 if(pollutantss.tabph!=null||pollutantss.mintabph!=null||pollutantss.maxtabph!=null){
	 				 if(pollutantss.tabph==0&&pollutantss.mintabph==0&&pollutantss.maxtabph==0){
	 					 tabph="-";							
		                     mintabph="-";			
		                     maxtabph="-";			
	 				 }else{
	 					tabph=pollutantss.tabph==null?'-':pollutantss.tabph;						
		                    mintabph=pollutantss.mintabph==null?'-':pollutantss.mintabph;		
		                    maxtabph=pollutantss.maxtabph==null?'-':pollutantss.maxtabph;	
	 				 }
	 			 }else{
	 				    tabph="-";							
		                     mintabph="-";			
		                     maxtabph="-";		
	 			 }
	 			  if(pollutantss.tabCOD!=null||pollutantss.mintabCOD!=null||pollutantss.maxtabCOD!=null){
	 				 if(pollutantss.tabCOD==0&&pollutantss.mintabCOD==0&&pollutantss.maxtabCOD==0){
	 					 tabCOD="-";						
		                     mintabCOD="-";			
		                     maxtabCOD="-";			
	 				 }else{
	 					
	 					 tabCOD=pollutantss.tabCOD==null?'-':pollutantss.tabCOD.toFixed(0);	
	 					
		                     mintabCOD=pollutantss.mintabCOD==null?'-':pollutantss.mintabCOD.toFixed(0);	
		                        
		                     maxtabCOD=pollutantss.maxtabCOD==null?'-':pollutantss.maxtabCOD.toFixed(0);
	 				 }
	 			 }else{
	 				    tabCOD="-";						
		                     mintabCOD="-";			
		                     maxtabCOD="-";		
	 			 }
	 			  if(pollutantss.tabNH4!=null||pollutantss.mintabNH4!=null||pollutantss.maxtabNH4!=null){
	 				 
	 				 if(pollutantss.tabNH4==0&&pollutantss.mintabNH4==0&&pollutantss.maxtabNH4==0){
	 					 tabNH4=0.0;						
		                     mintabNH4=0.0;			
		                     maxtabNH4=0.0;			
	 				 }else{
	 					 tabNH4=pollutantss.tabNH4==null?'-':pollutantss.tabNH4;					
		                     mintabNH4=pollutantss.mintabNH4==null?'-':pollutantss.mintabNH4;		
		                     maxtabNH4=pollutantss.maxtabNH4==null?'-':pollutantss.maxtabNH4;
	 				 }
	 			 }else{
	 				     tabNH4="-";						
		                     mintabNH4="-";			
		                     maxtabNH4="-";			
	 			 }
	 			  
	 			   if(pollutantss.tabconductivity!=null||pollutantss.maxtabconductivity!=null||pollutantss.mintabconductivity!=null){
	 				 if(pollutantss.tabconductivity==0&&pollutantss.maxtabconductivity==0&&pollutantss.mintabconductivity==0){
	 					tabconductivity="-";		
		                    maxtabconductivity="-";		
		                       mintabconductivity="-";			
	 				 }else{
	 					 tabconductivity=pollutantss.tabconductivity==null?'-':pollutantss.tabconductivity;		
		                     maxtabconductivity=pollutantss.maxtabconductivity==null?'-':pollutantss.maxtabconductivity;			
		                     mintabconductivity=pollutantss.mintabconductivity==null?'-':pollutantss.mintabconductivity;	
	 				 }
	 			 }else{
	 				   tabconductivity="-";		
		                    maxtabconductivity="-";		
		                       mintabconductivity="-";		
	 			 }
	 			  /*console.log(pollutantss)
	 			    if(pollutantss.tabCr6!=null&&pollutantss.maxtabCr6!=null&&pollutantss.mintabCr6!=null){
	 				 if(pollutantss.tabCr6==0&&pollutantss.maxtabCr6==0&&pollutantss.mintabCr6==0){
	 					tabCr6="-";		
		                     maxtabCr6="-";		
		                    mintabCr6="-";			
	 				 }else{
	 					tabCr6=pollutantss.tabCr6;		
		                    maxtabCr6=pollutantss.maxtabCr6;		
		                    mintabCr6=pollutantss.mintabCr6;
	 				 }
	 			 }else{
	 				    tabCr6="-";		
		                     maxtabCr6="-";		
		                    mintabCr6="-";		
	 			 }*/
	 			    if(pollutantss.tabtemp!=null||pollutantss.maxtabtemp!=null||pollutantss.mintabtemp!=null){
	 				 if(pollutantss.tabtemp==0&&pollutantss.maxtabtemp==0&&pollutantss.mintabtemp==0){
	 					tabtemp="-";	
		                    maxtabtemp="-";	
		                    mintabtemp="-";		
	 				 }else{
	 				tabtemp=pollutantss.tabtemp==null?'-':pollutantss.tabtemp;	
		                maxtabtemp=pollutantss.maxtabtemp==null?'-':pollutantss.maxtabtemp;
		                mintabtemp=pollutantss.mintabtemp==null?'-':pollutantss.mintabtemp;
	 				 }
	 			 }else{
	 				    tabtemp="-";	
		                    maxtabtemp="-";	
		                    mintabtemp="-";		
	 			 }
	 			     if(pollutantss.tabDo!=null||pollutantss.maxtabDo!=null||pollutantss.maxtabDo!=null){
	 				 if(pollutantss.tabDo==0&&pollutantss.mintabDo==0&&pollutantss.mintabDo==0){
	 					 realDo="-";
		                     maxtabDo="-";		
		                     mintabDo="-";
	 				 }else{
	 				realDo=pollutantss.tabDo==null?"-":pollutantss.tabDo;	
		                maxtabDo=pollutantss.maxtabDo==null?'-':pollutantss.maxtabDo;
		                mintabDo=pollutantss.mintabDo==null?'-':pollutantss.mintabDo;
	 				 }
	 			 }else{
	 				     realDo="-";
		                     maxtabDo="-";		
		                     mintabDo="-";	
	 			 }
		      }else{
				 tabph="-";							
		       mintabph="-";			
		       maxtabph="-";			
		       tabCOD="-";						
		       mintabCOD="-";			
		       maxtabCOD="-";			
		       tabNH4="-";						
		       mintabNH4="-";			
		       maxtabNH4="-";			
		       tabconductivity="-";		
		       maxtabconductivity="-";		
		       mintabconductivity="-";		
			   tabCr6="-";		
		       maxtabCr6="-";		
		       mintabCr6="-";	
		       tabtemp="-";	
		       maxtabtemp="-";	
		       mintabtemp="-";
		       realDo="-";
		       maxtabDo="-";		
		       mintabDo="-";
		       
		       
		       var tabph="-";
		var tabtemp="-";
		var tabconductivity="-";
		var tabDo="-";
		var tabTurbidity="-";
		var tabCOD="-";
		var tabNH4="-";
		var tabTP="-";
		var tabTN="-";
		var tabNO3="-";
		var tabAn="-";
		var tabPhe="-";
		var tabCN="-";
		var tabPb="-";
		var tabCd="-";
		var tabCu="-";
		var tabHg="-";
		var tabAs="-";
		var tabFe="-";
		var tabCr6="-";
		var tabMn="-";
		var tabNi="-";
		var tabF="-";
		var tabS="-";
		var tabPoison="-";
		var tabOC="-";
		var tabZn="-";

		
		var mintabph="-";
		var mintabtemp="-";
		var mintabconductivity="-";
		var mintabDo="-";
		var mintabTurbidity="-";
		var mintabCOD="-";
		var mintabNH4="-";
		var mintabTP="-";
		var mintabTN="-";
		var mintabNO3="-";
		var mintabAn="-";
		var mintabPhe="-";
		var mintabCN="-";
		var mintabPb="-";
		var mintabCd="-";
		var mintabCu="-";
		var mintabHg="-";
		var mintabAs="-";
		var mintabFe="-";
		var mintabCr6="-";
		var mintabMn="-";
		var mintabNi="-";
		var mintabF="-";
		var mintabS="-";
		var mintabPoison="-";
		var mintabOC="-";
		var mintabZn="-";
		
		
		var maxtabph="-";
		var maxtabtemp="-";
		var maxtabconductivity="-";
		var maxtabDo="-";
		var maxtabTurbidity="-";
		var maxtabCOD="-";
		var maxtabNH4="-";
		var maxtabTP="-";
		var maxtabTN="-";
		var maxtabNO3="-";
		var maxtabAn="-";
		var maxtabPhe="-";
		var maxtabCN="-";
		var maxtabPb="-";
		var maxtabCd="-";
		var maxtabCu="-";
		var maxtabHg="-";
		var maxtabAs="-";
		var maxtabFe="-";
		var maxtabCr6="-";
		var maxtabMn="-";
		var maxtabNi="-";
		var maxtabF="-";
		var maxtabS="-";
		var maxtabPoison="-";
		var maxtabOC="-";
		var maxtabZn="-";
			 }
	 		
	 		
	 			if(pollutantss!=null){
	 				
	 				 if(pollutantss.tabCr6!=null||pollutantss.maxtabCr6!=null||pollutantss.mintabCr6!=null){
	 				 if(pollutantss.tabCr6==0&&pollutantss.maxtabCr6==0&&pollutantss.mintabCr6==0){
	 					tabCr6="-";		
		                     maxtabCr6="-";		
		                    mintabCr6="-";			
	 				 }else{
	 					tabCr6=pollutantss.tabCr6==null?'-':pollutantss.tabCr6;	
		                    maxtabCr6=pollutantss.maxtabCr6==null?'-':pollutantss.maxtabCr6;		
		                    mintabCr6=pollutantss.mintabCr6==null?'-':pollutantss.mintabCr6;
	 				 }
	 			 }else{
	 				    tabCr6="-";		
		                     maxtabCr6="-";		
		                    mintabCr6="-";		
	 			 }
	 			
	 			
	 			if(pollutantss.tabTurbidity!=null||pollutantss.mintabTurbidity!=null||pollutantss.maxtabTurbidity!=null){
	 				 if(pollutantss.tabTurbidity==0&&pollutantss.mintabTurbidity==0&&pollutantss.maxtabTurbidity==0){
	 					 var tabTurbidity='-';
		                    var mintabTurbidity='-'; //	
		                     var maxtabTurbidity='-'; //
	 				 }else{
	 				var tabTurbidity=pollutantss.tabTurbidity==null?'-':pollutantss.tabTurbidity;   //有机碳
		                var mintabTurbidity=pollutantss.mintabTurbidity==null?'-':pollutantss.mintabTurbidity;   //有机碳
		              var maxtabTurbidity=pollutantss.maxtabTurbidity==null?'-':pollutantss.maxtabTurbidity;   //有机碳
	 				 }
	 			 }else{
	 				      var tabTurbidity='-';
		                    var mintabTurbidity='-'; //	
		                     var maxtabTurbidity='-'; //
	 			 }
	 			if(pollutantss.tabNO3!=null||pollutantss.mintabNO3!=null||pollutantss.maxtabNO3!=null){
	 				 if(pollutantss.tabNO3==0&&pollutantss.mintabNO3==0&&pollutantss.maxtabNO3==0){
	 					 var tabNO3='-';
		                    var mintabNO3='-'; //	
		                     var maxtabNO3='-'; //
	 				 }else{
	 				var tabNO3=pollutantss.tabNO3==null?'-':pollutantss.tabNO3;   //有机碳
		                var mintabNO3=pollutantss.mintabNO3==null?'-':pollutantss.mintabNO3;   //有机碳
		              var maxtabNO3=pollutantss.maxtabNO3==null?'-':pollutantss.maxtabNO3;   //有机碳
	 				 }
	 			 }else{
	 				      var tabNO3='-';
		                    var mintabNO3='-'; //	
		                     var maxtabNO3='-'; //
	 			 }
	 			if(pollutantss.tabTP!=null||pollutantss.mintabTP!=null||pollutantss.maxtabTP!=null){
	 				 if(pollutantss.tabTP==0&&pollutantss.mintabTP==0&&pollutantss.maxtabTP==0){
	 					 var tabTP='-';
		                    var mintabTP='-'; //	
		                     var maxtabTP='-'; //
	 				 }else{
	 				var tabTP=pollutantss.tabTP==null?'-':pollutantss.tabTP;   //有机碳
		                var mintabTP=pollutantss.mintabTP==null?'-':pollutantss.mintabTP;   //有机碳
		              var maxtabTP=pollutantss.maxtabTP==null?'-':pollutantss.maxtabTP;  //有机碳
	 				 }
	 			 }else{
	 				      var tabTP='-';
		                    var mintabTP='-'; //	
		                     var maxtabTP='-'; //
	 			 }
	 			
	 			if(pollutantss.tabAn!=null||pollutantss.mintabAn!=null||pollutantss.maxtabAn!=null){
	 				 if(pollutantss.tabAn==0&&pollutantss.mintabAn==0&&pollutantss.maxtabAn==0){
	 					 var tabAn='-';
		                    var mintabAn='-'; //	
		                     var maxtabAn='-'; //
	 				 }else{
	 				var tabAn=pollutantss.tabAn==null?'-':pollutantss.tabAn;   //有机碳
		                var mintabAn=pollutantss.mintabAn==null?'-':pollutantss.mintabAn;   //有机碳
		              var maxtabAn=pollutantss.maxtabAn==null?'-':pollutantss.maxtabAn;   //有机碳
	 				 }
	 			 }else{
	 				      var tabAn='-';
		                    var mintabAn='-'; //	
		                     var maxtabAn='-'; //
	 			 }
	 			if(pollutantss.tabPhe!=null||pollutantss.maxtabPhe!=null||pollutantss.mintabPhe!=null){
	 				 if(pollutantss.tabPhe==0&&pollutantss.maxtabPhe==0&&pollutantss.mintabPhe==0){
	 					 var tabPhe='-';
		                    var maxtabPhe='-'; //	
		                     var mintabPhe='-'; //
	 				 }else{
	 				var tabPhe=pollutantss.tabPhe==null?'-':pollutantss.tabPhe;   //有机碳
		                var maxtabPhe=pollutantss.maxtabPhe==null?'-':pollutantss.maxtabPhe;   //有机碳
		              var mintabPhe=pollutantss.mintabPhe==null?'-':pollutantss.mintabPhe;   //有机碳
	 				 }
	 			 }else{
	 				      var tabPhe='-';
		                    var maxtabPhe='-'; //	
		                     var mintabPhe='-'; //
	 			 }
	 			
	 			
	 			
		if(pollutantss.tabCN!=null||pollutantss.maxtabCN!=null||pollutantss.mintabCN!=null){
	 				 if(pollutantss.tabCN==0&&pollutantss.maxtabCN==0&&pollutantss.mintabCN==0){
	 					 var tabCN='-';
		                    var maxtabCN='-'; //	
		                     var mintabCN='-'; //
	 				 }else{
	 				var tabCN=pollutantss.tabCN==null?'-':pollutantss.tabCN;
		                var maxtabCN=pollutantss.maxtabCN==null?'-':pollutantss.maxtabCN;
		              var mintabCN=pollutantss.mintabCN==null?'-':pollutantss.mintabCN;
	 				 }
	 			 }else{
	 				      var tabCN='-';
		                    var maxtabCN='-'; //	
		                     var mintabCN='-'; //
	 			 }
		
		         if(pollutantss.tabPb!=null||pollutantss.maxtabPb!=null||pollutantss.mintabPb!=null){
	 				 if(pollutantss.tabPb==0&&pollutantss.maxtabPb==0&&pollutantss.mintabPb==0){
	 					 var tabPb='-';
		                    var maxtabPb='-'; //	
		                     var mintabPb='-'; //
	 				 }else{
	 				var tabPb=pollutantss.tabPb==null?'-':pollutantss.tabPb;
		                var maxtabPb=pollutantss.maxtabPb==null?'-':pollutantss.maxtabPb;
		              var mintabPb=pollutantss.mintabPb==null?'-':pollutantss.mintabPb;
	 				 }
	 			 }else{
	 				      var tabPb='-';
		                    var maxtabPb='-'; //	
		                     var Cd='-'; //
	 			 }
		         
		          if(pollutantss.tabCd!=null||pollutantss.maxtabCd!=null||pollutantss.mintabCd!=null){
	 				 if(pollutantss.tabCd==0&&pollutantss.maxtabCd==0&&pollutantss.mintabCd==0){
	 					 var tabCd='-';
		                    var maxtabCd='-'; //	
		                     var mintabCd='-'; //
	 				 }else{
	 				var tabCd=pollutantss.tabCd==null?'-':pollutantss.tabCd;
		                var maxtabCd=pollutantss.maxtabCd==null?'-':pollutantss.maxtabCd;
		              var mintabCd=pollutantss.mintabCd==null?'-':pollutantss.mintabCd;
	 				 }
	 			 }else{
	 				      var tabCd='-';
		                    var maxtabCd='-'; //	
		                     var mintabPb='-'; //
	 			 }
		          if(pollutantss.tabCu!=null||pollutantss.maxtabCu!=null||pollutantss.mintabCu!=null){
	 				 if(pollutantss.tabCu==0&&pollutantss.maxtabCu==0&&pollutantss.mintabCu==0){
	 					 var tabCu='-';
		                    var maxtabCu='-'; //	
		                     var mintabCu='-'; //
	 				 }else{
	 				var tabCu=pollutantss.tabCu==null?'-':pollutantss.tabCu;
		                var maxtabCu=pollutantss.maxtabCu==null?'-':pollutantss.maxtabCu;
		              var mintabCu=pollutantss.mintabCu==null?'-':pollutantss.mintabCu;
	 				 }
	 			 }else{
	 				      var tabCu='-';
		                    var maxtabCu='-'; //	
		                     var mintabCu='-'; //
	 			 }
		          if(pollutantss.tabHg!=null||pollutantss.maxtabHg!=null||pollutantss.mintabHg!=null){
	 				 if(pollutantss.tabHg==0&&pollutantss.maxtabHg==0&&pollutantss.mintabHg==0){
	 					 var tabHg='-';
		                    var maxtabHg='-'; //	
		                     var mintabHg='-'; //
	 				 }else{
	 				var tabHg=pollutantss.tabHg==null?'-':pollutantss.tabHg;
		                var maxtabHg=pollutantss.maxtabHg==null?'-':pollutantss.maxtabHg;
		              var mintabHg=pollutantss.mintabHg==null?'-':pollutantss.mintabHg;
	 				 }
	 			 }else{
	 				      var tabHg='-';
		                    var maxtabHg='-'; //	
		                     var mintabHg='-'; //
	 			 }
		         if(pollutantss.tabAs!=null||pollutantss.maxtabAs!=null||pollutantss.mintabAs!=null){
	 				 if(pollutantss.tabAs==0&&pollutantss.maxtabAs==0&&pollutantss.mintabAs==0){
	 					 var tabAs='-';
		                    var maxtabAs='-'; //	
		                     var mintabAs='-'; //
	 				 }else{
	 				var tabAs=pollutantss.tabAs==null?'-':pollutantss.tabAs;
		                var maxtabAs=pollutantss.maxtabAs==null?'-':pollutantss.maxtabAs;
		              var mintabAs=pollutantss.mintabAs==null?'-':pollutantss.mintabAs;
	 				 }
	 			 }else{
	 				      var tabAs='-';
		                    var maxtabAs='-'; //	
		                     var mintabAs='-'; //
	 			 }
		         
		          if(pollutantss.tabFe!=null||pollutantss.maxtabFe!=null||pollutantss.mintabFe!=null){
	 				 if(pollutantss.tabFe==0&&pollutantss.maxtabFe==0&&pollutantss.mintabFe==0){
	 					 var tabFe='-';
		                    var maxtabFe='-'; //	
		                     var mintabFe='-'; //
	 				 }else{
	 				var tabFe=pollutantss.tabFe==null?'-':pollutantss.tabFe;
		                var maxtabFe=pollutantss.maxtabFe==null?'-':pollutantss.maxtabFe;
		              var mintabFe=pollutantss.mintabFe==null?'-':pollutantss.mintabFe;
	 				 }
	 			 }else{
	 				      var tabFe='-';
		                    var maxtabFe='-'; //	
		                     var mintabFe='-'; //
	 			 }
		        if(pollutantss.tabMn!=null||pollutantss.maxtabMn!=null||pollutantss.mintabMn!=null){
		        	
	 				 if(pollutantss.tabMn==0&&pollutantss.maxtabMn==0&&pollutantss.mintabMn==0){
	 					 var tabMn='-';
		                    var maxtabMn='-'; //	
		                     var mintabMn='-'; //
	 				 }else{
	 				var tabMn=pollutantss.tabMn==null?'-':pollutantss.tabMn;
		                var maxtabMn=pollutantss.maxtabMn==null?'-':pollutantss.maxtabMn;
		              var mintabMn=pollutantss.mintabMn==null?'-':pollutantss.maxtabMn;
	 				 }
	 			 }else{
	 				      var tabMn='-';
		                    var maxtabMn='-'; //	
		                     var mintabMn='-'; //
	 			 }
		          if(pollutantss.tabNi!=null||pollutantss.maxtabNi!=null||pollutantss.mintabNi!=null){
	 				 if(pollutantss.tabNi==0&&pollutantss.maxtabNi==0&&pollutantss.mintabNi==0){
	 					 var tabNi='-';
		                    var maxtabNi='-'; //	
		                     var mintabNi='-'; //
	 				 }else{
	 				var tabNi=pollutantss.tabNi==null?'-':pollutantss.tabNi;
		                var maxtabNi=pollutantss.maxtabNi==null?'-':pollutantss.maxtabNi;
		              var mintabNi=pollutantss.mintabNi==null?'-':pollutantss.mintabNi;
	 				 }
	 			 }else{
	 				      var tabNi='-';
		                    var maxtabNi='-'; //	
		                     var mintabNi='-'; //
	 			 }
		         if(pollutantss.tabF!=null||pollutantss.maxtabF!=null||pollutantss.mintabF!=null){
	 				 if(pollutantss.tabF==0&&pollutantss.maxtabF==0&&pollutantss.mintabF==0){
	 					 var tabF='-';
		                    var maxtabF='-'; //	
		                     var mintabF='-'; //
	 				 }else{
	 				var tabF=pollutantss.tabF==null?'-':pollutantss.tabF;
		                var maxtabF=pollutantss.maxtabF==null?'-':pollutantss.maxtabF;
		              var mintabF=pollutantss.mintabF==null?'-':pollutantss.mintabF;
	 				 }
	 			 }else{
	 				      var tabF='-';
		                    var maxtabF='-'; //	
		                     var mintabF='-'; //
	 			 }
		         if(pollutantss.tabS!=null||pollutantss.maxtabS!=null||pollutantss.mintabS!=null){
	 				 if(pollutantss.tabS==0&&pollutantss.maxtabS==0&&pollutantss.mintabS==0){
	 					 var tabS='-';
		                    var maxtabS='-'; //	
		                     var mintabS='-'; //
	 				 }else{
	 				var tabS=pollutantss.tabS==null?'-':pollutantss.tabS;
		                var maxtabS=pollutantss.maxtabS==null?'-':pollutantss.maxtabS;
		              var mintabS=pollutantss.mintabS==null?'-':pollutantss.mintabS;
	 				 }
	 			 }else{
	 				      var tabS='-';
		                    var maxtabS='-'; //	
		                     var mintabS='-'; //
	 			 }
		          if(pollutantss.tabPoison!=null||pollutantss.maxtabPoison!=null||pollutantss.mintabPoison!=null){
	 				 if(pollutantss.tabPoison==0&&pollutantss.maxtabPoison==0&&pollutantss.mintabPoison==0){
	 					 var tabPoison='-';
		                    var maxtabPoison='-'; //	
		                     var mintabPoison='-'; //
	 				 }else{
	 				var tabPoison=pollutantss.tabPoison==null?'-':pollutantss.tabPoison;  //有机碳
		                var maxtabPoison=pollutantss.maxtabPoison==null?'-':pollutantss.maxtabPoison;
		              var mintabPoison=pollutantss.mintabPoison==null?'-':pollutantss.mintabPoison;
	 				 }
	 			 }else{
	 				      var tabPoison='-';
		                    var maxtabPoison='-'; //	
		                     var mintabPoison='-'; //
	 			 }
		           if(pollutantss.tabOC!=null||pollutantss.maxtabOC!=null||pollutantss.mintabOC!=null){
	 				 if(pollutantss.tabOC==0&&pollutantss.maxtabOC==0&&pollutantss.mintabOC==0){
	 					 var tabOC='-';
		                    var maxtabOC='-'; //	
		                     var mintabOC='-'; //
	 				 }else{
	 				var tabOC=pollutantss.tabOC==null?'-':pollutantss.tabOC;
		                var maxtabOC=pollutantss.maxtabOC==null?'-':pollutantss.maxtabOC;
		              var mintabOC=pollutantss.mintabOC==null?'-':pollutantss.mintabOC;
	 				 }
	 			 }else{
	 				      var tabOC='-';
		                    var maxtabOC='-'; //	
		                     var mintabOC='-'; //
	 			 }
		            console.log(pollutantss.maxtabZn)
		            if(pollutantss.tabZn!=null||pollutantss.maxtabZn!=null||pollutantss.mintabZn!=null){
	 				 if(pollutantss.tabZn==0&&pollutantss.maxtabZn==0&&pollutantss.mintabZn==0){
	 					 var tabZn='-';
		                    var maxtabZn='-'; //	
		                     var mintabZn='-'; //
	 				 }else{
	 				var tabZn=pollutantss.tabZn==null?'-':pollutantss.tabZn;
		                var maxtabZn=pollutantss.maxtabZn==null?'-':pollutantss.maxtabZn;
		              var mintabZn=pollutantss.mintabZn==null?'-':pollutantss.mintabZn;
	 				 }
	 			 }else{
	 				      var tabZn='-';
		                    var maxtabZn='-'; //	
		                     var mintabZn='-'; //
	 			 }
		            
		             if(pollutantss.tabTN!=null||pollutantss.maxtabTN!=null||pollutantss.mintabTN!=null){
	 				 if(pollutantss.tabTN==0&&pollutantss.maxtabTN==0&&pollutantss.mintabTN==0){
	 					 var tabTN='-';
		                    var maxtabTN='-'; //	
		                     var mintabTN='-'; //
	 				 }else{
	 				var tabTN=pollutantss.tabTN==null?'-':pollutantss.tabTN;
		                var maxtabTN=pollutantss.maxtabTN==null?'-':pollutantss.maxtabTN;
		              var mintabTN=pollutantss.mintabTN==null?'-':pollutantss.mintabTN;
	 				 }
	 			 }else{
	 				      var tabTN='-';
		                    var maxtabTN='-'; //	
		                     var mintabTN='-'; //
	 			 }
	 		}else{
	 			var tabph="-";
		var tabtemp="-";
		var tabconductivity="-";
		var tabDo="-";
		var tabTurbidity="-";
		var tabCOD="-";
		var tabNH4="-";
		var tabTP="-";
		var tabTN="-";
		var tabNO3="-";
		var tabAn="-";
		var tabPhe="-";
		var tabCN="-";
		var tabPb="-";
		var tabCd="-";
		var tabCu="-";
		var tabHg="-";
		var tabAs="-";
		var tabFe="-";
		var tabCr6="-";
		var tabMn="-";
		var tabNi="-";
		var tabF="-";
		var tabS="-";
		var tabPoison="-";
		var tabOC="-";
		var tabZn="-";

		
		var mintabph="-";
		var mintabtemp="-";
		var minconductivity="-";
		var mintabDo="-";
		var mintabTurbidity="-";
		var mintabCOD="-";
		var mintabNH4="-";
		var mintabTP="-";
		var mintabTN="-";
		var mintabNO3="-";
		var mintabAn="-";
		var mintabPhe="-";
		var mintabCN="-";
		var mintabPb="-";
		var mintabCd="-";
		var mintabCu="-";
		var mintabHg="-";
		var mintabAs="-";
		var mintabFe="-";
		var mintabCr6="-";
		var mintabMn="-";
		var mintabNi="-";
		var mintabF="-";
		var mintabS="-";
		var mintabPoison="-";
		var mintabOC="-";
		var mintabZn="-";
		
		
		var maxtabph="-";
		var maxtabtemp="-";
		var maxconductivity="-";
		var maxtabDo="-";
		var maxtabTurbidity="-";
		var maxtabCOD="-";
		var maxtabNH4="-";
		var maxtabTP="-";
		var maxtabTN="-";
		var maxtabNO3="-";
		var maxtabAn="-";
		var maxtabPhe="-";
		var maxtabCN="-";
		var maxtabPb="-";
		var maxtabCd="-";
		var maxtabCu="-";
		var maxtabHg="-";
		var maxtabAs="-";
		var maxtabFe="-";
		var maxtabCr6="-";
		var maxtabMn="-";
		var maxtabNi="-";
		var maxtabF="-";
		var maxtabS="-";
		var maxtabPoison="-";
		var maxtabOC="-";
		var maxtabZn="-";
				
	 		}
	 if(pollutantss!=null&&pollutantss!=null){
	 				
	 				 if(pollutantss.tabTOC!=null||pollutantss.maxtabTOC!=null||pollutantss.mintabTOC!=null){
	 				 if(pollutantss.tabTOC==0&&pollutantss.maxtabTOC==0&&pollutantss.mintabTOC==0){
	 					tabTOC="-";		
		                     maxtabTOC="-";		
		                    mintabTOC="-";			
	 				 }else{
	 					tabTOC=pollutantss.tabTOC==null?'-':pollutantss.tabTOC;	
		                    maxtabTOC=pollutantss.maxtabTOC==null?'-':pollutantss.maxtabTOC;		
		                    mintabTOC=pollutantss.mintabTOC==null?'-':pollutantss.mintabTOC;
	 				 }
	 			 }else{
	 				    tabTOC="-";		
		                     maxtabTOC="-";		
		                    mintabTOC="-";		
	 			 }
	 			
	 			if(pollutantss.tabLJH0!=null||pollutantss.mintabLJH0!=null||pollutantss.maxtabLJH0!=null){
	 				 if(pollutantss.tabLJH0==0&&pollutantss.mintabLJH0==0&&pollutantss.maxtabLJH0==0){
	 					 var tabLJH0='-';
		                    var mintabLJH0='-'; 		                     var maxtabLJH0='-';     				 }else{
	 				var tabLJH0=pollutantss.tabLJH0==null?'-':pollutantss.tabLJH0; //  有机碳	            
	 				var mintabLJH0=pollutantss.mintabLJH0==null?'-':pollutantss.mintabLJH0;   //有机碳	             
	 				var maxtabLJH0=pollutantss.maxtabLJH0==null?'-':pollutantss.maxtabLJH0;  // 有机碳    		
	 				}
	 			 }else{
	 				      var tabLJH0='-';
		                    var mintabLJH0='-'; 		                     var maxtabLJH0='-';     			 }
	 			if(pollutantss.tabLJH1!=null||pollutantss.mintabLJH1!=null||pollutantss.maxtabLJH1!=null){
	 				 if(pollutantss.tabLJH1==0&&pollutantss.mintabLJH1==0&&pollutantss.maxtabLJH1==0){
	 					 var tabLJH1='-';
		                    var mintabLJH1='-'; 		                     var maxtabLJH1='-';     				 }else{
	 				var tabLJH1=pollutantss. tabLJH1==null?'-':pollutantss. tabLJH1;   //有机碳	  
	 				var mintabLJH1=pollutantss.mintabLJH1==null?'-':pollutantss.mintabLJH1;   //有机碳	      
	 				var maxtabLJH1=pollutantss.maxtabLJH1==null?'-':pollutantss.maxtabLJH1;  // 有机碳    				
	 				}
	 			 }else{
	 				      var tabLJH1='-';
		                    var mintabLJH1='-'; 		                     var maxtabLJH1='-';     			 }
	 			if(pollutantss. tabLJH2!=null||pollutantss.mintabLJH2!=null||pollutantss.maxtabLJH2!=null){
	 				 if(pollutantss. tabLJH2==0&&pollutantss.mintabLJH2==0&&pollutantss.maxtabLJH2==0){
	 					 var tabLJH2='-';
		                    var mintabLJH2='-'; 		                     var maxtabLJH2='-';     				 }else{
	 				var tabLJH2=pollutantss. tabLJH2==null?'-':pollutantss. tabLJH2;   //有机碳	         
	 				var mintabLJH2=pollutantss.mintabLJH2==null?'-':pollutantss.mintabLJH2;   //有机碳	       
	 				var maxtabLJH2=pollutantss.maxtabLJH2==null?'-':pollutantss.maxtabLJH2; // 有机碳    			
	 				}
	 			 }else{
	 				      var tabLJH2='-';
		                    var mintabLJH2='-'; 		                     var maxtabLJH2='-';     			 }
	 			if(pollutantss. tabtC2H2Cl2!=null||pollutantss.mintabtC2H2Cl2!=null||pollutantss.maxtabtC2H2Cl2!=null){
	 				 if(pollutantss. tabtC2H2Cl2==0&&pollutantss.mintabtC2H2Cl2==0&&pollutantss.maxtabtC2H2Cl2==0){
	 					 var tabtC2H2Cl2='-';
		                    var mintabtC2H2Cl2='-'; 		                     var maxtabtC2H2Cl2='-';     				 }else{
	 				var tabtC2H2Cl2=pollutantss. tabtC2H2Cl2==null?'-':pollutantss. tabtC2H2Cl2;   //有机碳	           
	 				var mintabtC2H2Cl2=pollutantss.mintabtC2H2Cl2==null?'-':pollutantss.mintabtC2H2Cl2;   //有机碳	       
	 				var maxtabtC2H2Cl2=pollutantss.maxtabtC2H2Cl2==null?'-':pollutantss.maxtabtC2H2Cl2;   //有机碳    			
	 				}
	 			 }else{
	 				      var tabtC2H2Cl2='-';
		                    var mintabtC2H2Cl2='-'; 		                     var maxtabtC2H2Cl2='-';     			 }
	 			if(pollutantss. tabfC2H2CL2!=null||pollutantss.maxtabfC2H2CL2!=null||pollutantss.mintabfC2H2CL2!=null){
	 				 if(pollutantss. tabfC2H2CL2==0&&pollutantss.maxtabfC2H2CL2==0&&pollutantss.mintabfC2H2CL2==0){
	 					 var tabfC2H2CL2='-';
		                    var maxtabfC2H2CL2='-'; 		                     var mintabfC2H2CL2='-';     				 }else{
	 				var tabfC2H2CL2=pollutantss. tabfC2H2CL2==null?'-':pollutantss. tabfC2H2CL2;   //有机碳	       
	 				var maxtabfC2H2CL2=pollutantss.maxtabfC2H2CL2==null?'-':pollutantss.maxtabfC2H2CL2;   //有机碳	
	 				var mintabfC2H2CL2=pollutantss.mintabfC2H2CL2==null?'-':pollutantss.mintabfC2H2CL2;  /// 有机碳    		
	 				}
	 			 }else{
	 				      var tabfC2H2CL2='-';
		                    var maxtabfC2H2CL2='-'; 		                     var mintabfC2H2CL2='-';     			 }
	 			
	 			
	 			
		if(pollutantss. tabCHCl3!=null||pollutantss.maxtabCHCl3!=null||pollutantss.mintabCHCl3!=null){
	 				 if(pollutantss. tabCHCl3==0&&pollutantss.maxtabCHCl3==0&&pollutantss.mintabCHCl3==0){
	 					 var tabCHCl3='-';
		                    var maxtabCHCl3='-'; 		                     var mintabCHCl3='-';     				 }else{
	 				var tabCHCl3=pollutantss. tabCHCl3==null?'-':pollutantss. tabCHCl3;
		                var maxtabCHCl3=pollutantss.maxtabCHCl3==null?'-':pollutantss.maxtabCHCl3;
		              var mintabCHCl3=pollutantss.mintabCHCl3==null?'-':pollutantss.mintabCHCl3;
	 				 }
	 			 }else{
	 				      var tabCHCl3='-';
		                    var maxtabCHCl3='-'; 		                     var mintabCHCl3='-';     			 }
		
		         if(pollutantss. tabC2H2Cl2!=null||pollutantss.maxtabC2H2Cl2!=null||pollutantss.mintabC2H2Cl2!=null){
	 				 if(pollutantss. tabC2H2Cl2==0&&pollutantss.maxtabC2H2Cl2==0&&pollutantss.mintabC2H2Cl2==0){
	 					 var tabC2H2Cl2='-';
		                    var maxtabC2H2Cl2='-'; 		                     var mintabC2H2Cl2='-';     				 }else{
	 				var tabC2H2Cl2=pollutantss. tabC2H2Cl2==null?'-':pollutantss. tabC2H2Cl2;
		                var maxtabC2H2Cl2=pollutantss.maxtabC2H2Cl2==null?'-':pollutantss.maxtabC2H2Cl2;
		              var mintabC2H2Cl2=pollutantss.mintabC2H2Cl2==null?'-':pollutantss.mintabC2H2Cl2;
	 				 }
	 			 }else{
	 				      var tabC2H2Cl2='-';
		                    var maxtabC2H2Cl2='-'; 		                     var mintabC2H2Cl2='-';     			 }
		         
		          if(pollutantss. tabBenzene!=null||pollutantss.maxtabBenzene!=null||pollutantss.mintabBenzene!=null){
	 				 if(pollutantss. tabBenzene==0&&pollutantss.maxtabBenzene==0&&pollutantss.mintabBenzene==0){
	 					 var tabBenzene='-';
		                    var maxtabBenzene='-'; 		                     var mintabBenzene='-';     				 }else{
	 				var tabBenzene=pollutantss.tabBenzene==null?'-':pollutantss.tabBenzene;
		                var maxtabBenzene=pollutantss.maxtabBenzene==null?'-':pollutantss.maxtabBenzene;
		              var mintabBenzene=pollutantss.mintabBenzene==null?'-':pollutantss.mintabBenzene;
	 				 }
	 			 }else{
	 				      var tabBenzene='-';
		                    var maxtabBenzene='-'; 		                     var mintabBenzene='-';     			 }
		          if(pollutantss.tabC2HCl3!=null||pollutantss.maxtabC2HCl3!=null||pollutantss.mintabC2HCl3!=null){
	 				 if(pollutantss.tabC2HCl3==0&&pollutantss.maxtabC2HCl3==0&&pollutantss.mintabC2HCl3==0){
	 					 var tabC2HCl3='-';
		                    var maxtabC2HCl3='-'; 		                     var mintabC2HCl3='-';     				 }else{
	 				var tabC2HCl3=pollutantss.tabC2HCl3==null?'-':pollutantss.tabC2HCl3;
		                var maxtabC2HCl3=pollutantss.maxtabC2HCl3==null?'-':pollutantss.maxtabC2HCl3;
		              var mintabC2HCl3=pollutantss.mintabC2HCl3==null?'-':pollutantss.mintabC2HCl3;
	 				 }
	 			 }else{
	 				      var tabC2HCl3='-';
		                    var maxtabC2HCl3='-'; 		                     var mintabC2HCl3='-';     			 }
		          if(pollutantss.tabC7H8!=null||pollutantss.maxtabC7H8!=null||pollutantss.mintabC7H8!=null){
	 				 if(pollutantss.tabC7H8==0&&pollutantss.maxtabC7H8==0&&pollutantss.mintabC7H8==0){
	 					 var tabC7H8='-';
		                    var maxtabC7H8='-'; 		                     var mintabC7H8='-';     				 }else{
	 				var tabC7H8=pollutantss.tabC7H8==null?'-':pollutantss.tabC7H8;
		                var maxtabC7H8=pollutantss.maxtabC7H8==null?'-':pollutantss.maxtabC7H8;
		              var mintabC7H8=pollutantss.mintabC7H8==null?'-':pollutantss.mintabC7H8;
	 				 }
	 			 }else{
	 				      var tabC7H8='-';
		                    var maxtabC7H8='-'; 		                     var mintabC7H8='-';     			 }
		         if(pollutantss.tabC2Cl4!=null||pollutantss.maxtabC2Cl4!=null||pollutantss.mintabC2Cl4!=null){
	 				 if(pollutantss.tabC2Cl4==0&&pollutantss.maxtabC2Cl4==0&&pollutantss.mintabC2Cl4==0){
	 					 var tabC2Cl4='-';
		                    var maxtabC2Cl4='-'; 		                     var mintabC2Cl4='-';     				 }else{
	 				var tabC2Cl4=pollutantss.tabC2Cl4==null?'-':pollutantss.tabC2Cl4;
		                var maxtabC2Cl4=pollutantss.maxtabC2Cl4==null?'-':pollutantss.maxtabC2Cl4;
		              var mintabC2Cl4=pollutantss.mintabC2Cl4==null?'-':pollutantss.mintabC2Cl4;
	 				 }
	 			 }else{
	 				      var tabC2Cl4='-';
		                    var maxtabC2Cl4='-'; 		                     var mintabC2Cl4='-';     			 }
		         
		          if(pollutantss.tabC6H5Cl!=null||pollutantss.maxtabC6H5Cl!=null||pollutantss.mintabC6H5Cl!=null){
	 				 if(pollutantss.tabC6H5Cl==0&&pollutantss.maxtabC6H5Cl==0&&pollutantss.mintabC6H5Cl==0){
	 					 var tabC6H5Cl='-';
		                    var maxtabC6H5Cl='-'; 		                     var mintabC6H5Cl='-';     				 }else{
	 				var tabC6H5Cl=pollutantss.tabC6H5Cl==null?'-':pollutantss.tabC6H5Cl;
		                var maxtabC6H5Cl=pollutantss.maxtabC6H5Cl==null?'-':pollutantss.maxtabC6H5Cl;
		              var mintabC6H5Cl=pollutantss.mintabC6H5Cl==null?'-':pollutantss.mintabC6H5Cl;
	 				 }
	 			 }else{
	 				      var tabC6H5Cl='-';
		                    var maxtabC6H5Cl='-'; 		                     var mintabC6H5Cl='-';     			 }
		        if(pollutantss.tabC6H5C2H5!=null||pollutantss.maxtabC6H5C2H5!=null||pollutantss.mintabC6H5C2H5!=null){
		        	
	 				 if(pollutantss.tabC6H5C2H5==0&&pollutantss.maxtabC6H5C2H5==0&&pollutantss.mintabC6H5C2H5==0){
	 					 var tabC6H5C2H5='-';
		                    var maxtabC6H5C2H5='-'; 		                     var mintabC6H5C2H5='-';     				 }else{
	 				var tabC6H5C2H5=pollutantss.tabC6H5C2H5==null?'-':pollutantss.tabC6H5C2H5;
		                var maxtabC6H5C2H5=pollutantss.maxtabC6H5C2H5==null?'-':pollutantss.maxtabC6H5C2H5;
		              var mintabC6H5C2H5=pollutantss.mintabC6H5C2H5==null?'-':pollutantss.maxtabC6H5C2H5;
	 				 }
	 			 }else{
	 				      var tabC6H5C2H5='-';
		                    var maxtabC6H5C2H5='-'; 		                     var mintabC6H5C2H5='-';     			 }
		          if(pollutantss.tabC8H10!=null||pollutantss.maxtabC8H10!=null||pollutantss.mintabC8H10!=null){
	 				 if(pollutantss.tabC8H10==0&&pollutantss.maxtabC8H10==0&&pollutantss.mintabC8H10==0){
	 					 var tabC8H10='-';
		                    var maxtabC8H10='-'; 		                     var mintabC8H10='-';     				 }else{
	 				var tabC8H10=pollutantss.tabC8H10==null?'-':pollutantss.tabC8H10;
		                var maxtabC8H10=pollutantss.maxtabC8H10==null?'-':pollutantss.maxtabC8H10;
		              var mintabC8H10=pollutantss.mintabC8H10==null?'-':pollutantss.mintabC8H10;
	 				 }
	 			 }else{
	 				      var tabC8H10='-';
		                    var maxtabC8H10='-'; 		                     var mintabC8H10='-';     			 }
		         if(pollutantss.tabC8H8!=null||pollutantss.maxtabC8H8!=null||pollutantss.mintabC8H8!=null){
	 				 if(pollutantss.tabC8H8==0&&pollutantss.maxtabC8H8==0&&pollutantss.mintabC8H8==0){
	 					 var tabC8H8='-';
		                    var maxtabC8H8='-'; 		                     var mintabC8H8='-';     				 }else{
	 				var tabC8H8=pollutantss.tabC8H8==null?'-':pollutantss.tabC8H8;
		                var maxtabC8H8=pollutantss.maxtabC8H8==null?'-':pollutantss.maxtabC8H8;
		              var mintabC8H8=pollutantss.mintabC8H8==null?'-':pollutantss.mintabC8H8;
	 				 }
	 			 }else{
	 				      var tabC8H8='-';
		                    var maxtabC8H8='-'; 		                     var mintabC8H8='-';     			 }
		         if(pollutantss.tabC6H4CH32!=null||pollutantss.maxtabC6H4CH32!=null||pollutantss.mintabC6H4CH32!=null){
	 				 if(pollutantss.tabC6H4CH32==0&&pollutantss.maxtabC6H4CH32==0&&pollutantss.mintabC6H4CH32==0){
	 					 var tabC6H4CH32='-';
		                    var maxtabC6H4CH32='-'; 		                     var mintabC6H4CH32='-';     				 }else{
	 				var tabC6H4CH32=pollutantss.tabC6H4CH32==null?'-':pollutantss.tabC6H4CH32;
		                var maxtabC6H4CH32=pollutantss.maxtabC6H4CH32==null?'-':pollutantss.maxtabC6H4CH32;
		              var mintabC6H4CH32=pollutantss.mintabC6H4CH32==null?'-':pollutantss.mintabC6H4CH32;
	 				 }
	 			 }else{
	 				      var tabC6H4CH32='-';
		                    var maxtabC6H4CH32='-'; 		                     var mintabC6H4CH32='-';     			 }
		          if(pollutantss.tabC9H12!=null||pollutantss.maxtabC9H12!=null||pollutantss.mintabC9H12!=null){
	 				 if(pollutantss.tabC9H12==0&&pollutantss.maxtabC9H12==0&&pollutantss.mintabC9H12==0){
	 					 var tabC9H12='-';
		                    var maxtabC9H12='-'; 		                     var mintabC9H12='-';     				 }else{
	 				var tabC9H12=pollutantss.tabC9H12==null?'-':pollutantss.tabC9H12;  //有机碳	    
	 				var maxtabC9H12=pollutantss.maxtabC9H12==null?'-':pollutantss.maxtabC9H12;
		              var mintabC9H12=pollutantss.mintabC9H12==null?'-':pollutantss.mintabC9H12;
	 				 }
	 			 }else{
	 				      var tabC9H12='-';
		                    var maxtabC9H12='-'; 		                     var mintabC9H12='-';     			 }
		           if(pollutantss.tab14C6H4Cl2!=null||pollutantss.maxtab14C6H4Cl2!=null||pollutantss.mintab14C6H4Cl2!=null){
	 				 if(pollutantss.tab14C6H4Cl2==0&&pollutantss.maxtab14C6H4Cl2==0&&pollutantss.mintab14C6H4Cl2==0){
	 					 var tab14C6H4Cl2='-';
		                    var maxtab14C6H4Cl2='-'; 		                     var mintab14C6H4Cl2='-';     				 }else{
	 				var tab14C6H4Cl2=pollutantss.tab14C6H4Cl2==null?'-':pollutantss.tab14C6H4Cl2;
		                var maxtab14C6H4Cl2=pollutantss.maxtab14C6H4Cl2==null?'-':pollutantss.maxtab14C6H4Cl2;
		              var mintab14C6H4Cl2=pollutantss.mintab14C6H4Cl2==null?'-':pollutantss.mintab14C6H4Cl2;
	 				 }
	 			 }else{
	 				      var tab14C6H4Cl2='-';
		                    var maxtab14C6H4Cl2='-'; 		                     var mintab14C6H4Cl2='-';     			 }
		            if(pollutantss.tab12C6H4Cl2!=null||pollutantss.maxtab12C6H4Cl2!=null||pollutantss.mintab12C6H4Cl2!=null){
	 				 if(pollutantss.tab12C6H4Cl2==0&&pollutantss.maxtab12C6H4Cl2==0&&pollutantss.mintab12C6H4Cl2==0){
	 					 var tab12C6H4Cl2='-';
		                    var maxtabC6H4CH32='-'; 		                     var mintab12C6H4Cl2='-';     				 }else{
	 				var tab12C6H4Cl2=pollutantss.tab12C6H4Cl2==null?'-':pollutantss.tab12C6H4Cl2;
		                var maxtab12C6H4Cl2=pollutantss.maxtab12C6H4Cl2==null?'-':pollutantss.maxtab12C6H4Cl2;
		              var mintab12C6H4Cl2=pollutantss.mintab12C6H4Cl2==null?'-':pollutantss.mintab12C6H4Cl2;
	 				 }
	 			 }else{
	 				      var tab12C6H4Cl2='-';
		                    var maxtab12C6H4Cl2='-'; 		                     var mintab12C6H4Cl2='-';     			 }
		             if(pollutantss.tabC2H3Cl!=null||pollutantss.maxtabC2H3Cl!=null||pollutantss.mintabC2H3Cl!=null){
	 				 if(pollutantss.tabC2H3Cl==0&&pollutantss.maxtabC2H3Cl==0&&pollutantss.mintabC2H3Cl==0){
	 					 var tabC2H3Cl='-';
		                    var maxtabC2H3Cl='-'; 		                     var mintabC2H3Cl='-';     				 }else{
	 				var tabC2H3Cl=pollutantss.tabC2H3Cl==null?'-':pollutantss.tabC2H3Cl;
		                var maxtabC2H3Cl=pollutantss.maxtabC2H3Cl==null?'-':pollutantss.maxtabC2H3Cl;
		              var mintabC2H3Cl=pollutantss.mintabC2H3Cl==null?'-':pollutantss.mintabC2H3Cl;
	 				 }
	 			 }else{
	 				      var tabC2H3Cl='-';
		                    var maxtabC2H3Cl='-'; 		                     var mintabC2H3Cl='-';     			 }
		           
		             
		             
		             
		             
		             
		             
		             if(pollutantss.tabC2H4O!=null||pollutantss.maxtabC2H4O!=null||pollutantss.mintabC2H4O!=null){
	 				 if(pollutantss.tabC2H4O==0&&pollutantss.maxtabC2H4O==0&&pollutantss.mintabC2H4O==0){
	 					 var tabC2H4O='-';
		                    var maxtabC2H4O='-'; 		                     var mintabC2H4O='-';     				 }else{
	 				var tabC2H4O=pollutantss.tabC2H4O==null?'-':pollutantss.tabC2H4O;
		                var maxtabC2H4O=pollutantss.maxtabC2H4O==null?'-':pollutantss.maxtabC2H4O;
		              var mintabC2H4O=pollutantss.mintabC2H4O==null?'-':pollutantss.mintabC2H4O;
	 				 }
	 			 }else{
	 				      var tabC2H4O='-';
		                    var maxtabC2H4O='-'; 		                     var mintabC2H4O='-';     			 }
		              if(pollutantss.tabC3H4O!=null||pollutantss.maxtabC3H4O!=null||pollutantss.mintabC3H4O!=null){
	 				 if(pollutantss.tabC3H4O==0&&pollutantss.maxtabC3H4O==0&&pollutantss.mintabC3H4O==0){
	 					 var tabC3H4O='-';
		                    var maxtabC3H4O='-'; 		                     var mintabC3H4O='-';     				 }else{
	 				var tabC3H4O=pollutantss.tabC3H4O==null?'-':pollutantss.tabC3H4O;
		                var maxtabC3H4O=pollutantss.maxtabC3H4O==null?'-':pollutantss.maxtabC3H4O;
		              var mintabC3H4O=pollutantss.mintabC3H4O==null?'-':pollutantss.mintabC3H4O;
	 				 }
	 			 }else{
	 				      var tabC3H4O='-';
		                    var maxtabC3H4O='-'; 		                     var mintabC3H4O='-';     			 }
		              if(pollutantss.tab11C2H2Cl2!=null||pollutantss.maxtab11C2H2Cl2!=null||pollutantss.mintab11C2H2Cl2!=null){
	 				 if(pollutantss.tab11C2H2Cl2==0&&pollutantss.maxtab11C2H2Cl2==0&&pollutantss.mintab11C2H2Cl2==0){
	 					 var tab11C2H2Cl2='-';
		                    var maxtab11C2H2Cl2='-'; 		                     var mintab11C2H2Cl2='-';     				 }else{
	 				var tab11C2H2Cl2=pollutantss.tab11C2H2Cl2==null?'-':pollutantss.tab11C2H2Cl2;
		                var maxtab11C2H2Cl2=pollutantss.maxtab11C2H2Cl2==null?'-':pollutantss.maxtab11C2H2Cl2;
		              var mintab11C2H2Cl2=pollutantss.mintab11C2H2Cl2==null?'-':pollutantss.mintab11C2H2Cl2;
	 				 }
	 			 }else{
	 				      var tab11C2H2Cl2='-';
		                    var maxtab11C2H2Cl2='-'; 		                     var mintab11C2H2Cl2='-';     			 }
		              if(pollutantss.tabC3H3N!=null||pollutantss.maxtabC3H3N!=null||pollutantss.mintabC3H3N!=null){
	 				 if(pollutantss.tabC3H3N==0&&pollutantss.maxtabC3H3N==0&&pollutantss.mintabC3H3N==0){
	 					 var tabC3H3N='-';
		                    var maxtabC3H3N='-'; 		                     var mintabC3H3N='-';     				 }else{
	 				var tabC3H3N=pollutantss.tabC3H3N==null?'-':pollutantss.tabC3H3N;
		                var maxtabC3H3N=pollutantss.maxtabC3H3N==null?'-':pollutantss.maxtabC3H3N;
		              var mintabC3H3N=pollutantss.mintabC3H3N==null?'-':pollutantss.mintabC3H3N;
	 				 }
	 			 }else{
	 				      var tabC3H3N='-';
		                    var maxtabC3H3N='-'; 		                     var mintabC3H3N='-';     			 }
		              if(pollutantss.tabCH2CClCHCH2!=null||pollutantss.maxtabCH2CClCHCH2!=null||pollutantss.mintabCH2CClCHCH2!=null){
	 				 if(pollutantss.tabCH2CClCHCH2==0&&pollutantss.maxtabCH2CClCHCH2==0&&pollutantss.mintabCH2CClCHCH2==0){
	 					 var tabCH2CClCHCH2='-';
		                    var maxtabCH2CClCHCH2='-'; 		                     var mintabCH2CClCHCH2='-';     				 }else{
	 				var tabCH2CClCHCH2=pollutantss.tabCH2CClCHCH2==null?'-':pollutantss.tabCH2CClCHCH2;
		                var maxtabCH2CClCHCH2=pollutantss.maxtabCH2CClCHCH2==null?'-':pollutantss.maxtabCH2CClCHCH2;
		              var mintabCH2CClCHCH2=pollutantss.mintabCH2CClCHCH2==null?'-':pollutantss.mintabCH2CClCHCH2;
	 				 }
	 			 }else{
	 				      var tabCH2CClCHCH2='-';
		                    var maxtabCH2CClCHCH2='-'; 		                     var mintabCH2CClCHCH2='-';     			 }
		              if(pollutantss.tabCHBr3!=null||pollutantss.maxtabCHBr3!=null||pollutantss.mintabCHBr3!=null){
	 				 if(pollutantss.tabCHBr3==0&&pollutantss.maxtabCHBr3==0&&pollutantss.mintabCHBr3==0){
	 					 var tabCHBr3='-';
		                    var maxtabCHBr3='-'; 		                     var mintabCHBr3='-';     				 }else{
	 				var tabCHBr3=pollutantss.tabCHBr3==null?'-':pollutantss.tabCHBr3;
		                var maxtabCHBr3=pollutantss.maxtabCHBr3==null?'-':pollutantss.maxtabCHBr3;
		              var mintabCHBr3=pollutantss.mintabCHBr3==null?'-':pollutantss.mintabCHBr3;
	 				 }
	 			 }else{
	 				      var tabCHBr3='-';
		                    var maxtabCHBr3='-'; 		                     var mintabCHBr3='-';     			 }
		              if(pollutantss.tabC10H16!=null||pollutantss.maxtabC10H16!=null||pollutantss.mintabC10H16!=null){
	 				 if(pollutantss.tabC10H16==0&&pollutantss.maxtabC10H16==0&&pollutantss.mintabC10H16==0){
	 					 var tabC10H16='-';
		                    var maxtabC10H16='-'; 		                     var mintabC10H16='-';     				 }else{
	 				var tabC10H16=pollutantss.tabC10H16==null?'-':pollutantss.tabC10H16;
		                var maxtabC10H16=pollutantss.maxtabC10H16==null?'-':pollutantss.maxtabC10H16;
		              var mintabC10H16=pollutantss.mintabC10H16==null?'-':pollutantss.mintabC10H16;
	 				 }
	 			 }else{
	 				      var tabC10H16='-';
		                    var maxtabC10H16='-'; 		                     var mintabC10H16='-';     			 }
		              if(pollutantss.tabC4Cl6!=null||pollutantss.maxtabC4Cl6!=null||pollutantss.mintabC4Cl6!=null){
	 				 if(pollutantss.tabC4Cl6==0&&pollutantss.maxtabC4Cl6==0&&pollutantss.mintabC4Cl6==0){
	 					 var tabC4Cl6='-';
		                    var maxtabC4Cl6='-'; 		                     var mintabC4Cl6='-';     				 }else{
	 				var tabC4Cl6=pollutantss.tabC4Cl6==null?'-':pollutantss.tabC4Cl6;
		                var maxtabC4Cl6=pollutantss.maxtabC4Cl6==null?'-':pollutantss.maxtabC4Cl6;
		              var mintabC4Cl6=pollutantss.mintabC4Cl6==null?'-':pollutantss.mintabC4Cl6;
	 				 }
	 			 }else{
	 				      var tabC4Cl6='-';
		                    var maxtabC4Cl6='-'; 		                     var mintabC4Cl6='-';     			 }
		              if(pollutantss.tabCH2Cl2!=null||pollutantss.maxtabCH2Cl2!=null||pollutantss.mintabCH2Cl2!=null){
	 				 if(pollutantss.tabCH2Cl2==0&&pollutantss.maxtabCH2Cl2==0&&pollutantss.mintabCH2Cl2==0){
	 					 var tabCH2Cl2='-';
		                    var maxtabCH2Cl2='-'; 		                     var mintabCH2Cl2='-';     				 }else{
	 				var tabCH2Cl2=pollutantss.tabCH2Cl2==null?'-':pollutantss.tabCH2Cl2;
		                var maxtabCH2Cl2=pollutantss.maxtabCH2Cl2==null?'-':pollutantss.maxtabCH2Cl2;
		              var mintabCH2Cl2=pollutantss.mintabCH2Cl2==null?'-':pollutantss.mintabCH2Cl2;
	 				 }
	 			 }else{
	 				      var tabCH2Cl2='-';
		                    var maxtabCH2Cl2='-'; 		                     var mintabCH2Cl2='-';     			 }
		              
		              if(pollutantss.tabCODmn!=null||pollutantss.maxtabCODmn!=null||pollutantss.mintabCODmn!=null){
		  				 if(pollutantss.tabCODmn==0&&pollutantss.maxtabCODmn==0&&pollutantss.mintabCODmn==0){
		  					 var tabCODmn='-';
		 	                    var maxtabCODmn='-'; 		                     var mintabCODmn='-';     				 }else{
		  				var tabCODmn=pollutantss.tabCODmn==null?'-':pollutantss.tabCODmn;
		 	                var maxtabCODmn=pollutantss.maxtabCODmn==null?'-':pollutantss.maxtabCODmn;
		 	              var mintabCODmn=pollutantss.mintabCODmn==null?'-':pollutantss.mintabCODmn;
		  				 }
		  			 }else{
		  				      var tabCODmn='-';
		 	                    var maxtabCODmn='-'; 		                     var mintabCODmn='-';     			 }
		              
		              if(pollutantss.tabChlorophyll!=null||pollutantss.maxtabChlorophyll!=null||pollutantss.mintabChlorophyll!=null){
		  				 if(pollutantss.tabChlorophyll==0&&pollutantss.maxtabChlorophyll==0&&pollutantss.mintabChlorophyll==0){
		  					 var tabChlorophyll='-';
		 	                    var maxtabChlorophyll='-'; 		                     var mintabChlorophyll='-';     				 }else{
		  				var tabChlorophyll=pollutantss.tabChlorophyll==null?'-':pollutantss.tabChlorophyll;
		 	                var maxtabChlorophyll=pollutantss.maxtabChlorophyll==null?'-':pollutantss.maxtabChlorophyll;
		 	              var mintabChlorophyll=pollutantss.mintabChlorophyll==null?'-':pollutantss.mintabChlorophyll;
		  				 }
		  			 }else{
		  				      var tabChlorophyll='-';
		 	                    var maxtabChlorophyll='-'; 		                     var mintabChlorophyll='-';     			 }
		              if(pollutantss.tabBGAlgae!=null||pollutantss.maxtabBGAlgae!=null||pollutantss.mintabBGAlgae!=null){
			  				 if(pollutantss.tabBGAlgae==0&&pollutantss.maxtabBGAlgae==0&&pollutantss.mintabBGAlgae==0){
			  					 var tabBGAlgae='-';
			 	                    var maxtabBGAlgae='-'; 		                     var mintabBGAlgae='-';     				 }else{
			  				var tabBGAlgae=pollutantss.tabBGAlgae==null?'-':pollutantss.tabBGAlgae;
			 	                var maxtabBGAlgae=pollutantss.maxtabBGAlgae==null?'-':pollutantss.maxtabBGAlgae;
			 	              var mintabBGAlgae=pollutantss.mintabBGAlgae==null?'-':pollutantss.mintabBGAlgae;
			  				 }
			  			 }else{
			  				      var tabBGAlgae='-';
			 	                    var maxtabBGAlgae='-'; 		                     var mintabBGAlgae='-';     			 }
		              if(pollutantss.tabFDOM!=null||pollutantss.maxtabFDOM!=null||pollutantss.mintabFDOM!=null){
			  				 if(pollutantss.tabFDOM==0&&pollutantss.maxtabFDOM==0&&pollutantss.mintabFDOM==0){
			  					 var tabFDOM='-';
			 	                    var maxtabFDOM='-'; 		                     var mintabFDOM='-';     				 }else{
			  				var tabFDOM=pollutantss.tabFDOM==null?'-':pollutantss.tabFDOM;
			 	                var maxtabFDOM=pollutantss.maxtabFDOM==null?'-':pollutantss.maxtabFDOM;
			 	              var mintabFDOM=pollutantss.mintabFDOM==null?'-':pollutantss.mintabFDOM;
			  				 }
			  			 }else{
			  				      var tabFDOM='-';
			 	                    var maxtabFDOM='-'; 		                     var mintabFDOM='-';     			 }
		            
		              
		              if(pollutantss.tabVOCs!=null||pollutantss.maxtabVOCs!=null||pollutantss.mintabVOCs!=null){
			  				 if(pollutantss.tabVOCs==0&&pollutantss.maxtabVOCs==0&&pollutantss.mintabVOCs==0){
			  					 var tabVOCs='-';
			 	                    var maxtabVOCs='-'; 		                     var mintabVOCs='-';     				 }else{
			  				var tabVOCs=pollutantss.tabVOCs==null?'-':pollutantss.tabVOCs;
			 	                var maxtabVOCs=pollutantss.maxtabVOCs==null?'-':pollutantss.maxtabVOCs;
			 	              var mintabVOCs=pollutantss.mintabVOCs==null?'-':pollutantss.mintabVOCs;
			  				 }
			  			 }else{
			  				      var tabVOCs='-';
			 	                    var maxtabVOCs='-'; 		                     var mintabVOCs='-';     			 }
		            
		              if(pollutantss.tabTest1!=null||pollutantss.maxtabTest1!=null||pollutantss.mintabTest1!=null){
			  				 if(pollutantss.tabTest1==0&&pollutantss.maxtabTest1==0&&pollutantss.mintabTest1==0){
			  					 var tabTest1='-';
			 	                    var maxtabTest1='-'; 		                     var mintabTest1='-';     				 }else{
			  				var tabTest1=pollutantss.tabTest1==null?'-':pollutantss.tabTest1;
			 	                var maxtabTest1=pollutantss.maxtabTest1==null?'-':pollutantss.maxtabTest1;
			 	              var mintabTest1=pollutantss.mintabTest1==null?'-':pollutantss.mintabTest1;
			  				 }
			  			 }else{
			  				      var tabTest1='-';
			 	                    var maxtabTest1='-'; 		                     var mintabTest1='-';     			 }
		              if(pollutantss.tabTest2!=null||pollutantss.maxtabTest2!=null||pollutantss.mintabTest2!=null){
			  				 if(pollutantss.tabTest2==0&&pollutantss.maxtabTest2==0&&pollutantss.mintabTest2==0){
			  					 var tabTest2='-';
			 	                    var maxtabTest2='-'; 		                     var mintabTest2='-';     				 }else{
			  				var tabTest2=pollutantss.tabTest2==null?'-':pollutantss.tabTest2;
			 	                var maxtabTest2=pollutantss.maxtabTest2==null?'-':pollutantss.maxtabTest2;
			 	              var mintabTest2=pollutantss.mintabTest2==null?'-':pollutantss.mintabTest2;
			  				 }
			  			 }else{
			  				      var tabTest2='-';
			 	                    var maxtabTest2='-'; 		                     var mintabTest2='-';     			 }
		            
	 		}else{
	 			
	 			var tabChlorophyll='-';
	             var maxtabChlorophyll='-'; 		                    
	             var mintabChlorophyll='-'; 
	             var tabCODmn='-';
	              var maxtabCODmn='-'; 		                     
	              var mintabCODmn='-';     	
	 			
	              var  tabBGAlgae='-';
	              var  tabFDOM='-';
	              
	              var  tabVOCs='-';
	              var  tabTest1='-';
	              var tabTest2='-';
	              var tabTest3='-';
	              var tabTest4='-';
	              var  tabTest5='-';
	             
	              
	              var  maxtabBGAlgae='-';
	              var  maxtabFDOM='-';
	              var  maxtabVOCs='-';
	              var  maxtabTest1='-';
	              var maxtabTest2='-';
	              var maxtabTest3='-';
	              var maxtabTest4='-';
	              var  maxtabTest5='-';
	              
	              var tabTOC="-";
		var tabLJH0="-";
		var tabLJH2="-";
		var tabC2H3Cl="-";
		var tabLJH1="-";
		var tabtC2H2Cl2="-";
		var tabfC2H2CL2="-";
		var tabCHCl3="-";
		var tabC2H2Cl2="-";
		var tabBenzene="-";
		var tabC2HCl3="-";
		var tabC7H8="-";
		var tabC2Cl4="-";
		var tabC6H5Cl="-";
		var tabC6H5C2H5="-";
		var tabC8H10="-";
		var tabC8H8="-";
		var tabC6H4CH32="-";
		var tabC9H12="-";
		var tab14C6H4Cl2="-";
		var tab12C6H4Cl2="-";
	 
		var tabC2H3Cl="-";
		var tabC2H4O="-";
		var tabC3H4O="-";
		var tab11C2H2Cl2="-";
		var tabC3H3N="-";
		var tabCH2CClCHCH2="-";
		var tabCHBr3="-";
		var tabC10H16="-";
		var tabC4Cl6="-";
		var mintabC2H3Cl="-";
		var mintabC2H4O="-";
		var mintabC3H4O="-";
		var mintab11C2H2Cl2="-";
		var mintabC3H3N="-";
		var mintabCH2CClCHCH2="-";
		var mintabCHBr3="-";
		var mintabC10H16="-";
		var mintabC4Cl6="-";
		var maxtabC2H3Cl="-";
		var maxtabC2H4O="-";
		var maxtabC3H4O="-";
		var maxtab11C2H2Cl2="-";
		var maxtabC3H3N="-";
		var maxtabCH2CClCHCH2="-";
		var maxtabCHBr3="-";
		var maxtabC10H16="-";
		var maxtabC4Cl6="-";
		var tabCH2Cl2="-";
		var mintabCH2Cl2="-";
		var maxtabCH2Cl2="-";
	var	maxtabC2HCl3="-";
		
		var mintabTOC="-";
		var mintabLJH0="-";
		var mintabLJH2="-";
		var mintabLJH1="-";
		var mintabtC2H2Cl2="-";
		var mintabfC2H2CL2="-";
		var mintabCHCl3="-";
		var mintabC2H2Cl2="-";
		var mintabBenzene="-";
		var mintabC2HCl3="-";
		var mintabC7H8="-";
		var mintabC2Cl4="-";
		var mintabC6H5Cl="-";
		var mintabC6H5C2H5="-";
		var mintabC8H10="-";
		var mintabC8H8="-";
		var mintabC6H4CH32="-";
		var mintabC9H12="-";
		var mintab14C6H4Cl2="-";
		var mintab12C6H4Cl2="-";
		  var  mintabVOCs='-';
	      var  mintabTest1='-';
	      var mintabTest2='-';
	      var mintabTest3='-';
	      var mintabTest4='-';
	      var  mintabTest5='-';
	      var  mintabBGAlgae='-';
	      var  mintabFDOM='-';
		
		var maxtabTOC="-";
		var maxtabLJH0="-";
		var maxtabLJH2="-";
		var maxtabC2H3Cl="-";
		var maxtabLJH1="-";
		var maxtabtC2H2Cl2="-";
		var maxtabfC2H2CL2="-";
		var maxtabCHCl3="-";
		var maxtabC2H2Cl2="-";
		var maxtabBenzene="-";
		var maxtabC7H8="-";
		var maxtabC2Cl4="-";
		var maxtabC6H5Cl="-";
		var maxtabC6H5C2H5="-";
		var maxtabC8H10="-";
		var maxtabC8H8="-";
		var maxtabC6H4CH32="-";
		var maxtabC9H12="-";
		var maxtab14C6H4Cl2="-";
		var maxtab12C6H4Cl2="-";
				
	 		}
	 		
	 		var th7="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>PH值</th>";
					th7+=" <th style='color: blue;'class='font_num' align='center'>"+tabph+"</th>";	
					th7+=" <th style='color: red;'class='font_num' align='center'>"+maxtabph+"</th>";
					th7+=" <th style='color: red;' class='font_num'align='center'>"+mintabph+"</th>";
					th7+=" <th style='color: red;' class='font_num'align='center'>-</th>";
			  $th7 = $(th7);
	        //清除数据
	        $("#PH_bt").empty();
	        //添加td
	 		$("#PH_bt").append($th7);
	 		
	 		var th8="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>电导率(μS/cm)</th>";
					th8+=" <th style='color: blue;'class='font_num' align='center'>"+tabconductivity+"</th>";	
					th8+=" <th style='color: red;'class='font_num' align='center'>"+maxtabconductivity+"</th>";
					th8+=" <th style='color: red;'class='font_num' align='center'>"+mintabconductivity+"</th>";
					th8+=" <th style='color: red;'class='font_num' align='center'>-</th>";
			  $th8 = $(th8);
	        //清除数据
	        $("#realConductivity_bt").empty();
	        //添加td
	 		$("#realConductivity_bt").append($th8);
	 		
	 		
	 		var th9="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>COD(mg/l)</th>";
					th9+=" <th style='color: blue;' class='font_num';align='center'>"+(tabCOD==null?'-':tabCOD)+"</th>";	
					th9+=" <th style='color: red;' class='font_num';align='center'>"+maxtabCOD+"</th>";
					th9+=" <th style='color: red;' class='font_num';align='center'>"+mintabCOD+"</th>";
					th9+=" <th style='color: red;'class='font_num'; align='center'>-</th>";
			  $th9 = $(th9);
	     //   清除数据         
	        $("#COD_bt").empty();
	       // 添加td    		
	        $("#COD_bt").append($th9);
	 		
	 		
	 		var th10="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>氨氮(mg/l)</th>";
					th10+=" <th style='color: blue;'class='font_num'; align='center'>"+tabNH4+"</th>";	
					th10+=" <th style='color: red;'class='font_num'; align='center'>"+maxtabNH4+"</th>";
					th10+=" <th style='color: red;' class='font_num';align='center'>"+mintabNH4+"</th>";
					th10+=" <th style='color: red;' class='font_num';align='center'>-</th>";
			  $th10 = $(th10);
	       // 清除数据          
	        $("#NH4_bt").empty();
	    //    添加td    		
	        $("#NH4_bt").append($th10);
	 		
	 		
	 		
	 		var th111="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>六价铬(mg/l)</th>";
					th111+=" <th style='color: blue;'class='font_num' align='center'>"+tabCr6+"</th>";	
					th111+=" <th style='color: red;' class='font_num'align='center'>"+maxtabCr6+"</th>";
					th111+=" <th style='color: red;' class='font_num'align='center'>"+mintabCr6+"</th>";
					th111+=" <th style='color: red;' class='font_num'align='center'>-</th>";
			  $th111 = $(th111);
	      //  清除数据           
			  $("#cr6_bt").empty();
	       // 添加td    		
			  $("#cr6_bt").append($th111);
	 		
	 		var thh11="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>温度(℃)</th>";
					thh11+=" <th style='color: blue;'class='font_num'; align='center'>"+tabtemp+"</th>";	
					thh11+=" <th style='color: red;' class='font_num';align='center'>"+maxtabtemp+"</th>";
					thh11+=" <th style='color: red;'class='font_num'; align='center'>"+mintabtemp+"</th>";
					thh11+=" <th style='color: red;'class='font_num'; align='center'>-</th>";
			  $thh11 = $(thh11);
	        //清除数据
	        $("#temp_bt").empty();
	        //添加td
	 		$("#temp_bt").append($thh11);
	 		
	 		var thh22="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>溶解氧(mg/l)</th>";
					thh22+=" <th style='color: blue;'class='font_num' align='center'>"+realDo+"</th>";	
					thh22+=" <th style='color: red;' class='font_num'align='center'>"+maxtabDo+"</th>";
					thh22+=" <th style='color: red;' class='font_num'align='center'>"+mintabDo+"</th>";
					thh22+=" <th style='color: red;'class='font_num' align='center'>-</th>";
			  $thh22 = $(thh22);
	        //清除数据           
	        $("#Do_bt").empty();
	     //   添加td    		
	        $("#Do_bt").append($thh22);
	 		
	 			var thp="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>挥发酚(mg/l)</th>";
					thp+=" <th style='color: blue;' class='font_num'align='center'>"+tabPhe+"</th>";	
					thp+=" <th style='color: red;' class='font_num'align='center'>"+maxtabPhe+"</th>";
					thp+=" <th style='color: red;' class='font_num'align='center'>"+mintabPhe+"</th>";
					thp+=" <th align='center'>-</th>";
			  $thp = $(thp);
	        //清除数据
	        $("#Phe_bt").empty();
	        //添加td
	 		$("#Phe_bt").append($thp);
	 		
	 		
	 		/*if(rid==75501330004){
	 		var th77="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>COD(mg/l)</th>";
					th77+=" <th style='color: blue;' align='center'>-</th>";	
					th77+=" <th style='color: red;' align='center'>-</th>";
					th77+=" <th style='color: red;' align='center'>-</th>";
					th77+=" <th align='center'>-</th>";
	 		}else{
	 		var th77="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>COD(mg/l)</th>";
					th77+=" <th style='color: blue;' align='center'>"+realcod+"</th>";	
					th77+=" <th style='color: red;' align='center'>"+maxcod+"</th>";
					th77+=" <th style='color: red;' align='center'>"+mincod+"</th>";
					th77+=" <th align='center'>-</th>";
	 		//}
	 		
	 	
			  $th77 = $(th77);
	        //清除数据
	        $("#COD").empty();
	        //添加td
	 		$("#COD").append($th77);
	 		*/
	 		var th88="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>浊度(mg/l)</th>";
					th88+=" <th style='color: blue;'class='font_num' align='center'>"+tabTurbidity+"</th>";	
					th88+=" <th style='color: red;' class='font_num'align='center'>"+maxtabTurbidity+"</th>";
					th88+=" <th style='color: red;' class='font_num'align='center'>"+mintabTurbidity+"</th>";
					th88+=" <th align='center'>-</th>";
			  $th88 = $(th88);
	        //清除数据
	        $("#Turbidity_bt").empty();
	        //添加td
	 		$("#Turbidity_bt").append($th88);
	 		
	 		
	 		var th99="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>总磷(mg/l)</th>";
					th99+=" <th style='color: blue;' class='font_num'align='center'>"+tabTP+"</th>";	
					th99+=" <th style='color: red;' class='font_num'align='center'>"+maxtabTP+"</th>style='color: blue;'";
					th99+=" <th style='color: red;' class='font_num'align='center'>"+mintabTP+"</th>";
					th99+=" <th align='center'>-</th>";
			  $th99 = $(th99);
	        //清除数据         
	        $("#phosphor_bt").empty();
	       // 添加td    		
	        $("#phosphor_bt").append($th99);
	        var th991="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>总氮(mg/l)</th>";
					th991+=" <th style='color: blue;' class='font_num'align='center'>"+tabTN+"</th>";	
					th991+=" <th style='color: red;' class='font_num'align='center'>"+maxtabTN+"</th>style='color: blue;'";
					th991+=" <th style='color: red;'class='font_num' align='center'>"+mintabTN+"</th>";
					th991+=" <th align='center'>-</th>";
			  $th991 = $(th991);
	        //清除数据         
	        $("#TN_bt").empty();
	       // 添加td    		
	        $("#TN_bt").append($th991);
	        
	 		/*if(rid==75501330004){
	 		var th100="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>硝酸盐氮(mg/l)</th>";
					th100+=" <th style='color: blue;' align='center'>-</th>";	
					th100+=" <th style='color: red;' align='center'>-</th>";
					th100+=" <th style='color: red;' align='center'>-</th>";
					th100+=" <th align='center'>-</th>";
	 		}else{*/
	 		var th100="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>硝酸盐氮(mg/l)</th>";
					th100+=" <th style='color: blue;' class='font_num'align='center'>"+tabNO3+"</th>";	
					th100+=" <th style='color: red;' class='font_num'align='center'>"+maxtabNO3+"</th>";
					th100+=" <th style='color: red;' class='font_num'align='center'>"+mintabNO3+"</th>";
					th100+=" <th align='center'>-</th>";
	 	
			  $th100 = $(th100);
	        //清除数据
	        $("#NO3_bt").empty();
	          $("#NO3_bt").append($th100);
	          
	          var th100s="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>阴离子表面活性剂(mg/l)</th>";
					th100s+=" <th style='color: blue;' class='font_num'align='center'>"+tabAn+"</th>";	
					th100s+=" <th style='color: red;' class='font_num'align='center'>"+maxtabAn+"</th>";
					th100s+=" <th style='color: red;' class='font_num'align='center'>"+mintabAn+"</th>";
					th100s+=" <th align='center'>-</th>";
		
			  $th100s = $(th100s);
	     //清除数据
	     $("#An_bt").empty();
	       $("#An_bt").append($th100s);
	       var t1="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>氰化物(mg/l)</th>";
					t1+=" <th style='color: blue;' class='font_num'align='center'>"+tabCN+"</th>";	
					t1+=" <th style='color: red;' class='font_num'align='center'>"+maxtabCN+"</th>";
					t1+=" <th style='color: red;' class='font_num'align='center'>"+mintabCN+"</th>";
					t1+=" <th align='center'>-</th>";
	 	
			  $t1 = $(t1);
	        //清除数据
	        $("#CN_bt").empty();
	        $("#CN_bt").append($t1);
	        var t2="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>铅(mg/l)</th>";
					t2+=" <th style='color: blue;' class='font_num'align='center'>"+tabPb+"</th>";	
					t2+=" <th style='color: red;' class='font_num'align='center'>"+maxtabPb+"</th>";
					t2+=" <th style='color: red;'class='font_num' align='center'>"+mintabPb+"</th>";
					t2+=" <th align='center'>-</th>";
	 	
			  $t2 = $(t2);
	        //清除数据
	        $("#Pb_bt").empty();
	        $("#Pb_bt").append($t2);
	         var t3="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>总铬(mg/l)</th>";
					t3+=" <th style='color: blue;'class='font_num' align='center'>"+tabCd+"</th>";	
					t3+=" <th style='color: red;' class='font_num'align='center'>"+maxtabCd+"</th>";
					t3+=" <th style='color: red;' class='font_num'align='center'>"+mintabCd+"</th>";
					t3+=" <th align='center'>-</th>";
	 	
			  $t3 = $(t3);
	        //清除数据
	        $("#Cd_bt").empty();
	        $("#Cd_bt").append($t3);
	         var t4="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>总铜(mg/l)</th>";
					t4+=" <th style='color: blue;'class='font_num' align='center'>"+tabCu+"</th>";	
					t4+=" <th style='color: red;' class='font_num'align='center'>"+maxtabCu+"</th>";
					t4+=" <th style='color: red;'class='font_num' align='center'>"+mintabCu+"</th>";
					t4+=" <th align='center'>-</th>";
	 	
			  $t4 = $(t4);
	        //清除数据
	        $("#Cu_bt").empty();
	        $("#Cu_bt").append($t4);
	         var t5="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>汞(mg/l)</th>";
					t5+=" <th style='color: blue;'class='font_num' align='center'>"+tabHg+"</th>";	
					t5+=" <th style='color: red;' class='font_num'align='center'>"+maxtabHg+"</th>";
					t5+=" <th style='color: red;' class='font_num'align='center'>"+mintabHg+"</th>";
					t5+=" <th align='center'>-</th>";
	 	
			  $t5 = $(t5);
	        //清除数据
	        $("#Hg_bt").empty();
	        $("#Hg_bt").append($t5);
	        
	         var t6="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>砷(mg/l)</th>";
					t6+=" <th style='color: blue;'class='font_num' align='center'>"+tabAs+"</th>";	
					t6+=" <th style='color: red;' class='font_num'align='center'>"+maxtabAs+"</th>";
					t6+=" <th style='color: red;' class='font_num'align='center'>"+mintabAs+"</th>";
					t6+=" <th align='center'>-</th>";
	 	
			  $t6 = $(t6);
	        //清除数据
	        $("#As_bt").empty();
	        $("#As_bt").append($t6);
	        
	        var t7="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>铁(mg/l)</th>";
					t7+=" <th style='color: blue;'class='font_num' align='center'>"+tabFe+"</th>";	
					t7+=" <th style='color: red;' class='font_num'align='center'>"+maxtabFe+"</th>";
					t7+=" <th style='color: red;' class='font_num'align='center'>"+mintabFe+"</th>";
					t7+=" <th align='center'>-</th>";
	 	
			  $t7 = $(t7);
	        //清除数据
	        $("#Fe_bt").empty();
	        $("#Fe_bt").append($t7);
	        
	        var t8="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>锰(mg/l)</th>";
					t8+=" <th style='color: blue;'class='font_num' align='center'>"+tabMn+"</th>";	
					t8+=" <th style='color: red;' class='font_num'align='center'>"+maxtabMn+"</th>";
					t8+=" <th style='color: red;' class='font_num'align='center'>"+mintabMn+"</th>";
					t8+=" <th align='center'>-</th>";
	 	
			  $t8 = $(t8);
	        //清除数据
	        $("#Mn_bt").empty();
	        $("#Mn_bt").append($t8);
	        
	          var t9="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>总镍(mg/l)</th>";
					t9+=" <th style='color: blue;'class='font_num' align='center'>"+tabNi+"</th>";	
					t9+=" <th style='color: red;' class='font_num'align='center'>"+maxtabNi+"</th>";
					t9+=" <th style='color: red;'class='font_num' align='center'>"+mintabNi+"</th>";
					t9+=" <th align='center'>-</th>";
	 	
			  $t9 = $(t9);
	        //清除数据
	        $("#Ni_bt").empty();
	        $("#Ni_bt").append($t9);
	        
	         var t10="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>氟化物(mg/l)</th>";
					t10+=" <th style='color: blue;' class='font_num'align='center'>"+tabF+"</th>";	
					t10+=" <th style='color: red;' class='font_num'align='center'>"+maxtabF+"</th>";
					t10+=" <th style='color: red;' class='font_num'align='center'>"+mintabF+"</th>";
					t10+=" <th align='center'>-</th>";
	 	
			  $t10 = $(t10);
	        //清除数据
	        $("#F_bt").empty();
	        $("#F_bt").append($t10);
	        
	        var t11="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>硫化物(mg/l)</th>";
					t11+=" <th style='color: blue;'class='font_num' align='center'>"+tabS+"</th>";	
					t11+=" <th style='color: red;' class='font_num'align='center'>"+maxtabS+"</th>";
					t11+=" <th style='color: red;' class='font_num'align='center'>"+mintabS+"</th>";
					t11+=" <th align='center'>-</th>";
	 	
			  $t11 = $(t11);
	        //清除数据
	        $("#S_bt").empty();
	        $("#S_bt").append($t11);
	        
	          var t12="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>水质综合毒性(mg/l)</th>";
					t12+=" <th style='color: blue;' class='font_num'align='center'>"+tabPoison+"</th>";	
					t12+=" <th style='color: red;' class='font_num'align='center'>"+maxtabPoison+"</th>";
					t12+=" <th style='color: red;' class='font_num'align='center'>"+mintabPoison+"</th>";
					t12+=" <th align='center'>-</th>";
	 	
			  $t12 = $(t12);
	        //清除数据
	        $("#Poison_bt").empty();
	        $("#Poison_bt").append($t12);
	        
	         var t13="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>有机物水质(mg/l)</th>";
					t13+=" <th style='color: blue;' class='font_num'align='center'>"+tabOC+"</th>";	
					t13+=" <th style='color: red;' class='font_num'align='center'>"+maxtabOC+"</th>";
					t13+=" <th style='color: red;' class='font_num'align='center'>"+mintabOC+"</th>";
					t13+=" <th align='center'>-</th>";
	 	
			  $t13 = $(t13);
	        //清除数据
	        $("#OC_bt").empty();
	        $("#OC_bt").append($t13);
	       
	         var t14="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>锌(mg/l)</th>";
					t14+=" <th style='color: blue;' class='font_num'align='center'>"+tabZn+"</th>";	
					t14+=" <th style='color: red;'class='font_num' align='center'>"+maxtabZn+"</th>";
					t14+=" <th style='color: red;' class='font_num'align='center'>"+mintabZn+"</th>";
					t14+=" <th align='center'>-</th>";
	 	
			  $t14 = $(t14);
	        //清除数据
	        $("#Zn_bt").empty();
	        $("#Zn_bt").append($t14);
	 		/* if(rid==75501330004){
	 		var th111="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>固体悬浮物(mg/l)</th>";
					th111+=" <th style='color: blue;' align='center'>-</th>";	
					th111+=" <th style='color: red;' align='center'>-</th>";
					th111+=" <th style='color: red;' align='center'>-</th>";
					S+=" <th align='center'>-</th>";
	 		}else{*/
	 		
	 		
	 		
	 		
	 		var td1="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>TOC(mg/l)</th>";
					td1+=" <th style='color: blue;' class='font_num'align='center'>"+tabTOC+"</th>";	
					td1+=" <th style='color: red;'class='font_num' align='center'>"+maxtabTOC+"</th>";
					td1+=" <th style='color: red;' class='font_num'align='center'>"+mintabTOC+"</th>";
					td1+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td1 = $(td1);
	        //清除数据
	        $("#tabTOC_bt").empty();
	        //添加td
	 		$("#tabTOC_bt").append($td1);
	 		
	 		var td2="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>LJH0(mg/l)</th>";
					td2+=" <th style='color: blue;' class='font_num'align='center'>"+tabLJH0+"</th>";	
					td2+=" <th style='color: red;'class='font_num' align='center'>"+maxtabLJH0+"</th>";
					td2+=" <th style='color: red;' class='font_num'align='center'>"+mintabLJH0+"</th>";
					td2+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td2 = $(td2);
	        //清除数据
	        $("#tabLJH0_bt").empty();
	        //添加td
	 		$("#tabLJH0_bt").append($td2);
	 		
	 	var td3="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>LJH1(mg/l)</th>";
					td3+=" <th style='color: blue;' class='font_num'align='center'>"+tabLJH1+"</th>";	
					td3+=" <th style='color: red;'class='font_num' align='center'>"+maxtabLJH1+"</th>";
					td3+=" <th style='color: red;' class='font_num'align='center'>"+mintabLJH1+"</th>";
					td3+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td3 = $(td3);
	        //清除数据
	        $("#tabLJH1_bt").empty();
	        //添加td
	 		$("#tabLJH1_bt").append($td3);
	 		var td4="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>LJH2(mg/l)</th>";
					td4+=" <th style='color: blue;' class='font_num'align='center'>"+tabLJH2+"</th>";	
					td4+=" <th style='color: red;'class='font_num' align='center'>"+maxtabLJH2+"</th>";
					td4+=" <th style='color: red;' class='font_num'align='center'>"+mintabLJH2+"</th>";
					td4+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td4 = $(td4);
	        //清除数据
	        $("#tabLJH2_bt").empty();
	        //添加td
	 		$("#tabLJH2_bt").append($td4);
	 		var td5="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>反式二氯乙烯(mg/l)</th>";
					td5+=" <th style='color: blue;' class='font_num'align='center'>"+tabtC2H2Cl2+"</th>";	
					td5+=" <th style='color: red;'class='font_num' align='center'>"+maxtabtC2H2Cl2+"</th>";
					td5+=" <th style='color: red;' class='font_num'align='center'>"+mintabtC2H2Cl2+"</th>";
					td5+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td5 = $(td5);
	        //清除数据
	        $("#tabtC2H2Cl2_bt").empty();
	        //添加td
	 		$("#tabtC2H2Cl2_bt").append($td5);
	 		var td6="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>顺式二氯乙烯(mg/l)</th>";
					td6+=" <th style='color: blue;' class='font_num'align='center'>"+tabfC2H2CL2+"</th>";	
					td6+=" <th style='color: red;'class='font_num' align='center'>"+maxtabfC2H2CL2+"</th>";
					td6+=" <th style='color: red;' class='font_num'align='center'>"+mintabfC2H2CL2+"</th>";
					td6+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td6 = $(td6);
	        //清除数据
	        $("#tabfC2H2CL2_bt").empty();
	        //添加td
	 		$("#tabfC2H2CL2_bt").append($td6);
	 		var td7="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>三氯甲烷(mg/l)</th>";
					td7+=" <th style='color: blue;' class='font_num'align='center'>"+tabCHCl3+"</th>";	
					td7+=" <th style='color: red;'class='font_num' align='center'>"+maxtabCHCl3+"</th>";
					td7+=" <th style='color: red;' class='font_num'align='center'>"+mintabCHCl3+"</th>";
					td7+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td7 = $(td7);
	        //清除数据
	        $("#tabCHCl3_bt").empty();
	        //添加td
	 		$("#tabCHCl3_bt").append($td7);
	 		var td8="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>二氯乙烯(mg/l)</th>";
					td8+=" <th style='color: blue;' class='font_num'align='center'>"+tabC2H2Cl2+"</th>";	
					td8+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC2H2Cl2+"</th>";
					td8+=" <th style='color: red;' class='font_num'align='center'>"+mintabC2H2Cl2+"</th>";
					td8+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td8 = $(td8);
	        //清除数据
	        $("#tabC2H2Cl2_bt").empty();
	        //添加td
	 		$("#tabC2H2Cl2_bt").append($td8);
	 		var td9="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>苯(mg/l)</th>";
					td9+=" <th style='color: blue;' class='font_num'align='center'>"+tabBenzene+"</th>";	
					td9+=" <th style='color: red;'class='font_num' align='center'>"+maxtabBenzene+"</th>";
					td9+=" <th style='color: red;' class='font_num'align='center'>"+mintabBenzene+"</th>";
					td9+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td9 = $(td9);
	        //清除数据
	        $("#tabBenzene_bt").empty();
	        //添加td
	 		$("#tabBenzene_bt").append($td9);
	 		var td10="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>三氯乙烯(mg/l)</th>";
					td10+=" <th style='color: blue;' class='font_num'align='center'>"+tabC2HCl3+"</th>";	
					td10+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC2HCl3+"</th>";
					td10+=" <th style='color: red;' class='font_num'align='center'>"+mintabC2HCl3+"</th>";
					td10+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td10 = $(td10);
	        //清除数据
	        $("#tabC2HCl3_bt").empty();
	        //添加td
	 		$("#tabC2HCl3_bt").append($td10);
	 		var td12="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>甲苯(mg/l)</th>";
					td12+=" <th style='color: blue;' class='font_num'align='center'>"+tabC7H8+"</th>";	
					td12+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC7H8+"</th>";
					td12+=" <th style='color: red;' class='font_num'align='center'>"+mintabC7H8+"</th>";
					td12+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td12 = $(td12);
	        //清除数据
	        $("#tabC7H8_bt").empty();
	        //添加td
	 		$("#tabC7H8_bt").append($td12);
	 		var td13="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>四氯乙烯(mg/l)</th>";
					td13+=" <th style='color: blue;' class='font_num'align='center'>"+tabC2Cl4+"</th>";	
					td13+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC2Cl4+"</th>";
					td13+=" <th style='color: red;' class='font_num'align='center'>"+mintabC2Cl4+"</th>";
					td13+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td13 = $(td13);
	        //清除数据
	        $("#tabC2Cl4_bt").empty();
	        //添加td
	 		$("#tabC2Cl4_bt").append($td13);
	 		var td14="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>氯苯(mg/l)</th>";
					td14+=" <th style='color: blue;' class='font_num'align='center'>"+tabC6H5Cl+"</th>";	
					td14+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC6H5Cl+"</th>";
					td14+=" <th style='color: red;' class='font_num'align='center'>"+mintabC6H5Cl+"</th>";
					td14+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td14 = $(td14);
	        //清除数据
	        $("#tabC6H5Cl_bt").empty();
	        //添加td
	 		$("#tabC6H5Cl_bt").append($td14);
	 		var td15="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>乙苯(mg/l)</th>";
					td15+=" <th style='color: blue;' class='font_num'align='center'>"+tabC6H5C2H5+"</th>";	
					td15+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC6H5C2H5+"</th>";
					td15+=" <th style='color: red;' class='font_num'align='center'>"+mintabC6H5C2H5+"</th>";
					td15+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td15 = $(td15);
	        //清除数据
	        $("#tabC6H5C2H5_bt").empty();
	        //添加td
	 		$("#tabC6H5C2H5_bt").append($td15);
	 		var td16="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>二甲苯(mg/l)</th>";
					td16+=" <th style='color: blue;' class='font_num'align='center'>"+tabC8H10+"</th>";	
					td16+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC8H10+"</th>";
					td16+=" <th style='color: red;' class='font_num'align='center'>"+mintabC8H10+"</th>";
					td16+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td16 = $(td16);
	        //清除数据
	        $("#tabC8H10_bt").empty();
	        //添加td
	 		$("#tabC8H10_bt").append($td16);
	 		var td17="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>苯乙烯(mg/l)</th>";
					td17+=" <th style='color: blue;' class='font_num'align='center'>"+tabC8H8+"</th>";	
					td17+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC8H8+"</th>";
					td17+=" <th style='color: red;' class='font_num'align='center'>"+mintabC8H8+"</th>";
					td17+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td17 = $(td17);
	        //清除数据
	        $("#tabC8H8_bt").empty();
	        //添加td
	 		$("#tabC8H8_bt").append($td17);
	 		var td18="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>邻二甲苯(mg/l)</th>";
					td18+=" <th style='color: blue;' class='font_num'align='center'>"+tabC6H4CH32+"</th>";	
					td18+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC6H4CH32+"</th>";
					td18+=" <th style='color: red;' class='font_num'align='center'>"+mintabC6H4CH32+"</th>";
					td18+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td18 = $(td18);
	        //清除数据
	        $("#tabC6H4CH32_bt").empty();
	        //添加td
	 		$("#tabC6H4CH32_bt").append($td18);
	 		var td19="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>异丙苯(mg/l)</th>";
					td19+=" <th style='color: blue;' class='font_num'align='center'>"+tabC9H12+"</th>";	
					td19+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC9H12+"</th>";
					td19+=" <th style='color: red;' class='font_num'align='center'>"+mintabC9H12+"</th>";
					td19+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td19 = $(td19);
	        //清除数据
	        $("#tabC9H12").empty();
	        //添加td
	 		$("#tabC9H12").append($td19);
	 		var td20="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>14二氯苯(mg/l)</th>";
					td20+=" <th style='color: blue;' class='font_num'align='center'>"+tab14C6H4Cl2+"</th>";	
					td20+=" <th style='color: red;'class='font_num' align='center'>"+tab14C6H4Cl2+"</th>";
					td20+=" <th style='color: red;' class='font_num'align='center'>"+tab14C6H4Cl2+"</th>";
					td20+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td20 = $(td20);
	        //清除数据
	        $("#tab14C6H4Cl2_bt").empty();
	        //添加td
	 		$("#tab14C6H4Cl2_bt").append($td20);
	 		var td21="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>12二氯苯(mg/l)</th>";
					td21+=" <th style='color: blue;' class='font_num'align='center'>"+tab12C6H4Cl2+"</th>";	
					td21+=" <th style='color: red;'class='font_num' align='center'>"+tab12C6H4Cl2+"</th>";
					td21+=" <th style='color: red;' class='font_num'align='center'>"+tab12C6H4Cl2+"</th>";
					td21+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td21 = $(td21);
	        //清除数据
	        $("#tab12C6H4Cl2_bt").empty();
	        //添加td
	 		$("#tab12C6H4Cl2_bt").append($td21);
	 		var td22="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>氯乙烯(mg/l)</th>";
					td22+=" <th style='color: blue;' class='font_num'align='center'>"+tabC2H3Cl+"</th>";	
					td22+=" <th style='color: red;'class='font_num' align='center'>"+tabC2H3Cl+"</th>";
					td22+=" <th style='color: red;' class='font_num'align='center'>"+tabC2H3Cl+"</th>";
					td22+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td22 = $(td22);
	        //清除数据
	        $("#tabC2H3Cl_bt").empty();
	        //添加td
	 		$("#tabC2H3Cl_bt").append($td22);
	 		var td23="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>氯丁二烯(mg/l)</th>";
					td23+=" <th style='color: blue;' class='font_num'align='center'>"+tabCH2CClCHCH2+"</th>";	
					td23+=" <th style='color: red;'class='font_num' align='center'>"+maxtabCH2CClCHCH2+"</th>";
					td23+=" <th style='color: red;' class='font_num'align='center'>"+mintabCH2CClCHCH2+"</th>";
					td23+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td23 = $(td23);
	        //清除数据
	        $("#tabCH2CClCHCH2_bt").empty();
	        //添加td
	 		$("#tabCH2CClCHCH2_bt").append($td23);
	 		var td24="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>乙醛(mg/l)</th>";
					td24+=" <th style='color: blue;' class='font_num'align='center'>"+tabC2H4O+"</th>";	
					td24+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC2H4O+"</th>";
					td24+=" <th style='color: red;' class='font_num'align='center'>"+mintabC2H4O+"</th>";
					td24+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td24 = $(td24);
	        //清除数据
	        $("#tabC2H4O_bt").empty();
	        //添加td
	 		$("#tabC2H4O_bt").append($td24);
	 		var td25="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>丙烯醛(mg/l)</th>";
					td25+=" <th style='color: blue;' class='font_num'align='center'>"+tabC3H4O+"</th>";	
					td25+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC3H4O+"</th>";
					td25+=" <th style='color: red;' class='font_num'align='center'>"+mintabC3H4O+"</th>";
					td25+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td25 = $(td25);
	        //清除数据
	        $("#tabC3H4O_bt").empty();
	        //添加td
	 		$("#tabC3H4O_bt").append($td25);
	 		var td26="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>11二氯乙烯(mg/l)</th>";
					td26+=" <th style='color: blue;' class='font_num'align='center'>"+tab11C2H2Cl2+"</th>";	
					td26+=" <th style='color: red;'class='font_num' align='center'>"+maxtab11C2H2Cl2+"</th>";
					td26+=" <th style='color: red;' class='font_num'align='center'>"+mintab11C2H2Cl2+"</th>";
					td26+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td26 = $(td26);
	        //清除数据
	        $("#tab11C2H2Cl2_bt").empty();
	        //添加td
	 		$("#tab11C2H2Cl2_bt").append($td26);
	 		var td27="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>丙烯腈(mg/l)</th>";
					td27+=" <th style='color: blue;' class='font_num'align='center'>"+tabC3H3N+"</th>";	
					td27+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC3H3N+"</th>";
					td27+=" <th style='color: red;' class='font_num'align='center'>"+mintabC3H3N+"</th>";
					td27+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td27 = $(td27);
	        //清除数据
	        $("#tabC3H3N_bt").empty();
	        //添加td
	 		$("#tabC3H3N_bt").append($td27);
	 		var td28="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>三溴甲烷(mg/l)</th>";
					td28+=" <th style='color: blue;' class='font_num'align='center'>"+tabCHBr3+"</th>";	
					td28+=" <th style='color: red;'class='font_num' align='center'>"+maxtabCHBr3+"</th>";
					td28+=" <th style='color: red;' class='font_num'align='center'>"+mintabCHBr3+"</th>";
					td28+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td28 = $(td28);
	        //清除数据
	        $("#tabCHBr3").empty();
	        //添加td
	 		$("#tabCHBr3").append($td28);
	 		var td29="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>松节油(mg/l)</th>";
					td29+=" <th style='color: blue;' class='font_num'align='center'>"+tabC10H16+"</th>";	
					td29+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC10H16+"</th>";
					td29+=" <th style='color: red;' class='font_num'align='center'>"+mintabC10H16+"</th>";
					td29+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td29 = $(td29);
	        //清除数据
	        $("#tabC10H16_bt").empty();
	        //添加td
	 		$("#tabC10H16_bt").append($td29);
	 		var td30="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>六氯丁二烯(mg/l)</th>";
					td30+=" <th style='color: blue;' class='font_num'align='center'>"+tabC4Cl6+"</th>";	
					td30+=" <th style='color: red;'class='font_num' align='center'>"+maxtabC4Cl6+"</th>";
					td30+=" <th style='color: red;' class='font_num'align='center'>"+mintabC4Cl6+"</th>";
					td30+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td30 = $(td30);
	        //清除数据
	        $("#tabC4Cl6_bt").empty();
	        //添加td
	 		$("#tabC4Cl6_bt").append($td30);
	 		var td31="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>二氯甲烷(mg/l)</th>";
					td31+=" <th style='color: blue;' class='font_num'align='center'>"+tabCH2Cl2+"</th>";	
					td31+=" <th style='color: red;'class='font_num' align='center'>"+maxtabCH2Cl2+"</th>";
					td31+=" <th style='color: red;' class='font_num'align='center'>"+mintabCH2Cl2+"</th>";
					td31+=" <th align='center'>-</th>";
	 		//}
	 	
	 		
			  $td31 = $(td31);
	        //清除数据
	        $("#tabCH2Cl2_bt").empty();
	        //添加td
	 		$("#tabCH2Cl2_bt").append($td31);
	 		
	 		var td32="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>COD-mn(mg/l)</th>";
			td32+=" <th style='color: blue;' class='font_num'align='center'>"+tabCODmn+"</th>";	
			td32+=" <th style='color: red;'class='font_num' align='center'>"+maxtabCODmn+"</th>";
			td32+=" <th style='color: red;' class='font_num'align='center'>"+mintabCODmn+"</th>";
			td32+=" <th align='center'>-</th>";
		//}

		
	  $td32 = $(td32);
	//清除数据
	$("#tabCODmn_bt").empty();
	//添加td
		$("#tabCODmn_bt").append($td32);
		var td33="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>叶绿素A(mg/l)</th>";
		td33+=" <th style='color: blue;' class='font_num'align='center'>"+tabChlorophyll+"</th>";	
		td33+=" <th style='color: red;'class='font_num' align='center'>"+maxtabChlorophyll+"</th>";
		td33+=" <th style='color: red;' class='font_num'align='center'>"+mintabChlorophyll+"</th>";
		td33+=" <th align='center'>-</th>";
	//}


	$td33 = $(td33);
	//清除数据
	$("#tabChlorophyll_bt").empty();
	//添加td
	$("#tabChlorophyll_bt").append($td33);
	 		
	 		

	var td44="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>蓝绿藻(mg/l)</th>";
	td44+=" <th style='color: blue;' class='font_num'align='center'>"+tabBGAlgae+"</th>";	
	td44+=" <th style='color: red;'class='font_num' align='center'>"+maxtabBGAlgae+"</th>";
	td44+=" <th style='color: red;' class='font_num'align='center'>"+mintabBGAlgae+"</th>";
	td44+=" <th align='center'>-</th>";
	//}

	$td44 = $(td44);
	//清除数据
	$("#tabBGAlgae_bt").empty();
	//添加td
	$("#tabBGAlgae_bt").append($td44);


	var td46="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>VOCs(mg/l)</th>";
	td46+=" <th style='color: blue;' class='font_num'align='center'>"+tabVOCs+"</th>";	
	td46+=" <th style='color: red;'class='font_num' align='center'>"+tabVOCs+"</th>";
	td46+=" <th style='color: red;' class='font_num'align='center'>"+tabVOCs+"</th>";
	td46+=" <th align='center'>-</th>";
	//}

	$td46 = $(td46);
	//清除数据
	$("#tabVOCs_bt").empty();
	//添加td
	$("#tabVOCs_bt").append($td46);

	var td45="<th align='center' style='font-family: 微软雅黑;font-size: 16px;'>FDOM(mg/l)</th>";
	td45+=" <th style='color: blue;' class='font_num'align='center'>"+tabFDOM+"</th>";	
	td45+=" <th style='color: red;'class='font_num' align='center'>"+tabFDOM+"</th>";
	td45+=" <th style='color: red;' class='font_num'align='center'>"+tabFDOM+"</th>";
	td45+=" <th align='center'>-</th>";
	//}

	$td45 = $(td45);
	//清除数据
	$("#tabFDOM_bt").empty();
	//添加td
	$("#tabFDOM_bt").append($td45);


	 		
	 		var s4= document.getElementById("table_bt");//获取水质表格
	 		console.log(pollutantNames)
	 		for(var i=2;i<s4.rows.length;i++){
	 			var dataValue=s4.rows[i].cells[0].innerHTML;//获取表格每行第1列的值
	 			var dataValues=dataValue.split(/\(.*?\)/);
	 			s4.rows[i].style.display="none";//默认为隐藏
	 			for(var b=0;b<pollutantNames.length;b++){
	 				var dataName=pollutantNames[b].pollType;
	 				var dataNames=dataName+',';
	 				if(dataValues == dataNames){
	     				s4.rows[i].style.display="";//将有这项的显示
	     			}
	 			}
	 		}
	        
	        
	        
	        
			}
		   })
	}

/*function  load_data3(rid){
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
		    
	     
	       if(keystate[0]!=undefined &&keystate[0]!=null){
		   if(keystate[0].strTime!=undefined &&keystate[0].strTime!=null){
			    var time_id= keystate[0].strTime;
			 $("#id_key").show(); 
			 //  alert('离线时间:'+time_id)
			 $("#id_key").val(time_id)
		  }
		   }
		    if(keystate[1]!=undefined &&keystate[1]!=null){
		   if( keystate[1].strTime!=undefined && keystate[1].strTime!=null){
			    var time_ls= keystate[1].strTime;
			   if(rid=='75501330001'){
				   $("#ls_key").hide();
			   }else{
			 $("#ls_key").show(); 
			//  alert('离线时间:'+time_ls)
             $("#ls_key").val(time_ls) 
             }
		  }}
			  if(keystate[2]!=undefined &&keystate[2]!=null){
		   if(keystate[2].strTime!=undefined && keystate[2].strTime!=null){
			    var time_is= keystate[2].strTime;
			 $("#is_key").show(); 
			 $("#is_key").val(time_is)
			//   alert('离线时间:'+time_is)
		  }
		  }            //清除数据
           $("#log").empty();
          if(logs.length==0){
        	 var log="<tr><th   align='center' '>-</th>";
				log+="  <th  style='color: blue;'class='font_num'; align='center'>-</th>";
				log+="  <th  style='color: blue;'class='font_num'; align='center'>-</th>";
				log+="  <th  style='color: blue;'class='font_num'; align='center'>-</th>";
				log+="  <th  style='color: blue;'class='font_num'; align='center'>-</th></tr>";
				 $log = $(log);
           //添加td
    		$("#log").append($log);
          }else{
		    for(i=0;i<logs.length;i++){
		    //	console.log(logs[i])
		    	var log="<tr><th   align='center' '>"+logs[i].updataTime+"</th>";
				log+="  <th  style='color: blue;'class='font_num'; align='center'>"+logs[i].userName+"</th>";
				log+="  <th  style='color: blue;'class='font_num'; align='center'>"+logs[i].userIp+"</th>";
				log+="  <th  style='color: blue;'class='font_num'; align='center'>"+logs[i].companyName+"</th>";
				log+="  <th  style='color: blue;'class='font_num'; align='center'>"+logs[i].describe+"</th></tr>";
				 $log = $(log);
           //添加td
    		$("#log").append($log);
    		}
		    }
		
        
           
           
           
           
		}
	   })
	   
	   }*/




