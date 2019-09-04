package com.hndl.cn.mongodb.manager.luckdraw.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpWelfareDo;

import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/24 16:25
 * @Created by 湖南达联
 */
public interface HelpWelfareManager {
    /**
     * 增加福利商品
     */
     void insertHelpWelfare(HelpWelfareDo helpWelfareDo);

    /**
     * 修改商品属性
     * @param helpWelfareDo
     */
     void updateHelpWelfare(HelpWelfareDo helpWelfareDo);


    /**
     * 增加当前助力值
     * @param welfareNumber 福利商品期号
     * @param nowSumCount  助力值
     */
    void addHelpUserNowSumCount(String welfareNumber,Integer nowSumCount);


    /**
     * 修改开奖状态
     * @param welfareNumber  福利商品期号
     * @param successUserUniId  中奖人id
     */
    boolean updateHelpUserLottery(String welfareNumber, List<Long> successUserUniId);


    /**
     * 给未达到开奖条件的奖品,状态修改为失效
     * @param welfareNumber  福利商品期货
     */
    boolean updateHelpUserInvalid(String welfareNumber);

    /**
     * 查询福利商品
     * @param id            _id
     * @param prizeName  福利商品名称
     * @param isValidEnums   是否已开奖(0.否| 1.是 |2.开奖失败)
     * @param limit         分页大小
     * @return
     */
    List<HelpWelfareDo>  findHelpUserById(String id,String prizeName ,Integer isValidEnums,Integer limit);

    /**
     * 获取当日上传数量
     */
    Long countAddCommodity();

    /**
     * 根据ID查询福利奖品
     * @param id
     * @return
     */
    HelpWelfareDo findWelfarePrizeById(String id);

    /**
     * 根据预览时间/开奖时间查询福利奖品
     * @param isValidEnums
     * @param showTime
     * @param successTime
     * @return
     */
    List<HelpWelfareDo> findSuccessWelfarePrize(IsValidEnums isValidEnums, Long showTime, Long successTime);

    /**
     * 查询十条正在开抢的福利商品
     * @return
     */
    List<HelpWelfareDo> findIsValidWelfarePrize(String id);

    /**
     * 根据期号查询福利奖品
     * @param welfareNumber
     * @return
     */
    HelpWelfareDo findWelfarePrizeByWelfareNumber(String welfareNumber);

    /**
     * 查询满足开奖添加的福利商品信息
     * @return
     */
     List<HelpWelfareDo> findSuccessAll(Long endTime);
}
