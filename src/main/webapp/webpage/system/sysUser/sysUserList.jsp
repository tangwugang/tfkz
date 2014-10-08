<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<script>
$(function(){
	$.post("sysRoleController.do?dataContext",function(reslut){
		var data = $.parseJSON(reslut);
		var str ='<div class="c_center"><ul>';
		for (var i = 0; i < data.length; i++) {
			str+='<li class="r_list"><div class="role"><div class="r_left"><input type="checkbox" data-id="'+data[i].obj.id+'"/><b>'+data[i].obj.roleName+'</b></div>';
			str+='<div class="r_center">';
			var funcList = data[i].objList1;
			for(var f = 0; f < funcList.length; f++){
				str+=funcList[f].funcName+' ';
			}
			str+='</div><div class="r_right"><a href="javascript:;" class="uadd" data-id="'+data[i].obj.id+'">创建账号</a></div><div class="clr"></div></div>';
			str+=' <div class="account"><ul>';
			var userList = data[i].objList2;
			for (var u = 0; u < userList.length; u++) {
				str+='<li class="a_list"><div class="a_left">'+userList[u].userName+'</div>';
				if(null != userList[u].barnNo && userList[u].barnNo != ""){
					str+='<div class="a_center">'+userList[u].barnNo.replace(","," ").replace("All","全部")+'</div>';
				}
				str+='<div class="a_right"><a href="javascript:;" class="xg" data-id="'+userList[u].id+'" title="修改"></a><a href="javascript:;" class="sc" data-id="'+userList[u].id+'" title="删除"></a></div></li><div class="clr"></div>';
			}
			str+='</ul></div>';
		}
		str+='</ul></div>';
		$('body').append(str).on('click','a.uadd',function(){
			title = $(this).text();
			$.dialog({
					id:'addUser',
			        title: title,
			        height : 380,
			        width : 450,
			        max:false,
			        min:false,
			        resize:false,
			        content:'url:sysUserController.do?sysUserAddOrUpdate&roleId='+$(this).data("id")
		    });
		})
		.on('click','a.xg',function(){
			title = $(this).text();
			var userId = $(this).data("id");
			$.dialog({
					id:'xgUser',
			        title: title,
			        height : 380,
			        width : 450,
			        max:false,
			        min:false,
			        resize:false,
			        content:'url:sysUserController.do?sysUserAddOrUpdate&id='+userId
		    });
		})
		.on('click','a.sc',function(){
			var userId = $(this).data("id");
			$.dialog.confirm('你确定要删除吗？', function(){
				$.post('sysUserController.do?del&id='+userId,function(result){
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
		.on('click',':checkbox',function(){
			var e = $(this);
			$(":checkbox").each(function(){
				if($(this).data("id")!= e.data("id") && $(this).is(":checked")){
					$(this).attr("checked",false);
				}
			});
		})
		.on('click','.r_center',function(){
			$(this).parent().siblings(".account").toggle();
		})
	});
	
	
	$("body").on('click','a.cview,a.cmodify,a.cdel',function(e){
		e.preventDefault();
		var flag = false;
		var ev = $(this);
		$(":checkbox").each(function(){
			if($(this).is(":checked")){
				//$(this).data("id")
				flag = true;
				if(ev.attr('class')=='cview'){
				}else if(ev.attr('class')=='cmodify'){
					$.dialog({
						id:'modifyRole',
						lock:true,
				        title: ev.text(),
				        height : 380,
				        width : 450,
				        max:false,
				        min:false,
				        resize:false,
				        content:'url:sysRoleController.do?sysRoleUpdate&id='+$(this).data("id")
			    	});
				}else if(ev.attr('class')=='cdel'){
					var roleId = $(this).data("id");
					$.dialog.confirm('你确定要删除吗？', function(){
						$.post('sysRoleController.do?del&id='+roleId,function(result){
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
					
				}
			}
		});
		if(!flag){
			$.dialog({
				title:'提示',
				time:3,
				icon:'alert.gif',
				content:'请先选择角色！',
				max:false,
		        min:false,
		        resize:false
			});
		}
		
	});
	
	$("body").on('click','a.cadd',function(){
		title = $(this).text();
		$.dialog({
				id:'addRole',
		        title: title,
		        height : 380,
		        width : 450,
		        max:false,
		        min:false,
		        resize:false,
		        content:'url:sysRoleController.do?sysRoleAdd'
	    });
		
	});
	
});
</script>
</head>
<body>
	 <!-----------人员管理 s--------------------->
    <div class="C_top">
      <a href="javascript:" class="cadd">创建角色</a>
<!--       <a href="javascript:" class="cview">角色信息查看</a> -->
      <a href="javascript:" class="cmodify">角色信息修改</a>
      <a href="javascript:" class="cdel">角色删除</a>
    </div><!--C_top e-->
 <!-----------人员管理 e--------------------->
</body>
</html>