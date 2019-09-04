package com.hndl.cn.mghd.sys.business.message.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.message.vo.VoteMessageVo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description 弹幕消息service
 * @Date 2019/5/15 14:14
 * @Created by 湖南达联
 */
public interface MessageService {


    /**
     * 获取弹幕消息
     * @return
     */
    Result<Object> findBarrageMsg(Long createTime);


    /**
     * 获取弹幕消息
     * @param createTime
     * @return
     */
    List<VoteMessageVo> findByCreateTime(Long createTime);


    /**
     * 添加快乐币打榜弹幕
     * @param userNickName
     * @param starName
     * @param coinNum
     */
     void addCoinVoteMsg(Long starId,String userNickName,String starName,Long coinNum);


    /**
     * 添加积分打榜弹幕
     * @param userNickName
     * @param starName
     * @param integralNum
     */
     void addIntegralVoteMsg(Long starId,String userNickName,String starName,Long integralNum);


    /**
     * 添加爱心打榜弹幕
     * @param userNickName
     * @param starName
     * @param loveNum
     */
     void addLoveVoteMsg(Long starId,String userNickName,String starName,Long loveNum);


    /**
     * 添加积分打榜大波粉弹幕
     * @param starId
     * @param starName
     * @param integralNum
     */

    void addIntegralPopulationMsg(Long starId,String starName,Long integralNum);


    /**
     * 添加快乐币打榜大波粉弹幕
     * @param starId
     * @param starName
     * @param coinNum
     */
    void addCoinPopulationMsg(Long starId,String starName,Long coinNum);


    /**
     * 添加召唤打榜大波粉弹幕
     * @param starId
     * @param starName
     * @param shareNum
     */
    void addSharePopulationMsg(Long starId,String starName,Long shareNum);

    /**
     * 添加打CALL打榜大波粉弹幕
     * @param starId
     * @param starName
     * @param callNum
     */
    void addCallPopulationMsg(Long starId,String starName,Long callNum);

    /**
     * 添加爱豆公益队伍前十次捐赠弹幕
     * @param teamId
     * @param starName
     */
   void addLoveGameTeamMsg(Long starId,Long teamId,String starName);



}
