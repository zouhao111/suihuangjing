

function  console2(data){
	   $.ajax({
          url:"/api/monitor/monitorList3",
		type:"post",
		async: true,
		dataType:"json",
		data:data, 
		success:function(result){
		   console.log(result)
		   
		   if(result.resultcode==300){
			   alert("不好意思！操作失败，请刷新页面后重新操作")
			   window.location.reload();
		   }
		   if(result.resultcode==100){
			   alert("登录超时！操作失败，请重新登陆后操作")
			   window.location.reload();
		   }
		   if(result.word==6){
			   $(this).jqLoading("destroy"); 
		   }
		    
		     result=result.result;
		     console.log(result);
		 // console.log(result.manholeValue4);
		     if(result.rid==75501330004){
		    	 data_zckj=result;
		    var manholeValue1=result.manholeValue1;
		    var manholeValue2=result.manholeValue2;
		    var manholeValue3=result.manholeValue3;
		    var pumpValue1=result.pumpValue1;
		   /*  var manholeValue4=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_zckj").removeClass("btn-success")
			    $("#button1_zckj").addClass("btn-danger")
			     $("#button1_zckj").val("1")
		   }
		   if(manholeValue1==1){
			   $("#button1_zckj").removeClass("btn-danger")
			    $("#button1_zckj").addClass("btn-success")
			     $("#button1_zckj").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_zckj").removeClass("btn-success")
			    $("#button2_zckj").addClass("btn-danger")
			     $("#button2_zckj").val("1")
		   }
		   if(manholeValue2==1){
			   $("#button2_zckj").removeClass("btn-danger")
			    $("#button2_zckj").addClass("btn-success")
			     $("#button2_zckj").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_zckj").removeClass("btn-success")
			    $("#button3_zckj").addClass("btn-danger")
			     $("#button3_zckj").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_zckj").removeClass("btn-danger")
			    $("#button3_zckj").addClass("btn-success")
			     $("#button3_zckj").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_zckj").removeClass("btn-success")
			    $("#button3_zckj").addClass("btn-danger")
			     $("#button3_zckj").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_zckj").removeClass("btn-danger")
			    $("#button3_zckj").addClass("btn-success")
			     $("#button3_zckj").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_zckj").removeClass("btn-success")
			    $("#p1_zckj").addClass("btn-danger")
			     $("#p1_zckj").val("1")
		   }
		   if(pumpValue1==1){
			   $("#p1_zckj").removeClass("btn-danger")
			    $("#p1_zckj").addClass("btn-success")
			     $("#p1_zckj").val("0")
		   }
		     }
		  if(result.rid==75501330001){
			   data_yyf=result;
		    var manholeValue1=result.manholeValue1;
		    var manholeValue3=result.manholeValue3;
		    var manholeValue2=result.manholeValue2;
		    var pumpValue1=result.pumpValue1;
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_yyf").removeClass("btn-success")
			    $("#button1_yyf").addClass("btn-danger")
			     $("#button1_yyf").val("1")
		   }
		   if(manholeValue1==1){
			   $("#button1_yyf").removeClass("btn-danger")
			    $("#button1_yyf").addClass("btn-success")
			     $("#button1_yyf").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_yyf").removeClass("btn-success")
			    $("#button2_yyf").addClass("btn-danger")
			     $("#button2_yyf").val("1")
		   }
		   if(manholeValue2==1){
			   $("#button2_yyf").removeClass("btn-danger")
			    $("#button2_yyf").addClass("btn-success")
			     $("#button2_yyf").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_yyf").removeClass("btn-success")
			    $("#button3_yyf").addClass("btn-danger")
			     $("#button3_yyf").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_yyf").removeClass("btn-danger")
			    $("#button3_yyf").addClass("btn-success")
			     $("#button3_yyf").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_yyf").removeClass("btn-success")
			    $("#button3_yyf").addClass("btn-danger")
			     $("#button3_yyf").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_yyf").removeClass("btn-danger")
			    $("#button3_yyf").addClass("btn-success")
			     $("#button3_yyf").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_yyf").removeClass("btn-success")
			    $("#p1_yyf").addClass("btn-danger")
			     $("#p1_yyf").val("1")
		   }
		   if(pumpValue1==1){
			   $("#p1_yyf").removeClass("btn-danger")
			    $("#p1_yyf").addClass("btn-success")
			     $("#p1_yyf").val("0")
		   }
		     }
		    if(result.rid==75501330002){
		    	 data_odk=result;
		    var manholeValue1=result.manholeValue1;
		    var manholeValue3=result.manholeValue3;
		    var manholeValue2=result.manholeValue2;
		    var pumpValue1=result.pumpValue1;
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_odk").removeClass("btn-success")
			    $("#button1_odk").addClass("btn-danger")
			     $("#button1_odk").val("1")
		   }
		   if(manholeValue1==1){
			   $("#button1_odk").removeClass("btn-danger")
			    $("#button1_odk").addClass("btn-success")
			     $("#button1_odk").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_odk").removeClass("btn-success")
			    $("#button2_odk").addClass("btn-danger")
			     $("#button2_odk").val("1")
		   }
		   if(manholeValue2==1){
			   $("#button2_odk").removeClass("btn-danger")
			    $("#button2_odk").addClass("btn-success")
			     $("#button2_odk").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_odk").removeClass("btn-success")
			    $("#button3_odk").addClass("btn-danger")
			     $("#button3_odk").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_odk").removeClass("btn-danger")
			    $("#button3_odk").addClass("btn-success")
			     $("#button3_odk").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_odk").removeClass("btn-success")
			    $("#button3_odk").addClass("btn-danger")
			     $("#button3_odk").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_odk").removeClass("btn-danger")
			    $("#button3_odk").addClass("btn-success")
			     $("#button3_odk").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_odk").removeClass("btn-success")
			    $("#p1_odk").addClass("btn-danger")
			     $("#p1_odk").val("1")
		   }
		   if(pumpValue1==1){
			   $("#p1_odk").removeClass("btn-danger")
			    $("#p1_odk").addClass("btn-success")
			     $("#p1_odk").val("0")
		   }
		     }
		    if(result.rid==75501330003){
		    	 data_tdht=result;
		    var manholeValue1=result.manholeValue1;
		    var manholeValue3=result.manholeValue3;
		    var manholeValue2=result.manholeValue2;
		    var pumpValue1=result.pumpValue1;
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_tdht").removeClass("btn-success")
			    $("#button1_tdht").addClass("btn-danger")
			     $("#button1_tdht").val("1")
		   }
		   if(manholeValue1==1){
			   $("#button1_tdht").removeClass("btn-danger")
			    $("#button1_tdht").addClass("btn-success")
			     $("#button1_tdht").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_tdht").removeClass("btn-success")
			    $("#button2_tdht").addClass("btn-danger")
			     $("#button2_tdht").val("1")
		   }
		   if(manholeValue2==1){
			   $("#button2_tdht").removeClass("btn-danger")
			    $("#button2_tdht").addClass("btn-success")
			     $("#button2_tdht").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_tdht").removeClass("btn-success")
			    $("#button3_tdht").addClass("btn-danger")
			     $("#button3_tdht").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_tdht").removeClass("btn-danger")
			    $("#button3_tdht").addClass("btn-success")
			     $("#button3_tdht").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_tdht").removeClass("btn-success")
			    $("#button3_tdht").addClass("btn-danger")
			     $("#button3_tdht").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_tdht").removeClass("btn-danger")
			    $("#button3_tdht").addClass("btn-success")
			     $("#button3_tdht").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_tdht").removeClass("btn-success")
			    $("#p1_tdht").addClass("btn-danger")
			     $("#p1_tdht").val("1")
		   }
		   if(pumpValue1==1){
			   $("#p1_tdht").removeClass("btn-danger")
			    $("#p1_tdht").addClass("btn-success")
			     $("#p1_tdht").val("0")
		   }
		     }
		     
		     if(result.rid==75501330005){
		    	  data_yuf=result;
		    var manholeValue1=result.manholeValue1;
		    var manholeValue3=result.manholeValue3;
		    var manholeValue2=result.manholeValue2;
		    var pumpValue1=result.pumpValue1;
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_yuf").removeClass("btn-success")
			    $("#button1_yuf").addClass("btn-danger")
			     $("#button1_yuf").val("1")
		   }
		   if(manholeValue1==1){
			   $("#button1_yuf").removeClass("btn-danger")
			    $("#button1_yuf").addClass("btn-success")
			     $("#button1_yuf").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_yuf").removeClass("btn-success")
			    $("#button2_yuf").addClass("btn-danger")
			     $("#button2_yuf").val("1")
		   }
		   if(manholeValue2==1){
			   $("#button2_yuf").removeClass("btn-danger")
			    $("#button2_yuf").addClass("btn-success")
			     $("#button2_yuf").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_yuf").removeClass("btn-success")
			    $("#button3_yuf").addClass("btn-danger")
			     $("#button3_yuf").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_yuf").removeClass("btn-danger")
			    $("#button3_yuf").addClass("btn-success")
			     $("#button3_yuf").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_yuf").removeClass("btn-success")
			    $("#button3_yuf").addClass("btn-danger")
			     $("#button3_yuf").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_yuf").removeClass("btn-danger")
			    $("#button3_yuf").addClass("btn-success")
			     $("#button3_yuf").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_yuf").removeClass("btn-success")
			    $("#p1_yuf").addClass("btn-danger")
			     $("#p1_yuf").val("1")
		   }
		   if(pumpValue1==1){
			   $("#p1_yuf").removeClass("btn-danger")
			    $("#p1_yuf").addClass("btn-success")
			     $("#p1_yuf").val("0")
		   }
		     }
		    
		    
		    $(this).jqLoading("destroy");
		    
		   }
	})
}   