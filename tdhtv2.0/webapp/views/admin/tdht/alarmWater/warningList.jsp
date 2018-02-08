<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />
<link rel="stylesheet" href="${ctx}/resources/ztree/css/demo.css" type="text/css">
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
<title>实时预警</title>

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

</head>
<body class="body_overflow">
<input id="webUrls" type="hidden" value="${webUrls}" >

	<p class="f14style" style="margin-bottom: 27px;"><span class="f14 text-title">${viewCompanyconfig.companyName}实时预警</span></p>
 
	<div class="table2excel bluestrip">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr class="tb_heard_font16">
						<th width="120" align="center">预警时间</th>
						<th width="120" align="center">监测单元名称</th>
						<th width="120" align="center">预警类型</th>
						<th width="100" align="center">预警值上限</th>
						<th width="100" align="center">预警值下限</th>
						<th width="100" align="center">预警值</th>
					</tr>
			</thead>
		<tbody>
		<c:forEach items="${alarms}" var="bean">
		    <c:choose>
				<c:when test="${bean.value != null}">
				
			<tr   class="tb_font15">
				<td width="120"  align="center"  ><fmt:formatDate value="${bean.strtime }" pattern="yyyy-MM-dd  HH:mm:ss"/></td>
				<td width="120" align="center"  style="font-family:Microsoft YaHei;">${bean.comName}</td>
				<td width="100" align="center"  style="font-family:Microsoft YaHei;">${bean.typeRemark}</td>
				<td width="100" align="center"><fmt:formatNumber type='number' value='${bean.limitH}' pattern="0.00"/></td>
				<c:choose>
				<c:when test="${bean.limitL == 0}">
				<td align="center" width="100">-</td>
				</c:when>
				<c:when test="${bean.limitL != 0}">
				<td width="100" align="center"><fmt:formatNumber type='number' value='${bean.limitL}' pattern="0.00"/></td>
				</c:when>
				</c:choose>
				<td width="100" align="center" style="background-color: yellow;"><fmt:formatNumber type='number' value='${bean.value }' pattern="0.00"/></td>
			</tr>
			</c:when></c:choose>
		</c:forEach>
		</tbody>
		</div>
	</table>
	</div>
 
	</div>
<%--<div style="with:100%;height:30px;  background: url(${ctx}/resources/lrtk/images/foot.png) no-repeat center;"></div> 

--%></body>

</html>