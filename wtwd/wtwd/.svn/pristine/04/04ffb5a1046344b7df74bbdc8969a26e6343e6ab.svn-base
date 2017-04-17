package com.cncoman.product.action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.cncoman.product.bean.CompanyInfo;


import com.cncoman.product.bean.VersionInfo;
import com.cncoman.product.bean.VersionManage;
import com.cncoman.product.bean.VersionProduct;
import com.cncoman.product.biz.IVersionProductService;
import com.cncoman.product.util.Constants;
import com.cncoman.product.util.Initialize;
import com.cncoman.product.bean.PageControlModel;
import com.cncoman.product.bean.ProvinceInfo;
import com.cncoman.product.util.StringUtil;

public class CustomerServiceAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private File bigIcon;
	
	private String bigIconContentType;

	private String bigIconFileName;
	
	private File icon;
	
	private String contentType;

	private String iconFileName;
	
	private File apk;
	
	private String apkContentType;
	
	private String apkFileName;

	private ProvinceInfo provinceInfo;

	private File upload;

	private String uploadContentType;

	private String uploadFileName;

	private String CKEditorFuncNum;

	private String CKEditor;

	/*private CustomerServiceAdvInfo advInfo;

	private List<CustomerServiceAdvInfo> advList;
	*/
	private List<VersionInfo> versionInfo;
	
	private List<VersionManage> versionManage;
	
	private List<VersionProduct> versionProduct;
	private VersionProduct versionProductbean;
	
	private  VersionInfo versionbean;
	


/*	private ICustomerServiceAdvService advService;
	*/
	private IVersionProductService  versionServ;
	
	private String code="1000";
	
	private String issue;
	
	private String remark;
	
	private int ptype;
	
	private String productName;
	
	private String vname;
	
	private String versionId;
	
	private int vid;
	
	private int id;
	
	private String ver;
	
	private String machCode;
	
	private String explain;   //公司内部所见版本说明˵��
	
	private VersionManage vm;

/*
	// /////////////////////////////////销售网络开始//////////////////////////////////
	public String saleNetWorkList() {
		if (saleNetWorkInfo == null) {
			saleNetWorkInfo = new SaleNetWorkInfo();
			saleNetWorkInfo.setPid(61);
			saleNetWorkInfo.setCid(199);
		}
		saleNetWorkList = customerService.saleNetWorkList(saleNetWorkInfo
				.getPid(), saleNetWorkInfo.getCid(), getCurUser().getCompany()
				.getCode());
		this.fullProvinceCityMap();
		this.setPageTitle("销售网络");
		return "saleNetWorkList";
	}

	public String toCreateSaleNetWork() {
		this.fullProvinceCityMap();
		this.setPageTitle("添加网点");
		return "saveSaleNetWork";
	}

	public String saveSaleNetWork() {
		if (saleNetWorkInfo != null) {
			if (saleNetWorkInfo.getPid() == 0) {
				this.addActionMessage("请选择省份!");
				return "saveSaleNetWork";
			}
			if (saleNetWorkInfo.getCid() == 0) {
				this.addActionMessage("请选择城市!");
				return "saveSaleNetWork";
			}
			if (StringUtil.isNull(saleNetWorkInfo.getName())) {
				this.addActionMessage("服务网点名称不能为空!");
				return "saveSaleNetWork";
			}
			if (StringUtil.isNull(saleNetWorkInfo.getAdd())) {
				this.addActionMessage("服务网点地址不能为空!");
				return "saveSaleNetWork";
			}
			saleNetWorkInfo.setCompanyCode(getCurUser().getCompany().getCode());
			customerService.saveSaleNetWork(saleNetWorkInfo);
		}
		return "saleNetWorkList";
	}

	public String deleteSaleNetWork() {
		if (saleNetWorkInfo != null) {
			saleNetWorkInfo.setCompanyCode(getCurUser().getCompany().getCode());
			customerService.deleteSaleNetWork(saleNetWorkInfo);
		}
		return "saleNetWorkList";
	}

	public String toModifySaleNetWork() {
		saleNetWorkInfo = customerService.getSaleNetWork(saleNetWorkInfo
				.getIntId(), getCurUser().getCompany().getCode());
		this.setPageTitle("修改网点");
		this.fullProvinceCityMap();
		return "updateSaleNetWork";
	}

	public String updateSaleNetWork() {
		if (saleNetWorkInfo != null) {
			if (saleNetWorkInfo.getPid() == 0) {
				this.addActionMessage("请选择省份!");
				return "updateSaleNetWork";
			}
			if (saleNetWorkInfo.getCid() == 0) {
				this.addActionMessage("请选择城市!");
				return "updateSaleNetWork";
			}
			if (StringUtil.isNull(saleNetWorkInfo.getName())) {
				this.addActionMessage("服务网点名称不能为空!");
				return "updateSaleNetWork";
			}
			if (StringUtil.isNull(saleNetWorkInfo.getAdd())) {
				this.addActionMessage("服务网点地址不能为空!");
				return "updateSaleNetWork";
			}
			saleNetWorkInfo.setCompanyCode(getCurUser().getCompany().getCode());
			customerService.updateSaleNetWork(saleNetWorkInfo);
		}
		return "saleNetWorkList";
	}

	// wap页面省份列表
	public String provinceList() {
		provinceList = Initialize.provinceList;
		companyInfo = companyService.getInfo(saleNetWorkInfo.getCompanyCode());
		return "provinceList";
	}*/

	// wap页面省份列表
	public String cityList() {
	//	cityList = provinceService.cityList(saleNetWorkInfo.getPid());
		return "cityList";
	}

	/*// wap页面售后网点列表
	public String saleNetWorks() {
		// System.out.println("at saleNetWorks session manu : ------>" +
		// this.getJumpUserCompanyCode());
		saleNetWorkList = customerService.saleNetWorkList(saleNetWorkInfo
				.getPid(), saleNetWorkInfo.getCid(), saleNetWorkInfo
				.getCompanyCode());
		companyInfo = companyService.getInfo(saleNetWorkInfo.getCompanyCode());
		provinceInfo = Initialize.provinceMap.get(saleNetWorkInfo.getPid());
		return "saleNetWorks";
	}

	// wap页面网点详细信息
	public String saleNetWork() {
		saleNetWorkInfo = customerService.getSaleNetWork(saleNetWorkInfo
				.getIntId(), saleNetWorkInfo.getCompanyCode());
		return "saleNetWork";
	}
*/
	// /////////////////////////////////销售网络结束//////////////////////////////////

	// /////////////////////////////////意见反馈开始//////////////////////////////////
	/*public String opinionList() {
		companyList = companyService.list(Constants.COMPANY_TYPE_MANU);

		pageModel = pageModel == null ? new PageControlModel() : pageModel;
		if (opinionInfo == null) {
			opinionInfo = new OpinionInfo();
			return "opinionList";
		}
		int curPage = pageModel.getCurPage();
		int rowsOfPage = pageModel.getRowsOfPage();
		try {
			int totalPage = pageModel.getTotalPage(customerService
					.opinionCount(opinionInfo.getKeyWord(), opinionInfo
							.getFromDay(), opinionInfo.getToDay(), machineInfo
							.getCompanyCode()), rowsOfPage);
			pageModel.setTotalPage(totalPage);
			pageModel.setUrl("/opinionList");
			opinionList = customerService.opinionList((curPage - 1)
					* rowsOfPage, rowsOfPage, opinionInfo.getKeyWord(),
					opinionInfo.getFromDay(), opinionInfo.getToDay(),
					machineInfo.getCompanyCode());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "opinionList";
	}

	public String delete() {
		try {
			customerService.delete(opinionInfo);
			log.info("DELETE OPINION BY USER " + getCurUser().getName()
					+ " OPINION ID " + opinionInfo.getIntId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "list";
	}

	public String toCreateOpinion() {
		companyInfo = companyService.getInfo(opinionInfo.getCompanyCode());
		return "saveOpinion";
	}

	public String saveOpinion() {
		boolean flag = false;
		try {
			if (opinionInfo != null
					&& !StringUtil.isNull(opinionInfo.getOpinion())) {
				String companyCode = opinionInfo.getCompanyCode();
				if (StringUtil.isNull(companyCode))
					opinionInfo.setCompanyCode("1000");
				PersonInfo person = opinionInfo.getPersonInfo();
				String ageStr = person.getAgeStr();
				int age = 0;
				if (!StringUtil.isNull(ageStr)) {
					if (StringUtil.isNumeric(ageStr)) {
						age = Integer.parseInt(ageStr);
					}
				}
				person.setAge(age);
				opinionInfo.setPersonInfo(person);
				flag = customerService.saveOpinion(opinionInfo);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (flag)
			return "saveOpinionOK";
		return "saveOpinionFail";
	}
*/
	// public String deleteOpinion() {
	// try{
	// if (opinionInfo != null) {
	// opinionInfo.setCompanyCode(getCurUser().getCompany().getCode());
	// customerService.deleteOpinion(opinionInfo);
	// }
	// }catch(Exception ex){
	// ex.printStackTrace();
	// }
	// return "opinionList";
	// }

	/*public String getOpinion() {
		opinionInfo = customerService.getOpinion(opinionInfo.getIntId(),
				getCurUser().getCompany().getCode());
		return "opinionInfo";
	}

	// /////////////////////////////////意见反馈结束//////////////////////////////////

	// /////////////////////////////////////////使用技巧////////////////////////////////////////////

	public String tipsList() {
		// TODO Auto-generated method stub
		pageModel = pageModel == null ? new PageControlModel() : pageModel;
		if (tipsInfo == null) {
			tipsInfo = new TipsInfo();
		}
		String companyCode = getCurUser().getCompany().getCode();
		int curPage = pageModel.getCurPage();
		int rowsOfPage = pageModel.getRowsOfPage();
		int totalPage = pageModel.getTotalPage(customerService.countTips(
				companyCode, tipsInfo.getKeyWord()), rowsOfPage);
		pageModel.setTotalPage(totalPage);
		pageModel.setUrl("/tipsList");
		tipsList = customerService.tipsList(companyCode, tipsInfo.getKeyWord(),
				(curPage - 1) * rowsOfPage, rowsOfPage);

		this.setPageTitle("技巧列表");
		return "tipsList";
	}

	public String toModifyTips() {
		tipsInfo = customerService.getTips(tipsInfo.getIntId(), getCurUser()
				.getCompany().getCode());
		this.setPageTitle("修改技巧");
		return "updateTips";
	}

	public String updateTips() {
		if (tipsInfo != null) {
			if (StringUtil.isNull(tipsInfo.getName())) {
				this.addActionMessage("标题不能为空！");
				return "updateTips";
			}
			if (StringUtil.isNull(tipsInfo.getName())) {
				this.addActionMessage("内容不能为空！");
				return "updateTips";
			}
			tipsInfo.setCompanyCode(getCurUser().getCompany().getCode());
			customerService.updateTips(tipsInfo);
		}
		tipsInfo = null;
		return "tipsList";
	}*/

	public String toCreateTips() {
		this.setPageTitle("添加技巧");
		return "saveTips";
	}

	/*public String saveTips() {
		if (tipsInfo != null) {
			if (StringUtil.isNull(tipsInfo.getName())) {
				this.addActionMessage("标题不能为空！");
				return "saveTips";
			}
			if (StringUtil.isNull(tipsInfo.getName())) {
				this.addActionMessage("内容不能为空！");
				return "saveTips";
			}
			tipsInfo.setCompanyCode(getCurUser().getCompany().getCode());
			customerService.saveTips(tipsInfo);
		}
		tipsInfo = null;
		return "tipsList";
	}

	public String deleteTips() {
		if (tipsInfo != null) {
			tipsInfo.setCompanyCode(getCurUser().getCompany().getCode());
			customerService.deleteTips(tipsInfo);
		}
		return "tipsList";
	}

	// wap视角列表
	public String wapTipsList() {
		tipsList = customerService.tipsList(tipsInfo.getCompanyCode(), null, 0,
				1000);
		companyInfo = companyService.getInfo(tipsInfo.getCompanyCode());
		return "wapTipsList";
	}

	// wap视角技巧详细信息
	public String getTips() {
		tipsInfo = customerService.getTips(tipsInfo.getIntId(), tipsInfo
				.getCompanyCode());
		return "tipsInfo";
	}*/

	// /////////////////////////////////////////使用技巧结束//////////////////////////////////////////////

	// ///////////////////////////////////////公司客服中心图标及联系方式////////////////////////////////////
	public String getIconAndContact() {
		companyInfo = Initialize.companyMap.get(getCurUser().getCompany()
				.getCode());
		this.setPageTitle("修改图标");
		return "updateIconAndContact";
	}

	// ************更新完毕后要更新Initialize的companyMap********************//
	public void updateCompanyIconAndContact() {
		try {
			CompanyInfo c = Initialize.companyMap.get(getCurUser().getCompany()
					.getCode());
			if (!StringUtil.isNull(iconFileName)) {
				String suffixs = ".jpg.png.bmp.gif.jpeg";
				if (suffixs.indexOf(getExtention(iconFileName).toLowerCase()) < 0) {
					this.addActionMessage("请选择正确的图片格式，例如：bmp,png,gif,jpg图片");
					getResponse().sendRedirect("/toModifyIcon");
					return;
				}

				iconFileName = new Random().nextInt(100000)
						+ getExtention(iconFileName);
				String path = ServletActionContext.getServletContext()
						.getRealPath(Constants.ICON_PATH);
				File imageFile = new File(path + "/" + iconFileName);
				copy(icon, imageFile);

				c.setIcon(Constants.ICON_PATH + iconFileName);
			}

			c.setContactInfo(companyInfo.getContactInfo());
			c.setBrandInfo(companyInfo.getBrandInfo());
			c.setService(companyInfo.getService());
			c.setBottomWord(companyInfo.getBottomWord());
			c.setWapTitle(companyInfo.getWapTitle());
			int ret = companyService.updateIconAndContact(c);
			if (ret > 0) {
				c.setIcon(c.getIcon());
				Initialize.companyMap.put(c.getCode(), c);
			}
			getResponse().sendRedirect("/toModifyIcon");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// //////////////////////////////////////公司图标及联系方式结束////////////////////////////////////////////

	// /////////////////////////////////////新机上市开始////////////////////////////////////////////////////
/*	public String customerMachineList() {
		customerMachineList = customerService.customerMachineList(getCurUser()
				.getCompany().getCode());
		this.setPageTitle("新机上市");
		return "customerMachineList";
	}

	public String toUpdateCustomerMachineInfo() {
		customerMachineInfo = customerService.getCustomerMachineInfo(
				getCurUser().getCompany().getCode(), customerMachineInfo
						.getIntId());
		this.setPageTitle("修改机型");
		return "updateCustomerMachineInfo";
	}

	public String toCreateCustomerMachineInfo() {

		this.setPageTitle("添加机型");
		return "saveCustomerMachineInfo";
	}

	public void updateCustomerMachineInfo() {
		try {
			HttpServletResponse res = getResponse();
			if (customerMachineInfo != null) {
				if (StringUtil.isNull(customerMachineInfo.getName())) {
					this.addActionMessage("机型名称不能为空!");
					res.sendRedirect("/toModifyCms");
					return;
				}
				if (!StringUtil.isNull(iconFileName)) {
					String suffixs = ".jpg.png.bmp.gif.jpeg";
					if (suffixs.indexOf(getExtention(iconFileName)
							.toLowerCase()) < 0) {
						this
								.addActionMessage("请选择正确的图片格式，例如：bmp,png,gif,jpg图片");
						res.sendRedirect("/toModifyCms");
						return;
					}

					iconFileName = new Random().nextInt(100000)
							+ getExtention(iconFileName);
					String path = ServletActionContext.getServletContext()
							.getRealPath(Constants.ICON_PATH);
					File imageFile = new File(path + "/" + iconFileName);
					copy(icon, imageFile);

					customerMachineInfo.setImg(Constants.ICON_PATH
							+ iconFileName);
				}
				customerMachineInfo.setCompanyCode(getCurUser().getCompany()
						.getCode());
				customerService.updateCustomerMachineInfo(customerMachineInfo);
			}
			res.sendRedirect("/cmsList");
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void saveCustomerMachineInfo() {
		try {
			HttpServletResponse res = getResponse();
			if (customerMachineInfo != null) {
				if (StringUtil.isNull(customerMachineInfo.getName())) {
					this.addActionMessage("机型名称不能为空!");
					res.sendRedirect("/createCms");
					return;
				}
				if (!StringUtil.isNull(iconFileName)) {
					String suffixs = ".jpg.png.bmp.gif.jpeg";
					if (suffixs.indexOf(getExtention(iconFileName)
							.toLowerCase()) < 0) {
						this
								.addActionMessage("请选择正确的图片格式，例如：bmp,png,gif,jpg图片");
						res.sendRedirect("/createCms");
						return;
					}

					iconFileName = new Random().nextInt(100000)
							+ getExtention(iconFileName);
					String path = ServletActionContext.getServletContext()
							.getRealPath(Constants.ICON_PATH);
					File imageFile = new File(path + "/" + iconFileName);
					copy(icon, imageFile);

					customerMachineInfo.setImg(Constants.ICON_PATH
							+ iconFileName);
				}
				customerMachineInfo.setCompanyCode(getCurUser().getCompany()
						.getCode());
				customerService.saveCustomerMachineInfo(customerMachineInfo);
			}
			res.sendRedirect("/cmsList");
			return;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String deleteCustomerMachineInfo() {
		customerService.deleteCustomerMachineInfo(customerMachineInfo
				.getIntId(), getCurUser().getCompany().getCode());
		return "customerMachineList";
	}*/

	// **************新机上市wap****************//
/*	public String wapMachineList() {
		customerMachineList = customerService
				.customerMachineList(customerMachineInfo.getCompanyCode());
		companyInfo = companyService.getInfo(customerMachineInfo
				.getCompanyCode());
		String marketDay = "";
		String[] ymd = null;
		for (CustomerMachineInfo m : customerMachineList) {
			marketDay = m.getMarketDay();
			if (!StringUtil.isNull(marketDay)) {
				ymd = marketDay.split("-");
				marketDay = ymd[0] + "年" + ymd[1] + "月";
			}
			m.setMarketDay(marketDay);
		}
		return "machines";
	}

	public String getCustomerMachine() {
		customerMachineInfo = customerService.getCustomerMachineInfo(
				customerMachineInfo.getCompanyCode(), customerMachineInfo
						.getIntId());
		String marketDay = customerMachineInfo.getMarketDay();
		if (!StringUtil.isNull(marketDay)) {
			String[] ymd = marketDay.split("-");
			marketDay = ymd[0] + "年" + ymd[1] + "月";
		} else {
			marketDay = "";
		}
		customerMachineInfo.setMarketDay(marketDay);
		return "machineInfo";
	}*/

	// /////////////////////////////////////新机上市结束////////////////////////////////////////////////////

	// ////////////////////////////////////////////保修查询_wap//////////////////////////////////////////////
	/*public String checkMachine() {
		saleDetailInfo = (SaleDetailInfo) getSession().getAttribute(
				Constants.SESSION_CUSTOMER_SALEDETAILINFO);
		if (saleDetailInfo != null) {
		//	saleDetailInfo = saleDetailService.getByIMEI(saleDetailInfo.getImei(), saleDetailInfo.getMan());
			// companyInfo = companyService.getInfo(saleDetailInfo.getMan());
		}
		return "checkMachine";
	}*/

	// ///////////////////////////////////////////保修查询_wap结束///////////////////////////////////////////

	// //////////////////////////////////////////////CKeditor上传图片////////////////////////////////////////
	public void uploadCKeditorImg() {
		PrintWriter out = null;
		File path = null;
		InputStream is = null;
		OutputStream os = null;
		Calendar c = null;
		Random r = null;
		try {
			c = Calendar.getInstance();
			r = new Random();
			out = getResponse().getWriter();
			String strPath = ServletActionContext.getServletContext()
					.getRealPath("/uploads");
			path = new File(strPath);
			if (!path.exists())
				path.mkdirs();

			is = new FileInputStream(this.upload);
			String suffix = getExtention(uploadFileName);
			String newFileName = "" + c.get(Calendar.HOUR_OF_DAY)
					+ c.get(Calendar.MINUTE) + c.get(Calendar.SECOND)
					+ r.nextInt(10000) + suffix;
			os = new FileOutputStream(new File(strPath + File.separator
					+ newFileName));
			int len;
			byte[] buffer = new byte[1024];
			while ((len = is.read(buffer)) > 0) {
				os.write(buffer, 0, len);
			}
			out
					.write("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
							+ this.CKEditorFuncNum
							+ ", 'http://www.data123.com.cn/uploads/"
							+ newFileName + "', '');</script>");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
					out = null;
				}
				path = null;
				if (is != null) {
					is.close();
					is = null;
				}
				if (os != null) {
					os.close();
					os = null;
				}
				c = null;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	// /////////////////////////////////////////////////////客服中心广告管理//////////////////////////////////////////////////////
	// ////////////////仅智能机上有此功能///////////////////////////////////////////
	// ////////////////联网仅取图片和文字////////////////////
	// ////////////////客服端指定一个不变的服务器地址，由服务器根据参数跳转////////////////////
	public String customerServiceAdvList() {
		try {
		//	if(advInfo != null)
		//		advList = advService.list(advInfo.getType());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "advList";
	}

	public String toAddAdvInfo() {
		companyList = companyService.list(0);
		return "toAddAdvInfo";
	}

/*	public String saveAdvInfo() {
		// 上传图片
		try {
		if(iconFileName!=null){
			String fileName = "small"+System.currentTimeMillis();
			String typeName = iconFileName.substring(iconFileName.indexOf("."), iconFileName.length());
			iconFileName = fileName+typeName;
			String targetPath = ServletActionContext.getServletContext()
				.getRealPath("/images/adverimage");
			File file = new File(targetPath, iconFileName);
			FileUtils.copyFile(icon, file);
			advInfo.setIcon1("/images/adverimage/" + iconFileName);
		}
		if(bigIconFileName!=null){
			String fileName = "big"+System.currentTimeMillis();
			String typeName = bigIconFileName.substring(bigIconFileName.indexOf("."), bigIconFileName.length());
			bigIconFileName = fileName+typeName;
			String targetPath = ServletActionContext.getServletContext()
				.getRealPath("/images/adverimage");
			File file = new File(targetPath, bigIconFileName);
			FileUtils.copyFile(bigIcon, file);
			advInfo.setBigIcon("/images/adverimage/" + bigIconFileName);
		}
		//	advService.saveAdvInfo(advInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "advList";
	}*/

	public String toUpdateAdvInfo() {
		companyList = companyService.list(0);
		//advInfo = advService.getAdveInfo(advInfo.getIntId());
		return "toupdateAdv";
	}

/*	public String updateAdvInfo() {

		// 上传图片
		try {
		if (iconFileName != null) {
			String fileName = "small"+System.currentTimeMillis();
			String typeName = iconFileName.substring(iconFileName.indexOf("."), iconFileName.length());
			iconFileName = fileName+typeName;
			String targetPath = ServletActionContext.getServletContext().getRealPath("/images/adverimage");
			File file = new File(targetPath, iconFileName);
			FileUtils.copyFile(icon, file);
			advInfo.setIcon1("/images/adverimage/" + iconFileName);
			
		}
		if(bigIconFileName!=null){
			String fileName = "big"+System.currentTimeMillis();
			String typeName = bigIconFileName.substring(bigIconFileName.indexOf("."), bigIconFileName.length());
			bigIconFileName = fileName+typeName;
			String targetPath = ServletActionContext.getServletContext().getRealPath("/images/adverimage");
			File file = new File(targetPath, bigIconFileName);
			FileUtils.copyFile(bigIcon, file);
			advInfo.setBigIcon("/images/adverimage/" + bigIconFileName);
		}
		// advService.updateAdvInfo(advInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		    
		return "advList";
	}*/

	public String deleteAdvInfo() {
	//	advService.deleteAdvInfo(advInfo.getIntId());
		return "advList";
	}
	/**客服中心访问统计查询*/
	/*public String getCordCount1(){		
		cordCountList = customerService.getCordCount1();		
		return "cordCount";
	}*/
	/**版本管理 */
	public String versionManage(){
		/*TODO*/
		int type=1;
		//companyList = companyService.list(Constants.COMPANY_TYPE_MANU);
		versionInfo=	versionService.versionlist(type);//版本
		
		
		pageModel = pageModel == null ? new PageControlModel() : pageModel;
		
		
		/*String companyCode = getCurUser().getCompany().getCode();*/
		int curPage = pageModel.getCurPage();
		int rowsOfPage = pageModel.getRowsOfPage();
		int totalPage = pageModel.getTotalPage(versionManageService.countManageInfo(issue, versionId, code,type), rowsOfPage);
		pageModel.setTotalPage(totalPage);
		pageModel.setUrl("/versionManage");
		
		versionManage=versionManageService.versionManagelist(issue, versionId, code,(curPage - 1) * rowsOfPage, rowsOfPage,type);
		
		return SUCCESS;
	}
	public String version() {
		/* TODO */
       int type=1;
		versionInfo = versionService.versionlist(type);//版本

		return SUCCESS;
	}
	public String addVerInfo(){
		try{
			 int type=1;
			VersionInfo verbean = new VersionInfo();
			verbean.setVer(ver);
			verbean.setRemark(remark);
			verbean.setExplain(explain);
			verbean.setType(type);
			if(versionService.save(verbean)>0){
				/* String add = "http://a.test.com.cn/cc";
					clearversion(add);
					String badd = "http://b.test.com.cn/cc";
					clearversion(badd);*/
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String addversion(){
		int type=1;
		companyList = companyService.list(Constants.COMPANY_TYPE_MANU);				
		/*for(CompanyInfo company : companyList){
			company.setMachList(machineService.list(company.getCode()));
		}*/
		versionInfo = versionService.versionlist(type);		
		return SUCCESS;
	}
	public String toaddversionproduct(){
		return SUCCESS;
	}
	public String addversionproduct(){
		VersionProduct verproduct=new VersionProduct();
		verproduct.setProductName(productName);
		verproduct.setRemark(remark);
		if(versionServ.save(verproduct)>0){
			
			/* String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
			
		}
		
		return SUCCESS;
	}
	public String updateversionproduct(){
		VersionProduct verproduct=new VersionProduct();
		verproduct.setId(id);
		verproduct.setProductName(productName);
		verproduct.setRemark(remark);
		if(versionServ.update(verproduct)>0){
			/* String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
		}
		
		return SUCCESS;
	}
	public String versionproductManger(){
		
		versionProduct=versionServ.list();/* TODO */
		
		return SUCCESS;
	}
	public String getversionproduct(){
	
		
		versionProductbean=versionServ.getInfo(id);
		
		
		return SUCCESS;
	}
	public String toUpdateCompanyVersion(){
		try{
		if(vm != null){			
			vm = versionManageService.getCompanyVersionInfo(vm.getId());
			/*if(vm != null){				
				HttpServletRequest req = getRequest();
				req.setAttribute("machList", machineService.list(vm.getCode()));
				req.setAttribute("mach", vm.getMach());
			}	*/		
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "toUpdateCompanyVersion";
	}
	
	public String updateCompanyVersion(){
		try{
			if(vm != null){
				/*String[] temp = getRequest().getParameterValues("machCode");
				String codeTemp = ",";
				for(int i = 0; i < temp.length; i++){
					codeTemp += temp[i] + ",";
				}			
				vm.setMach(codeTemp);*/
				if(versionManageService.update(vm)>0){
					
					/* String add = "http://a.www.test.cn/cc";
					clearversion(add);
					String badd = "http://a.www.test.cn/cc";
					clearversion(badd);*/
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	public void clearversion(String add){
		 String cmd="&CMDT=clearVersion";
		
		try{
		 URL url = new URL(add);
		 DataOutputStream out = null;
	     URLConnection httpUrlcon = (URLConnection) url.openConnection();
	     httpUrlcon.setDoOutput(true);
	     out = new DataOutputStream(httpUrlcon.getOutputStream());

	      byte[] uCmd = cmd.getBytes("UTF-8");
	      byte[] start = new byte[2];
	      start[0] = 00;
	      start[1] = 66;
	      out.write(start);
	      out.write(uCmd);
	      out.flush();
	      out.close();
	      DataInputStream dis = new DataInputStream(httpUrlcon.getInputStream());
	      dis.close();
	    
		}catch (Exception e) {
			
		}
	}
	
	public String getVerInfo(){
		versionbean=versionService.getById(vid);
		return SUCCESS;
	}
    public String saveVersionInfo() {
    	int type=1;

		try {

			/*if (StringUtil.isNull(code)) {
				this.addActionMessage("请选择客户！");				
				return INPUT;
			}*/
			
			/*if (StringUtil.isNull(machCode)) {			
				this.addActionMessage("请选择机型！");
				return INPUT;
			}*/

			VersionManage verbean = new VersionManage();
			if (!StringUtil.isNull(apkFileName)) {
				String suffixs = ".apk";
				if (suffixs.indexOf(getExtention(apkFileName).toLowerCase()) < 0) {
					this.addActionMessage("请选择正确的文件格式！");

					return INPUT;
				}

				apkFileName = new Random().nextInt(100000)
						+ getExtention(apkFileName);
				String path = ServletActionContext.getServletContext()
						.getRealPath(Constants.APK_PATH);

				path = path + "/" + code;
				File file = new File(path);
				if (!file.exists())
					file.mkdir();

				File imageFile = new File(path + "/" + apkFileName);

				copy(apk, imageFile);

				verbean.setPath(Constants.APK_PATH + "/" + code + "/"
						+ apkFileName);

				long fsize = 0;
				fsize = imageFile.length() / (long) 1024;

				verbean.setSize(fsize + "KB");
			}else{
				this.addActionMessage("请选择升级包！");
				return INPUT;
			}

	/*		verbean.setCode(code);
			String[] temp = getRequest().getParameterValues("machCode");
			String codeTemp = ",";
			for(int i = 0; i < temp.length; i++){
				codeTemp += temp[i] + ",";
			}			
			verbean.setMach(codeTemp);*/
			verbean.setIssue("0");
			verbean.setRemark(remark);
			verbean.setName(vname);
			verbean.setVersionId(versionId);
			verbean.setType(type);
		if(	versionManageService.save(verbean)>0){
			/* String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
		}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return SUCCESS;
	}
    public String updateVersion(){
    	
    	if(versionManageService.update(issue, vid)>0){
    		/* String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
    	}
    	return SUCCESS;
    }
    
    public String deleteVersion(){
    	if(versionManageService.delete(vid)>0){
    		/* String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
    	}
    	return SUCCESS;
    }
    
    public String updateVerInfo(){
    	
    	if(versionService.update(versionbean)>0){
    		/* String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
	}
    	return SUCCESS;
    }
    public String issusVersion(){
		
		return SUCCESS;
	}
    public String editVersion(){
		
		return SUCCESS;
	}
    
    
    /*osm*/
    
	public String sversionManage(){
		/*TODO*/
		int type=1;
		companyList = companyService.list(Constants.COMPANY_TYPE_MANU);
		versionInfo=	versionService.versionlist(type);//版本
		
		
		pageModel = pageModel == null ? new PageControlModel() : pageModel;
		
		
		String companyCode = getCurUser().getCompany().getCode();
		int curPage = pageModel.getCurPage();
		int rowsOfPage = pageModel.getRowsOfPage();
		int totalPage = pageModel.getTotalPage(versionManageService.countManageInfo(issue, versionId, code,type), rowsOfPage);
		pageModel.setTotalPage(totalPage);
		pageModel.setUrl("/sversionManage");
		
		versionManage=versionManageService.versionManagelist(issue, versionId, code,(curPage - 1) * rowsOfPage, rowsOfPage,type);
		
		return SUCCESS;
	}
	public String sversion() {
		/* TODO */
       int type=1;
		versionInfo = versionService.versionlist(type);//版本

		return SUCCESS;
	}
	public String saddVerInfo(){
		 int type=1;
		VersionInfo verbean = new VersionInfo();
		verbean.setVer(ver);
		verbean.setRemark(remark);
		verbean.setType(type);
		if(versionService.save(verbean)>0){
			/* String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
		}
		return SUCCESS;
	}
	
	public String saddversion(){
		int type=1;
		companyList = companyService.list(Constants.COMPANY_TYPE_MANU);
		 versionInfo=	versionService.versionlist(type);
		
		
		return SUCCESS;
	}
	public String sgetVerInfo(){
		versionbean=versionService.getById(vid);
		return SUCCESS;
	}
    public String ssaveVersionInfo() {
    	int type=1;

		try {

			if (StringUtil.isNull(code)) {
				this.addActionMessage("请选择客户！");
				return INPUT;
			}

			VersionManage verbean = new VersionManage();
			if (!StringUtil.isNull(apkFileName)) {
				String suffixs = ".apk";
				if (suffixs.indexOf(getExtention(apkFileName).toLowerCase()) < 0) {
					this.addActionMessage("请选择正确的文件格式！");

					return INPUT;
				}

				apkFileName = new Random().nextInt(100000)
						+ getExtention(apkFileName);
				String path = ServletActionContext.getServletContext()
						.getRealPath(Constants.APK_PATH);

				path = path + "/" + code;
				File file = new File(path);
				if (!file.exists())
					file.mkdir();

				File imageFile = new File(path + "/" + apkFileName);

				copy(apk, imageFile);

				verbean.setPath(Constants.APK_PATH + "/" + code + "/"
						+ apkFileName);

				long fsize = 0;
				fsize = imageFile.length() / (long) 1024;

				verbean.setSize(fsize + "KB");
			}

			verbean.setCode(code);
			verbean.setIssue("0");
			verbean.setRemark(remark);
			verbean.setName(vname);
			verbean.setVersionId(versionId);
			verbean.setType(type);
			if(versionManageService.save(verbean)>0){
				/* String add = "http://a.test.com.cn/cc";
					clearversion(add);
					String badd = "http://b.test.com.cn/cc";
					clearversion(badd);*/
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return SUCCESS;
	}
    public String supdateVersion(){
    	if(versionManageService.update(issue, vid)>0){
    		 /*String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
    	}
    	return SUCCESS;
    }
    
    public String sdeleteVersion(){
    	if(versionManageService.delete(vid)>0){
    		/* String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
    	}
    	return SUCCESS;
    }
    
    public String supdateVerInfo(){
    	if(versionService.update(versionbean)>0){
    		/* String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
    	}
    	return SUCCESS;
    }
    public String sissusVersion(){
		
		return SUCCESS;
	}
    public String seditVersion(){
		
		return SUCCESS;
	}
    
    
    
    
    
  /*product升级  s*/
    
	public String pversionManage(){
		/*TODO*/
	
		companyList = companyService.list(Constants.COMPANY_TYPE_MANU);
		versionInfo=	versionService.versionlist(ptype);//版本
		
		
		pageModel = pageModel == null ? new PageControlModel() : pageModel;
		
		
		String companyCode = getCurUser().getCompany().getCode();
		int curPage = pageModel.getCurPage();
		int rowsOfPage = pageModel.getRowsOfPage();
		int totalPage = pageModel.getTotalPage(versionManageService.countManageInfo(issue, versionId, code,ptype), rowsOfPage);
		pageModel.setTotalPage(totalPage);
		pageModel.setUrl("/sversionManage");
		
		versionManage=versionManageService.versionManagelist(issue, versionId, code,(curPage - 1) * rowsOfPage, rowsOfPage,ptype);
		
		return SUCCESS;
	}
	public String pversion() {
		/* TODO */
       //int type=1;
		versionInfo = versionService.versionlist(ptype);//版本

		return SUCCESS;
	}
	public String paddVerInfo(){
		// int type=1;
		VersionInfo verbean = new VersionInfo();
		verbean.setVer(ver);
		verbean.setRemark(remark);
		verbean.setType(ptype);
		
		if(versionService.save(verbean)>0){
			/* String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
		}
		return SUCCESS;
	}
	
	public String paddversion(){
		//int type=1;
		companyList = companyService.list(Constants.COMPANY_TYPE_MANU);
		 versionInfo=	versionService.versionlist(ptype);
		
		
		return SUCCESS;
	}
	public String pgetVerInfo(){
		versionbean=versionService.getById(vid);
		return SUCCESS;
	}
    public String psaveVersionInfo() {
    	//int type=1;

		try {
			String codepar="";
			if (StringUtil.isNull(code)) {
				//this.addActionMessage("请选择客户！");
				//return INPUT;
				 codepar="all";
			}else{
				codepar=code;
			}

			VersionManage verbean = new VersionManage();
			if (!StringUtil.isNull(apkFileName)) {
				String suffixs = ".apk";
				if (suffixs.indexOf(getExtention(apkFileName).toLowerCase()) < 0) {
					this.addActionMessage("请选择正确的文件格式！");

					return INPUT;
				}

				apkFileName = getDate()+new Random().nextInt(100000)
						+ getExtention(apkFileName);
				String path = ServletActionContext.getServletContext()
						.getRealPath(Constants.APK_PATH);

				path = path + "/" + codepar;
				File file = new File(path);
				if (!file.exists())
					file.mkdir();

				File imageFile = new File(path + "/" + apkFileName);

				copy(apk, imageFile);

				verbean.setPath(Constants.WEB_PATH+Constants.APK_PATH + "/" + codepar + "/"
						+ apkFileName);

				long fsize = 0;
				fsize = imageFile.length() / (long) 1024;

				verbean.setSize(fsize + "KB");
			}

			verbean.setCode(code);
			verbean.setIssue("0");
			verbean.setRemark(remark);
			verbean.setName(vname);
			verbean.setVersionId(versionId);
			verbean.setType(ptype);
			if(versionManageService.save(verbean)>0){
				/* String add = "http://a.test.com.cn/cc";
					clearversion(add);
					String badd = "http://b.test.com.cn/cc";
					clearversion(badd);*/
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return SUCCESS;
	}
	public static String getDate() {

		String time2;
		Calendar c = Calendar.getInstance();
		// c.add(Calendar.DAY_OF_MONTH, -1);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		// String endtime=formatter.format(c.getTime());

		time2 = formatter.format(c.getTime());

		return time2;
	}
    public String pupdateVersion(){
    	if(versionManageService.update(issue, vid)>0){
    		 /*String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
    	}
    	return SUCCESS;
    }
    
    public String pdeleteVersion(){
    	if(versionManageService.delete(vid)>0){
    	
    		/* String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
    	}
    	return SUCCESS;
    }
    
    public String pupdateVerInfo(){
    	if(versionService.update(versionbean)>0){
    		 /*String add = "http://a.test.com.cn/cc";
				clearversion(add);
				String badd = "http://b.test.com.cn/cc";
				clearversion(badd);*/
	}
    	return SUCCESS;
    }
    public String topaddVerInfo(){
    	return SUCCESS;
    }
    public String pissusVersion(){
		
		return SUCCESS;
	}
    public String peditVersion(){
		
		return SUCCESS;
	}
    
    /*product升级  e*/
    
    /**
     * 
     * @return
     */

  
	// ////////////////////////////////////////////////////////////分隔线///////////////////////////////////////////////////////

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public File getIcon() {
		return icon;
	}

	public void setIcon(File icon) {
		this.icon = icon;
	}

	public String getIconFileName() {
		return iconFileName;
	}

	public void setIconFileName(String iconFileName) {
		this.iconFileName = iconFileName;
	}

	public ProvinceInfo getProvinceInfo() {
		return provinceInfo;
	}

	public void setProvinceInfo(ProvinceInfo provinceInfo) {
		this.provinceInfo = provinceInfo;
	}

	public String getCKEditor() {
		return CKEditor;
	}

	public void setCKEditor(String editor) {
		CKEditor = editor;
	}

	public String getCKEditorFuncNum() {
		return CKEditorFuncNum;
	}

	public void setCKEditorFuncNum(String editorFuncNum) {
		CKEditorFuncNum = editorFuncNum;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<VersionInfo> getVersionInfo() {
		return versionInfo;
	}

	public File getApk() {
		return apk;
	}

	public void setApk(File apk) {
		this.apk = apk;
	}

	public String getApkContentType() {
		return apkContentType;
	}

	public void setApkContentType(String apkContentType) {
		this.apkContentType = apkContentType;
	}

	public String getApkFileName() {
		return apkFileName;
	}

	public void setApkFileName(String apkFileName) {
		this.apkFileName = apkFileName;
	}



	public void setVname(String vname) {
		this.vname = vname;
	}



	public List<VersionManage> getVersionManage() {
		return versionManage;
	}



	public void setVid(int vid) {
		this.vid = vid;
	}



	public String getIssue() {
		return issue;
	}



	public void setIssue(String issue) {
		this.issue = issue;
	}



	public void setVer(String ver) {
		this.ver = ver;
	}



	public VersionInfo getVersionbean() {
		return versionbean;
	}



	public void setVersionbean(VersionInfo versionbean) {
		this.versionbean = versionbean;
	}



/*	public ReferenceInfo getReferebean() {
		return referebean;
	}



	public void setReferebean(ReferenceInfo referebean) {
		this.referebean = referebean;
	}*/



	public String getExplain() {
		return explain;
	}



	public void setExplain(String explain) {
		this.explain = explain;
	}



	public String getMachCode() {
		return machCode;
	}



	public void setMachCode(String machCode) {
		this.machCode = machCode;
	}
	public VersionManage getVm() {
		return vm;
	}



	public void setVm(VersionManage vm) {
		this.vm = vm;
	}



	public void setCode(String code) {
		this.code = code;
	}

	

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

/*	public void setAdvService(ICustomerServiceAdvService advService) {
		this.advService = advService;
	}*/

/*	public CustomerServiceAdvInfo getAdvInfo() {
		return advInfo;
	}

	public void setAdvInfo(CustomerServiceAdvInfo advInfo) {
		this.advInfo = advInfo;
	}*/

/*	public List<CustomerServiceAdvInfo> getAdvList() {
		return advList;
	}

	public void setAdvList(List<CustomerServiceAdvInfo> advList) {
		this.advList = advList;
	}*/

	public IVersionProductService getVersionServ() {
		return versionServ;
	}

	public void setVersionServ(IVersionProductService versionServ) {
		this.versionServ = versionServ;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<VersionProduct> getVersionProduct() {
		return versionProduct;
	}

	public void setVersionProduct(List<VersionProduct> versionProduct) {
		this.versionProduct = versionProduct;
	}

	public VersionProduct getVersionProductbean() {
		return versionProductbean;
	}

	public void setVersionProductbean(VersionProduct versionProductbean) {
		this.versionProductbean = versionProductbean;
	}

	public int getPtype() {
		return ptype;
	}

	public void setPtype(int ptype) {
		this.ptype = ptype;
	}

	public File getBigIcon() {
		return bigIcon;
	}

	public void setBigIcon(File bigIcon) {
		this.bigIcon = bigIcon;
	}

	public String getBigIconContentType() {
		return bigIconContentType;
	}

	public void setBigIconContentType(String bigIconContentType) {
		this.bigIconContentType = bigIconContentType;
	}

	public String getBigIconFileName() {
		return bigIconFileName;
	}

	public void setBigIconFileName(String bigIconFileName) {
		this.bigIconFileName = bigIconFileName;
	}
}
