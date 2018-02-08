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
	      <p class="f14style" ><strong class="f14 text-title">${companyName}日曲线</strong></p>
	       <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
	             选择日期：<input id="startingTime" name="dateTypes" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
	             <input name="search" class="btn-big" onclick="findReport();" type="button" value="查询" />
	             <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	      </form>
	     </c:when>
	     
	    <c:when test="${type==2}">
	    	<p class="f14style"><strong class="f14 text-title">${companyName}周曲线</strong></p>
	       <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
	        选择周：<input type="text" id="startingTime" name="dateTypes" value="${sTime}" onfocus="WdatePicker({dateFmt:'yyyy-MM'})" class="Wdate" style="width:200px"/>
	         <input name="search" class="btn-big" onclick="findReport2();" type="button" value="查询" />
	         <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	      </form>
	   </c:when>
	   
	   <c:when test="${type==3}">
	    	<p class="f14style"><strong class="f14 text-title">${companyName}月曲线</strong></p>
	       <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
	        选择月份：<input id="startingTime" name="dateTypes" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM'})">
	        <input name="search" class="btn-big" onclick="findReport3();" type="button" value="查询" />
	        <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	      </form>
	   </c:when>
	   
	  <c:when test="${type==6}">
	  	<p class="f14style"><strong class="f14 text-title">${companyName}年曲线</strong></p>
	       <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
	        选择年份：<input id="startingTime" name="dateTypes" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY'})">
	        <input name="search" class="btn-big" onclick="findReport4();" type="button" value="查询" />
	        <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	      </form>
	  </c:when>
	              		
	  <c:otherwise>
	  	<p class="f14style"><strong class="f14 text-title">${companyName}自定义曲线</strong></p>
	  	<input id="select" type="hidden" value="${minates}" >
	     <form id="myform" name="myform" method="post"  style="text-align: left;margin-top: 5px;">
	      开始时间：<input id="startingTime" name="startingTime" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	       结束时间：<input id="endTime" name="endTime" value="${eTime}" class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	       时间间隔(/分钟)：<select id="timeSpace"name="minates"> <option value ="5">5分钟</option><option value ="30">30分钟</option><option value="60">1小时</option></select>  
	       <input name="search" class="btn-big" onclick="findReport5();" type="button" value="查询" />
	       <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
		</form>
	   </c:otherwise>
	</c:choose>

  
 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="height:600px"></div>
    <%--<div style="with:100%;height:31px; background: url(${ctx}/resources/lrtk/images/foot.png) no-repeat center;"></div>
    --%><!-- ECharts单文件引入 --><!--
    <script src="${ctx}/resources/js/echarts.js"></script>
       --><script src="${ctx}/resources/js/echarts.min.js"></script>
    <script type="text/javascript">
    var a=$("#webUrls").val();
 
    var rid=$("#rid").val()
    function findReport(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveWater/curveReportList?form=1&type=1&rid="+rid;
		document.myform.submit();
	}
	 function findReport2(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveWater/curveReportList?form=1&type=2&rid="+rid;;
		document.myform.submit();
	}
	 function findReport3(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveWater/curveReportList?form=1&type=3&rid="+rid;
		document.myform.submit();
	}
	 function findReport4(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveWater/curveReportList?form=1&type=6&rid="+rid;
		document.myform.submit();
	}
	 function findReport5(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveWater/curveReportList?form=1&type=5&rid="+rid;
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
    var sytime=${sytime}
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
    	/*borderColor: 'auto',,'电导率','六价铬','电导率':false,'六价铬':false*/
    	x:'left',
    	y:'30px',
    	selectedMode:'single',
        data:${data_name1},
        selected:{'流量速率(m³/s)':true,'电导率(μS/cm)':false,'流速(m/s)':false,'总流量(m³)':false,'水位(m)':false,'PH':false,'溶解氧(mg/l)':false,'浊度(mg/l)':false,'COD(mg/l)':false,'氨氮(mg/l)':false,'总磷(mg/l)':false,'总氮(mg/l)':false,'硝酸盐氮(mg/l)':false,'阴离子表面活性剂(mg/l)':false,'挥发酚(mg/l)':false,'氰化物(mg/l)':false,'铅(mg/l)':false,'镉(mg/l)':false,'铜(mg/l)':false,'砷(mg/l)':false,'铁(mg/l)':false,'六价铬(mg/l)':false,'锰(mg/l)':false,'镍(mg/l)':false,'氟化物(mg/l)':false,'硫化物(mg/l)':false,'水质综合毒性(mg/l)':false,'有机物水质(mg/l)':false,'锌(mg/l)':false}	
   
    },
     grid:
    	
    	{ 
    	top:'15%',
    	left: '3%',
        right: '4%',
        bottom: '7%',
    	containLabel: true},
    
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
            data : sytime
        }
    ],
    yAxis: [
{ 
position:'right',
type: 'value', 
scale: true, 
splitNumber: 12,//区间分隔
 
splitArea: { show: true } ,

show:false
},

        {
           type: 'value', 
           position:'left',
scale: true, 
splitNumber: 10,//区间分隔
 
splitArea: { show: true } ,
show:true,

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
            smooth:true,
            data:${traffic},
           //  symbol:'none',
            yAxisIndex:1,
        },
        {
            name:'PH',
            smooth:true,
           // symbol:'none',
            type:'line',
            data:${ph},
             markLine: {
             lineStyle:{
             normal: {
        color:'#FF0000'
    },
             
             },
                data :[
    
        {name: '最大限值' ,  yAxis: 9},
        {name: '最小限值' ,  yAxis: 6}
    
    
       
  
    
]  
       }         
        },
         {
            name:'流速(m/s)',
            smooth:true,
            type:'line',
         //   symbol:'none',
            data:${currentSpeed},
         yAxisIndex:1,
            
            
        },
         {
            name:'水位(m)',
            smooth:true,
          //  symbol:'none',
            type:'line',
            data:${waterleve},
            yAxisIndex:1,
        },
        {
            name:'总流量(m³)',
            smooth:true,
            type:'line',
         //   symbol:'none',
            data:${ztraffic},
            yAxisIndex:1,
        },
        {
            name:'电导率(μS/cm)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${conductivity},
              yAxisIndex:1,
            
        },
        {
        	yAxisIndex:0,
            name:'COD(mg/l)',
            smooth:true,
            type:'line',
         //   symbol:'none',
            data:${cod},
             markLine: {
            	
             lineStyle:{
             normal: {
        color:'#FF0000',
        
    },
             
             },
                data : [
        {name: '最大限值' ,  yAxis: 280},
]  
       }      
            
        },
        {
        	yAxisIndex:0,
            name:'氨氮(mg/l)',
            smooth:true,
            type:'line',
       //     symbol:'none',
            data:${NH3N},
            markLine: {
            lineStyle:{
             normal: {
        color:'#FF0000'
    },
             
             },
                data : [
     {name: '最大限值' ,  yAxis: 40},
]
       }   
        },
         {
            name:'六价铬(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${cr6},
            markLine: {
            lineStyle:{
             normal: {
        color:'#FF0000'
    },
             
             },
                data : [
     {name: '最大限值' ,  yAxis: 0.1},
    
    
]
       }   
            
        },
        
        {
        	yAxisIndex:0,
            name:'浊度(mg/l)',
            smooth:true,
            type:'line',
       //     symbol:'none',
            data:${Turbidity},
            markLine: {
            lineStyle:{
             normal: {
        color:'#FF0000'
    },
             
             },
                data : [
     {name: '最大限值' ,  yAxis: 220},
    
    
]
       }   
            
        },
        {
        	yAxisIndex:1,
            name:'溶解氧(mg/l)',
            smooth:true,
            type:'line',
       //     symbol:'none',
            data:${Do},
            
        },
        {
        	yAxisIndex:1,
            name:'氰化物(mg/l)',
            smooth:true,
            type:'line',
      //      symbol:'none',
            data:${CN},
            
        },
        {
        	yAxisIndex:1,
            name:'总氮(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${TN},
            
        },
        {
        	yAxisIndex:1,
            name:'硝酸盐氮(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${NO3},
            
        },
        {
        	yAxisIndex:1,
            name:'阴离子表面活性剂(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${An},
            
        },
        {
        	yAxisIndex:1,
            name:'挥发酚(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${Phe},
            
        },
        {
        	yAxisIndex:0,
            name:'总磷(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${TP},
            markLine: {
            lineStyle:{
             normal: {
        color:'#FF0000'
    },
             
             },
                data : [
     {name: '最大限值' ,  yAxis: 4.5},
    
    
]
       }   
        }
        ,
        {
        	yAxisIndex:1,
            name:'铅(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${Pb},
            
        },
        {
        	yAxisIndex:1,
            name:'镉(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${Cd},
            
        },
        {
        	yAxisIndex:1,
            name:'铜(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${Cu},
            
        },
        {
        	yAxisIndex:1,
            name:'汞(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${Hg},
            
        },
        {
        	yAxisIndex:1,
            name:'砷(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${As},
            
        },
        {
        	yAxisIndex:1,
            name:'铁(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${Fe},
            
        },
        {
        	yAxisIndex:1,
            name:'锰(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${Mn},
            
        },
        {
        	yAxisIndex:1,
            name:'镍(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${Ni},
            
        },
        {
        	yAxisIndex:1,
            name:'氟化物(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${F},
            
        },
        {
        	yAxisIndex:1,
            name:'硫化物(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${S},
            
        },
        {
        	yAxisIndex:1,
            name:'水质综合毒性(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${Poison},
            
        },
        {
        	yAxisIndex:1,
            name:'有机物水质(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${OC},
            
        },
        {
        	yAxisIndex:1,
            name:'锌(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${Zn},
            
        }
        
    ],
    color:  [ '#ff7f50', '#87cefa', '#da70d6', '#32cd32', '#6495ed','#ff69b4', '#ba55d3', '#cd5c5c', '#ffa500', '#40e0d0','#1e90ff', '#ff6347', '#7b68ee', '#00fa9a', '#ffd700','#6b8e23', '#ff00ff', '#3cb371', '#b8860b', '#30e0e0' 
]
};
/*var ph=${ph};
for(i=0;i<ph.length;i++){
if(ph[i]>9||ph[i]<6){
 
}
}*/

                myChart.setOption(option, true);
           window.onresize = myChart.resize;
                myChart.setOption(option);
                
                
                // 图例开关的行为只会触发 legendselectchanged 事件
myChart.on('legendselectchanged', function (params) {
    // 获取点击图例的选中状态
    var isSelected = params.selected[params.name];
    // 在控制台中打印{'流量速率(m³/s)':true,'电导率(μS/cm)':false,'流速(m/s)':false,'总流量(m³)':false,'水位(m)'
    console.log((isSelected ? '选中了' : '取消选中了') + '图例' + params.name);
  if(params.name==('流量速率(m³/s)')||params.name==('流速(m/s)')||params.name==('总流量(m³)')||params.name==('水位(m)')){
	    var sytime=${sytime}
	  myChart.setOption({
             xAxis: [{data:sytime}],});
  }else{
	  var sytime=${sytime2} 
	  myChart.setOption({
             xAxis: [{data:sytime}],});
  }
    if(params.name==('PH')){
    	myChart.setOption({
            yAxis: [
{ 
position:'left',
type: 'value', 
scale: true, 
splitNumber: 10,//区间分隔
max:14,
min:0,

splitArea: { show: true } ,

show:true
},

        {
           type: 'value', 
           position:'left',
scale: true, 
splitNumber: 10,//区间分隔
splitArea: { show: true } ,
show:false
        }
],
    });	
    }else if(params.name==('六价铬(mg/l)')){
    	var cr6=${cr6};
    	var maxval=maxVal(cr6,0.1);
    	myChart.setOption({
            yAxis: [
{ 
position:'left',
type: 'value', 
scale: true, 
splitNumber: 10,//区间分隔
max:maxval,
min:0,

splitArea: { show: true } ,

show:true
},

        {
position:'left',
type: 'value', 
scale: true, 
splitNumber: 10,//区间分隔


splitArea: { show: true } ,

show:false
        }
],
        });
    	
    } else  if(params.name==('cod(mg/l)')){
    	var cod=${cod};
    	var maxval=maxVal(cod,280);
    	
    	myChart.setOption({
            yAxis: [
{ 
position:'left',
type: 'value', 
max:maxval,
min:0,

splitArea: { show: true } ,

show:true
},{
           type: 'value', 
           position:'left',
scale: true, 
splitNumber: 10,//区间分隔
splitArea: { show: true } ,
show:false
        }
],
        });
    	
    } else  if(params.name==('氨氮(mg/l)')){
    	var NH3N=${NH3N};
    	var maxval=maxVal(NH3N,40);
    	myChart.setOption({
            yAxis: [
{ 
position:'left',
type: 'value', 
max:maxval,
min:0,

splitArea: { show: true } ,

show:true
},{
           type: 'value', 
           position:'left',
scale: true, 
splitNumber: 10,//区间分隔
splitArea: { show: true } ,
show:false
        }
],
        });
    	
    }else  if(params.name==('浊度(mg/l)')){
    	var mlss=${Turbidity};
    	var maxval=maxVal(mlss,220);
    	myChart.setOption({
            yAxis: [
{ 
position:'left',
type: 'value', 
max:maxval,
min:0,

splitArea: { show: true } ,

show:true
},{
           type: 'value', 
           position:'left',
scale: true, 
splitNumber: 10,//区间分隔
splitArea: { show: true } ,
show:false
        }
],
        });
    	
    }else  if(params.name==('总磷(mg/l)')){
    	var phosphor=${TP};
    	var maxval=maxVal(phosphor,4.5);
    	maxval=maxval.toFixed(0);
    	myChart.setOption({
            yAxis: [
{ 
position:'left',
type: 'value', 
max:maxval,
min:0,

splitArea: { show: true } ,

show:true
},{
           type: 'value', 
           position:'left',
scale: true, 
splitNumber: 10,//区间分隔

splitArea: { show: true } ,
show:false
        }
],
        });
    	
    }else{
    myChart.setOption({
            yAxis: [
{ 
position:'right',
type: 'value', 
scale: true, 
splitNumber: 10,//区间分隔
max:14,
min:0,

 
splitArea: { show: true } ,

show:false
},{ 
position:'left',
type: 'value', 
scale: true, 
splitNumber: 10,//区间分隔


 
splitArea: { show: true } ,

show:true
}
]
        });
    
    }
    // 打印所有图例的状态
    
});
    
      function maxVal( data, yval ){
    	 var maxval=Math.max.apply(null,data);//最大值
    	if(maxval<yval){
    		maxval=yval+(yval*0.20);
    	}else{
    		maxval=maxval+(maxval*0.20);
    	}
    	return maxval;
      }          
    </script>
	
	
</body>

</html>