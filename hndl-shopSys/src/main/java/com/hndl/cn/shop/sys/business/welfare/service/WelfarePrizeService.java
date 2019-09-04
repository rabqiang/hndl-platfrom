package com.hndl.cn.shop.sys.business.welfare.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

import javax.validation.constraints.NotNull;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/8/1 10 54
 * @Description:
 * @Author: 资龙茂
 */
public interface WelfarePrizeService {

    /**
     * 查询福利商品列表(第一页)
     * @return
     */
    Result<Object> findWelfarePrizeInfo();

    /**
     * 分页查询福利商品列表
     * @param id 根据此ID来分页, 每页十条
     * @return
     */
    Result<Object> findWelfarePrizeInfoByPage(@NotNull String id);

    /**
     * (自己看自己)根据期号查询单个福利商品和自己的参与信息
     * @param commonUserInfoDo
     * @param welfareNumber
     * @return
     */
    Result<Object> findMyWelfarePrizeSingle(CommonUserInfoDo commonUserInfoDo, @NotNull String welfareNumber);

    /**
     * (自己看别人)根据期号查询单个福利商品和自己的参与信息
     * 因为这个函数涉及到的业务逻辑过于复杂,所以写了很多条件判断,希望维护者不要骂我
     * @param commonUserInfoDo
     * @param userWelfareId
     * @return
     */
    Result<Object> findFriendWelfarePrizeSingle(CommonUserInfoDo commonUserInfoDo, @NotNull String userWelfareId);

    /**
     * 查询已开奖时长不超过三天的奖品列表
     * @return
     */
    Result<Object> findSuccessPrizeInfo();

    /**
     * 分页查询自己的中奖记录列表
     * @param id
     * @return
     */
    Result<Object> findMyPrizeInfo(@NotNull CommonUserInfoDo commonUserInfoDo, String id);

    /**
     * 根据期号按照最后修改时间倒序查询参与抢福利的十个用户
     * @param welfareNumber
     * @return
     */
    Result<Object> findIsJoinUserInfo(String welfareNumber);

    /**
     * 根据期号查询中奖用户列表
     * @param welfareNumber
     * @return
     */
    Result<Object> findLuckyUserInfo(String welfareNumber);

    /**
     * 中奖用户提交收货地址
     * @param commonUserInfoDo 登录用户对象
     * @param welfareNumber 期号
     * @param phoneNumber 收货手机号
     * @param receivingName 收货人姓名
     * @param receivingAddress 收货地址
     * @return
     */
    Result<Object> submitAddress(@NotNull CommonUserInfoDo commonUserInfoDo,
                                 @NotNull String welfareNumber,
                                 @NotNull String phoneNumber,
                                 @NotNull String receivingName,
                                 @NotNull String receivingAddress, String reason);
}
