package org.takinframework.web.aop;


import java.sql.SQLException;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.takinframework.core.extend.datasource.DataSourceContextHolder;
import org.takinframework.core.extend.datasource.DataSourceType;
import org.takinframework.core.util.StringUtil;
import org.takinframework.web.system.service.SystemService;

/**
 * 动态切换数据源(考虑到会去调用远程数据库)
 * @author twg
 *
 */
//@Aspect
@Component
public class DynamicDataSourceAspect {
	@Autowired
	private SystemService systemService;
//	@Before("execution (* find*(..))")
	public void beforeDynamicDataSource(JoinPoint jp) {
		DataSourceContextHolder.setDataSourceType(DataSourceType.dataSourceRemot);
		String dbtype = DataSourceContextHolder.getDbType();
		try {
			if(StringUtil.isEmpty(dbtype)){
				DataSourceContextHolder.setDbType(((String)systemService.getDBType()).toLowerCase());
			}
		} catch (SQLException e) {
		}
	}
	
//	@After("execution (* find*(..))")
	public void afterDynamicDataSource(JoinPoint jp) {
		DataSourceContextHolder.setDataSourceType(DataSourceType.dataSource1);
	}
	
}
