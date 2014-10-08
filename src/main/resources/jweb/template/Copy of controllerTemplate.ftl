package ${bussiPackage}.${entityPackage}.controller;
import java.util.List;

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
import ${bussiPackage}.${entityPackage}.entity.${entityName};
import ${bussiPackage}.${entityPackage}.service.${entityName}Service;

/**   
 * @Title:${entityName}Controller
 * @Description: ${ftl_description}Controller
 * @author twg
 * @date ${ftl_create_time}
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/${entityName?uncap_first}Controller")
public class ${entityName}Controller extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(${entityName}Controller.class);

	@Autowired
	private ${entityName}Service<${entityName}, String> ${entityName?uncap_first}Service;
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
	 * ${ftl_description}列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "${entityName?uncap_first}")
	public ModelAndView ${entityName?uncap_first}(HttpServletRequest request) {
		return new ModelAndView("${entityPackage}/${entityName?uncap_first}/${entityName?uncap_first}List");
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
	public void datagrid(${entityName} ${entityName?uncap_first},HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(${entityName}Entity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ${entityName?uncap_first}, request.getParameterMap());
		//this.${entityName?uncap_first}Service.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除${ftl_description}
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(${entityName} ${entityName?uncap_first}, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		//${entityName?uncap_first} = systemService.getEntity(${entityName}.class, ${entityName?uncap_first}.getId());
		message = "${ftl_description}删除成功";
		//${entityName?uncap_first}Service.deleteByEntity(${entityName?uncap_first});
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加${ftl_description}
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(${entityName} ${entityName?uncap_first}, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(${entityName?uncap_first}.getId())) {
			message = "${ftl_description}更新成功";
			//${entityName}Entity t = ${entityName?uncap_first}Service.get(${entityName}.class, ${entityName?uncap_first}.getId());
			try {
				//MyBeanUtils.copyBeanNotNull2Bean(${entityName?uncap_first}, t);
				//${entityName?uncap_first}Service.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "${ftl_description}更新失败";
			}
		} else {
			message = "${ftl_description}添加成功";
			//${entityName?uncap_first}Service.save(${entityName?uncap_first});
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * ${ftl_description}列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(${entityName} ${entityName?uncap_first}, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(${entityName?uncap_first}.getId())) {
			//${entityName?uncap_first} = ${entityName?uncap_first}Service.getEntity(${entityName}.class, ${entityName?uncap_first}.getId());
			req.setAttribute("${entityName?uncap_first}Page", ${entityName?uncap_first});
		}
		return new ModelAndView("${entityPackage}/${entityName?uncap_first}/${entityName?uncap_first}");
	}
}