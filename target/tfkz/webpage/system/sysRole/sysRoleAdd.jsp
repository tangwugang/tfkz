<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
<!--open s--> 
<form id="inputFrom" method="post" data-validator-option="{theme:'yellow_right_effect',stopOnError:true,timely:2}" >
      <div class="open">
      	<div class="dilog"><a href="javascript:;" class="submit-btn"></a></div>
        <div class="dd"><label>角色名称</label><input type="text" name="roleName" class="in" maxlength="50" data-rule="required;zh_cn;remote[sysRoleController.do?checkSysRole]" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok=""  placeholder="角色名称"/></div>
        <div class="dd"><label>角色授权</label><div id="resourcesTree" class="ztree" style="float: left;margin-top: 6px;" ></div></div>
        <div id="resId" class="hidden"></div>
      </div>
</form>
<!--open e-->
<script type="text/javascript">
$(function(){
	$('#inputFrom').validator({
		//验证成功
	    valid: function(form) {
	        $.ajax({
	            url: 'sysRoleController.do?save&resId='+$('#resId').text(),
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
	
	//加载树
	loadTree();
});


//树
var rootId = 0;
var resourcesTree;
var expandByDepth = 1;
//加载树
function loadTree() {
	var setting = {
			async : {
				enable : false
			},
			data : {
				key : {
					name : "funcName"
				},
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "parentId",
					rootPId : -1
				}
			},
			view : {
				selectedMulti : false
			},
			check: { 
				enable:true,nocheckInherit:true,
				chkboxType: { "Y": "ps", "N": "s" }
			},
			callback:{
				beforeClick:zTreeBeforeClick,
				onCheck: zTreeOnCheck
			}
		};
	var url = "systemController.do?sysFuncTree";
	$.post(url, function(result) {
		resourcesTree = $.fn.zTree.init($("#resourcesTree"), setting, 
				$.parseJSON(result));
		// 默认选中已分配节点
		var funcIds = "${sysRoleFuncIds}";
		if($.trim(funcIds)!=""){
			var ids = funcIds.split(",");
			$("#resId").text("${sysRoleFuncIds}");
			for(var i=0; i<ids.length; i++) {
				var node = resourcesTree.getNodeByParam("id", ids[i]);
				try{
					resourcesTree.checkNode(resourcesTree.getNodeByParam("id", rootId), true, false);
					resourcesTree.checkNode(node, true, false);
				}catch(e){}
			}
		}
		//

		if (expandByDepth != 0) {
			var nodes = resourcesTree.getNodesByFilter(function(node) {
				return (node.level == 0);//展开根节点
			});
			
			if (nodes.length > 0) {
				for (var idx = 0; idx < nodes.length; idx++) {
					resourcesTree.expandNode(nodes[idx], true, false);
				}
			}
		} else {
			resourcesTree.expandAll(true);
		}

	});

};
function zTreeBeforeClick(treeId, treeNode, clickFlag) {
	resourcesTree.checkNode(treeNode,treeNode.check, true, true);
    return false;
};

function zTreeOnCheck(event, treeId, treeNode) {
	var resourcesTree = $.fn.zTree.getZTreeObj("resourcesTree");
	var nodes = resourcesTree.getCheckedNodes(true);
	var resId="";
	$.each(nodes,function(i,n){
		if(n.id != rootId)resId+=n.id+",";
	});
	resId = resId.substring(0, $.trim(resId).length-1);
	$("#resId").text(resId);
};
</script>
</body>
	
