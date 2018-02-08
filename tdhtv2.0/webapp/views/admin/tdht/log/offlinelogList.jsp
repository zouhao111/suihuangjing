<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/resources/ztree/css/demo.css" type="text/css">
<link href="${ctx}/resources/css/pager.css"	type="text/css" rel="stylesheet" />
<script src="${ctx}/resources/laydate/laydate.js"></script>
<script type="text/javascript" src="http://www.xdocin.com/xdoc.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/pdf.js"></script>
<style type="text/css">
table tr td{
 width:120;
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
<title>设备日志</title>
<script type="text/javascript">
	
	//查询
	function findReport(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../log/logList";
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

	<p class="f14style" style="margin-bottom: 0px;padding-bottom: 15px;"><span id="com_name" class="f14 text-title">设备日志</span></p>
				<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	
	<form action="../log/offlineLogList?rid=${rid}" id="myform" name="myform" method="post">
	 <span class="heard_font14">监测单元： </span><input type="text"  id=""  name="companyName"  value="${companyName}"  />
	 <span class="heard_font14">控制器编号： </span><input type="text"  id=""  name="macId"  value="${macId}"  />
	 <span class="heard_font14">开始时间： </span><input id="startingTime" name="startingTime" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	<span class="heard_font14">结束时间：</span><input id="endTime" name="endTime" value="${eTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	<input name="search" class="btn-big"  type="submit" value="查 询" />
	<input name="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
	<input id="btn"class="btn-big" type="button" style="float: right;margin:0;"value="导出Excle"/>
			 <input id="btn"class="btn-big" type="button"style="float: right;margin:0;"onclick="pdf()" value="导出pdf"/>
	</form>  
 			<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	<div id="pdf" class="table2excel bluestrip">
	<table border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" style="border-collapse:collapse;" >
			<thead>
				<tr   class="tb_heard_font16">
					<th width="120"align="center">操作时间</th>
					<th width="120" align="center">监测单元</th>
					<th width="120"align="center">控制器编号</th>
					<th width="120" align="center">描述</th>
					<th width="120"align="center">控制器状态</th>
				</tr>
			</thead>
		<tbody id="table2">
		<c:forEach items="${log}" var="bean">
			<tr   class="tb_font15">
				<td  width="120"align="center"  ><fmt:formatDate value="${bean.strTime }" pattern="yyyy-MM-dd  HH:mm:ss"/></td>
				<td width="120" align="center"  style="font-family:Microsoft YaHei;">${bean.companyName}</td>
				<td width="120" align="center" >${bean.macId}</td>
				<td width="120"align="center">${bean.note}</td>
				<td width="120" align="center"  style="font-family:Microsoft YaHei;"><c:if test="${bean.bitOnline==0}">在线</c:if><c:if test="${bean.bitOnline==1}">离线</c:if></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	<div style="text-align: center;font-size: 15px;"><span  class="page_btn" id="spanFirst">首页</span> <span class="page_btn" id="spanPre">前一页</span> <span class="page_btn" id="spanNext">后一页</span> <span class="page_btn" id="spanLast">尾页</span> <span  class="page_text"> 第<span id="spanPageNum" ></span>页/共<span id="spanTotalPage"></span>页 </span></div>
	<%-- <div id="pagelist">
		<ul style="list-style:none;">
			<pg:pager items="${pager.rowCount}"
			export="currentPageNumber=pageNumber" maxPageItems="${pager.pageSize }" maxIndexPages="5" url="../log/offlineLogList" >
			<!-- 分页带查询条件 -->
			<pg:param name="startingTime" value="${sTime}"/>
			<pg:param name="endTime" value="${eTime}"/>
			<pg:param name="rid" value="${rid}"/>
			<pg:param name="companyName" value="${companyName}"/>
			
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
			<%--<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	--%></div>
<%--<div style="with:100%;height:30px;  background: url(${ctx}/resources/lrtk/images/foot.png) no-repeat center;"></div> 

--%></body>
<script src="${ctx}/resources/js/jquery.table2excel.js"></script>
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
</html>
<script>
     var theTable = document.getElementById("table2");
     var totalPage = document.getElementById("spanTotalPage");
     var pageNum = document.getElementById("spanPageNum");


     var spanPre = document.getElementById("spanPre");
     var spanNext = document.getElementById("spanNext");
     var spanFirst = document.getElementById("spanFirst");
     var spanLast = document.getElementById("spanLast");


     var numberRowsInTable = theTable.rows.length;
     var pageSize = 10;
     var page = 1;


     //下一页
     function next() {
         hideTable();
         currentRow = pageSize * page;
         maxRow = currentRow + pageSize;
         if (maxRow > numberRowsInTable) maxRow = numberRowsInTable;
         for (var i = currentRow; i < maxRow; i++) {
             theTable.rows[i].style.display = '';
         }
         page++;


         if (maxRow == numberRowsInTable) { nextText(); lastText(); }
         showPage();
         preLink();
         firstLink();
     }

     //上一页
     function pre() {

         hideTable();
         page--;
         currentRow = pageSize * page;
         maxRow = currentRow - pageSize;
         if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;
         for (var i = maxRow; i < currentRow; i++) {
             theTable.rows[i].style.display = '';
         }

         if (maxRow == 0) { preText(); firstText(); }
         showPage();
         nextLink();
         lastLink();
     }


     //第一页
     function first() {
         hideTable();
         page = 1;
         for (var i = 0; i < pageSize; i++) {
             theTable.rows[i].style.display = '';
         }
         showPage();


         preText();
         nextLink();
         lastLink();
     }


     //最后一页
     function last() {
         hideTable();
         page = pageCount();
         currentRow = pageSize * (page - 1);
         for (var i = currentRow; i < numberRowsInTable; i++) {
             theTable.rows[i].style.display = '';
         }
         showPage();


         preLink();
         nextText();
         firstLink();
     }


     function hideTable() {
         for (var i = 0; i < numberRowsInTable; i++) {
             theTable.rows[i].style.display = 'none';
         }
     }


     function showPage() {
         pageNum.innerHTML = page;
     }


     //总共页数
     function pageCount() {
         var count = 0;
         if (numberRowsInTable % pageSize != 0) count = 1;
         return parseInt(numberRowsInTable / pageSize) + count;
     }


     //显示链接
     function preLink() { spanPre.innerHTML = "<a href='javascript:pre(); '>前一页</a>"; }
     function preText() { spanPre.innerHTML = "前一页"; }


     function nextLink() { spanNext.innerHTML = "<a href='javascript:next(); '>后一页</a>"; }
     function nextText() { spanNext.innerHTML = "后一页"; }


     function firstLink() { spanFirst.innerHTML = "<a href='javascript:first();'>首页</a>"; }
     function firstText() { spanFirst.innerHTML = "首页"; }


     function lastLink() { spanLast.innerHTML = "<a href='javascript:last();'>尾页</a>"; }
     function lastText() { spanLast.innerHTML = "尾页"; }


     //隐藏表格
     function hide() {
         for (var i = pageSize; i < numberRowsInTable; i++) {
             theTable.rows[i].style.display = 'none';
         }


         totalPage.innerHTML = pageCount();
         pageNum.innerHTML = '1';


         nextLink();
         lastLink();
     }


     hide();
</script>