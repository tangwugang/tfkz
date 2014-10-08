package org.takinframework.web.system.entity;

import org.takinframework.core.model.BaseEntity;

/**
 * 系统角色机构表
 * @author twg
 *
 */
@SuppressWarnings("serial")
public class SysRoleDepart extends BaseEntity {
	private String roleId;
	private String departId;
	private Short allowDel = 0;//是否可以删除(在组织授权的不可以删除0,不可以删除,1,可以删除)
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getDepartId() {
		return departId;
	}
	public void setDepartId(String departId) {
		this.departId = departId;
	}
	public Short getAllowDel() {
		return allowDel;
	}
	public void setAllowDel(Short allowDel) {
		this.allowDel = allowDel;
	}
	
	

}
