<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
<div class="wrapper2">
<form id="inputFrom" method="post" data-validator-option="{theme:'yellow_right_effect',stopOnError:true,timely:2}" >
<c:if test="${tfGuize.id != null}"><input type="hidden" name="id" value="${tfGuize.id}"/></c:if>
<c:if test="${tfGuize.tfGuiZeName != null}"><input type="hidden" name="oldName" value="${tfGuize.tfGuiZeName}"/></c:if>
  <div class="main">
    <div class="top_box">
      <div class="name">
        <div class="fill" style="width:345px;"><label>通风规则名称</label><input type="text" name="tfGuiZeName"  data-rule="required;remote[tfGuizeController.do?checkTfGuize, oldName]"  data-ok="" value="${tfGuize.tfGuiZeName}" class="in"  style="width:250px;"/></div>
        <t:dictSelect title="通风目的" field="tfMuDi" id="tfMuDi" defaultVal="${tfGuize.tfMuDi}" divClass="fill" selectClass="in" selectStyle="width:160px" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="tf_mu_di" orderBy="sort" extendParams="{\"data-rule\":\"required;\",\"data-ok\":\"\",\"placeholder\":\"选择通风目的\"}"></t:dictSelect>
      </div><!--name e-->   
      <div class="save"><a href="javascript:;" title="保存" class="submit-btn"></a></div>
    </div><!--top_box e-->
    <div class="mid_box">
      <div class="mid_c">
       <div class="all">
        <div class="time" >
          <div class="h"><label>时间段</label><a href="javascript:;" title="添加时间段" class="add_time"></a></div>
          <ul>
          <c:forEach items="${tfGuizeTimes}" var="times" varStatus="t">
          <c:choose>
          <c:when test="${t.index == 0 }"><li class="first_time"><input type="text" class="in" name="tfGuiZeStartTime"  data-rule="time;"  value="${times.tfGuiZeStartTime}" /><label>至</label><input type="text" class="in" name="tfGuiZeEndTime" data-rule="time;" data-ok="" value="${times.tfGuiZeEndTime}"/></li></c:when>
          <c:otherwise><li><a href="javascript:;" title="删除时间段" class="del_time"></a><input type="text" class="in" name="tfGuiZeStartTime"  data-rule="time;"  value="${times.tfGuiZeStartTime}" /><label>至</label><input type="text" class="in" name="tfGuiZeEndTime" data-rule="time;" data-ok="" value="${times.tfGuiZeEndTime}"/></li></c:otherwise>
          </c:choose>
          </c:forEach>
          <c:if test="${tfGuizeTimes == null}">
          	<li class="first_time"><input type="text" class="in" name="tfGuiZeStartTime"  data-rule="time;"  /><label>至</label><input type="text" class="in" name="tfGuiZeEndTime" data-rule="time;" data-ok="" /></li>
          </c:if>
            <div class="clr"></div>
          </ul>
        </div><!--time e-->
        <div class="time_g" >
          <div class="h"><label>时间间隔</label></div>
          <div class="minit"><label>温湿度监测&nbsp;&nbsp;时间间隔</label><input type="text" class="in" name="tfWenShiDuTime" data-rule="integer[+0]" data-ok="" value="${tfGuize.tfWenShiDuTime}"/><label>分钟</label></div>
        </div><!--time e-->
        <div class="temp">
          <div class="h"><label>温湿度控制</label></div>
          <div class="factor">
            <div class="l_part">
              <label  style="color:#eb8800;">执行条件：</label>
              <t:dictSelect hasLabel="false" field="tfWenShiDuStart" id="tfWenShiDuStart1"  defaultVal="${fns:splitString(tfGuize.tfWenShiDuStart,0)}"  selectClass="in" selectStyle="width:80px" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="wen_du_type" orderBy="sort" extendParams="{\"data-rule\":\"required;\"}"></t:dictSelect>
              <label>比</label>
              <t:dictSelect hasLabel="false" field="tfWenShiDuStart"  id="tfWenShiDuStart2" defaultVal="${fns:splitString(tfGuize.tfWenShiDuStart,1)}"  selectClass="in" selectStyle="width:80px" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="wen_du_type" orderBy="sort" extendParams="{\"data-rule\":\"required;\"}"></t:dictSelect>
              <t:dictSelect hasLabel="false" field="tfWenShiDuStart"  id="tfWenShiDuStart3" defaultVal="${fns:splitString(tfGuize.tfWenShiDuStart,2)}"  selectClass="in" selectStyle="width:80px" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="yxj" orderBy="sort" extendParams="{\"data-rule\":\"required;\"}"></t:dictSelect>
              <input type="text" class="in" style="width:80px;" name="tfWenShiDuStart" id="tfWenShiDuStart4" data-inputmask="'mask': '[99]'" data-rule="integer[+]"  data-ok="" value="${fns:splitString(tfGuize.tfWenShiDuStart,3)}"/><label>℃</label><br/>
              <label style="padding-left:85px;">湿度</label>
              <t:dictSelect hasLabel="false" field="tfWenShiDuStart" id="tfWenShiDuStart5" defaultVal="${fns:splitString(tfGuize.tfWenShiDuStart,4)}"  selectClass="in" selectStyle="width:80px" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="yxj" orderBy="sort" extendParams="{\"data-rule\":\"required;\"}"></t:dictSelect>
              <input type="text" class="in" style="width:80px;" name="tfWenShiDuStart" id="tfWenShiDuStart6" data-inputmask="'mask': '[99]'" data-rule="integer[+]" data-ok="" value="${fns:splitString(tfGuize.tfWenShiDuStart,5)}"/><label>%</label>
            </div>
            <div class="r_part">
              <label  style="color:#eb8800;">终止条件：</label>
              <t:dictSelect hasLabel="false" field="tfWenShiDuEnd" id="tfWenShiDuEnd1" defaultVal="${fns:splitString(tfGuize.tfWenShiDuEnd,0)}"  selectClass="in" selectStyle="width:80px" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="wen_du_type" orderBy="sort" extendParams="{\"data-rule\":\"required;\"}"></t:dictSelect>
              <label>比</label>
              <t:dictSelect hasLabel="false" field="tfWenShiDuEnd" id="tfWenShiDuEnd2" defaultVal="${fns:splitString(tfGuize.tfWenShiDuEnd,1)}"  selectClass="in" selectStyle="width:80px" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="wen_du_type" orderBy="sort" extendParams="{\"data-rule\":\"required;\"}"></t:dictSelect>
              <t:dictSelect hasLabel="false" field="tfWenShiDuEnd" id="tfWenShiDuEnd3" defaultVal="${fns:splitString(tfGuize.tfWenShiDuEnd,2)}"  selectClass="in" selectStyle="width:80px" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="yxj" orderBy="sort" extendParams="{\"data-rule\":\"required;\"}"></t:dictSelect>
              <input type="text" class="in" style="width:80px;" name="tfWenShiDuEnd" id="tfWenShiDuEnd4" data-inputmask="'mask': '[99]'" data-rule="integer[+]" data-ok="" value="${fns:splitString(tfGuize.tfWenShiDuEnd,3)}"/><label>℃</label><br/>
              <label style="padding-left:85px;">湿度</label>
              <t:dictSelect hasLabel="false" field="tfWenShiDuEnd" id="tfWenShiDuEnd5" defaultVal="${fns:splitString(tfGuize.tfWenShiDuEnd,4)}"  selectClass="in" selectStyle="width:80px" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="yxj" orderBy="sort" extendParams="{\"data-rule\":\"required;\"}"></t:dictSelect>
              <input type="text" class="in" style="width:80px;" name="tfWenShiDuEnd" id="tfWenShiDuEnd6" data-inputmask="'mask': '[99]'" data-rule="integer[+]" data-ok="" value="${fns:splitString(tfGuize.tfWenShiDuEnd,5)}"/><label>%</label>
            </div>
          </div>
        </div><!--temp e-->
        </div><!--all e-->
      </div><!--mid_c e-->
    </div><!--mid_box e-->

  </div><!--main e-->
</form>
<script type="text/javascript">
	$(function(){
		$(":input").inputmask();
		//添加时间段
	    $('body').on('click','a.add_time',function(){
	    	var id = Math.random()*1000;
	    	$($('li').last()).after('<li><a href="javascript:;" title="删除时间段" class="del_time"></a><input type="text" class="in" id="tfGuiZeStartTime_'+id+'" name="tfGuiZeStartTime"  data-rule="time;"/><label>至</label><input type="text" class="in" id="tfGuiZeEndTime_'+id+'" name="tfGuiZeEndTime" data-rule="time;" data-ok=""/></li>');
		});
		
	    $('body').on('click','a.del_time',function(){
	    	$(this).parent().remove();  
		});
		
		$('#inputFrom').validator({
			//验证成功
		    valid: function(form) {
		    	var params = $(form).serialize();
		    	$.post('tfGuizeController.do?save',params,function(result){
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
		    	});
		    }
		})
		// 使用链接代替submit按钮（注意：这种情况下输入框里面的回车键不能触发submit事件）
		.on("click", "a.submit-btn", function(e){
		    $(e.delegateTarget).trigger("validate");
		});
		
	});

</script>
</body>