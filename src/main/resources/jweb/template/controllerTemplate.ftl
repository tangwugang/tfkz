package ${bussiPackage}.${entityPackage}.controller;
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
import ${bussiPackage}.${entityPackage}.entity.${entityName};
import ${bussiPackage}.${entityPackage}.service.${entityName}Service;
import com.google.common.collect.Lists;

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
		try {
			request.setAttribute("${entityName?uncap_first}", systemService.findAll(${entityName}.class));
		} catch (SQLException e) {
			LogUtil.error("获取${entityName?uncap_first}失败", e);
		}
		return new ModelAndView("${entityPackage}/${entityName?uncap_first}/${entityName?uncap_first}List");
	}
	
	/**
	 * ${ftl_description}添加和更新
	 * @param ${entityName?uncap_first}
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "${entityName?uncap_first}AddOrUpdate")
	public ModelAndView ${entityName?uncap_first}AddOrUpdate(${entityName} ${entityName?uncap_first},HttpServletRequest request){
		if(StringUtil.isNotBlank(${entityName?uncap_first}.getId())){
			try {
				request.setAttribute("${entityName?uncap_first}", systemService.checkEntityExits(${entityName?uncap_first}));
			} catch (Exception e) {
				LogUtil.error("获取${entityName?uncap_first}AddOrUpdate失败", e);
			}
		}
		return new ModelAndView("${entityPackage}/${entityName?uncap_first}/${entityName?uncap_first}AddOrUpdate");
	}
	
	/**
	 * 检测${ftl_description}是否存在
	 * @param ${entityName?uncap_first}
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "check${entityName}")
	@ResponseBody
	public JSONObject check${entityName}(${entityName} ${entityName?uncap_first},HttpServletRequest request){
		JSONObject obj = new JSONObject();
		List<String> params = Lists.newArrayList();
		params.add("name"); //按需求要进行修改
		try {
			//检测用户名称，与原先的用户名称是否一样，一样通过(${entityName?uncap_first}.getName(),按需求要进行修改)
			if(StringUtil.isNotEmpty(${entityName?uncap_first}.getName()) && 
					!${entityName?uncap_first}.getName().equals(request.getParameter("oldName"))){
				if(systemService.findList(${entityName?uncap_first}, params.toArray()).size()>0){
					obj.put("error", "已存在");
				}
			}
		} catch (Exception e) {
			LogUtil.error("获取${entityName?uncap_first}失败", e);
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
		message = "${ftl_description}删除成功";
		try {
			systemService.delete(${entityName?uncap_first});
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			message = "${ftl_description}删除失败";
			j.setSuccess(false);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_ERROR,e);
		}
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
			try {
				systemService.update(${entityName?uncap_first});
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "${ftl_description}更新失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "${ftl_description}添加成功";
			try {
				systemService.save(${entityName?uncap_first});
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "${ftl_description}添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_ERROR,e);
			}
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
			req.setAttribute("${entityName?uncap_first}Page", ${entityName?uncap_first});
		}
		return new ModelAndView("${entityPackage}/${entityName?uncap_first}/${entityName?uncap_first}");
	}
}
