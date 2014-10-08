<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
<div class="wrapper2">
<form id="exportFrom" method="post"></form>
<form id="inputFrom" method="post" data-validator-option="{theme:'yellow_right_effect',stopOnError:true,timely:2}" >
<c:if test="${tfBarnShiwu.id != null}"><input type="hidden" name="id" value="${tfBarnShiwu.id}"/></c:if>
<c:if test="${tfBarnShiwu.tfBarnId != null}"><input type="hidden" name="tfBarnId" value="${tfBarnShiwu.tfBarnId}"/></c:if>
  <div class="main">
    <div class="content">
      <div class="box_top11"></div>
      <div class="content1">
        <div class="nn"><label>粮食品种</label> <input type="text" class="in" name="liaShiPinZh" data-rule="required;zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" value="${tfBarnShiwu.liaShiPinZh}"/></div>
        <div class="nn"><label>粮食产地</label> <input type="text" class="in" name="liaShiChanDi" data-rule="required;zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" value="${tfBarnShiwu.liaShiChanDi}"/></div>
        <div class="nn"><label>粮食性质</label> <input type="text" class="in" name="liaShiXinZhi" data-rule="required;zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" value="${tfBarnShiwu.liaShiXinZhi}"/></div>
        <div class="nn"><label>粮权归属</label> <input type="text" class="in" name="liaQuaGuiSu" data-rule="required;zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" value="${tfBarnShiwu.liaQuaGuiSu}"/></div>
        <div class="nn"><label>实际数量(吨)</label> <input type="text" class="in" name="number" data-inputmask="'mask': '[9999]'" data-rule="required;num" data-rule-num="[/^\d{4}$/,'4位整数']" data-ok="" value="${tfBarnShiwu.number}"/></div>
        <div class="nn"><label>入库成本(元/吨)</label> <input type="text" class="in" name="ruKuCenBen" data-inputmask="'mask': '[9999]'" data-rule="required;num" data-rule-num="[/^\d{4}$/,'4位整数']" data-ok="" value="${tfBarnShiwu.ruKuCenBen}"/></div>
        <div class="nn"><label>收获年度</label> <input type="text" class="in" name="soHuoNiaDu" data-rule="required;num" data-rule-num="[/^\d{4}$/,'4位整数']" data-ok="" value="${tfBarnShiwu.soHuoNiaDu}"/></div>
        <div class="nn"><label>入仓时间</label> <input type="text" class="in" name="ruCanTime" data-inputmask="'alias': 'yyyy.mm.dd'" data-rule="required;date" data-rule-date="[/^\d{4}(\.)\d{2}(\.)\d{2}$/,'请输入日期']"  data-ok="" value="${tfBarnShiwu.ruCanTime}"/></div>
        <div class="nn"><label>成货位时间</label> <input type="text" class="in" name="huoWeiTime" data-inputmask="'alias': 'yyyy.mm.dd'" data-rule="required;date" data-rule-date="[/^\d{4}(\.)\d{2}(\.)\d{2}$/,'请输入日期']"  data-ok="" value="${tfBarnShiwu.huoWeiTime}"/></div>
        <div class="nn"><label>储存年限</label> <input type="text" class="in" name="cuCenNianX" data-rule="required;num" data-rule-num="[/^\d{1,4}$/,'1或4位整数']"  data-ok="" value="${tfBarnShiwu.cuCenNianX}"/></div>
        <div class="nn"><label>管理方式</label> <input type="text" class="in" name="guanLifanShi" data-rule="required;zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" value="${tfBarnShiwu.guanLifanShi}"/></div>
        <div class="nn"><label>储存方式</label> <input type="text" class="in" name="cuCenFanShi" data-rule="required;zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" value="${tfBarnShiwu.cuCenFanShi}"/></div>
        <div class="nn"><label>入仓方式</label> <input type="text" class="in" name="ruCanFanShi" data-rule="required;zh_cn" data-rule-zh_cn="[/^[\u4E00-\uFA29]*$/,'请输入中文']" data-ok="" value="${tfBarnShiwu.ruCanFanShi}"/></div>
        <div class="nn"><label>包装存粮(包数)</label> <input type="text" class="in" name="cunLiaBaoS" data-rule="num" data-rule-num="[/^\d{1,4}$/,'1或4位整数']"  data-ok="" value="${tfBarnShiwu.cunLiaBaoS}"/></div>
        <div class="nn"><label>包装存粮体积(m³)</label> <input type="text" class="in" name="bzCunLiaVol" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.bzCunLiaVol}"/></div>
        <div class="nn"><label>散装存粮体积(m³)</label> <input type="text" class="in" name="szCunLiaVol" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.szCunLiaVol}"/></div>
        <div class="clr"></div>
      </div>
      <div class="box_top22"></div><!--box_top2 e-->
      <div class="content1">
        <div class="nn"><label>容重(g/L)</label> <input type="text" class="in" name="rongZhong" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.rongZhong}"/></div>
        <div class="nn"><label>出糙率(%)</label> <input type="text" class="in" name="chuCaoLu" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.chuCaoLu}"/></div>
        <div class="nn"><label>水分(%)</label> <input type="text" class="in" name="shuiFen"  data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.shuiFen}"/></div>
        <div class="nn"><label>杂质(%)</label> <input type="text" class="in" name="zaZhi" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.zaZhi}"/></div>
        <div class="nn"><label>脂肪酸值</label> <input type="text" class="in" name="ziFanSuaZhi" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.ziFanSuaZhi}"/></div>
        <div class="nn"><label>黄粒米(%)</label> <input type="text" class="in" name="huanLieMi" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.huanLieMi}"/></div>
        <div class="nn"><label>整精米率(%)</label> <input type="text" class="in" name="zenJinMiLu" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.zenJinMiLu}"/></div>
        <div class="nn"><label>谷外糙米(%)</label> <input type="text" class="in" name="guWaiCaoMi" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.guWaiCaoMi}"/></div>
        <div class="nn"><label>不完善粒(%)</label> <input type="text" class="in" name="buWanSanLi" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.buWanSanLi}"/></div>
        <div class="nn"><label>面筋吸水量(%)</label> <input type="text" class="in" name="mjXiShuiLian" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.mjXiShuiLian}"/></div>
        <div class="nn"><label>硬度指数</label> <input type="text" class="in" name="yinDuZhiShu" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.yinDuZhiShu}"/></div>
        <div class="nn"><label>互混率(%)</label> <input type="text" class="in" name="huHunLu" data-rule="num" data-rule-num="[/^\d{1,4}|(\.)\d{1,2}$/,'整数或小数']" data-ok="" value="${tfBarnShiwu.huHunLu}"/></div>
        <div class="clr"></div>
        </div>
      <div class="box_bottom"></div>
    </div><!--content e-->
    <div class="dao"><a href="javascript:;" title="导出" class="export-btn"></a></div>
    <div class="save v_s"> <a href="javascript:;" title="保存" class="submit-btn"></a></div>    
  </div><!--main e-->
</form>
<script type="text/javascript">
	$(function(){
		$(":input").inputmask();
		
		$('body').on('click','a.export-btn',function(e){
			e.preventDefault();
			var api = frameElement.api, W = api.opener;
			id = $('input[name=\'id\']').val();
			if(id != undefined){
				$('#exportFrom').attr('action','tfBarnShiwuController.do?export&id='+id);
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
		
		$('#inputFrom').validator({
			//验证成功
		    valid: function(form) {
		    	var params = $(form).serialize();
		    	$.post('tfBarnShiwuController.do?save',params,function(result){
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