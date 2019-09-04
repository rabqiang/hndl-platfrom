package com.hndl.cn.mghd.sys.business.vote.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.pay.PayChannelEnums;
import com.hndl.cn.base.enums.pay.PayReasonType;
import com.hndl.cn.base.enums.user.FoucaultGetTypeEnums;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.enums.vote.VoteContentEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.base.redis.user.UserInfoKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.message.service.MessageService;
import com.hndl.cn.mghd.sys.business.rank.service.StarRankVoteService;
import com.hndl.cn.mghd.sys.business.star.service.StarFansStatisticsService;
import com.hndl.cn.mghd.sys.business.task.service.UserDayTaskService;
import com.hndl.cn.mghd.sys.business.vote.service.StarVoteService;
import com.hndl.cn.mghd.sys.business.vote.vo.CoinDataVo;
import com.hndl.cn.mghd.sys.business.vote.vo.IntegralDataVo;
import com.hndl.cn.mghd.sys.business.vote.vo.VoteContentVo;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.luckdraw.manager.FoucaultLogManager;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupRelationDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansDayStatisticsManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupRelationManager;
import com.hndl.cn.mongodb.manager.user.bean.UserIntegralLogDo;
import com.hndl.cn.mongodb.manager.user.bean.UserStatisticsDo;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.mysql.manager.coin.manager.HappyCoinBillInfoManger;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import com.hndl.cn.utils.number.CoinUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.hndl.cn.base.enums.user.UserDayTaskEnums.INTEGRAL_TASK;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/8 20:02
 * @Created by 湖南达联
 */
@Service
public class StarVoteServiceImpl implements StarVoteService {

    private static final Logger log = LoggerFactory.getLogger(StarVoteServiceImpl.class);

    private static final Long DATA_ID = 4L;

    @Resource
    private StarFansGroupManager starFansGroupManager;

    @Resource
    private StarFansGroupRelationManager starFansGroupRelationManager;

    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;

    @Resource
    private StarFansStatisticsService starFansStatisticsService;

    @Resource
    private UserIntegralLogManager userIntegralLogManager;

    @Resource
    private StarRankVoteService starRankVoteService;

    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    @Resource
    private HappyCoinBillInfoManger happyCoinBillInfoManger;

    @Resource
    private UserDayTaskService userDayTaskService;

    @Resource
    private MessageService messageService;



    @Resource
    private FoucaultLogManager foucaultLogManager;

    private ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;

    @Resource
    private RedisService redisService;

    @Resource
    private StarFansDayStatisticsManager starFansDayStatisticsManager;

    @Override
    @SubmitLock(keys = ("userInfoDo#sysUniId"),sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public Result<Object> integralVote(CommonUserInfoDo userInfoDo, Long starId, Long integralNum,boolean isNewData) {
            // 0 校验粉丝会是否存在
            StarFansGroupDo starFansGroup = starFansGroupManager.findStarFansGroup(starId);

            if(starFansGroup == null){
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
            }

            //1 校验用户是否加入粉丝会
            StarFansGroupRelationDo starFansGroupRelation = starFansGroupRelationManager.findStarFansGroupRelation(userInfoDo.getSysUniId(), starId);

            if(starFansGroupRelation == null || IsValidEnums.YES.getValue().equals(starFansGroupRelation.getIsDelete())){
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANSGOUP_NOT_FIND_EXCEPTION.getCode());
            }

            //2 校验用户积分
            UserStatisticsDo userStatisticsByUserUinId = userStatisticsDoManager.findAndAddIntegralCount(userInfoDo.getSysUniId(),integralNum, IsValidEnums.YES);

            if(userStatisticsByUserUinId == null){
                log.info("=========用户积分余额不足{ userUniId : "+userInfoDo.getSysUniId() + "===========");
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_INTEGRAL_NOT_ENOUGH.getCode());
            }

            Long oldIntegralCount = userStatisticsByUserUinId.getIntegralCount();

            //如果没有投过投票,+投票总用户数
            if (!starFansDayStatisticsManager.findVote(starId,userInfoDo.getSysUniId())) {
                starFansGroupManager.incVoteUserCount(starId);
            }

            //4 生成积分记录
            userIntegralLogManager.insertUserIntegralLog(userInfoDo.getSysUniId(),starId.toString(),IsValidEnums.NO,
                    INTEGRAL_TASK.getTaskType(),integralNum.intValue());

            //5 加任务记录
            userDayTaskService.insetTask(userInfoDo.getSysUniId(),starId, INTEGRAL_TASK);


            //6 添加用户统计记录 包括 日 周 月 全部
            starRankVoteService.asyncIncreaseAllVote(VoteTypeEnums.INTEGRAL_VOTE,userInfoDo.getSysUniId(),starId,integralNum);


            //7 添加明星榜信息 日 周 月 全部
            starFansStatisticsService.addVoteStatistics(userInfoDo,starFansGroup,VoteTypeEnums.INTEGRAL_VOTE,integralNum);

            //8 加用户经验并生成记录
            userStatisticsDoManager.userStatisticsAddEmpirical(userInfoDo.getSysUniId(),integralNum);

//        userEmpiricalLogDoManager.UserEmpiricalLogDoAddEmpiricalCount();
            //9 添加弹幕
            messageService.addIntegralVoteMsg(starFansGroup.getStarId(),userInfoDo.getNickName(),starFansGroup.getStarName(),integralNum);

            //10 计算用户今天打榜的记录800 / 1次
            this.addUserLuckDrawCount(userInfoDo.getSysUniId(),FoucaultGetTypeEnums.INTEGRAL_TASK);
            //11 返回用户扣完的余额

            IntegralDataVo integralDataVo = IntegralDataVo.builder().nowIntegralCount(oldIntegralCount-integralNum).voteCount(integralNum).build();

            if(isNewData){
                return ResultFactory.success(integralDataVo);
            }

            return ResultFactory.success(oldIntegralCount-integralNum);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @SubmitLock(keys = ("userInfoDo#sysUniId"),sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public Result<Object> coinVote(CommonUserInfoDo userInfoDo, Long starId, Long coinNum,boolean isNewData) {
            // 0 校验粉丝会是否存在
            StarFansGroupDo starFansGroup = starFansGroupManager.findStarFansGroup(starId);

            if(starFansGroup == null){
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
            }

            //1 校验用户是否加入粉丝会
            StarFansGroupRelationDo starFansGroupRelation = starFansGroupRelationManager.findStarFansGroupRelation(userInfoDo.getSysUniId(), starId);

            if(starFansGroupRelation == null || IsValidEnums.YES.getValue().equals(starFansGroupRelation.getIsDelete())){
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANSGOUP_NOT_FIND_EXCEPTION.getCode());
            }

            //3 校验用户余额
            Long oldCoinCount = CoinUtils.doubleConvertLong(userInfoDo.getConiCount());

            if(oldCoinCount < coinNum){
                //这里如果失败，返回的是用户的当前余额
                log.info("=========用户快乐币余额不足{ userUniId : "+userInfoDo.getSysUniId()
                        +",oldCoinCount :"+ oldCoinCount+ ",coinNum:"+coinNum+"}===========");

                return ResultFactory.failure(MghdSysExceptionEnums.MGHD_SYS_COIN_NOT_ENOUGH.getCode(),
                        MghdSysExceptionEnums.MGHD_SYS_COIN_NOT_ENOUGH.getMsg(),
                        oldCoinCount);
            }

            boolean flag =  commonUserInfoManager.minusCoinByUserUinId(userInfoDo.getSysUniId(), CoinUtils.longConvertDouble(coinNum));

            if(!flag){
                //这里如果失败，返回的是用户的当前余额
                log.info("=========用户快乐币余额不足{ userUniId : "+userInfoDo.getSysUniId()
                        +",oldCoinCount :"+ oldCoinCount+ ",coinNum:"+coinNum+"}===========");
                return ResultFactory.failure(MghdSysExceptionEnums.MGHD_SYS_COIN_NOT_ENOUGH.getCode(),
                        MghdSysExceptionEnums.MGHD_SYS_COIN_NOT_ENOUGH.getMsg(),
                        oldCoinCount);
            }

            //4 添加用户流水记录
            HappyCoinBillInfoDo happyCoinBillInfoDo = new HappyCoinBillInfoDo();
            happyCoinBillInfoDo.setCreateTime(new Date());
            happyCoinBillInfoDo.setCoinCount(coinNum);
            happyCoinBillInfoDo.setCreateUserId(userInfoDo.getSysUniId());
            happyCoinBillInfoDo.setIsPay(IsValidEnums.YES.getValue());
            happyCoinBillInfoDo.setPayType(PayChannelEnums.HAPPY_SYS_PAY.getChannelType());
            happyCoinBillInfoDo.setOldCoinCount(oldCoinCount);
            Long newCoinCount = CoinUtils.doubleConvertLong(userInfoDo.getConiCount()) - coinNum;
            userInfoDo.setConiCount(CoinUtils.longConvertDouble(newCoinCount));
            happyCoinBillInfoDo.setNewCoinCount(newCoinCount);
            happyCoinBillInfoDo.setReasonType(PayReasonType.HAPPY_COIN_VOTE.getReasonType());
            //这里应该存的是明星id
            happyCoinBillInfoDo.setReasonObjId(String.valueOf(starId));
            happyCoinBillInfoDo.setLocalTradeNo(iSnowflakeIdService.nextOrderId(DATA_ID));
            happyCoinBillInfoDo.setRemoteTradeNo(PayChannelEnums.PAY_DEFAULT_ID);
            happyCoinBillInfoManger.insertSelective(happyCoinBillInfoDo);

            //5 加任务记录
            userDayTaskService.insetTask(userInfoDo.getSysUniId(),starId,UserDayTaskEnums.GIVE_HEART_TASK);

            //如果没有投过投票
            if (!starFansDayStatisticsManager.findVote(starId,userInfoDo.getSysUniId())) {
                //粉丝会投票人数+1
                starFansGroupManager.incVoteUserCount(starId);
            }

            Long voteCount = coinNum * MghdSysConstants.VOTE_MULTIPLE ;

            //6 添加用户统计记录 包括 日 周 月 全部
            starRankVoteService.asyncIncreaseAllVote(VoteTypeEnums.COIN_VOTE,userInfoDo.getSysUniId(),starId,voteCount);
            //7 添加明星榜信息 日 周 月 全部
            starFansStatisticsService.addVoteStatistics(userInfoDo,starFansGroup,VoteTypeEnums.COIN_VOTE,voteCount);

            //8 加用户经验
            userStatisticsDoManager.userStatisticsAddEmpirical(userInfoDo.getSysUniId(),voteCount);
//        userNormalityTaskService.userDayTypeGetEmpirical(userInfoDo.getSysUniId(),UserDayEmpiricalTypeEnums.GIVE_HEART_TASK);
            //9 添加弹幕
            messageService.addCoinVoteMsg(starFansGroup.getStarId(),userInfoDo.getNickName(),starFansGroup.getStarName(),coinNum);

            //9返回当前用户的快乐币余额,更新用户缓存
            this.addUserLuckDrawCount(userInfoDo.getSysUniId(), FoucaultGetTypeEnums.GIVE_HEART_TASK);



            String userKey = UserInfoKey.getUserInfoCacheKey(userInfoDo.getSysUniId());

            redisService.set(userKey,userInfoDo,UserInfoKey.OUT_TIME);

            CoinDataVo coinDataVo = CoinDataVo.builder().nowCoinCount(newCoinCount).voteCount(voteCount).build();

            if(isNewData){
                return  ResultFactory.success(coinDataVo);
            }
            return ResultFactory.success(newCoinCount);
    }

    @Override
    public Result<Object> loveVote(CommonUserInfoDo userInfoDo, Long starId, Long loveNum) {
        return null;
    }

    /**
     * 查询打榜信息
     *
     * @param userInfoDo
     * @param type
     * @return
     */
    @Override
    public Result<Map<String, Object>> findVoteInformation(CommonUserInfoDo userInfoDo, Integer type) {
        Map<String,Object> map = new HashMap(1);
        VoteContentEnums voteContentEnums = VoteContentEnums.evalVal(type);
        if (null == voteContentEnums){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        VoteContentVo voteContentVo = VoteContentVo.builder()
                .type(voteContentEnums.getType())
                .title(voteContentEnums.getTitle())
                .content(voteContentEnums.getContent()).build();
        map.put("voteContentVo",voteContentVo);
        return ResultFactory.success(map);
    }


    private void addUserLuckDrawCount(Long userUniId, FoucaultGetTypeEnums foucaultGetTypeEnums){


        Integer lastCount = 0;

        Integer addCount = 0;

        Integer count = foucaultLogManager.findToDayCount(userUniId,foucaultGetTypeEnums,IsValidEnums.YES);

        switch (foucaultGetTypeEnums){
            case GIVE_HEART_TASK:
                Long coinSum = happyCoinBillInfoManger.countToDayVote(userUniId);
//                log.info("====="+coinSum+"====");
                //获取用户今天快乐币获取的抽奖次数
                lastCount = coinSum.intValue() / MghdSysConstants.COIN_LUCK_DRAW_COUNT;

                addCount = lastCount - count;

                if(addCount > 0){
                    userStatisticsDoManager.userAddFoucaultCount(userUniId,addCount);
                    //记录日志
                    foucaultLogManager.insertFoucaultLogs(userUniId,foucaultGetTypeEnums,IsValidEnums.YES,addCount);
//                    log.info("====="+luckyTurntableTypeEnums.getDescription()+" 用户:"+userUniId+"之前抽奖次数为:"+count+",新添加抽奖次数为:"+addCount+"========");
                }
                break;
            case INTEGRAL_TASK:
                List<UserIntegralLogDo> recordByDate = userIntegralLogManager.
                        findRecordByDate(LocalDateTimeUtil.getNowMinTimeMilli(),LocalDateTimeUtil.getNowMaxTimeMilli(),
                                userUniId,UserDayEmpiricalTypeEnums.INTEGRAL_TASK,IsValidEnums.NO);

                //获取用户今天打榜积分
                int sum = recordByDate.stream().filter(logDo -> logDo.getIsIncome().equals(IsValidEnums.NO.getValue())).mapToInt(logDo -> logDo.getIntegralCount()).sum();

                //获取需要生成的抽奖次数
                lastCount = sum / MghdSysConstants.LUCK_DRAW_COUNT;

                if(lastCount > BaseConstants.INTEGER_VOTE_DAY_FUKA_COUNT){
                    lastCount = BaseConstants.INTEGER_VOTE_DAY_FUKA_COUNT;
                }

                addCount = lastCount - count;
                if(addCount > 0 ){
                    userStatisticsDoManager.userAddFoucaultCount(userUniId,addCount);
                    //记录日志
                    foucaultLogManager.insertFoucaultLogs(userUniId,foucaultGetTypeEnums,IsValidEnums.YES,addCount);
//                    log.info("====="+luckyTurntableTypeEnums.getDescription()+" 用户:"+userUniId+"之前福卡次数为:"+count+",新添加的福卡:"+addCount+",今天共获得福卡:" +lastCount+"========");
                }
                break;
            default:
                break;
        }
    }



}
