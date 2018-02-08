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
<head>
<base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="../index/top.jsp"%>
	<script src="static/js/jquery.js"></script>
	<link rel="stylesheet" href="static/bootstrap/bootstrap-table/bootstrap-table.css" />	
	<script src="static/bootstrap/bootstrap-table/bootstrap-table2.js"></script>
	<script src="static/bootstrap/bootstrap-table2/colResizable-1.6.js"></script>

	<!-- 日期框 -->
 	<script type="text/javascript" src="static/bootstrap/bootstrap-datetime/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="static/bootstrap/bootstrap-datetime/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="static/bootstrap/bootstrap-datetime/bootstrap-time.js"></script>
	<link rel="stylesheet" href="static/bootstrap/bootstrap-datetime/bootstrap-datetimepicker.css" />

	<script src="static/bootstrap/extends/tableExport/jquery.base64.js"></script>
	<script src="static/bootstrap/js/tableExport.js"></script>
	<script src="static/js/echarts.min.js"></script>
	<script src="static/js/myjs/center.js"></script>
	<link href="static/buttons/buttons.css" rel="stylesheet" type="text/css"/>
<script src="static/js/jquery.cookie.js"></script>
</head>
<style type="text/css">
.module{
 font-size:16px;
 color:#3B9DDB;
 font-weight: 900;
  cursor: pointer;
}
</style>
<body style="background-color:#fff;"onload="resizeFrame()">
<a id="menuUrl" href="${menuUrl}"></a>
<input  id="R_ID" type="hidden"  value="${R_ID}"/>
<input  id="list" type="hidden"  value="${list}"/>

<c:if  test="${list0.hasMenu == true}" >
<div class="col-lg-12" style="top:5px;">
       <div class="panel panel-primary" style="border-top-width: 0px;">
         <div class="panel-heading" id="module0">
           <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list0.MENU_NAME}</h3>
         </div>
         <div class="panel-body" id="div0" style="height:550px;width:100%;">
         <div id="morris-chart-area" style="position: relative;margin:0;padding:0;height:100%">


		 <div class="font-css timeser" style="position:absolute;margin-top:15px;">
	        <div id="option" style="float: left;margin-top: 5px;">
	        	<label style="float:left;">
	                <input name="form-field" type="radio" onclick="time(1,1)" checked value="1"class="ace" id="form-field-radio1">	<span class="lbl">按天统计</span>
	            </label>
	            <label style="float:left;">
	                <input name="form-field" type="radio" onclick="time(1,2)" checked value="2"class="ace" id="form-field-radio1">	<span class="lbl">按月统计</span>
	            </label>
	            <label style="float:left;">
	                <input name="form-field" type="radio" onclick="time(1,4)" class="ace"value="4"  id="form-field-radio1">	<span class="lbl">按年统计</span>
	            </label>
	            <label style="float:left;"onclick="time(1,5)">
                	<input name="form-field" type="radio" " class="ace"value="5"  >	<span class="lbl">自定义统计</span>
            	</label>
	        </div>
	    
	    	<div id="startTime"style="float: left;margin-left: 10px;">
	  			时间: <input name="datetimepicker" type="text" id="datetimepicker1" >   <input style="display: none;" type="text" id="end_datetimepicker1" >
	   		</div>
	   		<button id="statictable" style="margin-left: 20px;" class="button button-glow button-border button-rounded button-primary" >刷新</button>
		 </div>
		 
		 <table id="reportTable" >
			 <thead>
			  <tr>
			   <th data-field="id"data-valign="middle" data-align="center" data-sortable="true">序号</th>
			   <th data-field="str_time"data-valign="middle" data-align="center" data-sortable="true">操作时间</th>
			   <th data-field="r_name_cn"data-valign="middle" data-align="center" data-sortable="true">监测单元</th>
			   <th data-field="device_id"data-valign="middle" data-align="center" data-sortable="true">控制器编号</th>
			   <th data-field="device_name_cn"data-valign="middle" data-align="center" data-sortable="true">描述</th>
			   <th data-field="device_state"data-valign="middle" data-align="center" data-sortable="true">控制器状态</th>
			  </tr>
			  </thead>
		</table>
		
	</div>	
	</div>
    </div>
  </div>
</c:if>

<c:if  test="${list1.hasMenu == true}" >
	<div class="col-lg-12" >
       <div class="panel panel-primary" style="border-top-width: 0px;">
         <div class="panel-heading" id="module1">
           <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list1.MENU_NAME}</h3>
         </div>
         <div class="panel-body" id="div1" style="height:550px;width:100%;">
         <div id="morris-chart-area" style="position: relative;margin:0;padding:0;height:100%">
	
			<div class="font-css timeser" style="position:absolute;margin-top:15px;">
		        <div id="option" style="float: left;margin-top: 5px;">
		        	<label style="float:left;">
		                <input name="form-field2" type="radio" onclick="time(2,1)" checked value="1"class="ace" id="form-field-radio4">	<span class="lbl">按天统计</span>
		            </label>
		            <label style="float:left;">
		                <input name="form-field2" type="radio" onclick="time(2,2)" checked value="2"class="ace" id="form-field-radio5">	<span class="lbl">按月统计</span>
		            </label>
		            <label style="float:left;">
		                <input name="form-field2" type="radio" onclick="time(2,4)" class="ace"value="4"  id="form-field-radio6">	<span class="lbl">按年统计</span>
		            </label>
		            <label style="float:left;"onclick="time(2,5)">
	                	<input name="form-field2" type="radio" " class="ace"value="5"  >	<span class="lbl">自定义统计</span>
	            	</label>
		        </div>
		    
		    	<div id="startTime"style="float: left;margin-left: 10px;">
		  			时间: <input name="datetimepicker" type="text" id="datetimepicker2" >   <input style="display: none;" type="text" id="end_datetimepicker2" >
		   		</div>
		   		<button id="controltable" style="margin-left: 20px;" class="button button-glow button-border button-rounded button-primary" >刷新</button>
			 </div>
	
		<table id="reportTable2" >
			 <thead>
			  <tr>
			   <th data-field="id"data-valign="middle" data-align="center" data-sortable="true">序号</th>
			   <th data-field="str_time"data-valign="middle" data-align="center" data-sortable="true">操作时间</th>
			   <th data-field="user_name"data-valign="middle" data-align="center" data-sortable="true">用户名</th>
			   <th data-field="user_ip"data-valign="middle" data-align="center" data-sortable="true">IP</th>
			   <th data-field="r_name_cn"data-valign="middle" data-align="center" data-sortable="true">监测单元</th>
			   <th data-field="content"data-valign="middle" data-align="center" data-sortable="true">描述</th>
			  </tr>
			  </thead>
		</table>
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
         <div class="panel-body" id="div2" style="height:550px;width:100%;">
         <div id="morris-chart-area" style="position: relative;margin:0;padding:0;height:100%">
	
	
		<div class="font-css timeser" style="position:absolute;margin-top:15px;">
		        <div id="option" style="float: left;margin-top: 5px;">
		        	<label style="float:left;">
		                <input name="form-field3" type="radio" onclick="time(3,1)" checked value="1"class="ace" id="form-field-radio7">	<span class="lbl">按天统计</span>
		            </label>
		            <label style="float:left;">
		                <input name="form-field3" type="radio" onclick="time(3,2)" checked value="2"class="ace" id="form-field-radio8">	<span class="lbl">按月统计</span>
		            </label>
		            <label style="float:left;">
		                <input name="form-field3" type="radio" onclick="time(3,4)" class="ace"value="4"  id="form-field-radio9">	<span class="lbl">按年统计</span>
		            </label>
		            <label style="float:left;"onclick="time(3,5)">
	                	<input name="form-field3" type="radio" " class="ace"value="5"  >	<span class="lbl">自定义统计</span>
	            	</label>
		        </div>
		    
		    	<div id="startTime"style="float: left;margin-left: 10px;">
		  			时间: <input name="datetimepicker" type="text" id="datetimepicker3" >   <input style="display: none;" type="text" id="end_datetimepicker3" >
		   		</div>
		   		<button id="maintaintable" style="margin-left: 20px;" class="button button-glow button-border button-rounded button-primary" >刷新</button>
			 </div>
		<table id="reportTable3" >
			 <thead>
			  <tr>
			   <th data-field="id" data-valign="middle" data-align="center" data-sortable="true">序号</th>
			   <th data-field="str_time"data-valign="middle" data-align="center" data-sortable="true">操作时间</th>
			   <th data-field="user_name"data-valign="middle" data-align="center" data-sortable="true">用户名</th>
			   <th data-field="user_ip"data-valign="middle" data-align="center" data-sortable="true">IP</th>
			   <th data-field="r_name_cn"data-valign="middle" data-align="center" data-sortable="true">监测单元</th>
			   <th data-field="content"data-valign="middle" data-align="center" data-sortable="true">描述</th>
			  </tr>
			  </thead>
		</table>
	</div>	
	</div>
    </div>
  </div>
</c:if>
</body>
<script type="text/javascript">
		$("#module0").click(function(){ 
			$("#div0").slideToggle("slow" )
		})
		$("#module1").click(function(){
			$("#div1").slideToggle("slow" )
		}) 
		$("#module2").click(function(){ 
			$("#div2").slideToggle("slow" )
		})
		
  
		$("#statictable").on("click", function(){
		 	$("#reportTable").bootstrapTable('refresh', {url: 'listState' });
		});
		$("#controltable").on("click", function(){
		 	$("#reportTable2").bootstrapTable('refresh', {url: 'listControl' });
		});
		$("#maintaintable").on("click", function(){
		 	$("#reportTable3").bootstrapTable('refresh', {url: 'listMaintain' });
		});
		
</script>
<script type="text/javascript">
  var height=0;
	$(function () {
		var menuUrl=$("#menuUrl").attr("href")
		$.cookie('menuUrl_s', menuUrl, { expires: 1, path: '/TDHT3.0' });
		
		
		 var lists=[];
     lists.push(${list0.hasMenu});
       lists.push(${list1.hasMenu});
        lists.push(${list2.hasMenu});
	for(i=0;i<lists.length;i++){
	  if(lists[i]){
		$("#div"+i).show();
		heights=$("#div"+i).parent().parent('.col-lg-12').height(); 
		if(heights!=null){
			height=height+heights;
		}
		//break;
	  }
  }
  height=height;
 $("body").css("height",height)
 
		
		
		
		
	//设备日志表格
	    //1.初始化Table
	    var oTable = new TableInit();
	    oTable.Init();
	
	    //2.初始化Button的点击事件
	    var oButtonInit = new ButtonInit();
	    oButtonInit.Init();
	
	});
	function resizeFrame(){
		
              var content_iframes = window.parent.parent.document.getElementById("iframe_div");//获取iframeID
         height=height+150;
              console.log(height)
            content_iframes.style.height =height+'px';
}
	var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
     oTableInit.Init = function () {
        $('#reportTable').bootstrapTable({
            url: 'listState',         //请求后台的URL（*）
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
            pageList: [10, 25, 50, 100,"ALL"],        //可供选择的每页的行数（*）
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            height: 530,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            exportTypes: ['excel'],
               uniqueId: "id",                  //每一行的唯一标识，一般为主键列
            showExport: true,                   //是否显示导出
            exportDataType: "all",              //basic', 'all', 'selected'.
            columns: [{
                    field: 'id',
                    title: '序号',
                    formatter: function (value, row, index) {  
                            return index+1;  
                        }  
                }],
            formatNoMatches: function(){
                	return '无符合条件的记录';
                }
        });
    };
		
   oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            R_ID:$("#R_ID").val(),
            strTime:$('#datetimepicker1').val(),
            strTime2:$('#end_datetimepicker1').val(),
            from:$('input:radio:checked').val(),
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
	$(function () {
	//操作日志表格
	    //1.初始化Table
	    var oTable2 = new TableInit2();
	    oTable2.Init();
	
	    //2.初始化Button的点击事件
	    var oButtonInit2 = new ButtonInit();
	    oButtonInit2.Init();
	
	});
	var TableInit2 = function () {
    var oTableInit2 = new Object();
    //初始化Table
     oTableInit2.Init = function () {
        $('#reportTable2').bootstrapTable({
            url: 'listControl',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit2.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100,"ALL"],        //可供选择的每页的行数（*）
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            height: 530,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            exportTypes: ['excel'],
               uniqueId: "id",                  //每一行的唯一标识，一般为主键列
            showExport: true,                   //是否显示导出
            exportDataType: "all",              //basic', 'all', 'selected'.
            columns: [{
                    field: 'id',
                    title: '序号',
                    formatter: function (value, row, index) {  
                            return index+1;  
                        }  
                }],
            formatNoMatches: function(){
                	return '无符合条件的记录';
                }
        });
    };
		
    oTableInit2.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            R_ID:$("#R_ID").val(),
            strTime:$('#datetimepicker2').val(),
            strTime2:$('#end_datetimepicker2').val(),
            from:$('input:radio:checked').val(),
        };
        return temp;
    }; 
    return oTableInit2;
};

var ButtonInit2 = function () {
    var oInit2 = new Object();
    var postdata2 = {};
    
    oInit2.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit2;
};
</script>

<script type="text/javascript">
	$(function () {
	//设备日志表格
	    //1.初始化Table
	    var oTable3 = new TableInit3();
	    oTable3.Init();
	
	    //2.初始化Button的点击事件
	    var oButtonInit3 = new ButtonInit();
	    oButtonInit3.Init();
	
	});
	var TableInit3 = function () {
    var oTableInit3 = new Object();
    //初始化Table
     oTableInit3.Init = function () {
        $('#reportTable3').bootstrapTable({
            url: 'listMaintain',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit3.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100,"ALL"],        //可供选择的每页的行数（*）
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            height: 530,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            exportTypes: ['excel'],
               uniqueId: "id",                  //每一行的唯一标识，一般为主键列
            showExport: true,                   //是否显示导出
            exportDataType: "all",              //basic', 'all', 'selected'.
            columns: [{
                    field: 'id',
                    title: '序号',
                    formatter: function (value, row, index) {  
                            return index+1;  
                        }  
                }],
            formatNoMatches: function(){
                	return '无符合条件的记录';
                }
        });
    };
		
    oTableInit3.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            R_ID:$("#R_ID").val(),
            strTime:$('#datetimepicker3').val(),
            strTime2:$('#end_datetimepicker3').val(),
            from:$('input:radio:checked').val(),
        };
        return temp;
    }; 
    return oTableInit3;
};

var ButtonInit3 = function () {
    var oInit3 = new Object();
    var postdata3 = {};
    
    oInit3.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit3;
};
</script>



</html>