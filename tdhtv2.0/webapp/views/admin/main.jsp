<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="/resources/common/jsp/taglibs.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />
<title>水污染源及水平衡在线监测系统</title>
<style>
*{  
margin:0;  
padding:0;  
}  
ul{  
list-style:none;  
} 
.nav{  
font-size:16px;  

}  
.nav li{  
float:left;  
margin-right:1px;  
}  
.nav li a{  
text-decoration:none;  
line-height:38px;  
background-color:#3498db;  
color:#FFF;  
display:block;  
width:136px;  
text-align:center;  
}  
.nav li a:hover{  
background-color:#2980b9;  
color:#FFFFFF;  
}  
.nav li ul{  
display:none;  
}  
.nav li ul li{  
margin-top:1px;  
position:relative;  
}  
/*鼠标移到相应元素上显示二级菜单*/  
.nav li:hover ul{  
display:block;  
width:136px;  
}  
.nav li:hover ul li ul{  
display:none;  
}  
.nav li:hover ul li ul li{  
margin-left:1px;  
}  
/*鼠标移到相应二级菜单元素上显示三级菜单*/  
.nav li ul li:hover ul{  
display:block;  
position:absolute;  
top:0px;  
left:136px;  
}  
</style>
<script type="text/javascript">
if (top != self) {
	top.location = self.location.href;
}
</script>
</head>
<body style="padding:0;margin:0">
	<div class="container-top">
	
		<!-- LOGO -->
	    <div class="logo">
	    <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"
			width="1000" height="189" id="1" align="">
			<param name=movie value="${ctx}/resources/flash/1.swf"><param name=quality value=high>
			<embed src="1.swf" quality=high  width="1000" height="189" name="1" align=""
			type="application/x-shockwave-flash" >
			</embed></object>
	    </div>
	    <%--
	    <img src="${ctx}/resources/img/logo.png" border="0" style="margin:10px 0" />
	    <form action="${ctx}/admin/tdht/data/doGet" id="myform" name="myform" method="post" target="main">
	    <div class="quick-link"  style="top:23px;padding-right: 300px; font-size: 18px;font-weight:bold;"><input type="text" name="mainRID" style="width:200px"/>
	    <input name="search" class="btn-big"  type="submit" value="查询" /></div>
	    </form>
	    
	    --%>
	    <!-- 退出 -->
	    <div class="quick-link" style="top:23px;width:150px;">
	        <p><strong>${user.realName}</strong> &lt;${user.account}&gt; | 
				<a href="${ctx}/logout">退出</a>
	    </div>
	</div>
	<!-- 主菜单 -->
	<%--<div class="navigation">
		<a href="${ctx}/admin/index" class="current">首页</a>  
		<c:forEach items="${sys_menus}" var="menu"  varStatus="stats">
			<a id="menua${stats.index}"  href="${ctx}/admin/sys/sysMenu/mainMenu?parentId=${menu.menuId }">${menu.fullName }</a>
		</c:forEach>
	</div>
	--%>
	<%--<div style="width:100%;height:38px;background-color: #3498db;overflow: hidden;">
	<ul class="nav" style="position: absolute;z-index: 999;left:20%;">  
         <li><a href="${ctx}/admin/index" >首页</a></li>  
     	<li><a href="${ctx}/admin/tdht/data/areaHtml?area=baoan" target="main">地图定位</a></li>  
    	<li><a target="main">监测数据</a>  
         <ul>  
          <li><a id="aaaa" name="webUrl" href="${ctx}/admin/tdht/data/dataNew?rid=${webCompany.rid}" target="main">实时数据</a></li>  
          <li><a target="main">历史数据</a>  
             <ul>  
                 <li><a href="${ctx}/admin/sys/sysMenu/minMenu?parentId=209" target="main">日结报表</a>  
                 <li><a href="${ctx}/admin/sys/sysMenu/minMenu?parentId=210" target="main">历史报表</a>  
                 <li><a href="${ctx}/admin/tdht/balance/balanceList?rid=${webCompany.rid}&type=3" target="main">水平衡分析</a>
            </ul>  
          </li>
         </ul>  
     </li>  
     <li><a href="#" target="main">图形曲线</a>  
         <ul>  
          <li><a  target="main">监测曲线</a>  
             <ul>  
                 <li><a href="${ctx}/admin/sys/sysMenu/minMenu?parentId=179" target="main">工业给水</a>  
                 <li><a href="${ctx}/admin/sys/sysMenu/minMenu?parentId=185" target="main">生活给水</a>  
                 <li><a href="${ctx}/admin/sys/sysMenu/minMenu?parentId=167" target="main">工业排水</a>
                 <li><a href="#" target="main">生活排水</a>  
             </ul>  
          </li>  
          <li><a  target="main">曲线分析</a>  
             <ul>  
                 <li><a href="${ctx}/admin/sys/sysMenu/minMenu?parentId=191" target="main">流量汇总</a>  
                 <li><a href="#" target="main">流量系数</a>  
                 <li><a href="#" target="main">流量日结</a>  
            </ul>  
          </li>  
         </ul>  
         
     </li>
     <li><a href="${ctx}/admin/sys/sysMenu/minMenu?parentId=97" target="main">预警报警</a></li>  
     <li><a href="${ctx}/admin/sys/sysMenu/minMenu?parentId=7" target="main">监测单元信息</a></li>
     <c:if test="${webCompany.companyId ==1000}">
     <li><a href="#" target="main">设备管理</a>  
         <ul>
          <li><a href="${ctx}/admin/sys/sysRoles/rolesList" target="main">设备状态</a></li>  
          <li><a href="#" target="main">设备控制</a></li>  
         </ul> 
     </li>
     <li><a href="${ctx}/admin/sys/sysMenu/menuList" target="main">系统管理</a></li>
     </c:if>
</ul>  
	</div>

	
	
	--%><div class="container-main" >
	    <div class="home">
	        <div class="home-right">
	            <div class="user-info-wrap">
	                <div class="user-info">
	                    <div class="info-item user-data">
	                        <div class="info-title"><span>系统特点</span></div>
	                        <p class="info-title" style="text-align: left;">
	                        	&nbsp;&nbsp;TDHT2.0系统立足大数据、云平台、移动应用等互联网+技术。TD2系统具有定时数据监测、远程数据传输、数据存储、历史数据查询、数据分析、实时报警、GPS定位、智能手机监控、远程设防撤防等特点。
	                        </p>
	                    </div>
	                    <div class="info-item user-data">
	                        <div class="info-title"><span>系统功能</span></div>
	                        <p class="info-title" style="text-align: left;">&nbsp;&nbsp;TDHT2.0系统可以同时装配多种在线监测设备，根据目前国内污水行业监测项目要求，TD2系统标配的功能主要有：流量、液位、流速、PH值、在线水质采样等，
	                        	其它功能如：COD、BOD、氨氮、重金属含量等可根据用户的要求选配。</p>
	                    </div>
	                   
	                    <div class="info-item user-data">
	                        <div class="info-title" ><span>应用领域</span></div>
	                        <p class="info-title" style="text-align: left;">
	                        &nbsp;&nbsp;区域管网信息采集系统（TDHT2.0）重要应用于厂矿企业、社区、污水处理厂等区域性用水单位的水量和水质等信息的采集与分析。
	                        </p>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="home-left">
	            <div class="home-pic" style="cursor:pointer" ><div class="home-pic-inner"></div></div>
	            <div class="functional-block">
	                <table border="0" cellspacing="10" cellpadding="0" width="100%">
	                     <tr>
	                        <td><div class="functional-group"><a href="${ctx}/admin/sys/sysMenu/mainMenu?parentId=94" class="png"><p class="functional-title">点位监测</p><span style="line-height:20px">已建地区：共2个</span></a></div></td>
	                        <td><div class="functional-board"><a href="${ctx}/admin/sys/sysMenu/mainMenu?parentId=95" class="png"><p class="functional-title">数据中心</p><span style="line-height:20px">已建公司：共3个</span></a></div></td>
	                        <td><div class="functional-safety"><a href="${ctx}/admin/sys/sysMenu/mainMenu?parentId=96" class="png"><p class="functional-title">图形分析</p><span style="line-height:20px">曲线分析</span></a></div></td>
	                    </tr>
	                     <tr>
	                     	<td><div class="functional-permissions"><a href="${ctx}/admin/sys/sysMenu/mainMenu?parentId=97" class="png"><p class="functional-title">报警记录</p><span style="line-height:20px"></span></a></div></td>
	                        <td><div class="functional-accounts"><a href="${ctx}/admin/sys/sysMenu/mainMenu?parentId=7" class="png"><p class="functional-title">公司管理</p><span style="line-height:20px">帐号数：共1个<br>已开通1个帐号</span></a></div></td>
	                        <td><div class="functional-structure"><a href="${ctx}/admin/sys/sysMenu/mainMenu?parentId=1" class="png"><p class="functional-title">系统管理</p><span style="line-height:20px">已建角色数：共2个</span></a></div></td>
	                        
	                    </tr>
	                </table>
	            </div>
	        </div>
	    </div>
	</div>
	<div class="footer">
	    <%--<a href="#" target="_blank">关于我们</a> |
	    <a href="#" target="_blank">联系我们</a> |
	    <a href="#" target="_blank">隐私保护</a> |
	    <a href="#" target="_blank">版权声明</a> |
	    <a href="#" target="_blank">相关帮助</a>--%>
	    <p>版权所有：深圳市天地互通科技有限公司 | 版本号：TDHTv2.0</p>
	</div>
	
	
</body>
</html>