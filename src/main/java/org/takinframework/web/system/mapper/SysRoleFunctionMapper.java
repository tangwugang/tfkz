package org.takinframework.web.system.mapper;

import java.io.Serializable;
import org.takinframework.core.common.dao.BaseMapper;
import org.takinframework.core.common.dao.annotation.MyBatisDao;

/**
 * SysRoleFunctionMapper
 * @date 2014-06-07
 * @version V1.0   
 */
@MyBatisDao
public interface SysRoleFunctionMapper<T,PK extends Serializable> extends BaseMapper<T, PK> {
	
	
}
