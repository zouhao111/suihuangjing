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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!-- <meta name="viewport" content="initial-scale=1.0, user-scalable=no" /> -->
	<meta name="viewport" content="width=device-width,initial-scale=1" />
	<style type="text/css">
		body, html {width: 103%;height: 100%;margin:0;font-family:"微软雅黑";overflow-x:hidden ; }
		#allmap{width:100%;height:96%;position:absolute;}
		.anchorBL{display:none;}
		p{margin-left:5px; font-size:14px;}
		
.font_div{
    float:left;
    width:20%;
    height:100px;
    background-color:#2c3b46;
    margin-left:7px;
   text-align: center;
}

.font_div2{
    font-family: 微软雅黑;font-size: 10px;
    margin-top:5px;
    color:#28A2DB;
}
.font_div3{
   color:#28A2DB;
   margin-top:5px;
   font-size: 12px;
}
.video_page{
	position: relative;
    width: 93%;
    height: 70%;
    left:15px;
    margin-bottom: 15px;
}
.videol_class{
	width:45%;
 	height: 50%;
 	position: relative;
    border: 2px solid #28A2DB;
    float: left;
	margin-left: 9px;
    margin-bottom: 5px;
}
.vodie_font{

margin-top: 30%;
font-size: 15px;
color: #28a2db;
text-align: center;

margin-top: 15%;
	font-size: 15px;
	color: #28a2db;
	text-align: center;
}
.select_video{
   display: none;
}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=EWj5lQ3L4YwQTuvyXpeCoT6j"></script>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link href="static/buttons/buttons.css" rel="stylesheet" type="text/css"/>
	<script src="static/js/echarts1.min.js"></script>
	<script src="static/js/InfoBox_min.js"></script>
	<link rel="stylesheet" href="static/bootstrap/bootstrap-table/bootstrap-table.css" />	
	<script src="static/bootstrap/bootstrap-table/bootstrap-table2.js"></script>
	<script src="static/bootstrap/bootstrap-table2/colResizable-1.6.js"></script>
	<script src="static/ckplayer/ckplayer.js"></script>
	<script src="static/js/fullScreen.js"></script>
	<script src="static/js/jquery.cookie.js"></script>
	 <link rel="icon" type="image/x-icon" href="//statics.ys7.com/mall/statics/site/favicon.ico" />
	 <script type="text/javascript">
	$(function () {
	  findDimensions();
	 resizeFrame();
	}) 	
function findDimensions() //函数：获取尺寸 
{ 
//获取窗口宽度 
if (window.innerWidth) 
winWidth = window.innerWidth; 
else if ((document.body) && (document.body.clientWidth)) 
winWidth =   window.screen.width ;
//获取窗口高度 

if (window.screen.height ) 
winHeight = window.screen.height ; 
else if ((document.body) && (document.body.clientHeight)) 
winHeight =window.screen.height ;
//通过深入Document内部对body进行检测，获取窗口大小 
if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth) 
{ 
winHeight = window.screen.height; 
winWidth = document.documentElement.clientWidth; 
} 
winHeight=window.outerHeight 
$("body").css("height",winHeight)
//alert(winHeight)
}

function resizeFrame(){
             var content_iframe = window.parent.document.getElementById("iframe_div");//获取iframeID
            var div_height = $("body").css("height");//使iframe高度等于子网页高度
            content_iframe.style.height = div_height;
}
</script>
</head>

<body>
<a id="menuUrl" href="${menuUrl}"></a>
<input  id="R_ID" type="hidden"  value="${R_ID}"/>
<input  id="list" type="hidden"  value="${list}"/>
    <div style="height:30px; position: absolute; ">
	<button id="watrning"type="button" class="button button-glow button-border button-rounded button-primary"  data-toggle="collapse" data-target="#demo">
		报警信息 <span class="badge badge-grey" style="background-color: red;"></span>
	</button>
	<button id="early"type="button" class="button button-glow button-border button-rounded button-primary"   data-toggle="collapse" data-target="#demo2">
		预警信息 <span class="badge badge-grey" style="background-color: yellow;"></span>
	</button>
	</div>
	<div id="demo" class="panel-collapse " style="width:94%;margin-top: 30px;display: none;">
		<table id="reportTable" >
			 <thead>
			  <tr>
			   <th data-field="id"data-valign="middle" data-align="center" data-sortable="true">序号</th>
			   <th data-field="r_name_cn" data-valign="middle" data-align="center" data-sortable="true">监测单元</th>
			   <th data-field="param_name"data-valign="middle" data-align="center" data-sortable="true">报警类型</th>
			   <th data-field="param_value"data-valign="middle" data-align="center" data-sortable="true">报警值</th>
			   <th data-field="limitLL" data-valign="middle" data-align="center" data-sortable="true">限定值</th>
			  </tr>
			  </thead>
		</table>
	</div>
	<div id="demo2" class="panel-collapse " style="width:94%;margin-top: 30px;display: none;">
		<table id="reportTable2" >
		 <thead>
		  <tr>
		   <th data-field="id"data-valign="middle" data-align="center" data-sortable="true">序号</th>
		   <th data-field="r_name_cn" data-valign="middle" data-align="center" data-sortable="true">监测单元</th>
		   <th data-field="param_name"data-valign="middle" data-align="center" data-sortable="true">预警类型</th>
		   <th data-field="param_value"data-valign="middle" data-align="center" data-sortable="true">预警值</th>
		   <th data-field="limitL" data-valign="middle" data-align="center" data-sortable="true">限定值</th>
		  </tr>
		  </thead>
		</table>
	</div>
	<div>
	<div id="left0"style="width:17%;height:60%;z-index:99;position: absolute; background-color:#081734;/*opacity:0.5; */">
	</div>
	<!-- 三圆环 -->
	
	<div id="left1"style="width:17%;height:20%;position: absolute;z-index: 100;border:1px solid #015B99;">
		<div style="color:white;background-color: #0C77BF;"><img width="15px" class="module-img" src="static/images/3gang.png"/> <span class="module">整体监控</span></div>
		<div id="main" style="width:33%;height:90%;float: left;"></div>
		<div id="main2" style="width:33%;height:90%;float: left;"></div>
		<div id="main3" style="width:33%;height:90%;float: left;"></div>
	</div>
	<!-- 仪表盘 -->
	<div id="left2"style="width:17%;height:20%;position: absolute;z-index: 100;border:1px solid #015B99;/* background-color:#081734; */">
		<div style="color:white;background-color: #0C77BF;"><img width="15px" class="module-img" src="static/images/3gang.png"/> <span class="module">综合水质评价</span></div>
		<div id="main4" style="width:100%;height:90%;float: left;"></div>
	</div>
	<div id="map_water"style="width:17%;height:20%;position: absolute;z-index: 100;border:1px solid #015B99;/* background-color:#081734; */display: none;">
		<div style="color:white;background-color: #0C77BF;"><img width="15px" class="module-img" src="static/images/3gang.png"/> <span class="module">水量监测</span></div>
		<div id="map_waters"style="margin-top: 20px;">
		</div>
	</div>
	<div id="map_day_line"style="width:100%;height:35%;position: absolute;z-index: 100;background-color:#081734;/*opacity:0.5; */">
		<div style="color:white;background-color: #0C77BF;"><img width="15px" class="module-img" src="static/images/3gang.png"/> <span class="module">一周数据</span></div>
		 <div id="main_line1" style="width:30%;height:92%;float: left;"></div>
		 <div id="main_line2" style="width:33%;height:92%;float: left;"></div>
		 <div id="main_line3" style="width:33%;height:92%;float: left;"></div>
	</div>
	<div id="right0"style="width:23%;height:60%;z-index:99;right:0px;position: absolute;background-color:#081734;/* opacity:0.5; */">
	</div>
	<div id="map_com_video"style="width:23%;height:30%;position: absolute;right:0px;z-index: 100;border:1px solid #015B99;">
		<div style="color:white;background-color: #0C77BF;"><img width="15px" class="module-img" src="static/images/3gang.png"/> <span class="module">视频</span></div>
		<div id="page1" class="video_page">
			<div id="videoPlay0" class="videol_class"><div class="vodie_font">未安装</div></div>
			<div id="videoPlay1" class="videol_class"><div class="vodie_font">未安装</div></div>
			<div id="videoPlay2" class="videol_class"><div class="vodie_font">未安装</div></div>
			<div id="videoPlay3" class="videol_class"><div class="vodie_font">未安装</div></div>
		</div>
		<div id="page2" class="video_page select_video ">
			<div id="videoPlay4" class="videol_class"><div class="vodie_font">未安装</div></div>
			<div id="videoPlay5" class="videol_class"><div class="vodie_font">未安装</div></div>
			<div id="videoPlay6" class="videol_class"><div class="vodie_font">未安装</div></div>
			<div id="videoPlay7" class="videol_class"><div class="vodie_font">未安装</div></div>
		</div>
		<div>
		  
		  <button  id="page_one" style="margin-left: 20%;width:30%;padding: 0 5%;" class="button button-glow button-border button-rounded button-primary">上一页</button >
		  
		  <button  id="page_two" style="width:30%;padding: 0 5%;"class="button button-glow button-border button-rounded button-primary">下一页</button >
		
		</div>
	</div>
	
	<div id="map_com_conf"style="width:23%;height:30%;position: absolute;right:1px;z-index: 100;overflow-y:hidden;border:1px solid #015B99;">
		<div style="color:white;background-color: #0C77BF;"><img width="15px" class="module-img" src="static/images/3gang.png"/> <span class="module">排污许可排放限值</span></div>
		<div id="tab_title"style="color:#28A2DB"></div>
		<table id="reportTable_com" style="width: 100%;height:90%;color:#28A2DB;text-align: center;font-size: 13px;">
			 <thead>
				  <tr>
				   <td>污染物排放名称</td>
				   <td>排放限值</td>
				   <td>日废水排放量</td>
				  </tr>
			 </thead>
			  <tbody>
			  </tbody>
		</table>
	</div>
	<div id="map_select"style="width:30%;height:5%;position: absolute;left:17%;z-index: 100;background-color:#081734;">
		<div style="color: #0C77BF;"><div style="float:left;  width: 90px;text-align: center; margin-top: 10px;" class="module">选择污染物:</div>
			<select class="chosen-select form-control" style="float: left;width:100px;background-color: transparent;
				border: solid 0px;-webkit-appearance: initial;"name="name" id="mySelect"data-placeholder="请选择"><option value=""></option>
	   		</select>
   		 	<div ><button  id="refresh" class="button button-glow button-border button-rounded button-primary">刷新</button ></div>
		</div>
	</div>
	
	<!-- 百度地图 -->
	<div id="allmap"></div>
	</div>
</body>
</html>

<script type="text/javascript">
$(function () {
	
	
	
	
})
function tops(){
	
	if($("#demo").is(":hidden")&&$("#demo2").is(":hidden")){
       $("#left0").css("top","4%");
	$("#left1").css("top","4%")
	$("#left2").css("top","24%")
	$("#map_water").css("top","44%")
	$("#map_day_line").css("top","64%")
	$("#right0").css("top","4%")
	$("#map_com_video").css("top","4%")
	$("#map_com_conf").css("top","34%")
	$("#map_select").css("top","4%")
	$("#allmap").css("top","4%")
     
}else if(!$("#demo").is(":hidden")||!$("#demo2").is(":hidden")){
      $("#left0").css("top","64%");
	$("#left1").css("top","64%")
	$("#left2").css("top","84%")
	$("#map_water").css("top","104%")
	$("#map_day_line").css("top","124%")
	$("#right0").css("top","64%")
	$("#map_com_video").css("top","64%")
	$("#map_com_conf").css("top","94%")
	$("#map_select").css("top","64%")
	$("#allmap").css("top","64%")
     
}
	
	
	
	
	
	
	
}
function tops2(){
	$("#left0").css("top","64%");
	$("#left1").css("top","64%")
	$("#left2").css("top","834%")
	$("#map_water").css("top","104%")
	$("#map_day_line").css("top","124%")
	$("#right0").css("top","64%")
	$("#map_com_video").css("top","64%")
	$("#map_com_conf").css("top","94%")
	$("#map_select").css("top","64%")
	$("#allmap").css("top","64%")
}
$("#watrning").click(function(){
  $("#demo").toggle();
  $("#demo2").hide()
  tops();
});
$("#early").click(function(){
  $("#demo2").toggle();
  $("#demo").hide()
  tops();
});
function show1(){
		//$("#demo2").collapse("hide")
		alert('1')
	}
	function show2(){
		//$("#demo").collapse("hide")
		
	}
	
</script>
 
<script type="text/javascript">

	 var winWidth = 0; 
	 var winHeight = 0; 

$(function () {
	//console.log("1")
	tops();
	var menuUrl=$("#menuUrl").attr("href")
		$.cookie('menuUrl_s', menuUrl, { expires: 1, path: '/TDHT3.0' });
	var R_ID=$("#R_ID").val();
	
	function map_value(R_ID){
	map_day_line(R_ID);
	map_day_poll_line(R_ID)
	map_video(R_ID)
	map_pie(R_ID)
	map_gauge(R_ID)
	map_com_conf(R_ID)
	}

	$("#page_one").on('click',function(){
		$("#page1").show();
		$("#page2").hide();
	})
	$("#page_two").on('click',function(){
		$("#page1").hide();
		$("#page2").show();
	})
	

	
})
</script>
<script type="text/javascript">
$(function () {
	var R_ID=$("#R_ID").val();
	map_water(R_ID);
	
	function map_water(R_ID){
		  $.ajax({
          url:'map_water',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			if(data.result=='success'){
			$("#map_water").show();	
		 $.each(data.varList, function(i, dvar){
			
			 if(dvar.param_type==1){
				 $("#map_waters").append("<div class='font_div'><div class='font_div3'>"+dvar.param_value.toFixed(dvar.decimal_number)+"</div><div class='font_div2'>"+dvar.param_name_cn+"</div></div>")
			 }
		 })
		 }
		 
		}
	      })
		
		}
	
})
</script>
<script type="text/javascript">
function  changeComs(R_ID,RIGHTS,ROLE_NAME){
		//alert("1")
		window.parent.changeMenu(R_ID,RIGHTS,ROLE_NAME,1);
		  
	}


</script>
<script type="text/javascript">

$(function () {
  $('[data-toggle="popover"]').popover()

	var R_ID=$("#R_ID").val();
	console.log(R_ID)
	map_value(R_ID)
	function map_value(R_ID){
	map_day_line(R_ID);
	map_day_poll_line(R_ID)
	map_video(R_ID)
	map_pie(R_ID)
	map_gauge(R_ID)
	map_com_conf(R_ID)
	map_select(R_ID)
	}

	$("#page_one").on('click',function(){
		$("#page1").show();
		$("#page2").hide();
	})
	$("#page_two").on('click',function(){
		$("#page1").hide();
		$("#page2").show();
	})
	function map_select(R_ID){
		  $.ajax({
          url:'map_select',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			$("#mySelect").empty();
			if(data.result=='success'){
				$("#mySelect").append("  <option value='-1'>综合水质</option>")
		 $.each(data.data, function(i, dvar){
			 
			$("#mySelect").append("  <option value="+dvar.limit_type+">"+dvar.param_name_cn+"</option>")
			
			 
		 })
		 }else{
			
		 }
		 
		},
	      })
		
		}
	
	
	function map_com_conf(R_ID){
		  $.ajax({
          url:'map_com_conf',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			$("#reportTable_com tbody").empty();
			if(data.result=='success'){
		 $.each(data.data, function(i, dvar){
			$("#reportTable_com tbody").append("<tr><td>"+dvar.param_name+"</td><td>"+dvar.limitLL+"</td></tr>")
			
			 
		 })
		 }else{
		
		
		 }
		 
		},
	      })
		
		}
	function map_video(R_ID){
		  $.ajax({
          url:'map_video',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			if(data.result=='success'){
		 $.each(data.varList, function(i, dvar){
			 
			 url=dvar.video_url;
			 
		//	 url='hls.open.ys7.com/openlive/ef9a78ab3b604624a98c1418c37a318c.m3u8'
			 var flashvars;
        flashvars={
            f: 'static/ckplayer/m3u8.swf',
            a:  "http://"+url,
            c: 0,
            p: 1,
            s: 4,
            lv: 1
        };
        var params = {bgcolor: '#FFF', allowFullScreen: true, allowScriptAccess: 'always', wmode: 'transparent'};
        CKobject.embedSWF("static/ckplayer/ckplayer.swf", "videoPlay"+i, "video", "100%", "100%", flashvars, params);
			
			 
		 })
		 }else{
			
			 
		 }
		 
		}
	      })
		
		}
	function map_day_poll_line(R_ID){
		var main_line1 = echarts.init(document.getElementById('main_line2')); 
		main_line1.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
		var main_line3 = echarts.init(document.getElementById('main_line3')); 
		main_line3.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
		  $.ajax({
          url:'map_day_poll_line',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			if(data.result=='success'){
			$("#main_line2").show();	
			$("#main_line3").show();	
			console.log(data.varList);
			var strTimes=data.strTimes;
			var varList=data.varList
			var poll_type=data.poll_type
			var poll_types=data.poll_types
			
			var series=[];
    for(var i = 0;i<varList.length;i++){
    	
        series.push({
             name:varList[i].param_name_cn,
            type:'line',
            data:varList[i].dataList,
        });
    }
		   option = {
    title: {
        text: '最近排放污染物总量',
         top:0,
          textStyle:{
           color:'#28a0d2',
           
       },
    },
    tooltip: {
        trigger: 'axis'
        
    },
    
   legend: {
        data:poll_type,
         type: 'scroll',
        orient: 'vertical',
        right: 0,
        top: 15,
        bottom: 0,
        textStyle:{
           color:'#28a0d2',
           
       },
    },
    grid:{
    	right:'30%',
    },
    xAxis:  {
    	 axisLine:{
        lineStyle:{
           color:'#28a0d2',
        } , 
       },
        type: 'category',
        boundaryGap: false,
        data: strTimes,
        
    },
    yAxis: {
    	 axisLine:{
        lineStyle:{
           color:'#28a0d2',
        } , 
       },
        type: 'value',
        splitArea : {show : true}//保留网格区域
       /* axisLabel: {
            formatter: '{value} °C'
        }*/
    },
    series: series
};
		   var series2=[];
		    for(var a = 0;a<varList.length;a++){
    	
        series2.push({
             name:varList[a].param_name_cn,
            type:'line',
            data:varList[a].dataList_avg,
        });
    }
	option3 = {
    title: {
        text: '污染物平均浓度',
         top:0,
          textStyle:{
           color:'#28a0d2',
           
       },
    },
    tooltip: {
        trigger: 'axis'
        
    },
    
   legend: {
        data:poll_types,
         type: 'scroll',
        orient: 'vertical',
        right: 0,
        top: 20,
        bottom: 0,
        textStyle:{
           color:'#28a0d2',
           
       },
    },
    grid:{
    	right:'30%',
    },
    xAxis:  {
    	 axisLine:{
        lineStyle:{
           color:'#28a0d2',
        } , 
       },
        type: 'category',
        boundaryGap: false,
        data: strTimes,
        
    },
    yAxis: {
    	 axisLine:{
        lineStyle:{
           color:'#28a0d2',
        } , 
       },
        type: 'value',
        splitArea : {show : true}//保留网格区域
       /* axisLabel: {
            formatter: '{value} °C'
        }*/
    },
    series: series2
};
		   
		  main_line1.setOption(option, true);
           window.onresize = main_line1.resize;
                main_line1.setOption(option);
                 main_line1.hideLoading();
                 
		     main_line3.setOption(option3, true);
           window.onresize = main_line3.resize;
                main_line3.setOption(option3);
                 main_line3.hideLoading();
		   
		   
		 }else{
			 $("#main_line2").hide();	
			  $("#main_line3").hide();	
		 }
		 
		 
		}
	      })
		}
	
	
	
	function map_day_line(R_ID){
		var main_line1 = echarts.init(document.getElementById('main_line1')); 
		main_line1.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
		  $.ajax({
          url:'map_day_line',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			if(data.result=='success'){
			$("#map_day_line").show();	
			console.log(data.varList);
			var strTimes=data.strTimes;
			var varList=data.varList
			var poll_type=data.poll_type
			
			var series=[];
    for(var i = 0;i<varList.length;i++){
    	
        series.push({
             name:varList[i].param_name_cn,
            type:'line',
            data:varList[i].dataList,
        });
    }
	option = {
    title: {
        text: '最近给排水量',
         top:0,
          textStyle:{
           color:'#28a0d2',
       },
    },
    tooltip: {
        trigger: 'axis'
    },
    
   legend: {
        data:poll_type,
        type: 'scroll',
        orient: 'vertical',
        right: 0,
        top: 20,
        bottom: 0,
        textStyle:{
           color:'#28a0d2',
           
       },
    },
     grid:{
    	right:'20%',
    },
    xAxis:  {
    	 axisLine:{
        lineStyle:{
           color:'#28a0d2',
        } , 
       },
        type: 'category',
        boundaryGap: false,
        data: strTimes,
        
    },
    yAxis: {
    	 axisLine:{
        lineStyle:{
           color:'#28a0d2',
        } , 
       },
        type: 'value',
        splitArea : {show : true}//保留网格区域
       /* axisLabel: {
            formatter: '{value} °C'
        }*/
    },
    series: series
};
		   
		   
		  main_line1.setOption(option, true);
           window.onresize = main_line1.resize;
           main_line1.setOption(option);
           main_line1.hideLoading();
		 }else{
			 $("#map_day_line").hide();	
		 }
		 
		}
	      })
		}

	
function addMap(){
	var data_info= [];
	 $.ajax({
          url:'map_marker',
		type:"post",
		async: false,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			 data_info = data.conJsons;
			 console.log(data_info);
        
           //  alert(obj2.length);
			/*  $.each(data.conJsons, function(i, dvar){
				  data_info.push(dvar)
				  })*/
			  
			return data_info;
		}
		
	})
	
	return data_info;
}
	var map = new BMap.Map('allmap');
	map.centerAndZoom(new BMap.Point(114.066852,22.558604), 11);
	  
	//map.addControl(new BMap.NavigationControl());      // 添加平移缩放控件
	map.addControl(new BMap.ScaleControl());             // 添加比例尺控件
	map.addControl(new BMap.OverviewMapControl());       //添加缩略地图控件
	map.enableScrollWheelZoom();                         //启用滚轮放大缩小
	
	 var data_info= [];
	ss=addMap();
	  var obj2=eval("("+ss+")"); 
        data_info=obj2
             
             
             
	//var data_info= {};
	//data_info=${conJsons}
	 var markerArr=[];
	  var markerArr0={w:23,h:25,l:0,t:21,x:9,lb:12};//获取图片标坐标（1.绿色）正常
	 var markerArr2={w:23,h:25,l:46,t:21,x:9,lb:12};//3.红色报警
	 var markerArr3={w:23,h:25,l:69,t:21,x:9,lb:12}//4.黄色预警
	 var markerArr1={w:23,h:25,l:115,t:21,x:9,lb:12};//6.灰色掉线
	 markerArr.push(markerArr0);
	  markerArr.push(markerArr1);
	   markerArr.push(markerArr2);
	    markerArr.push(markerArr3);
	    
	    
	    

	
	 function createIcon(json){
		        var icon = new BMap.Icon("static/img/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
		        return icon;
		    }
	 var content
	addmarker(data_info,markerArr);
	 
	
	 
	function addmarker(data_info,markerArr){
		map.clearOverlays();
		console.log(data_info);
		for(var i=0;i<data_info.length;i++){ 
		var iconImg;
		
		
		var title = data_info[i][2];
		 content = data_info[i][3];
		if(data_info[i][4]==1){
			var iconImg0 = createIcon(markerArr[1]);
		     iconImg=iconImg0;
		}if(data_info[i][4]==0){
			var iconImg0 = createIcon(markerArr[0]);
		     iconImg=iconImg0;
		}if(data_info[i][4]==2){
			var iconImg0 = createIcon(markerArr[2]);
		     iconImg=iconImg0;
		}if(data_info[i][4]==3){
			var iconImg0 = createIcon(markerArr[3]);
		     iconImg=iconImg0;
		}
		
		
		var R_ID = data_info[i][5];
		var ROLE_NAME = data_info[i][2];
		var RIGHTS = data_info[i][6];
		
		
		content="<div style='margin-top: 28px; text-align: center;color:#FFFFFF;'><a title='点击进入实时监测'style='cursor: pointer;  color:#FFFFFF;'>"+title+"</a></div><br /><div style='margin-top: -10px;  text-align: center;color:#0071bc;'>"+content+"<br /><a id='s'   style='color:#0071bc;font-size:12px;' onclick='changeComs("+R_ID+",&quot;"+RIGHTS+"&quot;,&quot;"+ROLE_NAME+"&quot;)' >点击查看详情</a></div>"
		
	var marker = new BMap.Marker(new BMap.Point(data_info[i][0],data_info[i][1]),{icon:iconImg});  // 创建标注 
	
	 
	map.addOverlay(marker);               // 将标注添加到地图中
	// marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
	addClickHandler(content,marker,R_ID);
	
	}
	
		}
	
	
	
	
	 var iswarning=[];
	
	var infoBox = new BMapLib.InfoBox(map,content,{
				boxStyle:{
					background:"url('static/images/0729-02.png') no-repeat center top"
					,width: "170px"
					,height: "117px"
				}
				,closeIconMargin: "1px 1px 0 0"
				,enableAutoPan: true
				,align: INFOBOX_AT_TOP
			});
	/**
	 * 定时显示
	 * 
	 * */
	
	/**setTimeout_warning();
	function setTimeout_warning(){
		console.log(iswarning)
		
		
		for(var a in iswarning){
			setInterval(function(){
		infoBox.close(marker);
		var marker = new BMap.Marker(new BMap.Point(data_info[a][0],data_info[a][1]),{icon:iconImg});  // 创建标注 
		console.log(marker)
		var title = data_info[a][2];
		var content = data_info[a][3];
		content="<div style='margin-top: 28px; text-align: center;color:#FFFFFF;'><a title='点击进入实时监测'style='cursor: pointer;  color:#FFFFFF;'>"+title+"</a></div><br /><div style='margin-top: -10px;  text-align: center;color:#0071bc;'>"+content+"<br /><a    style='color:#0071bc;font-size:12px;' href='indexHtml?rid=75501330002&state=${company2}'>点击查看详情</a></div>"
		
		infoBox.open(marker);
		infoBox.setContent(content);//向信息框添加类容
	        }, 4000);
		
			
		}
		
			}*/
			
			
	//	function map_select_choose(){
				
		$("#refresh").on("click",function(){
			var a = document.getElementById("mySelect");//mySelect是select 的Id
  var mySelect=$("#mySelect option:selected").val();
		if(mySelect==-1){
			 var data_info= [];
		ss=addMap();
	  	var obj2=eval("("+ss+")"); 
        data_info=obj2
        
        addmarker(data_info,markerArr);	
		}else{
			
		
		  $.ajax({
        url:'map_select_choose',
		type:"post",
		async: true,
		dataType:"json",
		data:{mySelect},
		success:function(data){
			 obj2 = data.conJsons;
          var data_info=eval("("+obj2+")"); 
           // alert(data_info.length);
		addmarker(data_info,markerArr);	
		 
		},
	      })
		}
		})
	 
	function addClickHandler(content,marker,R_ID){
				marker.addEventListener("click",function(e){
					
					$("#R_ID").val(R_ID);
					R_ID=$("#R_ID").val();
					map_value(R_ID);
				infoBox.open(marker);
				openInfo(content,e);
				
				});
	
				
			/* 	marker.addEventListener("mouseout",function(){
				
				
				});鼠标移开消失 */
			}
function openInfo(content,e){
				var p = e.target;
				var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
				infoBox.setContent(content);//向信息框添加类容
				
				
				//var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象 
				//map.openInfoWindow(infoWindow,point); //开启信息窗口
			} 
	map.disable3DBuilding();

	//个性化在线编辑器地址：http://developer.baidu.com/map/custom/
	  var styleJson = [{
                    "featureType": "land", //调整土地颜色
                    "elementType": "geometry",
                    "stylers": {
                        "color": "#081734"
                    }
                }, {
                    "featureType": "building", //调整建筑物颜色
                    "elementType": "geometry",
                    "stylers": {
                        "color": "#04406F"
                    }
                }, {
                    "featureType": "building", //调整建筑物标签是否可视
                    "elementType": "labels",
                    "stylers": {
                        "visibility": "off"
                    }
                }, {
                    "featureType": "highway", //调整高速道路颜色
                    "elementType": "geometry",
                    "stylers": {
                        "color": "#015B99",
                        "weight": "0.2"
                    }
                }, {
                    "featureType": "highway", //调整高速名字是否可视
                    "elementType": "labels",
                    "stylers": {
                        "visibility": "off"
                    }
                }, {
                    "featureType": "arterial", //调整一些干道颜色
                    "elementType": "geometry",
                    "stylers": {
                        "color": "#003051",
                        "weight": "0.2"
                    }
                }, {
                    "featureType": "arterial",
                    "elementType": "labels",
                    "stylers": {
                        "visibility": "on"
                    }
                }, {
                    "featureType": "green",
                    "elementType": "geometry",
                    "stylers": {
                        "visibility": "off"
                    }
                }, {
                    "featureType": "water",
                    "elementType": "geometry",
                    "stylers": {
                        "color": "#044161"
                    }
                }, {
                    "featureType": "subway", //调整地铁颜色
                    "elementType": "geometry.stroke",
                    "stylers": {
                        "color": "#003051",
                        "weight": "0.2"
                    }
                }, {
                    "featureType": "subway",
                    "elementType": "labels",
                    "stylers": {
                        "visibility": "off"
                    }
                }, {
                    "featureType": "railway",
                    "elementType": "geometry",
                    "stylers": {
                        "visibility": "off"
                    }
                }, {
                    "featureType": "railway",
                    "elementType": "labels",
                    "stylers": {
                        "visibility": "off"
                    }
                }, {
                    "featureType": "all", //调整所有的标签的边缘颜色
                    "elementType": "labels.text.stroke",
                    "stylers": {
                        "color": "#313131"
                    }
                }, {
                    "featureType": "all", //调整所有标签的填充颜色
                    "elementType": "labels.text.fill",
                    "stylers": {
                        "color": "#FFFFFF"
                    }
                }, {
                    "featureType": "manmade",
                    "elementType": "geometry",
                    "stylers": {
                        "visibility": "off"
                    }
                }, {
                    "featureType": "manmade",
                    "elementType": "labels",
                    "stylers": {
                        "visibility": "off"
                    }
                }, {
                    "featureType": "local",
                    "elementType": "geometry",
                    "stylers": {
                        "visibility": "off"
                    }
                }, {
                    "featureType": "local",
                    "elementType": "labels",
                    "stylers": {
                        "visibility": "off"
                    }
                }, {
                    "featureType": "subway",
                    "elementType": "geometry",
                    "stylers": {
                        "lightness": -65
                    }
                }, {
                    "featureType": "railway",
                    "elementType": "all",
                    "stylers": {
                        "lightness": -40
                    }
                },{
                    "featureType": "poi",
                    "elementType": "labels",
                    "stylers": {
                              "weight": "0.2",
                              "visibility": "off"
                    }
          		},               
                {
                    "featureType": "boundary",
                    "elementType": "geometry",
                    "stylers": {
                        "color": "#8b8787",
                        "weight": "1",
                        "lightness": -29
                    }
                }]
	map.setMapStyle({styleJson:styleJson});
	
	})
</script>

<script type="text/javascript">
	$(function () {
	//设备日志表格
	    //1.初始化Table
	    var oTable = new TableInit();
	    oTable.Init();
	
	    //2.初始化Button的点击事件
	    var oButtonInit = new ButtonInit();
	    oButtonInit.Init();
	
	});
	
	var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
     oTableInit.Init = function () {
        $('#reportTable').bootstrapTable({
            url: 'listReal',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100,"ALL"],        //可供选择的每页的行数（*）
            strictSearch: true,
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            height: 410,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            exportTypes: ['excel'],
               uniqueId: "id",                  //每一行的唯一标识，一般为主键列
            showExport: false,                   //是否显示导出
            exportDataType: "all",              //basic', 'all', 'selected'.
            columns: [{
                    field: 'id',
                    title: '序号',
                    formatter: function (value, row, index) {  
                            return index+1;  
                        }  
                }],
            formatNoMatches: function(){
                	return '无符合条件的记录';
                }
        });
    };
	
   oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
        };
        return temp;
    };
    return oTableInit;
};

var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};
</script>

<script type="text/javascript">
	$(function () {
	//操作日志表格
	    //1.初始化Table
	    var oTable2 = new TableInit2();
	    oTable2.Init();
	
	    //2.初始化Button的点击事件
	    var oButtonInit2 = new ButtonInit();
	    oButtonInit2.Init();
	
	});
	var TableInit2 = function () {
    var oTableInit2 = new Object();
    //初始化Table
     oTableInit2.Init = function () {
        $('#reportTable2').bootstrapTable({
            url: 'listEarly',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit2.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100,"ALL"],        //可供选择的每页的行数（*）
            strictSearch: true,
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            height: 410,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            exportTypes: ['excel'],
               uniqueId: "id",                  //每一行的唯一标识，一般为主键列
            showExport: false,                   //是否显示导出
            exportDataType: "all",              //basic', 'all', 'selected'.
            columns: [{
                    field: 'id',
                    title: '序号',
                    formatter: function (value, row, index) {  
                            return index+1;  
                        }  
                }],
            formatNoMatches: function(){
                	return '无符合条件的记录';
                }
        });
    };
		
    oTableInit2.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
        };
        return temp;
    }; 
    return oTableInit2;
};

var ButtonInit2 = function () {
    var oInit2 = new Object();
    var postdata2 = {};
    
    oInit2.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit2;
};
</script>

<script type="text/javascript">
function map_pie(R_ID){
//三圆环
 var myChart = echarts.init(document.getElementById('main'));
 var myChart2 = echarts.init(document.getElementById('main2'));
 var myChart3 = echarts.init(document.getElementById('main3'));
var dataStyle = {
    normal: {
        label: {
            show: false
        },
        labelLine: {
            show: false
        },
        shadowBlur: 40,
        shadowColor: 'rgba(40, 40, 40, 0.5)',
    }
};
var placeHolderStyle = {
    normal: {
        color: 'rgba(44,59,70,1)',//未完成的圆环的颜色
        label: {
            show: false
        },
        labelLine: {
            show: false
        }
    },
    emphasis: {
        color: 'rgba(44,59,70,1)'//未完成的圆环的颜色
    }
};

$.ajax({
          url:'map_pie',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			dt=data
			pi1=((dt.userRid-dt.realRids-dt.earlyRids)/dt.userRid)*100
			pi2=(dt.realRids/dt.userRid)*100
			
			pi3=(dt.earlyRids/dt.userRid)*100
			console.log(dt)
$("#watrning span").text(data.sumReal);
$("#early span").text(data.sumEarly);
var option = {
    title: {
        text: '正常\n'+pi1+'%',
        x: 'center',
        y: 'center',
        textStyle: {
            fontWeight: 'normal',
            color: "#3cde75",
            fontSize: 12
        }
    },
    //backgroundColor: '#011128',
    color: ['#3cde75', '#313443', '#fff'],
    tooltip: {
        show: false,
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        show: false,
        itemGap: 12,
        data: ['01', '02']
    },
    toolbox: {
        show: false,
        feature: {
            mark: {
                show: true
            },
            dataView: {
                show: true,
                readOnly: false
            },
            restore: {
                show: false
            },
            saveAsImage: {
                show: true
            }
        }
    },
    series: [{
            name: 'Line 1',
            type: 'pie',
            clockWise: false,
            radius: [20, 30],
            itemStyle: dataStyle,
            hoverAnimation: false,

            data: [{
                    value: dt.userRid-dt.realRids-dt.earlyRids,
                    name: '01'
                }, {
                    value: dt.realRids+dt.earlyRids,
                    name: 'invisible',
                    itemStyle: placeHolderStyle
                }

            ]
        },
    ]
};
var option2 = {
    title: {
        text: '报警\n'+pi2+'%',
        x: 'center',
        y: 'center',
        textStyle: {
            fontWeight: 'normal',
            color: "#eb202b",
            fontSize: 12
        }
    },
    //backgroundColor: '#011128',
    color: ['#eb202b', '#313443', '#fff'],
    tooltip: {
        show: false,
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        show: false,
        itemGap: 12,
        data: ['01', '02']
    },
    toolbox: {
        show: false,
        feature: {
            mark: {
                show: true
            },
            dataView: {
                show: true,
                readOnly: false
            },
            restore: {
                show: true
            },
            saveAsImage: {
                show: true
            }
        }
    },
    series: [{
            name: 'Line 1',
            type: 'pie',
            clockWise: false,
            radius: [20, 30],
            itemStyle: dataStyle,
            hoverAnimation: false,

            data: [{
                    value: dt.realRids,
                    name: '01'
                }, {
                    value: dt.userRid-dt.realRids,
                    name: 'invisible',
                    itemStyle: placeHolderStyle
                }

            ]
        },
    ]
};
var option3 = {
    title: {
        text: '预警\n'+pi3+'%',
        x: 'center',
        y: 'center',
        textStyle: {
            fontWeight: 'normal',
            color: "#f2f21c",
            fontSize: 12
        }
    },
    //backgroundColor: '#011128',
    color: ['#f2f21c', '#313443', '#fff'],
    tooltip: {
        show: false,
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        show: false,
        itemGap: 12,
        data: ['01', '02']
    },
    toolbox: {
        show: false,
        feature: {
            mark: {
                show: true
            },
            dataView: {
                show: true,
                readOnly: false
            },
            restore: {
                show: true
            },
            saveAsImage: {
                show: true
            }
        }
    },
    series: [{
            name: 'Line 1',
            type: 'pie',
            clockWise: false,
            radius: [20, 30],
            itemStyle: dataStyle,
            hoverAnimation: false,

            data: [{
                    value: dt.earlyRids,
                    name: '01'
                }, {
                    value:dt.userRid-dt.earlyRids,
                    name: 'invisible',
                    itemStyle: placeHolderStyle
                }

            ]
        },


    ]
};
        //加载图表  
        myChart.setOption(option);
        myChart2.setOption(option2);
        myChart3.setOption(option3);
        
        }
		})
   }     
</script>
<script type="text/javascript">

function map_gauge(R_ID){
 //仪表盘
 var myChart4 = echarts.init(document.getElementById('main4'));
 
 $.ajax({
        url:'qualityEvaluation',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
 
 var option4 = {
  	
    tooltip : {
        formatter: "{a} <br/>{b} : {c}%"
    },
    series: [
        {
            name: '综合评价',
            type: 'gauge',
           	detail: {formatter: data.qe,fontSize: 15},
            axisLine: {
            	show: true,
                lineStyle: {
                    width: 30,
                    shadowBlur: 0,
                    color: [[0.2,'#4e504e'],[0.5, '#eb202b'],[0.8, '#f2f21c'],[1, '#3cde75']]
                }
                
            },
           
            axisLabel: {
                formatter: function(e) {
                    switch (e + "") {
                        case "10":
                            return "离线";
                         case "35":
                            return "报警";    
                        case "65":
                            return "预警";
                        case "90":
                            return "正常";
                        default:
                            return "";
                    }
                },
                textStyle: {
                    fontSize: 10,
                    fontWeight: ""
                }
            },
            data: [{value:data.qeValue,name: ''}]
        }
    ]
};
 
  myChart4.setOption(option4, true);
 }
		})
 }

</script>

