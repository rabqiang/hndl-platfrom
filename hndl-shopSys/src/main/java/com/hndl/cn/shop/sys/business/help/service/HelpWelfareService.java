package com.hndl.cn.shop.sys.business.help.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

import javax.validation.constraints.NotNull;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/8/4 16 58
 * @Description:
 * @Author: 资龙茂
 */
public interface HelpWelfareService {

    /**
     * 邀请好友助力
     * @param commonUserInfoDo 当前登录用户
     * @param prizeId 奖品ID
     * @return
     */
    Result<Object> askForHelp(@NotNull CommonUserInfoDo commonUserInfoDo, @NotNull String prizeId, @NotNull String formId, @NotNull String openId);

    /**
     * 帮助好友助力
     * @param commonUserInfoDo 当前登录用户
     * @param userWelfareId 抢福利操作ID
     * @return
     */
    Result<Object> helpFriend(@NotNull CommonUserInfoDo commonUserInfoDo, @NotNull String userWelfareId);

    /**
     * 查询帮助自己助力过的好友列表
     * @param commonUserInfoDo
     * @param userWelfareId
     * @return
     */
    Result<Object> findHelpMeFriend(CommonUserInfoDo commonUserInfoDo, String userWelfareId);

}
