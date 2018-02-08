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
<title>排污许可</title>
<script type="text/javascript">
	$(document).ready(function () {
	window.parent.startaa();

	 $('#remotetest').justifiedGallery({rel: 'gal0'}).on('jg.rowflush', function () {
			$(this).find('a').colorbox({
				maxWidth : '120%',
				maxHeight : '100%',
				opacity : 0.8,
				transition : 'elastic',
				current : ''
			});
		}); 
})
	function showa(valueid){
	   		document.getElementById(valueid).click();
		}
</script>
</head>

<body class="body_overflow" align="center" >
<input id="webUrls" type="hidden" value="${webUrls}" >
 <c:choose>
	<c:when test="${rid == 75501330004}">
	<div id="remotetest" style="margin-top: -200px;">
    	<a id="a2" href="${ctx}/resources/img/company/company-11.jpg" title="" >
      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
	  	</a>
	  	<a id="a3" href="${ctx}/resources/img/company/company-10.jpg" title="" >
      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
	  	</a>
	  	<a id="a4" href="${ctx}/resources/img/company/company-03.png" title="水污染" >
      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
	  	</a>
	  	<a id="a5" href="${ctx}/resources/img/company/company-04.png" title="大气污染" >
      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
	  	</a>
	</div>
			<a  onclick="show('a2');"><img  width="30%" height="48%" src="${ctx}/resources/img/company/company-11.jpg"></img></a>
			<a  onclick="show('a3');"><img  width="30%" height="42%" src="${ctx}/resources/img/company/company-10.jpg"></img></a><br />
			<a  onclick="show('a4');"><img  width="28%" height="48%" src="${ctx}/resources/img/company/company-03.png"></a>
			<a  onclick="show('a5');"><img  width="30%" height="48%" src="${ctx}/resources/img/company/company-04.png"></a>
	
	</c:when>
	
	<c:when test="${rid == 75501330008}">
		<div id="remotetest" style="margin-top: -200px;">
	    	<a id="a6" href="${ctx}/resources/img/company/金标2.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
		  	</a>
		  	<a id="a7" href="${ctx}/resources/img/company/金标3.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
		  	</a>
		  	<a id="a8" href="${ctx}/resources/img/company/金标4.png"  >
	      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
		  	</a>
		</div>
			<a  onclick="show('a6');"><img  width="30%" height="48%" src="${ctx}/resources/img/company/金标2.png"></img></a>
			<a  onclick="show('a7');"><img  width="30%" height="42%" src="${ctx}/resources/img/company/金标3.png"></img></a><br />
			<a  onclick="show('a8');"><img  width="28%" height="48%" src="${ctx}/resources/img/company/金标4.png"></a>
	</c:when>
	
	<c:when test="${rid == 75501330009}">
		<div id="remotetest" style="margin-top: -200px;">
	    	<a id="a9" href="${ctx}/resources/img/company/天得2.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
		  	</a>
		  	<a id="a10" href="${ctx}/resources/img/company/天得3.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
		  	</a>
		  	<a id="a11" href="${ctx}/resources/img/company/天得4.png"  >
	      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
		  	</a>
		</div>
			<a  onclick="show('a9');"><img  width="30%" height="48%" src="${ctx}/resources/img/company/天得2.png"></img></a>
			<a  onclick="show('a10');"><img  width="30%" height="42%" src="${ctx}/resources/img/company/天得3.png"></img></a><br />
			<a  onclick="show('a11');"><img  width="28%" height="48%" src="${ctx}/resources/img/company/天得4.png"></a>
	</c:when>
	
	<c:when test="${rid == 75501330010}">
		<div id="remotetest" style="margin-top: -185px;">
	    	<a id="a12" href="${ctx}/resources/img/company/碧池2.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
		  	</a>
		  	<a id="a13" href="${ctx}/resources/img/company/碧池4.png" title="" >
	      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
		  	</a>
		  	<a id="a14" href="${ctx}/resources/img/company/碧池3.png"  >
	      	<img alt="111" src="${ctx}/resources/img/company/company-08_a.jpg" style="display: none;">
		  	</a>
		</div>
			<a  onclick="show('a12');"><img  width="30%" height="48%" src="${ctx}/resources/img/company/碧池2.png"></img></a>
			<a  onclick="show('a13');"><img  width="30%" height="42%" src="${ctx}/resources/img/company/碧池4.png"></img></a><br />
			<a  onclick="show('a14');"><img  width="28%" height="48%" src="${ctx}/resources/img/company/碧池3.png"></a>
	</c:when>
<c:otherwise>

</c:otherwise>
</c:choose>


</body>
</html>