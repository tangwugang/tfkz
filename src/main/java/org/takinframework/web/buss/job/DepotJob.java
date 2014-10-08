package org.takinframework.web.buss.job;

import java.util.Date;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.quartz.BaseJob;
import org.takinframework.core.serial.SerialListener;
import org.takinframework.core.util.ApplicationContextUtil;
import org.takinframework.core.util.CashUtils;
import org.takinframework.core.util.DateUtils;
import org.takinframework.core.util.LogUtil;
import org.takinframework.web.system.service.SystemService;


/**
 * 粮仓定时任务
 * @author twg
 *
 */
public class DepotJob extends BaseJob {
	private SystemService systemService = (SystemService) ApplicationContextUtil.getBean("systemService");

	public void executeJob(JobExecutionContext context) throws JobExecutionException {
			JobDataMap dataMap = context.getJobDetail().getJobDataMap();
			JobKey jobKey = context.getJobDetail().getKey();
			LogUtil.info("任务名==【"+jobKey.getName()+"】任务组名==【"+jobKey.getGroup()+"】==时间=="+DateUtils.formatDateTime(new Date()));
			System.out.println("DepotJob.executeJob() : 任务名==【"+jobKey.getName()+"】任务组名==【"+jobKey.getGroup());
			//发指令开始
			
				if(!SerialListener.serialManager().WritePort("this is serial")){
					CashUtils.removeCash(jobKey.getName());
					CashUtils.addCash(jobKey.getName(), "OutputStreamError");
//					systemService.addLog("发送串口指令任务失败", Globals.Log_Type_TFKZ, Globals.Log_Leavel_ERROR);
				}//串口通信
//				systemService.addLog("调用DepotJob任务失败", Globals.Log_Type_TFKZ, Globals.Log_Leavel_ERROR, e);
//				JobExecutionException e2 = new JobExecutionException(e);
//				e2.setRefireImmediately(true);
//	            throw e2;
	}

}
