package com.hndl.cn.pay.sys.util;


import com.hndl.cn.pay.sys.init.WeChatPayConfig;
import com.hndl.cn.pay.sys.init.WechatAppletsPayConfig;
import com.hndl.cn.utils.http.HttpClientUtil;
import com.hndl.cn.utils.md5.MD5Utils;
import com.hndl.cn.utils.string.StringUtils;
import org.apache.commons.collections.map.HashedMap;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;


/**
 * 微信支付
 */
public class WeChatPayUtil {

   private static final Logger log = LoggerFactory.getLogger(WeChatPayUtil.class);

   /**
    * 得到微信预付单的返回ID
    * @param orderId  商户自己的订单号
    * @param totalFee  总金额  （分）
    * @return
    */
   public static Map<String,String> getPreyId(String userId , String orderId, String totalFee,
                                              WeChatPayConfig weChatPayConfig){
      Map<String, String> reqMap = new HashMap<String, String>();
      reqMap.put("appid", weChatPayConfig.getAppId());
      reqMap.put("mch_id", weChatPayConfig.getAppKey());
      reqMap.put("nonce_str", getRandomString());
      reqMap.put("body", "快乐粉丝会");
      reqMap.put("detail", weChatPayConfig.getCommodityName()); //非必填
      reqMap.put("out_trade_no", orderId); //商户系统内部的订单号,
      reqMap.put("total_fee", totalFee); //订单总金额，单位为分
      reqMap.put("attach",userId);
      reqMap.put("spbill_create_ip", getHostIp()); //用户端实际ip
      reqMap.put("notify_url", weChatPayConfig.getNotifyUrl() ); //通知地址
      reqMap.put("trade_type", "APP"); //交易类型
      reqMap.put("sign",getSign(reqMap,weChatPayConfig.getAppPrivateKey()));
      String reqStr = creatXml(reqMap);
      String resultString = HttpClientUtil.postXml(weChatPayConfig.getPayUrl(), reqStr);
      Map<String, String> infoByXml = getInfoByXml(resultString,weChatPayConfig.getAppPrivateKey());

      String prepayId = infoByXml.get("prepay_id");
      String nonceStr = infoByXml.get("nonce_str");
      String timeStamp = getTenTimes();

      Map<String, String> result = new HashMap<String, String>();
      result.put("appid", weChatPayConfig.getAppId());
      result.put("prepayid", prepayId);
      result.put("noncestr", nonceStr);
      result.put("timestamp", timeStamp);
      result.put("package", "Sign=WXPay");
      result.put("partnerid", weChatPayConfig.getAppKey());
      result.put("sign",getSign(result,weChatPayConfig.getAppPrivateKey()));
//
//	  url += "appid="+WeiXinAppId+"&"
//	  + "prepayid=" +prepayId+"&"
//	  + "noncestr="+nonceStr+"&"
//	  + "timestamp="+timeStamp
//	  + "&packageValue="+"Sign%3DWXPay"
//	  + "&partnerid="+MchId
//	  + "&sign="+sign3;
      
      return result;
   }

   public static Map<String,String> getPreyIdApplets(String userId ,String orderId,String totalFee,String openId,
                                                     WechatAppletsPayConfig wechatAppletsPayConfig){
      Map<String, String> reqMap = new HashMap<String, String>();

      //小程序支付

      reqMap.put("openid", openId);
      // reqMap.put("appid", WeiXinAppId);
      reqMap.put("appid", wechatAppletsPayConfig.getAppId());
      reqMap.put("mch_id", wechatAppletsPayConfig.getAppMid());
      reqMap.put("nonce_str", getRandomString());
      reqMap.put("body", "快乐粉丝会");
      reqMap.put("detail", wechatAppletsPayConfig.getCommodityName()); // 非必填
      reqMap.put("out_trade_no", orderId); // 商户系统内部的订单号,
      reqMap.put("total_fee", totalFee); // 订单总金额，单位为分
      reqMap.put("attach", userId);
      reqMap.put("spbill_create_ip", getHostIp()); // 用户端实际ip
      reqMap.put("notify_url", wechatAppletsPayConfig.getNotifyUrl()); // 通知地址
      reqMap.put("trade_type", "JSAPI");
      reqMap.put("sign", getSign(reqMap, wechatAppletsPayConfig.getAppPrivateKey()));

      String reqStr = creatXml(reqMap);
      String retStr = HttpClientUtil.postXml(wechatAppletsPayConfig.getPayUrl(), reqStr);
      Map<String, String> infoByXml = getInfoByXml(retStr, wechatAppletsPayConfig.getAppPrivateKey());

      String prepayId = infoByXml.get("prepay_id");
      String nonceStr = infoByXml.get("nonce_str");
      String timeStamp = getTenTimes();

      Map<String,String> signMap = new HashedMap();
      signMap.put("appId", wechatAppletsPayConfig.getAppId());
      signMap.put("nonceStr", nonceStr);
      signMap.put("timeStamp", timeStamp);
      signMap.put("package", "prepay_id=" + prepayId);
      signMap.put("signType", "MD5");


      Map<String, String> result = new HashMap<>();
      result.put("noncestr", nonceStr);
      result.put("prepayid",prepayId);
      result.put("partnerid",wechatAppletsPayConfig.getAppMid());
      result.put("timestamp", timeStamp);
      result.put("package", "Sign=WXPay");
      result.put("sign",getSign(signMap,wechatAppletsPayConfig.getAppPrivateKey()));

      return result;
   }


   public static Map<String,String> getPreyIdSubscription(String userId ,String orderId,String totalFee,String openId,
                                                     WechatAppletsPayConfig wechatAppletsPayConfig,String appId){
      Map<String, String> reqMap = new HashMap<String, String>();

      //小程序支付

      reqMap.put("openid", openId);
      // reqMap.put("appid", WeiXinAppId);
      reqMap.put("appid", appId);
      reqMap.put("mch_id",  wechatAppletsPayConfig.getAppMid());
      reqMap.put("nonce_str", getRandomString());
      reqMap.put("body", "快乐粉丝会");
      reqMap.put("detail", wechatAppletsPayConfig.getCommodityName()); // 非必填
      reqMap.put("out_trade_no", orderId); // 商户系统内部的订单号,
      reqMap.put("total_fee", totalFee); // 订单总金额，单位为分
      reqMap.put("attach", userId);
      reqMap.put("spbill_create_ip", getHostIp()); // 用户端实际ip
      reqMap.put("notify_url", wechatAppletsPayConfig.getNotifyUrl()); // 通知地址
      reqMap.put("trade_type", "JSAPI");
      reqMap.put("sign", getSign(reqMap, wechatAppletsPayConfig.getAppPrivateKey()));

      String reqStr = creatXml(reqMap);
      String retStr = HttpClientUtil.postXml(wechatAppletsPayConfig.getPayUrl(), reqStr);
      Map<String, String> infoByXml = getInfoByXml(retStr, wechatAppletsPayConfig.getAppPrivateKey());

      String prepayId = infoByXml.get("prepay_id");
      String nonceStr = infoByXml.get("nonce_str");
      String timeStamp = getTenTimes();

      Map<String,String> signMap = new HashedMap();
      signMap.put("appId", appId);
      signMap.put("nonceStr", nonceStr);
      signMap.put("timeStamp", timeStamp);
      signMap.put("package", "prepay_id=" + prepayId);
      signMap.put("signType", "MD5");


      Map<String, String> result = new HashMap<>();
      result.put("noncestr", nonceStr);
      result.put("prepayid",prepayId);
      result.put("partnerid",wechatAppletsPayConfig.getAppMid());
      result.put("timestamp", timeStamp);
      result.put("package", "Sign=WXPay");
      result.put("sign",getSign(signMap,wechatAppletsPayConfig.getAppPrivateKey()));

      return result;
   }

   /**
    * 传入map  生成头为XML的xml字符串，例：<xml><key>123</key></xml>
    * @param reqMap
    * @return
    */
   public static String creatXml(Map<String, String> reqMap){
      Set<String> set = reqMap.keySet();
      StringBuffer stringBuffer = new StringBuffer("<xml>");
      for(String key : set){
         if(key.equals("sign")){
            stringBuffer.append("<").append(key).append(">");
            stringBuffer.append(reqMap.get(key));
            stringBuffer.append("</").append(key).append(">");
         }else {
            stringBuffer.append("<").append(key).append(">");
            stringBuffer.append("<![CDATA[").append(reqMap.get(key)).append("]]>");
            stringBuffer.append("</").append(key).append(">");
         }
      }
      stringBuffer.append("</xml>");
      return stringBuffer.toString();
   }

   /**
    * 得到加密值
    * @param map
    * @return
    */
   public static String getSign(Map<String, String> map,String AppSercret){
      String[] keys = map.keySet().toArray(new String[0]);
      Arrays.sort(keys);
      StringBuffer reqStr = new StringBuffer();
      for(String key : keys){
         if(key.equals("sign")){
            continue;
         }
         String v = map.get(key);
         if(v != null && !v.equals("")){
            reqStr.append(key).append("=").append(v).append("&");
         }
      }
      reqStr.append("key").append("=").append(AppSercret);

//      System.out.println(reqStr.toString());

      //MD5加密
      return MD5Utils.encode(reqStr.toString()).toUpperCase();
   }

   public static boolean isSignatureValid(Map<String,String> map,String sercret){
      String sign = map.get("sign");
      log.info("sign");
      if(StringUtils.isEmpty(sign)){
          return false;
      }
//      System.out.println("isSignatureValid : " + getSign(map, sercret));
      return getSign(map, sercret).equals(sign);
   }

   /**
    * 得到10 位的时间戳
    * 如果在JAVA上转换为时间要在后面补上三个0 
    * @return
    */
   public static String getTenTimes(){
      String t = new Date().getTime()+"";
      t = t.substring(0, t.length()-3);
      return t;
   }

   /**
    * 得到随机字符串
    * @return
    */
   public static String getRandomString(){
      int length = 32;
      String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
      Random random = new Random();
      StringBuffer sb = new StringBuffer();

      for(int i = 0; i < length; ++i){
         int number = random.nextInt(62);//[0,62)  
         sb.append(str.charAt(number));
      }
      return sb.toString();
   }

   /**
    * 得到本地机器的IP
    * @return
    */
   public static String getHostIp(){
      String ip = "";
      try{
         ip = InetAddress.getLocalHost().getHostAddress();
      }catch(UnknownHostException e){
         e.printStackTrace();
      }
      return ip;
   }

   /**
    * 将XML转换为Map 验证加密算法 然后返回
    * @param xml
    * @return
    */
   public static Map<String, String>  getInfoByXml(String xml,String AppSercret){
      try{
         Map<String, String> map = new HashMap<String, String>();
         Document document = DocumentHelper.parseText(xml);
         Element root = document.getRootElement();
         for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
             Element element = (Element) i.next();
             String name = element.getName();
             String text = element.getText();
             map.put(name, text);
         }
         String retSign = map.get("sign");
         map.remove("sign");
         String rightSing = getSign(map,AppSercret);
         if(rightSing.equals(retSign)){
            return map;
         }
      }catch(Exception e){
         return null;
      }
      return null;
   }


   /**
    * 将金额转换成分
    * @param fee 元格式的
    * @return 分
    */
   public static String changeToFen(Double fee){
      String priceStr = "";
      if(fee != null){
          int p = (int)(fee * 100); //价格变为分
          priceStr = Integer.toString(p);
      }
      return priceStr;
   }


   
//   public static void main(String[] args) {
//	   getPreyId("100004" ,"20180126112056123345213","600",
//			   "https://api.mch.weixin.qq.com/pay/unifiedorder",
//			   "http://shop.mgtvhd.com/shopM/ShopOrderInfoPay_weixinNotify.do",
//			   "25521909b894a0d0127d8db6ca4f9dfb","wxadec0d21568ce3dc",
//			   "1497384632");
//   }

}