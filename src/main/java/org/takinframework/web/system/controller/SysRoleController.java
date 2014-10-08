package org.takinframework.web.system.controller;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.takinframework.web.system.service.SystemService;
import org.takinframework.core.common.model.json.AjaxJson;
import org.takinframework.core.common.model.json.DataContext;
import org.takinframework.core.common.model.json.DataGrid;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.Page;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.system.entity.SysFunction;
import org.takinframework.web.system.entity.SysRole;
import org.takinframework.web.system.entity.SysRoleFunction;
import org.takinframework.web.system.entity.SysUser;
import org.takinframework.web.system.service.SysRoleService;

import com.google.common.collect.Lists;

/**   
 * @Title:SysRoleController
 * @Description: 系统角色表Controller
 * @author twg
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sysRoleController")
public class SysRoleController extends BaseController {

	@Autowired
	private SysRoleService<SysRole, String> sysRoleService;
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
	 * 系统角色表列表 页面跳转
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(params = "sysRoleList")
	public ModelAndView sysRole(SysRole sysRole,
			HttpServletRequest request,HttpServletResponse response) {
		try {
			Page<SysRole> page = systemService.findAllByPage(new Page<SysRole>(request, response), sysRole);
			request.setAttribute("page", page);
		} catch (Exception e) {
			LogUtil.error("获取系统角色表失败【sysRole】", e);
		}
		return new ModelAndView("system/sysRole/sysRoleList");
	}
	
	/**
	 * 系统角色资源分配页面跳转
	 * @return
	 */
	@RequestMapping(params = "sysRoleAss")
	public ModelAndView sysRoleAss(HttpServletRequest request){
		String roleId = request.getParameter("roleId");
		//通过当前角色id,来获取已分配的资源id
		String sysRoleFuncIds = "";
		List<SysRoleFunction> sysRoleFunctions = systemService.findList(SysRoleFunction.class, "methord1", roleId);
		for (SysRoleFunction s : sysRoleFunctions) {
			sysRoleFuncIds+=s.getFuncId();
			sysRoleFuncIds+=",";
		}
		if(StringUtil.isNotEmpty(sysRoleFuncIds))
		sysRoleFuncIds = sysRoleFuncIds.substring(0, sysRoleFuncIds.length()-1);
		request.setAttribute("sysRoleFuncIds", sysRoleFuncIds);
		return new ModelAndView("system/sysRole/sysRoleAss");
	}
	
	
	/**
	 * 系统人员角色资源分配页面跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "sysUserRoleAss")
	public ModelAndView sysUserRoleAss(HttpServletRequest request){
		request.setAttribute("roleId", request.getParameter("roleId"));
		return new ModelAndView("system/sysRole/sysUserRoleAss");
	}
	
	@RequestMapping(params = "sysRoleAdd")
	public ModelAndView sysRoleAdd(){
		return new ModelAndView("system/sysRole/sysRoleAdd");
	}
	
	@RequestMapping(params = "sysRoleUpdate")
	public ModelAndView sysRoleUpdate(SysRole sysRole,HttpServletRequest request){
		try {
			sysRole = systemService.checkEntityExits(sysRole);
			//通过当前角色id,来获取已分配的资源id
			String sysRoleFuncIds = "";
			List<SysRoleFunction> sysRoleFunctions = systemService.findList(SysRoleFunction.class, "methord1", sysRole.getId());
			for (SysRoleFunction s : sysRoleFunctions) {
				sysRoleFuncIds+=s.getFuncId();
				sysRoleFuncIds+=",";
			}
			if(StringUtil.isNotEmpty(sysRoleFuncIds))
			sysRoleFuncIds = sysRoleFuncIds.substring(0, sysRoleFuncIds.length()-1);
			request.setAttribute("sysRoleFuncIds", sysRoleFuncIds);
			request.setAttribute("sysRole", sysRole);
			
		} catch (Exception e) {
			LogUtil.error("sysRoleUpdate失败", e);
		}
		return new ModelAndView("system/sysRole/sysRoleUpdate");
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
	public void datagrid(SysRole sysRole,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(SysRoleEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sysRole, request.getParameterMap());
		//this.sysRoleService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}
	//对应杭州直属库智能通风系统的人员管理
	@RequestMapping(params = "dataContext")
	@ResponseBody
	public List<DataContext> dataContext(HttpServletResponse response){
		List<DataContext> dataContexts = Lists.newArrayList();
		try {
			List<SysRole> sysRoles = systemService.findAll(SysRole.class);
			for (SysRole r : sysRoles) {
				DataContext dataContext = new DataContext();
				dataContext.setObj(r);
				List<SysFunction> sysFunctions = systemService.findList(SysFunction.class, "methord3",r.getId());
				dataContext.setObjList1(sysFunctions);
				dataContext.setObjList2(systemService.findList(SysUser.class, "methord3", r.getId()));
				dataContexts.add(dataContext);
			}
		} catch (SQLException e) {
			LogUtil.error("获取系统角色表失败", e);
		}
		return dataContexts;
	}
	
	@RequestMapping(params = "checkSysRole")
	@ResponseBody
	public JSONObject checkSysRole(SysRole sysRole,HttpServletRequest request){
		JSONObject obj = new JSONObject();
		List<String> params = Lists.newArrayList();
		params.add("roleName");
		try {
			//检测角色名称，与原先的角色名称是否一样，一样通过
			if(StringUtil.isNotEmpty(sysRole.getRoleName()) && 
					!sysRole.getRoleName().equals(request.getParameter("oldName"))){
				if(systemService.findList(sysRole, params.toArray()).size()>0){
					obj.put("error", "已存在");
				}
			}
			
		} catch (Exception e) {
			LogUtil.error("获取角色信息表失败", e);
			obj.put("error", "网络出错了");
		}
		return obj;
		
	}

	/**
	 * 删除系统角色表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(SysRole sysRole, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "系统角色表删除成功";
		try {
			systemService.delete(sysRole);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			message = "系统角色表删除失败";
			j.setSuccess(false);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_ERROR,e);
		}
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加系统角色表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson save(SysRole sysRole, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(sysRole.getId())) {
			message = "系统角色表更新成功";
			try {
				systemService.update(sysRole,request);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "系统角色表更新失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "系统角色表添加成功";
			try {
				systemService.save(sysRole,request);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "系统角色表添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 系统角色表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(SysRole sysRole, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sysRole.getId())) {
			req.setAttribute("sysRolePage", sysRole);
		}
		return new ModelAndView("system/sysRole/sysRole");
	}
}
