package org.takinframework.tag.core.ui;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.takinframework.core.util.oConvertUtils;

public class BaseTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	protected String type = "default";// 加载类型

	public void setType(String type) {
		this.type = type;
	}
	
	public int doStartTag() throws JspException {
		return EVAL_PAGE;
	}
	
	
	public int doEndTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		StringBuffer sb = new StringBuffer();

		String types[] = type.split(",");
		if (oConvertUtils.isIn("icon", types)) {
			sb.append("<link rel=\"shortcut icon\" href=\"assets/img/logo.gif\"></link>\n");
		}
		if (oConvertUtils.isIn("jquery", types)) {
			sb.append("<script type=\"text/javascript\" src=\"plug-in/jquery/jquery-1.8.3.min.js\"></script>\n");
		}
		if (oConvertUtils.isIn("cookie", types)) {
			sb.append("<script type=\"text/javascript\" src=\"plug-in/jquery/jquery.cookie.js\"></script>\n");
		}
		if (oConvertUtils.isIn("ckeditor", types)) {
			sb.append("<script type=\"text/javascript\" src=\"plug-in/ckeditor/ckeditor.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/tools/ckeditorTool.js\"></script>");
		}
		if (oConvertUtils.isIn("ckfinder", types)) {
			sb.append("<script type=\"text/javascript\" src=\"plug-in/ckfinder/ckfinder.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/tools/ckfinderTool.js\"></script>");
		}
		if (oConvertUtils.isIn("tools", types)) {
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/tools/css/common.css\" type=\"text/css\"></link>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/lhgDialog/lhgdialog.min.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/tools/curdtools.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/tools/easyuiextend.js\"></script>");
		}
		if (oConvertUtils.isIn("toptip", types)) {
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/toptip/css/css.css\" type=\"text/css\"></link>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/toptip/manhua_msgTips.js\"></script>");
		}
		if (oConvertUtils.isIn("autocomplete", types)) {
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/jquery/jquery-autocomplete/jquery.autocomplete.css\" type=\"text/css\"></link>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/jquery/jquery-autocomplete/jquery.autocomplete.min.js\"></script>");
		}
		if (oConvertUtils.isIn("DatePicker", types)) {
			sb.append("<script type=\"text/javascript\" src=\"plug-in/My97DatePicker/WdatePicker.js\"></script>");
		}
		if (oConvertUtils.isIn("jqueryui-sortable", types)) {
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/jquery-ui/css/ui-lightness/jquery-ui-1.9.2.custom.min.css\" type=\"text/css\"></link>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/jquery-ui/js/ui/jquery.ui.core.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/jquery-ui/js/ui/jquery.ui.widget.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/jquery-ui/js/ui/jquery.ui.mouse.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/jquery-ui/js/ui/jquery.ui.sortable.js\"></script>");
		}
		if (oConvertUtils.isIn("prohibit", types)) {
			sb.append("<script type=\"text/javascript\" src=\"plug-in/tools/prohibitutil.js\"></script>");
		}
		if (oConvertUtils.isIn("designer", types)) {
			sb.append("<script type=\"text/javascript\" src=\"plug-in/designer/easyui/jquery-1.7.2.min.js\"></script>");
			sb.append("<link id=\"easyuiTheme\" rel=\"stylesheet\" href=\"plug-in/designer/easyui/easyui.css\" type=\"text/css\"></link>");
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/designer/easyui/icon.css\" type=\"text/css\"></link>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/designer/easyui/jquery.easyui.min.1.3.0.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/designer/easyui/locale/easyui-lang-zh_CN.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/tools/syUtil.js\"></script>");
			
			sb.append("<script type=\'text/javascript\' src=\'plug-in/jquery/jquery-autocomplete/lib/jquery.bgiframe.min.js\'></script>");
			sb.append("<script type=\'text/javascript\' src=\'plug-in/jquery/jquery-autocomplete/lib/jquery.ajaxQueue.js\'></script>");
			sb.append("<script type=\'text/javascript\' src=\'plug-in/jquery/jquery-autocomplete/jquery.autocomplete.min.js\'></script>");
			sb.append("<link href=\"plug-in/designer/designer.css\" type=\"text/css\" rel=\"stylesheet\" />");
			sb.append("<script src=\"plug-in/designer/draw2d/wz_jsgraphics.js\"></script>");
			sb.append("<script src=\'plug-in/designer/draw2d/mootools.js\'></script>");
			sb.append("<script src=\'plug-in/designer/draw2d/moocanvas.js\'></script>");
			sb.append("<script src=\'plug-in/designer/draw2d/draw2d.js\'></script>");
			sb.append("<script src=\"plug-in/designer/MyCanvas.js\"></script>");
			sb.append("<script src=\"plug-in/designer/ResizeImage.js\"></script>");
			sb.append("<script src=\"plug-in/designer/event/Start.js\"></script>");
			sb.append("<script src=\"plug-in/designer/event/End.js\"></script>");
			sb.append("<script src=\"plug-in/designer/connection/MyInputPort.js\"></script>");
			sb.append("<script src=\"plug-in/designer/connection/MyOutputPort.js\"></script>");
			sb.append("<script src=\"plug-in/designer/connection/DecoratedConnection.js\"></script>");
			sb.append("<script src=\"plug-in/designer/task/Task.js\"></script>");
			sb.append("<script src=\"plug-in/designer/task/UserTask.js\"></script>");
			sb.append("<script src=\"plug-in/designer/task/ManualTask.js\"></script>");
			sb.append("<script src=\"plug-in/designer/task/ServiceTask.js\"></script>");
			sb.append("<script src=\"plug-in/designer/gateway/ExclusiveGateway.js\"></script>");
			sb.append("<script src=\"plug-in/designer/gateway/ParallelGateway.js\"></script>");
			sb.append("<script src=\"plug-in/designer/boundaryevent/TimerBoundary.js\"></script>");
			sb.append("<script src=\"plug-in/designer/boundaryevent/ErrorBoundary.js\"></script>");
			sb.append("<script src=\"plug-in/designer/subprocess/CallActivity.js\"></script>");
			sb.append("<script src=\"plug-in/designer/task/ScriptTask.js\"></script>");
			sb.append("<script src=\"plug-in/designer/task/MailTask.js\"></script>");
			sb.append("<script src=\"plug-in/designer/task/ReceiveTask.js\"></script>");
			sb.append("<script src=\"plug-in/designer/task/BusinessRuleTask.js\"></script>");
			sb.append("<script src=\"plug-in/designer/designer.js\"></script>");
			sb.append("<script src=\"plug-in/designer/mydesigner.js\"></script>");
		}
		if (oConvertUtils.isIn("ligerui", types)) {
			sb.append("<script type=\"text/javascript\" src=\"plug-in/tools/dataformat.js\"></script>");
			sb.append("<link id=\"ligeruiTheme\" rel=\"stylesheet\" href=\"plug-in/ligerui/default/css/Aqua/css/ligerui-all.css\" type=\"text/css\"></link>");
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/ligerui/default/css/index.css\" type=\"text/css\"></link>");
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/ligerui/default/css/web.css\" type=\"text/css\"></link>");
			sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"plug-in/ligerui/default/css/select.css\">");
			sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"plug-in/ligerui/default/css/tree/zTreeStyle.css\">");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/ligerui/js/core/base.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/ligerui/js/ligerui.all.js\"></script>");
//			sb.append("<script type=\"text/javascript\" src=\"plug-in/ligerui/js/plugins/ligerDialog.js\"></script>");
//			sb.append("<script type=\"text/javascript\" src=\"plug-in/ligerui/js/plugins/ligerDrag.js\"></script>");
//			sb.append("<script type=\"text/javascript\" src=\"plug-in/ligerui/js/plugins/ligerLayout.js\"></script>");
//			sb.append("<script type=\"text/javascript\" src=\"plug-in/ligerui/js/plugins/ligerMenu.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/ligerui/js/plugins/ligerTab.js\"></script>");
//			sb.append("<script type=\"text/javascript\" src=\"plug-in/ligerui/js/plugins/ligerAccordion.js\"></script>");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/ligerui/js/tree/jquery.ztree.js\"></script>");
		}
		
		if(oConvertUtils.isIn("ztree", types)){
			sb.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"plug-in/assets/ztree/zTreeStyle.css\">\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/ztree/jquery.ztree.js\"></script>\n");
		}
		if(oConvertUtils.isIn("bootstrap", types)){
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/bootstrap/css/bootstrap.min.css\" type=\"text/css\"></link>\n");
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/bootstrap/css/bootstrap-responsive.min.css\" type=\"text/css\"></link>\n");
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/font-awesome/css/font-awesome.min.css\" type=\"text/css\"></link>\n");
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/css/style-metro.css\" type=\"text/css\"></link>\n");
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/css/style.css\" type=\"text/css\"></link>\n");
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/css/style-responsive.css\" type=\"text/css\"></link>\n");
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/css/default.css\" type=\"text/css\"></link>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/js/jquery.nicescroll.js\"></script>\n");
//			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/jquery-slimscroll/jquery-ui-1.9.2.custom.min.js\"></script>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/bootstrap/js/bootstrap.min.js\"></script>\n");
			sb.append("<!--[if lt IE 9]><script type=\"text/javascript\" src=\"plug-in/assets/js/excanvas.min.js\"></script>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/js/respond.min.js\"></script><![endif]-->\n");
		}
		if(oConvertUtils.isIn("nicescroll", types)){
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/js/jquery.nicescroll.js\"></script>\n");
		}
		if (oConvertUtils.isIn("jqueryui", types)) {
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/jquery-ui/jquery-ui-1.10.1.custom.min.css\" type=\"text/css\"></link>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/jquery-ui/jquery-ui-1.10.1.custom.min.js\"></script>\n");
		}
		if(oConvertUtils.isIn("uniform", types)){
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/uniform/css/uniform.default.css\" type=\"text/css\"></link>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/uniform/jquery.uniform.min.js\"></script>\n");
		}
		
		if(oConvertUtils.isIn("jqtransform", types)){
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/jqtransform/jqtransform.css\" type=\"text/css\"></link>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/jqtransform/jquery.jqtransform.js\"></script>\n");
		}
		if(oConvertUtils.isIn("app", types)){
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/js/app.js\"></script>\n");
		}
		if(oConvertUtils.isIn("blockUI", types)){
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/js/jquery.blockui.js\"></script>\n");
		}
		if(oConvertUtils.isIn("contextMenu", types)){
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/js/contextMenu.css\" type=\"text/css\"></link>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/js/contextMenu.js\"></script>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/js/menu.js\"></script>\n");
		}
		if(oConvertUtils.isIn("Validform", types)){
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/Validform/css/style.css\" type=\"text/css\"></link>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/Validform/js/Validform_v5.3.1_min.js\"></script>\n");
		}
		if(oConvertUtils.isIn("fancybox", types)){
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/fancybox/source/jquery.fancybox.css\" type=\"text/css\"></link>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/fancybox/source/jquery.fancybox.pack.js\"></script>\n");
		}
		if(oConvertUtils.isIn("dialog", types)){
			sb.append("<script type=\"text/javascript\" src=\"plug-in/jquery-plugs/dialog/js/jquery.dialog.js\"></script>\n");
		}
		if(oConvertUtils.isIn("dataTables", types)){
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/data-tables/datatables.css\" type=\"text/css\"></link>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/data-tables/jquery.dataTables.min.js\"></script>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/data-tables/datatables.js\"></script>\n");
			
		}
		if(oConvertUtils.isIn("barn", types)){
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/barn/css/style.css\" type=\"text/css\"></link>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/barn/js/total.js\"></script>\n");
		}
		if(oConvertUtils.isIn("lhgDialog", types)){
			sb.append("<script type=\"text/javascript\" src=\"plug-in/lhgDialog/lhgdialog.min.js?skin=iblue\"></script>\n");
		}
		if(oConvertUtils.isIn("niceValidator", types)){
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/niceValidator/jquery.validator.css\" type=\"text/css\"></link>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/niceValidator/jquery.validator.js\"></script>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/niceValidator/local/zh_CN.js\"></script>\n");
		}
		if(oConvertUtils.isIn("select2", types)){
			sb.append("<link rel=\"stylesheet\" href=\"plug-in/assets/select2/css/select2.css\" type=\"text/css\"></link>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/select2/js/select2.js\"></script>\n");
			sb.append("<script type=\"text/javascript\" src=\"plug-in/assets/select2/js/select2_locale_zh-CN.js\"></script>\n");
			
		}
		if(oConvertUtils.isIn("inputMask", types)){
			sb.append("<script type=\"text/javascript\" src=\"plug-in/jquery-plugs/inputMask/jquery.inputmask.bundle.min.js\"></script>\n");
			
		}
		try {
			out.print(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	

}
