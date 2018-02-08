<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head><%--

    <link rel="stylesheet" href="static/bootstrap/css/bootstrap/bootstrap.min.css" />
	--%>
		
	<script src="static/js/jquery.js"></script>
	<script type="text/javascript" src="static/js/jquery-ui-1.9.2.custom.min.js"></script>
	<%--script src="static/bootstrap/js/bootstrap.min.js"></script>	
	--%>
	<script src="static/bootstrap/bootstrap-table2/colResizable-1.6.js"></script>
<link href="static/buttons/buttons.css" rel="stylesheet" type="text/css"/>
	
	<script src="static/js/echarts.min.js"></script>
<script src="static/js/myjs/center.js"></script>
<script>
  (function($){ 
	  $(document).ready(function(){   
	  var menuUrl=$("#menuUrl").attr("href")
		$.cookie('menuUrl_ss', menuUrl, { expires: 1, path: '/TDHT3.0' });
		  $(".myDiv").center();
		   $(".water_div").center();
		   $(".poll_sum_div").center();
		   $(".t_div").center();
		    $(".water_font").center();
		    
    });
  })(jQuery);</script>
<style type="text/css">
body{
overflow-x:hidden; 
}
.font_div{
    float:left;
    width:24%;
    height:auto; 
    border-left: 3px solid #28A2DB;
   
}
.balance_div{
 width:15%;
}
.font_div2{
   margin-left: 10px;
    font-family: 微软雅黑;font-size: 16px;
    margin-top:5px;
}
.font_div3{
   margin-left: 10px;
   color:#28A2DB;
    margin-top:5px;
}
.myDiv{
  width:95%; 
  height:100%; 
 
}
.water_div{
 width:90%; 
  height:50px; 
  top:10px;
}
.poll_sum_div{
 width:90%; 
  height:150px; 
  top:10px;
}
.t_div{
font-family: 微软雅黑;font-size: 16px;
 border-left: 3px solid #28A2DB; 
 height:20px;
 
}
.t_button{
font-family: 微软雅黑;font-size: 16px;
 border-left: 3px solid #28A2DB; 
 width:25%;
 float: left;
}
.img_poll{
width: 113px; 
height: 11px;
background: #fff url('static/images/1.png') 0 0 no-repeat;
margin-top:5px;
 margin-left: 10px;
}
.img_PH{
width: 113px; 
height: 11px;
background: #fff url('static/images/jianbian2.png') 0 0 no-repeat;
margin-top:5px;
 margin-left: 10px;
}
.img_Do{
width: 113px; 
height: 11px;
background: #fff url('static/images/jianbian3.png') 0 0 no-repeat;
margin-top:5px;
 margin-left: 10px;
}
.img_poll_font{

    height: 20px;
    position: relative;
    top: -5px;
    float: right;
    left:5px;
}
.img_poll_div{

    height: 20px;
    width: 10%;

}
.module{
 font-size:16px;
 color:#3B9DDB;
 font-weight: 900;
  cursor: pointer;
}
.module-img{
width:15px;
}
.div-top{
display: none;
}
.my_button{
margin-left: 10px;
    
}
.water2{
background: #fff url('static/images/water2.png') 0 0 no-repeat;
float:left;
width: 150px;
    height: 100px;
margin:20px 0;padding:0;
}
.water_font{
font-family: 微软雅黑;font-size: 16px;
color:#fff;
width:100%;
height:80%;
position: relative;
top:30px;
left:60px;
}
.water_font1{
font-family: 微软雅黑;font-size: 12px;
color:#fff;
width:100%;
height:100%;
position: relative;
top:10px;
left:10px;
}
.water_font_div{
font-family: 微软雅黑;font-size: 16px;
color:#fff;
width:100%;
height:20%;
position: relative;
left: 40px;
    bottom: 5px;
}
.water3{
background: #fff url('static/images/water3.png') 0 0 no-repeat;
float:left;
width: 150px;
    height: 100px;
margin:20px 0;padding:0;
}

.water1{
background: #fff url('static/images/water1.png') 0 0 no-repeat;
float:left;
width: 50px;
    height: 40px;
margin:20px 0;padding:0;
cursor: pointer;
border-radius: 0px 15px 15px 0px;
}
.cover_name{
border-left: 3px solid #28A2DB; 
 height:20px;
}
</style>
<script type="text/javascript">
$(document).ready(function(){ 

   $(".water1").click(function(){ 
  // console.log($(this).prev(".water3").children(".water_font")) 
   // alert( $(this).prev(".water3").children(".water_font").children("input").val())
   $("#value").val($(this).prev(".water3").children(".water_font").children("#values").val());
    $("#control_action_id").val($(this).prev(".water3").children(".water_font").children("#control_action_ids").val());
    $('#myModal').modal()                      // 使用默认值初始化
$('#myModal').modal({ keyboard: true,
	                  backdrop:'static'     })   // 初始化。不支持键盘导航
$('#myModal').modal('show')        
   })
  
}) 


</script>
<base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="../../system/index/top.jsp"%>

</head>
<body style="background-color:#fff;">
<a id="menuUrl" href="${menuUrl}"></a>
<input  id="R_ID" type="hidden"  value="${R_ID}"/>
<input  id="list" type="hidden"  value="${list}"/>
<input  id="value" type="hidden"  value=""/>
<input  id="control_action_id" type="hidden"  value=""/>

<c:if test="${list0.hasMenu}">
  <div id="module0" >
 
  <span class="module"> <img class="module-img" src="static/images/3gang.png"/> ${list0.MENU_NAME}</span>
  </div>
  <div id="div0" class="div-top"style="height: 500px;">
  <div style=" margin:0;padding:0;height: 100%">
    <div class="myDiv">
  <div id="controller_water" style="clear:both ;width:110%; margin:0;padding:0;display: none;height:500px;">
  <div id="waters"style="width:100%;height:260px">
     <div id="traffic"style='width:30%;height:200px;float:left;display: none;'>
     <div id="param_name_cn"class="cover_name"></div>
     <div class='water2'>
     <div id="param_value"class='water_font'></div>
     <div class='water_font_div'>当前值</div>
     </div>
     <div class='water3'>
     <div id="setValue"class='water_font'><input  id="control_action_ids" type="hidden"  value="121"/><input id="values"type="text"style="width:50px;background-color:#3DAED8;border: 0px; font-family: 微软雅黑;font-size: 16px; color: #fff;" value="1"/></div>
     <div class='water_font_div'>设定值</div>
     </div>
     <div  class='water1'><div class='water_font1'>更新</div>
     </div>
     </div>
       
      <div id="water"style='width:30%;height:200px;float:left;display: none;'>
     <div id="param_name_cn2"class="cover_name"></div>
     <div class='water2'>
     <div id="param_value2"class='water_font'></div>
     <div class='water_font_div'>当前值</div>
     </div>
     <div class='water3'>
     <div id="setValue2"class='water_font'><input  id="control_action_ids" type="hidden"  value=""/><input id="values"type="text"style="width:50px;background-color:#3DAED8;border: 0px; font-family: 微软雅黑;font-size: 16px; color: #fff;" value="1"/></div>
     <div class='water_font_div'>设定值</div>
     </div>
     <div  class='water1'><div class='water_font1'>更新</div>
     </div>
     </div>
     
      <div id="current"style='width:30%;height:200px;float:left;display: none;'>
     <div id="param_name_cn3"class="cover_name"></div>
     <div class='water2'>
     <div id="param_value3"class='water_font'></div>
     <div class='water_font_div'>当前值</div>
     </div>
     <div class='water3'>
     <div id="setValue3"class='water_font'><input  id="control_action_ids" type="hidden"  value=""/><input id="values"type="text"style="width:50px;background-color:#3DAED8;border: 0px; font-family: 微软雅黑;font-size: 16px; color: #fff;" value="1"/></div>
     <div class='water_font_div'>设定值</div>
     </div>
     <div  class='water1'><div class='water_font1'>更新</div>
     </div>
     </div>
     
        
     </div>
  </div>
  </div>
  </div>
 </c:if>

<c:if test="${list1.hasMenu}">
   <div id="module1" >
 
  <span class="module"> <img class="module-img" src="static/images/3gang.png"/> ${list1.MENU_NAME}</span>
  </div>
  <div  id="div1" class="div-top"style="height: 320px;">
  <div style=" margin:0;padding:0;height: 100%">
    <div class="myDiv">
     
 
  </div>
  </div>
  </div>
 </c:if>
<c:if test="${list2.hasMenu}">
   <div id="module2" >
 
  <span class="module"> <img class="module-img" src="static/images/3gang.png"/> ${list2.MENU_NAME}</span>
  </div>
  <div  id="div2" class="div-top"style="height: 320px;">
  <div style=" margin:0;padding:0;height: 100%">
    <div class="myDiv">
     
 
  </div>
  </div>
  </div>
 </c:if>

<c:if test="${list3.hasMenu}">
   <div id="module3" >
 
  <span class="module"> <img class="module-img" src="static/images/3gang.png"/> ${list3.MENU_NAME}</span>
  </div>
  <div  id="div3" class="div-top"style="height: 320px;">
  <div style=" margin:0;padding:0;height: 100%">
    <div class="myDiv">
     
 
  </div>
  </div>
  </div>
 </c:if>
<c:if test="${list4.hasMenu}">
   <div id="module1" >
 
  <span class="module"> <img class="module-img" src="static/images/3gang.png"/> ${list4.MENU_NAME}</span>
  </div>
  <div  id="div4" class="div-top"style="height: 320px;">
  <div style=" margin:0;padding:0;height: 100%">
    <div class="myDiv">
     
 
  </div>
  </div>
  </div>
 </c:if>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">操作确定</h4>
      </div>
      <div class="modal-body">
       确定进行更新么
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button onclick="onClickTrue()"type="button" class="btn btn-primary">确定</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="loading" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop='static'>
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" id="myModalLabel">提示</h4>
      </div>
      <div class="modal-body">
        请稍候。。。
      </div>
    </div>
  </div>
</div>
	

		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script> 
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<script type="text/javascript">
		$(top.hangge());
	</script>
<script type="text/javascript">
	function onClickTrue(){
	 $('#myModal').modal('hide');
	  $('#loading').modal('show');
	var control_action_id= $("#control_action_id").val()
	var R_ID= $("#R_ID").val();
	var ip=returnCitySN["cip"];
	var value= $("#value").val();
	console.log(control_action_id)
	 $.ajax({
          url:'write_controller_water',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID,control_action_id,ip,value},
		success:function(data){
			$('#loading').modal('hide');
		}
		
	})
	}
$(function () {
	var R_ID=$("#R_ID").val();
	controller_water();
	$("#module0").click(function(){ 
$("#div0").slideToggle("slow" )
  })  
	$("#module1").click(function(){ 
$("#div1").slideToggle("slow" )
  })  
  $("#module2").click(function(){ 
$("#div2").slideToggle("slow" )
  })  
  $("#module3").click(function(){ 
$("#div3").slideToggle("slow" )
  })  
  $("#module4").click(function(){ 
$("#div4").slideToggle("slow" )
  })  
  
 var lists=[];
     lists.push(${list0.hasMenu});
       lists.push(${list1.hasMenu});
        lists.push(${list2.hasMenu});
         lists.push(${list3.hasMenu});
          lists.push(${list4.hasMenu});
          
       
	for(i=0;i<lists.length;i++){
	  if(lists[i]){
		$("#div"+i).show();
		//break;
	  }
  }
  
	function controller_water(){
		  $.ajax({
          url:'controller_water',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			console.log(data)
			var dataList=eval(data.map.result.myArrayList)
			$("#controller_water").show();
			for(i=0;i<dataList.length;i++){
			  if(dataList[i].map.is_state==3){
			  
			   if(dataList[i].map.param_name=="流量速率限值状态"){
			   $("#traffic").show();
			     var  param_value=dataList[i].map.param_value;
			     var param_name_cn=dataList[i].map.param_name_cn;
			     var  control_action_id=dataList[i].map.control_action_id;
			     $("#param_name_cn").text(param_name_cn);
			      $("#param_value").text(param_value);
			     //  $("#setValue ").children("#control_action_ids").val(control_action_id);
			   }
			    if(dataList[i].map.param_name=="水位限值状态"){
			     $("#water").show();
			     var  param_value=dataList[i].map.param_value;
			     var param_name_cn=dataList[i].map.param_name_cn;
			     $("#param_name_cn2").text(param_name_cn);
			      $("#param_value2").text(param_value);
			     // $("#setValue2 ").children("#control_action_ids").val(control_action_id);
			   }
			    if(dataList[i].map.param_name=="流速限值状态"){
			     $("#current").show();
			     var  param_value=dataList[i].map.param_value;
			     var param_name_cn=dataList[i].map.param_name_cn;
			     $("#param_name_cn3").text(param_name_cn);
			      $("#param_value3").text(param_value);
			     //  $("#setValue3 ").children("#control_action_ids").val(control_action_id);
			   }
			  }
			}
			
			
			
			   
		
		
	}
	
})
}
	
	})

</script>

</body>
<script src="static/bootstrap/js/bootstrap2.js"></script>

  <link  rel="stylesheet"href="static/bootstrap/css/bootstrap/bootstrap2.css" />
</html>