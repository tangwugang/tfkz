package org.takinframework.web.buss.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:TfConfigDevices表
 * @Description: 通风控制仓房通风设置关联设备表
 * @date 2014-09-03
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class TfConfigDevices extends BaseEntity{
		private String tfBarnDevicesId;//   仓房设备id	private String status = String.valueOf("");//   设置时的状态(N关/停Y开/启)	private String cfMode;//   风机抽风方式OUT:吸出式IN:压入式	private String fkStatus;//   反馈状态(OK/error)	private String beiZhu;//   	private String tfGuiZeId;//   通风规则id	private String tfConfigId;//   通风设置id	public String getTfBarnDevicesId() {	    return this.tfBarnDevicesId;	}	public void setTfBarnDevicesId(String tfBarnDevicesId) {	    this.tfBarnDevicesId=tfBarnDevicesId;	}	public String getStatus() {	    return this.status;	}	public void setStatus(String status) {	    this.status=status;	}	public String getCfMode() {	    return this.cfMode;	}	public void setCfMode(String cfMode) {	    this.cfMode=cfMode;	}	public String getFkStatus() {	    return this.fkStatus;	}	public void setFkStatus(String fkStatus) {	    this.fkStatus=fkStatus;	}	public String getBeiZhu() {	    return this.beiZhu;	}	public void setBeiZhu(String beiZhu) {	    this.beiZhu=beiZhu;	}	public String getTfGuiZeId() {	    return this.tfGuiZeId;	}	public void setTfGuiZeId(String tfGuiZeId) {	    this.tfGuiZeId=tfGuiZeId;	}	public String getTfConfigId() {	    return this.tfConfigId;	}	public void setTfConfigId(String tfConfigId) {	    this.tfConfigId=tfConfigId;	}

}
