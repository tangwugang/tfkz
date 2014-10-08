package org.takinframework.web.webservice.impl;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.takinframework.core.common.exception.BusinessException;
import org.takinframework.core.common.model.json.AjaxJson;
import org.takinframework.core.util.DateUtils;
import org.takinframework.web.system.entity.SysUser;
import org.takinframework.web.system.mapper.SysUserMapper;
import org.takinframework.web.webservice.SysUserDetailService;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Component(value="sysUserDetailServiceImpl")
@Produces(value={MediaType.APPLICATION_JSON})
public class SysUserDetailServiceImpl implements SysUserDetailService {
	@Autowired
	private SysUserMapper<SysUser,String> mapper;
			
	public SysUserMapper<SysUser,String> getMapper() {
		return mapper;
	}

	
//	@WebMethod(operationName="selectById")
//	public String selectById(@WebParam(name="userId")String id) throws BusinessException {
//		JSONObject jsonObject = new JSONObject();
//		SysUser sysUser = mapper.selectById(id);
//		jsonObject.put("user", sysUser);
//		return jsonObject.toString();
//	}
	@GET
	@Path("user/{userId}")
	public SysUser selectById(@PathParam("userId")String id) throws BusinessException {
		SysUser sysUser = mapper.selectById(id);
		return sysUser;
	}
	
	@GET
	@Path("user")
	
	public List<SysUser> selectAll() throws BusinessException {
		return mapper.selectAll();
	}
	
	
	public String selectAllMap() throws BusinessException {
		JSONObject jsonObject = new JSONObject();
		List<SysUser> sysUsers = mapper.selectAll();
		Map<String, Object> sysuMap = Maps.newHashMap();
		for (SysUser sysUser : sysUsers) {
//			try {
////				sysUser.setCreateDate(DateUtils.parseDate(DateUtils.formatDate(sysUser.getCreateDate())));
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
			sysuMap.put(sysUser.getId(), sysUser);
		}
		jsonObject.putAll(sysuMap);
		return jsonObject.toString();
	}

}
