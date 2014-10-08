package org.takinframework.web.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.takinframework.core.util.ApplicationContextUtil;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.ResourceUtils;
import org.takinframework.core.util.StringUtil;
import org.takinframework.web.buss.entity.TfGuize;
import org.takinframework.web.system.entity.SysDepart;
import org.takinframework.web.system.entity.SysRole;
import org.takinframework.web.system.entity.SysType;
import org.takinframework.web.system.entity.SysTypeGroup;
import org.takinframework.web.system.service.SystemService;

import com.google.common.collect.Lists;

/**
 * WEB端用EL表达式获取属性值
 * @author twg
 *
 */
public class WebUtil {
	
	/**
	 * 获取值
	 * @param name 属性名
	 * @return
	 */
	public static String getSysName(String name){
		return ResourceUtils.getConfig(name);
	}
	/**
	 * 通过用户id,获取组织机构名
	 * @param userId 用户id
	 * @return
	 */
	public static String getDepartNameByUser(String userId){
		SystemService systemService = (SystemService) ApplicationContextUtil.getBean("systemService");
		List<SysDepart> sysDeparts = systemService.findList(SysDepart.class, "methord1", userId);
		if(sysDeparts.size()>0){
			return sysDeparts.get(0).getDepartName();
		}
		return "";
	}
	/**
	 * 通过规则id，获取通风目的
	 * @param tfGuiZeId
	 * @return
	 */
	public static String getTfMuDi(String tfGuiZeId){
		if(StringUtil.isNotBlank(tfGuiZeId)){
			SystemService systemService = (SystemService) ApplicationContextUtil.getBean("systemService");
			TfGuize tfGuize = new TfGuize();
			tfGuize.setId(tfGuiZeId);
			SysType sysType = new SysType();
			try {
				tfGuize = systemService.checkEntityExits(tfGuize);
				if(null != tfGuize.getTfMuDi()){
					sysType.setType("tf_mu_di");
					sysType.setTypeCode(Short.toString(tfGuize.getTfMuDi()));
					List<String> params = Lists.newArrayList();
					params.add("type");
					params.add("typeCode");
					sysType = systemService.checkEntityExits(sysType,params.toArray());
				}
			} catch (Exception e) {
				LogUtil.error("获取getTfMuDi失败", e);
			}
			return sysType.getTypeName();
		}
		return "";
		
		
	}
	/**
	 * 通过字典编码获取名称
	 * @param typeCode
	 * @return
	 */
	public static String getTypeName(String typeCode,String type){
		List<SysType> sysTypes = SysTypeGroup.allTypes.get("sysType");
		if(sysTypes.size()>0){
			for (SysType sysType : sysTypes) {
				if(sysType.getTypeCode().equals(typeCode) && 
						sysType.getType().equals(type)){
					return sysType.getTypeName();
				}
			}
		}
		return "其它";
	}
	/**
	 * 通过用户id获取角色名
	 * @param userId
	 * @return
	 */
	public static String getRoleName(String userId){
		SystemService systemService = (SystemService) ApplicationContextUtil.getBean("systemService");
		try {
			List<SysRole> sysRoles = systemService.findList(SysRole.class, "methord2", userId);
			if(sysRoles.size()>0){
				return sysRoles.get(0).getRoleName();
			}
		} catch (Exception e) {
			LogUtil.error("获取getRoleName失败", e);
		}
		return "";
		
	}
	
	/**
	 * 获取HTTP请求时的参数信息
	 * @param request
	 * @return
	 */
	public static String getParams(HttpServletRequest request){
		StringBuilder params = new StringBuilder();
		int index = 0;
		for (Object param : request.getParameterMap().keySet()){ 
			params.append((index++ == 0 ? "" : "&") + param + "=");
			params.append(StringUtil.subStringEncode(StringUtil.endsWithIgnoreCase((String)param, "password")
					? "" : request.getParameter((String)param), 100));
		}
		return params.toString();
		
	}
}
