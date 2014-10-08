package org.takinframework.web.system.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
import org.takinframework.web.system.entity.SysUserRole;
import org.takinframework.web.system.service.SysUserRoleService;

/**   
 * @Title:SysUserRoleController
 * @Description: 系统用户角色表Controller
 * @author twg
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sysUserRoleController")
public class SysUserRoleController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SysUserRoleController.class);

	@Autowired
	private SysUserRoleService<SysUserRole, String> sysUserRoleService;
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
	 * 系统用户角色表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sysUserRole")
	public ModelAndView sysUserRole(HttpServletRequest request) {
		return new ModelAndView("system/sysUserRole/sysUserRoleList");
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
	public void datagrid(SysUserRole sysUserRole,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(SysUserRoleEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sysUserRole, request.getParameterMap());
		//this.sysUserRoleService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除系统用户角色表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SysUserRole sysUserRole, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		//sysUserRole = systemService.getEntity(SysUserRole.class, sysUserRole.getId());
		message = "系统用户角色表删除成功";
		//sysUserRoleService.deleteByEntity(sysUserRole);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加系统用户角色表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SysUserRole sysUserRole, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(sysUserRole.getId())) {
			message = "系统用户角色表更新成功";
			//SysUserRoleEntity t = sysUserRoleService.get(SysUserRole.class, sysUserRole.getId());
			try {
				//MyBeanUtils.copyBeanNotNull2Bean(sysUserRole, t);
				//sysUserRoleService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "系统用户角色表更新失败";
			}
		} else {
			message = "系统用户角色表添加成功";
			//sysUserRoleService.save(sysUserRole);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 系统用户角色表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SysUserRole sysUserRole, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sysUserRole.getId())) {
			//sysUserRole = sysUserRoleService.getEntity(SysUserRole.class, sysUserRole.getId());
			req.setAttribute("sysUserRolePage", sysUserRole);
		}
		return new ModelAndView("system/sysUserRole/sysUserRole");
	}
}
