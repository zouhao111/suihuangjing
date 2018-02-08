<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<!--[if IE 9]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if IE 8]>

<link href="${ctx}/resources/css/ie8.css"	type="text/css" rel="stylesheet" />
<![endif]-->
<!--[if  IE 7]>
<link href="${ctx}/resources/css/ie7.css"	type="text/css" rel="stylesheet" />
<![endif]-->


<script type="text/javascript" src="${ctx}/resources/js/left/jquery.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/resources/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/resources/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-ui-jqLoding.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/Newdata.js"></script>

<title>实时监测数据</title>
<style>
*{
font-family:微软雅黑;
}
</style>

<script type="text/javascript">
	
	
	$(document).ready(function () {
		
		 $("tr:even").addClass("over");
		  //点击变色  
		  $("#table tbody tr").toggle(
			   function(){
			    $(this).addClass("focus");
			    	$(this).find(":checkbox").attr("checked",true);
			   },function (){
			   $(this).removeClass("focus");
			  	$(this).find(":checkbox").attr("checked",false);
			  }
			  );
		  $('#table tbody tr :checkbox').click(function(event) {
			  event.stopPropagation();
			  if(this.checked){
				  $(this).parent.parent.addClass("focus");
			  }else{
				  $(this).parent.parent.removeClass("focus");
			  }
		  });
		  
		var url=  $("#webUrls").val();
		//console.log(url)
		
		
		var rid= $("#rid").val();
		load_newdata(rid);
		
		
		 var tiimer=setInterval(function() {
     load_newdata(rid);
     
      
}, 30000);
 $(this).jqLoading("destroy"); 
	});
</script>

<script type="text/javascript">
	
	
	//查询
	function findReport(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../reportForm/reportFormList";
		document.myform.submit();
	}

	//清空   
	 function cls(){
	
		   var sum=0;
		   var t = document.getElementsByTagName("INPUT");
		   for (var i=0; i <t.length;i++){   
		  if (t[i].type=='text'){   
		    ++sum; 
		    t[i].value="";
		  }
		   }
	 }
	
</script>
</head>
<body class="body_overflow">
	<input id="webUrls" type="hidden" value="${webUrls}" >
	<input id="rid" type="hidden"  value="${viewCompanyconfig.rid}" >
	<div style="border-bottom: 1px solid #000;">
	<p class="f14style" ><span class="f14 text-title" >${viewCompanyconfig.companyName}实时监测数据</span></p>
	</div>
	<div class="table2excel bluestrip">
		<table width="100%"  border="0" cellspacing="0" cellpadding="0" class="table-list" id="table"  >
			<thead >
					<tr >
						<th width="30" height="30px" rowspan="2"  align="center"  class="fontstyle">监测单元名称</th>
						<th width="30" height="30px"rowspan="2"  align="center" class="fontstyle">监测单元编号 </th>
						<th width="80" height="30px"colspan="4" align="center" class="fontstyle">流量监测数据（m3）</th>
						<th width="130" height="30px"colspan="5" align="center" class="fontstyle">水质监测数据</th>
					</tr>
					<tr>
						<th width="100" height="30px"align="center"class="fontstyle2" >工业给水(m<sup>3</sup>)</th>
						<th width="100" height="30px"align="center"class="fontstyle2">生活给水(m<sup>3</sup>)</th>
						<th width="100" height="30px"align="center"class="fontstyle2">工业排水(m<sup>3</sup>)</th>
						<th width="100" height="30px"align="center"class="fontstyle2">生活排水(m<sup>3</sup>)</th>
						<th width="130" height="30px"align="center"class="fontstyle2">PH值</th>
						<th width="150"height="30px" align="center"class="fontstyle2">电导率（μS/cm）</th>
						<th width="150" height="30px"align="center"class="fontstyle2">COD(mg/l)</th>
						<th width="150" height="30px"align="center"class="fontstyle2">氨氮(mg/l)</th>
						<th width="150" height="30px"align="center"class="fontstyle2">六价铬(mg/l)</th>
					</tr>
					</thead>
					<thead id="newData">
					<tr  height="40px">
						
					</tr>
			</thead>
			
	</table> 
       <div  style="font-size: 15px;margin-top: 20px">备注:   表中灰色代表该公司有预警或者报警值,<span style="color:red">红色</span>代表报警,<span style="color:orange;">黄色</span>代表预警
 			 </div>
	</div>
	<!--<button id="btn" class="btn btn-primary">点击这里将表格内容导出到excel中</button>
	-->

<script src="${ctx}/resources/js/jquery.table2excel.js"></script>
<script>
		$(function() {
			$("#btn").click(function(){
				$(".table2excel").table2excel({
					exclude: ".noExl",
					name: "Excel Document Name",
					filename: "myFileName",
					exclude_img: true,
					exclude_links: true,
					exclude_inputs: true
				});
			});
			
		});
	</script>
</body>

</html>