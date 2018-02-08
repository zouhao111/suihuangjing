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
<script src="static/js/jquery.cookie.js"></script>
	<script src="static/bootstrap/extends/tableExport/jquery.base64.js"></script>
	<script src="static/bootstrap/js/tableExport.js"></script>
	<script src="static/js/echarts1.min.js"></script>
	<script src="static/js/myjs/center.js"></script>
	<link href="static/buttons/buttons.css" rel="stylesheet" type="text/css"/>
</head>
<style type="text/css">
.module{
 font-size:16px;
 color:#3B9DDB;
 font-weight: 900;
  cursor: pointer;
}
</style>
<body style="background-color:#fff;">
<a id="menuUrl" href="${menuUrl}"></a>
<input  id="R_ID" type="hidden"  value="${R_ID}"/>
<input  id="list" type="hidden"  value="${list}"/>

<c:if  test="${list0.hasMenu == true}" >
		<div class="col-lg-12">
            <div class="panel panel-primary">
              <div class="panel-heading" id="module0">
                <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> ${list0.MENU_NAME}</h3>
              </div>
              <div class="panel-body" id="div0">
              	<div id="morris-chart-area" style="position: relative;">
              
			          <div style="position:absolute;margin-top:15px;">
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
				   		<button id="logintable" style="margin-left: 20px;" class="button button-glow button-border button-rounded button-primary" >刷新</button>
					 </div>
					 
					 <table id="reportTable" >
						 <thead>
						  <tr>
						   <th data-field="id"data-valign="middle" data-align="center" data-sortable="true">序号</th>
						   <th data-field="CZTIME"data-valign="middle" data-align="center" data-sortable="true">登录时间</th>
						   <th data-field="USERNAME"data-valign="middle" data-align="center" data-sortable="true">用户名</th>
						   <th data-field="USERIP"data-valign="middle" data-align="center" data-sortable="true">IP</th>
						  </tr>
						  </thead>
					</table>
					
                </div>
              </div>
            </div>
          </div>
		<!-- </div> -->
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
		
  
		$("#logintable").on("click", function(){
		 	$("#reportTable").bootstrapTable('refresh', {url: 'listlogin' });
		});
		
		
</script>
<script type="text/javascript">
	$(function () {
		var menuUrl=$("#menuUrl").attr("href")
		$.cookie('menuUrl_s', menuUrl, { expires: 1, path: '/TDHT3.0' });
	//设备日志表格
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
            url: 'listlogin',         //请求后台的URL（*）
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


</html>