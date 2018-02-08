<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/resources/common/jsp/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />
<link href="${ctx}/resources/lrtk/css/sucaijiayuan.css" rel="stylesheet" >
<script type="text/javascript" src="${ctx}/resources/lrtk/js/jquery.js" ></script>
<script type="text/javascript" src="${ctx}/resources/lrtk/js/jquery.caroufredsel-6.0.4-packed.js" ></script>
<script type="text/javascript" src="${ctx}/resources/lrtk/js/focus.js" ></script>
<script type="text/javascript" src="${ctx}/resources/lrtk/js/slider.js" ></script>
<style type="text/css">
#banner_tabs ul li{
height:100%;
}
</style>
<title>水污染源及水平衡在线监测系统</title>

</head>
<input id="webUrls"type="hidden" value="${webUrls}"/>

<body style="padding:0px;margin-right:0;width: 100%; overflow: hidden;">

	<div >
 <div id="banner_tabs" class="flexslider"  >
 
	<ul class="slides" >
		<li >
			<a title="" target="_blank">
				<img    alt=""   src="${ctx}/resources/lrtk/images/banner1.jpg">
			</a>
		</li>
		<li>
			<a title=""  target="_blank">
				<img alt=""     src="${ctx}/resources/lrtk/images/banner2.jpg">
			</a>
		</li>
		<li>
			<a title="" target="_blank">
				<img   alt=""  src="${ctx}/resources/lrtk/images/banner3.jpg">
			</a>
		</li>
	</ul>
	<ul class="flex-direction-nav">
		<li><a class="flex-prev" href="javascript:;">Previous</a></li>
		<li><a class="flex-next" href="javascript:;">Next</a></li>
	</ul>
		<div  class="banner-div"></div>
	 
	<ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
		<li><a>1</a></li>
		<li><a>2</a></li>
		<li><a>2</a></li>
	</ol>
	 
</div>

	</div>

	
	

	<!-- <div style="width: 100%;text-align: center; font-size: 15px;z-index: 88;">版权所有：© 深圳市天地互通科技有限公司 | 版本号：TDHTv2.0</div> -->
</body>
</html>