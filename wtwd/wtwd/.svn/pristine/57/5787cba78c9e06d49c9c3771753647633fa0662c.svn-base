package com.cncoman.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cncoman.product.bean.VersionProduct;



public class VersionProductDAO {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public List<VersionProduct> list(){
		String sql = "select * from cn_version_product ";
		
			sql += " order by  id desc " ;
		return jdbcTemplate.query(sql, new ProductfoMapper());
	}
	
	public int save(VersionProduct info){
		String sql = "insert into cn_version_product(productName, remark) values(?, ?)";
		Object[] param = new Object[2];
		param[0] = info.getProductName();
		param[1] = info.getRemark();
		
		
		return jdbcTemplate.update(sql, param);
	}
	
	public int update(VersionProduct info){
		String sql = "update cn_version_product set productName = ?, remark = ? where id = ?";
		Object[] param = new Object[3];
		param[0] = info.getProductName();
		param[1] = info.getRemark();
		
		param[2] = info.getId();
		return jdbcTemplate.update(sql, param);
	}
	
	public int delete(int id){
		String sql = "delete from cn_version_product where id = " + id;
		return jdbcTemplate.update(sql);
	}
	
	public VersionProduct getInfo(int id){
		String sql = "select * from cn_version_product where id = " + id;
		List<VersionProduct> list = jdbcTemplate.query(sql, new ProductfoMapper());
		return list == null || list.size() <= 0 ? null : list.get(0);
	}
	

	
	private class ProductfoMapper implements RowMapper{

		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			VersionProduct info = new VersionProduct();
			info.setId(rs.getInt("id"));
			info.setProductName(rs.getString("productName"));
			info.setRemark(rs.getString("remark"));

			return info;
		}
		
	}
}
