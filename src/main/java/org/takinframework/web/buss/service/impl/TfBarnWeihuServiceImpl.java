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
import org.takinframework.web.buss.entity.TfBarnWeihu;
import org.takinframework.web.buss.mapper.TfBarnWeihuMapper;
import org.takinframework.web.buss.service.TfBarnWeihuService;

/**   
 * @Title:TfBarnWeihuService
 * @Description: 通风控制仓房维护表Service
 * @date 2014-08-18
 * @version V1.0   
 *
 */
@Service("tfBarnWeihuService")
@Transactional
public class TfBarnWeihuServiceImpl<T,PK extends Serializable> implements TfBarnWeihuService<TfBarnWeihu,String> {
	@Autowired
	private TfBarnWeihuMapper<TfBarnWeihu,String> mapper;
			
	public TfBarnWeihuMapper<TfBarnWeihu,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(TfBarnWeihu entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public TfBarnWeihu selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<TfBarnWeihu> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(TfBarnWeihu entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(TfBarnWeihu entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<TfBarnWeihu> queryByList(TfBarnWeihu entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfBarnWeihu> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<TfBarnWeihu> selectByEntiry(TfBarnWeihu entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfBarnWeihu> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<TfBarnWeihu> selectByChild(TfBarnWeihu entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(TfBarnWeihu entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public TfBarnWeihu checkEntityExits(TfBarnWeihu entity) {
		return mapper.checkEntityExits(entity);
	}
}