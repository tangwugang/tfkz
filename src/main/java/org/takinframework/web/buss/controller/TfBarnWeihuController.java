package org.takinframework.web.buss.controller;
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
import org.takinframework.core.util.UUIDGenerator;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.buss.entity.TfBarnWeihu;
import org.takinframework.web.buss.service.TfBarnWeihuService;

/**   
 * @Title:TfBarnWeihuController
 * @Description: 通风控制仓房维护表Controller
 * @author twg
 * @date 2014-08-18
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tfBarnWeihuController")
public class TfBarnWeihuController extends BaseController {

	@Autowired
	private TfBarnWeihuService<TfBarnWeihu, String> tfBarnWeihuService;
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
	 * 通风控制仓房维护表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tfBarnWeihu")
	public ModelAndView tfBarnWeihu(HttpServletRequest request) {
		return new ModelAndView("buss/tfBarnWeihu/tfBarnWeihuList");
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
	public void datagrid(TfBarnWeihu tfBarnWeihu,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(TfBarnWeihuEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tfBarnWeihu, request.getParameterMap());
		//this.tfBarnWeihuService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除通风控制仓房维护表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TfBarnWeihu tfBarnWeihu, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "通风控制仓房维护表删除成功";
		systemService.delete(tfBarnWeihu);
		systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加通风控制仓房维护表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TfBarnWeihu tfBarnWeihu, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tfBarnWeihu.getId())) {
			message = "通风控制仓房维护表更新成功";
			try {
				systemService.update(tfBarnWeihu);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "通风控制仓房维护表更新失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "通风控制仓房维护表添加成功";
			try {
				systemService.save(tfBarnWeihu);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "通风控制仓房维护表添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 通风控制仓房维护表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TfBarnWeihu tfBarnWeihu, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tfBarnWeihu.getId())) {
			req.setAttribute("tfBarnWeihuPage", tfBarnWeihu);
		}
		return new ModelAndView("buss/tfBarnWeihu/tfBarnWeihu");
	}
}
