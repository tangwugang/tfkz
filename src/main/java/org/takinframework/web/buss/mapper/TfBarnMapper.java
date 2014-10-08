package org.takinframework.web.buss.mapper;

import java.io.Serializable;
import org.takinframework.core.common.dao.BaseMapper;
import org.takinframework.core.common.dao.annotation.MyBatisDao;

/**
 * TfBarnMapper
 * @date 2014-08-13
 * @version V1.0   
 */
@MyBatisDao
public interface TfBarnMapper<T,PK extends Serializable> extends BaseMapper<T, PK> {
	
	
}
