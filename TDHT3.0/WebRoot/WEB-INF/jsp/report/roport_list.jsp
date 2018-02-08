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
width:75%;
}
</style>

<base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="../system/index/top.jsp"%>

</head>
<body style="background-color:#fff;"onload="resizeFrame()">
<a id="menuUrl" href="${menuUrl}"></a>
<input  id="R_ID" type="hidden"  value="${R_ID}"/>
<input  id="list" type="hidden"  value="${list}"/>
<c:if test="${list0.hasMenu}">
	<div class="col-lg-12" style="top:10px;">
        <div class="panel panel-primary">
          <div class="panel-heading" id="module0">
            <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list0.MENU_NAME}</h3>
          </div>
          <div class="panel-body" id="div0" style="height: 530px;display: none;">
          <div id="morris-chart-area" style="position: relative;margin:0;padding:0;height: 100%">

		    <div class="font-css timeser" style="position:relative;width: 70%;">
		        <div id="option0" style="float: left;margin-top: 5px;width:30%;">
		            <label id="label0" style="float:left;"onclick="time(0,2)">
		                <input name="form-field" type="radio" " checked value="2"class="ace" >	<span class="lbl">按月统计</span>
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
		    	<button  id="search" style="margin-left: 20px;" class="button button-glow button-border button-rounded button-primary">刷新</button >
			</div>
			<div id="reportTableDiv" class="span10" style="position: relative; top:-50px;">
				<table id="reportTable" >
				 <thead>
				  <tr>
				   <th data-field="id"data-valign="middle" data-align="center" data-sortable="true">序号</th>
				   <th data-field="str_time"data-valign="middle" data-align="center" data-sortable="true">时间</th>
				  <c:forEach items="${varList}" var="list">
				   <th data-field="${list.param_name_sql}" data-valign="middle" data-align="center" data-sortable="true">${list.param_name_cn}</th>
				  </c:forEach>
				  </tr>
				  </thead>
				</table>
			</div>
	 </div>	
	</div>
    </div>
  </div>
 </c:if>

<c:if test="${list1.hasMenu}">
	<div class="col-lg-12" >
            <div class="panel panel-primary" style="border-top-width: 0px;">
              <div class="panel-heading" id="module1">
                <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list1.MENU_NAME}</h3>
              </div>
              <div class="panel-body" id="div1" style="height: 480px;display: none;">
              <div id="morris-chart-area" style="position: relative;margin:0;padding:0;height: 100%">
  
	  		<div style="position: absolute;margin-top:0px;margin-left: 40px;width:90%;">
		        <div id="option1" style="float: left;margin-top: 5px;width:40%;">
		        	<label class="col-sm-3 control-label no-padding-right" for="form-field-1">污染物：</label>
					<%--<div class="col-sm-9" style="width:30%;">
					    <div class="selQ313596790Qsel"></div>
					    <select class="chosen-select form-control" name="name" id="mySelect"data-placeholder="请选择"><option value=""></option>
					    <c:forEach items="${varList}" var="list">
					     <option value="${list.param_name_sql}">${list.param_name_cn}</option>
					    </c:forEach>
					   </select><div class="selQ313596790Qsel"></div>
					</div>
					--%><label id="label1"style="float:left;"onclick="time(1,2)">
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
					  时间: <input type="text" value="" id="datetimepicker1" >
					  <input style="display: none;" type="text" value="" id="end_datetimepicker1" >
			     </div>
		    	<button  id="search1" onclick="poll_line()"style="margin-left: 20px;" class="button button-glow button-border button-rounded button-primary">刷新</button >
			</div>
		  <!-- <div id="poll_line" style="clear:both ;width:98%; margin:0;padding:0;display: none;height:70px;"> -->
		        <div id="main" style="height:400px;top:60px;width:85%;float: left;padding-left: 80px;"></div>
		 <!--  </div> -->
	 </div>	
	</div>
    </div>
  </div>
 </c:if>
<c:if test="${list2.hasMenu}">
	<div class="col-lg-12" >
       <div class="panel panel-primary" style="border-top-width: 0px;">
         <div class="panel-heading" id="module2">
           <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list2.MENU_NAME}</h3>
         </div>
         <div class="panel-body" id="div2" style="height:460px;display: none;">
         <div id="morris-chart-area" style="position: relative;margin:0;padding:0;height: 100%;">
  
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
	    		<button  id="search2" onclick="poll_line_sum()"style="margin-left: 20px;" class="button button-glow button-border button-rounded button-primary">刷新</button >
	   	</div>

		<div id="poll_sum" style="clear:both ;width:110%; margin:0;padding:0;display: none;height:70px;">
		  <div id="main2" style="height:400px;top:40px;width:60%;float: left;"></div>
		   <div id="main3" style="height:300px;top:40px;width:30%;float: left;"></div>
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
	//$(window.parent.$("#menuUrl2").attr("href",menuUrl))
	$.cookie('menuUrl_ss', menuUrl, { expires: 1, path: '/TDHT3.0' });
	//window.parent.docuent.getElementById("menuUrl2").value=menuUrl;
	
	   var lists=[];
     lists.push(${list0.hasMenu});
       lists.push(${list1.hasMenu});
       lists.push(${list2.hasMenu});
       
	for(i=lists.length-1;i>=0;i--){
		//console.log(i)
	  if(lists[i]){
		$("#div"+i).show();
		
				$("#label"+i).trigger("click"); 
				heights=$("#div"+i).parent().parent('.col-lg-12').height(); 
		if(heights!=null){
			height=height+heights;
		}
					//	arr[0].click();
	  }
  }
	height=height+100;
	//console.log(height)
 $("body").css("height",height)
	 })
	 function resizeFrame(){
            var content_iframe = window.parent.document.getElementById("pages");//获取iframeID
              var content_iframes = window.parent.parent.document.getElementById("iframe_div");//获取iframeID
            var div_height = $("body").css("height");//使iframe高度等于子网页高度
            content_iframe.style.height = height+"px";
             height=height+50;
            content_iframes.style.height = height+"px";
}
</script>
<script type="text/javascript">
  function poll_line(){
	//  $("#poll_line").show();
	  var R_ID=$("#R_ID").val();
	   var from=$("input[name='form-field2']:checked").val();//日月年
  var startTime1=$('#datetimepicker1').val();
   var endTime1=$('#end_datetimepicker1').val();
  // var mySelect= $("#mySelect option:selected").val();
   Line_report_poll(from,startTime1,endTime1,R_ID);
	  
  }

</script>
<script type="text/javascript">
  function poll_line_sum(){
	//  $("#poll_sum").show();
	  var R_ID=$("#R_ID").val();
	   var from=$("input[name='form-field3']:checked").val();//日月年
  var startTime2=$('#datetimepicker2').val();
	   var endTime2=$('#end_datetimepicker2').val();
   line_poll_sum(from,startTime2,endTime2,R_ID);
	  
  }

</script>
<script type="text/javascript">
$(function () {
	//var a = document.getElementById("mySelect");//mySelect是select 的Id
  //a.options[1].selected = true;
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
  

 		
			
		poll_line_sum();
	poll_line();
	
	
})

</script>
<script type="text/javascript">

	
	
	function Line_report_poll(from,startTime1,endTime1,R_ID){
		var myChart = echarts.init(document.getElementById('main')); 
		myChart.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
		  $.ajax({
          url:'Line_report_poll',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID,from,startTime1,endTime1},
		success:function(data){
			//console.log(data)
			var strTimes=data.strTimes;
			var varList=data.poll_day;
			var poll_type=data.poll_type;
			//console.log(poll_type)
			
			var series=[];
    for(var i = 0;i<varList.length;i++){
        series.push({
             name:varList[i].param_name_cn,
            type:'line',
            data:varList[i].dataList,
        });
    }
			
			option = {
    title: {
        text: '水质曲线图',
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
    	/*[
        {
            name:'最大值',
            type:'line',
            data:max_polls,
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    
                ]
            }
        },
        {
            name:'最小值',
            type:'line',
            data:min_polls,
            
            markLine: {
                data: [
                   
                    [{
                        symbol: 'none',
                        x: '90%',
                        yAxis: 'max'
                    }, {
                        symbol: 'circle',
                        label: {
                            normal: {
                                position: 'start',
                                formatter: '最大值'
                            }
                        },
                        type: 'max',
                        name: '最高点'
                    }]
                ]
            }
        }
    ]*/

			
		 myChart.setOption(option, true);
           window.onresize = myChart.resize;
             for(var a = 1;a<poll_type.length;a++){
				option.legend.selected[poll_type[a]] = false;
                  
			}
           
                myChart.setOption(option);
                myChart.hideLoading();
	}
		})
	}
</script>
<script type="text/javascript">

	
	
	function line_poll_sum(from,startTime2,endTime2,R_ID){
		$("#poll_sum").show();
		var myChart2 = echarts.init(document.getElementById('main2')); 
		myChart2.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
	var myChart3 = echarts.init(document.getElementById('main3')); 
        myChart3.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
		  $.ajax({
          url:'line_poll_sum',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID,from,startTime2,endTime2},
		success:function(data){
			
			//console.log(data)
			var strTimes=data.strTimes;
			var varList=data.varList
			var poll_type=data.poll_type
			
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
        text: '污染物计算图',
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
            magicType: {type: ['bar']},
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
                
              
                
             var datas=[];   
           for(var i = 0;i<varList.length;i++){
        datas.push({
             value:varList[i].sumPoll, name:varList[i].param_name_cn
        });
    }
              
           option3 = {
    title : {
        text: '污染物比例',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        
        data: poll_type
    },
    series : [
        {
            name: '污染物比例',
            type: 'pie',
            radius : '55%',
            center: ['60%', '70%'],
            data:datas,
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
             myChart3.setOption(option3, true);
           window.onresize = myChart3.resize;
                myChart3.setOption(option3);
                 myChart2.hideLoading();
                 myChart3.hideLoading();
               
                
	}
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
            url: 'List_report_poll',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
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
            exportDataType: 'all',              //basic', 'all', 'selected'.
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
            from:$('input:radio:checked').val(),
            R_ID:$("#R_ID").val(),
            strTime:$('#datetimepicker0').val(),
            end_strTime:$('#end_datetimepicker0').val(),
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
  
	 $("#reportTable").bootstrapTable('refresh', {url: 'List_report_poll' });
	 
	});

	</script>
<script src="static/bootstrap/bootstrap-table/bootstrap-table-export.js"></script>
</body>
</html>