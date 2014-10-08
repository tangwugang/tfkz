package org.takinframework.web.system.service.impl;

import java.io.Serializable;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.takinframework.core.common.service.impl.BaseServiceImpl;
import org.takinframework.core.util.BrowserUtils;
import org.takinframework.core.util.CashUtils;
import org.takinframework.core.util.ContextHolderUtils;
import org.takinframework.core.util.DateUtils;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.Page;
import org.takinframework.core.util.PageUtil;
import org.takinframework.core.util.PasswordUtil;
import org.takinframework.core.util.ResourceUtils;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.util.oConvertUtils;
import org.takinframework.web.buss.entity.ParamsOfBarn;
import org.takinframework.web.buss.entity.TfBarn;
import org.takinframework.web.buss.entity.TfBarnDevices;
import org.takinframework.web.buss.entity.TfBarnShiwu;
import org.takinframework.web.buss.entity.TfBarnTfConfig;
import org.takinframework.web.buss.entity.TfBarnWeihu;
import org.takinframework.web.buss.entity.TfConfigDevices;
import org.takinframework.web.buss.entity.TfGuize;
import org.takinframework.web.buss.entity.TfGuizeTimes;
import org.takinframework.web.buss.entity.TfMachine;
import org.takinframework.web.quartz.util.QuartzContext;
import org.takinframework.web.system.entity.SysFunction;
import org.takinframework.web.system.entity.SysLog;
import org.takinframework.web.system.entity.SysRole;
import org.takinframework.web.system.entity.SysRoleFunction;
import org.takinframework.web.system.entity.SysType;
import org.takinframework.web.system.entity.SysTypeGroup;
import org.takinframework.web.system.entity.SysUser;
import org.takinframework.web.system.entity.SysUserRole;
import org.takinframework.web.system.service.SystemService;
import org.takinframework.web.util.WebUtil;

import com.google.common.collect.Lists;

@Service("systemService")
@Transactional
public class SystemServiceImpl extends BaseServiceImpl<Object, Serializable> implements SystemService {
	

	/**
	 * 添加日志
	 * @throws SocketException 
	 * @throws SQLException 
	 */
	public void addLog(String logcontent, Short operatetype, Short loglevel){
		addLog(logcontent, operatetype, loglevel, null);
	}
	
	public void addLog(String LogContent, Short operatetype, Short loglevel,
			Exception e) {
		
		HttpServletRequest request = ContextHolderUtils.getRequest();
		String broswer = BrowserUtils.checkBrowse(request);
		String params = WebUtil.getParams(request);
		SysLog log = new SysLog();
		if(params.length()>255){
			log.setParams(params.substring(0, 255));
		}else{
			log.setParams(params);
		}
		log.setLogLevel(loglevel);
		log.setIp(oConvertUtils.getIp());
		log.setUserAgent(broswer);
		log.setType(operatetype);
		log.setRequestUrl(request.getRequestURI());
		log.setMethod(request.getMethod());
		log.setContent(LogContent);
		if(StringUtil.isNotEmpty(e) && e.getMessage().length()<1000){
			log.setException(e.getMessage());
		}else if(StringUtil.isNotEmpty(e)){
			log.setException(StringUtil.substring(e.getMessage(), 0, 1000));
		}
		
		try {
			jdbcDao.save(log);
		} catch (SQLException ex) {
		}
		
	}
	


	/**
	 * 根据类型编码和类型名称获取Type,如果为空则创建一个
	 * 
	 * @param typecode
	 * @param typename
	 * @return
	 */
	public <T> T getType(String typecode, String typename, SysTypeGroup sysTypeGroup) {
//		SysType actType = commonDao.findUniqueByProperty(SysType.class, "typecode", typecode);
//		if (actType == null) {
//			actType = new TSType();
//			actType.setTypecode(typecode);
//			actType.setTypename(typename);
//			actType.setTSTypegroup(tsTypegroup);
//			commonDao.save(actType);
//		}
//		return actType;
		return null;

	}

	/**
	 * 根据类型分组编码和名称获取TypeGroup,如果为空则创建一个
	 * 
	 * @param typecode
	 * @param typename
	 * @return
	 */
	public <T> T getTypeGroup(String typegroupcode, String typgroupename) {
//		SysTypeGroup tsTypegroup = commonDao.findUniqueByProperty(SysTypeGroup.class, "typegroupcode", typegroupcode);
//		if (tsTypegroup == null) {
//			tsTypegroup = new SysTypeGroup();
//			tsTypegroup.setTypegroupcode(typegroupcode);
//			tsTypegroup.setTypegroupname(typgroupename);
//			commonDao.save(tsTypegroup);
//		}
//		return tsTypegroup;
		return null;
	}

	
	public <T> T getTypeGroupByCode(String typegroupCode) {
//		SysTypeGroup tsTypegroup = commonDao.findUniqueByProperty(SysTypeGroup.class, "typegroupcode", typegroupCode);
//		return tsTypegroup;
		return null;
	}

	
	public void initAllTypeGroups() {
//		List<SysTypeGroup> typeGroups = this.jdbcDao.findAll(SysTypeGroup.class,"methord1");
//		for (SysTypeGroup tsTypegroup : typeGroups) {
//			SysTypeGroup.allTypeGroups.put(tsTypegroup.getTypeGroupCode().toLowerCase(), tsTypegroup);
//			List<SysType> types = this.jdbcDao.findList(SysType.class,"methord1", tsTypegroup.getId());
//			SysTypeGroup.allTypes.put(tsTypegroup.getTypeGroupCode().toLowerCase(), types);
//		}
		try {
			List<SysType> sysTypes = jdbcDao.findAll(SysType.class);
			SysTypeGroup.allTypes.put("sysType", sysTypes);
		} catch (SQLException e) {
			LogUtil.error("获取initAllTypeGroups失败", e);
		}
	}

	
	public void refleshTypesCach(SysType type) throws SQLException {
//		SysTypeGroup tsTypegroup = this.jdbcDao.getEntity(SysTypeGroup.class,"methord1", type.getTypeGroupId());
//		List<SysType> types = this.jdbcDao.findList(SysType.class,"methord1", tsTypegroup.getId());
//		SysTypeGroup.allTypes.put(tsTypegroup.getTypeGroupCode().toLowerCase(), types);
	}

	/**
	 * 刷新数据字典缓存
	 */
	public void refleshTypeGroupCach() {
		SysTypeGroup.allTypes.clear();
		initAllTypeGroups();
//		TSTypegroup.allTypeGroups.clear();
//		List<TSTypegroup> typeGroups = this.commonDao.loadAll(TSTypegroup.class);
//		for (TSTypegroup tsTypegroup : typeGroups) {
//			TSTypegroup.allTypeGroups.put(tsTypegroup.getTypegroupcode().toLowerCase(), tsTypegroup);
//		}
	}

	// ----------------------------------------------------------------
	// ----------------------------------------------------------------

	
	public <T> Set<T> getOperationCodesByRoleIdAndFunctionId(String roleId, String functionId) {
		Set<T> operationCodes = new HashSet<T>();
//		TSRole role = commonDao.get(TSRole.class, roleId);
////		CriteriaQuery cq1 = new CriteriaQuery(TSRoleFunction.class);
//		cq1.eq("TSRole.id", role.getId());
//		cq1.eq("TSFunction.id", functionId);
//		cq1.add();
//		List<TSRoleFunction> rFunctions = getListByCriteriaQuery(cq1, false);
//		if (null != rFunctions && rFunctions.size() > 0) {
//			TSRoleFunction tsRoleFunction = rFunctions.get(0);
//			if (null != tsRoleFunction.getOperation()) {
//				String[] operationArry = tsRoleFunction.getOperation().split(",");
//				for (int i = 0; i < operationArry.length; i++) {
//					operationCodes.add(operationArry[i]);
//				}
//			}
//		}
		return operationCodes;
	}

	
	public <T> Set<T> getOperationCodesByUserIdAndFunctionId(String userId, String functionId) {
		Set<T> operationCodes = new HashSet<T>();
//		List<TSRoleUser> rUsers = findByProperty(TSRoleUser.class, "TSUser.id", userId);
//		for (TSRoleUser ru : rUsers) {
//			TSRole role = ru.getTSRole();
//			CriteriaQuery cq1 = new CriteriaQuery(TSRoleFunction.class);
//			cq1.eq("TSRole.id", role.getId());
//			cq1.eq("TSFunction.id", functionId);
//			cq1.add();
//			List<TSRoleFunction> rFunctions = getListByCriteriaQuery(cq1, false);
//			if (null != rFunctions && rFunctions.size() > 0) {
//				TSRoleFunction tsRoleFunction = rFunctions.get(0);
//				if (null != tsRoleFunction.getOperation()) {
//					String[] operationArry = tsRoleFunction.getOperation().split(",");
//					for (int i = 0; i < operationArry.length; i++) {
//						operationCodes.add(operationArry[i]);
//					}
//				}
//			}
//		}
		return operationCodes;
	}

	// ----------------------------------------------------------------
	// ----------------------------------------------------------------
	
	public void flushRoleFunciton(String id, SysFunction newFunction) {
//		TSFunction functionEntity = this.getEntity(TSFunction.class, id);
//		if (functionEntity.getTSIcon() == null || !StringUtil.isNotEmpty(functionEntity.getTSIcon().getId())) {
//			return;
//		}
//		TSIcon oldIcon = this.getEntity(TSIcon.class, functionEntity.getTSIcon().getId());
//		if (!oldIcon.getIconClas().equals(newFunction.getTSIcon().getIconClas())) {
//			// 刷新缓存
//			HttpSession session = ContextHolderUtils.getSession();
//			TSUser user = ResourceUtilss.getSessionUserName();
//			List<TSRoleUser> rUsers = this.findByProperty(TSRoleUser.class, "TSUser.id", user.getId());
//			for (TSRoleUser ru : rUsers) {
//				TSRole role = ru.getTSRole();
//				session.removeAttribute(role.getId());
//			}
//		}
	}

	public <T> T getTypeGroupByCode(Class<T> entity) {
		return null;
	}

	public <T> void refleshTypesCach(Class<T> entity) {
		
	}

	public <T> T checkEntityExits(Class<T> entity, String methord)
			throws SQLException {
		return jdbcDao.checkEntityExits(entity, methord);
	}

	public <T> T checkEntityExits(T entity) throws Exception {
		return jdbcDao.checkEntityExits(entity);
	}

	public <T> T checkEntityExits(T entity, Object... param) throws Exception {
		return jdbcDao.checkEntityExits(entity, param);
	}

	public <T> T getEntity(Class<T> entity, String methord, Serializable id)
			throws SQLException {
		return jdbcDao.getEntity(entity, methord, id);
	}

	public <T> Integer getEntityCount(Class<T> entity, String methord,
			Serializable id) {
		return jdbcDao.getEntityCount(entity, methord, id);
	}

	public <T> Integer getEntityCount(T entity) throws Exception {
		return jdbcDao.getEntityCount(entity);
	}

	public <T> Integer getEntityCount(T entity, Object... param)
			throws Exception {
		return jdbcDao.getEntityCount(entity, param);
	}

	public <T> Integer getEntityCountById(T entity) throws Exception {
		return jdbcDao.getEntityCountById(entity);
	}

	public <T> List<T> findList(Class<T> entity, String methord, Serializable id) {
		return jdbcDao.findList(entity, methord, id);
	}

	public <T> List<T> findList(Class<T> entity, String methord,
			Object... param) {
		return jdbcDao.findList(entity, methord, param);
	}

	public <T> List<T> findList(T entity) throws Exception {
		return jdbcDao.findList(entity);
	}

	public <T> List<T> findList(T entity, Object... param) throws Exception {
		return jdbcDao.findList(entity, param);
	}
	
	public <T> List<T> findList(T entity, Map<String, Object> param)
			throws Exception {
		return jdbcDao.findList(entity, param);
	}

	public <T> List<T> findListByPage(T entity, Object... param)
			throws Exception {
		return jdbcDao.findListByPage(entity, param);
	}
	
	public <T> Page<T> findListByPage(Page<T> page, T entity, Object... param)
			throws Exception {
		return jdbcDao.findListByPage(page, entity, param);
	}
	
	public <T> Page<T> findListByPage(Page<T> page, T entity,
			Map<String, Object> param) throws Exception {
		return jdbcDao.findListByPage(page, entity, param);
	}
	
	public <T> PageUtil<T> findListByPage(PageUtil<T> page, T entity,
			Map<String, Object> param) throws Exception {
		return jdbcDao.findListByPage(page, entity, param);
	}

	public <T> List<T> findAll(Class<T> entity, String methord) {
		return jdbcDao.findAll(entity, methord);
	}

	public <T> List<T> findAll(Class<T> entity) throws SQLException {
		return jdbcDao.findAll(entity);
	}

	public <T> List<T> findAllByPage(T entity) throws Exception {
		return jdbcDao.findAllByPage(entity);
	}
	
	public <T> Page<T> findAllByPage(Page<T> page, T entity) throws Exception {
		return jdbcDao.findAllByPage(page, entity);
	}
	
	public <T> PageUtil<T> findAllByPage(PageUtil<T> page, T entity)
			throws Exception {
		return jdbcDao.findAllByPage(page, entity);
	}

	public void executeSql(String sql, Object... param) {
		jdbcDao.executeSql(sql, param);
	}

	public <T> void delete(T entity) {
		jdbcDao.delete(entity);
	}

	public <T> void delete(T entity, Object... params) {
		jdbcDao.delete(entity, params);
	}

	public <T> boolean save(T entity) throws SQLException {
		return jdbcDao.save(entity);
	}

	public <T> void batchSave(List<T> entitys) throws SQLException {
		jdbcDao.batchSave(entitys);
	}

	

	public <T> String getDBType() throws SQLException {
		return jdbcDao.getDBType();
	}

	public <T> void deleteAllEntitie(Collection<T> entities) {
		jdbcDao.delete(entities);
	}
	
	public <T> boolean delete(Class<T> entity,String methord,Object...param){
		return jdbcDao.delete(entity, methord, param);
	}
	
	
	//================================通风控制设备设置操作================================
	public <T> void save(TfBarnTfConfig tfConfig,
			TfConfigDevices tfConfigDevices, HttpServletRequest request)
			throws SQLException {
		jdbcDao.save(tfConfig);
		String [] deviceId = tfConfigDevices.getTfBarnDevicesId().split(",");
		String [] deviceStatus = tfConfigDevices.getStatus().split(",");
		String [] deviceCfMode = tfConfigDevices.getCfMode().split(",");
		List<TfConfigDevices> params = Lists.newArrayList();
		for (int i = 0; i < deviceId.length; i++) {
			TfConfigDevices dev = new TfConfigDevices();
			dev.setCreateBy(tfConfig.getCreateBy());
			dev.setCreateName(tfConfig.getCreateName());
			dev.setUpdateBy(tfConfig.getUpdateBy());
			dev.setUpdateName(tfConfig.getUpdateName());
			dev.setCreateDate(new Date());
			dev.setUpdateDate(new Date());
			
			dev.setTfBarnDevicesId(deviceId[i]);
			dev.setStatus(deviceStatus[i]);
			dev.setCfMode(deviceCfMode[i]);
			dev.setTfGuiZeId(tfConfig.getTfGuiZeId());
			dev.setTfConfigId(tfConfig.getId());
			params.add(dev);
		}
		jdbcDao.batchSave(params);
	}
	
	
	public <T> void update(TfBarnTfConfig tfConfig,
			TfConfigDevices tfConfigDevices, HttpServletRequest request)
			throws Exception {
		jdbcDao.update(tfConfig);
		jdbcDao.delete(TfConfigDevices.class, "methord2", tfConfig.getId());
		String [] deviceId = tfConfigDevices.getTfBarnDevicesId().split(",");
		String [] deviceStatus = tfConfigDevices.getStatus().split(",");
		String [] deviceCfMode = tfConfigDevices.getCfMode().split(",");
		List<TfConfigDevices> params = Lists.newArrayList();
		for (int i = 0; i < deviceId.length; i++) {
			TfConfigDevices dev = new TfConfigDevices();
			dev.setCreateBy(tfConfig.getUpdateBy());
			dev.setCreateName(tfConfig.getUpdateName());
			dev.setUpdateBy(tfConfig.getUpdateBy());
			dev.setUpdateName(tfConfig.getUpdateName());
			dev.setCreateDate(new Date());
			dev.setUpdateDate(new Date());
			dev.setTfBarnDevicesId(deviceId[i]);
			dev.setStatus(deviceStatus[i]);
			dev.setCfMode(deviceCfMode[i]);
			dev.setTfGuiZeId(tfConfig.getTfGuiZeId());
			dev.setTfConfigId(tfConfig.getId());
			params.add(dev);
		}
		jdbcDao.batchSave(params);
		
	}
	//==================================仓房操作======================================
	public <T> void save(TfBarn tfBarn,ParamsOfBarn paramsOfBarn ,HttpServletRequest request) throws SQLException {
		jdbcDao.save(tfBarn);
		if(StringUtil.isNotBlank(paramsOfBarn.getNo()) && StringUtil.isNotBlank(paramsOfBarn.getType()) &&
				StringUtil.isNotBlank(paramsOfBarn.getPlace()) && StringUtil.isNotBlank(paramsOfBarn.getPower())
				&& StringUtil.isNotBlank(paramsOfBarn.getVersion())){
			
			String[] nos = paramsOfBarn.getNo().split(",");
			String[] types = paramsOfBarn.getType().split(",");
			String[] places = paramsOfBarn.getPlace().split(",");
			String[] versions = paramsOfBarn.getVersion().split(",");
			String[] powers = paramsOfBarn.getPower().split(",");
			List<TfBarnDevices> params = Lists.newArrayList();
			for (int i = 0; i < powers.length; i++) {
				TfBarnDevices barnDevices = new TfBarnDevices();
				barnDevices.setCreateBy(tfBarn.getCreateBy());
				barnDevices.setCreateName(tfBarn.getCreateName());
				barnDevices.setUpdateBy(tfBarn.getUpdateBy());
				barnDevices.setUpdateName(tfBarn.getUpdateName());
				barnDevices.setCreateDate(new Date());
				barnDevices.setUpdateDate(new Date());
				
				barnDevices.setType(Short.valueOf(types[i]));
				barnDevices.setNo(nos[i]);
				barnDevices.setPlace(places[i]);
				barnDevices.setVersion(versions[i]);
				barnDevices.setPower(Double.parseDouble(powers[i]));
				barnDevices.setTfBarnId(tfBarn.getId());
				params.add(barnDevices);
			} 
			jdbcDao.batchSave(params);
		}
		
		if(StringUtil.isNotBlank(paramsOfBarn.getWhTime()) && StringUtil.isNotBlank(paramsOfBarn.getWhName()) &&
				StringUtil.isNotBlank(paramsOfBarn.getWhQiKua())&& StringUtil.isNotBlank(paramsOfBarn.getWhBeiZ())){
			String[] whtimes = paramsOfBarn.getWhTime().split(",");
			String[] whnames = paramsOfBarn.getWhName().split(",");
			String[] whqikuas = paramsOfBarn.getWhQiKua().split(",");
			String[] whbeizs = paramsOfBarn.getWhBeiZ().split(",");
			List<TfBarnWeihu> params = Lists.newArrayList();
			for (int i = 0; i < whtimes.length; i++) {
				TfBarnWeihu tfBarnWeihu = new TfBarnWeihu();
				tfBarnWeihu.setCreateBy(tfBarn.getCreateBy());
				tfBarnWeihu.setCreateName(tfBarn.getCreateName());
				tfBarnWeihu.setUpdateBy(tfBarn.getUpdateBy());
				tfBarnWeihu.setUpdateName(tfBarn.getUpdateName());
				tfBarnWeihu.setCreateDate(new Date());
				tfBarnWeihu.setUpdateDate(new Date());
				
				tfBarnWeihu.setWhTime(whtimes[i]);
				tfBarnWeihu.setWhName(whnames[i]);
				tfBarnWeihu.setWhQiKua(whqikuas[i]);
				tfBarnWeihu.setWhBeiZ(whbeizs[i]);
				tfBarnWeihu.setTfBarnId(tfBarn.getId());
				params.add(tfBarnWeihu);
			}
			jdbcDao.batchSave(params);
		}
		
	}
	
	public <T> void update(TfBarn tfBarn,ParamsOfBarn paramsOfBarn, HttpServletRequest request)
			throws Exception {
		jdbcDao.update(tfBarn);
		jdbcDao.delete(TfBarnDevices.class, "methord1", tfBarn.getId());
		jdbcDao.delete(TfBarnWeihu.class, "methord1", tfBarn.getId());
		if(StringUtil.isNotBlank(paramsOfBarn.getNo()) && StringUtil.isNotBlank(paramsOfBarn.getType()) &&
				StringUtil.isNotBlank(paramsOfBarn.getPlace()) && StringUtil.isNotBlank(paramsOfBarn.getPower())
				&& StringUtil.isNotBlank(paramsOfBarn.getVersion())){
			
			String[] nos = paramsOfBarn.getNo().split(",");
			String[] types = paramsOfBarn.getType().split(",");
			String[] places = paramsOfBarn.getPlace().split(",");
			String[] versions = paramsOfBarn.getVersion().split(",");
			String[] powers = paramsOfBarn.getPower().split(",");
			List<TfBarnDevices> params = Lists.newArrayList();
			for (int i = 0; i < powers.length; i++) {
				TfBarnDevices barnDevices = new TfBarnDevices();
				barnDevices.setCreateBy(tfBarn.getUpdateBy());
				barnDevices.setCreateName(tfBarn.getUpdateName());
				barnDevices.setUpdateBy(tfBarn.getUpdateBy());
				barnDevices.setUpdateName(tfBarn.getUpdateName());
				barnDevices.setCreateDate(new Date());
				barnDevices.setUpdateDate(new Date());
				
				barnDevices.setType(Short.valueOf(types[i]));
				barnDevices.setNo(nos[i]);
				barnDevices.setPlace(places[i]);
				barnDevices.setVersion(versions[i]);
				barnDevices.setPower(Double.parseDouble(powers[i]));
				barnDevices.setTfBarnId(tfBarn.getId());
				params.add(barnDevices);
			} 
			jdbcDao.batchSave(params);
		}
		
		if(StringUtil.isNotBlank(paramsOfBarn.getWhTime()) && StringUtil.isNotBlank(paramsOfBarn.getWhName()) &&
				StringUtil.isNotBlank(paramsOfBarn.getWhQiKua())){
			String[] whtimes = paramsOfBarn.getWhTime().split(",");
			String[] whnames = paramsOfBarn.getWhName().split(",");
			String[] whqikuas = paramsOfBarn.getWhQiKua().split(",");
			String[] whbeizs = paramsOfBarn.getWhBeiZ().split(",");
			List<TfBarnWeihu> params = Lists.newArrayList();
			for (int i = 0; i < whtimes.length; i++) {
				TfBarnWeihu tfBarnWeihu = new TfBarnWeihu();
				tfBarnWeihu.setCreateBy(tfBarn.getUpdateBy());
				tfBarnWeihu.setCreateName(tfBarn.getUpdateName());
				tfBarnWeihu.setUpdateBy(tfBarn.getUpdateBy());
				tfBarnWeihu.setUpdateName(tfBarn.getUpdateName());
				tfBarnWeihu.setCreateDate(new Date());
				tfBarnWeihu.setUpdateDate(new Date());
				
				tfBarnWeihu.setWhTime(whtimes[i]);
				tfBarnWeihu.setWhName(whnames[i]);
				tfBarnWeihu.setWhQiKua(whqikuas[i]);
				tfBarnWeihu.setWhBeiZ(whbeizs[i]);
				tfBarnWeihu.setTfBarnId(tfBarn.getId());
				params.add(tfBarnWeihu);
			}
			jdbcDao.batchSave(params);
		}
	}
	
	
	public <T> void delete(TfBarn tfBarn) throws Exception {
		jdbcDao.delete(tfBarn);
		jdbcDao.delete(TfBarnDevices.class, "methord1", tfBarn.getId());
		jdbcDao.delete(TfBarnWeihu.class, "methord1", tfBarn.getId());
		jdbcDao.delete(TfBarnShiwu.class, "methord1", tfBarn.getId());
	}
	//====================================通风规则操作================================================
	public <T> void save(TfGuize tfGuize, TfGuizeTimes tfGuizeTimes, HttpServletRequest request) 
			throws SQLException {
		jdbcDao.save(tfGuize);
		String[] startTimes = tfGuizeTimes.getTfGuiZeStartTime().split(",");
		String[] endTimes = tfGuizeTimes.getTfGuiZeEndTime().split(",");
		List<TfGuizeTimes> tfgTimes = Lists.newArrayList();
		for (int i = 0; i < endTimes.length; i++) {
			TfGuizeTimes times = new TfGuizeTimes();
			times.setCreateBy(tfGuize.getCreateBy());
			times.setCreateName(tfGuize.getCreateName());
			times.setUpdateBy(tfGuize.getUpdateBy());
			times.setUpdateName(tfGuize.getUpdateName());
			times.setCreateDate(new Date());
			times.setUpdateDate(new Date());
			
			times.setTfGuiZeStartTime(startTimes[i]);
			times.setTfGuiZeEndTime(endTimes[i]);
			times.setTfGuiZeId(tfGuize.getId());
			tfgTimes.add(times);
		}
		jdbcDao.batchSave(tfgTimes);
		
	};
	
	public <T> void update(TfGuize tfGuize, TfGuizeTimes tfGuizeTimes,
			HttpServletRequest request) throws Exception {
		jdbcDao.update(tfGuize);
		
		if(StringUtil.isNotBlank(tfGuizeTimes.getTfGuiZeStartTime()) &&
				StringUtil.isNotBlank(tfGuizeTimes.getTfGuiZeEndTime())&&
				StringUtil.isNotBlank(tfGuize.getId())){
			jdbcDao.delete(TfGuizeTimes.class, "methord1", tfGuize.getId());
			String[] startTimes = tfGuizeTimes.getTfGuiZeStartTime().split(",");
			String[] endTimes = tfGuizeTimes.getTfGuiZeEndTime().split(",");
			List<TfGuizeTimes> tfgTimes = Lists.newArrayList();
			for (int i = 0; i < endTimes.length; i++) {
				TfGuizeTimes times = new TfGuizeTimes();
				times.setCreateBy(tfGuize.getUpdateBy());
				times.setCreateName(tfGuize.getUpdateName());
				times.setUpdateBy(tfGuize.getUpdateBy());
				times.setUpdateName(tfGuize.getUpdateName());
				times.setCreateDate(new Date());
				times.setUpdateDate(new Date());
				
				times.setTfGuiZeStartTime(startTimes[i]);
				times.setTfGuiZeEndTime(endTimes[i]);
				times.setTfGuiZeId(tfGuize.getId());
				tfgTimes.add(times);
			}
			jdbcDao.batchSave(tfgTimes);
		}
		
		if(StringUtil.isNotBlank(tfGuize.getId()) && StringUtil.isNotBlank(tfGuize.getStatus())){
			if(tfGuize.getStatus().equals("Y")){//启动通风规则,并生成设备机械通风信息（如果通风控制设置关联设备有信息和通风控制设置表中有启用的仓房编号）
				List<TfGuizeTimes> times = jdbcDao.findList(TfGuizeTimes.class, "methord1", tfGuize.getId());
				TfBarnTfConfig tfBarnTfConfig = new TfBarnTfConfig();
				tfBarnTfConfig.setTfGuiZeId(tfGuize.getId());
				List<String> param = Lists.newArrayList();
				param.add("tfGuiZeId");
				List<TfBarnTfConfig> tfBarnTfConfigs = jdbcDao.findList(tfBarnTfConfig, param.toArray());
				List<TfConfigDevices> tfConfigDevices = jdbcDao.findList(TfConfigDevices.class, "methord2", tfGuize.getId());
				if(tfBarnTfConfigs.size()>0 &&
						tfConfigDevices.size()>0){//仓房启用的同时设备也打开，就记录机械通风记录
					String barnNo = "";
					for (TfBarnTfConfig config : tfBarnTfConfigs) {
						barnNo += config.getBarnNo();
						barnNo +=",";
					}
					String [] no = barnNo.split(",");//启用的仓房编号
					List<TfMachine> tfMachines = Lists.newArrayList();
					for (String s : no) {
						TfBarn tfBarn = jdbcDao.getEntity(TfBarn.class, "methord2", s);
						TfMachine tfMachine = new TfMachine();
						tfMachine.setCreateBy(ResourceUtils.getSessionUserName().getId());
						tfMachine.setCreateName(ResourceUtils.getSessionUserName().getUserName());
						tfMachine.setCreateDate(new Date());
						tfMachine.setUpdateDate(new Date());
						tfMachine.setUpdateBy(ResourceUtils.getSessionUserName().getId());
						tfMachine.setUpdateName(ResourceUtils.getSessionUserName().getUserName());
						
						tfMachine.setStTonFenTime(DateUtils.formatDate(new Date(), "MM月dd日"));
						tfMachine.setTfBarnId(tfBarn.getId());
						tfMachine.setTfGuiZeId(tfGuize.getId());
						tfMachines.add(tfMachine);
					}
					jdbcDao.batchSave(tfMachines);
					QuartzContext.tfGuizeJob(tfGuize.getId(), QuartzContext.HoursAndMinutesEveryDay, times);
				}
				if(null != CashUtils.getCash(tfGuize.getId())){//有任务名说明有异常
					CashUtils.removeCash(tfGuize.getId());
					throw new Exception(ResourceUtils.getConfig("ajaxTfGuizeSerialMsg"));
				}
				
			}else{
				//停止通风规则，并更新设备机械通风信息
				List<TfMachine> tfMachines = jdbcDao.findList(TfMachine.class, "methord1", tfGuize.getId());
				if(tfMachines.size()>0){
					List<TfMachine> tfMachineList = Lists.newArrayList();
					for (TfMachine tfMachine : tfMachines) {
						tfMachine.setUpdateBy(ResourceUtils.getSessionUserName().getId());
						tfMachine.setUpdateName(ResourceUtils.getSessionUserName().getUserName());
						tfMachine.setUpdateDate(new Date());
						
						tfMachine.setEnTonFenTime(DateUtils.formatDate(new Date(), "MM月dd日"));
						tfMachineList.add(tfMachine);
					}
					jdbcDao.batchUpdate(tfMachineList);
				}
				QuartzContext.removeJob(tfGuize.getId());
				//发指令使此规则的设备停止工作
			}
		}
		//温湿度监测开始
		if(StringUtil.isNotBlank(tfGuize.getId()) && 
				StringUtil.isNotBlank(tfGuize.getStatus()) &&
				null != tfGuize.getTfWenShiDuTime() &&
				tfGuize.getTfWenShiDuTime()>0){
			if(tfGuize.getStatus().equals("Y")){
				QuartzContext.tfGuizeMinutesJob(tfGuize.getId()+"wensidu", QuartzContext.MinutesEveryDay, String.valueOf(tfGuize.getTfWenShiDuTime()));
				if(null != CashUtils.getCash(tfGuize.getId()+"wensidu")){//有任务名说明有异常
					CashUtils.removeCash(tfGuize.getId()+"wensidu");
					throw new Exception(ResourceUtils.getConfig("ajaxTfGuizeSerialMsg"));
				}
			}else{
				QuartzContext.removeJob(tfGuize.getId()+"wensidu");//停止通风规则
			}
		}
		
	}
	
	//删除通风规则
	public <T> void delete(TfGuize tfGuize) throws Exception{
		jdbcDao.delete(tfGuize);
		jdbcDao.delete(TfGuizeTimes.class, "methord1", tfGuize.getId());
		jdbcDao.delete(TfBarnTfConfig.class, "methord1", tfGuize.getId());
		jdbcDao.delete(TfConfigDevices.class, "methord1", tfGuize.getId());
		QuartzContext.removeJob(tfGuize.getId());//停止通风规则
		QuartzContext.removeJob(tfGuize.getId()+"wensidu");//停止通风规则
		//发指令使此规则的设备停止工作
		
	}
	
	//====================================系统用户操作================================================
	//系统用户的添加操作
	public <T> void save(SysUser sysUser, HttpServletRequest request) throws SQLException {
		String password = PasswordUtil.encrypt(sysUser.getUserName(), sysUser.getPassword(), PasswordUtil.getStaticSalt());
		sysUser.setPassword(password);
		jdbcDao.save(sysUser);
		String param = request.getParameter("roleId");//角色id
		//保存用户角色表
		if(StringUtil.isNotEmpty(param)){
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setRoleId(param);
			sysUserRole.setUserId(sysUser.getId());
			jdbcDao.save(sysUserRole);
		}
	}
	
	//系统用户的更新操作
	public <T> void update(SysUser sysUser, HttpServletRequest request)
			throws Exception {
		String password = PasswordUtil.encrypt(sysUser.getUserName(), sysUser.getPassword(), PasswordUtil.getStaticSalt());
		sysUser.setPassword(password);
		jdbcDao.update(sysUser);
	}
	//系统用户的删除操作
	public <T> void delete(SysUser sysUser) throws Exception{
		jdbcDao.delete(sysUser);
		jdbcDao.delete(SysUserRole.class, "methord2", sysUser.getId());
	};
	
	//============================系统角色的操作===================================
	public <T> void save(SysRole sysRole, HttpServletRequest request) throws SQLException {
		jdbcDao.save(sysRole);
		String param = request.getParameter("resId");//菜单id
		if(StringUtil.isNotEmpty(param)){
			String [] resid = ((String) param).split(",");
			for (String res : resid) {
				SysRoleFunction sysRoleFunction = new SysRoleFunction();
				sysRoleFunction.setRoleId(sysRole.getId());
				sysRoleFunction.setFuncId(res);
				jdbcDao.save(sysRoleFunction);
			}
		}
		
	}

	public <T> boolean update(T entity) throws Exception {
		
		
		return jdbcDao.update(entity);
	}

	public <T> void update(SysRole sysRole, HttpServletRequest request) throws Exception {
		jdbcDao.update(sysRole);
		String param = request.getParameter("resId");//菜单id
		List<String> params = Lists.newArrayList();
		params.add(sysRole.getId());
		jdbcDao.delete(SysRoleFunction.class, "methord1", params.toArray());
		if(StringUtil.isNotEmpty(param)){
			String [] resid = ((String) param).split(",");
			for (String res : resid) {
				SysRoleFunction sysRoleFunction = new SysRoleFunction();
				sysRoleFunction.setRoleId(sysRole.getId());
				sysRoleFunction.setFuncId(res);
				jdbcDao.save(sysRoleFunction);
			}
		}
		
	}

	public <T> void delete(SysRole sysRole) throws Exception {
		jdbcDao.delete(sysRole);
		jdbcDao.delete(SysRoleFunction.class, "methord1", sysRole.getId());
		jdbcDao.delete(SysUserRole.class, "methord1", sysRole.getId());
	}

	public <T> List<Map<String, Object>> find(String sql) {
		return jdbcDao.findForJdbc(sql);
	}

	
	
}
