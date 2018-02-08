<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/resources/common/jsp/taglibs.jsp"%>
<%@tagliburi="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>视频</title>
    <link rel="icon" type="image/x-icon" href="//statics.ys7.com/mall/statics/site/favicon.ico" />
    <script src="/views/admin/tdht/demo1/ckplayer/ckplayer.js"></script>
 <script src="${ctx}/resources/js/metismenu/jquery.min.js"></script>
</head>
<style>
html
{
	width:100%;
	height:100%;
	font-size:12px;
	font-family:Arial, Helvetica, sans-serif;
	-webkit-text-size-adjust:none;
	background:#FFFFFF;
	background-image: url('/views/admin/tdht/demo1/11.png');
}
.video{
width: 45%;height: 45%;
float: left;
    margin-left: 2.5%;
    margin-top: 3%;
    border: 1px solid #fff;
}
.vodie_font{
font-size: 15px;
color: #fff;
text-align: center;

margin-top: 30%;
}
.select_video{
   display: none;
}
.video_page{
width: 100%;height: 90%;

}
</style>
<body>
<input id="webUrls" type="hidden" value="${webUrls}" >
<!--注意：
    例子必须使用服务端环境运行，如：Tomcat，iis，注意浏览器的地址，需要http://开头
    直接运行html文件打开不能看（file:///开头）-->
    <div style="
    width: 40%;
    height: 70%;
    position: absolute;
    right: 50px;
    top: 140px;
">
    <div id="page1"class="video_page">
     <div id="videoPlay0" class="video"><div class="vodie_font">未安装</div></div>
      <div id="videoPlay1" class="video"><div class="vodie_font">未安装</div></div>
       <div id="videoPlay2" class="video"><div class="vodie_font">未安装</div></div>
        <div id="videoPlay3" class="video"><div class="vodie_font">未安装</div></div>
       </div>
       <div id="page2" class="video_page select_video">
        <div id="videoPlay4" class="video"><div class="vodie_font">未安装</div></div>
         <div id="videoPlay5" class="video"><div class="vodie_font">未安装</div></div>
          <div id="videoPlay6" class="video"><div class="vodie_font">未安装</div></div>
           <div id="videoPlay7" class="video"><div class="vodie_font">未安装</div></div>
            </div>
         <button  id="page_one" style="margin-left: 200px;" >上一页</button >
		    
		    <button  id="page_two" style="margin-left:20px;">下一页</button >
		    
    </div>
  
    <script>
   var videoUrl=${videoUrl};
     $.each(videoUrl, function(i, dvar){
    
    url=videoUrl[i];
   url= "hls.open.ys7.com/openlive/d93c4a5a6e94443a9baf4d0637fbd12c.m3u8"
        var flashvars;
        flashvars={
            f: '/views/admin/tdht/demo1/ckplayer/m3u8.swf',
            a: "http://"+url,
            c: 0,
            p: 1,
            s: 4,
            lv: 1
        };
        var params = {bgcolor: '#FFF', allowFullScreen: true, allowScriptAccess: 'always', wmode: 'transparent'};
        CKobject.embedSWF("/views/admin/tdht/demo1/ckplayer/ckplayer.swf", "videoPlay"+i, "video", "100%", "100%", flashvars, params);
    
    
     })
     $("#page_one").on('click',function(){
		$("#page1").show();
		$("#page2").hide();
	})
	$("#page_two").on('click',function(){
		$("#page1").hide();
		$("#page2").show();
	})
    </script>
     <!--  <div id="videoPlay1" style="width: 700px;height: 393px;"></div>
  <script>
        var flashvars1;
        flashvars1={
            f: 'ckplayer/m3u8.swf',
            a: 'http://open.ys7.com/openlive/82c0315ef8df40d695fb2006e7c38b12.m3u8', //炳坑地址
            c: 0,
            p: 1,
            s: 4,
            lv: 1
        };
        var params1 = {bgcolor: '#FFF', allowFullScreen: true, allowScriptAccess: 'always', wmode: 'transparent'};
        CKobject.embedSWF("./ckplayer/ckplayer.swf", "videoPlay1", "video", "100%", "100%", flashvars1, params1);
    </script> -->
</body>
</html>