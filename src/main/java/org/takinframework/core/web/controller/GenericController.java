package org.takinframework.core.web.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.ModelAndView;
import org.takinframework.core.util.ContextHolderUtils;
import org.takinframework.core.util.StringUtil;
import org.takinframework.web.util.RequestUtil;
import org.takinframework.web.util.ResultMessage;

import com.google.common.collect.Lists;

public class GenericController {
	protected Logger logger = LoggerFactory.getLogger(BaseController.class);

	public final String SUCCESS = "{success:true}";

	public final String FAILURE = "{success:false}";
	private MessageSourceAccessor messages;
	public static final String STEP1 = "1";
	public static final String STEP2 = "2";
	public static final String MESSAGES_KEY = "successMessages";
	public static final String ERRORS = "errors";

	// @Resource
	// protected Properties configproperties;

	public ModelAndView getAutoView() throws Exception {
		HttpServletRequest request = RequestUtil.getHttpServletRequest();
		String requestURI = request.getRequestURI();

		this.logger.debug("requestURI:" + requestURI);
		String contextPath = request.getContextPath();

		requestURI = requestURI.replace(".do", "");
		int cxtIndex = requestURI.indexOf(contextPath);
		if (cxtIndex != -1) {
			requestURI = requestURI.substring(cxtIndex + contextPath.length());
		}

		String[] paths = requestURI.split("[/]");
		if ((paths != null) && (paths.length == 5)) {
			String jspPath = "/" + paths[1] + "/" + paths[2] + "/" + paths[3]
					+ StringUtil.firstUpperCase(paths[4]) + ".jsp";
			return new ModelAndView(jspPath);
		}
		if ((paths != null) && (paths.length == 4)) {
			String jspPath = "/" + paths[1] + "/" + paths[2]
					+ StringUtil.firstUpperCase(paths[3]) + ".jsp";
			return new ModelAndView(jspPath);
		}
		this.logger
				.error("your request url is not the right pattern, it is not allowed use this getAutoView method");
		throw new Exception("url:[" + requestURI
				+ "] is not in this pattern:[/子系统/包名/表对应实体名/实体操作方法名.do]");
	}

	@Autowired
	public void setMessages(MessageSource messageSource) {
		this.messages = new MessageSourceAccessor(messageSource);
	}

	public void saveError(HttpServletRequest request, String msg) {
		saveMessage(request, "errors", msg);
	}

	public void saveMessage(HttpServletRequest request, String msg) {
		saveMessage(request, "successMessages", msg);
	}

	@SuppressWarnings("unchecked")
	public void saveMessage(HttpServletRequest request, String key, String msg) {
		List<String> messages = (List<String>) request.getSession().getAttribute(key);
		if (messages == null) {
			messages = Lists.newArrayList();
		}
		messages.add(msg);
		request.getSession().setAttribute(key, messages);
	}

	public String getText(String msgKey, Locale locale) {
		return this.messages.getMessage(msgKey, locale);
	}

	public String getText(String msgKey, String arg, Locale locale) {
		return getText(msgKey, new Object[] { arg }, locale);
	}

	public String getText(String msgKey, Object[] args, Locale locale) {
		return this.messages.getMessage(msgKey, args, locale);
	}

	public String getText(String msgKey, Object[] args) {
		return this.messages.getMessage(msgKey, args, ContextHolderUtils.getLocale());
	}

	public String getText(String msgKey) {
		return this.messages.getMessage(msgKey, ContextHolderUtils.getLocale());
	}

	protected String getText(String msgKey, String arg,
			HttpServletRequest request) {
		Locale locale = ContextHolderUtils.getLocale();
		return getText(msgKey, arg, locale);
	}

	protected String getText(String msgKey, Object[] args,
			HttpServletRequest request) {
		Locale locale = ContextHolderUtils.getLocale();
		return getText(msgKey, args, locale);
	}

	protected void writeResultMessage(PrintWriter writer, String resultMsg,
			String cause, int successFail) {
		ResultMessage resultMessage = new ResultMessage(successFail, resultMsg,
				cause);
		writeResultMessage(writer, resultMessage);
	}

	protected void writeResultMessage(PrintWriter writer, String resultMsg,
			int successFail) {
		ResultMessage resultMessage = new ResultMessage(successFail, resultMsg);
		writeResultMessage(writer, resultMessage);
	}

	protected void writeResultMessage(PrintWriter writer,
			ResultMessage resultMessage) {
		writer.print(resultMessage);
	}

	protected void saveResultMessage(HttpSession session, String msg,
			int successFail) {
		ResultMessage resultMsg = new ResultMessage(successFail, msg);
		session.setAttribute("message", resultMsg);
	}

	protected void saveSuccessResultMessage(HttpSession session, String msg) {
		saveResultMessage(session, msg, 1);
	}

	protected void saveFailResultMessage(HttpSession session, String msg) {
		saveResultMessage(session, msg, 0);
	}


}
