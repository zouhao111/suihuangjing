﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<head>
	
	<%--

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
	
	<link rel="stylesheet" href="static/bootstrap/bootstrap-table/bootstrap-table.css" />	
	<script src="static/bootstrap/bootstrap-table/bootstrap-table2.js"></script>
	<script src="static/bootstrap/bootstrap-table2/colResizable-1.6.js"></script>

	<script src="static/bootstrap/extends/tableExport/jquery.base64.js"></script>
	<script src="static/bootstrap/js/tableExport.js"></script>
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
.myDiv{
  width:95%; 
  height:100%; 
 
}
.module{
 font-size:16px;
 color:#3B9DDB;
 font-weight: 900;
  cursor: pointer;
}
.warning_div{
background: #fff url('static/images/warning.png') 0 0 no-repeat;
width: 150px; 
height:132px;
font-family: 微软雅黑;font-size: 16px;
color:#fff;
float:left;
margin-right: 50px;
}
.warning_div div{

position: relative;
top:10px;
left:10px;
}
.warning_div div span{
position: relative;
top:7px;
}
.early_warning_div{
background: #fff url('static/images/early_warning.png') 0 0 no-repeat;
width: 150px; 
height:132px;
font-family: 微软雅黑;font-size: 16px;
color:#fff;
float:left;
margin-right: 50px;
}
.early_warning_div div{

position: relative;
top:10px;
left:10px;
}
.early_warning_div div span{
position: relative;
top:7px;
}
</style>
 <base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
  
</head>

<body style="background-color:#fff;"onload="resizeFrame()">
<a id="menuUrl" href="${menuUrl}"></a>
<input  id="R_ID" type="hidden"  value="${R_ID}"/>
<input  id="list" type="hidden"  value="${list}"/>

<c:if  test="${list0.hasMenu == true}" >
<div class="col-lg-12" style="top:10px;">
       <div class="panel panel-primary" style="border-top-width: 0px;">
         <div class="panel-heading" id="module0">
           <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list0.MENU_NAME}</h3>
         </div>
         <div class="panel-body" id="div0" style="width:100%;">
         <div id="morris-chart-area" style="position: relative;margin:0;padding:0;height:100%">
    
         <div id="warning"></div>
         
    </div>	
	</div>
    </div>
  </div>
</c:if>

<c:if  test="${list1.hasMenu == true}" >
<div class="col-lg-12" >
       <div class="panel panel-primary" >
         <div class="panel-heading" id="module1">
           <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list1.MENU_NAME}</h3>
         </div>
         <div class="panel-body" id="div1" style="width:100%;height:480px;">
         <div id="morris-chart-area" style="position: relative;margin:0;padding:0;height:100%">

	
		<div style="width:48%;float:left;height:15%;padding-left: 20px;">
			<div class="font-css timeser" style="width:98%;height:60px;">
			<div style="width:100%;height:45%;">
				     <label id="label1" style="float:left;"onclick="time(1,1)">
                <input name="form-field2" type="radio"  checked value="1"class="ace" >	<span class="lbl">按天统计</span>
            </label>
				           <label id="label1"style="float:left;"onclick="time(1,2)">
                <input name="form-field2" type="radio" checked  value="2"class="ace" >	<span class="lbl">按月统计</span>
            </label>
            <label id="label1"style="float:left;"onclick="time(1,4)" >
                <input name="form-field2" type="radio" class="ace"value="4"  >	<span class="lbl">按年统计</span>

            </label>
            </label>
             <label id="label1"style="float:left;"onclick="time(1,5)">
                <input name="form-field2" type="radio" " class="ace"value="5"  >	<span class="lbl">自定义统计</span>
            </label>
				</div>    
				    	<div id="startTime"style="float: left;margin-left: 10px;">
				  			时间: <input name="datetimepicker" type="text" value="" id="datetimepicker1" >
				  			<input style="display: none;" type="text" value="" id="end_datetimepicker1" >
				   		</div>
				   		<button style="margin-left: 20px;" onclick="Warning()" class="button button-glow button-border button-rounded button-primary"  >刷新</button>
			</div>
			<div id="warningdiv" style="clear:both ;width:100%; margin:0;padding:0;display: none;height:350px;">
			
			<div id="main" style="width:100%;height:100%;float:left;"></div>
			</div>
	   </div>
	   <div style="width:48%;float:right;right:50px;padding-left: 20px;">
			<div class="font-css timeser" style="width:98%;height:60px;">
			<div style="width:100%;height:45%;">
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
		  			时间: <input name="datetimepicker" type="text" value="" id="datetimepicker2" >
		  			 <input style="display: none;" type="text" value="" id="end_datetimepicker2" >
		   		</div>
		   		<button style="margin-left: 20px;" onclick="Early_Warning()" class="button button-glow button-border button-rounded button-primary"  >刷新</button>
			</div>
			<div id="earlywarningdiv" style="clear:both ;width:100%; margin:0;padding:0;display: none;height:350px;">
			<div id="main2" style="width:100%;height:100%;float:left;"></div>
			</div>
	   </div>
	   
	</div>	
	</div>
    </div>
  </div>
</c:if>

<c:if  test="${list2.hasMenu == true}" >
	<div class="col-lg-12" >
       <div class="panel panel-primary" style="border-top-width: 0px;">
         <div class="panel-heading" id="module2">
           <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list2.MENU_NAME}</h3>
         </div>
         <div class="panel-body" id="div2" style="width:100%;height:550px;">
         <div id="morris-chart-area" style="position: relative;margin:0;padding:0;height:100%">

        <div  style="width:98%;height:50px;position: absolute;">
        	<div style="width:80%;height:10%;">
	        	<label id="labels" style="float:left;">
	            	<input name="form-fields" type="radio"  checked value="1" class="ace" >	<span class="lbl">报警历史</span>
	            </label>
	            <label id="labels" style="float:left;">
	                <input name="form-fields" type="radio" "  value="2"class="ace" >	<span class="lbl">预警历史</span>
	            </label>
            </div><br />
            <div style="float: left;width:85%;">
	         	<label class="col-sm-3 control-label no-padding-right" for="form-field-1">污染物：</label>
				<div class="col-sm-9" style="width:20%;">
				    <div class="selQ313596790Qsel"></div>
				    <select class="chosen-select form-control" style="width:200px;" name="name" id="mySelect"data-placeholder="请选择"><option value=""></option>
				    <c:forEach items="${varList}" var="list">
				     <option value="${list.param_name_sql}">${list.param_name_cn}</option>
				    </c:forEach>
				   </select><div class="selQ313596790Qsel"></div>
				</div>
				<label id="label3" style="float:left;"onclick="time(3,1)">
	                <input name="form-field4" type="radio"  checked value="1" class="ace" ><span class="lbl">按天统计</span>
	            </label>
	            <label id="label3" style="float:left;"onclick="time(3,2)">
	                <input name="form-field4" type="radio" "  value="2"class="ace" ><span class="lbl">按月统计</span>
	            </label>
	            <label id="label3"style="float:left;"onclick="time(3,4)">
	                <input name="form-field4" type="radio" " class="ace"value="4"  ><span class="lbl">按年统计</span>
	            </label>
	             <label id="label3"style="float:left;"onclick="time(3,5)">
	                <input name="form-field4" type="radio" " class="ace"value="5"  ><span class="lbl">自定义统计</span>
	            </label>
	            <div style="width:100%;">
	            	<label class="col-sm-3 control-label no-padding-right" for="form-field-1">时间：</label>
		           	   <input type="text" value="" id="datetimepicker3" >
					 <input style="display: none;" type="text" value="" id="end_datetimepicker3" >
					 <button  id="search" style="margin-left:20px;" class="button button-glow button-border button-rounded button-primary">刷新</button >
				</div> 
            </div>
         </div>  
		    
			<table id="reportTable" >
			 <thead>
			  <tr>
			   <th data-field="id"data-valign="middle" data-align="center" data-sortable="true">序号</th>
			   <th data-field="str_time"data-valign="middle" data-align="center" data-sortable="true">时间</th>
			   <th data-field="com_name"data-valign="middle" data-align="center" data-sortable="true">监测点名称</th>
			   <th data-field="param_name_cn"data-valign="middle" data-align="center" data-sortable="true">报警类型</th>
			   <th data-field="limitHH"data-valign="middle" data-align="center" data-sortable="true">上限值</th>
			   <th data-field="limitLL"data-valign="middle" data-align="center" data-sortable="true">下限值</th>
			   <th data-field="calc_value"data-valign="middle" data-align="center" data-sortable="true">报警值</th>
	  		  </tr>
			  </thead>
			</table>
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
	<%@ include file="../index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>
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
				$("#label"+i).trigger("click"); 
	  }
  }
	 height=height+100;
 $("body").css("height",height)
	//$("#label3").trigger("click"); 
  
	 })
	 function resizeFrame(){
            var content_iframe = window.parent.document.getElementById("pages");//获取iframeID
              var content_iframes = window.parent.parent.document.getElementById("iframe_div");//获取iframeID
            content_iframe.style.height = height+"px";
         height=height+100;
            content_iframes.style.height =height+'px';
}
</script>
<script type="text/javascript">
$(function () {
	
	var a = document.getElementById("mySelect");//mySelect是select 的Id
  a.options[0].selected = true;
	
	
var R_ID=$("#R_ID").val();

	Now_warning(R_ID);
	Warning();
	Early_Warning();
	
		$("#module0").click(function(){ 
			$("#div0").slideToggle("slow" )
		})
		$("#module1").click(function(){
			$("#div1").slideToggle("slow" )
		}) 
		$("#module2").click(function(){ 
			$("#div2").slideToggle("slow" )
		})
		
	function Now_warning(){
		$.ajax({
          url:'Now_warning',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			if(data.varList!=null){
			 $.each(data.varList, function(i, dvar){
				 if(dvar.warning!=undefined){
				 $("#warning").append("<div class='warning_div'><div><span>报警指标:"+dvar.param_name_cn+"</span></br><span>当前值:"+dvar.warning.calc_value+"</span></br><span>正常范围:"+dvar.warning.limitLL+"-"+dvar.warning.limitHH+"</span></br><span>报警范围:≤"+dvar.warning.limitLL+",≥"+dvar.warning.limitHH+"</span></dvi></div>")
				 }
			 })
			  $.each(data.varList, function(i, dvar){
				 if(dvar.early_warning!=undefined){
				 $("#warning").append("<div class='early_warning_div'><div><span>预警指标:"+dvar.param_name_cn+"</span></br><span>当前值:"+dvar.early_warning.calc_value+"</span></br><span>正常范围:"+dvar.early_warning.limitL+"-"+dvar.early_warning.limitH+"</span></br><span>预警范围:≤"+dvar.early_warning.limitL+",≥"+dvar.early_warning.limitH+"</span></dvi></div>")
				 }
			 })
			}
		},
		
		})
	  
		}	
	})	
		
		//水平衡分析2个饼图
	 	 
</script>


<script type="text/javascript">
  function Warning(){
	  var R_ID=$("#R_ID").val();
	  var from=$("input[name='form-field2']:checked").val();//日月年
      var startTime1=$('#datetimepicker1').val();
	   var endTime1=$('#end_datetimepicker1').val();
	   //alert(startTime1)
      //var mySelect= $("#mySelect option:selected").val();
      Warning_count(from,startTime1,endTime1,R_ID);
  }
</script>
<script type="text/javascript">
  function Early_Warning(){
	  var R_ID=$("#R_ID").val();
	  var from=$("input[name='form-field3']:checked").val();//日月年
      var startTime2=$('#datetimepicker2').val();
	   var endTime2=$('#end_datetimepicker2').val();
	   //alert(startTime1)
      //var mySelect= $("#mySelect option:selected").val();
      Early_Warning_count(from,startTime2,endTime2,R_ID);
  }
</script>

<script type="text/javascript">

function Warning_count(from,startTime1,endTime1,R_ID){
	$("#warningdiv").show();
			var myChart = echarts.init(document.getElementById('main'));
	myChart.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
		$.ajax({
          url:'Warning_count',
		type:"post",
		async: true,
		dataType:"json",
		data:{from,startTime1,endTime1,R_ID},
		success:function(data){
			
			
			if(data.varList!=null){
				 var datalist=[];
				 var datalistname=[];
			 $.each(data.varList, function(i, dvar){
				 if(dvar.warning_count!=undefined){
					 datalistname.push(dvar.param_name_cn)
					datalist.push ({
			value:dvar.warning_count,
			name:dvar.param_name_cn,
		})
				 }
			 })
			  	option = {
		   // backgroundColor: '#2c343c',
		
		    title: {
		        text: '报警指标统计',
		        left: 170,
		        top: 0,
		        textStyle: {
		            color: '#696969'
		        }
		    },
		
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        x : 'center',
        y : 50,
        data: datalistname
    },
		
		   toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true,
                type: ['pie', 'funnel']
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
		    series : [
		        {
		            name:'报警统计',
		            type:'pie',
		             radius : '40%',
		             //roseType : 'radius',
		            center: ['40%', '80%'],
		            data:datalist,
           
		
		            
		        }
		    ]
		};
		 myChart.setOption(option);
		  myChart.hideLoading();
			}
		},
		
		})
	  
		}	
function Early_Warning_count(from,startTime2,endTime2,R_ID){
		$("#earlywarningdiv").show();
			var myChart2 = echarts.init(document.getElementById('main2')); 
	myChart2.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
		$.ajax({
          url:'Early_Warning_count',
		type:"post",
		async: true,
		dataType:"json",
		data:{from,startTime2,endTime2,R_ID},
		success:function(data){
			
				//var myChart2 = echarts.init(document.getElementById('main2')); 
			if(data.varList!=null){
			  var datalist=[];
			   var datalistname=[];
			 $.each(data.varList, function(i, dvar){
				 if(dvar.early_warning_count!=undefined){
					  datalistname.push(dvar.param_name_cn)
					datalist.push ({
			value:dvar.early_warning_count,
			name:dvar.param_name_cn,
		})
				 }
			 })
			 option2 = {
		   // backgroundColor: '#2c343c',
		
		    title: {
		        text: '预警指标统计',
		        left: 170,
		        top: 0,
		        textStyle: {
		            color: '#696969'
		        }
		    },
		
		  tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        x : 'center',
        y : 50,
        data: datalistname
    },
		
	toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true,
                type: ['pie', 'funnel']
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
		    series : [
		        {
		            name:'预警统计',
		            type:'pie',
		            radius : '40%',
		            center: ['40%', '80%'],
		             //roseType : 'radius',
		            data:datalist,
		           
		        }
		    ]
		};
			 myChart2.setOption(option2); 
			  myChart2.hideLoading();
			 
			 
			}
		},
		
		})
	  
		}

</script>
<script type="text/javascript">
$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

});
	
	var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#reportTable').bootstrapTable({
            url: 'Warning_His',         //请求后台的URL（*）
           method: 'get',                      //请求方式（*）
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100,'ALL'],        //可供选择的每页的行数（*）
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            height: 530,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            exportTypes: ['excel'],
               uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showExport: true,                     //是否显示导出
            exportDataType: "all",              //basic', 'all', 'selected'.
            columns: [{
                    field: 'id',
                    title: '序号',
                    formatter: function (value, row, index) {  
                            return index+1;  
                        }  
                }]
        });
    };
    
    //得到查询的参数var from=$('input:radio:checked').val();//日月年
		///alert(from)
	//time();
	//var R_ID=$("#R_ID").val();
	// var startTime=$('#startTime input').val();
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            from:$("input[name='form-field3']:checked").val(),
            R_ID:$("#R_ID").val(),
            strTime:$('#datetimepicker3').val(),
            end_strTime:$('#end_datetimepicker3').val(),
            warning_type:$("input[name='form-fields']:checked").val(),
            mySelect:$("#mySelect option:selected").val(),
        };
        return temp;
    };
    return oTableInit;
};


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
       
    };

    return oInit;
};

</script>

	<script type="text/javascript">
	  $("#search").on("click", function(){
  
	 $("#reportTable").bootstrapTable('refresh', {url: 'Warning_His' });
	 
	});

	</script>
	<script src="static/bootstrap/bootstrap-table/bootstrap-table-export.js"></script>
	</body>
</html>