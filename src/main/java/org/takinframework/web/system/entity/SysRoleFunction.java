package org.takinframework.web.system.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:SysRoleFunction表
 * @Description: 系统角色菜单表
 * @date 2014-06-07
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class SysRoleFunction extends BaseEntity{
		private String roleId;//   角色id	private String funcId;//   菜单id	private String operation;//   操作码	public String getRoleId() {	    return this.roleId;	}	public void setRoleId(String roleId) {	    this.roleId=roleId;	}	public String getFuncId() {	    return this.funcId;	}	public void setFuncId(String funcId) {	    this.funcId=funcId;	}	public String getOperation() {	    return this.operation;	}	public void setOperation(String operation) {	    this.operation=operation;	}

}
