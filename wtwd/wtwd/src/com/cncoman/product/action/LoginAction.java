package com.cncoman.product.action;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.directwebremoting.util.Logger;

import com.cncoman.product.bean.UserInfo;
import com.cncoman.product.util.Constants;
import com.cncoman.product.bean.RoleInfo;
import com.cncoman.product.util.StringUtil;
import com.opensymphony.xwork2.Preparable;

public class LoginAction extends BaseAction implements Preparable{

	private Logger logger = Logger.getLogger(this.getClass());
	
	private static final long serialVersionUID = 1L;

	public String dologon(){
		logger.info("--------------dologon------------------");
		HttpServletRequest req = getRequest();		
		String TxtValidateCode = req.getParameter("TxtValidateCode");
		String sessionValidCode = (String) req.getSession().getAttribute(Constants.VALID_CODE);	
		if(TxtValidateCode==null){
			logger.info("TxtValidateCode==null");
			return "FAIL";
		}
		if(!TxtValidateCode.equalsIgnoreCase(sessionValidCode)){		
			logger.info("!TxtValidateCode.equalsIgnoreCase(sessionValidCode)");	
			this.addActionError("验证码错误!");
			return "FAIL";
		}
		String loginId = userInfo.getLoginId();
		String pwd = userInfo.getPwd();
		if(StringUtil.isNull(loginId)){			
			logger.info("StringUtil.isNull(loginId)");	
			this.addActionError("用户名不能为空!");
			return "FAIL";
		}
		String domain = req.getServerName();		
		if(StringUtil.isNull(domain)){
			logger.info("StringUtil.isNull(domain)");	
			this.addActionError("非法的访问!");
			return "FAIL";
		}	

		logger.info("domain:"+domain);	
		int domainFlag = 0;
		if(Constants.DOMAIN_CNCOMAN_LIST.contains(domain))
			domainFlag = Constants.DOMAIN_CNCOMAN_FLAG;
		else if(Constants.DOMAIN_SALEDETAIL_LIST.contains(domain))
			domainFlag = Constants.DOMAIN_DATA123_FLAG;		
		else if(Constants.DOMAIN_INCOME_LIST.contains(domain)){
			domainFlag = Constants.DOMAIN_INCOME_FLAG;
		}else{
			logger.info("domainFlag = 0");	
//			this.addActionError("不合法的请求源!");
//			return "FAIL";
		}
		//
		if(!loginId.matches("[\\w]{4,20}")){
			this.addActionError("不合法的请求!");
			return "FAIL";
		}
		
		userInfo = userService.getInfo(loginId, domainFlag);
		if(userInfo == null){			
			logger.info("userInfo == null");	
			this.addActionError("你所输入的用户不存在!");
			return "FAIL";
		}		
		if(userInfo.getPwd().equals(pwd)){
			RoleInfo role = userInfo.getRole();	
			
			if(role.getIntId() == Constants.SYSTEM_ROLE_ADMIN_ID)   //系统管理员获取所有菜单
				role.setResourceList(resourceService.list(1));
			else
				role.setResourceList(resourceService.list(role.getPurview()));
			
			userInfo.setRole(role);
			
			userInfo.setCompanyList(companyService.list(Constants.COMPANY_TYPE_MANU, (role.getIntId() == Constants.SYSTEM_ROLE_OPERATIONS || role.getIntId() == Constants.SYSTEM_ROLE_MANAGER_ID || role.getIntId() == Constants.SYSTEM_ROLE_ADMIN_ID || role.getIntId() == Constants.SYSTEM_ROLE_PROD_ID) ? 0 : userInfo.getIntId(), 0, 10000));    //设置用户可见厂商集合
			
			if(role.getIntId() != Constants.SYSTEM_ROLE_ADMIN_ID && role.getIntId() != Constants.SYSTEM_ROLE_PROD_ID){
				String machs = "";
				//List<MachineInfo> list = machineService.list(userInfo.getCompany().getCode(), userInfo.getMach(), userInfo.getBrandIdStr());
				/*for(MachineInfo machine : list){
					machs += "'" + machine.getCode() + "',";
				}*/
				if(!StringUtil.isNull(machs)){
					userInfo.setMach(machs.substring(0, machs.length() - 1));					
				}				
			}
			
			
			HttpSession session = getSession();
			session.setAttribute(Constants.SESSION_USER, userInfo);
			session.setMaxInactiveInterval(30 * 60);
			
			userInfo.setAccessTimes(userInfo.getAccessTimes() + 1);
			userInfo.setIp(req.getRemoteAddr());
//			userService.updateInfo(userInfo, userInfo);
			userService.updateInfoForLogin(userInfo, userInfo);
			if (!"admin".equals(userInfo.getLoginId())) {// 测试账号略过
				loginInfo(userInfo);//登录明细日志
			}
			log.info("USER LOGIN " + userInfo.getName() + " IP " + userInfo.getIp());
			return "OK";
		}		
		logger.info("!userInfo.getPwd().equals(pwd)");	
		this.addActionError("用户名或密码错误!");
		return "FAIL";
	}
	
	public void loginInfo(UserInfo userInfo) {
		FileWriter writer=null;
        try {
//        	String  fileName = "/home/mosrv/logs/p.data123.com-login.txt";
    		String  fileName = "/usr/local/web/login/login.txt";
//        	String  fileName ="D:/Users/local/web/login.txt";
    		String content=userInfo.getIntId()+","+userInfo.getName()+","+userInfo.getLoginId()+","+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+","+userInfo.getIp()+"\r\n";
        	
             writer = new FileWriter(fileName, true);
            writer.write(content);
            
            writer.close();
            content=null;
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	writer=null;
        }
	}

	/*//手机管理平台登陆
	public String login() {		
		if (userInfo == null)		
			return "fail";
		HttpServletRequest req = getRequest();
		String loginId = userInfo.getLoginId();
		String pwd = userInfo.getPwd();
		//获取今天的销量总计
		statInfo= new SaleStatInfo();
		String fromDay = "", toDay = "";
		fromDay = statInfo.getToDay();
		toDay = statInfo.getToDay();
		
		statInfo.setTitle(fromDay);
		//statInfo.setCncomanCount(saleDetailService.totalRecords(null, null,fromDay, toDay, 0, 0, 0, null, null, 1));
        //获取今天收益总计
		if (incomeInfo == null) {
			incomeInfo = new IncomeInfo();
			incomeInfo.setName("日期");
			incomeInfo.setGroupBy(1);
			incomeInfo.setFromDay(incomeInfo.getToDay());
		}

		incomeStatList = incomeService.incomeStatList(incomeInfo
				.getGroupBy(), incomeInfo.getOperator(), incomeInfo
				.getManu(), incomeInfo.getMach(), incomeInfo
				.getProvinceId(), incomeInfo.getCmdId(), incomeInfo
				.getProd(), incomeInfo.getFromDay(), incomeInfo.getToDay());
		///////////////获取今天收益总计        结束////////////
		if(StringUtil.isNull(loginId)){			
			this.addActionError("用户名不能为空!");
			return "fail";
		}
		String domain = req.getServerName();		
		if(StringUtil.isNull(domain)){
			this.addActionError("非法的访问!");
			return "fail";
		}
		
		
		int domainFlag = 0;
		if(Constants.DOMAIN_CNCOMAN_LIST.contains(domain))
			domainFlag = Constants.DOMAIN_CNCOMAN_FLAG;
		else if(Constants.DOMAIN_SALEDETAIL_LIST.contains(domain))
			domainFlag = Constants.DOMAIN_DATA123_FLAG;		
		else if(Constants.DOMAIN_INCOME_LIST.contains(domain)){
			domainFlag = Constants.DOMAIN_INCOME_FLAG;
		}else{
			this.addActionError("不合法的请求源!");
			return "fail";
		}
		
		userInfo = userService.getInfo(loginId, domainFlag);
		if(userInfo == null){			
			this.addActionError("你所输入的用户不存在!");
			return "fail";
		}		
		if(userInfo.getPwd().equals(pwd)){
			RoleInfo role = userInfo.getRole();	
			
			if(role.getIntId() == Constants.SYSTEM_ROLE_ADMIN_ID)   //系统管理员获取所有菜单
				role.setResourceList(resourceService.list(1));
			else
				role.setResourceList(resourceService.list(role.getPurview()));
			
			userInfo.setRole(role);
			
			userInfo.setCompanyList(companyService.list(Constants.COMPANY_TYPE_MANU, role.getIntId() == Constants.SYSTEM_ROLE_ADMIN_ID || role.getIntId() == Constants.SYSTEM_ROLE_PROD_ID ? 0 : userInfo.getIntId(), 0, 10000));    //设置用户可见厂商集合
			
			if(role.getIntId() != Constants.SYSTEM_ROLE_ADMIN_ID && role.getIntId() != Constants.SYSTEM_ROLE_PROD_ID){
				String machs = "";
				List<MachineInfo> list = machineService.list(userInfo.getCompany().getCode(), userInfo.getMach(), userInfo.getBrandIdStr());
				for(MachineInfo machine : list){
					machs += "'" + machine.getCode() + "',";
				}
				if(!StringUtil.isNull(machs)){
					userInfo.setMach(machs.substring(0, machs.length() - 1));					
				}				
			}
			
			
			HttpSession session = getSession();
			session.setAttribute(Constants.SESSION_USER, userInfo);
			session.setMaxInactiveInterval(30 * 60);
			
			userInfo.setAccessTimes(userInfo.getAccessTimes() + 1);
			userInfo.setIp(req.getRemoteAddr());			
			userService.updateInfoForLogin(userInfo, userInfo);
			log.info("USER LOGIN " + userInfo.getName() + " IP " + userInfo.getIp());
			return "success";
		}		
		this.addActionError("用户名或密码错误!");
		return "fail";		
	}*/

	
	public void logout() throws IOException{
		getSession().invalidate();
		getResponse().sendRedirect("/");
	}
	
	public void prepare() throws Exception{
		this.clearActionErrors();
	}
	//wap查询销量 返回到菜单的方法
	/*public String back(){
//		获取今天的销量总计
		statInfo= new SaleStatInfo();
		String fromDay = "", toDay = "";
		fromDay = statInfo.getToDay();
		toDay = statInfo.getToDay();
		
		statInfo.setTitle(fromDay);
	//	statInfo.setCncomanCount(saleDetailService.totalRecords(null, null,fromDay, toDay, 0, 0, 0, null, null, 1));
        //获取今天收益总计
		if (incomeInfo == null) {
			incomeInfo = new IncomeInfo();
			incomeInfo.setName("日期");
			incomeInfo.setGroupBy(1);
			incomeInfo.setFromDay(incomeInfo.getToDay());
		}

		incomeStatList = incomeService.incomeStatList(incomeInfo
				.getGroupBy(), incomeInfo.getOperator(), incomeInfo
				.getManu(), incomeInfo.getMach(), incomeInfo
				.getProvinceId(), incomeInfo.getCmdId(), incomeInfo
				.getProd(), incomeInfo.getFromDay(), incomeInfo.getToDay());
		///////////////获取今天收益总计        结束////////////
		return "success";
	}*/
	
}
