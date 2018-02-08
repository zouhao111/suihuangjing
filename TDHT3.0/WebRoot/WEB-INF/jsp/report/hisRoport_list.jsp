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
	<!-- 日期框 -->
	<link rel="stylesheet" href="static/bootstrap/bootstrap-datetime/bootstrap-datetimepicker.css" />
  <script type="text/javascript" src="static/bootstrap/bootstrap-datetime/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="static/bootstrap/bootstrap-datetime/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="static/bootstrap/bootstrap-datetime/bootstrap-time.js"></script>
	
	<script src="static/js/echarts.min.js"></script>
	
	
		<link href="static/buttons/buttons.css" rel="stylesheet" type="text/css"/>
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
font-family: 微软雅黑;font-size: 16px;
}
.font_div{
    float:left;
    width:24%;
    height:auto; 
    border-left: 3px solid #28A2DB;
   
}
.balance_div{
 width:15%;
}
.font_div2{
   margin-left: 10px;
    font-family: 微软雅黑;font-size: 16px;
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
 width:90%; 
  height:50px; 
  top:10px;
}
.poll_sum_div{
 width:90%; 
  height:150px; 
  top:10px;
}
.t_div{
font-family: 微软雅黑;font-size: 16px;
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
.font-css{
font-family: 微软雅黑;
font-size: 16px;
}
.timeser{
position: relative;
z-index: 99999;
width:85%;
}
</style>

<base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="../system/index/top.jsp"%>

</head>
<body style="background-color:#fff;" onload="resizeFrame()">
<a id="menuUrl" href="${menuUrl}"></a>
<input  id="R_ID" type="hidden"  value="${R_ID}"/>
<input  id="list" type="hidden"  value="${list}"/>
<c:if test="${list0.hasMenu}">
	<div class="col-lg-12" style="top:10px;">
       <div class="panel panel-primary">
         <div class="panel-heading" id="module0">
           <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list0.MENU_NAME}</h3>
         </div>
         <div class="panel-body" id="div0" style="height:470px;">
         <div id="morris-chart-area" style="position: relative;margin:0;padding:0;height: 100%">

    
		   <div class="font-css timeser">
		        <div id="option0" style="float: left;margin-top: 5px;width:55%;">
		        	<label class="col-sm-3 control-label no-padding-right" for="form-field-1">水类型：</label>
					<div class="col-sm-9" style="width:30%;">
					    <div class="selQ313596790Qsel"></div>
					    <select class="chosen-select form-control" name="name" id="waterSelect"data-placeholder="请选择"><option value=""></option>
					    <c:forEach items="${water_type}" var="list">
					     <option value="${list.param_type}">${list.water_type}</option>
					    </c:forEach>
					   </select><div class="selQ313596790Qsel"></div>
					</div>
		            <label id="label0" style="float:left;"onclick="time(0,1)">
		                <input name="form-field" type="radio"  checked value="1" class="ace" >	<span class="lbl">按天统计</span>
		            </label>
		            <label id="label0" style="float:left;"onclick="time(0,2)">
		                <input name="form-field" type="radio" "  value="2"class="ace" >	<span class="lbl">按月统计</span>
		            </label>
		            <label id="label0"style="float:left;"onclick="time(0,4)">
		                <input name="form-field" type="radio" " class="ace"value="4"  >	<span class="lbl">按年统计</span>
		            </label>
		             <label id="label0"style="float:left;"onclick="time(0,5)">
		                <input name="form-field" type="radio" " class="ace"value="5"  >	<span class="lbl">自定义统计</span>
		            </label>
		        </div>
				    <div id="startTime"style="float: left;margin-left: 10px;">
				  		时间: <input type="text" value="" id="datetimepicker0" >
				       <input style="display: none;" type="text" value="" id="end_datetimepicker0" >
				   </div>
		    	<button  id="search"onclick="water_line()" style="margin-left: 20px;" class="button button-glow button-border button-rounded button-primary">刷新</button >
		</div>
		<div id="water_line" style="clear:both ;width:110%; margin:0;padding:0;display: none;height:70px;">
	        <div id="main" style="height:400px;top:30px;width:75%;float: left;"></div>
	  	</div>

  	</div>	
	</div>
    </div>
  </div>
 </c:if>

<%--<c:if test="${list1.hasMenu}">
   <div id="module1" >
 
  <span class="module"> <img class="module-img" src="static/images/3gang.png"/> ${list1.MENU_NAME}</span>
  </div>
  <div  id="div1" class="div-top"style="height: 500px;">
  <div style=" margin:0;padding:0;height: 100%">
    <div class="myDiv">
     <div class="font-css timeser">
   
        <div id="option1" style="float: left;margin-top: 5px;">
        
</div>
         <label id="label1" style="float:left;"onclick="time(1,1)">
                <input name="form-field2" type="radio"  checked value="1"class="ace" >	<span class="lbl">按天统计</span>
            </label>
            <label id="label1"style="float:left;"onclick="time(1,2)">
                <input name="form-field2" type="radio"   value="2"class="ace" >	<span class="lbl">按月统计</span>
            </label>
            <label id="label1"style="float:left;"onclick="time(1,4)" >
                <input name="form-field2" type="radio" class="ace"value="4"  >	<span class="lbl">按年统计</span>

            </label>
            </label>
             <label id="label1"style="float:left;"onclick="time(1,5)">
                <input name="form-field" type="radio" " class="ace"value="5"  >	<span class="lbl">自定义统计</span>

            </label>
        </div>
     <div id="startTime"style="float: left;margin-left: 10px;">
  时间: <input type="text" value="" id="datetimepicker1" >
  <input style="display: none;" type="text" value="" id="end_datetimepicker1" >
   </div>
    
    <button  id="search1" onclick="poll_line()"style="margin-left: 20px;" class="button button-glow button-border button-rounded button-primary">刷新</button >
</div>
  <div id="poll_line1" style="clear:both ;width:110%; margin:0;padding:0;display: none;height:70px;">
      
       
  </div>
 
  </div>
  </div>
  </div>
 </c:if>
--%><c:if test="${list2.hasMenu}">
	<div class="col-lg-12">
       <div class="panel panel-primary" style="border-top-width: 0px;">
         <div class="panel-heading" id="module2">
           <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list2.MENU_NAME}</h3>
         </div>
         <div class="panel-body" id="div2" style="height:470px;">
         <div id="morris-chart-area" style="position: relative;height: 100%">
    
	       <div class="font-css timeser">
	       	  <div style="float: left;margin-top: 5px;width:40%;">
	        	<label id="label2" style="float:left;"onclick="time(2,1)">
	                <input name="form-field3" type="radio"  checked value="1" class="ace" >	<span class="lbl">按天统计</span>
	            </label>
	            <label id="label2"style="float:left;"onclick="time(2,2)">
	                <input name="form-field3" type="radio"   value="2"class="ace" >	<span class="lbl">按月统计</span>
	            </label>
	            <label id="label2"style="float:left;"onclick="time(2,4)" >
	                <input name="form-field3" type="radio" class="ace"value="4"  >	<span class="lbl">按年统计</span>
	            </label>
	            </label>
	             <label id="label2"style="float:left;"onclick="time(2,5)">
	                <input name="form-field3" type="radio" " class="ace"value="5"  >	<span class="lbl">自定义统计</span>
	            </label>
	           </div>
		     <div id="startTime"style="float: left;margin-left: 10px;">
			  时间: <input type="text" value="" id="datetimepicker2" >
			  <input style="display: none;" type="text" value="" id="end_datetimepicker2" >
		     </div>
	    	<button  id="search2" onclick="poll_line()"style="margin-left: 20px;" class="button button-glow button-border button-rounded button-primary">刷新</button >
	 	</div>
		<div id="poll_line" style="clear:both ;width:110%; margin:0;padding:0;display: none;height:70px;">
		  <div id="main2" style="height:400px;top:30px;width:75%;float: left;"></div>
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
	<%@ include file="../system/index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
	<script type="text/javascript">
		$(top.hangge());
		
	</script>
	<script type="text/javascript">
	var height=0;
$(function () {
	var menuUrl=$("#menuUrl").attr("href")
		$.cookie('menuUrl_ss', menuUrl, { expires: 1, path: '/TDHT3.0' });
	   var lists=[];
     lists.push(${list0.hasMenu});
       lists.push(${list1.hasMenu});
       lists.push(${list2.hasMenu});
        
       
       for(i=lists.length-1;i>=0;i--){
		//console.log(i)
	  if(lists[i]){
		$("#div"+i).show();
       
		
		heights=$("#div"+i).parent().parent('.col-lg-12').height(); 
		if(heights!=null){
			height=height+heights;
		}
		
		}
	  }
       height=height+100;
 $("body").css("height",height)
	for(i=lists.length-1;i>=0;i--){
		//console.log(i)
	  if(lists[i]){
				$("#label"+i).trigger("click"); 
					//	arr[0].click();
	  }
  }
	 })
	 function resizeFrame(){
            var content_iframe = window.parent.document.getElementById("pages");//获取iframeID
            console.log(content_iframe)
              var content_iframes = window.parent.parent.document.getElementById("iframe_div");//获取iframeID
            var div_height = $("body").css("height");//使iframe高度等于子网页高度
            content_iframe.style.height = height+"px";
         height=height+100;
            content_iframes.style.height = height+"px";
}
</script>
<script type="text/javascript">
  function water_line(){
	  $("#water_line").show();
	  var R_ID=$("#R_ID").val();
	  console.log($("#R_ID").val())
	   var from=$("input[name='form-field']:checked").val();//日月年
  var startTime0=$('#datetimepicker0').val();
   var endTime0=$('#end_datetimepicker0').val();
    var waterSelect= $("#waterSelect option:selected").val();
   Line_his_water(R_ID,from,startTime0,endTime0,waterSelect);
	  
  }

</script>
<script type="text/javascript">
  function poll_line(){
	//  alert("1")
	  $("#poll_line").show();
	  var R_ID=$("#R_ID").val();
	   var from=$("input[name='form-field3']:checked").val();//日月年
  var startTime2=$('#datetimepicker2').val();
	   var endTime2=$('#end_datetimepicker2').val();
   line_his_poll(from,startTime2,endTime2,R_ID);
	  
  }

</script>
<script type="text/javascript">
$(function () {
	var a = document.getElementById("waterSelect");//mySelect是select 的Id
  a.options[1].selected = true;
	//	var from=$('input:radio:checked').val();//日月年
		 
		
		
		//$("#option").firstChild.trigger("click");
	//time();
	var R_ID=$("#R_ID").val();
	 
	 
	// alert(startTime)
	 
	//List_report_poll(R_ID)
	/*pollData(R_ID)
	balanceData(R_ID)
	poll_sum_Data(R_ID)*/
	$("#module0").click(function(){ 
$("#div0").slideToggle("slow" )
  })  
	$("#module1").click(function(){ 
$("#div1").slideToggle("slow" )
  })  
  $("#module2").click(function(){ 
$("#div2").slideToggle("slow" )
  }) 
  

 		
			
		
	water_line();
	poll_line();
	
})

</script>
<script type="text/javascript">

	
	
	function Line_his_water(R_ID,from,startTime0,endTime0,waterSelect){
		var myChart = echarts.init(document.getElementById('main')); 
		myChart.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
		  $.ajax({
          url:'line_his_water',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID,from,startTime0,endTime0,waterSelect},
		success:function(data){
			//console.log(data)
			var strTimes=data.strTimes;
			var selectList=data.selectList
			var water_cof=data.water_cof
			var series=[];
    for(var i = 0;i<selectList.length;i++){
        series.push({
             name:selectList[i].param_name_cn,
            type:'line',
            data:selectList[i].dataList,
        });
    }
			option = {
    title: {
        text: '流量曲线图',
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:water_cof
    },
    toolbox: {
        show: true,
        feature: {
            dataZoom: {
                yAxisIndex: 'none'
            },
            dataView: {readOnly: false},
            magicType: {type: ['line']},
            restore: {},
            saveAsImage: {}
        }
    },
    xAxis:  {
        type: 'category',
        boundaryGap: false,
        data: strTimes
    },
    yAxis: {
        type: 'value',
        splitArea : {show : true}//保留网格区域
       /* axisLabel: {
            formatter: '{value} °C'
        }*/
    },
    series: series
};
			
		 myChart.setOption(option, true);
           window.onresize = myChart.resize;
                myChart.setOption(option);
                myChart.hideLoading();
	}
		})
	}
</script>
<script type="text/javascript">

	
	
	function line_his_poll(from,startTime2,endTime2,R_ID){
		var myChart2 = echarts.init(document.getElementById('main2')); 
		myChart2.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
		
		  $.ajax({
          url:'line_his_poll',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID,from,startTime2,endTime2},
		success:function(data){
			console.log(data)
			var strTimes=data.strTimes;
			var varList=data.varList
			var poll_type=data.poll_type
			var poll_type_select=data.poll_type_select
			
			var poll_type_select=[];
			
			
			
			
			var series=[];
    for(var i = 0;i<varList.length;i++){
        series.push({
             name:varList[i].param_name_cn,
            type:'line',
            data:varList[i].dataList,
        });
    }
			
			option2 = {
    title: {
        text: '水质曲线图',
         top:0,
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:poll_type,
        top:30,
        selected:{},
    },
    toolbox: {
        show: true,
        top:0,
        feature: {
            dataZoom: {
                yAxisIndex: 'none'
            },
            dataView: {readOnly: false},
            magicType: {type: ['line']},
            restore: {},
            saveAsImage: {}
        }
    },
    xAxis:  {
        type: 'category',
        boundaryGap: false,
        data: strTimes
    },
    yAxis: {
        type: 'value',
        splitArea : {show : true}//保留网格区域
       /* axisLabel: {
            formatter: '{value} °C'
        }*/
    },
    series: series
};
			
		 myChart2.setOption(option2, true);
           window.onresize = myChart2.resize;
           
           for(var a = 1;a<poll_type.length;a++){
				option2.legend.selected[poll_type[a]] = false;
                  
			}
           
                myChart2.setOption(option2);
                
                 myChart2.hideLoading();
                
	}
		})
	}
</script>

	
</body>
</html>