package org.takinframework.web.buss.mapper;

import java.io.Serializable;
import org.takinframework.core.common.dao.BaseMapper;
import org.takinframework.core.common.dao.annotation.MyBatisDao;

/**
 * JwebDepotOutMapper
 * @date 2014-06-17
 * @version V1.0   
 */
@MyBatisDao
public interface JwebDepotOutMapper<T,PK extends Serializable> extends BaseMapper<T, PK> {
	
	
}
