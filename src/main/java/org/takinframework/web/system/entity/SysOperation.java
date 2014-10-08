package org.takinframework.web.system.entity;

import org.takinframework.core.model.BaseEntity;

/**
 * 系统权限操作表
 * @author twg
 *
 */
@SuppressWarnings("serial")
public class SysOperation extends BaseEntity {
	private String operName;//权限名
	private String operCode;//权限码add、edit、del等
	private String operIcon;//权限图片
	private Short enabled;//是否可用0=不可用1=可用
	private String iconId;//图片表Id
	private String funcId;//菜单表Id
	
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public String getOperCode() {
		return operCode;
	}
	public void setOperCode(String operCode) {
		this.operCode = operCode;
	}
	public String getOperIcon() {
		return operIcon;
	}
	public void setOperIcon(String operIcon) {
		this.operIcon = operIcon;
	}
	public Short getEnabled() {
		return enabled;
	}
	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}
	public String getIconId() {
		return iconId;
	}
	public void setIconId(String iconId) {
		this.iconId = iconId;
	}
	public String getFuncId() {
		return funcId;
	}
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}
	
	
	
}
