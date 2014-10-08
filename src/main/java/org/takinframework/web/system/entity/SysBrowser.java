package org.takinframework.web.system.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:SysBrowser表
 * @Description: 浏览器是否活跃监控表
 * @date 2014-08-04
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class SysBrowser extends BaseEntity{
		private String sessionId;//   session的ID	private String userAgent;//   操作用户代理信息	private String ip;//   	public String getSessionId() {	    return this.sessionId;	}	public void setSessionId(String sessionId) {	    this.sessionId=sessionId;	}	public String getUserAgent() {	    return this.userAgent;	}	public void setUserAgent(String userAgent) {	    this.userAgent=userAgent;	}	public String getIp() {	    return this.ip;	}	public void setIp(String ip) {	    this.ip=ip;	}

}
