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
					
					<form action="com_control/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="COM_CONTROL_ID" id="COM_CONTROL_ID" value="${pd.COM_CONTROL_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">id:</td>
								<td><input type="number" name="ID" id="ID" value="${pd.ID}" maxlength="32" placeholder="这里输入id" title="id" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">R_ID:</td>
								<td><input type="number" name="R_ID" id="R_ID" value="${pd.R_ID}" maxlength="32" placeholder="这里输入rid" title="rid" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">参数名称:</td>
								<td>
								<input type="text" name="PARAM_NAME" id="PARAM_NAME" value="${pd.PARAM_NAME}" maxlength="255" placeholder="这里输入参数名称" title="参数名称" style="width:98%;"/>
								
								<%--<select style="width:98%;"onchange="func()" name="PARAM_NAMES" id="PARAM_NAMES"data-placeholder="请选择">
                                      <c:forEach items="${controlList}" var="var" varStatus="vs">
                                      <c:if test="${pd.PARAM_NAME==var.PARAM_NAME}">
                                      <option  selected="selected" value="${var.ACTION_ORDER}">${var.PARAM_NAME}</option>
                                      </c:if>
                                     <c:if test="${pd.PARAM_NAME!=var.PARAM_NAME}">
                                      <option  value="${var.ACTION_ORDER}">${var.PARAM_NAME}</option>
                                       
                                      </c:if>
                                      </c:forEach>
                                      </select>
								
								--%><%--<input type="text" name="PARAM_NAME" id="PARAM_NAME" value="${pd.PARAM_NAME}" maxlength="255" placeholder="这里输入参数名称" title="参数名称" style="width:98%;"/>
								
								--%></td>
							
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">动作描述:</td>
								<td>
								<input type="hidden" name="C_PARAM_NAME" id="C_PARAM_NAME" value="${pd.C_PARAM_NAME}" maxlength="255" placeholder="这里输入参数名称" title="参数名称" style="width:98%;"/>
								
								<select style="width:98%;" onchange="func()"name="PARAM_NAMES" id="PARAM_NAMES"data-placeholder="请选择">
                                      <c:forEach items="${controlList}" var="var" varStatus="vs">
                                      <c:if test="${pd.C_PARAM_NAME==var.PARAM_NAME}">
                                      <option  selected="selected" value="${var.ACTION_ORDER}">${var.PARAM_NAME}</option>
                                      </c:if>
                                     <c:if test="${pd.C_PARAM_NAME!=var.PARAM_NAME}">
                                      <option  value="${var.ACTION_ORDER}">${var.PARAM_NAME}</option>
                                      </c:if>
                                      </c:forEach>
                                      </select>
								
								<%--<input type="text" name="CONTROL_ACTION_STR" id="CONTROL_ACTION_STR" value="${pd.CONTROL_ACTION_STR}" maxlength="255" placeholder="这里输入动作描述" title="动作描述" style="width:98%;"/>
								
								--%></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">写值:</td>
								<td><input type="number" name="CONTROL_VALUE" id="CONTROL_VALUE" value="${pd.CONTROL_VALUE}" maxlength="32" placeholder="这里输入写值" title="写值" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">是否按位:</td>
								<td><input type="text" name="C_IS_BIT" id="C_IS_BIT" value="${pd.C_IS_BIT}" maxlength="255" placeholder="0否  1是" title="0否  1是" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">位数:</td>
								<td><input type="text" name="C_BIT_NUM" id="C_BIT_NUM" value="${pd.C_BIT_NUM}" maxlength="255" placeholder="位数" title="位数" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">状态:</td>
								<td><input type="text" name="ACTION_ORDER" id="ACTION_ORDER" value="${pd.ACTION_ORDER}" maxlength="255" placeholder="这里输入状态" title="状态" style="width:98%;"/></td>
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
		$(function() {
			func()
		})
	function func(){
			
 //获取被选中的option标签
 var vs = $('#PARAM_NAMES option:selected').val();
var vr = $('#PARAM_NAMES option:selected').text();
 
 $("#ACTION_ORDER").val(vs)
  $("#C_PARAM_NAME").val(vr)
}
	
	</script>
		<script type="text/javascript">
		$(top.hangge());
		//保存
		function save(){
			if($("#ID").val()==""){
				$("#ID").tips({
					side:3,
		            msg:'请输入id',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#ID").focus();
			return false;
			}
			if($("#R_ID").val()==""){
				$("#R_ID").tips({
					side:3,
		            msg:'请输入rid',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#R_ID").focus();
			return false;
			}
			
			if($("#CONTROL_ACTION_STR").val()==""){
				$("#CONTROL_ACTION_STR").tips({
					side:3,
		            msg:'请输入动作描述',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CONTROL_ACTION_STR").focus();
			return false;
			}
			if($("#CONTROL_VALUE").val()==""){
				$("#CONTROL_VALUE").tips({
					side:3,
		            msg:'请输入写值',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#CONTROL_VALUE").focus();
			return false;
			}
			if($("#ACTION_ORDER").val()==""){
				$("#ACTION_ORDER").tips({
					side:3,
		            msg:'请输入状态',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#ACTION_ORDER").focus();
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