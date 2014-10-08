package org.apache.jsp.webpage.buss.tfBarn;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tfBarnLiaQin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<body>\r\n");
      out.write("<div class=\"wrapper2\">\r\n");
      out.write("<form id=\"exportFrom\" method=\"post\"></form>\r\n");
      out.write("<div class=\"main\" style=\"background:none;\">\r\n");
      out.write("   <div class=\"main_top\">\r\n");
      out.write("     <ul>\r\n");
      out.write("       <li><a href=\"tfBarnController.do?tfLiaqin&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"l_1\"  onfocus=\"this.blur();\" class=\"current\">粮情检查记录</a></li>\r\n");
      out.write("       <li><a href=\"tfBarnController.do?tfMachine&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"l_2\"  onfocus=\"this.blur();\"  >机械通风记录</a></li>\r\n");
      out.write("       <li><a href=\"tfBarnController.do?tfChart&id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" id=\"l_3\"  onfocus=\"this.blur();\">三温图</a></li>\r\n");
      out.write("     </ul>\r\n");
      out.write("     <div class=\"main_rg\">\r\n");
      out.write("       <a href=\"javascript:;\" class=\"v_s\" title=\"保存\"></a>\r\n");
      out.write("       <a href=\"javascript:;\" class=\"dc\" title=\"导出\"></a>\r\n");
      out.write("     </div> \r\n");
      out.write("   </div>\r\n");
      out.write("   <div class=\"main_center\" id=\"d1\" style=\"display:block;\">\r\n");
      out.write("   <div class=\"m_left\">\r\n");
      out.write("   <iframe id=\"searchFrame\" name=\"searchFrame\" data-url=\"tfLiaqinController.do?tfLiaqin&tfBarnId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" src=\"tfLiaqinController.do?tfLiaqin&tfBarnId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" frameborder=\"0\" scrolling=\"no\" height=\"580px\" width=\"160px\"></iframe>\r\n");
      out.write("   </div><!--m_left e-->\r\n");
      out.write("   <div class=\"m_right\">\r\n");
      out.write("   <iframe id=\"detailFrame\" name=\"detailFrame\" data-url=\"tfLiaqinController.do?tfLiaqinAddOrUpdate&tfBarnId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" src=\"tfLiaqinController.do?tfLiaqinAddOrUpdate&tfBarnId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${tfBarn.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" frameborder=\"0\" scrolling=\"no\" height=\"570px\" width=\"740px\"></iframe>\r\n");
      out.write("   </div><!--m_right e-->\r\n");
      out.write("   </div><!--main_center e-->\r\n");
      out.write("</div><!--main e-->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t/*var selectM = $.cookie(\"selectM\");\r\n");
      out.write("\t\tvar obj= $(\"#\" +selectM);\r\n");
      out.write("\t\tvar url = obj.data('url');\r\n");
      out.write("\t\tif(selectM && obj.length>0){\r\n");
      out.write("\t\t\t$(\".main_top ul li a\").removeClass(\"current\");\r\n");
      out.write("\t\t\tobj.addClass(\"current\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".main_top\").delegate(\"ul li a\", \"click\", function(){\r\n");
      out.write("\t         var id=$(this).attr(\"id\");\r\n");
      out.write("\t         var url = $(this).data(\"url\");\r\n");
      out.write("\t         $(\".main_top ul li a\").removeClass(\"current\");\r\n");
      out.write("\t         $(this).addClass(\"current\");\r\n");
      out.write("\t         $.cookie(\"selectM\",id);\r\n");
      out.write("\t         if(url!=\"\" && url!=undefined){\r\n");
      out.write("\t\t\t\t$(\"#recordFrame\").attr(\"src\",url);\r\n");
      out.write("\t\t\t }\r\n");
      out.write("\t     });\r\n");
      out.write("\t\t */\r\n");
      out.write("\t\t $('body').on('click','a.v_s',function(){\r\n");
      out.write("\t\t\t $(\"#inputFrom\",window.frames[\"detailFrame\"].document).find(\"#submit-btn\").click();\r\n");
      out.write("\t\t\t// window.frames[\"detailFrame\"].document.forms[\"inputFrom\"].action=\"\";\r\n");
      out.write("\t\t\t// window.frames[\"detailFrame\"].document.forms[\"inputFrom\"].submit();\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t })\r\n");
      out.write("\t\t .on('click','a.dc',function(){\r\n");
      out.write("\t\t\tvar api = frameElement.api, W = api.opener;\r\n");
      out.write("\t\t\tvar id = $(\"#inputFrom\",window.frames[\"detailFrame\"].document).find(\"input[name='id']\").val();\r\n");
      out.write("\t\t\tif(id != undefined){\r\n");
      out.write("\t\t\t\t$('#exportFrom').attr('action','tfLiaqinController.do?export&id='+id);\r\n");
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
      out.write("\t\t\t \r\n");
      out.write("\t\t })\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t \r\n");
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
