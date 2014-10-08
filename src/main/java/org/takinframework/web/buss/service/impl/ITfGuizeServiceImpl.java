package org.takinframework.web.buss.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.takinframework.core.common.service.impl.MybatisBaseServiceImpl;
import org.takinframework.web.buss.entity.TfGuize;
import org.takinframework.web.buss.service.ITfGuizeService;

@Service(value="iTfGuizeService")
@Transactional
public class ITfGuizeServiceImpl extends MybatisBaseServiceImpl<TfGuize, String> implements ITfGuizeService{
	
	public List<TfGuize> select(){
		this.mybatisBaseDAO.setNamespace("org.takinframework.web.buss.mapper.TfGuizeMapper");
		return this.mybatisBaseDAO.select();
	}
}
