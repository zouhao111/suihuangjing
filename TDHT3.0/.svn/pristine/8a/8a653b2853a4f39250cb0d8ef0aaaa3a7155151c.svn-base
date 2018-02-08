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
					
					<form action="conf_param/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="CONF_PARAM_ID" id="CONF_PARAM_ID" value="${pd.CONF_PARAM_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
						<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">监测点ID:</td>
								<td><input type="text" name="R_ID" id="R_ID" value="${pd.R_ID}" maxlength="255" placeholder="监测点ID" title="监测点ID" style="width:98%;"/></td>
							</tr>
						<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">控制器ID:</td>
								<td> <select style="width:98%;" name="DEVICE_ID" id="DEVICE_ID"data-placeholder="请选择">
                                      <c:forEach items="${varList}" var="var" varStatus="vs">
                                      <c:if test="${pd.DEVICE_ID==var.DEVICE_ID}">
                                      <option  selected="selected" value="${var.DEVICE_ID}">${var.DEVICE_ID}</option>
                                      </c:if>
                                     <c:if test="${pd.DEVICE_ID!=var.DEVICE_ID}">
                                      <option  value="${var.DEVICE_ID}">${var.DEVICE_ID}</option>
                                      </c:if>
                                      </c:forEach>
                                      </select>
                                      </td>
                                      <%--<input type="text" name="DEVICE_ID" id="DEVICE_ID" value="${pd.DEVICE_ID}" maxlength="255" placeholder="这里输入参数中文名称" title="参数中文名称" style="width:98%;"/></td>
							
							--%></tr>
							
							
							<tr>
							
								<td style="width:75px;text-align: right;padding-top: 13px;">参数中文名称:</td>
								<td><select style="width:98%;" name="PARAM_NAME_NUMB" id="PARAM_NAME_NUMB"data-placeholder="请选择">
                                      <c:forEach items="${pollList}" var="var" varStatus="vs">
                                      
                                      <option value="${var.PARAM_NAME_NUMB}">${var.PARAM_NAME}</option>
                                     
                                     
                                      </c:forEach>
                                      </select>
                                      <input type="hidden" id="PARAM_NAME" name="PARAM_NAME"value="" />
								</td><%--
								<td><input type="text" name="PARAM_NAME" id="PARAM_NAME" value="${pd.PARAM_NAME}" maxlength="255" placeholder="这里输入参数中文名称" title="参数中文名称" style="width:98%;"/></td>
							
							--%></tr>
							
							
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
			if($("#PARAM_NAME_NUMB").val()==""){
				$("#PARAM_NAME_NUMB").tips({
					side:3,
		            msg:'请输入参数中文名称',
		            bg:'#AE81FF',
		            time:2
		        });
				
				$("#PARAM_NAME").focus();
			return false;
			}
			var options=$("#PARAM_NAME_NUMB option:selected");  //获取选中的项
			$("#PARAM_NAME").val(options.text());
		
			
			
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