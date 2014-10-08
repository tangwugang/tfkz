package org.takinframework.web.system.controller;
import java.sql.SQLException;
import java.util.List;

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
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.Page;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.util.UUIDGenerator;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.system.entity.SysType;
import org.takinframework.web.system.service.SysTypeService;

import com.google.common.collect.Lists;

/**   
 * @Title:SysTypeController
 * @Description: 系统参数表Controller
 * @author twg
 * @date 2014-08-12
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sysTypeController")
public class SysTypeController extends BaseController {

	@Autowired
	private SysTypeService<SysType, String> sysTypeService;
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
	 * 系统参数表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sysType")
	public ModelAndView sysType(SysType sysType,
			HttpServletRequest request,HttpServletResponse response) {
		try {
			List<String> params = Lists.newArrayList();
			if(StringUtil.isNotBlank(sysType.getType())){
				params.add("type");
			}
			if(StringUtil.isNotBlank(sysType.getDescription())){
				params.add("description");
			}
			request.setAttribute("page", systemService.findListByPage(new Page<SysType>(request, response), sysType,params.toArray()));
		} catch (Exception e) {
			LogUtil.error("sysType失败", e);
		}
		return new ModelAndView("system/sysType/sysTypeList");
	}
	/**
	 * 参数添加
	 * @param sysType
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "sysTypeAddOrUpdate")
	public ModelAndView sysTypeAddOrUpdate(SysType sysType,HttpServletRequest request){
		if(StringUtil.isNotBlank(sysType.getId())){
			try {
				request.setAttribute("sysType", systemService.checkEntityExits(sysType));
			} catch (Exception e) {
				LogUtil.error("sysTypeAddOrUpdate失败", e);
			}
		}
		return new ModelAndView("system/sysType/sysTypeAddOrUpdate");
		
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
	public void datagrid(SysType sysType,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(SysTypeEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sysType, request.getParameterMap());
		//this.sysTypeService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除系统参数表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SysType sysType, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "系统参数表删除成功";
		systemService.delete(sysType);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加系统参数表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SysType sysType, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(sysType.getId())) {
			message = "系统参数表更新成功";
			try {
				systemService.update(sysType);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "系统参数表更新失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "系统参数表添加成功";
			try {
				systemService.save(sysType);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "系统参数表添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 系统参数表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SysType sysType, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sysType.getId())) {
			req.setAttribute("sysTypePage", sysType);
		}
		return new ModelAndView("system/sysType/sysType");
	}
}
