package org.takinframework.web.test;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.takinframework.web.system.entity.SysUser;

public class RSETServiceClient {
	private static WebClient client;
	 
	@Before
    public void init() {
        // 手动创建webClient对象，注意这里的地址是发布的那个/rest地址
        //String url = "http://localhost:8000/CXFWebService/rest/";
        //client = WebClient.create(url);
 
        // 从Spring Ioc容器中拿webClient对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc-client.xml");
        client = ctx.getBean("webClient", WebClient.class);
    }
    
    @After
    public void destory(){
    }
    
    @Test
    public void testGet() {
    	SysUser user = client.path("sysUserDetailService/user/{userId}","4028970346a285e80146a285e8e70000").accept(MediaType.APPLICATION_JSON).get(SysUser.class);
        System.out.println(user.getUserName());
    }

}
