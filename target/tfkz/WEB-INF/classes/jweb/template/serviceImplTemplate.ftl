package ${bussiPackage}.${entityPackage}.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.takinframework.core.common.exception.BusinessException;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.util.UUIDGenerator;
import ${bussiPackage}.${entityPackage}.entity.${entityName};
import ${bussiPackage}.${entityPackage}.mapper.${entityName}Mapper;
import ${bussiPackage}.${entityPackage}.service.${entityName}Service;

/**   
 * @Title:${entityName}Service
 * @Description: ${ftl_description}Service
 * @date ${ftl_create_time}
 * @version V1.0   
 *
 */
@Service("${entityName?uncap_first}Service")
@Transactional
public class ${entityName}ServiceImpl<T,PK extends Serializable> implements ${entityName}Service<${entityName},String> {
	@Autowired
	private ${entityName}Mapper<${entityName},String> mapper;
			
	public ${entityName}Mapper<${entityName},String> getMapper() {
		return mapper;
	}
	
	
	public void insert(${entityName} entity) throws BusinessException {
		if(StringUtil.isEmpty(entity.getId())){
			entity.setId(UUIDGenerator.generate());
		}
		mapper.insert(entity);
	}

	
	public ${entityName} selectById(String id) throws BusinessException {
		return mapper.selectById(id);
	}

	
	public void deleteById(String id) throws BusinessException {
		mapper.deleteById(id);
	}

	
	public List<${entityName}> selectBySql(String sql) throws BusinessException {
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

	
	public void updateBySelective(${entityName} entity) throws BusinessException {
		mapper.updateBySelective(entity);
	}

	
	public Integer queryByCount(${entityName} entity) throws BusinessException {
		return mapper.queryByCount(entity);
	}

	
	public List<${entityName}> queryByList(${entityName} entity)
			throws BusinessException {
		return mapper.queryByList(entity);
	}

	
	public Integer selectByMapPagingCount(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<${entityName}> selectByMapPaging(Map<?, ?> map)
			throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<${entityName}> selectByEntiry(${entityName} entity)
			throws BusinessException {
		return mapper.selectByList(entity);
	}

	
	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapCount(map);
	}

	
	public List<${entityName}> selectByMap(Map<?, ?> map) throws BusinessException {
		return mapper.selectByMapList(map);
	}

	
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException {
		return mapper.charts(map);
	}

	
	public List<${entityName}> selectByChild(${entityName} entity)
			throws BusinessException {
		return mapper.selectByChild(entity);
	}
	
	public Integer selectByCount(${entityName} entity) throws BusinessException {
		return mapper.selectByCount(entity);
	}
	
	public ${entityName} checkEntityExits(${entityName} entity) {
		return mapper.checkEntityExits(entity);
	}
}