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
import org.takinframework.core.common.model.json.AjaxJson;
import org.takinframework.core.common.model.json.DataGrid;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.doc.DocUtils;
import org.takinframework.core.util.DateUtils;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.ResourceUtils;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.buss.entity.TfBarnShiwu;
import org.takinframework.web.buss.service.TfBarnShiwuService;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import freemarker.template.Template;


/**   
 * @Title:TfBarnShiwuController
 * @Description: 通风控制库存实物表Controller
 * @author twg
 * @date 2014-08-19
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tfBarnShiwuController")
public class TfBarnShiwuController extends BaseController {

	@Autowired
	private TfBarnShiwuService<TfBarnShiwu, String> tfBarnShiwuService;
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
	 * 通风控制库存实物表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tfBarnShiwu")
	public ModelAndView tfBarnShiwu(HttpServletRequest request) {
		try {
			request.setAttribute("tfBarnShiwu", systemService.findAll(TfBarnShiwu.class));
		} catch (SQLException e) {
			LogUtil.error("获取tfBarnShiwu失败", e);
		}
		return new ModelAndView("buss/tfBarnShiwu/tfBarnShiwuList");
	}
	
	/**
	 * 通风控制库存实物表添加和更新
	 * @param tfBarnShiwu
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "tfBarnShiwuAddOrUpdate")
	public ModelAndView tfBarnShiwuAddOrUpdate(TfBarnShiwu tfBarnShiwu,HttpServletRequest request){
		if(StringUtil.isNotBlank(tfBarnShiwu.getTfBarnId())){
			try {
				List<String> params = Lists.newArrayList();
				params.add("tfBarnId");
				request.setAttribute("tfBarnShiwu", systemService.checkEntityExits(tfBarnShiwu, params.toArray()));
			} catch (Exception e) {
				LogUtil.error("获取tfBarnShiwuAddOrUpdate失败", e);
			}
		}
		return new ModelAndView("buss/tfBarnShiwu/tfBarnShiwuAddOrUpdate");
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
	public void datagrid(TfBarnShiwu tfBarnShiwu,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(TfBarnShiwuEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tfBarnShiwu, request.getParameterMap());
		//this.tfBarnShiwuService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除通风控制库存实物表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TfBarnShiwu tfBarnShiwu, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "通风控制库存实物表删除成功";
		try {
			systemService.delete(tfBarnShiwu);
			systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			message = "通风控制库存实物表删除失败";
			j.setSuccess(false);
			systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 导出通风控制库存实物表
	 * @param tfBarnShiwu
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "export")
	public void export(TfBarnShiwu tfBarnShiwu,
			HttpServletRequest request,HttpServletResponse response){
		String fileName = "库存实物基本情况"+DateUtils.getDate("yyyyMMddHHmmss")+".doc"; 
		DocUtils.write(response, fileName);
		try {
			SysUser user = ResourceUtils.getSessionUserName();
			tfBarnShiwu = systemService.checkEntityExits(tfBarnShiwu);
			Map<String, Object> dataMap = Maps.newHashMap();
			dataMap.put("tfBarnShiwu", tfBarnShiwu);
			dataMap.put("user", user);
			dataMap.put("createDate", DateUtils.formatDate(tfBarnShiwu.getCreateDate(), "yyyy年MM月dd日"));
			Template template = DocUtils.getTemplate("tfBarnShiwu.vm");
			template.setEncoding("UTF-8");
			Writer out = response.getWriter();
			DocUtils.createDoc(template, dataMap, out);
		} catch (Exception e) {
			LogUtil.error("获取export失败", e);
		}
	}


	/**
	 * 添加通风控制库存实物表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TfBarnShiwu tfBarnShiwu, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tfBarnShiwu.getId())) {
			message = "通风控制库存实物表更新成功";
			try {
				systemService.update(tfBarnShiwu);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "通风控制库存实物表更新失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "通风控制库存实物表添加成功";
			try {
				systemService.save(tfBarnShiwu);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "通风控制库存实物表添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 通风控制库存实物表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TfBarnShiwu tfBarnShiwu, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tfBarnShiwu.getId())) {
			req.setAttribute("tfBarnShiwuPage", tfBarnShiwu);
		}
		return new ModelAndView("buss/tfBarnShiwu/tfBarnShiwu");
	}
}
