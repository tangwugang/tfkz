package org.takinframework.web.buss.controller;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.takinframework.web.system.entity.SysUser;
import org.takinframework.web.system.service.SystemService;
import org.takinframework.web.util.WebUtil;
import org.takinframework.core.common.model.json.AjaxJson;
import org.takinframework.core.common.model.json.DataGrid;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.doc.DocUtils;
import org.takinframework.core.util.DateUtils;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.PageUtil;
import org.takinframework.core.util.ResourceUtils;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.buss.entity.TfBarn;
import org.takinframework.web.buss.entity.TfBarnDevices;
import org.takinframework.web.buss.entity.TfBarnShiwu;
import org.takinframework.web.buss.entity.TfMachine;
import org.takinframework.web.buss.service.TfMachineService;

import com.google.common.collect.Maps;

import freemarker.template.Template;

/**   
 * @Title:TfMachineController
 * @Description: 通风控制机械通风表Controller
 * @author twg
 * @date 2014-08-29
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tfMachineController")
public class TfMachineController extends BaseController {

	@Autowired
	private TfMachineService<TfMachine, String> tfMachineService;
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
	 * 通风控制机械通风表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tfMachine")
	public ModelAndView tfMachine(TfMachine tfMachine,
			HttpServletRequest request,HttpServletResponse response) {
		try {
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			Map<String, Object> params = Maps.newHashMap();
			params.put("tfBarnId",tfMachine.getTfBarnId());
			if(StringUtil.isNotBlank(startDate) && 
					StringUtil.isNotBlank(endDate)){
				params.put("createDate>=",startDate);
				params.put("createDate<=",DateUtils.addDay(endDate, 1));
				request.setAttribute("page", systemService.findListByPage(new PageUtil<TfMachine>(request, response), tfMachine,params));
				request.setAttribute("startDate", startDate);
				request.setAttribute("endDate", endDate);
			}else{
				request.setAttribute("page", systemService.findListByPage(new PageUtil<TfMachine>(request, response), tfMachine,params));
			}
		} catch (Exception e) {
			LogUtil.error("获取tfMachine失败", e);
		}
		return new ModelAndView("buss/tfMachine/tfMachineList");
	}
	
	/**
	 * 通风控制机械通风表添加和更新
	 * @param tfMachine
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "tfMachineAddOrUpdate")
	public ModelAndView tfMachineAddOrUpdate(TfMachine tfMachine,HttpServletRequest request){
		try {
			request.setAttribute("tfBarn", systemService.getEntity(TfBarn.class, "methord1",tfMachine.getTfBarnId()));
			List<TfBarnShiwu> tfBarnShiwus = systemService.findList(TfBarnShiwu.class, "methord1",tfMachine.getTfBarnId());
			List<TfBarnDevices> tfBarnDevices = systemService.findList(TfBarnDevices.class, "methord1", tfMachine.getTfBarnId());
			if(tfBarnDevices.size()>0){request.setAttribute("tfBarnDevices",tfBarnDevices);}
			if(tfBarnShiwus.size()>0){request.setAttribute("tfBarnShiwu",tfBarnShiwus.get(0));}
			if(StringUtil.isNotBlank(tfMachine.getId())){
				request.setAttribute("tfMachine", systemService.checkEntityExits(tfMachine));
			}
		} catch (Exception e) {
			LogUtil.error("获取tfMachineAddOrUpdate失败", e);
		}
		return new ModelAndView("buss/tfMachine/tfMachineAddOrUpdate");
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
	public void datagrid(TfMachine tfMachine,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(TfMachineEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tfMachine, request.getParameterMap());
		//this.tfMachineService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除通风控制机械通风表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TfMachine tfMachine, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "通风控制机械通风表删除成功";
		try {
			systemService.delete(tfMachine);
			systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			message = "通风控制机械通风表删除失败";
			j.setSuccess(false);
			systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 导出通风控制机械通风记录表
	 * @param tfMachine
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "export")
	public void export(TfMachine tfMachine,
			HttpServletRequest request,HttpServletResponse response){
		String fileName = "机械通风记录"+DateUtils.getDate("yyyyMMddHHmmss")+".doc"; 
		DocUtils.write(response, fileName);
		try {
			SysUser user = ResourceUtils.getSessionUserName();
			tfMachine = systemService.checkEntityExits(tfMachine);
			TfBarn tfBarn = systemService.getEntity(TfBarn.class, "methord1",tfMachine.getTfBarnId());
			List<TfBarnShiwu> tfBarnShiwus = systemService.findList(TfBarnShiwu.class, "methord1",tfMachine.getTfBarnId());
			List<TfBarnDevices> tfBarnDevices = systemService.findList(TfBarnDevices.class, "methord1", tfMachine.getTfBarnId());
			
			Map<String, Object> dataMap = Maps.newHashMap();
			dataMap.put("tfBarn", tfBarn);
			if(tfBarnShiwus.size()>0){dataMap.put("tfBarnShiwu", tfBarnShiwus.get(0));}
			dataMap.put("tfMachine", tfMachine);
			dataMap.put("user", user);
			dataMap.put("createDate", DateUtils.formatDate(tfMachine.getCreateDate(), "yyyy年MM月dd日"));
			dataMap.put("tfMuDi", WebUtil.getTfMuDi(tfMachine.getTfGuiZeId()));
			if(tfBarnDevices.size()>0){
				int num = 0;
				String version = "";
				double power = 0;
				for (TfBarnDevices dev : tfBarnDevices) {
					if(dev.getType() == 0){
						 ++num;
						 version = dev.getVersion();
						 power = dev.getPower();
					}
				}
				dataMap.put("version", version);
				dataMap.put("power", power);
				dataMap.put("num", num);
			}
			Template template = DocUtils.getTemplate("tfMachine.vm");
			template.setEncoding("UTF-8");
			Writer out = response.getWriter();
			DocUtils.createDoc(template, dataMap, out);
		} catch (Exception e) {
			LogUtil.error("获取export失败", e);
		}
	}


	/**
	 * 添加通风控制机械通风表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TfMachine tfMachine, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tfMachine.getId())) {
			message = "通风控制机械通风表更新成功";
			try {
				systemService.update(tfMachine);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "通风控制机械通风表更新失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "通风控制机械通风表添加成功";
			try {
				systemService.save(tfMachine);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "通风控制机械通风表添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 通风控制机械通风表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TfMachine tfMachine, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tfMachine.getId())) {
			req.setAttribute("tfMachinePage", tfMachine);
		}
		return new ModelAndView("buss/tfMachine/tfMachine");
	}
}
