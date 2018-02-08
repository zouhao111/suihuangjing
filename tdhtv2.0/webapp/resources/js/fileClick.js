var booClick = true;

function clickCom(rid) {
	if (booClick) {
       if(rid==75501330001){
    	   $("#left_img").html("永艺发"); 
       }else if(rid==75501330002){
    	  $("#left_img").html("欧达可");
       }else if(rid==75501330003){
    	   	$("#left_img").html("测试一");
       }else if(rid==75501330004){
    	  $("#left_img").html("中村科技");
       }else if(rid==75501330005){
    	 	$("#left_img").html("测试二");
       }
		
		
		
		booClick = false;
		var Rid =rid
		webUrl1 = $("#mainframe").contents().find("#webUrls").val();
		//alert(webUrl1+"   22")
		//alert(webUrl1!=undefined)
		if (webUrl1 != undefined) {
			webUrl = webUrl1
		} else {
			//alert("---333--")
			webUrl2 = $("#mainframe").contents().find("#hidden3").val();
			webUrl = webUrl2

			// alert(webUrl+"---333--")
			startaaa(Rid);
			//window.clearInterval(timer); 
		}

		//	alert(webUrl+"   55")
		//alert(webUrl)

		URLstr(Rid)
		var url = webUrl + "&rid=" + Rid
		//console.log(url+"        bb  ")
		$("#yyf1").attr("href", url);
		document.getElementById("yyf1").click();//打开页面后默认点击
		
		setTimeout(function() {
			booClick = true;
		}, 1000);

	} else {
		setTimeout("clickyyf()", 1500);
	}

}














function clickyyf() {
	if (booClick) {
     
		booClick = false;
		var yyfRid = 75501330001
		webUrl1 = $("#mainframe").contents().find("#webUrls").val();
		//alert(webUrl1+"   22")
		//alert(webUrl1!=undefined)
		if (webUrl1 != undefined) {
			webUrl = webUrl1
		} else {
			//alert("---333--")
			webUrl2 = $("#mainframe").contents().find("#hidden3").val();
			webUrl = webUrl2

			// alert(webUrl+"---333--")
			startaa(yyfRid);
			//window.clearInterval(timer); 
		}

		//	alert(webUrl+"   55")
		//alert(webUrl)

		URLstr(yyfRid)
		var url = webUrl + "&rid=" + yyfRid
		//console.log(url+"        bb  ")
		$("#yyf1").attr("href", url);
		document.getElementById("yyf1").click();//打开页面后默认点击
		setTimeout(function() {
			booClick = true;
		}, 1000);

	} else {
		setTimeout("clickyyf()", 1500);
	}

}

function clickodk() {
	if (booClick) {
		
		booClick = false;
		var odkRid = 75501330002
		var webUrl1 = $("#mainframe").contents().find("#webUrls").val();

		if (webUrl1 != undefined) {
			webUrl = webUrl1
		} else {
			webUrl2 = $("#mainframe").contents().find("#hidden3").val();
			webUrl = webUrl2
			//window.clearInterval(timer); 
			startaa(odkRid);
		}

		URLstr(odkRid)
		var url = webUrl + "&rid=" + odkRid
		$("#odk1").attr("href", url);
		document.getElementById("odk1").click();//打开页面后默认点击
		setTimeout(function() {
			booClick = true;
		}, 1000);
	} else {
		setTimeout("clickodk()", 1500);
	}
}

function clicktdht() {
	if (booClick) {
	
		booClick = false;
		var tdhtRid = 75501330003
		var webUrl1 = $("#mainframe").contents().find("#webUrls").val();

		if (webUrl1 != undefined) {
			webUrl = webUrl1
		} else {
			webUrl2 = $("#mainframe").contents().find("#hidden3").val();
			webUrl = webUrl2
			startaa(tdhtRid);
			//window.clearInterval(timer); 
		}

		//alert(webUrl)
		console.log(webUrl)

		URLstr(tdhtRid)
		var url = webUrl + "&rid=" + tdhtRid
		$("#tdht1").attr("href", url);
		document.getElementById("tdht1").click();//打开页面后默认点击
		setTimeout(function() {
			booClick = true;
		}, 1000);
	} else {
		setTimeout("clicktdht()", 1500);
	}
}
function clickzckj() {
	if (booClick) {
		
		booClick = false;
		var mgRid = 75501330004
		var webUrl1 = $("#mainframe").contents().find("#webUrls").val();

		if (webUrl1 != undefined) {
			webUrl = webUrl1
		} else {
			webUrl2 = $("#mainframe").contents().find("#hidden3").val();
			webUrl = webUrl2
			startaa(mgRid);
			//window.clearInterval(timer); 
		}

		//alert(webUrl)
		console.log(webUrl)

		URLstr(mgRid)
		var url = webUrl + "&rid=" + mgRid
		$("#company_11").attr("href", url);
		document.getElementById("company_11").click();//打开页面后默认点击
		setTimeout(function() {
			booClick = true;
		}, 1000);
	} else {
		setTimeout("clickzckj()", 1500);
	}
}

function clickryf() {
	if (booClick) {
	
		booClick = false;
		var hgRid = 75501330005
		var webUrl1 = $("#mainframe").contents().find("#webUrls").val();

		if (webUrl1 != undefined) {
			webUrl = webUrl1
		} else {
			webUrl2 = $("#mainframe").contents().find("#hidden3").val();
			webUrl = webUrl2
			startaa(hgRid);
			//window.clearInterval(timer); 
		}

		//alert(webUrl)
		console.log(webUrl)

		URLstr(hgRid)
		var url = webUrl + "&rid=" + hgRid
		$("#company_22").attr("href", url);
		document.getElementById("company_22").click();//打开页面后默认点击
		setTimeout(function() {
			booClick = true;
		}, 1000);
	} else {
		setTimeout("clickryf()", 1200);
	}
}
function startaaa(Rid) {
	//alert(Rid+"    33")
	var webUrl = $("#mainframe").contents().find("#hidden2").val();
	urll = webUrl;
	boo = false;
}
