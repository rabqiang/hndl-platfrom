package com.hndl.cn.activity.sys.business.library.service.impl;

import com.hndl.cn.activity.sys.business.library.service.HappyLibraryService;
import com.hndl.cn.activity.sys.business.library.vo.HappyLibraryDataVo;
import com.hndl.cn.activity.sys.business.library.vo.HappyLibraryHeadDataVo;
import com.hndl.cn.activity.sys.business.library.vo.HappyLibraryListDataVo;
import com.hndl.cn.activity.sys.constants.ActivitySysConstants;
import com.hndl.cn.activity.sys.exception.ActivitySysException;
import com.hndl.cn.activity.sys.exception.ActivitySysExceptionEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mongodb.manager.activity.bean.HappyLibraryShareVoteDo;
import com.hndl.cn.mongodb.manager.activity.bean.HappyLibraryUserVoteDo;
import com.hndl.cn.mongodb.manager.activity.manager.HappyLibraryShareVoteManager;
import com.hndl.cn.mongodb.manager.activity.manager.HappyLibraryUserVoteManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/31 17:06
 * @Created by 湖南达联
 */
@Service
public class HappyLibraryServiceImpl implements HappyLibraryService {


    private static final Logger log = LoggerFactory.getLogger(HappyLibraryServiceImpl.class);

    @Resource
    private HappyLibraryShareVoteManager happyLibraryShareVoteManager;

    @Resource
    private HappyLibraryUserVoteManager happyLibraryUserVoteManager;


    @Resource
    private RedisService redisService;


    @Override
    public Result<Object> findHappyLibraryByVersion(Long userId) {
        HappyLibraryDataVo vo = redisService.get(ActivitySysConstants.HAPPY_LIBRARY_REDIS_KEY);
        HappyLibraryHeadDataVo happyLibraryHeadDataVo = vo.getHappyLibraryHeadDataVo();
        happyLibraryHeadDataVo.setNowVoteCount(0L);
        //用户登陆要
        if(userId != null){
            Long count = happyLibraryUserVoteManager.countHappyLibraryUserVoteByNowTime(userId);
            happyLibraryHeadDataVo.setNowVoteCount(count);
        }
        if(happyLibraryHeadDataVo.getEndTime() > System.currentTimeMillis()){
            happyLibraryHeadDataVo.setGroupName("未结束");
        }
        vo.setHappyLibraryHeadDataVo(happyLibraryHeadDataVo);
        return ResultFactory.success(vo);
    }

    @Override
    public Result<Object> increaseVoteCount(Integer version,Long groupId,Long userId,Long voteCount) {
        //先校验活动是否开始
        HappyLibraryShareVoteDo happyLibraryShareVoteDo = happyLibraryShareVoteManager.findHappyLibraryShareVoteByGroupId(groupId);

        Long nowTime = System.currentTimeMillis();

        if(happyLibraryShareVoteDo == null || happyLibraryShareVoteDo.getEndTime() < nowTime || happyLibraryShareVoteDo.getStartTime() > nowTime){
            throw new ActivitySysException(ActivitySysExceptionEnums.ACTIVITY_END_EX.getCode());
        }

        Long nowCount = happyLibraryUserVoteManager.countHappyLibraryUserVoteByNowTime(userId);

        //每天限制次数
        if(ActivitySysConstants.HAPPY_LIBRARY_NOW_COUNT <= nowCount){
            throw new ActivitySysException(ActivitySysExceptionEnums.NOW_HAPPY_LIBRARY_COUNT_EX.getCode());
        }

        //加票
        happyLibraryShareVoteManager.increaseVoteCount(version,groupId,voteCount);


        HappyLibraryUserVoteDo happyLibraryUserVoteDo = HappyLibraryUserVoteDo.builder().groupName(happyLibraryShareVoteDo.getGroupName()).groupId(groupId).
                starName(happyLibraryShareVoteDo.getStarName()).version(version).sysUniId(userId).build();
        //加入用户关系
        happyLibraryUserVoteManager.insertHappyLibraryUserVote(happyLibraryUserVoteDo);

        return ResultFactory.success();
    }

    @Override
    public Result<Object> increaseVoteCountByKey(Integer version, Long groupId, Long voteCount) {
        log.info("======================increaseVoteCountByKey=============================");
        log.info("====================== vote to  " + groupId + " : "+voteCount+ "=============================");
        happyLibraryShareVoteManager.increaseVoteCount(version,groupId,voteCount);
        return ResultFactory.success();
    }

    @Override
    public void happyLibraryRefreshCache() {
        log.info("===================happyLibraryRefreshCache开始============================");

        HappyLibraryShareVoteDo voteDo =  happyLibraryShareVoteManager.findHappyLibraryShareVoteByVersionDesc();
        if(voteDo == null){
            log.info("===================happyLibraryRefreshCache失败,没有要加载的数据============================");
            return;
        }
        //查出最新版本的活动
        List<HappyLibraryShareVoteDo> byVoteCountDesc =
                happyLibraryShareVoteManager.findHappyLibraryShareVoteByVoteCountDesc(voteDo.getVersion());

        if(CollectionUtils.isEmpty(byVoteCountDesc)){
            log.info("===================happyLibraryRefreshCache失败,没有要加载的数据============================");
            return;
        }

        //获取发生变化的List
//        byVoteCountDesc = this.updateGroupNameAndFaceImg(byVoteCountDesc);


        HappyLibraryDataVo happyLibraryDataVo = new HappyLibraryDataVo();

        List<HappyLibraryListDataVo> happyLibraryListDataVo = SpringCglibBeanUtils.convertByList(byVoteCountDesc,HappyLibraryListDataVo.class);

        Long sumCount =  happyLibraryListDataVo.stream().mapToLong( vo -> vo.getVoteCount()).sum();

        happyLibraryDataVo.setHappyLibraryListDataVoList(happyLibraryListDataVo);

        //结束了不返回
        HappyLibraryHeadDataVo happyLibraryHeadDataVo = SpringCglibBeanUtils.convert(byVoteCountDesc.get(0),HappyLibraryHeadDataVo.class);
        happyLibraryHeadDataVo.setStarSumCount(sumCount);
        happyLibraryDataVo.setHappyLibraryHeadDataVo(happyLibraryHeadDataVo);


        redisService.set(ActivitySysConstants.HAPPY_LIBRARY_REDIS_KEY,happyLibraryDataVo);
        log.info("===================happyLibraryRefreshCache成功============================");
    }

//    private List<HappyLibraryShareVoteDo> updateGroupNameAndFaceImg(List<HappyLibraryShareVoteDo> byVoteCountDesc){
//        //获取用户id
//        List<Long> userIdList = byVoteCountDesc.stream().map(bean -> bean.getGroupId()).collect(Collectors.toList());
//
//        //需要改头像的List
//        List<HappyLibraryShareVoteDo> updateImgAndNameList =new ArrayList<>(byVoteCountDesc.size());
//
//        userIdList.forEach(userId -> {
//            //查出用户
//            CommonUserInfoDo commonUserInfoDo = commonUserInfoManager.findUserByUniId(userId);
//            String nikeName = commonUserInfoDo.getNickName();
//            String faceImg = commonUserInfoDo.getPersonImgUrlMin();
//            for(int i = 0 ;i < byVoteCountDesc.size(); i ++){
//                HappyLibraryShareVoteDo bean =  byVoteCountDesc.get(i);
//                if(commonUserInfoDo.getSysUniId().equals(bean.getGroupId())){
//                    //看用户是否修改了头像了昵称
//                    if(nikeName.equals(bean.getGroupName()) || faceImg.equals(bean.getFaceImg())){
//                        HappyLibraryShareVoteDo update = new HappyLibraryShareVoteDo();
//                        update.setGroupId(bean.getGroupId());
//                        update.setGroupName(nikeName);
//                        update.setFaceImg(faceImg);
//                        //修改
//                        happyLibraryShareVoteManager.updateGroupNameAndFaceImg(update);
//                        //插入修改后的数据
//                        bean.setFaceImg(faceImg);
//                        bean.setGroupName(nikeName);
//                    }
//                    updateImgAndNameList.add(bean);
//                }
//           }
//        });
//        return updateImgAndNameList;
//    }
}
