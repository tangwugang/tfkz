<%@include file="../../common/head.jsp"%>
<style type="text/css">
		html { overflow-x: hidden; overflow-y: auto; }
		#imgpst{
			overflow: auto;
		}
		#imgpst img {
			cursor: pointer;
			border-width: 1px; 
			border-style: sopd;
			border-color: transparent; 
			padding: 1px;
		}
		
		#imgpst .selected {
			border-color:  #86a9d1; 
			background-color:#c3dcfc; 
		}
</style>
<div class="row-fluid">
<div class="portlet box" style="height:500px;">
<div class="portlet-body" style="height:1030px;">
									
								
								<div class="tab-pane halfings-demo active">
												<p><i class="icon-adjust"></i> icon-adjust</p>
												<p><i class="icon-asterisk"></i> icon-asterisk</p>
												<p><i class="icon-ban-circle"></i> icon-ban-circle</p>
												<p><i class="icon-bar-chart"></i> icon-bar-chart</p>
												<p><i class="icon-barcode"></i> icon-barcode</p>
												<p><i class="icon-beaker"></i> icon-beaker</p>
												<p><i class="icon-bell"></i> icon-bell</p>
												<p><i class="icon-bolt"></i> icon-bolt</p>
												<p><i class="icon-book"></i> icon-book</p>
												<p><i class="icon-bookmark"></i> icon-bookmark</p>
												<p><i class="icon-bookmark-empty"></i> icon-bookmark-empty</p>
												<p><i class="icon-briefcase"></i> icon-briefcase</p>
												<p><i class="icon-bullhorn"></i> icon-bullhorn</p>
												<p><i class="icon-calendar"></i> icon-calendar</p>
												<p><i class="icon-camera"></i> icon-camera</p>
												<p><i class="icon-camera-retro"></i> icon-camera-retro</p>
												<p><i class="icon-certificate"></i> icon-certificate</p>
												<p><i class="icon-check"></i> icon-check</p>
												<p><i class="icon-check-empty"></i> icon-check-empty</p>
												<p><i class="icon-cloud"></i> icon-cloud</p>
												<p><i class="icon-cog"></i> icon-cog</p>
												<p><i class="icon-cogs"></i> icon-cogs</p>
												<p><i class="icon-comment"></i> icon-comment</p>
												<p><i class="icon-comment-alt"></i> icon-comment-alt</p>
												<p><i class="icon-comments"></i> icon-comments</p>
												<p><i class="icon-comments-alt"></i> icon-comments-alt</p>
												<p><i class="icon-credit-card"></i> icon-credit-card</p>
												<p><i class="icon-dashboard"></i> icon-dashboard</p>
												<p><i class="icon-download"></i> icon-download</p>
												<p><i class="icon-download-alt"></i> icon-download-alt</p>
												<p><i class="icon-edit"></i> icon-edit</p>
												<p><i class="icon-envelope"></i> icon-envelope</p>
												<p><i class="icon-envelope-alt"></i> icon-envelope-alt</p>
											</ul>
									
									
								</div>

</div>
</div>

</div>
	
<script type="text/javascript">
		var selectedImg=null;
		$(function(){
			$("#imgpst img").cpck(function(){
				if(selectedImg){
					$(selectedImg).removeClass('selected');
				}
				$(this).addClass('selected');
				selectedImg=this;
				parent.$("#icon").val($(this).attr("src"));
				parent.$("#iconImg").attr("src",$(this).attr("src"));
				parent.$.pgerDialog.hide();
			});
		});
		
</script>
