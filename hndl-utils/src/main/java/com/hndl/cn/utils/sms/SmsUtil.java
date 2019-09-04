package com.hndl.cn.utils.sms;


import com.hndl.cn.utils.http.HttpClientUtil;

import java.net.URL;
import java.util.Random;

public class SmsUtil {



	public static String sendMobileVerifyCode(String mobiles){
		Random random =new Random();
		String code = "";
		for(int i = 0 ; i < 6 ; i ++){
			Integer integer = random.nextInt(9);
			code += integer;
		}
		String content = "【快乐粉丝会】登陆验证码：" +code+ "。为了您的账号安全，验证码请勿转发给他人。如果非您本人操作，请忽略。";
		sendSms(mobiles,content);
		return code;
	}

	public static String updateMobileVerifyCode(String mobiles){
		Random random =new Random();
		String code = "";
		for(int i = 0 ; i < 6 ; i ++){
			Integer integer = random.nextInt(9);
			code += integer;
		}
		String content = "【快乐粉丝会】修改手机号验证码：" +code+ "。为了您的账号安全，验证码请勿转发给他人。如果非您本人操作，请忽略。";
		sendSms(mobiles,content);
		return code;
	}
	/**
	 * 成功返回true
	 * @remark 
	 * @author shengfukang 杂碎
	 * @createDate 2015-2-12
	 * @param mobiles
	 * @param content
	 * @return
	 */
	public static boolean sendSms(String mobiles,String content) {
		// 发送  以前是：ems.smsway.com.cn
		//String sendURL = "http://121.201.38.146:8001/sendSMSHX.action";//以前：106.14.183.42
		
		if(!mobiles.isEmpty() && mobiles.startsWith("100")){
			return false;
		}
		
		String sendURL = "http://113.108.68.228:8001/sendSMSHX.action";

		String enterpriseID = "16910";// 企业id  北京互联通达的
		String loginName = "admin";// 登录名
		String password = "1539abc";// 密码
		
		String smsId = "";// 消息id
		String subPort = "";// 扩展端口
		content = HxJiaMiTools.jiaMiContent(content);
		mobiles = HxJiaMiTools.jiaMiMobile(mobiles);
		// 定时发送时间
		String sendTime = "";
		// post内容
		String postContent = "";
		// 返回结果
		String returnXML = "";
		try {
			postContent = "enterpriseID=" + enterpriseID + "&loginName="+ loginName + "&password=" + MD5.toMD5(password)
					+ "&smsId=" + smsId + "&subPort=" + subPort+ "&content="+ java.net.URLEncoder.encode(content, "UTF-8")+ "&mobiles="
					+ java.net.URLEncoder.encode(mobiles, "UTF-8")+ "&sendTime=" + sendTime;
			
			returnXML = HttpClientUtil.doPost(new URL(sendURL),postContent);
			if(returnXML.contains("<Result>0</Result>")){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public static void main(String[] args){

	}
}
