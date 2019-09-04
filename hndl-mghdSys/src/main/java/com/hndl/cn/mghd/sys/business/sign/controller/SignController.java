package com.hndl.cn.mghd.sys.business.sign.controller;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.annotation.auth.bean.UserAuthLogin;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.RequestTypeEnums;
import com.hndl.cn.base.redis.sms.RedisSmsKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.sys.business.sign.service.SignService;
import com.hndl.cn.mghd.sys.business.sign.vo.*;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.aes.AESUtil;
import com.hndl.cn.utils.jwt.JwtTokenUtil;
import com.hndl.cn.utils.reg.RegExUtil;
import com.hndl.cn.utils.request.RequestUtil;
import com.hndl.cn.utils.sms.SmsUtil;
import com.hndl.cn.utils.string.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author 赵俊凯
 * @Description 登陆相关接口
 * @Date 2019/4/22 19:43
 * @Created by 湖南达联
 */
@Controller
@RequestMapping("/{source}/sign")
@Api(value = "/{source}/sign",tags = "登陆相关接口")
public class SignController {

    @Resource
    private RedisService redisService;

    @Resource
    private SignService signService;

    @Value("${app.auth.mobile}")
    private String appAuthMobile;

    @Value("${app.auth.code}")
    private String appAuthCode;

    private static final Logger log = LoggerFactory.getLogger(SignController.class);

    @PostMapping("/sendMobileVerifyCode/{mobile}")
    @ResponseBody
    @ApiOperation(value="获取手机验证码")
    public Result<Object> sendMobileVerifyCode(@PathVariable String source,
                                               @ApiParam(name="mobile",value="手机号码",required=true)
                                               @PathVariable(required = false) String mobile){
        if(StringUtils.isBlank(mobile) || !RegExUtil.isPhoneLegal(mobile)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_MOBILE_ERROR.getCode());
        }

        //获取key
        String smsKey = RedisSmsKey.getSmsCodeKey(mobile);

        if(redisService.exists(smsKey)){
            throw new MghdSysException(PublicExceptionCodeEnum.EX_MOB_EXCESSIVE_ATTEMPTS.getCode());
        }
        //获取code
        String code = SmsUtil.sendMobileVerifyCode(mobile);

        redisService.set(smsKey,code,RedisSmsKey.OUT_TIME);

        return ResultFactory.success();
    }


    @GetMapping(value = {"/refreshToken/{version:.+}","/refreshToken"})
    @ResponseBody
    @ApiOperation(value="刷新Token")
    public Result<Object> refreshToken(HttpServletRequest request,@PathVariable String source,
                                       @PathVariable(required = false) String version){

        String token = RequestUtil.getRequestHeaderByKey(request,BaseConstants.JWT_TOKEN_COOKIE_KEY);
        //参数校验
        if(StringUtils.isBlank(token)){
            log.error(RequestUtil.getErrorMsg(request)+","+"token:" + token);
            throw new MghdSysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
        }
        String json = null;
        try{
            json = JwtTokenUtil.decryption(token,BaseConstants.JWT_TOKEN_KEY);
        }catch (Exception e){
            throw new MghdSysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
        }
            if(StringUtils.isBlank(json)){
                throw new MghdSysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
        }

        UserAuthLogin userAuthLogin = JSONObject.parseObject(json,UserAuthLogin.class);

        if(userAuthLogin == null || userAuthLogin.getLoginUserId() == null){
                throw new MghdSysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
        }
        //如果都成功返回新的token
        if(StringUtils.isNotBlank(version)){
           return ResultFactory.success(SignDataVo.builder().token(signService.createSignToken(userAuthLogin.getLoginUserId())).build());
        }
        return ResultFactory.success(signService.createSignToken(userAuthLogin.getLoginUserId()));


    }


    /**
     * 手机登陆接口
     * @param vo
     * @return
     */
    @PostMapping(value = {"/mobileVerifyCodeLogin/{version:.+}","/mobileVerifyCodeLogin"})
    @ResponseBody
    @ApiOperation(value="手机验证码登陆")
    public Result<Object> mobileVerifyCodeLogin(@PathVariable String source,@PathVariable(required = false) String version,
                                                @Valid @RequestBody MobileLoginParamVo vo){


        if(StringUtils.isBlank(vo.getMobile()) || !RegExUtil.isPhoneLegal(vo.getMobile()) || !RequestUtil.checkVerifyCode(vo.getVerifyCode())){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_MOBILE_ERROR.getCode());
        }

        boolean flag = StringUtils.isNotEmpty(version);

        if(appAuthMobile.equals(vo.getMobile()) && appAuthCode.equals(vo.getVerifyCode())){
            return signService.signUserByMobile(vo.getMobile(),vo.getDeviceNumber(),flag);
        }

        //获取key
        String smsKey = RedisSmsKey.getSmsCodeKey(vo.getMobile());

            //检查
        String redisCode = redisService.get(smsKey);

        if(StringUtils.isBlank(redisCode) || !vo.getVerifyCode().equals(redisCode)){
                throw new MghdSysException(PublicExceptionCodeEnum.EX_VERIFY_CODE_ERROR.getCode());
        }
        if(vo.getVerifyCode().equals(redisCode)){
                redisService.del(smsKey);
        }
        return signService.signUserByMobile(vo.getMobile(),vo.getDeviceNumber(),flag);
    }


    /**
     * 微信登陆接口
     * @return
     */
    @PostMapping(value = {"/wechatLogin/{version:.+}","/wechatLogin"})
    @ResponseBody
    @ApiOperation(value="微信登陆/注册")
    public Result<Object> wechatLogin(HttpServletRequest request,@PathVariable String source,@PathVariable(required = false) String version,
                                      @RequestBody LoginAesData data){


        String key = RequestUtil.getRequestHeaderByKey(request,BaseConstants.HTTP_HEADER_KEY);

        log.info("=============hndl_http_header_key : {}================",key);

        if(StringUtils.isBlank(key)){
            throw new MghdSysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
        }
        //ip地址做为key,解密
        String jsonData = this.aesDecrypt(data.getData(),AESUtil.getSecretKey(key));

        //转换为对象
        WechatLoginParamVo vo = JSONObject.parseObject(jsonData,WechatLoginParamVo.class);

        if(!RequestUtil.isFieldNull(vo)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        boolean flag = StringUtils.isNotEmpty(version);

        return signService.wechatLogin(vo,flag);
    }


    /**
     * 微博登陆接口
     * @return
     */
    @PostMapping(value = {"/sinaWeiBoLogin/{version:.+}","/sinaWeiBoLogin"})
    @ResponseBody
    @ApiOperation(value="微博登陆/注册")
    public Result<Object> sinaWeiBoLogin(HttpServletRequest request,@PathVariable String source,@PathVariable(required = false) String version,
                                         @RequestBody LoginAesData data){

        String key = RequestUtil.getRequestHeaderByKey(request,BaseConstants.HTTP_HEADER_KEY);

        log.info("=============hndl_http_header_key : {}================",key);

        if(StringUtils.isBlank(key)){
            throw new MghdSysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
        }

        //ip地址做为key,解密
        String jsonData = this.aesDecrypt(data.getData(),AESUtil.getSecretKey(key));

        WeiBoLoginParamVo vo = JSONObject.parseObject(jsonData,WeiBoLoginParamVo.class);


        if(!RequestUtil.isFieldNull(vo)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        boolean flag = StringUtils.isNotEmpty(version);

        return signService.weiBoLogin(vo,flag);
    }

    /**
     * qq登陆
     * @return
     */
    @PostMapping(value = {"/qqLogin/{version:.+}","/qqLogin"})
    @ResponseBody
    @ApiOperation(value="QQ登陆/注册")
    public Result<Object> qqLogin(HttpServletRequest request,@PathVariable String source,@PathVariable(required = false) String version,
                                  @RequestBody LoginAesData data){

        String key = RequestUtil.getRequestHeaderByKey(request,BaseConstants.HTTP_HEADER_KEY);

        log.info("=============hndl_http_header_key : {}================",key);

        if(StringUtils.isBlank(key)){
            throw new MghdSysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
        }

        //ip地址做为key,解密
        String jsonData = this.aesDecrypt(data.getData(),key);

        QQLoginParamVo vo = JSONObject.parseObject(jsonData,QQLoginParamVo.class);


        if(!RequestUtil.isFieldNull(vo)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        boolean flag = StringUtils.isNotEmpty(version);

        return signService.qqLogin(vo,flag);
    }

    @GetMapping("/getWecahtLoginData")
    @ResponseBody
    @ApiOperation(value="小程序通过临时登录凭证 code获取openid和unionid")
    public Result<Object> getWecahtLoginData(HttpServletRequest request,@PathVariable String source,
                                  @RequestParam String jsCode,@RequestParam String encryptedData,@RequestParam String iv){

        if(!RequestTypeEnums.WECHAT_PROGRAM.getValue().equals(source)){
            throw new MghdSysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
        }
        if(StringUtils.isBlank(jsCode) || StringUtils.isBlank(encryptedData) || StringUtils.isBlank(iv)){
             throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        return signService.getWecahtLoginData(jsCode, encryptedData, iv);
    }


//    @GetMapping("/redirectAuthorizationUrl")
//    public void oauth2buildAuthorizationUrl(HttpServletResponse response) throws Exception{
//        response.sendRedirect(signService.oauth2buildAuthorizationUrl());
//    }


    @GetMapping(value = "/getWechatAccessToken")
    @ApiOperation(value="微信公众号h5登陆注册接口")
    @ResponseBody
    public Result<Object> getWechatAccessToken( @ApiParam(name="code",value="微信code",required=true) @RequestParam String code){
        return signService.getWechatAccess(code);
    }



    private String aesDecrypt(String data,String secretKey){
        if(StringUtils.isBlank(data)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        String jsonData = null;
        try {
            //解密失败
            jsonData = AESUtil.decrypt(data,secretKey);

        }catch (Exception e){
            throw new MghdSysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
        }

        //如果为空，返回参数错误
        if(StringUtils.isBlank(jsonData)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        return jsonData;
    }


    public static void main(String[] args) {
        WechatLoginParamVo vo = new WechatLoginParamVo();
    }


}
