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
		private String funcName;//   菜单名称
	private String funcAlias; // 菜单别名(唯一)	private String parentId = String.valueOf("0");//   父id	private String funcUrl;//   菜单url地址	private String icon;//   菜单图标String.valueOf("plug-in/ligerui/default/images/resicon/tree_file.gif");	private Short funcOrder = Short.valueOf("0");//   菜单排序（默认排序0）	private Short isShow = Short.valueOf("1");//   菜单是否显示0=不显示1=显示	private Short isFolder = Short.valueOf("0");//   默认无子节点	private Short isOpen = Short.valueOf("0");//   菜单是否打开0=关闭1=打开	private Short funcLevel = Short.valueOf("0");//   菜单等级(默认等级0)	private String funcIframe;//   菜单地址打开方式iframe、tab	private String operate;// 执行菜单的动作add、edit、del  
	private String funcClass;//菜单class
	private String funcCss;//菜单CSS
		public String getFuncName() {	    return this.funcName;	}	public void setFuncName(String funcName) {	    this.funcName=funcName;	}	public String getParentId() {	    return this.parentId;	}	public void setParentId(String parentId) {	    this.parentId=parentId;	}	public String getFuncUrl() {	    return this.funcUrl;	}	public void setFuncUrl(String funcUrl) {	    this.funcUrl=funcUrl;	}	public String getIcon() {	    return this.icon;	}	public void setIcon(String icon) {	    this.icon=icon;	}	public Short getFuncOrder() {	    return this.funcOrder;	}	public void setFuncOrder(Short funcOrder) {	    this.funcOrder=funcOrder;	}	public Short getIsShow() {	    return this.isShow;	}	public void setIsShow(Short isShow) {	    this.isShow=isShow;	}	public Short getIsFolder() {	    return this.isFolder;	}	public void setIsFolder(Short isFolder) {	    this.isFolder=isFolder;	}	public Short getIsOpen() {	    return this.isOpen;	}	public void setIsOpen(Short isOpen) {	    this.isOpen=isOpen;	}	public Short getFuncLevel() {	    return this.funcLevel;	}	public void setFuncLevel(Short funcLevel) {	    this.funcLevel=funcLevel;	}	public String getFuncIframe() {	    return this.funcIframe;	}	public void setFuncIframe(String funcIframe) {	    this.funcIframe=funcIframe;	}	public String getOperate() {	    return this.operate;	}	public void setOperate(String operate) {	    this.operate=operate;	}
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
