package org.takinframework.web.buss.job;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.takinframework.core.quartz.BaseJob;
import org.takinframework.core.util.ApplicationContextUtil;
import org.takinframework.core.util.ContextHolderUtils;
import org.takinframework.core.util.DateUtils;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.ResourceUtil;
import org.takinframework.core.util.StringUtil;
import org.takinframework.web.system.entity.Client;
import org.takinframework.web.system.entity.SysBrowser;
import org.takinframework.web.system.entity.SysUser;
import org.takinframework.web.system.manager.ClientManager;
import org.takinframework.web.system.service.SystemService;

import com.google.common.collect.Lists;

/**
 * 浏览器监听job,用来控制单用户登录
 * @author twg
 *
 */
public class BrowserJob extends BaseJob {
	private SystemService systemService =  (SystemService) ApplicationContextUtil.getBean("systemService");

	public void executeJob(JobExecutionContext context)
			throws JobExecutionException {
		
		try {
			//发指令开始
			
//			Set<String> sessions = ApplicationContextUtil.getSessions();
//			for (String sessionId : sessions) {
//				SysBrowser sysBrowser = new SysBrowser();
//				sysBrowser.setSessionId(sessionId);
//				List<String> param = Lists.newArrayList();
//				param.add("sessionId");
//				List<SysBrowser> browser = systemService.findList(sysBrowser, param.toArray());
//			}
				List<SysBrowser> browser  = systemService.findAll(SysBrowser.class);
				for (SysBrowser b : browser) {
					String sessionId = b.getSessionId();
					Client c = ClientManager.getInstance().getClient(sessionId);
					//大于自定义的session过期时间，说明浏览器不是激活状态，就把用户表设为可用状态
					if(StringUtil.isNotEmpty(c)){
						int d = DateUtils.dateDiff(b.getUpdateDate());
						if(Integer.parseInt(ResourceUtil.getConfig("sessionExpire"))<=d){
							SysUser sysUser = c.getUser();
							if("3".equals(sysUser.getStatus().toString())){//用户在线
								sysUser.setStatus(Short.valueOf("1"));
								systemService.update(sysUser);
								systemService.delete(b);
								ClientManager.getInstance().removeClinet(sessionId);
							}
						}
					}else{
						String sql = "update sys_user set status = 1 where status = 3";
						systemService.executeSql(sql);
					}
				}
			
		} catch (Exception e) {
			LogUtil.error("调用BrowserJob任务失败", e);
			JobExecutionException e2 = new JobExecutionException(e);
			e2.setRefireImmediately(true);
            throw e2;
		}

	}

}
