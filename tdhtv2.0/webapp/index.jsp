<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta name="renderer" content="webkit"/> 
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" />
<title>水污染源及水平衡在线监控系统</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<script type="text/javascript" src="${ctx}/resources/js/left/jquery.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/resources/newLog/js/jquery.cookie.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/resources/newLog/js/jquery.fullbg.min.js" charset="UTF-8"></script>
<link href="${ctx}/resources/img/icon.ico" rel="Shortcut Icon"/>


<link href="${ctx}/resources/indexjs/snow.css" rel="stylesheet" type="text/css" media="all">
<link href="${ctx}/resources/indexjs/style.css" rel="stylesheet" type="text/css" media="all">
<link href="${ctx}/resources/indexjs/font-awesome.css" rel="stylesheet"> 

<link href="${ctx}/resources/indexjs/css" rel="stylesheet">
<link href="${ctx}/resources/indexjs/css(1)" rel="stylesheet">
<link href="${ctx}/resources/indexjs/css(2)" rel="stylesheet" type="text/css">



<!--[if IE 6]>
<script type="text/javascript" src="js/ie6-min.js"></script>
<script type="text/javascript">
DD_belatedPNG.fix('.png, background,img');
</script>

<![endif]-->


<!--[if gte IE 8]> 
<link href="resources/newLog/css/ie8.css" type="text/css" rel="stylesheet" />

 <![endif]--> 

<script type="text/javascript">

 
// 设置为主页 
function SetHome(obj,vrl){ 
try{ 
obj.style.behavior='url(#default#homepage)';obj.setHomePage(vrl); 
} 
catch(e){ 
if(window.netscape) { 
try { 
netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect"); 
} 
catch (e) { 
alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。"); 
} 
var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch); 
prefs.setCharPref('browser.startup.homepage',vrl); 
}else{ 
alert("您的浏览器不支持，请按照下面步骤操作：1.打开浏览器设置。2.点击设置网页。3.输入："+vrl+"点击确定。"); 
} 
} 
} 
// 加入收藏 兼容360和IE6 
function shoucang(sTitle,sURL) 
{ 
try 
{ 
window.external.addFavorite(sURL, sTitle); 
} 
catch (e) 
{ 
try 
{ 
window.sidebar.addPanel(sTitle, sURL, ""); 
} 
catch (e) 
{ 
alert("加入收藏失败，请使用Ctrl+D进行添加"); 
} 
} 
} 
</script>

<script>
			$(function() {				
				$('#gallery').poptrox({
					usePopupCaption: true
				});
			
			});
		</script>
		<script>
			$(function() {				
				$('#app').toggle( 
				 function(){$("#app_img").show()} ,
             function(){$("#app_img").hide()} 

			)
			});
		</script>
</head>
<body style="background-image: url('${ctx}/resources/newLog/img/logbackground.jpg');">
<%-- <img id="body-img"src="${ctx}/resources/newLog/img/logbackground.jpg" alt="" id="background"  style="width:100%;height:100%;"/> --%>

			<div class="main">
				<div style="background-color:white;opacity:0.8;whidth:100%;height:100%;"><h1 >流域水环境精细化管理决策支持系统</h1></div>
					<div class="banner-right">
						<div class="banner-right-info">
							<!-- <p>Our website is under construction. We`ll be here soon with our new awesome site, subscribe to be notified.</p> -->
						</div>
						<!--timer-->
						<div class="agileits-timer"style="position: absolute;top: 300px; left: 225px;"> 
							<div class="clock">
							<a href="http://www.tdhtiot.com:3333/indexs.jsp">
								<div class="column days" style="display: inline-block;border-left-width: 0px;">
									<div class="timer" id="days"><img id="body-img"src="${ctx}/resources/newLog/img/but1.png" alt="" /></div>
									<div class="text">水污染源监测系统</div>
								</div>
							</a>
								<div class="timer days" style="display: inline-block;"></div>
								
							<a href="http://120.76.233.59:8089/">	
								<div class="column">
									<div class="timer" id="hours"><img id="body-img"src="${ctx}/resources/newLog/img/but1.png" alt="" /></div>
									<div class="text">水环境监测系统</div>
								</div>
							</a>	
								<div class="timer"></div>
								
							<a href="http://www.tdhtiot.com:3346">	
								<div class="column">
									<div class="timer" id="minutes"><img id="body-img"src="${ctx}/resources/newLog/img/but1.png" alt="" /></div>
									<div class="text">智慧水务监测系统</div>
								</div>
							</a>
								<div class="timer"></div>
								<%-- <div class="column">
									<div class="timer" id="seconds"><img id="body-img"src="${ctx}/resources/newLog/img/but1.png" alt="" /></div>
									<div class="text">Seconds</div>
								</div> 
								<div class="clear"> </div>--%>
							</div>	 
						</div>
						<!--//timer-->
						<!--newsletter-->
				</div>
				
				<div class="w3layouts_copy_right"  style="margin-top: 26%;">
					<div class="container">
						<p>版权所有：© 深圳市天地互通科技有限公司 | 版本号：TDHTv2.0</p>
					</div>
				</div>
			</div>



		
						<%-- <div style="width:100%;height:100%;"> 
						<div class="login-box-body" >
						
						<div style="width:30%;height:50%;">
						<a><img id="body-img"src="${ctx}/resources/newLog/img/but1.png" alt="" /><br />水污染源在线监测系统</a>
						</div>
						
						<div style="width:30%;height:50%;">
						<a><img id="body-img"src="${ctx}/resources/newLog/img/but1.png" alt="" /><br />水环境在线监测系统</a>
						</div>
						
						<div style="width:30%;height:50%;">
						<a href="http://demos.sucaihuo.com/modals/37/3774/demo/#"><img id="body-img"src="${ctx}/resources/newLog/img/but1.png" alt="" /><br />智慧水务在线监测系统</a>
						</div>
						
						<img id="body-img"src="${ctx}/resources/newLog/img/log.png" alt="" />
						</div>
						</div> --%>
			 		
<script type="text/javascript">
		(function() {
			var f = $('#footer').height(), h = $('#container-height').height(), mh = $(
					'#main').outerHeight();

			function onResize() {
				var dh = document.body.offsetHeight;
				t = Math.max(30, Math.round(dh / 2 - mh / 2))
				height = dh - t - f - 1;

				$('#header').css('height', t + 'px');

				height = height > h ? height : h;

				$('#container-height').css('height', height);
			}
			window.onresize = onResize;

			onResize();

			$('input:text,input:password').bind(
					'focus blur mouseover mouseout',
					function(e) {
						if (e.type == 'focus' || e.type == 'mouseover') {
							$(this).addClass('input-text-hover');
						} else {
							if (e.type == 'blur'
									|| document.activeElement != this) {
								$(this).removeClass('input-text-hover');
							}
						}
					});

		})();
		
		
	</script>
</body>
</html>