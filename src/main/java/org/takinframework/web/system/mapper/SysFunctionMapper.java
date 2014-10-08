package org.takinframework.web.system.mapper;

import java.io.Serializable;
import org.takinframework.core.common.dao.BaseMapper;
import org.takinframework.core.common.dao.annotation.MyBatisDao;

/**
 * SysFunctionMapper
 * @date 2014-06-06
 * @version V1.0   
 */
@MyBatisDao
public interface SysFunctionMapper<T,PK extends Serializable> extends BaseMapper<T, PK> {
	
	
}
