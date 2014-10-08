<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<!-- <link rel="stylesheet" href="plug-in/assets/bootstrap/css/bootstrap.min.css" type="text/css"/> -->
<body>
      <div class="open">
      	<div style="margin-bottom:20px;" class="dd"></div>
        <div class="dd"><label>用户名</label><input type="text" name="userName" value="${sysUser.userName}" class="in" disabled data-rule="required;username;remote[sysUserController.do?checkUserName, oldUserName]" data-ok=""  placeholder="用户名"/></div>
        <div class="dd"><label>姓名</label><input type="text" name="realName" value="${sysUser.realName}" class="in" disabled data-ok=""  placeholder="真实姓名"/></div>
        <t:dictSelect title="仓房" field="barnNo" id="barn" defaultVal="${sysUser.barnNo}" divClass="dd" divStyle="height: auto;padding-bottom: 10px;" style="width:200px;" dataTable="tf_barn" dataField="barnNo" dataText="barnNo" hasDisabled="true" hasMultiple="true" extendParams="{\"data-rule\":\"required;\",\"data-ok\":\"\",\"placeholder\":\"选择仓库\"}"></t:dictSelect>
        <div class="dd"><label>手机</label><input type="text" name="mobilePhone" value="${sysUser.mobilePhone}" class="in" disabled data-rule="mobile;" data-ok=""  placeholder="手机号"/></div>
        <div class="dd"><label>邮箱</label><input type="text" name="email" value="${sysUser.email}" class="in" disabled data-rule="email;" data-ok=""  placeholder="邮箱"/></div>
      </div><!--open e-->
</body>
	
