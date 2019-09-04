package com.hndl.cn.mghd.sys.business.vote.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

import java.util.Map;

/**
 * @author 赵俊凯
 * @Description 明星投票（打榜）service
 * @Date 2019/5/8 11:36
 * @Created by 湖南达联
 */
public interface StarVoteService {


    /**
     * 积分投票
     * @param userInfoDo
     * @param starId
     * @param integralNum
     * @return
     */
    Result<Object> integralVote(CommonUserInfoDo userInfoDo,Long starId,Long integralNum,boolean isNewData);


    /**
     *  充值投票（比心）
     * @param userInfoDo
     * @param starId
     * @param coinNum
     * @return
     */
    Result<Object> coinVote(CommonUserInfoDo userInfoDo,Long starId,Long coinNum,boolean isNewData);


    /**
     * 公益投票（捐爱心）
     * @param userInfoDo
     * @param starId
     * @param loveNum
     * @return
     */
    Result<Object> loveVote(CommonUserInfoDo userInfoDo,Long starId,Long loveNum);

    /**
     * 查询打榜信息
     * @param userInfoDo
     * @param type
     * @return
     */
    Result<Map<String, Object>> findVoteInformation(CommonUserInfoDo userInfoDo, Integer type);
}
