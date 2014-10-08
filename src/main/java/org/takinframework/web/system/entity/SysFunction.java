package org.takinframework.web.system.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:SysFunction表
 * @Description: 系统菜单表
 * @date 2014-06-06
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class SysFunction extends BaseEntity{
	
	private String funcAlias; // 菜单别名(唯一)
	private String funcClass;//菜单class
	private String funcCss;//菜单CSS
	
	public String getFuncAlias() {
		return funcAlias;
	}
	public void setFuncAlias(String funcAlias) {
		this.funcAlias = funcAlias;
	}
	public String getFuncClass() {
		return funcClass;
	}
	public void setFuncClass(String funcClass) {
		this.funcClass = funcClass;
	}
	public String getFuncCss() {
		return funcCss;
	}
	public void setFuncCss(String funcCss) {
		this.funcCss = funcCss;
	}
	

}