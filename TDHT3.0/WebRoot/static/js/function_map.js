function map_com_conf(R_ID){
		  $.ajax({
          url:'map_com_conf',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			if(data.result=='success'){
		 $.each(data.data, function(i, dvar){
			$("#reportTable_com tbody").append("<tr><td>"+dvar.param_name+"</td><td>"+dvar.limitLL+"</td></tr>")
			
			 
		 })
		 }else{
			
			 
		 }
		 
		},
	      })
		
		}
	function map_video(R_ID){
		  $.ajax({
          url:'map_video',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			if(data.result=='success'){
		 $.each(data.varList, function(i, dvar){
			 
			 url=dvar.video_url;
			 
			 url='http://hls.open.ys7.com/openlive/82c0315ef8df40d695fb2006e7c38b12.m3u8'
			 var flashvars;
        flashvars={
            f: 'static/ckplayer/m3u8.swf',
            a: url,
            c: 0,
            p: 1,
            s: 4,
            lv: 1
        };
        var params = {bgcolor: '#FFF', allowFullScreen: true, allowScriptAccess: 'always', wmode: 'transparent'};
        CKobject.embedSWF("static/ckplayer/ckplayer.swf", "videoPlay"+i, "video", "100%", "100%", flashvars, params);
			
			
			 
		 })
		 }else{
			
			 
		 }
		 
		}
	      })
		
		}
	function map_day_poll_line(R_ID){
		var main_line1 = echarts.init(document.getElementById('main_line2')); 
		main_line1.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
		var main_line3 = echarts.init(document.getElementById('main_line3')); 
		main_line3.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
		  $.ajax({
          url:'map_day_poll_line',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			if(data.result=='success'){
			$("#main_line2").show();	
			$("#main_line3").show();	
			console.log(data.varList);
			var strTimes=data.strTimes;
			var varList=data.varList
			var poll_type=data.poll_type
			
			var series=[];
    for(var i = 0;i<varList.length;i++){
    	
        series.push({
             name:varList[i].param_name_cn,
            type:'line',
            data:varList[i].dataList,
        });
    }
		   option = {
    title: {
        text: '最近7天每日污染物总量',
         top:0,
          textStyle:{
           color:'#28a0d2',
           
       },
    },
    tooltip: {
        trigger: 'axis'
        
    },
    
   legend: {
        data:poll_type,
         type: 'scroll',
        orient: 'vertical',
        right: 0,
        top: 20,
        bottom: 0,
        textStyle:{
           color:'#28a0d2',
           
       },
    },
    grid:{
    	right:'30%',
    },
    xAxis:  {
    	 axisLine:{
        lineStyle:{
           color:'#28a0d2',
        } , 
       },
        type: 'category',
        boundaryGap: false,
        data: strTimes,
        
    },
    yAxis: {
    	 axisLine:{
        lineStyle:{
           color:'#28a0d2',
        } , 
       },
        type: 'value',
        splitArea : {show : true}//保留网格区域
       /* axisLabel: {
            formatter: '{value} °C'
        }*/
    },
    series: series
};
		   var series2=[];
		    for(var a = 0;a<varList.length;a++){
    	
        series2.push({
             name:varList[a].param_name_cn,
            type:'line',
            data:varList[a].dataList_avg,
        });
    }
	option3 = {
    title: {
        text: '最近7天每日污染物平均浓度',
         top:0,
          textStyle:{
           color:'#28a0d2',
           
       },
    },
    tooltip: {
        trigger: 'axis'
        
    },
    
   legend: {
        data:poll_type,
         type: 'scroll',
        orient: 'vertical',
        right: 0,
        top: 20,
        bottom: 0,
        textStyle:{
           color:'#28a0d2',
           
       },
    },
    grid:{
    	right:'30%',
    },
    xAxis:  {
    	 axisLine:{
        lineStyle:{
           color:'#28a0d2',
        } , 
       },
        type: 'category',
        boundaryGap: false,
        data: strTimes,
        
    },
    yAxis: {
    	 axisLine:{
        lineStyle:{
           color:'#28a0d2',
        } , 
       },
        type: 'value',
        splitArea : {show : true}//保留网格区域
       /* axisLabel: {
            formatter: '{value} °C'
        }*/
    },
    series: series2
};
		   
		  main_line1.setOption(option, true);
           window.onresize = main_line1.resize;
                main_line1.setOption(option);
                
                 main_line1.hideLoading();
		     main_line3.setOption(option3, true);
           window.onresize = main_line3.resize;
                main_line3.setOption(option);
                
                 main_line3.hideLoading();
		   
		   
		 }else{
			 $("#main_line2").hide();	
			  $("#main_line3").hide();	
		 }
		 
		 
		}
	      })
		}
	
	
	
	
	
	
	
	function map_day_line(R_ID){
		var main_line1 = echarts.init(document.getElementById('main_line1')); 
		main_line1.showLoading('default', {text:'统计中，请稍候...', color: '#c23531',
  textColor: '#000',
  maskColor: 'rgba(255, 255, 255, 0.8)',
  zlevel: 0});
		  $.ajax({
          url:'map_day_line',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			if(data.result=='success'){
			$("#map_day_line").show();	
			console.log(data.varList);
			var strTimes=data.strTimes;
			var varList=data.varList
			var poll_type=data.poll_type
			
			var series=[];
    for(var i = 0;i<varList.length;i++){
    	
        series.push({
             name:varList[i].param_name_cn,
            type:'line',
            data:varList[i].dataList,
        });
    }
		   option = {
    title: {
        text: '最近7天每日排放量',
         top:0,
          textStyle:{
           color:'#28a0d2',
           
       },
    },
    tooltip: {
        trigger: 'axis'
        
    },
    
   legend: {
        data:poll_type,
        type: 'scroll',
        orient: 'vertical',
        right: 0,
        top: 20,
        bottom: 0,
        textStyle:{
           color:'#28a0d2',
           
       },
    },
     grid:{
    	right:'20%',
    },
    xAxis:  {
    	 axisLine:{
        lineStyle:{
           color:'#28a0d2',
        } , 
       },
        type: 'category',
        boundaryGap: false,
        data: strTimes,
        
    },
    yAxis: {
    	 axisLine:{
        lineStyle:{
           color:'#28a0d2',
        } , 
       },
        type: 'value',
        splitArea : {show : true}//保留网格区域
       /* axisLabel: {
            formatter: '{value} °C'
        }*/
    },
    series: series
};
		   
		   
		  main_line1.setOption(option, true);
           window.onresize = main_line1.resize;
                main_line1.setOption(option);
                
                 main_line1.hideLoading();
		   
		   
		 }else{
			 $("#map_day_line").hide();	
		 }
		 
		 
		}
	      })
		}
	
	
	
	function map_water(R_ID){
		  $.ajax({
          url:'map_water',
		type:"post",
		async: true,
		dataType:"json",
		data:{R_ID},
		success:function(data){
			if(data.result=='success'){
			$("#map_water").show();	
		 $.each(data.varList, function(i, dvar){
			
			 if(dvar.param_type==1){
				 $("#map_waters").append("<div class='font_div'><div class='font_div3'>"+dvar.param_value.toFixed(dvar.decimal_number)+"</div><div class='font_div2'>"+dvar.param_name_cn+"</div></div>")
			 }
		 })
		 }
		 
		}
	      })
		
		}