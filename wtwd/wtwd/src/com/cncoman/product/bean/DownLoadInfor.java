package com.cncoman.product.bean;

import java.io.Serializable;

public class DownLoadInfor implements Serializable{
	/**
	 * 下载详情
	 */
	private static final long serialVersionUID = 1L;
private int id;//id号
private String fileId;//文件id
private int companyCount;//厂家下载统计
private FileInformation fileInfo;//文件信息
private CompanyInfo info;//厂家名称
private String downLoadTime;//下载时间

public int getCompanyCount() {
	return companyCount;
}
public void setCompanyCount(int companyCount) {
	this.companyCount = companyCount;
}
public String getDownLoadTime() {
	return downLoadTime;
}
public void setDownLoadTime(String downLoadTime) {
	this.downLoadTime = downLoadTime;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getFileId() {
	return fileId;
}
public void setFileId(String fileId) {
	this.fileId = fileId;
}
public CompanyInfo getInfo() {
	return info;
}
public void setInfo(CompanyInfo info) {
	this.info = info;
}
public FileInformation getFileInfo() {
	return fileInfo;
}
public void setFileInfo(FileInformation fileInfo) {
	this.fileInfo = fileInfo;
}

}
