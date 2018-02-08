<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html {width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#allmap{width:100%;height:100%;}
		p{margin-left:5px; font-size:14px;}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=EWj5lQ3L4YwQTuvyXpeCoT6j"></script>
	<script type="text/javascript" src="${ctx}/resources/js/InfoBox_min.js"></script>
	<title>公司详细信息</title>
</head>
<body>
<input id="webUrls" type="hidden" value="${webUrls}" >
	<input id="rid" type="hidden"  value="${rid}" >
	<input id="areatype" type="hidden"  value="${areatype}" >
	<div id="allmap"></div>
	
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point =null;
	if(${rid}=='75501330001'){
		point= new BMap.Point(113.813562,22.774615);
	}
	if(${rid}=='75501330002'){
		point= new BMap.Point(113.801161,22.713418);
	}
	if(${rid}=='75501330003'){
		point= new BMap.Point(114.067164,22.691745);
	}
	if(${rid}=='75501330004'){
		point= new BMap.Point(113.835664,22.798955);
	}
	if(${rid}=='75501330005'){
		point= new BMap.Point(113.835664,22.798955);
	}
	if(${rid}=='75501330006'){
		point= new BMap.Point(114.067164,22.691745);
	}
	if(${rid}=='75501330008'){
		point= new BMap.Point(113.810217,22.786339);
	}
	if(${rid}=='75501330009'){
		point= new BMap.Point(113.808389,22.788259);
	}
	if(${rid}=='75501330010'){
		point= new BMap.Point(113.814996,22.781932);
	}
	if(${rid}=='75501330011'){
		point= new BMap.Point(113.813629,22.784438);
	}
	if(${rid}=='75501330012'){
		point= new BMap.Point(113.814447,22.783441);
	}
	
	  		var markerArr0= {w:23,h:25,l:0,t:21,x:9,lb:12};//获取图片标坐标（1.绿色）正常
		    var markerArr3={w:23,h:25,l:46,t:21,x:9,lb:12};//3.红色报警
		   	var markerArr2={w:23,h:25,l:69,t:21,x:9,lb:12}//4.黄色预警
		    var markerArr1={w:23,h:25,l:115,t:21,x:9,lb:12};//6.灰色掉线
		    
		    
			var iconImg0 = createIcon(markerArr0);
			var iconImg1 = createIcon(markerArr1);
			var iconImg2 = createIcon(markerArr2);
			var iconImg3 = createIcon(markerArr3);
			
	
			if(${state}==0){iconImg=iconImg0;}
			if(${state}==1){iconImg=iconImg1;}
			if(${state}==2){iconImg=iconImg2;}
			if(${state}==3){iconImg=iconImg3;}
		
			function createIcon(json){
		        var icon = new BMap.Icon("${ctx}/resources/img/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
		        return icon;
		    }
	
	
	var html = ["<div class='infoBoxContent'><div class='title' style='margin-top: 20px;margin-left: 55px;color:#FFFFFF;'>${datas2.companyName}</div>",
				"<br /><div style='margin-top: -10px;margin-left: 25px;color:#0071bc;'>水位：<fmt:formatNumber type='number' value='${dataOne.waterlevel}' pattern='0.000'/>"
				,"<br />流速：<fmt:formatNumber type='number' value='${dataOne.id_CurrentSpeed}' pattern='0.000'/> "
				,"<br />流量速率：<fmt:formatNumber type='number' value='${dataOne.id_traffic}' pattern='0.0000' />"
				,"<br />ph：<fmt:formatNumber type='number' value='${datas2.realPh}' pattern='0.0'/>"
				,"<br /><a href='doGet?rid=${rid}' style='color:#0071bc;'>查看详细数据</a>"
				,"</div>"
				,"</div>"];
	var infoBox = new BMapLib.InfoBox(map,html.join(""),{
		boxStyle:{
			background:"url('${ctx}/resources/img/0729-06.png') no-repeat center top"
			,width: "170px"
			,height: "180px"
		}
		,closeIconMargin: "1px 1px 0 0"
		,enableAutoPan: true
		,align: INFOBOX_AT_TOP
	});
	
	
	
	var marker = new BMap.Marker(point,{icon:iconImg});  // 创建标注
	map.addOverlay(marker);              // 将标注添加到地图中
	map.centerAndZoom(point, 15);
	map.enableScrollWheelZoom(true);//地图缩放
	infoBox.open(marker);//默认打开信息窗口
	
	var cr = new BMap.CopyrightControl({anchor:BMAP_ANCHOR_TOP_LEFT});   //设置版权控件位置
				map.addControl(cr); //添加版权控件
			
	var bs = map.getBounds();   //返回地图可视区域
  	cr.addCopyright({id: 1, content: "<img src='${ctx}/resources/img/0729-01.png' />", bounds: bs});  
  	
  	
	
	marker.addEventListener("click", function(){
	infoBox.open(marker); //点击标注后打开信息窗口
});

	
	/* var opts = {
	  width : 170,     // 信息窗口宽度
	  height: 190,     // 信息窗口高度
	  title : "名称：${datas2.companyName}" , // 信息窗口标题
	  enableMessage:true,//设置允许信息窗发送短息
	  message:"消息记录"
	}
	var infoWindow = new BMap.InfoWindow("<div style='background:url(${ctx}/resources/img/0729-06.png);height:230px;width:160px;'>水位：<fmt:formatNumber type='number' value='${dataOne.waterlevel}' pattern='0.000'/> <br />" +
										 "流速：<fmt:formatNumber type='number' value='${dataOne.id_CurrentSpeed}' pattern='0.000'/> <br />" +
										 "流量速率：<fmt:formatNumber type='number' value='${dataOne.id_traffic}' pattern='0.0000' /> <br />" +
										 "ph：<fmt:formatNumber type='number' value='${datas2.realPh}' pattern='0.00'/> <br />" +
										 "<a href='doGet?rid=${rid}'>查看详细数据</a></div>", opts);  // 创建信息窗口对象 
	marker.addEventListener("mouseover", function(){
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	}); */
</script>
