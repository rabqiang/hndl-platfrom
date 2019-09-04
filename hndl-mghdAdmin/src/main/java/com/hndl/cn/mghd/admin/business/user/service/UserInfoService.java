package com.hndl.cn.mghd.admin.business.user.service;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

import java.text.ParseException;

/**
 * @author 曹加丽
 * @Description 后台用户管理
 * @Date 2019/6/19 16:53
 * @Created by 湖南达联
 */
public interface UserInfoService {

    /**
     * 查询所有用户(包括模糊查)
     *
     * @param commonUserInfoDo 查询的条件
     * @param pageNo           分页
     * @return
     */
    Result<Object> findUserInByLimit(CommonUserInfoDo commonUserInfoDo, Integer pageNo);

    /**
     * 加减积分
     *
     * @param userUniId    用户id`
     * @param isValidEnums 是否减少
     * @param integral     积分值
     * @return
     */
    Result<Object> updateUserIntegral(Long userUniId, IsValidEnums isValidEnums, Long integral,String integralText);

    /**
     * 加减快乐币
     * @param userUniId    用户id
     * @param isValidEnums 是否减少
     * @param coniCount    快乐币值
     * @return
     */
    Result<Object> updateUserConiCount(Long userUniId, IsValidEnums isValidEnums, Long coniCount);

    /**
     * 批量增加
     * @param userUniId  增加用户id
     * @param integral   积分数
     * @return
     */
    Result<Object> addUserAllGetIntegral(Object[] userUniId,  Long integral);

    /**
     * 封号
     * @param userUniId
     * @return
     */
    Result<Object> userInfoSealNumber(Long userUniId,IsValidEnums isValidEnums);
}
