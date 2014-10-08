package org.takinframework.web.buss.service.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.takinframework.core.common.exception.BusinessException;
import org.takinframework.core.util.Page;
import org.takinframework.core.util.PageUtil;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.util.UUIDGenerator;
import org.takinframework.web.buss.entity.TfGuize;
import org.takinframework.web.buss.mapper.TfGuizeMapper;
import org.takinframework.web.buss.service.TfGuizeService;
import org.takinframework.web.system.entity.SysFunction;
import org.takinframework.web.system.entity.SysTypeGroup;

/**   
 * @Title:TfGuizeService
 * @Description: 通风控制规则表Service
 * @date 2014-08-21
 * @version V1.0   
 *
 */
@Service("tfGuizeService")
@Transactional
public class TfGuizeServiceImpl<T,PK extends Serializable> implements TfGuizeService<T,Serializable> {
	@Autowired
	private TfGuizeMapper<TfGuize,String> mapper;
			
	public TfGuizeMapper<TfGuize,String> getMapper() {
		return mapper;
	}

	public <T> T checkEntityExits(Class<T> entity, String methord)
			throws SQLException {
		
		return null;
	}

	public <T> T checkEntityExits(T entity) throws Exception {
		
		return null;
	}

	public <T> T checkEntityExits(T entity, Object... param) throws Exception {
		
		return null;
	}

	public <T> T getEntity(Class<T> entity, String methord, Serializable id)
			throws SQLException {
		
		return null;
	}

	public <T> Integer getEntityCount(Class<T> entity, String methord,
			Serializable id) {
		
		return null;
	}

	public <T> Integer getEntityCount(T entity) throws Exception {
		
		return null;
	}

	public <T> Integer getEntityCount(T entity, Object... param)
			throws Exception {
		
		return null;
	}

	public <T> Integer getEntityCountById(T entity) throws Exception {
		
		return null;
	}

	public <T> List<Map<String, Object>> find(String sql) {
		
		return null;
	}

	public <T> List<T> findList(Class<T> entity, String methord, Serializable id) {
		
		return null;
	}

	public <T> List<T> findList(Class<T> entity, String methord,
			Object... param) {
		
		return null;
	}

	public <T> List<T> findList(T entity) throws Exception {
		
		return null;
	}

	public <T> List<T> findList(T entity, Object... param) throws Exception {
		
		return null;
	}

	public <T> List<T> findList(T entity, Map<String, Object> param)
			throws Exception {
		
		return null;
	}

	public <T> List<T> findListByPage(T entity, Object... param)
			throws Exception {
		
		return null;
	}

	public <T> Page<T> findListByPage(Page<T> page, T entity, Object... param)
			throws Exception {
		
		return null;
	}

	public <T> Page<T> findListByPage(Page<T> page, T entity,
			Map<String, Object> param) throws Exception {
		
		return null;
	}

	public <T> PageUtil<T> findListByPage(PageUtil<T> page, T entity,
			Map<String, Object> param) throws Exception {
		
		return null;
	}

	public <T> List<T> findAll(Class<T> entity, String methord) {
		
		return null;
	}

	public <T> List<T> findAll(Class<T> entity) throws SQLException {
		
		return null;
	}

	public <T> List<T> findAllByPage(T entity) throws Exception {
		
		return null;
	}

	public <T> Page<T> findAllByPage(Page<T> page, T entity) throws Exception {
		
		return null;
	}

	public <T> PageUtil<T> findAllByPage(PageUtil<T> page, T entity)
			throws Exception {
		
		return null;
	}

	public void executeSql(String sql, Object... param) {
		
		
	}

	public <T> void delete(T entity) {
		
		
	}

	public <T> void delete(T entity, Object... params) {
		
		
	}

	public <T> boolean delete(Class<T> entity, String methord,
			Object... parameters) {
		
		return false;
	}

	public <T> void deleteAllEntitie(Collection<T> entities) {
		
		
	}

	public <T> boolean save(T entity) throws SQLException {
		
		return false;
	}

	public <T> void batchSave(List<T> entitys) throws SQLException {
		
		
	}

	public void addLog(String LogContent, Short operatetype, Short loglevel) {
		
		
	}

	public void addLog(String LogContent, Short operatetype, Short loglevel,
			Exception e) {
		
		
	}

	public <T> T getType(String typecode, String typename,
			SysTypeGroup sysTypeGroup) {
		
		return null;
	}

	public <T> T getTypeGroup(String typegroupcode, String typgroupename) {
		
		return null;
	}

	public <T> Set<T> getOperationCodesByUserIdAndFunctionId(String userId,
			String functionId) {
		
		return null;
	}

	public <T> Set<T> getOperationCodesByRoleIdAndFunctionId(String roleId,
			String functionId) {
		
		return null;
	}

	public <T> T getTypeGroupByCode(Class<T> entity) {
		
		return null;
	}

	public void initAllTypeGroups() {
		
		
	}

	public <T> void refleshTypesCach(Class<T> entity) {
		
		
	}

	public void refleshTypeGroupCach() {
		
		
	}

	public void flushRoleFunciton(String id, SysFunction newFunciton) {
		
		
	}

	public <T> boolean update(T entity) throws Exception {
		
		return false;
	}

	public <T> String getDBType() throws SQLException {
		
		return null;
	}


	public void insert(T entity) throws BusinessException {
		
		
	}

	public T selectById(Serializable id) throws BusinessException {
		
		return null;
	}

	public void deleteById(Serializable id) throws BusinessException {
		
		
	}

	public List<T> selectBySql(String sql) throws BusinessException {
		
		return null;
	}

	public void updateBySql(String sql) throws BusinessException {
		
		
	}

	public void deleteBySql(String sql) throws BusinessException {
		
		
	}

	public void insertBySql(String sql) throws BusinessException {
		
		
	}

	public void updateBySelective(T entity) throws BusinessException {
		
		
	}

	public Integer queryByCount(T entity) throws BusinessException {
		
		return null;
	}

	public List<T> queryByList(T entity) throws BusinessException {
		
		return null;
	}

	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		
		return null;
	}

	public List<T> selectByMapPaging(Map<?, ?> map) throws BusinessException {
		
		return null;
	}

	public Integer selectByCount(T entity) throws BusinessException {
		
		return null;
	}

	public List<T> selectByEntiry(T entity) throws BusinessException {
		
		return null;
	}

	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		
		return null;
	}

	public List<T> selectByMap(Map<?, ?> map) throws BusinessException {
		
		return null;
	}

	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		
		return null;
	}

	public List<T> selectByChild(T entity) throws BusinessException {
		
		return null;
	}
	
	
}