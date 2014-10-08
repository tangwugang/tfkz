<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- BEGIN JAVASCRIPTS -->
<script type="text/javascript">
	$(function(){
		//加载菜单
		loadMenu();
	});
	var aryTreeData=null;
	var current_node=null;
	var parents = new Array();
	var str ="";
	var breadcrumb="";
	//加载菜单面板
	function loadMenu(){
	    $(".page-sidebar-menu").empty();
		//一次性加载
		$.post("loginController.do?leftTree",
			 function(result){
				aryTreeData=$.parseJSON(result);
				current_node = App.getCookie("current_node");
				if(current_node!=null){hasParentById(current_node);parents.push(current_node);}
				
				//获取根节点，加载顶部按钮菜单。
				str+="<li><div class=\"sidebar-toggler hidden-phone\"></div> </li>";
				if(current_node!=null){str+=" <li class=\"start\">";}else{str+=" <li class=\"start active \">"; breadcrumb+="<li style=\"float: left;\"><i class=\"icon-angle-right\"></i><a href=\"javascript:;\">个人面板</a></li>";}
				str+="<a href=\"index.html\">"+
				"<i class=\"icon-home\"></i><span class=\"title\">个人面板</span><span class=\"selected\"></span></a></li>";
				for(var i=0;i<aryTreeData.length;i++){
            		var node=aryTreeData[i];
            		if(node.parentId==0 && node.isShow==1){
            			str+="<li class=\"";
            			//激活父节点active
            			for (var k = 0; k < parents.length; k++) {
            				if(parents[k]==node.id){str+="active";breadcrumb+="<li style=\"float: left;\"> <i class=\"icon-angle-right\"></i>  <a ";if(node.funcUrl!=null){breadcrumb+="href=\""+node.funcUrl+"\"";}else{breadcrumb+="href=\"javascript:;\"";} breadcrumb+=">"+node.funcName+"</a>  </li>";}
        				}
            			str+="\"> <a node=\""+node.id+"\"";
            			if(node.funcUrl!=null){str+="href=\""+node.funcUrl+"\"";}else{str+="href=\"javascript:;\"";}
            			str+="> <i class=\"icon-"+node.icon+"\"></i> "+
            			"<span class=\"title\">"+node.funcName+"</span>";
            			if(hasChildByParentId(node.id)){
            				str+="<span class=\"arrow ";
            				for (var k = 0; k < parents.length; k++) {
            				if(parents[k]==node.id){str+="open";}
        					}
            				str+="\"></span>";
        				}
            			str+="</a>";
            			getChildByParentId(node.id);
            			str+="</li>";
            		}
            	}
				
				$(".page-sidebar-menu").html(str);
				breadcrumb+="<div style=\"clear:both;\"></div>";
				$(".breadcrumb").append(breadcrumb);
			});
	};
	//获取子节点
	function getChildByParentId(parentId){
		if(hasChildByParentId(parentId)){
			str+="<ul class=\"sub-menu\">";
			for(var i=0;i<aryTreeData.length;i++){
	    		var node=aryTreeData[i];
	    		if(node.parentId==parentId && node.isShow==1){
	    			str+="<li class=\"";
        			for (var k = 0; k < parents.length; k++) {
        				if(parents[k]==node.id){str+="active";breadcrumb+="<li style=\"float: left;\"> <i class=\"icon-angle-right\"></i> <a ";if(node.funcUrl!=null){breadcrumb+="href=\""+node.funcUrl+"\"";}else{breadcrumb+="href=\"javascript:;\"";} breadcrumb+=">"+node.funcName+"</a> </li>";}
    				}
        			str+="\"> <a node=\""+node.id+"\"";
	    			if(node.funcUrl!=null){str+="href=\""+node.funcUrl+"\"";}else{str+="href=\"javascript:;\"";}
	    			str+="> <i class=\"icon-"+node.icon+"\"></i> "+node.funcName;
	    			if(hasChildByParentId(node.id)){
        				str+="<span class=\"arrow ";
        				for (var k = 0; k < parents.length; k++) {
        				if(parents[k]==node.id){str+="open";}
    					}
        				str+="\"></span>";
    				}
	    			str+="</a>";
	    			getChildByParentId(node.id);
	    			str+="</li>";
	    		}
	    		
	    	}
			
			str+="</ul>";
		}
    	
    };
  	//判断是否有子节点
    function hasChildByParentId(parentId){
    	for(var i=0;i<aryTreeData.length;i++){
    		var node=aryTreeData[i];
    		if(node.parentId==parentId && node.isShow==1){
    			return true;
    		}
    	}
    }
    
 	//判断当前节点是否有父节点
    function hasParentById(id){
    	for(var i=0;i<aryTreeData.length;i++){
    		var node=aryTreeData[i];
    		if(node.id == id && node.isShow==1 && node.parentId!=0){
    			parents.push(node.parentId);
    			hasParentById(node.parentId);
    		}
    	}
    	return parents;
    }
</script>

<!-- END JAVASCRIPTS -->
<!-- BEGIN SIDEBAR -->
	<div class="sidebar-scroll">

		<div class="page-sidebar nav-collapse collapse">

			<!-- BEGIN SIDEBAR MENU -->        

			<ul class="page-sidebar-menu">
<!-- 				<li> -->
<!-- 					BEGIN SIDEBAR TOGGLER BUTTON -->
<!-- 					<div class="sidebar-toggler hidden-phone "></div> -->
<!-- 					BEGIN SIDEBAR TOGGLER BUTTON -->
<!-- 				</li> -->
<!-- 				<li class="start active "> -->

<!-- 					<a href="index.html"> -->

<!-- 					<i class="icon-home"></i>  -->

<!-- 					<span class="title">个人面板</span> -->

<!-- 					<span class="selected"></span> -->

<!-- 					</a> -->
<!-- 				</li> -->


				<!-- 获取菜单 -->
<!-- 				<li> -->
<!-- 					<a node="" href="javascript:;"> -->
<!-- 					<i class="icon-sitemap"></i>  -->
<!-- 					<span class="title">3 Level Menu</span> -->
<!-- 					<span class="arrow "></span> -->
<!-- 					</a> -->
<!-- 					<ul class="sub-menu"> -->
<!-- 						<li> -->
<!-- 							<a node="" href="javascript:;"> -->
<!-- 							Item 1 -->
<!-- 							<span class="arrow"></span> -->
<!-- 							</a> -->
<!-- 							<ul class="sub-menu"> -->
<!-- 								<li><a node="" href="#">Sample Link 1</a></li> -->
<!-- 							</ul> -->
<!-- 						</li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<a href="javascript:;"> -->
<!-- 					<i class="icon-folder-open"></i>  -->
<!-- 					<span class="title">4 Level Menu</span> -->
<!-- 					<span class="arrow "></span> -->

<!-- 					</a> -->

<!-- 					<ul class="sub-menu"> -->

<!-- 						<li> -->

<!-- 							<a href="javascript:;"> -->

<!-- 							<i class="icon-cogs"></i>  -->

<!-- 							Item 1 -->

<!-- 							<span class="arrow"></span> -->

<!-- 							</a> -->

<!-- 							<ul class="sub-menu"> -->

<!-- 								<li> -->

<!-- 									<a href="javascript:;"> -->

<!-- 									<i class="icon-user"></i> -->

<!-- 									Sample Link 1 -->

<!-- 									<span class="arrow"></span> -->

<!-- 									</a> -->

<!-- 									<ul class="sub-menu"> -->

<!-- 										<li><a href="#"><i class="icon-remove"></i> Sample Link 1</a></li> -->

<!-- 										<li><a href="#"><i class="icon-pencil"></i> Sample Link 1</a></li> -->

<!-- 										<li><a href="#"><i class="icon-edit"></i> Sample Link 1</a></li> -->

<!-- 									</ul> -->

<!-- 								</li> -->

<!-- 								<li><a href="#"><i class="icon-user"></i>  Sample Link 1</a></li> -->

<!-- 								<li><a href="#"><i class="icon-external-link"></i>  Sample Link 2</a></li> -->

<!-- 								<li><a href="#"><i class="icon-bell"></i>  Sample Link 3</a></li> -->

<!-- 							</ul> -->

<!-- 						</li> -->

<!-- 						<li> -->

<!-- 							<a href="javascript:;"> -->

<!-- 							<i class="icon-globe"></i>  -->

<!-- 							Item 2 -->

<!-- 							<span class="arrow"></span> -->

<!-- 							</a> -->

<!-- 							<ul class="sub-menu"> -->

<!-- 								<li><a href="#"><i class="icon-user"></i>  Sample Link 1</a></li> -->

<!-- 								<li><a href="#"><i class="icon-external-link"></i>  Sample Link 1</a></li> -->

<!-- 								<li><a href="#"><i class="icon-bell"></i>  Sample Link 1</a></li> -->

<!-- 							</ul> -->

<!-- 						</li> -->

<!-- 						<li> -->

<!-- 							<a href="#"> -->

<!-- 							<i class="icon-folder-open"></i> -->

<!-- 							Item 3 -->

<!-- 							</a> -->

<!-- 						</li> -->

<!-- 					</ul> -->

<!-- 				</li> -->

				

			</ul>

			<!-- END SIDEBAR MENU -->
			</div>

		</div>

		<!-- END SIDEBAR -->