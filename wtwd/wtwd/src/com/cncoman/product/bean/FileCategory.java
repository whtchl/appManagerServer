package com.cncoman.product.bean;

import java.io.Serializable;

public class FileCategory implements Serializable{
public FileCategory(){}
	/**
	 * 缤纷乐园 文件�?属类型的�?
	 */
private static final long serialVersionUID = 1L;
private  int IntId;//ID
private  String shotName;//简称
private int FileCount;// 每个类型中的文件个数
private  String Name ;//类型名称
private  int TPosition;//类型�?放的位置
private  String TIcon;//类型名称
private int showId;//显示顺序
private int listId;//集合中的顺序
private int downCount;//下载统计
public int getIntId() {
	return IntId;
}
public void setIntId(int intId) {
	IntId = intId;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getShotName() {
	return shotName;
}
public void setShotName(String shotName) {
	this.shotName = shotName;
}
public String getTIcon() {
	return TIcon;
}
public String setTIcon(String icon) {
	return TIcon = icon;
}
public int getTPosition() {
	return TPosition;
}
public void setTPosition(int position) {
	TPosition = position;
}
public int getShowId() {
	return showId;
}
public void setShowId(int showId) {
	this.showId = showId;
}
public int getListId() {
	return listId;
}
public void setListId(int listId) {
	this.listId = listId;
}
public int getFileCount() {
	return FileCount;
}
public void setFileCount(int fileCount) {
	FileCount = fileCount;
}
public int getDownCount() {
	return downCount;
}
public void setDownCount(int downCount) {
	this.downCount = downCount;
}
}
