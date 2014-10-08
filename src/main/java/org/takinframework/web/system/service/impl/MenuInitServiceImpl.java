package org.takinframework.web.system.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.takinframework.core.common.model.common.UploadFile;
import org.takinframework.core.common.model.json.ComboTree;
import org.takinframework.core.common.model.json.ImportFile;
import org.takinframework.core.common.service.impl.CommonServiceImpl;
import org.takinframework.web.system.service.MenuInitService;

@Service("menuInitService")
@Transactional
public class MenuInitServiceImpl extends CommonServiceImpl implements
		MenuInitService {

	private static final String KEY_SPLIT = "-";//map key 分隔符
	private static final String MENU_TYPE_ID = "#";//采用控件ID方式的code前缀
	private static final String MENU_TYPE_CSS = ".";//采用Css样式方式的code前缀
	
	public List find(String sql, Object[] parameters, Class cl) {
		return null;
	}
	
	public int addOrUpdateOrDelete(String sql, Object[] parameters, Class cl) {
		return 0;
	}
	
	public void updateEntityById(Class entityName, Serializable id) {
		
	}
	
	public Map getHashMapbyQuery(String query) {
		return null;
	}
	
	public Integer executeHql(String hql) {
		return null;
	}
	
	public void initMenu() {
		
	}
//	
//	public Session getSession() {
//		return null;
//	}
//	
//	public List pageList(DetachedCriteria dc, int firstResult, int maxResult) {
//		return null;
//	}
//	
//	public List findByDetached(DetachedCriteria dc) {
//		return null;
//	}

	public List findByProperty(Class entityClass, String propertyName,
			Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List loadAll(Class entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteEntityById(Class entityName, Serializable id) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAllEntitie(Collection entities) {
		// TODO Auto-generated method stub
		
	}

	public void updateEntitie(Object pojo) {
		// TODO Auto-generated method stub
		
	}

	public List findByQueryString(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateBySqlString(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List findListbySql(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByPropertyisOrder(Class entityClass, String propertyName,
			Object value, boolean isAsc) {
		// TODO Auto-generated method stub
		return null;
	}

	public List getList(Class clas) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object singleResult(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findByExample(String entityName, Object exampleEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object uploadFile(UploadFile uploadFile) {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpServletResponse viewOrDownloadFile(UploadFile uploadFile) {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpServletResponse createXml(ImportFile importFile) {
		// TODO Auto-generated method stub
		return null;
	}

	public void parserXml(String fileName) {
		// TODO Auto-generated method stub
		
	}

	public List comTree(List all, ComboTree comboTree) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer executeSql(String sql, List param) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer executeSql(String sql, Object... param) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer executeSql(String sql, Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object executeSqlReturnKey(String sql, Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findForJdbc(String sql, Object... objs) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map findOneForJdbc(String sql, Object... objs) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findForJdbc(String sql, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findObjForJdbc(String sql, int page, int rows, Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findForJdbcParam(String sql, int page, int rows, Object... objs) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getCountForJdbc(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getCountForJdbcParam(String sql, Object[] objs) {
		// TODO Auto-generated method stub
		return null;
	}

	public List findHql(String hql, Object... param) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	
//	public void initMenu() {
//		// 1.扫描项目下，所有class，判断带有标签@AutoMenu
//		// 2.循环判断@AutoMenu在系统中是否存在,如果不存在进行插入，如果存在不再插入
//		// 比较规则[菜单名称-等级-菜单地址：全匹配]
//
//		// 3.加载@AutoMenu下带有标签@AutoMenuOperation所有方法
//
//		// 4.循环@AutoMenuOperation方法标签，判断该菜单下是否有该操作码配置，如果存在不插入，不存在进行插入
//		// 比较规则[菜单ID-操作码 ：全匹配]
//
//		List<SysFunction> functionList = this.loadAll(SysFunction.class);
//		List<SysOperation> operationList = this.loadAll(SysOperation.class);
//		
//		Map<String, SysFunction> functionMap = new HashMap<String, SysFunction>();//菜单map,key为菜单匹配规则的字符串
//		Map<String, SysOperation> operationMap = new HashMap<String, SysOperation>();//菜单操作按钮map,key为菜单操作按钮匹配规则的字符串
//		
//		//设置菜单map
//		for (SysFunction function : functionList) {
//			StringBuffer key = new StringBuffer();
//			key.append(function.getFuncName() == null ? "" : function.getFuncName());
//			key.append(KEY_SPLIT);
//			key.append(function.getFuncLevel() == null ? "" : function.getFuncLevel());
//			key.append(KEY_SPLIT);
//			key.append(function.getFuncUrl() == null ? "" : function.getFuncUrl());
//			functionMap.put(key.toString(), function);
//		}
//		//设置菜单操作按钮map
//		for (SysOperation operation : operationList) {
//			StringBuffer key = new StringBuffer();
////			key.append(operation.getTSFunc() == null ? "" : operation.getTSFunction().getId());
//			key.append(KEY_SPLIT);
//			key.append(operation.getOperCode() == null ? "" : operation.getOperCode());
//			operationMap.put(key.toString(), operation);
//		}
//		
//		//扫描Src目录下
//		Set<Class<?>> classSet = PackagesToScanUtil.getClasses(".*");
//		for (Class<?> clazz : classSet) {
//			//判断当前类是否设置了菜单注解
//			//未设置菜单注解就算在该类的方法上设置了菜单操作按钮注解也不进行菜单操作按钮的匹配
//			if (clazz.isAnnotationPresent(AutoMenu.class)) {
//				AutoMenu autoMenu = clazz.getAnnotation(AutoMenu.class);
//				//菜单名称必须填写，否则不进行菜单和菜单操作按钮的匹配
//				if (StringUtil.isNotEmpty(autoMenu.name())) {
//					StringBuffer menuKey = new StringBuffer();
//					menuKey.append(autoMenu.name());
//					menuKey.append(KEY_SPLIT);
//					menuKey.append(autoMenu.level() == null ? "" : autoMenu.level());
//					menuKey.append(KEY_SPLIT);
//					menuKey.append(autoMenu.url() == null ? "" : autoMenu.url());
//					
//					SysFunction function = null;
//					//判断菜单map的key是否包含当前key，不包含则插入一条菜单数据
//					if (!functionMap.containsKey(menuKey.toString())) {
//						function = new SysFunction();
//						function.setFunctionName(autoMenu.name());
////						function.setFunctionIframe(null);
//						function.setFunctionLevel(Short.valueOf(autoMenu.level()));
//						function.setFunctionOrder(Integer.toString(autoMenu.order()));
//						function.setFunctionUrl(autoMenu.url());
////						function.setTSFunction(null);
//						
//						String iconId = autoMenu.icon();
//						if (StringUtil.isNotEmpty(iconId)) {
//							Object obj = this.get(TSIcon.class, iconId);
//							if(obj!=null){
//								function.setTSIcon((TSIcon)obj);
//							}else{
//								function.setTSIcon(null);
//							}
//						} else {
//							function.setTSIcon(null);
//						}
//						Serializable id = this.save(function);
//						function.setId(id.toString());
//					} else {
//						function = functionMap.get(menuKey.toString());
//					}
//						
//					//获取该类的所有方法
//					Method[] methods = clazz.getDeclaredMethods();
//					for(Method method : methods){
//						//判断当前方法是否设置了菜单操作按钮注解
//						if (method.isAnnotationPresent(AutoMenuOperation.class)) {
//							AutoMenuOperation autoMenuOperation = method.getAnnotation(AutoMenuOperation.class);
//							//操作码必须填写，否则不进行菜单操作按钮的匹配
//							if (StringUtil.isNotEmpty(autoMenuOperation.code())) {
//								StringBuffer menuOperationKey = new StringBuffer();
//								menuOperationKey.append(function == null ? "" : function.getId());
//								menuOperationKey.append(KEY_SPLIT);
//								
//								String code = "";
//								//设置code前缀
//								if (autoMenuOperation.codeType() == MenuCodeType.TAG) {
//									code = autoMenuOperation.code();
//								} else if (autoMenuOperation.codeType() == MenuCodeType.ID) {
//									code = MENU_TYPE_ID + autoMenuOperation.code();
//								} else if (autoMenuOperation.codeType() == MenuCodeType.CSS) {
//									code = MENU_TYPE_CSS + autoMenuOperation.code();
//								}
//								menuOperationKey.append(code);
//								
//								//判断菜单操作按钮map的key是否包含当前key，不包含则插入一条菜单操作按钮数据
//								if (!operationMap.containsKey(menuOperationKey.toString())) {
//									TSOperation operation = new TSOperation();
//									operation.setOperationname(autoMenuOperation.name());
//									operation.setOperationcode(code);
//									operation.setOperationicon(null);
//									operation.setStatus(Short.parseShort(Integer.toString(autoMenuOperation.status())));
//									operation.setTSFunction(function);
//									
//									String iconId = autoMenuOperation.icon();
//									if (StringUtil.isNotEmpty(iconId)) {
//										TSIcon icon = new TSIcon();
//										icon.setId(iconId);
//										operation.setTSIcon(icon);
//									} else {
//										operation.setTSIcon(null);
//									}
//									this.save(operation);
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//	}
}
