<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
<!-- <div class="wrapper2"> -->
<!-- <div class="main" style="background:none;"> -->
<div class="m_left">
<div id="msg_holder"></div>
   <form id="searchForm" method="post">
   	<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
   </form>
   <form id="inputForm" >
   <div class="top_search">
      <label>时间</label><input type="text" class="in" style="width:100px;" name="startDate" value="${startDate}" data-inputmask="'alias': 'yyyy.mm.dd'"  data-rule="开始日期: required;date" data-rule-date="[/^\d{4}(\.)\d{2}(\.)\d{2}$/,'开始日期不对']"/><div class="clr"></div>
      <label>至</label><input type="text" class="in" style="width:100px;" name="endDate" value="${endDate}" data-inputmask="'alias': 'yyyy.mm.dd'" data-rule="结束日期: required;date;match[gt, startDate, date]" data-rule-date="[/^\d{4}(\.)\d{2}(\.)\d{2}$/,'结束日期不对']"/>
      <a href="javascript:;" class="search-btn">查询</a>
   </div>
   </form>
     <div class="pannel">
       <ul>
       <c:forEach items="${page.list}" var="p">
       	<li><a href="javascript:;" data-id="${p.id}"><fmt:formatDate value="${p.createDate}" pattern="yyyy年MM月dd日"/></a></li>
       </c:forEach>
       </ul>
     <div class="m_page">
     	${page}
     </div>
     </div><!--pannel e-->
</div>
<!-- </div> -->
<!-- </div> -->
<script type="text/javascript">
	$(function(){
		$('body').on('click','ul li a',function(e){
			e.preventDefault();
			$('ul li a').removeClass("key");
			$(this).addClass("key");
			var url = parent.$("#detailFrame").data('url');
			parent.$("#detailFrame").attr("src",url+"&id="+$(this).data("id"));
		});
		$(":input").inputmask();
		$('#inputForm').validator({
		    stopOnError: false, //关闭此开关，以便一次性显示所有消息
		    msgMaker: false,    //不要自动生成消息
			//验证成功
		    valid: function(form) {
		    	var params = $(form).serialize();
		    	var url = parent.$("#searchFrame").data('url');
		    	$("#searchForm").attr("action",url+"&"+params)
		    	$("#searchForm").submit();
		    },
	 		invalid: function(form, errors){
		        var html = '';
		        $.map(errors, function(msg){
		            html += '<p class="red">'+ msg +'</p>'
		        });
		        $('#msg_holder').html(html);
	    	}
		})
		// 使用链接代替submit按钮（注意：这种情况下输入框里面的回车键不能触发submit事件）
		.on("click", "a.search-btn", function(e){
		    $(e.delegateTarget).trigger("validate");
		});
	});

</script>
</body>