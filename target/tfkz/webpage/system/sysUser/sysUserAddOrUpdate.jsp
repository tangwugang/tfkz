<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
<!--open s--> 
<form id="inputFrom" method="post" data-validator-option="{theme:'yellow_right_effect',stopOnError:true,timely:2}" >
	  <!--角色id add -->
	  <input type="hidden" name="roleId" value="${roleId}"/>
	  <!--用户id update-->
	  <c:if test="${sysUser.id != null}"><input type="hidden" name="id" value="${sysUser.id}"/></c:if>
	  <c:if test="${sysUser.userName != null}"><input type="hidden" name="oldName" value="${sysUser.userName}"/></c:if>
      <!--open s--> 
      <div class="open">
      	<div class="dilog"><a href="javascript:;" class="submit-btn"></a></div>
        <div class="dd"><label>用户名</label><input type="text" name="userName" value="${sysUser.userName}" class="in" data-rule="required;username;remote[sysUserController.do?checkSysUser, oldName]" data-ok=""  placeholder="用户名"/></div>
        <div class="dd"><label>姓名</label><input type="text" name="realName" value="${sysUser.realName}" class="in" data-rule="required;zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok=""  placeholder="真实姓名"/></div>
        <div class="dd"><label>密码</label><input type="password" name="password" class="in" <c:if test="${sysUser.id != null}">data-rule="密码:!digits; length[6~]"</c:if> <c:if test="${sysUser.id == null}">data-rule="密码: required; !digits; length[6~]"</c:if>  data-msg-digits="{0}不能使用纯数字" data-msg-length="{0}至少6位" data-ok=""  placeholder="密码"/></div>
        <div class="dd"><label>确认密码</label><input type="password" name="againPwd" class="in" <c:if test="${sysUser.id != null}">data-rule="确认密码:match(password);"</c:if> <c:if test="${sysUser.id == null}">data-rule="确认密码: required;match(password);"</c:if> data-ok=""  placeholder="确认密码"/></div>
        <t:dictSelect title="仓房" field="barnNo" id="barn" defaultVal="${sysUser.barnNo}" divClass="dd" divStyle="height: auto;padding-bottom: 10px;" selectStyle="width:200px;" dataTable="tf_barn" dataField="barnNo" dataText="barnNo" hasMultiple="true" extendParams="{\"data-rule\":\"required;\",\"data-ok\":\"\",\"placeholder\":\"选择仓库\"}"></t:dictSelect>
        <div class="dd"><label>手机</label><input type="text" name="mobilePhone" value="${sysUser.mobilePhone}" class="in" data-rule="mobile;" data-ok=""  placeholder="手机号"/></div>
        <div class="dd"><label>邮箱</label><input type="text" name="email" value="${sysUser.email}" class="in" data-rule="email;" data-ok=""  placeholder="邮箱"/></div>
      </div><!--open e-->
</form>
<!--open e-->
<script type="text/javascript">
$(function(){
	$('#inputFrom').validator({
		//验证成功
	    valid: function(form) {
	       $.ajax({
	            url: 'sysUserController.do?save',
	            type: 'POST',
	            data: $(form).serialize(),
	            success: function(result){
	            	var result = $.parseJSON(result);
	            	var api = frameElement.api, W = api.opener;
	            	if(result.success == false){
	            		api.close();
	            		W.$.dialog({
	            			id:'alert',
	        				title:'提示',
	        				time:3,
	        				icon:'error.gif',
	        				content:result.msg,
	        				max:false,
	        		        min:false,
	        		        resize:false
	        			});
	            	}else{
	            		api.hide();
	            		W.$.dialog({
	            			id:'alert',
	        				title:'提示',
	        				time:3,
	        				icon:'success.gif',
	        				content:result.msg,
	        				max:false,
	        		        min:false,
	        		        resize:false
	        			});
	            		setTimeout(function(){top.location.reload();},1000);
	            	}
	            } 
	        });
	    }
	})
	// 使用链接代替submit按钮（注意：这种情况下输入框里面的回车键不能触发submit事件）
	.on("click", "a.submit-btn", function(e){
	    $(e.delegateTarget).trigger("validate");
	});
	
});

</script>
</body>
	
