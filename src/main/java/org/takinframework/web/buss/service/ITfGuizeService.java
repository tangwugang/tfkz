package org.takinframework.web.buss.service;

import java.util.List;

import org.takinframework.core.common.service.MybatisBaseService;
import org.takinframework.web.buss.entity.TfGuize;

public interface ITfGuizeService extends MybatisBaseService<TfGuize, String> {
	
	public List<TfGuize> select();
	

}
