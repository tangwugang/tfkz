package org.takinframework.core.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * 保存临时变量
 * @author twg
 *
 */
public class CashUtils {
	private static Map<String, Object> map = Collections.synchronizedMap(new HashMap<String, Object>());
	
	public static void addCash(String key,Object value){
		map.put(key, value);
	}
	
	public static Object getCash(String key){
		return map.get(key);
	}
	
	public static void removeCash(String key){
		map.remove(key);
	}
	
	public static void clear(){
		map.clear();
	}

}
