var contextMenu = (function(contextMenu){
    var resourcesTree = {
        expandByDepth :1,
        rootId: 0,
        zTree: '',
        pNode: '',
        setting : {
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
    				showLine: true,
    				selectedMulti : false,
    				showIcon:false
    			},
    			edit : {
    				drag : {
    					prev : false,
    					inner : true,
    					next : false,
    					isMove : true
    				},
    				enable : true,
    				showRemoveBtn : false,
    				showRenameBtn : false
    			},
    			callback : {
    				onClick : function(event, treeId, treeNode) {
    		    		var resId = treeNode.id;
    		    		if (resId == resourcesTree.rootId) {
    		    			return;
    		    		}
    		    		var url = "sysFunctionController.do?detail&id="+ treeNode.id;
    		    		$("#listFrame").attr("src", url);
    		    	},
    				onRightClick :function(e, treeId, treeNode) {
    		    		var x = e.pageX, y = e.pageY;
    		    		resourcesTree.hideItem();
    		    		resourcesTree.pNode = treeNode;
    		    		resourcesTree.showRightMenu({//显示右键菜单
		    	              x:x,   
		    	              y:y    
		    	        });
    		    	},
    				onDrop : function(event,treeId,treeNodes, targetNode, moveType) {
    		    		if(moveType == "inner"){
    		    			url = "sysFunctionController.do?moveTree";
    		    			var params = {
    		    				targetId : targetNode.id,
    		    				sourceId : treeNodes[0].id
    		    			};
    		    			$.post(url, params, function(data) {
    		    				data = $.parseJSON(data);
    		    				if(data.success==true){
    		    					App.alert(data.msg);
    		    					resourcesTree.loadTree();
    		    				}
    		    			});
    		    		}
    		        }
    			}
    		},
        init:{
            initEvent:{
                initRMenu:function(){
                    $("#rMenu").hover(function(){//设置进入右键菜单事件
                    	resourcesTree.bindClick($("#r_addFolder"),function(){
                    		resourcesTree.addFolder();
                        });
 
                    	resourcesTree.bindClick($("#r_addNode"),function(){
                    		resourcesTree.addNode();
                        });
 
                    	resourcesTree.bindClick($("#r_updateNode"),function(){
                    		resourcesTree.updateNode();
                        });
 
                    	resourcesTree.bindClick($("#r_deleteNode"),function(){
                    		resourcesTree.deleteNode();
                        });
                    },function(){//设置离开右键菜单事件
                    	resourcesTree.hideItem();
                    });                    
                }
            }
        },
        loadTree: function(){//加载树
        	var url = "systemController.do?sysFuncTree";
    		$.post(url, function(result) {
    			resourcesTree.zTree = $.fn.zTree.init($("#resourcesTree"),resourcesTree.setting, $.parseJSON(result));
    			if (resourcesTree.expandByDepth != 0) {
    				var nodes = resourcesTree.zTree.getNodesByFilter(function(node) {
    					return (node.level != 0);//展开根节点
    				});
    				if (nodes.length > 0) {
    					for (var idx = 0; idx < nodes.length; idx++) {
    						var node = nodes[idx];
    						if(node.isOpen == 1){
    							resourcesTree.zTree.expandNode(node, true, true);
    						}else{
    							resourcesTree.zTree.expandNode(node, false, false);
    						}
    						
    					}
    				}
    			} else {
    				resourcesTree.zTree.expandAll(true);
    			}

    		});
        },
        showRightMenu:function(postionJson){
            $("#rMenu").css({//设置右键菜单的位置
                top:postionJson.y + "px",
                left:postionJson.x+2 + "px",
                display:"block"
            });
            if(resourcesTree.pNode.id=="0"){//如果是根节点则禁用“删除”、“修改名称”选项
            	resourcesTree.showItem(["#r_addNode"]);
            }else if(resourcesTree.pNode.isFolder==1){
            	resourcesTree.showItem(["#r_addNode","#r_updateNode","#r_deleteNode",]);
            }else{//此选项为节点，则禁用“增加节点”、“增加文件夹”选项
            	resourcesTree.showItem(["#r_updateNode","#r_deleteNode"]);
            }            
            resourcesTree.init.initEvent.initRMenu();//加载菜单选项的事件
        },
        showItem:function(itemArray){//显示某些域
            for(var i = 0; i<itemArray.length; i++){
                $(itemArray[i]).show();
            }
        },
        hideItem:function(itemArray){//隐藏某些域
            if(itemArray==undefined){//如果为传入值，则禁用缺省的域
            	array = new Array();
            	array.push("#rMenu");
            	array.push("#r_addNode");
            	array.push("#r_updateNode");
            	array.push("#r_deleteNode");
            	resourcesTree.hideItem(array);
            }else{
            	for(var i = 0; i<itemArray.length; i++){
                    $(itemArray[i]).hide();
                }
            }
            
            
        },
        addNode: function(){//添加节点
        	var url = "sysFunctionController.do?addorupdate&operate=add&parentId="
				+ resourcesTree.pNode.id;
        	$("#listFrame").attr("src", url);
        },
        updateNode:function(){//更新节点-修改节点名称
        	var resId = resourcesTree.pNode.id;
    		if (resId == resourcesTree.rootId) {
    			App.alert("该节点为系统节点 ,不允许该操作");
    			return;
    		}
    		var url = "sysFunctionController.do?addorupdate&operate=edit&id="
    				+ resId;
    		$("#listFrame").attr("src", url);
        },
        deleteNode:function(){//删除节点
    		var resId = resourcesTree.pNode.id;
    		if (resId == resourcesTree.rootId) {
    			App.alert("该节点为系统节点 ,不允许该操作");
    			return;
    		}
    		
    		var callback = function() {
    			var url = "sysFunctionController.do?del";
    			var params = {
    				id : resId
    			};
    			$.post(url, params, function(data) {
    				data = $.parseJSON(data);
    				if (data.success==true) {//成功
    					resourcesTree.zTree.removeNode(resourcesTree.pNode);
    					$("#listFrame").attr("src", "about:blank");
    					App.alert(data.msg);
    					setTimeout(function () {
    						App.alertClose();
    					}, 2000);
    				}
    			});
    		};
    		App.confirm('确认删除吗？', callback);
    		
        },
        getSelectNode:function(){
        	resourcesTree = $.fn.zTree.getZTreeObj("resourcesTree.zTree");
    		var nodes = $.fn.zTree.getZTreeObj("resourcesTree").getSelectedNodes();
    		var node = nodes[0];
    		return node;
        },
        bindClick:function(obj,fn){//绑定click事件
            obj.unbind("click");
            obj.bind("click",fn);
        }
    };
    return {//此处为公开的数据
        loadTree:function(){
        	resourcesTree.loadTree();
        }
    };
})(contextMenu);

