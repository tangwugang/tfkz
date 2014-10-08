package org.takinframework.web.buss.controller;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.takinframework.web.system.entity.SysUser;
import org.takinframework.web.system.service.SystemService;
import org.takinframework.core.common.model.json.AjaxJson;
import org.takinframework.core.common.model.json.DataGrid;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.doc.DocUtils;
import org.takinframework.core.util.ContextHolderUtils;
import org.takinframework.core.util.DateUtils;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.ResourceUtils;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.buss.entity.ParamsOfBarn;
import org.takinframework.web.buss.entity.TfBarn;
import org.takinframework.web.buss.entity.TfBarnDevices;
import org.takinframework.web.buss.entity.TfBarnShiwu;
import org.takinframework.web.buss.entity.TfBarnWeihu;
import org.takinframework.web.buss.service.TfBarnService;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import freemarker.template.Template;

/**   
 * @Title:TfBarnController
 * @Description: 通风控制仓房表Controller
 * @author twg
 * @date 2014-08-13
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tfBarnController")
public class TfBarnController extends BaseController {

	@Autowired
	private TfBarnService<TfBarn, String> tfBarnService;
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
	 * 通风控制仓房表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tfBarn")
	public ModelAndView tfBarn(HttpServletRequest request) {
		try {
			List<TfBarn> tfBarns = systemService.findAll(TfBarn.class);
			List<TfBarnShiwu> tfBarnShiwus = systemService.findAll(TfBarnShiwu.class);
			if(tfBarns.size()>0){request.setAttribute("tfBarn",tfBarns);}
			if(tfBarnShiwus.size()>0){request.setAttribute("tfBarnShiwus",tfBarnShiwus);}
		} catch (SQLException e) {
			LogUtil.error("获取tfBarn失败", e);
		}
		return new ModelAndView("buss/tfBarn/tfBarnList");
	}
	/**
	 * 通风控制仓房表添加和更新
	 * @param tfBarn
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "tfBarnAddOrUpdate")
	public ModelAndView tfBarnAddOrUpdate(TfBarn tfBarn,HttpServletRequest request){
		if(StringUtil.isNotBlank(tfBarn.getId())){
			try {
				request.setAttribute("tfBarn", systemService.checkEntityExits(tfBarn));
				List<TfBarnDevices> tfBarnDevices = systemService.findList(TfBarnDevices.class, "methord1", tfBarn.getId());
				if(tfBarnDevices.size()>0){request.setAttribute("tfBarnDevices",tfBarnDevices );}
				List<TfBarnWeihu> tfBarnWeihu = systemService.findList(TfBarnWeihu.class, "methord1", tfBarn.getId());
				if(tfBarnWeihu.size()>0){request.setAttribute("tfBarnWeihu", tfBarnWeihu);}
			} catch (Exception e) {
				LogUtil.error("获取tfBarnAddOrUpdate失败", e);
			}
		}
		return new ModelAndView("buss/tfBarn/tfBarnAddOrUpdate");
	}
	
	/**
	 * 检测仓房编号是否存在
	 * @param tfBarn 仓房
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "checkTfBarn")
	@ResponseBody
	public JSONObject checkTfBarn(TfBarn tfBarn,HttpServletRequest request){
		JSONObject obj = new JSONObject();
		List<String> params = Lists.newArrayList();
		params.add("barnNo");
		try {
			//检测用户名称，与原先的用户名称是否一样，一样通过
			if(StringUtil.isNotEmpty(tfBarn.getBarnNo()) && 
					!tfBarn.getBarnNo().equals(request.getParameter("oldName"))){
				if(systemService.findList(tfBarn, params.toArray()).size()>0){
					obj.put("error", "已存在");
				}
			}
		} catch (Exception e) {
			LogUtil.error("获取仓房信息表失败", e);
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
	public void datagrid(TfBarn tfBarn,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(TfBarnEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tfBarn, request.getParameterMap());
		//this.tfBarnService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除通风控制仓房表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TfBarn tfBarn, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "通风控制仓房表删除成功";
		try {
			systemService.delete(tfBarn);
			systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			message = "通风控制仓房表删除失败";
			j.setSuccess(false);
			systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 导出通风控制仓房表
	 * @param tfBarn
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "export")
	public void export(TfBarn tfBarn,
			HttpServletRequest request,HttpServletResponse response){
		String fileName = "仓房情况及维修记录"+DateUtils.getDate("yyyyMMddHHmmss")+".doc"; 
		DocUtils.write(response, fileName);
		try {
			SysUser user = ResourceUtils.getSessionUserName();
			tfBarn = systemService.checkEntityExits(tfBarn);
			List<TfBarnWeihu> tfbWeihus = systemService.findList(TfBarnWeihu.class, "methord1", tfBarn.getId());
			Map<String, Object> dataMap = Maps.newHashMap();
			dataMap.put("tfBarn", tfBarn);
			dataMap.put("tfbWeihus", tfbWeihus);
			dataMap.put("user", user);
			dataMap.put("createDate", DateUtils.formatDate(tfBarn.getCreateDate(), "yyyy年MM月dd日"));
			Template template = DocUtils.getTemplate("tfBarn.vm");
			template.setEncoding("UTF-8");
			Writer out = response.getWriter();
			DocUtils.createDoc(template, dataMap, out);
		} catch (Exception e) {
			LogUtil.error("获取export失败", e);
		}
	}


	/**
	 * 添加通风控制仓房表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TfBarn tfBarn,ParamsOfBarn paramsOfBarn, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tfBarn.getId())) {
			message = "通风控制仓房表更新成功";
			try {
				systemService.update(tfBarn,paramsOfBarn,request);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "通风控制仓房表更新失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "通风控制仓房表添加成功";
			try {
				systemService.save(tfBarn,paramsOfBarn,request);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "通风控制仓房表添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 通风控制仓房表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TfBarn tfBarn, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tfBarn.getId())) {
			req.setAttribute("tfBarnPage", tfBarn);
		}
		return new ModelAndView("buss/tfBarn/tfBarn");
	}
	/**
	 * 通过粮仓类型获取仓房信息
	 * @param tfBarn
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "tfBarns")
	@ResponseBody
	public List<TfBarn> tfBarns(TfBarn tfBarn, HttpServletRequest request){
		if(StringUtil.isNotBlank(tfBarn.getLiaCaType())){
			List<String> param = Lists.newArrayList();
			param.add("liaCaType");
			try {
				return systemService.findList(tfBarn, param.toArray());
			} catch (Exception e) {
				LogUtil.error("获取tfBarns失败", e);
			}
		}
		return null;
	}
	
	/**
	 * 通风控制仓房表粮情记录页面跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "tfLiaqin")
	public ModelAndView tfLiaqin(TfBarn tfBarn,HttpServletRequest request) {
		return new ModelAndView("buss/tfBarn/tfBarnLiaQin");
	}
	/**
	 * 通风控制机械通风记录页面跳转
	 * @param tfBarn
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "tfMachine")
	public ModelAndView tfMachine(TfBarn tfBarn,HttpServletRequest request){
		return new ModelAndView("buss/tfBarn/tfBarnMachine");
	}
	/**
	 * 通风控制三温图页面跳转
	 * @param tfBarn
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "tfChart")
	public ModelAndView tfChart(TfBarn tfBarn,HttpServletRequest request){
		return new ModelAndView("buss/tfBarn/tfChart");
	}
	
	@RequestMapping(params = "chartExp")
	public void chartExp(TfBarn tfBarn,HttpServletRequest request,HttpServletResponse response){
		String fileName = "三温图"+DateUtils.getDate("yyyyMMddHHmmss")+".doc"; 
		DocUtils.write(response, fileName);
		try {
			Map<String, Object> dataMap = Maps.newHashMap();
			dataMap.put("barnNo", tfBarn.getBarnNo());
			String imgName = request.getParameter("imgName");
			if(StringUtil.isNotBlank(imgName)){
				dataMap.put("imgName", imgName.subSequence(0, imgName.length()-1));
			}
			Template template = DocUtils.getTemplate("tfChart.vm");
			template.setEncoding("UTF-8");
			Writer out = response.getWriter();
			DocUtils.createDoc(template, dataMap, out);
			
		}catch(Exception e){
			LogUtil.error("获取chartExp失败", e);
			
		}
	}
}
