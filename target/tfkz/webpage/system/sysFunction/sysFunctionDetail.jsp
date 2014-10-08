<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@include file="../../common/head.jsp"%>
<div class="row-fluid">
<div class="portlet box" style="height:500px;">
<div class="portlet-body" style="height:1030px;">
<form class="form-horizontal">
		<div class="control-group success">
		<label class="control-label">资源名称<span class="required">*</span></label>
		<div class="controls">
		${sysFunction.funcName}
		</div>
		</div>
		
		<div class="control-group success">
		<label class="control-label">资源别名<span class="required">*</span></label>
		<div class="controls">
		${sysFunction.funcAlias}
		</div>
		</div>
		
		<div class="control-group success">
		<label class="control-label">默认地址</label>
		<div class="controls">
		${sysFunction.funcUrl}
		</div>
		</div>
		
		<div class="control-group success">
		<label class="control-label">资源图标</label>
		<div class="controls">
		<a id="addIcon" class="btn green" title="点我"><i class="icon-${sysFunction.icon}"></i></a>
		</div>
		</div>
		
		<div class="control-group success">
		<label class="control-label">是否有子节点</label>
		<div class="controls">
			<c:choose>
				<c:when test="${sysFunction.isFolder==0}">否</c:when>
				<c:otherwise>是</c:otherwise>
			</c:choose>
		</div>
		</div>
		<div class="control-group success">
		<label class="control-label">是否显示到菜单</label>
		<div class="controls">
			<c:choose>
				<c:when test="${sysFunction.isShow==0}">否</c:when>
				<c:otherwise>是</c:otherwise>
			</c:choose>
		</div>
		</div>
		<div class="control-group success">
		<label class="control-label">是否打开</label>
		<div class="controls">
			<c:choose>
				<c:when test="${sysFunction.isOpen==0}">否</c:when>
				<c:otherwise>是</c:otherwise>
			</c:choose>
		</div>
		</div>
		
		<div class="control-group success">
		<label class="control-label">同级排序</label>
		<div class="controls">
		${sysFunction.funcOrder}
		</div>
		</div>
</form>
</div>
</div>
</div>
<script type="text/javascript">
		
	$(function() {
		App.init();
	});
</script>
