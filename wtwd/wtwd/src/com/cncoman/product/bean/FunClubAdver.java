package com.cncoman.product.bean;

import java.io.Serializable;

public class FunClubAdver implements Serializable {
/**
	 * 广告
	 */
	private static final long serialVersionUID = 1L;
private int intId;
private String name;
private String furl;
private String shotName;
private String code; 
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
} 
public String getFurl() {
	return furl;
}
public void setFurl(String furl) {
	this.furl = furl;
}
public int getIntId() {
	return intId;
}
public void setIntId(int intId) {
	this.intId = intId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getShotName() {
	return shotName;
}
public void setShotName(String shotName) {
	this.shotName = shotName;
}

}
