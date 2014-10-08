package org.takinframework.web.system.entity;

import java.util.List;
import java.util.Map;

/**
 * 在线用户对象
 * 
 * @author twg
 */
public class Client implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 用户
	 */
	private SysUser user;
	/**
	 * 角色
	 */
	private List<SysRole> sysRoles;
	/**
	 * 用户角色
	 */
	private List<SysUserRole> sysUserRoles;
	
	/**
	 * 权限菜单
	 */
	private Map<String, SysFunction> functions;
	
	/**
	 * 权限菜单
	 */
	private List<SysFunction> sysFunctions;
	/**
	 * 用户IP
	 */
	private java.lang.String ip;
	/**
	 *登录时间
	 */
	private java.util.Date loginDateTime;

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public Map<String, SysFunction> getFunctions() {
		return functions;
	}

	public void setFunctions(Map<String, SysFunction> functions) {
		this.functions = functions;
	}

	public java.lang.String getIp() {
		return ip;
	}

	public void setIp(java.lang.String ip) {
		this.ip = ip;
	}

	public java.util.Date getLoginDateTime() {
		return loginDateTime;
	}

	public void setLoginDateTime(java.util.Date loginDateTime) {
		this.loginDateTime = loginDateTime;
	}

	public List<SysFunction> getSysFunctions() {
		return sysFunctions;
	}

	public void setSysFunctions(List<SysFunction> sysFunctions) {
		this.sysFunctions = sysFunctions;
	}

	public List<SysUserRole> getSysUserRoles() {
		return sysUserRoles;
	}

	public void setSysUserRoles(List<SysUserRole> sysUserRoles) {
		this.sysUserRoles = sysUserRoles;
	}

	public List<SysRole> getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(List<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}
	
	

	
	
	
	

	


}
