package com.hndl.cn.utils.sms;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class HxJiaMiTools {
	private static final String DES_KEY  = "huaxingyinghang";
	private static final String ENC="utf-8";
	public static void main(String[] args) {
		
		//加密手机号
		String mobileMiWen = jiaMiMobile("18000000000");
		System.out.println("加密：src->desc->base64\n"+mobileMiWen);
		//解密手机号
		String mobilesrc = jieMiMoblie(mobileMiWen);
		System.out.println("解密：miwen->解utf-8->解desc\n"+mobilesrc);
		
		//加密短信内容
//		String contentMiWen = jiaMiContent("你好Hello，我是测试人员。");
//		String contentMiWen2 = jiaMiContent2("你好Hello，我是测试人员。");
//		System.out.println("加密：src->des->base64->utf-8\n"+contentMiWen);
//		System.out.println("加密：src->des->utf-8\n"+contentMiWen2);

		//解密短信内容
//		String srcContent = jieMiContent(contentMiWen);
//		String srcContent2 = jieMiContent2(contentMiWen2);
//		System.out.println("解密：miwen->解utf-8->解base64->解des:"+srcContent);
//		System.out.println("解密：miwen->解utf-8->解desc:"+srcContent2);
	}

	
	
	/**
	 * 对短信密文解密
	 * 密文-> UTF-8解码 -> BASE64解码-> DES解密->明文
	 * @param contentMiWen 密文字符串
	 * @return
	 */
	public static String jieMiContent(String contentMiWen) {
		try {
			String str = URLDecoder.decode(contentMiWen, ENC);
			byte[] base64Bytes = new BASE64Decoder().decodeBuffer(str);
			String ret = decrypt(DES_KEY.getBytes(), base64Bytes);
			return ret;
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

//	public static String jieMiContent2(String contentMiWen) {
//		try {
//			String str = URLDecoder.decode(contentMiWen, ENC);
////			byte[] base64Bytes = new BASE64Decoder().decodeBuffer(str);
//			String ret = decrypt(DES_KEY.getBytes(), str.getBytes());
//			return ret;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "";
//		}
//	}



	/**
	 * 对短信内容进行加密
	 * 明文 -> DES加密 -> BASE64编码 -> UTF-8编码->密文
	 * @param src
	 * @return
	 */
	public static String jiaMiContent(String src) {
		byte[] desBytes;
		try {
			desBytes = encrypt(DES_KEY.getBytes(), src);
			String base64Str = new BASE64Encoder().encode(desBytes);
			return URLEncoder.encode(base64Str, ENC);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} 		
	}



	/**
	 * 对手机号进行解密
	 * 密文 ->BASE64解码->DES解密->明文
	 * @param miwen
	 * @return
	 */
	public static String jieMiMoblie(String miwen) {
		try {
			byte[] base64Bytes = new BASE64Decoder().decodeBuffer(miwen);
			return decrypt(DES_KEY.getBytes(), base64Bytes);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 对手机号进行加密
	 * 明文 -> DES加密->BASE64编码->密文
	 * @param src
	 * @return
	 */
	public static String jiaMiMobile(String src) {
		
		try {
			byte[] desBytes = encrypt(DES_KEY.getBytes(), src);
			return new BASE64Encoder().encode(desBytes);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
	}

	
	public static byte[] encrypt(byte rawKeyData[], String str)  
            throws InvalidKeyException, NoSuchAlgorithmException,  
            IllegalBlockSizeException, BadPaddingException,  
            NoSuchPaddingException, InvalidKeySpecException {  
        
		// DES算法要求有一个可信任的随机数源  
        SecureRandom sr = new SecureRandom();  
        // 从原始密匙数据创建一个DESKeySpec对象  
        DESKeySpec dks = new DESKeySpec(rawKeyData);  
        // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
        SecretKey key = keyFactory.generateSecret(dks);  
        // Cipher对象实际完成加密操作  
        Cipher cipher = Cipher.getInstance("DES");  
        // 用密匙初始化Cipher对象  
        cipher.init(Cipher.ENCRYPT_MODE, key, sr);  
        // 现在，获取数据并加密  
        byte data[] = str.getBytes();  
        // 正式执行加密操作  
        byte[] encryptedData = cipher.doFinal(data);  
 
        return encryptedData;
//        System.out.println("加密后===>" + encryptedData +" =>"+new String(encryptedData));  
//        return encryptedData;  
    }
	
	public static String decrypt(byte rawKeyData[], byte[] encryptedData)  
            throws IllegalBlockSizeException, BadPaddingException,  
            InvalidKeyException, NoSuchAlgorithmException,  
            NoSuchPaddingException, InvalidKeySpecException, IOException {  
        // DES算法要求有一个可信任的随机数源  
        SecureRandom sr = new SecureRandom();  
        // 从原始密匙数据创建一个DESKeySpec对象  
        DESKeySpec dks = new DESKeySpec(rawKeyData);  
        // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成一个SecretKey对象  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
        SecretKey key = keyFactory.generateSecret(dks);  
        // Cipher对象实际完成解密操作  
        Cipher cipher = Cipher.getInstance("DES");  
        // 用密匙初始化Cipher对象  
        cipher.init(Cipher.DECRYPT_MODE, key, sr);  
        // 正式执行解密操作  
        
        byte decryptedData[] = cipher.doFinal(encryptedData);
        return new String(decryptedData,"UTF-8");  
    }
}
