package org.takinframework.core.interceptors;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.ehcache.Cache;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.takinframework.core.util.LogUtil;

/**
 * 清楚数据库查询的缓存(操作数据库后清除)
 * @author twg
 *
 */
public class MethodCacheAfterAdvice implements AfterReturningAdvice, InitializingBean{
	
	private Cache cache;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cache, "需要一个缓存. 使用setCache(Cache)分配一个.");
	}

	@SuppressWarnings("rawtypes")
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		
		String targetName = target.getClass().getName();
		List list = cache.getKeys();
		for(int i = 0;i<list.size();i++){  
            String cacheKey = (String) list.get(i);  
            if(cacheKey.startsWith(targetName)){  
                cache.remove(cacheKey);  
                LogUtil.info("清除缓存 ：" + cacheKey);  
            }  
        }
		
	}

}
