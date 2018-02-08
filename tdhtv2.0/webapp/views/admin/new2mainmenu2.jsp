<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>

<meta name=”renderer” content=”webkit” />  
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE10" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>水环境在线监控系统</title>
<script src="${ctx}/resources/js/metismenu/jquery.min.js"></script>
<script src="${ctx}/resources/js/metismenu/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/left/jquery-1.4.3.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/resources/js/left/jquery.min.js" charset="UTF-8"></script>
<script src="${ctx}/resources/js/background/jquery.MyFloatingBg.js"></script>
<script src="${ctx}/resources/js/metismenu/accordion.js"></script>
<script src="${ctx}/resources/js/ajax.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-ui-jqLoding.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/zDialog.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/zDrag.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/fileClick.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/css3-mediaqueries.js"></script>
<%--<script type="text/javascript" src="${ctx}/resources/newMain/js/jquery.searchMeme.js"></script>
<link href="${ctx}/resources/newMain/css/searchMeme.css" type="text/css" rel="stylesheet" id="css-skin" />
<link href="${ctx}/resources/newMain/css/demo.css" type="text/css" rel="stylesheet" id="css-skin" />
--%><link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />
<link href="${ctx}/resources/css/left/default.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/left/foundation.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/left/normalize.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/left/styles.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/newMain/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/img/icon.ico" rel="Shortcut Icon">
<link rel="stylesheet" href="${ctx}/resources/css/lanrenzhijia.css" media="all">
<script type="text/javascript" src="${ctx}/resources/newMain/js/css3-mediaqueries.js"></script>
<!--[if IE 8]>
<link href="${ctx}/resources/newLog/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->


<style>

html, body {
	height: 100%;
	overflow-y: hidden;
	font-size:62.5%;
}
#top ul.sidebar ul { margin:0px 0px 0px 15px; padding: 0;display: none;} 
input:-webkit-autofill {   
-webkit-box-shadow: 0 0 0px 1000px #FFFFFF inset;   
}  
.dot{
    position: absolute;
    top: 9px;
    display: none;
}
.dot2{
    position: absolute;
    top: 9px;
    display: none;
}

.input_find{
width:0px;
visibility: hidden;
}
.on{
width:200px;
visibility: visible;
}
@media screen and (min-width: 768px){
body{
  overflow: auto;
}
 .dot{
 left:0px;
 }
.dot2{
   
   left:0px;
    
}
 #top{
 margin: 0 0;
 }
}
@media screen and (min-width: 992px){
body{
  overflow: auto;
}
 .dot{
 left:5px;
 }
 .dot2{
   
   left:5px;
    
}
 #top{
 margin: 0 0;
 }
}
@media screen and (min-width: 1200px){
body{
  overflow: auto;
}
 .dot{left: 10px;}
 .dot2{
   
   left:10px;
    
}
 #top{
 margin: 0 10.5%;
 }
}









*{  
margin:0;  
padding:0;  
}  
#top ul{  
list-style:none;  
position: absolute;
} 
.nav{  
font-size:18px;  

}  
.nav li{  
float:left;  
margin-right:1px;  
height:50px;
width:12.19%;
}  
.nav li a{  
text-decoration:none;  
height:30px;
color:#000;  
display:block;  
 
text-align:center;  
margin-top: 10px;
border-right: 2px solid #d0d0d0;
font-size: 18px;
font-family: 微软雅黑;

}  

.nav li ul{  
display:none;  
margin-top:10px;
border:1px solid #00B9EF;
}  
.nav li ul li{  
/*margin-top:1px;  */
position:relative;  
margin: 0px;


width:100%;

}  
.nav li ul li a{  
border: 0px;
width:100%;
font-size: 16px;
color: #fff;
font-family: 微软雅黑;
}
/*鼠标移到相应元素上显示二级菜单*/  
.nav li:hover ul{  
display:block;  
 
}  
.nav li:hover ul li ul{  
display:none;  
}  
.nav li:hover ul li ul li{  
/*margin-left:1px;  */
}  
.nav li ul li ul li{
height: 30px;
border: 0px;

}
.nav li ul li ul li a{
font-size: 14px;
color: #fff;
font-family: 微软雅黑;
text-align: left;
margin-left: 40px;
}
#log_mun li{
border: 0px;
width:50%;
}
#log_mun li a{
width:100%;
}
/*鼠标移到相应二级菜单元素上显示三级菜单*/  
.nav li:hover ul li ul{  
display:block;  
 
}  

.black {
color:#000;
}
.gray {
color:#b3b3b3;
}


.mtree a{
color:#0372BC;
font-family: 微软雅黑;

}
.city{
 border-bottom: 2px solid #0372BC;
  border-top: 2px solid #0372BC;
}
.mtree li a{
font-size: 17px;
}
.mtree li ul li a{
font-size: 16px;
}
.mtree li ul li ul li a{
font-size: 14px;
}

#pull-down{
   margin-left:10px;
   display: black;
}
#pull-down2{
   
    position: absolute;
    top: 20px;
    left: 120px;
     display: black;
}

.user-div{
  width:116px;
  height:30px;
  position: relative;
  z-index: 999991;
  line-height: 23px;
  cursor: pointer;
}
.user-div1{

      position: absolute;
    top: 0px;
    right: 110px;
    border-bottom: 2px solid #d0d0d0;
}
#chose_img{
 width:12%;
}
#chose_img2{
 width:12%;
}

.mb{margin-bottom:10px;}
.wrapper{height:201px;margin-bottom:10px;display:table-cell;vertical-align:middle;*position:relative;}
.demo{width:200px;background:red;height:50px;}
.vam{*position:absolute;*top:50%;}
.va{*position:relative;*top:-50%;}
</style>

<script type="text/javascript">


//验证表单
	function checkForm(){
	var t1=document.getElementById("emil").value;

		if(!t1){
			alert("邮箱不能为空！");
			return false;
		}
		if(!titles){
			alert("标题不能为空！");
			return false;
		}
		
		return true;
	}


$(document).ready(function () {
		//新增
		$("#add-btn").click(function () {
			if(checkForm()){
				$.ajax({
	                type: "POST",
	                url:${ctx}"/admin/tdht/feedback/saveFeedback",
	                data:$('#loginform').serialize(),
	                dataType: 'json',
	                error: function(request) {
	                	infoMsg("提交失败");
	                },
	                success: function(data) {
	                	if(data.success){
	                	document.getElementById("gbss").click();
	                		$('#loginform')[0].reset(); 
	                		infoMsg(data.msg);
	                	}else{
	                	alert("添加成功！");
	                		infoMsg(data.msg);
	                	}
	                }
	            });
			}
		});
	});


jQuery(document).ready(function($) {
	/* $('.theme-login').click(function(){
		$('.theme-popover-mask').fadeIn(100);
		$('.theme-popover').slideDown(200);
	}) */
	$('.theme-poptit .close').click(function(){
		$('.theme-popover-mask').fadeOut(100);
		$('.theme-popover').slideUp(200);
	})
	
})
//判断弹框
function showtc(value){
    
	if(value==1){
		if(${webCompany.companyId ==2000}){
			$("#tanchu11").show();
		}else{
			$("#tanchu1").show();
		}
	}
	if(value==2){
		$("#tanchu2").show();
	}
}


function clickCom(rid) {
	
	
	if (booClick) {
       var rids=${rids};
    var comName =${comName};
    	
   
    for(i=0;i<rids.length;i++){
    	 
     if(rid==rids[i]){
    	
    	   $("#left_img").html(comName[i]); 
       }
    }
		
		
		
		booClick = false;
		var Rid =rid
		webUrl1 = $("#mainframe").contents().find("#webUrls").val();
		//alert(webUrl1+"   22")
		//alert(webUrl1!=undefined)
		if (webUrl1 != undefined) {
			webUrl = webUrl1
		} else {
			//alert("---333--")
			webUrl2 = $("#mainframe").contents().find("#hidden3").val();
			webUrl = webUrl2

			// alert(webUrl+"---333--")
			startaaa(Rid);
			//window.clearInterval(timer); 
		}

		//	alert(webUrl+"   55")
		//alert(webUrl)


 
 
    URLstr2(Rid)
 
		var url = webUrl + "&rid=" + Rid
		//console.log(url+"        bb  ")
		$("#yyf1").attr("href", url);
		document.getElementById("yyf1").click();//打开页面后默认点击
		
		setTimeout(function() {
			booClick = true;
		}, 1000);

	} else {
		setTimeout("clickCom("+rid+") ", 1500);
	}

}


$(function(){
   var  imrid=${webCompany.rid};
   
   /*
    * 判断rid   左侧导航梯形内显示公司名字
    */ 
   var rids=${rids};
    var comName =${comName};
    	
   
    for(i=0;i<rids.length;i++){
    	
     if(imrid==rids[i]){
    	
    	   $("#left_img").html(comName[i]); 
       }
    }
   
   // document.getElementById("yyf").click();//打开页面后默认点击
  //doAjax(imrid);
   
    var Rid=$("#impRid").val();
    if(Rid==""){
    	$(".chose_img2_1").show();
    }else{
    	$(".chose_img2_2").show();
    }
     click_com2(Rid);
    URLstr2(imrid)
  
   $("#img_div").css("left","0px")
 $("#iframe_div").css("left","30px")
  $("#leftMenu").css("left","-140px")
/* 左导航隐藏*/
	$("#iframe_div").css("left","30px")　　　
    	  $("#img_div").toggle( 
        function(){$("#leftMenu"). animate({left:"0px"},200);$("#img_div"). animate({left:"140px"},200);$("#iframe_div"). animate({left:"170px"},200); } ,
       function(){$("#leftMenu"). animate({left:"-140px"},200);$("#img_div"). animate({left:"0px"},200);$("#iframe_div"). animate({left:"30px"},200);} 
)





$("#img").hover(function(){
$("#img").css("background-color","#F0F0F0");
},function(){
$("#img").css("background-color","#fff");
});
   /*
$("#img_find").css("width","40px");

$("#img_div2").hover(function(){
$("#img_find").css("width","50px");
},function(){
$("#img_find").css("width","40px");
});
   $("#img_find").click(function(){
   $("#sub_but").click();
    
});
   */
   /*
    * 搜索框的打开和 关闭
    * */
   $("#img_find").click(function(ev){
      var ev = ev || event, // enent做兼容
            isTrue = $("#input_find").is(".on"); // 判断.search-hd是否是展开状态
      ev.stopPropagation(); // 阻止冒泡
      
      if($("#input_find").val() == ""){ // 在输入框没有文字时执行
    	
            if(isTrue){ // isTrue等于 true 移除on，false就添加on
            	$("#input_find").removeClass('on').find('input').blur();
            	
            }else{
            	$("#input_find").addClass('on').find('input').focus();
            	
            }
      }else{ //提交事件search-hd
      	$("#input_find").find('input').focus();
      	if(isTrue){
      		 $("#sub_but").click();
      	}else{

      	}
      }
  })
  
   
$("#input_find").click(function(ev){
	 ev.stopPropagation();
})
$(document).click(function(){
	$("#input_find").val("")
	$("#input_find").removeClass('on').find('input').blur();
});
   
   
   
  /* 
$(document).click(function(){
	$(".input_find").removeClass('on').find('input').blur();
});
	//回车提交
	$(document).on("keydown","#keywords",function(e){
		var keyVal = $(this).val();
		var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
		if(keyVal=='' && keyCode==13){
			e.preventDefault();
		}
	})user-click
   */

				

	/*
	 * 用户名点击后  显示和隐藏
	 */ 		
$('#user-click').toggle( 
				 function(){
					 var b=$("#user-img-all").css("display");

	if(b=="none"){
		$("#user-img-all").show();
	}else{
		$("#user-img-all").hide();
	}} ,
             function(){var b=$("#user-img-all").css("display");

	if(b=="none"){
		$("#user-img-all").show();
	}else{
		$("#user-img-all").hide();
	}} 

			)
$(document).click(function(){
	$("#user-img-all").hide();
});
	
	
	
   
   /*
    * 主导航下图标  鼠标滑过移动  点击停留
   */
   $(".nav li").hover(function(){
	   $("#chose_img",this).show();
	   
   },function(){
	    $("#chose_img",this).hide();
	    
   })
 $(".nav li").click(function() {
	 $(".nav li #chose_img2").hide();
	 $("#chose_img2",this).show();
	 $(".nav li #pull-down2").show();
	  $(".nav li  #pull-down").show();
	})
	
	$(".nav li ul li ").hover(function(){
	   $("#dot",this).show();
	   
   },function(){
	    $("#dot",this).hide();
   })
	$(".nav li ul li ul li ").hover(function(){
	   $("#dot2",this).show();
	    $("#dot",this).hide();
   },function(){
	    $("#dot2",this).hide();
   })
   
   /*
    * 侧导航  鼠标移动  小圆点
    * */
  $(".mtree li  ").hover(function(){
	   $("#dot",this).show();
	   
   },function(){
	    $("#dot",this).hide();
   })
   $(".mtree li ul li ").hover(function(){
	   $("#dot2",this).show();
	   
   },function(){
	    $("#dot2",this).hide();
   })
   $(".mtree li ul li ul li ").hover(function(){
	   $("#dot3",this).show();
	   
   },function(){
	    $("#dot3",this).hide();
   })
   
   
   $("#user-div1").hover(function(){
	   $("#user-img1").attr("src","../resources/newMain/img/user-11.png");
	   
   },function(){
	    $("#user-img1").attr("src","../resources/newMain//img/user-1.png");
	    
   })
   $("#user-div2").hover(function(){
	   $("#user-img2").attr("src","../resources/newMain/img/user-22.png");
	   
   },function(){
	    $("#user-img2").attr("src","../resources/newMain//img/user-2.png");
	    
   })
   $("#user-div3").hover(function(){
	   $("#user-img3").attr("src","../resources/newMain/img/user-33.png");
	   
   },function(){
	    $("#user-img3").attr("src","../resources/newMain//img/user-3.png");
	    
   })
   $("#user-div4").hover(function(){
	   $("#user-img4").attr("src","../resources/newMain/img/user-44.png");
	   
   },function(){
	    $("#user-img4").attr("src","../resources/newMain//img/user-4.png");
	    
   })
   $("#user-div5").hover(function(){
	   $("#user-img5").attr("src","../resources/newMain/img/user-55.png");
	   
   },function(){
	    $("#user-img5").attr("src","../resources/newMain//img/user-5.png");
	    
   })
   
   $("#user-div2").click(function(){
	$("#feedback").click();
});
 $("#user-div1").click(function(){
	$("#dupapp").click();
});
   $("#user-div5").click(function(){
	 
	$("#outss").click();
});
  
   
 var winWidth =window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
 //alert(winWidth)
   if(winWidth>1200){
	 //  $("#top").css("min-width",winWidth*0.6)
   //  $(".content-main").css("min-width",winWidth*0.6)
   //  $("#top_div").css("min-width",winWidth*0.6)
   } else{
	 // $("#top").css("min-width",winWidth)
  //   $(".content-main").css("min-width",winWidth)
    // $("#top_div").css("min-width",880)
   }
  $("#top").css("min-width",890)
    $("#top_div").css("min-width",920)
     $(".content-main").css("min-width",890)
 //$("#top_div").css("min-width",winWidth*0.8)
/*top_div	$("#top").css("min-width",winWidth*0.8)
     $(".content-main").css("min-width",winWidth*0.8)*/
     
     var winheight = document.body.clientHeight;
	$("#iframe_div").css("height",winheight*0.75)
     
})


</script>
<script type="text/javascript">
	var timerr;
	var urll;
	var boo=true;
function bb(){
	
	
	}
	function startaa(Rid){
   //alert(Rid+"    33")
			  var webUrl=$("#mainframe").contents().find("#hidden2").val(); 
			  urll=webUrl; 
			  //alert(urll+"    33")
			 boo=false;
			}
	
	 $(function(){ 
		 
		 $("#top a").click(function() {
		  boo=true; 
urll=""; 
	})
	/*$("#top a").click(function(event) {
	    
				if($(this).text()=="首页"){//获取并判断主菜单的值
				
				$("#leftMenu").hide();
					$("#iframe_div").css("left","0")
				}else{
				$("#leftMenu").hide();
					$("#iframe_div").css("left","130px")
					$("#leftMenu").show();
				} 
				});  */
	var webUrl
	var webUrl1
	 var webUrl2
	 
	
		 $("#baoan").click(function(event) {
		var area=$("#mainframe").contents().find("#areatype").val(); 
			 if(area==1){
			  document.getElementById("baoans").click();
			  }
		
		 	}
		 )
	
	 
	
	
	/**
	点击按钮永艺发
	
	$("#yyf").click(function(event) {
		setTimeout("clickyyf()",1000); 
	})
	*/
	/**
	点击按钮欧达可
	
	$("#odk").click(function(event) {
		setTimeout("clickodk()",1000); 
//	clickodk()
	})
	*/
	/**
	点击按钮天地互通
	
	$("#tdht").click(function(event) {
		setTimeout("clicktdht()",1000); 
//	clicktdht()
	})
	*/
	/**
	点击按钮新公司
	
	$("#company_1").click(function(event) {
		setTimeout("clickzckj()",1000); 
//clickzckj()
	})
	*/
	/**
	点击按钮新公司

	$("#company_2").click(function(event) {
		setTimeout("clickryf()",1000); 
	//clickryf()
	})
		*/
	
	
	
	
	
	})		
	</script>
</head>
<body class="frameset" style="width:100%;font-size:62.5%;">
<div >
	<div class="container-top" style=" top:10px;">
		<!-- LOGO -->
		<div class="logo" style="margin-left: 20px;">
			<img src="${ctx}/resources/newMain/img/log2.png" border="0" style="" />
			
			
</div>
<%--<input type="text" id="search-green" />
--%><%--<div id="demoDiv1" bg="${ctx}/resources/img/background/b106fca84153.jpg" class="m"style="height:180px;">
  <div style="color:#fff">
      7 billion friends
  </div>
</div>
<%--<div id="demoDiv2" bg="${ctx}/resources/img/background/b106fca84153.jpg" class="m" style="height:180px;">
  <div style="color:#fff">
     地下管网在线采集系统
  --%></div>
</div>

<input id="impRid" value="${Rid}" type="hidden" /> 
				<a  type="hidden" href="${ctx}/admin/tdht/data/indexHtml?state=0&rid=${Rid}" id="mapp"   target="main"></a>
		
		<input name="state" value="${state}" type="hidden" /> 
		
		<a  type="hidden" href=""id="a_img"   target="main"></a>
       <a  type="hidden" href=""id="a_hidden"   target="main"></a>
       <a  type="hidden" href="${ctx}/admin/tdht/data/areaHtml" id="baoans"  target="main"></a>
		<!-- 公司查询 -->
		
		<c:if test="${webCompany.companyId ==1000}">
		
		<form action="${ctx}/admin/tdht/data/doGet" id="myform" name="myform" method="post"  target="main">
		
		 <div class="quick-link"  style="top:23px;padding-right: 300px; font-size: 18px;font-weight:bold;">
		 <div id="sss">
	   <input id="input_find"class="input_find" placeholder="请输入监控单元名称或者编号"type="text" value=""name="mainRID"style="height:40px;position: absolute;top: 0px;right: 300px;transition:width .2s;" />
        </div>
        <div id="img_div2"style="width:60px;height:60px; position: absolute;top: 3px;right: 260px;cursor:pointer; ">
	   <img alt="搜索" src="${ctx}/resources/newMain/img/search.png"id="img_find"  >
	    <button  id="sub_but" type="submit" style="display:none" ></button>
	   </div>
	    </div>
		
	    </form>
	    
		</c:if>
		
		<!-- 退出 -->
		<div class="quick-link" style="width:150px;">
			<p id="user-click" style="cursor:pointer ; position:absolute;top:0px;right:90px; width:160px; text-align:right; padding-right:10px;border-left: 2px solid #d0d0d0;border-right: 2px solid #d0d0d0;">
				<span style="position: absolute;left: 10px;top: 5px; font-family:微软雅黑;font-size: 15px;">${user.realName}</span> <img alt="用户" src="${ctx}/resources/newMain/img/user.png"id=""style="margin: 0px 10px 0px 10px;"  >
				
			</p>
			<div id="user-img-all" style="display: none;">
			<div  ><img alt="用户" src="${ctx}/resources/newMain/img/div_user.png"id=""style="position: absolute;right:95px;top: -3px;z-index: 99999;"  ></div>
			<div class="user-div user-div1"><div id="username" style="position: absolute;font-family:微软雅黑;font-size: 13px">${user.realName}</div><img alt="用户" src="${ctx}/resources/newMain/img/user.png"id="" ></div>
				<div style="position: absolute; right:110px;top:40px;text-align: left;">
			<div id="user-div1"class="user-div"><img alt="用户" src="${ctx}/resources/newMain/img/user-1.png"id="user-img1" ></div>
			<div  id="user-div2"class="user-div"><img alt="用户" src="${ctx}/resources/newMain/img/user-2.png"id="user-img2"  ></div>
			<a href="${ctx}/admin/tdht/feedback/findUserLogin" target="main"><div  id="user-div3"class="user-div"><img alt="用户" src="${ctx}/resources/newMain/img/user-3.png"id="user-img3"  ></div></a>
			<div id="user-div4" class="user-div"><img alt="用户" src="${ctx}/resources/newMain/img/user-4.png"id="user-img4"  ></div>
			<div  id="user-div5"class="user-div" style="border-top: 2px solid #d0d0d0"><img alt="用户"id="user-img5" src="${ctx}/resources/newMain/img/user-5.png"id="" style="margin-top: 5px " ></div>
			</div>
			</div>
			
			
			<div style="position: absolute; top:-10px;right:20px"><a  style="color:black"href="${ctx}/logout"><img id="outss" src="${ctx}/resources/newMain/img/out.png"/></a></div>
			<div style="margin-top: 30px;font-size: 12;display: none;">
			<a onclick="showtc(2)" id="feedback" style="color:black"  class="btn btn-primary btn-large theme-login" >反馈</a>
			<a onclick="showtc(1)" id="dupapp" style="color:black" class="btn btn-primary btn-large theme-logins" >下载APP</a>
			</div>
			
		</div>
	
	<!-- 意见反馈 -->
		<div class="theme-popover" id="tanchu2">
		     <div class="theme-poptit">
		          <a href="javascript:;" id="gbss" title="关闭" class="close">×</a>
		          <h3>意见反馈</h3>
		     </div>
		     <div class="theme-popbod dform">
		           <form class="theme-signin" id="loginform"  name="loginform" action="" method="post">
		                <ol>
		                     <li><strong>邮箱：</strong><input name="emil" type="text" class="ipt" id="emil"  style="width:400px" size="50" /></li>
		                     <li><strong>标题：</strong><input name="title" type="text" class="ipt" id="titles"  style="width:400px" /></li>
		                     <li><strong>内容：</strong><textarea rows="30" cols="40" id="content" name="content" class="ipt" style="width:400px;height:160px;" ></textarea></li>
		                     <li style="padding-left: 250px;"><input class="btn btn-primary" type="button" id="add-btn"name="submit" value=" 提交 " /></li>
		                </ol>
		           </form>
		     </div>
		</div>
		
	<!-- 下载APP -->
		<div class="theme-popover" id="tanchu1" style="width:420px;left:55%;">
		     <div class="theme-poptit">
		          <a href="javascript:;" id="gbss" title="关闭" class="close">×</a>
		          <h3>下载APP</h3>
		     </div>
		     <div class="theme-popbod dform">
		           <form class="theme-signin" id="loginform"  name="loginform" action="" method="post">
		                <ol>
		                     <li style="padding-left:0px;"><img src="${ctx}/resources/img/app.png"></li>
		                     <li style="padding-left: 100px;"><a href="/resources/app/TDHTsystemV1.apk"><input class="btn btn-primary" type="button" id="add-btn"name="submit" value="点击下载 " /></a></li>
		                </ol>
		           </form>
		     </div>
		</div>
		<!-- 下载APP2 -->
		<div class="theme-popover" id="tanchu11" style="width:420px;left:55%;">
		     <div class="theme-poptit">
		          <a href="javascript:;" id="gbss" title="关闭" class="close">×</a>
		          <h3>下载APP</h3>
		     </div>
		     <div class="theme-popbod dform">
		           <form class="theme-signin" id="loginform"  name="loginform" action="" method="post">
		                <ol>
		                     <li style="padding-left:0px;"><img src="${ctx}/resources/img/app2.png"></li>
		                     <li style="padding-left: 100px;"><a href="/resources/app2/TDHTWEV1.apk"><input class="btn btn-primary" type="button" id="add-btn"name="submit" value="点击下载 " /></a></li>
		                </ol>
		           </form>
		     </div>
		</div>
	

	
	<!-- 主菜单 -->
	<%--<div id="menudiv" class="navigation">
		<a  id="menuid" href="${ctx}/admin/index">首页</a>
		<c:forEach items="${sys_menus }" var="menu" varStatus="stats">
			<a id="menua${stats.index}"  href="${ctx}/admin/sys/sysMenu/mainMenu?parentId=${menu.menuId }" <c:if test="${currentFirstMenu == menu.menuId}"> class="current" </c:if>>${menu.fullName }</a>
		</c:forEach>
	</div>--%>
	<div id="top_div" style="border-top: 3px solid #3498db;border-bottom: 3px solid #3498db;position: relative; z-index: 9999 ;width:100%">
	<div id="top" style="height:50px;"class="container">
	<ul class="nav" style="z-index: 999;position: relative;">
         <li ><a id="indexa" href="${ctx}/admin/sys/sysMenu/mains?Rid=${Rid}" style="border-left: 2px solid #d0d0d0"  target="main">首&nbsp;&nbsp; 页</a> <img id="chose_img"src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"> <img id="chose_img2"class="chose_img2_1"  src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"></li>
         <li><a id="data13"href="" target="main">监测单元信息</a> <img id="chose_img" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"><img id="chose_img2" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"></li>
     	<li><a href="${ctx}/admin/tdht/data/areaHtml?area=baoan&rid=${webCompany.rid}" target="main">地图定位</a> <img id="chose_img" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"><img id="chose_img2" class="chose_img2_1"src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"></li>  
    	<li ><a  target="main">监测数据 <img id="pull-down"src="${ctx}/resources/newMain/img/pull-down2.png" ></a>  <img id="chose_img" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"><img id="chose_img2" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none">
    	
         <ul style="width: 12.19%;background-color: #00B9EF;position:absolute; ">
            
          <li style="width:100%;"> <img id="dot"src="${ctx}/resources/newMain/img/dot2.png"  class="dot"><a id="data2" name="webUrl" href="" target="main">实时数据</a></li>  
          <li><img id="dot" src="${ctx}/resources/newMain/img/dot2.png" class="dot2" ><a id="data20" name="webUrl" href="" target="main">历史数据</a><%-- <img id="pull-down2"src="${ctx}/resources/newMain/img/pull-down.png" > 
            <ul>
                 <li> <img id="dot2" src="${ctx}/resources/newMain/img/dot2.png" class="dot2" ><a id="data3"href="" target="main">日结报表</a></li>
                 <li> <img id="dot2" src="${ctx}/resources/newMain/img/dot2.png" class="dot2" ><a id="data4"href="" target="main">历史报表</a></li>
                 <li> <img id="dot2" src="${ctx}/resources/newMain/img/dot2.png" class="dot2"><a id="data5"href="" target="main">水平衡分析</a></li>
                 <li> <img id="dot2" src="${ctx}/resources/newMain/img/dot2.png" class="dot2"><a id="data55"href="" target="main">污染物汇总</a></li>
            </ul>
          --%></li>  
         </ul>  
         
     </li> 
     <li><a id="data21" name="webUrl" href="" target="main">图形曲线</a>  <%--<img id="pull-down"src="${ctx}/resources/newMain/img/pull-down2.png" ></a>--%> <img id="chose_img" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"><img id="chose_img2" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none">
         <%--<ul  style="width: 320px;height:160px;background-color: #00B9EF;position:absolute;  ">  
          <li style="margin-left:10px" ><img id="dot" src="${ctx}/resources/newMain/img/dot2.png" class="dot" ><a  target="main">监测曲线</a> <img id="pull-down2"src="${ctx}/resources/newMain/img/pull-down.png" > 
             <ul >  
                 <li><img id="dot2" src="${ctx}/resources/newMain/img/dot2.png" class="dot2"><a id="data6"href="" target="main">工业给水</a>  </li>  
                 <li><img id="dot2" src="${ctx}/resources/newMain/img/dot2.png"  class="dot2"><a id="data7"href="" target="main">生活给水</a>  </li>  
                 <li><img id="dot2" src="${ctx}/resources/newMain/img/dot2.png"  class="dot2"><a id="data8"href="" target="main">工业排水</a></li>  
                 <li><a onclick="alert('该功能未开放')"target="main">生活排水</a>  </li>  
             </ul>  
          </li>  
          <li><img id="dot" src="${ctx}/resources/newMain/img/dot2.png" class="dot" ><a  target="main">曲线分析</a>  <img id="pull-down2"src="${ctx}/resources/newMain/img/pull-down.png" >
             <ul>
                 <li><img id="dot2" src="${ctx}/resources/newMain/img/dot2.png" class="dot2" ><a id="data9"href="" target="main">流量汇总</a>  </li>  
                 <li><img id="dot2" src="${ctx}/resources/newMain/img/dot2.png" class="dot2" ><a id="data10"href="" target="main">流量系数</a>  </li>  
                 <li><a style="display:none" id="data11"href="" target="main">流量日结</a></li>  
                 <li><img id="dot2" src="${ctx}/resources/newMain/img/dot2.png" class="dot2" ><a id="data17" href="" target="main">污染物分析</a>  </li>  
            </ul>  
          </li>  
         </ul>  
     --%></li>  
     <li><a id="data12"href="" target="main">预警报警</a> <img id="chose_img" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"><img id="chose_img2" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"></li> 
     
     <c:if test="${webCompany.companyId ==1000}">
     <li><a  target="main">设备管理 <img id="pull-down"src="${ctx}/resources/newMain/img/pull-down2.png" ></a> <img id="chose_img" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"><img id="chose_img2" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none">
         <ul id="log_mun" style="width: 200px;height:200px;background-color: #00B9EF;position:absolute; ">
          <li><img  id="dot" src="${ctx}/resources/newMain/img/dot2.png"  style="left: 10px;"class="dot"><a id="data14" href="" target="main">设备状态</a></li>  
          <li><img id="dot" src="${ctx}/resources/newMain/img/dot2.png" style="left: 10px;" class="dot"><a id="data15" href="" target="main">设备控制</a></li>
          <li><img id="dot" src="${ctx}/resources/newMain/img/dot2.png" style="left: 10px;" class="dot"><a id="data18" href="" target="main">操作日志</a></li>
          <li><img id="dot" src="${ctx}/resources/newMain/img/dot2.png" style="left: 10px;" class="dot"><a id="data19" href="" target="main">设备日志</a></li>
         </ul> 
     </li>  
     </c:if>
     <c:if test="${webCompany.companyId >=2000&&webCompany.companyId <3000}"> 
     <li><a  target="main">设备管理 <img id="pull-down"src="${ctx}/resources/newMain/img/pull-down2.png" ></a> <img id="chose_img" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"><img id="chose_img2" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none">
         <ul id="log_mun" style="width: 24%;height:100px;background-color: #00B9EF;position:absolute; ">
          <li><img  id="dot" src="${ctx}/resources/newMain/img/dot2.png"  style=""class="dot"><a id="data14" href="" target="main">设备状态</a></li>  
          <li><img id="dot" src="${ctx}/resources/newMain/img/dot2.png" style="" class="dot"><a id="data15" href="" target="main">设备控制</a></li>
          <li><img id="dot" src="${ctx}/resources/newMain/img/dot2.png" style="left: 10px;" class="dot"><a id="data18" href="" target="main">操作日志</a></li>
      <%--    <li><img id="dot" src="${ctx}/resources/newMain/img/dot2.png" style="left: 10px;" class="dot"><a id="data19" href="" target="main">设备日志</a></li>
        
         --%></ul> 
     </li>  
     </c:if>

      <li><a href="${ctx}/admin/tdht/company/video?rid=${rid}" target="main">视频</a><img id="chose_img" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"><img id="chose_img2" src="${ctx}/resources/newMain/img/chose.png" style="position: absolute;display: none"></li><%--
   <li><a href="${ctx}/admin/sys/sysMenu/menuList" target="main">系统管理</a></li>
     
--%></ul>  
 
	</div>
	</div>
	<div class="container-main" style="height:100% ;">
	
          <div class="content-left"  id="leftMenu"style="height:88% ;float: left;border-bottom:4px solid white" >
	<!--左侧树形菜单 -->
	
		<%--<!-- content-left   -->
		<div class="content-left"  id="leftMenu">
		<ul class="sidebar" style="height:100%;">
		<c:if test="${webCompany.companyId ==1 or webCompany.companyId ==1000}">
		<li><a id="yyf"href="" target="main" >永艺发</a></li>
		</c:if>
		<c:if test="${webCompany.companyId ==2 or webCompany.companyId ==1000}">
		<li><a id="odk" href="" target="main">欧达可</a></li>
		</c:if>
		<c:if test="${webCompany.companyId ==3 or webCompany.companyId ==1000}">
		<li><a id="tdht" href="" target="main">天地互通</a></li>
		</c:if>
		<c:if test="${webCompany.companyId ==4 or webCompany.companyId ==1000}">
		<li><a id="company_1" href="" target="main">XX公司</a></li>
		</c:if>
		<c:if test="${webCompany.companyId ==5 or webCompany.companyId ==1000}">
		<li><a id="company_2" href="" target="main">XX公司</a></li>
		</c:if>
		</ul>
      			
      			
      	--%>
      	<div class="htmleaf-container" style=" height:100% ;width:100%;float: left;border-right: 5px solid #0372BC;" >
      	
      	<div class="htmleaf-content bgcolor-3" style="height:100% ;background-color:#fff; border-top:1px solid white;border-bottom:1px solid white;padding-top: 0px;">
			<!-- This is mtree list -->
			<ul class=mtree style="height:100% ;background-color:#fff">
			  <li><a href="#" class="city"><img id="dot" src="${ctx}/resources/newMain/img/dot.png"  class="dot_img">深圳市</a>
			    <ul>
			      <li><a id="baoan" href=""><img id="dot2" src="${ctx}/resources/newMain/img/dot.png"  class="dot_img2"  >宝安区</a>
			        <ul>
			           <c:forEach items="${company}" var="bean">
			           <li><a id="yyf"href="#"value="${bean.rid}"onclick='clickCom(${bean.rid})' ><img id="dot3" src="${ctx}/resources/newMain/img/dot.png" class="dot_img3"   >${bean.companyName}</a><a id="yyf1"href="" style="display: none;" target="main" ></a></li>
			           </c:forEach><%--
			       
			        
			        
		                  <li><a id="yyf"href="#"  >永艺发</a><a id="yyf1"href="" style="display: none;" target="main" ></a></li>
		                 <li><a id="odk" href="#" >欧达可</a><a id="odk1"href="" style="display: none;" target="main" ></a></li>
		                 <li><a id="tdht" href="#" >天地互通</a><a id="tdht1"href="" style="display: none;" target="main" ></a></li>
		                 <li><a id="company_1" href="#" >中村科技</a><a id="company_11"href="" style="display: none;" target="main" ></a></li>
		                 <li><a id="company_2" href="#" >瑞云峰</a><a id="company_22"href=""style="display: none;" target="main" ></a></li>
			        --%></ul>
			      </li>
			      <li><a href="#"><img id="dot2" src="${ctx}/resources/newMain/img/dot.png"  class="dot_img2"  >罗湖区</a></li>
			      <li><a href="#"><img id="dot2" src="${ctx}/resources/newMain/img/dot.png"   class="dot_img2" >福田区</a></li>
			      <li><a href="#"><img id="dot2" src="${ctx}/resources/newMain/img/dot.png"   class="dot_img2" >南山区</a></li>
			      <li><a href="#"><img id="dot2" src="${ctx}/resources/newMain/img/dot.png"   class="dot_img2" >盐田区</a></li>
			      <li><a href="#"><img id="dot2" src="${ctx}/resources/newMain/img/dot.png"   class="dot_img2" >龙华区</a></li>
			      <li><a href="#"><img id="dot2" src="${ctx}/resources/newMain/img/dot.png"  class="dot_img2"  >光明区</a></li>
			      <li><a href="#"><img id="dot2" src="${ctx}/resources/newMain/img/dot.png"  class="dot_img2"  >龙岗区</a></li>
			      <li><a href="#"><img id="dot2" src="${ctx}/resources/newMain/img/dot.png"   class="dot_img2" >坪山区</a></li>
			      <li><a href="#" style="border-bottom:2px solid #0372BC"><img id="dot2" src="${ctx}/resources/newMain/img/dot.png"   class="dot_img2" >大鹏区</a></li>
			   </ul>
			  </li>
			  <li><a style="border-bottom:2px solid #0372BC" href="#"><img id="dot" src="${ctx}/resources/newMain/img/dot.png"  class="dot_img" >广州市</a></li>
			  
			</ul>
		</div>
		
				
      		
	</div>
      			
      		</div>	
      		<div id="img_div"style="cursor:pointer; width: 30px;height: 100%;position: absolute;top: 150px;left: 140px;" ><div class="left_img"><div class="wrapper"><div class="vam"><div id="left_img"class="va"></div></div></div></div>
      		<%--<img id="img"style="width:25px ;cursor:pointer; "src="${ctx}/resources/newMain/img/left-img.png"  />
      		
      		
      			
      			--%></div>
      			
      			<%--<ul id="sidebar" class="sidebar">
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
      			</ul>--%>
<%--<script>
    $(function () {
        $("#sidebar").accordion({
            accordion: true,
            speed: 200,
    	    closedSign: '[+]',
    		openedSign: '[-]'
    	});
    });
</script>
			
		--%>
		<!-- end content-left   -->
		
		<main >
		<div id="iframe_div" class="content-main"; style=" margin-top:20px;" >
			<iframe  height="100%" frameborder="0" scrolling="auto" 
				allowtransparency="true" class="iframe-main" marginheight="0"
				marginwidth="0" name="main" id="mainframe" src="">
				</iframe>
	
	
		</div>
		
		</main>
		<div style="with:100%;height:30px; background: url(${ctx}/resources/lrtk/images/foot.png) no-repeat center;"></div> 
	
	</div>
	</div>
	
	<script src="${ctx}/resources/js/left/stopExecutionOnTimeout.js?t=1"></script>
	<%--<script src='http://libs.useso.com/js/jquery/1.8.0/jquery.min.js'></script>
	--%><script src="${ctx}/resources/js/left/jquery.velocity.min.js"></script>

	<script>
	;(function ($, window, document, undefined) {
	    if ($('ul.mtree').length) {
	        var collapsed = true;
	        var close_same_level = false;
	        var duration = 400;
	        var listAnim = true;
	        var easing = 'easeOutQuart';
	        $('.mtree ul').css({
	            'overflow': 'hidden',
	            'height': collapsed ? 0 : 'auto',
	            'display': collapsed ? 'none' : 'block'
	        });
	        var node = $('.mtree li:has(ul)');
	        node.each(function (index, val) {
	            $(this).children(':first-child').css('cursor', 'pointer');
	            $(this).addClass('mtree-node mtree-' + (collapsed ? 'closed' : 'open'));
	            $(this).children('ul').addClass('mtree-level-' + ($(this).parentsUntil($('ul.mtree'), 'ul').length + 1));
	        });
	        $('.mtree li > *:first-child').on('click.mtree-active', function (e) {
	            if ($(this).parent().hasClass('mtree-closed')) {
	                $('.mtree-active').not($(this).parent()).removeClass('mtree-active');
	                $(this).parent().addClass('mtree-active');
	            } else if ($(this).parent().hasClass('mtree-open')) {
	                $(this).parent().removeClass('mtree-active');
	            } else {
	                $('.mtree-active').not($(this).parent()).removeClass('mtree-active');
	                $(this).parent().toggleClass('mtree-active');
	            }
	        });
	        node.children(':first-child').on('click.mtree', function (e) {
	            var el = $(this).parent().children('ul').first();
	            var isOpen = $(this).parent().hasClass('mtree-open');
	            if ((close_same_level || $('.csl').hasClass('active')) && !isOpen) {
	                var close_items = $(this).closest('ul').children('.mtree-open').not($(this).parent()).children('ul');
	                if ($.Velocity) {
	                    close_items.velocity({ height: 0 }, {
	                        duration: duration,
	                        easing: easing,
	                        display: 'none',
	                        delay: 100,
	                        complete: function () {
	                            setNodeClass($(this).parent(), true);
	                        }
	                    });
	                } else {
	                    close_items.delay(100).slideToggle(duration, function () {
	                        setNodeClass($(this).parent(), true);
	                    });
	                }
	            }
	            el.css({ 'height': 'auto' });
	            if (!isOpen && $.Velocity && listAnim)
	                el.find(' > li, li.mtree-open > ul > li').css({ 'opacity': 0 }).velocity('stop').velocity('list');
	            if ($.Velocity) {
	                el.velocity('stop').velocity({
	                    height: isOpen ? [
	                        0,
	                        el.outerHeight()
	                    ] : [
	                        el.outerHeight(),
	                        0
	                    ]
	                }, {
	                    queue: false,
	                    duration: duration,
	                    easing: easing,
	                    display: isOpen ? 'none' : 'block',
	                    begin: setNodeClass($(this).parent(), isOpen),
	                    complete: function () {
	                        if (!isOpen)
	                            $(this).css('height', 'auto');
	                    }
	                });
	            } else {
	                setNodeClass($(this).parent(), isOpen);
	                el.slideToggle(duration);
	            }
	            e.preventDefault();
	        });
	        function setNodeClass(el, isOpen) {
	            if (isOpen) {
	                el.removeClass('mtree-open').addClass('mtree-closed');
	            } else {
	                el.removeClass('mtree-closed').addClass('mtree-open');
	            }
	        }
	        if ($.Velocity && listAnim) {
	            $.Velocity.Sequences.list = function (element, options, index, size) {
	                $.Velocity.animate(element, {
	                    opacity: [
	                        1,
	                        0
	                    ],
	                    translateY: [
	                        0,
	                        -(index + 1)
	                    ]
	                }, {
	                    delay: index * (duration / size / 2),
	                    duration: duration,
	                    easing: easing
	                });
	            };
	        }
	        if ($('.mtree').css('opacity') == 0) {
	            if ($.Velocity) {
	                $('.mtree').css('opacity', 1).children().css('opacity', 0).velocity('list');
	            } else {
	                $('.mtree').show(200);
	            }
	        }
	    }
	}(jQuery, this, this.document));
	$(document).ready(function () {
	    var mtree = $('ul.mtree');
	    mtree.wrap('<div class=mtree-demo></div>');
	    var skins = [
	        'bubba',
	        'skinny',
	        'transit',
	        'jet',
	        'nix'
	    ];
	    mtree.addClass(skins[0]);
	    $('body').prepend('<div class="mtree-skin-selector"><ul class="button-group radius"></ul></div>');
	    var s = $('.mtree-skin-selector');
	    $.each(skins, function (index, val) {
	        s.find('ul').append('<li><button class="small skin">' + val + '</button></li>');
	    });
	    s.find('ul').append('<li><button class="small csl active">Close Same Level</button></li>');
	    s.find('button.skin').each(function (index) {
	        $(this).on('click.mtree-skin-selector', function () {
	            s.find('button.skin.active').removeClass('active');
	            $(this).addClass('active');
	            mtree.removeClass(skins.join(' ')).addClass(skins[index]);
	        });
	    });
	    s.find('button:first').addClass('active');
	    s.find('.csl').on('click.mtree-close-same-level', function () {
	        $(this).toggleClass('active');
	    });
	});
	</script>
	
	<script type="text/javascript">
	
//	var statisDate = window.frames["mains"].document.getElementById('webUrls').value; 

	
		/* $(function() {
		//	alert(statisDate);
			//alert(document.getElementById("indexa").href);
			var input=$("#aaa").attr("href");
			
			if(input==""){
			   document.getElementById("indexa").click();//打开页面后默认点击
			}else{
			document.getElementById("aaa").click();//打开页面后默认点击
			}
			
		/**	var s = $('#sidebar').css('overflow', 'auto');
			var t = s.offset().top
			function onResize() {
				var height = document.body.offsetHeight - t;
				$('#sidebar').height(height);
				$('#mainframe').height(height);
			}
		**/
	
		/* 	window.onresize = onResize;

			onResize(); */

	//	})() */

	</script>
	<script type="text/javascript">
$(document).ready(function(){
  //weather
	$("#demoDiv1").MyFloatingBg({direction:-1});
	$("#demoDiv2").MyFloatingBg({direction:0, speed:50});
});
</script>

</body>

</html>