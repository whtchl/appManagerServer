package com.cncoman.product.biz.impl;

import java.util.List;

import com.cncoman.product.bean.CompanyInfo;
import com.cncoman.product.bean.DownLoadInfor;
import com.cncoman.product.bean.FileCategory;
import com.cncoman.product.bean.FileInformation;
import com.cncoman.product.bean.FunClubAdver;
import com.cncoman.product.bean.FunComments;
import com.cncoman.product.bean.OrzStaInfo;
import com.cncoman.product.biz.IFunClubService;
import com.cncoman.product.dao.FunClubDAO;



public class FunClubServiceImpl implements IFunClubService {
private FunClubDAO dao;

public void setDao(FunClubDAO dao) {
	this.dao = dao;
}

public int addCategory(FileCategory cate) {
	
	return dao.addCategory(cate);
}

public List<FileCategory> getCateList() {
	
	return dao.getCageList();
}

public List<FileInformation> getFileList(int i) {
	
	return dao.getFileList(i);
}

public int addFile(FileInformation fileInformation) {
    	return dao.addFile(fileInformation);
}

public int deleteById(int i) {
	
	return dao.deleteById(i);
}

public FileInformation getFileInfo(int i) {
	
	return dao.getFileInfo(i);
}

public int updateFileInfo(FileInformation fileInformation) {
	
	return dao.updateFileInfo(fileInformation);
}

public FileCategory getCateById(int i) {
	
	return dao.getCateById(i);
}

//public FileCategory getCateByShotName(String shotName){
//	return dao.getCateByShotName(shotName);
//}

public int updateCateInfo(FileCategory fileCategory) {
	
	return dao.updateCateInfo(fileCategory);
}

public int deleteCateById(int i) {
	
	return dao.deleteCateById(i);
}

public int addAdver(FunClubAdver funclubAdver) {
	return dao.addAdver(funclubAdver);
	
}

public List<FunClubAdver> getAdverList(int i) {
	
	return dao.getAdverList(i);
}

public int delAdver(int i) {
	
	return dao.delAdver(i);
}

public int updateAdver(FunClubAdver funclubAdver) {
	return dao.updateAdver(funclubAdver);
	
}

public List<FileCategory> getPositionById(int i) {
	
	return dao.getPositionById(i);
}

public List<FileInformation> getFileListByMoreId(String id, int page, int pagesize,String loginId) {
	
	return dao.getfileListByMoreId(id,page,pagesize,loginId);
}

public void updateShowId(FileCategory showId) {
	dao.updateShowId(showId);
	
}

public void updateFileShowId(FileInformation fileInformation) {
	
	dao.updateFileShowId(fileInformation);
}

public List<FileInformation> getFileByEssentail(int i) {

	return dao.getFileByEssentail(i);
}

public int getCountFile(int intId) {
	
	return dao.getCountFile(intId);
}

public int getPageCount(String id) {
	
	return dao.getPageCount(id);
}

public int getDownCount(int intId) {
	
	return dao.getDownCount(intId);
}

public List<CompanyInfo> getCompanyList(long id) {
	
	return dao.getCompanyList(id);
}

public List<DownLoadInfor> getDownLoadInfo(String starTime, String endTime,String id) {
	
	return dao.getDownLoadInfo(starTime,endTime,id);
}

public List<FileInformation> getByCompanyId(long id) {
	
	return dao.getByCompanyId(id);
}


public List<FunComments> getfuncommentsList(int appid) {
	return dao.getfuncommentsList(appid);
}
public int getfuncommentsdel(int comid){
	return dao.getfuncommentsdel(comid);
}
/////////////////////////////////////统计开始//////////////////////////////
public List<OrzStaInfo> getOrzAppSta(String fromDay, String toDay,int appId, String code, int groupBy) {
	return dao.getOrzAppSta( fromDay,  toDay, appId,  code,  groupBy);
}

}
