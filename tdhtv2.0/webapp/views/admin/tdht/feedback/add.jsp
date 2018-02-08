<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_3.css" id="css-skin" rel="stylesheet" type="text/css" >
<title>用户反馈</title>
<script type="text/javascript">
	
	//验证表单
	function checkForm(){
		
		if(!checkStrLength("title", 50, "标题")){
			return false;
		}
		if(!checkStrLength("content", 500, "描述")){
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
	                url:"../feedback/saveFeedback",
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
		window.location.href = "../sysUser/userList";		
	}
	
		
</script>
</head>
<body>

<div class="title-bar"><strong class="f14 text-title">意见反馈</strong></div>
<form id="myform" name="myform" method="post">
    <table id="user-base" border="0" cellspacing="2" cellpadding="3" class="table-form table-form-f12" style="margin-top:20px;">
        <tr>
            <th width="110" align="right"><label for="name">标题：</label></th>
            <td><input name="title" type="text" class="text" id="title" value="" style="width:250px" /></td>
        </tr>
        
        <tr>
            <th align="right"><label for="name">描述：</label></th>
            <td><textarea rows="10" cols="40" id="content" name="content"></textarea></td>
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