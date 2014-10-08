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
import org.takinframework.web.system.entity.SysUserDepart;
import org.takinframework.web.system.mapper.SysUserDepartMapper;
import org.takinframework.web.system.service.SysUserDepartService;

/**   
 * @Title:SysUserDepartService
 * @Description: 系统用户机构表Service
 * @date 2014-06-07
 * @version V1.0   
 *
 */
@Service("sysUserDepartService")
@Transactional
public class SysUserDepartServiceImpl<T,PK extends Serializable> implements SysUserDepartService<SysUserDepart,String> {
	@Autowired
	private SysUserDepartMapper<SysUserDepart,String> mapper;
			
	public SysUserDepartMapper<SysUserDepart,String> getMapper() {
		return mapper;
	}
	
	
	public void insert(SysUserDepart entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public SysUserDepart selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<SysUserDepart> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(SysUserDepart entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(SysUserDepart entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<SysUserDepart> queryByList(SysUserDepart entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysUserDepart> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<SysUserDepart> selectByEntiry(SysUserDepart entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<SysUserDepart> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<SysUserDepart> selectByChild(SysUserDepart entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(SysUserDepart entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public SysUserDepart checkEntityExits(SysUserDepart entity) {
		return mapper.checkEntityExits(entity);
	}
}