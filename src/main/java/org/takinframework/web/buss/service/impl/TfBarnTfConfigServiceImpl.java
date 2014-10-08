package org.takinframework.web.buss.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.takinframework.core.common.exception.BusinessException;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.util.UUIDGenerator;
import org.takinframework.web.buss.entity.TfBarnTfConfig;
import org.takinframework.web.buss.mapper.TfBarnTfConfigMapper;
import org.takinframework.web.buss.service.TfBarnTfConfigService;

/**   
 * @Title:TfBarnTfConfigService
 * @Description: 通风控制仓房通风设置表Service
 * @date 2014-08-25
 * @version V1.0   
 *
 */
@Service("tfBarnTfConfigService")
@Transactional
public class TfBarnTfConfigServiceImpl<T,PK extends Serializable> implements TfBarnTfConfigService<TfBarnTfConfig,String> {
	@Autowired
	private TfBarnTfConfigMapper<TfBarnTfConfig,String> mapper;
			
	public TfBarnTfConfigMapper<TfBarnTfConfig,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(TfBarnTfConfig entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public TfBarnTfConfig selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<TfBarnTfConfig> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(TfBarnTfConfig entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(TfBarnTfConfig entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<TfBarnTfConfig> queryByList(TfBarnTfConfig entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfBarnTfConfig> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<TfBarnTfConfig> selectByEntiry(TfBarnTfConfig entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfBarnTfConfig> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<TfBarnTfConfig> selectByChild(TfBarnTfConfig entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(TfBarnTfConfig entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public TfBarnTfConfig checkEntityExits(TfBarnTfConfig entity) {
		return mapper.checkEntityExits(entity);
	}
}