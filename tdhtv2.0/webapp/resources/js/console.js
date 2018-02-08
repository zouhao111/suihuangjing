

function  console1(data){
	
	   $.ajax({
          url:"/api/monitor/monitorList2",
		type:"post",
		async: false,
		dataType:"json",
		data:data,
		success:function(result){
		//	   alert("xsss"+result.word);
		   if(result.word==6){
			   $(this).jqLoading("destroy"); 
		   }
		//   alert("x"+result.rid);
		     result=result.result;
		     console.log(result);
		 // console.log(result.manholeValue4);
		     if(result.rid==75501330004){
		 // 	   alert("y"+result.rid);
		    	 data_zckj=result;
		    var manholeValue1=result.manholeValue1;
		    var manholeValue2=result.manholeValue2;
		    var manholeValue3=result.manholeValue3;
		    var pumpValue1=result.pumpValue1;
		   /*  var manholeValue4=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		    
		//    alert(manholeValue1);
		   if(manholeValue1==0){
			//   alert("22222222");
			   $("#button1_zckj").removeClass("btn_off")
			    $("#button1_zckj").addClass("btn_on")
			     $("#button1_zckj").val("1")
		   }
		   if(manholeValue1==1){
			   $("#button1_zckj").removeClass("btn_on")
			    $("#button1_zckj").addClass("btn_off")
			     $("#button1_zckj").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_zckj").removeClass("btn_off")
			    $("#button2_zckj").addClass("btn_on")
			     $("#button2_zckj").val("1")
		   }
		   if(manholeValue2==1){
			   $("#button2_zckj").removeClass("btn_on")
			    $("#button2_zckj").addClass("btn_off")
			     $("#button2_zckj").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_zckj").removeClass("btn_off")
			    $("#button3_zckj").addClass("btn_on")
			     $("#button3_zckj").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_zckj").removeClass("btn_on")
			    $("#button3_zckj").addClass("btn_off")
			     $("#button3_zckj").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_zckj").removeClass("btn_off")
			    $("#button3_zckj").addClass("btn_on")
			     $("#button3_zckj").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_zckj").removeClass("btn_on")
			    $("#button3_zckj").addClass("btn_off")
			     $("#button3_zckj").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_zckj").removeClass("btn_off")
			    $("#p1_zckj").addClass("btn_on")
			     $("#p1_zckj").val("1")
		   }
		   if(pumpValue1==1){
			   $("#p1_zckj").removeClass("btn_on")
			    $("#p1_zckj").addClass("btn_off")
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
			   $("#button1_yyf").removeClass("btn_off")
			    $("#button1_yyf").addClass("btn_on")
			     $("#button1_yyf").val("1")
		   }
		   if(manholeValue1==1){
			   $("#button1_yyf").removeClass("btn_on")
			    $("#button1_yyf").addClass("btn_off")
			     $("#button1_yyf").val("0")
		   }
		   /*if(manholeValue2==0){
			   $("#button2_yyf").removeClass("btn_off")
			    $("#button2_yyf").addClass("btn_on")
			     $("#button2_yyf").val("1")
		   }
		   if(manholeValue2==1){
			   $("#button2_yyf").removeClass("btn_on")
			    $("#button2_yyf").addClass("btn_off")
			     $("#button2_yyf").val("0")
		   }*/
		   if(manholeValue3==0){
			   $("#button3_yyf").removeClass("btn_off")
			    $("#button3_yyf").addClass("btn_on")
			     $("#button3_yyf").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_yyf").removeClass("btn_on")
			    $("#button3_yyf").addClass("btn_off")
			     $("#button3_yyf").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_yyf").removeClass("btn_off")
			    $("#button3_yyf").addClass("btn_on")
			     $("#button3_yyf").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_yyf").removeClass("btn_on")
			    $("#button3_yyf").addClass("btn_off")
			     $("#button3_yyf").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_yyf").removeClass("btn_off")
			    $("#p1_yyf").addClass("btn_on")
			     $("#p1_yyf").val("1")
		   }
		   if(pumpValue1==1){
			   $("#p1_yyf").removeClass("btn_on")
			    $("#p1_yyf").addClass("btn_off")
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
			   $("#button1_odk").removeClass("btn_off")
			    $("#button1_odk").addClass("btn_on")
			     $("#button1_odk").val("1")
		   }
		   if(manholeValue1==1){
			   $("#button1_odk").removeClass("btn_on")
			    $("#button1_odk").addClass("btn_off")
			     $("#button1_odk").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_odk").removeClass("btn_off")
			    $("#button2_odk").addClass("btn_on")
			     $("#button2_odk").val("1")
		   }
		   if(manholeValue2==1){
			   $("#button2_odk").removeClass("btn_on")
			    $("#button2_odk").addClass("btn_off")
			     $("#button2_odk").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_odk").removeClass("btn_off")
			    $("#button3_odk").addClass("btn_on")
			     $("#button3_odk").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_odk").removeClass("btn_on")
			    $("#button3_odk").addClass("btn_off")
			     $("#button3_odk").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_odk").removeClass("btn_off")
			    $("#button3_odk").addClass("btn_on")
			     $("#button3_odk").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_odk").removeClass("btn_on")
			    $("#button3_odk").addClass("btn_off")
			     $("#button3_odk").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_odk").removeClass("btn_off")
			    $("#p1_odk").addClass("btn_on")
			     $("#p1_odk").val("1")
		   }
		   if(pumpValue1==1){
			   $("#p1_odk").removeClass("btn_on")
			    $("#p1_odk").addClass("btn_off")
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
			   $("#button1_tdht").removeClass("btn_off")
			    $("#button1_tdht").addClass("btn_on")
			     $("#button1_tdht").val("1")
		   }
		   if(manholeValue1==1){
			   $("#button1_tdht").removeClass("btn_on")
			    $("#button1_tdht").addClass("btn_off")
			     $("#button1_tdht").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_tdht").removeClass("btn_off")
			    $("#button2_tdht").addClass("btn_on")
			     $("#button2_tdht").val("1")
		   }
		   if(manholeValue2==1){
			   $("#button2_tdht").removeClass("btn_on")
			    $("#button2_tdht").addClass("btn_off")
			     $("#button2_tdht").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_tdht").removeClass("btn_off")
			    $("#button3_tdht").addClass("btn_on")
			     $("#button3_tdht").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_tdht").removeClass("btn_on")
			    $("#button3_tdht").addClass("btn_off")
			     $("#button3_tdht").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_tdht").removeClass("btn_off")
			    $("#button3_tdht").addClass("btn_on")
			     $("#button3_tdht").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_tdht").removeClass("btn_on")
			    $("#button3_tdht").addClass("btn_off")
			     $("#button3_tdht").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_tdht").removeClass("btn_off")
			    $("#p1_tdht").addClass("btn_on")
			     $("#p1_tdht").val("1")
		   }
		   if(pumpValue1==1){
			   $("#p1_tdht").removeClass("btn_on")
			    $("#p1_tdht").addClass("btn_off")
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
			   $("#button1_yuf").removeClass("btn_off")
			    $("#button1_yuf").addClass("btn_on")
			     $("#button1_yuf").val("1")
		   }
		   if(manholeValue1==1){
			   $("#button1_yuf").removeClass("btn_on")
			    $("#button1_yuf").addClass("btn_off")
			     $("#button1_yuf").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_yuf").removeClass("btn_off")
			    $("#button2_yuf").addClass("btn_on")
			     $("#button2_yuf").val("1")
		   }
		   if(manholeValue2==1){
			   $("#button2_yuf").removeClass("btn_on")
			    $("#button2_yuf").addClass("btn_off")
			     $("#button2_yuf").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_yuf").removeClass("btn_off")
			    $("#button3_yuf").addClass("btn_on")
			     $("#button3_yuf").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_yuf").removeClass("btn_on")
			    $("#button3_yuf").addClass("btn_off")
			     $("#button3_yuf").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_yuf").removeClass("btn_off")
			    $("#button3_yuf").addClass("btn_on")
			     $("#button3_yuf").val("1")
		   }
		   if(manholeValue3==1){
			   $("#button3_yuf").removeClass("btn_on")
			    $("#button3_yuf").addClass("btn_off")
			     $("#button3_yuf").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_yuf").removeClass("btn_off")
			    $("#p1_yuf").addClass("btn_on")
			     $("#p1_yuf").val("1")
		   }
		   if(pumpValue1==1){
			   $("#p1_yuf").removeClass("btn_on")
			    $("#p1_yuf").addClass("btn_off")
			     $("#p1_yuf").val("0")
		   }
		     }
		    
		 
		    
		    
		   }
	})
}   