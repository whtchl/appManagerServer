package com.cncoman.product.bean;

import java.util.List;

public class RoleInfo extends BaseEntity
{
  private static final long serialVersionUID = 1L;
  private String valid;
  private String purview;
  private String remark;
  private String addTime;
  private int userCount;
  private Integer[] resourceIds;
  private List<ResourceInfo> resourceList;
  private int uid;
  private String userName;
  private int isPublic;
  private int mosId;

  public int getMosId() {
	return mosId;
}
public void setMosId(int mosId) {
	this.mosId = mosId;
}
public String getAddTime()
  {
    return this.addTime;
  }
  public void setAddTime(String addTime) {
    this.addTime = addTime;
  }
  public String getPurview() {
    return this.purview;
  }
  public void setPurview(String purview) {
    this.purview = purview;
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
  public List<ResourceInfo> getResourceList() {
    return this.resourceList;
  }
  public void setResourceList(List<ResourceInfo> resourceList) {
    this.resourceList = resourceList;
  }
  public int getUserCount() {
    return this.userCount;
  }
  public void setUserCount(int userCount) {
    this.userCount = userCount;
  }

  public int getUid() {
    return this.uid;
  }
  public void setUid(int uid) {
    this.uid = uid;
  }
  public Integer[] getResourceIds() {
    return this.resourceIds;
  }
  public void setResourceIds(Integer[] resourceIds) {
    this.resourceIds = resourceIds;
  }
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public int getIsPublic() {
	return isPublic;
}
public void setIsPublic(int isPublic) {
	this.isPublic = isPublic;
}
}
