<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
 <script type="text/javascript">
 //自定义js
 	$(function() {
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
				parent.$("#resId").text("${sysRoleFuncIds}");
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
		parent.$("#resId").text(resId);
	};
 
 </script>
</head>
	<div class="row-fluid">
		<div class="portlet box" style="height:500px;">
		<div class="portlet-body" style="height:1030px;">
			<div id="resourcesTree" class="ztree"></div>
		</div>
		</div>
	</div>
