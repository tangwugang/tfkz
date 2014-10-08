package org.takinframework.web.buss.controller;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Date;
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
import org.takinframework.core.util.PageUtil;
import org.takinframework.core.util.ResourceUtils;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.web.controller.BaseController;
import org.takinframework.web.buss.entity.TfBarn;
import org.takinframework.web.buss.entity.TfBarnShiwu;
import org.takinframework.web.buss.entity.TfLiaqin;
import org.takinframework.web.buss.service.TfLiaqinService;
import com.google.common.collect.Maps;
import freemarker.template.Template;

/**   
 * @Title:TfLiaqinController
 * @Description: 通风控制粮情记录表Controller
 * @author twg
 * @date 2014-08-20
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tfLiaqinController")
public class TfLiaqinController extends BaseController {

	@Autowired
	private TfLiaqinService<TfLiaqin, String> tfLiaqinService;
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
	 * 通风控制粮情记录表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "tfLiaqin")
	public ModelAndView tfLiaqin(TfLiaqin tfLiaqin,
			HttpServletRequest request,HttpServletResponse response) {
		try {
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			
			Map<String, Object> params = Maps.newHashMap();
			params.put("tfBarnId",tfLiaqin.getTfBarnId());
			if(StringUtil.isNotBlank(startDate) && 
					StringUtil.isNotBlank(endDate)){
				params.put("createDate>=",startDate);
				params.put("createDate<=",DateUtils.addDay(endDate, 1));
				request.setAttribute("page", systemService.findListByPage(new PageUtil<TfLiaqin>(request, response), tfLiaqin,params));
				request.setAttribute("startDate", startDate);
				request.setAttribute("endDate", endDate);
			}else{
				request.setAttribute("page", systemService.findListByPage(new PageUtil<TfLiaqin>(request, response), tfLiaqin,params));
			}
		} catch (Exception e) {
			LogUtil.error("获取tfLiaqin失败", e);
		}
		return new ModelAndView("buss/tfLiaqin/tfLiaqinList");
	}
	
	/**
	 * 通风控制粮情记录表添加和更新
	 * @param tfLiaqin
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "tfLiaqinAddOrUpdate")
	public ModelAndView tfLiaqinAddOrUpdate(TfLiaqin tfLiaqin,HttpServletRequest request){
		try {
			request.setAttribute("tfBarn", systemService.getEntity(TfBarn.class, "methord1",tfLiaqin.getTfBarnId()));
			List<TfBarnShiwu> tfBarnShiwus = systemService.findList(TfBarnShiwu.class, "methord1",tfLiaqin.getTfBarnId());
			if(tfBarnShiwus.size()>0){request.setAttribute("tfBarnShiwu",tfBarnShiwus.get(0));}
			if(StringUtil.isNotBlank(tfLiaqin.getId())){
				request.setAttribute("tfLiaqin", systemService.checkEntityExits(tfLiaqin));
			}
		} catch (Exception e) {
			LogUtil.error("获取tfLiaqinAddOrUpdate失败", e);
		}
		return new ModelAndView("buss/tfLiaqin/tfLiaqinAddOrUpdate");
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
	public void datagrid(TfLiaqin tfLiaqin,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//CriteriaQuery cq = new CriteriaQuery(TfLiaqinEntity.class, dataGrid);
		//查询条件组装器
		//org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tfLiaqin, request.getParameterMap());
		//this.tfLiaqinService.getDataGridReturn(cq, true);
		//TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除通风控制粮情记录表
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(TfLiaqin tfLiaqin, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "通风控制粮情记录表删除成功";
		try {
			systemService.delete(tfLiaqin);
			systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			message = "通风控制粮情记录表删除失败";
			j.setSuccess(false);
			systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 导出通风控制粮情记录表
	 * @param tfLiaqin
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "export")
	public void export(TfLiaqin tfLiaqin,
			HttpServletRequest request,HttpServletResponse response){
		String fileName = "粮情检查记录"+DateUtils.getDate("yyyyMMddHHmmss")+".doc"; 
		DocUtils.write(response, fileName);
		try {
			SysUser user = ResourceUtils.getSessionUserName();
			tfLiaqin = systemService.checkEntityExits(tfLiaqin);
			TfBarn tfBarn = systemService.getEntity(TfBarn.class, "methord1",tfLiaqin.getTfBarnId());
			List<TfBarnShiwu> tfBarnShiwus = systemService.findList(TfBarnShiwu.class, "methord1",tfLiaqin.getTfBarnId());
			Map<String, Object> dataMap = Maps.newHashMap();
			dataMap.put("tfBarn", tfBarn);
			if(tfBarnShiwus.size()>0){dataMap.put("tfBarnShiwu", tfBarnShiwus.get(0));}
			dataMap.put("tfLiaqin", tfLiaqin);
			dataMap.put("user", user);
			dataMap.put("createDate", DateUtils.formatDate(tfLiaqin.getCreateDate(), "yyyy年MM月dd日"));
			Template template = DocUtils.getTemplate("tfLiaqin.vm");
			template.setEncoding("UTF-8");
			Writer out = response.getWriter();
			DocUtils.createDoc(template, dataMap, out);
		} catch (Exception e) {
			LogUtil.error("获取export失败", e);
		}
	}



	/**
	 * 添加通风控制粮情记录表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(TfLiaqin tfLiaqin, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(tfLiaqin.getId())) {
			message = "通风控制粮情记录表更新成功";
			try {
				systemService.update(tfLiaqin);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				message = "通风控制粮情记录表更新失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
			}
		} else {
			message = "通风控制粮情记录表添加成功";
			try {
				systemService.save(tfLiaqin);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_INFO);
			} catch (SQLException e) {
				message = "通风控制粮情记录表添加失败";
				j.setSuccess(false);
				systemService.addLog(message, Globals.Log_Type_CANCHU, Globals.Log_Leavel_ERROR,e);
			}
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 通风控制粮情记录表列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(TfLiaqin tfLiaqin, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tfLiaqin.getId())) {
			req.setAttribute("tfLiaqinPage", tfLiaqin);
		}
		return new ModelAndView("buss/tfLiaqin/tfLiaqin");
	}
	
	@RequestMapping(params = "chartXml")
	@ResponseBody
	public AjaxJson chartXml(TfLiaqin tfLiaqin,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String year = request.getParameter("year");//查询条件年
		String time = request.getParameter("time");//查询条件上半年、下半年
		
		StringBuilder dataXml = new StringBuilder("");
		
		StringBuilder lw = new StringBuilder("<dataset seriesName='粮温' color='F1683C' anchorBorderColor='F1683C' anchorBgColor='F1683C' dashed='1'>");
		StringBuilder cw = new StringBuilder("<dataset seriesName='仓温' color='1D8BD1' anchorBorderColor='1D8BD1' anchorBgColor='1D8BD1'>");
		StringBuilder qw = new StringBuilder("<dataset seriesName='气温' color='000000' anchorBorderColor='000000' anchorBgColor='000000' lineThickness='0.1'>");
		
		Map<String, Object> params = Maps.newHashMap();
		params.put("tfBarnId",tfLiaqin.getTfBarnId());
		
		if(StringUtil.isNotBlank(year) && 
				StringUtil.isNotBlank(time)){
			if(time.equals("0")){
				params.put("createDate<=",year+".07.06");
				params.put("createDate>=",year+".01.01");
			}else {
				params.put("createDate<=",year+".12.31");
				params.put("createDate>=",year+".07.06");
			}
		}else{
			params.put("createDate<=",DateUtils.formatDate(new Date(),"yyyy")+".07.06");
			params.put("createDate>=",DateUtils.formatDate(new Date(),"yyyy")+".01.01");
		}
		try {
			message = "获取图表数据成功";
			List<TfLiaqin> tfLiaqins = systemService.findList(tfLiaqin, params);
			if(tfLiaqins.size()>0){
				int numVDivLines = tfLiaqins.size()-2;
				dataXml.append("<chart  yAxisMinValue='-4'   outCnvBaseFontSize='8.5' divLineAlpha='100'  canvasBorderColor='000000' canvasBorderThickness='0'  showalternatevgridcolor='0' showalternatehgridcolor='0' bgcolor='ffffff' divlineisdashed='1' divlinedashlen='1'  showLegend='0' formatNumberScale='0' numberSuffix='℃'  showhovercap='1' showNames='1' showValues='0' numdivlines='44' numVDivLines='"+numVDivLines+"' rotateNames='0' showPrintMenuItem='0' exportEnabled='1' aboutMenuItemLabel='浙江省粮食局直属库' aboutMenuItemLink='http://www.512u.com/index1.do' exportAtClient='0' exportHandler='FCExporter' exportAction='save' exportCallback='chartCallback' exportDialogMessage='正在生成,请稍候...' exportFormats='PNG=生成PNG图片' exportFileName='barn'>");
				dataXml.append("<categories>");
				for (TfLiaqin lq : tfLiaqins) {
					dataXml.append("<category name='"+DateUtils.formatDate(lq.getCreateDate(),"MM.dd")+"' />");
					lw.append("<set value='"+lq.getZscPinJunWen()+"' />");
					cw.append("<set value='"+lq.getCanWen()+"' />");
					qw.append("<set value='"+lq.getQiWen()+"' />");
				}
				
				dataXml.append("</categories>");
				lw.append("</dataset>");
				cw.append("</dataset>");
				qw.append("</dataset>");
				dataXml.append(lw.toString());
				dataXml.append(cw.toString());
				dataXml.append(qw.toString());
				dataXml.append("</chart>");
			}
		} catch (Exception e) {
			message = "获取图表数据失败";
			j.setSuccess(false);
			LogUtil.error("获取chartXml失败", e);
		}
		j.setMsg(message);
		j.setObj(dataXml.toString());
		return j;
		
	}
}
