package com.hndl.cn.mghd.sys.business.sign.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.sign.vo.QQLoginParamVo;
import com.hndl.cn.mghd.sys.business.sign.vo.SignDataVo;
import com.hndl.cn.mghd.sys.business.sign.vo.WechatLoginParamVo;
import com.hndl.cn.mghd.sys.business.sign.vo.WeiBoLoginParamVo;

/**
 * @author 赵俊凯
 * @Description 登陆service
 * @Date 2019/4/23 11:25
 * @Created by 湖南达联
 */
public interface SignService {


    /**
     * 创建登陆token
     * @param userUinId
     * @return
     */
    String createSignToken(Long userUinId);


    /**
     * 登陆/注册手机账号
     * @param mobile
     * @param deviceNumber
     * @return
     */
    Result<Object> signUserByMobile(String mobile,String deviceNumber,boolean isNewData);


    /**
     * 微信登陆方法
     * @param wechatLoginParamVo
     * @return
     */
    Result<Object> wechatLogin(WechatLoginParamVo wechatLoginParamVo,boolean isNewData);


    /**
     * 微博登陆方法
     * @param weiBoLoginParamVo
     * @return
     */
    Result<Object> weiBoLogin(WeiBoLoginParamVo weiBoLoginParamVo,boolean isNewData);


    /**
     * qq登陆方法
     * @param qqLoginParamVo
     * @return
     */
    Result<Object> qqLogin(QQLoginParamVo qqLoginParamVo,boolean isNewData);


    /**
     * 获取小程序登陆信息
     * @return
     */
    Result<Object> getWecahtLoginData(String jsCode,String encryptedData,String iv);


    /**
     * 获取微信的跳转地址
     * @return
     */
    String oauth2buildAuthorizationUrl();


    /**
     * 获取用户信息
     * @param code
     * @return
     */
    Result<Object> getWechatAccess(String code);

}
