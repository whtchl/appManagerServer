package com.cncoman.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;


import com.cncoman.product.bean.CompanyInfo;

import com.cncoman.product.util.StringUtil;

public class CompanyDAO {
	
	private JdbcTemplate jdbcTemplate;	
	
	public List<CompanyInfo> list(String nameOrCode, int type, int salesId, int from, int to){
		StringBuilder sb = new StringBuilder();
		sb.append("select * from cn_company where true");
		if(!StringUtil.isNull(nameOrCode))
			sb.append(" and (name like '%" + nameOrCode + "%' or code = '" + nameOrCode + "')");
		if(type > 0)
			sb.append(" and type = " + type);
		if(salesId > 0)
			sb.append(" and salesId = " + salesId);
		sb.append(" order by time desc");		
		sb.append(" limit " + from + "," + to);
		return jdbcTemplate.query(sb.toString(), new CompanyRowMapper());
	}
	
	public int companyCount(String nameOrCode, int type, int salesId){
		String sql = "select count(1) from cn_company where true";

		if(!StringUtil.isNull(nameOrCode))
			sql += " and (name like '%" + nameOrCode + "%' or code = '" + nameOrCode + "')";
		if(type > 0)
			sql += " and type = " + type;
		if(salesId > 0)
			sql += " and salesId = " + salesId;
		return jdbcTemplate.queryForInt(sql);
	}
	
	public CompanyInfo getInfo(int companyId){
		String sql = "select * from cn_company where id = " + companyId;
		List list = jdbcTemplate.query(sql, new CompanyRowMapper());
		return list == null || list.size() <= 0 ? null : (CompanyInfo) list.get(0);
	}
	
	public CompanyInfo getInfo(String code){
		String sql = "select * from cn_company where code = '" + code + "'";
		List list = jdbcTemplate.query(sql, new CompanyRowMapper());
		return list == null || list.size() <= 0 ? null : (CompanyInfo) list.get(0);
	}
	
	public CompanyInfo getByMachineId(int machineId){
		String sql = "select a.* from cn_company a, cn_machine b where a.code = b.companyCode and b.id = " + machineId;
		return (CompanyInfo)jdbcTemplate.queryForObject(sql, new CompanyRowMapper());
	}
	
	public int insert(CompanyInfo info){
		String sql = "insert into cn_company(name, code, type, salesId, remark, time) values(?, ?, ?, ?, ?, now())";
		Object[] param = new Object[5];
		param[0] = info.getName();
		param[1] = info.getCode();
		param[2] = info.getType();
		param[3] = info.getSalesId();
		param[4] = info.getRemark();
		return jdbcTemplate.update(sql, param);
	}
	
	public int update(CompanyInfo info){
		String sql = "update cn_company set name = ?, code = ?, type = ?, salesId = ?, remark = ? where id = ?";
		Object[] param = new Object[6];
		param[0] = info.getName();
		param[1] = info.getCode();
		param[2] = info.getType();
		param[3] = info.getSalesId();
		param[4] = info.getRemark();
		param[5] = info.getIntId();
		return jdbcTemplate.update(sql, param);
	}
	public int updateShop(CompanyInfo info){
		String sql = "update cn_company set  isShop = ?, shopUrl = ? where id = ?";
		Object[] param = new Object[3];
		param[0] = info.getIsShop();
		param[1] = info.getShopUrl();
		
		param[2] = info.getId();
		return jdbcTemplate.update(sql, param);
	}
	
	public int updateIconAndContact(CompanyInfo info){
		String sql = "update cn_company set icon = ?, contact = ?, brandInfo = ?, service = ?, bottomWord = ?, wapTitle = ? where id = ? and code = ?";
		Object[] param = new Object[8];
		param[0] = info.getIcon();
		param[1] = info.getContactInfo();
		param[2] = info.getBrandInfo();
		param[3] = info.getService();
		param[4] = info.getBottomWord();
		param[5] = info.getWapTitle();
		param[6] = info.getIntId();		
		param[7] = info.getCode();
		return jdbcTemplate.update(sql, param);
	}
	
	protected class CompanyRowMapper implements RowMapper{
		public CompanyInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			CompanyInfo info = new CompanyInfo();
			info.setIntId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setCode(rs.getString("code"));
			info.setType(rs.getInt("type"));
			info.setSalesId(rs.getInt("salesId"));
			info.setRemark(rs.getString("remark"));
			info.setTime(rs.getString("time"));
			String icon = rs.getString("icon");			
			info.setIcon(icon);
			info.setContactInfo(rs.getString("contact"));
			info.setBrandInfo(rs.getString("brandInfo"));
			info.setService(rs.getString("service"));
			info.setBottomWord(rs.getString("bottomWord"));
			info.setWapTitle(rs.getString("wapTitle"));
			info.setIsShop(rs.getInt("isShop"));
			info.setShopUrl(rs.getString("shopUrl"));
			return info;
		}
		
	}
	
	
	/*/////////////////////////////公司品牌管理/////////////////////////////////////
	public List<CompanyBrandInfo> brandList(String companyCode, String codes, String brandIdStr){
		StringBuffer sb = new StringBuffer();
		sb.append("select * from cn_company_brand where companyCode = '" + companyCode + "'");
		
		sb.append(" and id in(");
		sb.append(" select brandId from cn_machine where companyCode = '" + companyCode + "'");
		if(!StringUtil.isNull(codes) && !"0".equals(codes) && StringUtil.isNull(brandIdStr))
			sb.append(" and code in (" + codes + ")");
		if(!StringUtil.isNull(codes) && !"0".equals(codes) && !StringUtil.isNull(brandIdStr))
			sb.append(" and (code in(" + codes + ") or brandId in(" + brandIdStr + "))");
		if(StringUtil.isNull(codes) && !"0".equals(codes) && StringUtil.isNull(brandIdStr))   //机型为空，品牌为空，则为全部ȫ��
			sb.append(" ");
		if(StringUtil.isNull(codes) && !"0".equals(codes) && !StringUtil.isNull(brandIdStr))			
			sb.append(" and brandId in(" + brandIdStr + ")");
		sb.append(" group by brandId)");		
		
		return jdbcTemplate.query(sb.toString(), new CompanyBrandMapper());
	}
	
	public List<CompanyBrandInfo> brandList(String companyCode){
		String sql = "select * from cn_company_brand where companyCode = '" + companyCode + "'";
		return jdbcTemplate.query(sql, new CompanyBrandMapper());
	}
	
	private class CompanyBrandMapper implements RowMapper{
		public CompanyBrandInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			CompanyBrandInfo brand = new CompanyBrandInfo();
			brand.setIntId(rs.getInt("id"));
			brand.setName(rs.getString("name"));
			brand.setCompanyCode(rs.getString("companyCode"));
			brand.setUid(rs.getInt("uid"));
			brand.setCreateTime(rs.getString("createTime"));
			return brand;
		}
	}
	
	public int saveBrand(final CompanyBrandInfo brand){
		KeyHolder keyHolder = new GeneratedKeyHolder();
		try{
			final String sql = "insert into cn_company_brand(name, companyCode, uid, createTime) values(?, ?, ?, now())";
			jdbcTemplate.update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"name", "companyCode", "uid"});
					pstmt.setString(1, brand.getName());
					pstmt.setString(2, brand.getCompanyCode());
					pstmt.setInt(3, brand.getUid());					
					return pstmt;
				}
			}, keyHolder);						
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}
	
	public int deleteBrand(CompanyBrandInfo brand){
		String sql = "delete from cn_company_brand where id = ? and companyCode = ?";
		Object[] param = new Object[2];
		param[0] = brand.getIntId();
		param[1] = brand.getCompanyCode();
		return jdbcTemplate.update(sql, param);
	}
	
	public int updateBrand(CompanyBrandInfo brand){
		String sql = "update cn_company_brand set name = ? where id = ? and companyCode = ?";
		Object[] param = new Object[3];
		param[0] = brand.getName();
		param[1] = brand.getIntId();
		param[2] = brand.getCompanyCode();
		return jdbcTemplate.update(sql, param);
	}
	
	public CompanyBrandInfo getBrand(int id, String companyCode){
		String sql = "select * from cn_company_brand where id = " + id + " and companyCode = '" + companyCode + "'";
		List<CompanyBrandInfo> list = jdbcTemplate.query(sql, new CompanyBrandMapper());
		return list == null || list.size() <= 0 ? null : list.get(0);
	}
	
	public int updateMachineBrand(String companyCode, String machIds, int brandId){
		String sql = "update cn_machine set brandId = " + brandId + " where id in (" + machIds + ")";
		if("1047".equals(companyCode) || "1049".equals(companyCode))
			sql += " and (companyCode = '1047' or companyCode = '1049')";
		else
			sql += " and companyCode = '" + companyCode + "'";		
		return jdbcTemplate.update(sql);
	}
	
	public int updateMachineBrand(String companyCode, int brandId){		
		String sql = "update cn_machine set brandId = 0 where brandId = " + brandId ;
		if("1047".equals(companyCode) || "1049".equals(companyCode))
			sql += " and (companyCode = '1047' or companyCode = '1049')";
		else
			sql += " and companyCode = '" + companyCode + "'";	
		return jdbcTemplate.update(sql);
	}
	
	public CompanyBrandInfo getBrand(String companyCode, String machineCode){
		String sql = "select a.* from cn_company_brand a, cn_machine b where a.id = b.brandId and b.companyCode = '" + companyCode + "' and b.code = '" + machineCode + "'";
		List<CompanyBrandInfo> list = jdbcTemplate.query(sql, new CompanyBrandMapper());
		return list == null || list.size() <= 0 ? null : list.get(0);
	}*/

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/*public List<ProductInfo> listPord() {
		String sql = "select * from cn_prod";
		return jdbcTemplate.query(sql, new ProductInfoMapper());
	}*/
	/*private class ProductInfoMapper implements RowMapper{
		public ProductInfo mapRow(ResultSet rs, int arg1) throws SQLException {
			ProductInfo info = new ProductInfo();
			info.setIntId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setNumber(rs.getString("number"));			
			info.setFeeCycle(rs.getInt("feeCycle"));
			info.setExplain(rs.getString("explain"));
			info.setLinkHours(rs.getInt("linkHours"));
			info.setLinkDays(rs.getString("linkDays"));
			info.setTargetUrl(rs.getString("targetUrl"));
			info.setTime(rs.getString("time"));
			return info;
		}
		
	}*/
}
