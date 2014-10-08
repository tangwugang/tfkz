package ${bussiPackage}.${entityPackage}.mapper;

import java.io.Serializable;
import org.takinframework.core.common.dao.BaseMapper;
import org.takinframework.core.common.dao.annotation.MyBatisDao;

/**
 * ${entityName}Mapper
 * @date ${ftl_create_time}
 * @version V1.0   
 */
@MyBatisDao
public interface ${entityName}Mapper<T,PK extends Serializable> extends BaseMapper<T, PK> {
	
	
}
