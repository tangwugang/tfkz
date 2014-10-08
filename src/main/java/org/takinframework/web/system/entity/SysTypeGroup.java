package org.takinframework.web.system.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.takinframework.core.model.BaseEntity;

/**
 * 系统字典类型表
 * @author twg
 *
 */
@SuppressWarnings("serial")
public class SysTypeGroup extends BaseEntity {
	public static Map<String, SysTypeGroup> allTypeGroups = new HashMap<String,SysTypeGroup>();
	public static Map<String, List<SysType>> allTypes = new HashMap<String,List<SysType>>();
	private String typeGroupCode;//字典类型码
	private String typeGroupName;//字典类型名
	
	public String getTypeGroupCode() {
		return typeGroupCode;
	}
	public void setTypeGroupCode(String typeGroupCode) {
		this.typeGroupCode = typeGroupCode;
	}
	public String getTypeGroupName() {
		return typeGroupName;
	}
	public void setTypeGroupName(String typeGroupName) {
		this.typeGroupName = typeGroupName;
	}
	
	

}
