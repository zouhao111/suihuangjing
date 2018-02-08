
function data_pdf(){
	var rid=$("#rid").val();
	var startingTime;
	var endTime;
var url;

	startingTime=$("#startingTime").val();
	endTime=$("#endTime").val();
	url="../log/logListpdf?rid="+rid+"&startingTime="+startingTime+"&endTime="+endTime;

	$.ajax({
          url:url,
		type:"post",
		async: true,
		dataType:"json",
		success:function(result){
		  var list=result.list;
		  var data1= list[0];
		  
		  console.log(data1)
		  
		  
		  for(var i=0;i<data1.length;i++){
			  
		  
			  var tr="<tr><td   align='center' style='font-family: 楷体;font-size: 15;'>"+data1[i].updataTime+"</td> "
				tr+="<td  align='center'>"+data1[i].userName+"</td>"
				tr+="<td  align='center'>"+data1[i].userIp+"</td>"
				tr+="<td  align='center'>"+data1[i].companyName+"</td>"
				tr+="<td  align='center'>"+data1[i].describe+"</td></tr>"
		 
		   $tr = $(tr);
           //添加thead
    		$("#tr").append($tr);
		 }
		}
	})
}
