package org.takinframework.web.quartz;

import java.text.ParseException;
import java.util.List;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.ResourceUtils;
import org.takinframework.web.buss.entity.TfGuize;
import org.takinframework.web.buss.entity.TfGuizeTimes;
import org.takinframework.web.quartz.util.QuartzContext;
import org.takinframework.web.system.service.SystemService;

/**
 * spring 初始化后需要执行的类
 * 
 * @author twg
 * 
 */
@Component
public class InstantiationQuartzProcessor implements
		ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private SystemService systemService;

	private boolean isStart = false;

	public void startJob() throws SchedulerException, ParseException {
		if (!isStart) {// 没有父容器时说明它是最大的
			isStart = true;
			LogUtil.debug("=======定时任务开始启动=======");

			List<TfGuize> tfGuizes = systemService.findAll(TfGuize.class,
					"methord1");
			for (TfGuize gz : tfGuizes) {
				List<TfGuizeTimes> tfGuizeTimes = systemService.findList(
						TfGuizeTimes.class, "methord1", gz.getId());
				if (tfGuizeTimes.size() > 0) {
					QuartzContext
							.tfGuizeJob(gz.getId(),
									QuartzContext.HoursAndMinutesEveryDay,
									tfGuizeTimes);
				}// 规则
				if (null != gz.getTfWenShiDuTime()
						&& gz.getTfWenShiDuTime() > 0) {
					QuartzContext.tfGuizeMinutesJob(gz.getId() + "wensidu",
							QuartzContext.MinutesEveryDay,
							String.valueOf(gz.getTfWenShiDuTime()));
				}// 温湿度监测时间间隔
			}
			// ////////////////////////////////////////////////
			String jobName2 = "检测浏览器是否激活";
			String description2 = "按每天【每分钟】执行一次";
			QuartzContext.BrowserJob(jobName2, description2,
					ResourceUtils.getConfig("sessionExpire"));
		}
	}

	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null)
			try {
				startJob();
			} catch (Exception e) {
				LogUtil.error("启动通风规则任务器失败", e);
			}
	}

}
