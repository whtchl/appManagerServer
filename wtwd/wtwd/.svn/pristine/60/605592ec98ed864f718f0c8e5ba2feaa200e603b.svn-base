package com.cncoman.product.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.cncoman.product.bean.CompanyInfo;




import com.cncoman.product.biz.ICompanyService;
/*import com.cncoman.product.biz.IJumpStatService;*/
/*import com.cncoman.product.biz.IProductService;*/
/*import com.cncoman.product.biz.IProvinceService;
import com.cncoman.product.biz.ISPService;*/
import com.cncoman.product.bean.CityInfo;
import com.cncoman.product.bean.ProvinceInfo;
import com.cncoman.product.util.StringUtil;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2009
 * </p>
 * 
 * <p>
 * Company: cncoman
 * </p>
 * 
 * @author David Kong
 * @version 1.0
 */

public class Initialize{

	
	private static final long serialVersionUID = 1L;
	
	public static List<CityInfo> cityList;
	public static Map<Integer, CityInfo> cityIdMap;
	public static List<ProvinceInfo> provinceList;
	public static Map<String, Integer> sendmap = new HashMap<String, Integer>();
	public static String datetime="";
	
	/**
	 * 厂商Map<br/>
	 * key:code (String)<br/>
	 * value:CompanyInfo
	 */
	public static Map<String, CompanyInfo> companyMap;
	public static Map<Integer, ProvinceInfo> provinceMap;

	

	

	
	public static Map<String, String> portMobileMap;
	

/*	private IProvinceService provinceService;*/
	private ICompanyService companyService;
/*	private IJumpStatService jumpService;*/
/*	private IProductService productService;*/
/*	private ISPService spService;*/
	private Log log = LogFactory.getLog(Initialize.class);
	
	

	public void contextInitialized() {		
		//cityList = cityService.list();
		//provinceList = provinceService.list();
	//	cityIdMap = cityService.cityIdMap();
		companyMap = companyService.companyMap(2);
	//	setProvinceMap(provinceList);
//		jumpMap = jumpService.jumpMap();
	//	setProductMap(productService.list());
//		setSPMap(spService.list());
//		setSPIPMap(spService.list());
	//	portMobileMap = provinceService.getPortMobileMap();
		log.info("Initialize initialized!");
	}
	
/*	public static void setSPIPMap(List<SPInfo> spList){		
		spIPMap = new HashMap<String, SPInfo>();
		String ip, tmp;
		String[] ips;
		for(SPInfo sp : spList){
			ip = sp.getServerIp();
			if(!StringUtil.isNull(ip)){
				ips = ip.split("\\#");				
				if(ips != null && ips.length >= 0){					
					for(int i = 0; i < ips.length; i++){
						tmp = ips[i];						
						if(!StringUtil.isNull(tmp) && tmp.split("\\.").length == 4)							
							spIPMap.put(tmp, sp);						
					}
				}
			}
		}
	}*/
	
/*	public static void setAdCompanyIPMap(List<AdCompanyInfo> spList){		
		adCompanyIPMap = new HashMap<String, AdCompanyInfo>();
		String ip, tmp;
		String[] ips;
		for(AdCompanyInfo sp : spList){
			ip = sp.getServerIp();
			if(!StringUtil.isNull(ip)){
				ips = ip.split("\\#");				
				if(ips != null && ips.length >= 0){					
					for(int i = 0; i < ips.length; i++){
						tmp = ips[i];						
						if(!StringUtil.isNull(tmp) && tmp.split("\\.").length == 4)							
							adCompanyIPMap.put(tmp, sp);						
					}
				}
			}
		}
	}*/
	
	/**
	 * 根据城市名称模糊查找城市<br/>
	 * 当城市名中包含该关键字，条件成立
	 * @param cityName
	 * @return
	 */
	public static CityInfo getCityByName(String cityName){
		CityInfo city2 = null;		
		List<CityInfo> list = cityList;
		try{			
			for(CityInfo city : list){
				if(city.getName().indexOf(cityName) != -1){					
					city2 = city;
					break;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return city2;
	}
	
	public void setProvinceMap(List<ProvinceInfo> list){
		provinceMap = new HashMap<Integer, ProvinceInfo>();
		for(ProvinceInfo province : list){
			provinceMap.put(province.getIntId(), province);
		}
	}
	
/*	private void setSPMap(List<SPInfo> list){
		spMap = new HashMap<Integer, SPInfo>();
		for(SPInfo sp : list){
			spMap.put(sp.getIntId(), sp);
		}
	}*/
	
/*	public void setProductMap(List<ProductInfo> list){
		productMap = new HashMap<String, ProductInfo>();
		for(ProductInfo product : list){
			productMap.put(product.getNumber(), product);
		}
	}*/






/*	public void setProvinceService(IProvinceService provinceService) {
		this.provinceService = provinceService;
	}
*/


	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
	}

/*	public void setJumpService(IJumpStatService jumpService) {
		this.jumpService = jumpService;
	}*/

/*	public void setProductService(IProductService productService) {
		this.productService = productService;
	}*/

/*	public void setSpService(ISPService spService) {
		this.spService = spService;
	}*/
}

