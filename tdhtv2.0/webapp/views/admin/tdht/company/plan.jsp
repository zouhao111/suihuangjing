<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel='stylesheet' href='${ctx}/resources/lrtk/css/justifiedgallery.min.css' type='text/css' media='all' />
<link rel='stylesheet' href='${ctx}/resources/lrtk/css/swipebox.css' type='text/css' media='screen' />
<link rel='stylesheet' href='${ctx}/resources/lrtk/css/colorbox.css' type='text/css' media='screen' />
<script src='${ctx}/resources/lrtk/js/jquery.min.js'></script>
<script src='${ctx}/resources/lrtk/js/justifiedgallery.js'></script>
<script src='${ctx}/resources/lrtk/js/jquery.swipebox.min.js'></script>
<script src='${ctx}/resources/lrtk/js/jquery.colorbox-min.js'></script>

<title>厂区平面</title>
<script type="text/javascript">
	$(document).ready(function () {
	window.parent.startaa();

	$('#remotetest').justifiedGallery({rel: 'gal0'}).on('jg.rowflush', function () {
				$(this).find('a').colorbox({
					maxWidth : '120%',
					maxHeight : '130%',
					opacity : 0.8,
					transition : 'elastic',
					current : ''
				});
			}); 

})
function showa(){
   		document.getElementById('a2').click();
	}
</script>
</head>

<body class="body_overflow" align="center" >
<input id="webUrls" type="hidden" value="${webUrls}" >
<c:choose>
<c:when test="${imgSrc eq null}">

</c:when>
<c:otherwise>

<div id="remotetest" style="margin-top: -200px;">
    <a id="a2" href="${ctx}/resources/img/company/company-09.jpg" title="" >
      <img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
  </a>
</div>  
<a id="a1" onclick="showa();">
<img  style="margin-top: 50px;" height="90%" src="${ctx}/resources/img/company/company-09.jpg"></img>
</a>
</c:otherwise>
</c:choose>
	

	<%--<img  width="50%" src="${ctx}/resources/img/yyf.jpg" ></img>--%>

</body>
</html>