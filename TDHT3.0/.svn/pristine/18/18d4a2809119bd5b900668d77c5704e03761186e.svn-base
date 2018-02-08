
<script type="text/javascript">
	try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
</script>

<style>
.mtree-demo{
position: absolute;
height:87%;
width:170px;
z-index: 99999;
}
.mtree-demo .mtree {
  background: #EEE;
  margin: 0px auto;
  max-width: 170px;
  border-radius: 3px;
  height: 100%;
}

.mtree-skin-selector {
  text-align: center;
  background: #EEE;
  padding: 10px 0 15px;
}

.mtree-skin-selector li {
  display: inline-block;
  float: none;
}

.mtree-skin-selector button {
  padding: 5px 10px;
  margin-bottom: 1px;
  background: #BBB;
}

.mtree-skin-selector button:hover { background: #999; }

.mtree-skin-selector button.active {
  background: #999;
  font-weight: bold;
}

.mtree-skin-selector button.csl.active { background: #FFC000; }

.left_img1 {
	position: absolute;
	top:30%;
	word-wrap: break-word;
	margin-left: 5px;
	}
.left_img {
background: url(static/left/img/left-img.png) no-repeat;
width:33px;
height:201px;
font-family: 微软雅黑;
font-size: 18px;
color: #fff;
writing-mode:vertical-lr;
text-align: center;
writing-mode:bt-lr;
position: absolute;
z-index: 999;
}
.active{
background-color: #0C77BF;
      color: #FFF;
}
</style>

				<%--<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						
						<button class="btn btn-info" onclick="changeMenus();" title="切换菜单">
							<i class="ace-icon fa fa-pencil"></i>
						</button>
						
						<button class="btn btn-success" title="UI实例" onclick="window.open('static/html_UI/html');">
							<i class="ace-icon fa fa-signal"></i>
						</button>

						<!-- #section:basics/sidebar.layout.shortcuts -->
						<button class="btn btn-warning" title="" id="adminzidian">
							<i class="ace-icon fa fa-book"></i>
						</button>

						<button class="btn btn-danger">
							<i class="ace-icon fa fa-cogs"></i>
						</button>

						<!-- /section:basics/sidebar.layout.shortcuts -->
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

				--%>
				
				
			<!-- This is mtree list -->
			<div id='mtree-demo'class=mtree-demo>
			<input id="inforid" type="hidden" value="">
			<ul id="COM_RID" class="mtree bubba" style="opacity:1">
				
				<%--<ul id="COM_RID" class="nav nav-list">--%>
				
				<input id="ROLE_NAME"type="hidden" value=""/>
				 <c:forEach items="${allList}" var="all" varStatus="loop">
				 
				<c:if test="${all.hasDict}">
                             <li class=""var="${all.BZ}" style="cursor:pointer;" ><a href="#">${all.BZ}</a>
                             <c:if test="${'[]' !=all.subDict}">
                             <ul>
                              <c:forEach items="${all.subDict}" var="all1">
                              <c:if test="${all1.hasDict}">
                              <li class=""var="${all1.BZ}" style="cursor:pointer;" ><a href="#">${all1.BZ}</a>
                                 <c:if test="${'[]' !=all1.subDict}">
                                  <ul>
                                   <c:forEach items="${all1.subDict}" var="all2">
                                   <c:if test="${all2.hasDict}">
                                    <li class=""var="${all2.BZ}" style="cursor:pointer;" ><a href="#">${all2.BZ}</a>
                                     <ul id="rid">
                                     <c:forEach items="${allridList}" var="rid">
                                      <c:if test="${all2.BZ==rid.RB}">
                                           <li class=""  id="lm${rid.R_ID }"var="${rid.R_NAME_CN }" style="cursor:pointer;"  onclick="changeMenu(${rid.R_ID },'${rid.RIGHTS}','${rid.R_NAME_CN }',0)">
						 					<a style="cursor:pointer;" class="dropdown-toggle">${rid.R_NAME_CN }</a>
                      						</li>
                                      </c:if>
                                     </c:forEach>
                                     </ul>
                                     <%--<c:if test="${all2.BZ==allridList[loop.count-1].RB}">
                                          <ul>
                                           <li class=""  id="lm${allridList[loop.count-1].R_ID }"var="${allridList[loop.count-1].R_NAME_CN }" style="cursor:pointer;"  onclick="changeMenu(${allridList[loop.count-1].R_ID },'${allridList[loop.count-1].RIGHTS}','${allridList[loop.count-1].R_NAME_CN }')">
						 					<a style="cursor:pointer;text-align: center;" class="dropdown-toggle">
											${allridList[loop.count-1].R_NAME_CN }
											</a>
					                      </li>
                                          </ul>
                                        </c:if>
                                    
                                    --%></li>
                                   </c:if>
                                   
                                   </c:forEach>
                                  </ul>
                                 
                                 </c:if>
                                 
                                 
                                 <c:if test="${'[]' ==all1.subDict}">
                                   <c:forEach items="${allridList}" var="rid">
                                      <c:if test="${all2.BZ==rid.RB}">
                                       <ul>
                                           <li class=""  id="lm${rid.R_ID }"var="${rid.R_NAME_CN }" style="cursor:pointer;"  onclick="changeMenu(${rid.R_ID },'${rid.RIGHTS}','${rid.R_NAME_CN }',0)">
						 						<a style="cursor:pointer;" class="dropdown-toggle">${rid.R_NAME_CN }</a>
                      						</li>
                                       </ul>
                                      </c:if>
                                     </c:forEach>
                                 </c:if>
                              </li>
                              </c:if>
                              
                              </c:forEach>
                              </ul>
                             </c:if>
                    </li>
                    </c:if>
                      </c:forEach>
				</ul>
				</div>
				<!-- /.nav-list -->

				<!-- #section:basics/sidebar.layout.minimize -->
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
				<div id="img_div"class="in"style="cursor:pointer; width: 30px;height: 82%;display:block;   position: absolute;top: 150px;left: 170px;" ><div class="left_img"><div id="left_img"class="left_img1"></div></div>
      		</div>
      		<script src="static/js/jquery.cookie.js"></script>
                 <script type="text/javascript">
				 function onSelect(a){
					 $.cookie('onSelect2',a, { expires: 1, path: '/TDHT3.0' });
				 }
                function  changeMenu(RID,RIGHTS,ROLE_NAME,changeType ){
                //	alert(RIGHTS)
                	$.cookie('menuUrl', 'listMonitoring.do?MENU_ID=93&R_ID=', { expires: 7, path: '/TDHT3.0' });
                	 $.cookie('onSelect','0', { expires: 7, path: '/TDHT3.0' });
                	//var href = $("#mainFrame").contents().find("#menuUrl").attr("href")
                	var href =$.cookie('menuUrl_s');
                	var href2 =$.cookie('menuUrl');
                	var onSelect =$.cookie('onSelect');
                	var onSelect2 =$.cookie('onSelect2');
                	if(onSelect2=="null"){
                		onSelect2=onSelect
                	}
                	 $.cookie('onSelect',onSelect2, { expires: 1, path: '/TDHT3.0' });
                	//alert(href==null)
                	if(href=="null"){
                		
                		href=href2;
                	}
                	
                	$.cookie('menuUrl', href, { expires: 1, path: '/TDHT3.0' });
                
	            
	           href=href+RID+"&ROLE_NAME="+ROLE_NAME;
              $("#menuUrl").attr("href",href);   	
             
	 $.ajax({
    url: 'changeMenu',
    type: "post",
    async: true,
    dataType: "json",
    data: {
         RID,
        RIGHTS,
        ROLE_NAME
    },
    success: function(data) {
        $("#menuList").empty();
        var a = 0;
        $.each(data.list,
        function(i, dvar) {

            if (dvar.hasMenu) {
                if ("#" == dvar.MENU_URL || "" == dvar.MENU_URL) {
                    $("#menuList").append("<a  onclick='onSelect(" + a + ")' target='mainFrame' href=tab.do?MENU_ID=" + dvar.MENU_ID + "&ROLE_NAME=" + data.ROLE_NAME + "&R_ID=" + RID + " style='width:12%;height:30px;'> <li value='" + a + "'><i style='margin-right:10px'class=' " + dvar.MENU_ICON + "'></i>" + dvar.MENU_NAME + "</li></a>");
                } else {
                    $("#menuList").append("<a  onclick='onSelect(" + a + ")'  target='mainFrame' href=" + dvar.MENU_URL + "?MENU_ID=" + dvar.MENU_ID + "&ROLE_NAME=" + data.ROLE_NAME + "&R_ID=" + RID + " style='width:12%;height:30px;'><li value='" + a + "'><i style='margin-right:10px' class=' " + dvar.MENU_ICON + "'></i>" + dvar.MENU_NAME + "</li></a>");
                    //$("#menuList").append("<a   target='mainFrame' href='login_default.do?R_ID="+RID+"' style='width:12%;height:30px;'><li><i style='margin-right:10px' class=' "+dvar.MENU_ICON+"'></i>"+dvar.MENU_NAME+"</li></a>");
                }
                a++;
            }

        });

        //	$("#menuUrl").attr("href","tab.do?MENU_ID=99&ROLE_NAME="+data.ROLE_NAME); 
        var example1 = new sNav('example1');

        if (changeType == 1) {
            $.cookie('onSelect', 1, {
                expires: 1,
                path: '/TDHT3.0'
            });
            $.cookie('onSelect2', 1, {
                expires: 1,
                path: '/TDHT3.0'
            });
            var list = jQuery('#menuList a li');
            var onSelect = $.cookie('onSelect');
            console.log(onSelect);
            $('#menuList a li').eq(onSelect).css("background", "#0C77BF");
            $('#menuList a li').eq(onSelect).css("color", "#fff");

            $("#menuList a  span").on("click",
            function() {

                $("#menuList a  li").css("background", "#fff");
                $("#menuList a  li").css("color", "#0C77BF");
                $(this).next().css("background", "#0C77BF");
                $(this).next().css("color", "#fff");

            });
            $("#menuList a  li").on("click",
            function() {

                $("#menuList a  li").css("background", "#fff");
                $("#menuList a  li").css("color", "#0C77BF");
                $(this).css("background", "#0C77BF");
                $(this).css("color", "#fff");

            });
            $("#changeUrl").attr("href", "NewData.do?MENU_ID=94&ROLE_NAME=" + ROLE_NAME + "&R_ID=" + RID);
            var arrs = document.getElementById("changeUrl");
            arrs.click();
        } else {

            var list = jQuery('#menuList a li');
            var onSelect = $.cookie('onSelect');
            console.log(onSelect);
            $('#menuList a li').eq(onSelect).css("background", "#0C77BF");
            $('#menuList a li').eq(onSelect).css("color", "#fff");

            $("#menuList a  span").on("click",
            function() {

                $("#menuList a  li").css("background", "#fff");
                $("#menuList a  li").css("color", "#0C77BF");
                $(this).next().css("background", "#0C77BF");
                $(this).next().css("color", "#fff");

            });
            $("#menuList a  li").on("click",
            function() {

                $("#menuList a  li").css("background", "#fff");
                $("#menuList a  li").css("color", "#0C77BF");
                $(this).css("background", "#0C77BF");
                $(this).css("color", "#fff");

            });

            var arr = document.getElementById("menuUrl");
           // console.log($("#menuUrl").attr("href"))

            arr.click();
        }
        /*var arr = document.getElementById("menuUrl");
						console.log($("#menuUrl").attr("href"))
						
						arr.click();*/
        document.getElementById("inforid").value = RID;
        $("#left_img").text(data.ROLE_NAME)

    }
    
})
          var list = jQuery('#menuList a li');
	
			list.click(function(){
				list.removeClass('active');
				jQuery(this).addClass('active');
				return false;
			});
           
           }
                 
				</script>
			
				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
				$("#menuList").find("a").each(function(){
					$(this).click();
					});
				
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
		