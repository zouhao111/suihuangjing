<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/skin_8.css" type="text/css" rel="stylesheet" id="css-skin" />
<link rel="StyleSheet" href="${ctx}/resources/tabletree4j/tabletree4j.css" type="text/css" />
<link rel="StyleSheet" href="${ctx}/resources/tabletree4j/menu.css" type="text/css" />
<script type="text/javascript" src="${ctx}/resources/common/jquery/jquery.json-2.4.min.js"></script>
<script language="JavaScript" src="${ctx}/resources/tabletree4j/Core4j.js"></script>
<script language="JavaScript" src="${ctx}/resources/tabletree4j/TableTree4j.js"></script>
<title>模块管理</title>
</head>
<body>
<form id="myform" name="myform" method="post">
	<input type="hidden" id="menuId" name="menuId"/>
</form>
<p style="padding:4px 5px 9px; height:16px;line-height:16px;"><strong class="f14 text-title">模块管理</strong></p>
<div id="toolbar">
<div class="toolbar">
	<input name="refresh" onclick="reload();" type="button" class="btn wd50" value="刷新"/>
	<span cl0000000ass="toolbar-space"></span>
    <input name="create" onclick="add()" type="button" class="btn wd85" value="添加模块"/>
    <input name="edit" onclick="edit()" type="button" class="btn wd80" value="编辑模块" />
    <input name="delete" onclick="del()" type="button" class="btn wd50" value="删除" />
</div>
<div id="worldcupgird" class="content" style="float:left;width:100%;"></div>
<script language="javascript">
dummyJsonData= function(){
this.jsonFIFAHeaders=[{
		  	columns:[
				{dataIndex:'fullName'},
				{dataIndex:'code'},
				{dataIndex:'target'},
				{dataIndex:'navigateUrl'},
				{dataIndex:'enabled'},
				{dataIndex:'sortCode'}
			],
			dataObject:{fullName:'模块名称',code:'模块编码',target:'连接目标',navigateUrl:'Web连接地址',enabled:'有效',sortCode:'排序'},
			trAttributeNames:['classStyle','style'],
			trAttributeValueObject:{classStyle:'headerbg',style:''}
		  }
		];
}

//ExpandNodeEvent
function fifaExpandNodeEvent(node, tree){
	if (node.isLoad == false) {
		tree.startLoadingNode(node);
		alert("This alert is show you the node loading...");
		var userObject=node.userObject;
		if(userObject!=null){
			var jsonName=userObject.jsonName;
			if(jsonName!=null){
				var jsonNodes=eval('new dummyJsonData().'+jsonName);
				if(jsonNodes!=null){
					tree.loadingAddNodes(jsonNodes,node.id);
				}
			}
		}
		tree.endLoadingNode(node);
	}
}
//infoObj {dataValue:,node:,tabletreeObj:,rowObj:,rowIndex:,container:,columnIndex:}
function operateRenderFunction(infoObj){
	var value=infoObj.dataValue;
	var node=infoObj.node;
	var tree=infoObj.tabletreeObj;
	var aElobj=Core4j.Domhelper.createElement("a",{
	attributeNames:['href'],
	valueObject:{href:'#'}
	});
	Core4j.Domhelper.addEventToEl(aElobj,Core4j.Domhelper.ElEventType.CLICK,function(){
		//alert(tree.tableObject.getAttribute("class"));
		//alert("id is ["+value+"] node level is["+node.level+"] islastNode["+node.isLastNode+"]");
		if(node.childs!=null&&node.childs.length>0){
			if(window.confirm("The node[id:"+node.id+"] has childs,are you sure to delete?")){
				tree.removeNode(node.id);
			}
		}else{
			
			if(!node.isLeaf&&node.isLoad==false){
				if(window.confirm("The node[id:"+node.id+"] is unload,maybe has childs,are you sure to delete?")){
				tree.removeNode(node.id);
				}
			}else{
				if(window.confirm("Are you sure to delete the node[id:"+node.id+"]?")){
				tree.removeNode(node.id);
				}
			}

		}
	});
	aElobj.innerHTML="编辑";
	return aElobj;
}

//create and config tabletree object
var fifaGirdTree=new Core4j.toolbox.TableTree4j({
	columns:[
			{isNodeClick:true,dataIndex:'fullName',width:'20%'},
			{dataIndex:'code',width:'5%'},
			{dataIndex:'target',width:'5%'},
			{dataIndex:'navigateUrl'},
			{dataIndex:'enabled',width:'5%'},
			{dataIndex:'sortCode',width:'5%'}
			],
	treeMode:'gird',
	renderTo:'worldcupgird',
	useLine:true,
	useIcon:true,
	id:'myworldcupgirdtree',
	useCookie:true,
	onExpandNodeEvents:[fifaExpandNodeEvent],
	headers:new dummyJsonData().jsonFIFAHeaders,
	//footers:jsonfooters,
	themeName:'default',
	selectMode:'single'
	//floatRight:true
});

//build tree by nodes  


//异步请求获取菜单列表
$(document).ready(function () {
	$.ajax({
	    type: "POST",
	    url:"../sysMenu/menuListJsonForMenuList",
	    dataType: 'json',
	    error: function(request) {
	    	infoMsg("请求失败");
	    },
	    success: function(data) {
	    	fifaGirdTree.build(data,true);
	    }
	});
});
//编辑 
function edit(){
	var sllectNodes=fifaGirdTree.getSelectNodes();
	if(sllectNodes==null||sllectNodes.length==0){
		infoMsg("很抱歉，您当前未选中任何一行!");
	}else{
		var node=sllectNodes[0];
		$("#menuId").val(node.id);
		document.myform.action="../sysMenu/edit";
		document.myform.submit();
	}
}
//新增
function add(){
	document.myform.action="../sysMenu/add";
	document.myform.submit();
}
//删除 
function del(){
	var sllectNodes=fifaGirdTree.getSelectNodes();
	if(sllectNodes==null||sllectNodes.length==0){
		infoMsg("很抱歉，您当前未选中任何一行!");
	}else{
		var node=sllectNodes[0];
		if(node.childs!=null&&node.childs.length>0){
			infoMsg("该模块下有子模块，不允许删除!");
		}else{
			var id = node.id;
			confirmMsg('确定删除这条数据?',function(res){
		      	if(res){
		      		$.ajax({
			               type: 'POST',//请求方式
			               url: '../sysMenu/del',//请求的action路径
			               data: "menuId="+id,//请求参数
			               dataType: 'json',//返回参数类型
			               error: function () {//请求失败处理函数
			                   errorMsg('请求失败');
			               },
			               success: function (data) { //请求成功后处理函数。
			                   if(data.success){
			                	   reload();
			                   }else
			                   {
			                       errorMsg(data.msg);
			                   }
			               }
			           });
		      	}
		      });
		}
	}
}
//刷新
function reload(){
	location.reload();
}

</script>


	
</div>

</body>
</html>