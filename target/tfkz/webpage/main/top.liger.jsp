<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<div class="index_top">
	<div class="left_logo">
		<img id="logoImg" src="plug-in/ligerui/default/images/resicon/logo.png">
	</div>
	
	<div class="search_welcome">
		<div class="welcome_panel">
			<table border="0" style="display: inline-table;">
				<tbody><tr>
					<td nowrap="nowrap">
						<div style="padding: 5px;">
							<div id="welcomeContainer" onclick="setLink('default')">
								<span></span>
								欢迎您，${userName }
								${roleName}
							</div>
							<div id="loginContainer">
								<a id="loginButton" href="javascript:;" title="更多操作"></a>
								<div style="clear: both"></div>
								<div id="loginBox" class="itemDiv">
									<ul>
									
                                    <li><a class="more edit2" resid="-001" href="javascript:;">修改密码</a></li>
                                    
                                    <li><a class="more detail2" href="javascript:;" resid="-002" prehref="/bpm3/platform/system/sysUser/get.ht?userId=1&amp;canReturn=0">个人资料</a></li>
										<li class="moreinfo"><a class="more switch2" resid="-003" href="javascript:;">切换组织</a>
											<div style="position:absolute;top:0;right:95px;" class="itemDiv">
													<ul>
										            	<li><a class="curOrg" orgid="10000001640678">hotent-系统练习</a></li>
													</ul>
											</div>
										</li>
										<li><a class="more exit2" href="javascript:;">退出系统</a></li>
									</ul>
								</div>
								<em id="shadeEm"></em>
							</div>
					</div></td>
					<td>
						<div class="msg_div" alt="站内消息">
								<img id="inMsg" title="站内消息" src="plug-in/ligerui/default/images/msg_none.png">
							 (<a href="javascript:showReadMsgDlg()" id="labMsgSize">0</a>)
						</div>
					</td>
				</tr>
			</tbody></table>
		</div>
	</div>
	<div class="index_menu">
		<div class="menuParent">
			<div id="menuPanel" class="menuPanel">
<!-- 			<a class="menuItem menuItem_hover" id="1"> -->
<!-- 			<img src="plug-in/ligerui/default/images/resicon/user.png"><span>用户组织管理</span></a> -->
<!-- 			<a class="menuItem" id="34"> -->
<!-- 			<img src="plug-in/ligerui/default/images/resicon/destop.png"><span>个人办公</span></a> -->
<!-- 			<a class="menuItem" id="148"> -->
<!-- 			<img src="plug-in/ligerui/default/images/resicon/manage.png"><span>流程管理</span></a> -->
<!-- 			<a class="menuItem" id="75"> -->
<!-- 			<img src="plug-in/ligerui/default/images/resicon/setting.png"><span>系统管理</span></a> -->
			</div>
		</div>
		<div class="nav_button">
			<a class="nav_left" href="#" onclick="rollLeft()" onmousedown="startRoll(0)" onmouseup="breakRoll()" title="向左移动"></a>
			<a class="nav_right" href="#" onclick="rollRight()" onmousedown="startRoll(1)" onmouseup="breakRoll()" title="向右移动"></a>
		</div>
	</div>
<!-- 	<div class="changge_skin">  -->
<!-- 		<img src="plug-in/ligerui/default/images/icons/icons_38.png"   onclick="changeSkin('default')" /> <img -->
<!-- 			src="plug-in/ligerui/default/images/icons/icons_40-69.png"   onclick="changeSkin('green')"/>  -->
		
<!-- 			<img src="plug-in/ligerui/default/images/icons/icons_44-73.png" onclick="changeSkin('other')"/> -->
		
<!-- 			<img src="plug-in/ligerui/default/images/icons/icons_41-71.png" /> -->
<!-- 	</div> -->

	<div class="head_bg">
	</div>
</div>