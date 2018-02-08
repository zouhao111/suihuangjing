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
<title>水平衡报表</title>
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
	var rid=${rid}
	$(function(){
	if(rid=="75501330004"){
	
	var sum=${tabZtrafficIS1}
	if(sum!=0){
	                var tabZtrafficIS1=${tabZtrafficIS1}/sum
					var tabZtrafficDS1=${tabZtrafficDS1}/sum
					var tabZtrafficID1=${tabZtrafficID1}/sum
					var lossLimit=${lossLimit}/sum
					var wastage=${wastage}/sum
					var unknown=${unknown}/sum
	}else{
	 var tabZtrafficIS1=0
					var tabZtrafficDS1=0
					var tabZtrafficID1=0
					var lossLimit=0
					var wastage=0
					var unknown=0
	}				
					
					var tr="<th align='center'>"+tabZtrafficIS1.toFixed(2)+"</th>";
						tr+="<th align='center'>-</th>";
						tr+="<th align='center'>"+tabZtrafficID1.toFixed(2)+"</th>";
						tr+="<th align='center'>-</th>";
						tr+="<th align='center'>"+lossLimit.toFixed(2)+"</th>";
						tr+="<th align='center'>"+wastage.toFixed(2)+"</th>";
						tr+="<th align='center'>"+unknown.toFixed(2)+"</th>";
					  $tr = $(tr);
         
           //添加td
    		$("#tr").append($tr);
    		
	}else{
	var sum=(${tabZtrafficDS1}+${tabZtrafficIS1})
	if(sum!=0){
					var tabZtrafficIS1=${tabZtrafficIS1}/sum
					var tabZtrafficDS1=${tabZtrafficDS1}/sum
					var tabZtrafficID1=${tabZtrafficID1}/sum
					var lossLimit=${lossLimit}/sum
					var wastage=${wastage}/sum
					var unknown=${unknown}/sum
					
		}else{
		var tabZtrafficIS1=0
					var tabZtrafficDS1=0
					var tabZtrafficID1=0
					var lossLimit=0
					var wastage=0
					var unknown=0
		}			
					var tr="<th align='center'>"+tabZtrafficIS1.toFixed(2)+"</th>";
						tr+="<th align='center'>"+tabZtrafficDS1.toFixed(2)+"</th>";
						tr+="<th align='center'>"+tabZtrafficID1.toFixed(2)+"</th>";
						tr+="<th align='center'>-</th>";
						tr+="<th align='center'>"+lossLimit.toFixed(2)+"</th>";
						tr+="<th align='center'>"+wastage.toFixed(2)+"</th>";
						tr+="<th align='center'>"+unknown.toFixed(2)+"</th>";
					  $tr = $(tr);
         
           //添加td
    		$("#tr").append($tr);
    		}
    		})
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
<body  class="body_overflow">
	<input id="webUrls" type="hidden" value="${webUrls}" >
	
	
	
	<c:choose>
		<c:when test="${type==3}">
			<p class="f14style" ><span id="com_name"class="f14 text-title">${viewCompanyconfig.companyName}水平衡月度报表</span></p>
				
		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
			
			<form  action="../balance/balanceList?rid=${rid}&type=3"  id="myform" name="myform" method="post">
		   <span class="heard_font14">选择月份： </span><input id="dateType" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM'})">
			<input name="search" class="btn-big"  type="submit" value="查 询" />
			<input name="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
				<input id="btn"class="btn-big" type="button" style="float: right;"value="导出Excle"/>
			 <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
			</form>
		</c:when>
		
		<c:when test="${type==6}">
			<p class="f14style" ><span id="com_name" class="f14 text-title">${viewCompanyconfig.companyName}水平衡年度报表</span></p>
		
			
		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
		
			<form action="../balance/balanceList?rid=${rid}&type=6" id="myform" name="myform" method="post">
		 <span class="heard_font14">选择年份： </span><input id="dateType"  name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY'})">
			<input name="search" class="btn-big"  type="submit" value="查 询" />
			<input name="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
				<input id="btn"class="btn-big" type="button" style="float: right;"value="导出Excle"/>
			 <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
			</form>  
		</c:when>
		
		<c:when test="${type==5}">
			<p class="f14style" ><span id="com_name" class="f14 text-title">${viewCompanyconfig.companyName}水平衡自定义报表</span></p>
			
		<div style="background-color:#ffffff;width:100%;height:5px;"></div>
			<form action="../balance/balanceList?rid=${rid}&type=5" id="myform" name="myform" method="post">
			<span class="heard_font14">开始时间：</span><input id="startingTime" name="startingTime" value="${sTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
	         <span class="heard_font14">结束时间：</span><input id="endTime" name="endTime" value="${eTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
				<input name="search" class="btn-big"  type="submit" value="查 询" />
				<input name="search" class="btn-big" onclick="cls();" type="button" value="清 空" />
					<input id="btn"class="btn-big" type="button" style="float: right;"value="导出Excle"/>
			 <input id="btn"class="btn-big" type="button"style="float: right;"onclick="pdf()" value="导出pdf"/>
			</form>
		</c:when>
		
	</c:choose>

	<%--<p class="f14style"><strong class="f14 text-title" style="color: blue;">基本信息</strong></p>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr>
						<th width="2%" align="center">项目名称</th>
						<th width="130" align="center">工业给水</th>
						<th width="130" align="center">生活给水</th>
						<th width="130" align="center">工业排水</th>
						<th width="130" align="center">生活排水</th>
					</tr>
					<tr>
						<th align="center">水位(m)</th>
						<th align="center">-</th>
						<th align="center">-</th>
						<th align="center">${data3.waterLevelMin}-${data3.waterLevelMax}</th>
						<th align="center">-</th>
					</tr>
					<tr>
						<th align="center">流速(m/s)</th>
						<th align="center">${data1.flowVelocityMin}-${data1.flowVelocityMax}</th>
						<th align="center">${data2.flowVelocityMin}-${data2.flowVelocityMax}</th>
						<th align="center">${data3.flowVelocityMin}-${data3.flowVelocityMax}</th>
						<th align="center">-</th>
					</tr>
					<tr>
						<th align="center">流量速率(m3/s)</th>
						<th align="center">${data1.flowRateMin}-${data1.flowRateMax}</th>
						<th align="center">${data2.flowRateMin}-${data2.flowRateMax}</th>
						<th align="center">${data3.flowRateMin}-${data3.flowRateMax}</th>
						<th align="center">-</th>
					</tr>
					<tr>
						<th align="center">流量(m3)</th>
						<th align="center">-</th>
						<th align="center">-</th>
						<th align="center">-</th>
						<th align="center">-</th>
					</tr>
			</thead>
	</table>
	
	<p class="f14style"><strong class="f14 text-title" style="color: blue;">水质报表</strong></p>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr>
						<th width="2%" align="center">项目名称</th>
						<th width="130" align="center">预警值</th>
						<th width="130" align="center">当值最大值</th>
						<th width="130" align="center">当值最小值</th>
						<th width="130" align="center">备注</th>
					</tr>
					<tr>
						<th align="center">PH值</th>
						<th align="center">6-9</th>
						<th align="center"><fmt:formatNumber type="number" value="${balanceaPH.phmax}" maxFractionDigits="2"/></th>
						<th align="center"><fmt:formatNumber type="number" value="${balanceaPH.phmin}" maxFractionDigits="2"/></th>
						<th align="center"><c:choose>
	              			<c:when test="${balanceaPH.phmax < '9' and balanceaPH.phmin> '6'}">正常</c:when>
	              			<c:otherwise>超限</c:otherwise>
	              			</c:choose></th>
					</tr>
					<tr>
						<th align="center">COD(mg/l)</th>
						<th align="center">15-60</th>
						<th align="center"><fmt:formatNumber type="number" value="${balanceaPH.codmax}" maxFractionDigits="2"/></th>
						<th align="center"><fmt:formatNumber type="number" value="${balanceaPH.codmin}" maxFractionDigits="2"/></th>
						<th align="center">
	              			<c:if test="${balanceaPH.codmax<='15'}">Ⅱ类水</c:if><c:if test="${balanceaPH.codmax<='20'}">Ⅲ类水</c:if>
	              			<c:if test="${balanceaPH.codmax<='30'}">Ⅳ类水</c:if><c:if test="${balanceaPH.codmax<='40'}">Ⅴ类水</c:if>
	              			<c:if test="${balanceaPH.codmax>'40'}">严重污染</c:if> 
	              			</th>
					</tr>
			</thead>
	</table>
	<p class="f14style"><strong class="f14 text-title" style="color: blue;">水平衡报表</strong></p>--%>
	
	
	
		<!--<div style="background-color:#ffffff;width:100%;height:5px;"></div>



	--><div id="pdf"class="table2excel bluestrip"  >
	<table  border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" style="border-collapse:collapse;" >
			<thead>
					<tr   class="tb_heard_font16">
					   <th  align="center">类型</th>
					   <th  align="center">时间</th>
					       <c:if test="${rid==75501330025}">
						<th  align="center">工业给水1(m<sup>3</sup>)</th>
						<th  align="center">工业给水2(m<sup>3</sup>)</th>
						<th  align="center">工业排水(m<sup>3</sup>)</th>
						<th  align="center">生活排水(m<sup>3</sup>)</th>
						<th  align="center">损耗限值(m<sup>3</sup>)</th>
						<th  align="center">损耗值(m<sup>3</sup>)</th>
						<th  align="center">不明工业排水(m<sup>3</sup>)</th>
						</c:if>
						<c:if test="${rid!=75501330025}">
						<th  align="center">工业给水(m<sup>3</sup>)</th>
						<th  align="center">生活给水(m<sup>3</sup>)</th>
						<th  align="center">工业排水(m<sup>3</sup>)</th>
						<th  align="center">生活排水(m<sup>3</sup>)</th>
						<th  align="center">损耗限值(m<sup>3</sup>)</th>
						<th  align="center">损耗值(m<sup>3</sup>)</th>
						<th  align="center">不明工业排水(m<sup>3</sup>)</th>
						</c:if>
					</tr>
					<tr class="tb_font15">
					 <td align="center" style="font-family:Microsoft YaHei;font-size: 15;">流量</td>
					 <c:if test="${type==5}">
				 <td align="center"  >${sTime} - ${eTime}</td>
				 </c:if>
				 <c:if test="${type!=5}">

				 <td align="center"  >${dateTypes}</td>

		

				 </c:if>
						<td align="center"><fmt:formatNumber type="number" value="${tabZtrafficIS1}" pattern="0.00"/></td>
						  <c:if test="${rid eq 75501330004}">
				<td align="center">-</td>
				 </c:if>
				 <c:if test="${rid ne 75501330004}">
				 <td align="center"><fmt:formatNumber type="number" value="${tabZtrafficDS1}" pattern="0.00"/></td>
				 </c:if>
						<td align="center"><fmt:formatNumber type="number" value="${tabZtrafficID1}" pattern="0.00"/></td>
						<td align="center">-</td>
						<td align="center"><fmt:formatNumber type="number" value="${lossLimit}" pattern="0.00"/></td>
						<td align="center"><fmt:formatNumber type="number" value="${wastage}" pattern="0.00"/></td>
						<td align="center"><fmt:formatNumber type="number" value="${unknown}" pattern="0.00"/></td>
					</tr>
					
					
					<tr id="tr"  class="tb_font15" >
					 <td align="center"   style="font-family:Microsoft YaHei;font-size: 15;">系数</td>
					 <c:if test="${type==5}">
				 <td align="center"   >${sTime} - ${eTime}</td>
				 </c:if>
				 <c:if test="${type!=5}">
				 <td align="center"  >${dateTypes}</td>
				 </c:if>
					<!--	<th align="center">tabZtrafficIS1.toFixed(2)</th>
						<th align="center">tabZtrafficDS1.toFixed(2)</th>
						<th align="center">tabZtrafficID1.toFixed(2)</th>
						<th align="center">-</th>
						<th align="center">lossLimi.toFixed(2)</th>
						<th align="center">wastage.toFixed(2)</th>
						<th align="center">unknown.toFixed(2)</th>
					</tr>
			--></thead>
	</table>
	</div>
	
		<%--<div style="background-color:#ffffff;width:100%;height:5px;"></div>
	--%></div>

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