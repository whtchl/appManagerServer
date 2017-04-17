package com.cncoman.product.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.util.NodeList;

import com.cncoman.product.bean.CityInfo;

import com.cncoman.product.bean.ProvinceInfo;
import com.cncoman.product.util.StringUtil;
import com.mysql.jdbc.Connection;

public class GetCityByPhoneFromForeignSite {	
	
	private static Random r = new Random();
	
	public static void main(String[] args){				
		/*MobileInfo mobile = getInfo("14799806552");
		System.out.println("provinceName: " + mobile.getProvinceName());
		System.out.println(mobile.getCityName());
		System.out.println(mobile.getCorp());
		System.out.println(mobile.getCard());
		System.out.println(mobile.getOperator());*/
		
//		MobileInfo mobile1 = getInfo("18312417308");
//		System.out.println("provinceName: " + mobile1.getProvinceName());
//		System.out.println(mobile1.getCityName());
//		System.out.println(mobile1.getCorp());
//		System.out.println(mobile1.getCard());
//		System.out.println(mobile1.getOperator());
//		
//		MobileInfo mobile2 = getInfo("18313027660");
//		System.out.println("provinceName: " + mobile2.getProvinceName());
//		System.out.println(mobile2.getCityName());
//		System.out.println(mobile2.getCorp());
//		System.out.println(mobile2.getCard());
//		System.out.println(mobile2.getOperator());
//		
//		
//		MobileInfo mobile3 = getInfo("18682217802");
//		System.out.println("provinceName: " + mobile3.getProvinceName());
//		System.out.println(mobile3.getCityName());
//		System.out.println(mobile3.getCorp());
//		System.out.println(mobile3.getCard());
//		System.out.println(mobile3.getOperator());
//		
//		
//		MobileInfo mobile4 = getInfo("18368360867");
//		System.out.println("provinceName: " + mobile4.getProvinceName());
//		System.out.println(mobile4.getCityName());
//		System.out.println(mobile4.getCorp());
//		System.out.println(mobile4.getCard());
//		System.out.println(mobile4.getOperator());
	}
	
	/*public static MobileInfo getInfo(String phone){
		if(StringUtil.isNull(phone))
			return null;
		phone = phone.trim();
		String[] strs = getInfoFromBaiduByHtmlParser(phone);	
		if(strs == null)
			return null;		
		MobileInfo mobile = new MobileInfo();
		try{
			mobile.setProvinceName(strs[0].trim());			
			mobile.setCityName(strs[1].trim());
			mobile.setAreaCode("");
			mobile.setPostCode("");
			String[] temp = strs[3].split(" ");
			mobile.setCorp(temp[0].trim());
			mobile.setCard(temp[1].trim());
			mobile.setMobile(phone);
			mobile.setCity(Initialize.getCityByName(mobile.getCityName()));
			mobile.setOperator(StringUtil.getOperatorByName(mobile.getCorp()));
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return mobile;
	}	*/
	
	
	public static String[] getInfoFromBaiduByHtmlParser(String mobile){
		String[] str3 = null;// 所得到的值存入到数组中				
		try{
			Parser parser = new Parser("http://www.baidu.com/s?wd=" + mobile + "&rsv_bp=0&rsv_spt=3&inputT=" + r.nextInt(10000));
			NodeFilter nodeFilter = new TagNameFilter("div");
			NodeList nodeList = (NodeList) parser.parse(nodeFilter);
			String str = null;// 得到所要的值
			for(int i = 0; i < nodeList.size(); i++){
				Div contentTag = (Div) nodeList.elementAt(i);
				if ("op_mp_r".equals(contentTag.getAttribute("class"))){ 
					str = contentTag.getStringText();
					break;
				}
			}
			if(!StringUtil.isNull(str)){			
				int index = str.indexOf("</span>");
				String str1 = str.substring(index + 14);// 得到第二个span内的值
				int index1 = str1.indexOf("</span>");
				String str2 = str1.substring(0, index1);
				str2 = str2.replace("&nbsp", "");				
				str3 = str2.split(";");				
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
					
		}
		return str3;
	}
	
	
	/////////////////2012-07-19此方法已失效/////////////////////////
	public static String[] getInfoFromBaidu(String mobile){
		String[] str3 = null;// 所得到的值存入到数组中
		InputStream in = null;
		URL url = null;
		Object obj = null;		
		try{
			String urlpath = "http://www.baidu.com/s?wd=" + mobile + "&rsv_bp=0&rsv_spt=3&inputT=111";
			url = new URL(urlpath);
			obj = url.getContent();
			in = (InputStream) obj;			
			byte[] tt = new byte[1024];			
			String str = null;// 得到所要的值
			while (in.read(tt, 0, tt.length) != -1) {				
				String regex = "(<div class=\"op_mp_r.+>)(.+?)(</div>)";// 得到div里的值
				Pattern p = Pattern.compile(regex);
				boolean tr = false;// 如果找到为true				
				Matcher m = p.matcher(new String(tt, "UTF-8"));
				while (m.find()) {
					str = m.group(0);// sss				
					tr = true;
					break;
				}				
				if (tr) {
					int index = str.indexOf("</span>");
					String str1 = str.substring(index + 14);// 得到第二个span内的值
					int index1 = str1.indexOf("</span>");
					String str2 = str1.substring(0, index1);
					str2 = str2.replace("&nbsp", "");					
					str3 = str2.split(";");					
					break;					
				}	
			}			
			in.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(in != null)
				try {
					in.close();
				} catch (IOException e) {					
					e.printStackTrace();
				}
			in = null;
			url = null;
			obj = null;		
		}
		return str3;
	}
	
	////////////////////////2012-05-15原URL已关闭，无法再取值///////////////////////////////////////
//	public static MobileInfo getInfo(String phone){
//		MobileInfo mobile = null;
//		InputStream in = null;
//		DocumentBuilder documentBuilder = null;
//		URL url = null;
//		HttpURLConnection httpUrlConn = null;
//		Document doc = null;
//		try{
////			String add = "http://api.showji.com/locating/?m=" + phone + "&output=xml";
////			String add = "http://api.showji.com/Locating/default.aspx?m=" + phone;
//			String add = "http://vip.showji.com/Locating/?m=" + phone;
//			url = new URL(add);
//			httpUrlConn = (HttpURLConnection) url.openConnection();
//			httpUrlConn.connect();
//			in = httpUrlConn.getInputStream();
//			
//			documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//			doc = documentBuilder.parse(in);
//			String result = doc.getElementsByTagName("QueryResult").item(0).getFirstChild().getNodeValue();
//			if("False".equals(result))
//				return null;
//			
//			mobile = new MobileInfo();
//			Node nodeP = doc.getElementsByTagName("Province").item(0).getFirstChild();
//			Node nodeC = doc.getElementsByTagName("City").item(0).getFirstChild();
//			if(nodeP == null || nodeC == null)
//				return null;
//			mobile.setProvinceName(nodeP.getNodeValue());
//			mobile.setCityName(nodeC.getNodeValue());			
//			mobile.setAreaCode(doc.getElementsByTagName("AreaCode").item(0).getFirstChild().getNodeValue());
//			mobile.setPostCode(doc.getElementsByTagName("PostCode").item(0).getFirstChild().getNodeValue());
//			mobile.setCorp(doc.getElementsByTagName("Corp").item(0).getFirstChild().getNodeValue());
//			mobile.setCard(doc.getElementsByTagName("Card").item(0).getFirstChild().getNodeValue());
//			mobile.setMobile(phone);			
//			mobile.setCity(Initialize.getCityByName(mobile.getCityName()));
//			mobile.setOperator(StringUtil.getOperatorByName(mobile.getCorp()));
//		}catch(Exception ex){
//			ex.printStackTrace();			
//		}finally{			
//			if(in != null)
//				try {
//					in.close();
//				} catch (IOException e) {					
//					e.printStackTrace();
//				}
//			in = null;
//			documentBuilder = null;
//			httpUrlConn = null;
//			doc = null;
//		}
//		return mobile;
//	}
	
//	public static void main(String[] args){		
//		Connection conn = null;		
//		PreparedStatement pstmt = null;	
//		String sql = "insert into cn_mobile(mobile, pid, cid, areaCode, postCode, crop, card) values(?, ?, ?, ?, ?, ?, ?)";
//		
//		MobileInfo mobile = null;
//		int cid = 0, pid = 0;
//		try{
//			conn = getConnection();
//			pstmt = conn.prepareStatement(sql);
//			
//			Map<String, CityInfo> map = cityMap();		
//			int totalCount = 0;
//			int[] be = null;
//			int j = 0;
//			for(int count = 0; count < 28; count++){
//				be = getBE(count);
//				j = 0;
//				for(int i = be[0]; i <= be[1]; i ++){
//					mobile = getInfo(String.valueOf(i));
//					if(mobile != null){
//						CityInfo city = map.get(mobile.getCityName());
//						if(city != null){
//							cid = city.getIntId();
//							pid = city.getProvince().getIntId();
//							
//							pstmt.setString(1, mobile.getMobile());
//							pstmt.setInt(2, pid);
//							pstmt.setInt(3, cid);
//							pstmt.setString(4, mobile.getAreaCode());
//							pstmt.setString(5, mobile.getPostCode());
//							pstmt.setString(6, mobile.getCorp());
//							pstmt.setString(7, mobile.getCard());
//							
//							pstmt.addBatch();
//							j++;
//							totalCount++;							
//							if(j % 500 == 0){
//								System.out.println("insert 500 records");
//								pstmt.executeBatch();
//							}
//						}else{
//							System.out.println("不匹配的城市记录-->" + mobile.getCityName());
//							pstmt.executeUpdate("insert into cn_mobile2(mobile, cid, areaCode, postCode, crop, card) " +
//									"values('" + mobile.getMobile() + "', '" + mobile.getCityName() + "', '" + mobile.getAreaCode() + "', '" + mobile.getPostCode() + "', '" + mobile.getCorp() + "', '" + mobile.getCard() + "')");
//						}
//					}				
//				}
//				pstmt.executeBatch();
//			}		
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}finally{
//			clearup(pstmt, conn);
//		}
//	}
	
	
	
	public static int[] getBE(int i){
		int[] be = new int[2];		
		switch(i){
		case 0:
			be[0] = 1300000;be[1] = 1309999;
			break;
		case 1:
			be[0] = 1310000;be[1] = 1319999;
			break;
		case 2:
			be[0] = 1320000;be[1] = 1329999;
			break;
		case 3:
			be[0] = 1330000;be[1] = 1339999;
			break;
		case 4:
			be[0] = 1340000;be[1] = 1349999;
			break;
		case 5:
			be[0] = 1350000;be[1] = 1359999;
			break;
		case 6:
			be[0] = 1360000;be[1] = 1369999;
			break;
		case 7:
			be[0] = 1370000;be[1] = 1379999;
			break;
		case 8:
			be[0] = 1380000;be[1] = 1389999;
			break;
		case 9:
			be[0] = 1390000;be[1] = 1399999;
			break;
		case 10:
			be[0] = 1450000;be[1] = 1459999;
			break;
		case 11:
			be[0] = 1470000;be[1] = 1479999;
			break;
		case 12:
			be[0] = 1500000;be[1] = 1509999;
			break;
		case 13:
			be[0] = 1510000;be[1] = 1519999;
			break;
		case 14:
			be[0] = 1520000;be[1] = 1529999;
			break;
		case 15:
			be[0] = 1530000;be[1] = 1539999;
			break;
		case 16:
			be[0] = 1550000;be[1] = 1559999;
			break;
		case 17:
			be[0] = 1560000;be[1] = 1569999;
			break;
		case 18:
			be[0] = 1570000;be[1] = 1579999;
			break;
		case 19:
			be[0] = 1580000;be[1] = 1589999;
			break;
		case 20:
			be[0] = 1590000;be[1] = 1599999;
			break;
		case 21:
			be[0] = 1800000;be[1] = 1809999;
			break;
		case 22:
			be[0] = 1820000;be[1] = 1829999;
			break;
		case 23:
			be[0] = 1850000;be[1] = 1859999;
			break;
		case 24:
			be[0] = 1860000;be[1] = 1869999;
			break;
		case 25:
			be[0] = 1870000;be[1] = 1879999;
			break;
		case 26:
			be[0] = 1880000;be[1] = 1889999;
			break;
		case 27:
			be[0] = 1890000;be[1] = 1899999;
			break;		
		}
		return be;
	}
	
	public static Map<String, CityInfo> cityMap(){		
		List list = list();
		Map<String, CityInfo> map = new HashMap<String, CityInfo>();
		Iterator it = list.iterator();
		CityInfo city = null;
		String cityName = "";
		int len = 0;		
		for(; it.hasNext(); ){
			city = (CityInfo) it.next();
			cityName = city.getName();
			len = cityName.lastIndexOf("市");
			cityName =  len > 0 ? cityName.substring(0, len) : cityName;			
			map.put(cityName, city);
		}		
		return map;
	}
	
	public static List<CityInfo> list(){
		List<CityInfo> list = new ArrayList<CityInfo>();
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		String sql = "select a.id, a.name cityName, b.name provinceName, a.pid from cn_city a, cn_province b where a.pid = b.id";
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			CityInfo city = null;
			ProvinceInfo province = null;
			for(; rs.next(); ){
				city = new CityInfo();
				city.setIntId(rs.getInt("id"));
				city.setName(rs.getString("cityName"));

				province = new ProvinceInfo();
				province.setIntId(rs.getInt("pid"));
				province.setName(rs.getString("provinceName"));
				
				city.setProvince(province);
				list.add(city);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			clearup(rs, stmt, conn);
		}
		return list;
	}
	
	
	
	public static Connection getConnection(){		
		Connection conn = null;
		String driver = "org.gjt.mm.mysql.Driver";		
		String url = "jdbc:mysql://127.0.0.1:3306/cncoman?autoReconnect=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&user=root&password=123456";
		
		try {
			Class.forName(driver).getInterfaces();
			conn = (Connection) DriverManager.getConnection(url);
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return conn;
	}
	
	public static void clearup(ResultSet rs, Statement stmt, Connection conn){
		try{
			if(rs != null){
				rs.close();
				rs = null;
			}
			if(stmt != null){
				stmt.close();
				stmt = null;
			}
			if(conn != null){
				conn.close();
				conn = null;
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
	public static void clearup(ResultSet rs){
		clearup(rs, null, null);
	}
	
	public static void clearup(ResultSet rs, Statement stmt){
		clearup(rs, stmt, null);
	}
	
	public static void clearup(Statement stmt, Connection conn){
		clearup(null, stmt, conn);
	}
}
