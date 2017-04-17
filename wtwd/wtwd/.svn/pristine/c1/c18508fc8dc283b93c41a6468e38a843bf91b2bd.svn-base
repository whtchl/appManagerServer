package com.cncoman.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.cncoman.product.bean.CompanyInfo;

/*import com.cncoman.product.bean.CustomerMachineInfo;*/
/*import com.cncoman.product.bean.OpinionInfo;*/

/*import com.cncoman.product.bean.TipsInfo;*/
import com.cncoman.product.util.Initialize;
import com.cncoman.product.bean.PersonInfo;
import com.cncoman.product.util.StringUtil;

public class CustomerServiceDAO {
	private JdbcTemplate jdbcTemplate;

	// /////////////////////////////优惠活动/////////////////////////////////////////////
	

	// /////////////////////////////销售网络/////////////////////////////////////////////////
/*	public int saveSaleNetWork(SaleNetWorkInfo info) {
		String sql = "insert into cn_cs_salenetwork(companyCode, pid, cid, name, content, createTime, telephonenumber) values(?, ?, ?, ?, ?, now(), ?)";
		Object[] param = new Object[6];
		param[0] = info.getCompanyCode();
		param[1] = info.getPid();
		param[2] = info.getCid();
		param[3] = info.getName();
		param[4] = info.getAdd();
		param[5] = info.getTel();
		return jdbcTemplate.update(sql, param);
	}

	public int updateSaleNetWork(SaleNetWorkInfo info) {
		String sql = "update cn_cs_salenetwork set pid = ?, cid = ?, name = ?, content = ?, telephonenumber = ? where id = ? and companyCode = ?";
		Object[] param = new Object[7];
		param[0] = info.getPid();
		param[1] = info.getCid();
		param[2] = info.getName();
		param[3] = info.getAdd();
		param[4] = info.getTel();
		param[5] = info.getIntId();
		param[6] = info.getCompanyCode();
		return jdbcTemplate.update(sql, param);
	}

	public List<SaleNetWorkInfo> saleNetWorkList(int pid, int cid,
			String companyCode) {
		String sql = "";
		if ("1047".equals(companyCode) || "1049".equals(companyCode)
				|| "1048".equals(companyCode) || "1050".equals(companyCode)
				|| "1051".equals(companyCode)) {
			sql = "select * from cn_cs_salenetwork where (companyCode = '1047' or companyCode = '1049' or companyCode = '1048' or companyCode = '1050' or companyCode = '1051')";
		} else {
			sql = "select * from cn_cs_salenetwork where companyCode = '"
					+ companyCode + "'";
		}
		if (pid > 0)
			sql += " and pid = " + pid;
		if (cid > 0)
			sql += " and cid = " + cid;
		return jdbcTemplate.query(sql, new SaleNetWorkMapper());
	}

	public int deleteSaleNetWork(SaleNetWorkInfo info) {
		String sql = "delete from cn_cs_salenetwork where companyCode = '"
				+ info.getCompanyCode() + "' and id = " + info.getIntId();
		return jdbcTemplate.update(sql);
	}

	public SaleNetWorkInfo getSaleNetWork(int id, String companyCode) {
		String sql = "";
		if ("1047".equals(companyCode) || "1049".equals(companyCode)) {
			sql = "select * from cn_cs_salenetwork where (companyCode = '1047' || companyCode = '1049') and id = "
					+ id;
		} else {
			sql = "select * from cn_cs_salenetwork where companyCode = '"
					+ companyCode + "' and id = " + id;
		}
		List<SaleNetWorkInfo> list = jdbcTemplate.query(sql,
				new SaleNetWorkMapper());
		return list == null || list.size() <= 0 ? null : list.get(0);
	}

	private class SaleNetWorkMapper implements RowMapper {
		public SaleNetWorkInfo mapRow(ResultSet rs, int arg1)
				throws SQLException {
			SaleNetWorkInfo info = new SaleNetWorkInfo();
			info.setIntId(rs.getInt("id"));
			info.setPid(rs.getInt("pid"));
			info.setCid(rs.getInt("cid"));
			info.setName(rs.getString("name"));
			info.setAdd(rs.getString("content"));
			info.setTel(rs.getString("telephonenumber"));
			info.setCreateTime(rs.getString("createTime"));
			info.setCity(Initialize.cityIdMap.get(info.getCid()));
			return info;
		}
	}*/

	// /////////////////////////////销售网络结束/////////////////////////////////////////////

	// ////////////////////////////////客户意见反馈///////////////////////////////////////////
	/*public int saveOpinion(OpinionInfo opinion) {
		String sql = "insert into cn_cs_opinion(companyCode, opinion, customerName, mobile, QQ, email, sex, age, job, stamp, imei) values(?, ?, ?, ?, ?, ?, ?, ?, ?, now(), ?)";
		Object[] param = new Object[10];
		param[0] = opinion.getCompanyCode();
		param[1] = opinion.getOpinion();
		PersonInfo person = opinion.getPersonInfo();
		param[2] = person.getName();
		param[3] = person.getMobile();
		param[4] = person.getQq();
		param[5] = person.getEmail();
		param[6] = person.getSex();
		param[7] = person.getAge();
		param[8] = person.getJob();
		param[9] = opinion.getImei();
		return jdbcTemplate.update(sql, param);
	}

	public int deleteOpinion(OpinionInfo opinion) {
		String sql = "delete from cn_cs_opinion where companyCode = '"
				+ opinion.getCompanyCode() + "' and id = " + opinion.getIntId();
		return jdbcTemplate.update(sql);
	}
*/
	// public List<OpinionInfo> opinionList(int from, int to, String keyWord,
	// String fromDay, String toDay, String companyCode){
	// String sql = "";
	// if("1047".equals(companyCode) || "1049".equals(companyCode) ||
	// "1048".equals(companyCode) || "1050".equals(companyCode) ||
	// "1051".equals(companyCode)){
	// sql = "select * from cn_cs_opinion where (companyCode = '1047' or
	// companyCode = '1049' or companyCode = '1048' or companyCode = '1050' or
	// companyCode = '1051')";
	// }else{
	// sql = "select * from cn_cs_opinion where companyCode = '" + companyCode +
	// "'";
	// }
	// if(!StringUtil.isNull(keyWord))
	// sql += " and instr(opinion, '" + keyWord + "') > 0";
	// if(!StringUtil.isNull(fromDay) && !StringUtil.isNull(toDay))
	// sql += " and cast(stamp as date) between '" + fromDay + "' and '" + toDay
	// + "'";
	// sql += " order by stamp desc";
	// sql += " limit " + from + ", " + to;
	// return jdbcTemplate.query(sql, new OpinionInfoMapper());
	// }
	/*public List<OpinionInfo> opinionList(int from, int to, String keyWord,
			String fromDay, String toDay, String companyCode) {

		String sql = "";
		if ("1047".equals(companyCode) || "1049".equals(companyCode)
				|| "1048".equals(companyCode) || "1050".equals(companyCode)
				|| "1051".equals(companyCode)) {
			sql = "select * from cn_cs_opinion where (companyCode = '1047' or companyCode = '1049' or companyCode = '1048' or companyCode = '1050' or companyCode = '1051')";
		} else if (!companyCode.equals("")) {
			sql = "select * from cn_cs_opinion where  companyCode in('"
					+ companyCode + "')";
		} else {
			sql = "select * from cn_cs_opinion where 1=1";
		}
		if (!StringUtil.isNull(keyWord))
			sql += " and opinion like '%" + keyWord + "%'";
		if (!StringUtil.isNull(fromDay) && !StringUtil.isNull(toDay))
			sql += " and  cast(stamp as date) between '" + fromDay + "' and '"
					+ toDay + "'";
		sql += " order by stamp desc";
		sql += " limit " + from + ", " + to;
		return jdbcTemplate.query(sql, new OpinionInfoMapper());
	}*/

	public int opinionCount(String keyWord, String fromDay, String toDay,
			String companyCode) {
		String sql = "";
		if ("1047".equals(companyCode) || "1049".equals(companyCode)
				|| "1048".equals(companyCode) || "1050".equals(companyCode)
				|| "1051".equals(companyCode)) {
			sql = "select count(1) from cn_cs_opinion where (companyCode = '1047' or companyCode = '1049' or companyCode = '1048' or companyCode = '1050' or companyCode = '1051')";
		} else if (!companyCode.equals("")) {
			sql = "select count(1) from cn_cs_opinion where companyCode = '"
					+ companyCode + "'";
		} else {
			sql = "select count(1) from cn_cs_opinion where 1=1";
		}
		if (!StringUtil.isNull(keyWord))
			sql += " and instr(opinion, '" + keyWord + "') > 0";
		if (!StringUtil.isNull(fromDay) && !StringUtil.isNull(toDay))
			sql += " and cast(stamp as date) between '" + fromDay + "' and '"
					+ toDay + "'";
		return jdbcTemplate.queryForInt(sql);
	}

	@SuppressWarnings("unchecked")
/*	public OpinionInfo getOpinion(int id, String companyCode) {
		String sql = "select * from cn_cs_opinion where  id = " + id;
		List<OpinionInfo> list = jdbcTemplate.query(sql,
				new OpinionInfoMapper());
		return list == null || list.size() <= 0 ? null : list.get(0);
	}

	private class OpinionInfoMapper implements RowMapper {

		public OpinionInfo mapRow(ResultSet rs, int arg1) throws SQLException {

			OpinionInfo info = new OpinionInfo();

			info.setIntId(rs.getInt("id"));
			
			if (StringUtil.isNull(rs.getString("errorPic"))) {
				info.setErrorPic("");
			}else {
				info.setErrorPic("http://3g.zhangfun.com"+rs.getString("errorPic"));
			}
			if (StringUtil.isNull(rs.getString("errorLog"))) {
				info.setErrorLog("");
			}else {
				info.setErrorLog("http://3g.zhangfun.com"+rs.getString("errorLog"));
			}
			info.setTitle(rs.getString("title"));
			info.setReply(rs.getString("reply"));
			if (rs.getString("reply")!=null) {
				info.setIsReply(1);
			}
			info.setRepTime(rs.getString("replyTime"));
			info.setCompany(Initialize.companyMap.get(rs
					.getString("companyCode")));
			info.setOpinion(rs.getString("opinion"));
			// info.setName(Initialize.companyMap.get(rs.getString("CompanyCode")));
			info.setCompanyCode(rs.getString("companyCode"));
			info.setCreateTime(rs.getString("stamp"));
			String summary = "";
			if (!StringUtil.isNull(info.getOpinion())) {
				summary = info.getOpinion();
				if (summary.length() > 20) {
					summary = summary.substring(0, 20);
					info.setMoreContent(1);
				}
			}
			info.setSummary(summary);
			info.setImei(rs.getString("mobile"));

			PersonInfo person = new PersonInfo();
			person.setName(rs.getString("customerName"));
			person.setMobile(rs.getString("mobile"));
			person.setQq(rs.getString("QQ"));
			person.setEmail(rs.getString("email"));
			person.setSex(rs.getInt("sex"));
			person.setAge(rs.getInt("age"));
			person.setJob(rs.getString("job"));
			info.setPersonInfo(person);

			return info;
		}

	}*/

	// ////////////////////////////////客户意见反馈结束///////////////////////////////////////////

	// ////////////////////////////////////使用技巧/////////////////////////////////////////////
/*	public List<TipsInfo> tipsList(String companyCode, String keyWord,
			int from, int to) {
		String sql = "";
		if ("1047".equals(companyCode) || "1049".equals(companyCode)
				|| "1048".equals(companyCode) || "1050".equals(companyCode)
				|| "1051".equals(companyCode)) {
			sql = "select * from cn_cs_tips where (companyCode = '1047' or companyCode = '1000' or companyCode = '1049' or companyCode = '1048' or companyCode = '1050' or companyCode = '1051')";
		} else {
			sql = "select * from cn_cs_tips where (companyCode = '"
					+ companyCode + "' or companyCode = '1000')";
		}
		if (!StringUtil.isNull(keyWord))
			sql += " and (instr(title, '" + keyWord
					+ "') > 0 or instr(content, '" + keyWord + "') > 0)";
		sql += " order by createTime desc limit " + from + ", " + to;
		return jdbcTemplate.query(sql, new TipsMapper());
	}

	public int countTips(String companyCode, String keyWord) {
		String sql = "";
		if ("1047".equals(companyCode) || "1049".equals(companyCode)
				|| "1048".equals(companyCode) || "1050".equals(companyCode)
				|| "1051".equals(companyCode)) {
			sql = "select count(1) from cn_cs_tips where (companyCode = '1047' or companyCode = '1000' or companyCode = '1049' or companyCode = '1048' or companyCode = '1050' or companyCode = '1051')";
		} else {
			sql = "select count(1) from cn_cs_tips where companyCode = '"
					+ companyCode + "' or companyCode = '1000'";
		}
		if (!StringUtil.isNull(keyWord))
			sql += " and (instr(title, '" + keyWord
					+ "') > 0 or instr(content, '" + keyWord + "') > 0)";
		return jdbcTemplate.queryForInt(sql);
	}

	public int saveTips(TipsInfo info) {
		String sql = "insert into cn_cs_tips(companyCode, title, content, createTime) values(?, ?, ?, now())";
		Object[] param = new Object[3];
		param[0] = info.getCompanyCode();
		param[1] = info.getName();
		param[2] = info.getContent();
		return jdbcTemplate.update(sql, param);
	}

	public int updateTips(TipsInfo info) {
		String sql = "update cn_cs_tips set title = ?, content = ? where companyCode = ? and id = ?";
		Object[] param = new Object[4];
		param[0] = info.getName();
		param[1] = info.getContent();
		param[2] = info.getCompanyCode();
		param[3] = info.getIntId();
		return jdbcTemplate.update(sql, param);
	}

	public int deleteTips(TipsInfo info) {
		String sql = "delete from cn_cs_tips where companyCode = '"
				+ info.getCompanyCode() + "' and id = " + info.getIntId();
		return jdbcTemplate.update(sql);
	}

	public TipsInfo getTips(int id, String companyCode) {
		String sql = "";
		if ("1047".equals(companyCode) || "1049".equals(companyCode)
				|| "1048".equals(companyCode) || "1050".equals(companyCode)
				|| "1051".equals(companyCode)) {
			sql = "select * from cn_cs_tips where (companyCode = '1047' or companyCode = '1049' or companyCode = '1048' or companyCode = '1050' or companyCode = '1051') and id = "
					+ id;
		} else {
			sql = "select * from cn_cs_tips where companyCode = '"
					+ companyCode + "' and id = " + id;
		}
		List<TipsInfo> list = jdbcTemplate.query(sql, new TipsMapper());
		return list == null || list.size() <= 0 ? null : list.get(0);
	}

	private class TipsMapper implements RowMapper {
		public TipsInfo mapRow(ResultSet rs, int arg1) throws SQLException {
			TipsInfo tips = new TipsInfo();
			tips.setIntId(rs.getInt("id"));
			tips.setCompanyCode(rs.getString("companyCode"));
			tips.setName(rs.getString("title"));
			tips.setContent(rs.getString("content"));
			tips.setCreateTime(rs.getString("createTime"));

			String summary = "";
			if (!StringUtil.isNull(tips.getContent())) {
				summary = tips.getContent();
				if (summary.length() > 20) {
					summary = summary.substring(0, 20) + "...";
				}
			}
			tips.setSummary(summary);
			return tips;
		}
	}*/

	// ///////////////////////////////////使用技巧结束///////////////////////////////////////////

	// ///////////////////////////////////公司图标及联系信息/////////////////////////////////////
	public int saveCompanyInfo(CompanyInfo company) {
		String sql = "update cn_company set icon = ?, contact = ? where code = ?";
		Object[] param = new Object[3];
		param[0] = company.getIcon();
		param[1] = company.getContactInfo();
		param[2] = company.getCode();
		return jdbcTemplate.update(sql, param);
	}

	// ///////////////////////////////////公司信息结束////////////////////////////////////////////

	// ///////////////////////////////////////新机上市开始///////////////////////////////////////
	/*public List<CustomerMachineInfo> customerMachineList(String companyCode) {
		String sql = "";
		if ("1047".equals(companyCode) || "1049".equals(companyCode)
				|| "1048".equals(companyCode) || "1050".equals(companyCode)
				|| "1051".equals(companyCode)) {
			sql = "select * from cn_cs_machine where (companyCode = '1047' or companyCode = '1049' or companyCode = '1048' or companyCode = '1050' or companyCode = '1051') order by marketDay desc";
		} else {
			sql = "select * from cn_cs_machine where companyCode = '"
					+ companyCode + "' order by marketDay desc";
		}
		return jdbcTemplate.query(sql, new CustomerMachineMapper());
	}

	public CustomerMachineInfo getCustomerMachineInfo(String companyCode, int id) {
		String sql = "";
		if ("1047".equals(companyCode) || "1049".equals(companyCode)
				|| "1048".equals(companyCode) || "1050".equals(companyCode)
				|| "1051".equals(companyCode)) {
			sql = "select * from cn_cs_machine where (companyCode = '1047' or companyCode = '1049' or companyCode = '1048' or companyCode = '1050' or companyCode = '1051') and id = "
					+ id;
		} else {
			sql = "select * from cn_cs_machine where companyCode = '"
					+ companyCode + "' and id = " + id;
		}
		List<CustomerMachineInfo> list = jdbcTemplate.query(sql,
				new CustomerMachineMapper());
		return list == null || list.size() <= 0 ? null : list.get(0);
	}

	public int updateCustomerMachineInfo(CustomerMachineInfo info) {
		String sql = "update cn_cs_machine set name = ?, img = ?, marketDay = ?, content = ? where id = ? and companyCode = ?";
		Object[] param = new Object[6];
		param[0] = info.getName();
		param[1] = info.getImg();
		param[2] = info.getMarketDay();
		param[3] = info.getContent();
		param[4] = info.getIntId();
		param[5] = info.getCompanyCode();
		return jdbcTemplate.update(sql, param);
	}

	public int saveCustomerMachineInfo(CustomerMachineInfo info) {
		String sql = "insert into cn_cs_machine(companyCode, name, marketDay, createTime, img, content) values(?, ?, ?, now(), ?, ?)";
		Object[] param = new Object[5];
		param[0] = info.getCompanyCode();
		param[1] = info.getName();
		param[2] = info.getMarketDay();
		param[3] = info.getImg();
		param[4] = info.getContent();
		return jdbcTemplate.update(sql, param);
	}

	public int deleteCustomerMachineInfo(int id, String companyCode) {
		String sql = "delete from cn_cs_machine where companyCode = '"
				+ companyCode + "' and id = " + id;
		return jdbcTemplate.update(sql);
	}

	private class CustomerMachineMapper implements RowMapper {
		public CustomerMachineInfo mapRow(ResultSet rs, int row)
				throws SQLException {
			CustomerMachineInfo info = new CustomerMachineInfo();
			info.setIntId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setImg(rs.getString("img"));
			info.setCompanyCode(rs.getString("companyCode"));
			info.setMarketDay(rs.getString("marketDay"));
			info.setContent(rs.getString("content"));
			info.setCreateTime(rs.getString("createTime"));
			String summary = "";
			if (!StringUtil.isNull(info.getContent())) {
				summary = info.getContent();
				if (summary.length() > 20) {
					summary = summary.substring(0, 20) + "...";
				}
			}
			info.setSummary(summary);
			return info;
		}
	}
*/
	// ///////////////////////////////////////新机上市结束///////////////////////////////////////

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

/*	public void delete(OpinionInfo info) {
		String sql = "delete from cn_cs_opinion where  id = " + info.getIntId();
		jdbcTemplate.update(sql);
	}*/
    //客服中心流量统计
	
	/*public List<CordCount> getCordCount1() {
		String Sql="select * from cn_cordcount";
		return jdbcTemplate.query(Sql,new CustomerCordCountMapper());
	}
	private class CustomerCordCountMapper implements RowMapper {
		public CordCount mapRow(ResultSet rs, int row)
				throws SQLException {
			CordCount info = new CordCount();
			info.setIntId(rs.getInt("id"));
			info.setCord(CordCount.getMenuName(rs.getString("cord")));
			info.setMonthCount(rs.getInt("month_count"));
			info.setTodayCount(rs.getInt("today_count"));
			info.setTotalCount(rs.getInt("total_count"));
			return info;
		}
	}*/
}
