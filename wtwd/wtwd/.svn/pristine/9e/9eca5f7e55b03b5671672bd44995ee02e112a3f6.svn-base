package com.cncoman.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cncoman.product.bean.VersionInfo;


public class VersionDAO {
	private JdbcTemplate jdbcTemplate;
	public List<VersionInfo> versionlist(int type){
		String sql = "select * from cn_version where type="+type;
		
		return jdbcTemplate.query(sql, new VersionInfoMapper());
	}
	private class VersionInfoMapper implements RowMapper{

		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			VersionInfo info = new VersionInfo();
			info.setId(rs.getInt("id"));
			info.setVer(rs.getString("ver"));
			info.setRemark(rs.getString("remark"));
			info.setCreatTime(rs.getDate("creatTime"));
			info.setExplain(rs.getString("explains"));
			return info;
		}
		
	}
	public int save(VersionInfo info) {
		String sql = "insert into cn_version(ver, remark, creatTime, type, explains)" +
				" values(?, ?, now(), ?, ?)";

		Object[] param = new Object[4];
		param[0] = info.getVer();
		param[1] = info.getRemark();
		param[2] = info.getType();
		param[3] = info.getExplain();
		
		return this.jdbcTemplate.update(sql, param);
	}
	
	public VersionInfo getById(int id){
		String sql = "select * from cn_version where id = " + id;
		return (VersionInfo) jdbcTemplate.queryForObject(sql, new VersionInfoMapper());
	}
	public int update(VersionInfo issue){
		String sql = "update cn_version set remark = ?,ver=?, explains = ?  where id = ?";
		Object[] param = new Object[4];
		param[0] = issue.getRemark();
		param[1] = issue.getVer();
		param[2] = issue.getExplain();
		param[3] = issue.getId();
		
		return jdbcTemplate.update(sql, param);
	}
	
	
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
