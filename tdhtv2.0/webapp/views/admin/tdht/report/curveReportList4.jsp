<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/pager.css"	type="text/css" rel="stylesheet" />
<script src="${ctx}/resources/laydate/laydate.js"></script>
<script type="text/javascript" src="${ctx}/resources/js/jquery-ui-jqLoding.js"></script>

<title>曲线报表</title>
<script type="text/javascript">
	$(document).ready(function () {
window.parent.startaa();
})

</script>
</head>
<body class="body_overflow">
<input id="rid" type="hidden" value="${rid}" >
<input id="webUrls" type="hidden" value="${webUrls}" >
    <c:choose>
	  <c:when test="${type==1}">
	 <p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}流量汇总日曲线</span></p>
	     <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
	     选择日期：<input id="startingTime" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
	     <input name="search" class="btn-big" onclick="findReport();" type="button" value="查询" />
	     <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	      </form>
	  </c:when>
 
	  <c:when test="${type==2}">
	     <p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}流量汇总周曲线</span></p>
	     <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
	     选择周：<input type="text" id="startingTime" name="dateTypes" value="${dateTypes}" onfocus="WdatePicker({dateFmt:'yyyy-MM'})" class="Wdate" style="width:200px"/>
	    <input name="search" class="btn-big" onclick="findReport2();" type="button" value="查询" />
	    <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	     </form>
	  </c:when>
	  
	 <c:when test="${type==3}">
	  <p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}流量汇总月曲线</span></p>
		  <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
		  选择月份：<input id="startingTime" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM'})">
		  <input name="search" class="btn-big" onclick="findReport3();" type="button" value="查询" />
		  <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
		  </form>
     </c:when>
     
	<c:when test="${type==6}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}流量汇总年曲线</span></p>
		<form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
		 选择年份：<input id="startingTime" name="dateTypes" value="${dateTypes}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY'})">
	     <input name="search" class="btn-big" onclick="findReport4();" type="button" value="查询" />
	     <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	     </form>
	</c:when>
	
	<c:otherwise>
		<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}流量汇总自定义曲线</span></p>
		
		  <form id="myform" name="myform" method="post"  style="text-align: left;margin-top: 5px;">
		  开始时间：<input id="startingTime" name="startingTime" value="${sTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY:MM:DD'})">
		  结束时间：<input id="endTime" name="endTime" value="${eTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY:MM:DD'})"><%--
		  时间间隔(/分钟)<input type="text" name="minates" value="${minates} ">
		  --%><input name="search" class="btn-big" onclick="findReport5();" type="button" value="查询" />
		  <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
		  </form>
	 </c:otherwise>
	</c:choose>

  

  
 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:500px"></div>
     
    <!--  <div style="with:100%;height:31px; background: url(${ctx}/resources/lrtk/images/foot.png) no-repeat center;"></div>
    ECharts单文件引入 -->
    <script src="${ctx}/resources/js/echarts.js"></script>
    <script type="text/javascript">
    var rid=$("#rid").val()
    function findReport(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList2?form=4&type=1&rid="+rid;
		document.myform.submit();
	}
	 function findReport2(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList2?form=4&type=2&rid="+rid;
		document.myform.submit();
	}
	 function findReport3(){
	 
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		//alert("222");
		document.myform.action = "../curveReport/curveReportList2?form=4&type=3&rid="+rid;
		//alert("333");
		document.myform.submit();
	}
	 function findReport4(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList2?form=4&type=6&rid="+rid;
		document.myform.submit();
	}
	 function findReport5(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList2?form=4&type=5&rid="+rid;
		document.myform.submit();
	}
	

	//清空   
	 function cls(){
	
		   var sum=0;
		   var t = document.getElementsByTagName("INPUT");
		   for (var i=0; i <t.length;i++){   
		  if (t[i].type=='text'){   
		    ++sum; 
		    t[i].value="";
		  }
		   }
	 }
    
    </script>
    
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts图表
        var myChart = echarts.init(document.getElementById('main')); 
        
        var option = {
  /* title : {
        text: '${companyName}数据曲线报表',
        subtext: ''
    },*/
    //鼠标悬浮时的弹出框
    tooltip : {
        trigger: 'axis',
        alwaysShowContent:false,
        hideDelay:10000,
        enterable:false
    },
    //折线提示
    legend: {
    	/*x:'right',
    	y: 'center' ,*/
    	/*itemWidth:'30px',
    	itemHeight:'20px',*/
    	/*borderWidth:'1',*/
    	/*borderColor: 'auto',*/
    	x:'left',
    	y:'25px',
    	selectedMode:'multiple',
        data:['工业排水(m³)','工业给水(m³)','生活给水(m³)','损耗限值(m³)','损耗值(m³)','不明工业排水(m³)'],
        selected:{'工业排水(m³)':true,'工业给水(m³)':false,'生活给水(m³)':false,'损耗限值(m³)':false,'损耗值(m³)':false,'不明工业排水(m³)':false}	
    },
    grid:{
    	 left: '1%',
        right: '0',
        bottom: '8%',
    	containLabel: true
    },
    toolbox: {
        show : true,
        showTitle:true,
        //右上角工具箱
        feature : {
              dataZoom: {},
            //数据视图
            dataView : {show: false, readOnly: false},
            magicType : {show: true, type: ['bar','line']},
            //还原
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
           type: 'category',
        
        splitLine: {show: false},
            data : ${sytime}
        }
    ],
    yAxis: [
{ 
type: 'value', 
scale: true, 
precision: 2, 
splitNumber: 10, 
splitArea: { show: true } 


} 

],

         dataZoom :[
            {
                type: 'slider',
                show: true,
                start: 0,
                end: 100,
                handleSize: 8,
               backgroundColor:  'rgba(47,69,84,0)' ,
        dataBackgroundColor: '#D4D4D4',
        fillerColor:'#8cc63f'
            },
            {
                type: 'inside',
                start: 0,
                end: 100,
               
            }
            
        ]
    ,
    series : [
        
         {
            name:'工业给水(m³)',
            type:'bar',
            smooth:true,
            data:${industrialsupply},
           //  symbol:'none',
            
        },
        {/* industrialdrainage
livingsupply
industrialsupply
Losslimit
wastage
unknown

        */
            name:'工业排水(m³)',
            smooth:true,
           
            type:'bar',
            data:${industrialdrainage},
            
        },
         {
            name:'生活给水(m³)',
            smooth:true,
            type:'bar',
            //symbol:'none',
            data:${livingsupply},
            
        },
         {
            name:'损耗限值(m³)',
            smooth:true,
         //   symbol:'none',
            type:'bar',
            data:${LossLimit},
            
        },
         {
            name:'损耗值(m³)',
            smooth:true,
          //  symbol:'none',
            type:'bar',
            data:${wastage},
            
        },
        {
            name:'不明工业排水(m³)',
            smooth:true,
            type:'bar',
         //   symbol:'none',
            data:${unknown},
             
        }
    ],
    color:  [ '#ff7f50', '#87cefa', '#da70d6', '#32cd32', '#6495ed','#ff69b4', '#ba55d3', '#cd5c5c', '#ffa500', '#40e0d0','#1e90ff', '#ff6347', '#7b68ee', '#00fa9a', '#ffd700','#6b8e23', '#ff00ff', '#3cb371', '#b8860b', '#30e0e0' 
]
};
                  myChart.setOption(option, true);
           window.onresize = myChart.resize;    
                myChart.setOption(option);
    </script>
	
	
</body>

</html>