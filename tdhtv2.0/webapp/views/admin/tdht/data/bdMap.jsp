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
	<title>添加行政区划</title>
</head>
<body>
	<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	map.centerAndZoom(new BMap.Point(114.061794 ,22.553742), 12);
	map.enableScrollWheelZoom();
	
	function getBoundary(){       
		var bdary = new BMap.Boundary();
		bdary.get("深圳", function(rs){       //获取行政区域
			map.clearOverlays();        //清除地图覆盖物
			var count = rs.boundaries.length; //行政区域的点有多少个
			if (count === 0) {
				alert('未能获取当前输入行政区域');
				return ;
			}
          	var pointArray = [];
			for (var i = 0; i < count; i++) {
				var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2, strokeColor: "#ff0000"}); //建立多边形覆盖物
				map.addOverlay(ply);  //添加覆盖物
				pointArray = pointArray.concat(ply.getPath());
			}
			
			
			var data_info = [[113.813562,22.774615,"地址：北京市东城区王府井大街88号乐天银泰百货八层"],
					 [113.801161,22.713418,"地址：北京市东城区东华门大街"],
					 [114.067164,22.691745,"地址：北京市东城区正义路甲5号"]
					];
			var opts = {
				width : 250,     // 信息窗口宽度
				height: 80,     // 信息窗口高度
				title : "信息窗口" , // 信息窗口标题
				enableMessage:true//设置允许信息窗发送短息
			   };
	
			for(var i=0;i<data_info.length;i++){
				var marker = new BMap.Marker(new BMap.Point(data_info[i][0],data_info[i][1]));  // 创建标注
				var content = data_info[i][2];
				map.addOverlay(marker);               // 将标注添加到地图中
			}
			
			
			
			
			
			
			map.setViewport(pointArray);    //调整视野
		});
	}
	setTimeout(function(){
		getBoundary();
	}, 2000);
	
</script>
