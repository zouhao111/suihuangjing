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
								<td style="width:75px;text-align: right;padding-top: 13px;">控制器参数ID:</td>
								<td><input type="text" name="PARAM_ID" id="PARAM_ID" value="${pd.PARAM_ID}" maxlength="255" placeholder="这里输入控制器参数ID" title="参数控制器参数ID" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">参数中文名称:</td>
								<td><input type="text" name="PARAM_NAME" id="PARAM_NAME" value="${pd.PARAM_NAME}" maxlength="255" placeholder="这里输入参数中文名称" title="参数中文名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">参数ID:</td>
								<td><input type="number" name="PARAM_NAME_NUMB" id="PARAM_NAME_NUMB" value="${pd.PARAM_NAME_NUMB}" maxlength="32" placeholder="这里输入参数ID" title="参数ID" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">modbus点位:</td>
								<td><input type="number" name="MODBUS_ADDR" id="MODBUS_ADDR" value="${pd.MODBUS_ADDR}" maxlength="32" placeholder="这里输入modbus点位" title="modbus点位" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">数据类型:</td>
								<td>
								<select style="width:98%;" name="DATA_TYPES" id="DATA_TYPES"data-placeholder="请选择">
                                      <c:forEach items="${data_TypesList}" var="var" varStatus="vs">
                                      <c:if test="${pd.DATA_TYPES==var}">
                                      <option  selected="selected" value="${var}">${var}</option>
                                      </c:if>
                                     <c:if test="${pd.DATA_TYPES!=var}">
                                      <option  value="${var}">${var}</option>
                                      </c:if>
                                      </c:forEach>
                                      </select>
								
								<%--<input type="text" name="DATA_TYPES" id="DATA_TYPES" value="${pd.DATA_TYPES}" maxlength="12" placeholder="这里输入数据类型" title="数据类型" style="width:98%;"/>
								
								--%></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">高低位排序:</td>
								<td>
								<select style="width:98%;" name="BYTE_ORDER" id="BYTE_ORDER"data-placeholder="请选择">
                                      <c:forEach items="${byte_orderList}" var="var" varStatus="vs">
                                      <c:if test="${pd.BYTE_ORDER==var}">
                                      <option  selected="selected" value="${var}">${var}</option>
                                      </c:if>
                                     <c:if test="${pd.BYTE_ORDER!=var}">
                                      <option  value="${var}">${var}</option>
                                      </c:if>
                                      </c:forEach>
                                      </select>
								
								<%--<input type="text" name="BYTE_ORDER" id="BYTE_ORDER" value="${pd.BYTE_ORDER}" maxlength="12" placeholder="这里输入高低位排序" title="高低位排序" style="width:98%;"/>
								
								--%></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">scale_factor:</td>
								<td><input type="text" name="SCALE_FACTOR" id="SCALE_FACTOR" value="${pd.SCALE_FACTOR}" maxlength="12" placeholder="这里输入scale_factor" title="scale_factor" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">偏移值:</td>
								<td><input type="text" name="OFFSET_VALUE" id="OFFSET_VALUE" value="${pd.OFFSET_VALUE}" maxlength="12" placeholder="这里输入偏移值" title="偏移值" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">预警上限:</td>
								<td><input type="text" name="LIMITH" id="LIMITH" value="${pd.LIMITH}" maxlength="12" placeholder="这里输入预警上限" title="预警上限" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">报警上限:</td>
								<td><input type="text" name="LIMITHH" id="LIMITHH" value="${pd.LIMITHH}" maxlength="12" placeholder="这里输入报警上限" title="报警上限" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">预警下限:</td>
								<td><input type="text" name="LIMITL" id="LIMITL" value="${pd.LIMITL}" maxlength="12" placeholder="这里输入预警下限" title="预警下限" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">报警下限:</td>
								<td><input type="text" name="LIMITLL" id="LIMITLL" value="${pd.LIMITLL}" maxlength="12" placeholder="这里输入报警下限" title="报警下限" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">参数初始值:</td>
								<td><input type="text" name="PARAM_VALUE" id="PARAM_VALUE" value="${pd.PARAM_VALUE}" maxlength="12" placeholder="这里输入参数初始值" title="参数初始值" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">时间类型:</td>
								<td><input class="span10 date-picker" name="STR_TIME" id="STR_TIME" value="${pd.STR_TIME}" type="text" data-date-format="yyyy-mm-dd" readonly="readonly" placeholder="时间类型" title="时间类型" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">时间整型:</td>
								<td><input type="number" name="SY_TIME" id="SY_TIME" value="${pd.SY_TIME}" maxlength="32" placeholder="这里输入时间整形" title="时间整形" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">可见1  不可见0:</td>
								<td><input type="number" name="PARAM_ABLE" id="PARAM_ABLE" value="${pd.PARAM_ABLE}" maxlength="32" placeholder="这里输入可见1  不可见0" title="可见1  不可见0" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">1有上下限  0没有上下限:</td>
								<td><input type="number" name="LIMIT_ABLE" id="LIMIT_ABLE" value="${pd.LIMIT_ABLE}" maxlength="32" placeholder="这里输入1有上下限  0没有上下限" title="1有上下限  0没有上下限" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">decimal_number:</td>
								<td><input type="number" name="DECIMAL_NUMBER" id="DECIMAL_NUMBER" value="${pd.DECIMAL_NUMBER}" maxlength="32" placeholder="这里输入decimal_number" title="decimal_number" style="width:98%;"/></td>
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
			if($("#PARAM_NAME").val()==""){
				$("#PARAM_NAME").tips({
					side:3,
		            msg:'请输入参数中文名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PARAM_NAME").focus();
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
			if($("#MODBUS_ADDR").val()==""){
				$("#MODBUS_ADDR").tips({
					side:3,
		            msg:'请输入modbus点位',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#MODBUS_ADDR").focus();
			return false;
			}
			if($("#DATA_TYPES").val()==""){
				$("#DATA_TYPES").tips({
					side:3,
		            msg:'请输入数据类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DATA_TYPES").focus();
			return false;
			}
			if($("#BYTE_ORDER").val()==""){
				$("#BYTE_ORDER").tips({
					side:3,
		            msg:'请输入高低位排序',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#BYTE_ORDER").focus();
			return false;
			}
			if($("#SCALE_FACTOR").val()==""){
				$("#SCALE_FACTOR").tips({
					side:3,
		            msg:'请输入scale_factor',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#SCALE_FACTOR").focus();
			return false;
			}
			if($("#OFFSET_VALUE").val()==""){
				$("#OFFSET_VALUE").tips({
					side:3,
		            msg:'请输入偏移值',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#OFFSET_VALUE").focus();
			return false;
			}
			if($("#LIMITH").val()==""){
				$("#LIMITH").tips({
					side:3,
		            msg:'请输入预警上限',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#LIMITH").focus();
			return false;
			}
			if($("#LIMITHH").val()==""){
				$("#LIMITHH").tips({
					side:3,
		            msg:'请输入报警上限',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#LIMITHH").focus();
			return false;
			}
			if($("#LIMITL").val()==""){
				$("#LIMITL").tips({
					side:3,
		            msg:'请输入报警上限',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#LIMITL").focus();
			return false;
			}
			if($("#LIMITLL").val()==""){
				$("#LIMITLL").tips({
					side:3,
		            msg:'请输入报警下限',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#LIMITLL").focus();
			return false;
			}
			if($("#PARAM_VALUE").val()==""){
				$("#PARAM_VALUE").tips({
					side:3,
		            msg:'请输入参数初始值',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PARAM_VALUE").focus();
			return false;
			}
			if($("#STR_TIME").val()==""){
				$("#STR_TIME").tips({
					side:3,
		            msg:'请输入时间类型',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#STR_TIME").focus();
			return false;
			}
			if($("#SY_TIME").val()==""){
				$("#SY_TIME").tips({
					side:3,
		            msg:'请输入时间整形',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#SY_TIME").focus();
			return false;
			}
			if($("#PARAM_ABLE").val()==""){
				$("#PARAM_ABLE").tips({
					side:3,
		            msg:'请输入可见1  不可见0',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#PARAM_ABLE").focus();
			return false;
			}
			if($("#LIMIT_ABLE").val()==""){
				$("#LIMIT_ABLE").tips({
					side:3,
		            msg:'请输入1有上下限  0没有上下限',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#LIMIT_ABLE").focus();
			return false;
			}
			if($("#DECIMAL_NUMBER").val()==""){
				$("#DECIMAL_NUMBER").tips({
					side:3,
		            msg:'请输入decimal_number',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DECIMAL_NUMBER").focus();
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