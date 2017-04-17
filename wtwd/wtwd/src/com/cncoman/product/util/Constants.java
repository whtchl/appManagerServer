package com.cncoman.product.util;

import java.util.Arrays;
import java.util.List;

public class Constants {
	
	
	
	
	

	public static final int COMPANY_TYPE_CNCOMAN = 1;
	
	/**
	 * 公司类型定义：厂家：2
	 */
	public static final int COMPANY_TYPE_MANU = 2;
	
	//用户部门定义
	public static final int DEPARTMENT_CNCOMAN_SALES = 1;   
	
	public static final String SESSION_USER = "SESSION_USER";
	
	/**
	 * 客服中心跳转时的用户信息
	 */
	public static final String SESSION_CUSTOMER_SALEDETAILINFO = "SESSION_CUSTOMER_SALEDETAILINFO";
	
	public static final String VALID_CODE = "VALID_CODE";
	

	
	/**
	 * 默认计费周期：30天
	 */
	public static final int DEFAULT_FEE_CYCLE = 30;
	
	public static final int DEFAULT_PROD_PRICE = 2;
	
	public static final int DEFAULT_AUTO_USER_DAILY_LIMIT = 8;
	
	public static final int DEFAULT_AUTO_USER_MONTHLY_LIMIT = 16;
	
	public static final int DEFAULT_AUTO_LINKHOURS = 24;
	
	public static final String DEFAULT_AUTO_LINKDAYS = "2|12|22";
	


	public static final List DOMAIN_CNCOMAN_LIST = Arrays.asList(new String[]{"www.wtwd.cn","www.wtwd1.cn","111.1.41.98","111.1.41.109","111.1.41.106","192.168.18.106","127.0.0.1","app.lifengpay.com"});   

	
	/**
	 * 域名数组
	 */
	public static final List DOMAIN_INCOME_LIST = Arrays.asList(new String[]{"www.wtwd.cn","www.wtwd1.cn","111.1.41.98","111.1.41.109","111.1.41.106","192.168.18.106","127.0.0.1","app.lifengpay.com"});  
	
	/**
	 * 域名数组
	 */
	public static final List DOMAIN_SALEDETAIL_LIST = Arrays.asList(new String[]{"www.wtwd.cn","www.wtwd1.cn","111.1.41.98","111.1.41.109","111.1.41.106","192.168.18.106","127.0.0.1","app.lifengpay.com"});  
	
	/**
	 *
	 * 
	 */
	public static final int DOMAIN_DATA123_FLAG = 2;
	
	/**
	 *
	 */
	public static final int DOMAIN_CNCOMAN_FLAG = 1;
	
	
	public static final int DOMAIN_INCOME_FLAG = 3;

/*	public static final List SP_IP_LIST = Arrays.asList(new String[]{"60.173.10.23", "113.97.123.235", "121.11.76.86"});  //sp同步mo, mt数据ip集
*/	
	public static final String ALL_MACHINE = "--全部机型--";
	
	public static final String ALL_CITY = "--全部城市--";
	
	/**
	 * 自动产生手机销售人员编号<br/>
	 * 最小编号:100,000.十万
	 */
	public static final int MOBILE_SALES_MIN_ID = 100000;
	
	/**
	 * 自动产生手机销售人员编号<br/>
	 * 最大编号899,999,9.百万
	 */
	public static final int MOBILE_SALES_MAX_ID = 8999999;
	
	
	public static final String PAGE_TITLE = "PAGE_TITLE";
	
	/**
	 * 系统管理员角色ID：1
	 */
	public static final int SYSTEM_ROLE_ADMIN_ID = 1;
	
	/**
	 * 有角色标识:3
	 */
	public static final int SALE_SYSTEM_PRIVATE_ROLE_FLAG = 3;	
	
	/**
	 *角色标识:2
	 */
	public static final int SALE_SYSTEM_PUBLIC_ROLE_FLAG = 2;
	
	
	/**
	 *角色ID：18
	 */
	public static final int SYSTEM_ROLE_PROD_ID = 18;
	
	/**
	 * 运营角色
	 */
    public static final int SYSTEM_ROLE_OPERATIONS = 47;
	
	public static final int SYSTEM_ROLE_MANAGER_ID = 46;
	
	/**
	 * 角色ID
	 */
	public static final int SYSTEM_ROLE_SALE_ADMIN_ID = 10;
	
	/**
	 * 公司logo路径
	 */
	public static final String ICON_PATH = "/images/";
	public static final String TASK_PATH = "/images/task";
	
	public static final String WEB_PATH ="http://p.wdwd.com.cn";
	
	public static final String APK_PATH = "/upload/apk";
	
	public static final String HTML_CONTENT_TYPE = "text/html; charset=UTF-8";
	/*
	 * 导销量给客户
	 */
	public static final String PHONE="phone";//手机号码
	
	public static final String O="o";//运营商
	
	public static final String M="m";//手机型号
	
	public static final String IMSI="imsi";//IMSI
	
	public static final String IMEI="imei";//IMEI
	
	public static final String Prov="p";//省份
	
	public static final String CITY="c";//城市
	
	public static final String TIME="t";//时间
	
}
