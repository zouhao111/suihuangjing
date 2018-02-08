<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=EWj5lQ3L4YwQTuvyXpeCoT6j"></script>
	<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
	<script type="text/javascript" src="${ctx}/resources/js/InfoBox_min.js"></script>
	<title>添加行政区划</title>
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
	map.centerAndZoom(new BMap.Point(114.061794 ,22.553742), 12);
	map.enableScrollWheelZoom();
	var areas="${area}";
	if(areas=="baoan"){
		areas="宝安";
		if(${webCompany.companyId ==2000}){
			
			var data_info = [[113.813562,22.774615,"<div style='margin-top: 20px;margin-left: 35px;color:#FFFFFF;'>永艺发</div><br /><div style='margin-top: -10px;margin-left: 20px;'><a target='_Parent'style='color:#0071bc;' href='http://www.tdhtiot.com:3333/login?account=admin&password=system&Rid=75501330001'>点击查看详情</a></div>"],
			[113.801161,22.713418,"<div style='margin-top: 20px;margin-left: 35px;color:#FFFFFF;'>欧达可</div><br /><div style='margin-top: -10px;margin-left: 20px;'><a target='_Parent'style='color:#0071bc;' href='http://www.tdhtiot.com:3333/login?account=admin&password=system&Rid=75501330002'>点击查看详情</a></div>"],
			[114.067164,22.691745,"<div style='margin-top: 20px;margin-left: 35px;color:#FFFFFF;'>测试1</div><br /><div style='margin-top: -10px;margin-left: 20px;'><a target='_Parent'style='color:#0071bc;' href='http://www.tdhtiot.com:3333/login?account=admin&password=system&Rid=75501330003'>点击查看详情</a></div>"],
			[113.835665,22.798954,"<div style='margin-top: 20px;margin-left: 35px;color:#FFFFFF;'>中村科技</div><br /><div style='margin-top: -10px;margin-left: 20px;'><a target='_Parent'style='color:#0071bc;' href='http://www.tdhtiot.com:3333/login?account=admin&password=system&Rid=75501330004'>点击查看详情</a></div>"],
		 [114.395138,22.785101,"<div style='margin-top: 20px;margin-left: 35px;color:#FFFFFF;'>龙岗河</div><br /><div style='margin-top: -10px;margin-left: 20px;'><a target='_Parent'style='color:#0071bc;' href='indexHtml?rid=75501330005&state=${company5}'>点击查看详情</a></div>"],
		
		  [113.819648,22.787312,"<div style='margin-top: 20px;margin-left: 35px;color:#FFFFFF;'>碧头</div><br /><div style='margin-top: -10px;margin-left: 20px;'><a target='_Parent'style='color:#0071bc;' href='indexHtml?rid=75501330006&state=${company6}'>点击查看详情</a></div>"],
			[114.395174,22.790374,"<div style='margin-top: 20px;margin-left: 35px;color:#FFFFFF;'>白石桥1</div><br /><div style='margin-top: -10px;margin-left: 20px;'><a target='_Parent'style='color:#0071bc;' href='http://www.tdhtiot.com:3346/login?account=tdht2&password=1&Rid=75503780001'>点击查看详情</a></div>"],
			[114.028357,22.53314,"<div style='margin-top: 20px;margin-left: 35px;color:#FFFFFF;'>凤塘泵站2</div><br /><div style='margin-top: -10px;margin-left: 20px;'><a target='_Parent'style='color:#0071bc;' href='http://www.tdhtiot.com:3346/login?account=tdht2&password=1&Rid=75503780002'>点击查看详情</a></div>"],
		 [114.394365,22.787109,"<div style='margin-top: 20px;margin-left: 35px;color:#FFFFFF;'>白石桥2</div><br /><div style='margin-top: -10px;margin-left: 20px;'><a target='_Parent'style='color:#0071bc;' href='http://www.tdhtiot.com:3346/login?account=tdht2&password=1&Rid=75503780006'>点击查看详情</a></div>"],
		
			 [114.40157,22.786842,"<div style='margin-top: 20px;margin-left: 35px;color:#FFFFFF;'>白石桥5#2160</div><br /><div style='margin-top: -10px;margin-left: 20px;'><a target='_Parent' style='color:#0071bc;' href='http://www.tdhtiot.com:3346/login?account=tdht2&password=1&Rid=75503780013'>点击查看详情</a></div>"],
			[114.394617,22.78441,"<div style='margin-top: 20px;margin-left: 35px;color:#FFFFFF;'>白石桥5#2150</div><br /><div style='margin-top: -10px;margin-left: 20px;'><a target='_Parent'style='color:#0071bc;' href='http://www.tdhtiot.com:3346/login?account=tdht2&password=1&Rid=755037800014'>点击查看详情</a></div>"],
			[114.397689,22.783443,"<div style='margin-top: 20px;margin-left: 35px;color:#FFFFFF;'>白石桥12#</div><br /><div style='margin-top: -10px;margin-left: 20px;'><a target='_Parent'style='color:#0071bc;' href='http://www.tdhtiot.com:3346/login?account=tdht2&password=1&Rid=75503780015'>点击查看详情</a></div>"],
		]
		}
		if(${webCompany.companyId ==1}){
			var data_info = [[113.813562,22.774615,"<div style='background:url(${ctx}/resources/img/0729-02.png) no-repeat 4px 5px;'>永艺发 <br /><a href='indexHtml?rid=75501330001&state=${company1}'>点击查看详情</a></div>"]];
		}
		if(${webCompany.companyId ==2}){
			var data_info = [[113.801161,22.713418,"欧达可<br /><a href='indexHtml?rid=75501330002&state=${company2}'>点击查看详情</a>"]];
		}
		if(${webCompany.companyId ==3}){
			var data_info = [[114.067164,22.691745,"测试1<br /><a href='indexHtml?rid=75501330003&state=${company3}'>点击查看详情</a>"]];
		}
		if(${webCompany.companyId ==4}){
			var data_info = [[113.835664,22.798955,"中村科技<br /><a href='indexHtml?rid=75501330004&state=${company4}'>点击查看详情</a>"]];
		}
	}
	if(areas=="luohu"){
		areas="罗湖";
	}
	if(areas=="futian"){
		areas="福田";
	}
	if(areas=="nanshan"){
		areas="南山";
	}
	if(areas=="yantian"){
		areas="盐田";
	}
	if(areas=="longgang"){
		areas="龙岗";
	}
	
	function getBoundary(){       
		var bdary = new BMap.Boundary();
		bdary.get(areas, function(rs){       //获取行政区域
			map.clearOverlays();        //清除地图覆盖物
			
			var count = rs.boundaries.length; //行政区域的点有多少个
			
          	var pointArray = [];
			for (var i = 0; i < count; i++) {
				var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2, strokeColor: "#FF0000"}); //建立多边形覆盖物
				//map.addOverlay(ply);  //添加覆盖物
				pointArray = pointArray.concat(ply.getPath());
			}
			
			
				//var data_info = [[113.813562,22.774615,"永艺发 <br /><a href='indexHtml'>点击查看详情</a>"],
				//	 [113.801161,22.713418,"欧达可<br />点击查看详情"],
					// [114.067164,22.691745,"天地互通<br />点击查看详情"]
					//];
			
		    var markerArr0= {w:23,h:25,l:0,t:21,x:9,lb:12};//获取图片标坐标（1.绿色）正常
		    var markerArr3={w:23,h:25,l:46,t:21,x:9,lb:12};//3.红色报警
		   	var markerArr2={w:23,h:25,l:69,t:21,x:9,lb:12}//4.黄色预警
		    var markerArr1={w:23,h:25,l:115,t:21,x:9,lb:12};//6.灰色掉线
		    
		    
			var iconImg0 = createIcon(markerArr0);
			var iconImg1 = createIcon(markerArr1);
			var iconImg2 = createIcon(markerArr2);
			var iconImg3 = createIcon(markerArr3);
			
           // var marker = new BMap.Marker(point,{icon:iconImg}); 
			function createIcon(json){
		        var icon = new BMap.Icon("${ctx}/resources/img/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
		        return icon;
		    }
		   
			for(var i=0;i<data_info.length;i++){
				
			if(i==0){
				if(${company1}==0){
				iconImg=iconImg0;
				}
				if(${company1}==1){
				iconImg=iconImg1;
				}
				if(${company1}==2){
				iconImg=iconImg2;
				}
				if(${company1}==3){
				iconImg=iconImg3;
				}
			}
			if(i==1){
				if(${company2}==0){
				iconImg=iconImg0;
				}
				if(${company2}==1){
				iconImg=iconImg1;
				}
				if(${company2}==2){
				iconImg=iconImg2;
				}
				if(${company2}==3){
				iconImg=iconImg3;
				}
			}
			if(i==2){
				if(${company3}==0){
				iconImg=iconImg0;
				}
				if(${company3}==1){
				iconImg=iconImg1;
				}
				if(${company3}==2){
				iconImg=iconImg2;
				}
				if(${company3}==3){
				iconImg=iconImg3;
				}
				
			}
			if(i==3){
				if(${company4}==0){
				iconImg=iconImg0;
				}
				if(${company4}==1){
				iconImg=iconImg1;
				}
				if(${company4}==2){
				iconImg=iconImg2;
				}
				if(${company4}==3){
				iconImg=iconImg3;
				}
				
			}
			if(i==4){
				if(${company5}==0){
				iconImg=iconImg0;
				}
				if(${company5}==1){
				iconImg=iconImg1;
				}
				if(${company5}==2){
				iconImg=iconImg2;
				}
				if(${company5}==3){
				iconImg=iconImg3;
				}
			}	
			if(i==5){
				if(${company6}==0){
				iconImg=iconImg0;
				}
				if(${company6}==1){
				iconImg=iconImg1;
				}
				if(${company6}==2){
				iconImg=iconImg2;
				}
				if(${company6}==3){
				iconImg=iconImg3;
				}
			}
			if(i==6){
				if(${company7}==0){
				iconImg=iconImg0;
				}
				if(${company7}==1){
				iconImg=iconImg1;
				}
				if(${company7}==2){
				iconImg=iconImg2;
				}
				if(${company7}==3){
				iconImg=iconImg3;
				}
				
			}
			if(i==7){
				if(${company8}==0){
				iconImg=iconImg0;
				}
				if(${company8}==1){
				iconImg=iconImg1;
				}
				if(${company8}==2){
				iconImg=iconImg2;
				}
				if(${company8}==3){
				iconImg=iconImg3;
				}
				
			}
			if(i==8){
				if(${company9}==0){
				iconImg=iconImg0;
				}
				if(${company9}==1){
				iconImg=iconImg1;
				}
				if(${company9}==2){
				iconImg=iconImg2;
				}
				if(${company9}==3){
				iconImg=iconImg3;
				}
			}
				if(i==9){
				if(${company10}==0){
				iconImg=iconImg0;
				}
				if(${company10}==1){
				iconImg=iconImg1;
				}
				if(${company10}==2){
				iconImg=iconImg2;
				}
				if(${company10}==3){
				iconImg=iconImg3;
				}
			}
			if(i==10){
				if(${company11}==0){
				iconImg=iconImg0;
				}
				if(${company11}==1){
				iconImg=iconImg1;
				}
				if(${company11}==2){
				iconImg=iconImg2;
				}
				if(${company11}==3){
				iconImg=iconImg3;
				}
				
			}
			if(i==11){
				if(${company12}==0){
				iconImg=iconImg0;
				}
				if(${company12}==1){
				iconImg=iconImg1;
				}
				if(${company12}==2){
				iconImg=iconImg2;
				}
				if(${company12}==3){
				iconImg=iconImg3;
				}
				
			}
			
				var marker = new BMap.Marker(new BMap.Point(data_info[i][0],data_info[i][1]),{icon:iconImg});  // 创建标注
				var content = data_info[i][2];
				
				map.addOverlay(marker);               // 将标注添加到地图中
				addClickHandler(content,marker);
				
				var cr = new BMap.CopyrightControl({anchor:BMAP_ANCHOR_TOP_LEFT});   //设置版权控件位置
				map.addControl(cr); //添加版权控件
			
				var bs = map.getBounds();   //返回地图可视区域
			  	cr.addCopyright({id: 1, content: "<img src='${ctx}/resources/img/0729-01.png' />", bounds: bs});   
				//Copyright(id,content,bounds)类作为CopyrightControl.addCopyright()方法的参数
			}
			
				
			var infoBox = new BMapLib.InfoBox(map,content,{
				boxStyle:{
					background:"url('${ctx}/resources/img/0729-02.png') no-repeat center top"
					,width: "140px"
					,height: "110px"
				}
				,closeIconMargin: "1px 1px 0 0"
				,enableAutoPan: true
				,align: INFOBOX_AT_TOP
			});
			
			function addClickHandler(content,marker){
				marker.addEventListener("click",function(e){
				infoBox.open(marker);
				openInfo(content,e)
				
				});
				marker.addEventListener("mouseout",function(){
				setTimeout(function(){
		infoBox.close(marker);
	        }, 2000);
				
				});
			}
			 function openInfo(content,e){
				var p = e.target;
				var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
				infoBox.setContent(content);//向信息框添加类容
				
				
				//var infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象 
				//map.openInfoWindow(infoWindow,point); //开启信息窗口
			} 
			
			map.setViewport(pointArray);    //调整视野
		});
	}
	setTimeout(function(){
		getBoundary();
	}, 2000);
	
</script>
