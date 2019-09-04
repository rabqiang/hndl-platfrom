package com.hndl.cn.mghd.sys.business.task.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.enums.user.UserNormalityTaskEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.task.service.UserDayTaskService;
import com.hndl.cn.mghd.sys.business.task.service.UserNormalityTaskService;
import com.hndl.cn.mghd.sys.business.task.vo.UserTaskVo;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.collection.MapUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: hndl-platform
 * @description: 用户任务查询/领取
 * @author: 易成贤
 * @create: 2019-05-08 10:48 @Created by 湖南达联
 */
@Api(tags = "用户任务")
@RestController
@RequestMapping(path = "/{source}/user/userTask")
public class UserTaskController {

    @Resource
    UserDayTaskService userDayTaskService;

    @Resource
    UserNormalityTaskService userNormalityTaskService;

    /**
     * app排序
     * @return
     */
    private static List<Integer> appSort(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(UserNormalityTaskEnums.BIND_PHONE.getTaskType());
        list.add(UserDayTaskEnums.GUARD_TASK.getTaskType());
        list.add(UserDayTaskEnums.GIVE_HEART_TASK.getTaskType());
        list.add(UserDayTaskEnums.INTEGRAL_TASK.getTaskType());
        list.add(UserDayTaskEnums.SUMMON_TASK.getTaskType());
        list.add(UserDayTaskEnums.CALL_TASK.getTaskType());
        list.add(UserDayTaskEnums.COMMENT_TASK.getTaskType());
        list.add(UserDayTaskEnums.LIKE_TASK.getTaskType());
        list.add(UserDayTaskEnums.LOGIN_TASK.getTaskType());
        list.add(UserNormalityTaskEnums.OBEY_MASTER.getTaskType());
        list.add(UserNormalityTaskEnums.OBEY_SLAVE.getTaskType());
        return list;
    }


    /**
     * 查询app任务列表
     *
     * @param //commonUserInfoDo
     * @return
     */
    @GetMapping(path = "/findAppUserTask")
    @AuthPassport
    @ApiOperation(value = "查询任务列表", notes = "用户必须登陆")
    public Result<List<UserTaskVo>> findAppUserTask(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo) {

        // 日常用户
        Map<Integer,UserTaskVo> dayTask = userDayTaskService.findAppUserDayTask(commonUserInfoDo);
        // 常态任务
       Map<Integer,UserTaskVo> normalityTask = userNormalityTaskService.findAppUserNormalityTask(commonUserInfoDo.getSysUniId());

        // 数据具有空值
        if (MapUtils.isEmpty(dayTask) || MapUtils.isEmpty(normalityTask)) {
            throw new MghdSysException(PublicExceptionCodeEnum.EX_SELECT_ERROR.getCode());
        }
        dayTask.putAll(normalityTask);

        List<UserTaskVo> list = new ArrayList<>();
        appSort().forEach(
                v -> {
                    UserTaskVo e = dayTask.get(v);
                    if(null != e){
                        list.add(e);
                    }
                }
        );
        return ResultFactory.success(list);
    }

    /**
     * 查询wecaht任务列表
     *
     *
     * @param commonUserInfoDo
     * @return
     */
    @GetMapping(path = "/findWeChatUserTask")
    @AuthPassport
    @ApiOperation(value = "查询wechat任务列表", notes = "用户必须登陆")
    public Result<List<UserTaskVo>> findWeChatUserTask(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo) {

        // 日常用户
        List<UserTaskVo> dayTask = userDayTaskService.findWeChatUserDayTask(commonUserInfoDo);

        List<UserTaskVo> normalityTask = userNormalityTaskService.findWeChatUserNormalityTask(commonUserInfoDo.getSysUniId());

        // 数据具有空值
        if (CollectionUtils.isEmpty(dayTask) || CollectionUtils.isEmpty(normalityTask)) {
            throw new MghdSysException(PublicExceptionCodeEnum.EX_SELECT_ERROR.getCode());
        } else {
            // 合并数据
            dayTask.addAll(normalityTask);
            return ResultFactory.success(dayTask);
        }
    }

    /**
     * 领取app奖励积分
     *
     * @param commonUserInfoDo
     * @param
     * @param type
     * @return
     */
    @GetMapping(path = "/getAppIntegral")
    @AuthPassport
    @ApiOperation(value = "app任务领取", notes = "用户必须登陆")
    public Result<UserTaskVo> getAppIntegral(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo, @ApiParam(value = "任务类型", required = true) @RequestParam Integer type) {
        // 如果是app日常任务
        if (UserDayTaskEnums.isApp(type)) {
            return userDayTaskService.getIntegralCount(
                    commonUserInfoDo.getSysUniId(), UserDayTaskEnums.getApp().get(type));
        } else if (UserNormalityTaskEnums.isApp(type)) { // 如果是app常态任务
            return userNormalityTaskService.insertTaskAddIntegralCount(
                    commonUserInfoDo.getSysUniId(), UserNormalityTaskEnums.getApp().get(type));
        } else {
            // 如果都不是,参数错误
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
    }

    /**
     * 领取wechat积分奖励
     *
     * @param commonUserInfoDo
     * @param
     * @param type
     * @return
     */
    @GetMapping(path = "/getWechatIntegral")
    @AuthPassport
    @ApiOperation(value = "wechat任务领取", notes = "用户必须登陆")
    public Result<UserTaskVo> getWechatIntegral(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo, @ApiParam(value = "任务类型") @RequestParam Integer type) {
        // 是小程序日常任务
        if (UserDayTaskEnums.isWeChat(type)) {
            return userDayTaskService.getIntegralCount(
                    commonUserInfoDo.getSysUniId(), UserDayTaskEnums.getWeChat().get(type));
        } else if (UserNormalityTaskEnums.isWeChat(type)) { // 如果是app常态任务
            return userNormalityTaskService.insertTaskAddIntegralCount(
                    commonUserInfoDo.getSysUniId(), UserNormalityTaskEnums.getWeChat().get(type));
        } else if (null != UserNormalityTaskEnums.getGeneralize().get(type)) {
            return userNormalityTaskService.insertTaskAddIntegralCount(
                    commonUserInfoDo.getSysUniId(), UserNormalityTaskEnums.getGeneralize().get(type));
        } else {
            // 如果都不是,参数错误
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
    }

    @ApiOperation("查询推广任务")
    @AuthPassport
    @GetMapping("/findGeneralizeTask")
    public Result<Object> findGeneralizeTask(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo) {
        //return userNormalityTaskService.findGeneralizeTask(commonUserInfoDo);
        return ResultFactory.success();
    }

    @ApiModelProperty("推广任务回调接口")
    @AuthPassport
    @GetMapping("/reportGeneralizeTask")
    public Result<Object> reportGeneralizeTask(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo, Integer taskType) {
        //return userNormalityTaskService.reportGeneralizeTask(commonUserInfoDo,taskType);
        return ResultFactory.success();
    }
}
