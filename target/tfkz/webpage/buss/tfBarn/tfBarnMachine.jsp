<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
<div class="wrapper2">
<form id="exportFrom" method="post"></form>
<div class="main" style="background:none;">
   <div class="main_top">
     <ul>
       <li><a href="tfBarnController.do?tfLiaqin&id=${tfBarn.id}" id="l_1"  onfocus="this.blur();" >粮情检查记录</a></li>
       <li><a href="tfBarnController.do?tfMachine&id=${tfBarn.id}" id="l_2"  onfocus="this.blur();"  class="current">机械通风记录</a></li>
       <li><a href="tfBarnController.do?tfChart&id=${tfBarn.id}" id="l_3"  onfocus="this.blur();">三温图</a></li>
     </ul>
     <div class="main_rg">
       <a href="javascript:;" class="v_s" title="保存"></a>
       <a href="javascript:;" class="dc" title="导出"></a>
     </div> 
   </div>
   <div class="main_center" id="d1" style="display:block;">
   <div class="m_left">
   <iframe id="searchFrame" name="searchFrame" data-url="tfMachineController.do?tfMachine&tfBarnId=${tfBarn.id}" src="tfMachineController.do?tfMachine&tfBarnId=${tfBarn.id}" frameborder="0" scrolling="no" height="580px" width="160px"></iframe>
   </div><!--m_left e-->
   <div class="m_right">
   <iframe id="detailFrame" name="detailFrame" data-url="tfMachineController.do?tfMachineAddOrUpdate&tfBarnId=${tfBarn.id}" src="tfMachineController.do?tfMachineAddOrUpdate&tfBarnId=${tfBarn.id}" frameborder="0" scrolling="no" height="570px" width="740px"></iframe>
   </div><!--m_right e-->
   </div><!--main_center e-->
</div><!--main e-->
<script type="text/javascript">
	$(function(){
		/*var selectM = $.cookie("selectM");
		var obj= $("#" +selectM);
		var url = obj.data('url');
		if(selectM && obj.length>0){
			$(".main_top ul li a").removeClass("current");
			obj.addClass("current");
		}
		
		$(".main_top").delegate("ul li a", "click", function(){
	         var id=$(this).attr("id");
	         var url = $(this).data("url");
	         $(".main_top ul li a").removeClass("current");
	         $(this).addClass("current");
	         $.cookie("selectM",id);
	         if(url!="" && url!=undefined){
				$("#recordFrame").attr("src",url);
			 }
	     });*/
		 
		 $('body').on('click','a.v_s',function(){
			 $("#inputFrom",window.frames["detailFrame"].document).find("#submit-btn").click();
			// window.frames["detailFrame"].document.forms["inputFrom"].action="";
			// window.frames["detailFrame"].document.forms["inputFrom"].submit();
			 
		 })
		 .on('click','a.dc',function(){
			var api = frameElement.api, W = api.opener;
			var id = $("#inputFrom",window.frames["detailFrame"].document).find("input[name='id']").val();
			if(id != undefined){
				$('#exportFrom').attr('action','tfMachineController.do?export&id='+id);
				$('#exportFrom').submit();
			}else{
				W.$.dialog({
        			id:'alert',
    				title:'提示',
    				time:3,
    				icon:'error.gif',
    				content:'亲,请先添加信息！',
    				max:false,
    		        min:false,
    		        resize:false
    			});
			}
			 
		 })
		 
		 
	});

</script>
</body>