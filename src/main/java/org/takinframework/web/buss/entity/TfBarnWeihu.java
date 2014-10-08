package org.takinframework.web.buss.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:TfBarnWeihu表
 * @Description: 通风控制仓房维护表
 * @date 2014-08-19
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class TfBarnWeihu extends BaseEntity{
		private String whTime;//   维护日期	private String whName;//   维护保养项目名称	private String whQiKua;//   维护情况	private String whBeiZ;//   备注	private String tfBarnId;//   仓房表id	public String getWhTime() {	    return this.whTime;	}	public void setWhTime(String whTime) {	    this.whTime=whTime;	}	public String getWhName() {	    return this.whName;	}	public void setWhName(String whName) {	    this.whName=whName;	}	public String getWhQiKua() {	    return this.whQiKua;	}	public void setWhQiKua(String whQiKua) {	    this.whQiKua=whQiKua;	}	public String getWhBeiZ() {	    return this.whBeiZ;	}	public void setWhBeiZ(String whBeiZ) {	    this.whBeiZ=whBeiZ;	}	public String getTfBarnId() {	    return this.tfBarnId;	}	public void setTfBarnId(String tfBarnId) {	    this.tfBarnId=tfBarnId;	}

}
