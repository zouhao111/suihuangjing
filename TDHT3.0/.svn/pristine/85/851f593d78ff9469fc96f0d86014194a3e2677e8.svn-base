<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
	<link rel="stylesheet" href="static/bootstrap/tab/bootstrap.min.css" />
	<script src="static/bootstrap/tab/jquery.min.js"></script>
	<script src="static/bootstrap/tab/bootstrap.min.js"></script>
<script src="static/js/jquery.cookie.js"></script>
</head>
<body style="background-color:#fff;"onload="resizeFrame()">
<a id="menuUrl" href="${menuUrl}"></a>
<input  id="R_ID" type="hidden"  value="${R_ID}"/>
<input  id="list" type="hidden"  value="${list}"/>

<script type="text/javascript">
var height=0;
$(function () {
	var menuUrl=$("#menuUrl").attr("href")
		$.cookie('menuUrl_ss', menuUrl, { expires: 1, path: '/TDHT3.0' });
	console.log($("#myTabContent").height())
	var heights=$("#myTabContent").height()
	height=heights+100;
 $("body").css("height",height)
	})
	
	 function resizeFrame(){
            var content_iframe = window.parent.document.getElementById("pages");//获取iframeID
              var content_iframes = window.parent.parent.document.getElementById("iframe_div");//获取iframeID
            height=height+100;
            content_iframe.style.height = height+"px";
         height=height+100;
            content_iframes.style.height =height+'px';
}
	</script>

<ul id="myTab" class="nav nav-tabs" style="width:98%;margin-top: 15px;">
		<c:if  test="${list0.hasMenu == true}" >
				<li class="active">
					<a href="#home1" data-toggle="tab"><img width="15px" class="module-img" src="static/images/3gang.png"/> ${list0.MENU_NAME}</a>
				</li>
		</c:if>

		<c:if  test="${list1.hasMenu == true}" >
				<li><a href="#home2" data-toggle="tab"><img width="15px" class="module-img" src="static/images/3gang.png"/> ${list1.MENU_NAME}</a>
				</li>
		</c:if>

		<c:if  test="${list2.hasMenu == true}" >
				<li><a href="#home3" data-toggle="tab"><img width="15px" class="module-img" src="static/images/3gang.png"/> ${list2.MENU_NAME}</a>
				</li>
		</c:if>
</ul>
						<div id="myTabContent" class="tab-content" style="width:98%;">
							<div class="tab-pane fade in active" id="home1" style="height:100%" >
							<table  class="table table-striped table-bordered table-hover" style="width:60%;margin-left:20%;">
							  <tr>
							    <td width="166">企业名称</td>
							    <td colspan="3">${infojson0.var1}</td>
							  </tr>
							  <tr>
							    <td>生产地址</td>
							    <td colspan="3">${infojson1.var1}</td>
							  </tr>
							  <tr>
							    <td>联系人</td>
							    <td width="69">${infojson2.var1}</td>
							    <td width="131">联系电话</td>
							    <td width="106">${infojson2.var3}</td>
							  </tr>
							  <tr>
							    <td>工厂占地面积</td>
							    <td>${infojson3.var1}</td>
							    <td>工厂建筑面积</td>
							    <td>${infojson3.var3}</td>
							  </tr>
							  <tr>
							    <td>工厂员工人数</td>
							    <td>${infojson4.var1}</td>
							    <td>生产车间数量</td>
							    <td>${infojson4.var3}</td>
							  </tr>
							  <tr>
							    <td>行业类别</td>
							    <td>${infojson5.var1}</td>
							    <td>生产线数量</td>
							    <td>${infojson5.var3}</td>
							  </tr>
							  <tr>
							    <td>上年度生活给水总量</td>
							    <td>${infojson6.var1}</td>
							    <td>上年度工业给水总量</td>
							    <td>${infojson6.var3}</td>
							  </tr>
							  <tr>
							    <td>产品及年产能</td>
							    <td colspan="3">${infojson7.var1}</td>
							  </tr>
							  <tr>
							    <td>上年度总产量</td>
							    <td colspan="3">${infojson8.var1}</td>
							  </tr>
							  <tr>
							    <td>生产废水处理能力（吨/日）</td>
							    <td colspan="3">${infojson9.var1}</td>
							  </tr>
							  <tr align="center">
							    <td colspan="4">企业用水信息</td>
							  </tr>
							  <tr>
							    <td>生活给水口数量</td>
							    <td>${infojson11.var1}</td>
							    <td>工业给水口数量</td>
							    <td>${infojson11.var3}</td>
							  </tr>
							  <tr height="60px">
							    <td>工业废水总排放口数量</td>
							    <td>${infojson12.var1}</td>
							    <td >车间或生产设施废水排放口数量(第一类污染物)</td>
							    <td>${infojson12.var3}</td>
							  </tr>
							  <tr height="55px">
							    <td>排水管网类别以及与市政管网接驳口数量</td>
							    <td colspan="3">${infojson13.var1}</td>
							  </tr>
							  <tr>
							    <td rowspan="3">排水管网设置情况</td>
							    <td>分离排放：</td>
							    <td colspan="2">${infojson14.var2}</td>
							  </tr>
							  <tr height="85px">
							    <td>混合排放：</td>
							    <td colspan="2" >
							      ${infojson15.var2}${infojson16.var2}<br /><br />
							      ${infojson17.var2}
							      ${infojson18.var2}  
							    </td>
							  </tr>
							  <tr>
							    <td>部分分离排放</td>
							    <td colspan="2">${infojson19.var2}</td>
							  </tr>
							  <tr height="40px">
							    <td>生活用水量(吨/日)</td>
							    <td>${infojson20.var1}</td>
							    <td>工业用水量(吨/日)</td>
							    <td>${infojson20.var3}</td>
							  </tr>
							  <tr height="60px">
							    <td>工业给水量(新鲜水)(吨/日)</td>
							    <td>${infojson21.var1}</td>
							    <td>重复用水量(吨/日)</td>
							    <td>${infojson21.var3}</td>
							  </tr>
							  <tr align="center">
							    <td colspan="4">其它说明</td>
							  </tr>
							  <tr height="180px">
							    <td colspan="4" >${infojson23.var0}</td>
							  </tr>
							   
							  <tr height="50px">
							    <td colspan="4" >重要提示：本表由被调查人填写，被调查人必须全面、准确地填写，并保证其真实性，否则将对被调查人产生不利的影响。</td>
							  </tr><tr>
							    <td>企业法人(或代理人)签名</td>
							    <td>${infojson25.var1}</td>
							    <td>日期</td>
							    <td>${infojson25.var3}</td>
							  </tr>
							</table>
							</div>
							<div class="tab-pane fade" id="home2" style="text-align: center;">
								<img src="static/img/${R_ID}/1.png" width="43%" class="img-thumbnail"><img style="margin-left: 60px;" src="static/img/${R_ID}/4.png" width="45%" class="img-thumbnail">
								<img src="static/img/${R_ID}/2.png" style="margin-top: 15px;" width="43%" height="300px" class="img-thumbnail"><img style="margin-left: 60px;margin-top: 15px;height:440px;" src="static/img/${R_ID}/3.png" width="45%" class="img-thumbnail">
							</div>
							<div class="tab-pane fade" id="home3">
								<table  class="table table-striped table-bordered table-hover" style="width:65%;margin-left:17%;text-align:left;">
									 <tr>
									    <td colspan="6" align="center"><h3>深圳市天地互通监测单元安装信息表</h3></td>
									  </tr>
									 <tr>
									    <td >机舱编码</td>
									    <td colspan="5">${cabin}</td>
									  </tr>
									  <tr>
									    <td width="90">部门</td>
									    <td width="120">${com.R_OPERATING}</td>
									    <td width="120">流量计归零时间</td>
									    <td width="110">${com.R_WATER_STR_TIME}</td>
									    <td width="110">监测单元名称</td>
									    <td width="100">${com.R_NAME_CN}</td>
									  </tr>
									  <tr>
									    <td>控制器ID</td>
									    <td >${dID}</td>
									     <td >水质监测启用时间</td>
									     <td >${com.R_QUALITY_STR_TIME}</td>
									    <td>项目名称</td>
									    <td>水污染源</td>
									  </tr>
									  <tr>
									    <td>人数</td>
									    <td>${com.R_N}</td>
									    <td>行业</td>
									    <td>&nbsp;</td>
									    <td>坐标</td>
									    <td>${com.R_LON},${com.R_LAT}</td>
									  </tr>
									  <tr>
									    <td>流域</td>
									    <td colspan="2">${com.R_BASIN}</td>
									    <td>河流</td>
									    <td colspan="2">${com.R_BASIN}</td>
									  </tr>
									  <tr>
									    <td>水平衡分析</td>
									    <td colspan="5">${calc}</td>
									  </tr>
									  <tr>
									    <td>地址</td>
									    <td colspan="5">${com.R_ADDRESS}</td>
									  </tr>
									   <tr>
									    <td>安装位置</td>
									    <td colspan="5"></td>
									  </tr>
									  <tr>
									    <td colspan="2">安装设备名称</td>
									    <td >I类污染物(单位)</td>
									    <td>II类污染物(单位)</td>
									    <td>其他水质参数(单位)</td>
									    <td>报警上/下限</td>
									  </tr>
									  <c:forEach items="${qList}" var="list">
									  	 <tr>
										  <td colspan="2">${list.apparatus}</td>
											<c:choose>  
											    <c:when test="${list.pollutant_type==1}">
											    	<td>${list.param_name}</td>
											   </c:when>  
											   <c:otherwise>
											  		<td ></td>
											   </c:otherwise>  
											</c:choose>
										  	<c:choose>  
											    <c:when test="${list.pollutant_type==2}">
											    	<td>${list.param_name}</td>
											   </c:when>  
											   <c:otherwise>
											  		<td></td>
											   </c:otherwise>  
											</c:choose>
											<c:choose>  
											    <c:when test="${list.pollutant_type==0}">
											    	<td>${list.param_name}</td>
											   </c:when>  
											   <c:otherwise>
											  		<td></td>
											   </c:otherwise>  
											</c:choose>
											<td>${list.limitHH}~${list.limitLL}</td>
										 </tr>
									  </c:forEach>
									  <tr>
									    <td colspan="2">控制设备名称</td>
									    <td colspan="4" align="center">控制参数</td>
									  </tr>
									  <c:forEach items="${cList}" var="list">
									  <tr>
									    <td colspan="2">${list.param_name}</td>
									    <td colspan="4" align="center">${list.control_action}</td>
									  </tr>
									  </c:forEach>
									</table>
							</div>
						</div>

</body>
</html>