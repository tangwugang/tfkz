package org.takinframework.web.system.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.takinframework.core.util.ApplicationContextUtil;
import org.takinframework.web.system.manager.ClientManager;


/**
 * 监听在线用户上线下线
 * @author twg
 *
 */
public class OnlineListener implements ServletContextListener,
		HttpSessionListener {
	
	private static ApplicationContext ctx = null;

	public void sessionCreated(HttpSessionEvent evt) {
		System.out.println("====OnlineListener.sessionCreated()====");
		ApplicationContextUtil.getSessions().add(evt.getSession().getId());

	}

	public void sessionDestroyed(HttpSessionEvent evt) {
		ClientManager.getInstance().removeClinet(evt.getSession().getId());
		System.out.println("====OnlineListener.sessionDestroyed()=====");
	}

	public void contextDestroyed(ServletContextEvent evt) {
		System.out.println("====OnlineListener.contextDestroyed()=====");
	}

	public void contextInitialized(ServletContextEvent evt) {
		ctx = WebApplicationContextUtils.getWebApplicationContext(evt.getServletContext());
		System.out.println("OnlineListener.contextInitialized()");

	}
	
	public static ApplicationContext getCtx() {
		return ctx;
	}

}
