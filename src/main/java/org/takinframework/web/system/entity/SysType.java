package org.takinframework.web.system.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:SysType表
 * @Description: 系统参数表
 * @date 2014-08-12
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class SysType extends BaseEntity{
		private String typeCode;//   字典码	private String typeName;//   字典名	private String type;//   类型	private String description;//   描述	private Short sort = Short.valueOf("0");//   排序	private String typeGroupId;//   字典类型组id	public String getTypeCode() {	    return this.typeCode;	}	public void setTypeCode(String typeCode) {	    this.typeCode=typeCode;	}	public String getTypeName() {	    return this.typeName;	}	public void setTypeName(String typeName) {	    this.typeName=typeName;	}	public String getType() {	    return this.type;	}	public void setType(String type) {	    this.type=type;	}	public String getDescription() {	    return this.description;	}	public void setDescription(String description) {	    this.description=description;	}	public Short getSort() {	    return this.sort;	}	public void setSort(Short sort) {	    this.sort=sort;	}	public String getTypeGroupId() {	    return this.typeGroupId;	}	public void setTypeGroupId(String typeGroupId) {	    this.typeGroupId=typeGroupId;	}

}
