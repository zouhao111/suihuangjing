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
					
					<form action="rid_device/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="R_ID" id="R_ID" value="${pd.R_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">ID:</td>
								<td><input type="number" name="ID" id="ID" value="${ID}" maxlength="32" placeholder="这里输入ID" title="ID" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">RID:</td>
								<td>
								
								
								<div style="width:98%;">
                                      <select style="width:100%;" name="R_ID" id="R_ID"data-placeholder="请选择">
                                      <c:forEach items="${roleList}" var="var" varStatus="vs">
                                      <c:if test="${pd.R_ID==var.RID}">
                                      <option  selected="selected" value="${var.RID}">${var.RID}</option>
                                      </c:if>
                                     <c:if test="${pd.R_ID!=var.RID}">
                                      <option  value="${var.RID}">${var.RID}</option>
                                      </c:if>
                                      </c:forEach>
                                      </select>
                                 
                                 </div>
								<%--<input type="number" name="R_ID" id="R_ID" value="${pd.R_ID}" maxlength="32" placeholder="这里输入RID" title="RID" style="width:98%;"/>
								
								--%></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">控制器ID:</td>
								<td><input type="number" name="DEVICE_ID" id="DEVICE_ID" value="${pd.DEVICE_ID}" maxlength="32" placeholder="这里输入控制器ID" title="控制器ID" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">控制器类型:</td>
								<td><input type="number" name="DEVICE_TYPE" id="DEVICE_TYPE" value="${pd.DEVICE_TYPE}" maxlength="32" placeholder="这里输入控制器类型" title="控制器类型" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">1参与计算  0不参与计算:</td>
								<td><input type="number" name="BALANCE_CALC" id="BALANCE_CALC" value="${pd.BALANCE_CALC}" maxlength="32" placeholder="这里输入1参与计算  0不参与计算" title="1参与计算  0不参与计算" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">读指令的字数:</td>
								<td>
								 <select style="width:100%;" name="Read_NUMBER" id="Read_NUMBER"data-placeholder="请选择">
                                      
                                      <option  selected="selected" value="0">0</option>
                                      <option   value="100">100</option>
                                      <option   value="201">201</option>
                                      <option   value="303">303</option>
                                      <option   value="406">406</option>
                                       <option   value="510">510</option>
                                      <option   value="615">615</option>
                                      <option   value="721">721</option>
                                      <option   value="828">828</option>
                                       <option   value="936">936</option>
                                      <option   value="1045">1045</option>
                                     
                                      </select>
								<%--<input type="String" name="BALANCE_CALC" id="BALANCE_CALC" value="${pd.BALANCE_CALC}" maxlength="32" placeholder="这里输入1参与计算  0不参与计算" title="1参与计算  0不参与计算" style="width:98%;"/>
								
								--%></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">机舱ID:</td>
								<td><input type="String" name="cabin_id" id="cabin_id" value="${pd.cabin_id}" maxlength="32" placeholder="这里输入机舱ID" title="机舱ID" style="width:98%;"/></td>
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
			/*if($("#ID").val()==""){
				$("#ID").tips({
					side:3,
		            msg:'请输入ID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#ID").focus();
			return false;
			}*/
			//var options=$("#R_ID option:selected");  //获取选中的项
			
			/*if($("#R_ID").val()==""){
				$("#R_ID").tips({
					side:3,
		            msg:'请输入RID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#R_ID").focus();
			return false;
			}*/
			if($("#DEVICE_ID").val()==""){
				$("#DEVICE_ID").tips({
					side:3,
		            msg:'请输入控制器ID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#DEVICE_ID").focus();
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
			if($("#BALANCE_CALC").val()==""){
				$("#BALANCE_CALC").tips({
					side:3,
		            msg:'请输入1参与计算  0不参与计算',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#BALANCE_CALC").focus();
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