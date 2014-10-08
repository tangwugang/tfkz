package org.apache.jsp.webpage.buss.tfBarnShiwu;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tfBarnShiwuAddOrUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getSysName", org.takinframework.web.util.WebUtil.class, "getSysName", new Class[] {java.lang.String.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/webpage/buss/tfBarnShiwu/../../common/head.jsp");
    _jspx_dependants.add("/context/mytags.jsp");
    _jspx_dependants.add("/WEB-INF/tld/takinui.tld");
    _jspx_dependants.add("/WEB-INF/tld/fns.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<body>\r\n");
      out.write("<div class=\"wrapper2\">\r\n");
      out.write("<form id=\"exportFrom\" method=\"post\"></form>\r\n");
      out.write("<form id=\"inputFrom\" method=\"post\" data-validator-option=\"{theme:'yellow_right_effect',stopOnError:true,timely:2}\" >\r\n");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("  <div class=\"main\">\r\n");
      out.write("    <div class=\"content\">\r\n");
      out.write("      <div class=\"box_top11\"></div>\r\n");
      out.write("      <div class=\"content1\">\r\n");
      out.write("        <div class=\"nn\"><label>粮食品种</label> <input type=\"text\" class=\"in\" name=\"liaShiPinZh\" data-rule=\"required;zh_cn\" data-rule-zh_cn=\"[/^[\\u4E00-\\uFA29]*$/,'请输入中文']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.liaShiPinZh}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>粮食产地</label> <input type=\"text\" class=\"in\" name=\"liaShiChanDi\" data-rule=\"required;zh_cn\" data-rule-zh_cn=\"[/^[\\u4E00-\\uFA29]*$/,'请输入中文']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.liaShiChanDi}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>粮食性质</label> <input type=\"text\" class=\"in\" name=\"liaShiXinZhi\" data-rule=\"required;zh_cn\" data-rule-zh_cn=\"[/^[\\u4E00-\\uFA29]*$/,'请输入中文']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.liaShiXinZhi}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>粮权归属</label> <input type=\"text\" class=\"in\" name=\"liaQuaGuiSu\" data-rule=\"required;zh_cn\" data-rule-zh_cn=\"[/^[\\u4E00-\\uFA29]*$/,'请输入中文']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.liaQuaGuiSu}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>实际数量(吨)</label> <input type=\"text\" class=\"in\" name=\"number\" data-inputmask=\"'mask': '[9999]'\" data-rule=\"required;num\" data-rule-num=\"[/^\\d{4}$/,'4位整数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.number}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>入库成本(元/吨)</label> <input type=\"text\" class=\"in\" name=\"ruKuCenBen\" data-inputmask=\"'mask': '[9999]'\" data-rule=\"required;num\" data-rule-num=\"[/^\\d{4}$/,'4位整数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.ruKuCenBen}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>收获年度</label> <input type=\"text\" class=\"in\" name=\"soHuoNiaDu\" data-rule=\"required;num\" data-rule-num=\"[/^\\d{4}$/,'4位整数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.soHuoNiaDu}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>入仓时间</label> <input type=\"text\" class=\"in\" name=\"ruCanTime\" data-inputmask=\"'alias': 'yyyy.mm.dd'\" data-rule=\"required;date\" data-rule-date=\"[/^\\d{4}(\\.)\\d{2}(\\.)\\d{2}$/,'请输入日期']\"  data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.ruCanTime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>成货位时间</label> <input type=\"text\" class=\"in\" name=\"huoWeiTime\" data-inputmask=\"'alias': 'yyyy.mm.dd'\" data-rule=\"required;date\" data-rule-date=\"[/^\\d{4}(\\.)\\d{2}(\\.)\\d{2}$/,'请输入日期']\"  data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.huoWeiTime}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>储存年限</label> <input type=\"text\" class=\"in\" name=\"cuCenNianX\" data-rule=\"required;num\" data-rule-num=\"[/^\\d{1,4}$/,'1或4位整数']\"  data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.cuCenNianX}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>管理方式</label> <input type=\"text\" class=\"in\" name=\"guanLifanShi\" data-rule=\"required;zh_cn\" data-rule-zh_cn=\"[/^[\\u4E00-\\uFA29]*$/,'请输入中文']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.guanLifanShi}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>储存方式</label> <input type=\"text\" class=\"in\" name=\"cuCenFanShi\" data-rule=\"required;zh_cn\" data-rule-zh_cn=\"[/^[\\u4E00-\\uFA29]*$/,'请输入中文']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.cuCenFanShi}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>入仓方式</label> <input type=\"text\" class=\"in\" name=\"ruCanFanShi\" data-rule=\"required;zh_cn\" data-rule-zh_cn=\"[/^[\\u4E00-\\uFA29]*$/,'请输入中文']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.ruCanFanShi}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>包装存粮(包数)</label> <input type=\"text\" class=\"in\" name=\"cunLiaBaoS\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}$/,'1或4位整数']\"  data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.cunLiaBaoS}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>包装存粮体积(m³)</label> <input type=\"text\" class=\"in\" name=\"bzCunLiaVol\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.bzCunLiaVol}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>散装存粮体积(m³)</label> <input type=\"text\" class=\"in\" name=\"szCunLiaVol\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.szCunLiaVol}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"clr\"></div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"box_top22\"></div><!--box_top2 e-->\r\n");
      out.write("      <div class=\"content1\">\r\n");
      out.write("        <div class=\"nn\"><label>容重(g/L)</label> <input type=\"text\" class=\"in\" name=\"rongZhong\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.rongZhong}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>出糙率(%)</label> <input type=\"text\" class=\"in\" name=\"chuCaoLu\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.chuCaoLu}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>水分(%)</label> <input type=\"text\" class=\"in\" name=\"shuiFen\"  data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.shuiFen}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>杂质(%)</label> <input type=\"text\" class=\"in\" name=\"zaZhi\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.zaZhi}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>脂肪酸值</label> <input type=\"text\" class=\"in\" name=\"ziFanSuaZhi\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.ziFanSuaZhi}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>黄粒米(%)</label> <input type=\"text\" class=\"in\" name=\"huanLieMi\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.huanLieMi}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>整精米率(%)</label> <input type=\"text\" class=\"in\" name=\"zenJinMiLu\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.zenJinMiLu}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>谷外糙米(%)</label> <input type=\"text\" class=\"in\" name=\"guWaiCaoMi\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.guWaiCaoMi}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>不完善粒(%)</label> <input type=\"text\" class=\"in\" name=\"buWanSanLi\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.buWanSanLi}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>面筋吸水量(%)</label> <input type=\"text\" class=\"in\" name=\"mjXiShuiLian\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.mjXiShuiLian}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>硬度指数</label> <input type=\"text\" class=\"in\" name=\"yinDuZhiShu\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.yinDuZhiShu}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"nn\"><label>互混率(%)</label> <input type=\"text\" class=\"in\" name=\"huHunLu\" data-rule=\"num\" data-rule-num=\"[/^\\d{1,4}|(\\.)\\d{1,2}$/,'整数或小数']\" data-ok=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.huHunLu}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></div>\r\n");
      out.write("        <div class=\"clr\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("      <div class=\"box_bottom\"></div>\r\n");
      out.write("    </div><!--content e-->\r\n");
      out.write("    <div class=\"dao\"><a href=\"javascript:;\" title=\"导出\" class=\"export-btn\"></a></div>\r\n");
      out.write("    <div class=\"save v_s\"> <a href=\"javascript:;\" title=\"保存\" class=\"submit-btn\"></a></div>    \r\n");
      out.write("  </div><!--main e-->\r\n");
      out.write("</form>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$(\":input\").inputmask();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('body').on('click','a.export-btn',function(e){\r\n");
      out.write("\t\t\te.preventDefault();\r\n");
      out.write("\t\t\tvar api = frameElement.api, W = api.opener;\r\n");
      out.write("\t\t\tid = $('input[name=\\'id\\']').val();\r\n");
      out.write("\t\t\tif(id != undefined){\r\n");
      out.write("\t\t\t\t$('#exportFrom').attr('action','tfBarnShiwuController.do?export&id='+id);\r\n");
      out.write("\t\t\t\t$('#exportFrom').submit();\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tW.$.dialog({\r\n");
      out.write("        \t\t\tid:'alert',\r\n");
      out.write("    \t\t\t\ttitle:'提示',\r\n");
      out.write("    \t\t\t\ttime:3,\r\n");
      out.write("    \t\t\t\ticon:'error.gif',\r\n");
      out.write("    \t\t\t\tcontent:'亲,请先添加信息！',\r\n");
      out.write("    \t\t\t\tmax:false,\r\n");
      out.write("    \t\t        min:false,\r\n");
      out.write("    \t\t        resize:false\r\n");
      out.write("    \t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#inputFrom').validator({\r\n");
      out.write("\t\t\t//验证成功\r\n");
      out.write("\t\t    valid: function(form) {\r\n");
      out.write("\t\t    \tvar params = $(form).serialize();\r\n");
      out.write("\t\t    \t$.post('tfBarnShiwuController.do?save',params,function(result){\r\n");
      out.write("\t\t    \t\tvar result = $.parseJSON(result);\r\n");
      out.write("\t            \tvar api = frameElement.api, W = api.opener;\r\n");
      out.write("\t            \tif(result.success == false){\r\n");
      out.write("\t            \t\tapi.close();\r\n");
      out.write("\t            \t\tW.$.dialog({\r\n");
      out.write("\t            \t\t\tid:'alert',\r\n");
      out.write("\t        \t\t\t\ttitle:'提示',\r\n");
      out.write("\t        \t\t\t\ttime:3,\r\n");
      out.write("\t        \t\t\t\ticon:'error.gif',\r\n");
      out.write("\t        \t\t\t\tcontent:result.msg,\r\n");
      out.write("\t        \t\t\t\tmax:false,\r\n");
      out.write("\t        \t\t        min:false,\r\n");
      out.write("\t        \t\t        resize:false\r\n");
      out.write("\t        \t\t\t});\r\n");
      out.write("\t            \t}else{\r\n");
      out.write("\t            \t\tapi.hide();\r\n");
      out.write("\t            \t\tW.$.dialog({\r\n");
      out.write("\t            \t\t\tid:'alert',\r\n");
      out.write("\t        \t\t\t\ttitle:'提示',\r\n");
      out.write("\t        \t\t\t\ttime:3,\r\n");
      out.write("\t        \t\t\t\ticon:'success.gif',\r\n");
      out.write("\t        \t\t\t\tcontent:result.msg,\r\n");
      out.write("\t        \t\t\t\tmax:false,\r\n");
      out.write("\t        \t\t        min:false,\r\n");
      out.write("\t        \t\t        resize:false\r\n");
      out.write("\t        \t\t\t});\r\n");
      out.write("\t            \t\tsetTimeout(function(){top.location.reload();},1000);\r\n");
      out.write("\t            \t}\r\n");
      out.write("\t\t    \t});\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t// 使用链接代替submit按钮（注意：这种情况下输入框里面的回车键不能触发submit事件）\r\n");
      out.write("\t\t.on(\"click\", \"a.submit-btn\", function(e){\r\n");
      out.write("\t\t    $(e.delegateTarget).trigger(\"validate\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
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
    // /webpage/buss/tfBarnShiwu/../../common/head.jsp(9,1) name = type type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_t_005fbase_005f0.setType("icon,jquery,cookie,ztree,lhgDialog,niceValidator,select2,inputMask,DatePicker,barn");
    int _jspx_eval_t_005fbase_005f0 = _jspx_th_t_005fbase_005f0.doStartTag();
    if (_jspx_th_t_005fbase_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.reuse(_jspx_th_t_005fbase_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ft_005fbase_0026_005ftype_005fnobody.reuse(_jspx_th_t_005fbase_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /webpage/buss/tfBarnShiwu/tfBarnShiwuAddOrUpdate.jsp(8,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.id != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<input type=\"hidden\" name=\"id\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write('/');
        out.write('>');
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /webpage/buss/tfBarnShiwu/tfBarnShiwuAddOrUpdate.jsp(9,0) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.tfBarnId != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<input type=\"hidden\" name=\"tfBarnId\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarnShiwu.tfBarnId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write('/');
        out.write('>');
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
