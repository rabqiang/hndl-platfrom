package com.hndl.cn.mghd.sys.business.user.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.redis.sms.RedisSmsKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.user.service.UserStatisticsService;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.file.FileUtils;
import com.hndl.cn.utils.reg.RegExUtil;
import com.hndl.cn.utils.sms.SmsUtil;
import com.hndl.cn.utils.string.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @author 曹加丽
 * @Description 进行用户基本信息的操作
 * @Date 2019/5/10 11:02
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/{source}/user")
@Api(value = "/{source}/user", tags = "用户基本信息  相关接口")
public class CommonUserInfoController {

    //注入相关的service层
    @Resource
    private UserStatisticsService userStatisticsService;
    @Resource
    private RedisService redisService;

    /**
     * 查询用户详细的信息
     *
     * @return
     */
    @ApiOperation(value = "查询用户信息", notes = "用户必须先登陆.否则无法查询个人信息")
    @AuthPassport
    @GetMapping("/findLoginUserInfo")
    public Result<Object> findUserStatisticsByUserUinId(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo) {

        return userStatisticsService.findUserStatisticsByUserUinId(commonUserInfoDo.getSysUniId());
    }

    /**
     * 修改用户头像
     *
     * @param commonUserInfoDo 登陆的当前用户信息
     * @param userImgUrl       要修改的头像url
     * @return
     */
    @ApiOperation(value = "修改用户头像", notes = "用户要登陆才能使用,头像不能超过两千个字符")
    @AuthPassport
    @GetMapping("/updateUserImgUrl")
    public Result<Object> updateUserImgUrl(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo, @RequestParam @ApiParam(value = "用户头像") String userImgUrl) {
        //校验url是否合法
        if (!RegExUtil.isImgUrl(userImgUrl)) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_PIC_DATA_EXCEPTION.getCode());
        }
        if ("gif".equalsIgnoreCase(FileUtils.getExtensionName(userImgUrl))) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_UPDATE_USER_IMG_URL_FIND.getCode());
        }


        return userStatisticsService.updateUserPersonImgUrl(commonUserInfoDo, userImgUrl);
    }

    /**
     * 修改用户昵称
     *
     * @param commonUserInfoDo 登陆的当前用户信息
     * @param nickName         需要修改的用户昵称
     * @return
     */
    @ApiOperation(value = "修改用户昵称", notes = "用户要登陆才能使用,昵称最长20个字符")
    @AuthPassport
    @GetMapping("/updateUserNickName")
    public Result<Object> updateUserNickName(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo, @RequestParam @ApiParam(value = "用户昵称") String nickName) {

        return userStatisticsService.updateUserNickName(commonUserInfoDo, nickName);

    }

    /**
     * 用户修改个性签名
     *
     * @param commonUserInfoDo  登陆的当前用户信息
     * @param personalAutograph 需要修改的个性签名
     * @return
     */
    @ApiOperation(value = "修改用户个性签名", notes = "用户必须登陆才能使用,个性签名最多20字(含特殊字符)")
    @AuthPassport
    @GetMapping("/updateUserPersonalAutograph")
    public Result<Object> updateUserPersonalAutograph(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo, @RequestParam @ApiParam(value = "需要修改个性签名") String personalAutograph) {

        return userStatisticsService.updateUserPersonalAutograph(commonUserInfoDo, personalAutograph);

    }

    @PostMapping("/updateMobileVerifyCode/{mobile}")
    @ApiOperation(value = "获取修改手机的验证码", notes = "获取修改手机的验证码")
    public Result<Object> updateMobileVerifyCode(@PathVariable String source,
                                                 @ApiParam(name = "mobile", value = "手机号码", required = true)
                                                 @PathVariable String mobile) {
        if (StringUtils.isBlank(mobile) || !RegExUtil.isPhoneLegal(mobile)) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_MOBILE_ERROR.getCode());
        }

        //获取key
        String smsKey = RedisSmsKey.getSmsCodeKey(mobile);

        if (redisService.exists(smsKey)) {
            throw new MghdSysException(PublicExceptionCodeEnum.EX_MOB_EXCESSIVE_ATTEMPTS.getCode());
        }
        //获取code
        String code = SmsUtil.updateMobileVerifyCode(mobile);

        redisService.set(smsKey, code, RedisSmsKey.OUT_TIME);
        return ResultFactory.success();
    }

    /**
     * 修改用户手机号
     *
     * @param commonUserInfoDo 登陆的当前用户信息
     * @param phoneNum         需要修改的手机号
     * @return
     */
    @ApiOperation(value = "修改用户手机号", notes = "用户修改手机号,如果之前没有添加手机号,就先增加手机号就完成了常态任务绑定手机号")
    @AuthPassport
    @GetMapping("/updateUserPhoneNum")
    public Result<Object> updateUserPhoneNumPerson(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                                   @RequestParam @ApiParam(value = "需要修改的手机号") String phoneNum,
                                                   @RequestParam @ApiParam(value = "获取的验证码") String verifyCode) {
        //获取key
        String smsKey = RedisSmsKey.getSmsCodeKey(phoneNum);
        //检查
        String redisCode = redisService.get(smsKey);

        if (StringUtils.isBlank(redisCode) || !verifyCode.equals(redisCode)) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_USER_PHONE_NUM_NOT.getCode());
        }
        if (redisCode.equals(verifyCode)) {
            redisService.del(smsKey);
        }
        return userStatisticsService.updateUserPhoneNum(commonUserInfoDo, phoneNum);
    }

    /**
     * 修改用户个人主页 背景图片
     *
     * @param commonUserInfoDo 登陆的当前用户信息
     * @param userImgUrl       要修改的背景图片
     * @return
     */
    @ApiOperation(value = "修改用户个人主页 背景图片", notes = "在我的日常中显示的图片,图片是直接选择进行更改")
    @AuthPassport
    @GetMapping("/updateUserHomepageImg")
    public Result<Object> updateUserHomepageImg(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo, @RequestParam @ApiParam(value = "要修改的背景图片") String userImgUrl) {
        //校验url是否合法
        if (!RegExUtil.isImgUrl(userImgUrl)) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_PIC_DATA_EXCEPTION.getCode());
        }

        return userStatisticsService.updateUserHomepageImg(commonUserInfoDo, userImgUrl);

    }

    /**
     * 根据快乐号查询用户昵称和头像
     *
     * @param commonUserInfoDo 登陆的当前用户信息
     * @param userId           查询的快乐号
     * @return
     */
    @ApiOperation(value = "根据快乐号查询用户信息", notes = "必须登陆才可以使用")
    @AuthPassport
    @GetMapping("/findIdGetUser")
    public Result<Object> findIdGetUser(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                        @ApiParam(value = "快乐号") @RequestParam Long userId) {

        return userStatisticsService.findIdGetUser(commonUserInfoDo, userId);

    }


}
