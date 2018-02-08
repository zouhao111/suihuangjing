$(function(){
    var list = $('#list');
    $("#list").datagrid({
        height:$("#body").height()-$('#search_area').height()-5,
        width:$("#body").width(),
        idField:'id',
        url:"list",
        singleSelect:true,
        nowrap:true,
        fitColumns:true,
        rownumbers:true,
        columns:[[
            {field:'id',title:'ID',width:100,halign:"center", align:"left",hidden:true},
            {field:'checkbox',title:'checkbox',width:100,halign:"center", align:"left",checkbox:true},
            {field:'account',title:'用户名',width:100,halign:"center", align:"left"},
            {field:'real_name',title:'姓名',width:100,halign:"center", align:"left"},
            {field:'sex',title:'性别',width:100,halign:"center", align:"left",
                formatter:function(value){
                    if(value == 1){
                        return "男";
                    }
                    if(value == 0){
                        return "女";
                    }
                }},
            {field:'email',title:'邮箱',width:100,halign:"center", align:"left"},
            {field:'mobile',title:'手机',width:100,halign:"center", align:"left"},
            {field:'address',title:'地址',width:100,halign:"center", align:"left"},
            {field:'birthday',title:'生日',width:100,halign:"center", align:"left"},
            {field:'company',title:'公司',width:100,halign:"center", align:"left"},
            {field:'register_date',title:'注册日期',width:100,halign:"center", align:"left"},
            {field:'last_login_date',title:'最后登录日期',width:100,halign:"center", align:"left"},
            {field:'last_login_ip',title:'最后登录IP',width:100,halign:"center", align:"left"}
        ]],
        toolbar:'#list_btn',
        pagination:true,
        onDblClickRow:function(rowIndex, rowData){
            viewDetail(rowData.id);
        }
    });

    //新增弹出框
    $("#save").on("click", function(){
        clearSelections();
        $parent("#parent_win").window({
            width:274,
            height:225,
            href:'user/addUser.html',
            title:'新增用户'
        });
    });
    //修改
    $("#update").on("click", function(){
        $('#list').datagrid('clearSelections');

        $parent.messager.alert("提示","update", "info");
    });
    //删除
    $("#delete").on("click", function(){
        //获取选中的数据
        var ids = getSelections(list);
        confirmMsg('确定删除这'+ids.length+'条数据',function(){
            $.ajax({
                type: 'POST',//请求方式
                url: 'delete',//请求的action路径
                data: "ids="+$.toJSON(ids),//请求参数
                dataType: 'json',//返回参数类型
                error: function () {//请求失败处理函数
                    errorMsg('请求失败');
                },
                success: function (data) { //请求成功后处理函数。
                    if(data.success)
                    {
                        infoMsg(data.msg);
                        //刷新datalist
                        list.datagrid('reload');
                    }else
                    {
                        errorMsg(data.msg);
                    }
                }
            });
        })
    });
    //多选
    $("#multi_check").on("click", function(){
        clearSelections(list);
        list.datagrid({singleSelect:false});
        $(this).linkbutton('disable');
        $('#single_check').linkbutton('enable');


    });
    //单选
    $("#single_check").on("click", function(){
        clearSelections(list);
        list.datagrid({singleSelect:true});
        $(this).linkbutton('disable');
        $('#multi_check').linkbutton('enable');
    });
    //查询按钮事件
    $("#search_btn").click(function(){
        list.datagrid('load',{
            "condition['account']":$("#account").val(),
            "condition['sex']":$("#sex").val()
        });

    });
    //重置按钮
    $("#reset_btn").click(function(){
        $("#search_form")[0].reset();
    });
})

function viewDetail(date, id){
    $parent.messager.alert("提示","查询详细", "info");
}

//监听窗口大小变化
window.onresize = function(){
    setTimeout(domresize,300);
};
//改变表格宽高
function domresize(){
    $('#list').datagrid('resize',{
        height:$("#body").height()-$('#search_area').height()-5,
        width:$("#body").width()
    });
}