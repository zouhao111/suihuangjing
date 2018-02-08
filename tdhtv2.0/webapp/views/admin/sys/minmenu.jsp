<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>水污染源及水平衡在线监测系统</title>
<link href="${ctx}/resources/css/button/rippler.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/button/bootstrap.min.css"	type="text/css" rel="stylesheet" />



<link href="${ctx}/resources/css/minstyle.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />
<link href="${ctx}/resources/newMain/css/but.css" type="text/css" rel="stylesheet" id="css-skin" />
<!--[if IE 9]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if IE 8]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if  IE 7]>
<link href="${ctx}/resources/css/ie7.css"	type="text/css" rel="stylesheet" />
<![endif]-->


<script src="${ctx}/resources/js/frame.js"></script>
<script src="${ctx}/resources/js/jquery-1.4.4.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/left/jquery-1.4.3.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/resources/js/left/jquery.min.js" charset="UTF-8"></script>
<script src="${ctx}/resources/js/jquery.rippler.js"></script>
</head>

<script>

var timer;
 var boo=window.parent.boo;
  var url1;
 if(boo==false){
 url1=window.parent.urll;
 }else{

 url1="";
 }
// alert(url1)

 
 
$(document).ready(function(e) {



$("#hover_ul").hide();
    $("ul li  ").click(function(){
    	  $(this).each(function () {//移除其余非点中状态
         $("ul li  a").removeClass("current1");
        });
    	$("ul li ul li a").addClass("current2");
		$("a",this).toggleClass('current1');
	});
      
     	
     	$("ul li ul li a").hover( function(event){
    $(this).css("color", "#0071bc");    
}, function(event){
    $(this).css("color", "#333333");
} );
     	
     	
     	
      timer=setInterval(function() {
        startaa();
}, 1000); 
			 
//点击日月年的时候
/**$("div a").click(function(){
   timer=setInterval(function() {
        startaa();
}, 1000); 
 })	*/		
})

function startaa(){

			  var webUrl=$("#mainframes").contents().find("#webUrls").val(); 
			  $("#hidden2").val(webUrl);
			  var a=$("#hidden2").val();
			  window.clearInterval(timer); 
			}
			
 
</script>


<body >
	
	<%--<div class="navigation" style="background-color:#e9e9e9;" >
		<!--<a href="${ctx}/admin/index">后台首页</a>-->
		<c:forEach items="${lastMenu}" var="menu">
			<a style="margin-left:20px;" href="${ctx}/${menu.navigateUrl}" target="mains">${menu.fullName }</a>
		</c:forEach>
	</div>
	--%>
	
	<%--
	<div class="tabs">
	<a href="#"><strong>常规</strong></a>
	<a href="#"><strong>界面皮肤</strong></a>
	<a href="#" class="current"><strong>登录页设置</strong></a></div>

	--%>
	<input id="hidden4"type="hidden" />
	<a id="hidden2"type="hidden" href="" target="mains"></a>
	<input id="hidden3"type="hidden" value="${webUrls}"/>
	<div class="tabs" style="padding-top: 7px; position: relative; z-index: 2;margin-left: 11px">
	
	<ul class="sidebar_ul" >
	<c:forEach items="${lastMenu}" var="menu" varStatus="statusValue">
	<li style="float:left"class="hover_li" >
	                        <c:choose>
	              			<c:when test="${menu.target=='Click' }">
	              			
	              			<a id="alinks" href="${ctx}/${menu.navigateUrl}${rid}" class="btn btn-primary rippler rippler-default" target="mains" >${menu.fullName }&nbsp;&nbsp;<img id="dot2" src="${ctx}/resources/newMain/img/pull-down2.png"></a>
	              			</c:when>
	              			<c:otherwise>
	              			<a id="alinks" href="${ctx}/${menu.navigateUrl}${rid}" class="btn btn-primary rippler rippler-default" target="mains" >${menu.fullName }</a>
	              			</c:otherwise>
	              			</c:choose>
	              			
             			               <ul id="hover_ul" style="padding-left: 0 ; display: none;border-bottom:1px solid #333333;" class="hover_ul">
              							<c:forEach items="${menu.childMenuList }" var="cmenus" varStatus="status2">
              							<li>
              							 <a id="alinkss" href="${ctx}/${cmenus.navigateUrl}${rid}" class="btn btn-primary rippler rippler-default"  target="mains" >${cmenus.fullName }</a>
             			                    </li>
		              					</c:forEach>
                     					</ul>
 </li>
	</c:forEach>

	</ul>
	
	</div>
	
	<!--<ul id="sidebar" class="sidebar">
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
      			</ul>
	
	
	--><div class="container-main">
		
		<div class="content-main2">
			<iframe height="50%" frameborder="0" scrolling="auto"
				allowtransparency="true" class="iframe-main" marginheight="0"
				marginwidth="0" name="mains" id="mainframes" src=""></iframe>
		</div>
		
	</div>
	<script type="text/javascript">
		(function() {
		var rid=${rid};
		//alert(rid)
		/*timer=setInterval(function() {
        startaa();
}, 1000); 
		*/
		var url1=window.parent.urll;
		 if(url1!=undefined&&url1!=''){
 url1=url1+"&rid="+rid
//alert(url1+"    +url2")
 }else{
 var url1="";
 
 }
 //console.log(url1)
		$("#hidden2").attr("href",url1);
 var hidden2=$("#hidden2").attr("href");
		// console.log(hidden2)
		if(hidden2!=""){
		document.getElementById("hidden2").click();//打开页面后默认点击
		}else{
			//document.getElementById("alinks").click();//打开页面后默认点击
			var href = $("#alinks").attr("href");
		 	if(href==""){
			document.getElementById("alinkss").click();
				$("#alinkss").toggleClass('current1');
			}else{
			document.getElementById("alinks").click();
			$("#alinks").toggleClass('current1');
			   }			
		}
			$('.hover_li').mouseover(function(event) {
			$(this).find("ul").show();
			});  
             $('.hover_li').mouseleave (function(event) {
			$(this).find("ul").hide();
			
			
			});  
			
/* 			
   $(this).hover(
     function(){
    	$(this) .find("ul").show();
     },function(){
    	$(this).find("ul").hide();
     } */
		})()
		
		
		

	</script>
 <script type="text/javascript">
	  $(document).ready(function() {
	    
	      $(".rippler").rippler({
	        // addElement:"svg"
	      });

	      $('a[href^=#]').on('click', function(){
	        return false;
	      });
	      
	  }); 

	  </script>
</body>
	
</html>