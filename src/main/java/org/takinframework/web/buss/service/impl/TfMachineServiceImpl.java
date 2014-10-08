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
import org.takinframework.web.buss.entity.TfMachine;
import org.takinframework.web.buss.mapper.TfMachineMapper;
import org.takinframework.web.buss.service.TfMachineService;

/**   
 * @Title:TfMachineService
 * @Description: 通风控制机械通风表Service
 * @date 2014-08-29
 * @version V1.0   
 *
 */
@Service("tfMachineService")
@Transactional
public class TfMachineServiceImpl<T,PK extends Serializable> implements TfMachineService<TfMachine,String> {
	@Autowired
	private TfMachineMapper<TfMachine,String> mapper;
			
	public TfMachineMapper<TfMachine,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(TfMachine entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public TfMachine selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<TfMachine> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(TfMachine entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(TfMachine entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<TfMachine> queryByList(TfMachine entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfMachine> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<TfMachine> selectByEntiry(TfMachine entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfMachine> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<TfMachine> selectByChild(TfMachine entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(TfMachine entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public TfMachine checkEntityExits(TfMachine entity) {
		return mapper.checkEntityExits(entity);
	}
}