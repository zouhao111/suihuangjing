<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />
<script type="text/javascript" src="${ctx}/resources/common/jquery/jquery.json-2.4.min.js"></script>
<link rel="stylesheet" href="${ctx}/resources/ztree/css/demo.css" type="text/css">
<link rel="stylesheet" href="${ctx}/resources/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/resources/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/resources/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<link href="${ctx}/resources/css/pager.css"	type="text/css" rel="stylesheet" />

<title>用户管理</title>
<style type="text/css">
.table-list th{
    background:url(../../resources/img/tablelist_th_110525.gif) right 0 no-repeat;
}


</style>
<script type="text/javascript">
	//进入添加界面
	function add(){
		document.myform.action = "../sysUser/add";
		document.myform.submit();
	}
	//全选反选
	function checkall(){
		selectSelections('checkall','userid');
	}
	//刷新
	function reload(){
		location.reload();
		clearSelections("userid");
	}
	
	$(document).ready(function () {
		
		 $("tr:even").addClass("over");
		  //$("tr:odd").addClass("over");
		  //点击变色 
		  $("#table tbody tr").toggle(
			   function(){
			    $(this).addClass("focus");
			    
			    //alert($(this).find(":checkbox").attr("checked"));
			    
			   // if(!$(this).find(":checkbox").attr("checked")){
			    	$(this).find(":checkbox").attr("checked",true);
			   // }
			    //$(this).find(":checkbox").attr("checked", !$(this).find(":checkbox").attr("checked"));  
			   },function (){
			   $(this).removeClass("focus");
			  	$(this).find(":checkbox").attr("checked",false);
			   //$(this).find(":checkbox").attr("checked", !$(this).find(":checkbox").attr("checked"));  
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
		
		
	
		//删除
		$("#delete-btn").click(function () {
			//获取选中的数据
	        var ids = getSelections("userid");
			if(ids.length == 0){
				infoMsg("请选择要删除的数据!");
				return;
			}
	        confirmMsg('确定删除这'+ids.length+'条数据?',function(res){
	        	if(res){
	        		$.ajax({
		                type: 'POST',//请求方式
		                url: '../sysUser/del',//请求的action路径
		                data: "ids="+$.toJSON(ids),//请求参数
		                dataType: 'json',//返回参数类型
		                error: function () {//请求失败处理函数
		                    errorMsg('请求失败');
		                },
		                success: function (data) { //请求成功后处理函数。
		                    if(data.success){
		                        location.reload();
		                        clearSelections("userid");
		                    }else
		                    {
		                        errorMsg(data.msg);
		                    }
		                }
		            });
	        	}
	        });
		});
		
		//编辑
		$("#edit-btn").click(function () {
			var ids = getSelections("userid");
			if(ids.length == 0){
				infoMsg("请选择要编辑的数据!");
				return;
			}else if(ids.length > 1){
				infoMsg("只能选择一行要编辑的数据!");
				return;
			}else{
				$("#userId").val(ids);
				document.myform.action="../sysUser/edit";
				document.myform.submit();
			}
				
		});
		
	});
</script>
<script type="text/javascript">
	
	//树初始参数
	var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};
	
	//角色弹出层 
	function openWin(id){
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var checkedNodes = treeObj.getCheckedNodes(true);
		for(var i = 0 ; i < checkedNodes.length ; i++){
			treeObj.checkNode(checkedNodes[i], false, false, false);
		}
		$("#userid2").val(id);
		document.getElementById("popwin").style.display = "block";
		document.getElementById("mask").style.display = "block";
		//默认选中该用户拥有的角色
		$.ajax({
            type: 'POST',//请求方式
            url: '../sysUserRole/queryUserRoleByUserIdToJson',//请求的action路径
            data: "userId="+id,//请求参数
            dataType: 'json',//返回参数类型
            error: function () {//请求失败处理函数
                errorMsg('请求失败');
            },
            success: function (data) { //请求成功后处理函数。
                if(data.length > 0){
	        		var nodes = treeObj.getCheckedNodes(false);
	        		
	        		//以下是处理IE中indexOf不兼容的定义方法
	        		if(!Array.indexOf){
		        		Array.prototype.indexOf = function(obj){
			        		for(var i=0; i<this.length; i++){
				        		if(this[i]==obj){
				        			return i;
				        		}
				        	}
			        		return -1;
		        		}
	        		}
	        		
	        		for(var i = 0 ; i < nodes.length ; i++){
	        			if(data.indexOf(nodes[i].id) > -1){
	        				treeObj.checkNode(nodes[i], true, false, false);
	        			}
	        		}
                }
            }
        });
	}
	
	$(document).ready(function () {
		
		//初始化角色列表
		$.ajax({
            type: "POST",
            url:"../sysRoles/queryRoleListJson",
            dataType: 'json',
            error: function(request) {
            	infoMsg("请求失败");
            },
            success: function(data) {
            	$.fn.zTree.init($("#treeDemo"), setting, data);
            }
        });
		
		//设置角色
		$("#add-btn").click(function () {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getCheckedNodes(true);
			var ids = [];
			for (var i=0, l=nodes.length; i<l; i++) {
				ids.push(nodes[i].id);
			}
			$.ajax({
                type: 'POST',//请求方式
                url: '../sysUserRole/setUserRole',//请求的action路径
                data: "ids="+$.toJSON(ids)+"&userId="+$("#userid2").val(),//请求参数
                dataType: 'json',//返回参数类型
                error: function () {//请求失败处理函数
                    errorMsg('请求失败');
                },
                success: function (data) { //请求成功后处理函数。
                    if(data.success){
                    	infoMsg("保存成功");
                    }else
                    {
                    	infoMsg("保存失败");
                    }
                }
            });
		});
		
	});

</script>
<script type="text/javascript">
	
	
	//权限弹出层 
	function openWin2(id){
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo2");
		var checkedNodes = treeObj.getCheckedNodes(true);
		for(var i = 0 ; i < checkedNodes.length ; i++){
			treeObj.checkNode(checkedNodes[i], false, false, false);
		}
		$("#userid2").val(id);
		document.getElementById("popwin2").style.display = "block";
		document.getElementById("mask").style.display = "block";
		//默认选中该用户拥有的菜单
		$.ajax({
            type: 'POST',//请求方式 
            url: '../sysUserMenu/queryUserMenuByUserIdToJson',//请求的action路径
            data: "userId="+id,//请求参数  
            dataType: 'json',//返回参数类型
            error: function () {//请求失败处理函数
                errorMsg('请求失败');
            },
            success: function (data) { //请求成功后处理函数。
                if(data.length > 0){
	        		var nodes = treeObj.getCheckedNodes(false);
	        		
	        		//以下是处理IE中indexOf不兼容的定义方法
	        		if(!Array.indexOf){
		        		Array.prototype.indexOf = function(obj){
			        		for(var i=0; i<this.length; i++){
				        		if(this[i]==obj){
				        			return i;
				        		}
				        	}
			        		return -1;
		        		}
	        		}
	        		
	        		for(var i = 0 ; i < nodes.length ; i++){
	        			if(data.indexOf(nodes[i].id) > -1){
	        				treeObj.checkNode(nodes[i], true, false, false);
	        			}
	        		}
                }
            }
        });
	}
	
	$(document).ready(function () {
		
		//初始化菜单列表
		$.ajax({
            type: "POST",
            url:"../sysMenu/queryMenuListJson",
            dataType: 'json',
            error: function(request) {
            	infoMsg("请求失败");
            },
            success: function(data) {
            	$.fn.zTree.init($("#treeDemo2"), setting, data);
            }
        });
		
		//设置权限
		$("#add-btn2").click(function () {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo2"),
			nodes = zTree.getCheckedNodes(true);
			var ids = [];
			for (var i=0, l=nodes.length; i<l; i++) {
				ids.push(nodes[i].id);
			}
			$.ajax({
                type: 'POST',//请求方式
                url: '../sysUserMenu/setUserMenu',//请求的action路径
                data: "ids="+$.toJSON(ids)+"&userId="+$("#userid2").val(),//请求参数
                dataType: 'json',//返回参数类型
                error: function () {//请求失败处理函数
                    errorMsg('请求失败');
                },
                success: function (data) { //请求成功后处理函数。
                    if(data.success){
                    	infoMsg("保存成功");
                    }else
                    {
                    	infoMsg("保存失败");
                    }
                }
            });
		});
		
	});
	
	//查询
	function findReport(){
		document.myform.action = "../sysUser/userList";
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
<body>
	<form id="myform" name="myform" method="post">
		<input type="hidden" id="userId" name="userId"/>
	
	<p style="padding:4px 5px 9px; height:16px;line-height:16px;"><strong class="f14 text-title">用户管理</strong></p>
	<!--用户姓名：<input type="text" id="realName" name="realName"  value="${cxName}" />
	登录帐号：<input type="text" id="account" name="account"  value="${cxAccount}" />
	<select name="enabled" style="width:50px;"><option value="1" selected="selected">有效</option><option value="0">无效</option></select>
	
	<input name="search" class="btn-big" onclick="findReport();" type="button" value="查询" />
	<input name="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	--></form>
	<div class="title-bar" id="user-title" style="display: none;">
		<strong class="f14 text-title" id="list-title">帐号</strong>（共<span
			id="user-total">0</span>个<span id="user-span-temp">，其中<a
			href="javascript:void(0)" _status="2">临时帐号</a><span id="user-temp">0</span>个
		</span><span id="user-span-disabled">，<a href="javascript:void(0)"
			_status="0">停用帐号</a><span id="user-disabled">0</span>个
		</span><span id="user-span-locked">，<a href="javascript:void(0)"
			_status="locked">锁定帐号</a><span id="user-locked">0</span>个
		</span>）<span id="search-back" style="display: none"> | <a
			href="javascript:void(0)">返回用户列表</a></span>
	</div>
	

	<div id="float-toolbar" class="float-toolbar">
		<div class="toolbar">
			<input name="add" type="button" class="btn wd85" value="添加帐号" />
			<input name="edit" type="button" class="btn wd80" value="帐号编辑" />
			<span class="toolbar-space"></span>
			<input name="delete" type="button" class="btn wd50" value="删除" />
		</div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="table-list table-header">
			<tr>
				<th width="30"><input name="checkall" type="checkbox" /></th>
				<th width="120" align="left"><div class="td-space">
						<a href="javascript:void(0)" name="sort-truename">真实姓名<span
							class="sort-label"></span></a>
					</div></th>
				<th width="270" align="left"><div class="td-space">
						<a href="javascript:void(0)" name="sort-uid">帐号<span
							class="sort-label"></span></a>
					</div></th>
				<th width="95" align="left"><div class="td-space">
						<a href="javascript:void(0)" name="sort-status">帐号状态<span
							class="sort-label"></span></a>
					</div></th>
				<th width="95" align="left"><div class="td-space">
						<a href="javascript:void(0)" name="sort-deptid">所属部门<span
							class="sort-label"></span></a>
					</div></th>
				<th width="95" align="left"><div class="td-space">
						<a href="javascript:void(0)" name="sort-createtime">创建时间<span
							class="sort-label"></span></a>
					</div></th>
				<th class="td-last" align="left"><div class="td-space">所属群组</div></th>
			</tr>
		</table>
	</div>
	
	<div id="toolbar">
		<div class="toolbar">
			<input name="refresh" onclick="reload();" type="button" class="btn wd50" value="刷新"/>
			<span class="toolbar-space"></span>
			<input name="add" onclick="add();" type="button" class="btn wd85" value="添加用户" />
			<input id="edit-btn" name="edit" type="button" class="btn wd80" value="编辑用户" />
			<input id="delete-btn" name="delete" type="button" class="btn wd50" value="删除" />
			<span class="toolbar-space"></span>
		</div>
		<!-- <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list table-header">
			
		</table> -->
	</div>

	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
			<thead>
					<tr>
						<th width="30"><input id="checkall" onclick="checkall();" name="checkall" type="checkbox" /></th>
						<th width="100" align="left"><div class="td-space">编号</div></th>
						<th width="120" align="left"><div class="td-space">登录账户</div></th>
						<th width="120" align="left"><div class="td-space">姓名</div></th>
						<th width="80" align="left"><div class="td-space">性别</div></th>
						<th width="150" align="left"><div class="td-space">手机号码</div></th>
						<th width="80" align="left"><div class="td-space">有效</div></th>
						<th width="120" align="left"><div class="td-space">登录次数</div></th>
						<th  align="left"><div class="td-space">最后登录时间</div></th>
						<th width="200" align="left" ><div class="td-space">操作</div></th>
					</tr>
			</thead>
		<tbody>
		<c:forEach items="${sysUsers }" var="bean">
			<tr >
				<td class="td-first" width="30" align="center">
					<input type="checkbox" value="${bean.userId }" name="userid">
				</td>
				<td width="100"><div class="td-space">${bean.code }</div></td>
				<td width="120"><div class="td-space">${bean.account }</div></td>
				<td width="120"><div class="td-space">${bean.realName }</div></td>
				<td width="80"><div class="td-space"><c:if test="${bean.gender == '1'}">男</c:if><c:if test="${bean.gender == '0'}">女</c:if></div></td>
				<td width="150"><div class="td-space">${bean.mobile }</div></td>
				<td width="80"><div class="td-space"><c:if test="${bean.enabled == 1}">有效</c:if><c:if test="${bean.enabled == 0}">无效</c:if></div></td>
				<td width="120"><div class="td-space">${bean.logOnCount }</div></td>
				<td ><div class="td-space"><fmt:formatDate value="${bean.lastVisit }" pattern="yyyy/MM/dd  HH:mm:ss"/></div></td>
				<td width="200">
					<div class="td-space">
						<a onclick="openWin('${bean.userId}');" href="javascript:void(0)">[设置角色]</a> 
						<!--<a onclick="openWin2('${bean.userId}');" href="javascript:void(0)">[设置权限]</a> 
					--></div>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div id="pagelist">
		<ul style="list-style:none;">
			<pg:pager items="${pager.rowCount}"
			export="currentPageNumber=pageNumber" maxPageItems="${pager.pageSize }" maxIndexPages="5" url="../sysUser/userList" >
				<!-- 首页 -->
				<pg:first>
					<li style="list-style:none;"><a href="${pageUrl }" class="page_btn">首页</a></li>
				</pg:first>
				<pg:prev>
					<li style="list-style:none;"><a href="${pageUrl }" class="page_btn">前一页</a></li>
				</pg:prev>
				<pg:pages>
					<c:choose>
						<c:when test="${currentPageNumber eq pageNumber }">
							<li class="page_btn_s">${pageNumber }</li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl }" class="page_btn">${pageNumber }</a></li>
						</c:otherwise>
					</c:choose>
				</pg:pages>
				<pg:next>
					<li style="list-style:none;"><a href="${pageUrl }" class="page_btn">后一页</a></li>
				</pg:next>
				<pg:last>
					<li style="list-style:none;"><a href="${pageUrl }" class="page_btn">尾页</a></li>
				</pg:last>
		    <li style="list-style:none;color:#555;" class="page_text">共${pager.pageCount}页</li>
		    <li style="list-style:none;color:#555;" class="page_text">共${pager.rowCount}条记录</li>
			</pg:pager>
  		</ul>
	</div>
	
	<div id="btm-bar" class="list-btm-bar"></div>

	<!-- 遮罩层 -->
	<div id="mask" class="mask" style="z-index: 8000; display: none; position: fixed;"></div>
	<!-- 设置角色 弹出层 -->
	<div class="window" id="popwin" style="position: absolute; z-index: 8001; display: none; padding: 0px; margin: 0px; top: 164.5px; left: 471.5px;width: 400px; ">
		<div class="window-header">
			<div class="tool" style="top:6px;">
				<a href="javascript:void(0)" class="close" style="background:url(${ctx}/resources/img/icon_skin_0.gif) no-repeat -48px -16px;" onclick="javascript:document.getElementById('popwin').style.display='none';document.getElementById('mask').style.display = 'none';"  title="关闭"><em>关闭</em></a>
			</div>
			<div class="window-header-text"><strong>设置角色</strong></div>
		</div>
		<div class="window-body">
			<input type="hidden"  id="userid2">
			<ul id="treeDemo" class="ztree"></ul>
		</div>
		<div class="window-footer">
			<input id="add-btn" type="button" value="确定" class="btn">
			<input type="button" value="关闭" class="btn" name="close" onclick="javascript:document.getElementById('popwin').style.display='none';document.getElementById('mask').style.display = 'none';">
		</div>
	</div>
	
	<!-- 设置权限 弹出层 -->
	<div class="window" id="popwin2" style="position: absolute; z-index: 8001; display: none; padding: 0px; margin: 0px; top: 164.5px; left: 471.5px;width: 400px; ">
		<div class="window-header">
			<div class="tool" style="top:6px;">
				<a href="javascript:void(0)" class="close" style="background:url(${ctx}/resources/img/icon_skin_0.gif) no-repeat -48px -16px;" onclick="javascript:document.getElementById('popwin2').style.display='none';document.getElementById('mask').style.display = 'none';"  title="关闭"><em>关闭</em></a>
			</div>
			<div class="window-header-text"><strong>设置权限</strong></div>
		</div>
		<div class="window-body">
			<ul id="treeDemo2" class="ztree"></ul>
		</div>
		<div class="window-footer">
			<input id="add-btn2" type="button" value="确定" class="btn">
			<input type="button" value="关闭" class="btn" name="close" onclick="javascript:document.getElementById('popwin2').style.display='none';document.getElementById('mask').style.display = 'none';">
		</div>
	</div>
	
</body>
<script type="text/javascript">
	document.onkeydown=function(event){
	    var e = event || window.event || arguments.callee.caller.arguments[0];
	    if(e && e.keyCode==27){ // 按 Esc 
	    	document.getElementById('popwin').style.display='none';
	    	document.getElementById('popwin2').style.display='none';
	    	document.getElementById('mask').style.display = 'none';
	    }
	}; 
</script>
</html>