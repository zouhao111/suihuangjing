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
						
							<h2>水污染物</h2>
								<table class="table table-striped table-bordered table-hover">
								  <tr>
								    <td width="18%">排污口编号</td>
								    <td colspan="5">总排口</td>
								    <td colspan="10">总排</td>
								  </tr>
								  <tr>
								    <td>排放去向(受纳水体名称)</td>
								    <td colspan="5">珠江口流域</td>
								    <td colspan="10">污水处理厂</td>
								  </tr>
								  <tr width="80px">
								    <td>废水排放执行标准</td>
								    <td colspan="5"><p>一类：GB21900-2008表3标准</p>
								    <p>GB21900-2008表2标准</p></td>
								    <td colspan="10"><p>二类：污水厂进水标准</p>
								    <p>GB21900-2008表2标准(总铜)</p></td>
								  </tr>
								  <tr>
								    <td>排污口名称</td>
								    <td colspan="5">一类污染物排放口</td>
								    <td colspan="10">二类污染物排放口</td>
								  </tr>
								  <tr>
								    <td>主要污染物名称</td>
								    <td width="7%">六价铬</td>
								    <td width="10%">总镍</td>
								    <td width="6%">&nbsp;</td>
								    <td width="9%">&nbsp;</td>
								    <td width="7%">&nbsp;</td>
								    <td width="5%">PH值</td>
								    <td width="6%">悬浮物</td>
								    <td width="6%">COD</td>
								    <td width="4%">总铜</td>
								    <td width="2%">氨氮</td>
								    <td width="7%">总氰化物</td>
								    <td width="2%">总磷</td>
								    <td width="2%">&nbsp;</td>
								    <td width="4%">&nbsp;</td>
								    <td width="5%">&nbsp;</td>
								  </tr>
								  <tr>
								    <td>排放浓度限值(mg/L)</td>
								    <td>0.1</td>
								    <td>0.5</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>6-9</td>
								    <td>220</td>
								    <td>280</td>
								    <td>0.5</td>
								    <td>40</td>
								    <td>1.0</td>
								    <td>4.5</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>日废水排放量限值(吨/日)</td>
								    <td colspan="5">350.0</td>
								    <td colspan="5">年废水排放量限值(万吨/年)</td>
								    <td colspan="5">&nbsp;</td>
								  </tr>
								  </table>
								 <table class="table table-striped table-bordered table-hover">
								  <tr>
								    <td width="10%" rowspan="5">有效期限内各年度污染物排放量限值(吨/年)</td>
								    <td width="12%">污染物名称</td>
								    <td width="8%">COD</td>
								    <td width="8%">氨氮</td>
								    <td width="8%">&nbsp;</td>
								    <td width="8%">&nbsp;</td>
								    <td width="8%">&nbsp;</td>
								    <td width="8%">&nbsp;</td>
								    <td width="8%">&nbsp;</td>
								    <td width="8%">&nbsp;</td>
								    <td width="8%">&nbsp;</td>
								  </tr>
								  <tr>
								    <td align="right">年</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td align="right">年</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td align="right">年</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td align="right">年</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr align="left">
								    <td colspan="11">备 注：废水排污口合计有__2__个</td>
								   </tr>
								</table>

								<h2>水污染物</h2>
								<table class="table table-striped table-bordered table-hover">
								  <tr>
								    <td width="18%">排污口编号</td>
								    <td colspan="5">总排口</td>
								    <td colspan="10">总排</td>
								  </tr>
								  <tr>
								    <td>排放去向(受纳水体名称)</td>
								    <td colspan="5">珠江口流域</td>
								    <td colspan="10">污水处理厂</td>
								  </tr>
								  <tr width="80px">
								    <td>废水排放执行标准</td>
								    <td colspan="5"><p>一类：GB21900-2008表3标准</p>
								    <p>GB21900-2008表2标准</p></td>
								    <td colspan="10"><p>二类：污水厂进水标准</p>
								    <p>GB21900-2008表2标准(总铜)</p></td>
								  </tr>
								  <tr>
								    <td>排污口名称</td>
								    <td colspan="5">一类污染物排放口</td>
								    <td colspan="10">二类污染物排放口</td>
								  </tr>
								  <tr>
								    <td>主要污染物名称</td>
								    <td width="7%">六价铬</td>
								    <td width="10%">总镍</td>
								    <td width="6%">&nbsp;</td>
								    <td width="9%">&nbsp;</td>
								    <td width="7%">&nbsp;</td>
								    <td width="5%">PH值</td>
								    <td width="6%">悬浮物</td>
								    <td width="6%">COD</td>
								    <td width="4%">总铜</td>
								    <td width="2%">氨氮</td>
								    <td width="7%">总氰化物</td>
								    <td width="2%">总磷</td>
								    <td width="2%">&nbsp;</td>
								    <td width="4%">&nbsp;</td>
								    <td width="5%">&nbsp;</td>
								  </tr>
								  <tr>
								    <td>排放浓度限值(mg/L)</td>
								    <td>0.1</td>
								    <td>0.5</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>6-9</td>
								    <td>220</td>
								    <td>280</td>
								    <td>0.5</td>
								    <td>40</td>
								    <td>1.0</td>
								    <td>4.5</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td>日废水排放量限值(吨/日)</td>
								    <td colspan="5">350.0</td>
								    <td colspan="5">年废水排放量限值(万吨/年)</td>
								    <td colspan="5">&nbsp;</td>
								  </tr>
								  </table>
								 <table class="table table-striped table-bordered table-hover">
								  <tr>
								    <td width="10%" rowspan="5">有效期限内各年度污染物排放量限值(吨/年)</td>
								    <td width="12%">污染物名称</td>
								    <td width="8%">COD</td>
								    <td width="8%">氨氮</td>
								    <td width="8%">&nbsp;</td>
								    <td width="8%">&nbsp;</td>
								    <td width="8%">&nbsp;</td>
								    <td width="8%">&nbsp;</td>
								    <td width="8%">&nbsp;</td>
								    <td width="8%">&nbsp;</td>
								    <td width="8%">&nbsp;</td>
								  </tr>
								  <tr>
								    <td align="right">年</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td align="right">年</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td align="right">年</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr>
								    <td align="right">年</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								    <td>&nbsp;</td>
								  </tr>
								  <tr align="left">
								    <td colspan="11">备 注：废水排污口合计有__2__个</td>
								   </tr>
								</table>
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