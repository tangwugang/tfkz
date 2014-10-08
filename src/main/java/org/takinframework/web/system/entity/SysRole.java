package org.takinframework.web.system.entity;

import java.util.Date;
import java.util.List;

import org.takinframework.core.model.BaseEntity;

import com.google.common.collect.Lists;

/**   
 * @Title:SysRole表
 * @Description: 系统角色表
 * @date 2014-06-07
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class SysRole extends BaseEntity{
	private String roleName;//   角色名	private Short allowDel = Short.valueOf("1");//   允许删除0=不允许1=允许	private Short allowEdit = Short.valueOf("1");//   允许编辑0=不允许1=允许	private Short enabled = Short.valueOf("1");//   是否可用0=不可用1可用
	public String getRoleName() {	    return this.roleName;	}	public void setRoleName(String roleName) {	    this.roleName=roleName;	}	public Short getAllowDel() {	    return this.allowDel;	}	public void setAllowDel(Short allowDel) {	    this.allowDel=allowDel;	}	public Short getAllowEdit() {	    return this.allowEdit;	}	public void setAllowEdit(Short allowEdit) {	    this.allowEdit=allowEdit;	}	public Short getEnabled() {	    return this.enabled;	}	public void setEnabled(Short enabled) {	    this.enabled=enabled;	}
	
	
	

}
