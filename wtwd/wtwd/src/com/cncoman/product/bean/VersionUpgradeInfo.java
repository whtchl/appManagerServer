package com.cncoman.product.bean;

public class VersionUpgradeInfo extends BaseInfo{
	private static final long serialVersionUID = 1L;
	private String title;
	private String man;
	private String mac;
	private String ver;
	private String day;
	private int groupBy;
	private int userCount;
	private int userCountTotal;
	private String imei;
	private String oldVersion;
	private String newVetsion;
	
	
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getOldVersion() {
		return oldVersion;
	}
	public void setOldVersion(String oldVersion) {
		this.oldVersion = oldVersion;
	}
	public String getNewVetsion() {
		return newVetsion;
	}
	public void setNewVetsion(String newVetsion) {
		this.newVetsion = newVetsion;
	}
	public VersionUpgradeInfo(){
		this.setFromDay(this.monthFirstDay);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMan() {
		return man;
	}
	public void setMan(String man) {
		this.man = man;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getGroupBy() {
		return groupBy;
	}
	public void setGroupBy(int groupBy) {
		this.groupBy = groupBy;
	}
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	public int getUserCountTotal() {
		return userCountTotal;
	}
	public void setUserCountTotal(int userCountTotal) {
		this.userCountTotal = userCountTotal;
	}
	
	
	
}
