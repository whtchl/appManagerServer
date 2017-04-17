package com.cncoman.product.biz;

import java.util.List;

import com.cncoman.product.bean.ResourceInfo;

public interface IResourceService {
	
	/**
	 * 系统资源列表
	 * @param ids 资源id序列,空为所有
	 * @return
	 */
	public List<ResourceInfo> list(String ids, int domain, int grade);
	
	public List<ResourceInfo> list(String ids);
	
	public List<ResourceInfo> list(int domain);
	
	public List<ResourceInfo> list(int grade, int domain);

	/**
	 * 所有系统资源列表
	 * @return
	 */
	public List<ResourceInfo> list();
	
	public int saveResource(ResourceInfo info);
	
	public ResourceInfo getInfo(int id);
	
	public int updateResource(ResourceInfo info);

	public List<ResourceInfo> list(int grade, int domain, String name);
}
