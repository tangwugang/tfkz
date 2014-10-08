package org.apache.jsp.webpage.system.sysUser;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class sysUserList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fns:getSysName", org.takinframework.web.util.WebUtil.class, "getSysName", new Class[] {java.lang.String.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/webpage/system/sysUser/../../common/head.jsp");
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
      out.write("\n");
      out.write("<script>\n");
      out.write("$(function(){\n");
      out.write("\t$.post(\"sysRoleController.do?dataContext\",function(reslut){\n");
      out.write("\t\tvar data = $.parseJSON(reslut);\n");
      out.write("\t\tvar str ='<div class=\"c_center\"><ul>';\n");
      out.write("\t\tfor (var i = 0; i < data.length; i++) {\n");
      out.write("\t\t\tstr+='<li class=\"r_list\"><div class=\"role\"><div class=\"r_left\"><input type=\"checkbox\" data-id=\"'+data[i].obj.id+'\"/><b>'+data[i].obj.roleName+'</b></div>';\n");
      out.write("\t\t\tstr+='<div class=\"r_center\">';\n");
      out.write("\t\t\tvar funcList = data[i].objList1;\n");
      out.write("\t\t\tfor(var f = 0; f < funcList.length; f++){\n");
      out.write("\t\t\t\tstr+=funcList[f].funcName+' ';\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tstr+='</div><div class=\"r_right\"><a href=\"javascript:;\" class=\"uadd\" data-id=\"'+data[i].obj.id+'\">创建账号</a></div><div class=\"clr\"></div></div>';\n");
      out.write("\t\t\tstr+=' <div class=\"account\"><ul>';\n");
      out.write("\t\t\tvar userList = data[i].objList2;\n");
      out.write("\t\t\tfor (var u = 0; u < userList.length; u++) {\n");
      out.write("\t\t\t\tstr+='<li class=\"a_list\"><div class=\"a_left\">'+userList[u].userName+'</div>';\n");
      out.write("\t\t\t\tif(null != userList[u].barnNo && userList[u].barnNo != \"\"){\n");
      out.write("\t\t\t\t\tstr+='<div class=\"a_center\">'+userList[u].barnNo.replace(\",\",\" \").replace(\"All\",\"全部\")+'</div>';\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t\tstr+='<div class=\"a_right\"><a href=\"javascript:;\" class=\"xg\" data-id=\"'+userList[u].id+'\" title=\"修改\"></a><a href=\"javascript:;\" class=\"sc\" data-id=\"'+userList[u].id+'\" title=\"删除\"></a></div></li><div class=\"clr\"></div>';\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tstr+='</ul></div>';\n");
      out.write("\t\t}\n");
      out.write("\t\tstr+='</ul></div>';\n");
      out.write("\t\t$('body').append(str).on('click','a.uadd',function(){\n");
      out.write("\t\t\ttitle = $(this).text();\n");
      out.write("\t\t\t$.dialog({\n");
      out.write("\t\t\t\t\tid:'addUser',\n");
      out.write("\t\t\t        title: title,\n");
      out.write("\t\t\t        height : 380,\n");
      out.write("\t\t\t        width : 450,\n");
      out.write("\t\t\t        max:false,\n");
      out.write("\t\t\t        min:false,\n");
      out.write("\t\t\t        resize:false,\n");
      out.write("\t\t\t        content:'url:sysUserController.do?sysUserAddOrUpdate&roleId='+$(this).data(\"id\")\n");
      out.write("\t\t    });\n");
      out.write("\t\t})\n");
      out.write("\t\t.on('click','a.xg',function(){\n");
      out.write("\t\t\ttitle = $(this).text();\n");
      out.write("\t\t\tvar userId = $(this).data(\"id\");\n");
      out.write("\t\t\t$.dialog({\n");
      out.write("\t\t\t\t\tid:'xgUser',\n");
      out.write("\t\t\t        title: title,\n");
      out.write("\t\t\t        height : 380,\n");
      out.write("\t\t\t        width : 450,\n");
      out.write("\t\t\t        max:false,\n");
      out.write("\t\t\t        min:false,\n");
      out.write("\t\t\t        resize:false,\n");
      out.write("\t\t\t        content:'url:sysUserController.do?sysUserAddOrUpdate&id='+userId\n");
      out.write("\t\t    });\n");
      out.write("\t\t})\n");
      out.write("\t\t.on('click','a.sc',function(){\n");
      out.write("\t\t\tvar userId = $(this).data(\"id\");\n");
      out.write("\t\t\t$.dialog.confirm('你确定要删除吗？', function(){\n");
      out.write("\t\t\t\t$.post('sysUserController.do?del&id='+userId,function(result){\n");
      out.write("\t\t\t\t\tvar result = $.parseJSON(result);\n");
      out.write("\t\t\t\t\tif(result.success == true){\n");
      out.write("\t\t\t\t\t\t$.dialog({\n");
      out.write("\t            \t\t\tid:'alert',\n");
      out.write("\t        \t\t\t\ttitle:'提示',\n");
      out.write("\t        \t\t\t\ttime:3,\n");
      out.write("\t        \t\t\t\ticon:'success.gif',\n");
      out.write("\t        \t\t\t\tcontent:result.msg,\n");
      out.write("\t        \t\t\t\tmax:false,\n");
      out.write("\t        \t\t        min:false,\n");
      out.write("\t        \t\t        resize:false\n");
      out.write("\t        \t\t\t});\n");
      out.write("\t\t\t\t\t\tsetTimeout(function(){top.location.reload();},1000);\n");
      out.write("\t\t\t\t\t}else{\n");
      out.write("\t\t\t\t\t\t$.dialog({\n");
      out.write("\t            \t\t\tid:'alert',\n");
      out.write("\t        \t\t\t\ttitle:'提示',\n");
      out.write("\t        \t\t\t\ttime:3,\n");
      out.write("\t        \t\t\t\ticon:'error.gif',\n");
      out.write("\t        \t\t\t\tcontent:result.msg,\n");
      out.write("\t        \t\t\t\tmax:false,\n");
      out.write("\t        \t\t        min:false,\n");
      out.write("\t        \t\t        resize:false\n");
      out.write("\t        \t\t\t});\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t});\n");
      out.write("\t\t\t});\n");
      out.write("\t\t})\n");
      out.write("\t\t.on('click',':checkbox',function(){\n");
      out.write("\t\t\tvar e = $(this);\n");
      out.write("\t\t\t$(\":checkbox\").each(function(){\n");
      out.write("\t\t\t\tif($(this).data(\"id\")!= e.data(\"id\") && $(this).is(\":checked\")){\n");
      out.write("\t\t\t\t\t$(this).attr(\"checked\",false);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t})\n");
      out.write("\t\t.on('click','.r_center',function(){\n");
      out.write("\t\t\t$(this).parent().siblings(\".account\").toggle();\n");
      out.write("\t\t})\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t$(\"body\").on('click','a.cview,a.cmodify,a.cdel',function(e){\n");
      out.write("\t\te.preventDefault();\n");
      out.write("\t\tvar flag = false;\n");
      out.write("\t\tvar ev = $(this);\n");
      out.write("\t\t$(\":checkbox\").each(function(){\n");
      out.write("\t\t\tif($(this).is(\":checked\")){\n");
      out.write("\t\t\t\t//$(this).data(\"id\")\n");
      out.write("\t\t\t\tflag = true;\n");
      out.write("\t\t\t\tif(ev.attr('class')=='cview'){\n");
      out.write("\t\t\t\t}else if(ev.attr('class')=='cmodify'){\n");
      out.write("\t\t\t\t\t$.dialog({\n");
      out.write("\t\t\t\t\t\tid:'modifyRole',\n");
      out.write("\t\t\t\t\t\tlock:true,\n");
      out.write("\t\t\t\t        title: ev.text(),\n");
      out.write("\t\t\t\t        height : 380,\n");
      out.write("\t\t\t\t        width : 450,\n");
      out.write("\t\t\t\t        max:false,\n");
      out.write("\t\t\t\t        min:false,\n");
      out.write("\t\t\t\t        resize:false,\n");
      out.write("\t\t\t\t        content:'url:sysRoleController.do?sysRoleUpdate&id='+$(this).data(\"id\")\n");
      out.write("\t\t\t    \t});\n");
      out.write("\t\t\t\t}else if(ev.attr('class')=='cdel'){\n");
      out.write("\t\t\t\t\tvar roleId = $(this).data(\"id\");\n");
      out.write("\t\t\t\t\t$.dialog.confirm('你确定要删除吗？', function(){\n");
      out.write("\t\t\t\t\t\t$.post('sysRoleController.do?del&id='+roleId,function(result){\n");
      out.write("\t\t\t\t\t\t\tvar result = $.parseJSON(result);\n");
      out.write("\t\t\t\t\t\t\tif(result.success == true){\n");
      out.write("\t\t\t\t\t\t\t\t$.dialog({\n");
      out.write("\t\t\t            \t\t\tid:'alert',\n");
      out.write("\t\t\t        \t\t\t\ttitle:'提示',\n");
      out.write("\t\t\t        \t\t\t\ttime:3,\n");
      out.write("\t\t\t        \t\t\t\ticon:'success.gif',\n");
      out.write("\t\t\t        \t\t\t\tcontent:result.msg,\n");
      out.write("\t\t\t        \t\t\t\tmax:false,\n");
      out.write("\t\t\t        \t\t        min:false,\n");
      out.write("\t\t\t        \t\t        resize:false\n");
      out.write("\t\t\t        \t\t\t});\n");
      out.write("\t\t\t\t\t\t\t\tsetTimeout(function(){top.location.reload();},1000);\n");
      out.write("\t\t\t\t\t\t\t}else{\n");
      out.write("\t\t\t\t\t\t\t\t$.dialog({\n");
      out.write("\t\t\t            \t\t\tid:'alert',\n");
      out.write("\t\t\t        \t\t\t\ttitle:'提示',\n");
      out.write("\t\t\t        \t\t\t\ttime:3,\n");
      out.write("\t\t\t        \t\t\t\ticon:'error.gif',\n");
      out.write("\t\t\t        \t\t\t\tcontent:result.msg,\n");
      out.write("\t\t\t        \t\t\t\tmax:false,\n");
      out.write("\t\t\t        \t\t        min:false,\n");
      out.write("\t\t\t        \t\t        resize:false\n");
      out.write("\t\t\t        \t\t\t});\n");
      out.write("\t\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t\tif(!flag){\n");
      out.write("\t\t\t$.dialog({\n");
      out.write("\t\t\t\ttitle:'提示',\n");
      out.write("\t\t\t\ttime:3,\n");
      out.write("\t\t\t\ticon:'alert.gif',\n");
      out.write("\t\t\t\tcontent:'请先选择角色！',\n");
      out.write("\t\t\t\tmax:false,\n");
      out.write("\t\t        min:false,\n");
      out.write("\t\t        resize:false\n");
      out.write("\t\t\t});\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("\t$(\"body\").on('click','a.cadd',function(){\n");
      out.write("\t\ttitle = $(this).text();\n");
      out.write("\t\t$.dialog({\n");
      out.write("\t\t\t\tid:'addRole',\n");
      out.write("\t\t        title: title,\n");
      out.write("\t\t        height : 380,\n");
      out.write("\t\t        width : 450,\n");
      out.write("\t\t        max:false,\n");
      out.write("\t\t        min:false,\n");
      out.write("\t\t        resize:false,\n");
      out.write("\t\t        content:'url:sysRoleController.do?sysRoleAdd'\n");
      out.write("\t    });\n");
      out.write("\t\t\n");
      out.write("\t});\n");
      out.write("\t\n");
      out.write("});\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t <!-----------人员管理 s--------------------->\n");
      out.write("    <div class=\"C_top\">\n");
      out.write("      <a href=\"javascript:\" class=\"cadd\">创建角色</a>\n");
      out.write("<!--       <a href=\"javascript:\" class=\"cview\">角色信息查看</a> -->\n");
      out.write("      <a href=\"javascript:\" class=\"cmodify\">角色信息修改</a>\n");
      out.write("      <a href=\"javascript:\" class=\"cdel\">角色删除</a>\n");
      out.write("    </div><!--C_top e-->\n");
      out.write(" <!-----------人员管理 e--------------------->\n");
      out.write("</body>\n");
      out.write("</html>");
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
    // /webpage/system/sysUser/../../common/head.jsp(9,1) name = type type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
