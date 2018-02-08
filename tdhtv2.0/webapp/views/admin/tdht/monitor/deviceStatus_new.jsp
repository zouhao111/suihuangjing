<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/resources/newMonitor/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />
<script type="text/javascript" src="${ctx}/resources/common/jquery/jquery.json-2.4.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/montors_new/Newconsole_new.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/montors_new/Newconsole2_new.js"></script>

<script type="text/javascript" src="${ctx}/resources/js/montors_water/conversion.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/zDialog.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/zDrag.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-ui-jqLoding.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/montors_new/click.js"></script>

<script type="text/javascript" src="${ctx}/resources/js/console_demo.js"></script>
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
<title>设备控制</title>
<style type="text/css">
  table button{
    cursor: pointer;
  }
</style>
<script type="text/javascript">
	 
	 var data1={};
	  
	    
	$(document).ready(function () {
		$.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
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
		
		 /*$("#button1").on("click",function(){
        if($("#button1").var()!=1){
        var button=  $("#button1").var(1);
        Console();
        }
        if($("#button1").var()!=0){
        var button=  $("#button1").var(0);
        Console();
        }
    */
    var rid=$("#rid").val();
    data1.rid=rid;
    console.log(data1)
   data1.word=3
  // console.log(data_zckj)
  
   console1(data1)
 
        $(this).jqLoading("destroy");  
		    
	
	
	var tiimer=setInterval(function() {
   console1(data1)
 
	
     
      
}, 10000);
        
  });
</script>

</head>
<body  class="body_overflow">

<%--<button id="button3"value=""type="button" onclick='console_demo1()'class="btn btn-danger">开</button>
<button id="button2_tdht"value=""type="button" onclick='console_demo2()' class="btn btn-success">关</button>
--%><input id="webUrls" type="hidden" value="${webUrls}" >
	<input id="rid" type="hidden" value="${rid}" >
	<div style="margin-bottom: 8px;">
	<span class="f14 text-title" >设备控制</span>
	</div>
 

		<div style="background-color:#b0b0b0;;width:100%;height:1px;"></div>
			<div style="background-color:#ffffff;width:100%;height:8px;"></div>
	<div class="table2excel bluestrip">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr   class="tb_heard_font16_h46">
						<th width="15%" align="center">控制单元</th>
						<th width="10%" align="center">当前状态</th>
						<th width="20%" align="center">开关操作</th>
						<!-- <th width="15%" align="center">当前模式</th>
						<th width="15%" align="center">模式切换</th> -->
						</tr>
			</thead>
		<tbody>
		<%--<c:forEach items="${historys}" var="bean">
			--%><tr class='tb_font15_h46'>
				
				<td width="130" align="center">门磁1</td> 
				<td width="130" align="center"><div id="button1_tdht"    class='btn_off'  style='width: 95px;'></div></td>
				<td width="130" rowspan="2" align="center">
				<button id="button11_tdht"value="1"type="button" onclick='open1(data1)'     class='btn-on'  style='width: 95px;'>启动</button>
				<button id="button111_tdht"value="0"type="button" onclick='open111(data1)'     class='btn-off'  style='width: 95px;'>关闭</button>
				<button id="button111_tdht"value="0"type="button" onclick='open1111(data1)'     class='btn-off'  style='width: 95px;'>停止</button>
				
				</td>
				
				</tr>
				<tr class='tb_font15_h46'>
				
				<td width="130" align="center">门磁2</td> 
				<td width="130" align="center"><div id="button2_tdht"    class='btn_off'  style='width: 95px;'></div></td>
				
				
				</tr>
				 <tr class='tb_font15_h46'>
			 <td width="130" align="center">灯光1</td> 
			<td width="130" align="center"><div  id="light1"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"><button type="button"  id="light11"value="1"    onclick='open4s(data1)'  class='btn-on'  style='width:95px;'>启 动</button>
				<button type="button"  id="light111"value="1"    onclick='open44s(data1)'  class='btn-off'  style='width:95px;'>关 闭</button>
				</td>
               
			 </tr>
				 <tr class='tb_font15_h46'>
			 <td width="130" align="center">灯光2</td> 
			<td width="130" align="center"><div  id="light2"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"><button type="button"  id="light22"value="1"    onclick='open4(data1)'  class='btn-on'  style='width:95px;'>启 动</button>
				<button type="button"  id="light222"value="1"    onclick='open44(data1)'  class='btn-off'  style='width:95px;'>关 闭</button>
				</td>
               
			 </tr>
				
			 
			  <tr class='tb_font15_h46'>
			 <td width="130" align="center">空调</td> <td width="130" align="center">
			 <div  id="conditioning"    class='btn_on'  style='width:95px;'></div></td>
			 <td width="130" align="center">
			  <button type="button"  id="conditioning1"value=""   onclick='open3(data1)'  class='btn-on'  style='width:95px;'>启 动</button>
			   <button type="button"  id="conditioning11"value=""   onclick='open333(data1)'  class='btn-off'  style='width:95px;'>关 闭</button>
			  
			   </td>
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">报警撤防</td> 
			<td width="130" align="center"><div  id=""    class='btn_off'  style='width:95px;'></div></td>
			
            <td width="130" align="center">	 <button type="button"  id="fan11"value=""   onclick='openchefang(data1)'  class='btn-on'  style='width:95px;'>撤防</button>
			 </td>
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">报警布防</td> 
			<td width="130" align="center"><div  id=""    class='btn_off'  style='width:95px;'></div></td>
			
            <td width="130" align="center">	 <button type="button"  id="fan11"value=""   onclick='openbufang(data1)'  class='btn-on'  style='width:95px;'>布防</button>
			 </td>
			
               
               
			 </tr>
			  <!--  <tr class='tb_font15_h46'>
			 <td width="130" align="center">空调模式</td> 
			<td width="130" align="center"><div  id="mode"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center">
             <button type="button"  id="conditioning1"value="0"   onclick='open6(data1,this.value)'  class='btn-on'  style='width:95px;'>自动</button>
			   <button type="button"  id="conditioning11"value="1"   onclick='open6(data1,this.value)'  class='btn-off'  style='width:95px;'>送风</button>
			    <button type="button"  id="conditioning1"value="2"   onclick='open6(data1,this.value)'  class='btn-on'  style='width:95px;'>制冷</button>
			   <button type="button"  id="conditioning11"value="3"   onclick='open6(data1,this.value)'  class='btn-off'  style='width:95px;'>制热</button>
			   <button type="button"  id="conditioning11"value="4"   onclick='open6(data1,this.value)'  class='btn-off'  style='width:95px;'>除湿</button>
			  
             </td>
               
			 </tr>
			  
			   <tr class='tb_font15_h46'>
			 <td width="130" align="center">空调风量</td> 
			<td width="130" align="center"><div  id="AirVolume"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center">
              <button type="button"  id="conditioning11"value="0"   onclick='open7(data1,this.value)'  class='btn-off'  style='width:95px;'>自动</button>
             <button type="button"  id="conditioning1"value="1"   onclick='open7(data1,this.value)'  class='btn-on'  style='width:95px;'>LL</button>
			   <button type="button"  id="conditioning11"value="2"   onclick='open7(data1,this.value)'  class='btn-off'  style='width:95px;'>L</button>
			    <button type="button"  id="conditioning1"value="3"   onclick='open7(data1,this.value)'  class='btn-on'  style='width:95px;'>H</button>
			     <button type="button"  id="conditioning1"value="4"   onclick='open7(data1,this.value)'  class='btn-on'  style='width:95px;'>HH</button>
			  
             
             </td>
               
			 </tr> -->
			 <!-- <tr class='tb_font15_h46'>
			 <td width="150" align="center">风机1</td> 
			 
			<td width="130" align="center"><div   id="fan1"  class='btn_on'  style='width:95px;'></div></td>
		<td width="130" align="center">	 <button type="button"  id="fan11"value=""   onclick='open5(data1)'  class='btn-on'  style='width:95px;'>启 动</button>
			 <button type="button"  id="fan111"value=""   onclick='open55(data1)'  class='btn-off'  style='width:95px;'>关 闭</button></td>
			   </tr> -->
			  <!--  <tr class='tb_font15_h46'>
			 <td width="150" align="center">阀门</td> 
			 
			<td width="130" align="center"><div   id="tabPumpValue"  class='btn_on'  style='width:95px;'></div></td>
		<td width="130" align="center">	 <button type="button"  id="fan11"value=""   onclick='open8(data1)'  class='btn-on'  style='width:95px;'>启 动</button>
			 <button type="button"  id="fan111"value=""   onclick='open88(data1)'  class='btn-off'  style='width:95px;'>关 闭</button></td>
			   </tr> -->
			    <tr class='tb_font15_h46'>
			 <td width="150" align="center">采样</td> 
			 
			<td width="130" align="center"><div   id="tabPumpValue"  class='btn_on'  style='width:95px;'></div></td>
		<td width="130" align="center">	 <button type="button"  id="fan11"value=""   onclick='open9(data1)'  class='btn-on'  style='width:95px;'>启 动</button>
			 
			   </tr>
			    <tr class='tb_font15_h46'>
			 <td width="130" align="center">空调温度</td> 
			<td width="130" align="center"><div  id="TemSv"    class='btn_off'  style='width:95px;'></div></td>
            
             
             <td width="130" align="center">	 <button type="button"  id="fan11"value=""   onclick='open10(data1)'  class='btn-on'  style='width:95px;'>设置</button>
		
             </td>
			 </tr>
			  <tr class='tb_font15_h46'>
			 <td width="130" align="center">手自动切换</td> 
			<td width="130" align="center"><div  id="shouzi"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"><!-- <button type="button"  id="light22"value="1"    onclick='open2(data1)'  class='btn-on'  style='width:95px;'>自动</button>
				<button type="button"  id="light222"value="1"    onclick='open22(data1)'  class='btn-off'  style='width:95px;'>手动</button> -->
				</td>
               
			 </tr>
				
			    <tr class='tb_font15_h46'>
			 <td width="130" align="center">烟感报警</td> 
			<td width="130" align="center"><div  id="yangan"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center">
				</td>
               
			 </tr>
				<tr class='tb_font15_h46'>
			 <td width="130" align="center">温感报警</td> 
			<td width="130" align="center"><div  id="wengan"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			   <tr class='tb_font15_h46'>
			 <td width="130" align="center">红外报警</td> 
			<td width="130" align="center"><div  id="hongwai"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">漏液1</td> 
			<td width="130" align="center"><div  id="louye1"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">漏液2</td> 
			<td width="130" align="center"><div  id="louye2"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			  <tr class='tb_font15_h46'>
			 <td width="130" align="center">防拆报警1</td> 
			<td width="130" align="center"><div  id="fangchai1"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">防拆报警2</td> 
			<td width="130" align="center"><div  id="fangchai2"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			<!--  <tr class='tb_font15_h46'>
			 <td width="130" align="center">UPS报警</td> 
			<td width="130" align="center"><div  id="UPS"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr> -->
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">震动报警1</td> 
			<td width="130" align="center"><div  id="zhendong1"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">震动报警2</td> 
			<td width="130" align="center"><div  id="zhendong2"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">温度（舱）</td> 
			<td width="130" align="center"><div  id="tabTemperature"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">湿度（舱）</td> 
			<td width="130" align="center"><div  id="tabHumidity"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">空调电流</td> 
			<td width="130" align="center"><div  id="tabAirCCurrent"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			    <tr class='tb_font15_h46'>
			 <td width="130" align="center">电流</td> 
			<td width="130" align="center"><div  id="tabCurrentU"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">电压</td> 
			<td width="130" align="center"><div  id="tabVoltageU"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			  <tr class='tb_font15_h46'>
			 <td width="130" align="center">电度</td> 
			<td width="130" align="center"><div  id="tabElectric"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 
			<!--   <tr class='tb_font15_h46'>
			 <td width="130" align="center">刷卡</td> 
			<td width="130" align="center"><div  id="shuaka"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr> -->
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">安防</td> 
			<td width="130" align="center"><div  id="anfang"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">高温报警</td> 
			<td width="130" align="center"><div  id="hightTemp"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">低温报警</td> 
			<td width="130" align="center"><div  id="lowTemp"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 
			 
			
		<!-- 	 <tr class='tb_font15_h46'>
			 <td width="130" align="center">三相电流W</td> 
			<td width="130" align="center"><div  id="tabCurrentW"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">三相电压W</td> 
			<td width="130" align="center"><div  id="tabVoltageW"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			
			  <tr class='tb_font15_h46'>
			 <td width="130" align="center">三相电流V</td> 
			<td width="130" align="center"><div  id="tabCurrentV"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr>
			  <tr class='tb_font15_h46'>
			 <td width="130" align="center">三相电压V</td> 
			<td width="130" align="center"><div  id="tabVoltageV"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"></td>
               
			 </tr> -->
			
			 
			 </tbody>
	</table>
	 <div id="forlogin" style="display:none;">
	 <input id="sampValue"type="text" style="display: none"value=""/>
      <table width="100%" border="0" align="center" cellpadding="4" cellspacing="4" bordercolor="#666666">
        <tr>
          <td colspan="2" bgcolor="#eeeeee">采样控制</td>
        </tr>
        <tr>
          <td width="50" align="right">采样杯号(数字1-24)</td>
          <td><input type="text" id="samplemMac1" /></td>
        </tr>
        <tr>
         <td align="right">采样容量(数字0-80)</td>
          <td><input type="text" id="samplemValue1"  /></td>
        </tr>
      </table>
    </div>
     <div id="forlogin2" style="display:none;">
	 <input id="sampValue"type="text" style="display: none"value=""/>
      <table width="100%" border="0" align="center" cellpadding="4" cellspacing="4" bordercolor="#666666">
        <tr>
          <td colspan="2" bgcolor="#eeeeee">设置温度</td>
        </tr>
        <tr>
          <td width="120" align="right">温度(数字15-32)</td>
          <td><input type="text" id="Temp" /></td>
        </tr>
      <tr>
      <td></td>
      </tr>
      </table>
    </div>
	<table border="0" cellspacing="0" cellpadding="0"class="table-list"style="display: none;" >
	  <thead>
					<tr   class="tb_heard_font16_h46">
						<th width="15%" align="center">空调单元</th>
						<th width="15%" align="center">当前状态</th>
						<th width="45%" align="center">开关操作</th>
						
						<!--<th width="15%" align="center">采样控制</th>
						<th width="70" align="center">COD</th>
						<th width="70" align="center">氨氮</th> 
						<th width="70" align="center">六价铬</th>
					--></tr>
			</thead>
			<tbody  >
			<tr class='tb_font15_h46'>
			
			 <td width="150" align="center">空调温度</td> 
			 <td width="130" align="center"> <div  id="QJ"   class='btn_on'  style='width:95px;'></div></td>
			  <td width="130" align="center">
			  <button type="button"  id="conditioning1"value=""   onclick='open5(data1)'  class='btn-on'  style='width:95px;'>调高</button>
			   <button type="button"  id="conditioning11"value=""   onclick='open55(data1)'  class='btn-off'  style='width:95px;'>调低</button>
			  
			   </td>
			 </tr>
			<tr class='tb_font15_h46'>
			
			 <td width="200" align="center">风速</td> 
			 <td width="130" align="center"> <div  id="QJ"   class='btn_on'  style='width:95px;'></div></td>
			  <td width="130" align="center">
			  <button type="button"  id="conditioning1"value=""   onclick='open5(data_tdht)'  class='btn-on'  style='width:95px;'>小风</button>
			   <button type="button"  id="conditioning11"value=""   onclick='open55(data_tdht)'  class='btn-off'  style='width:95px;'>中风</button>
			    <button type="button"  id="conditioning1"value=""   onclick='open5(data_tdht)'  class='btn-on'  style='width:95px;'>大风</button>
			   <button type="button"  id="conditioning11"value=""   onclick='open55(data_tdht)'  class='btn-off'  style='width:95px;'>自动</button>
			  
			   </td>
			 </tr>
			 <tr class='tb_font15_h46'>
			
			 <td width="200" align="center">空调模式</td> 
			 <td width="130" align="center"> <div  id="QJ"   class='btn_on'  style='width:95px;'></div></td>
			  <td width="130" align="center">
			  <button type="button"  id="conditioning1"value=""   onclick='open5(data1)'  class='btn-on'  style='width:95px;'>自动</button>
			   <button type="button"  id="conditioning11"value=""   onclick='open55(data1)'  class='btn-off'  style='width:95px;'>制冷</button>
			    <button type="button"  id="conditioning1"value=""   onclick='open5(data1)'  class='btn-on'  style='width:95px;'>加热</button>
			   <button type="button"  id="conditioning11"value=""   onclick='open55(data1)'  class='btn-off'  style='width:95px;'>除湿</button>
			   <button type="button"  id="conditioning11"value=""   onclick='open55(data1)'  class='btn-off'  style='width:95px;'>换气</button>
			  
			   </td>
			 </tr>
			 <tr class='tb_font15_h46'>
			
			 <td width="150" align="center">回风温度</td> 
			 <td width="130" align="center"> <div  id="QJ"   class='btn_on'  style='width:95px;'></div></td>
			  <td width="130" align="center">
			  
			   </td>
			 </tr>
			</tbody>
	</table>
	
				<%--<td width="120" align="center"> 
				<button id="button1_yyf" value=""type="button" class="btn btn-success">工业给水</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>
				--><button id="button2_yyf"value=""type="button"  class="btn btn-success">生活给水</button>
				<!--<button id="button55"value=""type="button" onclick='open5(75501330001)'class="btn btn-success">工业排水2</button>
				--><button id="button3_yyf"value=""type="button"  class="btn btn-success">工业排水</button>
				
				</td>
				<td width="70" align="center"> 
				<button type="button"  id="p1_yyf"value=""class="btn btn-success">阀门1</button>
				<button type="button"  id="p2_yyf"value=""class="btn btn-danger">阀门2</button>
				</td>
				<td width="70" align="center"> 
				<button type="button" class="btn btn-default">采样</button>
				</td>
				--%>
				
				<!--<td width="120" align="center"> 
				<button type="button" class="btn btn-default">测量</button>
				<button type="button" class="btn btn-default">定标</button>
				<button type="button" class="btn btn-default">终止</button>
				</div></td>
				<td width="120" align="center"> 
				<button type="button" class="btn btn-default">测量</button>
				<button type="button" class="btn btn-default">定标</button>
				<button type="button" class="btn btn-default">终止</button>
				</div></td>
				<td width="120" align="center"> 
				<button type="button" class="btn btn-default">测量</button>
				<button type="button" class="btn btn-default">定标</button>
				<button type="button" class="btn btn-default">终止</button>
				</div></td>
			-->
			
				<%--
				<td width="120" align="center"> 
				<button id="button1_odk" value=""type="button" class="btn btn-success">工业给水</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>
				--><button id="button2_odk"value=""type="button"  class="btn btn-success">生活给水</button>
				<!--<button id="button55"value=""type="button" onclick='open5(75501330001)'class="btn btn-success">工业排水2</button>
				--><button id="button3_odk"value=""type="button"  class="btn btn-success">工业排水</button>
				
				</td>
				<td width="70" align="center"> 
				<button type="button"  id="p1_odk"value=""class="btn btn-success">阀门1</button>
				<button type="button"  id="p2_odk"value=""class="btn btn-danger">阀门2</button>
				</td>
				<td width="70" align="center"> 
				<button type="button" class="btn btn-default">采样</button>
				</td>
				--%>
				<!--<td width="120" align="center"> 
				<button type="button" class="btn btn-default">测量</button>
				<button type="button" class="btn btn-default">定标</button>
				<button type="button" class="btn btn-default">终止</button>
				</div></td>
				<td width="120" align="center"> 
				<button type="button" class="btn btn-default">测量</button>
				<button type="button" class="btn btn-default">定标</button>
				<button type="button" class="btn btn-default">终止</button>
				</div></td>
				<td width="120" align="center"> 
				<button type="button" class="btn btn-default">测量</button>
				<button type="button" class="btn btn-default">定标</button>
				<button type="button" class="btn btn-default">终止</button>
				</div></td>
			-->
			
				<!--<td width="120" align="center"> 
				<button type="button" class="btn btn-default">测量</button>
				<button type="button" class="btn btn-default">定标</button>
				<button type="button" class="btn btn-default">终止</button>
				</div></td>
				<td width="120" align="center"> 
				<button type="button" class="btn btn-default">测量</button>
				<button type="button" class="btn btn-default">定标</button>
				<button type="button" class="btn btn-default">终止</button>
				</div></td>
				<td width="120" align="center"> 
				<button type="button" class="btn btn-default">测量</button>
				<button type="button" class="btn btn-default">定标</button>
				<button type="button" class="btn btn-default">终止</button>
				</div></td>
			-->
			
		<%--</c:forEach>
		--%>
<%--<div   style='margin-top:20px'>
	<span  class='tb_font16'>备注:</span>
	<div style="margin-left:35px; text-align: left;font-size: 15px;font-family:Microsoft YaHei;" colspan="5"> <img height=26px width=12px style='	margin: 2px; background: url(${ctx}/resources/lrtk/images/button-off2.png) no-repeat center;'></img><span style="font-family:Microsoft YaHei;">绿色代表关闭，</span><img height=26px width=12px style='	margin: 2px;background: url(${ctx}/resources/lrtk/images/button-on2.png) no-repeat center;'></img><span style="font-family:Microsoft YaHei;">红色代表开启</span></div>

	</div>
--%></div>
	<%-- <div id="pagelist">
		<ul style="list-style:none;">
			<pg:pager items="${pager.rowCount}"
			export="currentPageNumber=pageNumber" maxPageItems="${pager.pageSize }" maxIndexPages="5" url="../alarm/historyList" >
			<!-- 分页带查询条件 -->
				<!-- 首页 -->
				<pg:first>
					<li style="list-style:none;"><a href="${pageUrl }" style="color:#333; text-decoration:none;">首页</a></li>
				</pg:first>
				<pg:prev>
					<li style="list-style:none;"><a href="${pageUrl }" style="color:#333; text-decoration:none;">前一页</a></li>
				</pg:prev>
				<pg:pages>
					<c:choose>
						<c:when test="${currentPageNumber eq pageNumber }">
							<li style="list-style:none;background:#a9d2ff; display:block; padding:0px 6px; font-weight:bold;">${pageNumber }</li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl }" style="list-style:none;color:#333; text-decoration:none;">${pageNumber }</a></li>
						</c:otherwise>
					</c:choose>
				</pg:pages>
				<pg:next>
					<li style="list-style:none;"><a href="${pageUrl }" style="color:#333; text-decoration:none;">后一页</a></li>
				</pg:next>
				<pg:last>
					<li style="list-style:none;"><a href="${pageUrl }" style="color:#333; text-decoration:none;">尾页</a></li>
				</pg:last>
		    <li style="list-style:none;color:#555;" class="pageinfo">共${pager.pageCount}页</li>
		    <li style="list-style:none;color:#555;" class="pageinfo">共${pager.rowCount}条记录</li>
			</pg:pager>
  		</ul>
	</div> --%>
	
	
<!--<div style="with:100%;height:30px;  background: url(${ctx}/resources/lrtk/images/foot.png) no-repeat center;"></div> 

--><script>
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