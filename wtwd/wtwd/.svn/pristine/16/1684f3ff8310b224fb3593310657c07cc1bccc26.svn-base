package com.cncoman.product.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;


import com.cncoman.product.bean.CompanyInfo;

import com.cncoman.product.bean.UserInfo;
import com.cncoman.product.util.Constants;
import com.cncoman.product.bean.PageControlModel;

import com.cncoman.product.bean.ResourceInfo;
import com.cncoman.product.bean.RoleInfo;
import com.cncoman.product.util.StringUtil;

import com.opensymphony.xwork2.Preparable;

public class UserInfoAction extends BaseAction implements Preparable {
	private static final long serialVersionUID = 1L;

	private static Random r = new Random();

	/////////////////////////////////中科脉系统用户管理开始/////////////////////////////////////	
	public String list() {
		this.pageModel = (this.pageModel == null ? new PageControlModel()
				: this.pageModel);
		UserInfo curUser = (UserInfo) getSession().getAttribute("SESSION_USER");
		if (curUser.getRole().getIntId() == Constants.SYSTEM_ROLE_ADMIN_ID)
			this.companyList = this.companyService.list();
		else
			this.companyList = curUser.getCompanyList();
		this.roleList = this.userService.roleList(curUser);
		String companyIds = "";
		for (CompanyInfo company : this.companyList) {
			companyIds = companyIds + company.getIntId() + ",";
		}
		if (StringUtil.isNull(companyIds)) {
			return "userList";
		}
		companyIds = companyIds.substring(0, companyIds.length() - 1);

		if (this.userInfo == null)
			return "userList";
		int curPage = this.pageModel.getCurPage();
		int rowsOfPage = this.pageModel.getRowsOfPage();
		CompanyInfo company = this.userInfo.getCompany();
		int companyId = company == null ? 0 : company.getIntId();
		int totalPage = this.pageModel.getTotalPage(this.userService.userCount(
				this.userInfo.getRole().getIntId(), companyId, this.userInfo
						.getDepartmentId(), companyIds, curUser), rowsOfPage);
		this.pageModel.setTotalPage(totalPage);
		this.pageModel.setUrl("/userList");
		this.userList = this.userService.list(this.userInfo.getRole()
				.getIntId(), companyId, this.userInfo.getDepartmentId(),
				(curPage - 1) * rowsOfPage, rowsOfPage, companyIds, curUser
						.getIntId(), curUser);
		return "userList";
	}

	public String toAdd() {
		try{
			this.userInfo = ((UserInfo) getSession().getAttribute("SESSION_USER"));
			if (this.userInfo.getRole().getIntId() == Constants.SYSTEM_ROLE_ADMIN_ID)
				this.companyList = this.companyService.list();
			else
				this.companyList = this.userInfo.getCompanyList();
			this.roleList = this.userService.roleList(this.userInfo);
			this.userInfo = null;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "add";
	}

	public String save() {
		try{
			if (this.userInfo.getCompany() == null) {
				this.userInfo.setCompany(getCurUser().getCompany());
			}
			//System.out.println("userInfo.getRole().getIntId()="+userInfo.getRole().getIntId());
			RoleInfo role=userService.getRole(userInfo.getRole().getIntId());
			if(role!=null){
				this.userInfo.getRole().setMosId(role.getMosId());
			}else{
				this.userInfo.getRole().setMosId(0);
			}
		//	userInfo.getRole().getIntId();TODO
		//	userInfo.getRole().getMosId();
			this.userService.save(this.userInfo);
			log.info("ADD USER " + this.userInfo.getName() + " BY USER "
					+ getCurUser().getName());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "list";
	}

	public String toUpdate() {
		this.userInfo = this.userService.getInfo(this.userInfo.getIntId());
		this.roleList = this.userService.roleList(getCurUser());
		UserInfo curUser = (UserInfo) getSession().getAttribute("SESSION_USER");
		if (curUser.getRole().getIntId() == Constants.SYSTEM_ROLE_ADMIN_ID)
			this.companyList = this.companyService.list();
		else
			this.companyList = curUser.getCompanyList();
		return "update";
	}

	public String update() {
//		userInfo.getRole().getIntId();TODO
		//	userInfo.getRole().getMosId();
		RoleInfo role=userService.getRole(userInfo.getRole().getIntId());
		if(role!=null){
			this.userInfo.getRole().setMosId(role.getMosId());
		}else{
			this.userInfo.getRole().setMosId(0);
		}
		this.userService.updateInfo(this.userInfo, getCurUser());
		log.info("UPDATE USER " + this.userInfo.getName() + " BY USER "
				+ getCurUser().getName());
		return "list";
	}

	// ///////////////////////////////中科脉系统用户管理结束/////////////////////////////////////

	// /////////////////////////////////代理商管理开始///////////////////////////////////////
	public String agentList() {
		this.pageModel = (this.pageModel == null ? new PageControlModel()
				: this.pageModel);
		UserInfo curUser = (UserInfo) getSession().getAttribute("SESSION_USER");
		CompanyInfo company = curUser.getCompany();
		this.roleList = this.getSaleRoleList(curUser);
		if (company == null) {
			return "agentList";
		}
		if (this.userInfo == null) {
			return "agentList";
		}

		int companyId = company.getIntId();
		int curPage = this.pageModel.getCurPage();
		int rowsOfPage = this.pageModel.getRowsOfPage();
		int totalPage = this.pageModel.getTotalPage(this.userService.userCount(
				this.userInfo.getRole().getIntId(), companyId, this.userInfo
						.getDepartmentId(), null, curUser, "Y", 2), rowsOfPage);
		this.pageModel.setTotalPage(totalPage);
		this.pageModel.setUrl("/agentList");

		this.userList = this.userService.list(this.userInfo.getRole()
				.getIntId(), companyId, this.userInfo.getDepartmentId(),
				(curPage - 1) * rowsOfPage, rowsOfPage, null, curUser
						.getIntId(), "Y", curUser, 2);
		return "agentList";
	}

	// 获取各角色的可见角色列表
	// 2011-09-27，张总要求全部写死。
	/**
	 * 系统管理员:10 数据运维人员:38 区域经理:32 数据查询人员:40 区域代理:36 区代查询员:37
	 */
	public List<RoleInfo> getSaleRoleList(UserInfo curUser) {
		int roleId = curUser.getRole().getIntId();
		if (roleId == Constants.SYSTEM_ROLE_SALE_ADMIN_ID) {
			this.roleList = this.userService.roleList("38,32,40,36,37,41,42");
		} else if (roleId == 32) { // 区域经理
			this.roleList = userService.roleList("40,36");
		} else if (roleId == 36) { // 区域代理
			roleList = userService.roleList("37");
		} else if (roleId == Constants.SYSTEM_ROLE_ADMIN_ID) {
			roleList = userService.roleList(curUser);
		} else {
			roleList = new ArrayList<RoleInfo>();
		}
		return roleList;
	}

	// 初始化修改代理商页面
	/*public String toUpdateAgent() {
		this.userInfo = this.userService.getInfo(this.userInfo.getIntId());

		roleList = this.getSaleRoleList(getCurUser());

		String s = this.userInfo.getCidStrs();
		if (!StringUtil.isNull(s)) {
			String[] cids = s.split(",");
			Integer[] ids = new Integer[cids.length];
			for (int i = 0; i < cids.length; i++) {
				ids[i] = Integer.valueOf(Integer.parseInt(cids[i]));
			}
			this.userInfo.setCids(ids);
		}

		s = this.userInfo.getPidStrs();
		Integer[] ids;
		if (!StringUtil.isNull(s)) {
			String[] cids = s.split(",");
			ids = new Integer[cids.length];
			for (int i = 0; i < cids.length; i++) {
				ids[i] = Integer.valueOf(Integer.parseInt(cids[i]));
			}
			this.userInfo.setPids(ids);
		}

		s = this.userInfo.getMach();
		if (!StringUtil.isNull(s)) {
			String[] machs = s.split(",");
			this.userInfo.setMachs(machs);
		}

		UserInfo curUser = getCurUser();
		this.provinceList = provinceService.list(curUser.getPidStrs());
		for (ProvinceInfo province : this.provinceList) {
			province.setCity(this.provinceService.cityList(province.getIntId(),
					curUser.getCidStrs()));
		}
		String manuCode = this.userInfo.getCompany().getCode();
		this.machineList = this.machineService.list(manuCode,
				curUser.getMach(), curUser.getBrandIdStr());

		brandList = companyService.brandList(manuCode, curUser.getMach(),
				curUser.getBrandIdStr());
		String brandTem = "," + userInfo.getBrandIdStr() + ",";
		String macTem = userInfo.getMach();
		if (!StringUtil.isNull(macTem))
			macTem = "," + macTem + ",";
		else
			macTem = "";
		int isAllMac = -1;
		boolean bTem = true;
		List<MachineInfo> list = null;
		for (CompanyBrandInfo brand : brandList) {
			brand.setMachineList(machineService.list(brand.getIntId(), curUser
					.getMach(), curUser.getBrandIdStr(), curUser.getCompany()
					.getCode()));

			*//**
			 * 判断品牌是全部机型还是部份机型 1,用户的品牌权限为部份品牌机型 2,
			 *//*
			isAllMac = -1;
			bTem = true;
			if (userInfo.getIsAllBrand() == 1) {
				if (!StringUtil.isNull(macTem)) {
					list = brand.getMachineList();
					for (MachineInfo machine : list) {
						if (macTem.indexOf(",'" + machine.getCode() + "',") != -1)
							bTem = false;
					}
				}
				// System.out.println("macTem : " + macTem);
				if (brandTem.indexOf("," + brand.getIntId() + ",") != -1
						&& bTem)
					isAllMac = 0;
				if (!bTem)
					isAllMac = 1;
			}
			// System.out.println("--------------------------->isAllMac : " +
			// isAllMac);
			brand.setIsAllMac(isAllMac);
		}
		return "updateAgent";
	}*/

	// 添加保存代理商
	/*public String saveAgent() {
		if (this.userInfo == null)
			return "createAgent";
		if ((this.userInfo.getRole() == null)
				|| (this.userInfo.getRole().getIntId() == 0)) {
			addActionMessage("请先创建角色!");
			return "createAgent";
		}
		if (StringUtil.isNull(this.userInfo.getLoginId())) {
			addActionMessage("登陆ID不能为空");
			return "createAgent";
		}
		if (StringUtil.isNull(this.userInfo.getName())) {
			addActionMessage("用户姓名不能为空");
			return "createAgent";
		}
		if (this.userService.getInfo(this.userInfo.getLoginId()) != null) {
			addActionMessage("该登陆ID已存在");
			return "createAgent";
		}
		if (this.userInfo.getCompany() == null) {
			this.userInfo.setCompany(getCurUser().getCompany());
		}
		int isAllArea = userInfo.getIsAllArea();
		String cids, pids;
		if (isAllArea == 0) {
			cids = getCurUser().getCidStrs();
			pids = getCurUser().getPidStrs();
		} else {
			cids = StringUtil.getSequence(this.userInfo.getCids());
			if (StringUtil.isNull(cids)) {
				addActionMessage("请选择城市！");
				return "createAgent";
			}
			pids = StringUtil.getSequence(this.userInfo.getPids());
			if (StringUtil.isNull(pids)) {
				addActionMessage("请选择省份！");
				return "createAgent";
			}
		}
		this.userInfo.setPidStrs(pids);
		this.userInfo.setCidStrs(cids);
		String machs = "";
		if (userInfo.getIsAllBrand() == 1) { // 部份品牌机型
			brandList = companyService.brandList(getCurUser().getCompany()
					.getCode(), getCurUser().getMach(), getCurUser()
					.getBrandIdStr());
			String brandIdStrs = "";
			HttpServletRequest req = getRequest();
			String brandId = "";
			for (CompanyBrandInfo brand : brandList) {
				brandId = req.getParameter("isAllMac" + brand.getIntId());
				if (!StringUtil.isNull(brandId) && "0".equals(brandId)) { // 品牌已选中，且值为全部机型ȫ������
					brandIdStrs += brand.getIntId() + ",";
				}
			}
			if (!StringUtil.isNull(brandIdStrs)) {
				brandIdStrs = brandIdStrs
						.substring(0, brandIdStrs.length() - 1);
				userInfo.setBrandIdStr(brandIdStrs);
			}
			machs = StringUtil.getSequence(this.userInfo.getMachs());
		} else {
			if (getCurUser().getRole().getIntId() != Constants.SYSTEM_ROLE_SALE_ADMIN_ID) {
				userInfo.setBrandIdStr(getCurUser().getBrandIdStr());
				machs = getCurUser().getMach();
			} else {
				machs = StringUtil.getSequence(this.userInfo.getMachs());
			}
		}
		this.userInfo.setMach(machs);
		this.userInfo.setValidDomain(2);
		this.userInfo.setPhoneSaleRate(100.0F);
		this.userInfo.setIncomeRate(100.0F);
		this.userInfo.setUid(getCurUser().getIntId());
		this.userService.save(this.userInfo);
		log.info("ADD USER " + this.userInfo.getName() + " BY USER "
				+ getCurUser().getName());
		return "agentList";
	}*/

	// 修改保存代理商
	/*public String updateAgent() {
		if (this.userInfo == null)
			return "createAgent";
		if ((this.userInfo.getRole() == null)
				|| (this.userInfo.getRole().getIntId() == 0)) {
			addActionMessage("请先创建角色!");
			return "createAgent";
		}
		if (StringUtil.isNull(this.userInfo.getName())) {
			addActionMessage("登陆ID不能为空");
			return "createAgent";
		}
		if (StringUtil.isNull(this.userInfo.getName())) {
			addActionMessage("用户姓名不能为空");
			return "createAgent";
		}
		int isAllArea = userInfo.getIsAllArea();
		String cids, pids;
		if (isAllArea == 0) {
			cids = getCurUser().getCidStrs();
			pids = getCurUser().getPidStrs();
		} else {
			cids = StringUtil.getSequence(this.userInfo.getCids());
			if (StringUtil.isNull(cids)) {
				addActionMessage("请选择城市！");
				return "createAgent";
			}
			pids = StringUtil.getSequence(this.userInfo.getPids());
			if (StringUtil.isNull(pids)) {
				addActionMessage("请选择省份！");
				return "createAgent";
			}
		}
		this.userInfo.setPidStrs(pids);
		this.userInfo.setCidStrs(cids);
		String machs = "";
		if (userInfo.getIsAllBrand() == 1) { // 部份品牌机型
			brandList = companyService.brandList(getCurUser().getCompany()
					.getCode(), getCurUser().getMach(), getCurUser()
					.getBrandIdStr());
			String brandIdStrs = "";
			HttpServletRequest req = getRequest();
			String brandId = "";
			for (CompanyBrandInfo brand : brandList) {
				brandId = req.getParameter("isAllMac" + brand.getIntId());
				if (!StringUtil.isNull(brandId) && "0".equals(brandId)) { // 品牌已选中，且值为全部品牌ȫ��Ʒ��
					brandIdStrs += brand.getIntId() + ",";
				}
			}
			if (!StringUtil.isNull(brandIdStrs)) {
				brandIdStrs = brandIdStrs
						.substring(0, brandIdStrs.length() - 1);
				userInfo.setBrandIdStr(brandIdStrs);
			}
			machs = StringUtil.getSequence(this.userInfo.getMachs());
		} else {
			if (getCurUser().getRole().getIntId() != Constants.SYSTEM_ROLE_SALE_ADMIN_ID) {
				userInfo.setBrandIdStr(getCurUser().getBrandIdStr());
				machs = getCurUser().getMach();
			} else {
				machs = StringUtil.getSequence(this.userInfo.getMachs());
			}
		}
		this.userInfo.setMach(machs);
		// this.userInfo.setBrandIdStr(StringUtil.getSequence(this.userInfo.getBrands()));
		this.userInfo.setValidDomain(2);
		this.userInfo.setPhoneSaleRate(100.0F);
		this.userInfo.setIncomeRate(100.0F);
		this.userService.updateInfo(this.userInfo, getCurUser());
		return "agentList";
	}*/

	// 删除代理商
	public String delAgent() {
		if (this.userInfo != null) {
			this.userInfo = this.userService.getInfo(this.userInfo.getIntId());

			int ret = this.userService.deleteUser(this.userInfo.getIntId(),
					getCurUser());
			if (ret > 0)
				log.info("DELETE USER " + this.userInfo.getName() + " BY USER "
						+ getCurUser().getName());
		}
		return "agentList";
	}

	// 初始化新建代理商页面
	/*public String createAgent() {
		this.userInfo = getCurUser();
		roleList = this.getSaleRoleList(userInfo);
		this.provinceList = provinceService.list(this.userInfo.getPidStrs());
		for (ProvinceInfo province : this.provinceList) {
			province.setCity(this.provinceService.cityList(province.getIntId(),
					this.userInfo.getCidStrs()));
		}

		String manuCode = this.userInfo.getCompany().getCode();
		// machineList = machineService.list(manuCode, this.userInfo.getMach(),
		// userInfo.getBrandIdStr());

		brandList = companyService.brandList(manuCode, userInfo.getMach(),
				userInfo.getBrandIdStr());
		for (CompanyBrandInfo brand : brandList) {
			brand.setMachineList(machineService.list(brand.getIntId(), userInfo
					.getMach(), userInfo.getBrandIdStr(), manuCode));
		}
		this.userInfo = null;
		return "createAgent";
	}*/

	// /////////////////////////////////代理商管理结束///////////////////////////////////////

	// /////////////////////////////////系统角色管理开始///////////////////////////////////////
	public String roleList() {
		try {
			roleList = this.getSaleRoleList(getCurUser());
			UserInfo curUser = getCurUser();
			for (RoleInfo role : this.roleList) {
				//role.setResourceList(this.resourceMosService.list(role.getPurview()));
				//role.setUserCount(userService.userCount(role.getIntId(), 0, 0,null, curUser));
				// userInfo = userService.getInfo(role.getUid());
				// role.setUserName(userInfo == null ?  "该用户已被删除" :
				// userInfo.getName());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "roleList";
	}

	// public void alert(){
	// HttpServletResponse res = getResponse();
	// res.setContentType("text/html");
	// res.setCharacterEncoding("UTF-8");
	// PrintWriter out = null;
	// try {
	// out = res.getWriter();
	// out.write("<script>alert('对不起，你不可以对自己的角色进行操作!');
	// history.back();</script>");
	// } catch (IOException e) {
	// e.printStackTrace();
	// }finally{
	// if(out != null){
	// out.close();
	// out = null;
	// }
	// }
	// }

	public String toUpdateRole() {
		this.userInfo = getCurUser();
		// if(roleInfo.getIntId() == this.userInfo.getRole().getIntId()){
		// alert();
		// return null;
		// }
		// System.out.println("--------toUpdateRole after alert()------------");
		this.roleInfo = this.userService.getRole(this.roleInfo.getIntId());
		if (this.userInfo.getRole().getIntId() == Constants.SYSTEM_ROLE_ADMIN_ID){
			this.resourceList = this.resourceService.list();
		//  roleList = userMosService.roleList(userInfo);	
		  /*
		   * TODO
		   */
		}else {
			this.resourceList = this.userInfo.getRole().getResourceList();
		}
		String purview = roleInfo.getPurview();
		if (!StringUtil.isNull(purview)) {
			String[] strs = purview.split(",");
			if ((strs != null) && (strs.length > 0)) {
				Integer[] resIds = new Integer[strs.length];
				for (int i = 0; i < strs.length; i++) {
					resIds[i] = Integer.valueOf(Integer.parseInt(strs[i]));
				}
				this.roleInfo.setResourceIds(resIds);
			}
		}
		return "toUpdateRole";
	}

	public String updateRole() {
		try{
			if (this.roleInfo == null)
				return "toUpdateRole";
			if (StringUtil.isNull(this.roleInfo.getName())) {
				addActionMessage("角色名称不能为空!");
				return "toUpdateRole";
			}
			String purview = StringUtil.getSequence(this.roleInfo.getResourceIds());
			if (StringUtil.isNull(purview)) {
				addActionMessage("请选择权限!");
				return "toUpdateRole";
			}
			this.roleInfo.setPurview(purview);
			if (getCurUser().getRole().getIntId() != Constants.SYSTEM_ROLE_ADMIN_ID) {
				this.roleInfo.setIsPublic(Constants.SALE_SYSTEM_PRIVATE_ROLE_FLAG);
			}
			RoleInfo role = this.userService.getRole(this.roleInfo.getIntId());
			
			int c=this.userService.updateRole(this.roleInfo, getCurUser());
			if(c>0){
				if(role.getMosId()!=roleInfo.getMosId()){
					RoleInfo info=new RoleInfo();
					info.setIntId(role.getIntId());
					info.setMosId(roleInfo.getMosId());
					userService.updateMosid( info, getCurUser());
				}
			}
			
			log.info("UPDATE ROLE PURVIEW BY USER " + getCurUser().getName()
					+ " OLD PURVIEW " + role.getPurview() + " -> NEW PURVIEW "
					+ purview);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "list";
	}

	public String createRole() {
		if (this.roleInfo == null)
			return "createRole";
		if (StringUtil.isNull(this.roleInfo.getName())) {
			addActionMessage("角色名称不能为空!");
			return "createRole";
		}
		String purview = StringUtil.getSequence(this.roleInfo.getResourceIds());
		if (StringUtil.isNull(purview)) {
			addActionMessage("请选择权限!");
			return "createRole";
		}

		this.roleInfo.setPurview(purview);
		this.roleInfo.setUid(getCurUser().getIntId());
		
		if (getCurUser().getRole().getIntId() != Constants.SYSTEM_ROLE_ADMIN_ID) {
			this.roleInfo.setIsPublic(Constants.SALE_SYSTEM_PRIVATE_ROLE_FLAG);
		}

		this.userService.createRole(this.roleInfo);
		return "list";
	}

	public String roleForm() {
		this.userInfo = getCurUser();
		if (this.userInfo.getRole().getIntId() == Constants.SYSTEM_ROLE_ADMIN_ID){
			this.resourceList = this.resourceService.list();
		/*
		 * TODO
		 */
			//roleList = userMosService.roleList(userInfo);	
		
		}else {
			this.resourceList = this.userInfo.getRole().getResourceList();
		}
		
		return "createRole";
	}

	/**
	 * 物理删除角色 先物理删除该角色下用户.
	 * 
	 * @return
	 */
	public String delRole() {
		if (this.roleInfo != null) {
			// this.userInfo = getCurUser();
			// if(roleInfo.getIntId() == this.userInfo.getRole().getIntId()){
			// alert();
			// return null;
			// }
			// System.out.println("--------delRole after alert()------------");
			// this.roleInfo =
			// this.userService.getRole(this.roleInfo.getIntId());
			// this.roleInfo.setValid("N");
			// this.userService.updateRole(this.roleInfo, getCurUser());

			this.userService.deleteUserByRoleId(roleInfo.getIntId(),
					getCurUser());
			userService.deleteRole(roleInfo.getIntId());
		}
		return "list";
	}

	// /////////////////////////////////系统角色管理结束///////////////////////////////////////

	// /////////////////////////////////修改用户密码//////////////////////////////////////////
	public String toChangePwd() {
		return "changePwd";
	}

	public String changePwd() {
		try{
			if (this.userInfo == null) {
				return "changePwd";
			}
			UserInfo curUser = getCurUser();
	
			if (!this.userInfo.getPwd().equals(curUser.getPwd())) {
				addFieldError("oldError", "密码错误!");
				return "changePwd";
			}
	
			if ((StringUtil.isNull(this.userInfo.getOldPwd()))
					|| (StringUtil.isNull(this.userInfo.getNewPwd()))) {
				addFieldError("newError", "新密码不能为空!");
				return "changePwd";
			}
	
			if (!this.userInfo.getOldPwd().equals(this.userInfo.getNewPwd())) {
				addFieldError("newError2", "两次新密码不一致!");
				return "changePwd";
			}
	
			curUser.setPwd(this.userInfo.getNewPwd());
			this.userService.updateInfo(curUser, curUser);
			addActionMessage("修改成功!!请记好你的新密码：" + this.userInfo.getNewPwd());
		}catch(Exception ex){
			ex.printStackTrace();
			addActionMessage("修改失败！！");
		}
		return "changePwd";
	}

	// /////////////////////////////////修改用户密码结束//////////////////////////////////////////

	// ////////////////////////////////系统菜单管理开始//////////////////////////////
	public String createResource() {
		this.resourceList = this.resourceService.list();
		return "createResource";
	}

	public String resourceList() {
		resourceInfo = resourceInfo == null ? new ResourceInfo() : resourceInfo;
		this.resourceList = this.resourceService.list(resourceInfo.getGrade(), resourceInfo.getDomain(),resourceInfo.getName());
		return "resourceList";
	}

	public void saveResource() {
		this.resourceService.saveResource(this.resourceInfo);
	}

	public String toUpdateResource() {
		this.resourceList = this.resourceService.list();
		this.resourceInfo = this.resourceService.getInfo(this.resourceInfo
				.getIntId());
		return "updateResource";
	}

	public String updateResource() {
		this.resourceService.updateResource(this.resourceInfo);
		return "resourceList";
	}

	// /////////////////////////////系统菜单管理结束////////////////////////////////////

	// /////////////////////////////销售人员注册////////////////////////////////////////
/*	public String mobileSalesRegister() {
		if (this.mobileSalesInfo != null) {
			if (!VerifyIdCard.verify(this.mobileSalesInfo.getIdentity())) {
				return "register";
			}
			this.mobileSalesInfo.setLoginId(generateMobileSalesID());
			this.userService.save(this.mobileSalesInfo);
		}
		return "register";
	}

	public boolean validIdentity(String identity) {
		this.mobileSalesInfo = this.userService.getMobileSalesInfo(identity);
		return this.mobileSalesInfo == null;
	}*/

	public String generateMobileSalesID() {
		String id = String.valueOf(Constants.MOBILE_SALES_MIN_ID
				+ r.nextInt(Constants.MOBILE_SALES_MAX_ID));
		while (this.userService.getInfo(id) != null) {
			id = String.valueOf(Constants.MOBILE_SALES_MIN_ID
					+ r.nextInt(Constants.MOBILE_SALES_MAX_ID));
		}
		return id;
	}

	public static void main(String[] args) {
	}

	public void prepare() throws Exception {
		clearActionErrors();
	}

}
