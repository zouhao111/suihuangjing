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
					
					<form action="poll_type/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="POLL_TYPE_ID" id="POLL_TYPE_ID" value="${pd.POLL_TYPE_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">ID:</td>
								<td><input type="number" name="ID" id="ID" value="${pd.ID}" maxlength="32" placeholder="这里输入ID" title="ID" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">名称:</td>
								<td><input type="text" name="PARAM_NAME" id="PARAM_NAME" value="${pd.PARAM_NAME}" maxlength="255" placeholder="这里输入名称" title="名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">参数中文名称:</td>
								<td><input type="text" name="PARAM_NAME_CN" id="PARAM_NAME_CN" value="${pd.PARAM_NAME_CN}" maxlength="255" placeholder="这里输入参数中文名称" title="参数中文名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">参数 数据库对应字段:</td>
								<td><input type="text" name="PARAM_NAME_SQL" id="PARAM_NAME_SQL" value="${pd.PARAM_NAME_SQL}" maxlength="255" placeholder="这里输入参数 数据库对应字段" title="参数 数据库对应字段" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">参数类型:</td>
								<td><input type="number" name="PARAM_TYPE" id="PARAM_TYPE" value="${pd.PARAM_TYPE}" maxlength="32" placeholder="这里输入参数类型" title="参数类型" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">限值类型:</td>
								<td><input type="number" name="LIMIT_TYPE" id="LIMIT_TYPE" value="${pd.LIMIT_TYPE}" maxlength="32" placeholder="这里输入限值类型" title="限值类型" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">参数ID:</td>
								<td><input type="number" name="PARAM_NAME_NUMB" id="PARAM_NAME_NUMB" value="${pd.PARAM_NAME_NUMB}" maxlength="32" placeholder="这里输入参数ID" title="参数ID" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">污染物类型:</td>
								<td><input type="number" name="PARAM_NAME_NUMB" id="PARAM_NAME_NUMB" value="${pd.PARAM_POLL_TYPE}" maxlength="32" placeholder="这里输入污染物类型" title="污染物类型" style="width:98%;"/></td>
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
			if($("#PARAM_NAME").val()==""){
				$("#PARAM_NAME").tips({
					side:3,
		            msg:'请输入名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PARAM_NAME").focus();
			return false;
			}
			if($("#PARAM_NAME_CN").val()==""){
				$("#PARAM_NAME_CN").tips({
					side:3,
		            msg:'请输入参数中文名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PARAM_NAME_CN").focus();
			return false;
			}
			if($("#PARAM_NAME_SQL").val()==""){
				$("#PARAM_NAME_SQL").tips({
					side:3,
		            msg:'请输入参数 数据库对应字段',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PARAM_NAME_SQL").focus();
			return false;
			}
			if($("#PARAM_TYPE").val()==""){
				$("#PARAM_TYPE").tips({
					side:3,
		            msg:'请输入参数类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PARAM_TYPE").focus();
			return false;
			}
			if($("#LIMIT_TYPE").val()==""){
				$("#LIMIT_TYPE").tips({
					side:3,
		            msg:'请输入限值类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#LIMIT_TYPE").focus();
			return false;
			}
			if($("#PARAM_NAME_NUMB").val()==""){
				$("#PARAM_NAME_NUMB").tips({
					side:3,
		            msg:'请输入参数ID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PARAM_NAME_NUMB").focus();
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