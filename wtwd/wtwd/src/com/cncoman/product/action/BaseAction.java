package com.cncoman.product.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/*import com.cncoman.product.bean.CommandInfo;
import com.cncoman.product.bean.CommandProvinceMapInfo;
import com.cncoman.product.bean.CompanyBrandInfo;*/
import com.cncoman.product.bean.CompanyInfo;
/*import com.cncoman.product.bean.CordCount;
import com.cncoman.product.bean.CustomerMachineInfo;
import com.cncoman.product.bean.IncomeInfo;
import com.cncoman.product.bean.IncomeStatInfo;
import com.cncoman.product.bean.JumpStatInfo;
import com.cncoman.product.bean.MOInfo;
import com.cncoman.product.bean.MachineInfo;
import com.cncoman.product.bean.MachineProdExplainInfo;
import com.cncoman.product.bean.MobileInfo;
import com.cncoman.product.bean.MobileSalesInfo;
import com.cncoman.product.bean.OpinionInfo;
import com.cncoman.product.bean.ProductInfo;
import com.cncoman.product.bean.ReqFeeDetailInfo;*/

/*import com.cncoman.product.bean.SaleDetailInfo;
import com.cncoman.product.bean.SaleNetWorkInfo;
import com.cncoman.product.bean.SaleStatInfo;
import com.cncoman.product.bean.SendCmdAndMOInfo;
import com.cncoman.product.bean.SendCmdDetailInfo;
import com.cncoman.product.bean.SmsCatInfo;
import com.cncoman.product.bean.TipsInfo;*/
import com.cncoman.product.bean.UserInfo;
import com.cncoman.product.bean.VersionInfo;
/*import com.cncoman.product.biz.ICommandProvinceMapService;
import com.cncoman.product.biz.ICommandService;*/
import com.cncoman.product.biz.ICompanyService;
import com.cncoman.product.biz.ICustomerService;
/*import com.cncoman.product.biz.IIncomeService;*/


/*import com.cncoman.product.biz.IMachineProdExplainService;
import com.cncoman.product.biz.IMachineService;
import com.cncoman.product.biz.IMobileService;*/
/*import com.cncoman.product.biz.IProductService;*/

import com.cncoman.product.biz.IResourceService;



import com.cncoman.product.biz.IUserService;
import com.cncoman.product.biz.IVersionManageService;
import com.cncoman.product.biz.IVersionService;
import com.cncoman.product.util.Constants;
import com.cncoman.product.util.GetCityByPhoneFromForeignSite;
import com.cncoman.product.util.Initialize;
import com.cncoman.product.action.Action;

import com.cncoman.product.bean.PageControlModel;

import com.cncoman.product.bean.ResourceInfo;
import com.cncoman.product.bean.RoleInfo;


public class BaseAction extends Action {

	
	private static final long serialVersionUID = 1L;
	protected static final Log log = LogFactory.getLog("cncoman");
	private static final int BUFFER_SIZE = 16 * 1024 ;
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat ymdsdf = new SimpleDateFormat("yyyy-MM-dd");
	
	protected PageControlModel pageModel;
	/*protected List<CordCount> cordCountList;//客服中心流量统计
*/
	protected ICompanyService companyService;
	/*protected IMachineService machineService;*/

/*	protected IProductService productService;*/
/*	protected IIncomeService incomeService;*/




	protected IUserService userService;

/*	protected IMachineProdExplainService explainService;*/

	protected IResourceService resourceService;

	/*protected IMobileService mobileService;*/
	protected ICustomerService customerService;
	protected IVersionService versionService;
	protected IVersionManageService versionManageService;

	
	/*  lkl加 s */
	/*protected IAdCompanyService adcompanyService;
	protected IAdMapService adMapService;
	protected IAdContextService adcontextService;
	protected AdContextInfo adContextInfo;
	protected List<AdContextInfo> adcontextList;
	protected List<AdMapInfo> admapList;
	protected List<AdContextInfo> aList;*/
	/*  lkl加 e */
	
/*	protected SaleDetailInfo saleDetailInfo;
	protected SaleStatInfo statInfo;
	protected MOInfo moInfo;
	protected SendCmdDetailInfo sendCmdInfo;
	protected IncomeInfo incomeInfo;
	protected CommandInfo commandInfo;
	protected CommandProvinceMapInfo cmdMapInfo;*/
	protected CompanyInfo companyInfo;
	/*protected MachineInfo machineInfo;
	protected JumpStatInfo jumpInfo;
	protected SPInfo spInfo;*/
	protected UserInfo userInfo;
	protected RoleInfo roleInfo;
	protected ResourceInfo resourceInfo;
/*	protected SendCmdAndMOInfo sendCmdAndMOInfo;
	protected MobileSalesInfo mobileSalesInfo;
	protected SaleNetWorkInfo saleNetWorkInfo;

	protected OpinionInfo opinionInfo;
	protected TipsInfo tipsInfo;
	protected CustomerMachineInfo customerMachineInfo;
	protected SmsCatInfo smsCatInfo;
	protected CompanyBrandInfo brandInfo;
	
	
	protected Map<CompanyInfo, List<MachineInfo>> companyMachineMap;
	protected Map<ProvinceInfo, List<CityInfo>> provinceCityMap;
	protected List<SaleDetailInfo> saleDetailList;
	protected List<SaleStatInfo> statList;	
	protected List<MOInfo> moList;
	protected List<ProductInfo> productList;	
	protected List<SendCmdDetailInfo> sendCmdList;	
	protected List<IncomeStatInfo> incomeStatList;
	protected List<ProvinceInfo> provinceList;
	protected List<SPInfo> spList;
	protected List<ReqFeeDetailInfo> reqList;	
	protected List<ProvinceInfo> mapProvinceList;
	protected List<CommandInfo> commandList;
	protected List<CommandProvinceMapInfo> mapList;*/
	protected List<UserInfo> userList;	
	protected List<CompanyInfo> companyList;
/*	protected List<MachineInfo> machineList;	
	protected List<MachineProdExplainInfo> explainList;
	protected MachineProdExplainInfo explainben;
	protected List<JumpStatInfo> jumpList;
	protected Map<String, JumpStatInfo> jumpMap;*/
	protected Map<String, CompanyInfo> companyMap;	
	protected List<RoleInfo> roleList;
	protected List<ResourceInfo> resourceList;
/*	protected TreeMap<String, SendCmdAndMOInfo> sendCmdAndMOMap;

	protected List<SaleNetWorkInfo> saleNetWorkList;
	protected List<OpinionInfo> opinionList;
	protected List<TipsInfo> tipsList;*/
	
/*	protected List<CustomerMachineInfo> customerMachineList;
	protected List<SmsCatInfo> smsList;
	protected List<CompanyBrandInfo> brandList;*/
	protected List<VersionInfo> versionList;
	protected int prodid;
	
	/**
	 * www.data123.com.cn页面标题设置
	 * @param pageTitle
	 */
	protected void setPageTitle(String pageTitle){
		getRequest().setAttribute(Constants.PAGE_TITLE, pageTitle);
	}
	
/*	public void fullCompanyMachineMap(){		
		companyList = companyService.list(Constants.COMPANY_TYPE_MANU);
		companyMachineMap = new HashMap<CompanyInfo, List<MachineInfo>>();
		MachineInfo m = null;
		List<MachineInfo> mlist = null;
		for(CompanyInfo company : companyList){
			mlist = machineService.list(company.getCode());
			m = new MachineInfo();
			m.setCode(Constants.ALL_MACHINE);
			m.setName("");
			mlist.add(0, m);
			company.setMachList(mlist);			
			companyMachineMap.put(company, company.getMachList());
			
		}
	
	}*/
	
	public void printString(String str, String contentType){
		HttpServletResponse response = null;
		PrintWriter out = null;
		try{	
			response = getResponse();
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setCharacterEncoding("UTF-8");
			response.setContentType(contentType);
			
			out.print(str);			
			out.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(out != null){
				out.close();
				out.close();
			}			
		}
	}
	
	/*public void fullCompanyMachineMap(List<CompanyInfo> companyList){		
		companyMachineMap = new HashMap<CompanyInfo, List<MachineInfo>>();
		MachineInfo m = null;
		List<MachineInfo> mlist = null;
		for(CompanyInfo company : companyList){
			mlist = machineService.list(company.getCode());			
			m = new MachineInfo();
			m.setCode(Constants.ALL_MACHINE);
			m.setName("");
			mlist.add(0, m);
			company.setMachList(mlist);			
			companyMachineMap.put(company, company.getMachList());
		}		
	}*/
	
	/*public void fullProvinceCityMap(){
		if(provinceCityMap == null || provinceCityMap.size() <=0){
			provinceCityMap = new HashMap<ProvinceInfo, List<CityInfo>>();
			provinceList = Initialize.provinceList;
			List<CityInfo> clist = null;
			CityInfo c = null;
			for(ProvinceInfo province : provinceList){
			//	clist = provinceService.cityList(province.getIntId());
				c = new CityInfo();
				c.setName(Constants.ALL_CITY);
				c.setIntId(0);
				clist.add(0, c);
				province.setCity(clist);
				provinceCityMap.put(province, province.getCity());
			}
		}
	}*/

	
	protected UserInfo getCurUser(){
		return (UserInfo) getSession().getAttribute(Constants.SESSION_USER);
	}
	
	
	/**
	 * 获取进入客服中心的手机用户的厂家代码
	 * @return
	 */
//	protected String getJumpUserCompanyCode(){		
//		SaleDetailInfo s = (SaleDetailInfo)getApplication().get(Constants.SESSION_CUSTOMER_SALEDETAILINFO);
//		if(s == null)
//			return "";
//		return s.getMan();
//	}
	

	public static String getExtention(String fileName)  {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos);
   }
	
	public static void copy(File src, File dst)  {
        try  {
           InputStream in = null ;
           OutputStream out = null ;
            try  {                
               in = new BufferedInputStream( new FileInputStream(src), BUFFER_SIZE);
               out = new BufferedOutputStream( new FileOutputStream(dst), BUFFER_SIZE);
                byte [] buffer = new byte [BUFFER_SIZE];
              
              /*  while (in.read(buffer) > 0 )  { //上传文件变大。
                  out.write(buffer);
                
               } */
                int i;                        //lkl 改 2012.11.05
                while ((i=in.read(buffer) )> 0 )  {
                    out.write(buffer,0, i);
                }
                
            } finally  {
                if ( null != in)  {
                   in.close();
               } 
                 if ( null != out)  {
                   
                   out.flush();
                   out.close();
               } 
           } 
        } catch (Exception e)  {
           e.printStackTrace();
       } 
   }
	

	/*public MobileInfo getMobileInfo(String phone){
		MobileInfo mobile = null;
		CityInfo city = null;
		mobile = mobileService.getMobile(phone);
		if(mobile != null){
			city = Initialize.cityIdMap.get(mobile.getCid());			
		}else{
			mobile = GetCityByPhoneFromForeignSite.getInfo(phone);
			if(mobile != null){
				log.info("!!本地数据表cn_mobile中无该号段记录,从外部网站获取成功！手机号码：" + phone);
				city = mobile.getCity();
				if(city == null){
					mobile.setPid(0);
					mobile.setCid(0);
				}else{
					mobile.setPid(city.getProvince().getIntId());
					mobile.setCid(city.getIntId());
				}
				int ret = mobileService.saveMobile(mobile);
				if(ret == 0)
					log.info("!!添加号段信息失败：手机号码：" + phone);
			}else{
				String info = "!!本地数据表cn_mobile中无该号段记录,且从外部网站获取失败！手机号码：" + phone; 
				log.info(info);
				 mobile =new MobileInfo();
//				MailUtil.getInstance().sendMail(new String[]{"460026490@qq.com"},"获取手机归属地失败",info);
			}			
		}
		city = city == null ? new CityInfo() : city;
		mobile.setCity(city);
		return mobile;
	}*/

	public PageControlModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageControlModel pageModel) {
		this.pageModel = pageModel;
	}
	

	/*public List<SaleDetailInfo> getSaleDetailList() {
		return saleDetailList;
	}

	public void setSaleDetailList(List<SaleDetailInfo> saleDetailList) {
		this.saleDetailList = saleDetailList;
	}

	public List<SaleStatInfo> getStatList() {
		return statList;
	}

	public void setStatList(List<SaleStatInfo> statList) {
		this.statList = statList;
	}

	public SaleStatInfo getStatInfo() {
		return statInfo;
	}

	public void setStatInfo(SaleStatInfo statInfo) {
		this.statInfo = statInfo;
	}
	
	public MOInfo getMoInfo() {
		return moInfo;
	}
	public void setMoInfo(MOInfo mo) {
		this.moInfo = mo;
	}
	public List<MOInfo> getMoList() {
		return moList;
	}
	public void setMoList(List<MOInfo> moList) {
		this.moList = moList;
	}*/

	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}

	/*public void setMachineService(IMachineService machineService) {
		this.machineService = machineService;
	}*/

/*	public void setProductService(IProductService productService) {
		this.productService = productService;
	}*/

	/*public List<ProductInfo> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductInfo> productList) {
		this.productList = productList;
	}

	public void setIncomeService(IIncomeService incomeService) {
		this.incomeService = incomeService;
	}



	public List<SendCmdDetailInfo> getSendCmdList() {
		return sendCmdList;
	}


	public void setSendCmdList(List<SendCmdDetailInfo> sendCmdList) {
		this.sendCmdList = sendCmdList;
	}


	public SendCmdDetailInfo getSendCmdInfo() {
		return sendCmdInfo;
	}


	public void setSendCmdInfo(SendCmdDetailInfo sendCmdInfo) {
		this.sendCmdInfo = sendCmdInfo;
	}


	public List<IncomeStatInfo> getIncomeStatList() {
		return incomeStatList;
	}


	public void setIncomeStatList(List<IncomeStatInfo> incomeStatList) {
		this.incomeStatList = incomeStatList;
	}


	public IncomeInfo getIncomeInfo() {
		return incomeInfo;
	}


	public void setIncomeInfo(IncomeInfo incomeInfo) {
		this.incomeInfo = incomeInfo;
	}




	public List<ReqFeeDetailInfo> getReqList() {
		return reqList;
	}


	public void setReqList(List<ReqFeeDetailInfo> reqList) {
		this.reqList = reqList;
	}
	

	public List<ProvinceInfo> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<ProvinceInfo> provinceList) {
		this.provinceList = provinceList;
	}

	public List<CommandInfo> getCommandList() {
		return commandList;
	}

	public void setCommandList(List<CommandInfo> list) {
		this.commandList = list;
	}*/

	/*public void setMapService(ICommandProvinceMapService mapService) {
		this.mapService = mapService;
	}*/

	/*public List<CommandProvinceMapInfo> getMapList() {
		return mapList;
	}

	public void setMapList(List<CommandProvinceMapInfo> mapList) {
		this.mapList = mapList;
	}

	public List<ProvinceInfo> getMapProvinceList() {
		return mapProvinceList;
	}

	public void setMapProvinceList(List<ProvinceInfo> mapProvinceList) {
		this.mapProvinceList = mapProvinceList;
	}





	public List<SPInfo> getSpList() {
		return spList;
	}

	public void setSpList(List<SPInfo> spList) {
		this.spList = spList;
	}

	public CommandProvinceMapInfo getCmdMapInfo() {
		return cmdMapInfo;
	}

	public void setCmdMapInfo(CommandProvinceMapInfo cmdMapInfo) {
		this.cmdMapInfo = cmdMapInfo;
	}

	public CommandInfo getCommandInfo() {
		return commandInfo;
	}

	public void setCommandInfo(CommandInfo commandInfo) {
		this.commandInfo = commandInfo;
	}*/

	public CompanyInfo getCompanyInfo() {
		return companyInfo;
	}

	public void setCompanyInfo(CompanyInfo companyInfo) {
		this.companyInfo = companyInfo;
	}

	public List<CompanyInfo> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<CompanyInfo> companyList) {
		this.companyList = companyList;
	}

	/*public Map<CompanyInfo, List<MachineInfo>> getCompanyMachineMap() {
		return companyMachineMap;
	}

	public void setCompanyMachineMap(
			Map<CompanyInfo, List<MachineInfo>> companyMachineMap) {
		this.companyMachineMap = companyMachineMap;
	}*/

	public Map<String, CompanyInfo> getCompanyMap() {
		return companyMap;
	}

	public void setCompanyMap(Map<String, CompanyInfo> companyMap) {
		this.companyMap = companyMap;
	}

	/*public List<MachineProdExplainInfo> getExplainList() {
		return explainList;
	}

	public void setExplainList(List<MachineProdExplainInfo> explainList) {
		this.explainList = explainList;
	}

	public JumpStatInfo getJumpInfo() {
		return jumpInfo;
	}

	public void setJumpInfo(JumpStatInfo jumpInfo) {
		this.jumpInfo = jumpInfo;
	}

	public List<JumpStatInfo> getJumpList() {
		return jumpList;
	}

	public void setJumpList(List<JumpStatInfo> jumpList) {
		this.jumpList = jumpList;
	}

	public Map<String, JumpStatInfo> getJumpMap() {
		return jumpMap;
	}

	public void setJumpMap(Map<String, JumpStatInfo> jumpMap) {
		this.jumpMap = jumpMap;
	}

	public MachineInfo getMachineInfo() {
		return machineInfo;
	}

	public void setMachineInfo(MachineInfo machineInfo) {
		this.machineInfo = machineInfo;
	}

	public List<MachineInfo> getMachineList() {
		return machineList;
	}

	public void setMachineList(List<MachineInfo> machineList) {
		this.machineList = machineList;
	}*/

	public List<ResourceInfo> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<ResourceInfo> resourceList) {
		this.resourceList = resourceList;
	}

	public RoleInfo getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}

	public List<RoleInfo> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<RoleInfo> roleList) {
		this.roleList = roleList;
	}

	/*public SaleDetailInfo getSaleDetailInfo() {
		return saleDetailInfo;
	}

	public void setSaleDetailInfo(SaleDetailInfo saleDetailInfo) {
		this.saleDetailInfo = saleDetailInfo;
	}

	public SPInfo getSpInfo() {
		return spInfo;
	}

	public void setSpInfo(SPInfo spInfo) {
		this.spInfo = spInfo;
	}*/

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserInfo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}

/*	public void setCommandService(ICommandService commandService) {
		this.commandService = commandService;
	}*/

	/*public void setExplainService(IMachineProdExplainService explainService) {
		this.explainService = explainService;
	}
*/


	public void setResourceService(IResourceService resourceService) {
		this.resourceService = resourceService;
	}


	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/*public void setMobileService(IMobileService mobileService) {
		this.mobileService = mobileService;
	}

	public Map<ProvinceInfo, List<CityInfo>> getProvinceCityMap() {
		return provinceCityMap;
	}

	public void setProvinceCityMap(Map<ProvinceInfo, List<CityInfo>> provinceCityMap) {
		this.provinceCityMap = provinceCityMap;
	}*/

	public ResourceInfo getResourceInfo() {
		return resourceInfo;
	}

	public void setResourceInfo(ResourceInfo resourceInfo) {
		this.resourceInfo = resourceInfo;
	}

	/*public SendCmdAndMOInfo getSendCmdAndMOInfo() {
		return sendCmdAndMOInfo;
	}

	public void setSendCmdAndMOInfo(SendCmdAndMOInfo sendCmdAndMOInfo) {
		this.sendCmdAndMOInfo = sendCmdAndMOInfo;
	}

	public TreeMap<String, SendCmdAndMOInfo> getSendCmdAndMOMap() {
		return sendCmdAndMOMap;
	}

	public void setSendCmdAndMOMap(TreeMap<String, SendCmdAndMOInfo> sendCmdAndMOMap) {
		this.sendCmdAndMOMap = sendCmdAndMOMap;
	}

	public MobileSalesInfo getMobileSalesInfo() {
		return mobileSalesInfo;
	}

	public void setMobileSalesInfo(MobileSalesInfo mobileSalesInfo) {
		this.mobileSalesInfo = mobileSalesInfo;
	}*/

	public ICustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(ICustomerService customerService) {
		this.customerService = customerService;
	}



	/*public OpinionInfo getOpinionInfo() {
		return opinionInfo;
	}

	public void setOpinionInfo(OpinionInfo opinionInfo) {
		this.opinionInfo = opinionInfo;
	}

	public List<OpinionInfo> getOpinionList() {
		return opinionList;
	}

	public void setOpinionList(List<OpinionInfo> opinionList) {
		this.opinionList = opinionList;
	}

	public SaleNetWorkInfo getSaleNetWorkInfo() {
		return saleNetWorkInfo;
	}

	public void setSaleNetWorkInfo(SaleNetWorkInfo salenetWorkInfo) {
		this.saleNetWorkInfo = salenetWorkInfo;
	}

	public List<SaleNetWorkInfo> getSaleNetWorkList() {
		return saleNetWorkList;
	}

	public void setSaleNetWorkList(List<SaleNetWorkInfo> saleNetWorkList) {
		this.saleNetWorkList = saleNetWorkList;
	}

	public List<TipsInfo> getTipsList() {
		return tipsList;
	}

	public void setTipsList(List<TipsInfo> tipsList) {
		this.tipsList = tipsList;
	}

	public TipsInfo getTipsInfo() {
		return tipsInfo;
	}

	public void setTipsInfo(TipsInfo tipsInfo) {
		this.tipsInfo = tipsInfo;
	}*/

/*	public List<CityInfo> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityInfo> cityList) {
		this.cityList = cityList;
	}*/

	/*public CustomerMachineInfo getCustomerMachineInfo() {
		return customerMachineInfo;
	}

	public void setCustomerMachineInfo(CustomerMachineInfo customerMachineInfo) {
		this.customerMachineInfo = customerMachineInfo;
	}

	public List<CustomerMachineInfo> getCustomerMachineList() {
		return customerMachineList;
	}

	public void setCustomerMachineList(List<CustomerMachineInfo> customerMachineList) {
		this.customerMachineList = customerMachineList;
	}

	public SmsCatInfo getSmsCatInfo() {
		return smsCatInfo;
	}

	public void setSmsCatInfo(SmsCatInfo smsCatInfo) {
		this.smsCatInfo = smsCatInfo;
	}

	public List<SmsCatInfo> getSmsList() {
		return smsList;
	}

	public void setSmsList(List<SmsCatInfo> smsList) {
		this.smsList = smsList;
	}

	

	
	public List<CordCount> getCordCountList() {
		return cordCountList;
	}

	public void setCordCountList(List<CordCount> cordCountList) {
		this.cordCountList = cordCountList;
	}
*/
	public void setVersionService(IVersionService versionService) {
		this.versionService = versionService;
	}

	public void setVersionManageService(IVersionManageService versionManageService) {
		this.versionManageService = versionManageService;
	}



/*	public IAdCompanyService getAdcompanyService() {
		return adcompanyService;
	}

	public void setAdcompanyService(IAdCompanyService adcompanyService) {
		this.adcompanyService = adcompanyService;
	}

	public IAdMapService getAdMapService() {
		return adMapService;
	}

	public void setAdMapService(IAdMapService adMapService) {
		this.adMapService = adMapService;
	}

	public IAdContextService getAdcontextService() {
		return adcontextService;
	}

	public void setAdcontextService(IAdContextService adcontextService) {
		this.adcontextService = adcontextService;
	}

	public AdContextInfo getAdContextInfo() {
		return adContextInfo;
	}

	public void setAdContextInfo(AdContextInfo adContextInfo) {
		this.adContextInfo = adContextInfo;
	}
*/
	

	public List<VersionInfo> getVersionList() {
		return versionList;
	}

	public void setVersionList(List<VersionInfo> versionList) {
		this.versionList = versionList;
	}

	


	/*public MachineProdExplainInfo getExplainben() {
		return explainben;
	}

	public void setExplainben(MachineProdExplainInfo explainben) {
		this.explainben = explainben;
	}*/

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	

	
	


}
