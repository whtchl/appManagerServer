package com.cncoman.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.cncoman.product.bean.CompanyInfo;
import com.cncoman.product.bean.UserInfo;
import com.cncoman.product.util.Constants;
import com.cncoman.product.bean.PersonInfo;
import com.cncoman.product.bean.RoleInfo;
import com.cncoman.product.util.StringUtil;

public class UsersDAO {
	protected JdbcTemplate jdbcTemplate;

	public List<UserInfo> list(int roleId, int companyId, int departmentId,
			int from, int to, String companyIds, int uid, String valid, UserInfo curUser, int domain) {
		StringBuilder sb = new StringBuilder();
		sb
				.append("select b.name roleName, c.name companyName, c.code, c.icon, c.contact, b.purview, a.* from cn_users a, cn_role b, cn_company c where a.roleId = b.id and a.companyId = c.id");
		if (!StringUtil.isNull(valid))
			sb.append(" and a.valid = '" + valid + "' and b.valid = '" + valid
					+ "'");
		if (!StringUtil.isNull(companyIds))
			sb.append(" and a.companyId in(" + companyIds + ")");
		if (roleId > 0)
			sb.append(" and a.roleId = " + roleId);
		if(curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_ADMIN_ID && curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_SALE_ADMIN_ID && curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_PROD_ID)			
			sb.append(" and a.uid = " + curUser.getIntId());
			
		if(domain > 0)
			sb.append(" and a.validDomain = " + domain);
		if (companyId > 0)
			sb.append(" and a.companyId = " + companyId);
		if (departmentId > 0) {
			sb.append(" and a.departmentId = " + departmentId);
		}
		if (uid > 1)
			sb.append(" and a.id != " + uid);
		sb.append(" order by create_time desc");
		if ((from > 0) && (to > 0))
			sb.append(" limit " + from + ", " + to);		
		return this.jdbcTemplate.query(sb.toString(), new UserMapper());
	}

	public int userCount(int roleId, int companyId, int departmentId,
			String companyIds, UserInfo curUser, String valid, int domain) {
		StringBuilder sb = new StringBuilder();
		sb
				.append("select count(1) from cn_users a, cn_role b, cn_company c where a.roleId = b.id and a.companyId = c.id and a.valid = 'Y'");
		if (!StringUtil.isNull(valid))
			sb.append(" and a.valid = '" + valid + "'");
		if (!StringUtil.isNull(companyIds))
			sb.append(" and a.companyId in(" + companyIds + ")");
		if (roleId > 0)
			sb.append(" and a.roleId = " + roleId);
		if(curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_ADMIN_ID && curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_SALE_ADMIN_ID)			
			sb.append(" and a.uid = " + curUser.getIntId());
		if (companyId > 0)
			sb.append(" and a.companyId = " + companyId);
		if (departmentId > 0)
			sb.append(" and a.departmentId = " + departmentId);
		if (curUser.getIntId() > 1)
			sb.append(" and a.id != " + curUser.getIntId());
		if(domain > 0)
			sb.append(" and a.validDomain = " + domain);
		return this.jdbcTemplate.queryForInt(sb.toString());
	}

	public UserInfo getInfo(String loginId, int flag) {
		String sql = "select b.name roleName, c.name companyName, c.code, c.icon, c.contact,  b.purview, a.* from cn_users a, cn_role b, cn_company c " +
				"where a.roleId = b.id and a.companyId = c.id and a.valid = 'Y' and a.login_id = '"
				+ loginId + "' and a.validDomain = " + flag;
		List list = this.jdbcTemplate.query(sql, new UserMapper());
		return (list != null) && (list.size() > 0) ? (UserInfo) list.get(0)
				: null;
	}

	public UserInfo getInfo(String loginId) {
		String sql = "select b.name roleName, c.name companyName, c.code, c.icon, c.contact,  b.purview, a.* from cn_users a, cn_role b, cn_company c where a.roleId = b.id and a.companyId = c.id and a.valid = 'Y' and a.login_id = '"
				+ loginId + "'";
		List list = this.jdbcTemplate.query(sql, new UserMapper());
		return (list != null) && (list.size() > 0) ? (UserInfo) list.get(0)
				: null;
	}

	public UserInfo getInfo(int id) {
		String sql = "select b.name roleName, c.name companyName, c.code,  c.icon, c.contact, b.purview, a.* from cn_users a, cn_role b, cn_company c where a.roleId = b.id and a.companyId = c.id and a.id = '"
				+ id + "'";
		List list = this.jdbcTemplate.query(sql, new UserMapper());
		return (list != null) && (list.size() > 0) ? (UserInfo) list.get(0)
				: null;
	}

	public int save(UserInfo info) {
		String sql = "insert into cn_users(login_id, password, name, companyId, roleId, incomeRate, phoneSaleRate, last_access_time, access_times, ip, create_time," +
				" valid, remark, validDomain, departmentId, machs, pids, cids, uid, mobile, tel, QQ, email, shortMob, brandIds,roleMosId)" +
				" values(?, ?, ?, ?, ?, ?, ?, now(), ?, ?, now(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

		Object[] param = new Object[24];
		param[0] = info.getLoginId();
		param[1] = info.getPwd();
		param[2] = info.getName();
		param[3] = Integer.valueOf(info.getCompany().getIntId());
		param[4] = Integer.valueOf(info.getRole().getIntId());
		param[5] = Float.valueOf(info.getIncomeRate());
		param[6] = Float.valueOf(info.getPhoneSaleRate());
		param[7] = Integer.valueOf(info.getAccessTimes());
		param[8] = info.getIp();
		param[9] = info.getValid();
		param[10] = info.getRemark();
		param[11] = Integer.valueOf(info.getValidDomain());
		param[12] = Integer.valueOf(info.getDepartmentId());
		param[13] = info.getMach();
		param[14] = info.getPidStrs();
		param[15] = info.getCidStrs();
		param[16] = info.getUid();
		PersonInfo person = info.getPersonInfo();
		person = person == null ? new PersonInfo() : person;
		param[17] = person.getMobile();
		param[18] = person.getTel();
		param[19] = person.getQq();
		param[20] = person.getEmail();
		param[21] = person.getShortMob();
		param[22] = info.getBrandIdStr();
		param[23] = info.getRole().getMosId();
		return this.jdbcTemplate.update(sql, param);
	}

	public int deleteUser(int id, UserInfo curUser) {
		String sql = "delete from cn_users where id = " + id;
		if (curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_ADMIN_ID) {
			sql = sql + " and companyId = " + curUser.getCompany().getIntId();
		}
		return this.jdbcTemplate.update(sql);
	}
	
	public int deleteUserByRoleId(int roleId, UserInfo curUser) {
		String sql = "delete from cn_users where roleId = " + roleId;
		if (curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_ADMIN_ID) {
			sql = sql + " and companyId = " + curUser.getCompany().getIntId();
		}
		return this.jdbcTemplate.update(sql);
	}

	public int updateInfo(UserInfo info, UserInfo curUser) {
		String sql = "update cn_users set login_id = ?, password = ?, name = ?, companyId = ?, roleId = ?, incomeRate = ?, phoneSaleRate = ?, last_access_time = now(), " +
				" access_times = ?, ip = ?, valid = ?, remark = ?, departmentId = ?, validDomain = ?, machs = ?, pids = ?, cids = ?, mobile = ?, tel = ?, shortMob = ?, " +
				" QQ = ?, email = ?, brandIds = ?,roleMosId=? where id = ?";

		if (curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_ADMIN_ID) {
			sql = sql + " and companyId = " + curUser.getCompany().getIntId();
		}
		Object[] param = new Object[24];
		param[0] = info.getLoginId();
		param[1] = info.getPwd();
		param[2] = info.getName();
		param[3] = Integer.valueOf(info.getCompany().getIntId());
		param[4] = Integer.valueOf(info.getRole().getIntId());
		param[5] = Float.valueOf(info.getIncomeRate());
		param[6] = Float.valueOf(info.getPhoneSaleRate());
		param[7] = Integer.valueOf(info.getAccessTimes());
		param[8] = info.getIp();
		param[9] = info.getValid();
		param[10] = info.getRemark();
		param[11] = Integer.valueOf(info.getDepartmentId());
		param[12] = Integer.valueOf(info.getValidDomain());
		param[13] = info.getMach();
		param[14] = info.getPidStrs();
		param[15] = info.getCidStrs();
		PersonInfo person = info.getPersonInfo();
		person = person == null ? new PersonInfo() : person;
		param[16] = person.getMobile();
		param[17] = person.getTel();
		param[18] = person.getShortMob();
		param[19] = person.getQq();
		param[20] = person.getEmail();
		param[21] = info.getBrandIdStr();
		param[22] = info.getRole().getMosId();
		param[23] = Integer.valueOf(info.getIntId());
		return this.jdbcTemplate.update(sql, param);
	}
	
	public int updateInfoForLogin(UserInfo info, UserInfo curUser){
		String sql = "update cn_users set last_access_time = now(), access_times = ?, ip = ? where id = ?";
		if (curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_ADMIN_ID) {
			sql = sql + " and companyId = " + curUser.getCompany().getIntId();
		}
		Object[] param = new Object[3];
		param[0] = info.getAccessTimes();
		param[1] = info.getIp();
		param[2] = info.getIntId();
		return jdbcTemplate.update(sql, param);
	}
	public int updateMosid(RoleInfo info, UserInfo curUser){
		String sql = "update cn_users set roleMosId =? where roleId = ?";
		if (curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_ADMIN_ID) {
			sql = sql + " and companyId = " + curUser.getCompany().getIntId();
		}
		Object[] param = new Object[2];
		param[0] = info.getMosId();
		param[1] = info.getIntId();
		
		return jdbcTemplate.update(sql, param);
	}

	public int updateRole(RoleInfo role, UserInfo curUser) {
		String sql = "update cn_role set purview = ?, name = ?, remark = ?, valid = ?, isPublic = ?,mosId=? where id = ?";		
		if (curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_ADMIN_ID && curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_SALE_ADMIN_ID) {
			sql += " and uid = " + curUser.getIntId() + " and isPublic <> " + Constants.SALE_SYSTEM_PUBLIC_ROLE_FLAG;
		}
		Object[] param = new Object[7];
		param[0] = role.getPurview();
		param[1] = role.getName();
		param[2] = role.getRemark();
		param[3] = role.getValid();
		param[4] = role.getIsPublic();
		param[5] = role.getMosId();
		param[6] = Integer.valueOf(role.getIntId());
		return this.jdbcTemplate.update(sql, param);
	}

	public int unableUser(int id) {
		String sql = "update cn_users set valid = 'N' where id = " + id;
		return this.jdbcTemplate.update(sql);
	}

	public List<RoleInfo> roleList(UserInfo curUser) {
//		String sql = "select a.*, count(b.id) userCount from cn_role a left join cn_users b on(a.id = b.roleId) where true";
//		if ((curUser != null) && (curUser.getRole().getIntId() == 2))   //兼职商务的角色列表，待验证取消此条。2011-09-01
//			sql = sql + " and a.id in(3,4,5)";
//		if (curUser.getRole().getIntId() > 2 && curUser.getRole().getIntId() != Constants.SYSTEM_ROLE_SALE_ADMIN_ID) {
//			sql = sql + " and a.uid = " + curUser.getIntId()
//					+ " and a.valid = 'Y'";
//		}else{
//			sql += " and a.valid = 'Y' and a.companyId = " + curUser.getCompany().getIntId();
//		}
//		sql = sql + " group by a.id";		
		String sql = "select * from cn_role where (uid in(select id from cn_users where roleId in " +
				"(select id from cn_role where uid = " + curUser.getIntId() + " and valid = 'Y')) or uid = " + curUser.getIntId() + " or isPublic = " + Constants.SALE_SYSTEM_PUBLIC_ROLE_FLAG + ") and valid = 'Y'";
		if(curUser.getRole().getIntId() == Constants.SYSTEM_ROLE_ADMIN_ID){
			sql = "select * from cn_role";
		}
		List<RoleInfo> list = new ArrayList<RoleInfo>();
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sql);
		RoleInfo info = null;
		while (rs.next()) {
			info = new RoleInfo();
			info.setIntId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setValid(rs.getString("valid"));
			info.setPurview(rs.getString("purview"));
			info.setRemark(rs.getString("remark"));
			info.setAddTime(rs.getString("addTime"));
			info.setIsPublic(rs.getInt("isPublic"));
			//info.setUserCount(rs.getInt("userCount"));
			list.add(info);
		}		
		return list;
	}
	
	public List<RoleInfo> roleList(String ids) {	
		String sql  = "select * from cn_role where id in(" + ids + ")";		
		List<RoleInfo> list = new ArrayList<RoleInfo>();
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sql);
		RoleInfo info = null;
		while (rs.next()) {
			info = new RoleInfo();
			info.setIntId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setValid(rs.getString("valid"));
			info.setPurview(rs.getString("purview"));
			info.setRemark(rs.getString("remark"));
			info.setAddTime(rs.getString("addTime"));
			info.setIsPublic(rs.getInt("isPublic"));			
			list.add(info);
		}
		return list;
	}

	public int createRole(RoleInfo role) {
		String sql = "insert into cn_role(name, valid, purview, remark, addTime, uid, isPublic,mosId) values(?, 'Y', ?, ?, now(), ?, ?,?)";
		Object[] param = new Object[6];
		param[0] = role.getName();
		param[1] = role.getPurview();
		param[2] = role.getRemark();
		param[3] = Integer.valueOf(role.getUid());
		param[4] = role.getIsPublic();
		param[5] = role.getMosId();
		return this.jdbcTemplate.update(sql, param);
	}

	public RoleInfo getRole(int id) {
		RoleInfo info = null;
		String sql = "select * from cn_role where id = " + id;
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet(sql);
		if (rs.next()) {
			info = new RoleInfo();
			info.setIntId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setValid(rs.getString("valid"));
			info.setPurview(rs.getString("purview"));
			info.setRemark(rs.getString("remark"));
			info.setAddTime(rs.getString("addTime"));
			info.setUid(rs.getInt("uid"));
			info.setIsPublic(rs.getInt("isPublic"));
			info.setMosId(rs.getInt("mosId"));
		}
		return info;
	}

	public int deleteRole(int id){
		String sql = "delete from cn_role where id = " + id;
		return jdbcTemplate.update(sql);
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	protected class UserMapper implements RowMapper {
		protected UserMapper() {
		}

		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserInfo info = new UserInfo();
			info.setIntId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setLoginId(rs.getString("login_id"));
			info.setPwd(rs.getString("password"));
			info.setDepartmentId(rs.getInt("departmentId"));
			info.setIncomeRate(rs.getFloat("incomeRate"));
			info.setPhoneSaleRate(rs.getFloat("phoneSaleRate"));
			info.setLastAccessTime(rs.getString("last_access_time"));
			info.setAccessTimes(rs.getInt("access_times"));
			info.setIp(rs.getString("ip"));
			info.setCreateTime(rs.getString("create_time"));
			info.setValid(rs.getString("valid"));
			info.setRemark(rs.getString("remark"));
			info.setValidDomain(rs.getInt("validDomain"));
			info.setMach(rs.getString("machs"));
			info.setCidStrs(rs.getString("cids"));
			info.setPidStrs(rs.getString("pids"));
			info.setIsAllMac(StringUtil.isNull(info.getMach()) ? 0 : 1);
			info.setIsAllArea(StringUtil.isNull(info.getCidStrs()) && StringUtil.isNull(info.getPidStrs()) ? 0 : 1);
			info.setBrandIdStr(rs.getString("brandIds"));
			info.setIsAllBrand(StringUtil.isNull(info.getBrandIdStr()) ? 0 : 1);

			CompanyInfo company = new CompanyInfo();
			company.setName(rs.getString("companyName"));
			company.setIntId(rs.getInt("companyId"));
			company.setCode(rs.getString("code"));
			company.setIcon(rs.getString("icon"));
			company.setContactInfo(rs.getString("contact"));
			info.setCompany(company);

			RoleInfo role = new RoleInfo();
			role.setName(rs.getString("roleName"));
			role.setPurview(rs.getString("purview"));
			role.setIntId(rs.getInt("roleId"));		
			info.setRole(role);
			
			PersonInfo person = new PersonInfo();
			person.setMobile(rs.getString("mobile"));
			person.setQq(rs.getString("QQ"));
			person.setEmail(rs.getString("email"));
			person.setShortMob(rs.getString("shortMob"));
			person.setTel(rs.getString("tel"));
			info.setPersonInfo(person);
			
			return info;
		}
	}
}
