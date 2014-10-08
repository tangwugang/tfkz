package org.takinframework.core.interceptors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.takinframework.core.util.ContextHolderUtils;
import org.takinframework.core.util.ResourceUtils;
import org.takinframework.core.util.oConvertUtils;
import org.takinframework.web.system.entity.Client;
import org.takinframework.web.system.entity.SysFunction;
import org.takinframework.web.system.entity.SysOperation;
import org.takinframework.web.system.entity.SysRoleFunction;
import org.takinframework.web.system.manager.ClientManager;
import org.takinframework.web.system.service.SystemService;

import com.google.common.collect.Lists;


/**
 * 权限拦截器
 * 
 * @author  twg
 * 
 */
public class AuthInterceptor implements HandlerInterceptor {
	 
	@Autowired
	private SystemService systemService;
	private List<String> excludeUrls;

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}


	/**
	 * 在controller后拦截
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在controller前拦截
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestPath = ResourceUtils.getRequestPath(request);// 用户访问的资源地址
		HttpSession session = ContextHolderUtils.getSession();
		Client client = ClientManager.getInstance().getClient(session.getId());
		if(client == null){ 
			client = ClientManager.getInstance().getClient(
					request.getParameter("sessionId"));
		}
		if (excludeUrls.contains(requestPath)) {
			return true;
		} else {
			if (client != null && client.getUser()!=null ) {
				 if(!hasMenuAuth(request)){
					 response.sendRedirect("loginController.do?noAuth");
					//request.getRequestDispatcher("webpage/common/noAuth.jsp").forward(request, response);
					return false;
				} 
				String functionId=oConvertUtils.getString(request.getParameter("clickFunctionId"));
				if(!oConvertUtils.isEmpty(functionId)){
					Set<String> operationCodes = systemService.getOperationCodesByUserIdAndFunctionId(client.getUser().getId(), functionId);
					request.setAttribute("operationCodes", operationCodes);
				 
				}
				if(!oConvertUtils.isEmpty(functionId)){
					List<SysOperation> operations = systemService.findList(SysOperation.class, functionId);
					List<String> newall = new ArrayList<String>();
					if(operations.size()>0){
						for (SysOperation sysOperation : operations) {
							newall.add(sysOperation.getOperCode().replaceAll(" ", ""));
						}
						
						List<String> params = Lists.newLinkedList();
						params.add(functionId);
						params.add(client.getUser().getId());
						List<SysRoleFunction> hasOperList = this.systemService.findList(SysRoleFunction.class, "methord2",params.toArray());
						for (SysRoleFunction sysRoleFunction : hasOperList) {
							 for(String s:sysRoleFunction.getOperation().split(",")){
							        s=s.replaceAll(" ", "");
							    	newall.remove(s);
							    } 
						}
					}
					 request.setAttribute("noauto_operationCodes", newall);
				}
				return true;
			} else {
				//forword(request);
				forward(request, response);
				return false;
			}

		}
	}
	private boolean hasMenuAuth(HttpServletRequest request) throws Exception{
		String requestPath = ResourceUtils.getRequestPath(request);// 用户访问的资源地址
		String funcid=oConvertUtils.getString(request.getParameter("clickFunctionId"));
		 
		if(requestPath.indexOf("loginController.do")!=-1||funcid.length()==0){
			return true;
		} 
		String userid = ClientManager.getInstance().getClient(
				ContextHolderUtils.getSession().getId()).getUser().getId();
		//requestPath=requestPath.substring(0, requestPath.indexOf("?")+1);
		List<String> params = Lists.newLinkedList();
		params.add(userid);
		params.add(requestPath+"%");
		List<SysFunction> list = this.systemService.findList(SysFunction.class, "methord1", params.toArray());
		if(list.size()==0){
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 转发
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "forword")
	public ModelAndView forword(HttpServletRequest request) {
		return new ModelAndView(new RedirectView("loginController.do?login"));
	}

	private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getHeader("x-requested-with") != null  
                && request.getHeader("x-requested-with")  
                        .equalsIgnoreCase("XMLHttpRequest")){  //如果是ajax请求响应头会有，x-requested-with；
			response.setStatus(403);//session过期
        }else{
        	request.getRequestDispatcher("webpage/login/timeout.jsp").forward(request, response);
        }
		
	}

}
