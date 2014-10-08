package org.takinframework.web.system.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;
import org.takinframework.core.model.BaseEntity;

/**   
 * @Title:SysUser表
 * @Description: 系统用户表
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SysUser extends BaseEntity {
	private String userName;//   用户名
	
	private String barnNo;// 分配的仓房编号
	
	@NotBlank
	public String getUserName() {
	public byte[] getSignature() {
		return signature;
	}
	public void setSignature(byte[] signature) {
		this.signature = signature;
	}
	public String getSignatureFile() {
	public String getBarnNo() {
		return barnNo;
	}
	public void setBarnNo(String barnNo) {
		this.barnNo = barnNo;
	}
	
	
	
	
	

}