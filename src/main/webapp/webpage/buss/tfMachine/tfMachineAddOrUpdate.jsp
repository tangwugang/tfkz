<%@page import="java.util.List"%>
<%@page import="org.takinframework.web.buss.entity.TfBarnDevices"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
<!-- 计算设备型号、功率和数量 开始 -->
<% List<TfBarnDevices> tfBarnDevices = (List<TfBarnDevices>)request.getAttribute("tfBarnDevices");
int num = 0;if(null != tfBarnDevices && tfBarnDevices.size()>0){for(int i=0;i<tfBarnDevices.size();i++) {
TfBarnDevices devs = tfBarnDevices.get(i);
if(devs.getType() == 0){ ++num;%>
<c:set var="version" value="<%=devs.getVersion() %>"></c:set>
<c:set var="power" value="<%=devs.getPower() %>"></c:set>
<%}}} %>
<c:set var="num" value="<%=num%>"></c:set>
<!-- 计算设备型号、功率和数量 结束 -->
<div class="wrapper2">
<form id="exportFrom" method="post"></form>
<form id="inputFrom"  method="post" data-validator-option="{theme:'yellow_right_effect',stopOnError:true,timely:2}" >
<c:if test="${tfMachine.id != null}"><input type="hidden" name="id" value="${tfMachine.id}"/></c:if>
<c:if test="${tfMachine.tfBarnId != null}"><input type="hidden" name="tfBarnId" value="${tfMachine.tfBarnId}"/></c:if>
<div class="main" style="background:none;">
   <div class="main_center" id="d1" style="display:block;">
   <div class="m_right">
   	<div class="Tab">
       <div class="Tab_bg">
         <table cellpadding="0" cellspacing="0" width="100%">
         <tr>
           <td height="35" width="160" class="T_R" colspan="2">粮食品种</td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="liaShiPinZh" value="${tfBarnShiwu.liaShiPinZh}" readonly="readonly" data-rule="required;" /></td>
           <td colspan="2" width="160" class="T_R">实际数量（t）</td>
           <td width="160" class="T_C"><input type="text" class="T_C" name="number"  value="${tfBarnShiwu.number}" data-inputmask="'mask': '[9999]'" readonly="readonly" data-rule="required;" /></td>
         </tr>
         <tr>
           <td height="30" width="160" class="T_R" colspan="2">通风目的</td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="tfMuDi" value="${fns:getTfMuDi(tfMachine.tfGuiZeId)}" readonly="readonly" data-rule="required;" /></td>
           <td colspan="2" width="160" class="T_R">堆粮高度（m）</td>
           <td width="160" class="T_C"><input name="duiLianGaoDu" value="${tfMachine.duiLianGaoDu}" data-inputmask="'mask': '[9.9]'" data-rule="required;num" data-rule-num="[/^\d{1}(\.)\d{1}$/,'格式不对']" /></td>
         </tr>
         <tr>
           <td height="30" width="160" class="T_R" colspan="2">堆粮体积（m³）</td>
           <td colspan="2" width="160" class="T_C"><input name="lianDuiVol" value="${tfMachine.lianDuiVol}"  data-rule="required;num" data-rule-num="[/^\d{1,4}(\.)\d{1}$/,'格式不对']"/></td>
           <td colspan="2" width="160" class="T_R">风机型号</td>
           <td width="160" class="T_C">${version}</td>
         </tr>
         <tr>
           <td height="30" width="160" class="T_R" colspan="2">风机功率（KW）</td>
           <td colspan="2" width="160" class="T_C">${power}</td>
           <td colspan="2" width="160" class="T_R">风机数量（台）</td>
           <td width="160" class="T_C">${num}</td>
         </tr>
         <tr>
           <td height="30" width="160" class="T_R" colspan="2">总风量（m³/h）</td>
           <td colspan="2" width="160" class="T_C"><input name="zonFenLia" value="${tfMachine.zonFenLia}"  data-rule="required;integer"/></td>
           <td colspan="2" width="160" class="T_R">风道类型</td>
           <td width="160" class="T_C">${tfBarn.fenDaoType}</td>
         </tr>
         <tr>
           <td height="30" width="160" class="T_R" colspan="2">风网布置</td>
           <td colspan="2" width="160" class="T_C"><input name="fenWanBuZhi" value="${tfMachine.fenWanBuZhi}"  data-rule="required"/></td>
           <td colspan="2" width="160" class="T_R">风道数量（条）</td>
           <td width="160" class="T_C"><input name="fenDaoNum" value="${tfMachine.fenDaoNum}"  data-rule="required;integer"/></td>
         </tr>
         <tr>
           <td height="30" width="160" class="T_R" colspan="2">风道间距（m）</td>
           <td colspan="2" width="160" class="T_C"><input name="fenDaoStep" value="${tfMachine.fenDaoStep}"  data-rule="required;num" data-rule-num="[/^\d{1,4}(\.)\d{1}$/,'格式不对']"/></td>
           <td colspan="2" width="160" class="T_R">单位通风量（m³/h.t）</td>
           <td width="160" class="T_C"><input name="unitTonFenVol" value="${tfMachine.unitTonFenVol}"  data-rule="required;num" data-rule-num="[/^\d{1,4}(\.)\d{1}$/,'格式不对']"/></td>
         </tr>
         <tr>
           <td height="30" width="160" class="T_R" colspan="2">通风方式（吸/压）</td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="cfMode" value="${tfMachine.cfMode}"/></td>
           <td colspan="2" width="160" class="T_R">空气途径比</td>
           <td width="160" class="T_C"><input name="konQiTuJinBi" value="${tfMachine.konQiTuJinBi}"  data-rule="required;num" data-rule-num="[/^\d{1,4}(\.)\d{1}$/,'格式不对']"/></td>
         </tr>
         <tr>
           <td height="30" width="160" class="T_R" colspan="2">开始通风时间</td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="stTonFenTime" value="${tfMachine.stTonFenTime}" readonly="readonly" data-rule="required;"/></td>
           <td colspan="2" width="160" class="T_R">停止通风时间</td>
           <td width="160" class="T_C"><input type="text" class="T_C" name="enTonFenTime" value="${tfMachine.enTonFenTime}" readonly="readonly" data-rule="required;"/></td>
         </tr>
         <tr>
           <td height="30" width="160" class="T_R" colspan="2">累计通风时间（h）</td>
           <td colspan="5" width="160" class="T_C"><input type="text" class="T_C" name="tonFenTime" value="${tfMachine.tonFenTime}" readonly="readonly" data-rule="required;"/></td>
         </tr>
         <tr>
           <td height="35" width="160" class="T_R" colspan="2">通风期间参数</td>
           <td colspan="2" width="160" class="T_R">最高值</td>
           <td colspan="2" width="160" class="T_R">最低值</td>
           <td width="160" class="T_R">平均值</td>
         </tr>
         <tr>
           <td height="35" width="160" class="T_R" colspan="2">大气温度（℃）</td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="daQiWenDuHi" value="${tfMachine.daQiWenDuHi}" readonly="readonly" data-rule="required;"/></td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="daQiWenDuLo" value="${tfMachine.daQiWenDuLo}" readonly="readonly" data-rule="required;"/></td>
           <td width="160" class="T_C"><input type="text" class="T_C" name="daQiWenDuAv" value="${tfMachine.daQiWenDuAv}" readonly="readonly" data-rule="required;"/></td>
         </tr>
         <tr>
           <td height="35" width="160" class="T_R" colspan="2">大气湿度（RH%）</td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="daQiShiDuHi" value="${tfMachine.daQiShiDuHi}" readonly="readonly" /></td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="daQiShiDuLo" value="${tfMachine.daQiShiDuLo}" readonly="readonly" /></td>
           <td width="160" class="T_C"><input type="text" class="T_C" name="daQiShiDuAv" value="${tfMachine.daQiShiDuAv}" readonly="readonly" /></td>
         </tr>
         <tr>
           <td width="110" class="T_R" rowspan="2" >粮食温度（℃）</td>
           <td class="T_R" width="50" height="35">通风前</td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="liaWenStartHi" value="${tfMachine.liaWenStartHi}" readonly="readonly" /></td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="liaWenStartLo" value="${tfMachine.liaWenStartLo}" readonly="readonly" /></td>
           <td width="160" class="T_C"><input type="text" class="T_C" name="liaWenStartAv" value="${tfMachine.liaWenStartAv}" readonly="readonly" /></td>
         </tr>
         <tr>
           <td class="T_R" width="50" height="35">通风后</td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="liaWenEndHi" value="${tfMachine.liaWenEndHi}" readonly="readonly" /></td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="liaWenEndLo" value="${tfMachine.liaWenEndLo}" readonly="readonly" /></td>
           <td width="160" class="T_C"><input type="text" class="T_C" name="liaWenEndAv" value="${tfMachine.liaWenEndAv}" readonly="readonly" /></td>
         </tr>
         <tr>
           <td width="110" class="T_R" rowspan="2" >粮食水份（%）</td>
           <td class="T_R" width="50" height="35">通风前</td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="suiFenStartHi" value="${tfMachine.suiFenStartHi}" readonly="readonly" /></td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="suiFenStartLo" value="${tfMachine.suiFenStartLo}" readonly="readonly" /></td>
           <td width="160" class="T_C"><input type="text" class="T_C" name="suiFenStartAv" value="${tfMachine.suiFenStartAv}" readonly="readonly" /></td>
         </tr>
         <tr>
           <td class="T_R" width="50" height="35">通风后</td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="suiFenEndHi" value="${tfMachine.suiFenEndHi}" readonly="readonly" /></td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="suiFenEndLo" value="${tfMachine.suiFenEndLo}" readonly="readonly" /></td>
           <td width="160" class="T_C"><input type="text" class="T_C" name="suiFenEndAv" value="${tfMachine.suiFenEndAv}" readonly="readonly" /></td>
         </tr>
         <tr>
           <td height="35" width="160" class="T_R" colspan="2">总电耗（kW.h）</td>
           <td colspan="2" width="160" class="T_C"><input type="text" class="T_C" name="power" value="${tfMachine.power}" readonly="readonly" data-rule="required;"/></td>
           <td colspan="2" width="160" class="T_R">单位能耗（kw·h/℃·t或kw·h/l%水分·t）</td>
           <td width="160" class="T_C"><input type="text" class="T_C" name="unitPower" value="${tfMachine.unitPower}" readonly="readonly" data-rule="required;"/></td>
         </tr>
         <tr>
           <td height="35" width="160" class="T_R" colspan="2">备注</td>
           <td colspan="5" class="T_C"><input type="text" class="T_C" name="beiZhui" value="${tfMachine.beiZhui}" /></td>
         </tr>
         </table>
       </div>
     </div>
   </div><!--m_right e-->
   </div><!--main_center e-->
   <div class="clr"></div>
</div><!--main e-->
<button id="submit-btn" class="submit-btn" type="submit"></button>
</form>
<script type="text/javascript">
	$(":input").inputmask();
	
	$('#inputFrom').validator({
		//验证成功
	    valid: function(form) {
	    	var params = $(form).serialize();
	    	$.post('tfMachineController.do?save',params,function(result){
	    		var result = $.parseJSON(result);
	    		var api = parent.frameElement.api, W = api.opener;
            	if(result.success == false){
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
            	}else{
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
            		setTimeout(function(){parent.location.reload();},1000);
            	}
	    	});
	    }
	})
</script>
</body>