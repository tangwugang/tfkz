package org.takinframework.web.webservice;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.takinframework.core.common.exception.BusinessException;


@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
@WebService(endpointInterface="org.takinframework.web.webservice.JwebDepotDetailService",targetNamespace="http://impl.webservice.web.takinframework.org/")
public interface JwebDepotDetailService {
//	@WebMethod(operationName="selectAll")
//	public String selectAll() throws BusinessException;
	
	public String selectAll() throws BusinessException;

}
