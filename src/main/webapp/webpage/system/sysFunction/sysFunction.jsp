<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@include file="../../common/head.jsp"%>
<script type="text/javascript">
		
	$(function() {
		App.init();
		//自定义回调函数
		var callback = function(data){
			parent.contextMenu.loadTree();
			if(data.obj.operate == "add"){
				var callback = function (yes) {
					App.confirmClose();
					if(yes == true){
						$(".dataForm")[0].reset();
					}else{
						location.href= "sysFunctionController.do?addorupdate&operate=edit&id="+data.obj.id;
					}
				};
				parent.App.confirm(data.msg,callback);
			}else{
				parent.App.alert(data.msg);
			}
		};
		$("#dataFormSave").click(function(){
			App.validform(callback);
		});
		
		//选择图标	
		$("#addIcon").click(function(e){
			e.preventDefault();
			parent.$("body").openWidow({
				title:"图标",
				width: $(window).width()+200,
				height: $(window).height(),
				text:$("#myicon").html(),
				buttons:[{
					text:'确定',
					'class':'btn blue',
					click:function(){
						$("#addIcon i").removeClass();
	    				$("#addIcon i").addClass("icon-"+$(this).find("input").val());//图标面板中的隐藏字段
	    				$("input[name='icon']").val($(this).find("input").val());
	    				App.confirmClose();
						}
				}]
			});
		});
		
	});
	
</script>
<div class="row-fluid">
<div class="portlet box" style="height:500px;">
<div class="portlet-body" style="height:1030px;">
<form class="form-horizontal dataForm"  name="dataForm" method="post" action="sysFunctionController.do?save">
		<input type="hidden" name="id" value="${sysFunction.id}" />
		<input type="hidden" name="operate" value="${sysFunction.operate}" />
		<!-- 表单开始 -->
		<div class="control-group success">
		<div class="controls">
		<button id="dataFormSave" type="submit" class="btn blue"><i class="icon-plus"></i>&nbsp;保存</button>
		</div>
		</div>
		<hr>
		<div class="control-group success">
		<label class="control-label">资源名称<span class="required">*</span></label>
		<div class="controls">
		<input type="text" placeholder="资源名称" id="funcName" name="funcName" value="${sysFunction.funcName}" datatype="s2-15" nullmsg="请填写信息！" sucmsg="验证通过！" class="m-wrap medium "/>
		</div>
		</div>
		<div class="control-group success">
		<label class="control-label">资源别名<span class="required">*</span></label>
		<div class="controls">
		<input type="text" placeholder="资源别名"  id="funcAlias" name="funcAlias" value="${sysFunction.funcAlias}" <c:if test="${sysFunction.funcAlias!=null}">disabled="disabled"</c:if><c:if test="${sysFunction.funcAlias==null}"> datatype="s2-15" ajaxurl="systemController.do?checkFunction" nullmsg="请输入资源别名！" </c:if>  class="m-wrap medium "/>
		</div>
		</div>
		
		<div class="control-group success">
		<label class="control-label">默认地址</label>
		<div class="controls">
		<input type="text" placeholder="默认地址"  id="funcUrl" name="funcUrl"  value="${sysFunction.funcUrl}"  class="m-wrap medium "/>
		</div>
		</div>
		<div class="control-group success">
		<label class="control-label">资源图标</label>
		<div class="controls">
		
		<input type="hidden" id="icon" name="icon" value="${sysFunction.icon}"  class="m-wrap medium "/>
<%-- 		<img id="iconImg" alt="" src="${sysFunction.icon}" <c:if test="${sysFunction.icon==null}">style="display:none;"</c:if>> --%>
<!-- 		<a class="btn" href="javascript:selectIcon();">选择</a> -->
		<a id="addIcon" class="btn green" title="点我"><i class="icon-${sysFunction.icon}"></i></a>
		</div>
		</div>
		
		<div class="control-group success">
		<label class="control-label">是否有子节点</label>
		<div class="controls">
			<select id="isFolder" name="isFolder" class="medium m-wrap">
			<option value="0" <c:if test="${sysFunction.isFolder==0}">selected="selected"</c:if>>否</option>
			<option value="1" <c:if test="${sysFunction.isFolder==1}">selected="selected"</c:if>>是</option>
			</select>
		</div>
		</div>
		<div class="control-group success">
		<label class="control-label">是否显示到菜单</label>
		<div class="controls">
			<select id="isDisplayInMenu" name="isShow" class="medium m-wrap">
			<option value="0" <c:if test="${sysFunction.isShow==0}">selected="selected"</c:if>>否</option>
			<option value="1" <c:if test="${sysFunction.isShow==1}">selected="selected"</c:if>>是</option>
			</select>
		</div>
		</div>
		<div class="control-group success">
		<label class="control-label">是否打开</label>
		<div class="controls">
			<select id="isOpen" name="isOpen" class="medium m-wrap">
			<option value="0" <c:if test="${sysFunction.isOpen==0}">selected="selected"</c:if>>否</option>
			<option value="1" <c:if test="${sysFunction.isOpen==1}">selected="selected"</c:if>>是</option>
			</select>
		</div>
		</div>
		
		<div class="control-group success">
		<label class="control-label">同级排序</label>
		<div class="controls">
		<input type="text" placeholder="同级排序"  id="funcOrder" name="funcOrder" value="${sysFunction.funcOrder}"  class="m-wrap medium "/>
		</div>
		</div>
		
		<div class="control-group success hide">
		<label class="control-label">父ID</label>
		<div class="controls">
		<input type="text" placeholder="父ID"  id="parentId" name="parentId" value="${sysFunction.parentId}"  class="m-wrap medium "/>
		</div>
		</div>
</form>

</div>
</div>
</div>
</div>
<!-- 图标选择  -->
<div id="myicon" class="hide" title="图标">
<style type="text/css">
	.the-icons li {float:left;width:22%;line-height:25px;margin:2px 5px;cursor:pointer;}
	.the-icons i {margin:1px 5px;} .the-icons li:hover {background-color:#efefef;}
    .the-icons li.active {background-color:#0088CC;color:#ffffff;}
</style>
<script type="text/javascript">
	    	$("#icons li").click(function(){
	    		$("#icons li").removeClass("active");
	    		$("#icons li i").removeClass("icon-white");
	    		$(this).addClass("active");
	    		$(this).children("i").addClass("icon-white");
	    		$("#icon").val($(this).text());
	    	});
	    	$("#icons li").each(function(){
	    		if ($(this).text()=="${sysFunction.icon}"){
	    			$(this).click();
	    		}
	    	});
	    	$("#icons li").dblclick(function(){
	    	});
    </script>
    <input type="hidden" id="icon" value="" />
	<ul class="the-icons" id="icons">
    <li><i class="icon-glass"></i>glass</li>
    <li><i class="icon-music"></i>music</li>
    <li><i class="icon-search"></i>search</li>
    <li><i class="icon-envelope"></i>envelope</li>
    <li><i class="icon-heart"></i>heart</li>
    <li><i class="icon-star"></i>star</li>
    <li><i class="icon-star-empty"></i>star-empty</li>
    <li><i class="icon-user"></i>user</li>
    <li><i class="icon-film"></i>film</li>
    <li><i class="icon-th-large"></i>th-large</li>
    <li><i class="icon-th"></i>th</li>
    <li><i class="icon-th-list"></i>th-list</li>
    <li><i class="icon-ok"></i>ok</li>
    <li><i class="icon-remove"></i>remove</li>
    <li><i class="icon-zoom-in"></i>zoom-in</li>
    <li><i class="icon-zoom-out"></i>zoom-out</li>
    <li><i class="icon-off"></i>off</li>
    <li><i class="icon-signal"></i>signal</li>
    <li><i class="icon-cog"></i>cog</li>
    <li><i class="icon-trash"></i>trash</li>
    <li><i class="icon-home"></i>home</li>
    <li><i class="icon-file"></i>file</li>
    <li><i class="icon-time"></i>time</li>
    <li><i class="icon-road"></i>road</li>
    <li><i class="icon-download-alt"></i>download-alt</li>
    <li><i class="icon-download"></i>download</li>
    <li><i class="icon-upload"></i>upload</li>
    <li><i class="icon-inbox"></i>inbox</li>
    <li><i class="icon-play-circle"></i>play-circle</li>
    <li><i class="icon-repeat"></i>repeat</li>
    <li><i class="icon-refresh"></i>refresh</li>
    <li><i class="icon-list-alt"></i>list-alt</li>
    <li><i class="icon-lock"></i>lock</li>
    <li><i class="icon-flag"></i>flag</li>
    <li><i class="icon-headphones"></i>headphones</li>
    <li><i class="icon-volume-off"></i>volume-off</li>
    <li><i class="icon-volume-down"></i>volume-down</li>
    <li><i class="icon-volume-up"></i>volume-up</li>
    <li><i class="icon-qrcode"></i>qrcode</li>
    <li><i class="icon-barcode"></i>barcode</li>
    <li><i class="icon-tag"></i>tag</li>
    <li><i class="icon-tags"></i>tags</li>
    <li><i class="icon-book"></i>book</li>
    <li><i class="icon-bookmark"></i>bookmark</li>
    <li><i class="icon-print"></i>print</li>
    <li><i class="icon-camera"></i>camera</li>
    <li><i class="icon-font"></i>font</li>
    <li><i class="icon-bold"></i>bold</li>
    <li><i class="icon-italic"></i>italic</li>
    <li><i class="icon-text-height"></i>text-height</li>
    <li><i class="icon-text-width"></i>text-width</li>
    <li><i class="icon-align-left"></i>align-left</li>
    <li><i class="icon-align-center"></i>align-center</li>
    <li><i class="icon-align-right"></i>align-right</li>
    <li><i class="icon-align-justify"></i>align-justify</li>
    <li><i class="icon-list"></i>list</li>
    <li><i class="icon-indent-left"></i>indent-left</li>
    <li><i class="icon-indent-right"></i>indent-right</li>
    <li><i class="icon-facetime-video"></i>facetime-video</li>
    <li><i class="icon-picture"></i>picture</li>
    <li><i class="icon-pencil"></i>pencil</li>
    <li><i class="icon-map-marker"></i>map-marker</li>
    <li><i class="icon-adjust"></i>adjust</li>
    <li><i class="icon-tint"></i>tint</li>
    <li><i class="icon-edit"></i>edit</li>
    <li><i class="icon-share"></i>share</li>
    <li><i class="icon-check"></i>check</li>
    <li><i class="icon-move"></i>move</li>
    <li><i class="icon-step-backward"></i>step-backward</li>
    <li><i class="icon-fast-backward"></i>fast-backward</li>
    <li><i class="icon-backward"></i>backward</li>
    <li><i class="icon-play"></i>play</li>
    <li><i class="icon-pause"></i>pause</li>
    <li><i class="icon-stop"></i>stop</li>
    <li><i class="icon-forward"></i>forward</li>
    <li><i class="icon-fast-forward"></i>fast-forward</li>
    <li><i class="icon-step-forward"></i>step-forward</li>
    <li><i class="icon-eject"></i>eject</li>
    <li><i class="icon-chevron-left"></i>chevron-left</li>
    <li><i class="icon-chevron-right"></i>chevron-right</li>
    <li><i class="icon-plus-sign"></i>plus-sign</li>
    <li><i class="icon-minus-sign"></i>minus-sign</li>
    <li><i class="icon-remove-sign"></i>remove-sign</li>
    <li><i class="icon-ok-sign"></i>ok-sign</li>
    <li><i class="icon-question-sign"></i>question-sign</li>
    <li><i class="icon-info-sign"></i>info-sign</li>
    <li><i class="icon-screenshot"></i>screenshot</li>
    <li><i class="icon-remove-circle"></i>remove-circle</li>
    <li><i class="icon-ok-circle"></i>ok-circle</li>
    <li><i class="icon-ban-circle"></i>ban-circle</li>
    <li><i class="icon-arrow-left"></i>arrow-left</li>
    <li><i class="icon-arrow-right"></i>arrow-right</li>
    <li><i class="icon-arrow-up"></i>arrow-up</li>
    <li><i class="icon-arrow-down"></i>arrow-down</li>
    <li><i class="icon-share-alt"></i>share-alt</li>
    <li><i class="icon-resize-full"></i>resize-full</li>
    <li><i class="icon-resize-small"></i>resize-small</li>
    <li><i class="icon-plus"></i>plus</li>
    <li><i class="icon-minus"></i>minus</li>
    <li><i class="icon-asterisk"></i>asterisk</li>
    <li><i class="icon-exclamation-sign"></i>exclamation-sign</li>
    <li><i class="icon-gift"></i>gift</li>
    <li><i class="icon-leaf"></i>leaf</li>
    <li><i class="icon-fire"></i>fire</li>
    <li><i class="icon-eye-open"></i>eye-open</li>
    <li><i class="icon-eye-close"></i>eye-close</li>
    <li><i class="icon-warning-sign"></i>warning-sign</li>
    <li><i class="icon-plane"></i>plane</li>
    <li><i class="icon-calendar"></i>calendar</li>
    <li><i class="icon-random"></i>random</li>
    <li><i class="icon-comment"></i>comment</li>
    <li><i class="icon-magnet"></i>magnet</li>
    <li><i class="icon-chevron-up"></i>chevron-up</li>
    <li><i class="icon-chevron-down"></i>chevron-down</li>
    <li><i class="icon-retweet"></i>retweet</li>
    <li><i class="icon-shopping-cart"></i>shopping-cart</li>
    <li><i class="icon-folder-close"></i>folder-close</li>
    <li><i class="icon-folder-open"></i>folder-open</li>
    <li><i class="icon-resize-vertical"></i>resize-vertical</li>
    <li><i class="icon-resize-horizontal"></i>resize-horizontal</li>
    <li><i class="icon-hdd"></i>hdd</li>
    <li><i class="icon-bullhorn"></i>bullhorn</li>
    <li><i class="icon-bell"></i>bell</li>
    <li><i class="icon-certificate"></i>certificate</li>
    <li><i class="icon-thumbs-up"></i>thumbs-up</li>
    <li><i class="icon-thumbs-down"></i>thumbs-down</li>
    <li><i class="icon-hand-right"></i>hand-right</li>
    <li><i class="icon-hand-left"></i>hand-left</li>
    <li><i class="icon-hand-up"></i>hand-up</li>
    <li><i class="icon-hand-down"></i>hand-down</li>
    <li><i class="icon-circle-arrow-right"></i>circle-arrow-right</li>
    <li><i class="icon-circle-arrow-left"></i>circle-arrow-left</li>
    <li><i class="icon-circle-arrow-up"></i>circle-arrow-up</li>
    <li><i class="icon-circle-arrow-down"></i>circle-arrow-down</li>
    <li><i class="icon-globe"></i>globe</li>
    <li><i class="icon-wrench"></i>wrench</li>
    <li><i class="icon-tasks"></i>tasks</li>
    <li><i class="icon-filter"></i>filter</li>
    <li><i class="icon-briefcase"></i>briefcase</li>
    <li><i class="icon-fullscreen"></i>fullscreen</li>
</div>
