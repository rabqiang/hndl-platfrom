package com.hndl.cn.mghd.sys.business.task.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.redis.sms.RedisSmsKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.task.service.UserNormalityTaskService;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.reg.RegExUtil;
import com.hndl.cn.utils.sms.SmsUtil;
import com.hndl.cn.utils.string.StringUtils;
import com.hndl.cn.utils.text.InvitationUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @author 曹加丽
 * @Description 用户常态任务(未写关注公众号任务)
 * @Date 2019/5/6 13:48
 * @Created by 湖南达联
 */
@RestController
@RequestMapping(path = "/{source}/normalityTask")
@Api(value = "/{source}/normalityTask",tags = "师徒系统(拜师,查询用户徒弟列表)相关接口 ")
public class UserNormalityTaskController {

    @Resource
    private UserNormalityTaskService userNormalityTaskService;

    @Resource
    private RedisService redisService;

    /**
     * 用户拜师
     *
     * @param commonUserInfoDo 用户信息
     * @param lastUserId       师父id
     */
    @ApiOperation(value = "拜师", notes = "拜师只能一次,不能多个师父")
    @AuthPassport
    @GetMapping(path = "/userTaskGetMaster")
    public Result<Object> userNormalityGetMaster(@PathVariable @ApiParam(value = "当前页") String source,
                                                 @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                                 @RequestParam @ApiParam(value = "师父邀请码")  String lastUserId) {
        long toId = InvitationUtils.codeToId(lastUserId);
        //用户拜师
        return userNormalityTaskService.insertUserNormalityTaskAddMaster(commonUserInfoDo, toId);
    }



    /**
     * 查询徒弟列表
     */
    @ApiOperation(value = "查询徒弟列表", notes = "查询师徒系统有关信息")
    @AuthPassport
    @GetMapping(path = "/findUserGetMasterAndApprentice")
    public Result<Object> findUserGetMasterAndApprentice(@PathVariable @ApiParam(value = "来源") String source,
                                                         @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                                         @RequestParam @ApiParam(value = "当前页") Integer pageNo) {

        return userNormalityTaskService.findMasterApprentice(commonUserInfoDo, pageNo);

    }



}
