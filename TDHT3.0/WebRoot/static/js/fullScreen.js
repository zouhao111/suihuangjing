/*
 * 浏览器全屏
 */
function fullScreen() {
alert("1")
	  var el = document.documentElement;

	  var rfs = el.requestFullScreen || el.webkitRequestFullScreen;

	  if(typeof rfs != "undefined" && rfs) {

	    rfs.call(el);

	  } else if(typeof window.ActiveXObject != "undefined") {

	    var wscript = new ActiveXObject("WScript.Shell");

	    if(wscript != null) {

	        wscript.SendKeys("{F11}");

	    }

	}else if (el.msRequestFullscreen) {

		el.msRequestFullscreen();

	}else if(el.oRequestFullscreen){
		
		el.oRequestFullscreen();
		
    }else{
    	
    	swal({   title: "浏览器不支持全屏调用！",   text: "请更换浏览器或按F11键切换全屏！(3秒后自动关闭)", type: "error",  timer: 3000 });	
	       
    }

}

/*
 * 浏览器退出全屏
 */
function exitFullScreen() {

	  var el = document;

	  var cfs = el.cancelFullScreen || el.webkitCancelFullScreen || el.exitFullScreen;

	  if(typeof cfs != "undefined" && cfs) {

	    cfs.call(el);

	  } else if(typeof window.ActiveXObject != "undefined") {

	    var wscript = new ActiveXObject("WScript.Shell");

	    if(wscript != null) {

	        wscript.SendKeys("{F11}");

	    }

	}else if (el.msExitFullscreen) {

		el.msExitFullscreen();

	}else if(el.oRequestFullscreen){
		
		el.oCancelFullScreen();
		
    }else{ 
   	
    	swal({   title: "浏览器不支持全屏调用！",   text: "请更换浏览器或按F11键切换全屏！(3秒后自动关闭)", type: "error",  timer: 3000 });	
    }  
	  
}