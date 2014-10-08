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
import org.takinframework.core.common.model.json.Ztree;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.buss.entity.TfBarn;
import org.takinframework.web.buss.entity.TfBarnDevices;
import org.takinframework.web.buss.entity.TfBarnTfConfig;
import org.takinframework.web.buss.entity.TfConfigDevices;
import org.takinframework.web.buss.entity.TfGuize;
import org.takinframework.web.buss.entity.TfGuizeTimes;
import org.takinframework.web.buss.service.TfGuizeService;

import com.google.common.collect.Lists;

/**   
 * @Title:TfGuizeController
 * @Description: 通风控制规则表Controller
 * @author twg
 * @date 2014-08-21
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tfGuizeController")
public class TfGuizeController extends BaseController {

	@Autowired
	private TfGuizeService<TfGuize, String> tfGuizeService;
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
	 * 通风控制规则表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tfGuize")
	public ModelAndView tfGuize(HttpServletRequest request) {
		try {
			request.setAttribute("tfGuize", systemService.findAll(TfGuize.class));
		} catch (SQLException e) {
			LogUtil.error("获取tfGuize失败", e);
		}
		return new ModelAndView("buss/tfGuize/tfGuizeList");
	}
	
	/**
	 * 通风控制规则表添加和更新
	 * @param tfGuize
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "tfGuizeAddOrUpdate")
	public ModelAndView tfGuizeAddOrUpdate(TfGuize tfGuize,HttpServletRequest request){
		if(StringUtil.isNotBlank(tfGuize.getId())){
			try {
				List<TfGuizeTimes> tfgTimes = systemService.findList(TfGuizeTimes.class, "methord1", tfGuize.getId());
				if(tfgTimes.size()>0){request.setAttribute("tfGuizeTimes", tfgTimes);}
				request.setAttribute("tfGuize", systemService.checkEntityExits(tfGuize));
			} catch (Exception e) {
				LogUtil.error("获取tfGuizeAddOrUpdate失败", e);
			}
		}
		return new ModelAndView("buss/tfGuize/tfGuizeAddOrUpdate");
	}
	
	/**
	 * 检测通风控制规则表是否存在
	 * @param tfGuize
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "checkTfGuize")
	@ResponseBody
	public JSONObject checkTfGuize(TfGuize tfGuize,HttpServletRequest request){
		JSONObject obj = new JSONObject();
		List<String> params = Lists.newArrayList();
		params.add("tfGuiZeName"); //按需求要进行修改
		try {
			//检测用户名称，与原先的用户名称是否一样，一样通过(tfGuize.getName(),按需求要进行修改)
			if(StringUtil.isNotEmpty(tfGuize.getTfGuiZeName()) && 
					!tfGuize.getTfGuiZeName().equals(request.getParameter("oldName"))){
				if(systemService.findList(tfGuize, params.toArray()).size()>0){
					obj.put("error", "已存在");
				}
			}
		} catch (Exception e) {
			LogUtil.error("获取tfGuize失败", e);
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
	public void datagrid(TfGuize tfGuize,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(TfGuizeEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tfGuize, request.getParameterMap());
		//this.tfGuizeService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除通风控制规则表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TfGuize tfGuize, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "通风控制规则表删除成功";
		try {
			systemService.delete(tfGuize);
			systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			message = "通风控制规则表删除失败";
			j.setSuccess(false);
			systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_ERROR,e);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 添加通风控制规则表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TfGuize tfGuize,TfGuizeTimes tfGuizeTimes, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tfGuize.getId())) {
			message = "通风控制规则表更新成功";
			try {
				systemService.update(tfGuize,tfGuizeTimes,request);
				systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = e.getMessage();
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "通风控制规则表添加成功";
			try {
				systemService.save(tfGuize,tfGuizeTimes,request);
				systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "通风控制规则表添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 通过粮仓类型获取仓房信息
	 * @param tfBarn
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "tfBarnSelect")
	@ResponseBody
	public List<Ztree> tfBarnSelect(TfBarnTfConfig tfBarnTfConfig,TfBarn tfBarn, HttpServletRequest request){
		tfBarn.setLiaCaType(tfBarnTfConfig.getBarnType());
		List<Ztree> barns = Lists.newArrayList();//返回ztree的JSON格式数据
		List<String> param = Lists.newArrayList();
		List<TfBarnDevices> tfBarnDevices = Lists.newArrayList();
		param.add("liaCaType");
		try {
			List<TfBarn> tfBarns = systemService.findList(tfBarn,param.toArray());
			//通过粮仓类型获取 仓房信息与获仓房设备
			if(tfBarns.size()>0){
				tfBarnDevices = systemService.findList(TfBarnDevices.class, "methord1", tfBarns.get(0).getId());
			}
			
			//通过粮仓类型获取通风控制设备设置信息
			if(StringUtil.isNotBlank(tfBarnTfConfig.getBarnType()) &&
					StringUtil.isNotBlank(tfBarnTfConfig.getTfGuiZeId())){
				param = Lists.newArrayList();
				param.add("barnType");
				param.add("tfGuiZeId");
				//获取仓房通风设置表和仓房通风设置关联设备表
				List<TfBarnTfConfig> tfBarnTfConfigs = systemService.findList(tfBarnTfConfig, param.toArray());
				if(tfBarnTfConfigs.size()>0){
					List<TfConfigDevices> tfConfigDevices = systemService.findList(TfConfigDevices.class, "methord1", tfBarnTfConfigs.get(0).getId());
					//仓房设备信息和通风设置关联设备表都不为空时，返现在页面上的设备信息其实就是通风设置关联表的信息（设备状态和通风模式 ）
					if(tfConfigDevices.size()>0 && tfBarnDevices.size()>0){
						for (int i = 0; i < tfBarnDevices.size(); i++) {
							for (int j = 0; j < tfConfigDevices.size(); j++) {
								if(tfConfigDevices.get(j).getTfBarnDevicesId().equals(tfBarnDevices.get(i).getId())){
									tfBarnDevices.get(i).setStatus(tfConfigDevices.get(j).getStatus());
									tfBarnDevices.get(i).setCfMode(tfConfigDevices.get(j).getCfMode());
									break;
								}
							}
							
						}
					}
				}
				
				for (TfBarn b : tfBarns) {
					Ztree ztree = new Ztree();
					ztree.setId(b.getBarnNo());
					ztree.setName(b.getBarnNo());
					ztree.setObj(tfBarnDevices);
					for (TfBarnTfConfig c : tfBarnTfConfigs) {
						if(c.getBarnNo().contains(b.getBarnNo())){
							ztree.setChecked(true);
						}
						ztree.setpId(c.getId());//TfBarnTfConfig的id
					}
					barns.add(ztree);
				}
				
			}else{
				for (TfBarn b : tfBarns) {
					Ztree ztree = new Ztree();
					ztree.setId(b.getBarnNo());
					ztree.setName(b.getBarnNo());
					ztree.setObj(tfBarnDevices);
					barns.add(ztree);
				}
			}
		} catch (Exception e) {
			LogUtil.error("获取tfBarnSelect失败", e);
		}
		
		return barns;
	}

	/**
	 * 通风控制规则表配置页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tfGzConfig")
	public ModelAndView addorupdate(TfGuize tfGuize, HttpServletRequest request) {
		return new ModelAndView("buss/tfGuize/tfGzConfig");
	}
	
	/**
	 * 添加通风控制仓房通风设置
	 * @param tfConfig
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "tfConfigSave")
	@ResponseBody
	public AjaxJson tfConfigSave(TfBarnTfConfig tfConfig,TfConfigDevices tfConfigDevices,
			HttpServletRequest request ){
		AjaxJson j = new AjaxJson();
		if(StringUtil.isNotBlank(tfConfig.getTfGuiZeId()) &&
				StringUtil.isNotBlank(tfConfig.getId())){
			message = "通风控制设置更新成功";
			try {
				systemService.update(tfConfig,tfConfigDevices,request);
				systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "通风控制设置更新失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_ERROR,e);
			}
		}else{
			message = "通风控制设置添加成功";
			try {
				systemService.save(tfConfig,tfConfigDevices,request);
				systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "通风控制设置添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_TFKZ, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
		
	}
	
	
}
