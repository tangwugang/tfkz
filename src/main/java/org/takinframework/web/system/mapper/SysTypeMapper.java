package org.takinframework.web.system.mapper;

import java.io.Serializable;
import org.takinframework.core.common.dao.BaseMapper;
import org.takinframework.core.common.dao.annotation.MyBatisDao;

/**
 * SysTypeMapper
 * @date 2014-08-12
 * @version V1.0   
 */
@MyBatisDao
public interface SysTypeMapper<T,PK extends Serializable> extends BaseMapper<T, PK> {
	
	
}
