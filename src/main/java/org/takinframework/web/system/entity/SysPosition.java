package org.takinframework.web.system.entity;

import org.takinframework.core.model.BaseEntity;
import org.takinframework.core.util.StringUtil;

/**
 * 系统岗位表
 * @author twg
 *
 */
@SuppressWarnings("serial")
public class SysPosition extends BaseEntity {
	
	private String posName;//岗位名
	private String posDesc;//岗位描述
	private String parentId;//父id
	private String nodePath;//节点路径
	private String depth;//层级
	private Short isLeaf;//是否叶子1=是0=不是
	@SuppressWarnings("unused")
	private String isParent;//是否父节点true、false
	
	
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public String getPosDesc() {
		return posDesc;
	}
	public void setPosDesc(String posDesc) {
		this.posDesc = posDesc;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getNodePath() {
		return nodePath;
	}
	public void setNodePath(String nodePath) {
		this.nodePath = nodePath;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public Short getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(Short isLeaf) {
		this.isLeaf = isLeaf;
		if (StringUtil.isNotEmpty(isLeaf) && isLeaf.equals(1)) {
			this.isParent = "false";
		}else if (StringUtil.isNotEmpty(isLeaf) && isLeaf.equals(0)) {
			this.isParent = "true";
		}else {
			this.isParent = null;
		}
	}
	public String getIsParent() {
		if (this.isLeaf == null){
			 return "true";
		}
		return this.isLeaf.intValue() == 1?"false":"true";
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
		if (StringUtil.isNotEmpty(isParent) && isParent.equals("false")) {
			this.isLeaf = 1;
		}else if (StringUtil.isNotEmpty(isParent) && isParent.equals("true")) {
			this.isLeaf = 0;
		}else {
			this.isLeaf = null;
		}
	}
	
	
	

}
