package org.takinframework.web.system.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:SysUserRole表
 * @Description: 系统用户角色表
 * @date 2014-06-07
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class SysUserRole extends BaseEntity{
		private String userId;//   用户id	private String roleId;//   角色id	public String getUserId() {	    return this.userId;	}	public void setUserId(String userId) {	    this.userId=userId;	}	public String getRoleId() {	    return this.roleId;	}	public void setRoleId(String roleId) {	    this.roleId=roleId;	}

}
