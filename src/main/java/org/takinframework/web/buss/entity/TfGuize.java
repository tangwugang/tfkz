package org.takinframework.web.buss.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:TfGuize表
 * @Description: 通风控制规则表
 * @date 2014-08-22
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class TfGuize extends BaseEntity{
		private String tfGuiZeName;//   通风规则名称	private Short tfMuDi;//   通风目的0-降温1-降水2-均温3-调质4-散热	private Short tfWenShiDuTime;//   温湿度监测时间间隔(分钟)	private String tfWenShiDuStart = String.valueOf("");//   温湿度执行条件(0粮温1气温0低1高)0,1,1,10,1,20,	private String tfWenShiDuEnd = String.valueOf("");//   温湿度终止条件(0粮温1气温0低1高)0,1,1,10,1,20,	private String status = String.valueOf("N");;//   状态(Y已启动、N未启动)	public String getTfGuiZeName() {	    return this.tfGuiZeName;	}	public void setTfGuiZeName(String tfGuiZeName) {	    this.tfGuiZeName=tfGuiZeName;	}	public Short getTfMuDi() {	    return this.tfMuDi;	}	public void setTfMuDi(Short tfMuDi) {	    this.tfMuDi=tfMuDi;	}	public Short getTfWenShiDuTime() {	    return this.tfWenShiDuTime;	}	public void setTfWenShiDuTime(Short tfWenShiDuTime) {	    this.tfWenShiDuTime=tfWenShiDuTime;	}	public String getTfWenShiDuStart() {	    return this.tfWenShiDuStart;	}	public void setTfWenShiDuStart(String tfWenShiDuStart) {	    this.tfWenShiDuStart=tfWenShiDuStart;	}	public String getTfWenShiDuEnd() {	    return this.tfWenShiDuEnd;	}	public void setTfWenShiDuEnd(String tfWenShiDuEnd) {	    this.tfWenShiDuEnd=tfWenShiDuEnd;	}	public String getStatus() {	    return this.status;	}	public void setStatus(String status) {	    this.status=status;	}

}
