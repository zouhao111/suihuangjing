<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<!doctype html>
<html lang="zh" class="no-js">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<!--<meta name="viewport" content="width=device-width, initial-scale=1">-->
	<title>jQuery和CSS3通过AJAX调用切换页面过渡动画特效|DEMO_jQuery之家-自由分享jQuery、html5、css3的插件库</title>
	<!--<link href='http://fonts.useso.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>-->
	<link href="${ctx}/resources/css/page-change/default.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/page-change/reset.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/page-change/style-page.css"	type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/resources/js/left/jquery-1.4.3.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/resources/js/left/jquery.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="${ctx}/resources/js/pageChange/main.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/resources/js/pageChange/modernizr.js" charset="UTF-8"></script>
	
</head>
<body>
	<div id="main">
		
			<div>
				
				
				<p class="center"><a id="page-change"class="cd-btn" href="" data-type="page-transition"target="main">Start animation</a></p>
			</div>
		
	</div>

	<div class="cd-cover-layer"></div>
	<div class="cd-loading-bar"></div>
	
	
	
</body>
</html>