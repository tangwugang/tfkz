package org.takinframework.core.util;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.takinframework.web.system.entity.Client;
import org.takinframework.web.system.entity.SysFunction;
import org.takinframework.web.system.manager.ClientManager;

/**
 * 菜单权限工具类
 * @author twg
 *
 */
public class AuthFunctionUtil {
	/**
	 * 菜单是否有权限
	 * @param name 菜单别名
	 * @return
	 */
	public static boolean hasFuncPermission(String name){
		HttpSession session = ContextHolderUtils.getSession();
		Client client = ClientManager.getInstance().getClient(session.getId());
		List<SysFunction> sysFunctions = client.getSysFunctions();
		for (SysFunction sysFunction : sysFunctions) {
			if(sysFunction.getFuncAlias().equals(name)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取对应菜单的url地址
	 * @param name 菜单别名
	 * @return
	 */
	public static String getFuncUrl(String name){
		HttpSession session = ContextHolderUtils.getSession();
		Client client = ClientManager.getInstance().getClient(session.getId());
		List<SysFunction> sysFunctions = client.getSysFunctions();
		for (SysFunction sysFunction : sysFunctions) {
			if(sysFunction.getFuncAlias().equals(name)){
				return sysFunction.getFuncUrl();
			}
		}
		return "";
		
	}
}
