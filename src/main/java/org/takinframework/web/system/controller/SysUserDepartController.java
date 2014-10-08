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
import org.takinframework.web.system.entity.SysUserDepart;
import org.takinframework.web.system.service.SysUserDepartService;

/**   
 * @Title:SysUserDepartController
 * @Description: 系统用户机构表Controller
 * @author twg
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sysUserDepartController")
public class SysUserDepartController extends BaseController {

	@Autowired
	private SysUserDepartService<SysUserDepart, String> sysUserDepartService;
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
	 * 系统用户机构表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sysUserDepart")
	public ModelAndView sysUserDepart(HttpServletRequest request) {
		return new ModelAndView("system/sysUserDepart/sysUserDepartList");
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
	public void datagrid(SysUserDepart sysUserDepart,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(SysUserDepartEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sysUserDepart, request.getParameterMap());
		//this.sysUserDepartService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除系统用户机构表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SysUserDepart sysUserDepart, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		//sysUserDepart = systemService.getEntity(SysUserDepart.class, sysUserDepart.getId());
		message = "系统用户机构表删除成功";
		//sysUserDepartService.deleteByEntity(sysUserDepart);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加系统用户机构表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(SysUserDepart sysUserDepart, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(sysUserDepart.getId())) {
			message = "系统用户机构表更新成功";
			//SysUserDepartEntity t = sysUserDepartService.get(SysUserDepart.class, sysUserDepart.getId());
			try {
				//MyBeanUtils.copyBeanNotNull2Bean(sysUserDepart, t);
				//sysUserDepartService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "系统用户机构表更新失败";
			}
		} else {
			message = "系统用户机构表添加成功";
			//sysUserDepartService.save(sysUserDepart);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 系统用户机构表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SysUserDepart sysUserDepart, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sysUserDepart.getId())) {
			//sysUserDepart = sysUserDepartService.getEntity(SysUserDepart.class, sysUserDepart.getId());
			req.setAttribute("sysUserDepartPage", sysUserDepart);
		}
		return new ModelAndView("system/sysUserDepart/sysUserDepart");
	}
}
