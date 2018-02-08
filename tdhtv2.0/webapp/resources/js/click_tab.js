
$(function(){
$("#click_fir").click(function(){ 
$("#tab_first").slideToggle("slow" )
　　
  })  	 
 $("#click_fir").toggle( 
        function(){$("#img_first").attr('src',"/resources/img/plus.png")} ,
       function(){$("#img_first").attr('src',"/resources/img/minus.png")} 
);

$("#click_sec").click(function(){ 
$("#tab_sec").slideToggle("slow" )
　　
  })  	 
 $("#click_sec").toggle( 
	  function(){$("#img_sec").attr('src',"/resources/img/minus.png")} ,
        function(){$("#img_sec").attr('src',"/resources/img/plus.png")} 
      
);

$("#click_tre").click(function(){ 
$("#tab_tre").slideToggle("slow" )
　　
  })  	 
 $("#click_tre").toggle( 
       function(){$("#img_tre").attr('src',"/resources/img/minus.png")} ,
        function(){$("#img_tre").attr('src',"/resources/img/plus.png")} 
);

$("#click_fou").click(function(){ 
$("#tab_fou").slideToggle("slow" )
　　
  })  	 
 $("#click_fou").toggle( 
        function(){$("#img_fou").attr('src',"/resources/img/minus.png")} ,
        function(){$("#img_fou").attr('src',"/resources/img/plus.png")} 
);

$("#click_five").click(function(){ 
$("#tab_five").slideToggle("slow" )
　　
  })  	 
 $("#click_five").toggle( 
         function(){$("#img_five").attr('src',"/resources/img/minus.png")} ,
        function(){$("#img_five").attr('src',"/resources/img/plus.png")} 
);

$("#click_six").click(function(){ 
$("#tab_six").slideToggle("slow" )
　　
  })  	 
 $("#click_six").toggle( 
         function(){$("#img_six").attr('src',"/resources/img/minus.png")} ,
        function(){$("#img_six").attr('src',"/resources/img/plus.png")} 
);
$("#click_sev").click(function(){ 
$("#tab_sev").slideToggle("slow" )
　　
  })  	 
 $("#click_sev").toggle( 
         function(){$("#img_sev").attr('src',"/resources/img/minus.png")} ,
        function(){$("#img_sev").attr('src',"/resources/img/plus.png")} 
);
})