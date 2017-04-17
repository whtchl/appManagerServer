package com.cncoman.product.biz;

import java.util.List;

import com.cncoman.product.bean.CompanyInfo;
import com.cncoman.product.bean.DownLoadInfor;
import com.cncoman.product.bean.FileCategory;
import com.cncoman.product.bean.FileInformation;
import com.cncoman.product.bean.FunClubAdver;
import com.cncoman.product.bean.FunComments;
import com.cncoman.product.bean.OrzStaInfo;



public interface IFunClubService {
 public int addCategory(FileCategory cate);//增加类型

public List<FileCategory> getCateList();

public List<FileInformation> getFileList(int i);

public int addFile(FileInformation fileInformation);

public int deleteById(int i);

public FileInformation getFileInfo(int i);

public int updateFileInfo(FileInformation fileInformation);

public FileCategory getCateById(int i);

//public FileCategory getCateByShotName(String shotname);

public int updateCateInfo(FileCategory fileCategory);

public int deleteCateById(int i);

public int addAdver(FunClubAdver funclubAdver);

public List<FunClubAdver> getAdverList(int i);

public int delAdver(int i);

public int updateAdver(FunClubAdver funclubAdver);

public List<FileCategory> getPositionById(int i);

public List<FileInformation> getFileListByMoreId(String id, int page, int pagesize,String loginId);

public void updateShowId(FileCategory showId);

public void updateFileShowId(FileInformation fileInformation);

public List<FileInformation> getFileByEssentail(int i);

public int getCountFile(int intId);

public int getPageCount(String id);

public int getDownCount(int intId);

public List<CompanyInfo> getCompanyList(long id);

public List<DownLoadInfor> getDownLoadInfo(String starTime, String endTime,String id);

public List<FileInformation> getByCompanyId(long id);

public List<FunComments> getfuncommentsList(int appid); 
public int getfuncommentsdel(int comid);
public List<OrzStaInfo> getOrzAppSta(String fromDay, String toDay,int appId, String code, int groupBy);
}
