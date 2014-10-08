package org.takinframework.tag.core.ui;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.takinframework.core.util.ApplicationContextUtil;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.StringUtil;
import org.takinframework.web.system.entity.SysType;
import org.takinframework.web.system.service.SystemService;

import com.google.gson.Gson;

/**
 * 字典下拉框
 * @author twg
 *
 */
@SuppressWarnings("serial")
public class DictSelectTag extends TagSupport {
	
	private String typeGroupCode; // 数据字典类型(可选)
	private String field; // 选择表单的Name EAMPLE:<select name="selectName" id = ""
							// />
	private String id; // 选择表单ID EAMPLE:<select name="selectName" id = "" />
	private String defaultVal; // 默认值
	private String divClass; // DIV样式
	private String divStyle;// DIV样式
	private String labelClass; // Label样式
	private String labelStyle; // Label样式
	private String selectStyle;// 控件样式style
	private String selectClass;// 控件样式class
	private String title; // label显示值
	private boolean hasLabel = true; // 是否显示label
	private String type;// 控件类型select|radio|checkbox
	private String dataTable;// 自定义表
	private String dataField;// 自定义表的匹配字段-字典的编码值
	private String dataText;// 自定义表的显示文本-字典的显示值
	private String dataType;// 自定义表的类型 - 字典的类型
	private String orderBy = "id ";// 自定义排序
	private String extendParams;//扩展参数
	private boolean hasMultiple = false;//是否多选
	private boolean hasDisabled = false;//是否disabled

	
	@Autowired
	private static SystemService systemService;

	public int doStartTag() throws JspTagException {
		return EVAL_PAGE;
	}

	public int doEndTag() throws JspTagException {
		try {
			JspWriter out = this.pageContext.getOut();
			out.print(end().toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	@SuppressWarnings("unchecked")
	public StringBuffer end() {
		StringBuffer sb = new StringBuffer();
		if (StringUtil.isBlank(divClass)) {
			divClass = "form"; // 默认form样式
		}
		if (StringUtil.isBlank(labelClass)) {
			labelClass = "Validform_label"; // 默认label样式
		}
		if (hasLabel) {
			sb.append("<div class=\"" + divClass + "\" style=\""+divStyle+"\">");
			sb.append("<label class=\"" + labelClass + "\"  style=\""+labelStyle+"\">");
		}
		if (StringUtil.isNotBlank(this.title)) {
			sb.append(this.title);
		}
		sb.append("</label>");
		if (dataTable != null) {
			List<Map<String, Object>> list = queryDic(dataType,orderBy);
			if ("radio".equals(type)) {
				for (Map<String, Object> map : list) {
					radio(map.get("text").toString(), map.get("field")
							.toString(), sb);
				}
			} else if ("checkbox".equals(type)) {
				for (Map<String, Object> map : list) {
					checkbox(map.get("text").toString(), map.get("field")
							.toString(), sb);
				}
			} else if("text".equals(type)){
				for (Map<String, Object> map : list) {
					text(map.get("text").toString(), map.get("field")
							.toString(), sb);
				}
			}else {
				sb.append("<select name=\"" + field + "\"");
				if(StringUtil.isNotBlank(selectStyle)){
					sb.append(" style=\""+selectStyle+"\"");
				}
				if(StringUtil.isNotBlank(selectClass)){
					sb.append(" class=\""+selectClass+"\"");
				}
				if (!StringUtil.isBlank(this.id)) {
					sb.append(" id=\"" + id + "\"");
				}
				//增加扩展属性
				if (!StringUtil.isBlank(this.extendParams)) {
					Gson gson = new Gson();
					Map<String, String> mp = gson.fromJson(extendParams, Map.class);
					for(Map.Entry<String, String> entry: mp.entrySet()) { 
						sb.append(entry.getKey()+"=\"" + entry.getValue() + "\"");
						} 
				}
				//多选
				if(hasMultiple){
					sb.append(" multiple");
				}
				if(hasDisabled){
					sb.append(" disabled");
				}
				sb.append(">");
				if(hasMultiple && defaultVal.contains("All")){//多选
					sb.append(" <option value=\"All\" selected=\"selected\">全部</option>");
				}else if(hasMultiple && !defaultVal.contains("All")){
					sb.append(" <option value=\"All\" >全部</option>");
				}
				if(!hasMultiple){
					sb.append(" <option value=\"\" >请选择</option>");
				}
				for (Map<String, Object> map : list) {
					select(map.get("text").toString(), map.get("field")
							.toString(), sb);
				}
				sb.append("</select>");
			}
		} else {
			systemService = ApplicationContextUtil.getContext().getBean(
					SystemService.class);
			
			sb.append("<select name=\"" + field + "\"");
//			//增加扩展属性
			if (!StringUtil.isBlank(this.extendParams)) {
				Gson gson = new Gson();
				Map<String, String> mp = gson.fromJson(extendParams, Map.class);
				for(Map.Entry<String, String> entry: mp.entrySet()) { 
					sb.append(" "+entry.getKey()+"=\"" + entry.getValue() + "\"");
					} 
			}
			if(StringUtil.isNotBlank(selectStyle)){
				sb.append(" style=\""+selectStyle+"\"");
			}
			if(StringUtil.isNotBlank(selectClass)){
				sb.append(" class=\""+selectClass+"\"");
			}
			if (!StringUtil.isBlank(this.id)) {
				sb.append(" id=\"" + id + "\"");
			}
			sb.append(">");
			sb.append(" <option value=\"\" >请选择</option>");
			try {
				List<SysType> sysTypes = systemService.findAll(SysType.class, "methord1");
				for (SysType type : sysTypes) {
					select(type.getType(), type.getType(), sb);
				}
			} catch (Exception e) {
				LogUtil.error("获取SysType失败", e);
			}
			sb.append("</select>");
		}
		if (hasLabel) {
			sb.append("</div>");
		}
		if(hasMultiple){
			sb.append("<script type=\"text/javascript\">");
			sb.append("$(\"#"+id+"\").select2();");
			sb.append("</script>");
		}
		return sb;
	}
	/**
	 * 文本框方法
	 * @param name
	 * @param code
	 * @param sb
	 */
	private void text(String name, String code, StringBuffer sb) {
		if (code.equals(this.defaultVal)) {
			sb.append("<input name='"+field+"'"+" id='"+id+"' value='"+name+"' readOnly = 'readOnly' />");
		} else {
		}
	}


	/**
	 * 单选框方法
	 * 
	 * @作者：Alexander
	 * 
	 * @param name
	 * @param code
	 * @param sb
	 */
	private void radio(String name, String code, StringBuffer sb) {
		if (code.equals(this.defaultVal)) {
			sb.append("<input type=\"radio\" name=\"" + field
					+ "\" checked=\"checked\" value=\"" + code + "\"");
			if (!StringUtil.isBlank(this.id)) {
				sb.append(" id=\"" + id + "\"");
			}
			sb.append(" />");
		} else {
			sb.append("<input type=\"radio\" name=\"" + field + "\" value=\""
					+ code + "\"");
			if (!StringUtil.isBlank(this.id)) {
				sb.append(" id=\"" + id + "\"");
			}
			sb.append(" />");
		}
		sb.append(name);
	}

	/**
	 * 复选框方法
	 * 
	 * @作者：Alexander
	 * 
	 * @param name
	 * @param code
	 * @param sb
	 */
	private void checkbox(String name, String code, StringBuffer sb) {
		String[] values = this.defaultVal.split(",");
		Boolean checked = false;
		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			if (code.equals(value)) {
				checked = true;
				break;
			}
			checked = false;
		}
		if(checked){
			sb.append("<input type=\"checkbox\" name=\"" + field
					+ "\" checked=\"checked\" value=\"" + code + "\"");
			if (!StringUtil.isBlank(this.id)) {
				sb.append(" id=\"" + id + "\"");
			}
			sb.append(" />");
		} else {
			sb.append("<input type=\"checkbox\" name=\"" + field
					+ "\" value=\"" + code + "\"");
			if (!StringUtil.isBlank(this.id)) {
				sb.append(" id=\"" + id + "\"");
			}
			sb.append(" />");
		}
		sb.append(name);
	}

	/**
	 * 选择框方法
	 * 
	 * @作者：Alexander
	 * 
	 * @param name
	 * @param code
	 * @param sb
	 */
	private void select(String name, String code, StringBuffer sb) {
		String[] values = this.defaultVal.split(",");
		Boolean select = false;
		
		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			if (code.equals(value)) {
				sb.append(" <option value=\"" + code + "\" selected=\"selected\">");
				select = true;
				break;
			}
			select = false;
		}
		
		if(!select){
			sb.append(" <option value=\"" + code + "\">");
		}
		
		sb.append(name);
		sb.append(" </option>");
	}

	/**
	 * 查询自定义数据字典
	 * 
	 * @作者：Alexander
	 */
	private List<Map<String, Object>> queryDic(String dataType,String order) {
		String sql = "select " + dataField + " as field," + dataText
				+ " as text from " + dataTable +" where 1=1 ";
		if(StringUtil.isNotEmpty(dataType)){
			sql += " and type='"+dataType+"' ";
		}
		if(StringUtil.isNotEmpty(order)){
			sql += " order by "+order;
		}
		systemService = ApplicationContextUtil.getContext().getBean(
				SystemService.class);
		List<Map<String, Object>> list = systemService.find(sql);
		return list;
	}

	public String getTypeGroupCode() {
		return typeGroupCode;
	}

	public void setTypeGroupCode(String typeGroupCode) {
		this.typeGroupCode = typeGroupCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDefaultVal() {
		return defaultVal;
	}

	public void setDefaultVal(String defaultVal) {
		this.defaultVal = defaultVal;
	}

	public String getDivClass() {
		return divClass;
	}

	public void setDivClass(String divClass) {
		this.divClass = divClass;
	}

	public String getLabelClass() {
		return labelClass;
	}

	public void setLabelClass(String labelClass) {
		this.labelClass = labelClass;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isHasLabel() {
		return hasLabel;
	}

	public void setHasLabel(boolean hasLabel) {
		this.hasLabel = hasLabel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getDataTable() {
		return dataTable;
	}

	public void setDataTable(String dataTable) {
		this.dataTable = dataTable;
	}

	public String getDataField() {
		return dataField;
	}

	public void setDataField(String dataField) {
		this.dataField = dataField;
	}

	public String getDataText() {
		return dataText;
	}

	public void setDataText(String dataText) {
		this.dataText = dataText;
	}

	public String getExtendParams() {
		return extendParams;
	}

	public void setExtendParams(String extendParams) {
		this.extendParams = extendParams;
	}

	public String getDivStyle() {
		return divStyle;
	}

	public void setDivStyle(String divStyle) {
		this.divStyle = divStyle;
	}

	public String getLabelStyle() {
		return labelStyle;
	}

	public void setLabelStyle(String labelStyle) {
		this.labelStyle = labelStyle;
	}

	public String getSelectStyle() {
		return selectStyle;
	}

	public void setSelectStyle(String selectStyle) {
		this.selectStyle = selectStyle;
	}

	public String getSelectClass() {
		return selectClass;
	}

	public void setSelectClass(String selectClass) {
		this.selectClass = selectClass;
	}

	public boolean isHasMultiple() {
		return hasMultiple;
	}

	public void setHasMultiple(boolean hasMultiple) {
		this.hasMultiple = hasMultiple;
	}

	public boolean isHasDisabled() {
		return hasDisabled;
	}

	public void setHasDisabled(boolean hasDisabled) {
		this.hasDisabled = hasDisabled;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	

	
	
	
	
	
	
}

