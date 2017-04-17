package com.cncoman.product.biz.impl;

import java.util.List;


/*import com.cncoman.product.bean.CordCount;*/



import com.cncoman.product.biz.ICustomerService;
import com.cncoman.product.dao.CustomerServiceDAO;

public class CustomerServiceImpl implements ICustomerService {
	
	private CustomerServiceDAO dao;
	
	










	/*public int deleteOpinion(OpinionInfo opinion) {
		
		return dao.deleteOpinion(opinion);
	}



	public int deleteSaleNetWork(SaleNetWorkInfo info) {
		
		return dao.deleteSaleNetWork(info);
	}



	public List<OpinionInfo> opinionList(int from, int to, String keyWord, String fromDay, String toDay, String companyCode) {
		
		return dao.opinionList(from, to, keyWord, fromDay, toDay, companyCode);
	}



	public List<SaleNetWorkInfo> saleNetWorkList(int pid, int cid, String companyCode) {
		
		return dao.saleNetWorkList(pid, cid, companyCode);
	}*/





/*
	public boolean saveOpinion(OpinionInfo opinion) {
		
		return dao.saveOpinion(opinion) > 0;
	}


	public SaleNetWorkInfo getSaleNetWork(int id, String companyCode){
		
		return dao.getSaleNetWork(id, companyCode);
	}

	public int saveSaleNetWork(SaleNetWorkInfo info) {
	
		return dao.saveSaleNetWork(info);
	}*/






/*
	public int updateSaleNetWork(SaleNetWorkInfo info) {
		
		return dao.updateSaleNetWork(info);
	}
*/
	
	/*public int opinionCount(String keyWord, String fromDay, String toDay, String companyCode){
		
		return dao.opinionCount(keyWord, fromDay, toDay, companyCode);
	}

	public OpinionInfo getOpinion(int id, String companyCode){
		return dao.getOpinion(id, companyCode);
	}
	*/
	
	
/*
	public int countTips(String companyCode, String keyWord) {
		
		return dao.countTips(companyCode, keyWord);
	}


	public int deleteTips(TipsInfo info) {
		
		return dao.deleteTips(info);
	}


	public TipsInfo getTips(int id, String companyCode) {
		
		return dao.getTips(id, companyCode);
	}


	public int saveTips(TipsInfo info) {
		
		return dao.saveTips(info);
	}


	public List<TipsInfo> tipsList(String companyCode, String keyWord, int from, int to) {
		
		return dao.tipsList(companyCode, keyWord, from, to);
	}


	public int updateTips(TipsInfo info) {
		
		return dao.updateTips(info);
	}

	
	

	public List<CustomerMachineInfo> customerMachineList(String companyCode) {
		return dao.customerMachineList(companyCode);
	}


	public int deleteCustomerMachineInfo(int id, String companyCode) {
		return dao.deleteCustomerMachineInfo(id, companyCode);
	}
*/
/*
	public CustomerMachineInfo getCustomerMachineInfo(String companyCode, int id) {
		return dao.getCustomerMachineInfo(companyCode, id);
	}


	public int saveCustomerMachineInfo(CustomerMachineInfo info) {
		return dao.saveCustomerMachineInfo(info);
	}


	public int updateCustomerMachineInfo(CustomerMachineInfo info) {
		return dao.updateCustomerMachineInfo(info);
	}*/


	public void setDao(CustomerServiceDAO dao) {
		this.dao = dao;
	}


	


/*	public void delete(OpinionInfo opinionInfo) {
		
		dao.delete(opinionInfo);
	}*/


/*	public List<CordCount> getCordCount1() {
		
		return dao.getCordCount1();
	}*/


	

}
