package org.takinframework.web.system.controller.core;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.takinframework.core.common.model.json.AjaxJson;
import org.takinframework.core.constant.Globals;
import org.takinframework.core.util.BrowserUtils;
import org.takinframework.core.util.ContextHolderUtils;
import org.takinframework.core.util.LogUtil;
import org.takinframework.core.util.Page;
import org.takinframework.core.util.PasswordUtil;
import org.takinframework.core.util.ResourceUtils;
import org.takinframework.core.util.StringUtil;
import org.takinframework.core.util.oConvertUtils;
import org.takinframework.web.system.entity.Client;
import org.takinframework.web.system.entity.SysBrowser;
import org.takinframework.web.system.entity.SysFunction;
import org.takinframework.web.system.entity.SysRole;
import org.takinframework.web.system.entity.SysRoleFunction;
import org.takinframework.web.system.entity.SysUser;
import org.takinframework.web.system.entity.SysUserRole;
import org.takinframework.web.system.manager.ClientManager;
import org.takinframework.web.system.service.SysFunctionService;
import org.takinframework.web.system.service.SysRoleService;
import org.takinframework.web.system.service.SysUserService;
import org.takinframework.web.system.service.SystemService;
import com.google.common.collect.Lists;

/**
 * 登陆初始化控制器
 * @author twg
 * 
 */
@Controller
@RequestMapping("/loginController")
public class LoginController {
	@Autowired
	private SystemService systemService;
	@Autowired
	private SysUserService<SysUser,String> sysUserService;
	@Autowired
	private SysRoleService<SysRole, String> sysRoleService;
	@Autowired
	private SysFunctionService<SysFunction, String> sysFunctionService;

	private String message = null;
	
	
	@RequestMapping(params = "goPwdInit")
	public String goPwdInit() {
		return "login/pwd_init";
	}
	
	
	private boolean isSameIp(SysUser u,HttpServletRequest req,HttpServletResponse res){
		//判断当前用户的ip，与日志中的用户ip是否同一个，如果是同一个就可以登录否则要判断用户状态是否为在线
		Page<SysBrowser> page = new Page<SysBrowser>(req,res);
		page.setOrderBy("updateDate desc");
		SysBrowser sysBrowser = new SysBrowser();
		sysBrowser.setCreateName(u.getUserName());
		sysBrowser.setPage(page);
		List<String> log = Lists.newArrayList();
		log.add("createName");
		try {
			List<SysBrowser> logs = systemService.findListByPage(sysBrowser,log.toArray());
			if(StringUtil.isNotEmpty(logs) && logs.size()>0){
				if(logs.get(0).getIp().equals(oConvertUtils.getIpAddrByRequest(req))){
					return true;
				}
			}
		} catch (Exception e) {
		}
		return false;
	}


	/**
	 * 检查用户名称
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(params = "checkuser",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson checkuser(SysUser user,HttpServletRequest req,HttpServletResponse res) {
			HttpSession session = ContextHolderUtils.getSession();
			AjaxJson j = new AjaxJson();
			user.setPassword(PasswordUtil.encrypt(user.getUserName(), user.getPassword(), PasswordUtil.getStaticSalt()));
			List<String> param = Lists.newArrayList();
			param.add("userName");
			param.add("password");
//			param.add("status");
			try {
				int users = systemService.getEntityCount(user, param.toArray());
				if (users == 0) {
					j.setMsg("用户名或密码错误!");
					j.setSuccess(false);
				}else {
					
					SysUser u = systemService.checkEntityExits(user, param.toArray());//用户验证
					
					if (u != null && !"0".equals(u.getStatus().toString())) {
						
						//判断用户状态是否为在线,再判断当前用户的ip，与日志中的用户ip是否同一个，如果是同一个就可以登录
						if("3".equals(u.getStatus().toString())){//3在线
							if(!isSameIp(u,req,res)){
								j.setMsg("用户已登录");
								j.setSuccess(false);
								return j;
							}
							
						}
//						List<SysDepart> sysDeparts = systemService.findList(SysDepart.class,"methord1", u.id);
//						if(sysDeparts.size()>0){
							// if (user.getUserKey().equals(u.getUserKey())) {
							if (true) {
								u.setStatus(Short.valueOf("3"));//登陆成功设置为3在线
								message = "用户: " + user.getUserName() +  "登录成功";
								Client client = new Client();
								client.setIp(oConvertUtils.getIpAddrByRequest(req));
								client.setLoginDateTime(new Date());
								client.setUser(u);
								ClientManager.getInstance().addClinet(session.getId(),
										client);
								//检测浏览器是否激活用的
								SysBrowser sysBrowser = new SysBrowser();
								HttpServletRequest request = ContextHolderUtils.getRequest();
								String broswer = BrowserUtils.checkBrowse(request);
								sysBrowser.setSessionId(session.getId());
								sysBrowser.setUserAgent(broswer);
								sysBrowser.setIp(oConvertUtils.getIpAddrByRequest(req));
								try {
									systemService.update(u);
									systemService.save(sysBrowser);
									// 添加登陆日志
									systemService.addLog(message, Globals.Log_Type_LOGIN,
											Globals.Log_Leavel_INFO);
								} catch (Exception e) {
									// 添加登陆日志
									systemService.addLog(message, Globals.Log_Type_LOGIN,
											Globals.Log_Leavel_ERROR);
									j.setMsg("用户登录失败");
									j.setSuccess(false);
								}
			
							} else {
								j.setMsg("请检查U盾是否正确");
								j.setSuccess(false);
							}
//						}else{
//							j.setMsg("用户机构不存在!");
//							j.setSuccess(false);
//							return j;
//						}
					} else {
						j.setMsg("用户名或密码错误!");
						j.setSuccess(false);
					}
				}
				
			} catch (Exception e) {
				LogUtil.error("获取用户表失败", e);
			}
//			int users = sysUserService.selectByCount(user);
			
			
			return j;
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(params = "login")
	public String login(HttpServletRequest request) {
		SysUser user = ResourceUtils.getSessionUserName();
		HttpSession session = ContextHolderUtils.getSession();
		Client client = ClientManager.getInstance().getClient(session.getId());
		String roles = "";
		if (user != null) {
			List<SysUserRole> rUsers = null;
			//防止重复查询SysUserRole
			if(client.getSysUserRoles() == null){
				rUsers = systemService.findList(SysUserRole.class,"methord1", user.getId());
				client.setSysUserRoles(rUsers);
			}else{
				rUsers = client.getSysUserRoles();
			}
			//防止重复查询SysRole
			if(client.getSysRoles() == null){
				List<SysRole> sysRoles = Lists.newArrayList();
				for (SysUserRole ru : rUsers) {
					SysRole role;
					try {
						role = systemService.getEntity(SysRole.class, "methord1", ru.getRoleId());
						roles += role.getRoleName() + ",";
						sysRoles.add(role);
					} catch (SQLException e) {
						LogUtil.error("获取系统角色表失败", e);
					}
					
				}
				client.setSysRoles(sysRoles);
			}else{
				List<SysRole> sysRoles = client.getSysRoles();
				for (SysRole role : sysRoles) {
					roles += role.getRoleName() + ",";
				}
			}
			
			if (roles.length() > 0) {
				roles = roles.substring(0, roles.length() - 1);
			}
			request.setAttribute("roleName", roles);
			request.setAttribute("userName", user.getUserName());
			return "main/main";
		} else {
			return "login/login";
		}

	}

	/**
	 * 退出系统
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = ContextHolderUtils.getSession();
		SysUser user = ResourceUtils.getSessionUserName();
		
		try {
			if("3".equals(user.getStatus().toString())){//在线的话，就为可用1
				user.setStatus(Short.valueOf("1"));
				systemService.update(user);
			}
			systemService.addLog("用户" + user.getUserName() + "已成功退出",
					Globals.Log_Type_EXIT, Globals.Log_Leavel_INFO);
			ClientManager.getInstance().removeClinet(session.getId());
		} catch (Exception e) {
			systemService.addLog("用户" + user.getUserName() + "退出失败",
					Globals.Log_Type_EXIT, Globals.Log_Leavel_ERROR);
		}
		ModelAndView modelAndView = new ModelAndView(new RedirectView(
				"loginController.do?login"));

		return modelAndView;
	}

//	/**
//	 * 菜单跳转
//	 * 
//	 * @return
//	 */
//	@RequestMapping(params = "left")
//	public ModelAndView left(HttpServletRequest request) {
//		SysUser user = ResourceUtil.getSessionUserName();
//		HttpSession session = ContextHolderUtils.getSession();
//		// 登陆者的权限
//		if (user.getId() == null) {
//			session.removeAttribute(Globals.USER_SESSION);
//			return new ModelAndView(
//					new RedirectView("loginController.do?login"));
//		}
//
//		request.setAttribute("menuMap", getFunctionMap(user));
////		List<TSConfig> configs = userService.loadAll(TSConfig.class);
////		for (TSConfig tsConfig : configs) {
////			request.setAttribute(tsConfig.getCode(), tsConfig.getContents());
////		}
//		return new ModelAndView("main/left");
//	}
	
	@RequestMapping(params = "leftTree")
	@ResponseBody
	public List<SysFunction> leftTree(){
		SysUser user = ResourceUtils.getSessionUserName();
		HttpSession session = ContextHolderUtils.getSession();
		// 登陆者的权限
		if (user.getId() == null) {
			session.removeAttribute(Globals.USER_SESSION);
			// 添加登陆日志
			systemService.addLog("用户会话已过期", Globals.Log_Type_LOGIN,
					Globals.Log_Leavel_WARRING);
		}
		return getFunctionList(user);
	}

//	/**
//	 * 获取权限的map
//	 * 
//	 * @param user
//	 * @return
//	 */
//	private Map<Integer, List<SysFunction>> getFunctionMap(SysUser user) {
//		Map<Integer, List<SysFunction>> functionMap = new HashMap<Integer, List<SysFunction>>();
//		Map<String, SysFunction> loginActionlist = getUserFunction(user);
//		if (loginActionlist.size() > 0) {
//			Collection<SysFunction> allFunctions = loginActionlist.values();
//			for (SysFunction function : allFunctions) {
//				if (!functionMap.containsKey(function.getFuncLevel() + 0)) {
//					functionMap.put(function.getFuncLevel() + 0,
//							new ArrayList<SysFunction>());
//				}
//				functionMap.get(function.getFuncLevel() + 0).add(function);
//			}
//			// 菜单栏排序
//			Collection<List<SysFunction>> c = functionMap.values();
//			for (List<SysFunction> list : c) {
//				Collections.sort(list, new NumberComparator());
//			}
//		}
//		return functionMap;
//	}
	
	
	private List<SysFunction> getFunctionList(SysUser user) {
		List<SysFunction> sysFunctions = getUserFunctions(user);
		return sysFunctions;
	}

//	/**
//	 * 获取用户菜单列表
//	 * 
//	 * @param user
//	 * @return
//	 */
//	private Map<String, SysFunction> getUserFunction(SysUser user) {
//		HttpSession session = ContextHolderUtils.getSession();
//		Client client = ClientManager.getInstance().getClient(session.getId());
//		if (client.getFunctions() == null) {
//			Map<String, SysFunction> loginActionlist = new HashMap<String, SysFunction>();
//			List<SysUserRole> rUsers = systemService.findList(SysUserRole.class,"methord1", user.getId());
//			for (SysUserRole ru : rUsers) {
//				SysRole role = systemService.getEntity(SysRole.class, "methord1", ru.getRoleId());
//				List<SysRoleFunction> roleFunctionList = systemService.findList(SysRoleFunction.class,"methord1", role.getId());
//				for (SysRoleFunction roleFunction : roleFunctionList) {
//					SysFunction function = systemService.getEntity(SysFunction.class, "methord1", roleFunction.getFuncId());
//					loginActionlist.put(function.getId(), function);
//				}
//			}
//			client.setFunctions(loginActionlist);
//		}
//		return client.getFunctions();
//	}
	
	/**
	 * 获取用户菜单列表
	 * 
	 * @param user
	 * @return
	 */
	private List<SysFunction>  getUserFunctions(SysUser user) {
		HttpSession session = ContextHolderUtils.getSession();
		Client client = ClientManager.getInstance().getClient(session.getId());
		if (client.getSysFunctions() == null) {
			List<SysFunction> loginActionlist = Lists.newLinkedList();
			//如果当前用户为指定用户时，就直接取全部菜单
			String adminUser  = ResourceUtils.getConfig("account");
			if(StringUtil.isNotEmpty(adminUser) && 
					client.getUser().getUserName().equals(adminUser)){
				List<SysFunction> functions = systemService.findAll(SysFunction.class, "methord1");
				for (SysFunction sysFunction : functions) {
					loginActionlist.add(sysFunction);
				}
			}else{
				List<SysRole> roles = client.getSysRoles();
				for (SysRole role : roles) {
					List<SysRoleFunction> roleFunctionList = systemService.findList(SysRoleFunction.class,"methord1", role.getId());
					for (SysRoleFunction roleFunction : roleFunctionList) {
						try {
							SysFunction function = systemService.getEntity(SysFunction.class, "methord1", roleFunction.getFuncId());
							loginActionlist.add(function);
						} catch (SQLException e) {
							LogUtil.error("获取系统菜单表失败", e);
						}
//						if(function.getIsShow().toString().equals("1")){
							
//						}
						
					}
				}
			}
			
			client.setSysFunctions(loginActionlist);
		}
		return client.getSysFunctions();
	}

	/**
	 * 首页跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "home")
	public ModelAndView home(HttpServletRequest request) {
		return new ModelAndView("main/home");
	}
	/**
	 * 无权限页面提示跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "noAuth")
	public ModelAndView noAuth(HttpServletRequest request) {
		return new ModelAndView("common/noAuth");
	}
//	/**
//	 * @Title: top
//	 * @Description: bootstrap头部菜单请求
//	 * @param request
//	 * @return ModelAndView
//	 * @throws
//	 */
//	@RequestMapping(params = "top")
//	public ModelAndView top(HttpServletRequest request) {
//		SysUser user = ResourceUtil.getSessionUserName();
//		HttpSession session = ContextHolderUtils.getSession();
//		// 登陆者的权限
//		if (user.getId() == null) {
//			session.removeAttribute(Globals.USER_SESSION);
//			return new ModelAndView(
//					new RedirectView("loginController.do?login"));
//		}
//		request.setAttribute("menuMap", getFunctionMap(user));
////		List<TSConfig> configs = userService.loadAll(TSConfig.class);
////		for (TSConfig tsConfig : configs) {
////			request.setAttribute(tsConfig.getCode(), tsConfig.getContents());
////		}
//		return new ModelAndView("main/bootstrap_top");
//	}
//	/**
//	 * @Title: top
//	 * @author gaofeng
//	 * @Description: shortcut头部菜单请求
//	 * @param request
//	 * @return ModelAndView
//	 * @throws
//	 */
//	@RequestMapping(params = "shortcut_top")
//	public ModelAndView shortcut_top(HttpServletRequest request) {
//		SysUser user = ResourceUtil.getSessionUserName();
//		HttpSession session = ContextHolderUtils.getSession();
//		// 登陆者的权限
//		if (user.getId() == null) {
//			session.removeAttribute(Globals.USER_SESSION);
//			return new ModelAndView(
//					new RedirectView("loginController.do?login"));
//		}
//		request.setAttribute("menuMap", getFunctionMap(user));
////		List<TSConfig> configs = userService.loadAll(TSConfig.class);
////		for (TSConfig tsConfig : configs) {
////			request.setAttribute(tsConfig.getCode(), tsConfig.getContents());
////		}
//		return new ModelAndView("main/shortcut_top");
//	}
	
	/**
	 * @Title: top
	 * @author:gaofeng
	 * @Description: shortcut头部菜单一级菜单列表，并将其用ajax传到页面，实现动态控制一级菜单列表
	 * @param request
	 * @return AjaxJson
	 * @throws
	 */
//	public String getPrimaryMenu(List<SysUserRole> rUsers) {
//		
//		//获取一级菜单列表
//		Map<Integer, List<SysFunction>> functionMap = new HashMap<Integer, List<SysFunction>>();
//		if(shortcutFunctionMap != null){
//
//			//将更新前的菜单数据传过来
//			functionMap = shortcutFunctionMap;
//		}else{
//			functionMap = getPrimaryMenuBase(rUsers);
//		}
//		
//		String floor = "";
//		List<SysFunction> primaryMenu = null;
//		Iterator<Entry<Integer, List<SysFunction>>> it = functionMap.entrySet().iterator();
//		while (it.hasNext()) {
//			Map.Entry pairs = (Map.Entry) it.next();
//			primaryMenu = (List<SysFunction>) pairs.getValue();
//
//			for (SysFunction function : primaryMenu) {
//				if(function.getFuncLevel() == 0 && function.getIsShow() == 1){//一级菜单是否显示1显示0不显示
//					if(function.getIsOpen() == 1){//一级菜单是否打开1打开0不打开
//						floor +="<a class='menuItem menuItem_hover' id='"+function.getId()+"'><img src='plug-in/ligerui/default/images/resicon/manage.png'><span>"+function.getFuncName()+"</span></a>";
//					}else{
//						floor +="<a class='menuItem' id='"+function.getId()+"'><img src='plug-in/ligerui/default/images/resicon/manage.png'><span>"+function.getFuncName()+"</span></a>";
//					}
//					
//					
//
////					if("Online 开发".equals(function.getFuncName())){
////
////						floor += " <li><img class='imag1' src='plug-in/login/images/online.png' /> " 
////								+ " <img class='imag2' src='plug-in/login/images/online_up.png' style='display: none;' />" + " </li> ";
////					}else if("统计查询".equals(function.getFuncName())){
////
////						floor += " <li><img class='imag1' src='plug-in/login/images/guanli.png' /> " 
////								+ " <img class='imag2' src='plug-in/login/images/guanli_up.png' style='display: none;' />" + " </li> ";
////					}else if("系统管理".equals(function.getFuncName())){
////
////						floor += " <li><img class='imag1' src='plug-in/login/images/xtgl.png' /> " 
////								+ " <img class='imag2' src='plug-in/login/images/xtgl_up.png' style='display: none;' />" + " </li> ";
////					}else if("常用示例".equals(function.getFuncName())){
////
////						floor += " <li><img class='imag1' src='plug-in/login/images/cysl.png' /> " 
////								+ " <img class='imag2' src='plug-in/login/images/cysl_up.png' style='display: none;' />" + " </li> ";
////					}else if("系统监控".equals(function.getFuncName())){
////
////						floor += " <li><img class='imag1' src='plug-in/login/images/xtjk.png' /> " 
////								+ " <img class='imag2' src='plug-in/login/images/xtjk_up.png' style='display: none;' />" + " </li> ";
////					}else{
////						//其他的为默认通用的图片模式
//////						String s = "";
//////						if(function.getFuncName().length()>=5 && function.getFuncName().length()<7){
//////							s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'><span style='letter-spacing:-1px;'>"+ function.getFuncName() +"</span></div>";
//////						}else if(function.getFuncName().length()<5){
//////							s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'>"+ function.getFuncName() +"</div>";
//////						}else if(function.getFuncName().length()>=7){
//////							s = "<div style='width:67px;position: absolute;top:40px;text-align:center;color:#909090;font-size:12px;'><span style='letter-spacing:-1px;'>"+ function.getFuncName().substring(0, 6) +"</span></div>";
//////						}
//////						floor += " <li style='position: relative;'><img class='imag1' src='plug-in/login/images/default.png' /> " 
//////								+ " <img class='imag2' src='plug-in/login/images/default_up.png' style='display: none;' />"
//////								+ s +"</li> ";
////						
////					}
//				}
//			}
//		}
//		
//		return floor;
//	}
//	/**
//	 * @Title: top
//	 * @author:gaofeng
//	 * @Description: shortcut头部菜单一级菜单列表，实现动态控制一级菜单列表的基础方法
//	 * @param request
//	 * @return AjaxJson
//	 * @throws
//	 */
//	public Map<Integer, List<SysFunction>> getPrimaryMenuBase(List<SysUserRole> rUsers) {
//		
//		//获取一级菜单列表
//		Map<Integer, List<SysFunction>> functionMap = new HashMap<Integer, List<SysFunction>>();
//		Map<String, SysFunction> loginActionlist = new HashMap<String, SysFunction>();
//		for (SysUserRole ru : rUsers) {
//			SysRole role = systemService.getEntity(SysRole.class, "methord1", ru.getRoleId());
//			List<SysRoleFunction> roleFunctionList = systemService.findList(SysRoleFunction.class,"methord1", role.getId());
//			for (SysRoleFunction roleFunction : roleFunctionList) {
//				SysFunction function = systemService.getEntity(SysFunction.class, "methord1", roleFunction.getFuncId());
//				loginActionlist.put(function.getId(), function);
//			}
//		}
//		
//		if (loginActionlist.size() > 0) {
//			Collection<SysFunction> allFunctions = loginActionlist.values();
//			for (SysFunction function : allFunctions) {
//				if (!functionMap.containsKey(function.getFuncLevel() + 0)) {
//					functionMap.put(function.getFuncLevel() + 0,
//							new ArrayList<SysFunction>());
//				}
//				functionMap.get(function.getFuncLevel() + 0).add(function);
//			}
//			// 菜单栏排序
//			Collection<List<SysFunction>> c = functionMap.values();
//			for (List<SysFunction> list : c) {
//				Collections.sort(list, new NumberComparator());
//			}
//		}
//		//将更新前的菜单数据赋值过去
//		shortcutFunctionMap = functionMap;
//		return functionMap;
//	}
}
