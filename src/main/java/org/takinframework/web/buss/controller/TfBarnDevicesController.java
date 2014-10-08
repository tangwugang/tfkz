package org.takinframework.web.buss.controller;
import java.sql.SQLException;
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
import org.takinframework.web.buss.entity.TfBarnDevices;
import org.takinframework.web.buss.service.TfBarnDevicesService;

/**   
 * @Title:TfBarnDevicesController
 * @Description: 通风控制仓房设备表Controller
 * @author twg
 * @date 2014-08-14
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tfBarnDevicesController")
public class TfBarnDevicesController extends BaseController {

	@Autowired
	private TfBarnDevicesService<TfBarnDevices, String> tfBarnDevicesService;
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
	 * 通风控制仓房设备表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tfBarnDevices")
	public ModelAndView tfBarnDevices(HttpServletRequest request) {
		return new ModelAndView("buss/tfBarnDevices/tfBarnDevicesList");
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
	public void datagrid(TfBarnDevices tfBarnDevices,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(TfBarnDevicesEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tfBarnDevices, request.getParameterMap());
		//this.tfBarnDevicesService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除通风控制仓房设备表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TfBarnDevices tfBarnDevices, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "通风控制仓房设备表删除成功";
		systemService.delete(tfBarnDevices);
		systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加通风控制仓房设备表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TfBarnDevices tfBarnDevices, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tfBarnDevices.getId())) {
			message = "通风控制仓房设备表更新成功";
			try {
				systemService.update(tfBarnDevices);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "通风控制仓房设备表更新失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "通风控制仓房设备表添加成功";
			try {
				systemService.save(tfBarnDevices);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "通风控制仓房设备表添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 通风控制仓房设备表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TfBarnDevices tfBarnDevices, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tfBarnDevices.getId())) {
			req.setAttribute("tfBarnDevicesPage", tfBarnDevices);
		}
		return new ModelAndView("buss/tfBarnDevices/tfBarnDevices");
	}
}
