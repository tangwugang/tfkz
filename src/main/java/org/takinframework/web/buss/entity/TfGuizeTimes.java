package org.takinframework.web.buss.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:TfGuizeTimes表
 * @Description: 通风控制规则时间段表
 * @date 2014-08-22
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class TfGuizeTimes extends BaseEntity{
		private String tfGuiZeStartTime;//   通风规则时间段开始	private String tfGuiZeEndTime;//   通风规则时间段结束	private String tfGuiZeId;//   通风规则表ID	public String getTfGuiZeStartTime() {	    return this.tfGuiZeStartTime;	}	public void setTfGuiZeStartTime(String tfGuiZeStartTime) {	    this.tfGuiZeStartTime=tfGuiZeStartTime;	}	public String getTfGuiZeEndTime() {	    return this.tfGuiZeEndTime;	}	public void setTfGuiZeEndTime(String tfGuiZeEndTime) {	    this.tfGuiZeEndTime=tfGuiZeEndTime;	}	public String getTfGuiZeId() {	    return this.tfGuiZeId;	}	public void setTfGuiZeId(String tfGuiZeId) {	    this.tfGuiZeId=tfGuiZeId;	}

}
