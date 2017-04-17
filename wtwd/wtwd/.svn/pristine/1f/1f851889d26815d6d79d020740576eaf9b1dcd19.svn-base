package com.cncoman.product.bean;

public class ResourceInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int grade;
	private String url;
	private int parentId;
	private String remark;
	private boolean hasChild;
	private int domain;
	private int sort;
	private String extPanelName;
	
	
	public String getExtPanelName() {
		return extPanelName;
	}
	public void setExtPanelName(String extPanelName) {
		this.extPanelName = extPanelName;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof ResourceInfo))
			return false;
		final ResourceInfo resource = (ResourceInfo) other;
		if (!resource.getUrl().equals(getUrl()))
			return false;
		return true;
	}

	public int hashCode() {
		return url.hashCode();
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public boolean isHasChild() {
		return hasChild;
	}
	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}
	public int getDomain() {
		return domain;
	}
	public void setDomain(int domain) {
		this.domain = domain;
	}

}
