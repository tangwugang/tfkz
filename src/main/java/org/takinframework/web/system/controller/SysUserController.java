package org.takinframework.web.system.controller;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.takinframework.web.system.service.SystemService;
import org.takinframework.core.common.model.json.AjaxJson;
import org.takinframework.core.common.model.json.DataGrid;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.system.entity.SysRole;
import org.takinframework.web.system.entity.SysUser;
import org.takinframework.web.system.service.SysUserService;

import com.google.common.collect.Lists;

/**   
 * @Title:SysUserController
 * @Description: 系统用户表Controller
 * @author twg
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sysUserController")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService<SysUser, String> sysUserService;
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
	 * 系统用户表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sysUser")
	public ModelAndView sysUser(HttpServletRequest request) {
		return new ModelAndView("system/sysUser/sysUserList");
	}
	
	/**
	 * 用户添加和更新
	 * @return
	 */
	@RequestMapping(params = "sysUserAddOrUpdate")
	public ModelAndView sysUserAddOrUpdate(SysUser sysUser,HttpServletRequest request){
		request.setAttribute("roleId", request.getParameter("roleId"));
		if(StringUtil.isNotBlank(sysUser.getId())){
			try {
				request.setAttribute("sysUser", systemService.checkEntityExits(sysUser));
			} catch (Exception e) {
				LogUtil.error("sysUserAddOrUpdate失败", e);
			}
		}
		return new ModelAndView("system/sysUser/sysUserAddOrUpdate");
	}
	
	/**
	 * 系统人员分配组织机构用户列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "sysUserDepart")
	public ModelAndView sysDepartUser(HttpServletRequest request){
		String departId = request.getParameter("departId");
		List<SysUser> sysUsers = Lists.newArrayList();
		if(StringUtil.isNotEmpty(departId)){
			sysUsers = systemService.findList(SysUser.class, "methord1", departId);
		}else{
			sysUsers = systemService.findAll(SysUser.class, "methord1");
		}
		request.setAttribute("sysUsers", sysUsers);
		request.setAttribute("departId", departId);
		return new ModelAndView("system/sysUser/sysUserDepart");
	}
	/**
	 * 前端用户名检测
	 * @param sysUser
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "checkSysUser")
	@ResponseBody
	public JSONObject checkSysUser(SysUser sysUser,HttpServletRequest request){
		JSONObject obj = new JSONObject();
		List<String> params = Lists.newArrayList();
		params.add("userName");
		try {
			//检测用户名称，与原先的用户名称是否一样，一样通过
			if(StringUtil.isNotEmpty(sysUser.getUserName()) && 
					!sysUser.getUserName().equals(request.getParameter("oldName"))){
				if(systemService.findList(sysUser, params.toArray()).size()>0){
					obj.put("error", "已存在");
				}
			}
		} catch (Exception e) {
			LogUtil.error("获取用户信息表失败", e);
			obj.put("error", "网络出错了");
		}
		return obj;
		
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
	public void datagrid(SysUser sysUser,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(SysUserEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sysUser, request.getParameterMap());
		//this.sysUserService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除系统用户表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SysUser sysUser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "系统用户表删除成功";
		try {
			systemService.delete(sysUser);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			message = "系统用户表删除失败";
			j.setSuccess(false);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_ERROR,e);
		}
		
		j.setMsg(message);
		return j;
	}
	/**
	 * 系统用户明细
	 * @param sysUser
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "sysUserDetail")
	public ModelAndView sysUserDetail(SysUser sysUser, HttpServletRequest request){
		if(StringUtil.isNotBlank(sysUser.getId())){
			try {
				request.setAttribute("sysUser", systemService.checkEntityExits(sysUser));
			} catch (Exception e) {
				LogUtil.error("sysUserAddOrUpdate失败", e);
			}
		}
		return new ModelAndView("system/sysUser/sysUserDetail");
	}


	/**
	 * 添加系统用户表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save",method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson save(SysUser sysUser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(sysUser.getId())) {
			message = "系统用户表更新成功";
			try {
				systemService.update(sysUser,request);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "系统用户表更新失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "系统用户表添加成功";
			try {
				systemService.save(sysUser,request);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "系统用户表添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 系统用户表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SysUser sysUser, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sysUser.getId())) {
			req.setAttribute("sysUserPage", sysUser);
		}
		return new ModelAndView("system/sysUser/sysUser");
	}
}
