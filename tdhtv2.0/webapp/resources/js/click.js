
var boo_yyf=true;
var boo_odk=true;
var boo_tdht=true;
var boo_zckj=true;
var boo_yuf=true;
var boo_jb=true;
var boo_td=true;
var boo_bc=true;
var boo_6=true;
var boo_7=true;
var timer;


/**
 * 阀门 
 * @param {Object} data
 */
function open4(data)
{
	var companyId=$("#companyId").val();
	if(companyId>500&&companyId<1000){
		 Dialog.confirm('警告：您的权限不足操作，请联系管理员',function(){
			 
		 })
	}else{
    Dialog.confirm('警告：您确认要执行吗？',function(){
    	
    	
      $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
     data.word=6;
     if(data.rid==75501330001){
    	 if(boo_yyf){
    	data.pumpValue1=$("#p1_yyf").val(); 
    	 var value=data.pumpValue1;
    	 data.operationtype=5;
        data.value=value;
    	// console2(data)
       boo_yyf=false;
       
        timer=setTimeout(function() {
        boo_yyf=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
     }
     
 //******************************************    
     
     if(data.rid==75501330002){
    	  if(boo_odk){
    	data.pumpValue1=$("#p1_odk").val(); 
    	var value=data.pumpValue1;
    	 data.operationtype=5;
        data.value=value;
    	// console2(data)
       boo_odk=false;
       
        timer=setInterval(function() {
        boo_odk=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
     }
     
   //*********************************************  
     
     
     if(data.rid==75501330003){
    	 
    	 if(boo_tdht){
    	data.pumpValue1=$("#p1_tdht").val(); 
    	var value=data.pumpValue1;
    	 data.operationtype=5;
        data.value=value;
    //	 console2(data)
       boo_tdht=false;
       
        timer=setInterval(function() {
        boo_tdht=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	 
    	 
    	 
    	 
     }
     
     
     
     
     //******************************************************
     if(data.rid==75501330004){
    	 
    	  if(boo_zckj){
    	data.pumpValue1=$("#p1_zckj").val();  
    	var value=data.pumpValue1;
    	 data.operationtype=5;
        data.value=value;
    //	 console2(data)
       boo_zckj=false;
       
        timer=setInterval(function() {
        boo_zckj=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     
     //*********************************************
     if(data.rid==75501330005){
    	 if(boo_yuf){
    	data.pumpValue1=$("#p1_yuf").val();  
    	var value=data.pumpValue1;
    	 data.operationtype=5;
        data.value=value;
    //	 console2(data)
       boo_yuf=false;
       
        timer=setInterval(function() {
        boo_yuf=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     
   //*****************************  
     
     console.log(data.manholeValue4+"     444");
     
     })
	}
      
}
function open1(data)
{
	var companyId=$("#companyId").val();
	if(companyId>500&&companyId<1000){
		 Dialog.confirm('警告：您的权限不足操作，请联系管理员',function(){
			 
		 })
	}else{
	//alert(companyId);
    Dialog.confirm('警告：您确认要执行吗？',function(){
    	
    	
    	
     data.word=6;
   
       if(data.Rid==75501330001){
    	   if(boo_yyf==true){
    		   console.log(data)
     boo_yyf=false;
 $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue1=$("#button1_yyf").val(); 
    	var name='manholeValue1';
     var value=data.manholeValue1;
        data.operationtype=1;
        data.value=value;
    	 console2(data)
     
       
        timer=setTimeout(function() {
        boo_yyf=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
   //*************************************    
     if(data.Rid==75501330002){
    	 
    	   if(boo_odk==true){
    		     boo_odk=false;
 $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue1=$("#button1_odk").val();
    	var name='manholeValue1';
     var value=data.manholeValue1;
        data.operationtype=1;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_odk=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	  
     }
   //*******************************
     if(data.Rid==75501330003){
    	
    	if(boo_tdht==true){
    		 boo_tdht=false;
    		 $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue1=$("#button1_tdht").val(); 
    	var name='manholeValue1';
     var value=data.manholeValue1;
        data.operationtype=1;
        data.value=value;
    	 
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_tdht=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
     }
     //*******************************
     if(data.Rid==75501330004){
     if(boo_zckj==true){
    	   boo_zckj=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue1=$("#button1_zckj").val();  
    	var name='manholeValue1';
     var value=data.manholeValue1;
        data.operationtype=1;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_zckj=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330005){
    	 
     if(boo_yuf==true){
    	   boo_yuf=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue1=$("#button1_yuf").val();   
    	var name='manholeValue1';
     var value=data.manholeValue1;
        data.operationtype=1;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_yuf=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330008){
    	 
     if(boo_jb==true){
    	 boo_jb=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue1=$("#button1_jb").val();   
    	var name='manholeValue1';
     var value=data.manholeValue1;
        data.operationtype=1;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_jb=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330009){
    	 
     if(boo_td==true){
    	   boo_td=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue1=$("#button1_td").val();   
    	var name='manholeValue1';
     var value=data.manholeValue1;
        data.operationtype=1;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_td=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330010){
    	 
     if(boo_bc==true){
    	   boo_bc=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue1=$("#button1_bc").val();   
    	var name='manholeValue1';
     var value=data.manholeValue1;
        data.operationtype=1;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_bc=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330011){
    	 
     if(boo_6==true){
    	   boo_6=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue1=$("#button1_6").val();   
    	var name='manholeValue1';
     var value=data.manholeValue1;
        data.operationtype=1;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_6=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330012){
    	 
     if(boo_7==true){
    	   boo_7=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue1=$("#button1_7").val();   
    	var name='manholeValue1';
     var value=data.manholeValue1;
        data.operationtype=1;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_7=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     
     //   alert(data.manholeValue1+"     111");
        
      })
      
      
     
}
      
}
function open2(data)
{
	var companyId=$("#companyId").val();
	if(companyId>500&&companyId<1000){
		 Dialog.confirm('警告：您的权限不足操作，请联系管理员',function(){
			 
		 })
	}else{
    Dialog.confirm('警告：您确认要执行吗？',function(){

     data.word=6;
       if(data.Rid==75501330001){
    	  if(boo_yyf==true){
    		   boo_yyf=false;
$.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue2=$("#button2_yyf").val();  
    	var name='manholeValue2';
        var value=data.manholeValue2;
        data.operationtype=2;
        data.value=value;
    	 
    	 console2(data)
        timer=setTimeout(function() {
        boo_yyf=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	   
    	
     }
       //**************************
     if(data.Rid==75501330002){
    	  if(boo_odk==true){
    		  	  boo_odk=false;
    		        $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue2=$("#button2_odk").val();  
    	var name='manholeValue2';
        var value=data.manholeValue2;
        data.operationtype=2;
        data.value=value;
    
    	 console2(data)
        timer=setTimeout(function() {
        boo_odk=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     
     //*****************************************
     if(data.Rid==75501330003){
    	 
    	  if(boo_tdht==true){
    		    boo_tdht=false;
    		        $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue2=$("#button2_tdht").val();  
    	var name='manholeValue2';
        var value=data.manholeValue2;
        data.operationtype=2;
        data.value=value;
    	
    	 console2(data)
        timer=setTimeout(function() {
        boo_tdht=true;
},10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	 
     }
     //****************************************
     if(data.Rid==75501330004){
    	 if(boo_zckj==true){   
    		   boo_zckj=false;
    		 $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    		 
    	data.manholeValue2=$("#button2_zckj").val();  
    	var name='manholeValue2';
        var value=data.manholeValue2;
        data.operationtype=2;
        data.value=value;
    	
    	 console2(data)
        timer=setTimeout(function() {
        boo_zckj=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	 
     }
     //********************************************
     if(data.Rid==75501330005){
    	  if(boo_yuf==true){
    		   boo_yuf=false;
    		        $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue2=$("#button2_yuf").val();  
    	var name='manholeValue2';
        var value=data.manholeValue2;
        data.operationtype=2;
        data.value=value;
    	 
    	 console2(data)
        timer=setTimeout(function() {
        boo_yuf=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     
     //*************************************
     if(data.Rid==75501330008){
    	 
     if(boo_jb==true){
    	 boo_jb=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue2=$("#button2_jb").val();   
    	var name='manholeValue2';
     var value=data.manholeValue2;
        data.operationtype=2;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_jb=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330009){
    	 
     if(boo_td==true){
    	   boo_td=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue2=$("#button2_td").val();   
    	var name='manholeValue2';
     var value=data.manholeValue2;
        data.operationtype=2;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_td=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330010){
    	 
     if(boo_bc==true){
    	   boo_bc=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue2=$("#button2_bc").val();   
    	var name='manholeValue2';
     var value=data.manholeValue2;
        data.operationtype=2;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_bc=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330011){
    	 
     if(boo_6==true){
    	   boo_6=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue2=$("#button2_6").val();   
    	var name='manholeValue2';
     var value=data.manholeValue2;
        data.operationtype=2;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_6=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330012){
    	 
     if(boo_7==true){
    	   boo_7=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue2=$("#button2_7").val();   
    	var name='manholeValue2';
     var value=data.manholeValue2;
        data.operationtype=2;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_7=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     
     
     
        console.log(data.manholeValue2+"     222");
       })
	}
}

function open3(data)
{
	var companyId=$("#companyId").val();
	if(companyId>500&&companyId<1000){
		 Dialog.confirm('警告：您的权限不足操作，请联系管理员',function(){
			 
		 })
	}else{
    Dialog.confirm('警告：您确认要执行吗？',function(){
     console.log(data)
     data.word=6;
         if(data.Rid==75501330001){
        	 if(boo_yyf==true){
        		  boo_yyf=false;
        		       $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue3=$("#button3_yyf").val();  
    	 var value=data.manholeValue3;
        data.operationtype=3;
        data.value=value;
    	 
    	 console2(data)
        timer=setTimeout(function() {
        boo_yyf=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
         //************************************************
     if(data.Rid==75501330002){
    	  if(boo_odk==true){
    		    boo_odk=false;
    		        $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue3=$("#button3_odk").val();   
    	 var value=data.manholeValue3;
        data.operationtype=3;
        data.value=value;
    	
    	 console2(data)
        timer=setTimeout(function() {
        boo_odk=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //********************************************
     if(data.Rid==75501330003){
    	 if(boo_tdht==true){
    		 boo_tdht=false;
    		       $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue3=$("#button3_tdht").val();     
    	 var value=data.manholeValue3;
        data.operationtype=3;
        data.value=value;
    	 console2(data)
        timer=setTimeout(function() {
        boo_tdht=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //**********************************************************
     if(data.Rid==75501330004){
    	 if(boo_zckj==true){
    		  boo_zckj=false;
    		       $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue3=$("#button3_zckj").val();       
    	 var value=data.manholeValue3;
        data.operationtype=3;
        data.value=value;
    	 
    	 console2(data)
        timer=setTimeout(function() {
        boo_zckj=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //**********************************************************
     if(data.Rid==75501330005){
    	 if(boo_yuf==true){
    		 boo_yuf=false;
    		       $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue3=$("#button3_yuf").val();        
    	 var value=data.manholeValue3;
        data.operationtype=3;
        data.value=value;
    	  
    	 console2(data)
        timer=setTimeout(function() {
        boo_yuf=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     
     //*************************************
     if(data.Rid==75501330008){
    	 
     if(boo_jb==true){
    	 boo_jb=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue3=$("#button3_jb").val();   
    	var name='manholeValue3';
     var value=data.manholeValue33;
        data.operationtype=3;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_jb=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330009){
    	 
     if(boo_td==true){
    	   boo_td=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue3=$("#button3_td").val();   
    	var name='manholeValue3';
     var value=data.manholeValue3;
        data.operationtype=3;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_td=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330010){
    	 
     if(boo_bc==true){
    	   boo_bc=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue3=$("#button3_bc").val();   
    	var name='manholeValue3';
     var value=data.manholeValue3;
        data.operationtype=3;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_bc=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330011){
    	 
     if(boo_6==true){
    	   boo_6=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue3=$("#button3_6").val();   
    	var name='manholeValue3';
     var value=data.manholeValue3;
        data.operationtype=3;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_6=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     //*************************************
     if(data.Rid==75501330012){
    	 
     if(boo_7==true){
    	   boo_7=false;
    	  $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
    	data.manholeValue3=$("#button3_7").val();   
    	var name='manholeValue3';
     var value=data.manholeValue3;
        data.operationtype=3;
        data.value=value;
    	
    	
    	 console2(data)
      
       
        timer=setTimeout(function() {
        boo_7=true;
}, 10000); 
      
    }else{
    	alert("正在执行上次操作，请耐心等待...")
    }  
    	
     }
     
     
     
     
        console.log(data.manholeValue3+"     33333");
        
     
       })
	}
}


function open5(data)
{
	var companyId=$("#companyId").val();
	if(companyId>500&&companyId<1000){
		 Dialog.confirm('警告：您的权限不足操作，请联系管理员',function(){
			 
		 })
	}else{
console.log(data);
    Dialog.confirm('警告：您确认要执行吗？',function(){
      $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
     data.word=6;
     console.log(data.rid)
         if(data.Rid==75501330001){
    	data.manholeValue5=$("#button5_yyf").val();  
     }
     if(data.Rid==75501330002){
    	data.manholeValue5=$("#button5_odk").val();  
     }
     if(data.Rid==75501330003){
    	data.manholeValue5=$("#button5_tdht").val();  
     }
     if(data.Rid==75501330004){
    	data.manholeValue5=$("#button5_zckj").val();  
     }
     if(data.Rid==75501330005){
    	data.manholeValue5=$("#button5_yuf").val();  
     }
       
      
       console2(data)
       })
	}
}
function open6(data)
{
	var companyId=$("#companyId").val();
	if(companyId>500&&companyId<1000){
		 Dialog.confirm('警告：您的权限不足操作，请联系管理员',function(){
			 
		 })
	}else{
    Dialog.confirm('警告：您确认要执行吗？',function(){
      $.fn.jqLoading({ height: 100, width: 240, text: "正在操作中，请耐心等待...." });
     data.word=6;
      if(data.Rid==75501330001){
    	data.pumpValue1=$("#p1_yyf").val();   
     }
     if(data.Rid==75501330002){
    	data.pumpValue1=$("#p1_odk").val();    
     }
     if(data.Rid==75501330003){
    	data.pumpValue1=$("#p1_tdht").val();    
     }
     if(data.Rid==75501330004){
    	data.pumpValue1=$("#p1_zckj").val();    
     }
     if(data.Rid==75501330005){
    	data.pumpValue1=$("#p1_yuf").val();    
     }
        console.log(data.pumpValue1+"     ppp");
        
       var name='manholeValue6';
     var value=data.manholeValue6;
        
      data.operationtype=6;
        data.value=value;
       console2(data)
       })
	}
}

//弹出隐藏层 
var diag = new Dialog();
function open11(data,cap)
{
	console.log(cap)
	if(cap==-1){
		alert("该设备没有空闲杯号，请稍后再试")
	}else{
	
	$("#samplemMac1").val(cap)
	 $('#samplemMac1').attr("disabled",true); 
	rid=data.rid;
	//rid=75501330004;
	diag.Width = 300;
	diag.Height = 150;
	diag.Title = "采样控制";
	diag.InvokeElementId="forlogin"
	diag.OKEvent = function(){topWin.$id("samplemMac1").value||Dialog.alert("杯号不能为空");topWin.$id("samplemValue1").value||Dialog.alert("容量不能为空") ; panduan(data);};//点击确定后调用的方法
	diag.show();
	}
}
function open10(data)
{
	var companyId=$("#companyId").val();
	if(companyId>500&&companyId<1000){
		 Dialog.confirm('警告：您的权限不足操作，请联系管理员',function(){
			 
		 })
	}else{
	$("#samplemMac1").val("");
	$('#samplemMac1').attr("disabled",false);
	rid=data.rid;
	//rid=75501330004;
	diag.Width = 300;
	diag.Height = 150;
	diag.Title = "采样控制";
	diag.InvokeElementId="forlogin"
	diag.OKEvent = function(){topWin.$id("samplemMac1").value||Dialog.alert("杯号不能为空");topWin.$id("samplemValue1").value||Dialog.alert("容量不能为空") ; panduan(data);};//点击确定后调用的方法
	diag.show();
	}
}
  function  panduan(data){
  if(isNaN(topWin.$id("samplemMac1").value)){
	   Dialog.alert("请输入数字");
	}else if(topWin.$id("samplemMac1").value>24){
	   Dialog.alert("请输入小于24的数字");
	   }else if(isNaN(topWin.$id("samplemValue1").value)){
	   Dialog.alert("请输入数字");
	}else  if(topWin.$id("samplemValue1").value>80){
	   Dialog.alert("请输入小于80的数字");
	   }else{sendsam(data);
	   }
  
  function sendsam(data){
   var samplemMac1 =topWin.$id("samplemMac1").value;
   var samplemValue1=topWin.$id("samplemValue1").value;
   diag.close();
   console.log(samplemMac1,samplemValue1)
   insertSample(samplemMac1,samplemValue1,data);
   
   
   
}
  }
  
  function insertSample(samplemMac1,samplemValue1,data){
	  rid=data.Rid;
	console.log(rid)
	   $.ajax({
       url:"../monitors/insertSam",
		type:"post",
		async: false,
		dataType:"json",
		data:{num:samplemMac1,
			  capacity:samplemValue1,
			  rid:rid
			     },
		success:function(result){
			var  list=result.list;
			  var value=list[0];
			  $(this).jqLoading("destroy");
			var diag = new Dialog();
	            diag.AutoClose=3;
	            diag.Width=300;
	            diag.Height=200;
	            diag.ShowCloseButton=true;
	            diag.URL = "javascript:void(document.write(\'操作完毕，请耐心等待！！\'))";
	            diag.show();
           data.word=6;
           data.sampleValue1=value 
       data.operationtype=7;
        data.value=value;
       console2(data)
   
		},
        error:function(){
			$(this).jqLoading("destroy");
			
		}
		})
  }