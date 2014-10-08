package org.takinframework.web.system.dao.repair;

import org.takinframework.core.common.dao.annotation.MyBatisDao;

/**
 * 工程修复
 * @author twg
 */
@MyBatisDao
public interface MyBatisRepairDao {
	
	public void batchRepairTerritory();

}
