package org.takinframework.web.system.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:SysDepart表
 * @Description: 系统机构表
 * @date 2014-06-07
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class SysDepart extends BaseEntity{
		private String departName;//   机构名	private String departCode;//   机构编号（编号唯一）	private String parentDepartId;//   父级机构	private String description;//   机构描述	private Short departType;//   机构类型0=集团1=公司2=部门3=其他组织	private String master;//   机构负责人	private String departTel;//   机构电话	private String departAddress;//   机构地址	private Short departNature;//   机构性质0=国有1=民营2=股份制3=合资4=外资	public String getDepartName() {	    return this.departName;	}	public void setDepartName(String departName) {	    this.departName=departName;	}	public String getDepartCode() {	    return this.departCode;	}	public void setDepartCode(String departCode) {	    this.departCode=departCode;	}	public String getParentDepartId() {	    return this.parentDepartId;	}	public void setParentDepartId(String parentDepartId) {	    this.parentDepartId=parentDepartId;	}	public String getDescription() {	    return this.description;	}	public void setDescription(String description) {	    this.description=description;	}	public Short getDepartType() {	    return this.departType;	}	public void setDepartType(Short departType) {	    this.departType=departType;	}	public String getMaster() {	    return this.master;	}	public void setMaster(String master) {	    this.master=master;	}	public String getDepartTel() {	    return this.departTel;	}	public void setDepartTel(String departTel) {	    this.departTel=departTel;	}	public String getDepartAddress() {	    return this.departAddress;	}	public void setDepartAddress(String departAddress) {	    this.departAddress=departAddress;	}	public Short getDepartNature() {	    return this.departNature;	}	public void setDepartNature(Short departNature) {	    this.departNature=departNature;	}

}
