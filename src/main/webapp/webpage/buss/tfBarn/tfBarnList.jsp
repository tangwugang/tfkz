<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
 
<div class="container">
 <!-----------仓储管理 s--------------------->
  <div id="div2" >
    <div class="c_center">
    	<c:forEach items="${tfBarn}" var="b">
    		<div class="c_box">
	        <div class="c_T"><b>${b.barnNo}</b>
	        </div><!--c_T e-->
	        <div class="c_time">${fns:date2Str(b.qiDoTime,'yyyy年MM月')}&nbsp;启用
	        </div><!--c_time e-->
	        <c:forEach items="${tfBarnShiwus}" var="sw">
	        	<c:choose>
	        	<c:when test="${b.id == sw.tfBarnId }">
	        		<div class="Variety">${sw.liaShiPinZh}
	        		</div><!--Variety e-->
	        	</c:when>
	        	<c:otherwise>
	        		<div class="Variety">空
	        		</div><!--Variety e-->
	        	</c:otherwise>
	        	</c:choose>
	    	</c:forEach>
	    	<c:if test="${tfBarnShiwus == null }">
	    		<div class="Variety">空
	        	</div><!--Variety e-->
	    	</c:if>
	        <div class="c_bottom" style="display:none;">
	          <p></p>
	          <span>
	           <a href="javascript:;" class="cinfo" title="仓房情况" data-id="${b.id}"></a>
	           <a href="javascript:;" class="kc" title="库存记录" data-id="${b.id}"></a>
	           <a href="javascript:;" class="lq" title="粮情记录" data-id="${b.id}"></a>
	           <a href="javascript:;" class="cdel" title="删除" data-id="${b.id}"></a>
	         </span>
	        </div><!--c_bottom e-->
	      </div><!--c_box e-->
    	</c:forEach>
	      
	   <!--增加仓房 s-->
	      <div class="c_box">
	        <a class="c_add" href="javascript:;">
	          <img src="plug-in/barn/images/add_icon2.png"/>
	          <p>增加仓房</p>
	        </a>
	      </div><!--c_box e-->
	   <!--增加仓房 e-->
    </div><!--c_center e-->
 </div><!--div2 e-->
 <!-----------仓储管理 e--------------------->
</div><!--container e-->

 <script type="text/javascript">
 $(".c_box").mouseover(function(){
		$(this).children(".c_bottom").css("display","block");
	 });
$(".c_box").mouseout(function(){
		$(this).children(".c_bottom").css("display","none");
	 });
 $("body").on('click','a.c_add',function(){
		title = $(this).text();
		$.dialog({
				id:'addBarn',
		        title: title,
		        height : 665,
		        width : 900,
		        max:false,
		        min:false,
		        resize:false,
		        content:'url:tfBarnController.do?tfBarnAddOrUpdate'
	    });
		
	})
	.on('click','a.cinfo',function(){
		title = $(this).attr('title');
		barnId = $(this).data('id');
		$.dialog({
			id:'infoBarn',
	        title: title,
	        height : 665,
	        width : 900,
	        max:false,
	        min:false,
	        resize:false,
	        content:'url:tfBarnController.do?tfBarnAddOrUpdate&id='+barnId
    	});
	})
	.on('click','a.kc',function(){
		title = $(this).attr('title');
		var barnId = $(this).data("id");
		$.dialog({
			id:'infoShiwu',
	        title: title,
	        height : 665,
	        width : 900,
	        max:false,
	        min:false,
	        resize:false,
	        content:'url:tfBarnShiwuController.do?tfBarnShiwuAddOrUpdate&tfBarnId='+barnId
    	});
	})
	.on('click','a.lq',function(){
		title = $(this).attr('title');
		var barnId = $(this).data("id");
		$.dialog({
			id:'addLq',
	        title: title,
	        height : 665,
	        width : 900,
	        max:false,
	        min:false,
	        resize:false,
	        content:'url:tfBarnController.do?tfLiaqin&id='+barnId
    	});
	})
	.on('click','a.cdel',function(){
		var barnId = $(this).data("id");
		$.dialog.confirm('你确定要删除吗？', function(){
			$.post('tfBarnController.do?del&id='+barnId,function(result){
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
 
 </script>
</body>