package org.takinframework.web.buss.mapper;

import java.io.Serializable;
import org.takinframework.core.common.dao.BaseMapper;
import org.takinframework.core.common.dao.annotation.MyBatisDao;

/**
 * TfBarnWeihuMapper
 * @date 2014-08-18
 * @version V1.0   
 */
@MyBatisDao
public interface TfBarnWeihuMapper<T,PK extends Serializable> extends BaseMapper<T, PK> {
	
	
}
