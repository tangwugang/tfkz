<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
</head>
<body>
	<div class="container">
 <!-----------操作日志 s---------------------> 
  <div id="div5">
  <form id="searchForm" method="post">
  	<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <div class="J_top">
      <div class="J_time"><label>操作时间</label><input type="text" name="startDate" class="in" value="${startDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/><label>至</label><input type="text" name="endDate" class="in" value="${endDate}" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'});"/></div>
      <t:dictSelect field="type" defaultVal="${sysLog.type}" divClass="J_type" title="操作类型" selectClass="in" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="oper_type"></t:dictSelect>
      <div class="J_staff">
        <label>操作人员</label><input type="text" name="createName" class="in" value="${sysLog.createName}"/>
      </div>
      <div class="J_btn"><a href="javascript:;" class="search_btn"></a></div>
    </div><!--J_top e-->
   </form>
    <div class="J_center">
      <table cellpadding="0" cellspacing="0">
      <tr class="topic">
        <td height="35" width="180">操作时间</td>
        <td width="130">操作类型</td>
        <td width="130">操作角色</td>
        <td width="130">操作人员</td>
        <td width="396">操作内容</td>
      </tr>
      <c:forEach items="${page.list}" var="log">
      	<tr>
	        <td height="28"><fmt:formatDate value="${log.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	        <td>${fns:getTypeName(log.type,'oper_type')}</td>
	        <td>${fns:getRoleName(log.createBy)}</td>
	        <td>${log.createName}</td>
	        <td class="f1">${log.content}</td>
	      </tr>
      </c:forEach>
	      
      </table>
    </div><!--J_center e-->
    <div class="J_page">
    	${page}
    </div><!--J_page e-->
  </div><!--div5 e-->
 <!-----------操作日志 e---------------------> 
</div><!--container e-->
<script>
$('body').on('click','a.search_btn',function(e){
	$('form').submit();
});
</script>
</body>
</html>