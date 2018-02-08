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
						
							<div style="width:550px;font-size: 13px;float: left;">
								<h1 align="center">深圳市环境保护局<br /><br />建设项目环境影响审查批复</h1>
								<p align="center">深环批[2005]12230号</p>
								<hr></hr>
								<p>
								深圳市中村科技实业有限公司：<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;根据《中华人民共和国环境保护法》及国家建设项目环境保护管理有关法律、法规规定，经对《深圳市建设项目环境影响审批申请表》(12230)号及附件的审查，我局同意你公司在宝安区松岗镇沙浦村欧洲之窗工业区原址改建，同时对该项目要求如下：<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.该项目按申报方式生产五金制品，年生产量分别为3万吨。如有扩大规模、改变生产内容、改变建设地址须另行申报。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.该项目设置有酸洗、除油、钝化、镀铜、镀镍、镀铬、镀锌工序，项目将现有的1.5米x2.0~5.0米的电镀生产线，如有改变须另行申报。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3.排放废水执行DB44/26-2001的二级标准，改建后该项目生产用水量不超过500吨/日，改建后废水回用30%，改建后日排放废水量不超过350吨，废水须经过处理达标后方可排放。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4.排放废气执行DB44/27-2001的二级标准，所排废气须经处理，达到规定标准后，通过管道高空排放。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5.噪声执行GB12348-90Ⅱ类标准，白天≤60分贝，夜间≤50分贝。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6.生产中产生的工业固体废弃物不准擅自排放或混入生活垃圾中倾倒，工业危险废物(包括产生的浓度液及污泥)须委托深圳市危险废物处理站或经我局认可的有危险废物处理资质的单位处理，有关委托合同须报我局备案。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7.建设施工过程须逐项落实该项目环境影响评价报告表所提的各项环保措施。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;8.生产中产生的废水、废气须经过该项目专用污染防治设施处理达标后，才能排放。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;9.该项目污染防治设施须委托有环保技术资格证书的单位设计、施工，其设计方案须报我局备案。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;10.废水处理设施必须安装自动监控联网设备。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11.污染防治设施建成竣工后，投入使用前，须向我局申请验收，验收合格后主体工程方可投入使用或生产。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;12.建设工程或投入使用后，产生和向环境排放污染物应依法向深圳市环境监察支队缴纳排污费。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;13.本批复文件和有关附件是该项目环境影响审批的法律文件，根据《中华人民共和国环境影响评价法》有关规定，自批复之日起超过五年方决定项目开工建设的，其批复文件须报我局重新审核。<br />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;14.本审查批复的各项环境保护事项必须执行，如有违反将依法追究法律责任。<br /><br />
								<p align="right">深圳市环境保护局</p><br />
								<p align="right">二〇〇五年十月十八日</p>
								</p>
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