package org.apache.jsp.webpage.buss.tfBarn;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tfChart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getSysName", org.takinframework.web.util.WebUtil.class, "getSysName", new Class[] {java.lang.String.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/webpage/buss/tfBarn/../../common/head.jsp");
    _jspx_dependants.add("/context/mytags.jsp");
    _jspx_dependants.add("/WEB-INF/tld/takinui.tld");
    _jspx_dependants.add("/WEB-INF/tld/fns.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("  \r\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

      out.write('\n');
      //  c:set
      org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /context/mytags.jsp(10,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("webRoot");
      // /context/mytags.jsp(10,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(basePath);
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      out.write('\n');
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fns:getSysName('productName')}", java.lang.String.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false));
      out.write("</title>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("\t");
      if (_jspx_meth_t_005fbase_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<!-- END HEAD -->");
      out.write("\r\n");
      out.write("<script src=\"plug-in/FusionCharts/FusionCharts.js\"></script>\r\n");
      out.write("<script src=\"plug-in/FusionCharts/FusionChartsExportComponent.js\"></script>\r\n");
      out.write("<script src=\"plug-in/jquery/jquery.jSelectDate.js\"></script>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"wrapper2\">\r\n");
      out.write("<form id=\"exportFrom\" method=\"post\"></form>\r\n");
      out.write("<div class=\"main\" style=\"background:none;\">\r\n");
      out.write("   <div class=\"main_top\">\r\n");
      out.write("     <ul>\r\n");
      out.write("       <li><a href=\"tfBarnController.do?tfLiaqin&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"l_1\"  onfocus=\"this.blur();\" >粮情检查记录</a></li>\r\n");
      out.write("       <li><a href=\"tfBarnController.do?tfMachine&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"l_2\"  onfocus=\"this.blur();\">机械通风记录</a></li>\r\n");
      out.write("       <li><a href=\"tfBarnController.do?tfChart&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"l_3\"  onfocus=\"this.blur();\"   class=\"current\">三温图</a></li>\r\n");
      out.write("     </ul>\r\n");
      out.write("     <div class=\"main_rg\" data-no=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.barnNo}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"></div>\r\n");
      out.write("   </div>\r\n");
      out.write("   <div class=\"sw_choose\"><input type=\"text\" id=\"year\" class=\"date\" value='2014'/>&nbsp;&nbsp;&nbsp;<input type=\"radio\" name=\"time\" value=\"0\" checked=\"checked\"/>上半年&nbsp;&nbsp;&nbsp;<input type=\"radio\" name=\"time\" value=\"1\"/>下半年<input type=\"hidden\" name=\"date\" /></div>\r\n");
      out.write("   <div class=\"sw_info\"><span style=\"border-bottom:3px #1d8bd1 solid;\"></span><label>粮温</label><span style=\"border-bottom:1px #404040 solid;\"></span><label>气温</label><span  style=\"border-bottom:3px #f1683c dashed;\"></span><label>仓温</label></div>\r\n");
      out.write("   <div  id=\"main\" style=\"width:900px;\" align=\"center\">\r\n");
      out.write("   </div><!--main_center e-->\r\n");
      out.write("</div><!--main e-->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t$('input.date').jSelectDate({\r\n");
      out.write("\t\t css:\"date\",\r\n");
      out.write("\t\t yearBegin:2010,\r\n");
      out.write("\t\t isShowMonthDay:false\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl: \"tfLiaqinController.do?chartXml\",\r\n");
      out.write("        type: 'POST',\r\n");
      out.write("        data: \"tfBarnId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\",\r\n");
      out.write("        success: function(result){\r\n");
      out.write("        \tvar api = frameElement.api, W = api.opener;\r\n");
      out.write("        \tresult = $.parseJSON(result);\r\n");
      out.write("        \tif(result.success == true){\r\n");
      out.write("        \t\tcreatChart(result.obj);\r\n");
      out.write("        \t}else{\r\n");
      out.write("        \t\tW.$.dialog({\r\n");
      out.write("        \t\t\tid:'alert',\r\n");
      out.write("    \t\t\t\ttitle:'提示',\r\n");
      out.write("    \t\t\t\ttime:3,\r\n");
      out.write("    \t\t\t\ticon:'error.gif',\r\n");
      out.write("    \t\t\t\tcontent:result.msg,\r\n");
      out.write("    \t\t\t\tmax:false,\r\n");
      out.write("    \t\t        min:false,\r\n");
      out.write("    \t\t        resize:false\r\n");
      out.write("    \t\t\t});\r\n");
      out.write("        \t}\r\n");
      out.write("        }\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\tfunction creatChart(dataXml){\r\n");
      out.write("\t\tvar myChart = new FusionCharts(\"plug-in/FusionCharts/MSLine.swf\", \"myChartId\", \"860\", \"900\");\r\n");
      out.write("\t\tmyChart.setDataXML(dataXml);\r\n");
      out.write("\t\tmyChart.configure(\"ChartNoDataText\", \"没有显示数据\");\r\n");
      out.write("\t\tmyChart.configure(\"InvalidXMLText\", \"请验证数据\");\r\n");
      out.write("\t\tmyChart.render(\"main\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$('select.date').change(function(){\r\n");
      out.write("\t\tvar year = $('#year').val();\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl: \"tfLiaqinController.do?chartXml\",\r\n");
      out.write("\t        type: 'POST',\r\n");
      out.write("\t        data: \"tfBarnId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&year=\"+year+\"&time=\"+$('input[name=\"date\"]').val(),\r\n");
      out.write("\t        success: function(result){\r\n");
      out.write("\t        \tvar api = frameElement.api, W = api.opener;\r\n");
      out.write("\t        \tresult = $.parseJSON(result);\r\n");
      out.write("\t        \tif(result.success == true){\r\n");
      out.write("\t        \t\tcreatChart(result.obj);\r\n");
      out.write("\t        \t}else{\r\n");
      out.write("\t        \t\tW.$.dialog({\r\n");
      out.write("\t        \t\t\tid:'alert',\r\n");
      out.write("\t    \t\t\t\ttitle:'提示',\r\n");
      out.write("\t    \t\t\t\ttime:3,\r\n");
      out.write("\t    \t\t\t\ticon:'error.gif',\r\n");
      out.write("\t    \t\t\t\tcontent:result.msg,\r\n");
      out.write("\t    \t\t\t\tmax:false,\r\n");
      out.write("\t    \t\t        min:false,\r\n");
      out.write("\t    \t\t        resize:false\r\n");
      out.write("\t    \t\t\t});\r\n");
      out.write("\t        \t}\r\n");
      out.write("\t        }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t$('input[name=\"time\"]').change(function(){\r\n");
      out.write("\t\t$('input[name=\"date\"]').val($(this).val());\r\n");
      out.write("\t\tvar year = $('#year').val();\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl: \"tfLiaqinController.do?chartXml\",\r\n");
      out.write("\t        type: 'POST',\r\n");
      out.write("\t        data: \"tfBarnId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("&year=\"+year+\"&time=\"+$(this).val(),\r\n");
      out.write("\t        success: function(result){\r\n");
      out.write("\t        \tvar api = frameElement.api, W = api.opener;\r\n");
      out.write("\t        \tresult = $.parseJSON(result);\r\n");
      out.write("\t        \tif(result.success == true){\r\n");
      out.write("\t        \t\tcreatChart(result.obj);\r\n");
      out.write("\t        \t}else{\r\n");
      out.write("\t        \t\tW.$.dialog({\r\n");
      out.write("\t        \t\t\tid:'alert',\r\n");
      out.write("\t    \t\t\t\ttitle:'提示',\r\n");
      out.write("\t    \t\t\t\ttime:3,\r\n");
      out.write("\t    \t\t\t\ticon:'error.gif',\r\n");
      out.write("\t    \t\t\t\tcontent:result.msg,\r\n");
      out.write("\t    \t\t\t\tmax:false,\r\n");
      out.write("\t    \t\t        min:false,\r\n");
      out.write("\t    \t\t        resize:false\r\n");
      out.write("\t    \t\t\t});\r\n");
      out.write("\t        \t}\r\n");
      out.write("\t        }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t//var myChart = new FusionCharts(\"plug-in/FusionCharts/MSLine.swf\", \"myChartId\", \"900\", \"1080\");\r\n");
      out.write("\t//<chart outCnvBaseFontSize='8.5' divLineAlpha='100'  canvasBorderColor='000000' canvasBorderThickness='0'  showalternatevgridcolor='0' showalternatehgridcolor='0' bgcolor='ffffff' divlineisdashed='1' divlinedashlen='1'  showLegend='0' formatNumberScale='0' numberSuffix='℃' numdivlines='44' showhovercap='1' showNames='1' showValues='0' numVDivLines='26' rotateNames='0' showPrintMenuItem='0' exportEnabled='1' aboutMenuItemLabel='浙江省粮食局直属库' exportAtClient='0' exportHandler='FCExporter' exportAction='save' exportCallback='chartCallback' exportDialogMessage='正在生成,请稍候...' exportFormats='PNG=生成PNG图片' exportFileName='barn'>\r\n");
      out.write("\t/*myChart.setDataXML(\"<chart  chartTopMargin='0' chartRightMargin='2' yAxisMinValue='-4' chartLeftMargin='40'  outCnvBaseFontSize='8.5' divLineAlpha='100'  canvasBorderColor='000000' canvasBorderThickness='0'  showalternatevgridcolor='0' showalternatehgridcolor='0' bgcolor='ffffff' divlineisdashed='1' divlinedashlen='1'  showLegend='0' formatNumberScale='0' numberSuffix='℃'  showhovercap='1' showNames='1' showValues='0' numdivlines='44' numVDivLines='25' rotateNames='0' showPrintMenuItem='0' exportEnabled='1' aboutMenuItemLabel='浙江省粮食局直属库' aboutMenuItemLink='http://www.512u.com/index1.do' exportAtClient='0' exportHandler='FCExporter' exportAction='save' exportCallback='chartCallback' exportDialogMessage='正在生成,请稍候...' exportFormats='PNG=生成PNG图片' exportFileName='barn'>\"+\r\n");
      out.write("\t\t\t\"<categories><category name='1.7' /><category name='1.14' /><category name='1.21' /><category name='1.28' /><category name='2.4' /><category name='2.11' /><category name='2.18' />\"+\r\n");
      out.write("\t\t\t\"<category name='2.25' /><category name='3.4' /><category name='3.11' /><category name='3.18' /><category name='3.25' /><category name='4.1' /><category name='4.8' />\"+\r\n");
      out.write("\t\t\t\"<category name='4.15' /><category name='4.22' /><category name='4.29' /><category name='5.6' /><category name='5.13' /><category name='5.20' /><category name='5.27' />\"+\r\n");
      out.write("\t\t\t\"<category name='6.3' /><category name='6.10' /><category name='6.17' /><category name='6.24' /><category name='7.1' /><category name='' /></categories>\"+\r\n");
      out.write("\t\t\t\"<dataset seriesName='粮温' color='F1683C' anchorBorderColor='F1683C' anchorBgColor='F1683C' dashed='1'>\"+\r\n");
      out.write("\t\t\t \"<set value='13' />\"+\r\n");
      out.write("\t\t\t \"<set value='18' />\"+\r\n");
      out.write("\t\t\t \"<set value='16' />\"+\r\n");
      out.write("\t\t\t \"<set value='15' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='12' />\"+\r\n");
      out.write("\t\t\t \"<set value='13' />\"+\r\n");
      out.write("\t\t\t \"<set value='18' />\"+\r\n");
      out.write("\t\t\t \"<set value='16' />\"+\r\n");
      out.write("\t\t\t \"<set value='15' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='12' />\"+\r\n");
      out.write("\t\t\t \"<set value='13' />\"+\r\n");
      out.write("\t\t\t \"<set value='18' />\"+\r\n");
      out.write("\t\t\t \"<set value='16' />\"+\r\n");
      out.write("\t\t\t \"<set value='15' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='12' />\"+\r\n");
      out.write("\t\t\t \"<set value='13' />\"+\r\n");
      out.write("\t\t\t \"<set value='18' />\"+\r\n");
      out.write("\t\t\t \"<set value='16' />\"+\r\n");
      out.write("\t\t\t \"<set value='15' />\"+\r\n");
      out.write("\t\t\t \"<set value='18' />\"+\r\n");
      out.write("\t\t\t \"</dataset>\"+\r\n");
      out.write("\t\t\t\"<dataset seriesName='仓温' color='1D8BD1' anchorBorderColor='1D8BD1' anchorBgColor='1D8BD1'>\"+\r\n");
      out.write("\t\t\t \"<set value='20' />\"+\r\n");
      out.write("\t\t\t \"<set value='32' />\"+\r\n");
      out.write("\t\t\t \"<set value='29' valuePosition='12' />\"+\r\n");
      out.write("\t\t\t \"<set value='31' />\"+\r\n");
      out.write("\t\t\t \"<set value='28' />\"+\r\n");
      out.write("\t\t\t \"<set value='35' />\"+\r\n");
      out.write("\t\t\t \"<set value='18' />\"+\r\n");
      out.write("\t\t\t \"<set value='13' />\"+\r\n");
      out.write("\t\t\t \"<set value='18' />\"+\r\n");
      out.write("\t\t\t \"<set value='16' />\"+\r\n");
      out.write("\t\t\t \"<set value='15' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='12' />\"+\r\n");
      out.write("\t\t\t \"<set value='13' />\"+\r\n");
      out.write("\t\t\t \"<set value='18' />\"+\r\n");
      out.write("\t\t\t \"<set value='16' />\"+\r\n");
      out.write("\t\t\t \"<set value='15' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='12' />\"+\r\n");
      out.write("\t\t\t \"<set value='13' />\"+\r\n");
      out.write("\t\t\t \"<set value='18' />\"+\r\n");
      out.write("\t\t\t \"<set value='16' />\"+\r\n");
      out.write("\t\t\t \"<set value='15' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t\"</dataset>\"+\r\n");
      out.write("\t\t\t\"<dataset seriesName='气温' color='000000' anchorBorderColor='000000' anchorBgColor='000000' lineThickness='0.1'>\"+\r\n");
      out.write("\t\t\t \"<set value='24' />\"+\r\n");
      out.write("\t\t\t \"<set value='35' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='36' />\"+\r\n");
      out.write("\t\t\t \"<set value='38' />\"+\r\n");
      out.write("\t\t\t \"<set value='40' />\"+\r\n");
      out.write("\t\t\t \"<set value='28' />\"+\r\n");
      out.write("\t\t\t \"<set value='23' />\"+\r\n");
      out.write("\t\t\t \"<set value='28' />\"+\r\n");
      out.write("\t\t\t \"<set value='36' />\"+\r\n");
      out.write("\t\t\t \"<set value='15' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='12' />\"+\r\n");
      out.write("\t\t\t \"<set value='13' />\"+\r\n");
      out.write("\t\t\t \"<set value='28' />\"+\r\n");
      out.write("\t\t\t \"<set value='16' />\"+\r\n");
      out.write("\t\t\t \"<set value='15' />\"+\r\n");
      out.write("\t\t\t \"<set value='29' />\"+\r\n");
      out.write("\t\t\t \"<set value='19' />\"+\r\n");
      out.write("\t\t\t \"<set value='12' />\"+\r\n");
      out.write("\t\t\t \"<set value='13' />\"+\r\n");
      out.write("\t\t\t \"<set value='28' />\"+\r\n");
      out.write("\t\t\t \"<set value='26' />\"+\r\n");
      out.write("\t\t\t \"<set value='35' />\"+\r\n");
      out.write("\t\t\t \"<set value='29' />\"+\r\n");
      out.write("\t\t\t\"</dataset>\"+\r\n");
      out.write("\t\t\t\"</chart>\");*/\r\n");
      out.write("\t//myChart.render(\"main\");\r\n");
      out.write("\t//导出图片后调用的回调函数\r\n");
      out.write("\tfunction chartCallback(objRtn){\r\n");
      out.write("\t\tvar api = frameElement.api, W = api.opener;\r\n");
      out.write("\t\tif(objRtn.statusCode == \"1\"){\r\n");
      out.write("\t\t\tW.$.dialog.confirm('生成图片成功,你确定要导出吗？', function(){\r\n");
      out.write("\t\t\t\tvar barnNo = $(\".main_rg\").data(\"no\");\r\n");
      out.write("\t\t\t\t$('<input type=\"hidden\" name=\"imgName\" value='+objRtn.fileName+'/>').appendTo($('#exportFrom'));\r\n");
      out.write("\t\t\t\t$('#exportFrom').attr('action','tfBarnController.do?chartExp&barnNo='+barnNo);\r\n");
      out.write("\t\t\t\t$('#exportFrom').submit();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tW.$.dialog({\r\n");
      out.write("    \t\t\tid:'alert',\r\n");
      out.write("\t\t\t\ttitle:'提示',\r\n");
      out.write("\t\t\t\ttime:3,\r\n");
      out.write("\t\t\t\ticon:'error.gif',\r\n");
      out.write("\t\t\t\tcontent:'生成图片失败，描述：'+objRtn.statusMessage,\r\n");
      out.write("\t\t\t\tmax:false,\r\n");
      out.write("\t\t        min:false,\r\n");
      out.write("\t\t        resize:false\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\t//导出图片调用的方法\r\n");
      out.write("    function startExport(){\r\n");
      out.write("       var api = frameElement.api, W = api.opener;\r\n");
      out.write("       var chart = getChartFromId(\"myChartId\");   //生成的FusionCharts图表本身的标识\r\n");
      out.write("       if (chart.hasRendered()){\r\n");
      out.write("           chart.exportChart();\r\n");
      out.write("       }else{\r\n");
      out.write("    \t   setTimeout(function(){\r\n");
      out.write("    \t\t   W.$.dialog.tips('正在加载,请稍候...',1,'loading.gif',function(){startExport();});\r\n");
      out.write("    \t\t}, 1000 );\r\n");
      out.write("       }\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</body>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    // /context/mytags.jsp(11,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("ctx");
    // /context/mytags.jsp(11,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/context/mytags.jsp(11,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_t_005fbase_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  t:base
    org.takinframework.tag.core.ui.BaseTag _jspx_th_t_005fbase_005f0 = (org.takinframework.tag.core.ui.BaseTag) _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.get(org.takinframework.tag.core.ui.BaseTag.class);
    _jspx_th_t_005fbase_005f0.setPageContext(_jspx_page_context);
    _jspx_th_t_005fbase_005f0.setParent(null);
    // /webpage/buss/tfBarn/../../common/head.jsp(9,1) name = type type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fbase_005f0.setType("icon,jquery,cookie,ztree,lhgDialog,niceValidator,select2,inputMask,DatePicker,barn");
    int _jspx_eval_t_005fbase_005f0 = _jspx_th_t_005fbase_005f0.doStartTag();
    if (_jspx_th_t_005fbase_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.reuse(_jspx_th_t_005fbase_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.reuse(_jspx_th_t_005fbase_005f0);
    return false;
  }
}
