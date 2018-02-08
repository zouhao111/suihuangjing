<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<link rel='stylesheet' href='${ctx}/resources/lrtk/css/justifiedgallery.min.css' type='text/css' media='all' />
<link rel='stylesheet' href='${ctx}/resources/lrtk/css/swipebox.css' type='text/css' media='screen' />
<link rel='stylesheet' href='${ctx}/resources/lrtk/css/colorbox.css' type='text/css' media='screen' />
<script src='${ctx}/resources/lrtk/js/jquery.min.js'></script>
<script src='${ctx}/resources/lrtk/js/justifiedgallery.js'></script>
<script src='${ctx}/resources/lrtk/js/jquery.swipebox.min.js'></script>
<script src='${ctx}/resources/lrtk/js/jquery.colorbox-min.js'></script>
<title>公司信息</title>
<script type="text/javascript">
	$(document).ready(function () {
		window.parent.startaa();

	 $('#remotetest').justifiedGallery({rel: 'gal0'}).on('jg.rowflush', function () {
				$(this).find('a').colorbox({
					maxWidth : '120%',
					maxHeight : '150%',
					opacity : 0.8,
					transition : 'elastic',
					current : ''
				});
			}); 

})
	function show(valueid){
	   		document.getElementById(valueid).click();
		}
</script>
</head>

<body  class="body_overflow" align="center" style="font-size:14px;" >
<input id="webUrls" type="hidden" value="${webUrls}" >


<c:choose>
	<c:when test="${rid == 75501330001}">

	<div id="remotetest" style="margin-top: -200px;">
    	<a id="a2" href="${ctx}/resources/img/company/company-02.png" title="" >
      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
	  	</a>
	</div>
	<a  onclick="show('a2');" style="text-decoration:none;"><img height="98%" src="${ctx}/resources/img/company/company-02.png"></a>
	</c:when>
	
	<c:when test="${rid == 75501330002}">
	
		<div id="remotetest" style="margin-top: -200px;">
	    	<a id="a3" href="${ctx}/resources/img/company/company-01.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
		  	</a>
		</div>
		<a  onclick="show('a3');" style="text-decoration:none;"><img height="98%" src="${ctx}/resources/img/company/company-01.png"></a>
	</c:when>
	
	<c:when test="${rid == 	75501330004}">
	<div id="remotetest" style="margin-top: -200px;">
	    	<a id="a4" href="${ctx}/resources/img/company/company-06.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
		  	</a>
		  	<a id="a5" href="${ctx}/resources/img/company/company-05.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
		  	</a>
	</div>
	<div style="width:80%;margin-left: 10%;margin-top:40px;">
	<a  onclick="show('a4');" style="text-decoration:none;"><img height="90%" src="${ctx}/resources/img/company/company-06.png"></a>
	<a  onclick="show('a5');" style="text-decoration:none;"><img height="90%" src="${ctx}/resources/img/company/company-05.png"></a>
	</div>
	</c:when>
	
	<c:when test="${rid == 	75501330008}">
	<div id="remotetest" style="margin-top:-200px;">
	    	<a id="a6" href="${ctx}/resources/img/company/金标.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/金标.png" style="display:none;">
		  	</a>
		  	 
		  	<a id="a7" href="${ctx}/resources/img/company/金标1.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/金标1.png" style="display: none;">
		  	</a>
	</div>
	
	<div style="width:80%;margin-left: 10%;margin-top:40px;">
	<a  onclick="show('a6');" style="text-decoration:none;"><img height="90%" src="${ctx}/resources/img/company/金标.png"></a>
	<a  onclick="show('a7');" style="text-decoration:none;"><img height="90%" src="${ctx}/resources/img/company/金标1.png"></a>
	</div>
	</c:when>
	
	<c:when test="${rid == 	75501330009}">
	<div id="remotetest" style="margin-top:-200px;">
	    	<a id="a8" href="${ctx}/resources/img/company/天得.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/天得.png" style="display:none;">
		  	</a>
		  	 
		  	<a id="a9" href="${ctx}/resources/img/company/天得1.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/天得1.png" style="display: none;">
		  	</a>
	</div>
	
	<div style="width:80%;margin-left: 10%;margin-top:40px;">
	<a  onclick="show('a8');" style="text-decoration:none;"><img height="90%" src="${ctx}/resources/img/company/天得.png"></a>
	<a  onclick="show('a9');" style="text-decoration:none;"><img height="90%" src="${ctx}/resources/img/company/天得1.png"></a>
	</div>
	</c:when>
	
	<c:when test="${rid == 	75501330010}">
	<div id="remotetest" style="margin-top:-200px;">
	    	<a id="a10" href="${ctx}/resources/img/company/碧池.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/碧池.png" style="display:none;">
		  	</a>
		  	 
		  	<a id="a11" href="${ctx}/resources/img/company/碧池1.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/碧池1.png" style="display: none;">
		  	</a>
	</div>
	
	<div style="width:80%;margin-left: 10%;margin-top:40px;">
	<a  onclick="show('a10');" style="text-decoration:none;"><img height="90%" src="${ctx}/resources/img/company/碧池.png"></a>
	<a  onclick="show('a11');" style="text-decoration:none;"><img height="90%" src="${ctx}/resources/img/company/碧池1.png"></a>
	</div>
	</c:when>
<c:otherwise>
<%-- <img  width="50%" src="${ctx}/resources/img/company/${imgSrc}"></img> --%>
</c:otherwise>
</c:choose>




</body>
</html>