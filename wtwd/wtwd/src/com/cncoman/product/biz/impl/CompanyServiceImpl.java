package com.cncoman.product.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.cncoman.product.bean.CompanyInfo;

import com.cncoman.product.biz.ICompanyService;
import com.cncoman.product.dao.CompanyDAO;


public class CompanyServiceImpl implements ICompanyService {
	
	private CompanyDAO dao;

	public List<CompanyInfo> list(String nameOrCode, int type, int salesId, int from, int to) {		
		return dao.list(nameOrCode, type, salesId, from, to);
	}

	public List<CompanyInfo> list(int type, int salesId, int from, int to) {
		
		return list(null, type, salesId, from, to);
	}

	public List<CompanyInfo> list(int salesId, int from, int to) {
		
		return list(null, 0, salesId, from, to);
	}

	public List<CompanyInfo> list(int type) {
		
		return list(null, type, 0, 0, 10000);
	}

	public List<CompanyInfo> list() {
		
		return list(null, 0, 0, 0, 10000);
	}
	
	public CompanyInfo getInfo(int companyId){
		return dao.getInfo(companyId);
	}
	
	public CompanyInfo getInfo(String code){
		return dao.getInfo(code);
	}
	
	public Map<String, CompanyInfo> companyMap(int type){
		List<CompanyInfo> list = this.list(type);
		Map<String, CompanyInfo> map = new HashMap<String, CompanyInfo>();
		for(CompanyInfo company : list){
			map.put(company.getCode(), company);
		}
		return map;
	}
	
	
	public int insert(CompanyInfo info){
		return dao.insert(info);
	}
	
	

	public int update(CompanyInfo info) {
		
		return dao.update(info);
	}
	public int updateShop(CompanyInfo info){
		return dao.updateShop(info);
	}
	
	public int updateIconAndContact(CompanyInfo info){
		
		return dao.updateIconAndContact(info);
	}
	
	public CompanyInfo getByMachineId(int machineId){
		return dao.getByMachineId(machineId);
	}
	
	public int companyCount(String nameOrCode, int type, int salesId){
		
		return dao.companyCount(nameOrCode, type, salesId);
	}

	public void setDao(CompanyDAO dao) {
		this.dao = dao;
	}

	/*public int deleteBrand(CompanyBrandInfo brand) {
		
		return dao.deleteBrand(brand);
	}

	public int saveBrand(CompanyBrandInfo brand) {
		
		return dao.saveBrand(brand);
	}

	public int updateBrand(CompanyBrandInfo brand) {
		
		return dao.updateBrand(brand);
	}
	
	public CompanyBrandInfo getBrand(int id, String companyCode){
		
		return dao.getBrand(id, companyCode);
	}
	
	public CompanyBrandInfo getBrand(String companyCode, String machineCode){
		
		return dao.getBrand(companyCode, machineCode);
	}

	public int updateMachineBrand(String companyCode, String mids, int brandId) {
		
		return dao.updateMachineBrand(companyCode, mids, brandId);
	}
	
	public int updateMachineBrand(String companyCode, int brandId){
		return dao.updateMachineBrand(companyCode, brandId);
	}
	
	public List<CompanyBrandInfo> brandList(String companyCode, String codes, String brandIdStr){
		
		return dao.brandList(companyCode, codes, brandIdStr);
	}

	public List<CompanyBrandInfo> brandList(String companyCode){
		return dao.brandList(companyCode);
	}*/

	/*public List<ProductInfo> listPord() {
		return dao.listPord();
	}*/
}
