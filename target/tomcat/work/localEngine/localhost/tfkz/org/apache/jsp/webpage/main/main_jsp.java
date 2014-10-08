package org.apache.jsp.webpage.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getSysName", org.takinframework.web.util.WebUtil.class, "getSysName", new Class[] {java.lang.String.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/webpage/main/../common/head.jsp");
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
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("\t $(\".rg_menu\").delegate(\"a\", \"click\", function(){\r\n");
      out.write("         var id=$(this).attr(\"id\");\r\n");
      out.write("         var url = $(this).attr(\"url\");\r\n");
      out.write("         $(\".rg_menu a\").removeClass(\"current\");\r\n");
      out.write("         $(this).addClass(\"current\");\r\n");
      out.write("         $.cookie(\"selectTab\",id);\r\n");
      out.write("         if(url!=\"\" && url!=undefined){\r\n");
      out.write("        \t $(\"#mainFrame\").attr(\"src\",url);\r\n");
      out.write("         }\r\n");
      out.write("     });\r\n");
      out.write("\tsetInterval(getTime, 1000);\r\n");
      out.write("\tloadMenu();\r\n");
      out.write("});\r\n");
      out.write("function getTime(){\r\n");
      out.write("\tvar mon, day, now, hour, min, sec;  \r\n");
      out.write("    mon = new Array(\"一月\", \"二月\", \"三月\", \"四月\", \"五月\", \"六月\", \"七月\", \"八月\",  \r\n");
      out.write("            \"九月\", \"十月\", \"十一月\", \"十二月\");  \r\n");
      out.write("    day = new Array(\"周日\", \"周一\", \"周二\", \"周三\", \"周四\", \"周五\", \"周六\");  \r\n");
      out.write("    now = new Date();  \r\n");
      out.write("    hour = now.getHours();  \r\n");
      out.write("    min = now.getMinutes();  \r\n");
      out.write("    sec = now.getSeconds();  \r\n");
      out.write("    if (hour < 10) {  \r\n");
      out.write("        hour = \"0\" + hour;  \r\n");
      out.write("    }  \r\n");
      out.write("    if (min < 10) {  \r\n");
      out.write("        min = \"0\" + min;  \r\n");
      out.write("    }  \r\n");
      out.write("    if (sec < 10) {  \r\n");
      out.write("        sec = \"0\" + sec;  \r\n");
      out.write("    }  \r\n");
      out.write("    $(\".f_time\").html(  \r\n");
      out.write("            \"<nobr>\" + day[now.getDay()] + \", \" + mon[now.getMonth()] + \" \"  \r\n");
      out.write("                    + now.getDate() + \", \" + now.getFullYear() + \" \" + hour  \r\n");
      out.write("                    + \":\" + min + \":\" + sec + \"</nobr>\"); \r\n");
      out.write("}\r\n");
      out.write("var aryTreeData=null;\r\n");
      out.write("//返回根节点\r\n");
      out.write("function getRootNodes(){\r\n");
      out.write("\tvar nodes=new Array();\r\n");
      out.write("\tfor(var i=0;i<aryTreeData.length;i++){\r\n");
      out.write("\t\tvar node=aryTreeData[i];\r\n");
      out.write("\t\tif(node.parentId==\"0\"){\r\n");
      out.write("\t\t\tnodes.push(node);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\treturn nodes;\r\n");
      out.write("};\r\n");
      out.write("//加载菜单\r\n");
      out.write("function loadMenu(){\r\n");
      out.write("\t$(\".rg_menu\").empty();\r\n");
      out.write("\t//一次性加载\r\n");
      out.write("\t$.post(\"loginController.do?leftTree\",\r\n");
      out.write("\t\t function(result){\r\n");
      out.write("\t\t\taryTreeData=$.parseJSON(result);\r\n");
      out.write("\t\t\t//获取根节点，加载顶部按钮菜单。\r\n");
      out.write("\t\t\tvar headers=getRootNodes();\r\n");
      out.write("\t\t\tvar len=headers.length;\r\n");
      out.write("\t\t\tvar menuContainer=$(\".rg_menu\");\r\n");
      out.write("\t\t\tmenuContainer.append(\"<ul>\");\r\n");
      out.write("\t\t\tfor(var i=0;i<len;i++){\r\n");
      out.write("    \t\t\tvar head=headers[i];\r\n");
      out.write("    \t\t\tvar menuItemHtml=getMenuItem(head);\r\n");
      out.write("    \t\t\t$(menuItemHtml).appendTo(\".rg_menu ul\");\r\n");
      out.write("    \t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(len>0){\r\n");
      out.write("\t\t\t\tvar selectTab=$.cookie(\"selectTab\");\r\n");
      out.write("\t\t\t\tvar obj= $(\"#\" +selectTab);\r\n");
      out.write("\t\t\t\tvar url = obj.attr(\"url\");\r\n");
      out.write("\t\t\t\tif(selectTab && obj.length>0){\r\n");
      out.write("\t\t\t\t\t$(\"#\" +selectTab).addClass(\"current\");\r\n");
      out.write("\t\t\t\t\tif(url!=\"\" && url!=undefined){\r\n");
      out.write("\t\t\t        \t $(\"#mainFrame\").attr(\"src\",url);\r\n");
      out.write("\t\t\t         }\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\tvar head=headers[0];\r\n");
      out.write("\t\t\t\t\tvar resId=head.id;\r\n");
      out.write("\t\t\t\t\t$(\"#\" +resId).addClass(\"current\");\r\n");
      out.write("\t\t\t\t\turl = $(\"#\" +resId).attr(\"url\");\r\n");
      out.write("\t\t\t\t\tif(url!=\"\" && url!=undefined){\r\n");
      out.write("\t\t\t        \t $(\"#mainFrame\").attr(\"src\",url);\r\n");
      out.write("\t\t\t         }\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("//加载菜单项\r\n");
      out.write("function getMenuItem(node){\r\n");
      out.write("\tvar str='<li ';\r\n");
      out.write("\tif(node.funcClass!=\"\"){\r\n");
      out.write("\t\tstr+='class=\"'+node.funcClass+'\"';\r\n");
      out.write("\t}\r\n");
      out.write("\tstr+='><a href=\"#\" id=\"'+node.id+'\" url=\"'+node.funcUrl+'\" >'+node.funcName+'</a></li>';\r\n");
      out.write("\treturn str;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"wrapper\">\r\n");
      out.write("\t<!-----------顶部 s--------------------->\r\n");
      out.write("\t<div class=\"top_Bar\">\r\n");
      out.write("\t  <div class=\"left_logo\"></div><!--left_logo e-->\r\n");
      out.write("\t  <div class=\"rg_menu\">\r\n");
      out.write("\t  </div><!--rg_menu e-->\r\n");
      out.write("\t</div><!--top_Bar e-->\r\n");
      out.write("\t<!-----------顶部 e--------------------->\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t<iframe id=\"mainFrame\" name=\"mainFrame\" frameborder=\"0\" scrolling=\"no\" height=\"100%\" width=\"100%\"></iframe>\r\n");
      out.write("\t</div><!--container e-->\r\n");
      out.write("\t<!-----------底部 s--------------------->\r\n");
      out.write("\t<div class=\"footer\">\r\n");
      out.write("\t <div class=\"f_time\"></div><!--f_time e-->\r\n");
      out.write("\t <div class=\"welcome\">\r\n");
      out.write("\t    <span>欢迎登录！</span><span>超级管理员</span>&nbsp;&nbsp;<span class=\"blue\">张三三</span>\r\n");
      out.write("\t    <div class=\"list\">\r\n");
      out.write("\t        <ul style=\"display:none;\">\r\n");
      out.write("\t          <li><a href=\"\">账户基本信息</a></li>\r\n");
      out.write("\t          <li><a href=\"\">修改密码</a></li>\r\n");
      out.write("\t          <li><a href=\"\">退出</a></li>\r\n");
      out.write("\t        </ul>\r\n");
      out.write("\t     </div>\r\n");
      out.write("\t </div><!--welcome e-->\r\n");
      out.write("\t <div class=\"clr\"></div>\r\n");
      out.write("\t</div><!--footer e-->\r\n");
      out.write("\t<!-----------底部 e--------------------->\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
    // /webpage/main/../common/head.jsp(9,1) name = type type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
