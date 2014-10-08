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
import org.takinframework.web.buss.entity.TfBarn;
import org.takinframework.web.buss.mapper.TfBarnMapper;
import org.takinframework.web.buss.service.TfBarnService;

/**   
 * @Title:TfBarnService
 * @Description: 通风控制仓房表Service
 * @date 2014-08-13
 * @version V1.0   
 *
 */
@Service("tfBarnService")
@Transactional
public class TfBarnServiceImpl<T,PK extends Serializable> implements TfBarnService<TfBarn,String> {
	@Autowired
	private TfBarnMapper<TfBarn,String> mapper;
			
	public TfBarnMapper<TfBarn,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(TfBarn entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public TfBarn selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<TfBarn> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(TfBarn entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(TfBarn entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<TfBarn> queryByList(TfBarn entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfBarn> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<TfBarn> selectByEntiry(TfBarn entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfBarn> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<TfBarn> selectByChild(TfBarn entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(TfBarn entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public TfBarn checkEntityExits(TfBarn entity) {
		return mapper.checkEntityExits(entity);
	}
}