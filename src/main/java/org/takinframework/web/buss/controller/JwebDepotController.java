package org.takinframework.web.buss.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
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
import org.takinframework.web.buss.entity.JwebDepot;
import org.takinframework.web.buss.service.JwebDepotService;

/**   
 * @Title:JwebDepotController
 * @Description: 业务粮仓表Controller
 * @author twg
 * @date 2014-06-17
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/jwebDepotController")
public class JwebDepotController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(JwebDepotController.class);

	@Autowired
	private JwebDepotService<JwebDepot, String> jwebDepotService;
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
	 * 业务粮仓表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "jwebDepot")
	public ModelAndView jwebDepot(HttpServletRequest request) {
		return new ModelAndView("buss/jwebDepot/jwebDepotList");
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
	public void datagrid(JwebDepot jwebDepot,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(JwebDepotEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, jwebDepot, request.getParameterMap());
		//this.jwebDepotService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除业务粮仓表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(JwebDepot jwebDepot, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		//jwebDepot = systemService.getEntity(JwebDepot.class, jwebDepot.getId());
		message = "业务粮仓表删除成功";
		//jwebDepotService.deleteByEntity(jwebDepot);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加业务粮仓表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(JwebDepot jwebDepot, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(jwebDepot.getId())) {
			message = "业务粮仓表更新成功";
			//JwebDepotEntity t = jwebDepotService.get(JwebDepot.class, jwebDepot.getId());
			try {
				//MyBeanUtils.copyBeanNotNull2Bean(jwebDepot, t);
				//jwebDepotService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "业务粮仓表更新失败";
			}
		} else {
			message = "业务粮仓表添加成功";
			//jwebDepotService.save(jwebDepot);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 业务粮仓表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(JwebDepot jwebDepot, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(jwebDepot.getId())) {
			//jwebDepot = jwebDepotService.getEntity(JwebDepot.class, jwebDepot.getId());
			req.setAttribute("jwebDepotPage", jwebDepot);
		}
		return new ModelAndView("buss/jwebDepot/jwebDepot");
	}
}
