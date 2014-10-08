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
import org.takinframework.web.system.entity.SysIcon;
import org.takinframework.web.system.mapper.SysIconMapper;
import org.takinframework.web.system.service.SysIconService;

/**   
 * @Title:SysIconService
 * @Description: 系统图片表Service
 * @date 2014-07-10
 * @version V1.0   
 *
 */
@Service("sysIconService")
@Transactional
public class SysIconServiceImpl<T,PK extends Serializable> implements SysIconService<SysIcon,String> {
	@Autowired
	private SysIconMapper<SysIcon,String> mapper;
			
	public SysIconMapper<SysIcon,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(SysIcon entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public SysIcon selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<SysIcon> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(SysIcon entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(SysIcon entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<SysIcon> queryByList(SysIcon entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysIcon> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<SysIcon> selectByEntiry(SysIcon entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysIcon> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<SysIcon> selectByChild(SysIcon entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(SysIcon entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public SysIcon checkEntityExits(SysIcon entity) {
		return mapper.checkEntityExits(entity);
	}
}