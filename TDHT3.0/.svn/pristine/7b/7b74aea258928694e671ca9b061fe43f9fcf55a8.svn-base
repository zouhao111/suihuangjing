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
					
					<form action="com_poll/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="COM_POLL_ID" id="COM_POLL_ID" value="${pd.COM_POLL_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<!--<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">备注1:</td>
								<td><input type="number" name="WATER_TYPE_ID" id="WATER_TYPE_ID" value="${pd.WATER_TYPE_ID}" maxlength="32" placeholder="这里输入备注1" title="备注1" style="width:98%;"/></td>
							</tr>
							--><tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">RID</td>
								<td><input type="text" name="RID" id="RID" value="${pd.RID}" maxlength="225" placeholder="这里输入RID" title="备注2" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">污染物ID:</td>
								<td><input type="number" name="TYPE_ID" id="TYPE_ID" value="${pd.TYPE_ID}" maxlength="32" placeholder="这里输入备注3" title="备注3" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">污染物名字:</td>
								<td><input type="text" name="TYPE_NAME" id="TYPE_NAME" value="${pd.TYPE_NAME}" maxlength="255" placeholder="这里输入备注4" title="备注4" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">污染物类型:</td>
								<td><input type="number" name="TYPE_NUM" id="TYPE_NUM" value="${pd.TYPE_NUM}" maxlength="32" placeholder="这里输入备注5" title="备注5" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">污染物小数点:</td>
								<td><input type="number" name="POLL_POINT" id="POLL_POINT" value="${pd.POLL_POINT}" maxlength="32" placeholder="这里输入备注6" title="备注6" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">最小报警:</td>
								<td><input type="number" name="MIN_WAR" id="MIN_WAR" value="${pd.MIN_WAR}" maxlength="32" placeholder="这里输入备注7" title="备注7" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">最大报警:</td>
								<td><input type="number" name="MAX_WAR" id="MAX_WAR" value="${pd.MAX_WAR}" maxlength="32" placeholder="这里输入备注8" title="备注8" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">最小预警:</td>
								<td><input type="number" name="MIN_EARLY" id="MIN_EARLY" value="${pd.MIN_EARLY}" maxlength="32" placeholder="这里输入备注9" title="备注9" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">最大预警:</td>
								<td><input type="number" name="MAX_EARLY" id="MAX_EARLY" value="${pd.MAX_EARLY}" maxlength="32" placeholder="这里输入备注10" title="备注10" style="width:98%;"/></td>
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
			if($("#WATER_TYPE_ID").val()==""){
				$("#WATER_TYPE_ID").tips({
					side:3,
		            msg:'请输入备注1',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#WATER_TYPE_ID").focus();
			return false;
			}
			if($("#RID").val()==""){
				$("#RID").tips({
					side:3,
		            msg:'请输入备注2',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#RID").focus();
			return false;
			}
			if($("#TYPE_ID").val()==""){
				$("#TYPE_ID").tips({
					side:3,
		            msg:'请输入备注3',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TYPE_ID").focus();
			return false;
			}
			if($("#TYPE_NAME").val()==""){
				$("#TYPE_NAME").tips({
					side:3,
		            msg:'请输入备注4',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TYPE_NAME").focus();
			return false;
			}
			if($("#TYPE_NUM").val()==""){
				$("#TYPE_NUM").tips({
					side:3,
		            msg:'请输入备注5',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#TYPE_NUM").focus();
			return false;
			}
			if($("#POLL_POINT").val()==""){
				$("#POLL_POINT").tips({
					side:3,
		            msg:'请输入备注6',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#POLL_POINT").focus();
			return false;
			}
			if($("#MIN_WAR").val()==""){
				$("#MIN_WAR").tips({
					side:3,
		            msg:'请输入备注7',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MIN_WAR").focus();
			return false;
			}
			if($("#MAX_WAR").val()==""){
				$("#MAX_WAR").tips({
					side:3,
		            msg:'请输入备注8',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MAX_WAR").focus();
			return false;
			}
			if($("#MIN_EARLY").val()==""){
				$("#MIN_EARLY").tips({
					side:3,
		            msg:'请输入备注9',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MIN_EARLY").focus();
			return false;
			}
			if($("#MAX_EARLY").val()==""){
				$("#MAX_EARLY").tips({
					side:3,
		            msg:'请输入备注10',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MAX_EARLY").focus();
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