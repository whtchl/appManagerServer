package com.cncoman.product.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.cncoman.product.util.StringUtil;

public class GetPhoneCity {
    private static String callUrlByGet(String callurl,String charset){   
        String result = "";   
        try {   
            URL url = new URL(callurl);   
            URLConnection connection = url.openConnection();   
            connection.connect();   
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),charset));   
            String line;   
            while((line = reader.readLine())!= null){    
                result += line;   
                result += "\n";
            }
        } catch (Exception e) {   
            e.printStackTrace();   
            return "";
        }
        return result;
    }
    /**
	 * 067 手机号码归属地 068
	 * 
	 * @param tel
	 *            手机号码 069
	 * @return 135XXXXXXXX,联通/移动/电信,湖北武汉 070
	 * @throws Exception
	 *             071
	 * @author JIA-G-Y 072
     * @throws Exception 
     * @throws Exception 
     * @throws Exception 
	 */
    public static String[] getMobileNumerInfo(String tel){
    	String [] phone = null;
    	try {
    		phone = getMobileNumerInfo2(tel).split(",");
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return phone;
    }
    public static String getMobileNumerInfo2(String tel) throws Exception{
        Pattern pattern = Pattern.compile("1\\d{10}");
        Matcher matcher = pattern.matcher(tel);
        if(matcher.matches()){
            String url = "http://life.tenpay.com/cgi-bin/mobile/MobileQueryAttribution.cgi?chgmobile=" + tel;
            String result = callUrlByGet(url,"GBK");
            StringReader stringReader = new StringReader(result); 
            InputSource inputSource = new InputSource(stringReader); 
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance(); 
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder(); 
            Document document = documentBuilder.parse(inputSource);
            String retmsg = document.getElementsByTagName("retmsg").item(0).getFirstChild().getNodeValue();
            if(retmsg.equals("OK")){
                String province = document.getElementsByTagName("province").item(0).getFirstChild().getNodeValue().trim();
                String city = document.getElementsByTagName("city").item(0).getFirstChild().getNodeValue().trim();
                if (province.equals("-"))
                	province = "未知";
                if (city.equals("-"))
                	city = "未知";
                return (province+ "," + city);
            }else {
                return "未知,未知";
            }
        }else{
            return "未知,未知";
        }
    }
	/**
	 * 判断传入的参数号码为哪家运营商
	 * @param mobile
	 * @return 运营商名称
	 */
	public static String validateMobile(String mobile){
		String returnString="";
		if(mobile==null){
			return "0";//mobile参数为空
		}
		//System.out.println(mobile.trim().substring(0,3));
		if(mobile.trim().length()!=11){
			return "0";//手机号码长度不为11，错误！
		}
		if(mobile.trim().substring(0,3).equals("134") ||  mobile.trim().substring(0,3).equals("135") || 
				mobile.trim().substring(0,3).equals("136") || mobile.trim().substring(0,3).equals("137")  
				|| mobile.trim().substring(0,3).equals("138")  || mobile.trim().substring(0,3).equals("139") || mobile.trim().substring(0,3).equals("147")
				||  mobile.trim().substring(0,3).equals("150") || mobile.trim().substring(0,3).equals("151") || mobile.trim().substring(0,3).equals("152")  
				|| mobile.trim().substring(0,3).equals("157") || mobile.trim().substring(0,3).equals("158") || mobile.trim().substring(0,3).equals("159") 
				  || mobile.trim().substring(0,3).equals("182") || mobile.trim().substring(0,3).equals("187") || mobile.trim().substring(0,3).equals("188")){
			returnString="1";//中国移动
		}
		if(mobile.trim().substring(0,3).equals("130") ||  mobile.trim().substring(0,3).equals("131") || 
				mobile.trim().substring(0,3).equals("132") || mobile.trim().substring(0,3).equals("156")  
				|| mobile.trim().substring(0,3).equals("185")  || mobile.trim().substring(0,3).equals("186")
				|| mobile.trim().substring(0,3).equals("145") || mobile.trim().substring(0,3).equals("155")){
			returnString="2";//中国联通
		}
		if(mobile.trim().substring(0,3).equals("133") ||  mobile.trim().substring(0,3).equals("153") || 
				mobile.trim().substring(0,3).equals("180") || mobile.trim().substring(0,3).equals("189")){
			returnString="3";//中国电信
		}
		if(returnString.trim().equals("")){
			returnString="0";//未知的运营商
		}
		return returnString;
	}
}
