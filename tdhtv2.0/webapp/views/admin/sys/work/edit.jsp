<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_3.css" id="css-skin" rel="stylesheet" type="text/css" >
<title>用户管理</title>
<script type="text/javascript">
	
	//验证表单
	function checkForm(){
		if(!checkStrLength("code", 50, "编号")){
			return false;
		}
		if(!checkStr("realName", 50, "姓名")){
			return false;
		}
		if(!checkStr("account", 50, "登录账户")){
			return false;
		}
		if(!checkStr("password", 50, "密码")){
			return false;
		}
		if(!checkStrLength("mobile", 200, "手机")){
			return false;
		}
		if(!checkStrLength("email", 200, "电子邮件")){
			return false;
		}
		if(!checkStrLength("description", 200, "描述")){
			return false;
		}
		return true;
	}

	$(document).ready(function () {
		//修改
		$("#edit-btn").click(function () {
			if(checkForm()){
				$.ajax({
	                type: "POST",
	                url:"../sysUser/editSave",
	                data:$('#myform').serialize(),
	                dataType: 'json',
	                error: function(request) {
	                	infoMsg("提交失败");
	                },
	                success: function(data) {
	                	if(data.success){
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
		window.location.href = "../sysUser/userList";		
	}
	
		
</script>
</head>
<body>

<div class="title-bar"><strong class="f14 text-title">编辑用户</strong> | <a href="#" onclick="back()">返回</a></div>
<form id="myform" name="myform" method="post">
	<input type="hidden" name="userId" value="${sysUser.userId }" >
    <table id="user-base" border="0" cellspacing="2" cellpadding="3" class="table-form table-form-f12" style="margin-top:20px;">
        <tr>
            <th width="110" align="right"><label for="name">编号：</label></th>
            <td><input name="code" type="text" class="text" id="code" value="${sysUser.code }" style="width:250px" /></td>
        </tr>
        <tr>
            <th align="right"><label for="name">姓名[*]：</label></th>
            <td><input name="realName" type="text" class="text" id="realName" value="${sysUser.realName }" style="width:250px" /></td>
        </tr>
        <tr>
            <th align="right"><label for="name">登录账户[*]：</label></th>
            <td><input name="account" type="text" class="text" id="account" value="${sysUser.account }" style="width:250px" /></td>
        </tr>
        <tr>
            <th align="right"><label for="password">登录密码[*]：</label></th>
            <td><input name="password" type="password" class="text" id="password" value="${sysUser.password }" style="width:250px" /></td>
        </tr>
        <tr>
            <th align="right">性别[*]：</th>
            <td>
            	<select name="gender" style="width:250px;">
            		<option value="1" <c:if test="${sysUser.gender == 1 }"> selected="selected" </c:if> >男</option>
            		<option value="0" <c:if test="${sysUser.gender == 0 }"> selected="selected" </c:if>>女</option>
            	</select>
            </td>
        </tr>
        <tr>
            <th align="right"><label for="name">手机：</label></th>
            <td><input name="mobile" type="text" class="text" id="mobile" value="${sysUser.mobile }" style="width:250px" /></td>
        </tr>
        <tr>
            <th align="right"><label for="name">电子邮件：</label></th>
            <td><input name="email" type="text" class="text" id="email" value="${sysUser.email }" style="width:250px" /></td>
        </tr>
        <tr>
            <th align="right"><label for="name">选项[*]：</label></th>
            <td>
            	<input type="checkbox" name="enabled" value="1" <c:if test="${sysUser.enabled == 1 }"> checked="checked" </c:if> >有效
            </td>
        </tr>
        <tr>
            <th align="right"><label for="name">描述：</label></th>
            <td><textarea rows="3" cols="40" id="description" name="description">${sysUser.description }</textarea></td>
        </tr>
    </table>
    <div class="tool-btm" >
    	<div class="toolbar">
    		<input type="button" id="edit-btn" class="btn wd50" value="提 交"/>
    		<input type="button" id="cancel-btn" onclick="back()" class="btn wd50" value="取 消"/>
    	</div>
    </div>
	<p id="sys-msg" class="msg" style="display: none;">
		<span id="msg-info" class="error"></span>
	</p>
</form>
</body>
</html>