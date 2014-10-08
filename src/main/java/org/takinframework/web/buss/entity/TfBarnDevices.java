package org.takinframework.web.buss.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:TfBarnDevices表
 * @Description: 通风控制仓房设备表
 * @date 2014-08-29
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class TfBarnDevices extends BaseEntity{
		private Short type = Short.valueOf("0");//   设备类型(0-风机1-窗)	private String no;//   设备编号	private String place;//   位置	private String version;//   型号	private Double power;//   功率(kw)	private String status = String.valueOf("N");//   风机/窗状态Y:开N:关	private String fkStatus;//   反馈状态	private String beiZhu;//   反馈备注	private String cfMode = String.valueOf("OUT");//   风机抽风方式OUT:吸出式IN:压入式	private String tfBarnId;//   通风控制仓房表id	public Short getType() {	    return this.type;	}	public void setType(Short type) {	    this.type=type;	}	public String getNo() {	    return this.no;	}	public void setNo(String no) {	    this.no=no;	}	public String getPlace() {	    return this.place;	}	public void setPlace(String place) {	    this.place=place;	}	public String getVersion() {	    return this.version;	}	public void setVersion(String version) {	    this.version=version;	}	public Double getPower() {	    return this.power;	}	public void setPower(Double power) {	    this.power=power;	}	public String getStatus() {	    return this.status;	}	public void setStatus(String status) {	    this.status=status;	}	public String getFkStatus() {	    return this.fkStatus;	}	public void setFkStatus(String fkStatus) {	    this.fkStatus=fkStatus;	}	public String getBeiZhu() {	    return this.beiZhu;	}	public void setBeiZhu(String beiZhu) {	    this.beiZhu=beiZhu;	}	public String getCfMode() {	    return this.cfMode;	}	public void setCfMode(String cfMode) {	    this.cfMode=cfMode;	}	public String getTfBarnId() {	    return this.tfBarnId;	}	public void setTfBarnId(String tfBarnId) {	    this.tfBarnId=tfBarnId;	}

}
