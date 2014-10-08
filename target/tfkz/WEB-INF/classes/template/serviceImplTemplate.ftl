package ${bussiPackage}.service.impl.${entityPackage};

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ${bussiPackage}.mapper.${entityPackage}.${entityName}Mapper;
import org.takinframework.core.common.service.impl.BaseService;

/**   
 * @Title:${entityName}Service
 * @Description: ${ftl_description}Service
 * @date ${ftl_create_time}
 * @version V1.0   
 *
 */
@Service("${entityName?uncap_first}Service")
@Transactional
public class ${entityName}Service<T> extends BaseService<T> {
	@Autowired
	private ${entityName}Mapper<T> mapper;
			
	public ${entityName}Mapper<T> getMapper() {
		return mapper;
	}
	
}