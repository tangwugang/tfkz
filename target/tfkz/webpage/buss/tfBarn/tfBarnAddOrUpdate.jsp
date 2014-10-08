<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
<div class="wrapper2">
<form id="exportFrom" method="post"></form>
<form id="inputFrom" method="post" data-validator-option="{theme:'yellow_right_effect',stopOnError:true,timely:2}" >
<c:if test="${tfBarn.id != null}"><input type="hidden" name="id" value="${tfBarn.id}"/></c:if>
<c:if test="${tfBarn.barnNo != null}"><input type="hidden" name="oldName" value="${tfBarn.barnNo}"/></c:if>
  <div class="main">
    <div class="content">
      <div class="box_top1"></div>
      <div class="content1">
      	<t:dictSelect title="粮仓类型" field="liaCaType" id="liaCaType" defaultVal="${tfBarn.liaCaType}" divClass="nn" selectClass="in" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="lia_can_type" orderBy="sort" extendParams="{\"data-rule\":\"required;\",\"data-ok\":\"\",\"placeholder\":\"选择粮仓类型\"}"></t:dictSelect>
        <div class="nn"><label>仓房类型</label> <input type="text" class="in" name="barnType" data-rule="required;zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" value="${tfBarn.barnType}"/></div>
        <div class="nn"><label>仓房编号</label> <input type="text" class="in" name="barnNo" data-inputmask="'mask': '[P999]'"  data-rule="required;remote[tfBarnController.do?checkTfBarn, oldName]"  data-ok="" value="${tfBarn.barnNo}"/></div>
        <div class="nn"><label>启用日期</label> <input type="text" class="in" name="qiDoTime" data-inputmask="'alias': 'yyyy.mm.dd'" data-rule="required;date" data-rule-date="[/^\d{4}(\.)\d{2}(\.)\d{2}$/,'请输入日期']"  data-ok="" value="${tfBarn.qiDoTime}"/></div>
        <div class="nn"><label>结构</label> <input type="text" class="in" name="jieGou" data-rule="required;zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" value="${tfBarn.jieGou}"/></div>
        <div class="nn"><label>堆粮线高(m)</label> <input type="text" class="in" name="duiLianHeight" data-inputmask="'mask': '[9.9]'" data-rule="required;num" data-rule-num="[/^\d{1}(\.)\d{1}$/,'1位小数']" data-ok="" value="${tfBarn.duiLianHeight}"/></div>
        <div class="nn"><label>仓门数量</label> <input type="text" class="in" name="canMenNum" data-inputmask="'mask': '[99]'" data-rule="required;num" data-rule-num="[/^\d{1,2}$/,'格式不对']" data-ok="" value="${tfBarn.canMenNum}"/></div>
        <div class="nn"><label>建筑面积(长x宽)m</label> <input type="text" class="in" name="area" data-inputmask="'mask': '[99.9x99.9]'" data-rule="required;num" data-rule-num="[/^\d{1,2}(\.)\d{1}(\x)\d{1,2}(\.)\d{1}$/,'2位小数']" data-ok="" value="${tfBarn.area}"/></div>
        <div class="nn"><label>筒仓外径(m)</label> <input type="text" class="in" name="tonCaWaiJ" data-inputmask="'mask': '[9.9]'" data-rule="num" data-rule-num="[/^\d{1}(\.)\d{1}$/,'1位小数']" data-ok="" value="${tfBarn.tonCaWaiJ}"/></div>
        <div class="nn"><label>仓门高度(m)</label> <input type="text" class="in" name="canMenHeight" data-inputmask="'mask': '[9.9]'" data-rule="required;num" data-rule-num="[/^\d{1}(\.)\d{1}$/,'1位小数']" data-ok="" value="${tfBarn.canMenHeight}"/></div>
        <div class="nn"><label>檐高(m)</label> <input type="text" class="in" name="yanGao" data-inputmask="'mask': '[9.9]'" data-rule="required;num" data-rule-num="[/^\d{1}(\.)\d{1}$/,'1位小数']" data-ok="" value="${tfBarn.yanGao}"/></div>
        <div class="nn"><label>筒仓内径(m)</label> <input type="text" class="in" name="tonCaNeiJ" data-inputmask="'mask': '[9.9]'" data-rule="num" data-rule-num="[/^\d{1}(\.)\d{1}$/,'1位小数']" data-ok="" value="${tfBarn.tonCaNeiJ}"/></div>
        <div class="nn"><label>仓门宽度(m)</label> <input type="text" class="in" name="canMenKuanD" data-inputmask="'mask': '[9.9]'" data-rule="required;num" data-rule-num="[/^\d{1}(\.)\d{1}$/,'1位小数']" data-ok="" value="${tfBarn.canMenKuanD}"/></div>
        <div class="nn"><label>设计容量(t)</label> <input type="text" class="in" name="sheJiVol" data-inputmask="'mask': '[9999]'" data-rule="required;num" data-rule-num="[/^\d{4}$/,'4位整数']" data-ok="" value="${tfBarn.sheJiVol}"/></div>
        <div class="nn"><label>筒内体积(m³)</label> <input type="text" class="in" name="tonNeiVol" data-inputmask="'mask': '[99.9]'" data-rule="num" data-rule-num="[/^\d{1,2}(\.)\d{1}$/,'2位小数']" data-ok="" value="${tfBarn.tonNeiVol}"/></div>
        <div class="nn"><label>风道类型</label> <input type="text" class="in" name="fenDaoType" data-rule="required;zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" value="${tfBarn.fenDaoType}"/></div>
        <div class="nn"><label>核定容量(t)</label> <input type="text" class="in" name="heDinVol" data-inputmask="'mask': '[9999]'" data-rule="required;num" data-rule-num="[/^\d{4}$/,'4位整数']" data-ok="" value="${tfBarn.heDinVol}"/></div>
        <div class="nn"><label>通风口数量(个)</label> <input type="text" class="in" name="tonFenKoNum" data-inputmask="'mask': '[9]'" data-rule="required;num" data-rule-num="[/^\d{1}$/,'1位整数']" data-ok="" value="${tfBarn.tonFenKoNum}"/></div>
        <div class="nn"><label>实仓气密性(s)</label> <input type="text" class="in" name="shiCaQiMiX" data-inputmask="'mask': '[99]'" data-rule="required;num" data-rule-num="[/^\d{2}$/,'2位整数']" data-ok="" value="${tfBarn.shiCaQiMiX}"/></div>
        <div class="nn"><label>堆粮面积(长x宽)m</label> <input type="text" class="in" name="duiLianArea" data-inputmask="'mask': '[99.9x99.9]'" data-rule="required;num" data-rule-num="[/^\d{1,2}(\.)\d{1}(\x)\d{1,2}(\.)\d{1}$/,'2位小数']" data-ok="" value="${tfBarn.duiLianArea}"/></div>
        <div class="nn"><label>轴流风机数(台)</label> <input type="text" class="in" name="fenJiNum" data-inputmask="'mask': '[9]'" data-rule="required;num" data-rule-num="[/^\d{1}$/,'1位整数']" data-ok="" value="${tfBarn.fenJiNum}"/></div>
        <div class="nn"><label>隔热措施</label> <input type="text" class="in" name="geReCuoS" data-rule="required;zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" value="${tfBarn.geReCuoS}"/></div>
        <div class="clr"></div>
      </div>
      <div class="box_top3"><a href="javascript:;" class="wh_show">点击展开∨</a></div>
      
      <div id="items0" class="content3 hidden">
      
      <c:if test="${tfBarnWeihu==null}">
      	<div class="mm"> 
        <label>日期</label>
        <input type="text" name="whTime" data-inputmask="'alias': 'yyyy.mm.dd'" data-rule="date" data-rule-date="[/^\d{4}(\.)\d{2}(\.)\d{2}$/,'请输入日期']"  data-ok="" class="in" style="width:100px" />
        <label>维修保养项目名称</label>
        <input type="text" name="whName" data-rule="zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" class="in" style="width:120px" />
        <label>施工验收情况</label> 
        <input type="text" name="whQiKua" data-rule="zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" class="in" style="width:120px"/>
        <label>备注</label> 
        <input type="text" name="whBeiZ"  data-ok="" class="in" style="width:150px" value="备注"/>
        <a href="javascript:;" class="wh_add"></a>
        <div class="clr"></div>
       </div> <!--mm e-->
      </c:if>
      <c:forEach items="${tfBarnWeihu}" var="wh" varStatus="h">
      	<div class="mm"> 
        <label>日期</label>
        <input type="text" name="whTime" data-inputmask="'alias': 'yyyy.mm.dd'" data-rule="date" data-rule-date="[/^\d{4}(\.)\d{2}(\.)\d{2}$/,'请输入日期']"  data-ok="" class="in" style="width:100px" value="${wh.whTime}"/>
        <label>维修保养项目名称</label>
        <input type="text" name="whName" data-rule="zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" class="in" style="width:120px" value="${wh.whName}"/>
        <label>施工验收情况</label> 
        <input type="text" name="whQiKua" data-rule="zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" class="in" style="width:120px" value="${wh.whQiKua}"/>
        <label>备注</label> 
        <input type="text" name="whBeiZ"  data-ok="" class="in" style="width:150px" value="${wh.whBeiZ}"/>
        <c:choose>
        	<c:when test="${h.index == 0}"><a href="javascript:;" class="wh_add"></a></c:when>
        	<c:otherwise><a href="javascript:;" class="delete" data-id="${wh.id}"></a></c:otherwise>
        </c:choose>
        <div class="clr"></div>
       </div> <!--mm e-->
      </c:forEach>
      </div>
      <div class="box_top2"></div><!--box_top2 e-->
      <div class="content2">
      <c:if test="${tfBarnDevices==null}">
      	<div class="mm">
       	<t:dictSelect title="类型" field="type" id="type" defaultVal="" divClass="derv" selectClass="in" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="dev_type" orderBy="sort" extendParams="{\"data-ok\":\"\",\"placeholder\":\"选择类型\"}"></t:dictSelect>
        <div class="derv"><label>编号</label><input type="text" class="in" style="width:75px;" id="no" name="no"  data-rule="num" data-rule-num="[/^[A-Z]\d{1,3}(\:)\d{1,3}(\-)\d{1,2}$/,'如P1:123-12']" data-ok="" /></div>
        <div class="derv"><label>位置</label> <input type="text" class="in" id="place" name="place" data-inputmask="'mask': '[9]'" data-rule="num" data-rule-num="[/^\d{1,2}$/,'请输入1或2位整数']" data-ok="" /></div>
        <div class="derv"><label>型号</label> <input type="text" class="in" id="version" name="version"  data-ok="" /></div>
        <div class="derv"><label>功率</label> <input type="text" class="in" id="power" name="power" data-inputmask="'mask': '[9.9]'" data-rule="num" data-rule-num="[/^\d{1,2}(\.)\d{1,2}$/,'请输入1位小数']" data-ok="" /></div>
        <a href="javascript:;" class="dev_add"></a>
        <div class="clr"></div>
       </div> <!--mm e-->
      </c:if>
      <c:forEach items="${tfBarnDevices}" var="dev" varStatus="d">
      	<div class="mm">
       	<t:dictSelect title="类型" field="type" id="type" defaultVal="${dev.type}" divClass="derv" selectClass="in" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="dev_type" orderBy="sort" extendParams="{\"data-ok\":\"\",\"placeholder\":\"选择类型\"}"></t:dictSelect>
        <div class="derv"><label>编号</label><input type="text" class="in" style="width:75px;" id="no" name="no"  data-rule="num" data-rule-num="[/^[A-Z]\d{1,3}(\:)\d{1,3}(\-)\d{1,2}$/,'如P1:123-12']" data-ok="" value="${dev.no}"/></div>
        <div class="derv"><label>位置</label> <input type="text" class="in" id="place" name="place" data-inputmask="'mask': '[9]'" data-rule="num" data-rule-num="[/^\d{1,2}$/,'请输入1或2位整数']" data-ok="" value="${dev.place}"/></div>
        <div class="derv"><label>型号</label> <input type="text" class="in" id="version" name="version"  data-ok="" value="${dev.version}"/></div>
        <div class="derv"><label>功率</label> <input type="text" class="in" id="power" name="power" data-inputmask="'mask': '[9.9]'" data-rule="num" data-rule-num="[/^\d{1,2}(\.)\d{1,2}$/,'请输入1位小数']" data-ok="" value="${dev.power}" /></div>
        <c:choose>
        	<c:when test="${d.index == 0}"><a href="javascript:;" class="dev_add"></a></c:when>
        	<c:otherwise><a href="javascript:;" class="delete" data-id="${dev.id}"></a></c:otherwise>
        </c:choose>
        <div class="clr"></div>
       </div> <!--mm e-->
      </c:forEach>
       
      </div>
      <div class="box_bottom"></div>
    </div><!--content e-->
    
    <div class="dao"><a href="javascript:;" title="导出" class="export-btn"></a></div>
	<div class="save v_s"><a href="javascript:;" title="保存" class="submit-btn"></a></div>
  </div><!--main e-->
</form>
<script type="text/javascript">
	$(function(){
		$(":input").inputmask();
		//添加维护记录
		$('body').on('click','a.wh_add',function(e){
			var id = Math.random()*1000;
			$('<div class="mm"><label>日期</label><input type="text" id="whTime_'+id+'" name="whTime" data-rule="date" data-rule-date="[/^\\\d{4}(\\\.)\\\d{2}(\\\.)\\\d{2}$/,\'请输入日期\']"  data-ok="" class="in" style="width:100px"/>'+
			'<label>维修保养项目名称</label><input type="text" id="whName_'+id+'" name="whName" data-rule="zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,\'请输入中文\']" data-ok="" class="in" style="width:120px" />'+
			'<label>施工验收情况</label><input type="text" id="whQiKua_'+id+'" name="whQiKua" data-rule="zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,\'请输入中文\']" data-ok="" class="in" style="width:120px"/>'+
			'<label>备注</label><input type="text" id="whBeiZ_'+id+'" name="whBeiZ"  data-ok="" class="in" style="width:150px" value="备注"/>'+
			'<a href="javascript:;" class="delete"></a><div class="clr"></div></div>').appendTo('.content3').on('click','a.delete',function(e){
				e.preventDefault();	
				$(this).closest('.mm').hide(300, function(){
					$(this).remove();
				});
			})
			.on('focusin','input[name=\'whBeiZ\']',function(){
				if($(this).val()=="备注"){
					$(this).val("");
				}
			})
			.on('focusout','input[name=\'whBeiZ\']',function(){
				if($(this).val()==""){
					$(this).val("备注");
				}
			})
		});
		//添加设备
		$('body').on('click','a.dev_add',function(e){
			var id = Math.random()*1000;
			$('<div class="mm"><t:dictSelect title="类型" field="type" id="type_'+id+'" defaultVal="" divClass="derv" selectClass="in" dataTable="sys_type" dataField="typeCode" dataText="typeName" dataType="dev_type" orderBy="sort" extendParams="{\"data-ok\":\"\",\"placeholder\":\"选择类型\"}"></t:dictSelect>'+
					'<div class="derv"><label>编号</label><input type="text" class="in" style="width:75px;" id="no_'+id+'" name="no"  data-rule="num" data-rule-num="[/^[A-Z]\\\d{1,3}(\\\:)\\\d{1,3}(\\\-)\\\d{1,2}$/,\'如P1:123-12\']" data-ok="" value=""/></div>'+
					'<div class="derv"><label>位置</label> <input type="text" class="in" id="place_'+id+'" name="place"  data-rule="num" data-rule-num="[/^\\\d{1,2}$/,\'请输入1或2位整数\']" data-ok="" value=""/></div>'+
					'<div class="derv"><label>型号</label> <input type="text" class="in" id="version_'+id+'" name="version"  data-ok="" value=""/></div>'+
					'<div class="derv"><label>功率</label> <input type="text" class="in" id="power_'+id+'" name="power"  data-rule="num" data-rule-num="[/^\\\d{1,2}(\\\.)\\\d{1,2}$/,\'请输入1位小数\']" data-ok="" value=""/></div>'+
					' <a href="javascript:;" class="delete"></a><div class="clr"></div></div>').appendTo('.content2').on('click','a.delete',function(e){
						e.preventDefault();			
						$(this).closest('.mm').hide(300, function(){
							$(this).remove();
						});
					});
		})
		//删除设备
		.on('click','a.delete',function(e){
			e.preventDefault();
			devId = $(this).data('id');
			if(devId != undefined){
				$(this).closest('.mm').hide(300, function(){
					$(this).remove();
				});
			}
		})
		.on('click','a.wh_show',function(e){
			e.preventDefault();
			$('.content3').toggleClass('show');
			if($('.content3').attr('class')=='content3 hidden'){
				$(this).text('点击展开∨');
			}else{
				$(this).text('点击收起∧');
			}
		})
		.on('click','a.export-btn',function(e){
			e.preventDefault();
			var api = frameElement.api, W = api.opener;
			id = $('input[name=\'id\']').val();
			if(id != undefined){
				$('#exportFrom').attr('action','tfBarnController.do?export&id='+id);
				$('#exportFrom').submit();
			}else{
				W.$.dialog({
        			id:'alert',
    				title:'提示',
    				time:3,
    				icon:'error.gif',
    				content:'亲,请先添加信息！',
    				max:false,
    		        min:false,
    		        resize:false
    			});
			}
			
		})
		
		$("input[name='whBeiZ']").focusin(function(){
			if($(this).val()=="备注"){
				$(this).val("");
			}
		});
		
		$("input[name='whBeiZ']").focusout(function(){
			if($(this).val()==""){
				$(this).val("备注");
			}
		});
		
		$('#inputFrom').validator({
			//验证成功
		    valid: function(form) {
		    	var params = $(form).serialize();
		    	$.post('tfBarnController.do?save',params,function(result){
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