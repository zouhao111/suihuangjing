<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<!--[if IE 9]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if IE 8]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if  IE 7]>
<link href="${ctx}/resources/css/ie7.css"	type="text/css" rel="stylesheet" />
<![endif]-->




<script type="text/javascript" src="${ctx}/resources/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/resources/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-ui-jqLoding.js"></script>
<script type="text/javascript" src="http://www.xdocin.com/xdoc.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/pdf.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/ajaxpdf.js"></script>
<link href="${ctx}/resources/css/pager.css"	type="text/css" rel="stylesheet" />
<script src="${ctx}/resources/laydate/laydate.js"></script>
<title>统计报表</title>
<style type="text/css">
#td_time{
 width:15%;
}
#td_id{
 width:85%;
}
.tr_w{
 width:12%;
}
table{
width:100%
}
</style>
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
		  if(${type==11}){
		  var optss = document.getElementById("timeSpace");
		var minates=$("#select").val();  
		console.log(minates)
		console.log(optss)
		if(minates!=""&&optss!=""){
	 for(var i=0;i<4;i++){
           if(minates==optss.options[i].value){
                  optss.options[i].selected = 'selected';
                    break;
             }
          }
         }
         }
         window.parent.startaa();
	});
</script>

<script type="text/javascript">
	
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
	
</script>
</head>
<body class="body_overflow">
<input id="webUrls" type="hidden" value="${webUrls}" >
<input id="rid"  type="hidden" value="${rid}" >
<input id="type" type="hidden" value="${type}" >	
	 <c:choose>
	     <c:when test="${type==1}">
	            <p class="f14style" ><span class="f14 text-title">${Companyconfig.companyName}水质日报表</span></p>
	    		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	    
	       <form id="myform" name="myform" method="post" ">

	         <span class="heard_font14">选择日期：</span><input id="startingTime" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
	            <input name="search" class="btn-big" onclick="findReport();" type="button" value="查 询" />
	             <input id="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
	             <input id="btn" class="btn-big" type="button" style="float: right;"value="导出Excle"/>
	             <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
	      </form>
	    </c:when>
	    <%-- <c:when test="${type==2}">
	       <form id="myform" name="myform" method="post" style="text-align: center;">
	                         选择周：<input type="text" id="startingTime" name="dateTypes" value="${dateTypes}" onfocus="WdatePicker({dateFmt:'yyyy-MM'})" class="Wdate" style="width:200px"/>
	                <input name="search" class="btn-big" onclick="findReport2();" type="button" value="查询" />
	                 <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	      </form>
	     </c:when> --%>
	     
	     
	     <c:when test="${type==3}">
	        <p class="f14style" ><span class="f14 text-title">${Companyconfig.companyName}水质月报表</span></p>
	 
	   		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	 
	       <form id="myform" name="myform" method="post" >
	     
	       
	    <span class="heard_font14">选择月份： </span><input id="startingTime" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM'})">
	            <input name="search" class="btn-big" onclick="findReport3();" type="button" value="查询" />
	            <input name="lat"  class="btn-big"  type="submit" value="前月" />
				<input name="lat" class="btn-big"  type="submit" value="后月" />
	            <input id="btn"class="btn-big"  type="button"style="float: right;" value="导出Excle"/>
	            <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
	            </form>
	    </c:when>
	    
	    
	  	<c:when test="${type==6}">
	  	   <p class="f14style" ><span class="f14 text-title">${Companyconfig.companyName}水质年报表</span></p>
	  	     <div style="background-color:#ffffff;width:100%;height:5px;"></div>
	       <form id="myform" name="myform" method="post" >
 
	 <span class="heard_font14">选择年份： </span><input id="startingTime" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY'})">
	            <input name="search" class="btn-big" onclick="findReport6();" type="button" value="查询" />
	            <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	            <input id="btn" class="btn-big" type="button"style="float: right;" value="导出Excle"/>
	            <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
	      </form>
	   </c:when>
	   
	    <c:when test="${type==11}">
	    	<p class="f14style" ><span class="f14 text-title">${Companyconfig.companyName}水质历史报表</span></p>
	    
	        <div style="background-color:#ffffff;width:100%;height:5px;"></div>
	        
	    	<input id="select" type="hidden" value="${minates}" >
	        <form id="myform" name="myform" method="post" >
 
		<span class="heard_font14">开始时间：</span><input id="startingTime" name="startingTime" value="${sTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	<span class="heard_font14">结束时间：</span><input id="endTime" name="endTime" value="${eTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
		<span class="heard_font14">时间间隔(/分钟)： </span>	<select id="timeSpace"name="minates"><option value ="5">5分钟</option><option value ="30">30分钟</option><option value="60">1小时</option><option value="1440">24小时</option></select> 
	         <input name="search" class="btn-big" onclick="findReport11();" type="button" value="查询" />
	         <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	         <input id="btn" class="btn-big"type="button" style="float: right;"style="float: right;"value="导出Excle"/>
	         <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
	      </form>
	     </c:when> 
	     
	   <c:otherwise>
	   	<p class="f14style" ><span class="f14 text-title">${Companyconfig.companyName}水质自定义报表</span></p>
	        <div style="background-color:#ffffff;width:100%;height:5px;"></div>
	        
	   
	     <form id="myform" name="myform" method="post" >
		<span class="heard_font14">开始时间：</span><input id="startingTime" name="startingTime" value="${sTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
		<span class="heard_font14">结束时间：</span><input class="laydate-icon" id="endTime" name="endTime" value="${eTime}" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	     <input name="search" class="btn-big" onclick="findReport5();" type="button" value="查询" />
	      <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	      <input id="btn"class="btn-big"type="button" style="float: right;"value="导出Excle"/>
	      <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
	     </form>
	    </c:otherwise>
    </c:choose>
	
 
      <div style="background-color:#ffffff;width:100%;height:5px;"></div>
	        
	<table border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" style="border-collapse:collapse;"  >
			<thead >
					  <c:choose>
					  
					 
					 <c:when test="${rid==75501330003 or rid ==75501330002 or  rid==75501330001 or  rid==75501330005}">
						  <tr  class="tb_heard_font16">
					    <td id="td_time" align="center" rowspan="2"  >时间</td>
					    <td id="td_id" align="center" colspan="7"  >工业排水</td>
					 </tr>
						 <tr  class="tb_heard_font15">
					    <td  align="center" >PH</td>
					    <td  align="center">COD(mg/l)</td>
					    <td  align="center">氨氮(mg/l)</td>
					    <td  align="center">六价铬(mg/l)</td>
					    <td  align="center">电导率(mg/l)</td>
					    <td  align="center">固体悬浮物(mg/l)</td>
					     <td  align="center">总镍(mg/l)</td>
					 </tr>
					 </c:when>
					 <c:when test="${rid==75501330004}">
							  <tr  class="tb_heard_font16">
					    <td id="td_time"  align="center" rowspan="2"  >时间</td>
					    <td id="td_id"width="85% "align="center"; colspan="7"  >工业排水</td>
					 </tr>
					 <tr  class="tb_heard_font15">
					    <td  align="center" >PH</td>
					    <td  align="center">COD(mg/l)</td>
					    <td  align="center">氨氮(mg/l)</td>
					    <td  align="center">六价铬(mg/l)</td>
					    <td  align="center">电导率(mg/l)</td>
					    <td  align="center">固体悬浮物(mg/l)</td>
					     <td  align="center">总磷(mg/l)</td>
					     
					 </tr>
					 </c:when>
					<c:otherwise >
							  <tr  class="tb_heard_font16">
					    <td id="td_time"  align="center" rowspan="2"  >时间</td>
					    <td id="td_id"width="85% "align="center"; colspan='${size}'  >工业排水</td>
					 </tr>
					 <tr  class="tb_heard_font15">
					   <c:forEach items="${data_name1}" var="bean">
						 <td  align="center" >${bean.pollType}</td>
						  
						 </c:forEach>
					 </tr>
					 </c:otherwise> 
					  </c:choose>
			</thead>
	   <c:choose>
		<c:when test="${type==11}">
		 
		<c:forEach items="${datass}" var="bean">
		 <c:if test="${rid==75501330003 or rid ==75501330002 or  rid==75501330001 or  rid==75501330005}">
			 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realph}' pattern="0.0"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realcod}' pattern="0"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realnh4}' pattern="0.000"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.realcr6}' pattern="0.0000"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realconductivity}' pattern="0"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realmlss}' pattern="0.0"/></td>
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.realni}' pattern="0.0"/></td>
		  </tr>
		  </c:if>
		  <c:if test="${rid==75501330004}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realph}' pattern="0.0"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realcod}' pattern="0"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='0' pattern="0.000"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.realcr6}' pattern="0.0000"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realconductivity}' pattern="0"/></td>
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.realmlss}' pattern="0.00"/></td>
		    
		    <!--  <td  align="center">-</td> -->
		    
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realphosphor}' pattern="0.000"/></td>
		  </tr>
		  </c:if>
		   <c:if test="${rid==75501330008}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realph}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realTemp}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realTurbidity}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realconductivity}' pattern="0"/></td>
			
			<%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.realmlss}' pattern="0.00"/></td> --%>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realphosphor}' pattern="0.000"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realDo}' pattern="0.00"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.realnh4}' pattern="0.000"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realcu}' pattern="0.000"/></td>
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.realni}' pattern="0.000"/></td>
		   
		  
		  </tr>
		  </c:if>
		  <c:if test="${rid==75501330009}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realph}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realTemp}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realTurbidity}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realconductivity}' pattern="0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realDo}' pattern="0.00"/></td>
		<%-- 	<td  align="center"><fmt:formatNumber type='number' value='${bean.realmlss}' pattern="0.00"/></td> --%>
	
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.realni}' pattern="0.000"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.realphosphor}' pattern="0.000"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.realnh4}' pattern="0.000"/></td>
		  	    <td  align="center"><fmt:formatNumber type='number' value='${bean.realzn}' pattern="0.000"/></td>
		  </tr>
		  </c:if>
		  <c:if test="${rid==75501330010}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realph}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realTemp}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realTurbidity}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realconductivity}' pattern="0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realDo}' pattern="0.00"/></td>
			<%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.realmlss}' pattern="0.00"/></td> --%>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realphosphor}' pattern="0.000"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.realnh4}' pattern="0.000"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realzn}' pattern="0.000"/></td>
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.realni}' pattern="0.000"/></td>
		   
		  </tr>
		  </c:if>
		  <c:if test="${rid==75506330001}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realph}' pattern="0.0"/></td>
			<%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.realTemp}' pattern="0.0"/></td> --%>
			<%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.realTurbidity}' pattern="0.0"/></td> --%>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realconductivity}' pattern="0"/></td>
			 <td  align="center"><fmt:formatNumber type='number' value='${bean.realcod}' pattern="0"/></td>
			 <td  align="center"><fmt:formatNumber type='number' value='${bean.realphosphor}' pattern="0.000"/></td>
			 	   <td  align="center"><fmt:formatNumber type='number' value='${bean.realcr6}' pattern="0.0000"/></td>
			<%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.realDo}' pattern="0.00"/></td> --%>
			<%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.realmlss}' pattern="0.00"/></td> --%>
			<%-- 
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.realnh4}' pattern="0.000"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realzn}' pattern="0.000"/></td>
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.realni}' pattern="0.000"/></td> --%>
		   
		  </tr>
		  </c:if>
		  <c:if test="${rid==75506330002}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realph}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realconductivity}' pattern="0"/></td>
			 <td  align="center"><fmt:formatNumber type='number' value='${bean.realcod}' pattern="0"/></td>
			 <td  align="center"><fmt:formatNumber type='number' value='${bean.realphosphor}' pattern="0.000"/></td>
			 	   <td  align="center"><fmt:formatNumber type='number' value='${bean.realFlu}' pattern="0.0000"/></td>
			
			<%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.realTemp}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realTurbidity}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realconductivity}' pattern="0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realDo}' pattern="0.00"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realmlss}' pattern="0.00"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realphosphor}' pattern="0.000"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.realnh4}' pattern="0.000"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realzn}' pattern="0.000"/></td>
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.realni}' pattern="0.000"/></td> --%>
		   
		  </tr>
		  </c:if>
		  <c:if test="${rid==75506330003}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realph}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realconductivity}' pattern="0"/></td>
			 <td  align="center"><fmt:formatNumber type='number' value='${bean.realcod}' pattern="0"/></td>
			 <td  align="center"><fmt:formatNumber type='number' value='${bean.realphosphor}' pattern="0.000"/></td>
			 	   <td  align="center"><fmt:formatNumber type='number' value='${bean.realFlu}' pattern="0.0000"/></td>
			<%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.realTemp}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realTurbidity}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realconductivity}' pattern="0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realDo}' pattern="0.00"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realmlss}' pattern="0.00"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realphosphor}' pattern="0.000"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.realnh4}' pattern="0.000"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realzn}' pattern="0.000"/></td>
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.realni}' pattern="0.000"/></td>
		    --%>
		  </tr>
		  </c:if>
		  
		   <c:if test="${rid==75501330022||rid==75501330023||rid==75501330024||rid==75501330025||rid==75501330026}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realph}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realconductivity}' pattern="0"/></td>
			 <td  align="center"><fmt:formatNumber type='number' value='${bean.realcod}' pattern="0"/></td>
			     <td  align="center"><fmt:formatNumber type='number' value='${bean.realcu}' pattern="0.000"/></td>
			  <td  align="center"><fmt:formatNumber type='number' value='${bean.realni}' pattern="0.000"/></td>
			 
			<%--  <td  align="center"><fmt:formatNumber type='number' value='${bean.realphosphor}' pattern="0.000"/></td>
			 	   <td  align="center"><fmt:formatNumber type='number' value='${bean.realFlu}' pattern="0.0000"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realTemp}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realTurbidity}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realconductivity}' pattern="0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realDo}' pattern="0.00"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realmlss}' pattern="0.00"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.realphosphor}' pattern="0.000"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.realnh4}' pattern="0.000"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.realzn}' pattern="0.000"/></td>
		    
		    --%>
		  </tr>
		  </c:if>
		  
		</c:forEach>
		</c:when>
	
		
		<c:when test="${type!=11}">
		<c:forEach items="${datass}" var="bean">
		<c:if test="${rid==75501330003 or rid ==75501330002 or  rid==75501330001or  rid==75501330005}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minph}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxph}' pattern="0.0"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.mincod}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxcod}' pattern="0"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minnh4}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxnh4}' pattern="0.000"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.mincr6}' pattern="0.0000"/>-<fmt:formatNumber type='number' value='${bean.maxcr6}' pattern="0.0000"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minconductivity}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxconductivity}' pattern="0"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minmlss}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxmlss}' pattern="0.0"/></td>
		 <td  align="center"><fmt:formatNumber type='number' value='${bean.minni}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxni}' pattern="0.0"/></td>
		 
		  </tr>
		  </c:if>
		  <c:if test="${rid==75501330004}">
			 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minph}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxph}' pattern="0.0"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.mincod}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxcod}' pattern="0"/></td>
		   
		    <td  align="center"><fmt:formatNumber type='number' value='0' pattern="0.000"/>-<fmt:formatNumber type='number' value='0' pattern="0.000"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.mincr6}' pattern="0.0000"/>-<fmt:formatNumber type='number' value='${bean.maxcr6}' pattern="0.0000"/></td>
		    
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minconductivity}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxconductivity}' pattern="0"/></td>
		  <%--   <td  align="center"><fmt:formatNumber type='number' value='${bean.minmlss}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxmlss}' pattern="0.00"/></td>
		   --%>
		     <td  align="center">-</td>
		  
		  <td  align="center"><fmt:formatNumber type='number' value='${bean.minphosphor}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxphosphor}' pattern="0.000"/></td>
		 
		  </tr>
		  </c:if>
		   <c:if test="${rid==75501330008}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minph}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxph}' pattern="0.0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minTemp}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTemp}' pattern="0.0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minTurbidity}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTurbidity}' pattern="0.0"/></td>
			
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minconductivity}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxconductivity}' pattern="0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minphosphor}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxphosphor}' pattern="0.000"/></td>
		   
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minDo}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxDo}' pattern="0.00"/></td>
			
			 
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.minnh4}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxnh4}' pattern="0.000"/></td>
		  
			<%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.minmlss}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxmlss}' pattern="0.00"/></td>
		     --%>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.mincu}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxcu}' pattern="0.000"/></td>
		    
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.minni}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxni}' pattern="0.000"/></td>
		  
		  
		  </tr>
		  </c:if>
		  <c:if test="${rid==75501330009}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minph}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxph}' pattern="0.0"/></td>
			
		<td  align="center"><fmt:formatNumber type='number' value='${bean.minTemp}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTemp}' pattern="0.0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minTurbidity}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTurbidity}' pattern="0.0"/></td>
			
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minconductivity}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxconductivity}' pattern="0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minDo}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxDo}' pattern="0.00"/></td>
				
			<%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.minmlss}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxmlss}' pattern="0.00"/></td>
		    --%>
		   
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minni}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxni}' pattern="0.000"/></td>
		  
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minphosphor}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxphosphor}' pattern="0.000"/></td>
		   
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.minnh4}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxnh4}' pattern="0.000"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.minzn}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.minzn}' pattern="0.000"/></td>
		    
		  
		  </tr>
		  </c:if>
		  <c:if test="${rid==75501330010}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td  align="center"><fmt:formatNumber type='number' value='${bean.minph}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxph}' pattern="0.0"/></td>
			
		<td  align="center"><fmt:formatNumber type='number' value='${bean.minTemp}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTemp}' pattern="0.0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minTurbidity}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTurbidity}' pattern="0.0"/></td>
			
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minconductivity}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxconductivity}' pattern="0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minDo}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxDo}' pattern="0.00"/></td>
			
			<%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.minmlss}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxmlss}' pattern="0.00"/></td>
		    --%>
		    
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.minphosphor}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxphosphor}' pattern="0.000"/></td>
		   
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minnh4}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxnh4}' pattern="0.000"/></td>
		   
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.minzn}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.minzn}' pattern="0.000"/></td>
		    
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minni}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxni}' pattern="0.000"/></td>
		  
		   
		  
		  </tr>
		  </c:if>
		  
		   <c:if test="${rid==75506330001}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td  align="center"><fmt:formatNumber type='number' value='${bean.minph}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxph}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minconductivity}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxconductivity}' pattern="0"/></td>
			 <td  align="center"><fmt:formatNumber type='number' value='${bean.mincod}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxcod}' pattern="0"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.minphosphor}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxphosphor}' pattern="0.000"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.mincr6}' pattern="0.0000"/>-<fmt:formatNumber type='number' value='${bean.maxcr6}' pattern="0.0000"/></td>
		    
		<%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.minTemp}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTemp}' pattern="0.0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minTurbidity}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTurbidity}' pattern="0.0"/></td>
			
			
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minDo}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxDo}' pattern="0.00"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minmlss}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxmlss}' pattern="0.00"/></td>
		   
		    
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.minphosphor}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxphosphor}' pattern="0.000"/></td>
		   
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.minnh4}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxrealnh4}' pattern="0.000"/></td>
		  
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.minzn}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.minzn}' pattern="0.000"/></td>
		    
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minni}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxni}' pattern="0.000"/></td>
		   --%>
		   
		  
		  </tr>
		  </c:if>
		  
		   <c:if test="${rid==75506330002}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td  align="center"><fmt:formatNumber type='number' value='${bean.minph}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxph}' pattern="0.0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minconductivity}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxconductivity}' pattern="0"/></td>
			 <td  align="center"><fmt:formatNumber type='number' value='${bean.mincod}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxcod}' pattern="0"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.minphosphor}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxphosphor}' pattern="0.000"/></td>
		    <%-- <td  align="center"><fmt:formatNumber type='number' value='${bean.mincr6}' pattern="0.0000"/>-<fmt:formatNumber type='number' value='${bean.maxcr6}' pattern="0.0000"/></td>
		     --%>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minFlu}' pattern="0.0000"/>-<fmt:formatNumber type='number' value='${bean.maxFlu}' pattern="0.0000"/></td>
		    
			<%-- 
		<td  align="center"><fmt:formatNumber type='number' value='${bean.minTemp}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTemp}' pattern="0.0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minTurbidity}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTurbidity}' pattern="0.0"/></td>
			
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minconductivity}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxconductivity}' pattern="0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minDo}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxDo}' pattern="0.00"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minmlss}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxmlss}' pattern="0.00"/></td>
		   
		    
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.minphosphor}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxphosphor}' pattern="0.000"/></td>
		   
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.minnh4}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxrealnh4}' pattern="0.000"/></td>
		  
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.minzn}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.minzn}' pattern="0.000"/></td>
		    
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minni}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxni}' pattern="0.000"/></td>
		   --%>
		   
		  
		  </tr>
		  </c:if>
		  
		   <c:if test="${rid==75506330003}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td  align="center"><fmt:formatNumber type='number' value='${bean.minph}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxph}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minconductivity}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxconductivity}' pattern="0"/></td>
			 <td  align="center"><fmt:formatNumber type='number' value='${bean.mincod}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxcod}' pattern="0"/></td>
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.minphosphor}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxphosphor}' pattern="0.000"/></td>
		   <%--  <td  align="center"><fmt:formatNumber type='number' value='${bean.mincr6}' pattern="0.0000"/>-<fmt:formatNumber type='number' value='${bean.maxcr6}' pattern="0.0000"/></td>
		     --%><td  align="center"><fmt:formatNumber type='number' value='${bean.minFlu}' pattern="0.0000"/>-<fmt:formatNumber type='number' value='${bean.maxFlu}' pattern="0.0000"/></td>
		    
			
			<%-- 
		<td  align="center"><fmt:formatNumber type='number' value='${bean.minTemp}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTemp}' pattern="0.0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minTurbidity}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTurbidity}' pattern="0.0"/></td>
			
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minconductivity}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxconductivity}' pattern="0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minDo}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxDo}' pattern="0.00"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minmlss}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxmlss}' pattern="0.00"/></td>
		   
		    
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.minphosphor}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxphosphor}' pattern="0.000"/></td>
		   
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.minnh4}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxrealnh4}' pattern="0.000"/></td>
		  
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.minzn}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.minzn}' pattern="0.000"/></td>
		    
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minni}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxni}' pattern="0.000"/></td>
		   --%>
		   
		  
		  </tr>
		  </c:if>
		  
		   <c:if test="${rid==75501330022||rid==75501330023||rid==75501330024||rid==75501330025||rid==75501330026}">
		 <tr    class="tb_font15"   >
			<td  align="center"  ><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td  align="center"><fmt:formatNumber type='number' value='${bean.minph}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxph}' pattern="0.0"/></td>
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minconductivity}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxconductivity}' pattern="0"/></td>
			 <td  align="center"><fmt:formatNumber type='number' value='${bean.mincod}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxcod}' pattern="0"/></td>
		 <td  align="center"><fmt:formatNumber type='number' value='${bean.mincu}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxcu}' pattern="0.000"/></td>
		   
		 <td  align="center"><fmt:formatNumber type='number' value='${bean.minni}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxni}' pattern="0.000"/></td>
		  
		 <%--   <td  align="center"><fmt:formatNumber type='number' value='${bean.minphosphor}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxphosphor}' pattern="0.000"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.mincr6}' pattern="0.0000"/>-<fmt:formatNumber type='number' value='${bean.maxcr6}' pattern="0.0000"/></td>
		    <td  align="center"><fmt:formatNumber type='number' value='${bean.minFlu}' pattern="0.0000"/>-<fmt:formatNumber type='number' value='${bean.maxFlu}' pattern="0.0000"/></td>
		    
			
			
		<td  align="center"><fmt:formatNumber type='number' value='${bean.minTemp}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTemp}' pattern="0.0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minTurbidity}' pattern="0.0"/>-<fmt:formatNumber type='number' value='${bean.maxTurbidity}' pattern="0.0"/></td>
			
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minconductivity}' pattern="0"/>-<fmt:formatNumber type='number' value='${bean.maxconductivity}' pattern="0"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minDo}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxDo}' pattern="0.00"/></td>
			
			<td  align="center"><fmt:formatNumber type='number' value='${bean.minmlss}' pattern="0.00"/>-<fmt:formatNumber type='number' value='${bean.maxmlss}' pattern="0.00"/></td>
		   
		    
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.minphosphor}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxphosphor}' pattern="0.000"/></td>
		   
		   <td  align="center"><fmt:formatNumber type='number' value='${bean.minnh4}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.maxrealnh4}' pattern="0.000"/></td>
		  
		     <td  align="center"><fmt:formatNumber type='number' value='${bean.minzn}' pattern="0.000"/>-<fmt:formatNumber type='number' value='${bean.minzn}' pattern="0.000"/></td>
		    
		   
		   --%>
		   
		  
		  </tr>
		  </c:if>
		  
		  
		  
		</c:forEach>
		
		</c:when>
		</c:choose>
	</table>
	<div id="pdf"class="table2excel bluestrip" style="display:none" >
	<table border="0" cellspacing="0" cellpadding="0" class="table-list" id="table_pdf" >
			<thead id="thead"></thead>
		<tbody id="tr"></tbody>	
	</table>
	</div>
		
		 
		
	</tbody>	
	</table>
	</div>
	<div id="pagelist"  >
		<ul style="list-style:none;">
			<pg:pager items="${pager.rowCount}"
			export="currentPageNumber=pageNumber" maxPageItems="${pager.pageSize }" maxIndexPages="5" url="../reportForm/reportFormList" >
			<!-- 分页带查询条件 -->
			<pg:param name="startingTime" value="${sTime}"/>
			<pg:param name="endTime" value="${eTime}"/>
			<pg:param name="minates" value="${minates}"/>
			<pg:param name="rid" value="${rid}"/>
			<pg:param name="type" value="${type}"/>
			<pg:param name="dateTypes" value="${dateTypes}"/>
				<!-- 首页 -->
				<pg:first>
					<li style="list-style:none;"><a href="${pageUrl }"   class="page_btn">首页</a></li>
				</pg:first>
				<pg:prev>
					<li style="list-style:none;"><a href="${pageUrl }"   class="page_btn">前一页</a></li>
				</pg:prev>
				<pg:pages>
					<c:choose>
						<c:when test="${currentPageNumber eq pageNumber }">
							<li   class="page_btn_s">${pageNumber }</li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl }"  class="page_btn">${pageNumber }</a></li>
						</c:otherwise>
					</c:choose>
				</pg:pages>
				<pg:next>
					<li style="list-style:none;"><a href="${pageUrl }"  class="page_btn">后一页</a></li>
				</pg:next>
				<pg:last>
					<li style="list-style:none;"><a href="${pageUrl }"   class="page_btn">尾页</a></li>
				</pg:last>
		   	    <li  class="page_text">共${pager.pageCount}页</li>
		    <li class="page_text">共${pager.rowCount}条记录</li>
			</pg:pager>
  		</ul>
	</div>
	
      <%--<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	        
	--%></div>
	  <%--<div style="with:100%;height:30px;  background: url(${ctx}/resources/lrtk/images/foot.png) no-repeat center;"></div> 
	  
	  
--%><script src="${ctx}/resources/js/jquery.table2excel.js"></script>
	<script type="text/javascript">
	
	
	var rid=$("#rid").val();
	//查询
	function findReport(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../reportForm/reportFormList?type=1&rid="+rid;
		document.myform.submit();
	}
	function findReport3(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../reportForm/reportFormList?type=3&rid="+rid;
		document.myform.submit();
	}
	function findReport6(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../reportForm/reportFormList?type=6&rid="+rid;
		document.myform.submit();
	}
	function findReport11(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../reportForm/reportFormList?type=11&rid="+rid;
		document.myform.submit();
	}
	function findReport5(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../reportForm/reportFormList?type=5&rid="+rid;
		document.myform.submit();
	}
	
	</script>
	

	<script>
		$(function() {
			data_pdf2();
			var name1=$("#com_name").text();
			$("#btn").click(function(){
				
				if(${pager.rowCount}>4500){
					alert("抱歉！！浏览器限制，目前系统只支持导出15天或者4000条数据，请修改查询时间分段导出！")
				}else{
					if($("#tr").html()==''){
					alert("正在查询中，请稍后再试")
				}else{
					$(".table2excel").table2excel({
					exclude: ".noExl",
					name: "Excel Document Name",
					filename: name1,
					exclude_img: true,
					exclude_links: true,
					exclude_inputs: true
					
				});
				
				}
				}
				
				
			});
		});
	</script>	
	<script language="javascript" src="${ctx}/resources/print/jquery.jqprint-0.3.js"></script>
	<script language="javascript">
function  a(){
        $("#table_pdf").jqprint();
    }
</script>

</body>

</html>