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
import org.takinframework.web.buss.entity.JwebDepot;
import org.takinframework.web.buss.mapper.JwebDepotMapper;
import org.takinframework.web.buss.service.JwebDepotService;

/**   
 * @Title:JwebDepotService
 * @Description: 业务粮仓表Service
 * @date 2014-06-17
 * @version V1.0   
 *
 */
@Service("jwebDepotService")
@Transactional
public class JwebDepotServiceImpl<T,PK extends Serializable> implements JwebDepotService<JwebDepot,String> {
	@Autowired
	private JwebDepotMapper<JwebDepot,String> mapper;
			
	public JwebDepotMapper<JwebDepot,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(JwebDepot entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public JwebDepot selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<JwebDepot> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(JwebDepot entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(JwebDepot entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<JwebDepot> queryByList(JwebDepot entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<JwebDepot> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<JwebDepot> selectByEntiry(JwebDepot entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<JwebDepot> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<JwebDepot> selectByChild(JwebDepot entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(JwebDepot entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public JwebDepot checkEntityExits(JwebDepot entity) {
		return mapper.checkEntityExits(entity);
	}
}