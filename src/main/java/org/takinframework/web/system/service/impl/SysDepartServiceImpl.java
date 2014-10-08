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
import org.takinframework.web.system.entity.SysDepart;
import org.takinframework.web.system.mapper.SysDepartMapper;
import org.takinframework.web.system.service.SysDepartService;

/**   
 * @Title:SysDepartService
 * @Description: 系统机构表Service
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@Service("sysDepartService")
@Transactional
public class SysDepartServiceImpl<T,PK extends Serializable> implements SysDepartService<SysDepart,String> {
	@Autowired
	private SysDepartMapper<SysDepart,String> mapper;
			
	public SysDepartMapper<SysDepart,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(SysDepart entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public SysDepart selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<SysDepart> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(SysDepart entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(SysDepart entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<SysDepart> queryByList(SysDepart entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysDepart> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<SysDepart> selectByEntiry(SysDepart entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysDepart> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<SysDepart> selectByChild(SysDepart entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(SysDepart entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public SysDepart checkEntityExits(SysDepart entity) {
		return mapper.checkEntityExits(entity);
	}
}