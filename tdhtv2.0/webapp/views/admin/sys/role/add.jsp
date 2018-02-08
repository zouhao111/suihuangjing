<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_3.css" id="css-skin" rel="stylesheet" type="text/css" >
<title>角色管理</title>
<script type="text/javascript">

	
	
	//验证表单
	function checkForm(){
		if(!checkStrLength("code", 50, "编号")){
			return false;
		}
		if(!checkStr("fullName", 50, "角色名称")){
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
	                url:"../sysRoles/addSave",
	                data:$('#myform').serialize(),
	                dataType: 'json',
	                error: function(request) {
	                	infoMsg("提交失败");
	                },
	                success: function(data) {
	                	if(data.success){
	                		$('#myform')[0].reset(); 
	                		infoMsg(data.msg);
	                	}else{
	                		infoMsg(data.msg);
	                	}
	                }
	            });
			}
			
		});
	});
	
	function back(){
		window.location.href = "../sysRoles/rolesList";		
	}
	
	
	
		
</script>
</head>
<body>
<div class="title-bar"><strong class="f14 text-title">添加角色</strong> | <a href="#" onclick="back()">返回</a></div>
<form id="myform" name="myform" method="post">
    <table id="user-base" border="0" cellspacing="2" cellpadding="3" class="table-form table-form-f12" style="margin-top:20px;">
        <tr>
            <th width="110" align="right"><label for="name">编号：</label></th>
            <td><input name="code" type="text" class="text" id="code" value="" style="width:250px" /></td>
        </tr>
        <tr>
            <th align="right"><label for="name">角色名称[*]：</label></th>
            <td><input name="fullName" type="text" class="text" id="fullName" value="" style="width:250px" /></td>
        </tr>
        <tr>
            <th align="right"><label for="name">角色分类[*]：</label></th>
            <td>
            	<select id="category" name="category" style="width:250px;">
            		<option value="1" selected="selected">系统角色</option>
            		<option value="2">业务角色</option>
            	</select>
            </td>
        </tr>
        <tr>
            <th align="right"><label for="name">选项[*]：</label></th>
            <td>
            	<input type="checkbox" name="enabled" value="1" checked="checked" >有效
            </td>
        </tr>
        <tr>
            <th align="right"><label for="name">描述：</label></th>
            <td><textarea rows="3" cols="40" id="description" name="description"></textarea></td>
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