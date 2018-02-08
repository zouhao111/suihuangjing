<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
	<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
	
	<script type="text/javascript" src="plugins/tab/js/framework.js"></script>
	<link href="plugins/tab/css/import_basic.css" rel="stylesheet" type="text/css"/>
	<link  rel="stylesheet" type="text/css" id="skin" prePath="plugins/tab/" /><!--默认相对于根目录路径为../，可添加prePath属性自定义相对路径，如prePath="<%=request.getContextPath()%>"-->
	<script type="text/javascript" charset="utf-8" src="plugins/tab/js/tab.js"></script>
	<script src="static/js/jquery.cookie.js"></script>
	
	<link href="static/buttons/buttons.css" rel="stylesheet" type="text/css"/>
	<style type="text/css">
	 .active
    {
      background-color: #0C77BF;
      color: #FFF; }
	
	</style>
	</head>
<body>
<input id="ROLE_NAME"type="hidden" value="${pd.ROLE_NAME}"/>
<input id="MENU_ID"type="hidden" value="${pd.MENU_ID}"/>
<input id="R_ID"type="hidden" value="${pd.R_ID}"/>

<div id="tab_menu" style="display: none"></div>
<a id="menuUrl" target="pageFrame" href=""></a>
<a id="menuUrl2" target="pageFrame" href=""></a>
<div id="tab_menu_new">
<a id="menuUrl2" target="pageFrame" href="login_default.do"></a>
<div id="tab_menu_new">
<a id="menuUrl2" target="pageFrame" href="login_default.do?R_ID="+${pd.R_ID}></a>
<%--<a id="menuUrl2" target="pageFrame" href="listMonitoring.do?MENU_ID=93&ROLE_NAME=中村科技&R_ID=75501330004"></a>
--%><div id="tab_menu_new">
    <ul id="menu2"style="height: 30px;width:100%;min-width: 1000px;">
    <%--
    <a href="http://www.bootcss.com/" class="button button-3d button-primary button-rounded">Check out the new site!</a>
    
    <c:forEach items="${allmenuLists}" var="menu1">
				<c:if test="${menu1.hasMenu && '1' == menu1.MENU_STATE}">
			<a href="<%=basePath%>login_default.do" target="pageFrame"style="width:8%;height:10px;float: left"><li>${menu1.MENU_NAME }</li></a>
	       </c:if>
	       </c:forEach>
    --%></ul>
</div>
<div style="width:100%;">
	<div id="pages" style="width:100%;">
	<iframe name="pageFrame" id="pageFrame" frameborder="0" src="" style="margin:0 auto;width:100%;min-height:800px;height:100%;"></iframe>
	</div>
</div>
	
</body>
<script type="text/javascript">

 $("#menuUrl").click();
function tabAddHandler(mid,mtitle,murl){
	tab.update({
		id :mid,
		title :mtitle,
		url :murl,
		isClosed :true
	});
	tab.add({
		id :mid,
		title :mtitle,
		url :murl,
		isClosed :true
	});

	tab.activate(mid);
}
 var tab;	
$( function() {
	
	 tab = new TabView( {
		containerId :'tab_menu',
		pageid :'page',
		cid :'tab1',
		position :"top"
	});
	 
	/**tab.add( {
		id :'tab1_index1',
		title :"主页",
		url :"/per/undoTask!gettwo",
		isClosed :false
	});
	**/
});

	/*function cmainFrameT(){
		var hmainT = document.getElementById("page");
		var bheightT = document.documentElement.clientHeight;
		hmainT .style.width = '100%';
		hmainT .style.height = (bheightT  - 41) + 'px';
	}
	cmainFrameT();
	window.onresize=function(){  
		cmainFrameT();
	};*/

</script>
<script type="text/javascript">
    
	$(function () {
			var ROLE_NAME=$("#ROLE_NAME").val();			
			var	MENU_ID=$("#MENU_ID").val()		
			var	R_ID=$("#R_ID").val()			
              
	var onSelect2 =$.cookie('onSelect2s');
                	if(onSelect2=="null"){
                		$.cookie('onSelect2s','0', { expires: 7, path: '/TDHT3.0' });
		// var onSelect =$.cookie('onSelect2s');
                	}
	   $.ajax({
        url:'changeMenu2',
		type:"post",
		async: true,
		dataType:"json",
		data:{ROLE_NAME,MENU_ID},
		success:function(data){
			console.log(data.menuUrl)
			$("#menuList").empty();
			var a=0;
		   $.each(data.list, function(i, dvar){
			   
				if(dvar.hasMenu){
				$("#menu2").append("	<a onclick='onSelect("+a+")' href="+dvar.MENU_URL+"?R_ID="+R_ID+"&ROLE_NAME="+ROLE_NAME+"&MENU_ID="+dvar.MENU_ID +"&MENU_IDS="+MENU_ID+" target='pageFrame'class='button button-glow button-border button-rounded button-primary'style='float: left'><li>"+dvar.MENU_NAME+"</li></a>");
				//$("#menu2").append("	<a  href='login_default.do?R_ID="+R_ID+"' target='pageFrame'class='button button-glow button-border button-rounded button-primary'style='float: left'><li>"+dvar.MENU_NAME+"</li></a>");
				
				
				/*if("#"==dvar.MENU_URL||""==dvar.MENU_URL){
						$("#menuList").append("<a  target='mainFrame' href=tab.do?MENU_ID="+dvar.MENU_ID+"&ROLE_NAME="+data.ROLE_NAME+" style='width:12%;height:45px;'> <li><i style='margin-right:10px'class=' "+dvar.MENU_ICON+"'></i>"+dvar.MENU_NAME+"</li></a>");
					}else{
						$("#menuList").append("<a target='mainFrame' href="+dvar.MENU_URL+" style='width:12%;height:45px;'><li><i style='margin-right:10px' class=' "+dvar.MENU_ICON+"'></i>"+dvar.MENU_NAME+"</li></a>");
						}*/
						a++;
				}
					 });
		     $("#menuUrl").attr("href",data.menuUrl);
		 //   console.log($("#menuUrl").attr("href"))
		 
		//  $.cookie('onSelect2s','0', { expires: 7, path: '/TDHT3.0' });
		// var onSelect =$.cookie('onSelect2s');
                	
                	
		
		 
		 
		 
		     var menuUrl_s=$.cookie('menuUrl_s');
		    if(menuUrl_s!=data.menuUrl){
		    $.cookie('menuUrl_ss',null, { expires: 1, path: '/TDHT3.0' });
		    }
		    
		      $.cookie('menuUrl_s', data.menuUrl, { expires: 1, path: '/TDHT3.0' }); 
		     
		   //  var href = $("#pageFrame").contents().find("#menuUrl").attr("href")
		   
		 //   var href = $("#menuUrl2").attr("href");
		    
		    var href = $.cookie('menuUrl_ss'); 
               
		    
		    
		    
		    
              
	            if(href=='null'){
		  
	            	href=$("ul a:first").attr("href")
	            	 $("#menuUrl2").attr("href",href);
	            	$.cookie('onSelect2s','0', { expires: 7, path: '/TDHT3.0' });
	            }else{
	            	  $("#menuUrl2").attr("href",href+R_ID+"&ROLE_NAME="+ROLE_NAME);
	            }
		     
		     
		       var onSelect =$.cookie('onSelect2s');
		   console.log(onSelect)
		    $('#menu2 a ').eq(onSelect).css("background", "#0C77BF");
		     $('#menu2 a ').eq(onSelect).css("color", "#fff");
		   
		    
		  
	 $("#menu2 a ").on("click",function(){
				
	 $("#menu2 a  ").css("background", "#fff"); 
	$("#menu2 a  ").css("color", "#0C77BF"); 
	 $(this).css("background", "#0C77BF");
	 $(this).css("color", "#fff");
	
	})
		 
		     
             ///    console.log(href) 	
              $.cookie('menuUrl_ss', href, { expires: 1, path: '/TDHT3.0' });  
		  // $("#menuUrl2").attr("href","login_default.do?R_ID="); 
		  // var href = $("#menuUrl2").attr("href");
		 
		  var arr = document.getElementById("menuUrl2");
			  arr.click();
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) {
 
		}
           })
           
           $("#menuUrl").click();
           
			var list = jQuery('#menu2 a');
			//console.log(list)
			list.click(function(){
				list.removeClass('active');
				jQuery(this).addClass('active');
				return false;
			});
			
             })    
                function onSelect(a){
					 $.cookie('onSelect2s',a, { expires: 1, path: '/TDHT3.0' });
				 }
           /*var arr = document.getElementById("menu2").getElementsByTagName("li");
						
						arr[0].click();*/
           </script>
         
</html>

