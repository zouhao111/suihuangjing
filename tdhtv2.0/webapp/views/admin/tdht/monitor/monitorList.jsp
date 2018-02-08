<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />
<script type="text/javascript" src="${ctx}/resources/common/jquery/jquery.json-2.4.min.js"></script>
<link href="${ctx}/resources/css/pager.css"	type="text/css" rel="stylesheet" />
<!--[if IE 9]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if IE 8]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if  IE 7]>
<link href="${ctx}/resources/css/ie7.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<title>设备状态</title>

<script type="text/javascript">
	
	
	$(document).ready(function () {
		
		 $("tr:even").addClass("over");
		  //点击变色  
		  $("#table tbody tr").toggle(
			   function(){
			    $(this).addClass("focus");
			    	$(this).find(":checkbox").attr("checked",true);
			   },function (){
			   $(this).removeClass("focus");
			  	$(this).find(":checkbox").attr("checked",false);
			  }
			  );
		  
		  
		  $('#table tbody tr :checkbox').click(function(event) {
			  event.stopPropagation();
			  if(this.checked){
				  $(this).parent.parent.addClass("focus");
			  }else{
				  $(this).parent.parent.removeClass("focus");
			  }
		  });
		  
		  var rid=$("#rid").val();
		  load_newdata(rid)
		   var tiimer=setInterval(function() {
      load_newdata(rid);
}, 30000);
		<%--	
		 $("#button1").on("click",function(){
        if($("#button1").var()!=1){
        var button=  $("#button1").var(1);
        Console();
        }
        if($("#button1").var()!=0){
        var button=  $("#button1").var(0);
        Console();
        }
     });

	function Console(){
	var send=true;
	var XMLHttpReq;  
        //创建XMLHttpRequest对象         
        function createXMLHttpRequest() { 
        
            if(window.XMLHttpRequest) { //Mozilla 浏览器  
                XMLHttpReq = new XMLHttpRequest();
            }  
            else if (window.ActiveXObject) { // IE浏览器  
                try {  
                    XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");  
                } catch (e) {  
                    try {  
                        XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");  
                        
                    } catch (e) {}  
                }  
            }  
        }  
        
        
       
        
  function sendRequest() {  
  
//首先创建精灵对象  
createXMLHttpRequest();  

//尝试以异步的get方式访问某个URL  
//请求服务器端的一个servlet  
var url = "../monitor/doConsole?button="+button +"&send="+send
XMLHttpReq.open("get",url,true);  
//指明准备状态改变时回调的函数名  
XMLHttpReq.onreadystatechange=handle;  
//向服务器发送请求  
XMLHttpReq.send(null);  
}  

function handle()  
{  

//准备状态为4  
    if(XMLHttpReq.readyState==4)  
    {  
    //响应状态码为200，代表一切正常  
       if(XMLHttpReq.status==200)  
       {       
              if($("#button1").var()==1){
        $("#button1").css("background","red");
        }
        if($("#button1").var()==0){
       $("#button1").css("background","green");
        }
               
            alert("成功")
            send=false; 
       }  
    }  
}  


sendRequest();

 
	
	}
	
	--%>	
	});
</script>
<script type="text/javascript">
	
	
	//查询
	function findReport(){
		document.myform.action = "../phwarning/historyList";
		document.myform.submit();
	}

	//清空   
	 function cls(){
		   var sum=0;
		   var t = document.getElementsByTagName("INPUT"); 
		   for (var i=0; i <t.length;i++){   
		  if (t[i].type=='text'){   
		    ++sum; 
		    t[i].value="";
		  }
		   }
	 }
	function  load_newdata(rid){
	
	   $.ajax({
          url:"../monitors/monitorListss?rid="+rid,
		type:"post",
		async: true,
		dataType:"json",
		success:function(result){
		  
		   var list=result.list;
		   var ztraffic= list[0];
		   var url= list[1];
		   var companyconfig=list[2];
		    var companyId=list[3];
		   // console.log(companyconfig)
		  /* var companyconfig2=[];
		     var  waterType;
		   if(companyId==1000){
			   waterType=1
		   }else{
			  waterType=2 
			   }
		   
		    for(a=0;a<companyconfig.length;a++){
		    if(companyconfig[a].waterType==waterType){
			 
			   companyconfig2[a]=companyconfig[a];
		   }
		    }
		 */
		  
		   $("#state").empty();
		   
		   for(i=0;i<ztraffic.length;i++){
			    for(j=0;j<companyconfig.length;j++){
		    if(ztraffic[i]!=null&&companyconfig[j]!=null){
		    	
		   if(ztraffic[i].rid==companyconfig[j].rid){
			 
		   
		  var conpanyName=companyconfig[j].companyName
		   var rid=companyconfig[j].rid;
			var tabPh=(ztraffic[i].tabPh==null?"-":ztraffic[i].tabPh.toFixed(2));	
			 var tabTemperature=(ztraffic[i].tabTemperature==null?"-":ztraffic[i].tabTemperature.toFixed(2));	
			 var tabHumidity=(ztraffic[i].tabHumidity==null?"-":ztraffic[i].tabHumidity.toFixed(2));	
			  var tabVoltage=(ztraffic[i].tabVoltage==null?"-":ztraffic[i].tabVoltage.toFixed(2));
			  
}else{
	continue
}	
	 	   }else{
	 		    var conpanyName='-'
		   var rid='-'
				
			 var tabTemperature="-";	
			 var tabHumidity="-";	
			  var tabVoltage="-";
		}   
 
	     var th="<tr align='center'   class='tb_font15_h46'>";
			th+="<td style='font-family:Microsoft YaHei;'>"+conpanyName+"</td>";
				
			th+="<td>"+rid+"</td>";
			
			th+="<td>"+tabTemperature+"</td>";
			th+="<td>"+tabHumidity+"</td>";
			th+="<td>"+tabVoltage+"</td>";
			th+="<td align='center'>";
			
			if(companyId==2000){
			   if(ztraffic[i].bitOnline1==1){
			  th+=" <div id='a1'    class='btn_off_line'><span style='padding-left: 10px;'>工业排水</span ></div>";
			 
				
			  }else if (ztraffic[i].bitOnline1==0){
				th+=" <div id='a1' class='btn_on_line'><span style='padding-left: 10px;'>工业排水</span ></div>";
			  		  
			  }
		   }else{
			  
				 if(ztraffic[i].bitOnline!=null&&ztraffic[i].bitOnline==1){
			  th+=" <div id='a1'    class='btn_off_line'><span style='padding-left: 10px;'>"+ztraffic[i].note+"</span ></div>";
			 
				
			  }else if (ztraffic[i].bitOnline!=null&&ztraffic[i].bitOnline==0){
				th+=" <div id='a1' class='btn_on_line'><span style='padding-left: 10px;'>"+ztraffic[i].note+"</span ></div>";
			  }
			   if(ztraffic[i].bitOnline1!=null&&ztraffic[i].bitOnline1==1){
			  th+=" <div id='a1'    class='btn_off_line'><span style='padding-left: 10px;'>"+ztraffic[i].note1+"</span ></div>";
			 
				
			  }else if (ztraffic[i].bitOnline1!=null&&ztraffic[i].bitOnline1==0){
				th+=" <div id='a1' class='btn_on_line'><span style='padding-left: 10px;'>"+ztraffic[i].note1+"</span ></div>";
			  }
				 if(ztraffic[i].bitOnline2!=null&&ztraffic[i].bitOnline2==1){
			  th+=" <div id='a1'    class='btn_off_line'><span style='padding-left: 10px;'>"+ztraffic[i].note2+"</span ></div>";
			 
				
			  }else if (ztraffic[i].bitOnline2!=null&&ztraffic[i].bitOnline2==0){
				th+=" <div id='a1' class='btn_on_line'><span style='padding-left: 10px;'>"+ztraffic[i].note2+"</span ></div>";
			  }
				  if(ztraffic[i].bitOnline3!=null&&ztraffic[i].bitOnline3==1){
			  th+=" <div id='a1'    class='btn_off_line'><span style='padding-left: 10px;'>"+ztraffic[i].note3+"</span ></div>";
			 
				
			  }else if (ztraffic[i].bitOnline3!=null&&ztraffic[i].bitOnline3==0){
				th+=" <div id='a1' class='btn_on_line'><span style='padding-left: 10px;'>"+ztraffic[i].note3+"</span ></div>";
			  }
				
				
			 }
			th+="</td>";
			/**th+="<td width='100' align='center'> ";
			th+="<button type='button' class='btn '>生活给水</button>";
			th+="<button type='button' class='btn '>工业给水</button>";
			th+="<button type='button' class='btn '>工业排水</button>";
			th+="</td>";
				*/
		    th+="</tr>";
			
					
		    $th = $(th);
		   
           //清除数据
           //添加td
    		$("#state").append($th);
    		
		   
		
	  }
	  }
}
	   })
	   }
	   
</script>
</head>
<body class="body_overflow">
<input id="rid" type="hidden" value="${rid}" >
	<input id="webUrls" type="hidden" value="${webUrls}" >
	<div style="margin-bottom: 8px;">
	<span class="f14 text-title" >设备状态</span>
	</div>
	

	 <div style="background-color:#b0b0b0;;width:100%;height:1px;"></div>
	 <div style="background-color:#ffffff;width:100%;height:8px;"></div>
	
	<div class="table2excel bluestrip">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead >
					<tr   class="tb_heard_font16_h46">
						<th width="12%" align="center">监测单元名称</th>
						<th width="12%" align="center">监测单元编号</th>
					
						
						<th width="12%" align="center">温度(°C)</th>
						<th width="12%" align="center">湿度(%)</th>
						<th width="12%" align="center">电压(V)</th>
						<th width="28%"  style="text-align: center;">控制器状态</th>
						<%--<th width="100px"  style="text-align: center;">井盖状态</th>
					--%></tr>
			</thead>
		<tbody id="state">
	<tr align="center" >
				
				
			</tr>
			<tr align="center">
				
			</tr>
			<tr align="center">
				
			</tr>
			<%--<tr align="center">
				
			</tr>
			
			
		--%><%--</c:forEach>
		--%></tbody>
	
	</table>
	
	<div   style='margin-top:20px'>
	<span  class='tb_font16'>备注:</span>
	<div style="margin-left:35px; text-align: left;font-size: 15px;font-family:Microsoft YaHei;" colspan="5"> <img height=26px width=12px style='	margin: 2px; background: url(${ctx}/resources/lrtk/images/on-line2.png) no-repeat center;'></img><span style="font-family:Microsoft YaHei;">绿色代表在线，</span><img height=26px width=12px style='	margin: 2px;background: url(${ctx}/resources/lrtk/images/off-line2.png) no-repeat center;'></img><span style="font-family:Microsoft YaHei;">灰色代表离线</span></div>

	</div>
	</div>
 
	<%--<div  style="background-color:#ffffff;width:100%;height:5px;"></div>
	
--%></div>

<%--<div style="with:100%;height:30px;  background: url(${ctx}/resources/lrtk/images/foot.png) no-repeat center;"></div> 
<div style="with:100%;height:30px;  background: url(${ctx}/resources/lrtk/images/foot.png) no-repeat center;"></div> 

	
	--%><script>
		$(function() {
			$("#btn").click(function(){
				$(".table2excel").table2excel({
					exclude: ".noExl",
					name: "Excel Document Name",
					filename: "myFileName",
					exclude_img: true,
					exclude_links: true,
					exclude_inputs: true
				});
			});
			
		});
	</script>
</body>
</html>