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
<script src="${ctx}/resources/js/ajax.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/zDialog.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/zDrag.js"></script>
<link href="${ctx}/resources/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />



<style>
html, body {
	height: 100%;
	overflow: hidden;
}
ul.sidebar ul { margin:0px 0px 0px 15px; padding: 0;display: none;} 
input:-webkit-autofill {   
-webkit-box-shadow: 0 0 0px 1000px #FFFFFF inset;   
}  


*{  
margin:0;  
padding:0;  
}  
ul{  
list-style:none;  
} 
.nav{  
font-size:16px;  

}  
.nav li{  
float:left;  
margin-right:1px;  
}  
.nav li a{  
text-decoration:none;  
line-height:38px;  
background-color:#3498db;  
color:#FFF;  
display:block;  
width:136px;  
text-align:center;  
}  
.nav li a:hover{  
background-color:#2980b9;  
color:#FFFFFF;  
}  
.nav li ul{  
display:none;  
}  
.nav li ul li{  
margin-top:1px;  
position:relative;  
}  
/*鼠标移到相应元素上显示二级菜单*/  
.nav li:hover ul{  
display:block;  
width:136px;  
}  
.nav li:hover ul li ul{  
display:none;  
}  
.nav li:hover ul li ul li{  
margin-left:1px;  
}  
/*鼠标移到相应二级菜单元素上显示三级菜单*/  
.nav li ul li:hover ul{  
display:block;  
position:absolute;  
top:0px;  
left:136px;  
}  




</style>

<script type="text/javascript">
$(function(){

   var  imrid=${webCompany.rid};
   // document.getElementById("yyf").click();//打开页面后默认点击
  //doAjax(imrid);
     click_com();
   URLstr(imrid)
   
 


 
})


</script>
<script type="text/javascript">
	var timerr;
	 $(function(){ 

	$("#leftMenu").hide();
	$("#iframe_div").css("left","0")
	$(".nav a").click(function(event) {
	    
				if($(this).text()=="首页"){//获取并判断主菜单的值
				
				$("#leftMenu").hide();
					$("#iframe_div").css("left","0")
				}else{
				$("#leftMenu").hide();
					$("#iframe_div").css("left","180px")
					$("#leftMenu").show();
				} 
				});  
	var webUrl
	var webUrl1
	 var webUrl2
	
	/**
	点击按钮永艺发
	*/
	$("#yyf").click(function(event) {
	
	 webUrl1=$("#mainframe").contents().find("#webUrls").val(); 
	
	
	if(webUrl1!=undefined){
	webUrl=webUrl1
	}else{
	
	webUrl2=$("#mainframe").contents().find("#hidden3").val(); 
      webUrl=webUrl2
	//window.clearInterval(timer); 
	}
	
	console.log(webUrl)
	//alert(webUrl)
	var yyfRid=75501330001
	URLstr(yyfRid)
	var url=webUrl+"&rid="+yyfRid
	$("#yyf").attr("href",url);
	document.getElementById("yyf").click();//打开页面后默认点击
	
	 window.clearInterval(timerr);
	
	})
	/**
	点击按钮欧达可
	*/
	$("#odk").click(function(event) {
	var webUrl1=$("#mainframe").contents().find("#webUrls").val(); 
	
	if(webUrl1!=undefined){
	webUrl=webUrl1
	}else{
	webUrl2=$("#mainframe").contents().find("#hidden3").val(); 
      webUrl=webUrl2
	//window.clearInterval(timer); 
	}
	
	
	
	var odkRid=75501330002
	URLstr(odkRid)
	var url=webUrl+"&rid="+odkRid
	$("#odk").attr("href",url);
	document.getElementById("odk").click();//打开页面后默认点击
	})
	/**
	点击按钮天地互通
	*/
	$("#tdht").click(function(event) {
	var webUrl1=$("#mainframe").contents().find("#webUrls").val(); 
	
	if(webUrl1!=undefined){
	webUrl=webUrl1
	}else{
	webUrl2=$("#mainframe").contents().find("#hidden3").val(); 
      webUrl=webUrl2
	//window.clearInterval(timer); 
	}
	
	
	//alert(webUrl)
	console.log(webUrl)
	var tdhtRid=75501330003
	URLstr(tdhtRid)
	var url=webUrl+"&rid="+tdhtRid
	$("#tdht").attr("href",url);
	document.getElementById("tdht").click();//打开页面后默认点击
	})
	/**
	点击按钮新公司
	*/
	$("#company_1").click(function(event) {
	var webUrl1=$("#mainframe").contents().find("#webUrls").val(); 
	
	if(webUrl1!=undefined){
	webUrl=webUrl1
	}else{
	webUrl2=$("#mainframe").contents().find("#hidden3").val(); 
      webUrl=webUrl2
	//window.clearInterval(timer); 
	}
	
	
	//alert(webUrl)
	console.log(webUrl)
	var mgRid=75501330004
	URLstr(mgRid)
	var url=webUrl+"&rid="+mgRid
	$("#company_1").attr("href",url);
	document.getElementById("company_1").click();//打开页面后默认点击
	})
	/**
	点击按钮新公司
	*/
	$("#company_2").click(function(event) {
	var webUrl1=$("#mainframe").contents().find("#webUrls").val(); 
	
	if(webUrl1!=undefined){
	webUrl=webUrl1
	}else{
	webUrl2=$("#mainframe").contents().find("#hidden3").val(); 
      webUrl=webUrl2
	//window.clearInterval(timer); 
	}
	
	
	//alert(webUrl)
	console.log(webUrl)
	var hgRid=75501330005
	URLstr(hgRid)
	var url=webUrl+"&rid="+hgRid
	$("#company_2").attr("href",url);
	document.getElementById("company_2").click();//打开页面后默认点击
	})
	})
	
			
	</script>
</head>
<body class="frameset">
	<div class="container-top">
		<!-- LOGO -->
		<div class="logo">
			<img src="${ctx}/resources/img/logo.png" border="0" style="margin: 10px 0" />
		</div>
		
		
       <a  type="hidden" href=""id="a_hidden"   target="main"></a>
		<!-- 公司查询 -->
		<form action="${ctx}/admin/tdht/data/doGet" id="myform" name="myform" method="post"  target="main">
	    <div class="quick-link"  style="top:23px;padding-right: 300px; font-size: 18px;font-weight:bold;"><input type="text" name="mainRID" style="width:200px; "/>
	    <input name="search" class="btn-big"  type="submit" value="查询" /></div>
	    </form>
		
		<!-- 退出 -->
		<div class="quick-link" style="width:150px;">
			<p>
				<strong>${user.realName}</strong> &lt;${user.account}&gt; | 
				<a href="${ctx}/logout">退出</a>
			</p>
		</div>
	</div>
	<!-- 主菜单 -->
	<%--<div id="menudiv" class="navigation">
		<a  id="menuid" href="${ctx}/admin/index">首页</a>
		<c:forEach items="${sys_menus }" var="menu" varStatus="stats">
			<a id="menua${stats.index}"  href="${ctx}/admin/sys/sysMenu/mainMenu?parentId=${menu.menuId }" <c:if test="${currentFirstMenu == menu.menuId}"> class="current" </c:if>>${menu.fullName }</a>
		</c:forEach>
	</div>--%>
	
	<div style="width:100%;height:38px;background-color: #3498db;overflow: hidden;">
	<ul class="nav" style="position: absolute;z-index: 999;left:10%;">  
         <li><a id="indexa" href="${ctx}/admin/sys/sysMenu/mains"   target="main">首页</a></li>  
     	<li><a href="${ctx}/admin/tdht/data/areaHtml?area=baoan" target="main">地图定位</a></li>  
    	<li><a  id="data1" href=""+  target="main">监测数据</a>  
         <ul>  
          <li><a id="data2" name="webUrl" href="" target="main">实时数据</a></li>  
          <li><a target="main">历史数据</a>  
             <ul>  
                 <li><a id="data3"href="" target="main">日结报表</a>  
                 <li><a id="data4"href="" target="main">历史报表</a>  
                 <li><a id="data5"href="" target="main">水平衡分析</a>
            </ul>  
          </li>  
         </ul>  
     </li> 
     <li><a target="main">图形曲线</a>  
         <ul>  
          <li><a  target="main">监测曲线</a>  
             <ul>  
                 <li><a id="data6"href="" target="main">工业给水</a>  
                 <li><a id="data7"href="" target="main">生活给水</a>  
                 <li><a id="data8"href="" target="main">工业排水</a>
                 <li><a href="#" target="main">生活排水</a>  
             </ul>  
          </li>  
          <li><a  target="main">曲线分析</a>  
             <ul>
                 <li><a id="data9"href="" target="main">流量汇总</a>  
                 <li><a id="data10"href="" target="main">流量系数</a>  
                 <li><a id="data11"href="" target="main">流量日结</a>  
            </ul>  
          </li>  
         </ul>  
     </li>  
     <li><a id="data12"href="" target="main">预警报警</a></li>  
     <li><a id="data13"href="" target="main">监测单元信息</a></li>
     <c:if test="${webCompany.companyId ==1000}">
     <li><a href="#" target="main">设备管理</a>  
         <ul>
          <li><a id="data14" href="" target="main">设备状态</a></li>  
          <li><a id="data15" href="" target="main">设备控制</a></li>  
         </ul> 
     </li>  
     <li><a href="${ctx}/admin/sys/sysMenu/menuList" target="main">系统管理</a></li>
     </c:if>
</ul>  
	</div>
	

	<!--左侧树形菜单 -->
	<div class="container-main" >
		<!-- content-left   -->
		<div class="content-left"  id="leftMenu">
		<ul class="sidebar" style="height:100%;">
		<c:if test="${webCompany.companyId ==1 or webCompany.companyId ==1000}">
		<li><a id="yyf"href="" target="main" >永艺发</a></li>
		</c:if>
		<c:if test="${webCompany.companyId ==2 or webCompany.companyId ==1000}">
		<li><a id="odk" href="" target="main">欧达可</a></li>
		</c:if>
		<c:if test="${webCompany.companyId ==3 or webCompany.companyId ==1000}">
		<li><a id="tdht" href="" target="main">天地互通</a></li>
		</c:if>
		<c:if test="${webCompany.companyId ==4 or webCompany.companyId ==1000}">
		<li><a id="company_1" href="" target="main">XX公司</a></li>
		</c:if>
		<c:if test="${webCompany.companyId ==5 or webCompany.companyId ==1000}">
		<li><a id="company_2" href="" target="main">XX公司</a></li>
		</c:if>
		</ul>
      			<%--<ul id="sidebar" class="sidebar">
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
		              				<li>
		              					<c:choose>
				              			<c:when test="${cmenu.target=='Click' }">
				              			<a href="#">${cmenu.fullName}</a>
				              			</c:when>
				              			<c:otherwise>
		                          		<a id="alink" href="${ctx}/${cmenu.navigateUrl}" target="main">${cmenu.fullName }</a>
		                          		</c:otherwise>
		                          		</c:choose>
		                          		
		                          			<ul>
		              							<c:forEach items="${cmenu.childMenuList }" var="cmenus" varStatus="status3">
		              							<li onclick="switchMod(this.id.replace('nav-', ''));" id="nav-${cmenus.menuId}">
					                          	<a id="alink" href="${ctx}/${cmenus.navigateUrl}?parentId=${cmenus.menuId }" target="main">${cmenus.fullName }</a></li>
				              					</c:forEach>
	                      					</ul>
		                          		
		                          	</li>
	                          	</c:forEach>
	                      	</ul>
	          			</li>
      				</c:forEach>
      			</ul>--%>
<%--<script>
    $(function () {
        $("#sidebar").accordion({
            accordion: true,
            speed: 200,
    	    closedSign: '[+]',
    		openedSign: '[-]'
    	});
    });
</script>
			
		--%></div>
		<!-- end content-left   -->
		
		
		<div id="iframe_div" class="content-main">
			<iframe height="100%" frameborder="0" scrolling="auto"
				allowtransparency="true" class="iframe-main" marginheight="0"
				marginwidth="0" name="main" id="mainframe" src=""></iframe>
		</div>
		
	</div>
	<script type="text/javascript">
	
//	var statisDate = window.frames["mains"].document.getElementById('webUrls').value; 

	
		/* $(function() {
		//	alert(statisDate);
			//alert(document.getElementById("indexa").href);
			var input=$("#aaa").attr("href");
			
			if(input==""){
			   document.getElementById("indexa").click();//打开页面后默认点击
			}else{
			document.getElementById("aaa").click();//打开页面后默认点击
			}
			
		/**	var s = $('#sidebar').css('overflow', 'auto');
			var t = s.offset().top
			function onResize() {
				var height = document.body.offsetHeight - t;
				$('#sidebar').height(height);
				$('#mainframe').height(height);
			}
		**/
	
		/* 	window.onresize = onResize;

			onResize(); */

	//	})() */

	</script>
	
</body>
</html>