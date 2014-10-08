package org.takinframework.web.webservice.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jws.WebMethod;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.takinframework.core.common.exception.BusinessException;
import org.takinframework.core.common.service.impl.BaseServiceImpl;
import org.takinframework.core.util.Page;
import org.takinframework.core.util.PageUtil;
import org.takinframework.web.buss.entity.JwebDepot;
import org.takinframework.web.buss.entity.JwebDepotOut;
import org.takinframework.web.buss.mapper.JwebDepotMapper;
import org.takinframework.web.system.entity.SysFunction;
import org.takinframework.web.system.entity.SysTypeGroup;
import org.takinframework.web.webservice.JwebDepotDetailService;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


@Transactional
@Component(value="jwebDepotDetailServiceImpl")
@Produces(value={MediaType.APPLICATION_JSON})
public class JwebDepotDetailServiceImpl extends BaseServiceImpl implements JwebDepotDetailService {
	@Autowired
	private JwebDepotMapper<JwebDepot, String> depotMapper;

	@GET
	@Path("depot")
	public String selectAll() throws BusinessException {
		JSONObject jsonObject = new JSONObject();
		List<JwebDepot> d = Lists.newArrayList();
		List<JwebDepotOut> dep = Lists.newArrayList();
		Map<String, JwebDepot> map = Maps.newHashMap();
		for (int i = 0; i < 5; i++) {
			JwebDepot de = new JwebDepot();
			de.setId("11111"+i);
			de.setNumber("number01"+i);
			JwebDepotOut o = new JwebDepotOut();
			o.setAveraTempera(20.1);
			o.setAveraHumidity(21.0);
			dep.add(o);
			de.setDepotOut(dep);
			d.add(de);
			map.put(de.getNumber(), de);
		}
		jsonObject.putAll(map);
		return jsonObject.toString();
	}

	public <T> T checkEntityExits(Class<T> entity, String methord)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T checkEntityExits(T entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T checkEntityExits(T entity, Object... param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T getEntity(Class<T> entity, String methord, Serializable id)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Integer getEntityCount(Class<T> entity, String methord,
			Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Integer getEntityCount(T entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Integer getEntityCount(T entity, Object... param)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Integer getEntityCountById(T entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<Map<String, Object>> find(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> findList(Class<T> entity, String methord, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> findList(Class<T> entity, String methord,
			Object... param) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> findList(T entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> findList(T entity, Object... param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> findList(T entity, Map<String, Object> param)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> findListByPage(T entity, Object... param)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Page<T> findListByPage(Page<T> page, T entity, Object... param)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Page<T> findListByPage(Page<T> page, T entity,
			Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> PageUtil<T> findListByPage(PageUtil<T> page, T entity,
			Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> findAll(Class<T> entity, String methord) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> findAll(Class<T> entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> findAllByPage(T entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Page<T> findAllByPage(Page<T> page, T entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> PageUtil<T> findAllByPage(PageUtil<T> page, T entity)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void executeSql(String sql, Object... param) {
		// TODO Auto-generated method stub
		
	}

	public <T> void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	public <T> void delete(T entity, Object... params) {
		// TODO Auto-generated method stub
		
	}

	public <T> boolean delete(Class<T> entity, String methord,
			Object... parameters) {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> void deleteAllEntitie(Collection<T> entities) {
		// TODO Auto-generated method stub
		
	}

	public <T> boolean save(T entity) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> void batchSave(List<T> entitys) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void addLog(String LogContent, Short operatetype, Short loglevel) {
		// TODO Auto-generated method stub
		
	}

	public void addLog(String LogContent, Short operatetype, Short loglevel,
			Exception e) {
		// TODO Auto-generated method stub
		
	}

	public <T> T getType(String typecode, String typename,
			SysTypeGroup sysTypeGroup) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T getTypeGroup(String typegroupcode, String typgroupename) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Set<T> getOperationCodesByUserIdAndFunctionId(String userId,
			String functionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Set<T> getOperationCodesByRoleIdAndFunctionId(String roleId,
			String functionId) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T getTypeGroupByCode(Class<T> entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void initAllTypeGroups() {
		// TODO Auto-generated method stub
		
	}

	public <T> void refleshTypesCach(Class<T> entity) {
		// TODO Auto-generated method stub
		
	}

	public void refleshTypeGroupCach() {
		// TODO Auto-generated method stub
		
	}

	public void flushRoleFunciton(String id, SysFunction newFunciton) {
		// TODO Auto-generated method stub
		
	}

	public <T> boolean update(T entity) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> String getDBType() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<T> select() {
		// TODO Auto-generated method stub
		return null;
	}

	
//	@WebMethod(operationName="selectAll")
//	public String selectAll() throws BusinessException {
////		List<JwebDepot> depots = depotMapper.selectAll();
//		JSONObject jsonObject = new JSONObject();
//		List<JwebDepot> d = Lists.newArrayList();
//		List<JwebDepotOut> dep = Lists.newArrayList();
//		Map<String, JwebDepot> map = Maps.newHashMap();
//		JwebDepot de = new JwebDepot();
//		de.setId("11111");
//		de.setNumber("number01");
//		for (int i = 0; i < 5; i++) {
//			JwebDepotOut o = new JwebDepotOut();
//			o.setAveraTempera(20.1);
//			o.setAveraHumidity(21.0);
//			dep.add(o);
//			de.setDepotOut(dep);
//		}
//		map.put(de.getNumber(), de);
//		jsonObject.putAll(map);
//		
//		return jsonObject.toString();
//	}

}
