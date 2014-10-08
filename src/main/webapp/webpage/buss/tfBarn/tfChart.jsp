<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../common/head.jsp"%>
<script src="plug-in/FusionCharts/FusionCharts.js"></script>
<script src="plug-in/FusionCharts/FusionChartsExportComponent.js"></script>
<script src="plug-in/jquery/jquery.jSelectDate.js"></script>
<body>
<div class="wrapper2">
<form id="exportFrom" method="post"></form>
<div class="main" style="background:none;">
   <div class="main_top">
     <ul>
       <li><a href="tfBarnController.do?tfLiaqin&id=${tfBarn.id}" id="l_1"  onfocus="this.blur();" >粮情检查记录</a></li>
       <li><a href="tfBarnController.do?tfMachine&id=${tfBarn.id}" id="l_2"  onfocus="this.blur();">机械通风记录</a></li>
       <li><a href="tfBarnController.do?tfChart&id=${tfBarn.id}" id="l_3"  onfocus="this.blur();"   class="current">三温图</a></li>
     </ul>
     <div class="main_rg" data-no="${tfBarn.barnNo}"></div>
   </div>
   <div class="sw_choose"><input type="text" id="year" class="date" value='2014'/>&nbsp;&nbsp;&nbsp;<input type="radio" name="time" value="0" checked="checked"/>上半年&nbsp;&nbsp;&nbsp;<input type="radio" name="time" value="1"/>下半年<input type="hidden" name="date" /></div>
   <div class="sw_info"><span style="border-bottom:3px #1d8bd1 solid;"></span><label>粮温</label><span style="border-bottom:1px #404040 solid;"></span><label>气温</label><span  style="border-bottom:3px #f1683c dashed;"></span><label>仓温</label></div>
   <div  id="main" style="width:900px;" align="center">
   </div><!--main_center e-->
</div><!--main e-->
<script type="text/javascript">

	$('input.date').jSelectDate({
		 css:"date",
		 yearBegin:2010,
		 isShowMonthDay:false
	});


	$.ajax({
		url: "tfLiaqinController.do?chartXml",
        type: 'POST',
        data: "tfBarnId=${tfBarn.id}",
        success: function(result){
        	var api = frameElement.api, W = api.opener;
        	result = $.parseJSON(result);
        	if(result.success == true){
        		creatChart(result.obj);
        	}else{
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
        	}
        }
	});
	
	function creatChart(dataXml){
		var myChart = new FusionCharts("plug-in/FusionCharts/MSLine.swf", "myChartId", "860", "900");
		myChart.setDataXML(dataXml);
		myChart.configure("ChartNoDataText", "没有显示数据");
		myChart.configure("InvalidXMLText", "请验证数据");
		myChart.render("main");
	}
	
	$('select.date').change(function(){
		var year = $('#year').val();
		$.ajax({
			url: "tfLiaqinController.do?chartXml",
	        type: 'POST',
	        data: "tfBarnId=${tfBarn.id}&year="+year+"&time="+$('input[name="date"]').val(),
	        success: function(result){
	        	var api = frameElement.api, W = api.opener;
	        	result = $.parseJSON(result);
	        	if(result.success == true){
	        		creatChart(result.obj);
	        	}else{
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
	        	}
	        }
		});
	});
	
	$('input[name="time"]').change(function(){
		$('input[name="date"]').val($(this).val());
		var year = $('#year').val();
		$.ajax({
			url: "tfLiaqinController.do?chartXml",
	        type: 'POST',
	        data: "tfBarnId=${tfBarn.id}&year="+year+"&time="+$(this).val(),
	        success: function(result){
	        	var api = frameElement.api, W = api.opener;
	        	result = $.parseJSON(result);
	        	if(result.success == true){
	        		creatChart(result.obj);
	        	}else{
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
	        	}
	        }
		});
	});


	//var myChart = new FusionCharts("plug-in/FusionCharts/MSLine.swf", "myChartId", "900", "1080");
	//<chart outCnvBaseFontSize='8.5' divLineAlpha='100'  canvasBorderColor='000000' canvasBorderThickness='0'  showalternatevgridcolor='0' showalternatehgridcolor='0' bgcolor='ffffff' divlineisdashed='1' divlinedashlen='1'  showLegend='0' formatNumberScale='0' numberSuffix='℃' numdivlines='44' showhovercap='1' showNames='1' showValues='0' numVDivLines='26' rotateNames='0' showPrintMenuItem='0' exportEnabled='1' aboutMenuItemLabel='浙江省粮食局直属库' exportAtClient='0' exportHandler='FCExporter' exportAction='save' exportCallback='chartCallback' exportDialogMessage='正在生成,请稍候...' exportFormats='PNG=生成PNG图片' exportFileName='barn'>
	/*myChart.setDataXML("<chart  chartTopMargin='0' chartRightMargin='2' yAxisMinValue='-4' chartLeftMargin='40'  outCnvBaseFontSize='8.5' divLineAlpha='100'  canvasBorderColor='000000' canvasBorderThickness='0'  showalternatevgridcolor='0' showalternatehgridcolor='0' bgcolor='ffffff' divlineisdashed='1' divlinedashlen='1'  showLegend='0' formatNumberScale='0' numberSuffix='℃'  showhovercap='1' showNames='1' showValues='0' numdivlines='44' numVDivLines='25' rotateNames='0' showPrintMenuItem='0' exportEnabled='1' aboutMenuItemLabel='浙江省粮食局直属库' aboutMenuItemLink='http://www.512u.com/index1.do' exportAtClient='0' exportHandler='FCExporter' exportAction='save' exportCallback='chartCallback' exportDialogMessage='正在生成,请稍候...' exportFormats='PNG=生成PNG图片' exportFileName='barn'>"+
			"<categories><category name='1.7' /><category name='1.14' /><category name='1.21' /><category name='1.28' /><category name='2.4' /><category name='2.11' /><category name='2.18' />"+
			"<category name='2.25' /><category name='3.4' /><category name='3.11' /><category name='3.18' /><category name='3.25' /><category name='4.1' /><category name='4.8' />"+
			"<category name='4.15' /><category name='4.22' /><category name='4.29' /><category name='5.6' /><category name='5.13' /><category name='5.20' /><category name='5.27' />"+
			"<category name='6.3' /><category name='6.10' /><category name='6.17' /><category name='6.24' /><category name='7.1' /><category name='' /></categories>"+
			"<dataset seriesName='粮温' color='F1683C' anchorBorderColor='F1683C' anchorBgColor='F1683C' dashed='1'>"+
			 "<set value='13' />"+
			 "<set value='18' />"+
			 "<set value='16' />"+
			 "<set value='15' />"+
			 "<set value='19' />"+
			 "<set value='19' />"+
			 "<set value='12' />"+
			 "<set value='13' />"+
			 "<set value='18' />"+
			 "<set value='16' />"+
			 "<set value='15' />"+
			 "<set value='19' />"+
			 "<set value='19' />"+
			 "<set value='12' />"+
			 "<set value='13' />"+
			 "<set value='18' />"+
			 "<set value='16' />"+
			 "<set value='15' />"+
			 "<set value='19' />"+
			 "<set value='19' />"+
			 "<set value='12' />"+
			 "<set value='13' />"+
			 "<set value='18' />"+
			 "<set value='16' />"+
			 "<set value='15' />"+
			 "<set value='18' />"+
			 "</dataset>"+
			"<dataset seriesName='仓温' color='1D8BD1' anchorBorderColor='1D8BD1' anchorBgColor='1D8BD1'>"+
			 "<set value='20' />"+
			 "<set value='32' />"+
			 "<set value='29' valuePosition='12' />"+
			 "<set value='31' />"+
			 "<set value='28' />"+
			 "<set value='35' />"+
			 "<set value='18' />"+
			 "<set value='13' />"+
			 "<set value='18' />"+
			 "<set value='16' />"+
			 "<set value='15' />"+
			 "<set value='19' />"+
			 "<set value='19' />"+
			 "<set value='12' />"+
			 "<set value='13' />"+
			 "<set value='18' />"+
			 "<set value='16' />"+
			 "<set value='15' />"+
			 "<set value='19' />"+
			 "<set value='19' />"+
			 "<set value='12' />"+
			 "<set value='13' />"+
			 "<set value='18' />"+
			 "<set value='16' />"+
			 "<set value='15' />"+
			 "<set value='19' />"+
			"</dataset>"+
			"<dataset seriesName='气温' color='000000' anchorBorderColor='000000' anchorBgColor='000000' lineThickness='0.1'>"+
			 "<set value='24' />"+
			 "<set value='35' />"+
			 "<set value='19' />"+
			 "<set value='36' />"+
			 "<set value='38' />"+
			 "<set value='40' />"+
			 "<set value='28' />"+
			 "<set value='23' />"+
			 "<set value='28' />"+
			 "<set value='36' />"+
			 "<set value='15' />"+
			 "<set value='19' />"+
			 "<set value='19' />"+
			 "<set value='12' />"+
			 "<set value='13' />"+
			 "<set value='28' />"+
			 "<set value='16' />"+
			 "<set value='15' />"+
			 "<set value='29' />"+
			 "<set value='19' />"+
			 "<set value='12' />"+
			 "<set value='13' />"+
			 "<set value='28' />"+
			 "<set value='26' />"+
			 "<set value='35' />"+
			 "<set value='29' />"+
			"</dataset>"+
			"</chart>");*/
	//myChart.render("main");
	//导出图片后调用的回调函数
	function chartCallback(objRtn){
		var api = frameElement.api, W = api.opener;
		if(objRtn.statusCode == "1"){
			W.$.dialog.confirm('生成图片成功,你确定要导出吗？', function(){
				var barnNo = $(".main_rg").data("no");
				$('<input type="hidden" name="imgName" value='+objRtn.fileName+'/>').appendTo($('#exportFrom'));
				$('#exportFrom').attr('action','tfBarnController.do?chartExp&barnNo='+barnNo);
				$('#exportFrom').submit();
			});
		}else{
			W.$.dialog({
    			id:'alert',
				title:'提示',
				time:3,
				icon:'error.gif',
				content:'生成图片失败，描述：'+objRtn.statusMessage,
				max:false,
		        min:false,
		        resize:false
			});
		}
	};
	
	//导出图片调用的方法
    function startExport(){
       var api = frameElement.api, W = api.opener;
       var chart = getChartFromId("myChartId");   //生成的FusionCharts图表本身的标识
       if (chart.hasRendered()){
           chart.exportChart();
       }else{
    	   setTimeout(function(){
    		   W.$.dialog.tips('正在加载,请稍候...',1,'loading.gif',function(){startExport();});
    		}, 1000 );
       }
    }
</script>
</body>