package org.takinframework.web.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.takinframework.core.common.service.impl.MybatisBaseServiceImpl;
import org.takinframework.web.system.entity.SysUser;
import org.takinframework.web.system.service.ISysUserService;

@Service
@Transactional
public class ISysUserServiceImpl extends MybatisBaseServiceImpl<SysUser, String>
		implements ISysUserService {
	public List<SysUser> select() {
		this.mybatisBaseDAO.setNamespace("org.takinframework.web.system.mapper.SysUserMapper");
		return this.mybatisBaseDAO.select();
	}

}
