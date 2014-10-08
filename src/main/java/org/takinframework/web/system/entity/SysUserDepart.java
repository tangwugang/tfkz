package org.takinframework.web.system.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:SysUserDepart表
 * @Description: 系统用户机构表
 * @date 2014-06-07
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class SysUserDepart extends BaseEntity{
		private String userId;//   用户id	private String departId;//   机构id	private Short isPrimary = Short.valueOf("0");//   是否为主要1=主要0=非主要	private Short isGradeManage = Short.valueOf("0");//   是否为分级管理员1=是0=不是	public String getUserId() {	    return this.userId;	}	public void setUserId(String userId) {	    this.userId=userId;	}	public String getDepartId() {	    return this.departId;	}	public void setDepartId(String departId) {	    this.departId=departId;	}	public Short getIsPrimary() {	    return this.isPrimary;	}	public void setIsPrimary(Short isPrimary) {	    this.isPrimary=isPrimary;	}	public Short getIsGradeManage() {	    return this.isGradeManage;	}	public void setIsGradeManage(Short isGradeManage) {	    this.isGradeManage=isGradeManage;	}

}
