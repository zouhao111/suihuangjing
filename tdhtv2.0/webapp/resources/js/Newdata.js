function  load_newdata(rid){
	   $.ajax({
          url:"../data/dataNew2?rid="+rid,
		type:"post",
		async: false,
		dataType:"json",
		success:function(result){
		   var list=result.list;
		  console.log(list)
		   var waterquality= list[0];
		   var ztraffic= list[1];
		   var url= list[2];
		   var companyconfig=list[3];
		   
		   $("#newData").empty();
		   for(i=0;i<waterquality.length;i++){
			  for(j=0;j<ztraffic.length;j++){
				  
		    if(ztraffic[j]!=null&&waterquality[i]!=null&&companyconfig[i]!=null){
		    	
		   if(ztraffic[j].rid==waterquality[i].rid){
			//  console.log(ztraffic[j])
		   
		  
			    var rid=ztraffic[j].rid;
			    
			   var companyName=companyconfig[i].companyName;
			//   console.log(companyName)
			  var supplyIndustrial=ztraffic[j].supplyIndustrial==null?'-':ztraffic[j].supplyIndustrial.toFixed(1);		//工业给水
	          var supplyLiving=ztraffic[j].supplyLiving==null?'-':ztraffic[j].supplyLiving.toFixed(1);			//生活给水
	          var drainageIndustrial=ztraffic[j].drainageIndustrial==null?'-':ztraffic[j].drainageIndustrial.toFixed(1);//工业排水
		
		   
			var    realPh=waterquality[i].realPh==null?"-":waterquality[i].realPh.toFixed(2);	
			 var   realNH3N=waterquality[i].realNH3N==null?"-":waterquality[i].realNH3N.toFixed(2);	
			var     realCod=waterquality[i].realCod==null?"-":waterquality[i].realCod.toFixed(2);						
			var     realConductivity=waterquality[i].realConductivity==null?"-":waterquality[i].realConductivity.toFixed(2);		
			 var   realcr6=waterquality[i].realcr6==null?"-":waterquality[i].realcr6.toFixed(4);	
}else{
	continue
}	
	 	   }else{
			   var rid='-';
			    
			   var companyName='-';
			   var supplyIndustrial='-';		//工业给水
	          var supplyLiving='-';			//生活给水
	          var drainageIndustrial='-';//工业排水
	            var    realPh='-';	
			 var   realNH3N='-';	
			var     realCod='-';						
			var     realConductivity='-';		
			 var   cr6="-";	
		}   
 if((realPh!=null&&realPh>0&&realPh<14)&&(realPh>=8.5||realPh<=6.5)){
	 
			var th="<tr id='tr_color' style='background-color:#d0d0d0'><th align='center' style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'><a style='color: #0071BC;' href='../data/doGet?rid="+rid+"'>"+companyName+"</a></th>";   
    			
    		}else{
    			var th="<tr id='tr_color'><th align='center' style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'><a style='color: #0071BC;' href='../data/doGet?rid="+rid+"'>"+companyName+"</a></th>";
    			}
		   
					th+="<th align='center' style='font-family: 微软雅黑;font-size: 15px;'>"+rid+"</th>";
					th+="<th align='center'style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'>"+supplyIndustrial+"</th>";
					th+="<th align='center'style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'>"+supplyLiving+"</th>";
					th+="<th align='center'style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'>"+drainageIndustrial+"</th>";
				    th+="<th align='center'style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'>-</th>";
						if((realPh!=null&&realPh>0&&realPh<14)&&(realPh>9||realPh<6)){
			              th+="<th style='color:red;font-family: 微软雅黑;font-size: 15px;' align='center'style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'>"+realPh+"</th>";    
    			
    		}else{
    			if((realPh>=8.5&&realPh<9)||(realPh<=6.5&&realPh>6)){
			                	  th+="<th style='color:orange;font-family: 微软雅黑;font-size: 15px;' align='center'style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'>"+realPh+"</th>";
			                  }else{
    				th+="<th  align='center'style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'>"+realPh+"</th>";  
    			}
    			
    			}
					//th+="<th  align='center'style='color: blue;'>"+realPh+"</th>"; 	
					th+="<th align='center'style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'>"+realConductivity+"</th>";
					th+="<th align='center'style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'>"+realCod+"</th>";
					th+="<th align='center'style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'>"+realNH3N+"</th>";
					th+="<th align='center'style='color: #0071BC;font-family: 微软雅黑;font-size: 15px;'>"+realcr6+"</th>";
					
		    $th = $(th);
		   
           //清除数据
           //添加td
    		$("#newData").append($th);
		   
		}
	  }
	  }
	  })
}