<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>水污染源及水平衡在线监控系统</title>
<script src="${ctx}/resources/js/metismenu/jquery.min.js"></script>
<script src="${ctx}/resources/js/metismenu/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/left/jquery-1.4.3.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/resources/js/left/jquery.min.js" charset="UTF-8"></script>
<script src="${ctx}/resources/js/background/jquery.MyFloatingBg.js"></script>
<script src="${ctx}/resources/js/metismenu/accordion.js"></script>
<script src="${ctx}/resources/js/ajax.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-ui-jqLoding.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/zDialog.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/zDrag.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/fileClick.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/css3-mediaqueries.js"></script>
<link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />
<link href="${ctx}/resources/css/left/default.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/left/foundation.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/left/normalize.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/left/styles.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/img/icon.ico" rel="Shortcut Icon">
<link rel="stylesheet" href="${ctx}/resources/css/lanrenzhijia.css" media="all">

<!--[if IE 8]>
<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if  IE 7]>
<link href="${ctx}/resources/css/ie7.css"	type="text/css" rel="stylesheet" />
<![endif]-->

<style>

html, body {
	height: 100%;
	overflow-y: hidden;
}
#top ul.sidebar ul { margin:0px 0px 0px 15px; padding: 0;display: none;} 
input:-webkit-autofill {
-webkit-box-shadow: 0 0 0px 1000px #FFFFFF inset;   
}  

@media (min-width: 768px){
body{
  overflow: auto;
}
.container {
   width:1100px;
    margin-left: 0px;
    margin-right: auto;
}

}
@media (min-width: 992px){
body{
  overflow: auto;
}
.container {
   width:1100px;
    margin-left: 12%;
    margin-right: auto;
}
}
@media (min-width: 1200px){
body{
  overflow: hidden;
}
.container {
   width:1100px;
    margin-left: 12%;
    margin-right: auto;
}
}

*{  
margin:0;  
padding:0;  
}  
#top ul{  
list-style:none;  
} 
.nav{  
font-size:18px;  

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
/*margin-top:1px;  */
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
/*margin-left:1px;  */
}  
/*鼠标移到相应二级菜单元素上显示三级菜单*/  
.nav li ul li:hover ul{  
display:block;  
position:absolute;  
top:0px;  
left:136px;  
}  

.black {
color:#000;
}
.gray {
color:#b3b3b3;
}


</style>

<script type="text/javascript">


//验证表单
	function checkForm(){
	var t1=document.getElementById("emil").value;

		if(!t1){
			alert("邮箱不能为空！");
			return false;
		}
		if(!titles){
			alert("标题不能为空！");
			return false;
		}
		
		return true;
	}


$(document).ready(function () {
		//新增
		$("#add-btn").click(function () {
			if(checkForm()){
				$.ajax({
	                type: "POST",
	                url:${ctx}"/admin/tdht/feedback/saveFeedback",
	                data:$('#loginform').serialize(),
	                dataType: 'json',
	                error: function(request) {
	                	infoMsg("提交失败");
	                },
	                success: function(data) {
	                	if(data.success){
	                	document.getElementById("gbss").click();
	                		$('#loginform')[0].reset(); 
	                		infoMsg(data.msg);
	                	}else{
	                	alert("添加成功！");
	                		infoMsg(data.msg);
	                	}
	                }
	            });
			}
		});
	});


jQuery(document).ready(function($) {
	$('.theme-login').click(function(){
		$('.theme-popover-mask').fadeIn(100);
		$('.theme-popover').slideDown(200);
	})
	$('.theme-poptit .close').click(function(){
		$('.theme-popover-mask').fadeOut(100);
		$('.theme-popover').slideUp(200);
	})

})


$(function(){
   var  imrid=${webCompany.rid};
   // document.getElementById("yyf").click();//打开页面后默认点击
  //doAjax(imrid);
     click_com();
     if(${webCompany.companyId ==1000}){
   URLstr(imrid)
   }else  if(${webCompany.companyId ==2000}){
    URLstr2(imrid)
   }
   $("#img_div").css("left","0px")
 $("#iframe_div").css("left","30px")
  $("#leftMenu").css("left","-140px")
/* 左导航隐藏*/
	$("#iframe_div").css("left","30px")　　　
    	  $("#img_div").toggle( 
        function(){$("#leftMenu"). animate({left:"0px"},200);$("#img_div"). animate({left:"140px"},200);$("#iframe_div"). animate({left:"160px"},200);$("#img").attr('src',"${ctx}/resources/img/left.png"); } ,
       function(){$("#leftMenu"). animate({left:"-140px"},200);$("#img_div"). animate({left:"0px"},200);$("#iframe_div"). animate({left:"30px"},200);$("#img").attr('src',"${ctx}/resources/img/right.png");} 
)

$("#img").hover(function(){
$("#img").css("background-color","#F0F0F0");
},function(){
$("#img").css("background-color","#fff");
});
$("#img_find").css("width","40px");

$("#img_div2").hover(function(){
$("#img_find").css("width","50px");
},function(){
$("#img_find").css("width","40px");
});
   $("#img_find").click(function(){
   $("#sub_but").click();
    
});
   

 var winWidth = window.innerWidth;

	$("#top").css("width",winWidth)

})


</script>
<script type="text/javascript">
	var timerr;
	var urll;
	var boo=true;
function bb(){
	
	
	}
	function startaa(Rid){
   //alert(Rid+"    33")
			  var webUrl=$("#mainframe").contents().find("#hidden2").val(); 
			  urll=webUrl; 
			  //alert(urll+"    33")
			 boo=false;
			}
	
	 $(function(){ 
		 
		 $("#top a").click(function() {
		  boo=true; 
urll=""; 
	})
	/*$("#top a").click(function(event) {
	    
				if($(this).text()=="首页"){//获取并判断主菜单的值
				
				$("#leftMenu").hide();
					$("#iframe_div").css("left","0")
				}else{
				$("#leftMenu").hide();
					$("#iframe_div").css("left","130px")
					$("#leftMenu").show();
				} 
				});  */
	var webUrl
	var webUrl1
	 var webUrl2
	 
	
		 $("#baoan").click(function(event) {
		var area=$("#mainframe").contents().find("#areatype").val(); 
			 if(area==1){
			  document.getElementById("baoans").click();
			  }
		
		 	}
		 )
	
	 
	
	
	/**
	点击按钮永艺发
	
	$("#yyf").click(function(event) {
		setTimeout("clickyyf()",1000); 
	})
	*/
	/**
	点击按钮欧达可
	
	$("#odk").click(function(event) {
		setTimeout("clickodk()",1000); 
//	clickodk()
	})
	*/
	/**
	点击按钮天地互通
	
	$("#tdht").click(function(event) {
		setTimeout("clicktdht()",1000); 
//	clicktdht()
	})
	*/
	/**
	点击按钮新公司
	
	$("#company_1").click(function(event) {
		setTimeout("clickzckj()",1000); 
//clickzckj()
	})
	*/
	/**
	点击按钮新公司

	$("#company_2").click(function(event) {
		setTimeout("clickryf()",1000); 
	//clickryf()
	})
		*/
	
	})
	
	
	
			
	</script>
</head>
<body class="frameset" style="width:100%">
<div >
	<div class="container-top">
		<!-- LOGO -->
		<div class="logo">
			<img src="${ctx}/resources/img/logo2.png" border="0" style="margin: 10px 0" />
			
			
</div>
<%--<div id="demoDiv1" bg="${ctx}/resources/img/background/b106fca84153.jpg" class="m"style="height:180px;">
  <div style="color:#fff">
      7 billion friends
  </div>
</div>
<%--<div id="demoDiv2" bg="${ctx}/resources/img/background/b106fca84153.jpg" class="m" style="height:180px;">
  <div style="color:#fff">
     地下管网在线采集系统
  --%></div>
</div>
		</div>
		
		<a  type="hidden" href=""id="a_img"   target="main"></a>
       <a  type="hidden" href=""id="a_hidden"   target="main"></a>
       <a  type="hidden" href="${ctx}/admin/tdht/data/areaHtml" id="baoans"  target="main"></a>
		<!-- 公司查询 -->
		
		<c:if test="${webCompany.companyId ==1000}">
		
		<form action="${ctx}/admin/tdht/data/doGet" id="myform" name="myform" method="post"  target="main">
	    <div class="quick-link"  style="top:23px;padding-right: 300px; font-size: 18px;font-weight:bold;">
	   <input id="input_find" placeholder="请输入监控单元名称或者编号"type="text" name="mainRID"style="width:250px;height:40px;position: absolute;top: 0px;right: 250px;" />
        <div id="img_div2"style="width:60px;height:60px; position: absolute;top: 3px;right: 250px;cursor:pointer; ">
	    <img alt="搜索" src="${ctx}/resources/img/find.png"id="img_find"  >
	    <button  id="sub_but" type="submit" style="display:none" ></button>
	   </div>
	    </div>
	    </form>
		</c:if>
		<!-- 退出 -->
		<div class="quick-link" style="width:150px;">
			<p style="position:absolute;top:8px;right:0; width:250px; text-align:right; padding-right:10px;">
				<strong>${user.realName}</strong> &lt;${user.account}&gt; | 
				<a style="color:black"href="${ctx}/logout">退出</a>
			</p>
			<div style="margin-top: 30px;font-size: 12;"><a style="color:black"href="javascript:;" class="btn btn-primary btn-large theme-login" >反馈</a></div>
			
		</div>
	</div>
	<!-- 意见反馈 -->
		<div class="theme-popover">
		     <div class="theme-poptit">
		          <a href="javascript:;" id="gbss" title="关闭" class="close">×</a>
		          <h3>意见反馈</h3>
		     </div>
		     <div class="theme-popbod dform">
		           <form class="theme-signin" id="loginform"  name="loginform" action="" method="post">
		                <ol>
		                     <li><strong>邮箱：</strong><input name="emil" type="text" class="ipt" id="emil"  style="width:400px" size="50" /></li>
		                     <li><strong>标题：</strong><input name="title" type="text" class="ipt" id="titles"  style="width:400px" /></li>
		                     <li><strong>内容：</strong><textarea rows="30" cols="40" id="content" name="contentss" class="ipt" style="width:400px;height:200px;" ></textarea></li>
		                     <li style="padding-left: 250px;"><input class="btn btn-primary" type="button" id="add-btn"name="submit" value=" 提交 " /></li>
		                </ol>
		           </form>
		     </div>
		</div>
	
	
	
	<!-- 主菜单 -->
	<%--<div id="menudiv" class="navigation">
		<a  id="menuid" href="${ctx}/admin/index">首页</a>
		<c:forEach items="${sys_menus }" var="menu" varStatus="stats">
			<a id="menua${stats.index}"  href="${ctx}/admin/sys/sysMenu/mainMenu?parentId=${menu.menuId }" <c:if test="${currentFirstMenu == menu.menuId}"> class="current" </c:if>>${menu.fullName }</a>
		</c:forEach>
	</div>--%>
	<div style="background-color: #3498db;margin-top: 20px;">
	<div id="top" style="height:38px;background-color: #3498db;"class="container">
	<ul class="nav" style="z-index: 999;position: relative;">
         <li><a id="indexa" href="${ctx}/admin/sys/sysMenu/mains"   target="main">首页</a></li>
         <li><a id="data13"href="" target="main">监测单元信息</a></li>
     	<li><a href="${ctx}/admin/tdht/data/areaHtml?area=baoan" target="main">地图定位</a></li>  
    	<li><a  target="main">监测数据</a>
         <ul>
          <li><a id="data2" name="webUrl" href="" target="main">实时数据</a></li>  
          <li><a id="data20" name="webUrl" href="" target="main">历史数据</a><!--
             <ul>
                 <li><a id="data3"href="" target="main">日结报表</a>
                 <li><a id="data4"href="" target="main">历史报表</a>
                 <li><a id="data5"href="" target="main">水平衡分析</a>
                 <li><a id="data55"href="" target="main">污染物汇总</a>
            </ul>  
          --></li>  
         </ul>  
     </li> 
     <li><a id="data21" name="webUrl" href="" target="main">图形曲线</a>  
          <!-- <ul>  
          
            <ul>  
               <!--  <li><a id="data6"href="" target="main">工业给水</a>  </li>  
                 <li><a id="data7"href="" target="main">生活给水</a>  </li> 
                 <li><a id="data8"href="" target="main">工业排水</a></li></ul>
                 <%--  
                 <li><a onclick="alert('该功能未开放')"target="main">生活排水</a>  </li>  
             --%></ul>  
          </li>  
          <li><a  target="main">曲线分析</a>  
             <ul>
                 <li><a id="data9"href="" target="main">流量汇总</a>  </li>  
                 <li><a id="data10"href="" target="main">流量系数</a>  </li>  
                 <li><a style="display:none" id="data11"href="" target="main">流量日结</a></li>  
                 <li><a id="data17" href="" target="main">污染物分析</a>  </li>  
            </ul>  
          </li>  
         </ul>  -->
     </li><!--  
     <li><a id="data12"href="" target="main">预警报警</a></li>  
     
     --><c:if test="${webCompany.companyId ==1000}">
     <li><a  target="main">设备管理</a>  
         <ul>
          <li><a id="data14" href="" target="main">设备状态</a></li>  
          <li><a id="data15" href="" target="main">设备控制</a></li>
          <li><a id="data18" href="" target="main">操作日志</a></li>
          <li><a id="data19" href="" target="main">设备日志</a></li>
         </ul> 
     </li>  
     </c:if>
     <c:if test="${webCompany.companyId ==2000}">
     <li><a  target="main">设备管理</a>  
         <ul>
          <li><a id="data14" href="" target="main">设备状态</a></li>  
          <li><a id="data15" href="" target="main">设备控制</a></li>
          <li><a id="data18" href="" target="main">操作日志</a></li>
          <li><a id="data19" href="" target="main">设备日志</a></li>
         </ul> 
     </li>  
     </c:if>
     <li><a href="${ctx}/admin/tdht/company/video" target="main">视频</a></li> 
    <li><a href="${ctx}/admin/sys/sysMenu/menuList" target="main">系统管理</a></li> 
     
</ul>  
</ul>  
	</div>
	</div>
	<div class="container-main" style="height:100% ;">
	
          <div class="content-left"  id="leftMenu"style="height:88% ;float: left;border-bottom:4px solid white" >
	<!--左侧树形菜单 -->
	
		<%--<!-- content-left   -->
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
      			
      			
      	--%>
      	<div class="htmleaf-container" style=" height:100% ;width:100%;float: left;" >
      	
      	<div class="htmleaf-content bgcolor-3" style="height:100% ;background-color:#3498DB; border-top:1px solid white;border-bottom:1px solid white;padding-top: 0px;">
			<!-- This is mtree list -->
			<ul class=mtree style="height:100% ;background-color:#3498DB">
			  <li><a href="#">深圳市</a>
			    <ul>
			      <li><a id="baoan" href="">宝安区</a>
			        <ul>
			           <c:forEach items="${company}" var="bean">
			           <li><a id="yyf"href="#"value="${bean.rid}"onclick='clickCom(${bean.rid})' >${bean.companyName}</a><a id="yyf1"href="" style="display: none;" target="main" ></a></li>
			           </c:forEach><%--
			        
			        
			        
		                  <li><a id="yyf"href="#"  >永艺发</a><a id="yyf1"href="" style="display: none;" target="main" ></a></li>
		                 <li><a id="odk" href="#" >欧达可</a><a id="odk1"href="" style="display: none;" target="main" ></a></li>
		                 <li><a id="tdht" href="#" >天地互通</a><a id="tdht1"href="" style="display: none;" target="main" ></a></li>
		                 <li><a id="company_1" href="#" >中村科技</a><a id="company_11"href="" style="display: none;" target="main" ></a></li>
		                 <li><a id="company_2" href="#" >瑞云峰</a><a id="company_22"href=""style="display: none;" target="main" ></a></li>
			        --%></ul>
			      </li>
			      <li><a href="#">罗湖区</a></li>
			      <li><a href="#">福田区</a></li>
			      <li><a href="#">南山区</a></li>
			      <li><a href="#">盐田区</a></li>
			      <li><a href="#">龙华区</a></li>
			      <li><a href="#">光明区</a></li>
			      <li><a href="#">龙岗区</a></li>
			      <li><a href="#">坪山区</a></li>
			      <li><a href="#">大鹏区</a></li>
			   </ul>
			  </li>
			  <li><a href="#">广州市</a></li>
			  
			</ul>
		</div>
		
				
      		
	</div>
      			
      		</div>	
      		<div id="img_div"style="width: 30px;height: 100%;position: absolute;top: 380px;left: 140px;" >
      		<img id="img"style="width:25px ;cursor:pointer; "src="${ctx}/resources/img/right.png"  />
      		
      		
      			
      			</div>
      			
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
			
		--%>
		<!-- end content-left   -->
		
		<main>
		<div id="iframe_div" class="content-main" >
			<iframe height="100%" frameborder="0" scrolling="auto"
				allowtransparency="true" class="iframe-main" marginheight="0"
				marginwidth="0" name="main" id="mainframe" src="">
				</iframe>
		</div>
		</main>
		
	</div>
	</div>	
	
	<script src="${ctx}/resources/js/left/stopExecutionOnTimeout.js?t=1"></script>
	<%--<script src='http://libs.useso.com/js/jquery/1.8.0/jquery.min.js'></script>
	--%><script src="${ctx}/resources/js/left/jquery.velocity.min.js"></script>

	<script>
	;(function ($, window, document, undefined) {
	    if ($('ul.mtree').length) {
	        var collapsed = true;
	        var close_same_level = false;
	        var duration = 400;
	        var listAnim = true;
	        var easing = 'easeOutQuart';
	        $('.mtree ul').css({
	            'overflow': 'hidden',
	            'height': collapsed ? 0 : 'auto',
	            'display': collapsed ? 'none' : 'block'
	        });
	        var node = $('.mtree li:has(ul)');
	        node.each(function (index, val) {
	            $(this).children(':first-child').css('cursor', 'pointer');
	            $(this).addClass('mtree-node mtree-' + (collapsed ? 'closed' : 'open'));
	            $(this).children('ul').addClass('mtree-level-' + ($(this).parentsUntil($('ul.mtree'), 'ul').length + 1));
	        });
	        $('.mtree li > *:first-child').on('click.mtree-active', function (e) {
	            if ($(this).parent().hasClass('mtree-closed')) {
	                $('.mtree-active').not($(this).parent()).removeClass('mtree-active');
	                $(this).parent().addClass('mtree-active');
	            } else if ($(this).parent().hasClass('mtree-open')) {
	                $(this).parent().removeClass('mtree-active');
	            } else {
	                $('.mtree-active').not($(this).parent()).removeClass('mtree-active');
	                $(this).parent().toggleClass('mtree-active');
	            }
	        });
	        node.children(':first-child').on('click.mtree', function (e) {
	            var el = $(this).parent().children('ul').first();
	            var isOpen = $(this).parent().hasClass('mtree-open');
	            if ((close_same_level || $('.csl').hasClass('active')) && !isOpen) {
	                var close_items = $(this).closest('ul').children('.mtree-open').not($(this).parent()).children('ul');
	                if ($.Velocity) {
	                    close_items.velocity({ height: 0 }, {
	                        duration: duration,
	                        easing: easing,
	                        display: 'none',
	                        delay: 100,
	                        complete: function () {
	                            setNodeClass($(this).parent(), true);
	                        }
	                    });
	                } else {
	                    close_items.delay(100).slideToggle(duration, function () {
	                        setNodeClass($(this).parent(), true);
	                    });
	                }
	            }
	            el.css({ 'height': 'auto' });
	            if (!isOpen && $.Velocity && listAnim)
	                el.find(' > li, li.mtree-open > ul > li').css({ 'opacity': 0 }).velocity('stop').velocity('list');
	            if ($.Velocity) {
	                el.velocity('stop').velocity({
	                    height: isOpen ? [
	                        0,
	                        el.outerHeight()
	                    ] : [
	                        el.outerHeight(),
	                        0
	                    ]
	                }, {
	                    queue: false,
	                    duration: duration,
	                    easing: easing,
	                    display: isOpen ? 'none' : 'block',
	                    begin: setNodeClass($(this).parent(), isOpen),
	                    complete: function () {
	                        if (!isOpen)
	                            $(this).css('height', 'auto');
	                    }
	                });
	            } else {
	                setNodeClass($(this).parent(), isOpen);
	                el.slideToggle(duration);
	            }
	            e.preventDefault();
	        });
	        function setNodeClass(el, isOpen) {
	            if (isOpen) {
	                el.removeClass('mtree-open').addClass('mtree-closed');
	            } else {
	                el.removeClass('mtree-closed').addClass('mtree-open');
	            }
	        }
	        if ($.Velocity && listAnim) {
	            $.Velocity.Sequences.list = function (element, options, index, size) {
	                $.Velocity.animate(element, {
	                    opacity: [
	                        1,
	                        0
	                    ],
	                    translateY: [
	                        0,
	                        -(index + 1)
	                    ]
	                }, {
	                    delay: index * (duration / size / 2),
	                    duration: duration,
	                    easing: easing
	                });
	            };
	        }
	        if ($('.mtree').css('opacity') == 0) {
	            if ($.Velocity) {
	                $('.mtree').css('opacity', 1).children().css('opacity', 0).velocity('list');
	            } else {
	                $('.mtree').show(200);
	            }
	        }
	    }
	}(jQuery, this, this.document));
	$(document).ready(function () {
	    var mtree = $('ul.mtree');
	    mtree.wrap('<div class=mtree-demo></div>');
	    var skins = [
	        'bubba',
	        'skinny',
	        'transit',
	        'jet',
	        'nix'
	    ];
	    mtree.addClass(skins[0]);
	    $('body').prepend('<div class="mtree-skin-selector"><ul class="button-group radius"></ul></div>');
	    var s = $('.mtree-skin-selector');
	    $.each(skins, function (index, val) {
	        s.find('ul').append('<li><button class="small skin">' + val + '</button></li>');
	    });
	    s.find('ul').append('<li><button class="small csl active">Close Same Level</button></li>');
	    s.find('button.skin').each(function (index) {
	        $(this).on('click.mtree-skin-selector', function () {
	            s.find('button.skin.active').removeClass('active');
	            $(this).addClass('active');
	            mtree.removeClass(skins.join(' ')).addClass(skins[index]);
	        });
	    });
	    s.find('button:first').addClass('active');
	    s.find('.csl').on('click.mtree-close-same-level', function () {
	        $(this).toggleClass('active');
	    });
	});
	</script>
	
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
	<script type="text/javascript">
$(document).ready(function(){
  //weather
	$("#demoDiv1").MyFloatingBg({direction:-1});
	$("#demoDiv2").MyFloatingBg({direction:0, speed:50});
});
</script>
	
</body>

</html>