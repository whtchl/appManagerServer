package com.cncoman.product.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.cncoman.product.bean.CompanyInfo;


import com.cncoman.product.util.Constants;
import com.cncoman.product.util.Initialize;
import com.cncoman.product.bean.PageControlModel;
import com.cncoman.product.util.StringUtil;

import com.opensymphony.xwork2.Preparable;

public class CompanyAction extends BaseAction implements Preparable{
	
	private static final long serialVersionUID = 1L;
	private File pak;
	
	private String pakContentType;

	private String pakFileName;
//	private static String appUrl = "http://app.uubackup.com/reloadInfo";    //功能机应用
	private static String appUrl2 = "http://a.test.com.cn/reloadInfo?flag=89";   //智能机应用
	private static String bappUrl2 = "http://b.test.com.cn/reloadInfo?flag=89";   //智能机应用
	
	/*public String updateMachAdOpen(){
		String auto[] = explainben.getShieldPids().split(", ");
		
		explainben.setAutoFeeStatus(Integer.parseInt(auto[explainben.getMachineId()-1]));
		explainben.setLevel(explainben.getLevels()[explainben.getMachineId()-1]);
		explainben.setPushscount(explainben.getPushcount()[explainben.getMachineId()-1]);
		int a=explainService.updateMachAdOpen(explainben);
		if(a>0){
		URLUtil.callURL(appUrl2);
		URLUtil.callURL(bappUrl2);
		}
		return SUCCESS;
	}
	public String machAdOpen(){
		try {
			productList = companyService.listPord();
			companyList = companyService.list(Constants.COMPANY_TYPE_MANU, 0, 0, 10000);
			pageModel = pageModel == null ? new PageControlModel() : pageModel;
			if (explainben==null) {
				explainben = new MachineProdExplainInfo();
			}
			int curPage = pageModel.getCurPage();
			int rowsOfPage = pageModel.getRowsOfPage();	
			int totalPage = pageModel.getTotalPage(explainService.prodCount(explainben), rowsOfPage);
			pageModel.setTotalPage(totalPage);
			explainList = explainService.getAllList(explainben,(curPage - 1) * rowsOfPage, rowsOfPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}*/
	
	public String list(){
		userList = userService.salesList(Constants.COMPANY_TYPE_CNCOMAN, Constants.DEPARTMENT_CNCOMAN_SALES, getCurUser());
		pageModel = pageModel == null ? new PageControlModel() : pageModel;
		
		if(companyInfo == null)
			return "list";
		
		int curPage = pageModel.getCurPage();
		int rowsOfPage = pageModel.getRowsOfPage();	
		int totalPage = pageModel.getTotalPage(companyService.companyCount(companyInfo.getCode(), Constants.COMPANY_TYPE_MANU, companyInfo.getSalesId()), rowsOfPage);
		pageModel.setTotalPage(totalPage);
		pageModel.setUrl("/companyList");
		
		companyList = companyService.list(companyInfo.getCode(), Constants.COMPANY_TYPE_MANU, companyInfo.getSalesId(), (curPage - 1) * rowsOfPage, rowsOfPage);
		for(CompanyInfo company : companyList){
			company.setUserInfo(userService.getInfo(company.getSalesId()));
		}
		return "list";
	}
	
	public String toAdd(){
		userList = userService.salesList(Constants.COMPANY_TYPE_CNCOMAN, Constants.DEPARTMENT_CNCOMAN_SALES, getCurUser());
		return "add";
	}
	
	public String save(){
		if(StringUtil.isNull(companyInfo.getCode())){
			this.addActionMessage("编号不能为空!");
			return "toAdd";
		}
		if(!StringUtil.isNumeric(companyInfo.getCode())){
			this.addActionMessage("编号只能由四位数字组成!");
			return "toAdd";
		}
		if(companyService.getInfo(companyInfo.getCode()) == null){
			companyInfo.setType(Constants.COMPANY_TYPE_MANU);
			companyService.insert(companyInfo);
			Initialize.companyMap.put(companyInfo.getCode(), companyInfo);   //增加到内存中			
			log.info("ADD COMPANY BY USER " + getCurUser().getName() + ", COMPANY CODE " + companyInfo.getCode());
			return "list";
		}else{
			this.addActionMessage("编号已存在!");
			return "toAdd";
		}
	}
	
	public String update(){
		if(StringUtil.isNull(companyInfo.getCode())){
			this.addActionMessage("编号不能为空!");
			return "toUpdate";
		}
		if(!StringUtil.isNumeric(companyInfo.getCode())){
			this.addActionMessage("编号只能由四位数字组成!");
			return "toUpdate";
		}
		CompanyInfo company = companyService.getInfo(companyInfo.getCode());
		if(company != null && company.getIntId() != companyInfo.getIntId()){
			this.addActionMessage("编号已存在!");
			return "toUpdate";
		}else{
			companyService.update(companyInfo);
			log.info("UPDATE COMPANY BY USER " + getCurUser().getName() + ", COMPANY CODE " + companyInfo.getCode());
			return "list";
		}
	}
	
	public String toUpdate(){
		companyInfo = companyService.getInfo(companyInfo.getIntId());
		userList = userService.salesList(Constants.COMPANY_TYPE_CNCOMAN, Constants.DEPARTMENT_CNCOMAN_SALES, getCurUser());
		return "update";
	}
	
	
	///////////////////机型////////////////////////
	
	/*public String machineList(){
		try{
			companyList = companyService.list(Constants.COMPANY_TYPE_MANU, 0, 0, 10000);
			userList = userService.list(0, Constants.COMPANY_TYPE_CNCOMAN, Constants.DEPARTMENT_CNCOMAN_SALES, getCurUser());
			pageModel = pageModel == null ? new PageControlModel() : pageModel;
			if(machineInfo == null)
				return "machineList";
			int curPage = pageModel.getCurPage();
			int rowsOfPage = pageModel.getRowsOfPage();	
					
			companyInfo = machineInfo.getCompany();
			int salesId = companyInfo == null ? 0 : companyInfo.getSalesId();
			
			int totalPage = pageModel.getTotalPage(machineService.countMachine(machineInfo.getCompanyCode(), machineInfo.getBalanceType(), machineInfo.getProdFeeStatus(), machineInfo.getAutoFeeStatus(), salesId, machineInfo.getShieldStatus(), machineInfo.getCode()), rowsOfPage);
			pageModel.setTotalPage(totalPage);
			pageModel.setUrl("/company!machineList.action");
			
			machineList = machineService.list(machineInfo.getCompanyCode(), machineInfo.getBalanceType(), machineInfo.getProdFeeStatus(), machineInfo.getAutoFeeStatus(), salesId, machineInfo.getShieldStatus(), (curPage - 1) * rowsOfPage, rowsOfPage, getCurUser().getMach(), machineInfo.getCode());
			CompanyInfo company = null;
			for(MachineInfo machine : machineList){
				company = companyService.getInfo(machine.getCompanyCode());
				if (company==null) {
					company = new CompanyInfo();
					company.setName("未知");
				}else {
					company.setUserInfo(userService.getInfo(company.getSalesId()));
				}
				machine.setCompany(company);
				machine.setProdFeeStatusStr(MachineInfo.getFeeStatus(machine.getProdFeeStatus()));
				machine.setAutoFeeStatusStr(MachineInfo.getFeeStatus(machine.getAutoFeeStatus()));
				machine.setBalanceStatus(MachineInfo.getBalanceStatus(machine.getBalanceStatus()));
				machine.setBalanceTypeStr(MachineInfo.getBalanceType(machine.getBalanceType()));
				machine.setShieldStatus(MachineInfo.getShieldStatus(machine.getShieldStatus()));			
			}		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "machineList";
	}*/
	
	/**
	 * 厂家促销金管理
	 * @return
	 */
	/*public String profitManager(){
		UserInfo curUser = getCurUser();		
		String manuCode = curUser.getCompany().getCode();
		machineList = machineService.list(manuCode, curUser.getMach(), curUser.getBrandIdStr());
		this.setPageTitle("促销金管理");
		return "profitManager";
	}*/
	
	/*public String addMachine(){
		try{
			companyList = companyService.list(Constants.COMPANY_TYPE_MANU, 0, 0, 10000);
		//	productList = productService.list();
			machineInfo = new MachineInfo();
			machineInfo.setRepotDay(ymdsdf.format(new Date()));
			provinceList = Initialize.provinceList;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "machine";
	}*/
	
	/*public String saveMachine(){
//		int mmmm = machineInfo.getIsPoint();
//		System.out.println(mmmm);
		try{
			int[] temp = machineInfo.getPids();
			if(temp != null){
				String pids = "";
				int len = temp.length;
				if(len > 0){				
					for(int i = 0; i < len; i++){
						pids += temp[i] + ",";
					}
				}
				if(!StringUtil.isNull(pids)){
					pids = pids.substring(0, pids.length() - 1);
					machineInfo.setPidsStr(pids);
				}				
			}
			int[] temp2 = machineInfo.getFeeTypeIds();
			if(temp2 != null){
				String ids = ",";
				int len = temp2.length;
				if(len > 0){
					for(int i = 0; i < len; i++){
						ids += temp2[i] + ",";
					}
					machineInfo.setFeeTypeIdsStr(ids);
				}
			}
			
			if(pakFileName!=null)
			{
				String targetPath = ServletActionContext.getServletContext().getRealPath("/package");
				File file = new File(targetPath, pakFileName);
				copy(pak, file);
				machineInfo.setPakPath("/package/" + pakFileName);
			}
			int machineId = machineService.insert(machineInfo);
			
			log.info("ADD MACHINE BY USER " + getCurUser().getName() + ", MACHINE CODE " + machineInfo.getCode() + ", COMPANY CODE " + machineInfo.getCompanyCode());
			String[] prods = machineInfo.getProds();		
			if(prods != null && prods.length > 0){
				MachineProdExplainInfo explainInfo = null;			
				for(int i = 0; i < prods.length; i++){
					//增加机型产品配置映射,产品单价,产品计费周期,资费说明,提示方式等.
					explainInfo = new MachineProdExplainInfo();
					explainInfo.setMachineId(machineId);
					explainInfo.setProdCode(prods[i]);
					switch(Integer.parseInt(prods[i])){
					case 100:
						explainInfo.setPrice(Constants.DEFAULT_PROD_PRICE);
						explainInfo.setFeeCycle(Constants.DEFAULT_FEE_CYCLE);
						explainInfo.setFeeExplain("");
						explainInfo.setFeeExplainStatus("N");	
						explainInfo.setDailyUserLimit(Constants.DEFAULT_AUTO_USER_DAILY_LIMIT);
						explainInfo.setMonthlyUserLimit(Constants.DEFAULT_AUTO_USER_MONTHLY_LIMIT);					
						break;				
					}				
					explainInfo.setProdExplain("");
					explainInfo.setLinkDays(Constants.DEFAULT_AUTO_LINKDAYS);   //默认联网日期每月2,12,22号
					explainInfo.setLinkHours(Constants.DEFAULT_AUTO_LINKHOURS);   //默认联网周期：待机24小时
					explainService.insert(explainInfo);			
				}
				jumpInfo = null;
				explainInfo = null;
				log.info("ADD MACHINE PROD MAPPING AND MACHINE JUMP URL");
			}
			prods = null;
			/////////////////////////////////////////2012-05-31增加，添加到appuubackup的内存中/////////////////////////
	//		URLUtil.callURL(appUrl);
			URLUtil.callURL(appUrl2);
			URLUtil.callURL(bappUrl2);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "list";
	}*/
	
	/*public String toUpdateMachine(){
		//productList = productService.list();
		machineInfo = machineService.getInfo(machineInfo.getIntId());
		explainList = explainService.list(machineInfo.getIntId());
		if(explainList != null && explainList.size() > 0){
			String[] prods = new String[explainList.size()];
			for(int i = 0; i < explainList.size(); i++){
				prods[i] = explainList.get(i).getProdCode();
			}
			machineInfo.setProds(prods);
			machineInfo.setCompany(companyService.getInfo(machineInfo.getCompanyCode()));
		}
		provinceList = Initialize.provinceList;
		String pidsStrs = machineInfo.getPidsStr();		
		if(!StringUtil.isNull(pidsStrs)){
			String [] temp = pidsStrs.split(",");
			int[] pids = new int[temp.length];
			for(int i = 0; i < temp.length; i++){
				pids[i] = Integer.parseInt(temp[i]);
			}
			machineInfo.setPids(pids);
		}
		String ids = machineInfo.getFeeTypeIdsStr();
		if(!StringUtil.isNull(ids)){
			if(ids.startsWith(","))
				ids = ids.substring(1, ids.length());
			String[] temp = ids.split(",");
			int[] fids = new int[temp.length];
			for(int i = 0; i < temp.length; i++){
				fids[i] = Integer.parseInt(temp[i]);
			}
			machineInfo.setFeeTypeIds(fids);
		}
		explainList = null;
		getRequest().setAttribute("isPoint", machineInfo.getIsPoint());
		return "updateMachine";
	}*/
	
	/*public String updateMachine(){
		System.out.println(machineInfo.getIsPoint());
		if(machineInfo != null){
//			machineInfo = machineService.getInfo(machineInfo.getIntId());
			int[] temp = machineInfo.getPids();
			if(temp != null){
				String pids = "";
				int len = temp.length;
				if(len > 0){				
					for(int i = 0; i < len; i++){
						pids += temp[i] + ",";
					}
				}
				if(!StringUtil.isNull(pids)){
					pids = pids.substring(0, pids.length() - 1);
					machineInfo.setPidsStr(pids);
				}				
			}
			int[] temp2 = machineInfo.getFeeTypeIds();
			if(temp2 != null){
				String ids = ",";
				int len = temp2.length;
				if(len > 0){
					for(int i = 0; i < len; i++){
						ids += temp2[i] + ",";
					}
					machineInfo.setFeeTypeIdsStr(ids);
				}
			}
			if(pakFileName!=null){
				String targetPath = ServletActionContext.getServletContext().getRealPath("/package");
				File file = new File(targetPath, pakFileName);
				copy(pak, file);
				machineInfo.setPakPath("/package/" + pakFileName);
			}
			try {
				machineService.update(machineInfo, getCurUser());
			} catch (Exception e) {
				e.printStackTrace();
			}
			log.info("UPDATE MACHINE BY USER " + getCurUser().getName() + ", MACHINE CODE " + machineInfo.getCode() + ", COMPANY CODE " + machineInfo.getCompanyCode());
		}
		/////////////////////////////////////////2012-05-31增加，添加到appuubackup的内存中/////////////////////////
//		URLUtil.callURL(appUrl);
		URLUtil.callURL(appUrl2);
		URLUtil.callURL(bappUrl2);
		return "list";
	}*/
	protected HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	/*public String updateProfit(){
		if(machineInfo != null){
			int mid = machineInfo.getIntId();
			String profitStr = getRequest().getParameter("profit" + mid);
			if(StringUtil.isNumeric(profitStr)){
				float profit = Float.parseFloat(profitStr);
				machineInfo = machineService.getInfo(mid);
				machineInfo.setProfit(profit);
				machineService.update(machineInfo, getCurUser());
			}
		}		
		return "profitManager";
	}*/
	
	//////////////////////机型产品配置////////////////////////////
	
	/*public String listMacProd(){
//		int machineId = Integer.parseInt(getRequest().getParameter("id"));
		try{
			int machineId = machineInfo.getIntId();
			explainList = explainService.list(machineId);
			for(MachineProdExplainInfo info : explainList){
				info.setCompany(companyService.getByMachineId(info.getMachineId()));
			//	info.setProduct(productService.getInfo(info.getProdCode()));
				info.setMachine(machineService.getInfo(info.getMachineId()));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "listMacProd";
	}
	public String macProd(){
		int machineId = machineInfo.getIntId();
		explainben = explainService.getById(prodid);
		
		String pidsStrs = explainben.getShieldPids();		
		if(!StringUtil.isNull(pidsStrs)){
			String [] temp = pidsStrs.split(",");
			int[] pids = new int[temp.length];
			for(int i = 0; i < temp.length; i++){
				pids[i] = Integer.parseInt(temp[i]);
			}
			explainben.setPids(pids);
		}
		provinceList = Initialize.provinceList;
		return SUCCESS;
	}*/
	/*public String updatemacProd(){
		int machineId = machineInfo.getIntId();
		//explainben = explainService.getById(prodid);
		
		
		int[] temp = explainben.getPids();
		if(temp != null){
			String pids = "";
			int len = temp.length;
			if(len > 0){				
				for(int i = 0; i < len; i++){
					pids += temp[i] + ",";
				}
			}
			if(!StringUtil.isNull(pids)){
				pids = pids.substring(0, pids.length() - 1);
				explainben.setShieldPids(pids);
			}				
		}
		
		
		explainService.updateIsopen(explainben);
		
		URLUtil.callURL(appUrl2);
		URLUtil.callURL(bappUrl2);

		return SUCCESS;
	}*/
	
	/*public String updateMacProd(){		
		MachineProdExplainInfo explainInfo = new MachineProdExplainInfo();
		HttpServletRequest req = getRequest();
		int id = Integer.parseInt(req.getParameter("id"));		
		explainInfo.setIntId(id);
		explainInfo.setFeeExplain(req.getParameter("feeExplain" + id));
		explainInfo.setProdExplain(req.getParameter("prodExplain" + id));
		explainInfo.setPrice(Float.parseFloat(req.getParameter("price" + id)));
//		explainInfo.setFeeCycle(Integer.parseInt(req.getParameter("feeCycle" + id)));
		explainInfo.setFeeExplainStatus(req.getParameter("feeExplainStatus" + id));
		String dailyUserLimit = req.getParameter("userDailyLimit" + id);
		explainInfo.setDailyUserLimit(dailyUserLimit == null ? 0 : Float.parseFloat(dailyUserLimit));
		String monthlyUserLimit = req.getParameter("userMonthlyLimit" + id);
		explainInfo.setMonthlyUserLimit(monthlyUserLimit == null ? 0 : Float.parseFloat(monthlyUserLimit));
		explainInfo.setLinkDays(req.getParameter("linkDays" + id));
		String linkHoursStr = req.getParameter("linkHours" + id);
		explainInfo.setLinkHours(linkHoursStr == null ? 24 : Integer.parseInt(linkHoursStr));   //联网间隔时间 默认为待机24小时
		
		MachineProdExplainInfo old = explainService.getById(id);   //取得旧记录(一定要在更新操作之前)
		
		explainService.update(explainInfo);
		
		log.info("UPDATE MACHINE PROD SET BY USER " + getCurUser().getName() + " ID " + id);
		log.info("QUONDAM SET PRICE->" + old.getPrice() + ",FEE CYCLE->" + old.getFeeCycle() + ",FEE EXPLAIN STATUS->" + old.getFeeExplainStatus() + ",DAILY USER LIMIT->" + old.getDailyUserLimit() + ",MONTHLY USER LIMIT->" + old.getMonthlyUserLimit());
		old = null;
		
		/////////////////////////////////////////2012-05-31增加，添加到appuubackup的内存中/////////////////////////
//		URLUtil.callURL(appUrl);
		URLUtil.callURL(appUrl2);
		URLUtil.callURL(bappUrl2);
		return "list";
	}*/
	
	
	///////////////////////////////////////////品牌管理///////////////////////////////////////////
	/*public String BrandManager(){
		try{
			this.userInfo = getCurUser();
			String manuCode = this.userInfo.getCompany().getCode();
			machineList = machineService.list(manuCode, this.userInfo.getMach(), userInfo.getBrandIdStr());
			
			brandList = companyService.brandList(manuCode);
			for(CompanyBrandInfo brand : brandList){
				brand.setMachineList(machineService.list(brand.getIntId(), userInfo.getMach(), userInfo.getBrandIdStr(), manuCode));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		this.setPageTitle("品牌管理");
		return "brandManager";
	}*/
	
	
	
	/*public void saveBrand(){
		try{
			if(brandInfo != null){
				userInfo = getCurUser();
				brandInfo.setCompanyCode(userInfo.getCompany().getCode());
				brandInfo.setUid(userInfo.getIntId());
				int brandId = companyService.saveBrand(brandInfo);
				this.printString(String.valueOf(brandId), Constants.HTML_CONTENT_TYPE);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String deleteBrand(){
		if(brandInfo != null){
			userInfo = getCurUser();
			brandInfo.setCompanyCode(userInfo.getCompany().getCode());
			brandInfo.setUid(userInfo.getIntId());
			int flag = companyService.deleteBrand(brandInfo);
			if(flag > 0){
				companyService.updateMachineBrand(userInfo.getCompany().getCode(), brandInfo.getIntId());
			}
		}
		return "brandManager";
	}
	
	public void updateBrand(){
		if(brandInfo != null){
			userInfo = getCurUser();
			brandInfo.setCompanyCode(userInfo.getCompany().getCode());
			brandInfo.setUid(userInfo.getIntId());
			companyService.updateBrand(brandInfo);
		}
	}
	
	public String toUpdateBrand(){
		if(brandInfo != null)
			brandInfo = companyService.getBrand(brandInfo.getIntId(), getCurUser().getCompany().getCode());
		this.setPageTitle("修改品牌");
		return "updateBrand";
	}*/
	
	public String toCreateBrand(){		
		this.setPageTitle("添加品牌");
		return "createBrand";
	}
	
	/*public String updateMachineBrand(){
		try{
			String mids = "";
			int[] ids = brandInfo.getMids();
			for(int i = 0; i < ids.length; i++){
				mids += ids[i] + ",";
			}
			if(!StringUtil.isNull(mids))
				mids = mids.substring(0, mids.length() -1);
			else
				mids = "0";
			companyService.updateMachineBrand(getCurUser().getCompany().getCode(), mids, brandInfo.getIntId());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "brandManager";
	}*/
	///////////////////////////////////////////旧版品牌管理结束///////////////////////////////////////////
	
	
	
	///////////////////////////////////////////新版树形品牌管理，树列表///////////////////////////////////////////
	/*public void BrandTree(){		
		try{			
			String nodeIdStr = getRequest().getParameter("node");			
			this.userInfo = getCurUser();
			String manuCode = this.userInfo.getCompany().getCode();
			
//			manuCode = "1043";
			
			brandList = companyService.brandList(manuCode);
			CompanyBrandInfo b = new CompanyBrandInfo();
			b.setName("未归类机型");
			b.setIntId(0);
			brandList.add(b);
			
			String result = "[";
			if("-1".equals(nodeIdStr)){
				for(CompanyBrandInfo brand : brandList){
					if(brand.getIntId() != 0){
						result += "{id:'" + brand.getIntId() + "', text: '" + brand.getName() + "', singleClickExpand:true, qtip:'选中我，再单击我修改名称'},";
					}else{
						result += "{id:'" + brand.getIntId() + "', text: '" + brand.getName() + "', singleClickExpand:true},";
					}
				}
			}else{				
				int brandId = 0;				
				for(CompanyBrandInfo brand : brandList){
					if(!StringUtil.isNull(nodeIdStr)){
						brandId = Integer.parseInt(nodeIdStr);
						if(brand.getIntId() == brandId)
							break;
					}
				}
				List<MachineInfo> mList = machineService.list(brandId, userInfo.getMach(), userInfo.getBrandIdStr(), manuCode);
				for(MachineInfo m : mList){
					result += "{id:'" + m.getIntId() + "', text: '" + m.getCode() + "', singleClickExpand:true, leaf:true, qtip:'拖动我就可以归类', icon:'/images/machine.gif'},";
				}
			}
			result = result.replace("null", "");
			if(!result.equals("["))
				result = result.substring(0, result.lastIndexOf(","));
			result += "]";
			this.printString(result, Constants.HTML_CONTENT_TYPE);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	///新版机型归类到品牌
/*	public void classifyMachineToBrand(){
		HttpServletRequest req = getRequest();
		try{			
			String machineId = req.getParameter("machineId");
			String brandId = req.getParameter("brandId");			
			if(!StringUtil.isNull(machineId) && !StringUtil.isNull(brandId)){
				companyService.updateMachineBrand(getCurUser().getCompany().getCode(), machineId, Integer.parseInt(brandId));				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}*/
	
	
	
	////////////////////////////////////////////////新版机型品牌管理结束///////////////////////////////////////////////////////
	
	public void prepare() throws Exception {
		
		this.clearMessages();
	}

	public File getPak() {
		return pak;
	}

	public void setPak(File pak) {
		this.pak = pak;
	}

	public String getPakContentType() {
		return pakContentType;
	}

	public void setPakContentType(String pakContentType) {
		this.pakContentType = pakContentType;
	}

	public String getPakFileName() {
		return pakFileName;
	}

	public void setPakFileName(String pakFileName) {
		this.pakFileName = pakFileName;
	}	
	
}
