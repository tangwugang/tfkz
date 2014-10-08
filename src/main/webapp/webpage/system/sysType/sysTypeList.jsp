<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
	<div class="container">
 <!-----------操作日志 s---------------------> 
  <div id="div5">
<form id="searchForm" method="post" >
	<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <div class="J_top">
    <t:dictSelect title="参数类型" field="type" id="type" defaultVal="${sysType.type}" divClass="J_type" selectClass="in" ></t:dictSelect>
      <div class="J_staff">
        <label>描述</label><input type="text" name="description" value="${sysType.description}" class="in" style="width:160px "/>
      </div>
      <div class="J_btn"><a href="javascript:;" class="s_search"></a></div>
    </div><!--J_top e -->
</form>
    <div class="J_center">
      <table cellpadding="0" cellspacing="0" style="width:980px">
      <tr class="topic">
        <td height="35" width="180">参数名</td>
        <td width="130">键值</td>
        <td width="130">参数类型</td>
        <td width="230">描述</td>
        <td width="30">排序</td>
        <td width="230">操作</td>
      </tr>
      <c:forEach  items="${page.list}" var="type">
      	<tr>
        <td height="28">${type.typeName}</td>
        <td>${type.typeCode}</td>
        <td>${type.type}</td>
        <td>${type.description}</td>
        <td>${type.sort}</td>
        <td class="f1">
        <a href="javascript:;" class="s_xg" data-id="${type.id}">修改</a>&nbsp;&nbsp;<a href="javascript:;" class="s_sc" data-id="${type.id}">删除</a>&nbsp;&nbsp;<a href="javascript:;" class="s_add" data-type="${type.type}" data-description="${type.description}">添加</a></td>
      </tr>
      </c:forEach>
      </table>
    </div><!--J_center e-->
    <div class="J_page">
      ${page}
    </div><!--J_page e-->
   </div><!--div5 e-->
 <!-----------操作日志 e---------------------> 
</div><!--container e-->
<script type="text/javascript">
	$('body').on('click','a.s_add',function(){
		title = $(this).text();
		type = $(this).data("type");
		description = $(this).data("description");
		$.dialog({
			id:'addType',
	        title: title,
	        height : 380,
	        width : 450,
	        max:false,
	        min:false,
	        resize:false,
	        content:'url:sysTypeController.do?sysTypeAddOrUpdate&type='+type+'&description='+encodeURIComponent(description)
    	});
	})
	.on('click','a.s_sc',function(){
		var id = $(this).data("id");
		$.dialog.confirm('你确定要删除吗？', function(){
			$.post('sysTypeController.do?del&id='+id,function(result){
				var result = $.parseJSON(result);
				if(result.success == true){
					$.dialog({
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
				}else{
					$.dialog({
            			id:'alert',
        				title:'提示',
        				time:3,
        				icon:'error.gif',
        				content:result.msg,
        				max:false,
        		        min:false,
        		        resize:false
        			});
				}
				
			});
		});
	})
	.on('click','a.s_xg',function(){
		title = $(this).text();
		var id = $(this).data("id");
		$.dialog({
				id:'xgType',
		        title: title,
		        height : 380,
		        width : 450,
		        max:false,
		        min:false,
		        resize:false,
		        content:'url:sysTypeController.do?sysTypeAddOrUpdate&id='+id
	    });
	})
	.on('click','a.s_search',function(e){
		$('form').submit();
	});
</script>
</body>