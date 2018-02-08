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



<link href="resources/newLog/css/newlog.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/img/icon.ico" rel="Shortcut Icon"/>

<script  type="text/javascript" src="${ctx}/resources/newLog/js/jquery.poptrox.min.js"></script>

<!--[if IE 6]>
<script type="text/javascript" src="js/ie6-min.js"></script>
<script type="text/javascript">
DD_belatedPNG.fix('.png, background,img');
</script>

<![endif]-->


<!--[if gte IE 8]> 
<link href="resources/newLog/css/ie8.css" type="text/css" rel="stylesheet" />

 <![endif]--> 
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script> 
<script type="text/javascript">


	if(window.top==window.self){//不存在父页面
	}else{
		window.parent.location="${ctx}";
	} 
	
	document.onkeydown = keyDown; 

	function keyDown(e){ 
	if((e ? e.which : event.keyCode)==13 ){ 
	
	           
        	if ($("#account").val() == "") {
				errorMsg('请输入用户名！');
				return;
			}
			if ($("#password").val() == "") {
				errorMsg('请输入密码！');
				return;
			}
			$.ajax({
				type : 'POST',
				url : '${ctx}/login',
				data : $('#loginform').serialize(),
				dataType : 'json',
				async : false,
				error : function(request) {
					alert("服务器请求异常！");
				},
				success : function(data) {
					if (data.success == true || data.success == 'true') {
						Save();
						window.location = "${ctx}/admin/index";
					} else {
						$("#msg").html(data.msg);
					}
				}
			});
        	
        	
        } 
		
	} 
	
	
	function login(){   
			  
			  if ($("#account").val() == "") {
					errorMsg('请输入用户名！');
					return;
				}
				if ($("#password").val() == "") {
					errorMsg('请输入密码！');
					return;
				}
				
				$.ajax({
					type : 'POST',
					url : '${ctx}/login',
					data : $('#loginform').serialize(),
					dataType : 'json',
					async : false,
					error : function(request) {
						alert("服务器请求异常！");
					},
					success : function(data) {
					
						if (data.success == true || data.success == 'true') {
							Save();
							window.location = "${ctx}/admin/index";
						} else {
							
							$("#msg").html(data.msg);
						}
					}
				});
			  
		} 
	
      
     
    
$(function(){
	   $('#psssere').on('click',function() {
        	
        	if ($("#togglePassword").attr("checked")) {
        		
	   $("#password2").hide();
        	$("#password").val($("#password2").val())
        	$("#password").show();
	  $("#psssere").attr('src','${ctx}/resources/newLog/img/passere1.png'); 
	  $("#togglePassword").attr("checked", false);
	 $("#password2").attr("name","");
        	 $("#password").attr("name","password");
	
	
      }else{
    	  $("#password").hide();
    	  $("#password").attr("name","");
        	$("#password2").val($("#password").val())
        	$("#password2").show();
        	 $("#password2").attr("name","password");
	　$("#psssere").attr('src','${ctx}/resources/newLog/img/passere2.png'); 
	  $("#togglePassword").attr("checked", true);
    	 
}
        
		
        });
//$("#elementss").css({"-webkit-animation":"twinkling 2s infinite ease-in-out"}); //在对象element中添加闪烁动画
 var winWidth =window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
  
	$("#body-img").css("width",winWidth)
     
     var winheight = document.body.clientHeight;
	$("#body-img").css("height",winheight)
     
})
</script>
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
<script type="text/javascript">

    $(document).ready(function () {
    	 
    	
    	
    	
        if ($.cookie("rmbUser") == "true") {
        $("#ck_rmbUser").attr("checked", true);
        $("#account").val($.cookie("username"));
        $("#password").val($.cookie("password"));
        
        $("#imgrem").attr('src','${ctx}/resources/newLog/img/rem2.png'); 
        }
   });
     $(document).ready(function () {
$("#imgrem").on("click",function(){
　　　if ($("#ck_rmbUser").attr("checked")) {
	　$("#imgrem").attr('src','${ctx}/resources/newLog/img/rem1.png'); 
	$("#ck_rmbUser").attr("checked", false);
	
}else{
	$("#imgrem").attr('src','${ctx}/resources/newLog/img/rem2.png'); 
	$("#ck_rmbUser").attr("checked", true);
}
　　});
/*$(window).load(function() {
	$("#background").fullBg();account
});*/
 });
    
     
    //记住用户名密码
    function Save() {
        if ($("#ck_rmbUser").attr("checked")) {
            var str_username = $("#account").val();
            var str_password = $("#password").val();
            $.cookie("rmbUser", "true", { expires: 7 }); //存储一个带7天期限的cookie
            $.cookie("username", str_username, { expires: 7 });
            $.cookie("password", str_password, { expires: 7 });
        }
        else {
            $.cookie("rmbUser", "false", { expire: -1 });
            $.cookie("username", "", { expires: -1 });
            $.cookie("password", "", { expires: -1 });
        }
    };
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
<body>
<img id="body-img"src="${ctx}/resources/newLog/img/logbackground.png" alt="" id="background" />
	<div id="a_top"><a href="javascript:void(0)" class="right_top"onclick="shoucang(document.title,window.location)">加入收藏</a>&nbsp;<span style="color:#fff">|</span>&nbsp;<a href="javascript:void(0)"class="right_top" onclick="SetHome(this,window.location)">设为首页</a></div>

		<%--<div class="png login-cover-layer">
			<div class="login-content" id="main">
				<div class="login-left">
					<div class="login-left-header">
					</div>
					<div class="png login-left-body-common" style="font-size: 22;text-align: center;"><br /><!--
					<div style="text-align: left;">
					&nbsp;&nbsp;&nbsp;&nbsp;深圳市天地互通物联网科技有限公司紧跟时代脉搏，专注环境保护，结合微电子、精密探测、融合通讯、流程化应用等最新技术发展趋势，立足大数据、云平台
					、移动应用等物联网特点，在已有成熟技术的基础上，提供城市与园区或者指定区域与流域范围内的地下、地面大数据的采集、传输、分析、与行业应用结合的综合服务。
					实现人与自然、发展与持续、监管者与城市大众之间的和谐相处。</div>
					--></div>
				</div>
				<div class="login-right">
					<div class="login-box">
						<div class="login-box-header">
							<div class="login-logo">
								<a href=""><img src="resources/img/logo.png" class="png"
									border="0"></a>
							</div>
							<div class="login-box-header-ext">
								<!-- 还没有云票务帐号？<a href="register/">立即开通</a> -->
							</div>
						</div>    --%><!--
						 

						<div><img src="${ctx}/resources/newLog/img/font.png" class="imgtop font-img"></div>
						-->
						<div style="width:100%;height:100%;"> 
						<div id="log"class="login-box-body" >
						<img id="body-img"src="${ctx}/resources/newLog/img/log.png" alt="" />
						    <div id="logform">
						<form action="" method="post" class="login-form" id="loginform">
						<input type="hidden" id="ipAddress" name="ipAddress">
								<table border="0" cellpadding="0" cellspacing="0" align="center"style="margin-left: 0px;">
									
									<tr>
										<th align="right"></th>
										<td align="left"
											style="padding-top: 0; padding-bottom: 0; height: 16px"><div
												class="red" style="font-size: 12px; color: #f00"></div></td>
									</tr>
									<tr>
										
										<td align="left">
										<div id="userdiv"class="input-text"style="position:relative; margin-top:65px;margin-left:20px; margin-bottom: 13px";>
											<img src="${ctx}/resources/newLog/img/username.png" class="imgtop"/>	<input  class="input_1"name="account" placeholder="   用户名"id="account" type="text" value="75503780001" size="30"/>
											</div></td>
									</tr>
									<tr>
										
										<td align="left">
										<div id="userdiv"class="input-text" style="position:relative; margin-left:20px;">
										<img src="${ctx}/resources/newLog/img/pass.png"class="imgtop"/>
										<input class="input_1" placeholder="   密码"name="password" id="password"type="password" size="30"  value="1"maxlength="16" />
										<input class="input_1" placeholder="   密码"name="" id="password2"type="text" size="30"  value=""maxlength="16" style="display:none"/>
										<div id="imgere"><img id="psssere"src="${ctx}/resources/newLog/img/passere1.png"/></div>
											 </div></td>
									</tr>
									<tr>
										<td align="left"><div><img id="imgrem" src="${ctx}/resources/newLog/img/rem2.png" /><input name="Fruit" id="ck_rmbUser" type="checkbox" checked="checked"value="" class="checkbox" style="display:none"/><div id="rember">记住密码</div></div></td>
										<td align="right">&nbsp;&nbsp;<div id="gallery"style="    position: absolute;top: 5px;right: 5px; width: 100px;"> <a id="forget"  href="${ctx}/resources/newLog/img/rem.png">忘记密码?</a></div><input name="Fruit"id="togglePassword" type="checkbox" value="" class="checkbox" style="display:none"/></td>
									</tr>
									
									<tr>
										<td align="left"><span id="msg" style="position: absolute;top:250px;left:20px;color:red;font-size: 14px"></span></td>
									</tr>
									<tr>
										<th align="right">&nbsp;</th>
										<td align="left"><button id="login-btn" type="button"  onclick="login()" class="btn"/>
												
											<span style="font-size:18px;color:#fff;">登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</span></td>
									</tr>
									<tr>
										<th align="right"><div  id="app" class="app"></div></th>
										<td align="left"><div id="app_img"class="app_img"><img src="${ctx}/resources/newLog/img/login_common.png"/></div>
	    	
</td>
										
									</tr>
									
									
								</table>
							</form>
							
				          </div>
				          <div></div>
						</div>
				
			</div>
			 		
				<%-- 
					</div>
					
					
				</div>
				<div class="clear"></div>
			</div>
		</div>
	--%>
	<!--<div class="footer" id="footer">
		<p class="footer-link">
			<a href="#">关于我们</a> <a href="#">联系我们</a> <a href="#">隐私保护</a> <a
				href="#">版权声明</a> <a href="#">相关帮助</a>
		</p>
		<p class="copyright">
			<a href="http://www.miibeian.gov.cn/" target="_blank"
				style="margin-right: 5px">鄂ICP备09187954号</a> Copyright © 2012
			www.njt365.com
		</p>
	</div>

	--><script type="text/javascript">
	var ip=returnCitySN["cip"];
	document.getElementById("ipAddress").value=ip;	//获取IP
	
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
		
		
		setInterval("remind1()", 60000);//1分钟执行一次remind1方法。  设置定时器。

		function remind1(){
		alert("你好");
		  //也可以是ajax等请求代码,相当于一分钟执行一次ajax请求。
		   $.ajax({
		         url: "/remind/remindList.html",
		         type: "post",
		         dataType:"json",
		        cache: false,
		        async: false,
		        success: function(data){
		        if(data.length>0){  //将每一分钟请求的数据放在页面上，也可以刷新页面，具体业务具体对待。               
		             $('#MsgNum').attr("title","你有"+data.length+"条未读消息");
		             $('#recolor').attr("color","red");
		        }else{
		             $("#remindSound").attr("src","");
		             $('#recolor').attr("color","white");
		        }
		        }
		})
		}
		
		
	</script>
</body>
</html>