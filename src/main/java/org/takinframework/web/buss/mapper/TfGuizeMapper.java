package org.takinframework.web.buss.mapper;

import java.io.Serializable;
import org.takinframework.core.common.dao.BaseMapper;
import org.takinframework.core.common.dao.annotation.MyBatisDao;

/**
 * TfGuizeMapper
 * @date 2014-08-21
 * @version V1.0   
 */
@MyBatisDao
public interface TfGuizeMapper<T,PK extends Serializable> extends BaseMapper<T, PK> {
	
	
}
