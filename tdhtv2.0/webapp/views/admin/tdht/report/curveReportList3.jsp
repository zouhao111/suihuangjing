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
	  <c:if test="${rid==75501330025}">
	   <p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}工业给水2日曲线</span></p>
	   </c:if>
	   <c:if test="${rid!=75501330025}">
	   <p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}生活给水日曲线</span></p>
	   </c:if>
	   <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
	    选择日期：<input id="startingTime" name="dateTypes" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
	   <input name="search" class="btn-big" onclick="findReport();" type="button" value="查询" />
	   <input name="lat" class="btn-big" onclick="findReport();" type="submit" value="前一天" />
	   <input name="lat" class="btn-big" onclick="findReport();" type="submit" value="后一天" />
	   </form>
	  </c:when>
	  
	 <c:when test="${type==2}">
	 <c:if test="${rid==75501330025}">
	 	<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}工业给水2周曲线</span></p>
	 	</c:if>
	 	<c:if test="${rid!=75501330025}">
	 	<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}生活给水周曲线</span></p>
	 	</c:if>
	   <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
	   选择周：<input type="text" id="startingTime" name="dateTypes" value="${sTime}" onfocus="WdatePicker({dateFmt:'yyyy-MM'})" class="Wdate" style="width:200px"/>
	   <input name="search" class="btn-big" onclick="findReport2();" type="button" value="查询" />
	   <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	   </form>
	 </c:when>
	 
	<c:when test="${type==3}">
	 <c:if test="${rid==75501330025}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}工业给水2月曲线</span></p>
		</c:if>
		<c:if test="${rid!=75501330025}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}生活给水月曲线</span></p>
		</c:if>
		
		 <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
		  选择月份：<input id="startingTime" name="dateTypes" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM'})">
		  <input name="search" class="btn-big" onclick="findReport3();" type="button" value="查询" />
		  <input name="lat" class="btn-big" onclick="findReport3();" type="submit" value="前月" />
		  <input name="lat" class="btn-big" onclick="findReport3();" type="submit" value="后月" />
		  </form>
	</c:when>
		  
	<c:when test="${type==6}">
	<c:if test="${rid==75501330025}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}工业给水2年曲线</span></p>
		</c:if>
		<c:if test="${rid!=75501330025}">
		<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}生活给水年曲线</span></p>
		</c:if>
	    <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
	     选择年份：<input id="startingTime" name="dateTypes" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY'})">
	     <input name="search" class="btn-big" onclick="findReport4();" type="button" value="查询" />
	     <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	     </form>
	</c:when>
	              		
	 <c:otherwise>
	 <c:if test="${rid==75501330025}">
	 	<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}工业给水2自定义曲线</span></p>
	 	</c:if>
	 	 <c:if test="${rid!=75501330025}">
	 	<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}生活给水自定义曲线</span></p>
	 	</c:if>
	 	<input id="select" type="hidden" value="${minates}" >
	     <form id="myform" name="myform" method="post"  style="text-align: left;margin-top: 5px;">
	      开始时间：<input id="startingTime" name="startingTime" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	      结束时间：<input id="endTime" name="endTime" value="${eTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	       时间间隔(/分钟)：<select id="timeSpace"name="minates"> <option value ="5">5分钟</option><option value ="30">30分钟</option><option value="60">1小时</option><option value="1440">24小时</option></select>  
	      <input name="search" class="btn-big" onclick="findReport5();" type="button" value="查询" />
	      <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
		 </form>
	 </c:otherwise>
</c:choose>

  
 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:500px"></div>
    <!-- ECharts单文件引入 -->
    <script src="${ctx}/resources/js/echarts.js"></script>
    
    <script type="text/javascript">
    var rid=$("#rid").val()
    function findReport(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList?form=3&type=1&rid="+rid;
		document.myform.submit();
	}
	 function findReport2(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList?form=3&type=2&rid="+rid;
		document.myform.submit();
	}
	 function findReport3(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList?form=3&type=3&rid="+rid;
		document.myform.submit();
	}
	 function findReport4(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList?form=3&type=6&rid="+rid;
		document.myform.submit();
	}
	 function findReport5(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList4?form=3&type=5&rid="+rid;
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
    $(function(){
     var optss = document.getElementById("timeSpace");
		var minates=$("#select").val();  
		if(minates!=""&&optss!=""){
	 for(var i=0;i<3;i++){
           if(minates==optss.options[i].value){
                  optss.options[i].selected = 'selected';
                    break;
             }
          }
         }
    })
    </script>
    
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts图表
       
        var myChart = echarts.init(document.getElementById('main')); 
        
        var option = {
   /*title : {
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
    	selectedMode:'single',
        data:['总流量(m³)','流量速率(m³/s)','流速(m/s)'],
        selected:{'流量速率(m³/s)':true,'流速(m/s)':false,'总流量(m³)':false,}	
    },
     grid:{
    	 left: '1%',
        right: '0',
        bottom: '8%',
    	containLabel: true
    },
    toolbox: {
        show : true,
        //右上角工具箱
        feature : {
              dataZoom: {},
            //数据视图
            dataView : {show: false, readOnly: false},
            magicType : {show: true, type: ['line']},
            //还原
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            //端空白策略
            boundaryGap : false,
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
        /* */
         {
            name:'流量速率(m³/s)',
            type:'line',
            smooth:false,
            data:${traffic},
         //    symbol:'none'
        },
        
         {
            name:'流速(m/s)',
           // smooth:true,
            type:'line',
        //    symbol:'none',
            data:${currentSpeed}
        },
         
        {
            name:'总流量(m³)',
           // smooth:true,
            type:'line',
         //   symbol:'none',
            data:${ztraffic}
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