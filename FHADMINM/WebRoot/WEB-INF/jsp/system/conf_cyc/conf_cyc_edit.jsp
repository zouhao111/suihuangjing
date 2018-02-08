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
	<link rel="stylesheet" href="static/ace/css/bootstrap-datetimepicker.css" />
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
					
					<form action="conf_cyc/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="ID" id="ID" value="${pd.ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<%--<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">id:</td>
								<td><input type="number" name="ID" id="ID" value="${pd.ID}" maxlength="32" placeholder="这里输入id" title="id" style="width:98%;"/></td>
							</tr>
							--%><tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">R_ID:</td>
								<td>
								 <select style="width:98%;" name="R_ID" id="R_ID"data-placeholder="请选择">
                                      <c:forEach items="${varList}" var="var" varStatus="vs">
                                      <c:if test="${pd.R_ID==var.RID}">
                                      <option  selected="selected" value="${var.RID}" >${var.RID}</option>
                                      </c:if>
                                     <c:if test="${pd.R_ID!=var.RID}">
                                      <option  value="${var.RID}">${var.RID}</option>
                                      </c:if>
                                      </c:forEach>
                                      </select>
								
								
								<%--<input type="number" name="R_ID" id="R_ID" value="${pd.R_ID}" maxlength="32" placeholder="这里输入R_ID" title="R_ID" style="width:98%;"/>
								
								--%></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">周期:</td>
								<td><input type="number" name="CYC" id="CYC" value="${pd.CYC}" maxlength="32" placeholder="这里输入周期" title="周期" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">名称:</td>
								<td><input type="text" name="CYC_NAME" id="CYC_NAME" value="${pd.CYC_NAME}" maxlength="20" placeholder="这里输入名称" title="名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">时间:</td>
								<td><input class="span10 date-picker" name="STR_TIME" id="STR_TIME" value="${pd.STR_TIME}" type="text" data-date-format="yyyy-mm-dd HH:II" readonly="readonly" placeholder="时间" title="时间" style="width:98%;"/></td>
							</tr>
							<%--<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">sy时间:</td>
								<td><input type="number" name="SY_TIME" id="SY_TIME" value="${pd.SY_TIME}" maxlength="32" placeholder="这里输入sy时间" title="sy时间" style="width:98%;"/></td>
							</tr>
							--%><tr>
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
	<script src="static/ace/js/date-time/bootstrap-datetimepicker1.js"></script>
	<script src="static/ace/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
		
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			/*if($("#ID").val()==""){
				$("#ID").tips({
					side:3,
		            msg:'请输入id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#ID").focus();
			return false;
			}*/
			if($("#R_ID").val()==""){
				$("#R_ID").tips({
					side:3,
		            msg:'请输入R_ID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#R_ID").focus();
			return false;
			}
			if($("#CYC").val()==""){
				$("#CYC").tips({
					side:3,
		            msg:'请输入周期',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CYC").focus();
			return false;
			}
			if($("#CYC_NAME").val()==""){
				$("#CYC_NAME").tips({
					side:3,
		            msg:'请输入名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CYC_NAME").focus();
			return false;
			}
			if($("#STR_TIME").val()==""){
				$("#STR_TIME").tips({
					side:3,
		            msg:'请输入时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#STR_TIME").focus();
			return false;
			}
			if($("#SY_TIME").val()==""){
				$("#SY_TIME").tips({
					side:3,
		            msg:'请输入sy时间',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#SY_TIME").focus();
			return false;
			}
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datetimepicker({format:"yyyy-mm-dd hh:ii",language:"zh-CN",todayHighlight:true,todayBtn:true});
			//$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>