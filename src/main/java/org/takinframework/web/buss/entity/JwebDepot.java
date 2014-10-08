package org.takinframework.web.buss.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.takinframework.core.model.BaseEntity;

import com.google.common.collect.Lists;

/**   
 * @Title:JwebDepot表
 * @Description: 业务粮仓表
 * @date 2014-06-17
 * @version V1.0   
 *
 */
@XmlRootElement
public class JwebDepot{
	public String id;//主键
	public String createBy;//创建者
	public String createName;//创建者名
	public Date createDate;//创建时间
	public Date updateDate;//更新时间
	public String updateBy;//更新者
	public String updateName;//更新者名
		private String number;//   仓库编号
	
	private List<JwebDepotOut> depotOut = Lists.newArrayList();//仓外表
		public String getNumber() {	    return this.number;	}	public void setNumber(String number) {	    this.number=number;	}
	
	public List<JwebDepotOut> getDepotOut() {
		return depotOut;
	}
	public void setDepotOut(List<JwebDepotOut> depotOut) {
		this.depotOut = depotOut;
	}
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
