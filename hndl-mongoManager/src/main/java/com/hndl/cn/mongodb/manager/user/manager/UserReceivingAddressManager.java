package com.hndl.cn.mongodb.manager.user.manager;

import com.hndl.cn.mongodb.manager.user.bean.UserReceivingAddressDo;

import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO 福利收获地址
 * @Date 2019/7/24 16:07
 * @Created by 湖南达联
 */
public interface UserReceivingAddressManager {

    /**
     * 增加和修改用户福利收货地址
     * 条件: 用户id和收获名称
     * @param userReceiving  用户收货信息
     */
    void  setUserReceiving(UserReceivingAddressDo userReceiving);

    /**
     * 查询用户填写的收货地址
     * @param userUniId      用户id
     * @param welfareNumber  期号
     * @return
     */
    UserReceivingAddressDo findAddressByWelfareNumber(Long userUniId, String welfareNumber);

    /**
     * 根据用户ID按时间倒序查询自己的中奖记录
     * @param userUniId
     * @param id
     * @return
     */
    List<UserReceivingAddressDo> findPrizeInfoByUserId(Long userUniId, String id);

    /**
     *  根据奖品期号获取中奖收货记录
     * @param id            _id
     * @param welfareNumber 中奖期号
     * @param limit         每页分几条
     * @return
     */
    List<UserReceivingAddressDo>  findUserAddress(String  id,String welfareNumber, Integer isDelivery,Integer limit);

    /**
     * 修改收货地址
     * @param userReceivingAddressDo
     */
    void submitAddress(UserReceivingAddressDo userReceivingAddressDo);

    /**
     * 统计中奖用户总人数
     * @return
     */
    Long countLuckyUser();
}
