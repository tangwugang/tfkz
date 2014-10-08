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
					<div class="span5" >
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="tools">
									<a href="javascript:;" class="collapse" title="收起"></a>
									<a href="javascript:;" class="reload" title="刷新"></a>
								</div>
							</div>
							<div class="portlet-body" style="height:465px;">
							<div id="resourcesTree" class="ztree" 
							style="overflow: auto; clear: left"></div>
							</div>
						<div>
					</div>
			    </div>
				</div>
				<div class="span7">
						<div class="portlet box green">
							<div class="portlet-body" style="height:500px;">
								<iframe id="listFrame"  frameborder="no" width="100%"
								height="100%"></iframe>
							</div>
						<div>
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
	<div id="rMenu">
            <li>
                <ul id="r_addNode"><li><i class="icon-plus-sign"></i>&nbsp;增加节点</li></ul>
                <ul id="r_updateNode"><li><i class="icon-edit"></i>&nbsp;修改节点</li></ul>
                <ul id="r_deleteNode"><li><i class="icon-remove-sign"></i>&nbsp;删除节点</li></ul>
            </li>
        </ul>
    </div>
	<!-- BEGIN JAVASCRIPT -->
	<script type="text/javascript">
	contextMenu.loadTree();
	</script>
	<!-- END JAVASCRIPT -->