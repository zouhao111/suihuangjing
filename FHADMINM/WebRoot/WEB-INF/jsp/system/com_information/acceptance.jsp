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
						
						
						<div style="width:450px;font-size: 13px;float: left;">
								<h1 align="center">深圳市环境保护局</h1>
								<hr></hr>
								<h2 align="center">关于深圳市中村科技实业有限公司项目竣工环境<br />保护验收的决定书</h2>
								<p align="center">（生产类）</p>
								<p align="center">深环验收[2006]125号</p>
								<p>深圳市中村科技实业有限公司：<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;根据《中华人民共和国环境保护法》及国家和省建设项目环境保护管理条例等有关法律、法规的规定，经对你单位环境保护设施验收申请表及附件资料审查，我局组织了现场验收，现批复如下：<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;一、验收结论：该项目环保审批手续齐全，已按要求落实废水、废气环保措施，污染物排放标准，在线监测设备已联网并通过对比监测，符合环保验收条件，同意你单位环保设施正式投入使用。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;二、生产规模核定情况：验收该定电镀生产线27条；生产产品为五金制品；符合环境影响报告表和环境影响审批批复核定的范围。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;三、环保设施建设情况：该项目建成工业废水处理设施一套，核准工业废水排放量350吨/日；废气处理设施一套。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;四、验收监测情况：<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(一)工业废水达到DB44/26-2001的二级排放标准，达到率100%。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(二)废气处理达到DB44/27-2001的二级排放标准。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;五、有关要求：<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(一)今后须加强对污染治理设施的管理，以保证各治理设施正常运行和污染物达标排放。如污染治理设施须拆除、闲置，需向我局申请。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(二)污染治理设施运行必须符合安全生产要求，严格按照安全规程操作。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(三)验收后向我局申请办理《排污许可证》。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(四)你单位必须按环评报告要求，认证落实环境风险防范措施和履行环境安全职责。<br />
								<p align="right">深圳市环境保护局</p><br />
								<p align="right">二〇〇六年八月十八日</p>
								</p>
							</div>
						</a>
						</div>
							

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