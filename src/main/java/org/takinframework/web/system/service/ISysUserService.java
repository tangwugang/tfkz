package org.takinframework.web.system.service;

import java.util.List;

import org.takinframework.core.common.service.MybatisBaseService;
import org.takinframework.web.system.entity.SysUser;

public interface ISysUserService extends MybatisBaseService<SysUser, String> {
	/**
	 * 获取对象全部结果集
	 * @return
	 */
	public List<SysUser> select();
}
