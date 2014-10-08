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
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.system.entity.SysIcon;
import org.takinframework.web.system.service.SysIconService;

/**   
 * @Title:SysIconController
 * @Description: 系统图片表Controller
 * @author twg
 * @date 2014-07-10
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sysIconController")
public class SysIconController extends BaseController {

	@Autowired
	private SysIconService<SysIcon, String> sysIconService;
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
	 * 系统图片表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sysIcon")
	public ModelAndView sysIcon(HttpServletRequest request) {
		return new ModelAndView("system/sysIcon/sysIconList");
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
	public void datagrid(SysIcon sysIcon,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(SysIconEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sysIcon, request.getParameterMap());
		//this.sysIconService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除系统图片表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SysIcon sysIcon, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "系统图片表删除成功";
		systemService.delete(sysIcon);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加系统图片表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SysIcon sysIcon, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(sysIcon.getId())) {
			message = "系统图片表更新成功";
			try {
				systemService.update(sysIcon);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "系统图片表更新失败";
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "系统图片表添加成功";
			try {
				systemService.save(sysIcon);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "系统图片表添加失败";
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 系统图片表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SysIcon sysIcon, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sysIcon.getId())) {
			req.setAttribute("sysIconPage", sysIcon);
		}
		return new ModelAndView("system/sysIcon/sysIcon");
	}
}
