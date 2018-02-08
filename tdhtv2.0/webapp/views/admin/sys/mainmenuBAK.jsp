<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>地下管网在线监测中心</title>
	
<script src="${ctx}/resources/js/metismenu/jquery.min.js"></script>
<script src="${ctx}/resources/js/metismenu/jquery.js"></script>
<script src="${ctx}/resources/js/metismenu/accordion.js"></script>
<link href="${ctx}/resources/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />


<style>
html, body {
	height: 100%;
	overflow: hidden;
}
ul.sidebar ul { margin:0px 0px 0px 15px; padding: 0;display: none;} 
</style>
</head>
<body class="frameset">
	<div class="container-top">
		<div class="logo">
			<img src="${ctx}/resources/img/logo.png" border="0" style="margin: 10px 0" />
		</div>
		<div class="quick-link">
			<p>
				<strong>${user.realName}</strong> &lt;${user.account}&gt; | 
				<a href="${ctx}/logout">退出</a>
			</p>
		</div>
	</div>
	<div class="navigation">
		<!--<a href="${ctx}/admin/index">后台首页</a>-->
		<c:forEach items="${sys_menus }" var="menu">
			<a href="${ctx}/admin/sys/sysMenu/mainMenu?parentId=${menu.menuId }" <c:if test="${currentFirstMenu == menu.menuId}"> class="current" </c:if>>${menu.fullName }</a>
		</c:forEach>
	</div>
	<div class="container-main">
		<!-- content-left   -->
		<div class="content-left">
      			<ul id="sidebar" class="sidebar">
      				<c:forEach items="${sys_second_menus }" var="menu" varStatus="status">
	      				<li>
	              			
	              			<c:choose>
	              			<c:when test="${menu.target=='Click' }">
	              			<a href="#">${menu.fullName}</a>
	              			</c:when>
	              			<c:otherwise>
	              			<a href="${ctx}/${menu.navigateUrl}" target="main">${menu.fullName}</a>
	              			</c:otherwise>
	              			</c:choose>
	              			<ul>
	              				<c:forEach items="${menu.childMenuList }" var="cmenu" varStatus="status2">
	                          		<li onclick="switchMod(this.id.replace('nav-', ''));" id="nav-${cmenu.menuId}">
	                          		<a href="${ctx}/${cmenu.navigateUrl}" target="main">${cmenu.fullName }</a>
	                          		</li>
	                          	</c:forEach>
	                      	</ul>
	          			</li>
      				</c:forEach>
      			</ul>
				<script>
				    $(function () {
				        $("#sidebar").accordion({
				            accordion: true,
				            speed: 200,
				    	    closedSign: '[+]',
				    		openedSign: '[-]'
				    	});
				    });
				</script>
			
		</div>
		<!-- end content-left   -->
		<div class="content-main">
			<iframe height="100%" frameborder="0" scrolling="auto"
				allowtransparency="true" class="iframe-main" marginheight="0"
				marginwidth="0" name="main" id="mainframe" src=""></iframe>
		</div>

	</div>
	<script type="text/javascript">
		(function() {

			var s = $('#sidebar').css('overflow', 'auto');
			var t = s.offset().top
			function onResize() {
				var height = document.body.offsetHeight - t;
				$('#sidebar').height(height);
				$('#mainframe').height(height);
			}

			window.onresize = onResize;

			onResize();

		})()

	</script>
	<script type="text/javascript">
		/* if("${defaultMod}" != ""){
			switchMod("${defaultMod}");
		}
		if("${defaultUrl}" != ""){
			document.getElementById("mainframe").src = "../${defaultUrl }";
		} */
	</script>
</body>
</html>