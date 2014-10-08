package org.takinframework.web.test;
import java.util.List;

import org.apache.cxf.wsdl.TFault;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.takinframework.codegenerator.service.CodeGenerateService;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.serial.SerialListener;
import org.takinframework.core.util.Page;
import org.takinframework.core.util.PasswordUtil;
import org.takinframework.core.util.ResourceUtils;
import org.takinframework.web.buss.entity.TfBarn;
import org.takinframework.web.buss.entity.TfGuize;
import org.takinframework.web.buss.service.ITfGuizeService;
import org.takinframework.web.buss.service.TfBarnService;
import org.takinframework.web.buss.service.TfGuizeService;
import org.takinframework.web.system.entity.SysDepart;
import org.takinframework.web.system.entity.SysFunction;
import org.takinframework.web.system.entity.SysIcon;
import org.takinframework.web.system.entity.SysLog;
import org.takinframework.web.system.entity.SysRole;
import org.takinframework.web.system.entity.SysRoleFunction;
import org.takinframework.web.system.entity.SysType;
import org.takinframework.web.system.entity.SysUser;
import org.takinframework.web.system.entity.SysUserDepart;
import org.takinframework.web.system.entity.SysUserRole;
import org.takinframework.web.system.service.ISysUserService;
import org.takinframework.web.system.service.SysDepartService;
import org.takinframework.web.system.service.SysFunctionService;
import org.takinframework.web.system.service.SysIconService;
import org.takinframework.web.system.service.SysLogService;
import org.takinframework.web.system.service.SysRoleFunctionService;
import org.takinframework.web.system.service.SysRoleService;
import org.takinframework.web.system.service.SysUserDepartService;
import org.takinframework.web.system.service.SysUserRoleService;
import org.takinframework.web.system.service.SysUserService;
import org.takinframework.web.system.service.SystemService;

import com.google.common.collect.Lists;


/*
 * @TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true) 
 * transactionManager的默认取值是"transactionManager"，
 * defaultRollback的默认取值是true，当然，你也可以改成false。
 * true表示测试不会对数据库造成污染,false的话当然就会改动到数据库中了。
 * 在方法名上添加@Rollback(false)表示这个测试用例不需要回滚。
 */
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-mvc-mybatis.xml" ,"classpath:/spring-mvc-aop.xml","classpath:/spring-mvc-context.xml"})
public class SpringTestCase {
	Logger logger = LoggerFactory.getLogger(SpringTestCase.class);
	String bussiPackage = "org.takinframework.web";
	String tableName= "tf_machine"; //数据库表明
	String entityPackage = "buss";			// 模块名，例：sys(手输入)
	String ftl_description = "通风控制机械通风记录表";		// 功能名，例：用户
	
	@Autowired
	CodeGenerateService codeGenerateService;
	
	@Autowired
	SysDepartService<SysDepart, String> sysDepartService;
	@Autowired
	SysUserService<SysUser, String> sysUserService;
	@Autowired
	SysUserDepartService<SysUserDepart, String> sysUserDepartService;
	@Autowired
	SysRoleService<SysRole, String> sysRoleService;
	@Autowired
	SysUserRoleService<SysUserRole, String> sysUserRoleService;
	@Autowired
	SysFunctionService<SysFunction, String> sysFunctionService;
	@Autowired
	SysRoleFunctionService<SysRoleFunction, String> sysRoleFunctionService;
	@Autowired
	SysIconService<SysIcon, String> sysIconService;
	@Autowired
	SysLogService<SysLog, String> sysLogService;
	@Autowired
	TfBarnService<TfBarn, String> tfBarnService;
	@Autowired
	ITfGuizeService iTfGuizeService;
	@Autowired
	ISysUserService iSysUserService;
	
	@Autowired
	SystemService systemService;
	
	@Test
	public void test(){
		try {
			for (int i = 0; i < 10; i++) {
//				SysDepart sysDepart = new SysDepart();
//				sysDepart.setId(UUIDGenerator.generate());
//				sysDepart.setCreateDate(new Date());
//				sysDepart.setUpdateDate(new Date());
//				sysDepart.setDepartName("云计算公司4");
//				sysDepart.setDepartTel("05717456731");
////			
			}
			
			
			System.out.println("SpringTestCase.test() === "+iTfGuizeService.select().size()+" sysuser === "+iSysUserService.select().size());
			
			
			byte[] salt = PasswordUtil.getStaticSalt();
			
			long a=System.currentTimeMillis();
			List<SysUser> sysUsers = Lists.newArrayList();
//			for (int i = 0; i < 1; i++) {
				SysUser user = new SysUser();
				user.setUserName("twg333338");
				user.setPassword("123");
				String password = PasswordUtil.encrypt(user.getUserName(), user.getPassword(), salt);
				user.setPassword(password);
//				ByteArrayOutputStream outputStream  = new ByteArrayOutputStream();
//				File file = new File("d:\\dengni43.jpg");
//				BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//                byte[] bate = new byte[100000];
//                int len = 0;
//                while ((len = inputStream.read(bate)) != -1) {
//                      outputStream.write(bate, 0, len);
//                }
//                bate = outputStream.toByteArray();
//                outputStream.flush();
//                outputStream.close();
//                inputStream.close();
//				user.setSignature(bate);
				user.setId("4028970346eba5540146eba554460000");
//				Page page = new Page();
//				page.setOrderBy("createDate desc");
//				user.setPage(page);
//				sysUsers.add(user);
				
//				systemService.update(user);
				
//				systemService.save(user);
//				sysUserService.updateBySelective(user);
//				sysUserService.insert(user);
//				sysUserService.selectByEntiry(user);
				List<String> params = Lists.newArrayList();
				params.add("status");
//				params.add("password");
//				systemService.delete(user, params.toArray());
//			}
//				systemService.update(user);
//			systemService.batchSave(sysUsers);
//			List<SysUser> u = systemService.findListByPage(user,params.toArray());
//			for (SysUser sysUser : u) {
//				System.out.println(" =====user=== "+sysUser.getSignature()+"name =="+sysUser.getUserName()+"date =="+sysUser.getCreateDate());
//			}
//				System.out.println("test === "+systemService.checkEntityExits(user).getSignature());
			//bocp查询比c3p0快
//			SysUser user = new SysUser();
//			user.setUserName("twg33333");
//			user.setPassword("1234561");
//			String password = PasswordUtil.encrypt(user.getUserName(), user.getPassword(), salt);
//			user.setPassword(password);
//			List<String> params = Lists.newArrayList();
//			params.add("userName");
//			params.add("password");
//			List<SysUser> sysuList = systemService.findAll(SysUser.class);
//			System.out.println("===sysuList==="+sysuList.size());
//			systemService.delete(user, params.toArray());
//			sysUserService.delete(user);
//			sysUserService.insert(user);
//			sysUserService.selectByEntiry(user);
			long b=System.currentTimeMillis();
		   
//			user.setId("402897ec45f31ba00145f31ba0980000");
//			user = sysUserService.selectById("402897ec45f31ba00145f31ba6090008");
//			user = sysUserService.checkEntityExits(user);
//			int i = sysUserService.selectByCount(user);
			List<String> par = Lists.newArrayList();
			par.add("userName");
			par.add("password");
//			int i= systemService.getEntityCount(user, par.toArray());
//			 System.out.println(i+" ========数量 ");
//			systemService.delete(user);
//			List<SysUser> users = systemService.findList(SysUser.class, "methord1", "402897034673fcd7014673fcd8b40003");
//					systemService.checkEntityExits(user);
			
//			System.out.println("user "+users.size());
//			List<SysUser> userList = sysUserService.queryByList(user);
//			String userId = userList.get(0).getId();
//			
			SysRole sysRole = new SysRole();
			sysRole.setRoleName("普通用户");
//			sysRoleService.insert(sysRole);
//			System.out.println(" role :"+sysRole.getId());
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setRoleId(sysRole.getId());
//			sysUserRole.setUserId(user.getId());
//			sysUserRoleService.insert(sysUserRole);
			
//			sysDepartService.deleteById("402897ec45ef144e0145ef144e8e0000");
//			sysDepart.setUpdateDate(DateUtils.parseDate("2014-05-12 16:43:07","yyyy-MM-dd HH:mm:ss"));
//			sysDepart.setCreateDate(DateUtils.parseDate("2014-05-12 16:43:07","yyyy-MM-dd HH:mm:ss"));
			SysDepart sysDepart = new SysDepart();
			sysDepart.setDepartName("云计算公司");
//			sysDepartService.insert(sysDepart);
//			Page<SysDepart> page = new Page<SysDepart>();
//			page.setPageNo(1);
//			page.setOrderBy("createDate ");
//			sysDepart.setPage(page);
//			List<SysDepart> list = sysDepartService.queryByList(sysDepart);
//			String departId = list.get(0).getId();
			
//			sysDepart = systemService.getEntity(SysDepart.class,"methord1", userId);
			
//			List<SysUserRole> userrole = systemService.findList(SysUserRole.class,"methord1", userId);
//			System.out.print("userrole name:" + userrole.get(0).getRoleId()+"....."+userrole.get(1).getRoleId());
			
			List<String> f = Lists.newArrayList();
			f.add("系统管理");
			f.add("系统配置");
			f.add("角色管理");
			f.add("用户管理");
			
			
			
			
			
			SysFunction sysFunction = new SysFunction();
			sysFunction.setFuncName("通风控制");
			sysFunction.setFuncAlias("tongf");
			sysFunction.setParentId("0");
			sysFunction.setFuncUrl("tfGuizeController.do?tfGuize");
//			systemService.save(sysFunction);
//			sysFunctionService.insert(sysFunction);
//			List<String> params = Lists.newArrayList();
//			params.add("id");
//			params.add("parentId");
//			systemService.delete(sysFunction,params.toArray());
			SysRoleFunction sysRoleFunction = new SysRoleFunction();
			sysRoleFunction.setFuncId(sysFunction.getId());
			sysRoleFunction.setRoleId("402897034673fcd7014673fcd82b0001");
			
//			sysRoleFunctionService.insert(sysRoleFunction);
			List<String> list = Lists.newArrayList();
//			list.add("402897b946033948014603394cd2000c");
//			list.add("402897ec45f31ba00145f31ba4500001");
//			List<SysRoleFunction> l = systemService.findList(SysRoleFunction.class, "methord2",list.toArray());
//			System.out.println("SysRoleFunction :"+l.get(0).getId());
			
			list.add("402897ec45f31ba00145f31ba4500001");
			list.add("me%");
//			List<SysFunction> sysf = systemService.findList(SysFunction.class, "methord1", list.toArray());
//			System.out.println("sysf :"+sysf.get(0).getId());
			
			SysUserDepart sysUserDepart = new SysUserDepart();
//			sysUserDepart.setUserId(user.getId());
			sysUserDepart.setDepartId("402897034673fcd7014673fcd8b40003");
			sysUserDepart.setIsPrimary(Short.valueOf("1"));
//			sysUserDepartService.insert(sysUserDepart);
//			page.setList(list);
//			System.out.println("SpringTestCase.test()"+page.getList().get(3).getDescription());
			String[] templates = {"entityTemplate"};
//			codeGenerateService.generate(bussiPackage, tableName, entityPackage, ftl_description,templates);
			
//			List<SysFunction> f = systemService.findAll(SysFunction.class);
//			System.out.println("SpringTestCase.test()"+f.size());
			
			SysType sysType = new SysType();
			sysType.setTypeCode("Y");
			sysType.setTypeName("是");
			sysType.setDescription("状态");
			sysType.setType("status");
//			systemService.save(sysType);
			
			//图片
			SysIcon sysIcon = new SysIcon();
			sysIcon.setIconName("add.png");
			sysIcon.setIconType(Short.valueOf("0"));//sysType字典中的值
			sysIcon.setIconPath("plug-in/ligerui/default/images/resicon/add.png");
//			sysIconService.insert(sysIcon);
//			systemService.save(sysIcon);
			Page<SysLog> page = new Page<SysLog>(Integer.valueOf(ResourceUtils.getConfig("page.pageSize")));
			page.setOrderBy("updateDate desc");
			SysLog sysLog = new SysLog();
			sysLog.setType(Globals.Log_Type_LOGIN);
			sysLog.setCreateName("takin");
			sysLog.setPage(page);
			List<String> param = Lists.newArrayList();
			param.add("createName");
			param.add("type");
			List<SysLog> logs = sysLogService.queryByList(sysLog);
			for (SysLog log : logs) {
				System.out.println("SpringTestCase.test()" +log.getId());
			}
//			List<SysLog> logs = systemService.findListByPage(sysLog,param.toArray());
			for (int j = 1; j < 11; j++) {
				TfBarn tfBarn = new TfBarn();
				tfBarn.setBarnNo("P"+j);
//				tfBarnService.insert(tfBarn);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
//		CodeGenerator.generate(bussiPackage, tableName, entityPackage, ftl_description);
	}
	
}
