package org.takinframework.web.system.controller;

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
import org.takinframework.web.system.entity.SysRoleFunction;
import org.takinframework.web.system.service.SysRoleFunctionService;

/**   
 * @Title:SysRoleFunctionController
 * @Description: 系统角色菜单表Controller
 * @author twg
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sysRoleFunctionController")
public class SysRoleFunctionController extends BaseController {

	@Autowired
	private SysRoleFunctionService<SysRoleFunction, String> sysRoleFunctionService;
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
	 * 系统角色菜单表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sysRoleFunction")
	public ModelAndView sysRoleFunction(HttpServletRequest request) {
		return new ModelAndView("system/sysRoleFunction/sysRoleFunctionList");
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
	public void datagrid(SysRoleFunction sysRoleFunction,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(SysRoleFunctionEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sysRoleFunction, request.getParameterMap());
		//this.sysRoleFunctionService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除系统角色菜单表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SysRoleFunction sysRoleFunction, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		//sysRoleFunction = systemService.getEntity(SysRoleFunction.class, sysRoleFunction.getId());
		message = "系统角色菜单表删除成功";
		//sysRoleFunctionService.deleteByEntity(sysRoleFunction);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加系统角色菜单表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SysRoleFunction sysRoleFunction, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(sysRoleFunction.getId())) {
			message = "系统角色菜单表更新成功";
			//SysRoleFunctionEntity t = sysRoleFunctionService.get(SysRoleFunction.class, sysRoleFunction.getId());
			try {
				//MyBeanUtils.copyBeanNotNull2Bean(sysRoleFunction, t);
				//sysRoleFunctionService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "系统角色菜单表更新失败";
			}
		} else {
			message = "系统角色菜单表添加成功";
			//sysRoleFunctionService.save(sysRoleFunction);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 系统角色菜单表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SysRoleFunction sysRoleFunction, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sysRoleFunction.getId())) {
			//sysRoleFunction = sysRoleFunctionService.getEntity(SysRoleFunction.class, sysRoleFunction.getId());
			req.setAttribute("sysRoleFunctionPage", sysRoleFunction);
		}
		return new ModelAndView("system/sysRoleFunction/sysRoleFunction");
	}
}
