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
import org.takinframework.web.system.entity.SysUserRole;
import org.takinframework.web.system.mapper.SysUserRoleMapper;
import org.takinframework.web.system.service.SysUserRoleService;

/**   
 * @Title:SysUserRoleService
 * @Description: 系统用户角色表Service
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@Service("sysUserRoleService")
@Transactional
public class SysUserRoleServiceImpl<T,PK extends Serializable> implements SysUserRoleService<SysUserRole,String> {
	@Autowired
	private SysUserRoleMapper<SysUserRole,String> mapper;
			
	public SysUserRoleMapper<SysUserRole,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(SysUserRole entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public SysUserRole selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<SysUserRole> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(SysUserRole entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(SysUserRole entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<SysUserRole> queryByList(SysUserRole entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysUserRole> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<SysUserRole> selectByEntiry(SysUserRole entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysUserRole> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<SysUserRole> selectByChild(SysUserRole entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(SysUserRole entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public SysUserRole checkEntityExits(SysUserRole entity) {
		return mapper.checkEntityExits(entity);
	}
}