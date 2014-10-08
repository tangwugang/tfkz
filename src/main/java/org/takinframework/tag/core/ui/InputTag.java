package org.takinframework.tag.core.ui;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.takinframework.core.util.ApplicationContextUtil;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.StringUtil;
import org.takinframework.web.system.entity.SysType;
import org.takinframework.web.system.service.SystemService;

import com.google.gson.Gson;
/**
 * 表单input标签
 * @author twg
 *
 */
@SuppressWarnings("serial")
public class InputTag extends TagSupport {
	private String type;//;text,hidden,button等
	private String name;// name
	private String id;// id 
	private String defaultVal; // 默认值
	private String divClass; // DIV样式
	private String divStyle;// DIV样式
	private String labelClass; // Label样式
	private String labelStyle; // Label样式
	private String inputClass;// input样式
	private String inputStyle;// input样式
	private String title; // label显示值
	private boolean hasLabel = true; // 是否显示label
	private String extendParams;//扩展参数
	private String maxlength;//input 的maxlength
	private boolean hasDisabled = false;//是否disabled
	
	
	
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
		sb.append("<input name=\"" + name + "\"");
		if(StringUtil.isNotBlank(type)){
			sb.append(" type=\""+type+"\"");
		}
//			//增加扩展属性
			if (!StringUtil.isBlank(this.extendParams)) {
				Gson gson = new Gson();
				Map<String, String> mp = gson.fromJson(extendParams, Map.class);
				for(Map.Entry<String, String> entry: mp.entrySet()) { 
					sb.append(" "+entry.getKey()+"=\"" + entry.getValue() + "\"");
					} 
			}
			if(StringUtil.isNotBlank(inputStyle)){
				sb.append(" style=\""+inputStyle+"\"");
			}
			if(StringUtil.isNotBlank(inputClass)){
				sb.append(" class=\""+inputClass+"\"");
			}
			if (!StringUtil.isBlank(this.id)) {
				sb.append(" id=\"" + id + "\"");
			}
			if(StringUtil.isNotBlank(defaultVal)){
				sb.append(" value=\""+defaultVal+"\"");
			}
			if(StringUtil.isNotBlank(maxlength)){
				sb.append(" maxlength=\""+maxlength+"\" ");
			}
			if(hasDisabled){
				sb.append(" disabled");
			}
			sb.append("/>");
		
		if (hasLabel) {
			sb.append("</div>");
		}
		return sb;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDivStyle() {
		return divStyle;
	}

	public void setDivStyle(String divStyle) {
		this.divStyle = divStyle;
	}

	public String getLabelClass() {
		return labelClass;
	}

	public void setLabelClass(String labelClass) {
		this.labelClass = labelClass;
	}

	public String getLabelStyle() {
		return labelStyle;
	}

	public void setLabelStyle(String labelStyle) {
		this.labelStyle = labelStyle;
	}

	public String getInputClass() {
		return inputClass;
	}

	public void setInputClass(String inputClass) {
		this.inputClass = inputClass;
	}

	public String getInputStyle() {
		return inputStyle;
	}

	public void setInputStyle(String inputStyle) {
		this.inputStyle = inputStyle;
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

	public String getExtendParams() {
		return extendParams;
	}

	public void setExtendParams(String extendParams) {
		this.extendParams = extendParams;
	}

	public String getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}

	public boolean isHasDisabled() {
		return hasDisabled;
	}

	public void setHasDisabled(boolean hasDisabled) {
		this.hasDisabled = hasDisabled;
	}
	
	

}
