<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
    <!--open s--> 
<form id="inputFrom" method="post" data-validator-option="{theme:'yellow_right_effect',stopOnError:true,timely:2}" >
	  <c:if test="${sysType.id != null}"><input type="hidden" name="id" value="${sysType.id}"/></c:if>
      <!--open s--> 
      <div class="open">
      	<div class="dilog"><a href="javascript:;" class="submit-btn"></a></div>
        <div class="dd"><label>参数名</label><input type="text" name="typeName" value="${sysType.typeName}" class="in" data-rule="required;" data-rule="required;" data-ok=""  placeholder="参数名"/></div>
        <div class="dd"><label>键值</label><input type="text" name="typeCode" value="${sysType.typeCode}" class="in" data-rule="required;" data-ok=""  placeholder="键值"/></div>
        <div class="dd"><label>参数类型</label><input type="text" name="type" value="${sysType.type}" class="in" data-rule="required;username" data-ok=""  placeholder="参数类型"/></div>
        <div class="dd"><label>描述</label><input type="text" name="description" value="${sysType.description}" class="in" data-ok=""  placeholder="描述"/></div>
        <div class="dd"><label>排序</label><input type="text" name="sort" value="${sysType.sort}" class="in" data-rule="integer; range[0~100]" data-ok=""  placeholder="排序"/></div>
      </div><!--open e-->
</form>
<!--open e-->
<script type="text/javascript">
$(function(){
	$('#inputFrom').validator({
		//验证成功
	    valid: function(form) {
	       $.ajax({
	            url: 'sysTypeController.do?save',
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