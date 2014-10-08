<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="/context/mytags.jsp"%>
<head>
<title>${fns:getSysName('productName')}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<t:base type="jquery,cookie,ligerui,tools,DatePicker,autocomplete"></t:base>
<script type="text/javascript">
	var tab = null;
	var accordion = null;
	var tree = null;
	var tabItems = [];
	var setting = {
    		view: {showLine: true,nameIsHTML: true},
    		data: {
				key : {name: "funcName"},
				simpleData: {enable: true,idKey: "id",pIdKey: "parentId"}
			},
    		callback: {onClick: zTreeOnClick}
    };
	$(function() {
		

		//布局
		$("#layout1").ligerLayout({
			leftWidth : 190,
			height : '100%',
			heightDiff : -34,
			space : 4,
			onHeightChanged : f_heightChanged
		});

		var height = $(".l-layout-center").height();

		//Tab
		$("#framecenter").ligerTab({
			height : height,
			showSwitchInTab : true,
			showSwitch : true,
			onAfterAddTabItem : function(tabdata) {
				tabItems.push(tabdata);
				saveTabStatus();
			},
			onAfterRemoveTabItem : function(tabid) {
				for (var i = 0; i < tabItems.length; i++) {
					var o = tabItems[i];
					if (o.tabid == tabid) {
						tabItems.splice(i, 1);
						saveTabStatus();
						break;
					}
				}
			},
			onReload : function(tabdata) {
				var tabid = tabdata.tabid;
				addFrameSkinLink(tabid);
			}
		});

		//面板
		$("#accordion1").ligerAccordion({
			height : height - 24,
			speed : null
		});

		$(".l-link").hover(function() {
			$(this).addClass("l-link-over");
		}, function() {
			$(this).removeClass("l-link-over");
		});
		//                 //树
		//                 $("#tree1").ligerTree({
		//                     data : indexdata,
		//                     checkbox: false,
		//                     slide: false,
		//                     nodeWidth: 120,
		//                     attribute: ['nodename', 'url'],
		//                     onSelect: function (node)
		//                     {
		//                         if (!node.data.url) return;
		//                         var tabid = $(node.target).attr("tabid");
		//                         if (!tabid)
		//                         {
		//                             tabid = new Date().getTime();
		//                             $(node.target).attr("tabid", tabid)
		//                         } 
		//                         f_addTab(tabid, node.data.text, node.data.url);
		//                     }
		//                 });

		tab = liger.get("framecenter");
		accordion = liger.get("accordion1");
		//tree = liger.get("tree1");
		//加载菜单
		//loadMenu();
		$("#pageloading").hide();
	});
	function f_heightChanged(options) {
		if (tab)
			tab.addHeight(options.diff);
		if (accordion && options.middleHeight - 24 > 0)
			accordion.setHeight(options.middleHeight - 24);
	}
	function f_addTab(tabid, text, url) {
		tab.addTabItem({
			tabid : tabid,
			text : text,
			url : url,
			callback : function() {
				addShowCodeBtn(tabid);
				addFrameSkinLink(tabid);
			}
		});
	}
	
	 //加载菜单面板
    function loadMenu(){
        $("#leftTree").empty();
    	//一次性加载
		$.post("loginController.do?leftTree",
			 function(result){
				aryTreeData=$.parseJSON(result);
				//获取根节点，加载顶部按钮菜单。
				var headers=getRootNodes();
				var len=headers.length;
				var menuContainer=$("#menuPanel");
				for(var i=0;i<len;i++){
        			var head=headers[i];
        			var menuItemHtml=getMenuItem(head);
        			menuContainer.append($(menuItemHtml));
        		}
				initRollButton();
				
				if(len>0){
					var selectTab=$.cookie("selectTab");
					var obj= $("#" +selectTab);
					if(selectTab && obj.length>0){
						$("#" +selectTab).addClass("menuItem_hover");
						loadTree(selectTab);
					}
					else{
						
						var head=headers[0];
						var resId=head.id;
						$("#" +resId).addClass("menuItem_hover");
						loadTree(resId);
					}
				}
			});
    }
	//加载菜单
	function loadTree(resId){
    	var nodes=new Array();
		getChildByParentId(resId,nodes);
		var zTreeObj =$.fn.zTree.init($("#leftTree"), setting, nodes);
        var depth = 1; // 默认展开节点层级
		var nodes = zTreeObj.getNodesByFilter(function(node){
			return (node.funcLevel==depth);
		});
		
		if(nodes.length>0){
			for(var idx=0;idx<nodes.length;idx++){
				zTreeObj.expandNode(nodes[idx],false,false);
			}
		}
    }
	
	//加载菜单项
    function getMenuItem(node){
    	var str='<a class="menuItem" id="'+node.id+'">';
   		if(node.icon!="null" && node.icon!="" && node.icon!= null){
   			str+='<img src="'+node.icon+'" />';
   		}else{
   			str+='<img src="plug-in/ligerui/default/images/resicon/manage.png" />';
   		}
   		str+='<span >'+node.funcName+'</span></a>';
   		return str;
	}
	
	function getChildByParentId(parentId,nodes){
    	for(var i=0;i<aryTreeData.length;i++){
    		var node=aryTreeData[i];
    		if(node.parentId==parentId){
    			nodes.push(node);
    			getChildByParentId(node.id,nodes);
    		}
    	}
    };
    
    //处理点击事件
    function zTreeOnClick(event, treeId, treeNode) {
    	var url= treeNode.funcUrl;
    	if(url!=null && url!='' && url!='null'){
        	//扩展了tab方法。
        	addToTab(url,treeNode.funcName,treeNode.id,treeNode.icon);
    	}
    };
    
    //添加到tab或者刷新
    function addToTab(url,txt,id,icon){
    	if(tab.isTabItemExist(id)){
    		tab.selectTabItem(id);
    		tab.reload(id);
    	}
    	else{
    		tab.addTabItem({ tabid:id,text:txt,url:url,icon:icon});
    	}
    };
	
	function addShowCodeBtn(tabid) {
		var viewSourceBtn = $('<a class="viewsourcelink" href="javascript:void(0)">查看源码</a>');
		var jiframe = $("#" + tabid);
		viewSourceBtn.insertBefore(jiframe);
		viewSourceBtn.click(function() {
			showCodeView(jiframe.attr("src"));
		}).hover(function() {
			viewSourceBtn.addClass("viewsourcelink-over");
		}, function() {
			viewSourceBtn.removeClass("viewsourcelink-over");
		});
	}
	function showCodeView(src) {
		$.ligerDialog.open({
			title : '源码预览',
			url : 'dotnetdemos/codeView.aspx?src=' + src,
			width : $(window).width() * 0.9,
			height : $(window).height() * 0.9
		});

	}
	function addFrameSkinLink(tabid) {
		var prevHref = getLinkPrevHref(tabid) || "";
		var skin = getQueryString("skin");
		if (!skin)
			return;
		skin = skin.toLowerCase();
		attachLinkToFrame(tabid, prevHref + skin_links[skin]);
	}
	var skin_links = {
		"aqua" : "lib/ligerUI/skins/Aqua/css/ligerui-all.css",
		"gray" : "lib/ligerUI/skins/Gray/css/all.css",
		"silvery" : "lib/ligerUI/skins/Silvery/css/style.css",
		"gray2014" : "lib/ligerUI/skins/gray2014/css/all.css"
	};
	function pages_init() {
		var tabJson = $.cookie('liger-home-tab');
		if (tabJson) {
			var tabitems = $.parseJSON(tabJson);
			for (var i = 0; tabitems && tabitems[i]; i++) {
				f_addTab(tabitems[i].tabid, tabitems[i].text, tabitems[i].url);
			}
		}
	}
	function saveTabStatus() {
		$.cookie('liger-home-tab', tabItems);
	}
	function css_init() {
		var css = $("#mylink").get(0), skin = getQueryString("skin");
		$("#skinSelect").val(skin);
		$("#skinSelect").change(function() {
			if (this.value) {
				location.href = "index.htm?skin=" + this.value;
			} else {
				location.href = "index.htm";
			}
		});

		if (!css || !skin)
			return;
		skin = skin.toLowerCase();
		$('body').addClass("body-" + skin);
		$(css).attr("href", skin_links[skin]);
	}
	function getQueryString(name) {
		var now_url = document.location.search.slice(1), q_array = now_url
				.split('&');
		for (var i = 0; i < q_array.length; i++) {
			var v_array = q_array[i].split('=');
			if (v_array[0] == name) {
				return v_array[1];
			}
		}
		return false;
	}
	function attachLinkToFrame(iframeId, filename) {
		if (!window.frames[iframeId])
			return;
		var head = window.frames[iframeId].document
				.getElementsByTagName('head').item(0);
		var fileref = window.frames[iframeId].document.createElement("link");
		if (!fileref)
			return;
		fileref.setAttribute("rel", "stylesheet");
		fileref.setAttribute("type", "text/css");
		fileref.setAttribute("href", filename);
		head.appendChild(fileref);
	}
	function getLinkPrevHref(iframeId) {
		if (!window.frames[iframeId])
			return;
		var head = window.frames[iframeId].document
				.getElementsByTagName('head').item(0);
		var links = $("link:first", head);
		for (var i = 0; links[i]; i++) {
			var href = $(links[i]).attr("href");
			if (href && href.toLowerCase().indexOf("ligerui") > 0) {
				return href.substring(0, href.toLowerCase().indexOf("lib"));
			}
		}
	}
</script>
<style type="text/css">
body,html {
	height: 100%;
}

body {
	padding: 0px;
	margin: 0;
	overflow: hidden;
}

.l-link {
	display: block;
	height: 26px;
	line-height: 26px;
	padding-left: 10px;
	text-decoration: underline;
	color: #333;
}

.l-link2 {
	text-decoration: underline;
	color: white;
	margin-left: 2px;
	margin-right: 2px;
}

.l-layout-top {
	background: #102A49;
	color: White;
}

.l-layout-bottom {
	background: #E5EDEF;
	text-align: center;
}

#pageloading {
	position: absolute;
	left: 0px;
	top: 0px;
	background: white url('plug-in/ligerui/default/images/loading.gif')
		no-repeat center;
	width: 100%;
	height: 100%;
	z-index: 99999;
}

.l-link {
	display: block;
	line-height: 22px;
	height: 22px;
	padding-left: 16px;
	border: 1px solid white;
	margin: 4px;
}

.l-link-over {
	background: #FFEEAC;
	border: 1px solid #DB9F00;
}

.l-winbar {
	background: #2B5A76;
	height: 30px;
	position: absolute;
	left: 0px;
	bottom: 0px;
	width: 100%;
	z-index: 99999;
}

.space {
	color: #E7E7E7;
}
/* 顶部 */
.l-topmenu {
	margin: 0;
	padding: 0;
	height: 31px;
	line-height: 31px;
	background: url('plug-in/ligerui/default/images/top.jpg') repeat-x
		bottom;
	position: relative;
	border-top: 1px solid #1D438B;
}

.l-topmenu-logo {
	color: #E7E7E7;
	padding-left: 35px;
	line-height: 26px;
	background: url('plug-in/ligerui/default/images/topicon.gif') no-repeat
		10px 5px;
}

.l-topmenu-welcome {
	position: absolute;
	height: 24px;
	line-height: 24px;
	right: 30px;
	top: 2px;
	color: #070A0C;
}

.l-topmenu-welcome a {
	color: #E7E7E7;
	text-decoration: underline
}

.body-gray2014 #framecenter {
	margin-top: 3px;
}

.viewsourcelink {
	background: #B3D9F7;
	display: block;
	position: absolute;
	right: 10px;
	top: 3px;
	padding: 6px 4px;
	color: #333;
	text-decoration: underline;
}

.viewsourcelink-over {
	background: #81C0F2;
}

.l-topmenu-welcome label {
	color: white;
}

#skinSelect {
	margin-right: 6px;
}
</style>
</head>
<body style="padding: 0px; background: #EAEEF5;">
	<div id="pageloading"></div>
	<%@ include file="top.jsp" %>
	<div id="layout1" style="width: 99.2%; margin: 0 auto; margin-top: 4px;">
		<div position="left" id="accordion1"  title="<img src='plug-in/ligerui/default/images/icon/home.png' >${fns:getSysName('productName')}"> 
	      	<ul id='leftTree' class='ztree' style="overflow:auto;height: 100%" ></ul>
        </div>
		<div position="center" id="framecenter">
			<div tabid="home" title="我的主页" style="height: 300px">
				<iframe frameborder="0" name="home" src="loginController.do?login"></iframe>
			</div>
		</div>

	</div>
	<div style="height: 32px; line-height: 32px; text-align: center;">
		Copyright © 2011-2014 www.ligerui.com</div>
	<div style="display: none"></div>
</body>
</html>
