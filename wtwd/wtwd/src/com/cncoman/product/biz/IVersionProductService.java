package com.cncoman.product.biz;

import java.util.List;

import com.cncoman.product.bean.VersionProduct;

public interface IVersionProductService {
	public List<VersionProduct> list() ;

	public int save(VersionProduct info) ;

	public int update(VersionProduct info);

	public int delete(int id) ;

	public VersionProduct getInfo(int id);
}
