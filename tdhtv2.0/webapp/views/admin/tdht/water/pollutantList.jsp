<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/resources/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/resources/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-ui-jqLoding.js"></script>
<script type="text/javascript" src="http://www.xdocin.com/xdoc.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/pdf.js"></script>
<link href="${ctx}/resources/css/pager.css"	type="text/css" rel="stylesheet" />
<script src="${ctx}/resources/laydate/laydate.js"></script>
<!--[if IE 9]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if IE 8]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if  IE 7]>
<link href="${ctx}/resources/css/ie7.css"	type="text/css" rel="stylesheet" />
<![endif]-->

<title>污染物报表</title>
<style type="text/css">
table tr td{
 width:15%;
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
		  window.parent.startaa();
	});
</script>

<script type="text/javascript">
	
	var rid=${rid};
	//console.log(${rid})
	//查询
	function findReport(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../pollutant/pollutantList?type=1&rid="+rid;
		document.myform.submit();
	}
	function findReport3(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../pollutant/pollutantList?type=3&rid="+rid;
		document.myform.submit();
	}
	function findReport6(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../pollutant/pollutantList?type=6&rid="+rid;
		document.myform.submit();
	}
	function findReport11(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../pollutant/pollutantList?type=11&rid="+rid;
		document.myform.submit();
	}
	function findReport5(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../pollutant/pollutantList?type=5&rid="+rid;
		document.myform.submit();
	}
	
//console.log(${ni})
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
<body  class="body_overflow">
	
<input id="webUrls" type="hidden" value="${webUrls}" >
	<input id="rid"  type="hidden" value="${rid}" >
	<c:choose>
		
		
		<c:when test="${type==3}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${Companyconfig.companyName}污染物月报表</span></p>
		
		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	
			<form  action="../pollutant/pollutantList?rid=${rid}&type=3"  id="myform" name="myform" method="post">
		    <span class="heard_font14">选择月份： </span><input id="dateType" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM'})">
			<input name="search" class="btn-big" onclick="findReport3();" type="submit" value="查 询" />
			<input name="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
			<input id="btn"class="btn-big" type="button" style="float: right;"value="导出Excle"/>
			 <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
			</form>
		</c:when>
		
		<c:when test="${type==6}">
		<p class="f14style" ><span id="com_name" class="f14 text-title">${Companyconfig.companyName}污染物年报表</span></p>
			
		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
		
			<form action="../pollutant/pollutantList?rid=${rid}&type=6" id="myform" name="myform" method="post">
		 <span class="heard_font14">选择年份： </span><input id="dateType" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY'})">
			<input name="search" class="btn-big"  type="submit"onclick="findReport6();" value="查 询" />
			<input name="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
			<input id="btn"class="btn-big" type="button" style="float: right;"value="导出Excle"/>
			 <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
			</form>  
		</c:when>
		
		<c:when test="${type==5}">
		<p class="f14style" ><span id="com_name" class="f14 text-title">${Companyconfig.companyName}污染物自定义报表</span></p>
			
		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
			<form action="../pollutant/pollutantList?rid=${rid}&type=5" id="myform" name="myform" method="post">
			<span class="heard_font14">开始时间：</span><input id="startingTime" name="startingTime" value="${sTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
		<span class="heard_font14">结束时间：</span><input id="endTime" name="endTime" value="${eTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
				<input name="search" class="btn-big"  type="submit"onclick="findReport5();" value="查 询" />
				<input name="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
				<input id="btn"class="btn-big" type="button" style="float: right;"value="导出Excle"/>
			 <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
			</form>
		</c:when>
	</c:choose>
	
	
 	
		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	<div class="table2excel bluestrip"id="pdf">
	
	<table border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" style="border-collapse:collapse;" >
			<thead>
					<tr id="tra"   class="tb_heard_font16">
						<th rowspan="2">类型</th>
						<th rowspan="2">时间</th>
						<c:if test="${num1>0}">
						<th colspan="${num1}">一类污染物</th>
						</c:if>
						<c:if test="${num2>0}">
						<th colspan="${num2}">二类污染物</th>
						</c:if>
					</tr>
					
					<tr   class="tb_heard_font16">
					 <c:forEach items="${data_name3}" var="bean">
						 <td  align="center" >${bean.pollType}</td>
						 </c:forEach>
						
						
					</tr>
			</thead>
			<tbody>
			
				 <tr   class="tb_font15">
				 <td align="center"  style="font-family:Microsoft YaHei;font-size: 15;">污染物总量(kg)</td>
				 <c:if test="${type==5}">
				 <td align="center" style="font-family: 楷体;font-size: 15;">${sTime}  -<br> ${eTime}</td>
				 </c:if>
				 <c:if test="${type!=5}">
				 <td align="center" style="font-family: 楷体;font-size: 15;">${dateTypes}</td>
				 </c:if>
				 <c:if test="${rid == 75506330001 }">
					<td align="center"><fmt:formatNumber type="number" value="${cr6}" pattern="0.0000"/></td>
			
				    <td align="center"><fmt:formatNumber type="number" value="${cod}" pattern="0.00"/></td>
				     <td align="center"><fmt:formatNumber type="number" value="${phosphor}" pattern="0.000" /></td>
				 	 
				 	  			</c:if>
				 	  			 <c:if test="${rid == 75506330002 }">
				    <td align="center"><fmt:formatNumber type="number" value="${cod}" pattern="0.00"/></td>
				     <td align="center"><fmt:formatNumber type="number" value="${phosphor}" pattern="0.000" /></td>
				 	 
				 	  			</c:if>
				 	  			 <c:if test="${rid == 75506330003 }">
				    <td align="center"><fmt:formatNumber type="number" value="${cod}" pattern="0.00"/></td>
				     <td align="center"><fmt:formatNumber type="number" value="${phosphor}" pattern="0.000" /></td>
				 	 
				 	  			</c:if>
				 	  			
				 	  			
				 	  			 <c:if test="${rid == 75501330022 }">
				 	  			     <td align="center"><fmt:formatNumber type="number" value="${ni}" pattern="0.00"/></td>
				   <td align="center"><fmt:formatNumber type="number" value="${cod}" pattern="0.00"/></td>
				     <td align="center"><fmt:formatNumber type="number" value="${cu}" pattern="0.000" /></td>
				 	 
				 	  			</c:if>
				 	  			 <c:if test="${rid == 75501330023 }">
				    <td align="center"><fmt:formatNumber type="number" value="${ni}" pattern="0.00"/></td>
				   <td align="center"><fmt:formatNumber type="number" value="${cod}" pattern="0.00"/></td>
				     <td align="center"><fmt:formatNumber type="number" value="${cu}" pattern="0.000" /></td>
				 	 
				 	  			</c:if>
				 	  			 <c:if test="${rid == 75501330024 }">
				  <td align="center"><fmt:formatNumber type="number" value="${ni}" pattern="0.00"/></td>
				   <td align="center"><fmt:formatNumber type="number" value="${cod}" pattern="0.00"/></td>
				      <td align="center"><fmt:formatNumber type="number" value="${cu}" pattern="0.000" /></td>
				 	 
				 	  			</c:if>
				 	  			 <c:if test="${rid == 75501330025 }">
				   <td align="center"><fmt:formatNumber type="number" value="${ni}" pattern="0.00"/></td>
				   <td align="center"><fmt:formatNumber type="number" value="${cod}" pattern="0.00"/></td>
				      <td align="center"><fmt:formatNumber type="number" value="${cu}" pattern="0.000" /></td>
				 	 
				 	  			</c:if>
				 	  			 <c:if test="${rid == 75501330026 }">
				    <td align="center"><fmt:formatNumber type="number" value="${ni}" pattern="0.00"/></td>
				   <td align="center"><fmt:formatNumber type="number" value="${cod}" pattern="0.00"/></td>
				      <td align="center"><fmt:formatNumber type="number" value="${cu}" pattern="0.000" /></td>
				 	 
				 	  			</c:if>
				 	  			
				 	  			
				 	  			
				 	  			
				 	  			
					<c:if test="${rid == 75501330001 }">
					<td align="center"><fmt:formatNumber type="number" value="${cr6}" pattern="0.0000"/></td>
			
				    <td align="center"><fmt:formatNumber type="number" value="${ni}" pattern="0.00"/></td>
				    <td align="center"><fmt:formatNumber type="number" value="${cod}" pattern="0.00"/></td>
				    <%--  <td align="center"><fmt:formatNumber type="number" value="${phosphor}" pattern="0.000" /></td>
				 	 --%>
				 	   <td align="center"><fmt:formatNumber type="number" value="${mlss}" pattern="0.00"/></td>
				 	 
				     <td align="center"><fmt:formatNumber type="number" value="${nh4}" pattern="0.000"/></td>
				 					</c:if>
				 						<c:if test="${rid == 75501330002 }">
					<td align="center"><fmt:formatNumber type="number" value="${cr6}" pattern="0.0000"/></td>
			
				    <td align="center"><fmt:formatNumber type="number" value="${ni}" pattern="0.00"/></td>
				    <td align="center"><fmt:formatNumber type="number" value="${cod}" pattern="0.00"/></td>
				    <%--  <td align="center"><fmt:formatNumber type="number" value="${phosphor}" pattern="0.000" /></td>
				 	 --%>
				 	   <td align="center"><fmt:formatNumber type="number" value="${mlss}" pattern="0.00"/></td>
				 	 
				     <td align="center"><fmt:formatNumber type="number" value="${nh4}" pattern="0.000"/></td>
				 					</c:if>
					
						<c:if test="${rid == 75501330003 }">
					<td align="center">-</td>
			
				 					</c:if>
						<c:if test="${rid == 75501330004 }">
					<td align="center"><fmt:formatNumber type="number" value="${cr6}" pattern="0.0000"/></td>
			
				    <td align="center"><fmt:formatNumber type="number" value="${cod}" pattern="0.00"/></td>
				     <td align="center"><fmt:formatNumber type="number" value="${mlss}" pattern="0.00"/></td>
				    <td align="center"><fmt:formatNumber type="number" value="${phosphor}" pattern="0.000" /></td>
				 	 
				 	 
				 					</c:if>
					<c:if test="${rid == 75501330008 }">
					<td align="center"><fmt:formatNumber type="number" value="${ni}" pattern="0.0000"/></td>
			
				   <%--  <td align="center"><fmt:formatNumber type="number" value="${mlss}" pattern="0.00"/></td> --%>
				     <td align="center"><fmt:formatNumber type="number" value="${phosphor}" pattern="0.000" /></td>
				  
				     <td align="center"><fmt:formatNumber type="number" value="${nh4}" pattern="0.000"/></td>
				       <td align="center"><fmt:formatNumber type="number" value="${cu}" pattern="0.00"/></td>
				   
				 					</c:if>
					
					<c:if test="${rid == 75501330009 }">
					<td align="center"><fmt:formatNumber type="number" value="${ni}" pattern="0.0000"/></td>
			
				    <%-- <td align="center"><fmt:formatNumber type="number" value="${mlss}" pattern="0.00"/></td> --%>
				    
				     <td align="center"><fmt:formatNumber type="number" value="${phosphor}" pattern="0.000" /></td>
				     <td align="center"><fmt:formatNumber type="number" value="${nh4}" pattern="0.000"/></td>
				     <td align="center"><fmt:formatNumber type="number" value="${zn}" pattern="0.00"/></td>
				 					</c:if>
				  <c:if test="${rid == 75501330010 }">
					<td align="center"><fmt:formatNumber type="number" value="${ni}" pattern="0.0000"/></td>
			
				<%--     <td align="center"><fmt:formatNumber type="number" value="${mlss}" pattern="0.00"/></td> --%>
				   
				     <td align="center"><fmt:formatNumber type="number" value="${phosphor}" pattern="0.000" /></td>
				     <td align="center"><fmt:formatNumber type="number" value="${nh4}" pattern="0.000"/></td>
				      <td align="center"><fmt:formatNumber type="number" value="${zn}" pattern="0.00"/></td>
				 					</c:if>
				  
				   
				  </tr>
			
				 <tr  class="tb_font15">
				 <td align="center"  style="font-family:Microsoft YaHei;font-size: 15;">污染物平均浓度(mg/l)</td>
				 <c:if test="${type==5}">
				 <td align="center"  >${sTime} -<br>  ${eTime}</td>
				 </c:if>
				 <c:if test="${type!=5}">
				 <td align="center"  >${dateTypes}</td>
				 </c:if>
				 
				 <c:if test="${rid == 75506330001 }">
					<td align="center"><fmt:formatNumber type="number" value="${cr6==0.0?0.0:cr6*1000/sub_ztraffic}" pattern="0.0000"/></td>
			
				    <td align="center"><fmt:formatNumber type="number" value="${cod==0.0?0.0:cod*1000/sub_ztraffic}" pattern="0.00"/></td>
				      <td align="center"><fmt:formatNumber type="number" value="${phosphor==0.0?0.0:phosphor*1000/sub_ztraffic}" pattern="0.000" /></td>
				 				
				 					
				 					</c:if>
				 	 <c:if test="${rid == 75506330002 }">
				    <td align="center"><fmt:formatNumber type="number" value="${cod==0.0?0.0:cod*1000/sub_ztraffic}" pattern="0.00"/></td>
				      <td align="center"><fmt:formatNumber type="number" value="${phosphor==0.0?0.0:phosphor*1000/sub_ztraffic}" pattern="0.000" /></td>
				 				
				 					
				 					</c:if>
				  <c:if test="${rid == 75506330003}">
				    <td align="center"><fmt:formatNumber type="number" value="${cod==0.0?0.0:cod*1000/sub_ztraffic}" pattern="0.00"/></td>
				    
				      <td align="center"><fmt:formatNumber type="number" value="${phosphor==0.0?0.0:phosphor*1000/sub_ztraffic}" pattern="0.000" /></td>
				 				
				 					
				 					</c:if>
				 
				 
				 	
				 	  			 <c:if test="${rid == 75501330022 }">
				 	  			   <td align="center"><fmt:formatNumber type="number" value="${ni==0.0?0.0:ni*1000/sub_ztraffic}" pattern="0.00"/></td>
				   <td align="center"><fmt:formatNumber type="number" value="${cod==0.0?0.0:cod*1000/sub_ztraffic}" pattern="0.00"/></td>
				       <td align="center"><fmt:formatNumber type="number" value="${cu==0.0?0.0:cu*1000/sub_ztraffic}" pattern="0.00"/></td>
				 	
				 	  			</c:if>
				 	  			 <c:if test="${rid == 75501330023 }">
				   <td align="center"><fmt:formatNumber type="number" value="${ni==0.0?0.0:ni*1000/sub_ztraffic}" pattern="0.00"/></td>
				   <td align="center"><fmt:formatNumber type="number" value="${cod==0.0?0.0:cod*1000/sub_ztraffic}" pattern="0.00"/></td>
				       <td align="center"><fmt:formatNumber type="number" value="${cu==0.0?0.0:cu*1000/sub_ztraffic}" pattern="0.00"/></td>
				 	 
				 	  			</c:if>
				 	  			 <c:if test="${rid == 75501330024 }">
				   <td align="center"><fmt:formatNumber type="number" value="${ni==0.0?0.0:ni*1000/sub_ztraffic}" pattern="0.00"/></td>
				   <td align="center"><fmt:formatNumber type="number" value="${cod==0.0?0.0:cod*1000/sub_ztraffic}" pattern="0.00"/></td>
				       <td align="center"><fmt:formatNumber type="number" value="${cu==0.0?0.0:cu*1000/sub_ztraffic}" pattern="0.00"/></td>
				 	 
				 	  			</c:if>
				 	  			 <c:if test="${rid == 75501330025 }">
				  <td align="center"><fmt:formatNumber type="number" value="${ni==0.0?0.0:ni*1000/sub_ztraffic}" pattern="0.00"/></td>
				   <td align="center"><fmt:formatNumber type="number" value="${cod==0.0?0.0:cod*1000/sub_ztraffic}" pattern="0.00"/></td>
				       <td align="center"><fmt:formatNumber type="number" value="${cu==0.0?0.0:cu*1000/sub_ztraffic}" pattern="0.00"/></td>
				 	 
				 	  			</c:if>
				 	  			 <c:if test="${rid == 75501330026 }">
				   <td align="center"><fmt:formatNumber type="number" value="${ni==0.0?0.0:ni*1000/sub_ztraffic}" pattern="0.00"/></td>
				   <td align="center"><fmt:formatNumber type="number" value="${cod==0.0?0.0:cod*1000/sub_ztraffic}" pattern="0.00"/></td>
				       <td align="center"><fmt:formatNumber type="number" value="${cu==0.0?0.0:cu*1000/sub_ztraffic}" pattern="0.00"/></td>
				 	 
				 	  			</c:if>
				 	  	
				 
				 
				 
				 
				 
					<c:if test="${rid == 75501330001 }">
					<td align="center"><fmt:formatNumber type="number" value="${cr6==0.0?0.0:cr6*1000/sub_ztraffic}" pattern="0.0000"/></td>
			
				    <td align="center"><fmt:formatNumber type="number" value="${ni==0.0?0.0:ni*1000/sub_ztraffic}" pattern="0.00"/></td>
				    <td align="center"><fmt:formatNumber type="number" value="${cod==0.0?0.0:cod*1000/sub_ztraffic}" pattern="0.00"/></td>
				    <%--  <td align="center"><fmt:formatNumber type="number" value="${phosphor}" pattern="0.000" /></td>
				 	 --%>
				 	   <td align="center"><fmt:formatNumber type="number" value="${mlss==0.0?0.0:mlss*1000/sub_ztraffic}" pattern="0.00"/></td>
				 	 
				     <td align="center"><fmt:formatNumber type="number" value="${nh4==0.0?0.0:nh4*1000/sub_ztraffic}" pattern="0.000"/></td>
				 					</c:if>
				 						<c:if test="${rid == 75501330002 }">
					<td align="center"><fmt:formatNumber type="number" value="${cr6==0.0?0.0:cr6*1000/sub_ztraffic}" pattern="0.0000"/></td>
			
				    <td align="center"><fmt:formatNumber type="number" value="${ni==0.0?0.0:ni*1000/sub_ztraffic}" pattern="0.00"/></td>
				    <td align="center"><fmt:formatNumber type="number" value="${cod==0.0?0.0:cod*1000/sub_ztraffic}" pattern="0.00"/></td>
				    <%--  <td align="center"><fmt:formatNumber type="number" value="${phosphor}" pattern="0.000" /></td>
				 	 --%>
				 	   <td align="center"><fmt:formatNumber type="number" value="${mlss==0.0?0.0:mlss*1000/sub_ztraffic}" pattern="0.00"/></td>
				 	 
				     <td align="center"><fmt:formatNumber type="number" value="${nh4==0.0?0.0:nh4*1000/sub_ztraffic}" pattern="0.000"/></td>
				 					</c:if>
					
						<c:if test="${rid == 75501330003 }">
					<td align="center">-</td>
			
				 					</c:if>
						<c:if test="${rid == 75501330004 }">
					<td align="center"><fmt:formatNumber type="number" value="${cr6==0.0?0.0:cr6*1000/sub_ztraffic}" pattern="0.0000"/></td>
			
				    <td align="center"><fmt:formatNumber type="number" value="${cod==0.0?0.0:cod*1000/sub_ztraffic}" pattern="0.00"/></td>
				     <td align="center"><fmt:formatNumber type="number" value="${mlss==0.0?0.0:mlss*1000/sub_ztraffic}" pattern="0.00"/></td>
				    <td align="center"><fmt:formatNumber type="number" value="${phosphor==0.0?0.0:phosphor*1000/sub_ztraffic}" pattern="0.000" /></td>
				 	 
				 	 
				 					</c:if>
					<c:if test="${rid == 75501330008 }">
					<td align="center"><fmt:formatNumber type="number" value="${ni==0.0?0.0:ni*1000/sub_ztraffic}" pattern="0.0000"/></td>
			
				    <%-- <td align="center"><fmt:formatNumber type="number" value="${mlss*1000/sub_ztraffic}" pattern="0.00"/></td> --%>
				   
				     <td align="center"><fmt:formatNumber type="number" value="${phosphor==0.0?0.0:phosphor*1000/sub_ztraffic}" pattern="0.000" /></td>
				     <td align="center"><fmt:formatNumber type="number" value="${nh4==0.0?0.0:nh4*1000/sub_ztraffic}" pattern="0.000"/></td>
				      <td align="center"><fmt:formatNumber type="number" value="${cu==0.0?0.0:cu*1000/sub_ztraffic}" pattern="0.00"/></td>
				 					
				 					</c:if>
					
					<c:if test="${rid == 75501330009 }">
					<td align="center"><fmt:formatNumber type="number" value="${ni==0.0?0.0:ni*1000/sub_ztraffic}" pattern="0.0000"/></td>
			
				   <%--  <td align="center"><fmt:formatNumber type="number" value="${mlss*1000/sub_ztraffic}" pattern="0.00"/></td>
				    --%>
				    
				     <td align="center"><fmt:formatNumber type="number" value="${phosphor==0.0?0.0:phosphor*1000/sub_ztraffic}" pattern="0.000" /></td>
				     <td align="center"><fmt:formatNumber type="number" value="${nh4==0.0?0.0:nh4*1000/sub_ztraffic}" pattern="0.000"/></td>
				 		<td align="center"><fmt:formatNumber type="number" value="${zn==0.0?0.0:zn*1000/sub_ztraffic}" pattern="0.00"/></td>
				    	
				 					</c:if>
				  <c:if test="${rid == 75501330010 }">
					<td align="center"><fmt:formatNumber type="number" value="${ni==0.0?0.0:ni*1000/sub_ztraffic}" pattern="0.0000"/></td>
			
				   <%--  <td align="center"><fmt:formatNumber type="number" value="${mlss==0.0?0.0:phosphor*1000/sub_ztraffic}" pattern="0.00"/></td>
				    --%>
				  
				     <td align="center"><fmt:formatNumber type="number" value="${phosphor==0.0?0.0:phosphor*1000/sub_ztraffic}" pattern="0.000" /></td>
				     <td align="center"><fmt:formatNumber type="number" value="${nh4==0.0?0.0:nh4*1000/sub_ztraffic}" pattern="0.000"/></td>
				 	
				 	  <td align="center"><fmt:formatNumber type="number" value="${zn==0.0?0.0:zn*1000/sub_ztraffic}" pattern="0.00"/></td>
				   				</c:if>
				  
					
				  </tr>
		
			</tbody>
	</table>
	</div>
			<!--<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	--></div>
	<%--<div style="with:100%;height:30px;  background: url(${ctx}/resources/lrtk/images/foot.png) no-repeat center;"></div> 

--%><script src="${ctx}/resources/js/jquery.table2excel.js"></script>
<script>
		$(function() {
			var name1=$("#com_name").text();
			$("#btn").click(function(){
				$(".table2excel").table2excel({
					exclude: ".noExl",
					name: "Excel Document Name",
					filename: name1,
					exclude_img: true,
					exclude_links: true,
					exclude_inputs: true
				});
			});
			
		});
	</script>	
</body>

</html>
