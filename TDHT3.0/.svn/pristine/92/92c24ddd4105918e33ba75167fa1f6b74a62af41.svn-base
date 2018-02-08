<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
	<!-- 下拉框 -->
	<link rel="stylesheet" href="static/ace/css/chosen.css" />
	<!-- jsp文件头和头部 -->
	<%@ include file="../../system/index/top.jsp"%>
	<!-- 日期框 -->
	<link rel="stylesheet" href="static/ace/css/datepicker.css" />
</head>
<body class="no-skin">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
	<!-- /section:basics/sidebar -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
					
					<form action="water_type/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="WATER_TYPE_ID" id="WATER_TYPE_ID" value="${pd.WATER_TYPE_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">ID:</td>
								<td><input type="number" name="ID" id="ID" value="${pd.ID}" maxlength="32" placeholder="这里输入ID" title="ID" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">控制器类型:</td>
								<td><input type="number" name="DEVICE_TYPE" id="DEVICE_TYPE" value="${pd.DEVICE_TYPE}" maxlength="32" placeholder="这里输入控制器类型" title="控制器类型" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">表名:</td>
								<td><input type="text" name="TAB_NAME" id="TAB_NAME" value="${pd.TAB_NAME}" maxlength="32" placeholder="这里输入表名" title="表名" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">控制器类型:</td>
								<td><input type="text" name="DEVICE_NAME_CN" id="DEVICE_NAME_CN" value="${pd.DEVICE_NAME_CN}" maxlength="32" placeholder="这里输入控制器类型" title="控制器类型" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
						</table>
						</div>
						<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
					</form>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</div>
<!-- /.main-container -->


	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			if($("#ID").val()==""){
				$("#ID").tips({
					side:3,
		            msg:'请输入ID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#ID").focus();
			return false;
			}
			if($("#DEVICE_TYPE").val()==""){
				$("#DEVICE_TYPE").tips({
					side:3,
		            msg:'请输入控制器类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DEVICE_TYPE").focus();
			return false;
			}
			if($("#TAB_NAME").val()==""){
				$("#TAB_NAME").tips({
					side:3,
		            msg:'请输入表名',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TAB_NAME").focus();
			return false;
			}
			if($("#DEVICE_NAME_CN").val()==""){
				$("#DEVICE_NAME_CN").tips({
					side:3,
		            msg:'请输入控制器类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DEVICE_NAME_CN").focus();
			return false;
			}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>