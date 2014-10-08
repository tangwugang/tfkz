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
import org.takinframework.web.buss.entity.TfBarnShiwu;
import org.takinframework.web.buss.mapper.TfBarnShiwuMapper;
import org.takinframework.web.buss.service.TfBarnShiwuService;

/**   
 * @Title:TfBarnShiwuService
 * @Description: 通风控制库存实物表Service
 * @date 2014-08-19
 * @version V1.0   
 *
 */
@Service("tfBarnShiwuService")
@Transactional
public class TfBarnShiwuServiceImpl<T,PK extends Serializable> implements TfBarnShiwuService<TfBarnShiwu,String> {
	@Autowired
	private TfBarnShiwuMapper<TfBarnShiwu,String> mapper;
			
	public TfBarnShiwuMapper<TfBarnShiwu,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(TfBarnShiwu entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public TfBarnShiwu selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<TfBarnShiwu> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(TfBarnShiwu entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(TfBarnShiwu entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<TfBarnShiwu> queryByList(TfBarnShiwu entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfBarnShiwu> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<TfBarnShiwu> selectByEntiry(TfBarnShiwu entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfBarnShiwu> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<TfBarnShiwu> selectByChild(TfBarnShiwu entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(TfBarnShiwu entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public TfBarnShiwu checkEntityExits(TfBarnShiwu entity) {
		return mapper.checkEntityExits(entity);
	}
}