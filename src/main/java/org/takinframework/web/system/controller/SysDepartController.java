package org.takinframework.web.system.controller;

import java.sql.SQLException;
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
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.system.entity.SysDepart;
import org.takinframework.web.system.service.SysDepartService;

/**   
 * @Title:SysDepartController
 * @Description: 系统机构表Controller
 * @author twg
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sysDepartController")
public class SysDepartController extends BaseController {

	@Autowired
	private SysDepartService<SysDepart, String> sysDepartService;
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
	 * 系统机构表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sysDepart")
	public ModelAndView sysDepart(HttpServletRequest request) {
		return new ModelAndView("system/sysDepart/sysDepartList");
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
	public void datagrid(SysDepart sysDepart,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(SysDepartEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sysDepart, request.getParameterMap());
		//this.sysDepartService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除系统机构表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SysDepart sysDepart, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "系统机构表删除成功";
		systemService.delete(sysDepart);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加系统机构表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SysDepart sysDepart, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(sysDepart.getId())) {
			message = "系统机构表更新成功";
			try {
				systemService.update(sysDepart);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "系统机构表更新失败";
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_ERROR);
			}
		} else {
			message = "系统机构表添加成功";
			try {
				systemService.save(sysDepart);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "系统机构表添加失败";
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_ERROR);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 系统机构表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SysDepart sysDepart, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sysDepart.getId())) {
			req.setAttribute("sysDepartPage", sysDepart);
		}
		return new ModelAndView("system/sysDepart/sysDepart");
	}
}
