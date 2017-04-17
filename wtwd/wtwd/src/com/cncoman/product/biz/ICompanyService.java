package com.cncoman.product.biz;

import java.util.List;
import java.util.Map;


import com.cncoman.product.bean.CompanyInfo;



public interface ICompanyService {
	
	/**
	 * 查找公司集合
	 * @param nameOrCode名称或编号
	 * @param type 类型
	 * @param salesId 商务
	 * @param from 从第几条记录开始
	 * @param to 取多少条记录
	 * @return
	 */
	public List<CompanyInfo> list(String nameOrCode, int type, int salesId, int from, int to);
	
	/**
	 * 查找公司集合
	 * @param type 类型
	 * @param salesId 商务
	 * @param from
	 * @param to
	 * @return
	 */
	public List<CompanyInfo> list(int type, int salesId, int from, int to);
	
	/**
	 * 查找公司集合
	 * @param salesId 商务 0忽略该条件
	 * @param from 0忽略该条件
	 * @param to 0忽略该条件
	 * @return
	 */
	public List<CompanyInfo> list(int salesId, int from, int to);
	
	/**
	 * 查找该类型下所有公司
	 * @param type
	 * @return
	 */
	public List<CompanyInfo> list(int type);
	
	/**
	 * 查找所有公司
	 * @return
	 */
	public List<CompanyInfo> list();
	
	public CompanyInfo getInfo(int companyId);

	public CompanyInfo getInfo(String code);
	
	public Map<String, CompanyInfo> companyMap(int type);
	
	public int update(CompanyInfo info);
	
	public int updateShop(CompanyInfo info);
	
	/**
	 * 客服中心更新公司图标及联系方式专用
	 * @param info
	 * @return
	 */
	public int updateIconAndContact(CompanyInfo info);
	
	public int insert(CompanyInfo info);
	
	/**
	 * 根据机型ID查找对应的厂商信息
	 * @param machineId
	 * @return CompanyInfo
	 */
	public CompanyInfo getByMachineId(int machineId);
	
	public int companyCount(String nameOrCode, int type, int salesId);
	
	
	//////////////////////////////////品牌管理/////////////////////////////
	/**
	 * 保存品牌，并返回品牌ID
	 */
	/*public int saveBrand(CompanyBrandInfo brand);
	
	public int deleteBrand(CompanyBrandInfo brand);
	
	public int updateBrand(CompanyBrandInfo brand);
	
	public CompanyBrandInfo getBrand(int id, String companyCode);
	
	public CompanyBrandInfo getBrand(String companyCode, String machineCode);*/
	
	/**
	 * 归类机型到品牌
	 * @param companyCode
	 * @param machId
	 * @param brandId
	 * @return
	 *//*
	public int updateMachineBrand(String companyCode, String mids, int brandId);
	
	public int updateMachineBrand(String companyCode, int brandId);
	
	public List<CompanyBrandInfo> brandList(String companyCode, String codes, String brandIdStr);
	
	public List<CompanyBrandInfo> brandList(String companyCode);*/

	/*public List<ProductInfo> listPord();*/
	
}
