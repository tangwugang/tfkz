package org.takinframework.web.system.controller.core;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.takinframework.core.common.exception.BusinessException;
import org.takinframework.core.common.model.json.AjaxJson;
import org.takinframework.core.common.model.json.ComboTree;
import org.takinframework.core.common.model.json.DataGrid;
import org.takinframework.core.common.model.json.TreeGrid;
import org.takinframework.core.common.model.json.ValidForm;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.util.ApplicationContextUtil;
import org.takinframework.core.util.BrowserUtils;
import org.takinframework.core.util.ContextHolderUtils;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.util.oConvertUtils;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.system.entity.Client;
import org.takinframework.web.system.entity.SysBrowser;
import org.takinframework.web.system.entity.SysDepart;
import org.takinframework.web.system.entity.SysFunction;
import org.takinframework.web.system.entity.SysRole;
import org.takinframework.web.system.entity.SysRoleFunction;
import org.takinframework.web.system.entity.SysType;
import org.takinframework.web.system.entity.SysTypeGroup;
import org.takinframework.web.system.entity.SysUser;
import org.takinframework.web.system.entity.SysUserRole;
import org.takinframework.web.system.manager.ClientManager;
import org.takinframework.web.system.manager.ClientSort;
import org.takinframework.web.system.service.SysFunctionService;
import org.takinframework.web.system.service.SysUserService;
import org.takinframework.web.system.service.SystemService;
import org.takinframework.web.util.WebUtil;

import com.google.common.collect.Lists;



/**
 * 系统资源类
 * 
 * @author twg
 * 
 */
@Controller
@RequestMapping("/systemController")
public class SystemController extends BaseController {
	@Autowired
	private SysUserService<SysUser,String> sysUserService;
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
	 * 获取系统菜单
	 * @return
	 */
	@RequestMapping(params = "sysFuncTree")
	@ResponseBody
	public List<SysFunction> sysFuncTree(){
		List<SysFunction> sysFunctions = systemService.findAll(SysFunction.class,"methord1");
		SysFunction sysFunction = new SysFunction();
		sysFunction.setFuncName(WebUtil.getSysName("productName"));
		sysFunction.setIcon("");
		sysFunction.setFuncLevel(Short.valueOf("0"));
		sysFunction.setId("0");
		sysFunction.setIsOpen(Short.valueOf("1"));
		sysFunctions.add(sysFunction);
		return sysFunctions;
	}
	
	/**
	 * 系统菜单图标
	 * @return
	 */
	@RequestMapping(params = "sysIconList")
	public ModelAndView sysIconList(){
		return new ModelAndView("system/sysIcon/sysIconList");
	}
	/**
	 * 检测菜单信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(params = "checkFunction")
	public ValidForm checkFunction(HttpServletRequest request) {
		ValidForm v = new ValidForm();
		if(systemService.getEntityCount(SysFunction.class,"methord1",request.getParameter("param"))>0){
			v.setInfo("菜单已成在");
			v.setStatus("n");
		}
		return v;
	}


	@RequestMapping(params = "druid")
	public ModelAndView druid() {
		return new ModelAndView(new RedirectView("druid/index.html"));
	}
	/**
	 * 类型字典列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "typeGroupTabs")
	public ModelAndView typeGroupTabs(HttpServletRequest request) {
		List<SysTypeGroup> typegroupList = systemService.findAll(SysTypeGroup.class,"methord1");
		request.setAttribute("typegroupList", typegroupList);
		return new ModelAndView("system/type/typeGroupTabs");
	}

	/**
	 * 类型分组列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "typeGroupList")
	public ModelAndView typeGroupList(HttpServletRequest request) {
		return new ModelAndView("system/type/typeGroupList");
	}

	/**
	 * 类型列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "typeList")
	public ModelAndView typeList(HttpServletRequest request) {
		String typegroupid = request.getParameter("typegroupid");
		SysTypeGroup typegroup = null;
		try {
			typegroup = systemService.getEntity(SysTypeGroup.class,"methord1", typegroupid);
		} catch (SQLException e) {
			throw new BusinessException("获取类型失败", e);
		}
		request.setAttribute("typegroup", typegroup);
		return new ModelAndView("system/type/typeList");
	}

	/**
	 * easyuiAJAX请求数据
	 */

	@RequestMapping(params = "typeGroupGrid")
	public void typeGroupGrid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(TSTypegroup.class, dataGrid);
//		this.systemService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
	}


	/**
	 * easyuiAJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "typeGrid")
	public void typeGrid(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		String typegroupid = request.getParameter("typegroupid");
		String typename = request.getParameter("typename");
//		CriteriaQuery cq = new CriteriaQuery(TSType.class, dataGrid);
//		cq.eq("TSTypegroup.id", typegroupid);
//		cq.like("typename", typename);
//		cq.add();
//		this.systemService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
	}
//	@RequestMapping(params = "typeGroupTree")
//	@ResponseBody
//	public List<ComboTree> typeGroupTree(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(TSTypegroup.class);
//		List<TSTypegroup> typeGroupList = systemService.getListByCriteriaQuery(cq, false);
//		List<ComboTree> trees = new ArrayList<ComboTree>();
//		for (TSTypegroup obj : typeGroupList) {
//			ComboTree tree = new ComboTree();
//			tree.setId(obj.getId());
//			tree.setText(obj.getTypegroupname());
//			List<TSType> types = obj.getTSTypes();
//			if (types != null) {
//				if (types.size() > 0) {
//					//tree.setState("closed");
//					List<ComboTree> children = new ArrayList<ComboTree>();
//					for (TSType type : types) {
//						ComboTree tree2 = new ComboTree();
//						tree2.setId(type.getId());
//						tree2.setText(type.getTypename());
//						children.add(tree2);
//					}
//					tree.setChildren(children);
//				}
//			}
//			//tree.setChecked(false);
//			trees.add(tree);
//		}
//		return trees;
//	}

	@RequestMapping(params = "typeGridTree")
	@ResponseBody
	public List<TreeGrid> typeGridTree(HttpServletRequest request, TreeGrid treegrid) {
//		CriteriaQuery cq;
		List<TreeGrid> treeGrids = new ArrayList<TreeGrid>();
		if (treegrid.getId() != null) {
//			cq = new CriteriaQuery(TSType.class);
//			cq.eq("TSTypegroup.id", treegrid.getId().substring(1));
//			cq.add();
//			List<SysType> typeList = systemService.getListByCriteriaQuery(cq, false);
//			for (SysType obj : typeList) {
//				TreeGrid treeNode = new TreeGrid();
//				treeNode.setId("T"+obj.getId());
//				treeNode.setText(obj.getTypeName());
//				treeNode.setCode(obj.getTypeCode());
//				treeGrids.add(treeNode);
//			}
		} else {
//			cq = new CriteriaQuery(TSTypegroup.class);
//			List<SysTypeGroup> typeGroupList = systemService.getListByCriteriaQuery(cq, false);
//			for (SysTypeGroup obj : typeGroupList) {
//				TreeGrid treeNode = new TreeGrid();
//				treeNode.setId("G"+obj.getId());
//				treeNode.setText(obj.getTypeGroupName());
//				treeNode.setCode(obj.getTypeGroupCode());
//				treeNode.setState("closed");
//				treeGrids.add(treeNode);
//			}
		}

		return treeGrids;
	}
	/**
	 * 删除类型分组或者类型（ID以G开头的是分组）
	 * 
	 * @return
	 */
	@RequestMapping(params = "delTypeGridTree")
	@ResponseBody
	public AjaxJson delTypeGridTree(String id, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (id.startsWith("G")) {//分组
			SysTypeGroup typegroup = null;
			try {
				typegroup = systemService.getEntity(SysTypeGroup.class,"methord1", id.substring(1));
			} catch (SQLException e) {
				throw new BusinessException("获取系统字典类型表失败", e);
			}
			message = "数据字典分组: " + typegroup.getTypeGroupName() + "被删除 成功";
//			systemService.delete(typegroup);
		} else {
			SysType type = null;
			try {
				type = systemService.getEntity(SysType.class,"methord1", id.substring(1));
			} catch (SQLException e) {
				throw new BusinessException("获取系统字典表失败", e);
			}
			message = "数据字典类型: " + type.getTypeName() + "被删除 成功";
//			systemService.delete(type);
		}
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		//刷新缓存
		systemService.refleshTypeGroupCach();
		j.setMsg(message);
		return j;
	}

	/**
	 * 删除类型分组
	 * 
	 * @return
	 */
	@RequestMapping(params = "delTypeGroup")
	@ResponseBody
	public AjaxJson delTypeGroup(SysTypeGroup typegroup, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try {
			typegroup = systemService.getEntity(SysTypeGroup.class,"methord1", typegroup.getId());
		} catch (SQLException e) {
			throw new BusinessException("获取系统字典类型表失败", e);
		}
		message = "类型分组: " + typegroup.getTypeGroupName() + "被删除 成功";
//		systemService.delete(typegroup);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		//刷新缓存
		systemService.refleshTypeGroupCach();
		j.setMsg(message);
		return j;
	}

	/**
	 * 删除类型
	 * 
	 * @return
	 */
	@RequestMapping(params = "delType")
	@ResponseBody
	public AjaxJson delType(SysType type, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try {
			type = systemService.getEntity(SysType.class,"methord1", type.getId());
		} catch (SQLException e) {
			throw new BusinessException("获取系统字典表失败", e);
		}
		message = "类型: " + type.getTypeName() + "被删除 成功";
//		systemService.delete(type);
		//刷新缓存
		systemService.refleshTypesCach(SysType.class);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}

	/**
	 * 检查分组代码
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "checkTypeGroup")
	@ResponseBody
	public ValidForm checkTypeGroup(HttpServletRequest request) {
		ValidForm v = new ValidForm();
		String typegroupcode = oConvertUtils.getString(request.getParameter("param"));
		String code=oConvertUtils.getString(request.getParameter("code"));
		List<SysTypeGroup> typegroups=systemService.findList(SysTypeGroup.class,"methord1",typegroupcode);
		if(typegroups.size()>0&&!code.equals(typegroupcode))
		{
			v.setInfo("分组已存在");
			v.setStatus("n");
		}
		return v;
	}
	/**
	 * 添加类型分组
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "saveTypeGroup")
	@ResponseBody
	public AjaxJson saveTypeGroup(SysTypeGroup typegroup, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(typegroup.getId())) {
			message = "类型分组: " + typegroup.getTypeGroupName() + "被更新成功";
//			sysUserService.saveOrUpdate(typegroup);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} else {
			message = "类型分组: " + typegroup.getTypeGroupName() + "被添加成功";
//			userService.save(typegroup);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		//刷新缓存
		systemService.refleshTypeGroupCach();
		j.setMsg(message);
		return j;
	}
	/**
	 * 检查类型代码
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "checkType")
	@ResponseBody
	public ValidForm checkType(HttpServletRequest request) {
		ValidForm v = new ValidForm();
		String typecode=oConvertUtils.getString(request.getParameter("param"));
		String code=oConvertUtils.getString(request.getParameter("code"));
		String typeGroupCode=oConvertUtils.getString(request.getParameter("typeGroupCode"));
		StringBuilder hql = new StringBuilder("FROM ").append(SysType.class.getName()).append(" AS entity WHERE 1=1 ");
		hql.append(" AND entity.TSTypegroup.typegroupcode =  '").append(typeGroupCode).append("'");
		hql.append(" AND entity.typecode =  '").append(typecode).append("'");
//		List<Object> types = this.systemService.findByQueryString(hql.toString());
//		if(types.size()>0&&!code.equals(typecode))
//		{
//			v.setInfo("类型已存在");
//			v.setStatus("n");
//		}
		return v;
	}
	/**
	 * 添加类型
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "saveType")
	@ResponseBody
	public AjaxJson saveType(SysType type, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(type.getId())) {
			message = "类型: " + type.getTypeName() + "被更新成功";
//			userService.saveOrUpdate(type);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} else {
			message = "类型: " + type.getTypeName() + "被添加成功";
//			userService.save(type);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		//刷新缓存
		systemService.refleshTypesCach(SysType.class);
		j.setMsg(message);
		return j;
	}

	

	/**
	 * 类型分组列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "aouTypeGroup")
	public ModelAndView aouTypeGroup(SysTypeGroup typegroup, HttpServletRequest req) {
		if (typegroup.getId() != null) {
			try {
				typegroup = systemService.getEntity(SysTypeGroup.class,"methord1", typegroup.getId());
			} catch (SQLException e) {
				throw new BusinessException("获取系统字典类型表失败", e);
			}
			req.setAttribute("typegroup", typegroup);
		}
		return new ModelAndView("system/type/typegroup");
	}

	/**
	 * 类型列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdateType")
	public ModelAndView addorupdateType(SysType type, HttpServletRequest req) {
		String typegroupid = req.getParameter("typegroupid");
		req.setAttribute("typegroupid", typegroupid);
		if (StringUtil.isNotEmpty(type.getId())) {
			try {
				type = systemService.getEntity(SysType.class,"methord1", type.getId());
			} catch (SQLException e) {
				throw new BusinessException("获取系统字典表失败", e);
			}
			req.setAttribute("type", type);
		}
		return new ModelAndView("system/type/type");
	}

	/*
	 * *****************部门管理操作****************************
	 */
	/**
	 * 系统组织机构树
	 * @return
	 */
	@RequestMapping(params = "sysDepartTree")
	@ResponseBody
	public List<SysDepart> sysDepartTree(){
		List<SysDepart> sysDeparts = systemService.findAll(SysDepart.class,"methord1");
		return sysDeparts;
	}

	/**
	 * 部门列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "depart")
	public ModelAndView depart() {
		return new ModelAndView("system/depart/departList");
	}

	/**
	 * easyuiAJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagridDepart")
	public void datagridDepart(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(TSDepart.class, dataGrid);
//		this.systemService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除部门
	 * 
	 * @return
	 */
	@RequestMapping(params = "delDepart")
	@ResponseBody
	public AjaxJson delDepart(SysDepart depart, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		try {
			depart = systemService.getEntity(SysDepart.class,"methord1", depart.getId());
		} catch (SQLException e) {
			LogUtil.error("获取系统机构表失败", e);
		}
		message = "部门: " + depart.getDepartName() + "被删除 成功";
//		systemService.delete(depart);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

		return j;
	}

	/**
	 * 添加部门
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "saveDepart")
	@ResponseBody
	public AjaxJson saveDepart(SysDepart depart, HttpServletRequest request) {
		// 设置上级部门
		String pid = request.getParameter("TSPDepart.id");
		if (pid.equals("")) {
//			depart.setTSPDepart(null);
		}
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(depart.getId())) {
			message = "部门: " + depart.getDepartName() + "被更新成功";
//			userService.saveOrUpdate(depart);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} else {
			message = "部门: " + depart.getDepartName() + "被添加成功";
//			userService.save(depart);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 部门列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdateDepart")
	public ModelAndView addorupdateDepart(SysDepart depart, HttpServletRequest req) {
		List<SysDepart> departList = systemService.findAll(SysDepart.class,"methord1");
		req.setAttribute("departList", departList);
		if (depart.getId() != null) {
			try {
				depart = systemService.getEntity(SysDepart.class,"methord1", depart.getId());
			} catch (SQLException e) {
				throw new BusinessException("获取系统机构表失败", e);
			}
			req.setAttribute("depart", depart);
		}
		return new ModelAndView("system/depart/depart");
	}

	/**
	 * 父级权限列表
	 * 
	 * @param role
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 * @return
	 */
	@RequestMapping(params = "setPFunction")
	@ResponseBody
	public List<ComboTree> setPFunction(HttpServletRequest request, ComboTree comboTree) {
		return null;
//		CriteriaQuery cq = new CriteriaQuery(TSDepart.class);
//		if (StringUtil.isNotEmpty(comboTree.getId())) {
//			cq.eq("TSPDepart.id", comboTree.getId());
//		}
//		// ----------------------------------------------------------------
//		// ----------------------------------------------------------------
//		if (StringUtil.isEmpty(comboTree.getId())) {
//			cq.isNull("TSPDepart.id");
//		}
//		// ----------------------------------------------------------------
//		// ----------------------------------------------------------------
//		cq.add();
//		List<SysDepart> departsList = systemService.getListByCriteriaQuery(cq, false);
//		List<ComboTree> comboTrees = new ArrayList<ComboTree>();
//		comboTrees = systemService.comTree(departsList, comboTree);
//		return comboTrees;

	}

	/*
	 * *****************角色管理操作****************************
	 */
	/**
	 * 角色列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "role")
	public ModelAndView role() {
		return new ModelAndView("system/role/roleList");
	}

	/**
	 * easyuiAJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagridRole")
	public void datagridRole(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(TSRole.class, dataGrid);
//		this.systemService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除角色
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "delRole")
	@ResponseBody
	public AjaxJson delRole(SysRole role, String ids, HttpServletRequest request) {
		message = "角色: " + role.getRoleName() + "被删除成功";
		AjaxJson j = new AjaxJson();
		try {
			role = systemService.getEntity(SysRole.class,"methord1", role.getId());
		} catch (SQLException e) {
			throw new BusinessException("获取系统角色表失败", e);
		}
//		userService.delete(role);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}

	/**
	 * 角色录入
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "saveRole")
	@ResponseBody
	public AjaxJson saveRole(SysRole role, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (role.getId() != null) {
			message = "角色: " + role.getRoleName() + "被更新成功";
//			userService.saveOrUpdate(role);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} else {
			message = "角色: " + role.getRoleName() + "被添加成功";
//			userService.saveOrUpdate(role);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 角色列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "fun")
	public ModelAndView fun(HttpServletRequest request) {
		Integer roleid = oConvertUtils.getInt(request.getParameter("roleid"), 0);
		request.setAttribute("roleid", roleid);
		return new ModelAndView("system/role/roleList");
	}

	/**
	 * 设置权限
	 * 
	 * @param role
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 * @return
	 */
	@RequestMapping(params = "setAuthority")
	@ResponseBody
	public List<ComboTree> setAuthority(SysRole role, HttpServletRequest request, ComboTree comboTree) {
//		CriteriaQuery cq = new CriteriaQuery(TSFunction.class);
//		if (comboTree.getId() != null) {
//			cq.eq("TFunction.functionid", oConvertUtils.getInt(comboTree.getId(), 0));
//		}
//		if (comboTree.getId() == null) {
//			cq.isNull("TFunction");
//		}
//		cq.add();
//		List<TSFunction> functionList = systemService.getListByCriteriaQuery(cq, false);
		List<ComboTree> comboTrees = new ArrayList<ComboTree>();
		Integer roleid = oConvertUtils.getInt(request.getParameter("roleid"), 0);
		List<SysFunction> loginActionlist = new ArrayList<SysFunction>();// 已有权限菜单
		try {
			role = this.systemService.getEntity(SysRole.class,"methord1", roleid);
		} catch (SQLException e) {
			throw new BusinessException("获取系统角色表失败", e);
		}
		if (role != null) {
			List<SysRoleFunction> roleFunctionList = systemService.findList(SysRoleFunction.class,"methord1",role.getId());
			if (roleFunctionList.size() > 0) {
				for (SysRoleFunction roleFunction : roleFunctionList) {
					SysFunction function = null;
					try {
						function = systemService.getEntity(SysFunction.class, "methord1",roleFunction.getFuncId());
					} catch (SQLException e) {
						throw new BusinessException("获取系统菜单表失败", e);
					}
					loginActionlist.add(function);
				}
			}
		}
//		ComboTreeModel comboTreeModel = new ComboTreeModel("id", "functionName", "TSFunctions");
//		comboTrees = systemService.ComboTree(functionList, comboTreeModel, loginActionlist);
//		return comboTrees;
		return comboTrees;
	}
	/**
	 * 系统角色资源分配
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "sysRoleAss")
	@ResponseBody
	public AjaxJson sysRoleAss(HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "角色分配成功";
		String roleId  = request.getParameter("roleId");//角色id
		String funcIds = request.getParameter("ids");//资源ids
		List<SysRoleFunction> roleFunctionList = systemService.findList(SysRoleFunction.class,"methord1",roleId);
		systemService.deleteAllEntitie(roleFunctionList);
		if(StringUtil.isNotEmpty(funcIds)){
			String funcId[] = funcIds.split(",");
			for (String s : funcId) {
				SysRoleFunction rf = new SysRoleFunction();
				rf.setFuncId(s);
				rf.setRoleId(roleId);
				try {
					systemService.save(rf);
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				} catch (SQLException e) {
					message = "角色分配失败";
					systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_ERROR);
				}
				
			}
		}
		j.setMsg(message);
		return j;
		
	}
	
	/**
	 * 系统用户资源分配
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "sysUserRoleAss")
	@ResponseBody
	public AjaxJson sysUserRoleAss(HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "用户资源分配成功";
		String roleId  = request.getParameter("roleId");//角色id
		String userIds = request.getParameter("ids");//资源ids
		List<SysUserRole> sysUserRoles = systemService.findList(SysUserRole.class, "methord2", roleId);
		systemService.deleteAllEntitie(sysUserRoles);
		if(StringUtil.isNotEmpty(userIds)){
			String userId[] = userIds.split(",");
			for (String id : userId) {
				SysUserRole sysUserRole = new SysUserRole();
//				if(systemService.getEntityCount(SysUser.class, "methord1", id)>0){
					sysUserRole.setUserId(id);
					sysUserRole.setRoleId(roleId);
					try {
						systemService.save(sysUserRole);
						systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
					} catch (SQLException e) {
						message = "用户资源分配失败";
						systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_ERROR);
					}
//				}
				
			}
		}
		j.setMsg(message);
		return j;
		
	}

	/**
	 * 更新权限
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "updateAuthority")
	public String updateAuthority(HttpServletRequest request) {
		Integer roleid = oConvertUtils.getInt(request.getParameter("roleid"), 0);
		String rolefunction = request.getParameter("rolefunctions");
		SysRole role = null;
		try {
			role = this.systemService.getEntity(SysRole.class,"methord1", roleid);
		} catch (SQLException e) {
			LogUtil.error("获取系统角色表失败", e);
		}
		List<SysRoleFunction> roleFunctionList = systemService.findList(SysRoleFunction.class,"methord1",role.getId());
//		systemService.deleteAllEntitie(roleFunctionList);
		String[] roleFunctions = null;
		if (rolefunction != "") {
			roleFunctions = rolefunction.split(",");
			for (String s : roleFunctions) {
				SysRoleFunction rf = new SysRoleFunction();
				SysFunction f;
				try {
					f = this.systemService.getEntity(SysFunction.class,"methord1", s);
					rf.setFuncId(f.id);
					rf.setRoleId(role.getId());
				} catch (SQLException e) {
					LogUtil.error("获取系统菜单表失败", e);
				}
				
				
//				this.systemService.save(rf);
			}
		}
		return "system/role/roleList";
	}

	/**
	 * 角色页面跳转
	 * 
	 * @param role
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "addorupdateRole")
	public ModelAndView addorupdateRole(SysRole role, HttpServletRequest req) {
		if (role.getId() != null) {
			try {
				role = systemService.getEntity(SysRole.class,"methord1", role.getId());
			} catch (SQLException e) {
				throw new BusinessException("获取系统角色表失败", e);
			}
			req.setAttribute("role", role);
		}
		return new ModelAndView("system/role/role");
	}

	/**
	 * 操作列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "operate")
	public ModelAndView operate(HttpServletRequest request) {
		String roleid = request.getParameter("roleid");
		request.setAttribute("roleid", roleid);
		return new ModelAndView("system/role/functionList");
	}

	/**
	 * 权限操作列表
	 * 
	 * @param role
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "setOperate")
	@ResponseBody
	public List<TreeGrid> setOperate(HttpServletRequest request, TreeGrid treegrid) {
		String roleid = request.getParameter("roleid");
//		CriteriaQuery cq = new CriteriaQuery(TSFunction.class);
//		if (treegrid.getId() != null) {
//			cq.eq("TFunction.functionid", oConvertUtils.getInt(treegrid.getId(), 0));
//		}
//		if (treegrid.getId() == null) {
//			cq.isNull("TFunction");
//		}
//		cq.add();
//		List<TSFunction> functionList = systemService.getListByCriteriaQuery(cq, false);
		List<TreeGrid> treeGrids = new ArrayList<TreeGrid>();
//		Collections.sort(functionList, new SetListSort());
//		TreeGridModel treeGridModel = new TreeGridModel();
//		treeGridModel.setRoleid(roleid);
//		treeGrids = systemService.treegrid(functionList, treeGridModel);
		return treeGrids;

	}

	/**
	 * 操作录入
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "saveOperate")
	@ResponseBody
	public AjaxJson saveOperate(HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String fop = request.getParameter("fp");
		String roleid = request.getParameter("roleid");
		// 录入操作前清空上一次的操作数据
		clearp(roleid);
		String[] fun_op = fop.split(",");
		String aa = "";
		String bb = "";
		// 只有一个被选中
		if (fun_op.length == 1) {
			bb = fun_op[0].split("_")[1];
			aa = fun_op[0].split("_")[0];
			savep(roleid, bb, aa);
		} else {
			// 至少2个被选中
			for (int i = 0; i < fun_op.length; i++) {
				String cc = fun_op[i].split("_")[0]; // 操作id
				if (i > 0 && bb.equals(fun_op[i].split("_")[1])) {
					aa += "," + cc;
					if (i == (fun_op.length - 1)) {
						savep(roleid, bb, aa);
					}
				} else if (i > 0) {
					savep(roleid, bb, aa);
					aa = fun_op[i].split("_")[0]; // 操作ID
					if (i == (fun_op.length - 1)) {
						bb = fun_op[i].split("_")[1]; // 权限id
						savep(roleid, bb, aa);
					}

				} else {
					aa = fun_op[i].split("_")[0]; // 操作ID
				}
				bb = fun_op[i].split("_")[1]; // 权限id

			}
		}

		return j;
	}

	/**
	 * 更新操作
	 * 
	 * @param roleid
	 * @param functionid
	 * @param ids
	 */
	public void savep(String roleid, String functionid, String ids) {
		String hql = "from TRoleFunction t where" + " t.TSRole.id=" + roleid + " " + "and t.TFunction.functionid=" + functionid;
//		TSRoleFunction rFunction = systemService.singleResult(hql);
//		if (rFunction != null) {
//			rFunction.setOperation(ids);
//			systemService.saveOrUpdate(rFunction);
//		}
	}

	/**
	 * 清空操作
	 * 
	 * @param roleid
	 */
	public void clearp(String roleid) {
		String hql = "from TRoleFunction t where" + " t.TSRole.id=" + roleid;
//		List<TSRoleFunction> rFunctions = systemService.findByQueryString(hql);
//		if (rFunctions.size() > 0) {
//			for (TSRoleFunction tRoleFunction : rFunctions) {
//				tRoleFunction.setOperation(null);
//				systemService.saveOrUpdate(tRoleFunction);
//			}
//		}
	}

	/************************************** 版本维护 ************************************/

	/**
	 * 版本维护列表
	 */
	@RequestMapping(params = "versionList")
	public void versionList(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(TSVersion.class, dataGrid);
//		this.systemService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除版本
	 */

//	@RequestMapping(params = "delVersion")
//	@ResponseBody
//	public AjaxJson delVersion(TSVersion version, HttpServletRequest request) {
////		AjaxJson j = new AjaxJson();
////		version = systemService.getEntity(TSVersion.class, version.getId());
////		message = "版本：" + version.getVersionName() + "被删除 成功";
////		systemService.delete(version);
////		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
////
////		return j;
//	}

	/**
	 * 版本添加跳转
	 * 
	 * @param icon
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "addversion")
	public ModelAndView addversion(HttpServletRequest req) {
		return new ModelAndView("system/version/version");
	}

	/**
	 * 保存版本
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping(params = "saveVersion", method = RequestMethod.POST)
//	@ResponseBody
//	public AjaxJson saveVersion(HttpServletRequest request) throws Exception {
//		AjaxJson j = new AjaxJson();
//		TSVersion version = new TSVersion();
//		String versionName = request.getParameter("versionName");
//		String versionCode = request.getParameter("versionCode");
//		version.setVersionCode(versionCode);
//		version.setVersionName(versionName);
//		systemService.save(version);
//		j.setMsg("版本保存成功");
//		return j;
//	}

	/**
	 * 新闻法规文件列表
	 */
//	@RequestMapping(params = "documentList")
//	public void documentList(HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
//		CriteriaQuery cq = new CriteriaQuery(TSDocument.class, dataGrid);
//		String typecode = oConvertUtils.getString(request.getParameter("typecode"));
//		cq.createAlias("TSType", "TSType");
//		cq.eq("TSType.typecode", typecode);
//		cq.add();
//		this.systemService.getDataGridReturn(cq, true);
//		TagUtil.datagrid(response, dataGrid);
//	}
	
	/**
	 * 删除文档
	 * 
	 * @param ids
	 * @return
	 */
//	@RequestMapping(params = "delDocument")
//	@ResponseBody
//	public AjaxJson delDocument(TSDocument document, HttpServletRequest request) {
//		AjaxJson j = new AjaxJson();
//		document = systemService.getEntity(TSDocument.class, document.getId());
//		message = "" + document.getDocumentTitle() + "被删除成功";
//		userService.delete(document);
//		systemService.addLog(message, Globals.Log_Type_DEL,
//				Globals.Log_Leavel_INFO);
//		j.setSuccess(true);
//		j.setMsg(message);
//		return j;
//	}
	
	/**
	 * 文件添加跳转
	 * 
	 * @param icon
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "addFiles")
	public ModelAndView addFiles(HttpServletRequest req) {
		return new ModelAndView("system/document/files");
	}
	
	/**
	 * 保存文件
	 * 
	 * @param ids
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping(params = "saveFiles", method = RequestMethod.POST)
//	@ResponseBody
//	public AjaxJson saveFiles(HttpServletRequest request, HttpServletResponse response, TSDocument document) {
//		AjaxJson j = new AjaxJson();
//		Map<String, Object> attributes = new HashMap<String, Object>();
//		TSTypegroup tsTypegroup=systemService.getTypeGroup("fieltype","文档分类");
//		TSType tsType = systemService.getType("files","附件", tsTypegroup);
//		String fileKey = oConvertUtils.getString(request.getParameter("fileKey"));// 文件ID
//		String documentTitle = oConvertUtils.getString(request.getParameter("documentTitle"));// 文件标题
//		if (StringUtil.isNotEmpty(fileKey)) {
//			document.setId(fileKey);
//			document = systemService.getEntity(TSDocument.class, fileKey);
//			document.setDocumentTitle(documentTitle);
//
//		}
//		document.setSubclassname(MyClassLoader.getPackPath(document));
//		document.setCreatedate(DataUtils.gettimestamp());
//		document.setTSType(tsType);
//		UploadFile uploadFile = new UploadFile(request, document);
//		uploadFile.setCusPath("files");
//		uploadFile.setSwfpath("swfpath");
//		document = systemService.uploadFile(uploadFile);
//		attributes.put("url", document.getRealpath());
//		attributes.put("fileKey", document.getId());
//		attributes.put("name", document.getAttachmenttitle());
//		attributes.put("viewhref", "commonController.do?objfileList&fileKey=" + document.getId());
//		attributes.put("delurl", "commonController.do?delObjFile&fileKey=" + document.getId());
//		j.setMsg("文件添加成功");
//		j.setAttributes(attributes);
//		return j;
//	}
	
	/**
	 * 在线用户列表
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param tSOline
	 */

	@RequestMapping(params = "datagridOnline")
	public void datagridOnline(Client tSOnline,HttpServletRequest request, 
			HttpServletResponse response, DataGrid dataGrid) {
		List<Client> onlines = new ArrayList<Client>();
		onlines.addAll(ClientManager.getInstance().getAllClient());
		dataGrid.setTotal(onlines.size());
		dataGrid.setResults(getClinetList(onlines,dataGrid));
//		TagUtil.datagrid(response, dataGrid);
	}
	/**
	 * 获取当前页面的用户列表
	 * @param onlines
	 * @param dataGrid
	 * @return
	 */
	private List<Client> getClinetList(List<Client> onlines, DataGrid dataGrid) {
		Collections.sort(onlines, new ClientSort());
		List<Client> result = new ArrayList<Client>();
		for(int i = (dataGrid.getPage()-1)*dataGrid.getRows();
				i<onlines.size()&&i<dataGrid.getPage()*dataGrid.getRows();i++){
			result.add(onlines.get(i));
		}
		return result;
	}
	
	/**
	 * 异步检测浏览器是否活跃
	 */
	
	@RequestMapping(params = "isActiveOfBrowser")
	private void isActiveOfBrowser(SysBrowser sysBrowser){
		HttpSession session  = ContextHolderUtils.getSession();
		HttpServletRequest request = ContextHolderUtils.getRequest();
		String broswer = BrowserUtils.checkBrowse(request);
		sysBrowser.setSessionId(session.getId());
		sysBrowser.setUserAgent(broswer);
		sysBrowser.setIp(oConvertUtils.getIp());
		try {
			List<String> param = Lists.newArrayList();
			param.add("sessionId");
			List<SysBrowser> browsers = systemService.findList(sysBrowser, param.toArray());
			if(browsers.size()>0){//有sessionId记录的浏览器,就更新
				try {
					systemService.update(browsers.get(0));
				} catch (Exception e) {
					systemService.addLog("检测浏览器是否活跃更新失败", Globals.Log_Type_UPDATE, Globals.Log_Leavel_ERROR, e);
				}
			}else{
				systemService.save(sysBrowser);
			}
		} catch (Exception e) {
			systemService.addLog("检测浏览器是否活跃添加失败", Globals.Log_Type_INSERT, Globals.Log_Leavel_ERROR, e);
		}
	}
	
	
}
