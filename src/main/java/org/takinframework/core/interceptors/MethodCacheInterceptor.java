package org.takinframework.core.interceptors;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.takinframework.core.util.LogUtil;

/**
 * 方法缓存拦截器(缓存数据库查询的结果)
 * @author twg
 *
 */
public class MethodCacheInterceptor implements MethodInterceptor, InitializingBean {
	private Cache cache;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cache, "需要一个缓存. 使用setCache(Cache)分配一个.");
		
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
		String targetName = invocation.getThis().getClass().getName();
        String methodName = invocation.getMethod().getName();
        Object[] arguments = invocation.getArguments();
        Object result;
        String cacheKey = getCacheKey(targetName, methodName, arguments);
        Element element = null;
        synchronized (this) {
            element = cache.get(cacheKey);
            if (element == null) {
                LogUtil.info(cacheKey + "加入到缓存： " + cache.getName());
                // 调用实际的方法
                result = invocation.proceed();
                element = new Element(cacheKey, (Serializable) result);
                cache.put(element);
            } else {
            	LogUtil.info(cacheKey + "使用缓存： " + cache.getName());
            }
        }
        return element.getValue();
	}
	
	/**
	 * 返回具体的方法全路径名称 参数
	 * @param targetName 全路径
	 * @param methodName 方法名称
	 * @param arguments 参数
	 * @return
	 */
	private String getCacheKey(String targetName, String methodName, Object[] arguments) {
        StringBuffer sb = new StringBuffer();
        sb.append(targetName).append(".").append(methodName);
        if ((arguments != null) && (arguments.length != 0)) {
            for (int i = 0; i < arguments.length; i++) {
                sb.append(".").append(arguments[i]);
            }
        }
        return sb.toString();
    }
	
	

}
