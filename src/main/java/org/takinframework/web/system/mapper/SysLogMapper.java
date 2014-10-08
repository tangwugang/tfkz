package org.takinframework.web.system.mapper;

import java.io.Serializable;
import org.takinframework.core.common.dao.BaseMapper;
import org.takinframework.core.common.dao.annotation.MyBatisDao;

/**
 * SysLogMapper
 * @date 2014-07-31
 * @version V1.0   
 */
@MyBatisDao
public interface SysLogMapper<T,PK extends Serializable> extends BaseMapper<T, PK> {
	
	
}
