﻿		<div id="navbar" class="navbar navbar-default" style="margin-bottom: 0px;">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed');}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<!-- #section:basics/sidebar.mobile.toggle -->
				
               
				<!-- /section:basics/sidebar.mobile.toggle -->
				<div class="navbar-header pull-left">
					<!-- #section:basics/navbar.layout.brand -->
					<a class="navbar-brand">
					<img  src="static/images/logo.png">
						<%--<small> <i class="fa fa-leaf"></i> 水污染源及水平衡在线监测系统 </small>
					--%></a>

					<!-- /section:basics/navbar.layout.brand -->

					<!-- #section:basics/navbar.toggle -->

					<!-- /section:basics/navbar.toggle -->
				</div>

				<!-- #section:basics/navbar.dropdown -->
				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav" style="padding: 10px 0px">
						<!-- <li class="grey">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-tasks"></i>
								<span class="badge badge-grey">2</span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-check"></i>
									预留功能,待开发
								</li>
								<li class="dropdown-footer">
									<a href="javascript:">
										预留功能,待开发
										<i class="ace-icon fa fa-arrow-right"></i>
									</a>
								</li>
							</ul>
						</li>

						<li title="即时聊天" class="purple"  onclick="creatw();">creatw()在 WebRoot\plugins\websocketInstantMsg\websocket.js中
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-bell icon-animated-bell"></i>
								<span class="badge badge-important"></span>
							</a>

							<ul class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="ace-icon fa fa-bell-o"></i>
									FH Aadmin 即时通讯
								</li>
							</ul>
						</li>

						<li title="站内信" class="green" onclick="fhsms();" id="fhsmstss">fhsms()在 WebRoot\static\js\myjs\head.js中
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon fa fa-envelope icon-animated-vertical"></i>
								<span class="badge badge-success" id="fhsmsCount"></span>
							</a>
						</li> -->

						<!-- #section:basics/navbar.user_menu -->
						<li class="light-blue" >
							<a data-toggle="dropdown"  class="dropdown-toggle" href="#">
								<img class="nav-user-photo" style="margin-bottom: 18px;" src="static/ace/avatars/user.jpg" alt="Jason's Photo" id="userPhoto" />
								<span class="user-info" id="user_info">
								</span>
								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a onclick="editPhoto();" style="cursor:pointer;"><i class="ace-icon glyphicon glyphicon-picture"></i>修改头像</a><!-- editUserH()在 WebRoot\static\js\myjs\head.js中 -->
								</li>
								<li>
									<a onclick="editUserH();" style="cursor:pointer;"><i class="ace-icon fa fa-user"></i>修改资料</a><!-- editUserH()在 WebRoot\static\js\myjs\head.js中 -->
								</li>
								<li>
									<a onclick="weiHu();" style="cursor:pointer;"><i class="ace-icon fa fa-user"></i>维护记录</a><!-- editUserH()在 WebRoot\static\js\myjs\head.js中 -->
								</li>
								<li id="systemset">
									<a onclick="editSys();" style="cursor:pointer;"><i class="ace-icon fa fa-cog"></i>系统设置</a><!-- editSys()在 WebRoot\static\js\myjs\head.js中 -->
								</li>
								<li class="divider"></li>
								<li>
									<a onclick="logout();" href="logout"><i class="ace-icon fa fa-power-off"></i>退出登录</a>
								</li>
							</ul>
						</li>

						<!-- /section:basics/navbar.user_menu -->
					</ul>
				</div>
				<!-- /section:basics/navbar.dropdown -->
				
				
				<div id="fhsmsobj"><!-- 站内信声音消息提示 --></div>
		 
		<div style=" width:100%;min-width: 1100px;float:left;border-top: 3px solid rgb(52, 152, 219);border-bottom: 3px solid rgb(52, 152, 219);">
		<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>
				
				
				 <a id="menuUrl" target="mainFrame" href="NewData.do?MENU_ID=94&R_ID="></a>
				 <a id="changeUrl" target="mainFrame" href=""></a>
		<ul id="menuList"class="example1" style="width:100%;min-width: 1200px">
		<%--<c:forEach items="${menuList}" var="menu1">
				<c:if test="${menu1.hasMenu && '1' == menu1.MENU_STATE}">
			<a href="#" style="width:12%;height:45px;"><li>${menu1.MENU_NAME }</li></a>
	       </c:if>
	       </c:forEach>
	     
		--%></ul></div>
				
			
			</div><!-- /.navbar-container -->
		</div>
		<script type="text/javascript">
		
		function logout(){
			$.removeCookie('menuUrl')
			$.removeCookie('menuUrl_s')
			$.removeCookie('menuUrl_ss')
			$.removeCookie('onSelect')
			$.removeCookie('onSelect2')
			
			
			
		}
		</script>
		<script type="text/javascript">
		
				function addUrl(){
					var href = $("#mainFrame").contents().find("#menuUrl").val();
             		 $("#menuUrl").attr("href",href);   
					
				}
			</script>
			