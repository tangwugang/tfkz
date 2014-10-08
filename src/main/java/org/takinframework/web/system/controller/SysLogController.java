package org.takinframework.web.system.controller;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.takinframework.web.system.service.SystemService;
import org.takinframework.core.common.model.json.AjaxJson;
import org.takinframework.core.common.model.json.DataGrid;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.util.DateUtils;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.Page;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.util.UUIDGenerator;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.system.entity.SysLog;
import org.takinframework.web.system.service.SysLogService;

import com.google.common.collect.Maps;

/**   
 * @Title:SysLogController
 * @Description: 系统日志表Controller
 * @author twg
 * @date 2014-07-31
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sysLogController")
public class SysLogController extends BaseController {

	@Autowired
	private SysLogService<SysLog, String> sysLogService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 系统日志表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sysLog")
	public ModelAndView sysLog(SysLog sysLog,HttpServletRequest request,HttpServletResponse response) {
		try {
			Map<String, Object> params = Maps.newHashMap();
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			if(StringUtil.isNotBlank(startDate) && 
					StringUtil.isNotBlank(endDate)){
				params.put("createDate<=",DateUtils.addDay(endDate, 1));
				params.put("createDate>=",startDate);
				request.setAttribute("startDate", startDate);
				request.setAttribute("endDate", endDate);
			}
			if(null !=sysLog.getType()){
				params.put("type",sysLog.getType());
			}
			if(StringUtil.isNotBlank(sysLog.getCreateName())){
				params.put("createName",sysLog.getCreateName());
			}
			request.setAttribute("page", systemService.findListByPage(new Page<SysLog>(request, response), sysLog,params));
		} catch (Exception e) {
			LogUtil.error("获取sysType失败", e);
		}
		return new ModelAndView("system/sysLog/sysLogList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(SysLog sysLog,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(SysLogEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sysLog, request.getParameterMap());
		//this.sysLogService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除系统日志表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SysLog sysLog, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "系统日志表删除成功";
		systemService.delete(sysLog);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加系统日志表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SysLog sysLog, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(sysLog.getId())) {
			message = "系统日志表更新成功";
			try {
				systemService.update(sysLog);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "系统日志表更新失败";
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "系统日志表添加成功";
			try {
				sysLog.setId(UUIDGenerator.generate());
				systemService.save(sysLog);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "系统日志表添加失败";
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 系统日志表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SysLog sysLog, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sysLog.getId())) {
			req.setAttribute("sysLogPage", sysLog);
		}
		return new ModelAndView("system/sysLog/sysLog");
	}
}
