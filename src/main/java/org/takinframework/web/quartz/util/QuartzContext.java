package org.takinframework.web.quartz.util;

import java.text.ParseException;
import java.util.List;

import org.quartz.Job;
import org.quartz.SchedulerException;
import org.takinframework.core.quartz.QuartzManager;
import org.takinframework.core.quartz.TriggerTime;
import org.takinframework.web.buss.entity.TfGuizeTimes;
import org.takinframework.web.buss.job.DepotJob;
import org.takinframework.web.buss.job.BrowserJob;

import com.google.common.collect.Lists;

/**
 * 
 * @author twg
 *
 */
public class QuartzContext {
	public static final String HoursAndMinutesEveryDay = "按每天【小时:分钟】执行一次";
	public static final String MinutesEveryDay = "按每天【每分钟】执行一次";
	
	/**
	 * 启动通风规则任务器
	 * @param jobName 任务名
	 * @param description 任务描述
	 * @param tfGuizeTimes 任务定时时间段
	 * @throws ParseException 
	 * @throws SchedulerException 
	 */
	public static void tfGuizeJob(String jobName,String description,List<TfGuizeTimes> tfGuizeTimes) throws SchedulerException, ParseException{
		List<TriggerTime> triggerTimes = Lists.newLinkedList();
		List<String> times = Lists.newLinkedList();
		for (int i = 0; i < tfGuizeTimes.size(); i++) {
			times.add(tfGuizeTimes.get(i).getTfGuiZeStartTime());
			times.add(tfGuizeTimes.get(i).getTfGuiZeEndTime());
		}
		for (int i = 0; i < times.size(); i++) {
			TriggerTime time = new TriggerTime();
			time.setTimeType(3);
			time.setTimeInterval(times.get(i));
			time.setPriority(i);
			triggerTimes.add(time);
		}
		QuartzJob(jobName,DepotJob.class, triggerTimes, description);//通风类型job
		
	}
	
	/**
	 * 启动通风温湿度监测任务器
	 * @param jobName 任务名
	 * @param description 任务描述
	 * @param time 任务定时时间
	 * @throws ParseException 
	 * @throws SchedulerException 
	 */
	public static void tfGuizeMinutesJob(String jobName,String description,String time) throws SchedulerException, ParseException{
		List<TriggerTime> triggerTimes = Lists.newLinkedList();
		TriggerTime triggerTime = new TriggerTime();
		triggerTime.setTimeType(2);
		triggerTime.setTimeInterval(time);
		triggerTimes.add(triggerTime);
		QuartzJob(jobName,DepotJob.class, triggerTimes, description);//温湿度监测job
	}
	
	
	/**
	 * 启动浏览器激活任务器
	 * @param jobName 任务名
	 * @param description 任务描述
	 * @param time 任务定时时间
	 * @throws SchedulerException
	 * @throws ParseException
	 */
	public static void BrowserJob(String jobName,String description,String time) throws SchedulerException, ParseException{
		List<TriggerTime> triggerTimes = Lists.newLinkedList();
		TriggerTime triggerTime = new TriggerTime();
		triggerTime.setTimeType(2);
		triggerTime.setTimeInterval(time);
		triggerTimes.add(triggerTime);
		QuartzJob(jobName,BrowserJob.class,triggerTimes, description);//浏览器激活job
	}
	
	
	
	
	/**
	 * 停止任务
	 * @param jobName 任务名
	 * @throws SchedulerException
	 */
	public static void removeJob(String jobName) throws SchedulerException{
		QuartzManager.removeJob(jobName);
	}
	
	
	private static void QuartzJob(String jobName,Class<? extends Job> cls, List<TriggerTime> triggerTimes,String description) throws SchedulerException, ParseException{
		QuartzManager.addJob(jobName, cls, triggerTimes, description);
	}

}
