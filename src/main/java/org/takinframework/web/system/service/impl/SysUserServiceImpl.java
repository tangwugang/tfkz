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
import org.takinframework.web.system.entity.SysUser;
import org.takinframework.web.system.mapper.SysUserMapper;
import org.takinframework.web.system.service.SysUserService;

/**   
 * @Title:SysUserService
 * @Description: 系统用户表Service
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@Service("sysUserService")
@Transactional
public class SysUserServiceImpl<T,PK extends Serializable> implements SysUserService<SysUser,String> {
	@Autowired
	private SysUserMapper<SysUser,String> mapper;
			
	public SysUserMapper<SysUser,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(SysUser entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public SysUser selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<SysUser> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(SysUser entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(SysUser entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<SysUser> queryByList(SysUser entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysUser> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<SysUser> selectByEntiry(SysUser entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysUser> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<SysUser> selectByChild(SysUser entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(SysUser entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public SysUser checkEntityExits(SysUser entity) {
		return mapper.checkEntityExits(entity);
	}


	public void delete(SysUser entity) throws BusinessException {
		mapper.delete(entity);
	}
	
}