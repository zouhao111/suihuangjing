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
<link href="${ctx}/resources/css/pager.css"	type="text/css" rel="stylesheet" />

<title>历史报表</title>
<style>
.table-list td{
border-right:1px solid #c1c8d2;
}
</style>
<script type="text/javascript">
	
	
	$(document).ready(function () {
		
		 $("tr:even").addClass("over");
		  //$("tr:odd").addClass("over");
		  //点击变色  
		  $("#table tbody tr").toggle(
			   function(){
			    $(this).addClass("focus");
			    
			    //alert($(this).find(":checkbox").attr("checked"));
			    
			   // if(!$(this).find(":checkbox").attr("checked")){
			    	$(this).find(":checkbox").attr("checked",true);
			   // }
			    //$(this).find(":checkbox").attr("checked", !$(this).find(":checkbox").attr("checked"));  
			   },function (){
			   $(this).removeClass("focus");
			  	$(this).find(":checkbox").attr("checked",false);
			   //$(this).find(":checkbox").attr("checked", !$(this).find(":checkbox").attr("checked"));  
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
	
	
	//查询
	function findReport(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../historyReport/historyReportList";
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
<input id="rid" type="hidden" value="${rid}" >
<input id="webUrls" type="hidden" value="${webUrls}" >
	<form id="myform" name="myform" method="post">
	<p style="padding:4px 5px 9px; height:16px;line-height:16px;"><strong class="f14 text-title">历史表报</strong></p>
	开始时间：<input type="text" id="startingTime" name="startingTime" value="${sTime}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:200px"/>
	结束时间：<input type="text" id="endTime" name="endTime" value="${eTime}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="Wdate" style="width:200px"/>
	时间间隔(/分钟)<input type="text" name="minates" value="${minates} ">
	<input name="search" class="btn-big" onclick="findReport();" type="button" value="查询" />
	<input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	</form>

	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead >
					<tr>
    					<td width="100%" align="center"" colspan="11"><div class="td-space" style="font-size: 14px;">永艺发公司给排数据日报表</div></td>
  					</tr>
					  <tr>
					    <td width="200" align="center" rowspan="2" style="background-color: #f3f3f3"><div class="td-space">时间</div></td>
					    <td width="80" align="center" style="background-color: #f3f3f3"><div class="td-space">给水①工业</div></td>
					    <td width="80" align="center" style="background-color: #f3f3f3"><div class="td-space">给水②生活</div></td>
					    <td width="160" align="center" colspan="6" style="background-color: #f3f3f3"><div class="td-space">工业排水</div></td>
					    <td width="80" align="center" style="background-color: #f3f3f3"><div class="td-space">标准生活用水</div></td>
					    <td width="80" align="center" style="background-color: #f3f3f3"><div class="td-space">不明用水量</div></td>
					 </tr>
					 <tr>
					    <td width="80" align="center"><div class="td-space">总流量</div></td>
					    <td width="80" align="center"><div class="td-space">总流量</div></td>
					    <td width="60" align="center"><div class="td-space">水位</div></td>
					    <td width="60" align="center"><div class="td-space">流速</div></td>
					    <td width="60" align="center"><div class="td-space">流量速率</div></td>
					    <td width="60" align="center"><div class="td-space">温度</div></td>
					    <td width="60" align="center"><div class="td-space">总流量</div></td>
					    <td width="60" align="center"><div class="td-space">PH</div></td>
					    <td width="80" align="center"><div class="td-space">总流量</div></td>
					    <td width="80" align="center"><div class="td-space">总流量</div></td>
					 </tr>
			</thead>
		<tbody>
		<c:forEach items="${historyReports}" var="bean">
		 <tr>
			<td width="200" align="center"><div class="td-space"><fmt:formatDate value="${bean.sytime}" pattern="yyyy-MM-dd HH:mm:ss"/></div></td>
			<td width="80" align="center"><div class="td-space">${bean.ztraffic_a2}</div></td>
		    <td width="80" align="center"><div class="td-space">${bean.ztraffic_a3}</div></td>
		    <td width="80" align="center"><div class="td-space"><fmt:formatNumber type="number" value="${bean.waterlevel}" maxFractionDigits="4"/></div></td>
		    <td width="80" align="center"><div class="td-space">${bean.currentSpeed}</div></td>
		    <td width="80" align="center"><div class="td-space">${bean.traffic}</div></td>
		    <td width="80" align="center"><div class="td-space">${bean.temperature}</div></td>
		    <td width="80" align="center"><div class="td-space">${bean.ztraffic_a3}</div></td>
		    <td width="80" align="center"><div class="td-space">${bean.ph}</div></td>
		    <td width="80" align="center"><div class="td-space"><fmt:formatNumber type="number" value="${bean.standard}" maxFractionDigits="2"/></div></td>
		    <td width="80" align="center"><div class="td-space"><fmt:formatNumber type="number" value="${bean.unkonwn}" maxFractionDigits="2"/></div></td>
		  </tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div id="pagelist">
		<ul style="list-style:none;">
			<pg:pager items="${pager.rowCount}"
			export="currentPageNumber=pageNumber" maxPageItems="${pager.pageSize }" maxIndexPages="5" url="../historyReport/historyReportList" >
			<!-- 分页带查询条件 -->
			<pg:param name="startingTime" value="${sTime}"/>
			<pg:param name="endTime" value="${eTime}"/>
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
	</div>
	
	<div id="btm-bar" class="list-btm-bar"></div>

</body>
<script type="text/javascript">
	document.onkeydown=function(event){
	    var e = event || window.event || arguments.callee.caller.arguments[0];
	    if(e && e.keyCode==27){ // 按 Esc 
	    	document.getElementById('popwin').style.display='none';
	    	document.getElementById('popwin2').style.display='none';
	    	document.getElementById('mask').style.display = 'none';
	    }
	}; 
</script>
</html>