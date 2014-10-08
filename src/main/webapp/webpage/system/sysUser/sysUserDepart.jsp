<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@include file="/context/mytags.jsp"%>
<head>
<title>${fns:getSysName('productName')}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<t:base type="jquery,cookie,ligerui"></t:base>
<script type="text/javascript" src="plug-in/ligerui/other/css/jquery/plugins/jweb.select.js"></script>
<script type="text/javascript">
$(function(){
	var resId="";
	//全选
	$('table th input:checkbox').on('click' , function(){
		var that = this;
		$(this).closest('table').find('tr > td:first-child input:checkbox')
		.each(function(){
			this.checked = that.checked;
			if(this.checked == true){
				resId+=$(this).val()+",";
			}else{
				parent.parent.$("#resId").text("");
			}
			$(this).closest('tr').toggleClass('selected');
		});
		if(resId !=""){
			resId = resId.substring(0, $.trim(resId).length-1);
			parent.parent.$("#resId").text(resId);
			resId="";
		}
		
			
	});
	//单选
	$('table tr input:checkbox').on('click',function(){
		parent.parent.$("#resId").text(resId);
		$('input[type="checkbox"][name="id"]:checked').each(function () {
			resId+=$(this).val()+",";
		});
		if(resId !=""){
			resId = resId.substring(0, $.trim(resId).length-1);
			parent.parent.$("#resId").text(resId);
			resId="";
		}
	});
});
</script>
</head>
<body>
	<div class="panel-body">
		<div class="hide-panel">
			<div class="hide-panel">
				<div class="panel-top">
					<div class="panel-search">
						<div class="title">查询条件</div>
						<div class="drop">
							<a class="activi">收起</a>
						</div>
						<form id="searchForm" method="post" action=""
							style="display: block;">
							<ul class="row">
								<li><span class="label">用户名:</span><input type="text"
									name="userName" class="inputText"
									value="" /></li>
								<li>
							</ul>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="panel-body">
			<div class="panel-table">
				<table id="sysDepartUserItem" cellpadding="1"
					class="table-grid table-list" cellspacing="1">
					<thead>
						<tr>
							<th><input type="checkbox" id="chkall" /></th>
							<th>姓名</th>
							<th>组织机构名</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sysUsers}" var="user">
							<tr class="odd">
								<td style="width: 30px;"><input type="checkbox" class="pk"
									name="id" id="userId" value="${user.id}"></td>
								<td>${user.userName}</td>
								<td>${fns:getDepartNameByUser(user.id)}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>