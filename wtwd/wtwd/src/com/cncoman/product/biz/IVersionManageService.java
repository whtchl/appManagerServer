package com.cncoman.product.biz;

import java.util.List;

import com.cncoman.product.bean.VersionManage;

public interface IVersionManageService {
	public int save(VersionManage info) ;
	public List<VersionManage> versionManagelist(String issue,String versionId,String code,int from,int to,int type);
	public int countManageInfo(String issue,String versionId,String code,int type);
	public int update(String issue,int id);
	public int update(VersionManage vm);
	public int delete(int id);
	
	public VersionManage getCompanyVersionInfo(int id);
}
