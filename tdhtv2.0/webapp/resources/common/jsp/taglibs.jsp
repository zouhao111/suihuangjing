<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- 通用标签 -->
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<!-- 通用变量 -->
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="user" value="${sessionScope.CURRENT_USER}" />
<c:set var="webCompany" value="${sessionScope.web_company}" />
<meta http-equiv="X-UA-Compatible" content="IE=8"/>
<!-- Jquery -->
<script type="text/javascript" src="${ctx}/resources/common/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-1.4.4.js"></script>

<!-- jquery alert -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/jquery.alert.v1.2/jquery.alert.css"/>
<script type="text/javascript" src="${ctx}/resources/jquery.alert.v1.2/jquery.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery.alert.v1.2/jquery.easydrag.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery.alert.v1.2/jquery.alert.js"></script>

<script src="${ctx}/resources/js/common.js"	type="text/javascript"></script>
<script src="${ctx}/resources/common/js/common.js"	type="text/javascript"></script>

<!-- jquery-easyui -->
<script type="text/javascript">
<!--easyui封装的提醒消息-->
function infoMsg(msg,fun)
{
	$.alerts.okButton="确定";
	jAlert(msg,'提示');
}
function errorMsg(msg)
{
	$.alerts.okButton="确定";
	jAlert(msg,'提示');
}
function warningMsg(msg,fun)
{
	$.messager.alert('警告提醒',msg,'warning',fun);
}
function confirmMsg(msg,fun)
{
	jConfirm(msg, '提示',fun);
}
function showMsg(msg,fun)
{
	$.messager.alert({
		showType:'slide',   //定义如何将显示消息窗口。可用的值是：null,slide,fade,show。默认值是slide。
		showSpeed:'600',    //定义消息窗口完成的时间（以毫秒为单位）， 默认值600。
		width:'250',        //定义消息窗口的宽度。 默认值250。
		height:'100',       //定义消息窗口的高度。 默认值100。
		msg:msg,            //定义显示的消息文本。
		title:'友情提醒',   //定义显示在标题面板显示的标题文
		timeout:'500'       //如果定义为0，消息窗口将不会关闭，除非用户关闭它。如果定义为非0值，当超时后消息窗口将
	});
} 
function showMsgInfo(msg){
	  var objig = document.getElementById("sys-msg");
	  $("#msg-info").html(msg);
	  objig.style.display = 'block';
	  setTimeout(function(){
	    objig.style.display = 'none';
	  }, 2000);
}
</script>

