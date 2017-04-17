package com.cncoman.product.biz.impl;

import java.util.List;

import com.cncoman.product.bean.VersionProduct;
import com.cncoman.product.biz.IVersionProductService;
import com.cncoman.product.dao.VersionProductDAO;

public class VersionProductServiceImpl implements IVersionProductService {
	private VersionProductDAO dao;

	public VersionProductDAO getDao() {
		return dao;
	}

	public void setDao(VersionProductDAO dao) {
		this.dao = dao;
	}

	public List<VersionProduct> list() {

		return dao.list();
	}

	public int save(VersionProduct info) {

		return dao.save(info);
	}

	public int update(VersionProduct info) {

		return dao.update(info);
	}

	public int delete(int id) {

		return dao.delete(id);
	}

	public VersionProduct getInfo(int id) {
		return dao.getInfo(id);
	}
}
