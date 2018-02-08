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
<head><%--

    <link rel="stylesheet" href="static/bootstrap/css/bootstrap/bootstrap.min.css" />
	--%>
		
	<script src="static/js/jquery.js"></script>
	<script type="text/javascript" src="static/js/jquery-ui-1.9.2.custom.min.js"></script>
	<%--script src="static/bootstrap/js/bootstrap.min.js"></script>	
	--%>
	<script src="static/bootstrap/bootstrap-table2/colResizable-1.6.js"></script>
	<script src="static/js/jquery-1.7.2.js"></script>

	<script src="static/js/changeHeight.js"></script>
	<script src="static/js/echarts.min.js"></script>
	<script src="static/js/myjs/center.js"></script>
<script>
  (function($){ 
	  $(document).ready(function(){   
		  $(".myDiv").center();
		   $(".water_div").center();
		   $(".poll_sum_div").center();
		   $(".t_div").center();
    });
  })(jQuery);</script>
<style type="text/css">
body{
overflow-x:hidden; 
}
.font_div{
    float:left;
    width:24%;
    height:auto; 
    border-left: 3px solid #28A2DB;
   
}
.balance_div{
 width:14%;
}
.font_div2{
   margin-left: 10px;
    font-family: 微软雅黑;
    margin-top:5px;
}
.font_div3{
   margin-left: 10px;
   color:#28A2DB;
    margin-top:5px;
}
.myDiv{
  width:95%; 
  height:100%; 
 
}
.water_div{
 width:95%; 
  height:50px; 
  top:10px;
}
.poll_sum_div{
 width:90%; 
  height:150px; 
  top:10px;
}
.t_div{
font-family: 微软雅黑;
 border-left: 3px solid #28A2DB; 
 height:20px;
 
}

.img_poll{
width: 113px; 
height: 11px;
background: #fff url('static/images/1.png') 0 0 no-repeat;
margin-top:5px;
 margin-left: 10px;
}
.img_PH{
width: 113px; 
height: 11px;
background: #fff url('static/images/jianbian2.png') 0 0 no-repeat;
margin-top:5px;
 margin-left: 10px;
}
.img_Do{
width: 113px; 
height: 11px;
background: #fff url('static/images/jianbian3.png') 0 0 no-repeat;
margin-top:5px;
 margin-left: 10px;
}
.img_poll_font{

    height: 20px;
    position: relative;
    top: -5px;
    float: right;
    left:5px;
}
.img_poll_div{

    height: 20px;
    width: 10%;
}
.module{
 font-size:16px;
 color:#3B9DDB;
 font-weight: 900;
  cursor: pointer;
}
.module-img{
width:15px;
}
.div-top{
display: none;
}

</style>

<base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="../../system/index/top.jsp"%>

</head>
<body style="background-color:#fff;"onload="resizeFrame()">
<a id="menuUrl" href="${menuUrl}"></a>
<input  id="R_ID" type="hidden"  value="${R_ID}"/>
<input  id="list" type="hidden"  value="${list}"/>
<c:if test="${list0.hasMenu}">
	<div class="col-lg-12">
           <div class="panel panel-primary">
             <div class="panel-heading" id="module0">
               <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list0.MENU_NAME}</h3>
             </div>
             <div class="panel-body" id="div0" style="height: 320px;padding-top:5px;">
             	<div id="morris-chart-area" style="margin:0;padding:0;height: 100%">
  
				  <div id="water_id" style="clear:both ;width:110%; margin:0;padding:0;display: none;height:70px;padding-top: 20px;">
				       <div class='t_div'>	工业排水</div>
				       <div id="water_id_div"class="water_div"style="top:10px;"></div>
				  </div>
				  <div id="water_is"style="clear:both ;width:110%; margin:0;padding:0;display: none;height:70px;padding-top: 20px;">
				       <div class='t_div'>工业给水</div>
				        <div id="water_is_div"class="water_div" style="top:10px;"></div>
				  </div>
				  <div id="water_ld"style="clear:both ;width:110%; margin:0;padding:0;display: none;height:70px;padding-top: 20px;">
				       <div class='t_div'>生活排水</div>
				        <div id="water_ld_div"class="water_div"style="top:10px;"></div>
				  </div>
				   <div id="water_ls"style="clear:both ;width:110%; margin:0;padding:0;display: none;height:70px;padding-top: 20px;">
				       <div class='t_div'>生活排水</div>
				        <div id="water_ls_div"class="water_div"style="top:10px;"></div>
				  </div>
				  
             </div>
           </div>
         </div>
       </div>
 </c:if>

<c:if test="${list1.hasMenu}">
	<div class="col-lg-12">
        <div class="panel panel-primary">
          <div class="panel-heading" id="module1">
            <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list1.MENU_NAME}</h3>
          </div>
          <div class="panel-body" id="div1" style="height: 320px;padding-top:5px;">
          	<div id="morris-chart-area" style="margin:0;padding:0;height: 100%">
 
				  <div id="balance_id" style="clear:both ;width:110%; margin:0;padding:0;display: none;height:70px;">
				       <div id="balance_id_div"class="water_div"style="top:10px;"></div>
				        <div id="main" style="height:200px;top:40px;width:50%;float: left;"></div>
				        <div id="main2" style="height:200px;top:40px;width:50%;float: left;"></div>
				  </div>
			 
			  </div>
           </div>
         </div>
       </div>
 </c:if>
<c:if test="${list2.hasMenu}">
	<div class="col-lg-12">
        <div class="panel panel-primary">
          <div class="panel-heading" id="module2">
            <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list2.MENU_NAME}</h3>
          </div>
          <div class="panel-body" id="div2" style="padding-top:0px;">
          	<div id="morris-chart-area" style="margin:0;padding:0;height: 100%">
          	
				  <div id="poll_id" style="clear:both ;width:100%; margin:0;padding:0;display: none;height:70px;">
				       <div id="poll_id_div"class="water_div"style="top:10px;"></div>
				  </div>
				  
 			</div>
           </div>
         </div>
       </div>
 </c:if>
<c:if test="${list3.hasMenu}">
	<div class="col-lg-12">
        <div class="panel panel-primary">
          <div class="panel-heading" id="module3">
            <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list3.MENU_NAME}</h3>
          </div>
          <div class="panel-body" id="div3" style="height: 100%;padding-top:15px;">
          	<div id="morris-chart-area" style="margin:0;padding:0;height: 100%">
    
			  <div id="poll_sum_id" style="clear:both ;width:110%; margin:0;padding:0;display: none;height:70px;">
			       <div id="poll_sum"class="t_div"style="margin-top: 10px">一类污染物排放总量</div>
			       <div id="poll_sum_div1"class="poll_sum_div"style="top:10px;"></div>
			       <div id="poll_avg"class="t_div"style="margin-top: 10px">一类污染物平均排放量</div>
			       <div id="poll_avg_div1"class="poll_sum_div"style="top:10px;"></div>
			       
			        <div id="poll_sum2"class="t_div"style="margin-top: 10px">二类污染物排放总量</div>
			       <div id="poll_sum_div2"class="poll_sum_div"style="top:10px;"></div>
			       <div id="poll_avg2"class="t_div"style="margin-top: 10px">二类污染物平均排放量</div>
			       <div id="poll_avg_div2"class="poll_sum_div"style="top:10px;"></div>
			  </div>
 
 			</div>
           </div>
         </div>
       </div>
 </c:if>

		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<script type="text/javascript">
		$(top.hangge());
	</script>
<script type="text/javascript">
function resizeFrame(){
            var content_iframe = window.parent.document.getElementById("iframe_div");//获取iframeID
            var div_height = $("body").css("height");//使iframe高度等于子网页高度
            console.log(div_height)
            content_iframe.style.height = div_height;
}
$(function () {
	var menuUrl=$("#menuUrl").attr("href")
		$.cookie('menuUrl_s', menuUrl, { expires: 1, path: '/TDHT3.0' });
	var R_ID=$("#R_ID").val();
	waterData(R_ID)
	pollData(R_ID)
	balanceData(R_ID)
	poll_sum_Data(R_ID)
	$("#module0").click(function(){ 
$("#div0").slideToggle("slow" )
  })  
	$("#module1").click(function(){ 
$("#div1").slideToggle("slow" )
  })  
$("#module2").click   (function(){ 
$("#div2").slideToggle("slow" )
  }) 
   $("#module3").click(function(){ 
$("#div3").slideToggle("slow" )
  }) 
 var lists=[];
     lists.push(${list0.hasMenu});
       lists.push(${list1.hasMenu});
       lists.push(${list2.hasMenu});
        lists.push(${list3.hasMenu});
        
        var height=0;
	for(i=0;i<lists.length;i++){
	  if(lists[i]){
		$("#div"+i).show();
		heights=$("#div"+i).parent().parent('.col-lg-12').height(); 
		  console.log(heights)
		if(heights!=null){
			height=height+heights;
		}
		//break;
	  }
  }
	
	
	
	
	//height=height+900;
 $("body").css("height",height)
 

    	
 
 
 
 
	function waterData(){
		  $.ajax({
          url:'NewData_water',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			//console.log(data)
			   $.each(data.varList, function(i, dvar){
				 // console.log(dvar.param_type)
			if(dvar.param_type==1){
				$("#water_id").show();
				$("#water_id_div").append("<div class='font_div'><div class='font_div2'>"+dvar.param_name_cn+"</div><div class='font_div3'>"+dvar.param_value.toFixed(dvar.decimal_number)+"</div></div>")
				
				}else if(dvar.param_type==2){
					$("#water_is").show();
					$("#water_is_div").append("<div class='font_div'><div class='font_div2'>"+dvar.param_name_cn+"</div><div class='font_div3'>"+dvar.param_value.toFixed(dvar.decimal_number)+"</div></div>")
				}else if(dvar.param_type==3){
					$("#water_ld").show();
					$("#water_ld_div").append("<div class='font_div'><div class='font_div2'>"+dvar.param_name_cn+"</div><div class='font_div3'>"+dvar.param_value.toFixed(dvar.decimal_number)+"</div></div>")
				}else if(dvar.param_type==4){
					$("#water_ls").show();
					$("#water_ls_div").append("<div class='font_div'><div class='font_div2'>"+dvar.param_name_cn+"</div><div class='font_div3'>"+dvar.param_value.toFixed(dvar.decimal_number)+"</div></div>")
				}
			})
			
			
			
			
			
		}
		})
	}
	
	function pollData(){
		  $.ajax({
          url:'NewData_poll',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			   $.each(data.varList, function(i, dvar){
				 // console.log(dvar.param_type)
			
				$("#poll_id").show();
				$("#poll_id_div").append("<div class='font_div'style='margin-top:20px;'><div class='font_div2'>"+dvar.param_name_cn+"</div><div class='font_div3'>"+dvar.param_value.toFixed(dvar.decimal_number)+"</div>" +
				"   <div id=div_"+dvar.param_name_sql+" class='' title='限值:"+dvar.limitLL+"-"+dvar.limitHH+"'><div  id="+dvar.param_name_sql+" class='img_poll_div'><img class='img_poll_font'src='static/images/2.png' border='1' />"+
	            "</div></div> </div>")
	            
	            if(dvar.param_name_cn=='PH值'){
	            $("#div_"+dvar.param_name_sql).addClass('img_PH');
	            }else if(dvar.param_name_cn=='溶解氧(mg/l)'){
	             $("#div_"+dvar.param_name_sql).addClass('img_Do');	
	            }else{
	            	 $("#div_"+dvar.param_name_sql).addClass('img_poll');
	            }
	            
	            
	        //    console.log(dvar.param_value)
				if(dvar.param_value<=dvar.limitLL){
					$("#"+dvar.param_name_sql).width("0%");
				}else if(dvar.param_value>dvar.limitLL&&dvar.param_value<dvar.limitHH){
					var value=(dvar.param_value-dvar.limitLL)/(dvar.limitHH-dvar.limitLL)*100
					$("#"+dvar.param_name_sql).width(value+"%");
					
				}else if(dvar.param_value>=dvar.limitHH){
					
					$("#"+dvar.param_name_sql).width("100%");
					
				}
				
				$( "#div_"+dvar.param_name_sql).tooltip();
			})
			
			
		}
		})
	}
	function balanceData(){
		  $.ajax({
          url:'balance_water',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			  
				 
			var pds=data.pds;
			 console.log(pds)
			 if(pds!=null){
				 
			
			 
			 if(!pds.isHave&&!pds.lsHave&&!pds.idHave&&!pds.ldHave){
				 $("#balance_id").hide();
			 }
				$("#balance_id").show();
				
			 if(pds.isHave){
				 var th1="<div class='font_div  balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>工业进水</div>" +
				"<div class='font_div3'>"+pds.Isztraffic_sum.toFixed(2)+"</div>" +
				"</div>";
			 } 
			 if(pds.lsHave){
			   th1+= "<div class='font_div balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>生活进水</div>" +
				"<div class='font_div3'>"+pds.Lsztraffic_sum.toFixed(2)+"</div>" +
				"</div>" ; 
			 }
			  if(pds.idHave){
			   th1+="<div class='font_div balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>工业排水</div>" +
				"<div class='font_div3'>"+pds.Idztraffic_sum.toFixed(2)+"</div>" +
				"</div>" ;
			 }
			  if(pds.ldHave){
			   th1+="<div class='font_div balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>生活排水</div>" +
				"<div class='font_div3'>"+pds.Ldztraffic_sum.toFixed(2)+"</div>" +
				"</div>" ;
			 }
			  
			  
				th1+="<div class='font_div balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>损耗限值</div>" +
				"<div class='font_div3'>"+pds.Losslimit_sum.toFixed(2)+"</div></div>" +
				"<div class='font_div  balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>损耗值</div>" +
				"<div class='font_div3'>"+pds.Wastage_sum.toFixed(2)+"</div></div>" +
				"<div class='font_div  balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>不明用水</div>" +
				"<div class='font_div3'>"+pds.Unknow_sum.toFixed(2)+"</div></div>"
				
				

		  $th1 = $(th1);
           //清除数据
           $("#balance_id_div").empty();
           //添加td
    		$("#balance_id_div").append($th1);
			 }else{
				  var th1="<div class='font_div  balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>工业进水</div>" +
				"<div class='font_div3'>-</div>" +
				"</div>"
			   th1+= "<div class='font_div balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>生活进水</div>" +
				"<div class='font_div3'>-</div>" +
				"</div>" ; 
			
			   th1+="<div class='font_div balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>工业排水</div>" +
				"<div class='font_div3'>-</div>" +
				"</div>" ;
			 
			   th1+="<div class='font_div balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>生活排水</div>" +
				"<div class='font_div3'>-</div>" +
				"</div>" ;
			
			  
			  
				th1+="<div class='font_div balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>损耗限值</div>" +
				"<div class='font_div3'>-</div></div>" +
				"<div class='font_div  balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>损耗值</div>" +
				"<div class='font_div3'>-</div></div>" +
				"<div class='font_div  balance_div'style='margin-top:20px;'>" +
				"<div class='font_div2'>不明用水</div>" +
				"<div class='font_div3'>-</div></div>"
				
				

		  $th1 = $(th1);
           //清除数据
           $("#balance_id_div").empty();
           //添加td
    		$("#balance_id_div").append($th1);
			
			 }
           
         var myChart = echarts.init(document.getElementById('main')); 
        
           option = {
    title : {
        text: '给水比例',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['工业给水','生活给水']
    },
    series : [
        {
            name: '给水比例',
            type: 'pie',
            radius : '55%',
            center: ['50%', '50%'],
            data:[
                {value:pds.Isztraffic_sum, name:'工业给水'},
                {value:pds.Lsztraffic_sum, name:'生活给水'}
                
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
              myChart.setOption(option, true);
           window.onresize = myChart.resize;
                myChart.setOption(option);
           
             var myChart2 = echarts.init(document.getElementById('main2')); 
        
           option2 = {
    title : {
        text: '排水比例',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['工业排水','损耗值','不明用水']
    },
    series : [
        {
            name: '排水比例',
            type: 'pie',
            radius : '55%',
            center: ['50%', '50%'],
            data:[
                {value:pds.Idztraffic_sum, name:'工业排水'},
                {value:pds.Wastage_sum, name:'损耗值'},
                {value:pds.Unknow_sum, name:'不明用水'}
                
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
              myChart2.setOption(option2, true);
           window.onresize = myChart2.resize;
                myChart2.setOption(option2);
           
           
           
           
			
		}
		})
	}
	
		function poll_sum_Data(){
		  $.ajax({
          url:'poll_sum',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			var poll_all_sum=data.poll_all_sum;
			console.log(data)
			console.log(poll_all_sum)
			console.log(data.varList)
			
			
			var pollutant_type_num1=0;
			var pollutant_type_num2=0;
			//var poll_all_sum2=data.poll_all_sum2;
			   $.each(data.varList, function(i, dvar){
				 // console.log(dvar.param_type)
				 var sql=dvar.param_name_sql
			
				$("#poll_sum_id").show();
				 
				 if(dvar.pollutant_type==1){
				$("#poll_sum_div1").append("<div class='font_div'style='margin-top:20px;'><div class='font_div2'>"+dvar.param_name_cn+"</div><div class='font_div3'>"+dvar.param_value.toFixed(dvar.decimal_number)+"</div></div>")
	            $("#poll_avg_div1").append("<div class='font_div'style='margin-top:20px;'><div class='font_div2'>"+dvar.param_name_cn+"</div><div class='font_div3'>"+dvar.param_value2.toFixed(dvar.decimal_number)+"</div>" +
	            "   <div id=div_poll_"+dvar.param_name_sql+" class='' title='限值:"+dvar.limitLL+"-"+dvar.limitHH+"'><div  id="+dvar.param_name_sql+" class='img_poll_div'><img class='img_poll_font'src='static/images/2.png' border='1' />"+
	            "</div></div> </div>")
	            pollutant_type_num1++;
				 }
				 
				 
				 if(dvar.pollutant_type==2){
				$("#poll_sum_div2").append("<div class='font_div'style='margin-top:20px;'><div class='font_div2'>"+dvar.param_name_cn+"</div><div class='font_div3'>"+dvar.param_value.toFixed(dvar.decimal_number)+"</div></div>")
	            $("#poll_avg_div2").append("<div class='font_div'style='margin-top:20px;'><div class='font_div2'>"+dvar.param_name_cn+"</div><div class='font_div3'>"+dvar.param_value2.toFixed(dvar.decimal_number)+"</div>" +
	            "   <div id=div_poll_"+dvar.param_name_sql+" class='' title='限值:"+dvar.limitLL+"-"+dvar.limitHH+"'><div  id="+dvar.param_name_sql+" class='img_poll_div'><img class='img_poll_font'src='static/images/2.png' border='1' />"+
	            "</div></div> </div>")
				 pollutant_type_num2++
				 }
	           if(dvar.param_value<=dvar.limitLL){
					$("#"+dvar.param_name_sql).width("0%");
				}else if(dvar.param_value>dvar.limitLL&&dvar.param_value<dvar.limitHH){
					var value=(dvar.param_value-dvar.limitLL)/(dvar.limitHH-dvar.limitLL)*100
					$("#"+dvar.param_name_sql).width(value+"%");
					
				}else if(dvar.param_value>=dvar.limitHH){
					
					$("#"+dvar.param_name_sql).width("100%");
					
				}
				$("#div_poll_"+dvar.param_name_sql).addClass('img_Do');	
				$( "#div_"+dvar.param_name_sql).tooltip();
	            
	            
	        //    console.log(dvar.param_value)
			/*	if(dvar.param_value<=dvar.limitLL){
					$("#"+dvar.param_name_sql).width("0%");
				}else if(dvar.param_value>dvar.limitLL&&dvar.param_value<dvar.limitHH){
					var value=(dvar.param_value-dvar.limitLL)/(dvar.limitHH-dvar.limitLL)*100
					$("#"+dvar.param_name_sql).width(value+"%");
					
				}else if(dvar.param_value>=dvar.limitHH){
					
					$("#"+dvar.param_name_sql).width("100%");
					
				}*/
				
				//$( "#div_"+dvar.param_name_sql).tooltip();
			})
			console.log(pollutant_type_num1)
			if(pollutant_type_num1==0){
					$("#poll_sum").hide();
					$("#poll_sum_div1").hide();
					$("#poll_avg").hide();
					$("#poll_avg_div1").hide();
					
				 }
			   if(pollutant_type_num2==0){
					$("#poll_sum2").hide();
					$("#poll_sum_div2").hide();
					$("#poll_avg2").hide();
					$("#poll_avg_div2").hide();
					
				 }
			
		}
		})
	}
})

</script>

</body>
</html>