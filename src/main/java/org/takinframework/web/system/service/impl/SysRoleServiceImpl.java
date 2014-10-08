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
import org.takinframework.web.system.entity.SysRole;
import org.takinframework.web.system.mapper.SysRoleMapper;
import org.takinframework.web.system.service.SysRoleService;

/**   
 * @Title:SysRoleService
 * @Description: 系统角色表Service
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@Service("sysRoleService")
@Transactional
public class SysRoleServiceImpl<T,PK extends Serializable> implements SysRoleService<SysRole,String> {
	@Autowired
	private SysRoleMapper<SysRole,String> mapper;
			
	public SysRoleMapper<SysRole,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(SysRole entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public SysRole selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<SysRole> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(SysRole entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(SysRole entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<SysRole> queryByList(SysRole entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysRole> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<SysRole> selectByEntiry(SysRole entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysRole> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<SysRole> selectByChild(SysRole entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(SysRole entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public SysRole checkEntityExits(SysRole entity) {
		return mapper.checkEntityExits(entity);
	}
}