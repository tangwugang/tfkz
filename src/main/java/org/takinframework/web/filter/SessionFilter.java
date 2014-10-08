package org.takinframework.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SessionFilter extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//如果是ajax请求响应头会有，x-requested-with；  
		if (req.getHeader("x-requested-with") != null   
		        && req.getHeader("x-requested-with")  
		            .equalsIgnoreCase("XMLHttpRequest")){  
		    //在响应头设置session状态   
		    resp.setHeader("sessionstatus", "sessionOut");  
		    resp.getWriter().print("sessionOut");  
		}  
		
	}

//	public void init(FilterConfig filterConfig) throws ServletException {
//
//	}
//
//	public void doFilter(ServletRequest request, ServletResponse response,
//			FilterChain chain) throws IOException, ServletException {
//		HttpServletRequest re = (HttpServletRequest) request;
//		HttpServletResponse res = (HttpServletResponse) response;
//		//如果是ajax请求响应头会有，x-requested-with；  
//		if (re.getHeader("x-requested-with") != null   
//		        && re.getHeader("x-requested-with")  
//		            .equalsIgnoreCase("XMLHttpRequest")){  
//		    //在响应头设置session状态   
//		    res.setHeader("sessionstatus", "sessionOut");  
//		    res.getWriter().print("sessionOut");  
//		}  
//	}
//
//	public void destroy() {
//		
//	}

}
