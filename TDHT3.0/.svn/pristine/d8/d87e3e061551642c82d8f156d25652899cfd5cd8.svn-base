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
					
					<form action="conf_config/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="CONF_CONFIG_ID" id="CONF_CONFIG_ID" value="${pd.CONF_CONFIG_ID}"/>
						<div id="zhongxin" style="padding-top: 13px;">
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">ID:</td>
								<td><input type="number" name="ID" id="ID" value="${pd.ID}" maxlength="32" placeholder="这里输入ID" title="ID" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">监测点ID:</td>
								
								
								<td> <select style="width:98%;" name="R_ID" id="R_ID"data-placeholder="请选择">
                                      <c:forEach items="${varList}" var="var" varStatus="vs">
                                      <c:if test="${pd.R_ID==var.RID}">
                                      <option  selected="selected" value="${var.RID}">${var.RID}</option>
                                      </c:if>
                                     <c:if test="${pd.R_ID!=var.RID}">
                                      <option  value="${var.RID}">${var.RID}</option>
                                      </c:if>
                                      </c:forEach>
                                      </select>
                                      <%--
                                     
                                     <input type="text" name="R_ID" id="R_ID" value="${pd.R_ID}" maxlength="20" placeholder="这里输入监测点名称" title="监测点名称" style="width:98%;"/>
                                    
                                      --%></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">监测点名称:</td>
								<td><input type="text" name="R_NAME_CN" id="R_NAME_CN" value="${pd.R_NAME_CN}" maxlength="20" placeholder="这里输入监测点名称" title="监测点名称" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">纬度:</td>
								<td><input type="text" name="R_LAT" id="R_LAT" value="${pd.R_LAT}" maxlength="12" placeholder="这里输入纬度" title="纬度" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">经度:</td>
								<td><input type="text" name="R_LON" id="R_LON" value="${pd.R_LON}" maxlength="12" placeholder="这里输入经度" title="经度" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">人数:</td>
								<td><input type="number" name="R_N" id="R_N" value="${pd.R_N}" maxlength="32" placeholder="这里输入人数" title="人数" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">人均日水量:</td>
								<td><input type="text" name="R_Q" id="R_Q" value="${pd.R_Q}" maxlength="12" placeholder="这里输入人均日水量" title="人均日水量" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">系数:</td>
								<td><input type="text" name="R_K" id="R_K" value="${pd.R_K}" maxlength="12" placeholder="这里输入系数" title="系数" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">流域:</td>
								<td><input type="text" name="R_BASIN" id="R_BASIN" value="${pd.R_BASIN}" maxlength="255" placeholder="这里输入流域" title="流域" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">地址:</td>
								<td><input type="text" name="R_ADDRESS" id="R_ADDRESS" value="${pd.R_ADDRESS}" maxlength="255" placeholder="这里输入地址" title="地址" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">照片:</td>
								<td> 
								<input type="file" name="R_PHOTO" id="R_PHOTO" value="${pd.R_PHOTO}" maxlength="255" placeholder="这里输入照片" title="照片" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">安装形式:</td>
								<td><input type="text" name="R_INSTALL" id="R_INSTALL" value="${pd.R_INSTALL}" maxlength="255" placeholder="这里输入安装形式" title="安装形式" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">电话:</td>
								<td><input type="text" name="R_TELEPHONE" id="R_TELEPHONE" value="${pd.R_TELEPHONE}" maxlength="255" placeholder="这里输入电话" title="电话" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">地区:</td>
								<td><input type="text" name="R_REGION" id="R_REGION" value="${pd.R_REGION}" maxlength="255" placeholder="这里输入地区" title="地区" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">运营单位:</td>
								<td><input type="text" name="R_OPERATING" id="R_OPERATING" value="${pd.R_OPERATING}" maxlength="255" placeholder="这里输入运营单位" title="运营单位" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">运营单位联系人:</td>
								<td><input type="text" name="R_CONTACT" id="R_CONTACT" value="${pd.R_CONTACT}" maxlength="255" placeholder="这里输入运营单位联系人" title="运营单位联系人" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">建设状态:</td>
								<td><input type="text" name="R_BUILD" id="R_BUILD" value="${pd.R_BUILD}" maxlength="255" placeholder="这里输入建设状态" title="建设状态" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">监测类型:</td>
								<td><input type="text" name="R_WATERTYPE" id="R_WATERTYPE" value="${pd.R_WATERTYPE}" maxlength="255" placeholder="这里输入监测类型" title="监测类型" style="width:98%;"/></td>
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
		
		//console.log(${varList});
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
			if($("#R_ID").val()==""){
				$("#R_ID").tips({
					side:3,
		            msg:'请输入监测点ID',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#R_ID").focus();
			return false;
			}
			if($("#R_NAME_CN").val()==""){
				$("#R_NAME_CN").tips({
					side:3,
		            msg:'请输入监测点名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#R_NAME_CN").focus();
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