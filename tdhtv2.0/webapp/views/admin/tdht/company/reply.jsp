<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<title>环评批复</title>
<link rel='stylesheet' href='${ctx}/resources/lrtk/css/justifiedgallery.min.css' type='text/css' media='all' />
<link rel='stylesheet' href='${ctx}/resources/lrtk/css/swipebox.css' type='text/css' media='screen' />
<link rel='stylesheet' href='${ctx}/resources/lrtk/css/colorbox.css' type='text/css' media='screen' />
<script src='${ctx}/resources/lrtk/js/jquery.min.js'></script>
<script src='${ctx}/resources/lrtk/js/justifiedgallery.js'></script>
<script src='${ctx}/resources/lrtk/js/jquery.swipebox.min.js'></script>
<script src='${ctx}/resources/lrtk/js/jquery.colorbox-min.js'></script>

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

	function showa(){
   		document.getElementById('a2').click();
	}

</script>
</head>

<body  class="body_overflow">
<input id="webUrls" type="hidden" value="${webUrls}" >
<c:choose>
<c:when test="${rid == 75501330004}">

<div id="remotetest" style="margin-top: -200px;">
    <a id="a2" href="${ctx}/resources/img/company/company-07.png" title="" >
      <img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
  </a>
</div>  


	<div style="margin-left:35%;width:60%">
	<a id="a1" onclick="showa();">
		<div style="width:550px;font-size: 13px;float: left;">
			 <img height="100%" src="${ctx}/resources/img/company/company-07.png" >
		</div>
		</a>
	</div>
</c:when>
<c:otherwise>

</c:otherwise>
</c:choose> 

</body>
</html>