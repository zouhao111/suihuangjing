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
<script type="text/javascript" src="${ctx}/resources/js/ajaxpdf.js"></script>
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

<title>水量报表</title>
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
		  var optss = document.getElementById("timeSpace");
		var minates=$("#select").val();  
		//console.log(optss)
		if(minates!=""&&optss!=null){
	 for(var i=0;i<4;i++){
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
			<p class="f14style" ><span id="com_name"class="f14 text-title">${Companyconfig.companyName}水量日报表</span></p>


		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	
			<form action="../waterForm/waterFormList?rid=${rid}&type=1" id="myform" name="myform" method="post">
 
		
		<span class="heard_font14">选择日期：</span><input id="dateType" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
			<input name="search" class="btn-big"  type="submit" value="查 询" />
			<input name="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
			<input id="btn"class="btn-big" type="button" style="float: right;"value="导出Excle"/>
			 <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
			</form>
		</c:when>
		
		<c:when test="${type==3}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${Companyconfig.companyName}水量月报表</span></p>
	
		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	
			<form  action="../waterForm/waterFormList?rid=${rid}&type=3"  id="myform" name="myform" method="post">
			<span class="heard_font14">选择月份：</span>	<input id="dateType" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM'})">
			<input name="search" class="btn-big"  type="submit" value="查 询" />
			<input name="lat"  class="btn-big"  type="submit" value="前月" />
			<input name="lat" class="btn-big"  type="submit" value="后月" />
			<input id="btn"class="btn-big" type="button"style="float: right;" value="导出Excle"/>
			<input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
			</form>
		</c:when>
		
		<c:when test="${type==6}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${Companyconfig.companyName}水量年报表</span></p>
		
			<div style="background-color:#ffffff;width:100%;height:5px;"></div>
			
			<form action="../waterForm/waterFormList?rid=${rid}&type=6" id="myform" name="myform" method="post">
 
	<span class="heard_font14">选择年份： </span><input id="dateType" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY'})">
			<input name="search" class="btn-big"  type="submit" value="查 询" />
			<input name="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
			<input id="btn"class="btn-big" type="button" style="float: right;"value="导出Excle"/>
			<input id="btn"class="btn-big" type="button"style="float: right;" onclick="pdf()"value="导出pdf"/>
			</form>  
		</c:when>
		
		<c:when test="${type==5}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${Companyconfig.companyName}水量自定义报表</span></p>

	<div style="background-color:#ffffff;width:100%;height:5px;"></div>

			<form action="../waterForm/waterFormList?rid=${rid}&type=5" id="myform" name="myform" method="post">
 
	    <span class="heard_font14">开始时间：</span><input id="startingTime" name="startingTime" value="${sTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
		<span class="heard_font14">结束时间：</span>	<input id="endTime" name="endTime" value="${eTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
				<input name="search" class="btn-big"  type="submit" value="查 询" />
				<input name="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
				<input id="btn" class="btn-big" type="button"style="float: right;" value="导出Excle"/>
				<input id="btn"class="btn-big" type="button"style="float: right;" onclick="pdf()"value="导出pdf"/>
				</form>
		</c:when>
		
		<c:when test="${type==11}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${Companyconfig.companyName}水量历史报表</span></p>
		<input id="select" type="hidden" value="${minates}" >
			<form action="../waterForm/waterFormList?rid=${rid}&type=11" id="myform" name="myform" method="post">
			<div style="background-color:#ffffff;width:100%;height:5px;"></div>
			   <span class="heard_font14">开始时间：</span><input id="startingTime" name="startingTime" value="${sTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"> 
			   <span class="heard_font14">结束时间：</span><input id="endTime" name="endTime" value="${eTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
			   <span class="heard_font14">时间间隔(/分钟)： </span>	 <select id="timeSpace"name="minates"> <option  value ="5">5分钟</option>    <option value ="30">30分钟</option>  <option value="60">1小时</option><option value="1440">24小时</option>  </select>
			   <input name="search" class="btn-big"  type="submit" value="查 询" />
			   <input name="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
			   <input id="btn" class="btn-big" type="button"style="float: right;" value="导出Excle"/>
			   <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
			</form>
		</c:when>
	</c:choose>
	<!-- <div style="border-left: 0.1px solid #3498db;border-right: 0.1px solid #3498db;"> -->
	
	<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	
	
	
	<table border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" style="border-collapse:collapse;" >
			<thead>
			<c:choose>
		<c:when test="${type!=11}">
					  <tr  class="tb_heard_font16">
					    <td  align="center" rowspan="2"  >时间</td>
					    
					    <c:if test="${rid==75501330025}">
					    <td align="center"  >工业给水1</td>
					    <td  align="center" >工业给水2</td>
					    <td  align="center" >工业排水</td>
					    <td  align="center" >生活排水</td>
					    <td  align="center" >损耗值</td>
					    <td  align="center" >不明工业排水</td>
					    </c:if>
					     <c:if test="${rid!=75501330025}">
					    <td align="center"  >工业给水</td>
					    <td  align="center" >生活给水</td>
					    <td  align="center" >工业排水</td>
					    <td  align="center" >生活排水</td>
					    <td  align="center" >损耗值</td>
					    <td  align="center" >不明工业排水</td>
					    </c:if>
					 </tr>
					 <tr  class="tb_heard_font15">
					    <td  align="center">总流量(m<sup>3</sup>)</td>
					    <td  align="center">总流量(m<sup>3</sup>)</td>
					    <td  align="center">总流量(m<sup>3</sup>)</td>
					    <td  align="center">总流量(m<sup>3</sup>)</td>
					    <td  align="center">总流量(m<sup>3</sup>)</td>
					    <td  align="center">总流量(m<sup>3</sup>)</td>
					 </tr>
			</c:when>
			<c:when test="${type==11}">
					  <tr   class="tb_heard_font16">
					    <c:if test="${rid==75501330025}">
					    <td  align="center" rowspan="2" >时间</td>
					    <td align="center"  >工业给水1</td>
					    <td  align="center" >工业给水2</td>
					    <td  align="center" >工业排水</td>
					    <td  align="center" >生活排水</td>
					    </c:if>
					     <c:if test="${rid!=75501330025}">
					    <td  align="center" rowspan="2" >时间</td>
					    <td align="center"  >工业给水</td>
					    <td  align="center" >生活给水</td>
					    <td  align="center" >工业排水</td>
					    <td  align="center" >生活排水</td>
					    </c:if>
					    <%--<td  align="center" style="font-family: 黑体;font-size: 16;">损耗值</td>
					    <td  align="center"  style="font-family: 黑体;font-size: 16;">不明工业排水</td> --%>
					 </tr>
					 <tr   class="tb_heard_font15">
					    <td  align="center">总流量(m<sup>3</sup>)</td>
					    <td  align="center">总流量(m<sup>3</sup>)</td>
					    <td  align="center">总流量(m<sup>3</sup>)</td>
					    <td  align="center">总流量(m<sup>3</sup>)</td>
					    <%--<td  align="center">总流量(m<sup>3</sup>)</td>
					    <td  align="center">总流量(m<sup>3</sup>)</td>
					 --%></tr>
			</c:when>
			</c:choose>
		</thead>
		<tbody id="table2">
		<c:choose>
		<c:when test="${type==11}">
		<c:forEach items="${water}" var="bean">
		 <tr    class="tb_font15"   >
			<td  align="center" ><div class="td-space"><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td  align="center"><fmt:formatNumber type="number" value="${bean.tabZtrafficIS1}" pattern="0.00"/></td>
		    <td  align="center"><fmt:formatNumber type="number" value="${bean.tabZtrafficDS1}" pattern="0.00"/></td>
		    <td  align="center"><fmt:formatNumber type="number" value="${bean.tabZtrafficID1}" pattern="0.00"/></td>
		    <td  align="center">-</td>
		    <%--<td  align="center"><fmt:formatNumber type="number" value="${bean.wastage}" pattern="0.00"/></td>
		    <td  align="center"><fmt:formatNumber type="number" value="${bean.unknown}" pattern="0.00"/></td>
		  --%></tr>
		</c:forEach>
	
		</c:when>
		
		<c:when test="${type!=11}">
		 <c:forEach items="${water}" var="bean">
		 <tr class="tb_font15">
			<td  align="center"  ><div class="td-space"><fmt:formatDate value="${bean.strTime}" pattern="yyyy-MM-dd"/></div></td>
			<td  align="center"><fmt:formatNumber type="number" value="${bean.industrialsupply}" pattern="0.00"/></td>
		    <td  align="center"><fmt:formatNumber type="number" value="${bean.livingsupply}" pattern="0.00"/></td>
		    <td  align="center"><fmt:formatNumber type="number" value="${bean.industrialdrainage}" pattern="0.00"/></td>
		    <td  align="center">-</td>
		    <td  align="center"><fmt:formatNumber type="number" value="${bean.wastage}" pattern="0.00"/></td>
		    <td  align="center"><fmt:formatNumber type="number" value="${bean.unknown}" pattern="0.00"/></td>
		  </tr>
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
	<c:choose>
		<c:when test="${type==11}">
	<div id="pagelist" >
		<ul style="list-style:none;">
			<pg:pager items="${pager.rowCount}"
			export="currentPageNumber=pageNumber" maxPageItems="${pager.pageSize }" maxIndexPages="5" url="../waterForm/waterFormList" >
			 
			<pg:param name="startingTime" value="${sTime}"/>
			<pg:param name="endTime" value="${eTime}"/>
			<pg:param name="rid" value="${rid}"/>
			<pg:param name="type" value="${type}"/> 
			<pg:param name="dateTypes" value="${dateTypes}"/>
			<pg:param name="minates" value="${minates}"/>
				<pg:first>
					<li style="list-style:none;"><a href="${pageUrl }"    class="page_btn">首页</a></li>
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
					<li style="list-style:none;"><a href="${pageUrl }"    class="page_btn">后一页</a></li>
				</pg:next>
				<pg:last>
					<li style="list-style:none;"><a href="${pageUrl }"   class="page_btn">尾页</a></li>
				</pg:last>
		  	    <li  class="page_text">共${pager.pageCount}页</li>
		    <li class="page_text">共${pager.rowCount}条记录</li>
			</pg:pager>
  		</ul>
	</div>
	
		
		
	</div>
	</c:when>
	<c:when test="${type!=11}">
	<div style="text-align: center;font-size: 15px;"><span  class="page_btn" id="spanFirst">首页</span> <span class="page_btn" id="spanPre">前一页</span> <span class="page_btn" id="spanNext">后一页</span> <span class="page_btn" id="spanLast">尾页</span> <span  class="page_text"> 第<span id="spanPageNum" ></span>页/共<span id="spanTotalPage"></span>页 </span></div>
	</c:when>
			</c:choose>
			
			
<!--<div style="with:100%;height:30px;  background: url(${ctx}/resources/lrtk/images/foot.png) no-repeat center;"></div> 

--><script src="${ctx}/resources/js/jquery.table2excel.js"></script>
<script>
		$(function() {
			data_pdf();
			var name1=$("#com_name").text();
			$("#btn").click(function(){
				//alert($("#tr").html()=='')
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