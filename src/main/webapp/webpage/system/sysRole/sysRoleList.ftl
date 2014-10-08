<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<!-- BEGIN PAGE -->

		<div class="page-content">

			<!-- BEGIN PAGE CONTAINER-->

			<div class="container-fluid">

				<!-- BEGIN PAGE HEADER-->

				<div class="row-fluid">

					<div class="span12">
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->

						<ul class="breadcrumb">
							<li style="float: left;">
								<i class="icon-home"></i>
								<a href="index.html">首页</a> 
							</li>
						</ul>

						<!-- END PAGE TITLE & BREADCRUMB-->

					</div>

				</div>

				<!-- END PAGE HEADER-->

<!-- 				<!-- BEGIN PAGE CONTENT-->

				<div class="row-fluid">
				<!--条件查询  start-->
					<div class="span12" >
						<div class="portlet box blue">
								<div class="portlet-title">
									<div class="tools">
										<a href="javascript:;" class="collapse" title="收起"></a>
									</div>
									<div class="caption"><i class="icon-reorder"></i>查询条件</div>
									<div class="actions">
										<a href="#" class="btn purple"><i class="icon-search"></i>查询</a>
										<a href="#" class="btn green"><i class="icon-plus"></i>增加</a>
										<a href="#" class="btn yellow"><i class="icon-pencil"></i>修改</a>
										<a href="#" class="btn red"><i class="icon-trash"></i>删除</a>
									</div>
								</div>
							<div class="portlet-body">
							<form id="searchForm" class="form-horizontal" method="post" action="">
								<div class="row-fluid">
									<div class="span4 ">
										<div class="control-group">
											<label class="control-label">角色名</label>
											<div class="controls">
												<input type="text" name="roleName" value="" />
											</div>
										</div>
									</div>
									<div class="span4 ">
										<div class="control-group">
											<label class="control-label">允许删除</label>
											<div class="controls">
												<select name="allowDel">
													<option value="">--全部--</option>
													<option value="1">允许</option>
													<option value="0">不允许</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								
								<div class="row-fluid">
									<div class="span4 ">
										<div class="control-group">
											<label class="control-label">允许编辑</label>
											<div class="controls">
												<select name="allowEdit">
													<option value="">--全部--</option>
													<option value="1">允许</option>
													<option value="0">不允许</option>
												</select>
											</div>
										</div>
									</div>
									<div class="span4 ">
										<div class="control-group">
											<label class="control-label">是否启用</label>
											<div class="controls">
												<select name="enabled">
													<option value="">--全部--</option>
													<option value="1">是</option>
													<option value="0">否</option>
												</select>
											</div>
										</div>
									</div>
								</div>
								
							</form>
							
							</div>
						<div>
					</div>
			    </div>	<!-- END row-fluid-->
			    
			   <div class="row-fluid">
			    <div class="span12" >
				<div class="portlet">
				<div class="portlet-body">
					<table id="contentTable" class="table table-striped table-bordered table-advance table-hover">
					<thead>
						<tr>
							<th><input type="checkbox" class="group-checkable" data-set=".checkboxes"/></th>
							<th>角色名</th>
							<th>允许删除</th>
							<th>允许编辑</th>
							<th>是否可用</th>
							<th>管理</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.list}" var="role" varStatus="r">
							<tr class="odd">
								<td style="width: 30px;"><input type="checkbox" class="checkboxes"
									name="id" id="roleId_${r.index}" data-id="${role.id}"></td>
								<td>${role.roleName}</td>
								<td>${role.allowDel}</td>
								<td>${role.allowEdit}</td>
								<td>${role.enabled}</td>
								<td><div class="btn-group">
										<a class="btn blue" href="#" data-toggle="dropdown">
										<i class="icon-cogs"></i>工具栏
										<i class="icon-angle-down"></i>
										</a>
										<ul class="dropdown-menu pull-right">
											<li>
											<t:authFunctionFilter alias="resass" css="" name="资源分配" onclick="editRoleRes('${role.id}','资源分配');"></t:authFunctionFilter></li>
											<li>
											<t:authFunctionFilter alias="userass" css="" name="人员分配" onclick="userRoleRes('${role.id}','人员分配');"></t:authFunctionFilter></li>
										</ul>
									</div></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="pagination pagination-right">${page}</div>
				</div>
				</div>
				</div>
			    </div>
			    
			    
				</div>
				
			    </div>
				</div>

				<!-- END PAGE CONTENT-->
				

			</div> <!--container-fluid -->

			<!-- END PAGE CONTAINER-->    

		</div>

		<!-- END PAGE -->
	</div>
	<!-- END CONTAINER -->
	<div id="resId" class="hidden"></div>
	<!-- BEGIN JAVASCRIPT -->
	<script type="text/javascript">
	function editRoleRes(roleid,title) {
		$('body').openWidow({
			title : title,
			iframe : true,
			height : $(window).height() - 200,
			url : "sysRoleController.do?sysRoleAss&roleId=" + roleid,
			width : $(window).width() - 800,
			buttons : [
 						{
 							text : '确定',
 							'class' :'btn blue',
 							click : function() {
 								var url = "systemController.do?sysRoleAss";
 								var params = {
 									roleId : roleid,
 									ids : $("#resId").text()
 								};
 								$.post(url, params, function(data) {
 									data = $.parseJSON(data);
 									if (data.success == true) {
 										App.alert(data.msg);
 									} else {
 										App.alert(data.msg);
 									}
 								});
 							}
 						}, {
 							text : '取消',
 							click : function() {
								App.confirmClose();
 							}
 						} ]
		});
	};
	
	
	//人员分配
 	function userRoleRes(roleid,title) {
 			    $('body').openWidow({
 				title : title,
				iframe : true,
 				height : $(window).height() - 100,
 				url : "sysRoleController.do?sysUserRoleAss&roleId="+roleid,
 				width : $(window).width() - 600,
 				buttons : [
						{
							text : '确定',
							'class':'btn blue',
 							click : function(item, dialog) {
 								var url = "systemController.do?sysUserRoleAss";
 								var params = {
 									roleId : roleid,
 									ids : $("#resId").text()
 								};
								$.post(url, params, function(data) {
 									data = $.parseJSON(data);
 									if (data.success == true) {
 									var callback = function(yes){
 										if(yes ==true){
 											App.confirmClose();
 										}else{
 											
 										}
 									};
 										App.confirm('人员分配成功,是否继续?',callback);
 									} else {
										App.alert('人员分配出错!');
 									}
 								});
 							}
 						}, {
 							text : '取消',
 							'class':'btn',
							click : function() {
								App.confirmClose();
 							}
 						} ]
 			});
 		}
	
	
	App.datatable('sysRoleController.do?sysRole');
	</script>
	<!-- END JAVASCRIPT -->