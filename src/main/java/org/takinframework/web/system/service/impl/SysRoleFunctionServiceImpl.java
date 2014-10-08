package org.takinframework.web.system.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.takinframework.core.common.exception.BusinessException;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.util.UUIDGenerator;
import org.takinframework.web.system.entity.SysRoleFunction;
import org.takinframework.web.system.mapper.SysRoleFunctionMapper;
import org.takinframework.web.system.service.SysRoleFunctionService;

/**   
 * @Title:SysRoleFunctionService
 * @Description: 系统角色菜单表Service
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@Service("sysRoleFunctionService")
@Transactional
public class SysRoleFunctionServiceImpl<T,PK extends Serializable> implements SysRoleFunctionService<SysRoleFunction,String> {
	@Autowired
	private SysRoleFunctionMapper<SysRoleFunction,String> mapper;
			
	public SysRoleFunctionMapper<SysRoleFunction,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(SysRoleFunction entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public SysRoleFunction selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<SysRoleFunction> selectBySql(String sql) throws BusinessException {
		return mapper.selectBySql(sql);
	}

	
	public void updateBySql(String sql) throws BusinessException {
		mapper.updateBySql(sql);
		
	}

	
	public void deleteBySql(String sql) throws BusinessException {
		mapper.deleteBySql(sql);
	}

	
	public void insertBySql(String sql) throws BusinessException {
		mapper.insertBySql(sql);
	}

	
	public void updateBySelective(SysRoleFunction entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(SysRoleFunction entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<SysRoleFunction> queryByList(SysRoleFunction entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysRoleFunction> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<SysRoleFunction> selectByEntiry(SysRoleFunction entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysRoleFunction> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<SysRoleFunction> selectByChild(SysRoleFunction entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(SysRoleFunction entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public SysRoleFunction checkEntityExits(SysRoleFunction entity) {
		return mapper.checkEntityExits(entity);
	}
}