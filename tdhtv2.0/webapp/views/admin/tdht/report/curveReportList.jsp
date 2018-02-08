<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${ctx}/resources/ztree/css/style.css"	type="text/css" rel="stylesheet" />
<link href="${ctx}/resources/css/pager.css"	type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${ctx}/resources/js/jquery-ui-jqLoding.js"></script>
<script src="${ctx}/resources/laydate/laydate.js"></script>
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
	      <p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}工业排水日曲线</span></p>
	       <form id="myform" name="myform" action="" method="post" style="text-align: left;margin-top: 5px;">
	             选择日期：<input id="startingTime" name="dateTypes" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
	             <input name="search" class="btn-big" onclick="findReport();" type="button" value="查询" />
	             <input name="lat" class="btn-big" onclick="findReport();" type="submit" value="前一天" />
	             <input name="lat" class="btn-big" onclick="findReport();" type="submit" value="后一天" />
	      </form>
	     </c:when>
	     
	    <c:when test="${type==2}">
	    	<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}工业排水周曲线</span></p>
	       <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
	        选择周：<input id="startingTime" name="dateTypes" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM'})">
	         <input name="search" class="btn-big" onclick="findReport2();" type="button" value="查询" />
	         <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	      </form>
	   </c:when>
	   
	   <c:when test="${type==3}">
	    	<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}工业排水月曲线</span></p>
	       <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
	        选择月份：<input id="startingTime" name="dateTypes" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY-MM'})">
	        <input name="search" class="btn-big" onclick="findReport3();" type="button" value="查询" />
	        <input name="lat" class="btn-big" onclick="findReport3();" type="submit" value="前月" />
	        <input name="lat" class="btn-big" onclick="findReport3();" type="submit" value="后月" />
	      </form>
	   </c:when>
	   
	  <c:when test="${type==6}">
	  	<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}工业排水年曲线</span></p>
	       <form id="myform" name="myform" method="post" style="text-align: left;margin-top: 5px;">
	        选择年份：<input id="startingTime" name="dateTypes" value="${sTime}"  class="laydate-icon" onclick="laydate({istime: true, format: 'YYYY'})">
	        <input name="search" class="btn-big" onclick="findReport4();" type="button" value="查询" />
	        <input id="search" class="btn-big" onclick="cls();" type="button" value="清空" />
	      </form>
	  </c:when>
	              		
	  <c:otherwise>
	  	<p class="f14style" ><span id="com_name"class="f14 text-title">${companyName}工业排水自定义曲线</span></p>
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
    <!-- ECharts单文件引入 --><!--
    <script src="${ctx}/resources/js/echarts.js"></script>
       --><script src="${ctx}/resources/js/echarts2.js"></script>
    <script type="text/javascript">
    var a=$("#webUrls").val();
 
    var rid=$("#rid").val()
    function findReport(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList?form=1&type=1&rid="+rid;
		document.myform.submit();
	}
	 function findReport2(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList?form=1&type=2&rid="+rid;;
		document.myform.submit();
	}
	 function findReport3(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList?form=1&type=3&rid="+rid;
		document.myform.submit();
	}
	 function findReport4(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList?form=1&type=6&rid="+rid;
		document.myform.submit();
	}
	 function findReport5(){
		$.fn.jqLoading({ height: 100, width: 240, text: "正在加载中，请耐心等待...." });
		document.myform.action = "../curveReport/curveReportList?form=1&type=5&rid="+rid;
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
  /*  $(function(){
     var optss = document.getElementById("timeSpace");
		var minates=$("#select").val();  
		if(minates!=""&&optss!=""){
	 for(var i=0;i<4;i++){
           if(minates==optss.options[i].value){
                  optss.options[i].selected = 'selected';
                    break;
             }
          }
         }
           
    })*/
    
   
    </script>

    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts图表
    var sytime=${sytime}
   
  // var arr ='"'+ ${data_names1}+'"';
　　//　var str = JSON.stringify(arr);//这样也能转化为字符串但现在还是数组的形式不过类型已经是字符串了；
　　//　var arr2 = JSON.parse(str);
//console.log(arr2);
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
    	y:'25px',
    	selectedMode:'multiple',
        data:${data_name1},
       // selected:{'流量速率(m³/s)':true,'电导率(μS/cm)':false,'流速(m/s)':false,'总流量(m³)':false,'水位(m)':false,'PH':false,'水温(℃)':false,'浊度(NTU)':false,'溶解氧(mg/l)':false,'cod(mg/l)':false,'氨氮(mg/l)':false,'总汞(mg/l)':false,'六价铬(mg/l)':false,'TOC(mg/l)':false,'固体悬浮物(mg/l)':false,'总铬(mg/l)':false,'总镍(mg/l)':false,'总镉(mg/l)':false,'总铅(mg/l)':false,'总银(mg/l)':false,'总磷(mg/l)':true,'总铜(mg/l)':false,'总锌(mg/l)':false}	
   
    selected:{${data_names1}}
    },
     grid:
    	
    	{ 
    	 top:'15%',
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
            data : ${sytime2}
        }
    ],
   
   yAxis: [


        {
          position: 'left',
           type: 'value', 
scale: true, 
splitNumber: 10,//区间分隔
//   splitLine:{show: true},//去除网格线
splitArea: { show: true } ,
boundaryGap:true,
show:true
        },
       /* { 
          position: 'right',
type: 'value', 
scale: true, 
splitNumber: 10,//区间分隔
  boundaryGap:true,
splitArea: { show: true } ,
show:true
 //splitLine:{show: true},//去除网格线
}*/
],
       

 dataZoom :[
            {
                type: 'slider',
                show: true,
                start: 0,
                end: 100,
                handleSize: 9,
               backgroundColor:  'rgba(47,69,84,0)' ,
        dataBackgroundColor: '#D4D4D4',
        fillerColor:'#8dc73e'
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
            name:'流量速率*10^-3(m³/s)',
            type:'line',
            smooth:true,
            data:${traffic},
           //  symbol:'none',
           
        },
        {
            name:'PH',
            smooth:true,
           // symbol:'none',
            type:'line',
            data:${ph},
            /* markLine: {
             lineStyle:{
             normal: {
        color:'#FF0000'
    },
             
             },
                data :[
    
        {name: '最大限值' ,  yAxis: 9},
        {name: '最小限值' ,  yAxis: 6}
    
    
       
  
    
]  
       }  */       
        },
         {
            name:'流速*10^-2(m/s)',
            smooth:true,
            type:'line',
         //   symbol:'none',
            data:${currentSpeed},
            
            
        },
         {
            name:'水位*10^-2(m)',
            smooth:true,
          //  symbol:'none',
            type:'line',
            data:${waterleve},
        },
        {
            name:'总流量*10^3(m³)',
            smooth:true,
            type:'line',
          //   yAxisIndex:1,
         //   symbol:'none',
            data:${ztraffic},
        }/* ,
        {
            name:'电导率(μS/cm)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${conductivity},
              yAxisIndex:0,
            
        } */,
        {
            name:'cod*10^1(mg/l)',
            smooth:true,
            type:'line',
         //   symbol:'none',
            data:${cod},
            /* markLine: {
            	
             lineStyle:{
             normal: {
        color:'#FF0000',
        
    },
             
             },
                data : [
        {name: '最大限值' ,  yAxis: 280},
]  
       }*/      
            
        },
        {
            name:'电导率*10^3(μS/cm)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${conductivity},
        //     yAxisIndex:1,
        },
        {
            name:'水温(℃)',
            smooth:true,
            type:'line',
         //   symbol:'none',
            data:${Temp},
              
            
        },
        {
            name:'浊度*10^1(NTU)',
            smooth:true,
            type:'line',
         //   symbol:'none',
            data:${Turbidity},
              
            
        },
        {
            name:'溶解氧*10^1(mg/l)',
            smooth:true,
            type:'line',
         //   symbol:'none',
            data:${Do},
              
            
        },
        {
            name:'氨氮*10^-2(mg/l)',
            smooth:true,
            type:'line',
       //     symbol:'none',
            data:${NH3N},
           /* markLine: {
            lineStyle:{
             normal: {
        color:'#FF0000'
    },
             
             },
                data : [
     {name: '最大限值' ,  yAxis: 40},
]
       }*/   
        },
         {
            name:'六价铬*10^-2(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${cr6},
           /* markLine: {
            lineStyle:{
             normal: {
        color:'#FF0000'
    },
             
             },
                data : [
     {name: '最大限值' ,  yAxis: 0.1},
    
    
]
       } */  
            
        },
        {
            name:'TOC*10^-1(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${toc},
            
        },
        {
     //    yAxisIndex:1,
            name:'固体悬浮物*10^3(mg/l)',
            smooth:true,
            type:'line',
       //     symbol:'none',
            data:${mlss},
          /*  markLine: {
            lineStyle:{
             normal: {
        color:'#FF0000'
    },
             
             },
                data : [
     {name: '最大限值' ,  yAxis: 220},
    
    
]
       }   */
            
        },
        {
            name:'总铬*10^-3(mg/l)',
            smooth:true,
            type:'line',
       //     symbol:'none',
            data:${cr},
            
        },
        {
            name:'总镍*10^-2(mg/l)',
            smooth:true,
            type:'line',
      //      symbol:'none',
            data:${ni},
            
        },
        {
            name:'总镉*10^-3(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${cd},
            
        },
        {
            name:'总铅*10^-2(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${lead},
            
        },
        {
            name:'总银(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${silver},
            
        },
        {
            name:'总汞*10^-1(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${hg},
            
        },
        {
            name:'总磷*10^-2(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${phosphor},
            
           /* markLine: {
            lineStyle:{
             normal: {
        color:'#FF0000'
    },
             
             },
                data : [
     {name: '最大限值' ,  yAxis: 4.5},
    
    
]
       } */  
        }
        ,
        {
            name:'总铜*10^-2(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${cu},
            
        },
        {
            name:'总锌*10^-2(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${zn},
            
        },
        {
            name:'氟化物*10^-2(mg/l)',
            smooth:true,
            type:'line',
        //    symbol:'none',
            data:${Flu},
            
        },
        /*,
        {
            name:'电导率',
            smooth:true,
            type:'line',
            symbol:'none',
            data:${ztraffic}
        }
        ,
        {
            name:'六价铬',
            smooth:true,
            type:'line',
            symbol:'none',
            data:${ztraffic}
        } ,,'#00ff00''#00FFFF',	#228B22   ['#CD2626', '#0000FF','#FFA500','#9370DB','#FF00FF','#00BFFF','#1874CD','#228B22','#00C5CD','#4876FF','#5CACEE']*/
    ],
   color:  [ '#CD2626', '#87cefa', '#0000FF', '#32cd32', '#6495ed','#ff69b4','#CD2626', '#0000FF','#FFA500','#9370DB','#FF00FF','#00BFFF','#1874CD','#228B22','#00C5CD','#4876FF','#5CACEE', '#ba55d3', '#cd5c5c', '#ffa500', '#40e0d0','#1e90ff', '#4876FF', '#7b68ee', '#00fa9a', '#5CACEE','#6b8e23', '#ff00ff', '#3cb371', '#b8860b', '#30e0e0' ]

};
/*var ph=${ph};
for(i=0;i<ph.length;i++){
if(ph[i]>9||ph[i]<6){
 
}
}*/

                myChart.setOption(option, true);
           window.onresize = myChart.resize;
                myChart.setOption(option);
                
                
          /*       // 图例开关的行为只会触发 legendselectchanged 事件
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
    	maxval=maxval.toFixed(2);
    	myChart.setOption({
            yAxis: [
{ 
position:'left',
type: 'value', 
scale: false, 
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
    	maxval=Math.round(maxval);
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
    	maxval=Math.round(maxval);
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
    	
    }else  if(params.name==('固体悬浮物(mg/l)')){
    	var mlss=${mlss};
    	var maxval=maxVal(mlss,220);
    	maxval=Math.round(maxval);
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
    	var phosphor=${phosphor};
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
     */
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