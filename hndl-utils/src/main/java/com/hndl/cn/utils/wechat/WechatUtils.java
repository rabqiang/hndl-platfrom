package com.hndl.cn.utils.wechat;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.utils.http.HttpClientUtil;

import java.net.URLEncoder;

/**
 * @author 赵俊凯
 * @Description 微信工具类
 * @Date 2019/8/26 11:47
 * @Created by 湖南达联
 */
public class WechatUtils {


    /**
     * 获取微信AccessToken
     * @param appId
     * @param appSecret
     * @return
     */
    public static String getWeChatAccessToken(String appId,String appSecret){
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId +
                "&secret=" + appSecret;

        String result = HttpClientUtil.doGet(url);

        JSONObject jsonObject = JSONObject.parseObject(result);

        return jsonObject.getString("access_token");
    }

    /**
     * 获取用户Oauth2 AccessToken
     * @param appId
     * @param appSecret
     * @param code
     * @return
     */
    public static String getOauth2WechatAccess(String appId,String appSecret,String code){
        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + appId+
                "&secret=" +appSecret+
                "&code=" +code+
                "&grant_type=authorization_code";

        return HttpClientUtil.doGet(url);
    }


    /**
     * 获取用户信息
     * @param token
     * @param openId
     * @return
     */
    public static String gettOauth2WechatUserInfo(String token,String openId){
        //获取信息
        String infoUrl="https://api.weixin.qq.com/sns/userinfo?access_token=" +token+
                "&openid=" +openId+
                "&lang=zh_CN";


        return HttpClientUtil.doGet(infoUrl);
    }

    /**
     * 获取跳转地址
     * @param appId
     * @param redirectUrl
     * @return
     */
    public static String oauth2buildAuthorizationUrl(String appId,String redirectUrl){
        try {
            return "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appId+
                    "&redirect_uri=" + URLEncoder.encode(redirectUrl,"UTF-8")+
                    "&response_type=code" +
                    "&scope=snsapi_userinfo" +
                    "&state=STATE#wechat_redirect";
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 发送消息
     * @param token
     * @param jsonContent
     * @return
     */
    public static String sendWechatMsg(String token,String jsonContent){
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send" + "?access_token=" +  token;
        return HttpClientUtil.doPostJson(url,jsonContent);
    }

}
