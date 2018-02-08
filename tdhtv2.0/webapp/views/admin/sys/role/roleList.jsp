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
<title>角色管理</title>
<style type="text/css">
.table-list th{
    background:url(../../resources/img/tablelist_th_110525.gif) right 0 no-repeat;
}
</style>
<script type="text/javascript">
	//进入添加界面
	function add(){
		document.myform.action = "../sysRoles/add";
		document.myform.submit();
	}
	//全选反选
	function checkall(){
		selectSelections('checkall','roleId');
	}
	//刷新
	function reload(){
		location.reload();
		clearSelections("roleId");
	}
	//权限弹出层
	function openWin(id){
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		var checkedNodes = treeObj.getCheckedNodes(true);
		for(var i = 0 ; i < checkedNodes.length ; i++){
			treeObj.checkNode(checkedNodes[i], false, false, false);
		}
		$("#roleid2").val(id);
		document.getElementById("popwin").style.display = "block";
		document.getElementById("mask").style.display = "block";
		$.ajax({
            type: 'POST',//请求方式
            url: '../sysRoleMenu/queryRoleMenuByRoleIdToJson',//请求的action路径
            data: "roleId="+id,//请求参数
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
	        var ids = getSelections("roleId");
			if(ids.length == 0){
				infoMsg("请选择要删除的数据!");
				return;
			}
	        confirmMsg('确定删除这'+ids.length+'条数据?',function(res){
	        	if(res){
	        		$.ajax({
		                type: 'POST',//请求方式
		                url: '../sysRoles/del',//请求的action路径
		                data: "ids="+$.toJSON(ids),//请求参数
		                dataType: 'json',//返回参数类型
		                error: function () {//请求失败处理函数
		                    errorMsg('请求失败');
		                },
		                success: function (data) { //请求成功后处理函数。
		                    if(data.success){
		                        location.reload();
		                        clearSelections("roleId");
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
			var ids = getSelections("roleId");
			if(ids.length == 0){
				infoMsg("请选择要编辑的数据!");
				return;
			}else if(ids.length > 1){
				infoMsg("只能选择一行要编辑的数据!");
				return;
			}else{
				$("#roleId").val(ids);
				document.myform.action="../sysRoles/edit";
				document.myform.submit();
			}
		});
		
		//设置权限
		$("#add-btn").click(function () {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getCheckedNodes(true);
			var ids = [];
			for (var i=0, l=nodes.length; i<l; i++) {
				ids.push(nodes[i].id);
			}
			$.ajax({
                type: 'POST',//请求方式
                url: '../sysRoleMenu/setRoleMenu',//请求的action路径
                data: "ids="+$.toJSON(ids)+"&roleid="+$("#roleid2").val(),//请求参数
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
		
		//初始化权限菜单列表
		$.ajax({
            type: "POST",
            url:"../sysMenu/queryMenuListJson",
            dataType: 'json',
            error: function(request) {
            	infoMsg("请求失败");
            },
            success: function(data) {
            	$.fn.zTree.init($("#treeDemo"), setting, data);
            }
        });
		
	});
</script>
</head>
<body>
	<form id="myform" name="myform" method="post">
		<input type="hidden" id="roleId" name="roleId"/>
	</form>
	<p style="padding:4px 5px 9px; height:16px;line-height:16px;"><strong class="f14 text-title">角色管理</strong></p>
	<div id="toolbar">
		<div class="toolbar">
			<input name="refresh" onclick="reload();" type="button" class="btn wd50" value="刷新"/>
			<span class="toolbar-space"></span>
			<input name="add" onclick="add();" type="button" class="btn wd85" value="添加角色" />
			<input id="edit-btn" name="edit" type="button" class="btn wd80" value="编辑角色" />
			<input id="delete-btn" name="delete" type="button" class="btn wd50" value="删除" />
		</div>
		<!-- <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list table-header">
		</table> -->
	</div>

	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table-list" id="table" >
		<thend>
			<tr>
				<th width="30"><input id="checkall" onclick="checkall();" name="checkall" type="checkbox" /></th>
				<th  align="left" width="150">
					<div class="td-space">角色名称<span class="sort-label"></div>
				</th>
				<th align="left" width="150">
					<div class="td-space">角色编号<span class="sort-label"></div>
				</th>
				<th  align="left" width="150">
					<div class="td-space">角色分类<span class="sort-label"></div>
				</th>
				<th  align="left" width="100">
					<div class="td-space">有效<span class="sort-label"></div>
				</th>
				<th  align="left">
					<div class="td-space">描述<span class="sort-label"></div>
				</th>
				<th width="200" align="left" ><div class="td-space">操作</div></th>
			</tr>
		</thend>
		<tbody>
		<c:forEach items="${sysRoless }" var="bean">
			<tr>
				<td class="td-first" width="30" align="center">
					<input type="checkbox" value="${bean.roleId }" id="${bean.roleId }" name="roleId">
				</td>
				<td width="150"><div class="td-space">${bean.fullName }</div></td>
				<td width="150"><div class="td-space">${bean.code }</div></td>
				<td width="150"><div class="td-space"><c:if test="${bean.category == 1}">系统角色</c:if><c:if test="${bean.category == 2}">业务角色</c:if></div></td>
				<td width="100"><div class="td-space"><c:if test="${bean.enabled == 1}">有效</c:if><c:if test="${bean.enabled == 0}">无效</c:if></div></td>
				<td><div class="td-space">${bean.description }</div></td>
				<td width="200">
					<div class="td-space">
						<a onclick="openWin('${bean.roleId}');" href="javascript:void(0)">[设置权限]</a> 
					</div>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<div id="pagelist">
		<ul style="list-style:none;">
			<pg:pager items="${pager.rowCount}"
			export="currentPageNumber=pageNumber" maxPageItems="${pager.pageSize }" maxIndexPages="5" url="../sysRoles/rolesList" >
				<!-- 首页 -->
				<pg:first>
					<li style="list-style:none;"><a href="${pageUrl }" style="color:#333; text-decoration:none;">首页</a></li>
				</pg:first>
				<pg:prev>
					<li style="list-style:none;"><a href="${pageUrl }" style="color:#333; text-decoration:none;">前一页</a></li>
				</pg:prev>
				<pg:pages>
					<c:choose>
						<c:when test="${currentPageNumber eq pageNumber }">
							<li style="list-style:none;background:#a9d2ff; display:block; padding:0px 6px; font-weight:bold;">${pageNumber }</li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl }" style="list-style:none;color:#333; text-decoration:none;">${pageNumber }</a></li>
						</c:otherwise>
					</c:choose>
				</pg:pages>
				<pg:next>
					<li style="list-style:none;"><a href="${pageUrl }" style="color:#333; text-decoration:none;">后一页</a></li>
				</pg:next>
				<pg:last>
					<li style="list-style:none;"><a href="${pageUrl }" style="color:#333; text-decoration:none;">尾页</a></li>
				</pg:last>
		    <li style="list-style:none;color:#555;" class="pageinfo">共${pager.pageCount}页</li>
		    <li style="list-style:none;color:#555;" class="pageinfo">共${pager.rowCount}条记录</li>
			</pg:pager>
  		</ul>
	</div>
	
	<div id="btm-bar" class="list-btm-bar"></div>
	
	<!-- 遮罩层 -->
	<div id="mask" class="mask" style="z-index: 8000; display: none; position: fixed;"></div>
	<!-- 设置权限 弹出层 -->
	<div class="window" id="popwin" style="position: absolute; z-index: 8001; display: none; padding: 0px; margin: 0px; top: 164.5px; left: 471.5px;width: 400px; ">
		<form method="post" id="myform2" name="myform2">
			<div class="window-header">
				<div class="tool" style="top:6px;">
					<a href="javascript:void(0)" class="close" style="background:url(${ctx}/resources/img/icon_skin_0.gif) no-repeat -48px -16px;" onclick="javascript:document.getElementById('popwin').style.display='none';document.getElementById('mask').style.display = 'none';"  title="关闭"><em>关闭</em></a>
				</div>
				<div class="window-header-text"><strong>设置权限</strong></div>
			</div>
			<div class="window-body">
				<input type="hidden" value="" name="roleid" id="roleid2">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
			<div class="window-footer">
				<input id="add-btn" type="button" value="确定" class="btn">
				<input type="button" value="关闭" class="btn" name="close" onclick="javascript:document.getElementById('popwin').style.display='none';document.getElementById('mask').style.display = 'none';">
			</div>
		</form>
	</div>

</body>
<script type="text/javascript">
	document.onkeydown=function(event){
	    var e = event || window.event || arguments.callee.caller.arguments[0];
	    if(e && e.keyCode==27){ // 按 Esc 
	    	document.getElementById('popwin').style.display='none';
	    	document.getElementById('mask').style.display = 'none';
	    }
	}; 
</script>
</html>