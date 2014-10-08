package org.takinframework.web.buss.entity;

import org.takinframework.core.model.BaseEntity;
import org.takinframework.core.util.StringUtil;


/**
 * 前端仓房信息对表单多个参数的封装
 * @author twg
 *
 */
@SuppressWarnings("serial")
public class ParamsOfBarn extends BaseEntity{
	private String type;// 设备类型
	private String no;//   设备编号
	private String place;//   位置
	private String version;//   型号
	private String power;//   功率(kw)
	
	private String whTime;// 维护日期
	private String whName;// 维护项目名称
	private String whQiKua;// 维护情况
	private String whBeiZ;// 维护备注
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getWhTime() {
		return whTime;
	}
	public void setWhTime(String whTime) {
		this.whTime = whTime;
	}
	public String getWhName() {
		return whName;
	}
	public void setWhName(String whName) {
		this.whName = whName;
	}
	public String getWhQiKua() {
		return whQiKua;
	}
	public void setWhQiKua(String whQiKua) {
		this.whQiKua = whQiKua;
	}
	public String getWhBeiZ() {
		return whBeiZ;
	}
	public void setWhBeiZ(String whBeiZ) {
		this.whBeiZ = whBeiZ;
	}
	
	
	
	
	
	

}
