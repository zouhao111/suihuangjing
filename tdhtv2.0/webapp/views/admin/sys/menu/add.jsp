<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_3.css" id="css-skin" rel="stylesheet" type="text/css" >

<link rel="stylesheet" href="${ctx}/resources/ztree/css/demo.css" type="text/css">
<link rel="stylesheet" href="${ctx}/resources/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/resources/ztree/js/jquery.ztree.core-3.5.js"></script>
<title>模块管理</title>
<script type="text/javascript">

	var setting = {
		view: {
			dblClickExpand: false,
			selectedMulti:false
		},
		data: {
			simpleData: {
			enable: true
			}
		},
		callback: {
			onClick: onClick
		}
	};
	
	function onClick(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("menuTree"),
		nodes = zTree.getSelectedNodes(),
		v = "",
		ids = "";
		nodes.sort(function compare(a,b){return a.id-b.id;});
		for (var i=0, l=nodes.length; i<l; i++) {
			v += nodes[i].name + ",";
			ids += nodes[i].id + ",";
		}
		if (v.length > 0 ) v = v.substring(0, v.length-1);
		if (ids.length > 0 ) ids = ids.substring(0, ids.length-1);
		var cityObj = $("#menuName");
		cityObj.attr("value", v);
		$("#parentId").val(ids);
		hideMenu();
	}

	function showMenu() {
		var cityObj = $("#menuName");
		var cityOffset = $("#menuName").offset();
		$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	}
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
			hideMenu();
		}
	}
	
	function selectMaxSortCode(){
		//查询排序最大值
		$.ajax({
            type: "POST",
            url:"../sysMenu/selectMaxSortCode",
            dataType: 'text',
            error: function(request) {
            	infoMsg("请求失败");
            },
            success: function(data) {
            	$("#sortCode").val(data);
            }
        });
	}
	
	//验证表单
	function checkForm(){
		if(!checkStr("fullName", 50, "模块名称")){
			return false;
		}
		if(!checkStrLength("code", 50, "编号")){
			return false;
		}
		if(!checkStrLength("navigateUrl", 200, "Web链接地址")){
			return false;
		}
		if(!checkNum("sortCode", 11, "显示顺序")){
			return false;
		}
		if(!checkStrLength("description", 200, "描述")){
			return false;
		}
		return true;
	}

	$(document).ready(function () {
		//新增
		$("#add-btn").click(function () {
			if(checkForm()){
				$.ajax({
	                type: "POST",
	                url:"../sysMenu/addSave",
	                data:$('#myform').serialize(),
	                dataType: 'json',
	                error: function(request) {
	                	infoMsg("提交失败");
	                },
	                success: function(data) {
	                	if(data.success){
	                		$('#myform')[0].reset(); 
	                		selectMaxSortCode();
	                		infoMsg(data.msg);
	                	}else{
	                		infoMsg(data.msg);
	                	}
	                }
	            });
			}
		});
		
		//加载上级模块列表 
		$.ajax({
            type: "POST",
            url:"../sysMenu/menuListJsonForAdd",
            dataType: 'json',
            error: function(request) {
            	infoMsg("请求失败");
            },
            success: function(data) {
            	$.fn.zTree.init($("#menuTree"), setting, data);
            }
        });
		
		selectMaxSortCode();
		
	});
	
	function back(){
		window.location.href = "../sysMenu/menuList";		
	}


</script>
</head>
<body>

<div class="title-bar"><strong class="f14 text-title">新增模块</strong> | <a href="#" onclick="back()">返回</a></div>
<form id="myform" name="myform" method="post">
    <table id="user-base" border="0" cellspacing="2" cellpadding="3" class="table-form table-form-f12" style="margin-top:20px;">
        <tr>
            <th width="110" align="right"><label for="name">模块名称[*]：</label></th>
            <td><input id="fullName" name="fullName" type="text" class="text" value="" style="width:250px" /></td>
        </tr>
        <tr>
            <th align="right"><label for="name">模块编号：</label></th>
            <td><input id="code" name="code" type="text" class="text"  value="" style="width:250px" /></td>
        </tr>
        <tr>
            <th align="right"><label for="name">上级模块：</label></th>
            <td>
            	<input id="menuName" type="text" readonly value="" style="width:250px;" onclick="showMenu();"/>
            	<input id="parentId" name="parentId" type="hidden" value="0">
            </td>
        </tr>
        <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
			<ul id="menuTree" class="ztree" style="margin-top:0; width:240px;"></ul>
		</div>
        <tr>
            <th align="right">连接目标[*]：</th>
            <td><select name="target" style="width:250px;"><option value="Click" selected="selected">Click</option><option value="Iframe">Iframe</option></select></td>
        </tr>
        <tr>
            <th align="right"><label for="name">Web链接地址：</label></th>
            <td><input id="navigateUrl" name="navigateUrl" type="text" class="text"  value="" style="width:250px" /></td>
        </tr>
        
        <tr>
            <th align="right"><label for="name">显示顺序[*]：</label></th>
            <td><input id="sortCode" name="sortCode" type="text" class="text"  value="" style="width:250px" /></td>
        </tr>
        <tr>
            <th align="right"><label for="name">选项[*]：</label></th>
            <td>
            	<input type="checkbox" name="enabled" value="1" checked="checked" >有效
            </td>
        </tr>
        <tr>
            <th align="right"><label for="name">描述：</label></th>
            <td><textarea rows="3" cols="30" id="description" name="description"></textarea></td>
        </tr>
    </table>
    <div class="tool-btm" >
    	<div class="toolbar">
    		<input type="button" id="add-btn" class="btn wd50" value="提 交"/>
    		<input type="button" id="cancel-btn" onclick="back()" class="btn wd50" value="取 消"/>
    	</div>
    </div>
   
	<p id="sys-msg" class="msg" style="display: none;">
		<span id="msg-info" class="error"></span>
	</p>
</form>
</body>
</html>