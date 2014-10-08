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
import org.takinframework.web.system.entity.SysFunction;
import org.takinframework.web.system.mapper.SysFunctionMapper;
import org.takinframework.web.system.service.SysFunctionService;

/**   
 * @Title:SysFunctionService
 * @Description: 系统菜单表Service
 * @date 2014-06-06
 * @version V1.0   
 *
 */
@Service("sysFunctionService")
@Transactional
public class SysFunctionServiceImpl<T,PK extends Serializable> implements SysFunctionService<SysFunction,String> {
	@Autowired
	private SysFunctionMapper<SysFunction,String> mapper;
			
	public SysFunctionMapper<SysFunction,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(SysFunction entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public SysFunction selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<SysFunction> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(SysFunction entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(SysFunction entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<SysFunction> queryByList(SysFunction entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysFunction> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<SysFunction> selectByEntiry(SysFunction entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysFunction> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<SysFunction> selectByChild(SysFunction entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(SysFunction entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public SysFunction checkEntityExits(SysFunction entity) {
		return mapper.checkEntityExits(entity);
	}
}