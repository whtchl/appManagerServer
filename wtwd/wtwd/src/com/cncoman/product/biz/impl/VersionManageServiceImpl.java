package com.cncoman.product.biz.impl;

import java.util.List;

import com.cncoman.product.bean.VersionManage;
import com.cncoman.product.biz.IVersionManageService;
import com.cncoman.product.dao.VersionManageDAO;

public class VersionManageServiceImpl implements IVersionManageService {
	private VersionManageDAO versdao;

	public int save(VersionManage info) {

		return versdao.save(info);
	}

	public VersionManageDAO getVersdao() {
		return versdao;
	}

	public void setVersdao(VersionManageDAO versdao) {
		this.versdao = versdao;
	}

	public List<VersionManage> versionManagelist(String issue,
			String versionId, String code, int from, int to,int type) {

		return versdao.versionManagelist(issue, versionId, code, from, to,type);
	}

	public int countManageInfo(String issue, String versionId, String code,int type) {

		return versdao.countManageInfo(issue, versionId, code,type);
	}

	public int update(String issue, int id) {
		return versdao.update(issue, id);
	}

	public int delete(int id) {
		return versdao.delete(id);
	}
	
	public VersionManage getCompanyVersionInfo(int id){
		
		return versdao.getCompanyVersion(id);
	}
	
	public int update(VersionManage vm){
		return versdao.update(vm);
	}

}
