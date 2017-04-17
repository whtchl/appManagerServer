package com.cncoman.product.util;

import java.util.HashMap;

public class StringUtil {
	
	public final static String CMCC_NUMBERS = ",134,135,136,137,138,139,150,151,152,157,158,159,187,188,147,182,183,184,";
	public final static String UNICOM_NUMBERS = ",130,131,132,155,156,185,186,145,";
	public final static String CDMA_NUMBERS = ",133,153,180,189,";
	
	private static long lastClickTime;
	
	private static HashMap<String, String> map = new HashMap<String, String>();
	
	static{
		map.put(".apk", "application/vnd.android.package-archive");
		map.put(".ai", "application/postscript");
		map.put(".aif", "audio/x-aiff");
		map.put(".aifc", "audio/x-aiff");
		map.put(".aiff", "audio/x-aiff");
		map.put(".asc", "text/plain");
		map.put(".au", "audio/basic");
		map.put(".avi", "video/x-msvideo");
		map.put(".bcpio", "application/x-bcpio");
		map.put(".bin", "application/octet-stream");
		map.put(".c", "text/plain");
		map.put(".cc", "text/plain");
		map.put(".ccad", "application/clariscad");
		map.put(".cdf", "application/x-netcdf");
		map.put(".class", "application/octet-stream");
		map.put(".cpio", "application/x-cpio");
		map.put(".cpt", "application/mac-compactpro");
		map.put(".csh", "application/x-csh");
		map.put(".css", "text/css");
		map.put(".dcr", "application/x-director");
		map.put(".dir", "application/x-director");
		map.put(".dms", "application/octet-stream");
		map.put(".doc", "application/msword");
		map.put(".drw", "application/drafting");
		map.put(".dvi", "application/x-dvi");
		map.put(".dwg", "application/acad");
		map.put(".dxf", "application/dxf");
		map.put(".dxr", "application/x-director");
		map.put(".eps", "application/postscript");
		map.put(".etx", "text/x-setext");
		map.put(".exe", "application/octet-stream");
		map.put(".ez", "application/andrew-inset");
		map.put(".f", "text/plain");
		map.put(".f90", "text/plain");
		map.put(".fli", "video/x-fli");
		map.put(".gif", "image/gif");
		map.put(".gtar", "application/x-gtar");
		map.put(".gz", "application/x-gzip");
		map.put(".h", "text/plain");
		map.put(".hdf", "application/x-hdf");
		map.put(".hh", "text/plain");
		map.put(".hqx", "application/mac-binhex40");
		map.put(".htm", "text/html");
		map.put(".html", "text/html");
		map.put(".ice", "x-conference/x-cooltalk");
		map.put(".ief", "image/ief");
		map.put(".iges", "model/iges");
		map.put(".igs", "model/iges");
		map.put(".ips", "application/x-ipscript");
		map.put(".ipx", "application/x-ipix");
		map.put(".jpe", "image/jpeg");
		map.put(".jpeg", "image/jpeg");
		map.put(".jpg", "image/jpeg");
		map.put(".js", "application/x-javascript");
		map.put(".kar", "audio/midi");
		map.put(".latex", "application/x-latex");
		map.put(".lha", "application/octet-stream");
		map.put(".lsp", "application/x-lisp");
		map.put(".lzh", "application/octet-stream");
		map.put(".m", "text/plain");
		map.put(".man", "application/x-troff-man");
		map.put(".me", "application/x-troff-me");
		map.put(".mesh", "model/mesh");
		map.put(".mid", "audio/midi");
		map.put(".midi", "audio/midi");
		map.put(".mif", "application/vnd.mif");
		map.put(".mime", "www/mime");
		map.put(".mov", "video/quicktime");
		map.put(".movie", "video/x-sgi-movie");
		map.put(".mp2", "audio/mpeg");
		map.put(".mp3", "audio/mpeg");
		map.put(".mpe", "video/mpeg");
		map.put(".mpeg", "video/mpeg");
		map.put(".mpg", "video/mpeg");
		map.put(".mpga", "audio/mpeg");
		map.put(".ms", "application/x-troff-ms");
		map.put(".msh", "model/mesh");
		map.put(".nc", "application/x-netcdf");
		map.put(".oda", "application/oda");
		map.put(".pbm", "image/x-portable-bitmap");
		map.put(".pdb", "chemical/x-pdb");
		map.put(".pdf", "application/pdf");
		map.put(".pgm", "image/x-portable-graymap");
		map.put(".pgn", "application/x-chess-pgn");
		map.put(".png", "image/png");
		map.put(".pnm", "image/x-portable-anymap");
		map.put(".pot", "application/mspowerpoint");
		map.put(".ppm", "image/x-portable-pixmap");
		map.put(".pps", "application/mspowerpoint");
		map.put(".ppt", "application/mspowerpoint");
		map.put(".ppz", "application/mspowerpoint");
		map.put(".pre", "application/x-freelance");
		map.put(".prt", "application/pro_eng");
		map.put(".ps", "application/postscript");
		map.put(".qt", "video/quicktime");
		map.put(".ra", "audio/x-realaudio");
		map.put(".ram", "audio/x-pn-realaudio");
		map.put(".ras", "image/cmu-raster");
		map.put(".rgb", "image/x-rgb");
		map.put(".rm", "audio/x-pn-realaudio");
		map.put(".roff", "application/x-troff");
		map.put(".rpm", "audio/x-pn-realaudio-plugin");
		map.put(".rtf", "text/rtf");
		map.put(".rtx", "text/richtext");
		map.put(".scm", "application/x-lotusscreencam");
		map.put(".set", "application/set");
		map.put(".sgm", "text/sgml");
		map.put(".sgml", "text/sgml");
		map.put(".sh", "application/x-sh");
		map.put(".shar", "application/x-shar");
		map.put(".silo", "model/mesh");
		map.put(".sit", "application/x-stuffit");
		map.put(".skd", "application/x-koan");
		map.put(".skm", "application/x-koan");
		map.put(".skp", "application/x-koan");
		map.put(".skt", "application/x-koan");
		map.put(".smi", "application/smil");
		map.put(".smil", "application/smil");
		map.put(".snd", "audio/basic");
		map.put(".sol", "application/solids");
		map.put(".spl", "application/x-futuresplash");
		map.put(".src", "application/x-wais-source");
		map.put(".step", "application/STEP");
		map.put(".stl", "application/SLA");
		map.put(".stp", "application/STEP");
		map.put(".sv4cpio", "application/x-sv4cpio");
		map.put(".sv4crc", "application/x-sv4crc");
		map.put(".swf", "application/x-shockwave-flash");
		map.put(".t", "application/x-troff");
		map.put(".tar", "application/x-tar");
		map.put(".tcl", "application/x-tcl");
		map.put(".tex", "application/x-tex");
		map.put(".texi", "application/x-texinfo");
		map.put(".texinfo", "application/x-texinfo");
		map.put(".tif", "image/tiff");
		map.put(".tiff", "image/tiff");
		map.put(".tr", "application/x-troff");
		map.put(".tsi", "audio/TSP-audio");
		map.put(".tsp", "application/dsptype");
		map.put(".tsv", "text/tab-separated-values");
		map.put(".txt", "text/plain");
		map.put(".unv", "application/i-deas");
		map.put(".ustar", "application/x-ustar");
		map.put(".vcd", "application/x-cdlink");
		map.put(".vda", "application/vda");
		map.put(".viv", "video/vnd.vivo");
		map.put(".vivo", "video/vnd.vivo");
		map.put(".vrml", "model/vrml");
		map.put(".wav", "audio/x-wav");
		map.put(".wrl", "model/vrml");
		map.put(".xbm", "image/x-xbitmap");
		map.put(".xlc", "application/vnd.ms-excel");
		map.put(".xll", "application/vnd.ms-excel");
		map.put(".xlm", "application/vnd.ms-excel");
		map.put(".xls", "application/vnd.ms-excel");
		map.put(".xlw", "application/vnd.ms-excel");
		map.put(".xml", "text/xml");
		map.put(".xpm", "image/x-xpixmap");
		map.put(".xwd", "image/x-xwindowdump");
		map.put(".xyz", "chemical/x-pdb");
		map.put(".zip", "application/zip");
	}
	
	/**
	 * �ַ�Ϊ�շ���true
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str){
		if(str == null)
			return true;
		if("".equals(str.trim()))
			return true;
		if("null".equalsIgnoreCase(str))
			return true;
		if("--ȫ������--".equals(str))
			return true;
		if("--ȫ������--".equals(str))
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param suffix �ļ���׺������.mp3
	 * @param charset �ַ�GBK
	 * @return
	 */
	public static String getHttpContentType(String suffix, String charset){
		String contentType = map.get(suffix);
		if(!isNull(contentType))
			return contentType + ";charset=" + charset;
		return null;
	}
	

	/**
	 * ������ݿ���õ�int��ID����<br/>
	 * ���磺1,2,3,4
	 * @param ids ����
	 * @return
	 */
	public static String getSequence(Object[] ids){
		String str = "";
		if(ids != null && ids.length > 0){
			for(int i = 0; i < ids.length; i++){
				str += ids[i] + ","; 
			}
			str = str.substring(0, str.length() - 1);
		}			
		return str;
	}
	
	/**
	 * ����ֻ���������Ӫ��<br/>
	 * �ֻ�Ŵ���ʱ����0
	 * @param mobile
	 * @return 1�ƶ�,2jͨ,3����,4δ֪��Ӫ��
	 */
	public static int getOperator(String mobile){		
		if(isNull(mobile))
			return 0;
//		mobile = formatMobile(mobile);
		mobile = mobile.replace("+", "");
		if(mobile.startsWith("86"))
			mobile = mobile.replaceFirst("86", "");
		if(!isNumeric(mobile))
			return 0;		
		if(mobile.length() < 7 || mobile.length() > 12)   //�ֻ����������7λС��12λ
			return 0;
		if(mobile.startsWith("1349"))   //1349�ǵ���
			return 3;
		mobile = "," + mobile.substring(0, 3) + ",";
		if(CMCC_NUMBERS.indexOf(mobile) != -1)   //���ƶ�
			return 1;
		if(UNICOM_NUMBERS.indexOf(mobile) != -1)   //jͨ
			return 2;
		if(CDMA_NUMBERS.indexOf(mobile) != -1)  //����
			return 3;
		return 0;
	}
	
	
	public static int getOperatorByName(String operatorName){
		if(isNull(operatorName))
			return 0;
		operatorName = operatorName.trim();
		if("�й��ƶ�".equals(operatorName))
			return 1;
		if("�й�jͨ".equals(operatorName))
			return 2;
		if("�й����".equals(operatorName))
			return 3;
		return 0;
	}
	
	/**
	 * ��ʽ���ֻ����<br/>
	 * ȥ��+86��ȥ��ո�
	 * @param mobile �ֻ���룬����Ϊ��
	 * @return
	 */
	public static String formatMobile(String mobile){
		if(isNull(mobile))
			return mobile;
		mobile = mobile.trim();
		int len = mobile.length();
		if(len <= 11)
			return mobile;
		mobile = mobile.substring(len - 11, len);
		return mobile;
	}
	
	public static boolean isMobile(String mobile){
		if(isNull(mobile))
			return false;
		mobile = mobile.replace("+", "");
		if(mobile.startsWith("86"))
			mobile = mobile.replaceFirst("86", "");
		if(!isNumeric(mobile))
			return false;		
		if(mobile.length() != 11)
			return false;
		if(getOperator(mobile) == 0)
			return false;
		return true;
	}
	
	/**
	 * �ж��Ƿ�Ϊ������<br/>
	 * �Ƿ�Ϊ��С��
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		if(isNull(str))
			return false;
		if (str.matches("^[0-9]*$")) {
			return true;
		}
		if(str.matches("^\\d+\\.\\d+$"))
			return true;
		return false;
	}
	
	/**
	 * �����false
	 * Ƶ������true
	 * @param seconds
	 * @return
	 */
	public boolean frequentClick(int seconds){
		long currentClickTime = System.currentTimeMillis();
		long time = currentClickTime - lastClickTime;		
		lastClickTime = currentClickTime;
		if(time < (seconds * 1000))
			return true;		
		return false;
	}
	
	public static void main(String[] args){
		//System.out.println(org.apache.commons.lang.StringUtils.isNumeric("20.66"));
		//System.out.println(isNumeric("99"));
//		System.out.println(isMobile("13415686204"));
		System.out.println(getOperator("18357800747"));
	}
}
