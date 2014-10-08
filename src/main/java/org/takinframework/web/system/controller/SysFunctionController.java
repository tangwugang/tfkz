package org.takinframework.web.system.controller;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.takinframework.web.system.service.SystemService;
import org.takinframework.core.common.model.json.AjaxJson;
import org.takinframework.core.common.model.json.DataGrid;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.util.UUIDGenerator;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.system.entity.SysFunction;
import org.takinframework.web.system.entity.SysRoleFunction;
import org.takinframework.web.system.service.SysFunctionService;

import com.google.common.collect.Lists;

/**   
 * @Title:SysFunctionController
 * @Description: 系统菜单表Controller
 * @author twg
 * @date 2014-06-06
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sysFunctionController")
public class SysFunctionController extends BaseController {

	@Autowired
	private SysFunctionService<SysFunction, String> sysFunctionService;
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
	 * 系统菜单表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sysFunction")
	public ModelAndView sysFunction(HttpServletRequest request) {
		return new ModelAndView("system/sysFunction/sysFunctionList");
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
	public void datagrid(SysFunction sysFunction,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(SysFunctionEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sysFunction, request.getParameterMap());
		//this.sysFunctionService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除系统菜单表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SysFunction sysFunction, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "系统菜单表删除成功";
		List<SysFunction> funcIds = Lists.newArrayList();
		funcIds = getSysFuncChild(sysFunction, funcIds);
		for (SysFunction func : funcIds) {
			systemService.delete(func);
			List<String> params = Lists.newArrayList();
			SysRoleFunction sysRoleFunction = new SysRoleFunction();
			sysRoleFunction.setFuncId(func.getId());
			params.add("funcId");
			systemService.delete(sysRoleFunction, params.toArray());
		}
		systemService.delete(sysFunction);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}
	/**
	 * 递归查询子菜单
	 * @param sysFunction
	 * @param funcIds
	 * @return
	 */
	private List<SysFunction> getSysFuncChild(SysFunction sysFunction,List<SysFunction> funcIds){
		try {
			sysFunction = systemService.getEntity(SysFunction.class, "methord1", sysFunction.getId());
		} catch (SQLException e) {
			LogUtil.error("获取系统菜单表失败【getSysFuncChild】", e);
		}
		if(StringUtil.isNotEmpty(sysFunction.getId())){
			List<SysFunction> sysFunctions = systemService.findList(SysFunction.class, "methord2", sysFunction.getId());
			for (SysFunction func : sysFunctions) {
				funcIds.add(func);
				getSysFuncChild(func,funcIds);
			}
		}
		
		return funcIds;
		
	}


	/**
	 * 添加系统菜单表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SysFunction sysFunction, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(sysFunction.getId())) {
			message = "系统菜单表更新成功";
			try {
				systemService.update(sysFunction);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "系统菜单表更新失败";
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "系统菜单表添加成功";
			try {
				sysFunction.setId(UUIDGenerator.generate());
				systemService.save(sysFunction);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "系统菜单表添加失败";
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		j.setObj(sysFunction);
		return j;
	}

	/**
	 * 系统菜单表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SysFunction sysFunction,Model model) {
		if (StringUtil.isNotEmpty(sysFunction.getId()) && 
				StringUtil.isNotEmpty(sysFunction.getOperate())) {
			String operate = sysFunction.getOperate();
			try {
				sysFunction = systemService.getEntity(SysFunction.class,"methord1", sysFunction.getId());
			} catch (SQLException e) {
				LogUtil.error("获取系统菜单表失败【addorupdate】", e);
			}
			sysFunction.setOperate(operate);
			model.addAttribute("sysFunction", sysFunction);
		}
		return new ModelAndView("system/sysFunction/sysFunction");
	}
	/**
	 * 移动系统菜单
	 * @param sourceId 原菜单id
	 * @param targetId 目标菜单id
	 * @return
	 */
	@RequestMapping(params = "moveTree")
	@ResponseBody
	public AjaxJson moveTree(String sourceId,String targetId){
		AjaxJson j = new AjaxJson();
		message = "移动系统菜单成功";
		try {
			SysFunction sysFunction = systemService.getEntity(SysFunction.class, "methord1", sourceId);
			sysFunction.setParentId(targetId);
			systemService.update(sysFunction);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			message = "获取系统菜单表失败";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_ERROR,e);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 系统菜单表明细
	 * @param sysFunction
	 * @param model
	 * @return
	 */
	@RequestMapping(params = "detail")
	public ModelAndView detail(SysFunction sysFunction,Model model){
		try {
			model.addAttribute("sysFunction", systemService.getEntity(SysFunction.class, "methord1", sysFunction.getId()));
		} catch (SQLException e) {
			LogUtil.error("获取系统菜单表失败【detail】", e);
		}
		return new ModelAndView("system/sysFunction/sysFunctionDetail");
		
	}
}
