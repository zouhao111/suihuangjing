/*
	公共方法文件
	@eric
*/
//清空所有复选框
function clearSelections(objname)
{
	var rows = document.getElementsByName(objname);
	for(var i=0; i<rows.length; i++){
        var row = rows[i];
        if(row.checked){
        	row.checked = false;
        }
    }
}
//全选 反选
function selectSelections(obj,objname)
{
	var firstRow = document.getElementById(obj);
	var rows = document.getElementsByName(objname);
	if(firstRow.checked){
		for(var i=0; i<rows.length; i++){
	        rows[i].checked = true;
	    }
	}else{
		for(var i=0; i<rows.length; i++){
	        rows[i].checked = false;
	    }
	}
}
//获得选中的复选框
function getSelections(objname){
    var ids = [];
    var rows = document.getElementsByName(objname);
    for(var i=0; i<rows.length; i++){
        var row = rows[i];
        if(row.checked){
        	ids.push(row.value);
        }
    }
    return ids;
}
//验证字符串的长度
function checkStrLength(id, length, name){
	var val = document.getElementById(id).value;
	if(val != null && val.length > 0){
		if(val.length > length){
			showMsgInfo(name+"的长度不能大于"+length);
			return false;
		}
	}
	return true;
}
//验证字符串不能为空和长度
function checkStr(id, length, name){
	var val = document.getElementById(id).value;
	if(val){
		if(val.length > length){
			showMsgInfo(name+"的长度不能大于"+length);
			return false;
		}
	}else{
		showMsgInfo('请输入'+name);
		return false;
	}
	return true;
}
function checkNum(id, length, name){
	var val = document.getElementById(id).value;
	if(isNaN(val)){
		showMsgInfo(name + '请输入数字');
		return false;
	}else{
		if(val.length > length){
			showMsgInfo(name+"的长度不能大于"+length);
			return false;
		}
	}
	if(val.length < 0){
		showMsgInfo(name + '不能为空');
		return false;
	}
	return true;
}