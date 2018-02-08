/*
	扩展easyui中的控件方法或修改其默认属性
	@eric
 */
 
//翻页工具栏文字
if ($.fn.pagination){
    $.fn.pagination.defaults.showPageList=true,
    $.fn.pagination.defaults.pageList=[10,20,50,100],
    $.fn.pagination.defaults.beforePageText="第 <span id='currentPage'>1</span> 页  第",
	$.fn.pagination.defaults.afterPageText = "页 共 {pages} 页";
	$.fn.pagination.defaults.displayMsg ="当前{from}-{to} 条  共{total}条记录";
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = '正在加载...';
}


//window窗体默认属性
$.fn.window.defaults.resizable=false;
$.fn.window.defaults.collapsible=false;
$.fn.window.defaults.minimizable=false;
$.fn.window.defaults.maximizable=false;
$.fn.window.defaults.shadow=false;
$.fn.window.defaults.modal=true;
$.fn.window.defaults.loadingMessage = '正在加载...';

//信息框按钮文字
if ($.messager){
	$.messager.defaults.ok = '确定';
	$.messager.defaults.cancel = '取消';
}
