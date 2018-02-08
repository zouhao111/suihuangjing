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
<script type="text/javascript" src="${ctx}/resources/js/Newconsole.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/Newconsole2.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/zDialog.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/zDrag.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-ui-jqLoding.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/click.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/conversion.js"></script>
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
	 
	 var data_yyf={};
	  var data_odk={};
	   var data_tdht={};
	    var data_zckj={};
	    var data_yuf={};
	     var data_jb={};
	      var data_td={};
	       var data_bc={};
	        var data_6={};
	         var data_7={};
	    
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
    var companyId=$("#companyId").val();
    if(companyId>=1500&&companyId<2000){
    $("#yyf").hide();
    $("#odk").hide();
    $("#zckj").hide();
    
    }
    
    
    
    
    data_yyf.rid="75501330001";
   data_yyf.word=3
   data_odk.rid="75501330002";
   data_odk.word=3
   data_tdht.rid="75501330003";
   data_tdht.word=3
   data_zckj.rid="75501330004";
   data_zckj.word=3
    data_yuf.rid="75501330005";
   data_yuf.word=3
  // console.log(data_zckj)
   console1(data_zckj)
   /* console1( data_yyf)
     console1(data_odk)
      console1(data_tdht)
       console1(data_yuf)*/
        $(this).jqLoading("destroy");  
		    
	var rid=$("#rid").val();
	/* console1(data_yyf)
	 console1(data_odk)
	 console1(data_tdht)
	 console1(data_zckj)
	 console1(data_yuf)
	 */
	var tiimer=setInterval(function() {
     console1(data_yyf)
	/* console1(data_odk)
	 console1(data_tdht)
	 console1(data_zckj)
	 console1(data_yuf)*/
     
      
}, 10000);
        
  });
</script>

</head>
<body  class="body_overflow">

<%--<button id="button3"value=""type="button" onclick='console_demo1()'class="btn btn-danger">开</button>
<button id="button2_tdht"value=""type="button" onclick='console_demo2()' class="btn btn-success">关</button>
--%><input id="webUrls" type="hidden" value="${webUrls}" >
<input id="companyId" type="hidden" value="${companyId}" >
	<input id="rid" type="hidden" value="75501330003" >
	<div style="margin-bottom: 8px;">
	<span class="f14 text-title" >设备控制</span>
	</div>
 

		<div style="background-color:#b0b0b0;;width:100%;height:1px;"></div>
			<div style="background-color:#ffffff;width:100%;height:8px;"></div>
	<div class="table2excel bluestrip">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr   class="tb_heard_font16_h46">
						<th width="15%" align="center">公司名称</th>
						<th width="15%" align="center">监测单元编号</th>
						<th width="30%" align="center">井盖开关</th>
						<th width="30%" align="center">阀门</th>
						<th width="15%" align="center">采样控制</th>
						<!--<th width="70" align="center">COD</th>
						<th width="70" align="center">氨氮</th> 
						<th width="70" align="center">六价铬</th>
					--></tr>
			</thead>
		<tbody>
		<%--<c:forEach items="${historys}" var="bean">
			--%><%-- <tr class='tb_font15_h46'>
				<th width="30" align="center" style='font-family:Microsoft YaHei;'>测试1</th>
				<th width="50" align="center">75501330003</th>
				<td width="130" align="center"> 
				<button id="button1_tdht" value=""type="button" onclick='open1(data_tdht)'class="btn btn-success">工业给水</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>-->
				<button id="button2_tdht"value=""type="button"  onclick='open2(data_tdht)'class="btn btn-success">生活给水</button>
				<!--<button id="button55"value=""type="button" onclick='open5()'class="btn btn-success">工业排水2</button>-->
				<button id="button3_tdht"value=""type="button"  onclick='open3(data_tdht)'class="btn btn-success">工业排水</button>
				
				</td>
				<td width="70" align="center"> 
				<button type="button"  id="p1_tdht"value=""onclick='open6(data_tdht)'class="btn btn-success">阀门1</button>
				<button type="button"  id="p2_tdht"value=""onclick='open7(data_tdht)'class="btn btn-danger">阀门2</button>
				</td>
				<td width="70" align="center"> 
				<button type="button" onclick='open10(data_tdht)'class="btn btn-default">采样</button>
				</td>
				<td width="130" align="center"> 
				<!--<button id="button1_tdht" value=""type="button" class="btn btn-success">工业给水</button>-->
				<button id="button3"value=""type="button" onclick='open1(data_tdht)'     class='btn_off'  style='width: 80px;'>工业给水</button>
				<button id="button2_tdht"value=""type="button"      class='btn_off'  style='width: 80px;'>生活给水</button>
				<!--<button id="button55"value=""type="button" onclick='open5()'class="btn btn-success">工业排水2</button>-->
				<button id="button3_tdht"value=""type="button"    onclick='open3(data_tdht)'     class='btn_off'  style='width: 80px;'>工业排水</button>
				
				</td>
				<td width="70" align="center"> 
				<button type="button"  id="p1_tdht"value=""    onclick='open4(data_tdht)'  class='btn_off'  style='width:61px;'>阀门1</button>
				<button type="button"  id="p2_tdht"value=""     class='btn_on'  style='width:61px;'>阀门2</button>
				</td>
				<td width="70" align="center"> 
				<button type="button" class="btn btn-default"  style="font-family: Microsoft YaHei;">采样</button>
				</td>
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
			--></tr> --%>
		
			<%-- <tr  id="yyf"class='tb_font15_h46' >
				<th width="30" style='font-family:Microsoft YaHei;' align="center">永艺发</th>
				<th width="50" align="center">75501330001</th>
				<td width="120" align="center"> 
				<button id="button1_yyf" value=""type="button" onclick='open1(data_yyf)'    class='btn_off'  style='width: 80px;'>工业给水</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>
				<button id="button2_yyf"value=""type="button" class="btn btn-success">生活给水</button>-->
				<!--<button id="button55"value=""type="button" onclick='open5(75501330001)'class="btn btn-success">工业排水2</button>
				--><button id="button3_yyf"value=""type="button"  onclick='open3(data_yyf)'    class='btn_off'  style='width: 80px;'>工业排水</button>
				
				</td>
				<td width="70" align="center">
				<button type="button"  id="p1_yyf"value=""onclick='open6(data_yyf)'class="btn btn-success">阀门1</button>
				<button type="button"  id="p2_yyf"value=""onclick='open7(data_yyf)'class="btn btn-danger">阀门2</button>
				
				<button type="button"  id="p1_yyf"value=""   onclick='open4(data_yyf)'class='btn_off'  style='width:61px;'>阀门1</button>
				<button type="button"  id="p2_yyf"value=""      class='btn_on'   style='width:61px;'>阀门2</button>
				</td>
				<td width="70" align="center"> 
				<button type="button" onclick='open10(data_yyf)'class="btn btn-default"  style="font-family: Microsoft YaHei;">采样</button>
				</td>
				
				<td width="120" align="center"> 
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
			--></tr> --%>
			<tr id="odk" class='tb_font15_h46' >
				<th width="30"  style='font-family:Microsoft YaHei;' align="center">欧达可</th>
				<th width="50" align="center">75501330002</th>
				<td width="120" align="center"> 
				<button id="button1_odk" value=""type="button" onclick='open1(data_odk)'  class='btn_off'  style='width: 80px;'>工业给水</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>
				--><button id="button2_odk"value=""type="button"  onclick='open2(data_odk)' class='btn_off'  style='width: 80px;'>生活给水</button>
				<!--<button id="button55"value=""type="button" onclick='open5(75501330001)'class="btn btn-success">工业排水2</button>
				--><button id="button3_odk"value=""type="button"  onclick='open3(data_odk)' class='btn_off'  style='width: 80px;'>工业排水</button>
				
				</td>
				<td width="70" align="center"> 
				<button type="button"  id="p1_odk"value="" onclick='open4(data_odk)' class='btn_off'  style='width:61px;'>阀门1</button>
				<button type="button"  id="p2_odk"value=""  class='btn_on'  style='width:61px;'>阀门2</button>
				<!--<button type="button"  id="p1_odk"value=""onclick='open6(data_odk)'class="btn btn-success">阀门1</button>
				<button type="button"  id="p2_odk"value=""onclick='open7(data_odk)'class="btn btn-danger">阀门2</button>-->
				</td>
				<td width="70" align="center"> 
				<button type="button" onclick='open10(data_odk)'class="btn btn-default"  style="font-family: Microsoft YaHei;">采样</button>
				</td>
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
			--></tr>
			<tr  id="zckj"class='tb_font15_h46'>
				<th width="30" style='font-family:Microsoft YaHei;' align="center">中村科技</th>
				<th width="50" align="center">75501330004</th>
				<td width="120" align="center"> 
				<button id="button1_zckj" value=""type="button" onclick='open1(data_zckj)'     class='btn_off'  style='width: 80px;'>工业给水</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>
				--><button id="button2_zckj"value=""type="button"  onclick='open2(data_zckj)'class='btn_off' style='width: 80px;'>生活给水</button>
				<!--<button id="button55"value=""type="button" onclick='open5(75501330001)'class="btn btn-success">工业排水2</button>
				--><button id="button3_zckj"value=""type="button"  onclick='open3(data_zckj)'  class='btn_off' style='width: 80px;'>工业排水</button>
				
				</td>
				<td width="70" align="center"> 
				<%--<button type="button"  id="p1_zckj"value=""onclick='open6(data_zckj)'class="btn btn-success">阀门1</button>
				<button type="button"  id="p2_zckj"value=""onclick='open7(data_zckj)'class="btn btn-danger">阀门2</button>
				
				--%><button type="button"  id="p1_zckj"value=""  onclick='open4(data_zckj)' class='btn_off' style='width:61px;'>阀门1</button>
				<button type="button"  id="p2_zckj"value=""   class='btn_on'  style='width:61px;'>阀门2</button>
				</td>
				<td width="70" align="center"> 
				<button type="button" onclick='open10(data_zckj)'class="btn btn-default">采样</button>
				</td>
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
			--></tr>
			<%-- <tr class='tb_font15_h46'>
				<th width="30" style='font-family:Microsoft YaHei;' align="center">测试2</th>
				<th width="50" align="center">75501330005</th>
				<td width="120" align="center"> 
				<button id="button1_yuf" value=""type="button" onclick='open1(data_yuf)'class="btn btn-success">工业给水</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>
				--><button id="button2_yuf"value=""type="button"  onclick='open2(data_yuf)'class="btn btn-success">生活给水</button>
				<!--<button id="button55"value=""type="button" onclick='open5(75501330001)'class="btn btn-success">工业排水2</button>
				--><button id="button3_yuf"value=""type="button"  onclick='open3(data_yuf)'class="btn btn-success">工业排水</button>
				</td>
				<td width="70" align="center"> 
				<button type="button"  id="p1_yuf"value=""onclick='open6(data_yuf)'class="btn btn-success">阀门1</button>
				<button type="button"  id="p2_yuf"value=""onclick='open7(data_yuf)'class="btn btn-danger">阀门2</button>
				</td>
				<td width="70" align="center"> 
				<button type="button" onclick='open10(data_yuf)'class="btn btn-default">采样</button>
				</td>
				
				<td width="120" align="center"> 
				<button id="button1_yuf" value=""type="button" class='btn_off'  style='width: 80px;'>工业给水</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>
				--><button id="button2_yuf"value=""type="button"  class='btn_off'  style='width: 80px;'>生活给水</button>
				<!--<button id="button55"value=""type="button" onclick='open5(75501330001)'class="btn btn-success">工业排水2</button>
				--><button id="button3_yuf"value=""type="button" class='btn_off'  style='width: 80px;'>工业排水</button>
				</td>
				<td width="70" align="center"> 
				<button type="button"  id="p1_yuf"value="" class='btn_off'  style='width:61px;'>阀门1</button>
				<button type="button"  id="p2_yuf"value=""  class='btn_on'  style='width:61px;;'>阀门2</button>
				</td>
				<td width="70" align="center"> 
				<button type="button"class="btn btn-default">采样</button>
				</td>
				<!--<td width="120" align="center"> 
				<button type="button" class="btn btn-default">测量</button>
				<button type="button" class="btn btn-default">定标</button>
				<button type="button" class="btn btn-default">终止</button>
				</td>
				<td width="120" align="center"> 
				<button type="button" class="btn btn-default">测量</button>
				<button type="button" class="btn btn-default">定标</button>
				<button type="button" class="btn btn-default">终止</button>
				</td>
				<td width="120" align="center"> 
				<button type="button" class="btn btn-default">测量</button>
				<button type="button" class="btn btn-default">定标</button>
				<button type="button" class="btn btn-default">终止</button>
				</td>
			--></tr> --%>
			<tr id="jbdd" class='tb_font15_h46'>
				<th width="30" style='font-family:Microsoft YaHei;' align="center">金标电镀</th>
				<th width="50" align="center">75501330008</th>
				<td width="120" align="center"> 
				<button id="button1_jb" value=""type="button" onclick='open1(data_jb)'     class='btn_off'  style='width: 80px;'>舱门</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>
				-->
				<!-- <button id="button2_jb"value=""type="button"  onclick='open2(data_jb)'class='btn_off' style='width: 80px;'>生活给水</button>
				<button id="button55"value=""type="button" onclick='open5(75501330001)'class="btn btn-success">工业排水2</button>
				
				<button id="button3_jb"value=""type="button"  onclick='open3(data_jb)'  class='btn_off' style='width: 80px;'>工业排水</button>
				 -->
				</td>
				<td width="70" align="center"> 
				<%--<button type="button"  id="p1_zckj"value=""onclick='open6(data_zckj)'class="btn btn-success">阀门1</button>
				<button type="button"  id="p2_zckj"value=""onclick='open7(data_zckj)'class="btn btn-danger">阀门2</button>      0开1关
				
				--%><button type="button"  id="p1_zckj"value="0"  onclick='open4(data_jb)' class='btn_off' style='width:71px;'>阀门开</button>
				<button type="button"  id="p2_zckj"value="1"  onclick='open4(data_jb)'  class='btn_on'  style='width:71px;'>阀门关</button>
				</td>
				<td width="70" align="center"> 
				<button id="samp8"value="" type="button" onclick='open10(data_jb)'class="btn btn-default">采样</button>
				</td>
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
			--></tr>
			<tr id="tdwj" class='tb_font15_h46'>
				<th width="30" style='font-family:Microsoft YaHei;' align="center">天得五金</th>
				<th width="50" align="center">75501330009</th>
				<td width="120" align="center"> 
				<button id="button1_td" value=""type="button" onclick='open1(data_td)'     class='btn_off'  style='width: 80px;'>舱门</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>
				-->
				<!-- <button id="button2_td"value=""type="button"  onclick='open2(data_td)'class='btn_off' style='width: 80px;'>生活给水</button>
				<button id="button55"value=""type="button" onclick='open5(75501330001)'class="btn btn-success">工业排水2</button>
				
				<button id="button3_td"value=""type="button"  onclick='open3(data_td)'  class='btn_off' style='width: 80px;'>工业排水</button>
				 -->
				</td>
				<td width="70" align="center"> 
				<%--<button type="button"  id="p1_zckj"value=""onclick='open6(data_zckj)'class="btn btn-success">阀门1</button>
				<button type="button"  id="p2_zckj"value=""onclick='open7(data_zckj)'class="btn btn-danger">阀门2</button>
				
				--%><button type="button"  id="p1_td"value=""  onclick='open4(data_td)' class='btn_off' style='width:61px;'>阀门1</button>
				<button type="button"  id="p2_td"value=""   class='btn_on'  style='width:61px;'>阀门2</button>
				</td>
				<td width="70" align="center"> 
				<button type="button"id="samp9"value="" onclick='open11(data_td,value)'class="btn btn-default">采样</button>
				</td>
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
			--></tr>
			<tr id="bcdd" class='tb_font15_h46'>
				<th width="30" style='font-family:Microsoft YaHei;' align="center">碧池电镀</th>
				<th width="50" align="center">75501330010</th>
				<td width="120" align="center"> 
				<button id="button1_bc" value=""type="button" onclick='open1(data_bc)'     class='btn_off'  style='width: 80px;'>舱门</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>
				-->
				<!-- <button id="button2_bc"value=""type="button"  onclick='open2(data_bc)'class='btn_off' style='width: 80px;'>生活给水</button>
				<button id="button55"value=""type="button" onclick='open5(75501330001)'class="btn btn-success">工业排水2</button>
				
				<button id="button3_bc"value=""type="button"  onclick='open3(data_bc)'  class='btn_off' style='width: 80px;'>工业排水</button>
				 -->
				</td>
				<td width="70" align="center"> 
				<%--<button type="button"  id="p1_zckj"value=""onclick='open6(data_zckj)'class="btn btn-success">阀门1</button>
				<button type="button"  id="p2_zckj"value=""onclick='open7(data_zckj)'class="btn btn-danger">阀门2</button>
				
				--%><button type="button"  id="p1_bc"value=""  onclick='open4(data_bc)' class='btn_off' style='width:61px;'>阀门1</button>
				<button type="button"  id="p2_bc"value=""   class='btn_on'  style='width:61px;'>阀门2</button>
				</td>
				<td width="70" align="center"> 
				<button type="button" id="samp10"value=""onclick='open11(data_bc,value)'class="btn btn-default">采样</button>
				</td>
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
			--></tr>
			<%-- <tr  id="rhjd"class='tb_font15_h46'>
				<th width="30" style='font-family:Microsoft YaHei;' align="center">瑞鸿机电厂</th>
				<th width="50" align="center">75501330011</th>
				<td width="120" align="center"> 
				<button id="button1_6" value=""type="button" onclick='open1(data_6)'     class='btn_off'  style='width: 80px;'>舱门</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>
				-->
				<!-- <button id="button2_6"value=""type="button"  onclick='open2(data_6)'class='btn_off' style='width: 80px;'>生活给水</button>
				<button id="button55"value=""type="button" onclick='open5(75501330001)'class="btn btn-success">工业排水2</button>
				
				<button id="button3_6"value=""type="button"  onclick='open3(data_6)'  class='btn_off' style='width: 80px;'>工业排水</button>
				 -->
				</td>
				<td width="70" align="center"> 
				<button type="button"  id="p1_zckj"value=""onclick='open6(data_zckj)'class="btn btn-success">阀门1</button>
				<button type="button"  id="p2_zckj"value=""onclick='open7(data_zckj)'class="btn btn-danger">阀门2</button>
				
				<button type="button"  id="p1_6"value=""  onclick='open4(data_6)' class='btn_off' style='width:61px;'>阀门1</button>
				<button type="button"  id="p2_6"value=""   class='btn_on'  style='width:61px;'>阀门2</button>
				</td>
				<td width="70" align="center"> 
				<button type="button"id="samp11"value="" onclick='open11(data_6,value)'class="btn btn-default">采样</button>
				</td>
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
			--></tr> --%>
			<tr  id="ysh"class='tb_font15_h46'>
				<th width="30" style='font-family:Microsoft YaHei;' align="center">誉升恒</th>
				<th width="50" align="center">75501330012</th>
				<td width="120" align="center"> 
				<button id="button1_7" value=""type="button" onclick='open1(data_7)'     class='btn_off'  style='width: 80px;'>舱门</button>
				<!--<button id="button3"value=""type="button" onclick='open3()'class="btn btn-danger">工业给水</button>
				-->
				<!-- <button id="button2_7"value=""type="button"  onclick='open2(data_7)'class='btn_off' style='width: 80px;'>生活给水</button>
				<button id="button55"value=""type="button" onclick='open5(75501330001)'class="btn btn-success">工业排水2</button>
				
				<button id="button3_7"value=""type="button"  onclick='open3(data_7)'  class='btn_off' style='width: 80px;'>工业排水</button>
				 -->
				</td>
				<td width="70" align="center"> 
				<%--<button type="button"  id="p1_zckj"value=""onclick='open6(data_zckj)'class="btn btn-success">阀门1</button>
				<button type="button"  id="p2_zckj"value=""onclick='open7(data_zckj)'class="btn btn-danger">阀门2</button>
				
				--%><button type="button"  id="p1_7"value=""  onclick='open4(data_7)' class='btn_off' style='width:61px;'>阀门1</button>
				<button type="button"  id="p2_7"value=""   class='btn_on'  style='width:61px;'>阀门2</button>
				</td>
				<td width="70" align="center"> 
				<button type="button"id="samp12"value="" onclick='open11(data_7,value)'class="btn btn-default">采样</button>
				</td>
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
			--></tr>
		<%--</c:forEach>
		--%></tbody>
		
	</table>
<div   style='margin-top:20px'>
	<span  class='tb_font16'>备注:</span>
	<div style="margin-left:35px; text-align: left;font-size: 15px;font-family:Microsoft YaHei;" colspan="5"> <img height=26px width=12px style='	margin: 2px; background: url(${ctx}/resources/lrtk/images/button-off2.png) no-repeat center;'></img><span style="font-family:Microsoft YaHei;">绿色代表关闭，</span><img height=26px width=12px style='	margin: 2px;background: url(${ctx}/resources/lrtk/images/button-on2.png) no-repeat center;'></img><span style="font-family:Microsoft YaHei;">红色代表开启</span></div>

	</div>
</div>
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