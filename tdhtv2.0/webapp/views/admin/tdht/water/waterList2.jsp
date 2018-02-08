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
<script src="${ctx}/resources/laydate/laydate.js"></script>
<script type="text/javascript" src="http://www.xdocin.com/xdoc.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/pdf.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/ajaxpdf.js"></script>
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

<title>水量报表</title>
<style type="text/css">
table{
width:100%
}
</style>
<script type="text/javascript">

</script>
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
		  var optss = document.getElementById("timeSpace");
		var minates=$("#select").val();  
		//console.log(optss)
		if(minates!=""&&optss!=null){
	 for(var i=0;i<3;i++){
           if(minates==optss.options[i].value){
                  optss.options[i].selected = 'selected';
                    break;
             }
          }
         }
		window.parent.startaa();  
	});
</script>

<script type="text/javascript">
	
	
	//查询
	function findReport(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../reportForm/reportFormList";
		document.myform.submit();
	}

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
<input id="type" type="hidden" value="${type}" >	
<input id="rid" type="hidden" value="${rid}" >
	<c:choose>
		<c:when test="${type==1}">
			<p class="f14style" ><span id="com_name" class="f14 text-title">${Companyconfig.companyName}水量日报表</span></p>
			<form action="../waterForm/waterFormList?rid=${rid}&type=1" id="myform" name="myform" method="post">
			选择日期：<input id="dateType" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
			<input name="search" class="btn-big"  type="submit" value="查询" />
			<input name="search" class="btn-big" onclick="cls();" type="button" value="清空" />
			<input id="btn"class="btn-big" type="button" style="float: right;"value="导出Excle"/>
			 <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
			</form>
		</c:when>
		
		<c:when test="${type==3}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${Companyconfig.companyName}水量月报表</span></p>
			<form  action="../waterForm/waterFormList?rid=${rid}&type=3"  id="myform" name="myform" method="post">
			选择月份：<input id="dateType" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM'})">
			<input name="search" class="btn-big"  type="submit" value="查询" />
			<input name="search" class="btn-big" onclick="cls();" type="button" value="清空" />
			<input id="btn"class="btn-big" type="button"style="float: right;" value="导出Excle"/>
			<input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
			</form>
		</c:when>
		
		<c:when test="${type==6}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${Companyconfig.companyName}水量年报表</span></p>
			<form action="../waterForm/waterFormList?rid=${rid}&type=6" id="myform" name="myform" method="post">
			选择年份：<input id="dateType" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY'})">
			<input name="search" class="btn-big"  type="submit" value="查询" />
			<input name="search" class="btn-big" onclick="cls();" type="button" value="清空" />
			<input id="btn"class="btn-big" type="button" style="float: right;"value="导出Excle"/>
			<input id="btn"class="btn-big" type="button"style="float: right;" onclick="pdf()"value="导出pdf"/>
			</form>  
		</c:when>
		
		<c:when test="${type==5}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${Companyconfig.companyName}水量自定义报表</span></p>
			<form action="../waterForm/waterFormList?rid=${rid}&type=5" id="myform" name="myform" method="post">
				<span class="heard_font14">开始时间：</span><input id="startingTime" name="startingTime" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
				<span class="heard_font14">结束时间：</span>	<input  id="endTime" name="endTime" value="${eTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
				<input name="search" class="btn-big"  type="submit" value="查询" />
				<input name="search" class="btn-big" onclick="cls();" type="button" value="清空" />
				<input id="btn" class="btn-big" type="button"style="float: right;" value="导出Excle"/>
				<input id="btn"class="btn-big" type="button"style="float: right;" onclick="pdf()"value="导出pdf"/>
				</form>
		</c:when>
		
		<c:when test="${type==11}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${Companyconfig.companyName}水量历史报表</span></p>
		<input id="select" type="hidden" value="${minates}" >
			<form action="../waterForm/waterFormList?rid=${rid}&type=11" id="myform" name="myform" method="post">
			<div style="background-color:#ffffff;width:100%;height:5px;"></div>
				 <span class="heard_font14">开始时间：</span><input id="startingTime" name="startingTime" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
				<span class="heard_font14">结束时间：</span><input  id="endTime" name="endTime" value="${eTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
				<span class="heard_font14">时间间隔(/分钟)： </span>	 <select id="timeSpace"name="minates"> <option  value ="5">5分钟</option>    <option value ="30">30分钟</option>  <option value="60">1小时</option> </select>
				<input name="search" class="btn-big"  type="submit" value="查询" />
				<input name="search" class="btn-big" onclick="cls();" type="button" value="清空" />
				<input id="btn" class="btn-big" type="button"style="float: right;" value="导出Excle"/>
				 <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
				 </form>
		</c:when>
	</c:choose>
	
	<table border="0" cellspacing="0" cellpadding="0" class="table-list" id="table"  >
			<thead>
			<c:choose>
		
			<c:when test="${type==11}">
					  <tr class="tb_heard_font16">
					    <td  width='100px' align="center" rowspan="2" >时间</td>
					    <td  width='500px' align="center" colspan='4' >排水口</td>
					    <%--<td  align="center" style="font-family: 黑体;font-size: 16;">损耗值</td>
					    <td  align="center"  style="font-family: 黑体;font-size: 16;">不明工业排水</td>
					 --%></tr>
					 <tr class="tb_heard_font15">
					    <td  align="center">水位(m)</td>
					    <td  align="center">流速(m/s)</td>
					    <td  align="center">流量速率(m<sup>3</sup>/s)</td>
					    
					    <td  align="center">总流量(m<sup>3</sup>)</td>
					    <%--<td  align="center">总流量(m<sup>3</sup>)</td>
					 --%></tr>
			</c:when>
			</c:choose>
		</thead>
		<tbody>
		<c:choose>
		<c:when test="${type==11}">
		<c:forEach items="${water}" var="bean">
		 <tr class="tb_font15">
			<td  align="center" style="font-family: 楷体;font-size: 15;"><div class="td-space"><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td  align="center"><fmt:formatNumber type="number" value="${bean.tabWaterLevelID1}" pattern="0.00"/></td>
		    <td  align="center"><fmt:formatNumber type="number" value="${bean.tabCurrentSpeedID1}" pattern="0.00"/></td>
		    <td  align="center"><fmt:formatNumber type="number" value="${bean.tabTrafficID1}" pattern="0.00"/></td>
		    <td  align="center"><fmt:formatNumber type="number" value="${bean.tabZtrafficID1}" pattern="0.00"/></td>
		    <%--<td  align="center"><fmt:formatNumber type="number" value="${bean.wastage}" pattern="0.00"/></td>
		    <td  align="center"><fmt:formatNumber type="number" value="${bean.unknown}" pattern="0.00"/></td>
		  --%></tr>
		</c:forEach>
	
		</c:when>
		
		
	</c:choose>
	</tbody>	
	</table>
	<div id="pdf"class="table2excel bluestrip" style="display:none" >
	<table border="0" cellspacing="0" cellpadding="0" class="table-list" id="table_pdf" >
			<thead id="thead">
					  
			
		</thead>
		<tbody id="tr">
		
		 
		
	</tbody>	
	</table>
	</div>
	<div id="pagelist">
		<ul style="list-style:none;">
			<pg:pager items="${pager.rowCount}"
			export="currentPageNumber=pageNumber" maxPageItems="${pager.pageSize }" maxIndexPages="5" url="../waterForm/waterFormList" >
			<!-- 分页带查询条件 -->
			<pg:param name="startingTime" value="${sTime}"/>
			<pg:param name="endTime" value="${eTime}"/>
			<pg:param name="rid" value="${rid}"/>
			<pg:param name="type" value="${type}"/> 
			<pg:param name="dateTypes" value="${dateTypes}"/>
			<pg:param name="minates" value="${minates}"/>
				<!-- 首页 -->
				<pg:first>
					<li style="list-style:none;"><a href="${pageUrl }" class="page_btn">首页</a></li>
				</pg:first>
				<pg:prev>
					<li style="list-style:none;"><a href="${pageUrl }" class="page_btn">前一页</a></li>
				</pg:prev>
				<pg:pages>
					<c:choose>
						<c:when test="${currentPageNumber eq pageNumber }">
							<li class="page_btn_s">${pageNumber }</li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl }" class="page_btn">${pageNumber }</a></li>
						</c:otherwise>
					</c:choose>
				</pg:pages>
				<pg:next>
					<li style="list-style:none;"><a href="${pageUrl }" class="page_btn">后一页</a></li>
				</pg:next>
				<pg:last>
					<li style="list-style:none;"><a href="${pageUrl }" class="page_btn">尾页</a></li>
				</pg:last>
		    <li class="page_text">共${pager.pageCount}页</li>
		    <li class="page_text">共${pager.rowCount}条记录</li>
			</pg:pager>
  		</ul>
	</div>
	
<!--<div style="with:100%;height:30px;  background: url(${ctx}/resources/lrtk/images/foot.png) no-repeat center;"></div> 



--><script src="${ctx}/resources/js/jquery.table2excel.js"></script>
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
			data_pdf();
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