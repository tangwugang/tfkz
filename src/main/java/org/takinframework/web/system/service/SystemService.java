package org.takinframework.web.system.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.takinframework.core.common.service.BaseService;
import org.takinframework.web.buss.entity.ParamsOfBarn;
import org.takinframework.web.buss.entity.TfBarn;
import org.takinframework.web.buss.entity.TfBarnTfConfig;
import org.takinframework.web.buss.entity.TfConfigDevices;
import org.takinframework.web.buss.entity.TfGuize;
import org.takinframework.web.buss.entity.TfGuizeTimes;
import org.takinframework.web.system.entity.SysRole;
import org.takinframework.web.system.entity.SysUser;



public interface SystemService extends BaseService{
	/**
	 * 保存通风设备设置
	 * @param tfConfig
	 * @param tfConfigDevices
	 * @param request
	 * @throws SQLException
	 */
	public <T> void save(TfBarnTfConfig tfConfig,TfConfigDevices tfConfigDevices,HttpServletRequest request)throws SQLException;
	/**
	 * 更新通风设备设置
	 * @param tfConfig
	 * @param tfConfigDevices
	 * @param request
	 * @throws Exception
	 */
	public <T> void update(TfBarnTfConfig tfConfig,TfConfigDevices tfConfigDevices,HttpServletRequest request)throws Exception;
	/**
	 * 保存通风规则
	 * @param tfGuize
	 * @param tfGuizeTimes
	 * @param request
	 * @throws SQLException
	 */
	public <T> void save(TfGuize tfGuize,TfGuizeTimes tfGuizeTimes,HttpServletRequest request)throws SQLException;
	/**
	 * 更新通风规则
	 * @param tfGuize
	 * @param tfGuizeTimes
	 * @param request
	 * @throws Exception
	 */
	public <T> void update(TfGuize tfGuize,TfGuizeTimes tfGuizeTimes,HttpServletRequest request)throws Exception;
	/**
	 * 保存仓房信息
	 * @param tfBarn
	 * @param request
	 * @throws SQLException
	 */
	public <T> void save(TfBarn tfBarn,ParamsOfBarn paramsOfBarn,HttpServletRequest request) throws SQLException;
	/**
	 * 更新仓房信息
	 * @param tfBarn
	 * @param request
	 * @throws Exception
	 */
	public <T> void update(TfBarn tfBarn,ParamsOfBarn paramsOfBarn,HttpServletRequest request) throws Exception;
	
	
	/**
	 * 保存角色信息
	 * @param sysRole
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public <T> void save(SysRole sysRole,HttpServletRequest request) throws SQLException;
	/**
	 * 更新角色信息
	 * @param sysRole
	 * @param param
	 * @throws Exception
	 */
	public <T> void update(SysRole sysRole,HttpServletRequest request) throws Exception;
	
	/**
	 * 保存用户信息
	 * @param sysUser
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	public <T> void save(SysUser sysUser,HttpServletRequest request) throws SQLException;
	/**
	 * 更新用户信息
	 * @param sysUser
	 * @param request
	 * @throws Exception
	 */
	public <T> void update(SysUser sysUser,HttpServletRequest request) throws Exception;
	
	/**
	 * 删除角色信息
	 * @param sysRole
	 * @param param
	 * @throws Exception
	 */
	public <T> void delete(SysRole sysRole) throws Exception;
	
	/**
	 * 删除用户信息
	 * @param sysUser
	 * @throws Exception
	 */
	public <T> void delete(SysUser sysUser) throws Exception;
	/**
	 * 删除仓房信息
	 * @param tfBarn
	 * @throws Exception
	 */
	public <T> void delete(TfBarn tfBarn) throws Exception;
	/**
	 * 删除通风规则
	 * @param tfGuize
	 * @throws Exception
	 */
	public <T> void delete(TfGuize tfGuize) throws Exception;
	
	
}