<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<style>
ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:360px;overflow-y:scroll;overflow-x:auto;}
</style>
<body>
<div class="wrapper2">
<div class="main">
   <div style="height:10px"></div>
<form id="inputFrom" method="post">
   <c:if test="${null != tfGuize.id}"><input type="hidden" name="tfGuiZeId" value="${tfGuize.id}"/></c:if>
    <div class="top_box2">
      <div class="name">
      <t:dictSelect title="粮仓类型" field="barnType" id="barnType" defaultVal="1" divClass="fill" divStyle="width:270px;" selectClass="in" selectStyle="width:130px;" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="lia_can_type" orderBy="sort" extendParams="{\"data-rule\":\"required;\",\"data-ok\":\"\"}"></t:dictSelect>
      <div class="fill" style="width:200px;">
         <label>粮仓编号</label>
         <input type="text" name="barnNo" id="barnNo"  class="in"  style="width:130px" data-rule="required;" data-ok="" placeholder="请选择粮仓编号" onclick="showMenu();"/>
         <div id="menuContent" class="menuContent" style="display:none; position: absolute;left:359px; top:51px;">
			<ul id="treeBarn" class="ztree" style="margin-top:0; width:130px; height:auto;"></ul>
		 </div>
      </div>
        <div class="map_btn"><a href="javascript:;" title="图选"></a></div>
      </div><!--name e-->   
      <div class="save"><a href="javascript:;" title="保存" class="submit-btn"></a></div>
    </div><!--top_box e-->
    
    <div class="bom_box">
      <div class="bom_t">风机/窗状态控制</div><!--bom_t e-->
      <div class="bom_c">
        <ul>
        </ul>
      </div><!--mid_c e-->
    </div><!--mid_box e-->
</form>
  </div><!--main e-->
</div>
 <script type="text/javascript">
 
	 var setting = {
				check: {
					enable: true,
					chkboxType: {"Y":"", "N":""}
				},
				data: {
					simpleData: {
						enable: true,
						idKey : "id",
						pIdKey : "pId"
					}
				},
				callback: {
					onCheck: onCheck
				}
			};
	 
	 var zNodes =[{id:'',name:"不匹配"}];
		 
	$.fn.zTree.init($("#treeBarn"), setting,zNodes);
  	
 	function onCheck(e, treeId, treeNode) {
		var zTree = $.fn.zTree.getZTreeObj("treeBarn"),
		nodes = zTree.getCheckedNodes(true),
		v = "";
		for (var i=0, l=nodes.length; i<l; i++) {
			v += nodes[i].id + ",";
		}
		if (v.length > 0 ) v = v.substring(0, v.length-1);
		var obj = $("#barnNo");
		obj.val(v);
	}
 	
 	function showMenu() {
		var obj = $("#barnNo");
		var objOffset = $("#barnNo").offset();
		$("#menuContent").css({left:objOffset.left + "px", top:objOffset.top + obj.outerHeight() + "px"}).slideDown("fast");

		$("body").bind("mousedown", onBodyDown);
	}
 	
 	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "barnNo" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
			hideMenu();
		}
	}
	
var tfGuiZeId = $('input[name="tfGuiZeId"]').val();
 var barnType = $('#barnType').val();
 $.ajax({
		 url: "tfGuizeController.do?tfBarnSelect",
         type: 'POST',
         data: "barnType="+barnType+"&tfGuiZeId="+tfGuiZeId,
         success: function(result){
        	 result = $.parseJSON(result);
    		 var barns = result[0].obj;//仓房集合
    		 var tfConfigId = result[0].pId;//仓房通风设置表id
    		 $.each(result,function(n,v){
    			 $('#barnNo').val("");
    			 $.fn.zTree.init($("#treeBarn"), setting, result);
    			 var zTree = $.fn.zTree.getZTreeObj("treeBarn"),
    			nodes = zTree.getCheckedNodes(true),
    			v = "";
    			for (var i=0, l=nodes.length; i<l; i++) {
    				v += nodes[i].id + ",";
    				barns = nodes[i].obj;
    			}
    			if (v.length > 0 ) v = v.substring(0, v.length-1);
    			var obj = $("#barnNo");
    			obj.val(v);
    		 });
    		 $('.bom_c ul').empty();
    		 //仓房通风设置表id,更新时用
    		 if(tfConfigId != undefined && 
    				 tfConfigId != null &&
    				 ($('input[name="id"]').val() == null||
    				 $('input[name="id"]').val() == undefined)){
    			 $('<input type="hidden" name="id" value="'+tfConfigId+'"/>').appendTo($("#inputFrom"));
    		 }else if(tfConfigId != undefined && tfConfigId != null){
    			 $('input[name="id"]').val(tfConfigId);
    		 }
    		 //遍历选中的仓房设备信息
    		 for(var i=0,c=1;i<barns.length;i++){
    			 var html = '';
    			 var k = i;
    			 if(barns[i].type ==0 ){
    				 html += '<li><div class="num"><label>编号</label><span>'+c+'</span></div>';
    				 html += '<div class="window"></div>';
    				 fanClass = 'fan_stop';
    				 if(barns[i].status == 'Y'){fanClass = 'fan_start'}
    				 html += '<div class="fan"><a href="javascript:;" class="'+fanClass+'"></a><input type="hidden" name="tfBarnDevicesId" value="'+barns[i].id+'"/><input type="hidden"  name="status" value="'+barns[i].status+'"/>';
    				 if(barns[i].cfMode == 'OUT'){html += '<div class="check"><input type="radio" name="cfMode'+c+'" data-rule="checked" checked value="OUT"/>吸出式&nbsp;&nbsp;<input type="radio" name="cfMode'+c+'" value="IN"/>压入式</div></div>';}else{html += '<div class="check"><input type="radio" name="cfMode'+c+'" data-rule="checked"  value="OUT"/>吸出式&nbsp;&nbsp;<input type="radio" name="cfMode'+c+'"  checked value="IN"/>压入式</div></div>';}
    			  }else if(barns[i].type ==1){
    				 html += '<li><div class="num"><label>编号</label><span>'+c+'</span></div>';
    				 winClass = 'win_close';
    				 if(barns[i].status == 'Y'){winClass = 'win_open'}
    				 html += '<div class="window"><a href="javascript:;" class="'+winClass+'"></a><input type="hidden" name="tfBarnDevicesId" value="'+barns[i].id+'"/><input type="hidden" name="status" value="'+barns[i].status+'"/><div class="hidden"><input type="radio" name="cfMode99'+c+'" checked value=" "/></div></div>';
    				 k = k+1;
    				 if(k<barns.length && barns[k].type == 0){
    					 fanClass = 'fan_stop';
    					 if(barns[k].status == 'Y'){fanClass = 'fan_start'}
    					 html += '<div class="fan"><a href="javascript:;" class="'+fanClass+'"></a><input type="hidden" name="tfBarnDevicesId" value="'+barns[k].id+'"/><input type="hidden" name="status" value="'+barns[k].status+'"/>';
    					 if(barns[k].cfMode == 'OUT'){html += '<div class="check"><input type="radio" name="cfMode'+c+'" data-rule="checked" checked value="OUT"/>吸出式&nbsp;&nbsp;<input type="radio" name="cfMode'+c+'" value="IN"/>压入式</div></div>';}else{html += '<div class="check"><input type="radio" name="cfMode'+c+'" data-rule="checked"  value="OUT"/>吸出式&nbsp;&nbsp;<input type="radio" name="cfMode'+c+'"  checked value="IN"/>压入式</div></div>';}
    					 i = k;
    				 }
    			 }
    			 ++c;
    			 html += '<div class="clr"></div></li>';
    			 $(html).appendTo($('.bom_c ul'));
    		 }
         }
	 });

	
 
 //粮仓类型联动获取仓房编号
 $("#barnType").change(function(){
	 var tfGuiZeId = $('input[name="tfGuiZeId"]').val();
	 var barnType = $(this).val();
	 $.ajax({
			 url: "tfGuizeController.do?tfBarnSelect",
	         type: 'POST',
	         data: "barnType="+barnType+"&tfGuiZeId="+tfGuiZeId,
	         success: function(result){
	        	 result = $.parseJSON(result);
	    		 var barns = result[0].obj;//仓房集合
	    		 var tfConfigId = result[0].pId;//仓房通风设置表id
	    		 $.each(result,function(n,v){
	    			 $('#barnNo').val("");
	    			 $.fn.zTree.init($("#treeBarn"), setting, result);
	    			 var zTree = $.fn.zTree.getZTreeObj("treeBarn"),
	    			nodes = zTree.getCheckedNodes(true),
	    			v = "";
	    			for (var i=0, l=nodes.length; i<l; i++) {
	    				v += nodes[i].id + ",";
	    				barns = nodes[i].obj;
	    			}
	    			if (v.length > 0 ) v = v.substring(0, v.length-1);
	    			var obj = $("#barnNo");
	    			obj.val(v);
	    		 });
	    		 $('.bom_c ul').empty();
	    		 //仓房通风设置表id,更新时用
	    		 if(tfConfigId != undefined && 
	    				 tfConfigId != null &&
	    				 ($('input[name="id"]').val() == null||
	    				 $('input[name="id"]').val() == undefined)){
	    			 $('<input type="hidden" name="id" value="'+tfConfigId+'"/>').appendTo($("#inputFrom"));
	    		 }else if(tfConfigId != undefined && tfConfigId != null){
	    			 $('input[name="id"]').val(tfConfigId);
	    		 }
	    		 //遍历选中的仓房设备信息
	    		 for(var i=0,c=1;i<barns.length;i++){
	    			 var html = '';
	    			 var k = i;
	    			 if(barns[i].type ==0 ){
	    				 html += '<li><div class="num"><label>编号</label><span>'+c+'</span></div>';
	    				 html += '<div class="window"></div>';
	    				 fanClass = 'fan_stop';
	    				 if(barns[i].status == 'Y'){fanClass = 'fan_start'}
	    				 html += '<div class="fan"><a href="javascript:;" class="'+fanClass+'"></a><input type="hidden" name="tfBarnDevicesId" value="'+barns[i].id+'"/><input type="hidden"  name="status" value="'+barns[i].status+'"/>';
	    				 if(barns[i].cfMode == 'OUT'){html += '<div class="check"><input type="radio" name="cfMode'+c+'" data-rule="checked" checked value="OUT"/>吸出式&nbsp;&nbsp;<input type="radio" name="cfMode'+c+'" value="IN"/>压入式</div></div>';}else{html += '<div class="check"><input type="radio" name="cfMode'+c+'" data-rule="checked"  value="OUT"/>吸出式&nbsp;&nbsp;<input type="radio" name="cfMode'+c+'"  checked value="IN"/>压入式</div></div>';}
	    			  }else if(barns[i].type ==1){
	    				 html += '<li><div class="num"><label>编号</label><span>'+c+'</span></div>';
	    				 winClass = 'win_close';
	    				 if(barns[i].status == 'Y'){winClass = 'win_open'}
	    				 html += '<div class="window"><a href="javascript:;" class="'+winClass+'"></a><input type="hidden" name="tfBarnDevicesId" value="'+barns[i].id+'"/><input type="hidden" name="status" value="'+barns[i].status+'"/><div class="hidden"><input type="radio" name="cfMode99'+c+'" checked value=" "/></div></div>';
	    				 k = k+1;
	    				 if(k<barns.length && barns[k].type == 0){
	    					 fanClass = 'fan_stop';
	    					 if(barns[k].status == 'Y'){fanClass = 'fan_start'}
	    					 html += '<div class="fan"><a href="javascript:;" class="'+fanClass+'"></a><input type="hidden" name="tfBarnDevicesId" value="'+barns[k].id+'"/><input type="hidden" name="status" value="'+barns[k].status+'"/>';
	    					 if(barns[k].cfMode == 'OUT'){html += '<div class="check"><input type="radio" name="cfMode'+c+'" data-rule="checked" checked value="OUT"/>吸出式&nbsp;&nbsp;<input type="radio" name="cfMode'+c+'" value="IN"/>压入式</div></div>';}else{html += '<div class="check"><input type="radio" name="cfMode'+c+'" data-rule="checked"  value="OUT"/>吸出式&nbsp;&nbsp;<input type="radio" name="cfMode'+c+'"  checked value="IN"/>压入式</div></div>';}
	    					 i = k;
	    				 }
	    			 }
	    			 ++c;
	    			 html += '<div class="clr"></div></li>';
	    			 $(html).appendTo($('.bom_c ul'));
	    		 }
	         }
		 });
 });
 //校验
 $('#inputFrom').validator({
		//验证成功
	    valid: function(form) {
	    	var cfMode = $('input[type="radio"]').serialize().replace(/[0-9]/g, "");
	    	var params = $(form).serialize();
	    	$.ajax({
	    		url:"tfGuizeController.do?tfConfigSave&"+cfMode,
	    		type: 'POST',
	    		data: params,
	    		success: function(result){
	    			var result = $.parseJSON(result);
	             	var api = frameElement.api, W = api.opener;
	             	if(result.success == false){
	             		api.close();
	             		W.$.dialog({
	             			id:'alert',
	         				title:'提示',
	         				time:3,
	         				icon:'error.gif',
	         				content:result.msg,
	         				max:false,
	         		        min:false,
	         		        resize:false
	         			});
	             	}else{
	             		api.hide();
	             		W.$.dialog({
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
	             	}
	    		}
	    	});
	    }
	})
	// 使用链接代替submit按钮（注意：这种情况下输入框里面的回车键不能触发submit事件）
	.on("click", "a.submit-btn", function(e){
	    $(e.delegateTarget).trigger("validate");
	});

 $("body").on('click','.window a',function(e){
	 if($(this).attr('class') == 'win_open'){
		 $(this).removeClass();
		 $(this).addClass('win_close');
		 $(this).parent().find($('input[name="status"]')).val('N');
	 }else if($(this).attr('class') == 'win_close'){
		 $(this).removeClass();
		 $(this).addClass('win_open');
		 $(this).parent().find($('input[name="status"]')).val('Y');
	 }
	})
	.on('click','.fan a',function(){
		if($(this).attr('class') == 'fan_start'){
			 $(this).removeClass();
			 $(this).addClass('fan_stop');
			 $(this).parent().find($('input[name="status"]')).val('N');
		 }else if($(this).attr('class') == 'fan_stop'){
			 $(this).removeClass();
			 $(this).addClass('fan_start');
			 $(this).parent().find($('input[name="status"]')).val('Y')
		 }
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
	        content:'url:tfGuizeController.do?tfLiaqinAddOrUpdate&tfBarnId='+barnId
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