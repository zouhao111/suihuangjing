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
<!--[if IE 8]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if  IE 7]>
<link href="${ctx}/resources/css/ie7.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<script type="text/javascript" src="${ctx}/resources/js/left/jquery-1.4.3.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery.qtip-1.0.0-rc3.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-ui-jqLoding.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/data_water.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/click_tab.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#is_key").hide();
	$("#id_key").hide();
	$("#ls_key").hide();
	
   var rid=$("#rid").val();
    
   load_data(rid);
  // load_data2(rid);
  var tiimer=setInterval(function() {
      load_data(rid);
      // load_data2(rid);
}, 30000);

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
				alert('离线时间:'+time_id)
				
			} )

 $("#ls_key").click(function(){
	 time_ls=$("#ls_key").val()
				alert('离线时间:'+time_ls)
			} )
			
$("#is_key").click(function(){
	time_is=$("#is_key").val()
				alert('离线时间:'+time_is)
			} )
			



})
</script>

<title>实时数据</title>
</head>

<body style="overflow-x:hidden;">
	<input id="webUrls" type="hidden" value="${webUrls}" >
	<input id="rid" type="hidden"  value="${rid}" >
	<p class="f14style"><span class="f14 text-title" >${companyconfig.companyName}流量实时数据</span><a style="float:right;font-size: 15px"href="../data/dataNew?rid=${rid}">返回</a></p>
	<div  style="float: left; width:250px;"id="startTime"></div> <div id="endTime"  style="float: left;"> </div> <div id="sub_time"  style="float: right;"></div>
	<div style="border-left: 1px solid #3498db;border-right:1px solid #3498db;margin-top: 20px">
	<div style="background-color:#49AEF1;width:100%;height:25px;"></div>
	<div id="click_fir" style="cursor:pointer;"><p class="f14style"><img id="img_first"${ctx}/resources/img/minus.png"><span class="f14 text-title" >实时监测数据</span></p></div>
	<div id="tab_first" style="display: black">  
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr >
						<th width="40%" style="font-family: 黑体;font-size: 16px;">项目名称</th>
						<th width="60%"  style="font-family: 黑体;font-size: 16px;">排水口<img id="id_key"style="cursor: pointer;" src="${ctx}/resources/img/key.png"  title=""  height="20px"/></th>
					</tr>
			</thead>
			<tbody>
					<tr id="waterLevel" >
						<th style="font-family: 黑体;font-size: 16px;" >水位(m)</th>
						<th style="color: blue;"></th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id="flowVelocity">
						<th style="font-family: 黑体;font-size: 16px;">流速(m/s)</th>
						<th >-</th>
						
					</tr>
			</tbody>
			<tbody>
					<tr id="flowRate">
						<th style="font-family: 黑体;font-size: 16px;">流量速率(m<sup>3</sup>/s)</th>
						<th ></th>
						
					</tr>
			</tbody><!--
			
			<tbody>
					<tr id=voltage>
						<th style="font-family: 黑体;font-size: 16px;">总流量(m<sup>3</sup>)</th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th >-</th>
					</tr>
			</tbody>
			
	--></table>
	
	
	</div>
	
	<div style="background-color:#6EBEF3;height:25px;widht:100%;"></div>
	</div>
	<div id="click_sec" style="cursor:pointer;"><p class="f14style"><img id="img_sec"src="${ctx}/resources/img/plus.png"><span class="f14 text-title" >水质监测数据</span></p></div>
	<div id="tab_sec" style="display: none"> 
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr>
						<th width="15%" style="font-family: 黑体;font-size: 16px;">项目名称</th>
						<th width="21%" style="font-family: 黑体;font-size: 16px;" >实时参数</th>
						<th width="21%" style="font-family: 黑体;font-size: 16px;">最近24小时最大值</th>
						<th width="21%" style="font-family: 黑体;font-size: 16px;">最近24小时最小值</th>
						<th width="21%" style="font-family: 黑体;font-size: 16px;">备注</th>
					</tr>
					<tr id="PH">
						<th style="font-family: 黑体;font-size: 16px;">PH值</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="realConductivity">
						<th style="font-family: 黑体;font-size: 16px;">电导率(μS/cm)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="realCod">
						<th style="font-family: 黑体;font-size: 16px;">COD(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="realNH3N">
						<th style="font-family: 黑体;font-size: 16px;">氨氮(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<%--<tr  id="cr6">
						<th style="font-family: 黑体;font-size: 16px;">六价铬(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<tr  id="mlss">
						<th style="font-family: 黑体;font-size: 16px;">固体悬浮物(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					--%><%--<tr  id="TOC">
						<th style="font-family: 黑体;font-size: 16px;">TOC(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					--%><tr  id="temp">
						<th style="font-family: 黑体;font-size: 16px;">温度(℃)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					<!--
					<tr  id="Do">
						<th style="font-family: 黑体;font-size: 16px;">溶解氧(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
					
					--><%--<tr  id="phosphor">
						<th style="font-family: 黑体;font-size: 16px;">总磷(mg/l)</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
						<th >-</th>
					</tr>
			--%></thead>
	</table>
	
	<%--<div style="background-color:#6EBEF3;height:25px;widht:100%;"></div>
	--%><!--<p class="f14style"><span class="f14 text-title" >WTW监测数据</span></p>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr>
						<th width="15%" style="font-family: 黑体;font-size: 16px;">项目名称</th>
						<th width="21%" style="font-family: 黑体;font-size: 16px;" >实时参数</th>
						<th width="21%" style="font-family: 黑体;font-size: 16px;">最近24小时最大值</th>
						<th width="21%" style="font-family: 黑体;font-size: 16px;">最近24小时最小值</th>
						<th width="21%" style="font-family: 黑体;font-size: 16px;">备注</th>
					</tr>
					<tr id="COD">
						<th style="font-family: 黑体;font-size: 16px;">COD(mg/l)</th>
						<th >${waterquality.realPh}</th>
						<th >${waterquality.lastDayMaxPh}</th>
						<th >${waterquality.lastDayMinPh}</th>
						<th >-</th>
					</tr>
					<tr  id="TOC">
						<th style="font-family: 黑体;font-size: 16px;">TOC(mg/l)</th>
						<th >${waterquality.realConductivity}</th>
						<th >${waterquality.lastDayMaxConductivity}</th>
						<th >${waterquality.lastDayMinConductivity}</th>
						<th >-</th>
					</tr>
					<tr  id="BOD">
						<th style="font-family: 黑体;font-size: 16px;">BOD(mg/l)</th>
						<th >${waterquality.realCod}</th>
						<th >${waterquality.lastDayMaxCod}</th>
						<th >${waterquality.lastDayMinCod}</th>
						<th >-</th>
					</tr>
					<tr  id="NH4">
						<th style="font-family: 黑体;font-size: 16px;">氨氮(mg/l)</th>
						<th >${waterquality.realNH3N}</th>
						<th >${waterquality.lastDayMaxNH3N}</th>
						<th >${waterquality.lastDayMinNH3N}</th>
						<th >-</th>
					</tr>
					<tr  id="mlss">
						<th style="font-family: 黑体;font-size: 16px;">固体悬浮物(mg/l)</th>
						<th >${waterquality.realcr6}</th>
						<th >${waterquality.lastDayMaxCr6}</th>
						<th >${waterquality.lastDayMinCr6}</th>
						<th >-</th>
					</tr>
			</thead>
	</table>
	--><div style="background-color:#6EBEF3;height:25px;widht:100%;"></div>
	</div>
	
	
	<div id="click_tre"  style="cursor:pointer;"><p class="f14style"><img id="img_tre"src="${ctx}/resources/img/plus.png"><span class="f14 text-title">水质采样记录</span></p></div>     

	<div id="tab_tre" style="display: none"> 
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
			      <tr >
						<th width="15%"  style="font-family: 黑体;font-size: 16px;">采样时间</th>
						<th width="21%" style="font-family: 黑体;font-size: 16px;">采样水量(ml)</th>
						<th width="21%" style="font-family: 黑体;font-size: 16px;">采样时水样PH值</th>
						<th width="21%" style="font-family: 黑体;font-size: 16px;">采样杯号</th>
						<th width="21%" style="font-family: 黑体;font-size: 16px;">采样方式</th>
					</tr>
					
					<tr id="sam1">
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th >手动采样</th>
					</tr>
					<tr id="sam2">
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th >自动采样</th>
					</tr>
					<tr id="sam3">
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th >报警采样</th>
					</tr>
					<tr id="sam4">
						<th ></th>
						<th ></th>
						<th ></th>
						<th ></th>
						<th >远程采样</th>
					</tr>
			</thead>
	</table>
	<div style="background-color:#6EBEF3;height:25px;widht:100%;"></div>
	</div>
	<div id="click_sev"  style="cursor:pointer;"><p class="f14style"><img id="img_sev"src="${ctx}/resources/img/plus.png"><span class="f14 text-title">反控日志</span></p></div>     
</div>	
	<div id="tab_sev" style="display: none"> 
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
			      
					<tr>
						<th width="15%"  style="font-family: 黑体;font-size: 16px;">操作时间</th>
						<th width="15%"  style="font-family: 黑体;font-size: 16px;">用户名</th>
						<th width="15%"  style="font-family: 黑体;font-size: 16px;">IP</th>
						<th width="15%"  style="font-family: 黑体;font-size: 16px;">监测单元</th>
						<th width="15%"  style="font-family: 黑体;font-size: 16px;">描述</th>
					</tr>
					
			</thead>
			<tbody id="log">
			
			</tbody>		
					
	</table>
	</div>
	<div style="background-color:#6EBEF3;height:25px;widht:100%;"></div>
	
	
	<div style="width:100%">
         <p style="padding:4px 5px 9px; height:16px;line-height:16px;"><strong class="f14 text-title">说明</strong></p>
            <p>1、“绿色字体参数”代表设计值；“蓝色字体参数”代表系统实测值；“红色字体参数”代表分析、计算结果。</p>
           	<p>2、表中“－”符号代表该参数不可测量。</p>
           	<p>3、表中<img  src="${ctx}/resources/img/key.png"  height="20px"/>符号代表该监测设备离线。</p>
    </div>
   
</body>

</html>