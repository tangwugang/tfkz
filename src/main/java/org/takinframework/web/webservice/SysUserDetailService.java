package org.takinframework.web.webservice;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.takinframework.core.common.exception.BusinessException;
import org.takinframework.core.common.model.json.AjaxJson;
import org.takinframework.web.system.entity.SysUser;

//@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
//@WebService(endpointInterface="org.takinframework.web.webservice.SysUserDetailService",targetNamespace="http://impl.webservice.web.takinframework.org/")
//@Produces(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public interface SysUserDetailService {
//	@WebMethod(operationName="selectById")
//	public String selectById(@WebParam("userId")String id) throws BusinessException;
//	@GET
//	@Path("user/{userId}")
	public SysUser selectById(String id) throws BusinessException;
	
	public List<SysUser> selectAll() throws BusinessException;
	
	public String selectAllMap() throws BusinessException;

}
