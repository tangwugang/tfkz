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
import org.takinframework.web.buss.entity.TfBarnDevices;
import org.takinframework.web.buss.mapper.TfBarnDevicesMapper;
import org.takinframework.web.buss.service.TfBarnDevicesService;

/**   
 * @Title:TfBarnDevicesService
 * @Description: 通风控制仓房设备表Service
 * @date 2014-08-14
 * @version V1.0   
 *
 */
@Service("tfBarnDevicesService")
@Transactional
public class TfBarnDevicesServiceImpl<T,PK extends Serializable> implements TfBarnDevicesService<TfBarnDevices,String> {
	@Autowired
	private TfBarnDevicesMapper<TfBarnDevices,String> mapper;
			
	public TfBarnDevicesMapper<TfBarnDevices,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(TfBarnDevices entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public TfBarnDevices selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<TfBarnDevices> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(TfBarnDevices entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(TfBarnDevices entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<TfBarnDevices> queryByList(TfBarnDevices entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfBarnDevices> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<TfBarnDevices> selectByEntiry(TfBarnDevices entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<TfBarnDevices> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<TfBarnDevices> selectByChild(TfBarnDevices entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(TfBarnDevices entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public TfBarnDevices checkEntityExits(TfBarnDevices entity) {
		return mapper.checkEntityExits(entity);
	}
}