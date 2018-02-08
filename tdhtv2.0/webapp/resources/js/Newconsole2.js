

function  console2(data){
	
	   $.ajax({
          url:"/admin/tdht/newMonitors/monitorList4",
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
		  
		    
		   results=result.result;
		    result="{"+results;
		    console.log(result)
              
		     datass=eval("("+result+")"); 
		    datass=datass.锘縶result;
		    var result_6=null;
			  var result_7=null;
	//	var datass=eval(result)
		    console.log(datass)
		     for(i=0;i<datass.length;i++){
		    	 if(datass[i].Rid==75501330001){
		    		 result_yyf=datass[i];
		    	 }else  if(datass[i].Rid==75501330002){
		    		 result_odk=datass[i];
		    	 }else  if(datass[i].Rid==75501330003){
		    		 result_tdht=datass[i];
		    	 }else  if(datass[i].Rid==75501330004){
		    		 result_zckj=datass[i];
		    	 }else  if(datass[i].Rid==75501330005){
		    		 result_tdht2=datass[i];
		    	 }else  if(datass[i].Rid==75501330008){
		    		 result_jb=datass[i];
		    	 }else  if(datass[i].Rid==75501330009){
		    		 result_td=datass[i];
		    	 }else  if(datass[i].Rid==75501330010){
		    		 result_bc=datass[i];
		    	 }else  if(datass[i].Rid==75501330011){
		    		 result_6=datass[i];
		    	 }else  if(datass[i].Rid==75501330012){
		    		 result_7=datass[i];
		    	 }
		     }
		  
		    	 data_zckj=result_zckj;
		    var manholeValue1=result_zckj.manholeValue1;
		    var manholeValue2=result_zckj.manholeValue2;
		    var manholeValue3=result_zckj.manholeValue3;
		    var pumpValue1=result_zckj.pumpValue1;
		   /*  var manholeValue4=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_zckj").removeClass("btn_off")
			    $("#button1_zckj").addClass("btn_on")
			     $("#button1_zckj").val("1")
		   }
		   if(manholeValue1!=0){
			   $("#button1_zckj").removeClass("btn_on")
			    $("#button1_zckj").addClass("btn_off")
			     $("#button1_zckj").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_zckj").removeClass("btn_off")
			    $("#button2_zckj").addClass("btn_on")
			     $("#button2_zckj").val("1")
		   }
		   if(manholeValue2!=0){
			   $("#button2_zckj").removeClass("btn_on")
			    $("#button2_zckj").addClass("btn_off")
			     $("#button2_zckj").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_zckj").removeClass("btn_off")
			    $("#button3_zckj").addClass("btn_on")
			     $("#button3_zckj").val("1")
		   }
		   if(manholeValue3!=0){
			   $("#button3_zckj").removeClass("btn_on")
			    $("#button3_zckj").addClass("btn_off")
			     $("#button3_zckj").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_zckj").removeClass("btn_off")
			    $("#button3_zckj").addClass("btn_on")
			     $("#button3_zckj").val("1")
		   }
		   if(manholeValue3!=0){
			   $("#button3_zckj").removeClass("btn_on")
			    $("#button3_zckj").addClass("btn_off")
			     $("#button3_zckj").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_zckj").removeClass("btn_off")
			    $("#p1_zckj").addClass("btn_on")
			     $("#p1_zckj").val("1")
		   }
		   if(pumpValue1!=0){
			   $("#p1_zckj").removeClass("btn_on")
			    $("#p1_zckj").addClass("btn_off")
			     $("#p1_zckj").val("0")
		   }
		     
			   data_yyf=result_yyf;
		    var manholeValue1=result_yyf.manholeValue1;
		    var manholeValue3=result_yyf.manholeValue3;
		    var manholeValue2=result_yyf.manholeValue2;
		    var pumpValue1=result_yyf.pumpValue1;
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_yyf").removeClass("btn_off")
			    $("#button1_yyf").addClass("btn_on")
			     $("#button1_yyf").val("1")
		   }
		   if(manholeValue1!=0){
			   $("#button1_yyf").removeClass("btn_on")
			    $("#button1_yyf").addClass("btn_off")
			     $("#button1_yyf").val("0")
		   }
		   /*if(manholeValue2==0){
			   $("#button2_yyf").removeClass("btn_off")
			    $("#button2_yyf").addClass("btn_on")
			     $("#button2_yyf").val("1")
		   }
		   if(manholeValue2!=0){
			   $("#button2_yyf").removeClass("btn_on")
			    $("#button2_yyf").addClass("btn_off")
			     $("#button2_yyf").val("0")
		   }*/
		   if(manholeValue3==0){
			   $("#button3_yyf").removeClass("btn_off")
			    $("#button3_yyf").addClass("btn_on")
			     $("#button3_yyf").val("1")
		   }
		   if(manholeValue3!=0){
			   $("#button3_yyf").removeClass("btn_on")
			    $("#button3_yyf").addClass("btn_off")
			     $("#button3_yyf").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_yyf").removeClass("btn_off")
			    $("#button3_yyf").addClass("btn_on")
			     $("#button3_yyf").val("1")
		   }
		   if(manholeValue3!=0){
			   $("#button3_yyf").removeClass("btn_on")
			    $("#button3_yyf").addClass("btn_off")
			     $("#button3_yyf").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_yyf").removeClass("btn_off")
			    $("#p1_yyf").addClass("btn_on")
			     $("#p1_yyf").val("1")
		   }
		   if(pumpValue1!=0){
			   $("#p1_yyf").removeClass("btn_on")
			    $("#p1_yyf").addClass("btn_off")
			     $("#p1_yyf").val("0")
		   }
		    	 data_odk=result_odk;
		    var manholeValue1=result_odk.manholeValue1;
		    var manholeValue3=result_odk.manholeValue3;
		    var manholeValue2=result_odk.manholeValue2;
		    var pumpValue1=result_odk.pumpValue1;
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_odk").removeClass("btn_off")
			    $("#button1_odk").addClass("btn_on")
			     $("#button1_odk").val("1")
		   }
		   if(manholeValue1!=0){
			   $("#button1_odk").removeClass("btn_on")
			    $("#button1_odk").addClass("btn_off")
			     $("#button1_odk").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_odk").removeClass("btn_off")
			    $("#button2_odk").addClass("btn_on")
			     $("#button2_odk").val("1")
		   }
		   if(manholeValue2!=0){
			   $("#button2_odk").removeClass("btn_on")
			    $("#button2_odk").addClass("btn_off")
			     $("#button2_odk").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_odk").removeClass("btn_off")
			    $("#button3_odk").addClass("btn_on")
			     $("#button3_odk").val("1")
		   }
		   if(manholeValue3!=0){
			   $("#button3_odk").removeClass("btn_on")
			    $("#button3_odk").addClass("btn_off")
			     $("#button3_odk").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_odk").removeClass("btn_off")
			    $("#button3_odk").addClass("btn_on")
			     $("#button3_odk").val("1")
		   }
		   if(manholeValue3!=0){
			   $("#button3_odk").removeClass("btn_on")
			    $("#button3_odk").addClass("btn_off")
			     $("#button3_odk").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_odk").removeClass("btn_off")
			    $("#p1_odk").addClass("btn_on")
			     $("#p1_odk").val("1")
		   }
		   if(pumpValue1!=0){
			   $("#p1_odk").removeClass("btn_on")
			    $("#p1_odk").addClass("btn_off")
			     $("#p1_odk").val("0")
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
		   if(manholeValue1!=0){
			   $("#button1_tdht").removeClass("btn_on")
			    $("#button1_tdht").addClass("btn_off")
			     $("#button1_tdht").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_tdht").removeClass("btn_off")
			    $("#button2_tdht").addClass("btn_on")
			     $("#button2_tdht").val("1")
		   }
		   if(manholeValue2!=0){
			   $("#button2_tdht").removeClass("btn_on")
			    $("#button2_tdht").addClass("btn_off")
			     $("#button2_tdht").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_tdht").removeClass("btn_off")
			    $("#button3_tdht").addClass("btn_on")
			     $("#button3_tdht").val("1")
		   }
		   if(manholeValue3!=0){
			   $("#button3_tdht").removeClass("btn_on")
			    $("#button3_tdht").addClass("btn_off")
			     $("#button3_tdht").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_tdht").removeClass("btn_off")
			    $("#button3_tdht").addClass("btn_on")
			     $("#button3_tdht").val("1")
		   }
		   if(manholeValue3!=0){
			   $("#button3_tdht").removeClass("btn_on")
			    $("#button3_tdht").addClass("btn_off")
			     $("#button3_tdht").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_tdht").removeClass("btn_off")
			    $("#p1_tdht").addClass("btn_on")
			     $("#p1_tdht").val("1")
		   }
		   if(pumpValue1!=0){
			   $("#p1_tdht").removeClass("btn_on")
			    $("#p1_tdht").addClass("btn_off")
			     $("#p1_tdht").val("0")
		   }
		     }
		     
		    	  data_yuf=result_tdht2;
		    var manholeValue1=result_tdht2.manholeValue1;
		    var manholeValue3=result_tdht2.manholeValue3;
		    var manholeValue2=result_tdht2.manholeValue2;
		    var pumpValue1=result_tdht2.pumpValue1;
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_yuf").removeClass("btn_off")
			    $("#button1_yuf").addClass("btn_on")
			     $("#button1_yuf").val("1")
		   }
		   if(manholeValue1!=0){
			   $("#button1_yuf").removeClass("btn_on")
			    $("#button1_yuf").addClass("btn_off")
			     $("#button1_yuf").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_yuf").removeClass("btn_off")
			    $("#button2_yuf").addClass("btn_on")
			     $("#button2_yuf").val("1")
		   }
		   if(manholeValue2!=0){
			   $("#button2_yuf").removeClass("btn_on")
			    $("#button2_yuf").addClass("btn_off")
			     $("#button2_yuf").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_yuf").removeClass("btn_off")
			    $("#button3_yuf").addClass("btn_on")
			     $("#button3_yuf").val("1")
		   }
		   if(manholeValue3!=0){
			   $("#button3_yuf").removeClass("btn_on")
			    $("#button3_yuf").addClass("btn_off")
			     $("#button3_yuf").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_yuf").removeClass("btn_off")
			    $("#button3_yuf").addClass("btn_on")
			     $("#button3_yuf").val("1")
		   }
		   if(manholeValue3!=0){
			   $("#button3_yuf").removeClass("btn_on")
			    $("#button3_yuf").addClass("btn_off")
			     $("#button3_yuf").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_yuf").removeClass("btn_off")
			    $("#p1_yuf").addClass("btn_on")
			     $("#p1_yuf").val("1")
		   }
		   if(pumpValue1!=0){
			   $("#p1_yuf").removeClass("btn_on")
			    $("#p1_yuf").addClass("btn_off")
			     $("#p1_yuf").val("0")
		   }
		    
		   
		   data_jb=result_jb;
		    var manholeValue1=result_jb.manholeValue1;
		    var manholeValue3=result_jb.manholeValue3;
		    var manholeValue2=result_jb.manholeValue2;
		    var pumpValue1=result_jb.pumpValue1;
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_jb").removeClass("btn_off")
			    $("#button1_jb").addClass("btn_on")
			     $("#button1_jb").val("1")
		   }
		   if(manholeValue1!=0){
			   $("#button1_jb").removeClass("btn_on")
			    $("#button1_jb").addClass("btn_off")
			     $("#button1_jb").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_jb").removeClass("btn_off")
			    $("#button2_jb").addClass("btn_on")
			     $("#button2_jb").val("1")
		   }
		   if(manholeValue2!=0){
			   $("#button2_jb").removeClass("btn_on")
			    $("#button2_jb").addClass("btn_off")
			     $("#button2_jb").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_jb").removeClass("btn_off")
			    $("#button3_jb").addClass("btn_on")
			     $("#button3_jb").val("1")
		   }
		   
		   if(manholeValue3!=0){
			   $("#button3_jb").removeClass("btn_on")
			    $("#button3_jb").addClass("btn_off")
			     $("#button3_jb").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_jb").removeClass("btn_off")
			    $("#p1_jb").addClass("btn_on")
			     $("#p1_jb").val("1")
		   }
		   if(pumpValue1!=0){
			   $("#p1_jb").removeClass("btn_on")
			    $("#p1_jb").addClass("btn_off")
			     $("#p1_jb").val("0")
		   }
		   
		 
		    
		   
		   
		   data_td=result_td;
		    var manholeValue1=result_td.manholeValue1;
		    var manholeValue3=result_td.manholeValue3;
		    var manholeValue2=result_td.manholeValue2;
		    var pumpValue1=result_td.pumpValue1;
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_td").removeClass("btn_off")
			    $("#button1_td").addClass("btn_on")
			     $("#button1_td").val("1")
		   }
		   if(manholeValue1!=0){
			   $("#button1_td").removeClass("btn_on")
			    $("#button1_td").addClass("btn_off")
			     $("#button1_td").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_td").removeClass("btn_off")
			    $("#button2_td").addClass("btn_on")
			     $("#button2_td").val("1")
		   }
		   if(manholeValue2!=0){
			   $("#button2_td").removeClass("btn_on")
			    $("#button2_td").addClass("btn_off")
			     $("#button2_td").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_td").removeClass("btn_off")
			    $("#button3_td").addClass("btn_on")
			     $("#button3_td").val("1")
		   }
		   
		   if(manholeValue3!=0){
			   $("#button3_td").removeClass("btn_on")
			    $("#button3_td").addClass("btn_off")
			     $("#button3_td").val("0")
		   }
		   
		   if(pumpValue1==0){
			   $("#p1_td").removeClass("btn_off");
			    $("#p1_td").removeClass("btn_on");
			    $("#p1_td").val("");
			    $("#p1_td").removeAttr("onclick");
		   }else{
			   var byteNumber=[];
			   byteNumber=intToByte(pumpValue1);
			 //  console.log(byteNumber)
			 //  console.log(byteNumber[6],byteNumber[7])
			   if(byteNumber[6]!=0){
				   $("#p1_td").removeClass("btn_off")
				    $("#p1_td").addClass("btn_on")
				     $("#p1_td").val("1")
			   }else if(byteNumber[7]!=0){
				   $("#p1_td").removeClass("btn_on")
				    $("#p1_td").addClass("btn_off")
				     $("#p1_td").val("0")
			   }
		   }
		  /* if(pumpValue1==0){
			   $("#p1_td").removeClass("btn_off")
			    $("#p1_td").addClass("btn_on")
			     $("#p1_td").val("1")
		   }
		   if(pumpValue1!=0){
			   $("#p1_td").removeClass("btn_on")
			    $("#p1_td").addClass("btn_off")
			     $("#p1_td").val("0")
		   }*/
		   
		   data_bc=result_bc;
		    var manholeValue1=result_bc.manholeValue1;
		    var manholeValue3=result_bc.manholeValue3;
		    var manholeValue2=result_bc.manholeValue2;
		    var pumpValue1=result_bc.pumpValue1;
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_bc").removeClass("btn_off")
			    $("#button1_bc").addClass("btn_on")
			     $("#button1_bc").val("1")
		   }
		   if(manholeValue1!=0){
			   $("#button1_bc").removeClass("btn_on")
			    $("#button1_bc").addClass("btn_off")
			     $("#button1_bc").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_bc").removeClass("btn_off")
			    $("#button2_bc").addClass("btn_on")
			     $("#button2_bc").val("1")
		   }
		   if(manholeValue2!=0){
			   $("#button2_bc").removeClass("btn_on")
			    $("#button2_bc").addClass("btn_off")
			     $("#button2_bc").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_bc").removeClass("btn_off")
			    $("#button3_bc").addClass("btn_on")
			     $("#button3_bc").val("1")
		   }
		   
		   if(manholeValue3!=0){
			   $("#button3_bc").removeClass("btn_on")
			    $("#button3_bc").addClass("btn_off")
			     $("#button3_bc").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_bc").removeClass("btn_off");
			    $("#p1_bc").removeClass("btn_on");
			    $("#p1_bc").val("");
			    $("#p1_bc").removeAttr("onclick");
		   }else{
			   var byteNumber=[];
			   byteNumber=intToByte(pumpValue1);
		//	   console.log(byteNumber)
	//	 console.log(byteNumber[6],byteNumber[7])
			   if(byteNumber[6]!=0){
				   $("#p1_bc").removeClass("btn_off")
				    $("#p1_bc").addClass("btn_on")
				     $("#p1_bc").val("1")
			   }else if(byteNumber[7]!=0){
				   $("#p1_bc").removeClass("btn_on")
				    $("#p1_bc").addClass("btn_off")
				     $("#p1_bc").val("0")
			   }
		   }
		   /*if(pumpValue1==0){
			   $("#p1_bc").removeClass("btn_off")
			    $("#p1_bc").addClass("btn_on")
			     $("#p1_bc").val("1")
		   }
		   if(pumpValue1!=0){
			   $("#p1_bc").removeClass("btn_on")
			    $("#p1_bc").addClass("btn_off")
			     $("#p1_bc").val("0")
		   }*/
		   
		   if(result_6!=null){
			   
		   
		   data_6=result_6;
		    var manholeValue1=result_6.manholeValue1;
		    var manholeValue3=result_6.manholeValue3;
		    var manholeValue2=result_6.manholeValue2;
		    var pumpValue1=result_6.pumpValue1;
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_6").removeClass("btn_off")
			    $("#button1_6").addClass("btn_on")
			     $("#button1_6").val("1")
		   }
		   if(manholeValue1!=0){
			   $("#button1_6").removeClass("btn_on")
			    $("#button1_6").addClass("btn_off")
			     $("#button1_6").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_6").removeClass("btn_off")
			    $("#button2_6").addClass("btn_on")
			     $("#button2_6").val("1")
		   }
		   if(manholeValue2!=0){
			   $("#button2_6").removeClass("btn_on")
			    $("#button2_6").addClass("btn_off")
			     $("#button2_6").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_6").removeClass("btn_off")
			    $("#button3_6").addClass("btn_on")
			     $("#button3_6").val("1")
		   }
		   
		   if(manholeValue3!=0){
			   $("#button3_6").removeClass("btn_on")
			    $("#button3_6").addClass("btn_off")
			     $("#button3_6").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_6").removeClass("btn_off")
			    $("#p1_6").addClass("btn_on")
			     $("#p1_6").val("1")
		   }
		   if(pumpValue1!=0){
			   $("#p1_6").removeClass("btn_on")
			    $("#p1_6").addClass("btn_off")
			     $("#p1_6").val("0")
		   }
		   }
 if(result_7!=null){
			   
		   
		   data_7=result_7;
		    var manholeValue1=result_7.manholeValue1;
		    var manholeValue3=result_7.manholeValue3;
		    var manholeValue2=result_7.manholeValue2;
		    var pumpValue1=result_7.pumpValue1;
		   /*  var manholeValue1=0;
		    var manholeValue3=1;
		    var manholeValue2=0;
		     var pumpValue1=1*/
		   if(manholeValue1==0){
			   $("#button1_7").removeClass("btn_off")
			    $("#button1_7").addClass("btn_on")
			     $("#button1_7").val("1")
		   }
		   if(manholeValue1!=0){
			   $("#button1_7").removeClass("btn_on")
			    $("#button1_7").addClass("btn_off")
			     $("#button1_7").val("0")
		   }
		   if(manholeValue2==0){
			   $("#button2_7").removeClass("btn_off")
			    $("#button2_7").addClass("btn_on")
			     $("#button2_7").val("1")
		   }
		   if(manholeValue2!=0){
			   $("#button2_7").removeClass("btn_on")
			    $("#button2_7").addClass("btn_off")
			     $("#button2_7").val("0")
		   }
		   if(manholeValue3==0){
			   $("#button3_7").removeClass("btn_off")
			    $("#button3_7").addClass("btn_on")
			     $("#button3_7").val("1")
		   }
		   
		   if(manholeValue3!=0){
			   $("#button3_7").removeClass("btn_on")
			    $("#button3_7").addClass("btn_off")
			     $("#button3_7").val("0")
		   }
		   if(pumpValue1==0){
			   $("#p1_7").removeClass("btn_off")
			    $("#p1_7").addClass("btn_on")
			     $("#p1_7").val("1")
		   }
		   if(pumpValue1!=0){
			   $("#p1_7").removeClass("btn_on")
			    $("#p1_7").addClass("btn_off")
			     $("#p1_7").val("0")
		   }
 }
		 
		      $(this).jqLoading("destroy"); 
		    
		   }
	})
}   