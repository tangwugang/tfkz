package org.takinframework.web.buss.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.takinframework.core.common.exception.BusinessException;

public interface TfLiaqinService<T,PK extends Serializable>{
	public T checkEntityExits(T entity);
	/***************** CRUD操作 ********************/
	public void insert(T entity) throws BusinessException;
	public T selectById(PK id) throws BusinessException;
	public void deleteById(PK id)throws BusinessException;
	/********************sql************************/
	public List<T> selectBySql(@Param(value = "sql") String sql)throws BusinessException;
	public void updateBySql(@Param(value = "sql") String sql)throws BusinessException;
	public void deleteBySql(@Param(value = "sql") String sql)throws BusinessException;
	public void insertBySql(@Param(value = "sql") String sql)throws BusinessException;


	/*********************** 按更新条件更新 **************************/
	public void updateBySelective(T entity) throws BusinessException;

	/*********************** 分页查询操作 ************************/
	/************************ 总数 **************************/
	public Integer queryByCount(T entity) throws BusinessException;

	public List<T> queryByList(T entity) throws BusinessException;

	public Integer selectByMapPagingCount(Map<?, ?> map)throws BusinessException;

	public List<T> selectByMapPaging(Map<?, ?> map)throws BusinessException;

	/*********************** 查询不分页 *************************/
	public Integer selectByCount(T entity) throws BusinessException;
	public List<T> selectByEntiry(T entity) throws BusinessException;

	public Integer selectByMapCount(Map<?, ?> map) throws BusinessException;

	public List<T> selectByMap(Map<?, ?> map) throws BusinessException;

	/************************** 图表 **************************/
	public List<Map<?, ?>> charts(Map<?, ?> map) throws BusinessException;

	/************************** 递归查询 ***********************/
	public List<T> selectByChild(T entity) throws BusinessException;

}
