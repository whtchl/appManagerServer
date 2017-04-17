package com.cncoman.product.bean;

public class CityInfo extends BaseEntity{

	
	private static final long serialVersionUID = 1L;
	
	private int pid;
	private ProvinceInfo province;
	
	public CityInfo(){
		this.province = province == null ? new ProvinceInfo() : province;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public ProvinceInfo getProvince() {
		return province;
	}

	public void setProvince(ProvinceInfo province) {
		this.province = province;
	}

}
