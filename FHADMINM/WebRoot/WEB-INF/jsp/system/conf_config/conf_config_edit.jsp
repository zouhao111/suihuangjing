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
							<%-- <tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">ID:</td>
								<td><input type="number" name="ID" id="ID" value="${pd.ID}" maxlength="32" placeholder="这里输入ID" title="ID" style="width:98%;"/></td>
							</tr> --%>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">监测点ID:</td>
								<td>  <select style="width:98%;" name="R_ID" id="R_ID"data-placeholder="请选择">
                                      <c:forEach items="${varList}" var="var" varStatus="vs">
                                      <c:if test="${pd.R_ID==var.RID}">
                                      <option  selected="selected" value="${var.RID}" >${var.RID}</option>
                                      </c:if>
                                     <c:if test="${pd.R_ID!=var.RID}">
                                      <option  value="${var.RID}">${var.RID}</option>
                                      </c:if>
                                      </c:forEach>
                                      </select><%-- 
                                     <input type="text" name="R_ID" id="R_ID" value="${pd.R_ID}" maxlength="20" placeholder="这里输入监测点ID" title="监测点ID" style="width:98%;"/>
                                
                                 --%></td>
							</tr>
							<%--<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">监测点名称:</td>
								<td>
								
								
								<input type="text" name="R_NAME_CN" id="R_NAME_CN" value="${pd.R_NAME_CN}" maxlength="20" placeholder="这里输入监测点名称" title="监测点名称" style="width:98%;"/>
								
								</td>
							</tr>
							--%><tr>
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
								<td>
								<input type="text" name="R_BASINNAME" id="R_BASINNAME" value="${pd.R_BASINNAME}" maxlength="255" placeholder="这里输入流域" title="流域" style="width:30%;"/>
								<input type="text" name="R_BASIN" id="R_BASIN" value="${pd.R_BASIN}" maxlength="255" placeholder="这里输入流域" title="流域" style="width:35%;"/>
									<select name="level1" id="level1" onchange="change1(this.value)">
		                                <option>请选择</option>      					 
		                          	</select>
		                          	<select id="level2" name="level2" onchange="change2(this.value)">
								 		<option>请选择</option>                       
                      				</select>
                      				<select id="level3" name="level3" onchange="change3(this.value)">
								 		<option>请选择</option>                       
                      				</select>
                      				<!-- <select id="level4" name="level4">
										<option>请选择</option>
									</select> --></td>
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
								<td>
									<input type="text" name="R_REGIONNAME" id="R_REGIONNAME" value="${pd.R_REGIONNAME}" maxlength="255" placeholder="这里输入地区" title="地区" style="width:25%;"/>
									<input type="text" name="R_REGION" id="R_REGION" value="${pd.R_REGION}" maxlength="255" placeholder="这里输入地区" title="地区" style="width:35%;"/>
									<select name="level1s" id="level1s" onchange="change1s(this.value)">
		                                <option>请选择</option>      					 
		                          	</select>
		                          	<select id="level2s" name="level2s" onchange="change2s(this.value)">
								 		<option>请选择</option>                       
                      				</select>
                      				<select id="level3s" name="level3s" onchange="change3s(this.value)">
								 		<option>请选择</option>                       
                      				</select>
                      				<select id="level4s" name="level4s">
										<option>请选择</option>
									</select></td>
								</td>
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
								<td style="width:75px;text-align: right;padding-top: 13px;">水量清零时间</td>
								<td><input class="span10 date-picker"type="text" name="R_WATER_STR_TIME" id="R_WATER_STR_TIME" value="${pd.R_WATER_STR_TIME}"data-date-format="yyyy-mm-dd"  style="width:150px;" placeholder="清零时间" title="清零时间" maxlength="255" style="width:98%;"/></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">水质清零时间:</td>
								<td><input class="span10 date-picker"type="text" name="R_QUALITY_STR_TIME" id="R_QUALITY_STR_TIME" value="${pd.R_QUALITY_STR_TIME}"data-date-format="yyyy-mm-dd"  style="width:150px;" placeholder="清零时间" title="清零时间" maxlength="255" style="width:98%;"/></td>
							</tr>
                            <tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">人数是否计算水平衡:</td>
								<td><input type="text" name="R_BALANCE_PER_CALC" id="R_BALANCE_PER_CALC" value="${pd.R_BALANCE_PER_CALC}" maxlength="255" placeholder="这里输入人数是否计算水平衡" title="人数是否计算水平衡" style="width:98%;"/></td>
							</tr>
							 <tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">是否需要:</td>
								<td><input type="number" name="R_IS_NEED" id="R_IS_NEED" value="${pd.R_IS_NEED}" maxlength="255" placeholder="这里输入是否需要" title="是否需要" style="width:98%;"/></td>
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
		/*	if($("#R_NAME_CN").val()==""){
				$("#R_NAME_CN").tips({
					side:3,
		            msg:'请输入监测点名称',
		            bg:'#AE81FF',
		            time:2
		        });
				$("#R_NAME_CN").focus();
			return false;
			}*/
			
			$("#Form").submit();
			$("#zhongxin").hide();
			$("#zhongxin2").show();
		}
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		
		document.getElementById("level3").onchange=function (){
		
			var obj=document.getElementById("level3");
			var index = obj.selectedIndex; // 选中索引
			var text = obj.options[index].text; // 选中文本
	
  			if(this.options[0].value==-1)this.options[0]=null;
  			document.getElementById("R_BASIN").value=this.value
  			document.getElementById("R_BASINNAME").value=text
  			
		};
		

		document.getElementById("level4s").onchange=function (){
		
			var obj=document.getElementById("level4s");
			var index = obj.selectedIndex; // 选中索引
			var text = obj.options[index].text; // 选中文本
			
  			if(this.options[0].value==-1)this.options[0]=null;
  			document.getElementById("R_REGION").value=this.value
  			document.getElementById("R_REGIONNAME").value=text
  			
		};

		//初始第一级
		$(function() {
			$.ajax({
				type: "POST",
				url: '<%=basePath%>linkage/getLevels.do?tm='+new Date().getTime(),
		    	data: {},
				dataType:'json',
				cache: false,
				success: function(data){
					$("#level1").html('<option>请选择</option>');
					 $.each(data.list, function(i, dvar){
							$("#level1").append("<option value="+dvar.DICTIONARIES_ID+">"+dvar.BZ+"</option>");
					 });
				}
			});
		});
		
		//第一级值改变事件(初始第二级)
		function change1(value){
			$.ajax({
				type: "POST",
				url: '<%=basePath%>linkage/getLevels.do?tm='+new Date().getTime(),
		    	data: {DICTIONARIES_ID:value},
				dataType:'json',
				cache: false,
				success: function(data){
					$("#level2").html('<option>请选择</option>');
					$("#level3").html('<option>请选择</option>');
					$("#level4").html('<option>请选择</option>');
					 $.each(data.list, function(i, dvar){
							$("#level2").append("<option value="+dvar.DICTIONARIES_ID+">"+dvar.BZ+"</option>");
					 });
				}
			});
		}
		
		//第二级值改变事件(初始第三级)
		function change2(value){
			$.ajax({
				type: "POST",
				url: '<%=basePath%>linkage/getLevels.do?tm='+new Date().getTime(),
		    	data: {DICTIONARIES_ID:value},
				dataType:'json',
				cache: false,
				success: function(data){
					$("#level3").html('<option>请选择</option>');
					$("#level4").html('<option>请选择</option>');
					 $.each(data.list, function(i, dvar){
							$("#level3").append("<option value="+dvar.DICTIONARIES_ID+">"+dvar.BZ+"</option>");
					 });
				}
			});
		}

		//第三级值改件(初始第四级)
		function change3(value){
			$.ajax({
				type: "POST",
				url: '<%=basePath%>linkage/getLevels.do?tm='+new Date().getTime(),
		    	data: {DICTIONARIES_ID:value},
				dataType:'json',
				cache: false,
				success: function(data){
					$("#level4").html('<option>请选择</option>');
					 $.each(data.list, function(i, dvar){
							$("#level4").append("<option value="+dvar.DICTIONARIES_ID+">"+dvar.BZ+"</option>");
					 });
				}
			});
		}
		
		
		//初始第一级
		$(function() {
			$.ajax({
				type: "POST",
				url: '<%=basePath%>linkage/getLevels.do?tm='+new Date().getTime(),
		    	data: {},
				dataType:'json',
				cache: false,
				success: function(data){
					$("#level1s").html('<option>请选择</option>');
					 $.each(data.list, function(i, dvar){
							$("#level1s").append("<option value="+dvar.DICTIONARIES_ID+">"+dvar.BZ+"</option>");
					 });
				}
			});
		});
		
		//第一级值改变事件(初始第二级)
		function change1s(value){
			$.ajax({
				type: "POST",
				url: '<%=basePath%>linkage/getLevels.do?tm='+new Date().getTime(),
		    	data: {DICTIONARIES_ID:value},
				dataType:'json',
				cache: false,
				success: function(data){
					$("#level2s").html('<option>请选择</option>');
					$("#level3s").html('<option>请选择</option>');
					$("#level4s").html('<option>请选择</option>');
					 $.each(data.list, function(i, dvar){
							$("#level2s").append("<option value="+dvar.DICTIONARIES_ID+">"+dvar.BZ+"</option>");
					 });
				}
			});
		}
		
		//第二级值改变事件(初始第三级)
		function change2s(value){
			$.ajax({
				type: "POST",
				url: '<%=basePath%>linkage/getLevels.do?tm='+new Date().getTime(),
		    	data: {DICTIONARIES_ID:value},
				dataType:'json',
				cache: false,
				success: function(data){
					$("#level3s").html('<option>请选择</option>');
					$("#level4s").html('<option>请选择</option>');
					 $.each(data.list, function(i, dvar){
							$("#level3s").append("<option value="+dvar.DICTIONARIES_ID+">"+dvar.BZ+"</option>");
					 });
				}
			});
		}

		//第三级值改件(初始第四级)
		function change3s(value){
			$.ajax({
				type: "POST",
				url: '<%=basePath%>linkage/getLevels.do?tm='+new Date().getTime(),
		    	data: {DICTIONARIES_ID:value},
				dataType:'json',
				cache: false,
				success: function(data){
					$("#level4s").html('<option>请选择</option>');
					 $.each(data.list, function(i, dvar){
							$("#level4s").append("<option value="+dvar.DICTIONARIES_ID+">"+dvar.BZ+"</option>");
					 });
				}
			});
		}
		
		
	
		</script>
</body>
</html>