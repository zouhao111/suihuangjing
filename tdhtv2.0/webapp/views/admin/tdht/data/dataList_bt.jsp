<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/tip-skyblue/tip-skyblue.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/newData/css/newData.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/newData/css/showBo.css"	type="text/css" rel="stylesheet" />
<!--[if IE 8]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if  IE 7]>
<link href="${ctx}/resources/css/ie7.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<script type="text/javascript" src="${ctx}/resources/js/left/jquery-1.4.3.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.qtip-1.0.0-rc3.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-ui-jqLoding.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/data_bt.js"></script>

<script type="text/javascript" src="${ctx}/resources/js/data_water.js"></script>
<script type="text/javascript" src="${ctx}/resources/newData/js/click_tab.js"></script>
<script type="text/javascript" src="${ctx}/resources/newData/js/click_num.js"></script>
<script type="text/javascript" src="${ctx}/resources/newData/js/showBo.js"></script>
<script type="text/javascript">
$(function(){
	$("#is_key").hide();
	$("#id_key").hide();
	$("#ls_key").hide();
	
	 
   var rid=$("#rid").val();
  
   if(rid=="75501330006"){
     load_data_bt(rid);
    }else{
    load_data_bt(rid);
   load_data(rid);
   load_data2(rid);
   }
  var tiimer=setInterval(function() {
      if(rid=="75501330006"){
     load_data_bt(rid);
    }else{
    load_data_bt(rid);
   load_data(rid);
   load_data2(rid);
   }
}, 60000);

/*$("#remark_but").toggle( 
        function(){ $("#tr_flow").show()} ,
        function(){$("#tr_flow").hide()} 
)*/
window.parent.URLstr(rid);

var time_id;
var time_ls;
var time_is;
$("#id_key").click(function(){
	           time_id=$("#id_key").val()
				Showbo.Msg.alert('离线时间:'+time_id)
				
			} )

 $("#ls_key").click(function(){
	 time_ls=$("#ls_key").val()
				Showbo.Msg.alert('离线时间:'+time_ls)
			} )
			
$("#is_key").click(function(){
	time_is=$("#is_key").val()
				Showbo.Msg.alert('离线时间:'+time_is)
			} )
	
	
	
var list=${list};
console.log(list)

for(i=0;i<list.length;i++){
	
	if(list[i]==1){
	$("#click_fir").show();	
	$("#tab_first").show();	
	
	}
	if(list[i]==11){
	$("#click_fir").show();	
   $("#tab_first").show();	
	$("#tab_first11").show();	
	}
	if(list[i]==2){
		if($('#tab_first').css('display')=='block'){
		$("#tab_sec").hide();	
		}else{
		$("#tab_sec").show();	
		};
	$("#click_sec").show();	
		
	}
	if(list[i]==3){
	$("#click_tre").show();	
	
	}
	if(list[i]==4){
	$("#click_fou").show();	
	
	}
	if(list[i]==5){
	$("#click_five").show();	
	
	}
	if(list[i]==7){
	$("#click_sev").show();	
		
	}
	if(list[i]==0){
	$("#click_zer").show();	
	//$("#tab_zer").show();	
	
	}
	if(list[i]==10){
	$("#click_zer1").show();	
	
	}
}
	
			

})
</script>

<title>实时数据</title>
</head>

<body class="body_overflow">
	<input id="webUrls" type="hidden" value="${webUrls}" >
	<input id="rid" type="hidden"  value="${rid}" >
	
	<p class="f14style" style="height:25px"><span class="f14 text-title" style="font-size:19px ">${companyconfig.companyName}流量实时数据</span><a style="float:right;font-size: 15px"href="../data/dataNew?rid=${rid}"><img id="img_first" style="margin-right: 50px;border: 0px;"src="${ctx}/resources/newData/img/back.png"><span style="position: absolute;right: 20px;top: 23px;font-size: 19px;color:#0071BC;">返回</span></a></p>
	<c:if test="${rid==75501330006}">
	<div style="margin: 5px 0px;"><div  style="float: left; width:250px; font-family:微软雅黑;font-size: 15px"id="startTime_bt"></div> <div id="endTime_bt"  style="float: left; font-family:微软雅黑;font-size: 15px""> </div> <div id="sub_time_bt"  style="float: right; font-family:微软雅黑;font-size: 15px""></div></div>
 
	</c:if>
	<c:if test="${rid!=75501330006}">
	<div style="margin: 5px 0px;"><div  style="float: left; width:250px; font-family:微软雅黑;font-size: 15px"id="startTime"></div> <div id="endTime"  style="float: left; font-family:微软雅黑;font-size: 15px""> </div> <div id="sub_time"  style="float: right; font-family:微软雅黑;font-size: 15px""></div></div>
 </c:if>
 <c:choose>
<c:when test="${rid==75501330008||rid==75501330009||rid==75501330010||rid==75501330011||rid==75501330012}">
<div id="click_zer" class="font-div"style="display: none;margin-top: 30px;"><p class="f14style"><img id="img_zer"src="${ctx}/resources/newData/img/plus.png"><span id="font0"class="f14 text-title"style="color:#000; margin-left:20px; " >碧头排河口实时监测数据</span></p></div>
	<div id="tab_zer" style="display: none">  
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table0" >
	  
	   
	   <thead>
					<tr >
						<th width="15%" style="font-family: 微软雅黑;font-size: 16px;">项目名称</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">六号排河口360</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">六号排河口350 </th>
					</tr>
			</thead>
			<tbody>
					<tr id="waterLevel_bt" >
						<th style="font-family: 微软雅黑;font-size: 16px;" >水位(m)</th>
						<th style="color: blue;"></th>
						<th style="color: blue;"></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id="flowVelocity_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">流速(m/s)</th>
						<th >-</th>
						<th >-</th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id="flowRate_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">流量速率(m<sup>3</sup>/s)</th>
						<th ></th>
						<th ></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id=traffic_bt>
						<th style="font-family: 微软雅黑;font-size: 16px;">今日流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id=trafficLastDay_bt>
						<th style="font-family: 微软雅黑;font-size: 16px;">昨日流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id=voltage_bt>
						<th style="font-family: 微软雅黑;font-size: 16px;">总流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id=drainage_bt>
						<th style="font-family: 微软雅黑;font-size: 16px;">流域</th>
						<th ></th>
						<th ></th>
						
						
					</tr>
			</tbody>
	 
	</table>
	</div>
	<div id="click_zer1" class="font-div"style="cursor:pointer;display: none"><p class="f14style"><img id="img_zer1"src="${ctx}/resources/newData/img/plus.png"><span id="font01" class="f14 text-title" style="margin-left:20px;">碧头排河口水质监测数据</span></p></div>
	<div id="tab_zer1" style="display: none"> 
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table_bt" >
			<thead>
					<tr>
						<th width="15%" style="font-family: 微软雅黑;font-size: 16px;">项目名称</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;" >实时参数</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">最近24小时最大值</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">最近24小时最小值</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">备注</th>
					</tr>
					<tr id="PH_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">PH</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="realConductivity_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">电导率(μS/cm)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="COD_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">COD(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="NH4_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">氨氮(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="cr6_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">六价铬(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="mlss_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">固体悬浮物(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<%--<tr  id="TOC">
						<th style="font-family: 微软雅黑;font-size: 16px;">TOC(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					--%><tr  id="temp_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">温度(℃)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<!--
					<tr  id="Do">
						<th style="font-family: 微软雅黑;font-size: 16px;">溶解氧(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					
					--><tr  id="phosphor_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">总磷(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Cu_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">总铜(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Ni_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">总镍(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Cd_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">总铬(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="CN_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">氰化物(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Zn_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">总锌(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					
					
			</thead>
	</table>
	</div>
	  </c:when>
</c:choose>
	
	



	
	   <c:choose>
	   <c:when test="${rid==75501330006}">
	   <div id="click_fir" class="font-div"style="display: none;margin-top: 30px;background: #0071BC;"><p class="f14style"><img id="img_first1"src="${ctx}/resources/newData/img/minus.png"><span id="font1"class="f14 text-title"style="color:#fff; margin-left:20px; " >${companyconfig.companyName}实时监测数据</span></p></div>
	<div id="tab_first" style="display: black">  
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table0" >
	   <thead>
					<tr >
						<th width="15%" style="font-family: 微软雅黑;font-size: 16px;">项目名称</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">六号排河口360<img id="is_key" style="cursor: pointer;" src="${ctx}/resources/img/key.png" title=""height="20px"/></th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">六号排河口350 <img id="id_key"style="cursor: pointer;" src="${ctx}/resources/img/key.png"  title=""  height="20px"/></th>
					</tr>
			</thead>
			<tbody>
					<tr id="waterLevel_bt" >
						<th style="font-family: 微软雅黑;font-size: 16px;" >水位(m)</th>
						<th style="color: blue;"></th>
						<th style="color: blue;"></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id="flowVelocity_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">流速(m/s)</th>
						<th >-</th>
						<th >-</th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id="flowRate_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">流量速率(m<sup>3</sup>/s)</th>
						<th ></th>
						<th ></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id=traffic_bt>
						<th style="font-family: 微软雅黑;font-size: 16px;">今日流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id=trafficLastDay_bt>
						<th style="font-family: 微软雅黑;font-size: 16px;">昨日流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id=voltage_bt>
						<th style="font-family: 微软雅黑;font-size: 16px;">总流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id=drainage_bt>
						<th style="font-family: 微软雅黑;font-size: 16px;">流域</th>
						<th ></th>
						<th ></th>
						
						
					</tr>
			</tbody>
			</table>
	
	
	</div>
	   </c:when>
	   <c:when test="${rid==75501330008||rid==75501330009||rid==75501330012}">
	    <div id="click_fir" class="font-div"style="display: none;margin-top: 2px;background: #0071BC;"><p class="f14style"><img id="img_first1"src="${ctx}/resources/newData/img/minus.png"><span id="font1"class="f14 text-title"style="color:#fff; margin-left:20px; " >${companyconfig.companyName}实时监测数据</span></p></div>
	<div id="tab_first" style="display: black">  
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table0" >
			<thead>
					<tr >
						<th width="15%" style="font-family: 微软雅黑;font-size: 16px;">项目名称</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">工业给水<img id="is_key" style="cursor: pointer;" src="${ctx}/resources/img/key.png" title=""height="20px"/></th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">工业排水 <img id="id_key"style="cursor: pointer;" src="${ctx}/resources/img/key.png"  title=""  height="20px"/></th>
					</tr>
			</thead>
			<tbody>
					<tr id="waterLevel" >
						<th style="font-family: 微软雅黑;font-size: 16px;" >水位(m)</th>
						<th style="color: blue;"></th>
						<th style="color: blue;"></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id="flowVelocity">
						<th style="font-family: 微软雅黑;font-size: 16px;">流速(m/s)</th>
						<th >-</th>
						<th >-</th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id="flowRate">
						<th style="font-family: 微软雅黑;font-size: 16px;">流量速率(m<sup>3</sup>/s)</th>
						<th ></th>
						<th ></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id=traffic>
						<th style="font-family: 微软雅黑;font-size: 16px;">今日流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id=trafficLastDay>
						<th style="font-family: 微软雅黑;font-size: 16px;">昨日流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id=voltage>
						<th style="font-family: 微软雅黑;font-size: 16px;">总流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						
					</tr>
			</tbody>
			</table>
	
	
	</div>
			</c:when>
			<c:otherwise>
			<div id="click_fir" class="font-div"style="display: none;margin-top: 2px;background: #0071BC;"><p class="f14style"><img id="img_first1"src="${ctx}/resources/newData/img/minus.png"><span id="font1"class="f14 text-title"style="color:#fff; margin-left:20px; " >${companyconfig.companyName}实时监测数据</span></p></div>
	<div id="tab_first" style="display: black">  
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table0" >
			<thead>
					<tr >
						<th width="15%" style="font-family: 微软雅黑;font-size: 16px;">项目名称</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">工业给水<img id="is_key" style="cursor: pointer;" src="${ctx}/resources/img/key.png" title=""height="20px"/></th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">生活给水<img id="ls_key" style="cursor: pointer;"src="${ctx}/resources/img/key.png" title=""  height="20px"/></th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">工业排水 <img id="id_key"style="cursor: pointer;" src="${ctx}/resources/img/key.png"  title=""  height="20px"/></th>
						<!-- <th width="21%" style="font-family: 微软雅黑;font-size: 16px;">生活排水</th> 
					 -->
					</tr>
			</thead>
			<tbody>
					<tr id="waterLevel" >
						<th style="font-family: 微软雅黑;font-size: 16px;" >水位(m)</th>
						<th style="color: blue;"></th>
						<th style="color: blue;"></th>
						<th style="color: blue;"></th>
					<!-- 	<th style="color: blu e;">-</th>
					 --></tr>
			</tbody>
			<tbody>
					<tr id="flowVelocity">
						<th style="font-family: 微软雅黑;font-size: 16px;">流速(m/s)</th>
						<th >-</th>
						<th >-</th>
						<th ></th>
					<!-- 	<th >-</th>
					 --></tr>
			</tbody>
			<tbody>
					<tr id="flowRate">
						<th style="font-family: 微软雅黑;font-size: 16px;">流量速率(m<sup>3</sup>/s)</th>
						<th ></th>
						<th ></th>
						<th ></th>
					<!-- 	<th >-</th>
					 --></tr>
			</tbody>
			<tbody>
					<tr id=traffic>
						<th style="font-family: 微软雅黑;font-size: 16px;">今日流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						<th ></th>
						<!-- <th >-</th>
					 --></tr>
			</tbody>
			<tbody>
					<tr id=trafficLastDay>
						<th style="font-family: 微软雅黑;font-size: 16px;">昨日流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						<th ></th>
					<!-- 	<th >-</th>
				 -->	</tr>
			</tbody>
			<tbody>
					<tr id=voltage>
						<th style="font-family: 微软雅黑;font-size: 16px;">总流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						<th ></th>
					<!-- 	<th >-</th>
					 --></tr>
			</tbody>
			</table>
	
	
	</div>
			</c:otherwise>
	    </c:choose>
	
	<div id="click_fou" style="cursor:pointer;display: none" class="font-div"><p class="f14style"><img id="img_fou"src="${ctx}/resources/newData/img/plus.png"><span id="font2" class="f14 text-title"style="margin-left:20px;" >${companyconfig.companyName}水平衡分析  单位(m<sup>3</sup>)</span></p></div>
	<div id="tab_fou" style="display: none"> 
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table1" >
			<thead>
					<tr>
						<th width="10%" style="font-family: 微软雅黑;font-size: 16px;">项目名称</th>
						<th width="11%" style="font-family: 微软雅黑;font-size: 16px;">工业给水</th>
						<th width="11%" style="font-family: 微软雅黑;font-size: 16px;">生活给水</th>
						<th width="11%" style="font-family: 微软雅黑;font-size: 16px;">工业排水</th>
						<th width="11%" style="font-family: 微软雅黑;font-size: 16px;">生活排水</th>
						<th width="11%" colspan="2" style="font-family: 微软雅黑;font-size: 16px;">损耗量</th>
						<th width="11%" style="font-family: 微软雅黑;font-size: 16px;">不明工业排水</th>
					</tr>
					<tr>
						<th style="font-family: 微软雅黑;font-size: 16px;">代码</th>
						<th >Q<sub>工给</sub></th>
						<th >Q<sub>生给</sub></th>
						<th >Q<sub>工排</sub></th>
						<th >Q<sub>生排</sub></th>
						<th >损耗限值/Q<sub>限</sub></th>
						<th >损耗量/Q<sub>损耗</sub></th>
						<th >Q<sub>不明</sub></th>
					</tr>
					<tr id="ztraffic">
						<th style="font-family: 微软雅黑;font-size: 16px;">数值</th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
					</tr>
					<tr id="ztraffic2"> 
						<th style="font-family: 微软雅黑;font-size: 16px;">流量系数</th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
					</tr>
			</thead>
			<!--<tbody id="tr_flow"class="table-list"style="display: none">
                   
                      <tr style="text-align: left;" id='tr_color_remark'>
                       <th rowspan='9' style="text-align: center;font-family: 微软雅黑;font-size: 16px;">备注</th> <th colspan='7'>1、水平衡公式：Q工给+Q生给＝Q工排＋Q生排＋Q损耗＋Q不明</th></tr>
    		           <tr style="text-align: left;font-family: 微软雅黑;font-size: 16px;"> <th colspan='7' syle="text-align: left;">2、Q损耗＝Q限，当（Q工给＋Q生给－Q工排－Q生排）≥Q限时;</th></tr>
    		           <tr style="text-align: left;font-family: 微软雅黑;font-size: 16px;"> <th colspan='7'>Q损耗＝（Q工给＋Q生给－Q工排－Q生排），当（Q工给＋Q生给－Q工排－Q生排）＜Q限时。</th></tr>
    		           <tr style="text-align: left;font-family: 微软雅黑;font-size: 16px;"> <th colspan='7'>3、Q不明＝（Q工给＋Q生给－Q工排－Q生排－Q损耗）</th></tr>
    		           <tr style="text-align: left;font-family: 微软雅黑;font-size: 16px;"> <th colspan='7'>4、当“生活排水Q生排”无法测量时</th></tr>
    		           <tr style="text-align: left;font-family: 微软雅黑;font-size: 16px;"> <th colspan='7'>	如果N*q ≤Q24给，Q限=Qn=∑Qn-1+N * q+k(Q工给+Q生给)</th></tr>
    		           <tr style="text-align: left;font-family: 微软雅黑;font-size: 16px;"> <th colspan='7'>	如果N*Q＞Q24给，Q限=Qn=∑Qn-1+Q24给+K(Q工给+Q生给)。式中Q24给代表每日（增加）给水总量</th></tr>
    		           <tr style="text-align: left;font-family: 微软雅黑;font-size: 16px;"> <th colspan='7'>	当“生活排水Q生排”可以测量时，Q限=K(Q工给+Q生给)</th></tr>
    		           <tr style="text-align: left;font-family: 微软雅黑;font-size: 16px;"><th colspan='7'>5、流量系数：对应项目流量与给水总量之比，给水总量＝Q工给＋Q生给。</th></tr>
                    
                 </tbody>  
                  <tfoot><tr><td><input type="button" id="remark_but" value="备注" style="margin-left: 40px"></td></tr></tfoot>-->
	</table>
	
	</div>
	<div id="click_sec" class="font-div"style="cursor:pointer;display: none"><p class="f14style"><img id="img_sec"src="${ctx}/resources/newData/img/plus.png"><span id="font3" class="f14 text-title" style="margin-left:20px;">${companyconfig.companyName}水质监测数据</span></p></div>
	<div id="tab_sec" style="display: none"> 
	
	  <c:choose>
	   <c:when test="${rid==75501330006}">
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table_bt" >
			<thead>
					<tr>
						<th width="15%" style="font-family: 微软雅黑;font-size: 16px;">项目名称</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;" >实时参数</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">最近24小时最大值</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">最近24小时最小值</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">备注</th>
					</tr>
					<tr id="PH_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">PH</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="temp_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">温度(℃)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Turbidity_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">浊度(NTU)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="realConductivity_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">电导率(μS/cm)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Do_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">溶解氧(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="COD_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">COD(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="NH4_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">氨氮(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="cr6_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">六价铬(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="mlss_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">固体悬浮物(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<%--<tr  id="TOC">
						<th style="font-family: 微软雅黑;font-size: 16px;">TOC(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					--%>
					<!--
					<tr  id="Do">
						<th style="font-family: 微软雅黑;font-size: 16px;">溶解氧(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					
					--><tr  id="phosphor_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">总磷(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Cu_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">总铜(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Ni_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">总镍(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Cd_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">总铬(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="CN_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">氰化物(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Zn_bt">
						<th style="font-family: 微软雅黑;font-size: 16px;">总锌(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					
					
			</thead>
	</table>
	</c:when>
	
	
	<c:otherwise>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="tables" >
			<thead>
					<tr>
						<th width="15%" style="font-family: 微软雅黑;font-size: 16px;">项目名称</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;" >实时参数</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">最近24小时最大值</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">最近24小时最小值</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">备注</th>
					</tr>
					<tr id="PH">
						<th style="font-family: 微软雅黑;font-size: 16px;">PH</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="temp">
						<th style="font-family: 微软雅黑;font-size: 16px;">水温(℃)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr id="Turbidity">
						<th style="font-family: 微软雅黑;font-size: 16px;">浊度(NTU)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="realConductivity">
						<th style="font-family: 微软雅黑;font-size: 16px;">电导率(μS/cm)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr id="Do">
						<th style="font-family: 微软雅黑;font-size: 16px;">溶解氧(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="COD">
						<th style="font-family: 微软雅黑;font-size: 16px;">COD(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="NH4">
						<th style="font-family: 微软雅黑;font-size: 16px;">氨氮(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="cr6">
						<th style="font-family: 微软雅黑;font-size: 16px;">六价铬(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="mlss">
						<th style="font-family: 微软雅黑;font-size: 16px;">固体悬浮物(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<%--<tr  id="TOC">
						<th style="font-family: 微软雅黑;font-size: 16px;">TOC(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					--%>
					<!--
					<tr  id="Do">
						<th style="font-family: 微软雅黑;font-size: 16px;">溶解氧(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					
					--><tr  id="phosphor">
						<th style="font-family: 微软雅黑;font-size: 16px;">总磷(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Cu">
						<th style="font-family: 微软雅黑;font-size: 16px;">总铜(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Ni">
						<th style="font-family: 微软雅黑;font-size: 16px;">总镍(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Cd">
						<th style="font-family: 微软雅黑;font-size: 16px;">总铬(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="CN">
						<th style="font-family: 微软雅黑;font-size: 16px;">氰化物(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="Zn">
						<th style="font-family: 微软雅黑;font-size: 16px;">总锌(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					
					
			</thead>
			</table>
	
	</c:otherwise>
	</c:choose>
	
	<%--<div style="background-color:#6EBEF3;height:25px;widht:100%;"></div>
	--%><!--<p class="f14style"><span class="f14 text-title" >WTW监测数据</span></p>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr>
						<th width="15%" style="font-family: 微软雅黑;font-size: 16px;">项目名称</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;" >实时参数</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">最近24小时最大值</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">最近24小时最小值</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">备注</th>
					</tr>
					<tr id="COD">
						<th style="font-family: 微软雅黑;font-size: 16px;">COD(mg/l)</th>
						<th >${waterquality.realPh}</th>
						<th >${waterquality.lastDayMaxPh}</th>
						<th >${waterquality.lastDayMinPh}</th>
						<th >-</th>
					</tr>
					<tr  id="TOC">
						<th style="font-family: 微软雅黑;font-size: 16px;">TOC(mg/l)</th>
						<th >${waterquality.realConductivity}</th>
						<th >${waterquality.lastDayMaxConductivity}</th>
						<th >${waterquality.lastDayMinConductivity}</th>
						<th >-</th>
					</tr>
					<tr  id="BOD">
						<th style="font-family: 微软雅黑;font-size: 16px;">BOD(mg/l)</th>
						<th >${waterquality.realCod}</th>
						<th >${waterquality.lastDayMaxCod}</th>
						<th >${waterquality.lastDayMinCod}</th>
						<th >-</th>
					</tr>
					<tr  id="NH4">
						<th style="font-family: 微软雅黑;font-size: 16px;">氨氮(mg/l)</th>
						<th >${waterquality.realNH3N}</th>
						<th >${waterquality.lastDayMaxNH3N}</th>
						<th >${waterquality.lastDayMinNH3N}</th>
						<th >-</th>
					</tr>
					<tr  id="mlss">
						<th style="font-family: 微软雅黑;font-size: 16px;">固体悬浮物(mg/l)</th>
						<th >${waterquality.realcr6}</th>
						<th >${waterquality.lastDayMaxCr6}</th>
						<th >${waterquality.lastDayMinCr6}</th>
						<th >-</th>
					</tr>
			</thead>
	</table>
	-->
	</div>
	
	<div id="click_five"  class="font-div"style="cursor:pointer;display: none"><p class="f14style"><img id="img_five"src="${ctx}/resources/newData/img/plus.png"><span id="font4" class="f14 text-title"style="margin-left:20px;" >${companyconfig.companyName}污染物排放总量  </span></p></div>
	<div id="tab_five" style="display: none"> 
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table2" >
			<thead>
					<tr id="pollname">
						
					</tr>
					
					<tr id="pollvalue">
						
					</tr>
					<tr id="pollvalue_avg">
						
					</tr>
					<tr id="pollname2">
						
					</tr>
					
					<tr id="pollvalue2">
						
					</tr>
					<tr id="pollvalue2_avg">
						
					</tr>
			</thead>
	</table>
	
	

	</div>
	<div id="click_tre"  class="font-div"style="cursor:pointer;display: none"><p class="f14style"><img id="img_tre"src="${ctx}/resources/newData/img/plus.png"><span id="font5" class="f14 text-title"style="margin-left:20px;">${companyconfig.companyName}水质采样记录</span></p></div>     

	<div id="tab_tre" style="display: none"> 
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table3" >
			<thead>
			        <tr>
						<th width="15%"  style="font-family: 微软雅黑;font-size: 16px;">采样时间</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">采样水量(ml)</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">采样时水样PH值</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">采样杯号</th>
						<th width="21%" style="font-family: 微软雅黑;font-size: 16px;">采样方式</th>
					</tr>
					<tr id="sam1">
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th style="font-family: 微软雅黑;font-size: 16px;">手动采样</th>
					</tr>
					<tr id="sam2">
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th style="font-family: 微软雅黑;font-size: 16px;">自动采样</th>
					</tr>
					<tr id="sam3">
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th style="font-family: 微软雅黑;font-size: 16px;">报警采样</th>
					</tr>
					<tr id="sam4">
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th style="font-family: 微软雅黑;font-size: 16px;">远程采样</th>
					</tr>
			</thead>
	</table>
	
	</div>
	<div id="click_sev" class="font-div"style="cursor:pointer;display: none"><p class="f14style"><img id="img_sev"src="${ctx}/resources/newData/img/plus.png"><span id="font6" class="f14 text-title"style="margin-left:20px;">反控日志</span></p></div>     
	
	<div id="tab_sev" style="display: none"> 
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table4" >
			<thead>
					<tr>
						<th width="15%"  style="font-family: 微软雅黑;font-size: 16px;">操作时间</th>
						<th width="15%"  style="font-family: 微软雅黑;font-size: 16px;">用户名</th>
						<th width="15%"  style="font-family: 微软雅黑;font-size: 16px;">IP</th>
						<th width="15%"  style="font-family: 微软雅黑;font-size: 16px;">监测单元</th>
						<th width="15%"  style="font-family: 微软雅黑;font-size: 16px;">描述</th>
					</tr>
			</thead>
			<tbody id="log">
			
			</tbody>		
					
	</table>
	</div>
	
	<div style="width:100%">
        <img id="img_first" style="margin-top:10px"src="${ctx}/resources/newData/img/remark.png"> 
    </div>
   
</body>

</html>