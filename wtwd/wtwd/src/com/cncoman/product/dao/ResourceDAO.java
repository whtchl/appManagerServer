package com.cncoman.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.cncoman.product.bean.ResourceInfo;
import com.cncoman.product.util.StringUtil;

public class ResourceDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public List<ResourceInfo> list(String ids, int domain, int grade){
		String sql = "select * from cn_resource where true";
		if(!StringUtil.isNull(ids))
			sql += " and id in(" + ids + ")";
		if(domain > 0)
			sql += " and (domain = 0 or domain = " + domain + ")";
		if(grade > 0)
			sql += " and grade = " + grade;
		sql += " order by sort asc";		
		return jdbcTemplate.query(sql, new ResourceInfoMapper());
	}
	
	public List<ResourceInfo> list(int grade, int domain, String name) {
		String sql = "select * from cn_resource where true";
		if(!StringUtil.isNull(name))
			sql += " and name like '%" + name + "%' or url like '%" + name + "%'";
		if(domain > 0)
			sql += " and (domain = 0 or domain = " + domain + ")";
		if(grade > 0)
			sql += " and grade = " + grade;
		sql += " order by sort asc";		
		return jdbcTemplate.query(sql, new ResourceInfoMapper());
	}
	
	public int saveResource(ResourceInfo info){
		String sql = "insert into cn_resource(name, grade, url, parentId, remark, domain, sort, extPanelName) values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[8];
		param[0] = info.getName();
		param[1] = info.getGrade();
		param[2] = info.getUrl();
		param[3] = info.getParentId();
		param[4] = info.getRemark();
		param[5] = info.getDomain();
		param[6] = info.getSort();
		param[7] = info.getExtPanelName();
		return jdbcTemplate.update(sql, param);
	}
	
	public int updateResource(ResourceInfo info){
		String sql = "update cn_resource set name = ?, grade = ?, url = ?, parentId = ?, remark = ?, domain = ?, sort = ?, extPanelName = ? where id = ?";
		Object[] param = new Object[9];
		param[0] = info.getName();
		param[1] = info.getGrade();
		param[2] = info.getUrl();
		param[3] = info.getParentId();
		param[4] = info.getRemark();
		param[5] = info.getDomain();
		param[6] = info.getSort();
		param[7] = info.getExtPanelName();
		param[8] = info.getIntId();
		return jdbcTemplate.update(sql, param);
	}
	
	public ResourceInfo getResourceInfo(int id){
		String sql = "select * from cn_resource where id = " + id;
		return (ResourceInfo) jdbcTemplate.query(sql, new ResourceInfoMapper()).get(0);
	}
	
	public boolean hasChildren(int id){
		boolean flag = false;
		String sql = "select * from cn_resource where parentId = " + id;
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		if(rs.next())
			flag = true;
		return flag;
	}
	
	private class ResourceInfoMapper implements RowMapper{

		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			ResourceInfo info = new ResourceInfo();
			info.setIntId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setGrade(rs.getInt("grade"));
			info.setUrl(rs.getString("url"));
			info.setParentId(rs.getInt("parentId"));
			info.setRemark(rs.getString("remark"));
			info.setDomain(rs.getInt("domain"));
			info.setSort(rs.getInt("sort"));
			info.setExtPanelName(rs.getString("extPanelName"));
			return info;
		}
		
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
