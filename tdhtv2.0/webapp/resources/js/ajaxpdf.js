



function data_pdf(){
	var type=$("#type").val();
	var rid=$("#rid").val();
	var dateType;
	var startingTime;
	var endTime;
	var timeSpace;
var url;
if(type==1||type==3||type==6){
	dateType=$("#dateType").val();
	url="../waterForm/waterFormList_pdf?rid="+rid+"&dateTypes="+dateType+"&type="+type;
}else if(type==5){
	startingTime=$("#startingTime").val();
	endTime=$("#endTime").val();
	url="../waterForm/waterFormList_pdf?rid="+rid+"&startingTime="+startingTime+"&endTime="+endTime+"&type="+type;
}else if(type==11){
	timeSpace=$("#timeSpace").val();
	startingTime=$("#startingTime").val();
	endTime=$("#endTime").val();
	url="../waterForm/waterFormList_pdf?rid="+rid+"&startingTime="+startingTime+"&endTime="+endTime+"&minates="+timeSpace+"&type="+type;
}
	
	$.ajax({
          url:url,
		type:"post",
		async: true,
		dataType:"json",
		success:function(result){
		  var list=result.list;
		  var data1= list[0];
		  var data2= list[1];
		  
		  var thead="<tr ><td  align='center' rowspan='2' style='font-family: 黑体;font-size: 16;'>时间</td>" +
		  "<td align='center' style='font-family: 黑体;font-size: 16;'>工业给水</td>" +
		  "<td  align='center' style='font-family: 黑体;font-size: 16;'>生活给水</td>" +
		  "<td  align='center' style='font-family: 黑体;font-size: 16;'>工业排水</td>" +
		  "<td  align='center' style='font-family: 黑体;font-size: 16;'>生活排水</td>" +
		  "<td  align='center' style='font-family: 黑体;font-size: 16;'>损耗值</td>" +
		  "<td  align='center'  style='font-family: 黑体;font-size: 16;'>不明工业排水</td>" +
		  "</tr> <tr> <td  align='center'>总流量(m<sup>3</sup>)</td>" +
		  "<td  align='center'>总流量(m<sup>3</sup>)</td>" +
		  "<td  align='center'>总流量(m<sup>3</sup>)</td>" +
		  "<td  align='center'>总流量(m<sup>3</sup>)</td>" +
		  "<td  align='center'>总流量(m<sup>3</sup>)</td>" +
		  "<td  align='center'>总流量(m<sup>3</sup>)</td>" +
		  "</tr>"
		   $thead = $(thead);
           //添加thead
    		$("#thead").append($thead);
		  for(var i=0;i<data1.length;i++){
			  
		  
		  if(type==11){
			 
			  var tr="<tr><td  align='center' style='font-family: 楷体;font-size: 15;'><div class='td-space'>"+data1[i].strTime+"</td>" +
			"<td  align='center'>"+data1[i].tabZtrafficIS1.toFixed(2)+"</td>" +
		   " <td  align='center'>"+data1[i].tabZtrafficDS1.toFixed(2)+"</td>" +
		   " <td  align='center'>"+data1[i].tabZtrafficID1.toFixed(2)+"</td>" +
		  "  <td  align='center'>-</td>" 
		
		  }else{
			  
				  strTime=data1[i].strTime1
			  
			   var tr="<tr><td  align='center' style='font-family: 楷体;font-size: 15;'><div class='td-space'>"+strTime+"</div></td>" +
			"<td  align='center'>"+data1[i].industrialsupply.toFixed(2)+"</td>" +
		   " <td  align='center'>"+data1[i].livingsupply.toFixed(2)+"</td>" +
		   " <td  align='center'>"+data1[i].industrialdrainage.toFixed(2)+"</td>" +
		  "  <td  align='center'>-</td>" +
		   " <td  align='center'>"+data1[i].wastage.toFixed(2)+"</td>" +
		   " <td  align='center'>"+data1[i].unknown.toFixed(2)+"</td></tr>"
			  
		  }
		   $tr = $(tr);
           //添加thead
    		$("#tr").append($tr);
		  }
		}
	})
}


function data_pdf2(){
	
	var type=$("#type").val();
	var rid=$("#rid").val();
	var dateType;
	var startingTime;
	var endTime;
	var timeSpace;
	
var url;
if(type==1||type==3||type==6){
	dateType=$("#startingTime").val();
	url="../reportForm/reportFormList_pdf?rid="+rid+"&dateTypes="+dateType+"&type="+type;
}else if(type==5){
	startingTime=$("#startingTime").val();
	endTime=$("#endTime").val();
	url="../reportForm/reportFormList_pdf?rid="+rid+"&startingTime="+startingTime+"&endTime="+endTime+"&type="+type;
}else if(type==11){
	timeSpace=$("#timeSpace").val();
	startingTime=$("#startingTime").val();
	endTime=$("#endTime").val();
	url="../reportForm/reportFormList_pdf?rid="+rid+"&startingTime="+startingTime+"&endTime="+endTime+"&minates="+timeSpace+"&type="+type;
}
	$.ajax({
          url:url,
		type:"post",
		async: true,
		dataType:"json",
		success:function(result){
		  var list=result.list;
		  var data1= list[0];
		  var data2= list[1];
		  var data3= list[2];
		  if(rid==75501330003 || rid ==75501330002 ||  rid==75501330001 ||  rid==75501330005){
		  var thead=" <tr ><td   id='td_time' align='center' rowspan='2' style='font-family: 黑体;font-size:15; '>时间</td>" +
					   " <td   id='td_id'  align='center' colspan='6' style='font-family: 黑体;font-size:15;'>工业排水</td></tr>" +
		               "<tr class='tr_w'><td  align='center' >PH</td>" +
					   " <td  align='center'>COD(mg/l)</td>" +
					   " <td   align='center'>氨氮(mg/l)</td>" +
					   " <td  align='center'>六价铬(mg/l)</td>" +
					   " <td  align='center'>电导率(mg/l)</td>" +
					   " <td  align='center'>固体悬浮物(mg/l)</td></tr>" 
					   $thead = $(thead);
		   //添加thead
			$("#thead").append($thead);
		  }else if(rid==75501330004){
		  var thead=" <tr ><td    id='td_time' align='center' rowspan='2' style='font-family: 黑体;font-size:15;'>时间</td>" +
					   " <td  id='td_id' align='center' colspan='6' style='font-family: 黑体;font-size:15;'>工业排水</td></tr>" +
		               "<tr class='tr_w'><td  align='center' >PH</td>" +
					   " <td  align='center'>COD(mg/l)</td>" +
					   " <td  align='center'>氨氮(mg/l)</td>" +
					   " <td  align='center'>六价铬(mg/l)</td>" +
					   " <td  align='center'>电导率(mg/l)</td>" +
					   " <td  align='center'>固体悬浮物(mg/l)</td>" +
					   "<td  align='center'>总磷(mg/l)</td></tr>"
					   $thead = $(thead);
		   //添加thead
			$("#thead").append($thead);
		  }else if(rid==75501330008||rid==75501330009||rid==75501330010||rid==75501330011||rid==75501330012){
			  var thead="<tr  class='tb_heard_font16'>" +
			  "  <td id='td_time' align='center' rowspan='2'  >时间</td>" +
			  "  <td id='td_id' align='center' colspan='9'  >工业排水</td>" +
			" </tr>" +
			"	 <tr id='theads' class='tb_heard_font15'>" +
			" </tr>" 
			 $thead = $(thead);
   //添加thead
	$("#thead").append($thead);
			 for(i=0;i<data3.length;i++){
			var theads="	 <td  align='center' >"+data3[i].pollType+"</td>" 
			
	 $theads = $(theads);
   //添加thead
	$("#theads").append($theads);
 }  
			  
		  }
		  
		 
		  for(var i=0;i<data1.length;i++){
			  
		  
		  if(type==11){
			 if(rid==75501330003 || rid ==75501330002 ||  rid==75501330001 ||  rid==75501330005){
			  var tr="<tr class='tr_w'><td   align='center' style='font-family: 楷体;font-size:15;'><div class='td-space'>"+data1[i].strTime+"</td>" +
			"<td   align='center'>"+data1[i].realph.toFixed(2)+"</td>" +
		   " <td   align='center'>"+data1[i].realcod.toFixed(2)+"</td>" +
		   " <td   align='center'>"+data1[i].realnh4.toFixed(2)+"</td>" +
		  "  <td   align='center'>"+data1[i].realcr6.toFixed(4)+"</td>" +
		   " <td   align='center'>"+data1[i].realconductivity.toFixed(2)+"</td>" +
		   " <td   align='center'>"+data1[i].realmlss.toFixed(2)+"</td></tr>"
		   $tr = $(tr);
	           //添加thead
	    		$("#tr").append($tr);
			 }else if(rid==75501330004 ){
			   
			  var tr="<tr class='tr_w'><td   align='center' style='font-family: 楷体;font-size:15;'><div class='td-space'>"+data1[i].strTime+"</td>" +
			"<td   align='center'>"+data1[i].realph.toFixed(2)+"</td>" +
		   " <td   align='center'>"+data1[i].realcod.toFixed(2)+"</td>" +
		   " <td   align='center'>"+data1[i].realnh4.toFixed(2)+"</td>" +
		  "  <td   align='center'>"+data1[i].realcr6.toFixed(4)+"</td>" +
		   " <td   align='center'>"+data1[i].realconductivity.toFixed(2)+"</td>" +
		   " <td   align='center'>"+data1[i].realmlss.toFixed(2)+"</td>"+
		   " <td   align='center'>"+data1[i].realphosphor.toFixed(2)+"</td></tr>"
		   $tr = $(tr);
	           //添加thead
	    		$("#tr").append($tr);
		   }
		   
		   else if(rid==75501330008||rid==75501330009||rid==75501330010||rid==75501330011||rid==75501330012){
			   //console.log("1");
			   for(var i=0;i<data1.length;i++){
				   if(rid==75501330008){
					   console.log("2");
					   var tr="  <tr    class='tb_font15'   >"+
					"	<td  align='center'  style='font-family: 楷体;font-size:15;' >"+data1[i].strTime+"</td>"+
						
						"<td  align='center'>"+data1[i].realph.toFixed(2)+"</td>"+
						
					"	<td  align='center'>"+data1[i].realTemp.toFixed(2)+"</td>"+
						
					"	<td  align='center'>"+data1[i].realTurbidity+"</td>"+
						
						
					"	<td  align='center'>"+data1[i].realconductivity.toFixed(2)+"</td>"+
						
					"	<td  align='center'>"+data1[i].realDo+"</td>"+
						
					"	 <td  align='center'>"+data1[i].realphosphor.toFixed(2)+"</td>"+
					   
					 "  <td  align='center'>"+data1[i].realnh4.toFixed(2)+"</td>"+
					  
					
					 "   <td  align='center'>"+data1[i].realcu.toFixed(2)+"</td>"+
					    
					  "   <td  align='center'>"+data1[i].realni.toFixed(2)+"</td>"+
					 " </tr>"
					   
					  $tr = $(tr);
			           //添加thead
			    		$("#tr").append($tr);
					   
				   }else if(rid==75501330009){
					   var tr="  <tr    class='tb_font15'   >"+
						"	<td  align='center'  style='font-family: 楷体;font-size:15;' >"+data1[i].strTime+"</td>"+
							
							"<td  align='center'>"+data1[i].realph.toFixed(2)+"</td>"+
							
						"	<td  align='center'>"+data1[i].realTemp.toFixed(2)+"</td>"+
							
						"	<td  align='center'>"+data1[i].realTurbidity+"</td>"+
							
							
						"	<td  align='center'>"+data1[i].realconductivity.toFixed(2)+"</td>"+
							
						"	<td  align='center'>"+data1[i].realDo+"</td>"+
						"   <td  align='center'>"+data1[i].realni.toFixed(2)+"</td>"+
						"	 <td  align='center'>"+data1[i].realphosphor.toFixed(2)+"</td>"+
						   
						 "  <td  align='center'>"+data1[i].realnh4.toFixed(2)+"</td>"+
						  
						
						  "   <td  align='center'>"+data1[i].realzn.toFixed(2)+"</td>"+
						  
						  
						 " </tr>"
						   
						  $tr = $(tr);
			           //添加thead
			    		$("#tr").append($tr);
						   
					   }else if(rid==75501330010){
						   var tr="  <tr    class='tb_font15'   >"+
							"	<td  align='center'  style='font-family: 楷体;font-size:15;' >"+data1[i].strTime+"</td>"+
								
								"<td  align='center'>"+data1[i].realph.toFixed(2)+"</td>"+
								
							"	<td  align='center'>"+data1[i].realTemp.toFixed(2)+"</td>"+
								
							"	<td  align='center'>"+data1[i].realTurbidity+"</td>"+
								
								
							"	<td  align='center'>"+data1[i].realconductivity.toFixed(2)+"</td>"+
								
							"	<td  align='center'>"+data1[i].realDo+"</td>"+
							
							"	 <td  align='center'>"+data1[i].realphosphor.toFixed(2)+"</td>"+
							   
							 "  <td  align='center'>"+data1[i].realnh4.toFixed(2)+"</td>"+
							  
							
							  "   <td  align='center'>"+data1[i].realzn.toFixed(2)+"</td>"+
							  "   <td  align='center'>"+data1[i].realni.toFixed(2)+"</td>"+
							  
							 " </tr>"
							   
							  $tr = $(tr);
				           //添加thead
				    		$("#tr").append($tr);
							   
						   }
				  
				   
			   }
					  
			   
			   
		   } 
		  }else{
			  if(rid==75501330003 || rid ==75501330002 ||  rid==75501330001 ||  rid==75501330005){
				  strTime=data1[i].strTime1
			  
			   var tr="<tr class='tr_w'><td    align='center' style='font-family: 楷体;font-size:15;'><div class='td-space'>"+strTime+"</td>" +
			"<td   align='center'>"+data1[i].minph.toFixed(2)+"-"+data1[i].maxph.toFixed(2)+"</td>" +
		   " <td   align='center'>"+data1[i].mincod.toFixed(2)+"-"+data1[i].maxcod.toFixed(2)+"</td>" +
		   " <td   align='center'>"+data1[i].minnh4.toFixed(2)+"-"+data1[i].maxnh4.toFixed(2)+"</td>" +
		  "  <td   align='center'>"+data1[i].mincr6.toFixed(4)+"-"+data1[i].maxcr6.toFixed(4)+"</td>" +
		   " <td   align='center'>"+data1[i].minconductivity.toFixed(2)+"-"+data1[i].maxconductivity+"</td>" +
		   " <td   align='center'>"+data1[i].minmlss.toFixed(2)+"-"+data1[i].maxmlss.toFixed(2)+"</td></tr>"
		   
		   $tr = $(tr);
		           //添加thead
		    		$("#tr").append($tr);
			}else if(rid==75501330004) {
			 strTime=data1[i].strTime1
			  
			   var tr="<tr class='tr_w'><td   align='center' style='font-family: 楷体;font-size:15;'><div class='td-space'>"+strTime+"</td>" +
			"<td   align='center'>"+data1[i].minph.toFixed(2)+"-"+data1[i].maxph.toFixed(2)+"</td>" +
		   " <td   align='center'>"+data1[i].mincod.toFixed(2)+"-"+data1[i].maxcod.toFixed(2)+"</td>" +
		   " <td   align='center'>"+data1[i].minnh4.toFixed(2)+"-"+data1[i].maxnh4.toFixed(2)+"</td>" +
		  "  <td   align='center'>"+data1[i].mincr6.toFixed(4)+"-"+data1[i].maxcr6.toFixed(4)+"</td>" +
		   " <td   align='center'>"+data1[i].minconductivity.toFixed(2)+"-"+data1[i].maxconductivity+"</td>" +
		   " <td   align='center'>"+data1[i].minmlss.toFixed(2)+"-"+data1[i].maxmlss.toFixed(2)+"</td>"+
		   " <td   align='center'>"+data1[i].minphosphor.toFixed(2)+"-"+data1[i].maxphosphor.toFixed(2)+"</td></tr>"
		   $tr = $(tr);
	           //添加thead
	    		$("#tr").append($tr);
			} 
			else if(rid==75501330008||rid==75501330009||rid==75501330010||rid==75501330011||rid==75501330012){
				   
				   for(var i=0;i<data1.length;i++){
					   if(rid==75501330008){
						   var tr="  <tr    class='tb_font15'   >"+
						"	<td  align='center'  style='font-family: 楷体;font-size:15;' >"+data1[i].strTime+"</td>"+
							
							"<td  align='center'>"+data1[i].minph+"-"+data1[i].maxph+"</td>"+
							
						"	<td  align='center'>"+data1[i].minTemp+"-"+data1[i].maxTemp+"</td>"+
							
						"	<td  align='center'>"+data1[i].minTurbidity+"-"+data1[i].maxTurbidity+"</td>"+
							
							
						"	<td  align='center'>"+data1[i].minconductivity+"-"+data1[i].maxconductivity+"</td>"+
							
						"	<td  align='center'>"+data1[i].minDo+"-"+data1[i].maxDo+"</td>"+
							
						"	 <td  align='center'>"+data1[i].minphosphor+"-"+data1[i].maxphosphor+"</td>"+
						   
						 "  <td  align='center'>"+data1[i].minnh4+"-"+data1[i].maxnh4+"</td>"+
						  
						
						 "   <td  align='center'>"+data1[i].mincu+"-"+data1[i].maxcu+"</td>"+
						    
						  "   <td  align='center'>"+data1[i].minni+"-"+data1[i].maxni+"</td>"+
						  
						  
						 " </tr>"
						  $tr = $(tr);
				           //添加thead
				    		$("#tr").append($tr); 
						   
						   
					   }else if(rid==75501330009){
						   var tr="  <tr    class='tb_font15'   >"+
							"	<td  align='center'  style='font-family: 楷体;font-size:15;' >"+data1[i].strTime+"</td>"+
								
								"<td  align='center'>"+data1[i].minph+"-"+data1[i].maxph+"</td>"+
								
							"	<td  align='center'>"+data1[i].minTemp+"-"+data1[i].maxTemp+"</td>"+
								
							"	<td  align='center'>"+data1[i].minTurbidity+"-"+data1[i].maxTurbidity+"</td>"+
								
								
							"	<td  align='center'>"+data1[i].minconductivity+"-"+data1[i].maxconductivity+"</td>"+
								
							"	<td  align='center'>"+data1[i].minDo+"-"+data1[i].maxDo+"</td>"+
							"   <td  align='center'>"+data1[i].minni+"-"+data1[i].maxni+"</td>"+
							"	 <td  align='center'>"+data1[i].minphosphor+"-"+data1[i].maxphosphor+"</td>"+
							   
							 "  <td  align='center'>"+data1[i].minnh4+"-"+data1[i].maxnh4+"</td>"+
							  
							
							  "   <td  align='center'>"+data1[i].minzn+"-"+data1[i].maxzn+"</td>"+
							  
							  
							 " </tr>"
							   
							  $tr = $(tr);
				           //添加thead
				    		$("#tr").append($tr);   
							   
						   }else if(rid==75501330010){
							   var tr="  <tr    class='tb_font15'   >"+
								"	<td  align='center'  style='font-family: 楷体;font-size:15;' >"+data1[i].strTime+"</td>"+
									
									"<td  align='center'>"+data1[i].minph+"-"+data1[i].maxph+"</td>"+
									
								"	<td  align='center'>"+data1[i].minTemp+"-"+data1[i].maxTemp+"</td>"+
									
								"	<td  align='center'>"+data1[i].minTurbidity+"-"+data1[i].maxTurbidity+"</td>"+
									
									
								"	<td  align='center'>"+data1[i].minconductivity+"-"+data1[i].maxconductivity+"</td>"+
									
								"	<td  align='center'>"+data1[i].minDo+"-"+data1[i].maxDo+"</td>"+
								
								"	 <td  align='center'>"+data1[i].minphosphor+"-"+data1[i].maxphosphor+"</td>"+
								   
								 "  <td  align='center'>"+data1[i].minnh4+"-"+data1[i].maxnh4+"</td>"+
								  
								
								  "   <td  align='center'>"+data1[i].minzn+"-"+data1[i].maxzn+"</td>"+
								  "   <td  align='center'>"+data1[i].minni+"-"+data1[i].maxni+"</td>"+
								  
								 " </tr>"
								   
								  $tr = $(tr);
					           //添加thead
					    		$("#tr").append($tr);  
								   
							   }
					 
				  
				   
				   }
						  
				   
				   
			   }
		  }
		  
		  }
		}
	})
}

