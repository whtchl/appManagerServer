package com.cncoman.product.biz.impl;

import java.util.List;

import com.cncoman.product.bean.VersionInfo;
import com.cncoman.product.biz.IVersionService;
import com.cncoman.product.dao.VersionDAO;

public class VersionServiceImpl implements IVersionService{
private VersionDAO versiondao;

public List<VersionInfo> versionlist(int type) {
	// TODO Auto-generated method stub
	return versiondao.versionlist(type);
}
public int save(VersionInfo info){
	return versiondao.save(info);
}

public void setVersiondao(VersionDAO versiondao) {
	this.versiondao = versiondao;
}
public VersionInfo getById(int id){
	return versiondao.getById(id);
}
public int update(VersionInfo bean){
	return versiondao.update(bean);
}
}
