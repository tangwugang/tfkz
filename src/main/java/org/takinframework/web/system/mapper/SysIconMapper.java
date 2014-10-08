package org.takinframework.web.system.mapper;

import java.io.Serializable;
import org.takinframework.core.common.dao.BaseMapper;
import org.takinframework.core.common.dao.annotation.MyBatisDao;

/**
 * SysIconMapper
 * @date 2014-07-10
 * @version V1.0   
 */
@MyBatisDao
public interface SysIconMapper<T,PK extends Serializable> extends BaseMapper<T, PK> {
	
	
}
