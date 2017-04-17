package com.cncoman.product.biz.impl;

import java.util.List;

import com.cncoman.product.biz.IResourceService;
import com.cncoman.product.dao.ResourceDAO;
import com.cncoman.product.bean.ResourceInfo;

public class ResourceServiceImpl implements IResourceService {
	
	private ResourceDAO dao;

	public List<ResourceInfo> list(String ids, int domain, int grade) {
		List<ResourceInfo> l = dao.list(ids, domain, grade);	
		for(ResourceInfo r : l){
			if(r.getGrade() == 1){
				r.setHasChild(true);
			}else if(r.getGrade() == 2){
				r.setHasChild(dao.hasChildren(r.getIntId()));
			}else{
				r.setHasChild(false);
			}
		}
		return l;
	}
	
	public List<ResourceInfo> list(){
		return list(null, 0, 0);
	}
	
	public List<ResourceInfo> list(String ids){
		return list(ids, 0, 0);
	}
	
	public List<ResourceInfo> list(int domain){
		return list(null, domain, 0);
	}
	
	public List<ResourceInfo> list(int grade, int domain){
		
		return list(null, domain, grade);
	}

	public int saveResource(ResourceInfo info){
		
		return dao.saveResource(info);
	}
	
	public ResourceInfo getInfo(int id){
		return dao.getResourceInfo(id);
	}
	
	public int updateResource(ResourceInfo info){
		return dao.updateResource(info);
	}
	
	public void setDao(ResourceDAO dao) {
		this.dao = dao;
	}

	public List<ResourceInfo> list(int grade, int domain, String name) {
		return dao.list( grade,  domain,  name);
	}

}
