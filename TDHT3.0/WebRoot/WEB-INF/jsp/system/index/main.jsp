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
	<%@ include file="top.jsp"%>
	<style type="text/css">
	.commitopacity{position:absolute; width:100%; height:100px; background:#7f7f7f; filter:alpha(opacity=50); -moz-opacity:0.8; -khtml-opacity: 0.5; opacity: 0.5; top:0px; z-index:99999;}
	</style>
	<script type="text/javascript" src="static/js/jquery.min1.9.0.js"></script>
	<!-- 即时通讯 -->
	<link rel="stylesheet" type="text/css" href="plugins/websocketInstantMsg/ext4/resources/css/ext-all.css">
	<link rel="stylesheet" type="text/css" href="plugins/websocketInstantMsg/css/websocket.css" />
	<script type="text/javascript" src="plugins/websocketInstantMsg/ext4/ext-all-debug.js"></script>
	<script type="text/javascript" src="plugins/websocketInstantMsg/websocket.js"></script>
	
	
	<!--UI-->
	<script type="text/javascript" src="static/js/jquery-ui-1.9.2.custom.min.js"></script>
	
	
	
	<!-- 左侧导航 -->
	<%--<link rel="stylesheet" type="text/css" href="static/left/css/default.css">
	--%><link rel="stylesheet" type="text/css" href="static/left/css/foundation.css" />
	
	<link rel="stylesheet" type="text/css" href="static/left/css/mtree.css">
	<link rel="stylesheet" type="text/css" href="static/left/css/normalize.css" />
	
	
	<!-- 左侧导航-->
</head>
	<body class="no-skin"style="width:100%;min-width: 1280px;">
		<!-- #section:basics/navbar.layout -->
		
		<!-- 页面顶部¨ -->
		<%@ include file="head.jsp"%>
		<div id="websocket_button"></div><!-- 少了此处，聊天窗口就无法关闭 -->
		<!-- /section:basics/navbar.layout -->
		<div style="height:100%;" class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<!-- #section:basics/sidebar -->
			<!-- 左侧菜单 -->
			<%@ include file="left.jsp"%>

			<!-- /section:basics/sidebar -->
			<div class="main-content" style="height:100%;">
				<div class="main-content-inner" style="height:100%;">

					<!-- /section:basics/content.breadcrumbs -->
					<%--<div class="page-content"style="height:100%;">
						<!-- #section:settings.box -->
						<div class="ace-settings-container" id="ace-settings-container">
							<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
								<i class="ace-icon fa fa-cog bigger-130"></i>
							</div>

							<div class="ace-settings-box clearfix" id="ace-settings-box">
								<div class="pull-left width-50">
									<!-- #section:settings.skins -->
									<div class="ace-settings-item">
										<div class="pull-left">
											<select id="skin-colorpicker" class="hide">
												<option data-skin="no-skin" value="#438EB9">#438EB9</option>
												<option data-skin="skin-1" value="#222A2D">#222A2D</option>
												<option data-skin="skin-2" value="#C6487E">#C6487E</option>
												<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
											</select>
										</div>
										<span>&nbsp; 选择皮肤</span>
									</div>

									<!-- #section:settings.breadcrumbs -->
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
										<label class="lbl" for="ace-settings-breadcrumbs">固定面包屑</label>
									</div>

									<!-- #section:settings.container -->
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
										<label class="lbl" for="ace-settings-add-container">
											居中风格
										</label>
									</div>

									<!-- /section:settings.container -->
								</div><!-- /.pull-left -->

								<div class="pull-left width-50">
									<!-- #section:basics/sidebar.options -->
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" />
										<label class="lbl" for="ace-settings-hover">折叠菜单</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" />
										<label class="lbl" for="ace-settings-compact">压缩菜单</label>
									</div>

									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" />
										<label class="lbl" for="ace-settings-highlight">弹出风格</label>
									</div>

									<!-- /section:basics/sidebar.options -->
								</div><!-- /.pull-left -->
							</div><!-- /.ace-settings-box -->
						</div><!-- /.ace-settings-container -->--%>
						<div class="row"style="height: 100%;width:98%;overflow: hidden;">	
						<div id="jzts" style="display:none; width:100%; position:fixed; z-index:99999999;">
						<%--<div class="commitopacity" id="bkbgjz"></div>
						--%><div style="padding-left: 70%;padding-top: 1px;">
							<div style="float: left;margin-top: 3px;"><img src="static/images/loadingi.gif" /> </div>
							<div style="margin-top: 6px;"><h4 class="lighter block red">&nbsp;加载中 ...</h4></div>
						</div>
						</div>
						<div id="iframe_div" >
							<iframe name="mainFrame" id="mainFrame" frameborder="0" src="" style="margin:0 auto;width:100%;height:100%;"></iframe>
						
						</div>
						</div><!-- /.row -->
					</div><!-- /.page-content -->
					
				</div>
			</div><!-- /.main-content -->

		</div><!-- /.main-container -->

		<!-- basic scripts -->
		<!-- 页面底部js¨ -->
		<%@ include file="foot.jsp"%>
		<script type="text/javascript">
/*function resizeFrame(){
            var content_iframe = window.parent.document.getElementById("iframe_div");//获取iframeID
            var div_height = $("body").css("height");//使iframe高度等于子网页高度
            content_iframe.style.height = div_height;
}*/
 $(document).ready(function(){ 
	
	 $("#img_div").css("left","0px")
 	$(".main-content").css("margin-left","30px")
  $("#mtree-demo").css("left","-170px")
/* 左导航隐藏*/
	$(".row").css("left","30px")　
	i=0　　
    	   $("#img_div").click(function() {
    		 if(i==0){
                $("#mtree-demo"). animate({left:"0px"},200);
                $("#img_div"). animate({left:"170px"},200);
                $(".main-content"). animate({"margin-left":"180px"},200); 
                 i=1;
            }else  {
                $("#mtree-demo"). animate({left:"-170px"},200);
                $("#img_div"). animate({left:"0px"},200);
                $(".main-content"). animate({"margin-left":"30px"},200);
                 i=0;
            }
       // function(){$("#mtree-demo"). animate({left:"0px"},200);$("#img_div"). animate({left:"170px"},200);$(".main-content"). animate({"margin-left":"180px"},200); 　} ,
     // function(){$("#mtree-demo"). animate({left:"-170px"},200);$("#img_div"). animate({left:"0px"},200);$(".main-content"). animate({"margin-left":"30px"},200);} 

    	  })
    	 /*  $("#img_div").click(function(e){ 
    			   e.stopPropagation();
    			   })
	 $("body").click(function(){
    $("#mtree-demo"). animate({left:"-170px"},200);$("#img_div"). animate({left:"0px"},200);$(".row"). animate({left:"30px"},200) 
  })*/

});
</script>
	 <script type="text/javascript">
	
	// findDimensions();
	// resizeFrame();
	/**	
function findDimensions() //函数：获取尺寸 
{ 
//获取窗口宽度 
if (window.innerWidth) 
winWidth = window.innerWidth; 
else if ((document.body) && (document.body.clientWidth)) 
winWidth =   window.screen.width ;
//获取窗口高度 
if (window.screen.height )
winHeight = window.screen.height ;
else if ((document.body) && (document.body.clientHeight)) 
	winHeight =window.screen.height ;
	//通过深入Document内部对body进行检测，获取窗口大小 
	if (document.documentElement && document.documentElement.clientHeight && document.documentElement.clientWidth) 
	{ 
		winHeight = window.screen.height; 
		winWidth = document.documentElement.clientWidth; 
	} 
}
 
function resizeFrame(){
         var content_iframe = window.parent.document.getElementById("iframe_div");//获取iframeID
         	content_iframe.style.height = winHeight+'px';
            content_iframe.style.width = 'auto';//winWidth+'px';
}*/
</script>
		<!-- page specific plugin scripts -->
		<!-- ace scripts -->
		<script src="static/ace/js/ace/elements.scroller.js"></script>
		<script src="static/ace/js/ace/elements.colorpicker.js"></script>
		<script src="static/ace/js/ace/elements.fileinput.js"></script>
		<script src="static/ace/js/ace/elements.typeahead.js"></script>
		<script src="static/ace/js/ace/elements.wysiwyg.js"></script>
		<script src="static/ace/js/ace/elements.spinner.js"></script>
		<script src="static/ace/js/ace/elements.treeview.js"></script>
		<script src="static/ace/js/ace/elements.wizard.js"></script>
		<script src="static/ace/js/ace/elements.aside.js"></script>
		<script src="static/ace/js/ace/ace.js"></script>
		<script src="static/ace/js/ace/ace.ajax-content.js"></script>
		<script src="static/ace/js/ace/ace.touch-drag.js"></script>
		<script src="static/ace/js/ace/ace.sidebar.js"></script>
		<script src="static/ace/js/ace/ace.sidebar-scroll-1.js"></script>
		<script src="static/ace/js/ace/ace.submenu-hover.js"></script>
		<script src="static/ace/js/ace/ace.widget-box.js"></script>
		<script src="static/ace/js/ace/ace.settings.js"></script>
		<script src="static/ace/js/ace/ace.settings-rtl.js"></script>
		<script src="static/ace/js/ace/ace.settings-skin.js"></script>
		<script src="static/ace/js/ace/ace.widget-on-reload.js"></script>
		<script src="static/ace/js/ace/ace.searchbox-autocomplete.js"></script>
		<!-- inline scripts related to this page -->

		<!-- the following scripts are used in demo only for onpage help and you don't need them -->
		<link rel="stylesheet" href="static/ace/css/ace.onpage-help.css" />

		<script type="text/javascript"> ace.vars['base'] = '..'; </script>
		<script src="static/ace/js/ace/elements.onpage-help.js"></script>
		<script src="static/ace/js/ace/ace.onpage-help.js"></script>
	
		<!--引入属于此页面的js -->
		<script type="text/javascript" src="static/js/myjs/head.js"></script>
		<!--引入属于此页面的js -->
		<script type="text/javascript" src="static/js/myjs/index.js"></script>
		
		<!--引入弹窗组件1start-->
		<!--<script type="text/javascript" src="plugins/attention/zDialog/zDrag.js"></script>-->
		<!--<script type="text/javascript" src="plugins/attention/zDialog/zDialog.js"></script>-->
		<!--引入弹窗组件1end-->
		
		<!--引入弹窗组件2start-->
		<script type="text/javascript" src="plugins/attention/drag/drag.js"></script>
		<script type="text/javascript" src="plugins/attention/drag/dialog.js"></script>
		<link type="text/css" rel="stylesheet" href="plugins/attention/drag/style.css"  />
		<!--引入弹窗组件2end-->
		
		<!--提示框-->
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		
		
		<!-- 左侧导航 -->
	
	
	
	<script type="text/javascript" src="static/left/js/mtree.js"></script>
	<script type="text/javascript" src="static/left/js/stopExecutionOnTimeout.js"></script>
	<!-- 左侧导航-->
	</body>
	<script>
$(document).ready(function(){
 //  $("#ClCache").parent('div').hide();
});
</script>
	<script type="text/javascript">
				var arr = document.getElementById("rid").getElementsByTagName("li");
						arr[0].click();
						
	</script>
					
</html>