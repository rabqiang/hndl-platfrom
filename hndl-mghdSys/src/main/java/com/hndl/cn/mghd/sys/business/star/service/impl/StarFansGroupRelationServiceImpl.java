package com.hndl.cn.mghd.sys.business.star.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.permission.RelationPermissionEnum;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.star.service.StarFansGroupRelationService;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupRelationVo;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupStatisticsVo;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupVo;
import com.hndl.cn.mghd.sys.business.star.vo.UserInfoVo;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarDayRankDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupRelationDo;
import com.hndl.cn.mongodb.manager.star.manager.StarDayRankManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupRelationManager;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.collection.MapUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: hndl-platform
 * @description: 粉丝与粉丝会关系的关联信息业务处理实现类
 * @author: 易成贤
 * @create: 2019-04-23 14:05
 * @Created by 湖南达联
 **/
@Service
@Slf4j
public class StarFansGroupRelationServiceImpl implements StarFansGroupRelationService {

    /**
     *
     */
    @Resource
    StarFansGroupRelationManager starFansGroupRelationManager;
    /**
     *
     */
    @Resource
    StarFansGroupManager starFansGroupManager;

    @Resource
    UserDayTaskManager userDayTaskManager;

    @Resource
    CommonUserInfoManager commonUserInfoManager;

    @Resource
    StarDayRankManager starDayRankManager;

    @Resource
    RedisService redisService;

    /**
     * exp：用户新加入粉丝会
     *
     * @param userUniId
     * @param starId
     */
    @Override
    public StarFansGroupVo addStarFansGroupRelation(Long userUniId, Long starId) {

        StarFansGroupDo starFansGroupDo = starFansGroupManager.findStarFansGroup(starId);
        if (null == starFansGroupDo){
            //粉丝会不存在
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
        }
        //获取用户关注了多少粉丝会
        Long count = starFansGroupRelationManager.getFansCountByUserUinId(userUniId);
        //如果用户加入粉丝会超过上限，那么不能再添加
        if (count >= BaseConstants.ADD_FANSGROUP_MAX) {
            //抛出，加入粉丝会已达上限
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_ADD_FANSRELATION_MAX_EXCEPTION.getCode());
        }
        //查询关系表
        StarFansGroupRelationDo relation = starFansGroupRelationManager.findStarFansGroupRelation(userUniId, starId);

        if (null == relation) {
            //插入数据
            starFansGroupRelationManager.insertStarFansGroupRelation(userUniId, starId);
            //更改成功那么粉丝人数+1
            boolean b = starFansGroupManager.updateUserCount(starId, MghdSysConstants.ADD_ONE_NUM);
        }else {
            //用户加入过粉丝会
            if (IsValidEnums.NO.getValue().equals(relation.getIsDelete())) {
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_EXSIT_FANSRELATION_EXCEPTION.getCode());
            }
            starFansGroupRelationManager.updateIsDelete(userUniId, starId, IsValidEnums.NO);
            //更改成功那么粉丝人数+1
            boolean b = starFansGroupManager.updateUserCount(starId, MghdSysConstants.ADD_ONE_NUM);
        }
        StarFansGroupVo starFansGroupVo = SpringCglibBeanUtils.convert(starFansGroupDo, StarFansGroupVo.class);
        StarDayRankDo starIdCurrentRank = starDayRankManager.findCurrentRankByStarId(starId);
        if (starIdCurrentRank != null) {
            //今日排名
            starFansGroupVo.setCurrentRank(starIdCurrentRank.getCurrentRank());
            //  今日票数
            starFansGroupVo.setVoteCount(starIdCurrentRank.getVoteCount());
        }
        return starFansGroupVo;

    }


    /**
     * 用户退出粉丝会
     *
     * @param starId
     * @param sysUniId
     */
    @Override
    public void exitFansGroup(Long starId, Long sysUniId) {
        //查询粉丝会详细数据
        StarFansGroupDo group = starFansGroupManager.findStarFansGroup(starId);
        //粉丝会不存在
        if (group == null) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
        }

        //查询粉丝关系表数据
        StarFansGroupRelationDo relation = starFansGroupRelationManager.findStarFansGroupRelation(sysUniId, starId);
        //查询的粉丝会关系数据不存在
        if (relation == null || IsValidEnums.YES.getValue().equals(relation.getIsDelete())) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANSGOUP_NOT_FIND_EXCEPTION.getCode());
        }

        //1，更新状态为删除
        starFansGroupRelationManager.updateIsDelete(sysUniId, starId, IsValidEnums.YES);

        if (MghdSysConstants.ZERO.equals(group.getUserCount())) {
            //粉丝会没人了，如果系统还要退出，那应该是数据库数据异常
            log.info("=====退出粉丝会时候数据库人数不正常===数据库数据异常！===粉丝会id："+starId);
            throw new MghdSysException(PublicExceptionCodeEnum.EX_UNKNOWN.getCode());
        }
        //2，粉丝会人数-1
        starFansGroupManager.updateUserCount(starId, MghdSysConstants.MINUS_ONE_NUM);
    }


    /**
     * 更新累计打榜天数
     *
     * @param userUniId
     * @param starId
     */
    @Override
    @SuppressWarnings("unchecked")
    public void updateVoteDayCount(Long userUniId, Long starId, VoteTypeEnums voteTypeEnums) {
        boolean flag;
        UserDayTaskEnums userDayTaskEnums;
        switch (voteTypeEnums){
            case INTEGRAL_VOTE:
                userDayTaskEnums =UserDayTaskEnums.INTEGRAL_TASK;
                break;
            case COIN_VOTE:
                userDayTaskEnums =UserDayTaskEnums.GIVE_HEART_TASK;
                break;
            default:
                return;
        }
        flag = userDayTaskManager.findTaskByUserUniIdAndTaskType(userUniId,userDayTaskEnums).size() == 1 ;
        //判断一次
        if (flag){
            starFansGroupRelationManager.updateVoteDayCount(userUniId, starId);
        }

    }

    /**
     * 查询用户与粉丝会数据
     *
     * @param userUinId
     * @param starId
     * @return
     */
    @Override
    public StarFansGroupStatisticsVo findStarFansStatistics(Long userUinId, Long starId) {
        //查询粉丝会详细数据
        StarFansGroupDo group = starFansGroupManager.findStarFansGroup(starId);
        //粉丝会不存在
        if (group == null) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
        }
        //查询粉丝关系表数据
        StarFansGroupRelationDo relation = starFansGroupRelationManager.findStarFansGroupRelation(userUinId, starId);
        //查询的粉丝会关系数据不存在
        if (relation == null || IsValidEnums.YES.getValue().equals(relation.getIsDelete())) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANSGOUP_NOT_FIND_EXCEPTION.getCode());
        }
        StarFansGroupStatisticsVo vo = new StarFansGroupStatisticsVo();
        vo.setFansContribute(relation.getFansContribute());
        vo.setVoteDayCount(relation.getVoteDayCount());
        vo.setFansVoteCount(relation.getVoteCount());
        vo.setStarVoteCount(group.getVoteCount());
        return vo;
    }

    /**
     * 查询粉丝大咖守护大使/
     *
     * @param
     * @param starId
     * @return
     */
    @Override
    public Map<String, List<UserInfoVo>> findGuard(Long starId) {
        Map<String, List<UserInfoVo>> map;

        String redisKey = MgHdRedisKeyEnums.GROUPMAN_CACHE_KEY.getCacheKey(starId);
        //如果缓存有走缓存
        map = redisService.get(redisKey);
        if (MapUtils.isNotEmpty(map)) {
            return map;
        }

        map = new HashMap<>(3);
        //第一部分守护大使
        List<StarFansGroupRelationDo> ambassadorDos = starFansGroupRelationManager.getPowerFans(starId, RelationPermissionEnum.FANS_AMBASSADOR);
        List<UserInfoVo> ambassador = findPower(ambassadorDos);

        map.put("ambassador", ambassador);
        //第二部分粉丝大咖
        List<StarFansGroupRelationDo> masterDos = starFansGroupRelationManager.getPowerFans(starId, RelationPermissionEnum.FANS_MASTER);
        List<UserInfoVo> master = findPower(masterDos);
        map.put("master", master);
        //第三部分超级星粉
        List<StarFansGroupRelationDo> superStarPowderDos = starFansGroupRelationManager.getPowerFans(starId, null);
        List<UserInfoVo> superStarPowder = findPower(superStarPowderDos);
        map.put("superStarPowder", superStarPowder);

        redisService.set(redisKey, map,MgHdRedisKeyEnums.GROUPMAN_CACHE_KEY.getExpireTime());
        return map;
    }

    /**
     * 查询用户关注的粉丝会
     *
     * @param userUniId 用户唯一id
     * @return map集合 key 粉丝会id，val为关系表
     */
    @Override
    public Map<Long, StarFansGroupRelationVo> findstarFansGroupRelationMap(Long userUniId) {
        //1,查询关注的粉丝会
        List<StarFansGroupRelationDo> starFansGroupRelationManagerByUserUinId = starFansGroupRelationManager.findByUserUinId(userUniId);
        //2，转换为vo
        List<StarFansGroupRelationVo> fansGroupRelationVos = SpringCglibBeanUtils.convertByList(starFansGroupRelationManagerByUserUinId, StarFansGroupRelationVo.class);
        //3,构建对象用于存储用户关注的粉丝会表
        Map<Long, StarFansGroupRelationVo> starFansGroupRelationVoMap = new HashMap(8);
        //4,遍历粉丝会关系表 存入map集合
        for (StarFansGroupRelationVo fansGroupRelationVo : fansGroupRelationVos) {
            starFansGroupRelationVoMap.put(fansGroupRelationVo.getStarId(), fansGroupRelationVo);
        }
        //5,返回数据
        return starFansGroupRelationVoMap;
    }

    /**
     * 批量加入粉丝会
     *
     * @param sysUniId
     * @param starIds
     * @return
     */
    @Override
    public Result<List<StarFansGroupVo>> batchAddStarFansGroup(Long sysUniId, List<Long> starIds) {

        if (CollectionUtils.isEmpty(starIds) || CollectionUtils.hasNull(starIds)){
            log.info("传入粉丝会id集合为空或者集合中具有null值");
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        Long count = starFansGroupRelationManager.getFansCountByUserUinId(sysUniId);
        if (count+starIds.size() >= BaseConstants.ADD_FANSGROUP_MAX) {
            //抛出，加入粉丝会已达上限
           log.info("用户加入粉丝会记录数为{},但是传入参数个数为{}",count,starIds.size());
           return ResultFactory.success(new ArrayList<>(1));
        }
        //调用加入粉丝会接口 [如果抛出粉丝会不存在,之前的粉丝会已经加入]
        List<StarFansGroupVo> starFansGroupVos = new ArrayList<>();
        starIds.forEach( v -> starFansGroupVos.add(addStarFansGroupRelation(sysUniId,v)));

        return ResultFactory.success(starFansGroupVos);
    }

    /**
     * 查询指定权限粉丝会列表转换为需要展示vo
     *
     * @param starFansGroupRelationDoList
     * @return
     */
    private List<UserInfoVo> findPower(List<StarFansGroupRelationDo> starFansGroupRelationDoList) {
        //如果为空返回空
        if (CollectionUtils.isEmpty(starFansGroupRelationDoList)) {
            return null;
        }
        List<UserInfoVo> userInfoVos = new ArrayList<>();
        for (StarFansGroupRelationDo relationDo : starFansGroupRelationDoList) {
            CommonUserInfoDo user = commonUserInfoManager.findUserByUserId(relationDo.getUserUniId());
            if (null == user) {
                continue; //防止数据不一致空指针
            }
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.setSysUniId(user.getSysUniId());
            userInfoVo.setPersonImgUrlMin(user.getPersonImgUrlMin());
            userInfoVo.setNickName(user.getNickName());
            userInfoVo.setFansContribute(relationDo.getFansContribute());
            userInfoVos.add(userInfoVo);
        }
        return userInfoVos;
    }


}
