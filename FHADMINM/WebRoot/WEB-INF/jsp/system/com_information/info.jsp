<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">

<!-- jsp文件头和头部 -->
<%@ include file="../../system/index/top.jsp"%>

</head>
<body class="no-skin">

	<!-- /section:basics/navbar.layout -->
	<div class="main-container" id="main-container">
		<!-- /section:basics/sidebar -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="page-content">
					<div class="hr hr-18 dotted hr-double"></div>
					<div class="row">
						<div class="col-xs-12">
						
						<c:choose>
							<c:when test="${rid == 75501330001}">
							<table class="table table-striped table-bordered table-hover">
							  <tr>
							    <td width="129">企业名称</td>
							    <td colspan="3">永艺发金属制品有(深圳)限公司</td>
							  </tr>
							  <tr>
							    <td>占地面积</td>
							    <td width="74">15000㎡</td>
							    <td width="113">员工人数</td>
							    <td width="156">230</td>
							  </tr>
							  <tr>
							    <td>工业排放数量</td>
							    <td>1</td>
							    <td>工业用水进口数量</td>
							    <td>1</td>
							  </tr>
							  <tr>
							    <td colspan="2">工业用水与生活用水是否为同一进口</td>
							    <td><input type="checkbox" name="checkbox" id="checkbox" disabled="true"/>是</td>
							    <td><input type="checkbox" name="checkbox" id="checkbox" checked="checked" disabled="true"/>否</td>
							  </tr>
							  
							  <tr height="550px" align="left">
							    <td colspan="4">企业其他情况：<br /><br /><br /><br /><br /><br /><br /><br />
							    <span style="font-size: 16px;">1.新建一在处理废水设施站。<br /><br />
							    2.明管明渠，一目了然。<br /><br />
							    3.所有车间出来废水分类处理 。</span>
							    
							    </td>
							  </tr>
							  <tr>
							    <td colspan="2">企业法人(或委托代表人)签字：</td>
							    <td colspan="2">段吉祥</td>
							  </tr>
							 
							  <tr>
							    <td colspan="3" >日期</td>
							    <td>2015.9.10</td>
							  </tr>
							</table>
						</c:when>
						<c:when test="${rid == 75501330002}">
						<h2 align="center">排污企业基本情况调查表</h2>
							<table class="table table-striped table-bordered table-hover">
								  <tr>
								    <td width="129">企业名称</td>
								    <td colspan="3">欧达可金属制品有(深圳)限公司</td>
								  </tr>
								  <tr>
								    <td>占地面积</td>
								    <td width="74">15000㎡</td>
								    <td width="113">员工人数</td>
								    <td width="156">230</td>
								  </tr>
								  <tr>
								    <td>工业排放数量</td>
								    <td>1</td>
								    <td>工业用水进口数量</td>
								    <td>1</td>
								  </tr>
								  <tr>
								    <td colspan="2">水务局核定人均标准用水量</td>
								    <td colspan="2">300L/人/天</td>
								  </tr>
								  <tr>
								    <td colspan="2">每天工业生产耗水量</td>
								    <td colspan="2">工业总进水的15%</td>
								  </tr>
								  <tr>
								    <td colspan="2">工业用水与生活用水是否为同一进口</td>
								    <td><input type="checkbox" name="checkbox" id="checkbox" disabled="true"/>是</td>
								    <td><input type="checkbox" name="checkbox" id="checkbox" checked="checked" disabled="true"/>否</td>
								  </tr>
								  <tr>
								    <td colspan="2">雨水排放是否分离</td>
								    <td><input type="checkbox" name="checkbox" id="checkbox" disabled="true"/>是</td>
								    <td><input type="checkbox" name="checkbox" id="checkbox" checked="checked" disabled="true"/>否</td>
								  </tr>
								  <tr height="450px" align="left">
								    <td colspan="4">企业其他情况：<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
								    </td>
								  </tr>
								  <tr>
								    <td colspan="2">企业法人(或委托代表人)签字：</td>
								    <td colspan="2">周景</td>
								  </tr>
								 
								  <tr>
								    <td colspan="3" >日期</td>
								    <td>2015.12.15</td>
								  </tr>
							</table>
						</c:when>
						<c:when test="${rid == 	75501330004}">
						<h3>附件2  排污企业基本情况调查表</h3>
							<table class="table table-striped table-bordered table-hover">
							  <tr align="center">
							    <td colspan="4">企业基本信息</td>
							  </tr>
							  <tr>
							    <td width="166">企业名称</td>
							    <td colspan="3">深圳市中村科技实业有限公司</td>
							  </tr>
							  <tr>
							    <td>生产地址</td>
							    <td colspan="3">深圳市宝安区松岗沙浦村欧洲之窗工业区</td>
							  </tr>
							  <tr>
							    <td>联系人</td>
							    <td width="69">罗晃权</td>
							    <td width="131">联系电话</td>
							    <td width="106">18922801165</td>
							  </tr>
							  <tr>
							    <td>工厂占地面积</td>
							    <td>10000㎡</td>
							    <td>工厂建筑面积</td>
							    <td>7800㎡</td>
							  </tr>
							  <tr>
							    <td>工厂员工人数</td>
							    <td>350</td>
							    <td>生产车间数量</td>
							    <td>20</td>
							  </tr>
							  <tr>
							    <td>行业类别</td>
							    <td>五金电镀</td>
							    <td>生产线数量</td>
							    <td>32条</td>
							  </tr>
							  <tr>
							    <td>上年度生活给水总量</td>
							    <td>16455</td>
							    <td>上年度工业给水总量</td>
							    <td>68777</td>
							  </tr>
							  <tr>
							    <td>产品及年产能</td>
							    <td colspan="3">&nbsp;</td>
							  </tr>
							  <tr>
							    <td>上年度总产量</td>
							    <td colspan="3">25147吨</td>
							  </tr>
							  <tr>
							    <td>生产废水处理能力（吨/日）</td>
							    <td colspan="3">400/吨</td>
							  </tr>
							  <tr align="center">
							    <td colspan="4">企业用水信息</td>
							  </tr>
							  <tr>
							    <td>生活给水口数量</td>
							    <td>1个</td>
							    <td>工业给水口数量</td>
							    <td>1个</td>
							  </tr>
							  <tr height="60px">
							    <td>工业废水总排放口数量</td>
							    <td>1个</td>
							    <td >车间或生产设施废水排放口数量(第一类污染物)</td>
							    <td>2个</td>
							  </tr>
							  <tr height="55px">
							    <td>排水管网类别以及与市政管网接驳口数量</td>
							    <td colspan="3">1个</td>
							  </tr>
							  <tr>
							    <td rowspan="3">排水管网设置情况</td>
							    <td>分离排放：</td>
							    <td colspan="2">
							      <input type="checkbox" name="checkbox" id="checkbox" checked="checked" disabled="true"/>工业、生活、雨水分离排放；    
							    </td>
							  </tr>
							  <tr height="85px">
							    <td>混合排放：</td>
							    <td colspan="2" >
							      <input type="checkbox" name="checkbox2" id="checkbox2" disabled="true"/>工业、生活、雨水混合排放；
							      <input type="checkbox" name="checkbox3" id="checkbox2" disabled="true"/>工业、生活混合排放；<br /><br />
							      <input type="checkbox" name="checkbox3" id="checkbox2" disabled="true"/>工业、雨水混合排放；
							      <input type="checkbox" name="checkbox3" id="checkbox2" disabled="true"/>生活、雨水混合排放；    
							    </td>
							  </tr>
							  <tr>
							    <td>部分分离排放</td>
							    <td colspan="2"><input type="checkbox" name="checkbox3" id="checkbox2" disabled="true"/>
							      工业分离排放；<input type="checkbox" name="checkbox3" id="checkbox2" disabled="true"/>
							      其它；</td>
							  </tr>
							  <tr height="40px">
							    <td>生活用水量(吨/日)</td>
							    <td>&nbsp;</td>
							    <td>工业用水量(吨/日)</td>
							    <td>&nbsp;</td>
							  </tr>
							  <tr height="60px">
							    <td>工业给水量(新鲜水)(吨/日)</td>
							    <td>&nbsp;</td>
							    <td>重复用水量(吨/日)</td>
							    <td>&nbsp;</td>
							  </tr>
							  <tr align="center">
							    <td colspan="4">其它说明</td>
							  </tr>
							  <tr height="180px">
							    <td colspan="4" >&nbsp;</td>
							  </tr>
							   
							  <tr height="50px">
							    <td colspan="4" >重要提示：本表由被调查人填写，被调查人必须全面、准确地填写，并保证其真实性，否则将对被调查人产生不利的影响。</td>
							  </tr><tr>
							    <td>企业法人(或代理人)签名</td>
							    <td>罗晃权</td>
							    <td>日期</td>
							    <td>2016.3.31</td>
							  </tr>
							</table>
							<h3>附件3  排污企业污染物情况调查表</h3>
							
								<table  class="table table-striped table-bordered table-hover">
								  <tr align="center">
								    <td colspan="4">企业基本信息</td>
								  </tr>
								  <tr>
								    <td width="131">企业名称</td>
								    <td colspan="3">深圳市中村科技实业有限公司</td>
								  </tr>
								  <tr>
								    <td>生产地址</td>
								    <td colspan="3">深圳市宝安区松岗沙浦欧洲之窗工业区</td>
								  </tr>
								  <tr>
								    <td>联系人</td>
								    <td width="83">罗晃权</td>
								    <td width="112">联系电话</td>
								    <td width="146">18922801165</td>
								  </tr>
								  <tr align="center">
								    <td colspan="4">主要原材料及年用量</td>
								  </tr>
								  <tr>
								    <td>原材料名称</td>
								    <td>年用量</td>
								    <td>原材料名称</td>
								    <td>年用量</td>
								  </tr>
								  <tr>
								    <td>盐酸</td>
								    <td>136.7吨</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>镍</td>
								    <td>7.3吨</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>硫酸</td>
								    <td>118.6吨</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr align="center">
								    <td colspan="4">工业废水污染物排放情况</td>
								  </tr>
								  <tr>
								    <td>污染物名称</td>
								    <td>污染物处理前浓度</td>
								    <td>污染物处理后浓度</td>
								    <td>污染物来源</td>
								  </tr>
								  <tr>
								    <td>总镍</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>总铜</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>悬浮物</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>化学需氧量</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>氨氮</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>总磷</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>六价铬</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>总氯化物</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr align="center"  >
								    <td colspan="4">水污染源在线监测设备配置情况</td>
								  </tr>
								  <tr>
								    <td>在线监测设备名称及数量</td>
								    <td>监测部位</td>
								    <td>在线监测设备及数量</td>
								    <td>监测部位</td>
								  </tr>
								  <tr>
								    <td>COD一台</td>
								    <td></td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>PH一台</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr align="center">
								    <td colspan="4" >其它说明</td>
								  </tr>
								  <tr height="60px">
								    <td colspan="4">&nbsp;</td>
								  </tr>
								  <tr height="50px">
								    <td colspan="4" >重要提示：本表由被调查人填写，被调查人必须全面、准确地填写，并保证其真实性，否则将对被调查人产生不利的影响。</td>
								  </tr>
								  <tr>
								    <td>企业法人(或代理人)签名</td>
								    <td>罗晃权</td>
								    <td>日期</td>
								    <td>2016.3.31</td>
								 
								  </tr>
								</table>
						</c:when>
						
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.page-content -->
			</div>
		</div>
		<!-- /.main-content -->

 
		<!-- 返回顶部 -->
		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->
	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- ace scripts -->
	<script src="static/ace/js/ace/ace.js"></script>

</body>
</html>