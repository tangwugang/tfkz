<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
 
<div class="container">
 <!-----------通风控制 s--------------------->
   <div class="c1">
   <c:forEach items="${tfGuize}" var="gz">
   	<div class="Box">
      <div class="B_title">
       <a href="javascript:;" title="${gz.tfGuiZeName}">${gz.tfGuiZeName}</a>
      </div><!--B_title e-->
      <div class="B_control" data-id="${gz.id}" data-time="${gz.tfWenShiDuTime}">
      	<c:if test="${gz.status != null && gz.status != 'N'}">
	      	<div class="start"></div>
      	</c:if>
        <c:if test="${gz.status == null|| gz.status == 'N'}">
        <div class="stop"></div>
        </c:if>
      </div><!--B_control e-->
      <div class="B_time">
        <span>创建时间：<fmt:formatDate value="${gz.createDate}" pattern="yyyy年MM月dd日 HH:mm:ss"/></span><br/>
        <span>更新时间：<fmt:formatDate value="${gz.updateDate}" pattern="yyyy年MM月dd日 HH:mm:ss"/></span>
      </div><!--B_time e-->
      <div class="B_btns">
        <a href="javascript:;" class="modify" title="修改通风类型" data-id="${gz.id}"></a>
        <a href="javascript:;" class="house" title="粮仓通风设置" data-id="${gz.id}"></a>
        <a href="javascript:;" class="del" title="删除" data-id="${gz.id}"></a>
      </div><!--B_btns e-->
    </div><!--Box e-->
   </c:forEach>
 <!--创建类型 s-->
    <div class="Box">
     <a class="B_add" href="javascript:;">
       <img src="plug-in/barn/images/add_icon1.png"/>
       <p>创建通风类型</p>
     </a>
    </div><!--Box e-->
 <!--创建类型 e-->
    <div class="clr"></div>
   </div><!--c1 e-->
 <!-----------通风控制 e--------------------->
</div><!--container e-->

 <script type="text/javascript">

 $("body").on('click','a.B_add',function(){
		title = $(this).text();
		$.dialog({
				id:'addGuize',
		        title: title,
		        height : 665,
		        width : 900,
		        max:false,
		        min:false,
		        resize:false,
		        content:'url:tfGuizeController.do?tfGuizeAddOrUpdate'
	    });
		
	})
	.on('click','div.B_control',function(){
		var status = "N";
		var th = $(this);
		if($($(this).children()).attr('class') == 'stop'){status = "Y"}
		id = $(this).data('id');
		time = $(this).data('time');
		$.ajax({
			url:"tfGuizeController.do?save",
			type:"POST",
			data:"id="+id+"&status="+status+"&tfWenShiDuTime="+time,
			success: function(result){
				var result = $.parseJSON(result);
				if(result.success == true){
					if($(th.children()).attr('class') == 'stop'){
						$(th.children()).removeClass();
	 					$(th.children()).addClass("start");
					}else{
						$(th.children()).removeClass();
	 					$(th.children()).addClass("stop");
					}
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
			}
		});
	})
	.on('click','a.modify',function(){
		title = $(this).attr('title');
		var id = $(this).data("id");
		$.dialog({
			id:'modiGuize',
	        title: title,
	        height : 665,
	        width : 900,
	        max:false,
	        min:false,
	        resize:false,
	        content:'url:tfGuizeController.do?tfGuizeAddOrUpdate&id='+id
    	});
	})
	.on('click','a.house',function(){
		title = $(this).attr('title');
		var id = $(this).data("id");
		$.dialog({
			id:'guize',
	        title: title,
	        height : 665,
	        width : 900,
	        max:false,
	        min:false,
	        resize:false,
	        content:'url:tfGuizeController.do?tfGzConfig&id='+id
    	});
	})
	.on('click','a.del',function(){
		var id = $(this).data("id");
		$.dialog.confirm('你确定要删除吗？', function(){
			$.post('tfGuizeController.do?del&id='+id,function(result){
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