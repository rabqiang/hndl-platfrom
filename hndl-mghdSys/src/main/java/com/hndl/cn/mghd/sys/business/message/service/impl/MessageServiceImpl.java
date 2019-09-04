package com.hndl.cn.mghd.sys.business.message.service.impl;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.game.mapper.GameStarRecordDoMapper;
import com.hndl.cn.dao.star.mapper.StarCommentRecordDoMapper;
import com.hndl.cn.dao.star.mapper.StarHeartRecordDoMapper;
import com.hndl.cn.dao.star.mapper.StarShareRecordDoMapper;
import com.hndl.cn.dao.welfare.mapper.WelfareDonateRecordDoMapper;
import com.hndl.cn.mghd.sys.business.message.service.MessageService;
import com.hndl.cn.mghd.sys.business.message.vo.VoteMessageVo;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.mongodb.manager.message.bean.VoteMessageDo;
import com.hndl.cn.mongodb.manager.message.manager.VoteMessageManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.DateUtil;
import com.hndl.cn.utils.number.CoinUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.MessageFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/15 14:24
 * @Created by 湖南达联
 */
@Service
public class MessageServiceImpl implements MessageService {

    private static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Resource
    private VoteMessageManager voteMessageManager;

    @Resource
    private GameStarRecordDoMapper gameStarRecordDoMapper;

    @Resource
    private StarHeartRecordDoMapper starHeartRecordDoMapper;

    @Resource
    private StarShareRecordDoMapper starShareRecordDoMapper;

    @Resource
    private StarCommentRecordDoMapper starCommentRecordDoMapper;

    @Resource
    private WelfareDonateRecordDoMapper welfareDonateRecordDoMapper;

    @Resource
    private RedisService redisService;


    @Override
    public Result<Object> findBarrageMsg(Long createTime) {
            return ResultFactory.success(this.findByCreateTime(createTime));
    }

    @Override
    public List<VoteMessageVo> findByCreateTime(Long createTime) {

        //设置key
        String key = MgHdRedisKeyEnums.VOTE_MESSAGE_CACHE_KEY.getCacheKey(createTime);
        List<VoteMessageDo> voteMessageDoList=redisService.get(key);
        if (CollectionUtils.isEmpty(voteMessageDoList)){
            voteMessageDoList= voteMessageManager.findByCreateTime(createTime);
            redisService.set(key, voteMessageDoList, MgHdRedisKeyEnums.VOTE_MESSAGE_CACHE_KEY.getExpireTime());
        }

        return CollectionUtils.isEmpty(voteMessageDoList) ? new ArrayList<>() :
                SpringCglibBeanUtils.convertByList(voteMessageDoList, VoteMessageVo.class);
    }

    @Override
    public void addCoinVoteMsg(Long starId, String userNickName, String starName, Long coinNum) {
        voteMessageManager.insertVoteMessageDo(starId, MessageFormatUtils.getCoinVoteMsg(userNickName, starName, CoinUtils.centToOval(coinNum)));
    }

    @Override
    public void addIntegralVoteMsg(Long starId, String userNickName, String starName, Long integralNum) {
        //如果大于100 才发弹幕
        if (integralNum > MghdSysConstants.INTEGRAL_VOTE_THRESHOLD) {
            voteMessageManager.insertVoteMessageDo(starId, MessageFormatUtils.getIntegralVoteMsg(userNickName, starName, integralNum));
        }
    }

    @Override
    public void addLoveVoteMsg(Long starId, String userNickName, String starName, Long loveNum) {
        voteMessageManager.insertVoteMessageDo(starId, MessageFormatUtils.getLoveVoteMsg(userNickName, starName, CoinUtils.centToOval(loveNum)));
    }


    @Override
    public void addIntegralPopulationMsg(Long starId, String starName, Long integralNum) {
        //打榜的人数*3
        int voteCount = gameStarRecordDoMapper.selectIsBarrageCount(starId) * MghdSysConstants.POPULATION_THREE_NUM;
        //如果打榜次数是人数3倍数（或更多）
        if (voteCount <= integralNum) {
            voteMessageManager.insertVoteMessageDo(starId, MessageFormatUtils.getIntegralPopulationVoteMsg(starName));
            //修改该明星查出来的未弹幕的记录
            gameStarRecordDoMapper.updateIsBarrage(starId);
        }
    }

    @Override
    public void addCoinPopulationMsg(Long starId, String starName, Long coinNum) {
        //快乐币的人数*3
        int coinCount = starHeartRecordDoMapper.selectIsBarrageCount(starId) * MghdSysConstants.POPULATION_THREE_NUM;
        if (coinCount <= coinNum) {
            voteMessageManager.insertVoteMessageDo(starId, MessageFormatUtils.getCoinPopulationVoteMsg(starName));
            //修改该明星查出来的未弹幕的记录
            starHeartRecordDoMapper.updateIsBarrage(starId);
        }
    }

    @Override
    public void addSharePopulationMsg(Long starId, String starName, Long shareNum) {
        //召唤的人数*3
        int shareCount = starShareRecordDoMapper.selectIsBarrageCount(starId) * MghdSysConstants.POPULATION_THREE_NUM;
        if (shareCount <= shareNum) {
            voteMessageManager.insertVoteMessageDo(starId, MessageFormatUtils.getSharePopulationVoteMsg(starName));
            //修改该明星查出来的未弹幕的记录
            starShareRecordDoMapper.updateIsBarrage(starId);
        }
    }

    @Override
    public void addCallPopulationMsg(Long starId, String starName, Long callNum) {
        //打CALL人数*3
        int callCount = starCommentRecordDoMapper.selectIsBarrageCount(starId) * MghdSysConstants.POPULATION_THREE_NUM;
        if (callCount <= callNum) {
            voteMessageManager.insertVoteMessageDo(starId, MessageFormatUtils.getCallPopulationVoteMsg(starName));
            //修改该明星查出来的未弹幕的记录
            starCommentRecordDoMapper.updateIsBarrage(starId);

        }
    }

    @Override
    public void     addLoveGameTeamMsg(Long starId, Long teamId, String starName) {
        //获取每天公益队伍捐献次数
        int teamNum = welfareDonateRecordDoMapper.countTodayTeamDonateSize(teamId, DateUtil.getformatToStringDateEn(new Date()));
        if (teamNum < MghdSysConstants.LOVE_GAME_TEAM_NUM) {
            voteMessageManager.insertVoteMessageDo(starId, MessageFormatUtils.getLoveGameTeamVoteMsg(starName));
        }
    }


}
