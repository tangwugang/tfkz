package org.takinframework.web.test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.quartz.SchedulerException;
import org.takinframework.core.quartz.QuartzManager;
import org.takinframework.core.quartz.TriggerTime;
import org.takinframework.core.util.DateUtils;
import org.takinframework.web.buss.job.DepotJob;

import com.google.common.collect.Lists;

public class QuartzJobTest {
	private String jobName;
	private String description;
	
	private TriggerTime time;
	
	private List<TriggerTime> triggerTime;
	
	
	public QuartzJobTest(String jobName,TriggerTime time, String description){
		this.jobName = jobName;
		this.description = description;
		this.time = time;
	}
	public QuartzJobTest(String jobName,List<TriggerTime> triggerTime, String description){
		this.jobName = jobName;
		this.description = description;
		this.triggerTime = triggerTime;
	}
	
	public void run(){
		try {
			
			
//			QuartzManager.addJob(jobName, DepotJob.class, time, description);
			QuartzManager.addJob(jobName, DepotJob.class, triggerTime, description);
			Thread.sleep(3000);
//			time = new TriggerTime();
//			time.setTimeType(2);
//			time.setTimeInterval("1");
//			modifyTime(time);
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void modifyTime(TriggerTime time){
		try {
			QuartzManager.modifyJobTime(jobName, time);
		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		String jobName = "粮仓打开任务";
		String description = "按每天【小时:分钟】执行一次";
//		TriggerTime time = new TriggerTime();
//		time.setTimeType(2);
//		time.setTimeInterval("5");
		String date[] = {"10:10:00","10:38:00","10:55:00","13:25:00",
				"14:25:00","15:25:00","16:25:00","17:25:00","18:25:00",
				"19:25:00","20:25:00","21:25:00","22:25:00","23:25:00"};
		List<TriggerTime> triggerTimes = Lists.newLinkedList();
		for (int i = 0; i < date.length; i++) {
			TriggerTime time = new TriggerTime();
			time.setTimeType(3);
			time.setTimeInterval(date[i]);
			time.setPriority(i);
//			try {
//				DateUtils.parseDateTime(date[i]).compareTo(new Date());
				System.out.println("QuartzJobTest.main()== "+DateUtils.dateDiff(date[i]));
//				if(DateUtils.formatShortTime(date[i]).compareTo(new Date())>=0){
//					System.out.println("QuartzJobTest.main()"+date[i]);
//					triggerTimes.add(time);
//				}
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
			
		}
		
		QuartzJobTest job = new QuartzJobTest(jobName, triggerTimes, description);
		job.run();
		

	}

}
