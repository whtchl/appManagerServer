package com.cncoman.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.cncoman.product.bean.CompanyInfo;
import com.cncoman.product.bean.VersionInfo;
import com.cncoman.product.bean.VersionManage;
import com.cncoman.product.util.Initialize;
import com.cncoman.product.util.StringUtil;

public class VersionManageDAO {
	private JdbcTemplate jdbcTemplate;
	public int save(VersionManage info) {
		String sql = "insert into cn_version_manage(versionId, path, code, issue, remarks,name,size,uploadTime,type, mach)" +
				" values( ?,?, ?, ?, ?,?,?, now(),?, ?)";

		Object[] param = new Object[9];
		param[0] = info.getVersionId();
		param[1] = info.getPath();
		param[2] = info.getCode();
		param[3] = info.getIssue();
		param[4] = info.getRemark();
		param[5] = info.getName();
		param[6] = info.getSize();
		param[7] = info.getType();
		param[8] = info.getMach();
		return this.jdbcTemplate.update(sql, param);
	}
	public List<VersionManage> versionManagelist(String issue,String versionId,String code,int from,int to,int type){
		String sql = "select a.*,b.ver ver from cn_version_manage a,cn_version b where 1=1 and a.versionId=b.id ";
		if(!StringUtil.isNull(issue)&&!issue.equals("-1")){
		     sql=sql+" and issue="+issue+"" ;
		}
		if(!StringUtil.isNull(versionId)&&!versionId.equals("-1")){
		     sql=sql+" and versionId ='"+versionId+"'";
		}
		/*if(!StringUtil.isNull(code)&&!code.equals("-1")){
		     sql=sql+" and code='"+code+"'";
		}*/
		
		 sql=sql+" and a.type="+type;
		
		
		sql=sql+" order by id desc";
		
		sql=sql+" limit " + from + ", " + to;
				
		
		return jdbcTemplate.query(sql, new VersionManageInfoMapper());
	}
	private class VersionManageInfoMapper implements RowMapper{

		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			VersionManage info = new VersionManage();
			info.setId(rs.getInt("id"));
			
			CompanyInfo	compbean = Initialize.companyMap.get(rs.getString("code"));
			
			info.setCompany(compbean);
			info.setCode(rs.getString("code"));
			info.setIssue(rs.getInt("issue")+"");
			info.setName(rs.getString("name"));
			info.setUploadTime(rs.getDate("uploadTime"));
			info.setMach(rs.getString("mach"));
			info.setRemark(rs.getString("remarks"));
			
			VersionInfo verinfo=new VersionInfo();
			verinfo.setVer(rs.getString("ver"));
			
			info.setVerInfo(verinfo);
			info.setVersionId(rs.getString("versionId"));
					
			return info;
		}
		
	}
	
	public int countManageInfo(String issue,String versionId,String code,int type) {
		
		
		String sql = "select count(1) from cn_version_manage where 1=1 ";
		
			if(!StringUtil.isNull(issue)&&!issue.equals("-1")){
			     sql=sql+" and issue="+issue+"" ;
			}
			if(!StringUtil.isNull(versionId)&&!versionId.equals("-1")){
			     sql=sql+" and versionId ='"+versionId+"'";
			}
			/*if(!StringUtil.isNull(code)&&!code.equals("-1")){
			     sql=sql+" and code='"+code+"'";
			}*/
			  sql=sql+" and type="+type+"";
		return jdbcTemplate.queryForInt(sql);
	}
	
	
	
	
	public int update(String issue,int id){
		String sql = "update cn_version_manage set issue = ?  where id = ?";
		Object[] param = new Object[2];
		param[0] = issue;
		param[1] = id;
		
		return jdbcTemplate.update(sql, param);
	}
	public int delete(int id){

		String sql = "delete from cn_version_manage where id = " + id ;
		return jdbcTemplate.update(sql);
	}
	
	public VersionManage getCompanyVersion(int id){
		String sql = "select a.*,b.ver ver from cn_version_manage a,cn_version b where a.id = " + id + " and a.versionId=b.id ";
		List<VersionManage> list = jdbcTemplate.query(sql, new VersionManageInfoMapper());
		return list == null || list.size() <= 0 ? null : list.get(0);
	}
	
	public int update(VersionManage vm){
		String sql = "update cn_version_manage set mach = '" + vm.getMach() + "', name = '" + vm.getName() + "', issue = " + vm.getIssue() + ", remarks = '" + vm.getRemark() + "' where id = " + vm.getId();
		return jdbcTemplate.update(sql);
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
