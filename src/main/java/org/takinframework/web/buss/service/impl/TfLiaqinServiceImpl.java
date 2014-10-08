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
import org.takinframework.web.buss.entity.TfLiaqin;
import org.takinframework.web.buss.mapper.TfLiaqinMapper;
import org.takinframework.web.buss.service.TfLiaqinService;

/**   
 * @Title:TfLiaqinService
 * @Description: 通风控制粮情记录表Service
 * @date 2014-08-20
 * @version V1.0   
 *
 */
@Service("tfLiaqinService")
@Transactional
public class TfLiaqinServiceImpl<T,PK extends Serializable> implements TfLiaqinService<TfLiaqin,String> {
	@Autowired
	private TfLiaqinMapper<TfLiaqin,String> mapper;
			
	public TfLiaqinMapper<TfLiaqin,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(TfLiaqin entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public TfLiaqin selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<TfLiaqin> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(TfLiaqin entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(TfLiaqin entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<TfLiaqin> queryByList(TfLiaqin entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfLiaqin> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<TfLiaqin> selectByEntiry(TfLiaqin entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfLiaqin> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<TfLiaqin> selectByChild(TfLiaqin entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(TfLiaqin entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public TfLiaqin checkEntityExits(TfLiaqin entity) {
		return mapper.checkEntityExits(entity);
	}
}