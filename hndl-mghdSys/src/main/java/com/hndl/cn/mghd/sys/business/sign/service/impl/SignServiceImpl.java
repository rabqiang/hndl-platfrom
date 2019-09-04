package com.hndl.cn.mghd.sys.business.sign.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.annotation.auth.bean.UserAuthLogin;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.enums.user.UserNormalityTaskEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.sign.service.SignService;
import com.hndl.cn.mghd.sys.business.sign.vo.QQLoginParamVo;
import com.hndl.cn.mghd.sys.business.sign.vo.SignDataVo;
import com.hndl.cn.mghd.sys.business.sign.vo.WechatLoginParamVo;
import com.hndl.cn.mghd.sys.business.sign.vo.WeiBoLoginParamVo;
import com.hndl.cn.mghd.sys.business.task.service.UserDayTaskService;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.task.manager.UserNormalityTaskManager;
import com.hndl.cn.mongodb.manager.user.bean.UserStatisticsDo;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import com.hndl.cn.utils.aes.AESUtil;
import com.hndl.cn.utils.http.HttpClientUtil;
import com.hndl.cn.utils.jwt.JwtTokenUtil;
import com.hndl.cn.utils.mobile.MobileUtil;
import com.hndl.cn.utils.string.StringUtils;
import com.hndl.cn.utils.wechat.WechatUtils;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/23 11:29
 * @Created by 湖南达联
 */
@Service
public class SignServiceImpl implements SignService {

    private static final Logger log = LoggerFactory.getLogger(SignServiceImpl.class);

    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;

    @Resource
    private UserDayTaskService userDayTaskService;

    @Resource
    private UserNormalityTaskManager userNormalityTaskManager;

    private ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;

    @Value("${wechat.js.code.url}")
    private String wechatJsCodeUrl;

    @Value("${wechat.grant.type}")
    private String wechatGrantType;

    @Value("${wecaht.app.id}")
    private String wechatAppId;

    @Value("${wechat.app.secret}")
    private String wechatAppSecret;

    @Value("${wechat.subscription.app.id}")
    private String subscriptionAppId;

    @Value("${wechat.subscription.secret}")
    private String subscriptionAppSecret;

    @Value("${wechat.subscription.redirect.url}")
    private String redirectUrl;


    private static final String USER_NAME = "快乐君_";

    private static final Integer USER_NAME_LENTH = 6;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Object> signUserByMobile(String mobile, String deviceNumber,boolean isNewData) {
        //通过手机号查询用户
        CommonUserInfoDo userByMobile = commonUserInfoManager.findUserByMobile(mobile,null);

        //如果存在直接生成token
        if (userByMobile != null) {
            this.checkUserInfo(userByMobile);
            log.info("=========================手机" + mobile + "用户存在，登陆成功====================================");
            String signToken = this.createSignToken(userByMobile.getSysUniId());
            return ResultFactory.success(SignDataVo.builder().token(signToken).isNewUser(IsValidEnums.NO.getValue()).build());
        } else {
            log.info("=========================手机用户不存在存在，创建用户====================================");
            CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
            Date date = new Date();
            Long userUinId = iSnowflakeIdService.nextUserId();
            String netType = MobileUtil.validateMobile(mobile);
            commonUserInfoDo.setNetType(netType);
            commonUserInfoDo.setCreateOperator(mobile);
            commonUserInfoDo.setLastOperator(mobile);
            commonUserInfoDo.setPhoneNum(mobile);
            commonUserInfoDo.setPhoneNumPerson(Long.parseLong(mobile));
            commonUserInfoDo.setPrizeGivePhone(mobile);
            commonUserInfoDo.setNickName(getLoginUserName(null));
            commonUserInfoDo.setPersonImgUrlMax(BaseConstants.Default_personImgUrlMax);
            commonUserInfoDo.setPersonImgUrlMin(BaseConstants.Default_personImgUrlMin);
            commonUserInfoDo.setSysUniId(userUinId);
            commonUserInfoDo.setCreateTime(date);
            commonUserInfoDo.setLastModifyTime(date);

            boolean isCreateUser = commonUserInfoManager.addUserInfo(commonUserInfoDo);

            //直接绑定手机号
            userNormalityTaskManager.insert(userUinId,mobile, UserNormalityTaskEnums.BIND_PHONE,IsValidEnums.NO.getValue());

            //这里初始化用户统计数据
            this.initUserStatistics(isCreateUser, userUinId, date);
            //首次登陆送积分和经验，稍后补充
            // TH000

            String signToken = this.createSignToken(commonUserInfoDo.getSysUniId());
            if(isNewData){
                return ResultFactory.success(SignDataVo.builder().token(signToken).isNewUser(IsValidEnums.YES.getValue()).build());
            }
            return ResultFactory.success(signToken);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Object> wechatLogin(WechatLoginParamVo wechatLoginParamVo,boolean isNewData) {

        CommonUserInfoDo userByWeChatUniId = commonUserInfoManager.findUserByWeChatUniId(wechatLoginParamVo.getWeixinUniId(),null);

        //如果存在
        if (userByWeChatUniId != null) {
            this.checkUserInfo(userByWeChatUniId);
            log.info("=========================微信" + userByWeChatUniId.getWeixinUniId() + "用户存在，登陆成功====================================");
            String signToken = this.createSignToken(userByWeChatUniId.getSysUniId());
            return ResultFactory.success(SignDataVo.builder().token(signToken).isNewUser(IsValidEnums.NO.getValue()).build());
        } else {
            log.info("=========================微信用户不存在存在，创建用户====================================");
            CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
            Date date = new Date();
            Long userUinId = iSnowflakeIdService.nextUserId();
            commonUserInfoDo.setCreateOperator(wechatLoginParamVo.getWeixinUniId());
            commonUserInfoDo.setCreateTime(date);
            commonUserInfoDo.setLastModifyTime(date);
            commonUserInfoDo.setLastOperator(wechatLoginParamVo.getWeixinUniId());
            String loginUserName = getLoginUserName(wechatLoginParamVo.getNickName());

            commonUserInfoDo.setNickName(StringUtils.filterEmoji(loginUserName));
            this.setUserInfoImg(commonUserInfoDo, wechatLoginParamVo.getUserImgUrl(), wechatLoginParamVo.getUserImgUrl());
            commonUserInfoDo.setPersonImgUrlMin(wechatLoginParamVo.getUserImgUrl());
            commonUserInfoDo.setWeixinOpenId(wechatLoginParamVo.getWeixinOpenId());
            commonUserInfoDo.setWeixinUniId(wechatLoginParamVo.getWeixinUniId());
            commonUserInfoDo.setDeviceNumber(wechatLoginParamVo.getDeviceNumber());
            commonUserInfoDo.setAppType(wechatLoginParamVo.getAppType());
            commonUserInfoDo.setUmengChannel(wechatLoginParamVo.getUmengChannel());
            commonUserInfoDo.setSysUniId(userUinId);
            commonUserInfoDo.setCreateTime(date);
            commonUserInfoDo.setLastModifyTime(date);
            boolean isCreateUser = commonUserInfoManager.addUserInfo(commonUserInfoDo);

            //这里初始化用户统计数据
            this.initUserStatistics(isCreateUser, userUinId, date);

            //首次登陆送积分和经验，稍后补充
            // TH000
            String signToken = this.createSignToken(commonUserInfoDo.getSysUniId());
            if(isNewData){
                return ResultFactory.success(SignDataVo.builder().token(signToken).isNewUser(IsValidEnums.YES.getValue()).build());
            }

            return ResultFactory.success(signToken);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Object> weiBoLogin(WeiBoLoginParamVo weiBoLoginParamVo,boolean isNewData) {

        CommonUserInfoDo userByWeiBoOpenId = commonUserInfoManager.findUserByWeiBoOpenId(weiBoLoginParamVo.getWeiboOpenId(),null);

        if (userByWeiBoOpenId != null) {
            this.checkUserInfo(userByWeiBoOpenId);
            log.info("=========================微博" + userByWeiBoOpenId.getWeiboOpenId() + "用户存在，登陆成功====================================");
            String signToken = this.createSignToken(userByWeiBoOpenId.getSysUniId());
            return ResultFactory.success(SignDataVo.builder().token(signToken).isNewUser(IsValidEnums.NO.getValue()).build());
        } else {
            log.info("=========================微博用户不存在存在，创建用户====================================");
            CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
            Date date = new Date();
            Long userUinId = iSnowflakeIdService.nextUserId();
            commonUserInfoDo.setCreateOperator(weiBoLoginParamVo.getWeiboOpenId());
            commonUserInfoDo.setCreateTime(date);
            commonUserInfoDo.setLastModifyTime(date);
            commonUserInfoDo.setLastOperator(weiBoLoginParamVo.getWeiboOpenId());

            String loginUserName = getLoginUserName(weiBoLoginParamVo.getNickName());
            commonUserInfoDo.setNickName(StringUtils.filterEmoji(loginUserName));
            this.setUserInfoImg(commonUserInfoDo, weiBoLoginParamVo.getUserImgUrl(), weiBoLoginParamVo.getUserImgUrl());
            commonUserInfoDo.setDeviceNumber(weiBoLoginParamVo.getDeviceNumber());
            commonUserInfoDo.setAppType(weiBoLoginParamVo.getAppType());
            commonUserInfoDo.setUmengChannel(weiBoLoginParamVo.getUmengChannel());
            commonUserInfoDo.setWeiboOpenId(weiBoLoginParamVo.getWeiboOpenId());
            commonUserInfoDo.setSysUniId(userUinId);
            commonUserInfoDo.setCreateTime(date);
            commonUserInfoDo.setLastModifyTime(date);
            boolean isCreateUser = commonUserInfoManager.addUserInfo(commonUserInfoDo);

            //这里初始化用户统计数据
            this.initUserStatistics(isCreateUser, userUinId, date);

            //首次登陆送积分和经验，稍后补充
            // TH000
            String signToken = this.createSignToken(commonUserInfoDo.getSysUniId());
            if(isNewData){
                return ResultFactory.success(SignDataVo.builder().token(signToken).isNewUser(IsValidEnums.YES.getValue()).build());
            }

            return ResultFactory.success(signToken);

        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Object> qqLogin(QQLoginParamVo qqLoginParamVo,boolean isNewData) {

        CommonUserInfoDo userByQqOpenId = commonUserInfoManager.findUserByQqOpenId(qqLoginParamVo.getQqOpenId(),null);

        if (userByQqOpenId != null) {
            this.checkUserInfo(userByQqOpenId);
            log.info("=========================qq:" + userByQqOpenId.getQqOpenId() + "用户存在，登陆成功====================================");
            String signToken = this.createSignToken(userByQqOpenId.getSysUniId());
            return ResultFactory.success(SignDataVo.builder().token(signToken).isNewUser(IsValidEnums.NO.getValue()).build());
        } else {
            log.info("=========================qq用户不存在存在，创建用户====================================");
            CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
            Date date = new Date();
            Long userUinId = iSnowflakeIdService.nextUserId();
            commonUserInfoDo.setCreateOperator(qqLoginParamVo.getQqOpenId());
            commonUserInfoDo.setCreateTime(date);
            commonUserInfoDo.setLastModifyTime(date);
            commonUserInfoDo.setLastOperator(qqLoginParamVo.getQqOpenId());
            commonUserInfoDo.setNickName(this.getLoginUserName(StringUtils.filterEmoji(qqLoginParamVo.getNickName())));
            this.setUserInfoImg(commonUserInfoDo, qqLoginParamVo.getUserImgUrl(), qqLoginParamVo.getUserImgUrl());
            commonUserInfoDo.setDeviceNumber(qqLoginParamVo.getDeviceNumber());
            commonUserInfoDo.setAppType(qqLoginParamVo.getAppType());
            commonUserInfoDo.setUmengChannel(qqLoginParamVo.getUmengChannel());
            commonUserInfoDo.setQqOpenId(qqLoginParamVo.getQqOpenId());
            commonUserInfoDo.setSysUniId(userUinId);
            commonUserInfoDo.setCreateTime(date);
            commonUserInfoDo.setLastModifyTime(date);
            boolean isCreateUser = commonUserInfoManager.addUserInfo(commonUserInfoDo);

            //这里初始化用户统计数据
            this.initUserStatistics(isCreateUser, userUinId, date);


            //首次登陆送积分和经验，稍后补充

            // TH000
            String signToken = this.createSignToken(commonUserInfoDo.getSysUniId());
            if(isNewData){
                return ResultFactory.success(SignDataVo.builder().token(signToken).isNewUser(IsValidEnums.YES.getValue()).build());
            }


            return ResultFactory.success(signToken);
        }
    }

    @Override
    public Result<Object> getWecahtLoginData(String jsCode, String encryptedData, String iv) {

        String url = this.builderWechatJsCodeUrl(jsCode);

        String json = HttpClientUtil.doGet(url);

        Map<String, Object> map = JSON.parseObject(json, Map.class);

        Object errorCode = map.get("errcode");


        if (errorCode != null) {
            throw new MghdSysException(PublicExceptionCodeEnum.EX_OPERATION_FAIL.getCode());
        }

        Map<String, String> resultMap = new HashMap<>();
        Object openid = map.get("openid");

        if (openid == null) {
            throw new MghdSysException(PublicExceptionCodeEnum.EX_OPERATION_FAIL.getCode());
        }
        resultMap.put("openId", openid.toString());

        String unionid = map.get("unionid") == null ? null :map.get("unionid").toString();

        if (StringUtils.isBlank(unionid)) {
            String sessionkey = map.get("session_key").toString();
            // 被加密的数据
            byte[] dataByte = Base64.decodeBase64(encryptedData);
            // 加密秘钥
            byte[] aesKeyByte = Base64.decodeBase64(sessionkey);
            // 偏移量
            byte[] ivByte = Base64.decodeBase64(iv);

            try {
                String aesResult = AESUtil.decryptWecat(dataByte, aesKeyByte, ivByte);
                log.error("aesResult : "  + aesResult);
                Map<String, Object> aesMap = JSON.parseObject(aesResult, Map.class);
                unionid = aesMap.get("unionId").toString();
            } catch (InvalidAlgorithmParameterException e) {
                throw new MghdSysException(PublicExceptionCodeEnum.EX_OPERATION_FAIL.getCode());
            }
        }

        resultMap.put("unionId", unionid);

        return ResultFactory.success(resultMap);
    }

    @Override
    public String oauth2buildAuthorizationUrl() {
       return WechatUtils.oauth2buildAuthorizationUrl(subscriptionAppId,redirectUrl);
    }

    @Override
    public Result<Object> getWechatAccess(String code) {

        String result = WechatUtils.getOauth2WechatAccess(subscriptionAppId, subscriptionAppSecret, code);

        JSONObject jsonObject = JSONObject.parseObject(result);

        String openId = jsonObject.getString("openid");

        String token = jsonObject.getString("access_token");

        //获取信息
        String userInfo = WechatUtils.gettOauth2WechatUserInfo(token, openId);

        JSONObject infoObj = JSONObject.parseObject(userInfo);

        String unionid = infoObj.getString("unionid");

        if(StringUtils.isEmpty(unionid)){
            throw new MghdSysException(PublicExceptionCodeEnum.EX_OPERATION_FAIL.getCode());
        }
        Map<String,Object> map = new HashMap<>();

        Long userUinId = null;
        CommonUserInfoDo userByWeChatUniId = commonUserInfoManager.findUserByWeChatUniId(unionid,null);

        //如果存在直接生成token
        if (userByWeChatUniId != null) {
            this.checkUserInfo(userByWeChatUniId);
            userUinId = userByWeChatUniId.getSysUniId();
            map.put("isNewUser",IsValidEnums.NO.getValue());
            log.info("=========================微信" + userByWeChatUniId.getWeixinUniId() + "用户存在，登陆成功====================================");
        }else {
            log.info("=========================手机用户不存在存在，创建用户====================================");
            CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
            Date date = new Date();
            userUinId= iSnowflakeIdService.nextUserId();
            commonUserInfoDo.setCreateOperator(unionid);
            commonUserInfoDo.setCreateTime(date);
            commonUserInfoDo.setLastModifyTime(date);
            commonUserInfoDo.setLastOperator(unionid);
            String loginUserName = getLoginUserName(infoObj.getString("nickname"));

            commonUserInfoDo.setNickName(StringUtils.filterEmoji(loginUserName));
            this.setUserInfoImg(commonUserInfoDo, infoObj.getString("headimgurl"), infoObj.getString("headimgurl"));
            commonUserInfoDo.setPersonImgUrlMin(infoObj.getString("headimgurl"));
            commonUserInfoDo.setWeixinOpenId(openId);
            commonUserInfoDo.setWeixinUniId(unionid);
            commonUserInfoDo.setAppType("web");
            commonUserInfoDo.setUmengChannel("subscription");
            commonUserInfoDo.setSysUniId(userUinId);
            commonUserInfoDo.setCreateTime(date);
            commonUserInfoDo.setLastModifyTime(date);
            //这里初始化用户统计数据
            boolean isCreateUser = commonUserInfoManager.addUserInfo(commonUserInfoDo);
            this.initUserStatistics(isCreateUser, userUinId, date);
            map.put("isNewUser",IsValidEnums.YES.getValue());
        }

        map.put("token",this.createSignToken(userUinId));
        map.put("openId",openId);


        return ResultFactory.success(map);
    }


    private void initUserStatistics(boolean isCreateUser, Long userUinId, Date date) {

        if (!isCreateUser) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_ADD_USER__EXCEPTION.getCode());
        }
        if (userStatisticsDoManager.findUserStatisticsByUserUinId(userUinId) != null) {
            return;
        }

        //这里初始化用户统计数据
        UserStatisticsDo userStatisticsDo = new UserStatisticsDo();
        userStatisticsDo.setCreateTime(date.getTime());
        userStatisticsDo.setUserUniId(userUinId);
        userStatisticsDo.setSlaveCount(0);
        userStatisticsDo.setSlaveFansContribute(0L);
        userStatisticsDo.setEmpirical(0L);
        userStatisticsDo.setIntegralCount(0L);
        userStatisticsDo.setGettingLoveCount(0L);
        userStatisticsDo.setSpreadCount(0);
        userStatisticsDo.setFoucaultCount(0);
        userStatisticsDoManager.initUserStatistics(userStatisticsDo);
    }


    @Override
    @SubmitLock(keys = "userUinId",sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public String createSignToken(Long userUinId) {
        UserAuthLogin userAuthLogin = new UserAuthLogin();
        userAuthLogin.setLoginUserId(userUinId);
        userAuthLogin.setTimeOut(System.currentTimeMillis() + BaseConstants.JWT_TOKEN_VALID_TIME);
        //创建token时候刷新登陆任务

        userDayTaskService.insetTask(userUinId, 0L, UserDayTaskEnums.LOGIN_TASK);

        return JwtTokenUtil.createToken(JSONObject.toJSONString(userAuthLogin), BaseConstants.JWT_TOKEN_KEY);
    }

    /**
     * 构造微信jscode url
     *
     * @param jsCode
     * @return
     */
    private String builderWechatJsCodeUrl(String jsCode) {
        StringBuilder stringBuilder = new StringBuilder(wechatJsCodeUrl);
        stringBuilder.append("appid=").append(wechatAppId).append("&secret=")
                .append(wechatAppSecret).append("&js_code=").append(jsCode).append("&grant_type=")
                .append(wechatGrantType);
        return stringBuilder.toString();
    }

    private String getLoginUserName(String userName){
          if(StringUtils.isBlank(userName)){
              return USER_NAME + StringUtils.getRandomString(USER_NAME_LENTH);
          }
          return userName + "_" + StringUtils.getRandomString(4);
    }


    private void setUserInfoImg(CommonUserInfoDo commonUserInfoDo, String minImg, String maxImg) {
        commonUserInfoDo.setPersonImgUrlMin(StringUtils.isBlank(minImg) ? BaseConstants.Default_personImgUrlMin : minImg);
        commonUserInfoDo.setPersonImgUrlMax(StringUtils.isBlank(maxImg) ? BaseConstants.Default_personImgUrlMax : maxImg);
    }

    private void checkUserInfo(CommonUserInfoDo commonUserInfoDo){
        if(commonUserInfoDo.getIsDeleted().equals(IsValidEnums.YES.getOldValue())){
               throw new MghdSysException(PublicExceptionCodeEnum.EX_USER_LOCKED.getCode());
        }

    }
}
