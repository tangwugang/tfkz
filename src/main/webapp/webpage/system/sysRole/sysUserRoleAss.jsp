<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="/context/mytags.jsp"%>
<head>
<title>${fns:getSysName('productName')}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<t:base type="jquery,ligerui"></t:base>
 <script type="text/javascript">
 //自定义js
 	$(function() {
 		//布局
		loadLayout();
		//加载树
		loadTree();
	});
 
 
 	//布局
	function loadLayout() {
		$("#layout").ligerLayout({
			leftWidth : 120,
			onHeightChanged : heightChanged,
			allowLeftResize : false
		});
		//取得layout的高度
		var height = $(".l-layout-center").height();
	};
	
	//布局大小改变的时候通知tab，面板改变大小
	function heightChanged(options) {
		$("#resourcesTree").height(options.middleHeight - 90);
	};
 
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
						name : "departName"
					},
					simpleData : {
						enable : true,
						idKey : "id",
						pIdKey : "parentDepartId",
						rootPId : -1
					}
				},
				view : {
					selectedMulti : false
				},
				callback:{
					onClick: zTreeOnLeftClick
				}
			};
		var url = "systemController.do?sysDepartTree";
		$.post(url, function(result) {
			resourcesTree = $.fn.zTree.init($("#resourcesTree"), setting, 
					$.parseJSON(result));

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
	
	//左击
	function zTreeOnLeftClick(event, treeId, treeNode) {
		var resId = treeNode.id;
		if (resId == rootId) {
			return;
		}
		var url = "sysUserController.do?sysUserDepart&departId="+ treeNode.id;
		$("#listFrame").attr("src", url);
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
<body>
<div id="layout">
	<div position="left" title="资源管理" style="text-align: left;">
			<div class="panel-detail">
				<div id="resourcesTree" class="ztree"></div>
			</div>
	</div>
	<div position="center">
			<iframe id="listFrame" src="sysUserController.do?sysUserDepart" frameborder="no" width="100%"
				height="100%"></iframe>
	</div>
</div>
</body>
</html>