package com.cncoman.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.cncoman.product.bean.CompanyInfo;
import com.cncoman.product.bean.DownLoadInfor;
import com.cncoman.product.bean.FileCategory;
import com.cncoman.product.bean.FileInformation;
import com.cncoman.product.bean.FunClubAdver;
import com.cncoman.product.bean.FunComments;
import com.cncoman.product.bean.OrzStaInfo;
import com.cncoman.product.util.StringUtil;



public class FunClubDAO {
	private JdbcTemplate jdbcTemplate;

	public int addCategory(FileCategory cate) {
		String addSql = "insert into fun_category(shot_name,name,position,icon) values(?,?,?,?)";
		Object[] param = new Object[4];
		param[0] = cate.getShotName();
		param[1] = cate.getName();
		param[2] = cate.getTPosition();
		param[3] = cate.getTIcon();

		return jdbcTemplate.update(addSql, param);
	}

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<FileCategory> getCageList() {
		String sql = "select * from fun_category order by show_id";

		return jdbcTemplate.query(sql, new CategoryRowMapper());
	}

	private class CategoryRowMapper implements RowMapper {

		public FileCategory mapRow(ResultSet rs, int arg1) throws SQLException {
			FileCategory info = new FileCategory();
			info.setIntId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setShotName(rs.getString("shot_name"));
			info.setTIcon(rs.getString("icon"));
			info.setTPosition(rs.getInt("position"));
			info.setShowId(rs.getInt("show_id"));
			return info;
		}
	}

	//
	public List<FileInformation> getFileList(int i) {
		String sql = "";
		if (i == 0) {
			sql = "select * from fun_information";
		} else
			sql = "select * from fun_information where category_id=" + i;

		return jdbcTemplate.query(sql, new InformationRowMapper());
	}

	private class InformationRowMapper implements RowMapper {

		public FileInformation mapRow(ResultSet rs, int arg1)
				throws SQLException {

			FileInformation info = new FileInformation();
			info.setIntId(rs.getInt("id"));
			info.setCategoryId(rs.getInt("category_id"));
			info.setCreateTime(rs.getString("create_time"));
//			info.setCreateDay(rs.getDate("create"));
			info.setDownLoadCount(rs.getInt("download_count"));
			info.setDownName(rs.getString("download_name"));
			info.setFileDevloper(rs.getString("developer"));
			info.setFileGrad(rs.getString("file_grad"));
			info.setFileIcon(rs.getString("file_icon"));
			info.setFileImage(rs.getString("image"));
			info.setFileSize(rs.getString("file_size"));
			info.setName(rs.getString("name"));
			info.setOSYQ(rs.getString("os_yq"));
			info.setFileVersion(rs.getString("version"));
			info.setShowId(rs.getInt("show_id"));
			info.setInvente(rs.getInt("invente"));
			info.setCompanyId(rs.getInt("company_id"));
			if (rs.getString("information").length() > 10) {
				info.setInforSign(1);
				info.setShotInformation(rs.getString("information").substring(
						0, 10));
			} else {
				info.setShotInformation(rs.getString("information"));
			}
			info.setEssentail(rs.getInt("essential"));
			info.setInformation(rs.getString("information"));
			info.setFileContent(rs.getString("file"));
			info.setFlag(rs.getInt("flag"));
			info.setPackages(rs.getString("packages"));
			return info;
		}
	}

	public int addFile(FileInformation fileInformation) {
		String sql = "insert into fun_information(name,file_size,download_count,create_time,"
				+ "file_icon,file_grad,category_id,information,image,os_yq,version,developer,file,essential,company_id,download_name,invente,flag,packages,updatetime,userid) values (?,?,0,now(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?)";
		Object param[] = new Object[18];
		param[0] = fileInformation.getName();
		param[1] = fileInformation.getFileSize();
		param[2] = fileInformation.getFileIcon();
		param[3] = fileInformation.getFileGrad();
		param[4] = fileInformation.getCategoryId();
		param[5] = fileInformation.getInformation();
		param[6] = fileInformation.getFileImage();
		param[7] = fileInformation.getOSYQ();
		param[8] = fileInformation.getFileVersion();
		param[9] = fileInformation.getFileDevloper();
		param[10] = fileInformation.getFileContent();
		param[11] = fileInformation.getEssentail();
		param[12] = fileInformation.getCompanyId();
		param[13] = fileInformation.getDownName();
		param[14] = fileInformation.getInvente();
		param[15] = fileInformation.getFlag();
		param[16] = fileInformation.getPackages();
		param[17] = fileInformation.getUserid();
		return jdbcTemplate.update(sql, param);
	}

	public int deleteById(int i) {
		String sql = "delete from fun_information where id=" + i;
		return jdbcTemplate.update(sql);
	}

	public FileInformation getFileInfo(int i) {
		String sql = "select * from fun_information where id=" + i;
		List list = jdbcTemplate.query(sql, new InformationRowMapper());
		return (FileInformation) (list.size() == 0 ? null : list.get(0));
	}

	//鏇存柊鏂囦欢淇℃伅
	public int updateFileInfo(FileInformation fileInformation) {
		String sql = "update fun_information set name=?,file_size=?,download_count=?,file_icon=?,"
				+ "file_grad=?,category_id=?,information=?,image=?,os_yq=?,version=?,developer=? ,essential=?,invente=?,download_name=?, file = ?, flag = ? ,packages = ?,updatetime=now()  where id=?";
		Object param[] = new Object[18];
		param[0] = fileInformation.getName();
		param[1] = fileInformation.getFileSize();
		param[2] = fileInformation.getDownLoadCount();
		param[3] = fileInformation.getFileIcon();
		param[4] = fileInformation.getFileGrad();
		param[5] = fileInformation.getCategoryId();
		param[6] = fileInformation.getInformation();
		param[7] = fileInformation.getFileImage();
		param[8] = fileInformation.getOSYQ();
		param[9] = fileInformation.getFileVersion();
		param[10] = fileInformation.getFileDevloper();
		param[11] = fileInformation.getEssentail();
		param[12] = fileInformation.getInvente();
		param[13] = fileInformation.getDownName();
		param[14] = fileInformation.getFileContent();
		param[15] = fileInformation.getFlag();
		param[16] = fileInformation.getPackages();
		param[17] = fileInformation.getIntId();
	
		return jdbcTemplate.update(sql, param);
	}

	
	//
	public FileCategory getCateById(int i) {
		String sql = "select * from fun_category where id=" + i;
		List list = jdbcTemplate.query(sql, new CategoryRowMapper());
		return (FileCategory) (list.size() == 0 ? null : list.get(0));
	}
	
//	public FileCategory getCateByShotName(String shotName){
//		String sql = "select * from fun_category where shot_name=" + shotName;
//		List list = jdbcTemplate.query(sql, new CategoryRowMapper());
//		return (FileCategory) (list.size() == 0 ? null : list.get(0));
//	}
	

	public int updateCateInfo(FileCategory fileCategory) {
		String sql = "update fun_category set shot_name=?,name=?,position=?,icon=? where id=?";
		Object[] param = new Object[5];
		param[0] = fileCategory.getShotName();
		param[1] = fileCategory.getName();
		param[2] = fileCategory.getTPosition();
		param[3] = fileCategory.getTIcon();
		param[4] = fileCategory.getIntId();
		return jdbcTemplate.update(sql, param);
	}

	public int deleteCateById(int i) {
		String sql = "delete from fun_category where id=" + i;
		return jdbcTemplate.update(sql);
	}

	public int addAdver(FunClubAdver funclubAdver) {
		String sql = "insert into adver_info(name,shot_name,url,companycode) values(?,?,?,?)";
		Object[] param = new Object[4];
		param[0] = funclubAdver.getName();
		param[1] = funclubAdver.getShotName();
		param[2] = funclubAdver.getFurl();
		param[3] = funclubAdver.getCode();
		return jdbcTemplate.update(sql, param);
	}

	//
	public List<FunClubAdver> getAdverList(int i) {
		String sql;
		if (i == 0) {
			sql = "select * from adver_info";
		} else
			sql = "select * from adver_info where id=" + i;
		return jdbcTemplate.query(sql, new AdverRowMapper());
	}

	private class AdverRowMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			FunClubAdver info = new FunClubAdver();
			info.setCode(rs.getString("companyCode"));
			info.setFurl(rs.getString("url"));
			info.setIntId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setShotName(rs.getString("shot_name"));
			return info;
		}
	}

	public int delAdver(int i) {
		String sql = "delete from adver_info where id=" + i;
		return jdbcTemplate.update(sql);
	}

	public int updateAdver(FunClubAdver funclubAdver) {
		String sql = "update adver_info set name=?,shot_name=?,url=? where id=?";
		Object object[] = new Object[4];
		object[0] = funclubAdver.getName();
		object[1] = funclubAdver.getShotName();
		object[2] = funclubAdver.getFurl();
		object[3] = funclubAdver.getIntId();
		return jdbcTemplate.update(sql, object);
	}

	public List<FileCategory> getPositionById(int i) {
		String sql = "select * from  fun_category where position=" + i;
		List list = jdbcTemplate.query(sql, new CategoryRowMapper());
		return list.size() == 0 ? null : list;
	}

	/**
	 * 
	 * @param id
	 * @param page
	 * @param pagesize
	 * @return
	 */
	public List<FileInformation> getfileListByMoreId(String id, int page,
			int pagesize,String loginId) {
		String sb = "";
		if(!"".equals(loginId)&&loginId!=null&&!"admin".equals(loginId))
			sb = " and userid = '" +loginId+"' ";
		
		String sql = "select * from fun_information where category_id in('"
				+ id + "')" + sb +
				"  order by create_time desc limit " + (page - 1)
				* pagesize + "," + pagesize;
		
		return jdbcTemplate.query(sql, new InformationRowMapper());  

	}

	public void updateShowId(FileCategory showId) {
		String sql = "update fun_category set show_id=" + showId.getShowId()
				+ " where id=" + showId.getIntId() + "";
		jdbcTemplate.update(sql);
	}

	public void updateFileShowId(FileInformation fileInformation) {
		String sql = "update fun_information set show_id="
				+ fileInformation.getShowId() + " where id="
				+ fileInformation.getIntId() + "";
		int ok = jdbcTemplate.update(sql);

	}

	public List<FileInformation> getFileByEssentail(int i) {
		String sql = "";
		if (i == 0)
			sql = "select * from fun_information where essential=1 order by create_time desc";
		else
			sql = "select * from fun_information where essential=1 and id=" + i
					+ " order by show_id";
		return jdbcTemplate.query(sql, new InformationRowMapper());
	}

	//鑾峰彇鏂囦欢鎬绘暟
	public int getCountFile(int intId) {
		String sql = "select count(1) from fun_information where category_id="
				+ intId;
		return jdbcTemplate.queryForInt(sql);
	}

	//鑾峰彇鎬婚〉锟�?
	public int getPageCount(String id) {
		String sql = "select count(*) from fun_information where category_id in('"
				+ id + "')";

		return jdbcTemplate.queryForInt(sql);
	}

	public int getDownCount(int intId) {
		String sql = "select download_count from fun_information where category_id in('"
				+ intId + "')";
		List<Integer> list = jdbcTemplate.queryForList(sql, Integer.class);
		Integer count = 0;
		for (int i = 0; i < list.size(); i++) {
			count += ((Integer) list.get(i)).intValue();
		}
		return count;
	}

	public List<CompanyInfo> getCompanyList(long id) {
		String sql = "";
		if (id == 0)
			sql = "select * from cn_company";
		else
			sql = "select * from cn_company where id=" + id;
		List list = jdbcTemplate.query(sql, new CompanyRowMapper());
		return list.size() == 0 ? null : list;
	}

	private class CompanyRowMapper implements RowMapper {
		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			CompanyInfo info = new CompanyInfo();
			info.setId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setCompanyCode(rs.getString("code"));
			
			return info;
		}
	}

	private class DownLoadInfoRowMapper implements RowMapper {

		public Object mapRow(ResultSet rs, int arg1) throws SQLException {
			DownLoadInfor info = new DownLoadInfor();
			info.setDownLoadTime(rs.getString("download_time"));
			info.setFileId(rs.getString("file_id"));
			info.setCompanyCount(rs.getInt("downCount"));
			return info;
		}

	}

	public List<DownLoadInfor> getDownLoadInfo(String starTime, String endTime,
			String id) {
		String sql = "";
		if ((starTime == null || starTime.equals(""))
				&& (endTime == null || endTime.equals("")))
			sql = "select count(1) downCount,file_id,download_time from fun_downloadinfo where file_id in ("
					+ id + ") group by file_id";
		else if ((starTime == null || starTime.equals(""))
				&& (endTime != null || !endTime.equals(""))) {
			starTime = endTime + " 00:00:00";
			endTime = endTime + " 23:59:59";
			sql = "select count(1) downCount,file_id,download_time from fun_downloadinfo where file_id in ("
					+ id
					+ ") and download_time between '"
					+ starTime
					+ "' and '" + endTime + "'  group by file_id ";
		} else if ((starTime != null || !starTime.equals(""))
				&& (endTime == null || endTime.equals(""))) {
			endTime = starTime + " 23:59:59";
			starTime = starTime + " 00:00:00";
			sql = "select count(1) downCount,file_id,download_time from fun_downloadinfo where file_id in ("
					+ id
					+ ") and  download_time between '"
					+ starTime
					+ "' and '" + endTime + "'  group by file_id ";
		} else {
			starTime = starTime + " 00:00:00";
			endTime = endTime + " 23:59:59";
			sql = "select count(1) downCount,file_id,download_time from fun_downloadinfo where file_id in ("
					+ id
					+ ") and download_time between '"
					+ starTime
					+ "' and '" + endTime + "'  group by file_id ";
		}

		return jdbcTemplate.query(sql, new DownLoadInfoRowMapper());
	}

	public List<FileInformation> getByCompanyId(long id) {
		String sql = "select * from fun_information where company_id=" + id;
		return jdbcTemplate.query(sql, new InformationRowMapper());
	}
	
	
	public List<FunComments> getfuncommentsList(int appid) {
		String sql = "select * from fun_comments where appid="+appid+" order by id desc";

		return jdbcTemplate.query(sql, new FunCommentsRowMapper());
	}
	public int getfuncommentsdel(int comid) {
		//String sql = "select * from fun_comments where appid="+appid+" order by id desc";
		String sql = "delete from fun_comments where id="+comid;
		
		return jdbcTemplate.update(sql);
	}
	
	
	private class FunCommentsRowMapper implements RowMapper {

		public FunComments mapRow(ResultSet rs, int arg1) throws SQLException {
			FunComments info = new FunComments();
			info.setId(rs.getInt("id"));
			info.setName(rs.getString("name"));
			info.setAppid(rs.getInt("appid"));
			info.setContext(rs.getString("context"));
			info.setImei(rs.getString("imei"));
			info.setImsi(rs.getString("imsi"));
			info.setStar(rs.getInt("star"));
			info.setCreattime(rs.getString("creattime"));
			
			return info;
		}
	}
	
/////////////////////////////////统计开始///////////////////////////////////////
	public List<OrzStaInfo> getOrzAppSta(String fromDay, String toDay,int appId, String code, int groupBy) {
		String title= "";int  countDown = 0;SqlRowSet ra2 =null;int  countDown2 = 0; int us = 0;List<OrzStaInfo> list3 = new ArrayList<OrzStaInfo>();
		if (groupBy == 1)
			title ="DATE(download_time) as day";
		if (groupBy == 2)
			title ="DATE_FORMAT(download_time,'%Y-%m') as month";
		if (groupBy == 3)
			title ="appId";
		if (groupBy == 4)
			title ="mach";
		StringBuilder sa = new StringBuilder();
		sa.append("select "+title+",count(*) as count from fun_downloads where flag=2 and DATE(download_time) between '"+fromDay+"' and '"+toDay+"' ");
		if (appId>0)
			sa.append(" and appid="+appId);
		if (!StringUtil.isNull(code))
			sa.append(" and mach='"+code+"'");
		if (groupBy == 1){
			sa.append(" group by day desc");
		}else if (groupBy == 2){
			sa.append(" group by month desc");
		}else {
			sa.append(" group by "+title+" desc");
		}
		SqlRowSet ra = jdbcTemplate.queryForRowSet(sa.toString());
		StringBuilder sa2 = new StringBuilder();
		if (groupBy==1||groupBy==2) {
			sa2.append("select count(*) as count from fun_downloads where flag=2 and DATE(download_time) <= '"+toDay+"' ");
		}else {
			sa2.append("select "+title+",count(*) as count from fun_downloads where flag=2 and DATE(download_time) <= '"+toDay+"' ");
		}
		if (appId>0)
			sa2.append(" and appid="+appId);
		if (!StringUtil.isNull(code))
			sa2.append(" and mach='"+code+"'");
		if (groupBy==1||groupBy==2) {
			countDown2 = countDown= jdbcTemplate.queryForInt(sa2.toString());
		}else {
			sa2.append(" group by "+title+" desc");
			ra2= jdbcTemplate.queryForRowSet(sa2.toString());
			OrzStaInfo info =null;
			while (ra2.next()) {
				info = new OrzStaInfo();
				if (ra2.getString(title)==null) {
					info.setName("");
				}else {
					info.setName(ra2.getString(title));
				}
				info.setDownloads(ra2.getInt("count"));
				list3.add(info);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT "+title+",count(*) as count FROM (SELECT * FROM fun_downloads WHERE flag=2 and DATE(download_time) between '"+fromDay+"' and '"+toDay+"'");
		if (appId>0)
			sb.append(" and appid="+appId);
		if (!StringUtil.isNull(code))
			sb.append(" and mach='"+code+"'");
		if (groupBy == 1){
			sb.append(" GROUP BY mach,imei,imsi,DATE(download_time)) t GROUP BY DAY DESC");
		}else if (groupBy == 2){
			sb.append(" GROUP BY mach,imei,imsi,DATE_FORMAT(download_time,'%Y-%m')) t GROUP BY month DESC");
		}else {
			sb.append(" GROUP BY mach,imei,imsi,"+title+") t GROUP BY "+title+" DESC");
		}
		SqlRowSet rb = jdbcTemplate.queryForRowSet(sb.toString());
		
		if (groupBy==1||groupBy==2) {
			StringBuilder sbb = new StringBuilder();
			sbb.append("SELECT count(*) as count FROM (SELECT * FROM fun_downloads WHERE flag=2 and DATE(download_time) between '"+fromDay+"' and '"+toDay+"'");
			if (appId>0)
				sbb.append(" and appid="+appId);
			if (!StringUtil.isNull(code))
				sbb.append(" and mach='"+code+"'");
				sbb.append(" GROUP BY mach,imei,imsi) t ");
				us = jdbcTemplate.queryForInt(sbb.toString());
		}
		
		StringBuilder sb2 = new StringBuilder();
		sb2.append("SELECT "+title+",count(*) as count FROM (SELECT  appid,mach,imei,imsi,MIN(download_time) download_time FROM fun_downloads WHERE flag=2 and DATE(download_time) <='"+toDay+"'");
		if (appId>0)
			sb2.append(" and appid="+appId);
		if (!StringUtil.isNull(code))
			sb2.append(" and mach='"+code+"'");
		if (groupBy == 1){
			sb2.append(" GROUP BY mach,imei,imsi) t GROUP BY DAY DESC");
		}else if (groupBy == 2){
			sb2.append(" GROUP BY mach,imei,imsi) t GROUP BY month DESC");
		}else {
			sb2.append(" GROUP BY mach,imei,imsi,"+title+") t GROUP BY "+title+" DESC");
		}
		SqlRowSet rb2 = jdbcTemplate.queryForRowSet(sb2.toString());
		int allU=0;int allU2=0;
		List<OrzStaInfo> list2 = new ArrayList<OrzStaInfo>();
		OrzStaInfo info2 =null;
		while (rb2.next()) {
			allU +=rb2.getInt("count");
			allU2 = allU;
			info2 =new OrzStaInfo();
			if (groupBy==1) {
				info2.setName(rb2.getString("day"));
			}else if(groupBy==2){
				info2.setName(rb2.getString("month"));
			}else {
				if (rb2.getString(title)==null) {
					info2.setName("");
				}else {
					info2.setName(rb2.getString(title));
				}
			}
			info2.setAllUser(rb2.getInt("count"));
			list2.add(info2);
		}
		
		List<OrzStaInfo> list = new ArrayList<OrzStaInfo>();
		OrzStaInfo info = null;
		String title2="";
		int d=0;
		while (ra.next()) {
			switch (groupBy) {
			case 1:
				title = ra.getString("day");
				title2 ="day";
				break;
			case 2:
				title = ra.getString("month");
				title2 ="month";
				break;
			case 3:
				title = getAppName(ra.getString("appId"));
				title2 ="appId";
				break;
			case 4:
				if (ra.getString("mach")==null) {
					title ="未知渠道";
				}else {
					title = ra.getString("mach");
				}
				title2 ="mach";
				break;
			}
			info = new OrzStaInfo();
			info.setTitle(title);
			info.setDownload(ra.getInt("count"));
			d += ra.getInt("count");
			if (groupBy==1||groupBy==2) {
				info.setDownloads(countDown);
				countDown -= ra.getInt("count");
			}else {
				for (OrzStaInfo mtStaInfo : list3) {
					String t="";
					if (ra.getString(title2)!=null) {
						t = ra.getString(title2);
					}
					if (mtStaInfo.getName().equals(t)) {
						info.setDownloads(mtStaInfo.getDownloads());
						break;
					}
				}
			}
			while (rb.next()) {
				info.setUser(rb.getInt("count"));
				break;
			}
			if (groupBy==1||groupBy==2) {
				info.setAllUser(allU);
				for (OrzStaInfo mtStaInfo : list2) {
					if (mtStaInfo.getName().equals(ra.getString(title2))) {
						info.setAllUser(allU);
						allU -=mtStaInfo.getAllUser();
						break;
					}
				}
			}else {
				for (OrzStaInfo mtStaInfo : list2) {
					String t ="";
					if (ra.getString(title2)!=null) {
						t = ra.getString(title2);
					}
					if (mtStaInfo.getName().equals(t)) {
						info.setAllUser(mtStaInfo.getAllUser());
						break;
					}
				}
			}
			list.add(info);
		}
		if (groupBy==1||groupBy==2) {
			info = new OrzStaInfo();
			info.setTitle("合计：");
			info.setDownload(d);
			info.setDownloads(countDown2);
			info.setUser(us);
			info.setAllUser(allU2);
			list.add(info);
		}
		return list;
	}
	
	protected String getAppName(String id) {
		String sql = "select name from fun_information where id="+id;
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		String name = "未知应用";
		while (rs.next()) {
			return rs.getString("name");
		}
		return name;
	}
	
}
