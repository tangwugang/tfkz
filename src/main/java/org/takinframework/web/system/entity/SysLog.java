package org.takinframework.web.system.entity;

import java.util.Date;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:SysLog表
 * @Description: 系统日志表
 * @date 2014-07-31
 * @version V1.0   
 *
 */
 @SuppressWarnings("serial")
public class SysLog extends BaseEntity{
		private Short logLevel;//   日志级别	private Short type;//   日志类型	private String ip;//   操作用户的IP地址	private String requestUrl;//   操作的URI	private String method;//   操作的方式	private String params;//   操作提交的数据	private String userAgent;//   操作用户代理信息	private String exception;//   异常信息	private String content;//   返回内容	public Short getLogLevel() {	    return this.logLevel;	}	public void setLogLevel(Short logLevel) {	    this.logLevel=logLevel;	}	public Short getType() {	    return this.type;	}	public void setType(Short type) {	    this.type=type;	}	public String getIp() {	    return this.ip;	}	public void setIp(String ip) {	    this.ip=ip;	}	public String getRequestUrl() {	    return this.requestUrl;	}	public void setRequestUrl(String requestUrl) {	    this.requestUrl=requestUrl;	}	public String getMethod() {	    return this.method;	}	public void setMethod(String method) {	    this.method=method;	}	public String getParams() {	    return this.params;	}	public void setParams(String params) {	    this.params=params;	}	public String getUserAgent() {	    return this.userAgent;	}	public void setUserAgent(String userAgent) {	    this.userAgent=userAgent;	}	public String getException() {	    return this.exception;	}	public void setException(String exception) {	    this.exception=exception;	}	public String getContent() {	    return this.content;	}	public void setContent(String content) {	    this.content=content;	}

}
