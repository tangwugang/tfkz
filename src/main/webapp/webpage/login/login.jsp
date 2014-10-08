<%@page import="java.util.Properties"%>
<%@page import="org.takinframework.core.util.ApplicationContextUtil"%>
<%@ page pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>${fns:getSysName('productName')}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<link rel="stylesheet" type="text/css" href="${ctx}/plug-in/barn/css/style.css"></link>

<%
	Properties configProperties = (Properties) ApplicationContextUtil
			.getBean("configProperties");
	String validCodeEnabled = configProperties
			.getProperty("validCodeEnabled");
%>
</head>
<body>
	<form id="form-login" action="loginController.do?login"
		check="loginController.do?checkuser" method="post">
		<div class="banner">
		  <div class="center">
		    <div class="title">
		      <div class="l_logo"></div>
		    </div>
		    <div class="b_content">
		      <div class="l_img"></div>
		      <div class="r_box">
		        <h1>欢迎登录！</h1>
		          <div class="error"></div>
		        <div class="input_box">
		          <span style="border-bottom:1px #ddd solid;"><input type="text" class="username" name="userName" iscookie='true'  nullmsg="请输入用户名" placeholder="用户名"/></span>
		          <span><input type="password" class="psw" name="password" nullmsg="请输入密码" placeholder="密码"/></span>
		        </div>
		        <div class="mid_line">
		          <div class="remember"><input type="checkbox" />记住用户名</div>
		        </div>
		        <div class="lg_btn"><a href="javascript:;" class="login_btn">登录</a></div>
		      </div>
		    </div>
		  </div>
		</div>
		<div class="clr"></div>
		<div class="copyright"><p>版权所有&nbsp;©&nbsp;浙江省粮食局直属库</p><p>技术支持&nbsp;&nbsp;浙江银江云计算技术有限公司</p></div>
	</form>
<script type="text/javascript" src="${ctx}/plug-in/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/plug-in/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="${ctx}/plug-in/login/js/login.js"></script>
</body>
</html>
