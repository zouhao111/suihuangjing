/*
 主页加载方法
 @eric
 */
//系统时间显示
setInterval("document.getElementById('nowTime').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());", 1000);
var onlyOpenTitle = "首页";
var setting = {
    data: {
        simpleData: {
            enable: true
        }
    },
    view: {
        selectedMulti: false
    },
    callback: {
        onClick: function (e, id, node) {
            var zTree = $.fn.zTree.getZTreeObj("menuTree");
            if (node.isParent) {
                zTree.expandNode();
            } else {
                addTabs(node.name, node.file, node.tabIcon);
            }
        }
    }
};

$(function () {
    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: 'module/tree',//请求的action路径
        error: function () {//请求失败处理函数
            errorMsg('请求失败');
        },
        success: function (data) { //请求成功后处理函数。
            //alert(JSON.stringify(data));
            $.fn.zTree.init($("#menuTree"), setting, data);
            var zTree = $.fn.zTree.getZTreeObj("menuTree");
            //中间部分tab
            $('#tabs').tabs({
                border: false,
                fit: true,
                onSelect: function (title, index) {
                    var treeNode = zTree.getNodeByParam("name", title, null);
                    zTree.selectNode(treeNode);
                }
            });
        }
    });
    tabClose();
    tabCloseEven();

});

//添加一个选项卡面板 
function addTabs(title, url, icon) {
    if (!$('#tabs').tabs('exists', title)) {
        $('#tabs').tabs('add', {
            title: title,
            content: '<iframe src="' + url + '" frameBorder="0" border="0" scrolling="no" style="width: 100%; height: 100%;"/>',
            iconCls: icon,
            closable: true
        });
    } else {
        $('#tabs').tabs('select', title);
    }
    tabClose();
}
function tabClose() {
    /*双击关闭TAB选项卡*/
    $(".tabs-inner").dblclick(function () {
        var subtitle = $(this).children(".tabs-closable").text();
        $('#tabs').tabs('close', subtitle);
    });
    /*为选项卡绑定右键*/
    $(".tabs-inner").bind('contextmenu', function (e) {
        $('#mm').menu('show', {
            left: e.pageX,
            top: e.pageY
        });
        var subtitle = $(this).children(".tabs-closable").text();
        $('#mm').data("currtab", subtitle);
        $('#tabs').tabs('select', subtitle);

        var tabcount = $('#tabs').tabs('tabs').length; //tab选项卡的个数
        var tabs = $('#tabs').tabs('tabs');            //获得所有的Tab选项卡
        var lasttab = tabs[tabcount - 1];              //获得最后一个Tab选项卡
        var lasttitle = lasttab.panel('options').tab.text(); //最后一个Tab选项卡的Title
        var currtab_title = $('#mm').data("currtab");  //当前Tab选项卡的Title
        //判断关闭其他按钮
        if (tabcount <= 1) {
            $('#closeother').attr("disabled", "disabled").css({ "cursor": "default", "opacity": "0.4" });
        }
        else {
            $('#closeother').removeAttr("disabled").css({ "cursor": "pointer", "opacity": "1" });
        }
        //判断关闭右侧按钮
        if (lasttitle == currtab_title) {
            $('#closeright').attr("disabled", "disabled").css({ "cursor": "default", "opacity": "0.4" });
        }
        else {
            $('#closeright').removeAttr("disabled").css({ "cursor": "pointer", "opacity": "1" });
        }
        //判断关闭左侧按钮
        var onetab = tabs[0];  //第一个Tab选项卡
        var onetitle = onetab.panel('options').tab.text();  //第一个Tab选项卡的Title
        if (onetitle == currtab_title) {
            $('#closeleft').attr("disabled", "disabled").css({ "cursor": "default", "opacity": "0.4" });
        }
        else {
            $('#closeleft').removeAttr("disabled").css({ "cursor": "pointer", "opacity": "1" });
        }

        return false;
    });
}


//绑定右键菜单事件
function tabCloseEven() {

    $('#mm').menu({
        onClick: function (item) {
            closeTab(item.id);
        }
    });

    return false;
}

function closeTab(action) {
    var alltabs = $('#tabs').tabs('tabs');
    var currentTab = $('#tabs').tabs('getSelected');
    var allTabtitle = [];
    $.each(alltabs, function (i, n) {
        allTabtitle.push($(n).panel('options').title);
    })


    switch (action) {
        case "refresh":
            var iframe = $(currentTab.panel('options').content);
            var src = iframe.attr('src');
            $('#tabs').tabs('update', {
                tab: currentTab,
                options: {
                    content: createFrame(src)
                }
            })
            break;
        case "close":
            var currtab_title = currentTab.panel('options').title;
            $('#tabs').tabs('close', currtab_title);
            break;
        case "closeall":
            $.each(allTabtitle, function (i, n) {
                if (n != onlyOpenTitle) {
                    $('#tabs').tabs('close', n);
                }
            });
            break;
        case "closeother":
            var currtab_title = currentTab.panel('options').title;
            $.each(allTabtitle, function (i, n) {
                if (n != currtab_title && n != onlyOpenTitle) {
                    $('#tabs').tabs('close', n);
                }
            });
            break;
        case "closeright":
            var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);

            if (tabIndex == alltabs.length - 1) {
                alert('亲，后边没有啦 ^@^!!');
                return false;
            }
            $.each(allTabtitle, function (i, n) {
                if (i > tabIndex) {
                    if (n != onlyOpenTitle) {
                        $('#tabs').tabs('close', n);
                    }
                }
            });

            break;
        case "closeleft":
            var tabIndex = $('#tabs').tabs('getTabIndex', currentTab);
            if (tabIndex == 1) {
                alert('亲，前边那个上头有人，咱惹不起哦。 ^@^!!');
                return false;
            }
            $.each(allTabtitle, function (i, n) {
                if (i < tabIndex) {
                    if (n != onlyOpenTitle) {
                        $('#tabs').tabs('close', n);
                    }
                }
            });

            break;
        case "exit":
            $('#closeMenu').menu('hide');
            break;
    }
}