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
<script src="${ctx}/resources/laydate/laydate.js"></script>
<script type="text/javascript" src="http://www.xdocin.com/xdoc.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/pdf.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/pdflog.js"></script>
<style type="text/css">
.thh{
width:15%
}
.thhh{
width:30%
}
table{
width:100%
}
</style>
<!--[if IE 9]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if IE 8]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if  IE 7]>
<link href="${ctx}/resources/css/ie7.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<title>用户登录信息</title>
<script type="text/javascript">
	
	
	//查询
	function findReport(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../feedback/findUserLogin";
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
<body>
<input id="webUrls" type="hidden" value="${webUrls}" >

	<p class="f14style"><span class="f14 text-title">登录信息</span></p>
		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	<form action="../feedback/findUserLogin" id="myform" name="myform" method="post">
	  <span class="heard_font14">用户名：</span> <input type="text"  id=""  name="account"  value="${account}"  />
	 <span class="heard_font14">开始时间：</span><input id="startingTime" name="startingTime" value="${sTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	 <span class="heard_font14">结束时间：</span><input id="endTime" name="endTime" value="${eTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	<input name="search" class="btn-big"  type="submit" value="查 询" />
	<input name="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
	</form>  
 
	<div  class="bluestrip" >
	<table width="100%"  border="0" cellspacing="0" cellpadding="0"   class="table-list" id="table" >
			<thead>
					<tr  class="tb_heard_font16">
						<th width="15%" align="center">用户名</th>
						<th width="15%" align="center">IP</th>
						<th width="15%" align="center">登录时间</th>
					</tr>
			</thead>
		<tbody style="font-family: Arial">
		<c:forEach items="${userLogins}" var="bean">
			<tr  class="tb_font15">
				<td width="120"  align="center">${bean.account}</td>
				<td width="120" align="center" style="font-family:Microsoft YaHei;">${bean.ip}</td>
				<td width="100" align="center"><fmt:formatDate value="${bean.create_date }" pattern="yyyy-MM-dd  HH:mm:ss"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	<div id="pagelist">
		<ul style="list-style:none;">
			<pg:pager items="${pager.rowCount}"
			export="currentPageNumber=pageNumber" maxPageItems="${pager.pageSize }" maxIndexPages="5" url="../feedback/findUserLogin" >
			<!-- 分页带查询条件 -->
			<pg:param name="startingTime" value="${sTime}"/>
			<pg:param name="endTime" value="${eTime}"/>
			<pg:param name="rid" value="${rid}"/>
			<pg:param name="account" value="${account}"/>
			
				<!-- 首页 -->
				<pg:first>
					<li style="list-style:none;"><a href="${pageUrl }"  class="page_btn">首页</a></li>
				</pg:first>
				<pg:prev>
					<li style="list-style:none;"><a href="${pageUrl }"   class="page_btn">前一页</a></li>
				</pg:prev>
				<pg:pages>
					<c:choose>
						<c:when test="${currentPageNumber eq pageNumber }">
							<li  class="page_btn_s">${pageNumber }</li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl }"  class="page_btn">${pageNumber }</a></li>
						</c:otherwise>
					</c:choose>
				</pg:pages>
				<pg:next>
					<li style="list-style:none;"><a href="${pageUrl }"   class="page_btn">后一页</a></li>
				</pg:next>
				<pg:last>
					<li style="list-style:none;"><a href="${pageUrl }"   class="page_btn">尾页</a></li>
				</pg:last>
		    <li style="list-style:none;color:#555;"  class="page_text">共${pager.pageCount}页</li>
		    <li style="list-style:none;color:#555;"  class="page_text">共${pager.rowCount}条记录</li>
			</pg:pager>
  		</ul>
	</div>
		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	</div>



</body>

</html>