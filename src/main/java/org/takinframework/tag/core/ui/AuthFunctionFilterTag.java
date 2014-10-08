package org.takinframework.tag.core.ui;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import org.takinframework.core.util.AuthFunctionUtil;
import org.takinframework.core.util.StringUtil;

/**
 * 菜单按钮权限filter
 * 
 * @author twg
 * 
 */
@SuppressWarnings("serial")
public class AuthFunctionFilterTag extends TagSupport {
	/**
	 * CSS样式
	 */
	private String css;
	/**
	 * 按钮名称
	 */
	private String name;
	/**
	 * 资源别名
	 */
	private String alias;
	/**
	 * 资源id
	 */
	private String id;
	/**
	 * a标签的原生href
	 */
	private String href;
	/**
	 * js跳转的url
	 */
	private String action;
	/**
	 * js事件
	 */
	private String onclick;
	/**
	 * a标签的打开方式
	 */
	private String target = "_self";
	/**
	 * 是否显示
	 */
	private boolean isShow = true;
	
	public int doStartTag() throws JspException {
		return super.doStartTag();
	}
	
	public int doEndTag() throws JspException {
		
		try {
			JspWriter out = this.pageContext.getOut();
				if(!isShow){
					out.print("");
				}else{
					if(hasRights(alias)){
						StringBuffer sb = new StringBuffer("<a ");
						if(StringUtil.isNotEmpty(id)){
							sb.append("id=\"" + this.id + "\" ");
						}
						if(StringUtil.isNotEmpty(alias)){
							sb.append("alias=\"" + this.alias + "\" ");
						}
						if(StringUtil.isNotEmpty(target)){
							sb.append("target=\"" + this.target + "\" ");
						}
						if(StringUtil.isNotEmpty(css)){
							sb.append(" class=\"" + this.css + "\" ");
						}
						if(StringUtil.isNotEmpty(href)){
							sb.append(" href=\"" + this.href + "\" ");
						}
						if(StringUtil.isNotEmpty(action)){
							sb.append(" action=\"" + this.action + "\" ");
						}else{
							sb.append(" action=\"" + funcUrl(alias) + "\" ");
						}
						if(StringUtil.isNotEmpty(onclick)){
							sb.append("onclick=\"" + this.onclick + "\" ");
						}
				    	sb.append(">");
				    	sb.append("<i class=\"icon-pencil\"></i>");
				    	sb.append(name);
				    	sb.append("</a>");
				    	out.print(sb.toString());
					}
					
				}
				out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
		
	}
	//判断是否有权限
	private boolean hasRights(String name){
		return AuthFunctionUtil.hasFuncPermission(name);
	}
	//获取菜单的url地址
	private String funcUrl(String name){
		return AuthFunctionUtil.getFuncUrl(name);
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public boolean isShow() {
		return isShow;
	}

	public void setShow(boolean isShow) {
		this.isShow = isShow;
	}
	
	
	
	

}
