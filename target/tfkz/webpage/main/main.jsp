<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<script>
$(function(){
	 $(".rg_menu").delegate("a", "click", function(){
         var id=$(this).attr("id");
         var url = $(this).attr("url");
         $(".rg_menu a").removeClass("current");
         $(this).addClass("current");
         $.cookie("selectTab",id);
         if(url!="" && url!=undefined){
        	 $("#mainFrame").attr("src",url);
         }
     });
	setInterval(getTime, 1000);
	loadMenu();
});
function getTime(){
	var mon, day, now, hour, min, sec;  
    mon = new Array("一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月",  
            "九月", "十月", "十一月", "十二月");  
    day = new Array("周日", "周一", "周二", "周三", "周四", "周五", "周六");  
    now = new Date();  
    hour = now.getHours();  
    min = now.getMinutes();  
    sec = now.getSeconds();  
    if (hour < 10) {  
        hour = "0" + hour;  
    }  
    if (min < 10) {  
        min = "0" + min;  
    }  
    if (sec < 10) {  
        sec = "0" + sec;  
    }  
    $(".f_time").html(  
            "<nobr>" + day[now.getDay()] + ", " + mon[now.getMonth()] + " "  
                    + now.getDate() + ", " + now.getFullYear() + " " + hour  
                    + ":" + min + ":" + sec + "</nobr>"); 
}
var aryTreeData=null;
//返回根节点
function getRootNodes(){
	var nodes=new Array();
	for(var i=0;i<aryTreeData.length;i++){
		var node=aryTreeData[i];
		if(node.parentId=="0"){
			nodes.push(node);
		}
	}
	return nodes;
};
//加载菜单
function loadMenu(){
	$(".rg_menu").empty();
	//一次性加载
	$.post("loginController.do?leftTree",
		 function(result){
			aryTreeData=$.parseJSON(result);
			//获取根节点，加载顶部按钮菜单。
			var headers=getRootNodes();
			var len=headers.length;
			var menuContainer=$(".rg_menu");
			menuContainer.append("<ul>");
			for(var i=0;i<len;i++){
    			var head=headers[i];
    			var menuItemHtml=getMenuItem(head);
    			$(menuItemHtml).appendTo(".rg_menu ul");
    		}
			
			if(len>0){
				var selectTab=$.cookie("selectTab");
				var obj= $("#" +selectTab);
				var url = obj.attr("url");
				if(selectTab && obj.length>0){
					$("#" +selectTab).addClass("current");
					if(url!="" && url!=undefined){
			        	 $("#mainFrame").attr("src",url);
			         }
				}
				else{
					var head=headers[0];
					var resId=head.id;
					$("#" +resId).addClass("current");
					url = $("#" +resId).attr("url");
					if(url!="" && url!=undefined){
			        	 $("#mainFrame").attr("src",url);
			         }
				}
			}
		});
}

//加载菜单项
function getMenuItem(node){
	var str='<li ';
	if(node.funcClass!=""){
		str+='class="'+node.funcClass+'"';
	}
	str+='><a href="#" id="'+node.id+'" url="'+node.funcUrl+'" >'+node.funcName+'</a></li>';
	return str;
}
</script>
</head>
<body>
	<div class="wrapper">
	<!-----------顶部 s--------------------->
	<div class="top_Bar">
	  <div class="left_logo"></div><!--left_logo e-->
	  <div class="rg_menu">
	  </div><!--rg_menu e-->
	</div><!--top_Bar e-->
	<!-----------顶部 e--------------------->
	<div class="container">
	<iframe id="mainFrame" name="mainFrame" frameborder="0" scrolling="no" height="100%" width="100%"></iframe>
	</div><!--container e-->
	<!-----------底部 s--------------------->
	<div class="footer">
	 <div class="f_time"></div><!--f_time e-->
	 <div class="welcome">
	    <span>欢迎登录！</span><span>超级管理员</span>&nbsp;&nbsp;<span class="blue">张三三</span>
	    <div class="list">
	        <ul style="display:none;">
	          <li><a href="">账户基本信息</a></li>
	          <li><a href="">修改密码</a></li>
	          <li><a href="">退出</a></li>
	        </ul>
	     </div>
	 </div><!--welcome e-->
	 <div class="clr"></div>
	</div><!--footer e-->
	<!-----------底部 e--------------------->

	</div>

</body>
</html>
