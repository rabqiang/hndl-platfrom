package com.hndl.cn.shop.admin.business.turntable.service;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.shop.admin.business.turntable.vo.TurntableInfoVo;

/**
 * @author 曹加丽
 * @Description 后台 幸运大转盘管理
 * @Date 2019/7/5 19:51
 * @Created by 湖南达联
 */
public interface LuckyTurntableService {

    /**
     * 增加转盘奖品
     *
     * @param turntableInfoVo 增加奖品的vo类
     * @param userUniId       操作人的id
     * @return
     */
    Result<Object> addLuckyTurntable(TurntableInfoVo turntableInfoVo, Long userUniId);

    /**
     * 修改转盘奖品
     *
     * @param turntableInfoVo 修改奖品的vo类
     * @param userUniId       操作修改的id
     * @return
     */
    Result<Object> updateLuckyTurntable(TurntableInfoVo turntableInfoVo, Long userUniId);

    /**
     * 删除(下架)转盘奖品
     *
     * @param prizeId      奖品id
     * @param isValidEnums 判断是否是删除
     * @param userUniId    操作人id
     * @return
     */
    Result<Object> deleteLuckyTurntable(Long prizeId, IsValidEnums isValidEnums, Long userUniId);

    /**
     * 是否可以抽取实物(签名照,音乐专辑,门票)
     *
     * @param isValidEnums 是否可以开启(1.是0.否)
     * @return
     */
    Result<Object> luckyTurntableIsMaterialOpes(IsValidEnums isValidEnums);

    /**
     * 查询奖品信息
     *
     * @param prizeId 奖品id
     * @return
     */
    Result<Object> findPrizeLuckyById(Long prizeId);

    /**
     * 查询奖品信息
     */
    Result<Object> findPrizeLuckyTurntable(Integer pagerNo,Integer pagerSize);


    /**
     * 根据用户id和时间进行查询用户中奖信息
     *
     * @param userUniId 查询用户id
     * @param statTime  开始时间
     * @param endTime   结束时间
     * @param id        分页的条件
     * @return
     */
    Result<Object> findUserWinningThPrize(Long userUniId, Long statTime, Long endTime, String id,Integer pagerSize);
}
