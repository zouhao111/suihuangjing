function p(s) {
    return s < 10 ? '0' + s: s;
}
	
function time(id ,from){
	console.log(id)
	//$(this).attr('checked', 'checked');
		//console.log($(this))
	//var from=$(this).find( "input").val();//日月年
	 if(from==1){
		 var myDate = new Date();
//获取当前年
var year=myDate.getFullYear();
//获取当前月
var month=myDate.getMonth()+1;
//获取当前日
var date=myDate.getDate(); 
var time=year+'-'+p(month)+"-"+p(date)
$('#end_datetimepicker'+id).hide();
       
 		 $('#datetimepicker'+id).datetimepicker('remove');
		
		 $('#datetimepicker'+id).datetimepicker({
     minView: "day", //选择日期后，不会再跳转去选择时分秒 
    language:  'zh-CN',
    format: 'yyyy-mm-dd',
    todayBtn:  1,
    autoclose: 1,
});
		  $('#datetimepicker'+id).val(time);
	 }
	 if(from==2){
		  var myDate = new Date();
//获取当前年
var year=myDate.getFullYear();
//获取当前月
var month=myDate.getMonth()+1;
var time=year+'-'+p(month)
$('#end_datetimepicker'+id).hide();
 // consolt.log($(this).parent().find("startTime"));
		 $('#datetimepicker'+id).datetimepicker('remove');
		
		 $('#datetimepicker'+id).datetimepicker({
       format: 'yyyy-mm',  
         weekStart: 1,  
         autoclose: true,  
         startView: 3,  
         minView: 3,  
          startDate:'2017-01',
         forceParse: false,  
         language: 'zh-CN'
});
		  $('#datetimepicker'+id).val(time);
	 }
	 if(from==4){
		  var myDate = new Date();
//获取当前年
var year=myDate.getFullYear();
var time=year
     
 $('#end_datetimepicker'+id).hide();
		 $('#datetimepicker'+id).datetimepicker('remove');
		
		 $('#datetimepicker'+id).datetimepicker({
   format: 'yyyy',  
         weekStart: 1,  
         autoclose: true,  
         startView : 4, 
         minView: 4,
         startDate:'2010',
         
         forceParse: false,  
         language: 'zh-CN'
});
		 $('#datetimepicker'+id).val(time);
	 }
	  if(from==5){
		 var myDate = new Date();
//获取当前年
var year=myDate.getFullYear();
//获取当前月
var month=myDate.getMonth()+1;
//获取当前日
var date=myDate.getDate(); 
var endTime=year+'-'+p(month)+"-"+p(date)

var date2 = new Date(myDate);

var year7=date2.getFullYear();
//获取当前月
var month7=date2.getMonth()+1;
//7天前
var date7=date2.getDate()-7;
var startTime=year7+'-'+p(month7)+"-"+p(date7)

       
       $('#end_datetimepicker'+id).show();
 		 $('#datetimepicker'+id).datetimepicker('remove');
		$('#end_datetimepicker'+id).datetimepicker('remove');
		
		 $('#datetimepicker'+id).datetimepicker({
     minView:2, //选择日期后，不会再跳转去选择时分秒 
    language:  'zh-CN',
    format: 'yyyy-mm-dd',
    todayBtn:  1,
    autoclose: 1,
});
		  $("#end_datetimepicker"+id).datetimepicker({
        minView: 2, //选择日期后，不会再跳转去选择时分秒 
    language:  'zh-CN',
    format: 'yyyy-mm-dd',
    todayBtn:  1,
    autoclose: 1,
        startDate:new Date()
    }).on("click",function(){
        $("#end_datetimepicker"+id).datetimepicker("setStartDate",$('#datetimepicker'+id).val())
    });
		  
		  $('#datetimepicker'+id).val(startTime);
		   $('#end_datetimepicker'+id).val(endTime);
		  
	 }
	}