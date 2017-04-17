package com.cncoman.product.bean;

import java.util.Date;

public class VersionManage {
private int id;
private String versionId;
private VersionInfo verInfo;
private String  code;
private CompanyInfo company;
private String path;
private String remark;
private String issue;
private String name;
private Date uploadTime;
private String size;
private int type;
private String mach;
private int productId;

public String getMach() {
	return mach;
}
public void setMach(String mach) {
	this.mach = mach;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getVersionId() {
	return versionId;
}
public void setVersionId(String versionId) {
	this.versionId = versionId;
}

public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public String getIssue() {
	return issue;
}
public void setIssue(String issue) {
	this.issue = issue;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Date getUploadTime() {
	return uploadTime;
}
public void setUploadTime(Date uploadTime) {
	this.uploadTime = uploadTime;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}

public CompanyInfo getCompany() {
	return company;
}
public void setCompany(CompanyInfo company) {
	this.company = company;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public VersionInfo getVerInfo() {
	return verInfo;
}
public void setVerInfo(VersionInfo verInfo) {
	this.verInfo = verInfo;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
}
