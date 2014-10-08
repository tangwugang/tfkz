package org.takinframework.core.web.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;
import org.takinframework.core.common.exception.BusinessException;
import org.takinframework.core.util.ConfigUtil;
import org.takinframework.core.util.StringUtil;

public class BaseController extends GenericController {

	public final static String SUCCESS = "success";

	public final static String MSG = "msg";

	public final static String DATA = "data";

	public final static String LOGOUT_FLAG = "logoutFlag";
	

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// binder.registerCustomEditor(Date.class, new CustomDateEditor(
		// new SimpleDateFormat("yyyy-MM-dd"), true));
		// binder.registerCustomEditor(int.class,new CustomeIntegerEditor());
		this.logger.debug("init binder ....");
		binder.registerCustomEditor(Integer.class,
				new CustomeEditor(Integer.class,false));
		binder.registerCustomEditor(Long.class, new CustomeEditor(
				Long.class, false));
		binder.registerCustomEditor(Byte.class,
				new ByteArrayMultipartFileEditor());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class,new CustomDateEditor(
				dateFormat, true));
	}



	/** @deprecated */
//	protected ResultMessage validForm(String form, Object obj,
//			BindingResult result, HttpServletRequest request) {
//		ResultMessage resObj = new ResultMessage(1, "");
//		this.confValidator.setFormName(form);
//		this.confValidator.validate(obj, result);
//		if (result.hasErrors()) {
//			resObj.setResult(0);
//			List list = result.getFieldErrors();
//			String errMsg = "";
//			for (FieldError err : list) {
//				String msg = getText(err.getDefaultMessage(),
//						err.getArguments(), request);
//				errMsg = errMsg + msg + "\r\n";
//			}
//			resObj.setMessage(errMsg);
//		}
//		return resObj;
//	}

	/** @deprecated */
	public ModelAndView getView(String category, String id) {
		String view = ConfigUtil.getVal(category, id);
		return new ModelAndView(view);
	}
	
	class CustomeEditor extends PropertyEditorSupport{
		private final Class<? extends Number> numberClass;
		private final boolean allowEmpty;
		private final String defaultValue="-1";
		
		public CustomeEditor(Class<? extends Number> numberClass, boolean allowEmpty){
			if (numberClass == null || !Number.class.isAssignableFrom(numberClass)) {
				throw new BusinessException("数据类型："+numberClass.getName()+" 不合法");
			}
			this.numberClass = numberClass;
			this.allowEmpty = allowEmpty;
		}
		
		public void setAsText(String text) throws IllegalArgumentException {
			if (this.allowEmpty && !StringUtils.hasText(text)) {
				setValue(null);
			}else if (text == null || text.equals("")){
				text = defaultValue;
			}
			if(StringUtil.isJavaType(numberClass, "java.lang.Integer")){
				setValue(Integer.parseInt(text));
			}else if(StringUtil.isJavaType(numberClass, "java.lang.Long")){
				setValue(Long.parseLong(text));
			}else if(StringUtil.isJavaType(numberClass, "java.lang.Short")){
				setValue(Short.parseShort(text));
			}else if(StringUtil.isJavaType(numberClass, "java.lang.Float")){
				setValue(Float.parseFloat(text));
			}else if(StringUtil.isJavaType(numberClass, "java.lang.Double")){
				setValue(Double.parseDouble(text));
			}
		}

		/**
		 * Format the Date as String, using the specified DateFormat.
		 */
		public String getAsText() {
			return getValue().toString();
		}
		
		
	}
}
