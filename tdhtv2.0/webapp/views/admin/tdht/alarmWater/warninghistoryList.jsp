<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />
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
<title>历史预警</title>

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
	
	
	//查询
	function findReport(){
		document.myform.action = "../alarm/warninghistoryList";
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
	$(function(){
     var optss = document.getElementById("waterType");
		var minates=$("#select").val();  
		if(minates!=""&&optss!=""){
	 for(var i=0;i<7;i++){
           if(minates==optss.options[i].value){
                  optss.options[i].selected = 'selected';
                    break;
             }
          }
         }
           
    })
</script>
</head>
<body  class="body_overflow">
	
	<input id="webUrls" type="hidden" value="${webUrls}" >
	<c:choose>
		<c:when test="${type==1}">
		
		<p class="f14style" ><span class="f14 text-title">${viewCompanyconfig.companyName}历史日预警</span></p>
		<input id="select" type="hidden" value="${waterType}" >
			<div style="background-color:#ffffff;width:100%;height:5px;"></div>
			<form action="../alarmWater/warninghistoryList?rid=${rid}&type=1 " id="myform" name="myform" method="post">
			   <span class="heard_font14">选择日期： </span><input id="dateType" name="dateTypes" value="${dateTypes}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
			<%--公司名称：<input type="text"  id=""  name="companyName"  value="${companyName}"  />
			公司编号：<input type="text"  id="" name="rid"  value=" ${rid}" >--%>
			   <span class="heard_font14">污染物类型：</span>
			   <select id="waterType"name="waterType"> 
				   <c:forEach items="${alarmType}" var="bean">
				   <option value ="${bean.type}">${bean.typeRemark }</option>
					</c:forEach>
				</select> 
			<input name="search" class="btn-big"  type="submit" value="查 询" />
			<input name="search" class="btn-big" onclick="cls();" type="submit" value="清 空" />
			</form>
		</c:when>
		
		<c:when test="${type==3}">
		<p  class="f14style" ><span class="f14 text-title">${viewCompanyconfig.companyName}历史月预警</span></p>
		<input id="select" type="hidden" value="${waterType}" >
			<div style="background-color:#ffffff;width:100%;height:5px;"></div>
			<form action="../alarmWater/warninghistoryList?rid=${rid}&type=3 " id="myform" name="myform" method="post">
	   <span class="heard_font14">选择月份： </span><input id="dateType" name="dateTypes" value="${dateTypes}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM'})">
			<%--公司名称：<input type="text"  id=""  name="companyName"  value="${companyName}"  />
			公司编号：<input type="text"  id="" name="rid"  value=" ${rid}" >--%>
		  <span class="heard_font14">污染物类型：</span>
		  <select id="waterType"name="waterType"> 
				   <c:forEach items="${alarmType}" var="bean">
				   <option value ="${bean.type}">${bean.typeRemark }</option>
					</c:forEach>
		  </select>  
			<input name="search" class="btn-big"  type="submit" value="查 询" />
			<input name="search" class="btn-big" onclick="cls();" type="submit" value="清 空" />
			</form>
		</c:when>
		
		<c:when test="${type==6}">
		<p  class="f14style" ><span class="f14 text-title">${viewCompanyconfig.companyName}历史年预警</span></p>
		<input id="select" type="hidden" value="${waterType}" >
			<div style="background-color:#ffffff;width:100%;height:5px;"></div>
			<form action="../alarmWater/warninghistoryList?rid=${rid}&type=6" id="myform" name="myform" method="post">
			   <span class="heard_font14">选择年份： </span><input id="dateType" name="dateTypes" value="${dateTypes}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY'})">
			<%--公司名称：<input type="text"  id=""  name="companyName"  value="${companyName}"  />
			公司编号：<input type="text"  id="" name="rid"  value=" ${rid}" >--%>
			 污染物类型：
			 <select id="waterType"name="waterType"> 
				   <c:forEach items="${alarmType}" var="bean">
				   <option value ="${bean.type}">${bean.typeRemark }</option>
					</c:forEach>
				</select>  
			
			<input name="search" class="btn-big"  type="submit" value="查 询" />
			<input name="search" class="btn-big" onclick="cls();" type="submit" value="清 空" />
			</form>  
		</c:when>
		
		<c:when test="${type==5}">
		<p  class="f14style" ><span class="f14 text-title">${viewCompanyconfig.companyName}历史自定义预警</span></p>
		<input id="select" type="hidden" value="${waterType}" >
			<div style="background-color:#ffffff;width:100%;height:5px;"></div>
			<form action="../alarmWater/warninghistoryList?rid=${rid}&type=5 " id="myform" name="myform" method="post">
			<span class="heard_font14">开始时间：</span><input id="startingTime" name="startingTime" value="${sTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	     <span class="heard_font14">结束时间：</span><input id="endTime" name="endTime" value="${eTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
				<%--公司名称：<input type="text"  id=""  name="companyName"  value="${companyName}"  />
				公司编号：<input type="text"  id="" name="rid"  value=" ${rid}" >--%>
			  <span class="heard_font14">污染物类型：</span><select id="waterType"name="waterType">
			  <select id="waterType"name="waterType"> 
				   <c:forEach items="${alarmType}" var="bean">
				   <option value ="${bean.type}">${bean.typeRemark }</option>
					</c:forEach>
				</select>  
			
				<input name="search" class="btn-big"  type="submit" value="查 询" />
				<input name="search" class="btn-big" onclick="cls();" type="submit" value="清 空" />
			</form>
		</c:when>
	</c:choose>
			<%--<div style="background-color:#ffffff;width:100%;height:5px;"></div>


	--%><div class="table2excel bluestrip">
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr class="tb_heard_font16">
						<th width="120" align="center">预警时间</div></th>
						<th width="120" align="center">监测单元名称</div></th>
						<th width="120" align="center">监测单元编号</div></th>
						<th width="120" align="center">预警类型</div></th>
						<th width="100" align="center">预警值上限</div></th>
						<th width="100" align="center">预警值下限</div></th>
						<th width="100" align="center">预警值</div></th>
					</tr>
			</thead>
		<tbody>
		<c:forEach items="${historys}" var="bean">
			<tr   class="tb_font15">
				<td align="center" width="120"><fmt:formatDate value="${bean.strtime}" pattern="yyyy-MM-dd  HH:mm:ss"/></td>
				<td align="center" width="120"  style="font-family:Microsoft YaHei;">${bean.comName}</td>
				<td align="center" width="120">${bean.rid}</td>
				<td align="center" width="120" style="font-family:Microsoft YaHei;">${bean.typeRemark}</td>
				<td align="center" width="100"><fmt:formatNumber type='number' value='${bean.limitL}' pattern="0.00"/></td>
				<c:choose>
				<c:when test="${bean.limitLL == 0}">
				<td align="center" width="100">-</td>
				</c:when>
				<c:when test="${bean.limitLL != 0}">
				<td width="100" align="center"><fmt:formatNumber type='number' value='${bean.limitLL}' pattern="0.00"/></td>
				</c:when>
				</c:choose>
				<td align="center" width="100" style="background-color: yellow;"><fmt:formatNumber type='number' value='${bean.value}' pattern="0.00"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	<div id="pagelist"  >
	
		<ul style="list-style:none; ">
			<pg:pager items="${pager.rowCount}"
			export="currentPageNumber=pageNumber" maxPageItems="${pager.pageSize }" maxIndexPages="5" url="../alarmWater/warninghistoryList" >
			<!-- 分页带查询条件 -->
			<pg:param name="startingTime" value="${sTime}"/>
			<pg:param name="endTime" value="${eTime}"/>
			<pg:param name="rid" value="${rid}"/>
			<pg:param name="type" value="${type}"/>
			<pg:param name="dateTypes" value="${dateTypes}"/>
			<pg:param name="companyName" value="${companyName}"/>
			<pg:param name="waterType" value="${waterType}"/>
				<!-- 首页 -->
				<pg:first>
					<li style="list-style:none;"><a href="${pageUrl }"  class="page_btn">首页</a></li>
				</pg:first>
				<pg:prev>
					<li style="list-style:none;"><a href="${pageUrl }"  class="page_btn">前一页</a></li>
				</pg:prev>
				<pg:pages>
					<c:choose>
						<c:when test="${currentPageNumber eq pageNumber }">
							<li class="page_btn_s">${pageNumber }</li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl }"   class="page_btn">${pageNumber }</a></li>
						</c:otherwise>
					</c:choose>
				</pg:pages>
				<pg:next>
					<li style="list-style:none;"><a href="${pageUrl }"   class="page_btn">后一页</a></li>
				</pg:next>
				<pg:last>
					<li style="list-style:none;"><a href="${pageUrl }"   class="page_btn">尾页</a></li>
				</pg:last>
		    <li style="list-style:none;color:#555;"   class="page_text">共${pager.pageCount}页</li>
		    <li style="list-style:none;color:#555;"  class="page_text">共${pager.rowCount}条记录</li>
			</pg:pager>
  		</ul>
	</div>

</body>
</html>