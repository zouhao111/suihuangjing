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
	<script src="static/js/jquery.min1.9.0.js"></script>
		<link href="static/buttons/buttons.css" rel="stylesheet" type="text/css"/>
	<%--
	--%><script src="static/js/conversion.js"></script>
	<%--<script type="text/javascript" src="static/js/jquery-ui-1.9.2.custom.min.js"></script>
	--%><%--script src="static/bootstrap/js/bootstrap.min.js"></script>	
	--%>
	<script src="static/bootstrap/bootstrap-table2/colResizable-1.6.js"></script>
  <%--
	--%><script src="static/js/echarts.min.js"></script>
<script src="static/js/myjs/center.js"></script>

<script type="text/javascript">
$(document).ready(function(){  
	var menuUrl=$("#menuUrl").attr("href")
		$.cookie('menuUrl_ss', menuUrl, { expires: 1, path: '/TDHT3.0' });
  $(".button-raised").click(function(){  
 $("#control_action_id").val($(this).val()) 
     //alert($("#control_action_id").val())
}); 
  $("#kongtiao_model .cover_class").click(function(){  
	//  console.log($(this).children("input").val())
	  $("#control_action_id").val($(this).children("input").val()) 
	    $('#myModal').modal()                      // 使用默认值初始化
$('#myModal').modal({ keyboard: true,
	                  backdrop:'static'     })   // 初始化。不支持键盘导航
$('#myModal').modal('show')        
 // alert($(this));  
    
}); 
   $("#kongtiao_feng .cover_class").click(function(){  
	 //  console.log($(this).children("input").val())
	   $("#control_action_id").val($(this).children("input").val()) 
	   $('#myModal').modal()                      // 使用默认值初始化
$('#myModal').modal({ keyboard: true,
	                  backdrop:'static'     })   // 初始化。不支持键盘导航
$('#myModal').modal('show')        
 // alert($(this));  
    
}); 
}); 

 </script>
<script>
  (function($){ 
	  $(document).ready(function(){   
		  $(".myDiv").center();
		   $(".water_div").center();
		   $(".poll_sum_div").center();
		   $(".t_div").center();
		   
		  
		   
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
.cover_class{
width:172px;
height:170px;
float: left;
    margin-right: 70px;

 cursor:pointer;
}
.control_img{
 position: relative;
 left:26px;


}
.cover_onoff{
 margin-bottom: 10px
}
.cover_name{
border-left: 3px solid #28A2DB; 
 height:20px;
}
.control_class{
width:100%;
height:200px;
display: none;
}
.kongtiao_model_name{
float: left;
    width: 100%;
    margin-top: 15px;
}

.button_off{
    background: linear-gradient(#dddddd, #dddddd);
    border-color: #dddddd;
    color: #000000;
}
</style>

<base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="../../system/index/top.jsp"%>

</head>
<body style="background-color:#fff;"onload="resizeFrame()">
<a id="menuUrl" href="${menuUrl}"></a>
<input  id="R_ID" type="hidden"  value="${R_ID}"/>
<input  id="list" type="hidden"  value="${list}"/>
<input  id="control_action_id" type="hidden"  value=""/>
<c:if test="${list0.hasMenu}">
  <div id="module0" >
 
  <span class="module"> <img class="module-img" src="static/images/3gang.png"/> ${list0.MENU_NAME}</span>
  </div>
  <div id="div0" class="div-top"style="height: 500px;">
  <div style=" margin:0;padding:0;height: 100%">
    <div class="myDiv">
  <div id="controller_state" style="clear:both ;width:110%; margin:0;padding:0;display: none;height:500px;">
  <div style="width:100%;height:260px">
      <div id="main0" style="height:250px;top:40px;width:30%;float: left;"></div>
       <div id="main1" style="height:250px;top:40px;width:30%;float: left;"></div>
        <div id="main2" style="height:250px;top:40px;width:30%;float: left;"></div>
        </div>
        <div>
        <div class='t_div' > 控制器状态</div>
        <div id="state"class="water_div"style="top:10px;"></div>
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
  <div  id="div1" class="div-top"style="">
  <div style=" margin:0;padding:0;height: 100%">
    <div class="myDiv">
      <div class='t_div' ></div>
        <div id="control_all"class="water_div"style="top:10px;">
           <div id="cover_control"class="control_class">
                  
                  <div  id="c_manhole_1_state" class="cover_class"><div id="cover_name" class="cover_name">工业排水井盖</div><img class="control_img" src="static/images/control/manhole_01s.png"/><button id="cover_on" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="2"class="button button-raised button-primary button-pill">开启</button><button id="cover_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="1"class="button button-raised button-primary button-pill">关闭</button></div>
                   
                  <div  id="c_manhole_2_state" class="cover_class"><div id="cover_name"class="cover_name">工业给水井盖</div><img class="control_img" src="static/images/control/manhole_01s.png"/><button id="cover_on"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="4" class="button button-raised button-primary button-pill">开启</button><button id="cover_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="3"class="button button-raised button-primary button-pill">关闭</button></div>
                 
                  <div  id="c_manhole_3_state" class="cover_class"><div id="cover_name"class="cover_name">生活排水井盖</div><img class="control_img" src="static/images/control/manhole_01s.png"/><button id="cover_on" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="6"class="button button-raised button-primary button-pill">开启</button><button id="cover_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="5"class="button button-raised button-primary button-pill">关闭</button></div>
                 
                  <div  id="c_manhole_4_state" class="cover_class"><div id="cover_name"class="cover_name">生活给水井盖</div><img class="control_img" src="static/images/control/manhole_01s.png"/><button id="cover_on" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="8"class="button button-raised button-primary button-pill">开启</button><button id="cover_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="7"class="button button-raised button-primary button-pill">关闭</button></div>
           
           
           </div>
        <div id="door_control"class="control_class">
                  <div id="c_door_state"class="cover_class"><div id="door_name" class="cover_name">舱门</div><img class="control_img" src="static/images/control/door_03s.png"/><button id="door_on" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="15"class="button button-raised button-primary button-pill">开门</button><button id="door_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="14"class="button button-raised button-primary button-pill">关门</button></div>
           </div>
        
        <div id="light_control"class="control_class">
                  <div  id="c_light_control"class="cover_class"><div id="light_name" class="cover_name">灯光</div><img class="control_img" src="static/images/control/light_02s.png"/><button id="light_on"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="46"class="button button-raised button-primary button-pill">启动</button><button id="light_off"  data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="45" class="button button-raised button-primary button-pill">关闭</button></div>
                 <div id="light_model_control">
               <div  id="c_light_medol_control"class="cover_class"style="display: none;"><div id="light_model_name" class="cover_name">灯光模式</div><img class="control_img" src="static/images/control/light_02s.png"/><button id="light_model_on"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="47" class="button button-raised button-primary button-pill">自动</button><button id="light_model_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="48"class="button button-raised button-primary button-pill">手动</button></div>   
        </div>
        </div>
       
        <div id="fengji_control"class="control_class">
         <div id="fengji1_control">
                  <div  id="c_blower_01_state"class="cover_class"><div id="fengji1_name" class="cover_name">风机1</div><img class="control_img" src="static/images/control/fengji1_03s.png"/><button id="fengji1_on"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="28" class="button button-raised button-primary button-pill">启动</button><button id="fengji1_off"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="27" class="button button-raised button-primary button-pill">关闭</button></div>
        </div>
         <div id="fengji2_control">
                  <div id="c_blower_02_state"class="cover_class"><div id="fengji2_name" class="cover_name">风机2</div><img class="control_img" src="static/images/control/fengji1_03s.png"/><button id="fengji2_on" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="30"class="button button-raised button-primary button-pill">启动</button><button id="fengji1_off"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="29" class="button button-raised button-primary button-pill">关闭</button></div>
        </div>
          <div id="fengji_model_control">
                  <div id="c_blower_model_state"class="cover_class"><div id="fengji_model_name" class="cover_name">风机模式</div><img class="control_img" src="static/images/control/fengji1_03s.png"/><button id="fengji_model_on"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="39" class="button button-raised button-primary button-pill">自动</button><button id="fengji_model_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="40"class="button button-raised button-primary button-pill">手动</button></div>
        </div>
        </div>
         <div id="kongtiao_control"class="control_class" >
                  
                  <div id="c_air_con_onoff_state"class="cover_class"><div id="kongtiao_name" class="cover_name">空调</div><img class="control_img" src="static/images/control/kongtiao_02s.png"/><button id="kongtiao_on" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="16"class="button button-raised button-primary button-pill">开启</button><button id="kongtiao_off"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="17" class="button button-raised button-primary button-pill">关闭</button></div>
                 
                  </div>
           
           
           
        
        
        
        <div id="kongtiao_model"class="control_class"> 
         <div class="kongtiao_model_name">空调模式</div>
                    
                  <div class="cover_class"><img value="18" alt="自动" id="kongtiao_controla"class="control_img"     src="static/images/control/kong_auto_01s.png"/></div>
                 
                  <div class="cover_class"><img value="19" alt="送风"id="kongtiao_control1"class="control_img" src="static/images/control/kong_clean_01s.png"/></div>
                 
                  <div class="cover_class"><img value="20" alt="制冷"id="kongtiao_control2"class="control_img" src="static/images/control/kong_cold_01s.png"/></div>
                  
                  <div class="cover_class"><img value="21" alt="制热"id="kongtiao_control3"class="control_img" src="static/images/control/kong_hot_01s.png"/></div>
                  <div class="cover_class"><img value="22" alt="除湿"id="kongtiao_control4"class="control_img" src="static/images/control/kong_wet_01s.png"/></div>
        </div>
         <div id="kongtiao_feng"class="control_class">
                 <div class="kongtiao_model_name">风量</div>
                      <div id="101"class="cover_class"><input type="hidden" value="123"/><img  alt="自动" id="kongtiao_model_controla"class="control_img" src="static/images/control/kong_feng_auto_01.png"/></div>
                    <div class="cover_class"><input type="hidden" value="23"/><img  id="kongtiao_model_control0"class="control_img" src="static/images/control/kong_feng0_01.png"/></div>
                  <div class="cover_class"><input type="hidden"value="24" /><img  id="kongtiao_model_control1"class="control_img" src="static/images/control/kong_feng1_01.png"/></div>
                 
                  <div class="cover_class"><input type="hidden"value="25" /><img  id="kongtiao_model_control2"class="control_img" src="static/images/control/kong_feng2_01.png"/></div>
                 
                  <div class="cover_class"><input type="hidden"value="26" /><img  id="kongtiao_model_control3"class="control_img" src="static/images/control/kong_feng3_01.png"/></div>
        </div>
        
      
                    <div id="kongtiao_temp_control"class="control_class">
                   <div id="kongtiao_temp_controls"class="cover_class"><div id="kongtiao_temp" class="cover_name">温度</div><div id="font_temp"></div></div><img class="control_img" src="static/images/control/kong_temp2.png"/><button id="kong_temp_on" class="button button-raised button-primary button-pill">升温</button><button id="kong_temp_off" class="button button-raised button-primary button-pill">降温</button></div>
                  </div>
        
        
        
        
           <div id="qianshui_control_div"class="control_class">
        <div id="qianshui_control">
                  <div id="c_pump_state" class="cover_class"><div id="qianshui_name" class="cover_name">吸水泵</div><img class="control_img" src="static/images/control/qianshui_02s.png"/><button id="qianshui_on" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="42"class="button button-raised button-primary button-pill">启动</button><button id="qianshui_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="41"class="button button-raised button-primary button-pill">关闭</button></div>
        </div>
         <div id="qianshui_model_control">
                  <div id="c_pump_mode_state"class="cover_class"style="display: none;"><div id="qianshui_model_name" class="cover_name">吸水泵模式</div><img class="control_img" src="static/images/control/qianshui_02s.png"/><button id="qianshui_model_on"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="43" class="button button-raised button-primary button-pill">自动</button><button id="qianshui_model_off"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="44" class="button button-raised button-primary button-pill">手动</button></div>
        </div>
        </div>
        
        
        
        <div id="famen_control"class="control_class">
                  <div id="c_gate_state"class="cover_class"><div id="famen_name" class="cover_name">电磁阀门</div><img class="control_img" src="static/images/control/famen_01s.png"/><button id="famen_on" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="12"class="button button-raised button-primary button-pill">启动</button><button id="famen_off"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="11" class="button button-raised button-primary button-pill">关闭</button></div>
        </div>
        
        <div id="xiaofang_control"class="control_class">
        <div id="xiaofang1_control">
                  <div id="c_fire_alarm_01_state"class="cover_class"><div id="xiaofang1_name" class="cover_name">消防报警</div><img class="control_img" src="static/images/control/xiaofang01_02s.png"/><button id="xiaofang1_on"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="" class="button button-raised button-primary button-pill">启动</button><button id="xiaofang1_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value=""class="button button-raised button-primary button-pill">关闭</button></div>
        </div>
        
         
        <div id="xiaofang2_control">
                  <div id="c_fire_alarm_02_state"class="cover_class"><div id="xiaofang2_name" class="cover_name">消防报警2</div><img class="control_img" src="static/images/control/xiaofang02_02s.png"/><button id="xiaofang2_on"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="" class="button button-raised button-primary button-pill">启动</button><button id="xiaofang2_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value=""class="button button-raised button-primary button-pill">关闭</button></div>
        </div>
        </div>
        
          <div id="yewei_control"class="control_class">
                  <div id="c_water_alarm_01_state"class="cover_class"><div id="yewei_name" class="cover_name">液位报警</div><img class="control_img" src="static/images/control/louye_02s.png"/><button id="yewei1_on" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value=""class="button button-raised button-primary button-pill">启动</button><button id="yewei1_off"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="" class="button button-raised button-primary button-pill">关闭</button></div>
        </div>
          <div id="yewei2_control"class="control_class">
                  <div id="c_water_alarm_02_state"class="cover_class"><div id="yewei_name" class="cover_name">液位报警</div><img class="control_img" src="static/images/control/louye_02s.png"/><button id="yewei2_on" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value=""class="button button-raised button-primary button-pill">启动</button><button id="yewei2_off"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="" class="button button-raised button-primary button-pill">关闭</button></div>
        </div>
        
        <div id="shengguang_control"class="control_class">
                  <div id="voice_light_alarm_state"class="cover_class"><div id="shengguang_name" class="cover_name">声光报警</div><img class="control_img" src="static/images/control/shengguang_02s.png"/><button id="shengguang_on"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="" class="button button-raised button-primary button-pill">启动</button><button id="shengguang_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value=""class="button button-raised button-primary button-pill">关闭</button></div>
        </div>
        
         <div id="wengan_control"class="control_class">
                  <div id="c_temp_alarm_state"class="cover_class"><div id="wengan_name" class="cover_name">温感报警</div><img class="control_img" src="static/images/control/wen_02s.png"/><button id="wengan_on" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value=""class="button button-raised button-primary button-pill">启动</button><button id="wengan_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value=""class="button button-raised button-primary button-pill">关闭</button></div>
        </div>
         <div id="yangan_control"class="control_class">
                  <div id="c_smoke_alarm_state"class="cover_class"><div id="yangan_name" class="cover_name">烟感报警</div><img class="control_img" src="static/images/control/yan_02s.png"/><button id="yangan_on"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="" class="button button-raised button-primary button-pill">启动</button><button id="yangan_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value=""class="button button-raised button-primary button-pill">关闭</button></div>
        </div>
         <div id="hongwai_control"class="control_class">
                  <div id="c_infrared_alarm_state"class="cover_class"><div id="hongwai_name" class="cover_name">红外报警</div><img class="control_img" src="static/images/control/hongwai_02s.png"/><button id="hongwai_on"data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value="" class="button button-raised button-primary button-pill">启动</button><button id="hongwai_off" data-toggle="modal"  aria-hidden="true" data-backdrop="static" data-target="#myModal"value=""class="button button-raised button-primary button-pill">关闭</button></div>
        </div>
        
        
        
        </div>
       
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
       确定进行操作么
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
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script> 
	<script type="text/javascript">
		$(top.hangge());
	</script>
	<script type="text/javascript">
	$(document).ready(function(){ 
　　$("#a").click(function(){ 
　　　　//adding your code here　　 
　　}); 
}); 
	</script>
<script type="text/javascript">
 function onClickTrue(){
	 $('#myModal').modal('hide');
	  $('#loading').modal('show');
	var control_action_id= $("#control_action_id").val()
	var R_ID= $("#R_ID").val();
	var ip=returnCitySN["cip"];
	 $.ajax({
          url:'write_acontroller_control',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID,control_action_id,ip},
		success:function(data){
			$('#loading').modal('hide');
		}
		
	})
	
	
}
  var height=0;
  
$(function () {
	var R_ID=$("#R_ID").val();
	controller_state();
	controller_control();
	$("#module0").click(function(){ 
$("#div0").slideToggle("slow" )
  })  
	$("#module1").click(function(){ 
$("#div1").slideToggle("slow" )
  })  
  
 var lists=[];
     lists.push(${list0.hasMenu});
       lists.push(${list1.hasMenu});
       
	for(i=0;i<lists.length;i++){
	  if(lists[i]){
		$("#div"+i).show();
		heights=$("#div"+i).height(); 
		if(heights!=null){
			height=height+heights;
		}
		//break;
	  }
  }
  height=height+100;
 $("body").css("height",height)
 
  
	function controller_state(){
		  $.ajax({
          url:'controller_state',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			//console.log(data)
			$("#controller_state").show();
			   $.each(data.varList, function(i, dvar){
				   var myChart= echarts.init(document.getElementById('main'+i)); 
				   console.log(document.getElementById('main'+i))
				    myChart.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
				    	textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0})
				 // console.log(dvar.param_type)
			option = {
    tooltip : {
        formatter: "{a} <br/>{b} : {c}%"
    },
   
    series: [
        {
            name: dvar.param_name_cn,
            type: 'gauge',
           radius: '90%',
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    width: 10
                }
            },
            data: [{value: dvar.param_value, name: dvar.param_name_cn}]
        }
    ]
}
		  myChart.setOption(option, true);
           window.onresize = myChart.resize;
                myChart.setOption(option);
                 myChart.hideLoading();
				 
		
		})
		
		 $.each(data.online_list, function(i, dvar){
			if(dvar.device_state==0){
			$("#state").append("<div class='t_button '><button class='my_button button button-glow button-rounded button-raised button-primary'>"+dvar.device_name_cn+"</button></div>")	
			}else{
				$("#state").append("<div class='t_button '><button class='my_button button button-glow button-rounded button-raiseds button-primarys'>"+dvar.device_name_cn+"</button></div>")	
			}
			 
		 })
		
		
	}
	
})
}
	function controller_control(){
		  $.ajax({
          url:'controller_control',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			
			var dataList=eval(data.map.result.myArrayList)
			//console.log(dataList[0].map.param_value)
			$("#control_all").show();
			  
		for(i=0;i<dataList.length;i++){
		    if(dataList[i].map.is_state==1){
		   // console.log(dataList[i].map.is_state)
		    
		    if(dataList[i].map.c_is_bit==0){
		    var  param_value=dataList[i].map.param_value
		         
		      }else{
		      var bitNumber=[];
		      bitNumber=intToByte(dataList[i].map.param_value);
		      var param_value=bitNumber[dataList[i].map.c_bit_num]
		      }
		       if(dataList[i].map.param_name=="空调风量状态"){
		    	    $("#kongtiao_feng").show();
		   
		      if(param_value==dataList[i].map.control_value){
		       //  console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="自动"){
		            $("#kongtiao_model_controla").attr('src',"static/images/control/kong_feng_auto_02.png");
		            $("#kongtiao_model_control0").attr('src',"static/images/control/kong_feng0_01.png"); 
		             $("#kongtiao_model_control1").attr('src',"static/images/control/kong_feng1_01.png"); 
		              $("#kongtiao_model_control2").attr('src',"static/images/control/kong_feng2_01.png"); 
		               $("#kongtiao_model_control3").attr('src',"static/images/control/kong_feng3_01.png"); 
		            }
		            if(dataList[i].map.action_order=="LL"){
		            $("#kongtiao_model_controla").attr('src',"static/images/control/kong_feng_auto_01.png");
		            $("#kongtiao_model_control0").attr('src',"static/images/control/kong_feng0_02.png"); 
		             $("#kongtiao_model_control1").attr('src',"static/images/control/kong_feng1_01.png"); 
		              $("#kongtiao_model_control2").attr('src',"static/images/control/kong_feng2_01.png"); 
		               $("#kongtiao_model_control3").attr('src',"static/images/control/kong_feng3_01.png"); 
		            }
		             if(dataList[i].map.action_order=="L"){
		             $("#kongtiao_model_controla").attr('src',"static/images/control/kong_feng_auto_01.png");
		            $("#kongtiao_model_control0").attr('src',"static/images/control/kong_feng0_01.png"); 
		             $("#kongtiao_model_control1").attr('src',"static/images/control/kong_feng1_02.png"); 
		              $("#kongtiao_model_control2").attr('src',"static/images/control/kong_feng2_01.png"); 
		               $("#kongtiao_model_control3").attr('src',"static/images/control/kong_feng3_01.png"); 
		            }
		             if(dataList[i].map.action_order=="H"){
		             $("#kongtiao_model_controla").attr('src',"static/images/control/kong_feng_auto_01.png");
		            $("#kongtiao_model_control0").attr('src',"static/images/control/kong_feng0_01.png"); 
		             $("#kongtiao_model_control1").attr('src',"static/images/control/kong_feng1_01.png"); 
		              $("#kongtiao_model_control2").attr('src',"static/images/control/kong_feng2_02.png"); 
		               $("#kongtiao_model_control3").attr('src',"static/images/control/kong_feng3_01.png"); 
		            }
		             if(dataList[i].map.action_order=="HH"){
		             $("#kongtiao_model_controla").attr('src',"static/images/control/kong_feng_auto_01.png");
		            $("#kongtiao_model_control0").attr('src',"static/images/control/kong_feng0_01.png"); 
		             $("#kongtiao_model_control1").attr('src',"static/images/control/kong_feng1_01.png"); 
		              $("#kongtiao_model_control2").attr('src',"static/images/control/kong_feng2_01.png"); 
		               $("#kongtiao_model_control3").attr('src',"static/images/control/kong_feng3_02.png"); 
		            }
		         }
		    }
		      if(dataList[i].map.param_name=="空调模式状态"){
		  $("#kongtiao_model").show();
		      if(param_value==dataList[i].map.control_value){
		       //  console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="自动"){
		            $("#kongtiao_controla").attr('src',"static/images/control/kong_auto_02s.png");
		            $("#kongtiao_control1").attr('src',"static/images/control/kong_clean_01s.png"); 
		             $("#kongtiao_control2").attr('src',"static/images/control/kong_cold_01s.png"); 
		              $("#kongtiao_control3").attr('src',"static/images/control/kong_hot_01s.png"); 
		               $("#kongtiao_control4").attr('src',"static/images/control/kong_wet_01s.png"); 
		            }
		            if(dataList[i].map.action_order=="送风"){
		            $("#kongtiao_controla").attr('src',"static/images/control/kong_auto_01s.png");
		            $("#kongtiao_control1").attr('src',"static/images/control/kong_clean_02s.png"); 
		             $("#kongtiao_control2").attr('src',"static/images/control/kong_cold_01s.png"); 
		              $("#kongtiao_control3").attr('src',"static/images/control/kong_hot_01s.png"); 
		               $("#kongtiao_control4").attr('src',"static/images/control/kong_wet_01s.png"); 
		            }
		             if(dataList[i].map.action_order=="制冷"){
		              $("#kongtiao_controla").attr('src',"static/images/control/kong_auto_01s.png");
		            $("#kongtiao_control1").attr('src',"static/images/control/kong_clean_01s.png"); 
		             $("#kongtiao_control2").attr('src',"static/images/control/kong_cold_02s.png"); 
		              $("#kongtiao_control3").attr('src',"static/images/control/kong_hot_01s.png"); 
		               $("#kongtiao_control4").attr('src',"static/images/control/kong_wet_01s.png"); 
		            }
		             if(dataList[i].map.action_order=="加热"){
		            $("#kongtiao_controla").attr('src',"static/images/control/kong_auto_01s.png");
		            $("#kongtiao_control1").attr('src',"static/images/control/kong_clean_01s.png"); 
		             $("#kongtiao_control2").attr('src',"static/images/control/kong_cold_01s.png"); 
		              $("#kongtiao_control3").attr('src',"static/images/control/kong_hot_02s.png"); 
		               $("#kongtiao_control4").attr('src',"static/images/control/kong_wet_01s.png"); 
		            }
		             if(dataList[i].map.action_order=="除湿"){
		              $("#kongtiao_controla").attr('src',"static/images/control/kong_auto_01s.png");
		            $("#kongtiao_control1").attr('src',"static/images/control/kong_clean_01s.png"); 
		             $("#kongtiao_control2").attr('src',"static/images/control/kong_cold_01s.png"); 
		              $("#kongtiao_control3").attr('src',"static/images/control/kong_hot_01s.png"); 
		               $("#kongtiao_control4").attr('src',"static/images/control/kong_wet_02s.png"); 
		            }
		         }
		    }
		    
		     if(dataList[i].map.param_name=="工业排水井盖状态"){
		    	 
		    	  $("#cover_control").show();
		    	 $("#c_manhole_1_state").show();
		    	 
		      if(param_value==dataList[i].map.control_value){
		        // console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="打开"){
		            $("#c_manhole_1_state img").attr('src',"static/images/control/manhole_02s.png");
		             $("#c_manhole_1_state #cover_on").removeClass("button-raiseds button-primarys");
		             $("#c_manhole_1_state #cover_off").addClass("button-raiseds button-primarys");
		             $("#c_manhole_1_state #cover_on").addClass("button-raised button-primary");
		             $("#c_manhole_1_state #cover_off").removeClass("button-raised button-primary");
		             
		            }
		            if(dataList[i].map.action_order=="关闭"){
		            $("#c_manhole_1_state img").attr('src',"static/images/control/manhole_01s.png");
		              $("#c_manhole_1_state #cover_off").removeClass("button-raiseds button-primarys");
		             $("#c_manhole_1_state #cover_on").addClass("button-raiseds button-primarys");
		              $("#c_manhole_1_state #cover_on").removeClass("button-raised button-primary");
		             $("#c_manhole_1_state #cover_off").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		     if(dataList[i].map.param_name=="工业给水井盖状态"){
		  $("#cover_control").show();
		    	 $("#c_manhole_2_state").show();
		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="打开"){
		            $("#c_manhole_2_state img").attr('src',"static/images/control/manhole_02s.png");
		            $("#c_manhole_2_state #cover_on").removeClass("button-raiseds button-primarys");
		             $("#c_manhole_2_state #cover_off").addClass("button-raiseds button-primarys");
		              $("#c_manhole_2_state #cover_on").addClass("button-raised button-primary");
		             $("#c_manhole_2_state #cover_off").removeClass("button-raised button-primary");
		            }
		            if(dataList[i].map.action_order=="关闭"){
		            $("#c_manhole_2_state img").attr('src',"static/images/control/manhole_01s.png");
		            $("#c_manhole_2_state #cover_on").addClass("button-raiseds button-primarys");
		             $("#c_manhole_2_state #cover_off").removeClass("button-raiseds button-primarys");
		              $("#c_manhole_2_state #cover_on").removeClass("button-raised button-primary");
		             $("#c_manhole_2_state #cover_off").addClass("button-raised button-primary");
		             
		            }
		           
		         }
		    }
		     if(dataList[i].map.param_name=="生活排水井盖状态"){
		    	 $("#cover_control").show();
		    	 $("#c_manhole_3_state").show();
		    //console.log(dataList[i].map.param_name_cn)
		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="打开"){
		            $("#c_manhole_3_state img").attr('src',"static/images/control/manhole_02s.png");
		             $("#c_manhole_3_state #cover_on").removeClass("button-raiseds button-primarys");
		             $("#c_manhole_3_state #cover_off").addClass("button-raiseds button-primarys");
		             $("#c_manhole_3_state #cover_on").addClass("button-raised button-primary");
		             $("#c_manhole_3_state #cover_off").removeClass("button-raised button-primary");
		            }
		            if(dataList[i].map.action_order=="关闭"){
		            $("#c_manhole_3_state img").attr('src',"static/images/control/manhole_01s.png");
		              $("#c_manhole_3_state #cover_on").addClass("button-raiseds button-primarys");
		             $("#c_manhole_3_state #cover_off").removeClass("button-raiseds button-primarys");
		             $("#c_manhole_3_state #cover_on").removeClass("button-raised button-primary");
		             $("#c_manhole_3_state #cover_off").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		     if(dataList[i].map.param_name=="生活给水井盖状态"){
		     $("#cover_control").show();
		    	 $("#c_manhole_4_state").show();
		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="打开"){
		            $("#c_manhole_4_state img").attr('src',"static/images/control/manhole_02s.png");
		             $("#c_manhole_4_state #cover_on").removeClass("button-raiseds button-primarys");
		             $("#c_manhole_4_state #cover_off").addClass("button-raiseds button-primarys");
		             $("#c_manhole_2_state #cover_on").addClass("button-raised button-primary");
		             $("#c_manhole_2_state #cover_off").removeClass("button-raised button-primary");
		             
		            }
		            if(dataList[i].map.action_order=="关闭"){
		            $("#c_manhole_4_state img").attr('src',"static/images/control/manhole_01s.png");
		              $("#c_manhole_4_state #cover_on").addClass("button-raiseds button-primarys");
		             $("#c_manhole_4_state #cover_off").removeClass("button-raiseds button-primarys");
		             $("#c_manhole_2_state #cover_on").removeClass("button-raised button-primary");
		             $("#c_manhole_2_state #cover_off").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		    
		      if(dataList[i].map.param_name=="灯光状态"){
		    	   $("#light_control").show();
		    	 $("#c_light_control").show();
		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="打开"){
		            $("#c_light_control img").attr('src',"static/images/control/light_02s.png");
		              $("#light_on").removeClass("button-primarys button-raiseds");
		             $("#light_off").addClass("button-primarys button-raiseds");
		             $("#light_on").addClass("button-raised button-primary");
		             $("#light_off").removeClass("button-raised button-primary");
		            }
		            if(dataList[i].map.action_order=="关闭"){
		            $("#c_light_control img").attr('src',"static/images/control/light_03s.png");
		              $("#light_on").addClass("button-primarys button-raiseds");
		             $("#light_off").removeClass("button-primarys button-raiseds");
		             $("#light_on").removeClass("button-raised button-primary");
		             $("#light_off").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		      if(dataList[i].map.param_name=="灯光模式状态"){
		     $("#light_control").show();
		    	 $("#c_light_medol_control").show();
		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="自动"){
		            $("#c_light_medol_control img").attr('src',"static/images/control/light_02s.png");
		             $("#light_model_on").removeClass("button-raiseds button-primarys");
		             $("#light_model_off").addClass("button-raiseds button-primarys");
		             $("#light_model_on").addClass("button-raised button-primary");
		             $("#light_model_off").removeClass("button-raised button-primary");
		            }
		            if(dataList[i].map.action_order=="手动"){
		            $("#c_light_medol_control img").attr('src',"static/images/control/light_03s.png");
		             $("#light_model_on").addClass("button-raiseds button-primarys");
		             $("#light_model_off").removeClass("button-raiseds button-primarys");
		             $("#light_model_on").removeClass("button-raised button-primary");
		             $("#light_model_off").addClass("button-raised button-primary");
		             
		            }
		           
		         }
		    }
		      
		         if(dataList[i].map.param_name=="舱门状态"){
		   $("#door_control").show();
		    	 $("#c_door_state").show();
		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="打开"){
		            $("#c_door_state img").attr('src',"static/images/control/door_02s.png");
		           $("#door_on").removeClass("button-raiseds button-primarys");
		             $("#door_off").addClass("button-raiseds button-primarys");
		             $("#door_on").addClass("button-raised button-primary");
		             $("#door_off").removeClass("button-raised button-primary");
		            }
		            if(dataList[i].map.action_order=="关闭"){
		            $("#c_door_state img").attr('src',"static/images/control/door_03s.png");
		            $("#door_on").addClass("button-raiseds button-primarys");
		             $("#door_off").removeClass("button-raiseds button-primarys");
		             $("#door_on").removeClass("button-raised button-primary");
		             $("#door_off").addClass("button-raised button-primary");
		             
		            }
		           
		         }
		    }
		      
		      if(dataList[i].map.param_name=="空调运行状态"){
		  $("#kongtiao_control").show();
		    	 $("#c_air_con_onoff_state").show();
		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="打开"){
		            $("#c_air_con_onoff_state img").attr('src',"static/images/control/kongtiao_02s.png");
		            $("#kongtiao_on").removeClass("button-raiseds button-primarys");
		             $("#kongtiao_off").addClass("button-raiseds button-primarys");
		             $("#kongtiao_on").addClass("button-raised button-primary");
		             $("#kongtiao_off").removeClass("button-raised button-primary");
		          }
		            if(dataList[i].map.action_order=="关闭"){
		            $("#c_air_con_onoff_state img").attr('src',"static/images/control/kongtiao_01s.png");
		              $("#kongtiao_on").addClass("button-raiseds button-primarys");
		             $("#kongtiao_off").removeClass("button-raiseds button-primarys");
		             $("#kongtiao_on").removeClass("button-raised button-primary");
		             $("#kongtiao_off").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		      if(dataList[i].map.param_name=="风机01状态"){
		   $("#fengji_control").show();
		    	 $("#c_blower_01_state").show();
		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="打开"){
		            $("#c_blower_01_state img").attr('src',"static/images/control/fengji1_02s.png");
		             $("#fengji1_on").removeClass("button-raiseds button-primarys");
		             $("#fengji1_off").addClass("button-raiseds button-primarys");
		             $("#fengji1_on").addClass("button-raised button-primary");
		             $("#fengji1_off").removeClass("button-raised button-primary");
		            }
		            if(dataList[i].map.action_order=="关闭"){
		            $("#c_blower_01_state img").attr('src',"static/images/control/fengji1_03s.png");
		             $("#fengji1_on").addClass("button-raiseds button-primarys");
		             $("#fengji1_off").removeClass("button-raiseds button-primarys");
		             
		            }
		           
		         }
		    }
		      if(dataList[i].map.param_name=="风机02状态"){
		     $("#fengji_control").show();
		    	 $("#c_blower_02_state").show();
		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="打开"){
		            $("#c_blower_02_state img").attr('src',"static/images/control/fengji1_02s.png");
		             $("#fengji2_on").removeClass("button-raiseds button-primarys");
		             $("#fengji2_off").addClass("button-raiseds button-primarys");
		             $("#fengji2_on").addClass("button-raised button-primary");
		             $("#fengji2_off").removeClass("button-raised button-primary");
		            }
		            if(dataList[i].map.action_order=="关闭"){
		            $("#c_blower_02_state img").attr('src',"static/images/control/fengji1_03s.png");
		             $("#fengji2_on").addClass("button-raiseds button-primarys");
		             $("#fengji2_off").removeClass("button-raiseds button-primarys");
		             $("#fengji2_on").removeClass("button-raised button-primary");
		             $("#fengji2_off").addClass("button-raised button-primary");
		             
		            }
		           
		         }
		    }
		        if(dataList[i].map.param_name=="风机模式状态"){
		     $("#fengji_control").show();
		    	 $("#c_blower_model_state").show();
		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="自动"){
		            $("#c_blower_model_state img").attr('src',"static/images/control/fengji1_02s.png");
		             $("#fengji2_on").removeClass("button-raiseds button-primarys");
		             $("#fengji2_off").addClass("button-raiseds button-primarys");
		             $("#fengji2_on").addClass("button-raised button-primary");
		             $("#fengji2_off").removeClass("button-raised button-primary");
		            }
		            if(dataList[i].map.action_order=="手动"){
		            $("#c_blower_model_state img").attr('src',"static/images/control/fengji1_03s.png");
		             $("#fengji2_on").addClass("button-raiseds button-primarys");
		             $("#fengji2_off").removeClass("button-raiseds button-primarys");
		             $("#fengji2_on").removeClass("button-raised button-primary");
		             $("#fengji2_off").addClass("button-raised button-primary");
		             
		            }
		           
		         }
		    }
		       if(dataList[i].map.param_name=="吸水泵状态"){
		    
               $("#qianshui_control_div").show();
		    	 $("#c_pump_state").show();
		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="启动"){
		            $("#c_pump_state img").attr('src',"static/images/control/qianshui_02s.png");
		            $("#qianshui_on").removeClass("button-raiseds button-primarys");
		             $("#qianshui_off").addClass("button-raiseds button-primarys");
		             $("#qianshui_on").addClass("button-raised button-primary");
		             $("#qianshui_off").removeClass("button-raised button-primary");
		            }
		            if(dataList[i].map.action_order=="停止"){
		            $("#c_pump_state img").attr('src',"static/images/control/qianshui_01s.png");
		             $("#qianshui_on").addClass("button-raiseds button-primarys");
		             $("#qianshui_off").removeClass("button-raiseds button-primarys");
		             $("#qianshui_on").removeClass("button-raised button-primary");
		             $("#qianshui_off").addClass("button-raised button-primary");
		             
		            }
		           
		         }
		    }
		       if(dataList[i].map.param_name=="吸水泵模式状态"){
		     $("#qianshui_control_div").show();
		    	 $("#c_pump_mode_state").show();

		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="自动"){
		            $("#c_pump_mode_state img").attr('src',"static/images/control/qianshui_02s.png");
		             $("#qianshui_model_on").removeClass("button-raiseds button-primarys");
		             $("#qianshui_model_off").addClass("button-raiseds button-primarys");
		             $("#qianshui_model_on").addClass("button-raised button-primary");
		             $("#qianshui_model_off").removeClass("button-raised button-primary");
		            }
		            if(dataList[i].map.action_order=="手动"){
		            $("#c_pump_mode_state img").attr('src',"static/images/control/qianshui_01s.png");
		             $("#qianshui_model_on").addClass("button-raiseds button-primarys");
		             $("#qianshui_model_off").removeClass("button-raiseds button-primarys");
		             $("#qianshui_model_on").removeClass("button-raised button-primary");
		             $("#qianshui_model_off").addClass("button-raised button-primary");
		             
		            }
		           
		         }
		    }
		       if(dataList[i].map.param_name=="电磁阀门状态"){
		    $("#famen_control").show();
		    	 $("#c_gate_state").show();
		    

		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="打开"){
		            $("#c_gate_state img").attr('src',"static/images/control/famen_01s.png");
		            $("#famen_on").removeClass("button-raiseds button-primarys");
		             $("#famen_off").addClass("button-raiseds button-primarys");
		             $("#famen_on").addClass("button-raised button-primary");
		             $("#famen_off").removeClass("button-raised button-primary");
		            }
		            if(dataList[i].map.action_order=="关闭"){
		            $("#c_gate_state img").attr('src',"static/images/control/famen_02s.png");
		            $("#famen_on").addClass("button-raiseds button-primarys");
		             $("#famen_off").removeClass("button-raiseds button-primarys");
		             $("#famen_on").removeClass("button-raised button-primary");
		             $("#famen_off").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		       
		       if(dataList[i].map.param_name=="消防报警01状态"){
		     $("#xiaofang_control").show();
		    	 $("#c_fire_alarm_01_state").show();
		    

		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="启动"){
		            $("#c_fire_alarm_01_state img").attr('src',"static/images/control/xiaofang01_02s.png");
		          $("#xiaofang1_on").removeClass("button-raiseds button-primarys");
		             $("#xiaofang1_off").addClass("button-raiseds button-primarys");
		             $("#xiaofang1_on").addClass("button-raised button-primary");
		             $("#xiaofang1_off").removeClass("button-raised button-primary");
		          }
		            if(dataList[i].map.action_order=="关闭"){
		            $("#c_fire_alarm_01_state img").attr('src',"static/images/control/xiaofang01_01s.png");
		              $("#xiaofang1_on").addClass("button-raiseds button-primarys");
		             $("#xiaofang1_off").removeClass("button-raiseds button-primarys");
		             $("#xiaofang1_on").removeClass("button-raised button-primary");
		             $("#xiaofang1_off").addClass("button-raised button-primary");
		             
		            }
		           
		         }
		    }
		        if(dataList[i].map.param_name=="消防报警02状态"){
		    $("#xiaofang_control").show();
		    	 $("#c_fire_alarm_02_state").show();
		    

		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="打开"){
		            $("#c_fire_alarm_02_state img").attr('src',"static/images/control/xiaofang02_02s.png");
		            
		            $("#xiaofang2_on").removeClass("button-raiseds button-primarys");
		             $("#xiaofang2_off").addClass("button-raiseds button-primarys");
		             $("#xiaofang2_on").addClass("button-raised button-primary");
		             $("#xiaofang2_off").removeClass("button-raised button-primary");
		          }
		            if(dataList[i].map.action_order=="关闭"){
		            $("#c_fire_alarm_02_state img").attr('src',"static/images/control/xiaofang02_01s.png");
		               $("#xiaofang2_on").addClass("button-raiseds button-primarys");
		             $("#xiaofang2_off").removeClass("button-raiseds button-primarys");
		             $("#xiaofang2_on").removeClass("button-raised button-primary");
		             $("#xiaofang2_off").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		         if(dataList[i].map.param_name=="液位报警01状态"){
		     $("#yewei_control").show();
		    	 $("#c_water_alarm_01_state").show();
		    

		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="启动"){
		            $("#c_water_alarm_01_state img").attr('src',"static/images/control/louye_02s.png.png");
		          $("#yewei1_on").removeClass("button-raiseds button-primarys");
		             $("#yewei1_off").addClass("button-raiseds button-primarys");
		             $("#yewei1_on").addClass("button-raised button-primary");
		             $("#yewei1_off").removeClass("button-raised button-primary");
		          }
		            if(dataList[i].map.action_order=="停止"){
		            $("#c_water_alarm_01_state img").attr('src',"static/images/control/louye_01s.png");
		             $("#yewei1_on").addClass("button-raiseds button-primarys");
		             $("#yewei1_off").removeClass("button-raiseds button-primarys");
		             $("#yewei1_on").removeClass("button-raised button-primary");
		             $("#yewei1_off").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		     if(dataList[i].map.param_name=="液位报警02状态"){
		     $("#yewei_control").show();
		    	 $("#c_water_alarm_02_state").show();
		    

		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="启动"){
		            $("#c_water_alarm_02_state img").attr('src',"static/images/control/louye_02s.png");
		          $("#yewei2_on").removeClass("button-raiseds button-primarys");
		             $("#yewei2_off").addClass("button-raiseds button-primarys");
		             $("#yewei2_on").addClass("button-raised button-primary");
		             $("#yewei2_off").removeClass("button-raised button-primary");
		          }
		            if(dataList[i].map.action_order=="停止"){
		            $("#c_water_alarm_02_state img").attr('src',"static/images/control/louye_01s.png");
		              $("#yewei2_on").addClass("button-raiseds button-primarys");
		             $("#yewei2_off").removeClass("button-raiseds button-primarys");
		             $("#yewei2_on").removeClass("button-raised button-primary");
		             $("#yewei2_off").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		        if(dataList[i].map.param_name=="声光报警状态"){
		    
                 $("#shengguang_control").show();
		    	 $("#voice_light_alarm_state").show();
		    
		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="启动"){
		            $("#voice_light_alarm_state img").attr('src',"static/images/control/shengguang_02s.png");
		          $("#shengguang_on").removeClass("button-raiseds button-primarys");
		             $("#shengguang_off").addClass("button-raiseds button-primarys");
		             $("#shengguang_on").addClass("button-raised button-primary");
		             $("#shengguang_off").removeClass("button-raised button-primary");
		          }
		            if(dataList[i].map.action_order=="停止"){
		            $("#voice_light_alarm_state img").attr('src',"static/images/control/shengguang_01s.png");
		              $("#shengguang_on").addClass("button-raiseds button-primarys");
		             $("#shengguang_off").removeClass("button-raiseds button-primarys");
		             $("#shengguang_on").removeClass("button-raised button-primary");
		             $("#shengguang_off").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		     if(dataList[i].map.param_name=="温感报警状态"){
		     $("#wengan_control").show();
		    	 $("#c_temp_alarm_state").show();
		    

		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="启动"){
		            $("#c_temp_alarm_state img").attr('src',"static/images/control/wen_02s.png");
		             $("#wengan_on").removeClass("button-raiseds button-primarys");
		             $("#wengan_off").addClass("button-raiseds button-primarys");
		             $("#wengan_on").addClass("button-raised button-primary");
		             $("#wengan_on").removeClass("button-raised button-primary");
		            }
		            if(dataList[i].map.action_order=="停止"){
		            $("#c_temp_alarm_state img").attr('src',"static/images/control/wen_01s.png");
		              $("#wengan_on").addClass("button-raiseds button-primarys");
		             $("#wengan_off").removeClass("button-raiseds button-primarys");
		             $("#wengan_on").removeClass("button-raised button-primary");
		             $("#wengan_on").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		         if(dataList[i].map.param_name=="烟感报警状态"){
		    $("#yangan_control").show();
		    	 $("#c_smoke_alarm_state").show();
		    

		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="启动"){
		            $("#c_smoke_alarm_state img").attr('src',"static/images/control/yan_02s.png");
		          $("#yangan_on").removeClass("button-raiseds button-primarys");
		             $("#yangan_off").addClass("button-raiseds button-primarys");
		             $("#yangan_on").addClass("button-raised button-primary");
		             $("#yangan_off").removeClass("button-raised button-primary");
		          }
		            if(dataList[i].map.action_order=="停止"){
		            $("#c_smoke_alarm_state img").attr('src',"static/images/control/yan_01s.png");
		                $("#yangan_on").addClass("button-raiseds button-primarys");
		             $("#yangan_off").removeClass("button-raiseds button-primarys");
		             $("#yangan_on").removeClass("button-raised button-primary");
		             $("#yangan_off").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		       if(dataList[i].map.param_name=="红外报警状态"){
		     $("#hongwai_control").show();
		    	 $("#c_infrared_alarm_state").show();
		    

		      if(param_value==dataList[i].map.control_value){
		         //console.log(dataList[i].map.action_order)
		          if(dataList[i].map.action_order=="启动"){
		            $("#c_infrared_alarm_state img").attr('src',"static/images/control/hongwai_02s.png");
		          $("#hongwai_on").removeClass("button-raiseds button-primarys");
		             $("#hongwai_off").addClass("button-raiseds button-primarys");
		             $("#hongwai_on").addClass("button-raised button-primary");
		             $("#hongwai_off").removeClass("button-raised button-primary");
		          }
		            if(dataList[i].map.action_order=="停止"){
		            $("#c_infrared_alarm_state img").attr('src',"static/images/control/hongwai_01s.png");
		              $("#hongwai_on").addClass("button-raiseds button-primarys");
		             $("#hongwai_on").removeClass("button-raiseds button-primarys");
		             $("#hongwai_on").removeClass("button-raised button-primary");
		             $("#hongwai_off").addClass("button-raised button-primary");
		            }
		           
		         }
		    }
		         
		         
		      
		    
		    }else if(dataList[i].map.is_state==3){
		    	 var  param_value=dataList[i].map.param_value
		    	 if(dataList[i].map.param_name_cn=="空调温度状态"){
		    	    $("#kongtiao_temp_control").show();
		    	 $("#kongtiao_temp_controls").show();
		        $("#font_temp").text(param_value);
		    	 
		    	 }
		    	
		    	
		    }
		}
		
		
		
	}
	
})
}
	
	
	
	
	
	})
function resizeFrame(){
            var content_iframe = window.parent.document.getElementById("page");//获取iframeID
              var content_iframes = window.parent.parent.document.getElementById("iframe_div");//获取iframeID
            content_iframe.style.height = height+"px";
         height=height+350;
            content_iframes.style.height =height+'px';
}
</script>

	
</body>
<script src="static/bootstrap/js/bootstrap2.js"></script>

  <link  rel="stylesheet"href="static/bootstrap/css/bootstrap/bootstrap2.css" />
</html>