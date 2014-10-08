<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<body>
<div class="wrapper2">
<form id="exportFrom" method="post"></form>
<form id="inputFrom"  method="post" data-validator-option="{theme:'yellow_right_effect',stopOnError:true,timely:2}" >
<c:if test="${tfLiaqin.id != null}"><input type="hidden" name="id" value="${tfLiaqin.id}"/></c:if>
<c:if test="${tfLiaqin.tfBarnId != null}"><input type="hidden" name="tfBarnId" value="${tfLiaqin.tfBarnId}"/></c:if>
<div class="main" style="background:none;">
   <div class="main_center" id="d1" style="display:block;">
   <div class="m_right">
     <div class="Tab">
       <div class="Tab_bg">
         <table cellpadding="0" cellspacing="0" width="100%">
         <tr>
           <td height="40" width="10%" class="T_R">仓房编号</td>
           <td width="40%" colspan="5" >
           <input type="text"  style="width:100%" id="barnNo" class="T_C" readonly="readonly" data-rule="required;" value="${tfBarn.barnNo}"/>
           </td>
           <td width="10%" class="T_R">实际数量</td>
           <td width="40%" colspan="5" >
           <input type="text"  style="width:80%" id="number" readonly="readonly" class="T_C" readonly="readonly" data-inputmask="'mask': '[9999]'" data-rule="required;" value="${tfBarnShiwu.number}"/>
           <label>吨</label></td>
         </tr>
         <tr>
           <td height="40" width="10%" class="T_R">水分</td>
           <td width="10%"><input type="text"  style="width:70%" class="T_C" name="shuiFen"  data-rule="required;" value="${tfLiaqin.shuiFen}"/><label>%</label></td>
           <td height="40" width="5%" class="T_R">杂质</td>
           <td width="10%"><input type="text"  style="width:70%" class="T_C" name="zaZhi" data-rule="required;" value="${tfLiaqin.zaZhi}"/><label>%</label></td>
           <td height="40" width="5%" class="T_R">仓温</td>
           <td width="10%"><input type="text"  style="width:70%" class="T_C" name="canWen" data-rule="required;" value="${tfLiaqin.canWen}"/><label>%</label></td>
           <td height="40" width="10%" class="T_R">气温</td>
           <td width="10%"><input type="text"  style="width:70%" class="T_C" name="qiWen" data-rule="required;" value="${tfLiaqin.qiWen}"/><label>℃</label></td>
           <td height="40" width="5%" class="T_R">仓湿</td>
           <td width="10%"><input type="text"  style="width:90%" class="T_C" name="canShi" data-rule="required;" value="${tfLiaqin.canShi}"/><label>RH%</label></td>
           <td height="40" width="5%" class="T_R">气湿</td>
           <td width="10%"><input type="text"  style="width:90%" class="T_C" name="qiShi" data-rule="required;" value="${tfLiaqin.qiShi}"/><label>RH%</label></td>
         </tr>
         <tr>
           <td rowspan="4" class="T_R" width="10%" height="40">粮温检查情况</td>
           <td height="40" width="10%" class="T_R" align="center">部位</td>
           <td height="40" width="15%" class="T_R" colspan="2" align="center">上层</td>
           <td height="40" width="15%" class="T_R" colspan="2" align="center">中上层</td>
           <td height="40" width="20%" class="T_R"  colspan="2" align="center">中下层</td>
           <td height="40" width="15%" class="T_R"  colspan="2" align="center">下层</td>
           <td height="40" width="15%" class="T_R" colspan="2" align="center">整仓平均粮温</td>
         </tr>
         <tr>
           <td height="40" width="10%" class="T_R" align="center">最高</td>
           <td height="40" width="15%" colspan="2" >
           <input type="text"  style="width:70%" class="T_C" name="scZuiGaoWen" data-rule="required;" value="${tfLiaqin.scZuiGaoWen}"/><label>℃</label></td>
           <td height="40" width="15%" colspan="2" >
           <input type="text"  style="width:70%" class="T_C" name="zscZuiGaoWen" data-rule="required;" value="${tfLiaqin.zscZuiGaoWen}"/><label>℃</label></td>
           <td height="40" width="20%" colspan="2">
           <input type="text"  style="width:70%" class="T_C" name="zxcZuiGaoWen" value="${tfLiaqin.zxcZuiGaoWen}"/><label>℃</label></td>
           <td height="40" width="15%" colspan="2">
           <input type="text"  style="width:70%" class="T_C" name="xcZuiGaoWen" data-rule="required;" value="${tfLiaqin.xcZuiGaoWen}"/><label>℃</label></td>
           <td height="40" width="15%" colspan="2" rowspan="3" >
           <input type="text"  style="width:70%" class="T_C" name="zcPinJunWen" data-rule="required;" value="${tfLiaqin.zcPinJunWen}"/><label>℃</label></td>
         </tr>
         <tr>
           <td height="40" width="10%" class="T_R" align="center">最低</td>
           <td height="40" width="15%" colspan="2" >
           <input type="text"  style="width:70%" class="T_C" name="scZuiDiWen" data-rule="required;" value="${tfLiaqin.scZuiDiWen}"/><label>℃</label></td>
           <td height="40" width="15%" colspan="2" >
           <input type="text"  style="width:70%" class="T_C" name="zscZuiDiWen" data-rule="required;" value="${tfLiaqin.zscZuiDiWen}"/><label>℃</label></td>
           <td height="40" width="20%" colspan="2">
           <input type="text"  style="width:70%" class="T_C" name="zxcZuiDiWen" value="${tfLiaqin.zxcZuiDiWen}"/><label>℃</label></td>
           <td height="40" width="15%" colspan="2">
           <input type="text"  style="width:70%" class="T_C" name="xcZuiDiWen" data-rule="required;" value="${tfLiaqin.xcZuiDiWen}"/><label>℃</label></td>
         </tr>
         <tr>
           <td height="40" width="10%" class="T_R" align="center">平均</td>
           <td height="40" width="15%" colspan="2" >
           <input type="text"  style="width:70%" class="T_C" name="scPinJunWen" data-rule="required;" value="${tfLiaqin.scPinJunWen}"/><label>℃</label></td>
           <td height="40" width="15%" colspan="2" >
           <input type="text"  style="width:70%" class="T_C" name="zscPinJunWen" data-rule="required;" value="${tfLiaqin.zscPinJunWen}"/><label>℃</label></td>
           <td height="40" width="20%" colspan="2">
           <input type="text"  style="width:70%" class="T_C" name="zxcPinJunWen" value="${tfLiaqin.zxcPinJunWen}"/><label>℃</label></td>
           <td height="40" width="15%" colspan="2">
           <input type="text"  style="width:70%" class="T_C" name="xcPinJunWen" data-rule="required;" value="${tfLiaqin.xcPinJunWen}"/><label>℃</label></td>
         </tr>
         <tr>
           <td height="40" colspan="2" width="20%" class="T_R" align="center">虫害检测方式</td>
           <td colspan="3" width="20%" align="center">过筛检测&nbsp;<input type="checkbox" name="jiaCheFanS" value="GL" <c:if test="${fn:contains(tfLiaqin.jiaCheFanS, 'GL')}">checked="checked"</c:if>  data-rule="checked[2~]"/></td>
           <td colspan="3" width="30%" align="center">诱捕检测&nbsp;<input type="checkbox" name="jiaCheFanS" value="YB"  <c:if test="${fn:contains(tfLiaqin.jiaCheFanS, 'YB')}">checked="checked"</c:if> /></td>
           <td colspan="4" width="30%" align="center">空间检测&nbsp;<input type="checkbox" name="jiaCheFanS" value="KJ" <c:if test="${fn:contains(tfLiaqin.jiaCheFanS, 'KJ')}">checked="checked"</c:if>/></td>
         </tr>
         <tr>
           <td height="40" colspan="2" width="20%" class="T_R" align="center">虫害采样部位</td>
           <td colspan="10" width="80%">仓房四角&nbsp;<input type="checkbox" name="caiYanBuWei" value="CFSJ" <c:if test="${fn:contains(tfLiaqin.caiYanBuWei, 'CFSJ')}">checked="checked"</c:if>  data-rule="checked"/>
           	、进出门&nbsp;<input type="checkbox" name="caiYanBuWei" value="JCM" <c:if test="${fn:contains(tfLiaqin.caiYanBuWei, 'JCM')}">checked="checked"</c:if>/>
           	、窗户口&nbsp;<input type="checkbox" name="caiYanBuWei" value="CHK" <c:if test="${fn:contains(tfLiaqin.caiYanBuWei, 'CHK')}">checked="checked"</c:if>/>
           	、通风道口&nbsp;<input type="checkbox" name="caiYanBuWei" value="TFDK" <c:if test="${fn:contains(tfLiaqin.caiYanBuWei, 'TFDK')}">checked="checked"</c:if>/>
           	、沿墙&nbsp;<input type="checkbox" name="caiYanBuWei" value="YQ" <c:if test="${fn:contains(tfLiaqin.caiYanBuWei, 'YQ')}">checked="checked"</c:if>/>
           	、扇墙&nbsp;<input type="checkbox" name="caiYanBuWei" value="SQ" <c:if test="${fn:contains(tfLiaqin.caiYanBuWei, 'SQ')}">checked="checked"</c:if>/>
           	、粮堆中间&nbsp;<input type="checkbox" name="caiYanBuWei" value="LDZJ" <c:if test="${fn:contains(tfLiaqin.caiYanBuWei, 'LDZJ')}">checked="checked"</c:if>/></td>
         </tr>
         <tr>
           <td height="40" colspan="2" width="20%" class="T_R" align="center">检测部位数量</td>
           <td width="15%" colspan="2" ><input type="text"  style="width:70%" class="T_C" name="jiaCheNum" value="${tfLiaqin.jiaCheNum}"/><label>个</label></td>
           <td  width="15%" colspan="2" class="T_R" align="center">发现虫害部位</td>
           <td width="20%" colspan="2"><input type="text"  style="width:70%" class="T_C" name="choHaiBuWei" value="${tfLiaqin.choHaiBuWei}"/><label>个</label></td>
           <td width="15%" colspan="2" class="T_R" align="center">虫害位置分布</td>
           <td width="15%" colspan="2"><input type="text"  style="width:80%" class="T_C" name="choHaiFenBu" value="${tfLiaqin.choHaiFenBu}"/></td>
         </tr>
         <tr>
           <td height="40" colspan="2" width="20%" class="T_R" align="center">具体虫害名称</td>
           <td width="80%" colspan="10" ><input type="text"  style="width:90%" class="T_C" name="choHaiName" value="${tfLiaqin.choHaiName}"/></td>
         </tr>
         <tr>
           <td height="40" width="20%" colspan="2" class="T_R" align="center">害虫密度</td>
           <td width="30%" colspan="4" ><input type="text"  style="width:70%" class="T_C" name="haiChoMiDu" value="${tfLiaqin.haiChoMiDu}"/><label>头/kg</label></td>
           <td width="20%" colspan="2" class="T_R" align="center">主要害虫密度</td>
           <td width="30%" colspan="4" ><input type="text"  style="width:70%" class="T_C" name="zhaiChoMiDu" value="${tfLiaqin.zhaiChoMiDu}"/><label>头/kg</label></td>
         </tr>
         <tr>
           <td height="40" colspan="2" width="20%" class="T_R" align="center">判定虫粮等级</td>
           <td width="40%" colspan="5" >基本无虫粮&nbsp;<input type="radio" name="choLiaLevel" value="0" <c:if test="${fns:splitString(tfLiaqin.choLiaLevel,0)==0}">checked="checked"</c:if> data-rule="checked"/>；一般虫粮&nbsp;<input type="radio" name="choLiaLevel" value="1" <c:if test="${fns:splitString(tfLiaqin.choLiaLevel,0)==1}">checked="checked"</c:if>/>；严重虫粮&nbsp;<input type="radio" name="choLiaLevel" value="2" <c:if test="${fns:splitString(tfLiaqin.choLiaLevel,0)==2}">checked="checked"</c:if>/></td>
           <td width="15%" colspan="2" class="T_R" align="center">熏蒸措施</td>
           <td width="25%" colspan="3">已熏蒸&nbsp;<input type="radio" name="xunZhenCuoS" value="1" <c:if test="${fns:splitString(tfLiaqin.xunZhenCuoS,0)==1}">checked="checked"</c:if> data-rule="checked"/>；未熏蒸&nbsp;<input type="radio" name="xunZhenCuoS" value="0" <c:if test="${fns:splitString(tfLiaqin.xunZhenCuoS,0)==0}">checked="checked"</c:if>/></td>
         </tr>
         <tr>
           <td height="40" colspan="2" width="20%" class="T_R" align="center">粮情变化情况</td>
           <td width="80%" colspan="10" >粮食有无发现发热，有
           <input type="checkbox" name="liaQiQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.liaQiQiKua,0)==1}">checked="checked"</c:if>  data-rule="checked[2~]"/>
            	 无<input type="checkbox" name="liaQiQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.liaQiQiKua,0)==0}">checked="checked"</c:if>/>;粮食有无发现霉变，有
            	 <input type="checkbox" name="liaQiQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.liaQiQiKua,1)==1}">checked="checked"</c:if>/>
            	 无<input type="checkbox" name="liaQiQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.liaQiQiKua,1)==0}">checked="checked"</c:if>/>
           </td>
         </tr>
         <tr>
           <td height="40" colspan="2" width="20%" class="T_R" align="center" rowspan="3">仓房安全情况</td>
           <td width="80%" height="40" colspan="10" style="font-size:12px" >顶棚有无发现渗漏，有<input type="checkbox" name="anQuanQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,0)==1}">checked="checked"</c:if> data-rule="checked[9~]"/>
             无
             <input type="checkbox" name="anQuanQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,0)==0}">checked="checked"</c:if>/>
             ;墙体、地坪有无发现渗漏，有<input type="checkbox" name="anQuanQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,1)==1}">checked="checked"</c:if>/>
             无
             <input type="checkbox" name="anQuanQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,1)==0}">checked="checked"</c:if>/>
             ;门窗有无发现渗漏，有<input type="checkbox" name="anQuanQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,2)==1}">checked="checked"</c:if>/>
             无             <input type="checkbox" name="anQuanQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,2)==0}">checked="checked"</c:if>/></td>
         </tr>
         <tr>
           <td width="80%" height="40" colspan="10" style="font-size:12px" >顶棚有无发现裂缝，有<input type="checkbox" name="anQuanQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,3)==1}">checked="checked"</c:if>/>
             无
             <input type="checkbox" name="anQuanQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,3)==0}">checked="checked"</c:if>/>
             ;墙体、地坪有无发现裂缝，有<input type="checkbox" name="anQuanQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,4)==1}">checked="checked"</c:if>/>
             无
             <input type="checkbox" name="anQuanQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,4)==0}">checked="checked"</c:if>/>
             ;门窗有无发现裂缝，有<input type="checkbox" name="anQuanQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,5)==1}">checked="checked"</c:if>/>
             无             <input type="checkbox" name="anQuanQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,5)==0}">checked="checked"</c:if>/></td>
         </tr>
         <tr>
           <td width="80%" height="40" colspan="10" style="font-size:12px" >仓内照明是否故障，有<input type="checkbox" name="anQuanQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,6)==1}">checked="checked"</c:if>/>
             无
             <input type="checkbox" name="anQuanQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,6)==0}">checked="checked"</c:if>/>
             ;上下楼梯是否安全，有<input type="checkbox" name="anQuanQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,7)==1}">checked="checked"</c:if>/>
             无
             <input type="checkbox" name="anQuanQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,7)==0}">checked="checked"</c:if>/>
             ;辅助设施是否完好，有<input type="checkbox" name="anQuanQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,8)==1}">checked="checked"</c:if>/>
             无             <input type="checkbox" name="anQuanQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.anQuanQiKua,8)==0}">checked="checked"</c:if>/></td>
         </tr>
         <tr>
           <td height="40" colspan="2" width="20%" class="T_R" align="center">仓房清卫情况</td>
           <td width="80%" colspan="10" style="font-size:12px" >仓内有无发现鼠雀，有<input type="checkbox" name="qinWeiQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.qinWeiQiKua,0)==1}">checked="checked"</c:if> data-rule="checked[3~]"/>
             无
             <input type="checkbox" name="qinWeiQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.qinWeiQiKua,0)==0}">checked="checked"</c:if>/>
             ;仓内有无发现蛛网，有<input type="checkbox" name="qinWeiQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.qinWeiQiKua,1)==1}">checked="checked"</c:if>/>
             无
             <input type="checkbox" name="qinWeiQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.qinWeiQiKua,1)==0}">checked="checked"</c:if>/>
             ;清洁卫生是否达标，有<input type="checkbox" name="qinWeiQiKua" value="1" <c:if test="${fns:splitString(tfLiaqin.qinWeiQiKua,2)==1}">checked="checked"</c:if>/>
             无             <input type="checkbox" name="qinWeiQiKua" value="0" <c:if test="${fns:splitString(tfLiaqin.qinWeiQiKua,2)==0}">checked="checked"</c:if>/></td>
         </tr>
         <tr>
           <td height="40" colspan="2" width="20%" class="T_R" align="center">检查情况评估</td>
           <td width="80%" colspan="10" >粮情稳定，储存安全<input type="radio" name="qiKuaPinGu" value="0" <c:if test="${fns:splitString(tfLiaqin.qiKuaPinGu,0)==0}">checked="checked"</c:if> data-rule="checked"/>；粮情异常，急需妥善处理<input type="radio" name="qiKuaPinGu" value="1" <c:if test="${fns:splitString(tfLiaqin.qiKuaPinGu,0)==1}">checked="checked"</c:if>/></td>
         </tr>
         <tr>
           <td height="40" colspan="2" width="20%" class="T_R" align="center">检查性质</td>
           <td width="80%" colspan="10" >上级单位检查&nbsp;<input type="checkbox" name="jiaChaXinZhi" value="SJDW" <c:if test="${fn:contains(tfLiaqin.jiaChaXinZhi, 'SJDW')}">checked="checked"</c:if> data-rule="checked"/>；月普查&nbsp;<input type="checkbox" name="jiaChaXinZhi" value="YPC" <c:if test="${fn:contains(tfLiaqin.jiaChaXinZhi, 'YPC')}">checked="checked"</c:if>/>;季鉴定&nbsp;<input type="checkbox" name="jiaChaXinZhi" value="JJD" <c:if test="${fn:contains(tfLiaqin.jiaChaXinZhi, 'JJD')}">checked="checked"</c:if>/>;保管员自查&nbsp;<input type="checkbox" name="jiaChaXinZhi" value="ZC" <c:if test="${fn:contains(tfLiaqin.jiaChaXinZhi, 'ZC')}">checked="checked"</c:if>/></td>
         </tr>
         <tr>
           <td height="40" colspan="2" width="20%" class="T_R" align="center">备注</td>
           <td width="80%" colspan="10" ><textarea rows="2" cols="50" style="border:none" name="beiZhu">${tfLiaqin.beiZhu}</textarea></td>
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
	    	$.post('tfLiaqinController.do?save',params,function(result){
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