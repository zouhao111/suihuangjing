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
<script type="text/javascript" src="${ctx}/resources/js/montors_water/Newconsole_water.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/montors_water/Newconsole2_water.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/montors_water/conversion.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/zDialog.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/zDrag.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-ui-jqLoding.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/montors_water/click.js"></script>

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
  
        $(this).jqLoading("destroy");  
		    
	var rid=$("#rid").val();
	
	var tiimer=setInterval(function() {
  console1(data_zckj)
	
     
      
}, 10000);
        
  });
</script>

</head>
<body  class="body_overflow">

<%--<button id="button3"value=""type="button" onclick='console_demo1()'class="btn btn-danger">开</button>
<button id="button2_tdht"value=""type="button" onclick='console_demo2()' class="btn btn-success">关</button>
--%><input id="webUrls" type="hidden" value="${webUrls}" >
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
						<th width="15%" align="center">控制单元</th>
						<th width="15%" align="center">当前状态</th>
						<th width="15%" align="center">开关操作</th>
						<th width="15%" align="center">当前模式</th>
						<th width="15%" align="center">模式切换</th>
						<!--<th width="15%" align="center">采样控制</th>
						<th width="70" align="center">COD</th>
						<th width="70" align="center">氨氮</th> 
						<th width="70" align="center">六价铬</th>
					--></tr>
			</thead>
		<tbody>
		<%--<c:forEach items="${historys}" var="bean">
			--%><tr class='tb_font15_h46'>
				
				<%--<td width="130" align="center"> 
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
				--%>
				<td width="130" align="center">自动门</td> 
				<td width="130" align="center"><div id="button1_tdht"    class='btn_off'  style='width: 95px;'></div></td>
				<td width="130" align="center">
				<button id="button11_tdht"value="0"type="button" onclick='open1(data_tdht)'     class='btn-on'  style='width: 95px;'>启动</button>
				<button id="button111_tdht"value="1"type="button" onclick='open111(data_tdht)'     class='btn-off'  style='width: 95px;'>关闭</button>
				</td>
				<td width="130" align="center"></td><td width="130" align="center"></td>
				
				
				
				
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
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">安防</td> <td width="130" align="center"><div id="button2_tdht"    class='btn_off'  style='width: 95px;'></div></td>
			<td width="130" align="center"> <button id="button2_tdht"value=""type="button"  onclick='open2(data_tdht)'    class='btn-on'  style='width: 95px;'>启动</button>
			 <button id="button2_tdht"value=""type="button"  onclick='open22(data_tdht)'    class='btn-off'  style='width: 95px;'>关闭</button>
			 </td><td width="130" align="center"></td><td width="130" align="center"></td>
				
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="130" align="center">灯光</td> 
			<td width="130" align="center"><div  id="light2"    class='btn_off'  style='width:95px;'></div></td>
             <td width="130" align="center"><button type="button"  id="light22"value=""    onclick='open4(data_tdht)'  class='btn-on'  style='width:95px;'>启 动</button>
				<button type="button"  id="light222"value=""    onclick='open44(data_tdht)'  class='btn-off'  style='width:95px;'>关 闭</button>
				</td>
                
                <td width="130" align="center"><div id="button3_tdht"     class='btn_off'  style='width: 95px;'></div></td>
				<td width="130" align="center"><button id="button33_tdht"value=""type="button"    onclick='open3(data_tdht)'     class='btn-zd'  style='width: 95px;'>手 动</button>
				<button id="button333_tdht"value=""type="button"    onclick='open33(data_tdht)'     class='btn-sd'  style='width: 95px;'>自 动</button>
				</td>
				
				
			 </tr>
			  <tr class='tb_font15_h46'>
			 <td width="130" align="center">空调</td> <td width="130" align="center">
			 <div  id="conditioning"    class='btn_on'  style='width:95px;'></div></td>
			 <td width="130" align="center">
			  <button type="button"  id="conditioning1"value=""   onclick='open5(data_tdht)'  class='btn-on'  style='width:95px;'>启 动</button>
			   <button type="button"  id="conditioning11"value=""   onclick='open55(data_tdht)'  class='btn-off'  style='width:95px;'>关 闭</button>
			   </td><td width="130" align="center"></td><td width="130" align="center"></td>
				 
			 </tr>
			 <tr class='tb_font15_h46'>
			 <td width="150" align="center">风机1</td> 
			 
			<td width="130" align="center"><div   id="fan1"  class='btn_on'  style='width:95px;'></div></td>
		<td width="130" align="center">	 <button type="button"  id="fan11"value=""   onclick='open6(data_tdht)'  class='btn-on'  style='width:95px;'>启 动</button>
			 <button type="button"  id="fan111"value=""   onclick='open6s(data_tdht)'  class='btn-off'  style='width:95px;'>关 闭</button></td><%--
			 <button type="button"  id="fan2"value=""    onclick='open7(data_tdht)' class='btn_on'  style='width:90px;'>风机1低速</button>
			 --%>
				<td width="130" align="center" rowspan="2">
			  <div  id="fan"     class='btn_on'  style='width:95px;'></div></td>
			   <td width="130" align="center"  rowspan="2"> <button type="button"  id="fan11"value=""   onclick='open66(data_tdht)'  class='btn-zd'  style='width:95px;'>手 动</button>
			  <button type="button"  id="fan111"value=""   onclick='open66ss(data_tdht)'  class='btn-sd'  style='width:95px;'>自 动</button></td> 
			 </tr>
			   <tr class='tb_font15_h46'>
			 <td width="150" align="center">风机2</td> 
			  <td width="130" align="center"><div   id="fan3"   class='btn_on'  style='width:95px;'></div></td>
			 <td width="130" align="center"> <button type="button"  id="fan11"value=""   onclick='open8(data_tdht)'  class='btn-on'  style='width:95px;'>启 动</button>
			 <button type="button"  id="fan111"value=""   onclick='open8s(data_tdht)'  class='btn-off'  style='width:95px;'>关 闭</button>
			 <%--
			 <button type="button"  id="fan4"value=""    onclick='open9(data_tdht)' class='btn_on'  style='width:90px;'>风机2低速</button>
			 --%></td>
			   </tr>
			   
			   
			   
			  <tr class='tb_font15_h46'>
			 <td width="150" align="center">潜水泵</td> 
			<td width="130" align="center"> <div  id="QJ"   class='btn_on'  style='width:95px;'></div></td>
			<td width="130" align="center"> <button type="button"  id="QJ"value=""    onclick='open10(data_tdht)' class='btn-on'  style='width:95px;'>启动</button>
			 <button type="button"  id="QJ"value=""    onclick='open101(data_tdht)' class='btn-off'  style='width:95px;'>关闭</button></td>
			 <td width="130" align="center">
			  <div   id="QJ1"  class='btn_on'  style='width:95px;'></div></td>
			   <td width="130" align="center"><button type="button"  id="QJ1"value=""    onclick='open100(data_tdht)' class='btn-zd'  style='width:95px;'>手动</button>
			    <button type="button"  id="QJ1"value=""    onclick='open100s(data_tdht)' class='btn-sd'  style='width:95px;'>自动</button></td>
			 </tr>
			 </tbody>
	</table>
	
	<table border="0" cellspacing="0" cellpadding="0"class="table-list" >
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
			<tbody>
			<tr class='tb_font15_h46'>
			
			 <td width="150" align="center">空调温度</td> 
			 <td width="130" align="center"> <div  id="QJ"   class='btn_on'  style='width:95px;'></div></td>
			  <td width="130" align="center">
			  <button type="button"  id="conditioning1"value=""   onclick='open5(data_tdht)'  class='btn-on'  style='width:95px;'>调高</button>
			   <button type="button"  id="conditioning11"value=""   onclick='open55(data_tdht)'  class='btn-off'  style='width:95px;'>调低</button>
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
			  <button type="button"  id="conditioning1"value=""   onclick='open5(data_tdht)'  class='btn-on'  style='width:95px;'>自动</button>
			   <button type="button"  id="conditioning11"value=""   onclick='open55(data_tdht)'  class='btn-off'  style='width:95px;'>制冷</button>
			    <button type="button"  id="conditioning1"value=""   onclick='open5(data_tdht)'  class='btn-on'  style='width:95px;'>加热</button>
			   <button type="button"  id="conditioning11"value=""   onclick='open55(data_tdht)'  class='btn-off'  style='width:95px;'>除湿</button>
			   <button type="button"  id="conditioning11"value=""   onclick='open55(data_tdht)'  class='btn-off'  style='width:95px;'>换气</button>
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