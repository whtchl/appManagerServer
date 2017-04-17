package com.cncoman.product.bean;

import java.util.List;



public class UserInfo extends BaseEntity
{
  private static final long serialVersionUID = 1L;
  private String loginId;
  private String pwd;
  private String oldPwd;
  private String newPwd;
  private CompanyInfo company;
  private int departmentId;
  private RoleInfo role;
  private float incomeRate;
  private float phoneSaleRate;
  private String lastAccessTime;
  private int accessTimes;
  private String ip;
  private String createTime;
  private String valid = "Y";
  private String remark;
  private List<CompanyInfo> companyList;
  private int validDomain;
  private Integer[] cids;
  private Integer[] pids;
  private String cidStrs;
  private String pidStrs;
  private String mach;
  private String[] machs;
  private int isAllMac;   //是否所有机型
  private int isAllArea;   //是否所有地区
  private int uid;    //创建者ID
  private int isAllBrand;   //是否全部品牌
  private Integer[] brands;
  private String brandIdStr;
  private PersonInfo personInfo;
  
  private RoleInfo roleMos;

  public int getAccessTimes()
  {
    return this.accessTimes;
  }
  public void setAccessTimes(int accessTimes) {
    this.accessTimes = accessTimes;
  }
  public String getCreateTime() {
    return this.createTime;
  }
  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }
  public String getIp() {
    return this.ip;
  }
  public void setIp(String ip) {
    this.ip = ip;
  }
  public String getLastAccessTime() {
    return this.lastAccessTime;
  }
  public void setLastAccessTime(String lastAccessTime) {
    this.lastAccessTime = lastAccessTime;
  }
  public String getLoginId() {
    return this.loginId;
  }
  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }
  public String getPwd() {
    return this.pwd;
  }
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
  public String getRemark() {
    return this.remark;
  }
  public void setRemark(String remark) {
    this.remark = remark;
  }
  public String getValid() {
    return this.valid;
  }
  public void setValid(String valid) {
    this.valid = valid;
  }
  public float getIncomeRate() {
    return this.incomeRate;
  }
  public void setIncomeRate(float incomeRate) {
    this.incomeRate = incomeRate;
  }
  public float getPhoneSaleRate() {
    return this.phoneSaleRate;
  }
  public void setPhoneSaleRate(float phoneSaleRate) {
    this.phoneSaleRate = phoneSaleRate;
  }
  public RoleInfo getRole() {
    return this.role;
  }
  public void setRole(RoleInfo role) {
    this.role = role;
  }
  public CompanyInfo getCompany() {
    return this.company;
  }
  public void setCompany(CompanyInfo company) {
    this.company = company;
  }
  public List<CompanyInfo> getCompanyList() {
    return this.companyList;
  }
  public void setCompanyList(List<CompanyInfo> companyList) {
    this.companyList = companyList;
  }
  public int getDepartmentId() {
    return this.departmentId;
  }
  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }
  public String getNewPwd() {
    return this.newPwd;
  }
  public void setNewPwd(String newPwd) {
    this.newPwd = newPwd;
  }
  public String getOldPwd() {
    return this.oldPwd;
  }
  public void setOldPwd(String oldPwd) {
    this.oldPwd = oldPwd;
  }
  public int getValidDomain() {
    return this.validDomain;
  }
  public void setValidDomain(int validDomain) {
    this.validDomain = validDomain;
  }
  public Integer[] getCids() {
    return this.cids;
  }
  public void setCids(Integer[] cids) {
    this.cids = cids;
  }
  public String getCidStrs() {
    return this.cidStrs;
  }
  public void setCidStrs(String cidStrs) {
    this.cidStrs = cidStrs;
  }
  public int getIsAllMac() {
    return this.isAllMac;
  }
  public void setIsAllMac(int isAllMac) {
    this.isAllMac = isAllMac;
  }
  public String getMach() {
    return this.mach;
  }
  public void setMach(String mach) {
    this.mach = mach;
  }
  public String[] getMachs() {
    return this.machs;
  }
  public void setMachs(String[] machs) {
    this.machs = machs;
  }
  public Integer[] getPids() {
    return this.pids;
  }
  public void setPids(Integer[] pids) {
    this.pids = pids;
  }
  public String getPidStrs() {
    return this.pidStrs;
  }
  public void setPidStrs(String pidStrs) {
    this.pidStrs = pidStrs;
  }
public int getIsAllArea() {
	return isAllArea;
}
public void setIsAllArea(int isAllArea) {
	this.isAllArea = isAllArea;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getIsAllBrand() {
	return isAllBrand;
}
public void setIsAllBrand(int isAllBrand) {
	this.isAllBrand = isAllBrand;
}
public Integer[] getBrands() {
	return brands;
}
public void setBrands(Integer[] brands) {
	this.brands = brands;
}
public String getBrandIdStr() {
	return brandIdStr;
}
public void setBrandIdStr(String brandIdStr) {
	this.brandIdStr = brandIdStr;
}
/**
 * ������Ա����Ϣ
 * personInfoΪ��ʱ������һ���µĶ���
 * @return
 */
public PersonInfo getPersonInfo() {
	return personInfo;
//	return personInfo == null ? new PersonInfo() : personInfo;
}
public void setPersonInfo(PersonInfo personInfo) {
	this.personInfo = personInfo;
}
public RoleInfo getRoleMos() {
	return roleMos;
}
public void setRoleMos(RoleInfo roleMos) {
	this.roleMos = roleMos;
}
}
