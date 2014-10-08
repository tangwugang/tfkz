package org.takinframework.web.system.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:SysIcon表
 * @Description: 系统图片表
 * @date 2014-07-10
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class SysIcon extends BaseEntity{
		private String iconName;//   图片名	private Short iconType;//   图片类型	private String iconPath;//   图片路径	private byte[] iconContent;//   图片内容	private String iconAlias;//   图片别名	private String extend;//   扩展名	public String getIconName() {	    return this.iconName;	}	public void setIconName(String iconName) {	    this.iconName=iconName;	}	public Short getIconType() {	    return this.iconType;	}	public void setIconType(Short iconType) {	    this.iconType=iconType;	}	public String getIconPath() {	    return this.iconPath;	}	public void setIconPath(String iconPath) {	    this.iconPath=iconPath;	}	public byte[] getIconContent() {	    return this.iconContent;	}	public void setIconContent(byte[] iconContent) {	    this.iconContent=iconContent;	}	public String getIconAlias() {	    return this.iconAlias;	}	public void setIconAlias(String iconAlias) {	    this.iconAlias=iconAlias;	}	public String getExtend() {	    return this.extend;	}	public void setExtend(String extend) {	    this.extend=extend;	}

}
