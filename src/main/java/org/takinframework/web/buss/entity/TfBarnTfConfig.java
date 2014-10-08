package org.takinframework.web.buss.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:TfBarnTfConfig表
 * @Description: 通风控制仓房设置表
 * @date 2014-09-04
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class TfBarnTfConfig extends BaseEntity{
		private String barnType = String.valueOf("");//   粮仓类型(类型一)	private String barnNo;//   粮仓编号	private Short jobStatus;//   执行job后指令(1成功0失败)	private String beiZhu;//   备注	private String tfGuiZeId;//   通风规则ID	public String getBarnType() {	    return this.barnType;	}	public void setBarnType(String barnType) {	    this.barnType=barnType;	}	public String getBarnNo() {	    return this.barnNo;	}	public void setBarnNo(String barnNo) {	    this.barnNo=barnNo;	}	public Short getJobStatus() {	    return this.jobStatus;	}	public void setJobStatus(Short jobStatus) {	    this.jobStatus=jobStatus;	}	public String getBeiZhu() {	    return this.beiZhu;	}	public void setBeiZhu(String beiZhu) {	    this.beiZhu=beiZhu;	}	public String getTfGuiZeId() {	    return this.tfGuiZeId;	}	public void setTfGuiZeId(String tfGuiZeId) {	    this.tfGuiZeId=tfGuiZeId;	}

}
