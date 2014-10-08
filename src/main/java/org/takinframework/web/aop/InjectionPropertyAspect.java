package org.takinframework.web.aop;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import org.takinframework.core.util.ClassReflectUtil;
import org.takinframework.core.util.ContextHolderUtils;
import org.takinframework.core.util.StringUtil;
import org.takinframework.web.system.manager.ClientManager;

import com.google.common.collect.Maps;

/**
 * aop 注入属性值
 * @author twg
 *
 */
//@Aspect
@Component
public class InjectionPropertyAspect {
	/**
	 * 持久化
	 * @param jp
	 */
	@SuppressWarnings("deprecation")
//	@Before("execution (* org.takinframework.web.*.service.impl..save*(..))||"
//			+ "execution (* org.takinframework.web.*.service.impl..insert*(..))")
	public void beforePrePersist(JoinPoint jp){
		Object[] o = jp.getArgs();
		for (Object object : o) {
			System.out.println("InjectionPropertyAspect.beforePrePersist() ==== "+object.getClass().getSimpleName());
			if(!object.getClass().getSimpleName().toLowerCase().equals("string") && 
					!object.getClass().getSimpleName().toLowerCase().equals("int")&& 
					!object.getClass().getSimpleName().toLowerCase().equals("integer")&&
					!object.getClass().getSimpleName().toLowerCase().equals("double")&&
					!object.getClass().getSimpleName().toLowerCase().equals("float")&&
					!object.getClass().getSimpleName().toLowerCase().equals("date")&&
					!object.getClass().getSimpleName().toLowerCase().equals("long")&&
					!object.getClass().getSimpleName().toLowerCase().equals("short")&&
					!object.getClass().getSimpleName().toLowerCase().equals("object")&&
					!object.getClass().getSimpleName().equals("RequestFacade")){
				
				HttpSession session = ContextHolderUtils.getSession();
				String updateDate = new Date().toLocaleString();
				String updateBy = "";
				String updateName = "";
				if(StringUtil.isNotEmpty(session)){
					updateBy = ClientManager.getInstance().getClient(session.getId()).getUser().getId();
					updateName = ClientManager.getInstance().getClient(session.getId()).getUser().getUserName();
				}
				
				Map<String, String> map = Maps.newConcurrentMap();
				map.put("updateBy", updateBy);
				map.put("updateName", updateName);
				map.put("updateDate", updateDate);
				map.put("createBy", updateBy);
				map.put("createName",updateName );
				map.put("createDate", updateDate);
				initProperty(object,map);
			}
			
		}
	}
	
	/**
	 * 更新
	 * @param jp
	 */
	@SuppressWarnings("deprecation")
//	@Before("execution (* org.takinframework.web.*.service.impl..update*(..))")
	public void beforePreUpdate(JoinPoint jp){
		Object[] o = jp.getArgs();
		for (Object object : o) {
			System.out.println("InjectionPropertyAspect.beforePreUpdate() ==== "+object.getClass().getSimpleName());
			if(!object.getClass().getSimpleName().toLowerCase().equals("string") && 
					!object.getClass().getSimpleName().toLowerCase().equals("int")&& 
					!object.getClass().getSimpleName().toLowerCase().equals("integer")&&
					!object.getClass().getSimpleName().toLowerCase().equals("double")&&
					!object.getClass().getSimpleName().toLowerCase().equals("float")&&
					!object.getClass().getSimpleName().toLowerCase().equals("date")&&
					!object.getClass().getSimpleName().toLowerCase().equals("long")&&
					!object.getClass().getSimpleName().toLowerCase().equals("short")&&
					!object.getClass().getSimpleName().toLowerCase().equals("object")&&
					!object.getClass().getSimpleName().equals("RequestFacade")){
				
				HttpSession session = ContextHolderUtils.getSession();
				String updateDate = new Date().toLocaleString();
				String updateBy = "";
				String updateName = "";
				if(StringUtil.isNotEmpty(session)){
					updateBy = ClientManager.getInstance().getClient(session.getId()).getUser().getId();
					updateName = ClientManager.getInstance().getClient(session.getId()).getUser().getUserName();
				}
				
				Map<String, String> map = Maps.newConcurrentMap();
				map.put("updateBy", updateBy);
				map.put("updateName", updateName);
				map.put("updateDate", updateDate);
				initProperty(object,map);
				
			}
		}
	}
	
	private void initProperty(Object object,Map<String, String> map){
		Set<String> k = map.keySet();
		for (String string : k) {
			try {
				ClassReflectUtil.setFieldValue(object, string, map.get(string));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
