package org.takinframework.web.buss.controller;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.takinframework.web.system.service.SystemService;
import org.takinframework.core.common.model.json.AjaxJson;
import org.takinframework.core.common.model.json.DataGrid;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.buss.entity.TfBarnTfConfig;
import org.takinframework.web.buss.service.TfBarnTfConfigService;
import com.google.common.collect.Lists;

/**   
 * @Title:TfBarnTfConfigController
 * @Description: 通风控制仓房通风设置表Controller
 * @author twg
 * @date 2014-08-25
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tfBarnTfConfigController")
public class TfBarnTfConfigController extends BaseController {

	@Autowired
	private TfBarnTfConfigService<TfBarnTfConfig, String> tfBarnTfConfigService;
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
	 * 通风控制仓房通风设置表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tfBarnTfConfig")
	public ModelAndView tfBarnTfConfig(HttpServletRequest request) {
		try {
			request.setAttribute("tfBarnTfConfig", systemService.findAll(TfBarnTfConfig.class));
		} catch (SQLException e) {
			LogUtil.error("获取tfBarnTfConfig失败", e);
		}
		return new ModelAndView("buss/tfBarnTfConfig/tfBarnTfConfigList");
	}
	
	/**
	 * 通风控制仓房通风设置表添加和更新
	 * @param tfBarnTfConfig
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "tfBarnTfConfigAddOrUpdate")
	public ModelAndView tfBarnTfConfigAddOrUpdate(TfBarnTfConfig tfBarnTfConfig,HttpServletRequest request){
		if(StringUtil.isNotBlank(tfBarnTfConfig.getId())){
			try {
				request.setAttribute("tfBarnTfConfig", systemService.checkEntityExits(tfBarnTfConfig));
			} catch (Exception e) {
				LogUtil.error("获取tfBarnTfConfigAddOrUpdate失败", e);
			}
		}
		return new ModelAndView("buss/tfBarnTfConfig/tfBarnTfConfigAddOrUpdate");
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
	public void datagrid(TfBarnTfConfig tfBarnTfConfig,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(TfBarnTfConfigEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tfBarnTfConfig, request.getParameterMap());
		//this.tfBarnTfConfigService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除通风控制仓房通风设置表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TfBarnTfConfig tfBarnTfConfig, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "通风控制仓房通风设置表删除成功";
		try {
			systemService.delete(tfBarnTfConfig);
			systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			message = "通风控制仓房通风设置表删除失败";
			j.setSuccess(false);
			systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_ERROR,e);
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加通风控制仓房通风设置表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TfBarnTfConfig tfBarnTfConfig, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tfBarnTfConfig.getId())) {
			message = "通风控制仓房通风设置表更新成功";
			try {
				systemService.update(tfBarnTfConfig);
				systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "通风控制仓房通风设置表更新失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "通风控制仓房通风设置表添加成功";
			try {
				systemService.save(tfBarnTfConfig);
				systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "通风控制仓房通风设置表添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 通风控制仓房通风设置表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TfBarnTfConfig tfBarnTfConfig, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tfBarnTfConfig.getId())) {
			req.setAttribute("tfBarnTfConfigPage", tfBarnTfConfig);
		}
		return new ModelAndView("buss/tfBarnTfConfig/tfBarnTfConfig");
	}
}
