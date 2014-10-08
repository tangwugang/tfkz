package org.takinframework.web.buss.entity;

import java.util.Date;

import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:JwebDepotOut表
 * @Description: 业务粮仓仓外表
 * @date 2014-06-17
 * @version V1.0   
 *
 */
public class JwebDepotOut{
	public String id;//主键
	public String createBy;//创建者
	public String createName;//创建者名
	public Date createDate;//创建时间
	public Date updateDate;//更新时间
	public String updateBy;//更新者
	public String updateName;//更新者名
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateName() {
		return createName;
	}
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	
	
	
	

}