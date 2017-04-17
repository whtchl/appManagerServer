package com.cncoman.product.util;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncodeHelper {
	public static final String TYPE = "DESede/CBC/PKCS5Padding";

	public static final String KEYTYPE = "DESede";

	private static IvParameterSpec ips = null;

	private static BASE64Encoder ebs64 = null;

	private static BASE64Decoder dbs64 = null;

	private static Cipher c1 = null;

	private static String strKey = "3eqwVrlT0aYYxGjtW2wia6Wi";

	static {
		try {			
			ips = new IvParameterSpec("12345678".getBytes("utf-8"));
			ebs64 = new BASE64Encoder();
			dbs64 = new BASE64Decoder();
			c1 = Cipher.getInstance(TYPE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String XDEncode(String strWhiteText){
		byte[] byteUtf8 = null;
		try {
			byteUtf8 = strWhiteText.getBytes("utf-8");

			SecretKey deskey = new SecretKeySpec(strKey.getBytes(), KEYTYPE);
			c1.init(Cipher.ENCRYPT_MODE, deskey, ips);

			byte[] byteTemp = c1.doFinal(byteUtf8); // 0001 DES加密
			String strBase64 = ebs64.encode(byteTemp); // 0002
														// 对加密后字节流进行BASE64编码

			strBase64 = URLEncoder.encode(strBase64, "utf-8"); // 0003																

			return strBase64;
		} catch (Exception e) {
			e.printStackTrace();
			return "Encode_ERROR";
		}
	}

	/**
	 * 默认为Web容器方式。
	 * 
	 * @param strBlackText
	 * @return
	 */
	public String XDDecode(String strBlackText){
		return XDDecode(strBlackText, false);
	}

	/**
	 * 若CP方使用Web容器，由于容器自身默认会做URLDecode动作，故调用该方法时不需做解码动作，isNeedDecode应传入false。
	 * 
	 * @param strBlackText
	 * @param isNeedDecode
	 * @return
	 */
	public static String XDDecode(String strBlackText, boolean isNeedDecode){
		byte[] byteUtf8 = null;

		try {
			if (isNeedDecode) {
				strBlackText = URLDecoder.decode(strBlackText, "utf-8"); // 0001																	
			}

			byteUtf8 = strBlackText.getBytes("utf-8");
			byteUtf8 = dbs64.decodeBuffer(new String(byteUtf8)); // 0002
																	// 对字节流进行BASE64解码
			SecretKey deskey = new SecretKeySpec(strKey.getBytes(), KEYTYPE);
			c1.init(Cipher.DECRYPT_MODE, deskey, ips);

			byte[] byteEncrypted = c1.doFinal(byteUtf8); // 0003 DES解密
			String strUtf8 = new String(byteEncrypted, "utf-8");
			return strUtf8;
		} catch (Exception e) {
			e.printStackTrace();
			return "Decode_ERROR";
		}
	}
	
	public static void main(String[] args){
		System.out.println(XDEncode("26"));
	}
}
