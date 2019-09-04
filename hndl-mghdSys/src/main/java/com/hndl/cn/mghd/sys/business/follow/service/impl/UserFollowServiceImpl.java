package com.hndl.cn.mghd.sys.business.follow.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.follow.FollowTypeEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.call.service.StarFansCircleService;
import com.hndl.cn.mghd.sys.business.call.vo.StarCallContentVo;
import com.hndl.cn.mghd.sys.business.follow.service.UserFollowService;
import com.hndl.cn.mghd.sys.business.follow.vo.FollowCountVo;
import com.hndl.cn.mghd.sys.business.follow.vo.ReUserFollowVo;
import com.hndl.cn.mghd.sys.business.follow.vo.UserFollowVo;
import com.hndl.cn.mghd.sys.business.follow.vo.UserInfoVo;
import com.hndl.cn.mghd.sys.business.star.service.StarFansGroupService;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupVo;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.content.bean.StarCallContentDo;
import com.hndl.cn.mongodb.manager.content.manager.StarCallContentManger;
import com.hndl.cn.mongodb.manager.follow.bean.UserFollowDo;
import com.hndl.cn.mongodb.manager.follow.manager.UserFollowManager;
import com.hndl.cn.mongodb.manager.star.bean.StarDayRankDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupRelationDo;
import com.hndl.cn.mongodb.manager.star.manager.StarDayRankManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupRelationManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.nosql.redis.page.RedisPageService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.LocalDateUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author 尹争鸣
 * @Description
 * @Date 2019年5月28日11:45:22
 * @Created by 湖南达联
 */
@Service
public class UserFollowServiceImpl implements UserFollowService {

    @Resource
    private UserFollowManager userFollowManager;

    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    @Resource
    private StarFansGroupManager starFansGroupManager;

    @Resource
    private StarFansGroupService starFansGroupService;

    @Resource
    private StarCallContentManger starCallContentManger;

    @Resource
    private StarFansGroupRelationManager starFansGroupRelationManager;

    @Resource
    private StarDayRankManager starDayRankManager;

    @Resource
    private StarFansCircleService starFansCircleService;

    @Resource
    private RedisService redisService;

    @Resource
    private RedisPageService redisPageService;


    @Override
    @SubmitLock(keys="commonUserInfoDo#sysUniId",sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public void followUser(CommonUserInfoDo commonUserInfoDo, UserFollowVo userFollowVo) {


        //不能自己关注自己
        if (commonUserInfoDo.getSysUniId().equals(userFollowVo.getFollowUserId())) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_FOLLOW_EXCEPTION.getCode());
        }

        //是否已关注
        if (userFollowManager.eachotherFollow(commonUserInfoDo.getSysUniId(), userFollowVo.getFollowUserId())) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_REPETITION_FOLLOW_EXCEPTION.getCode());
        }

        //被关注用户是否存在
        CommonUserInfoDo followCommonUserInfoDo = commonUserInfoManager.findUserByUniId(userFollowVo.getFollowUserId());

        if (followCommonUserInfoDo == null) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_FOLLOW_EXCEPTION.getCode());
        }

        UserFollowDo userFollowDo = SpringCglibBeanUtils.convert(userFollowVo, UserFollowDo.class);
        userFollowDo.setCreateUserId(commonUserInfoDo.getSysUniId());

        userFollowManager.insertFollow(userFollowDo);
    }

    @Override
    public void cancelFollow(CommonUserInfoDo commonUserInfoDo, UserFollowVo userFollowVo) {

        userFollowManager.delFollow(commonUserInfoDo.getSysUniId(), userFollowVo.getFollowUserId());
    }


    @Override
    public List<UserFollowVo> findFollowByUniId(CommonUserInfoDo commonUserInfoDo, int followType) {
        //设置key
        String key = MgHdRedisKeyEnums.FOLLOW_CACHE_KEY.getCacheKey(commonUserInfoDo.getSysUniId() + followType);

        //获取缓存
        List<UserFollowDo> userFollowDoList = redisService.get(key);
        if (CollectionUtils.isEmpty(userFollowDoList)) {
            userFollowDoList = userFollowManager.findFollowByUniId(commonUserInfoDo.getSysUniId(), followType,null,null);
            redisService.set(key, userFollowDoList, MgHdRedisKeyEnums.FOLLOW_CACHE_KEY.getExpireTime());

        }

        return CollectionUtils.isEmpty(userFollowDoList) ? new ArrayList<>() :
                SpringCglibBeanUtils.convertByList(userFollowDoList, UserFollowVo.class);
    }


    @Override
    public List<ReUserFollowVo> findFollow(CommonUserInfoDo commonUserInfoDo) {


        //设置key
        String key = MgHdRedisKeyEnums.FOLLOW_USER_CACKE_KEY.getCacheKey(commonUserInfoDo.getSysUniId());


        //获取缓存
        List<UserFollowDo> userFollowDoList = redisService.get(key);

        if (CollectionUtils.isNotEmpty(userFollowDoList)) {
            return redisService.get(key);
        }

        List<UserFollowVo> userFollowVoList = this.findFollowByUniId(commonUserInfoDo, FollowTypeEnums.USER_FOLLOW.getType());
        List<StarFansGroupRelationDo> starFansGroupRelationDos = starFansGroupRelationManager.findByUserUinId(commonUserInfoDo.getSysUniId());
        List<ReUserFollowVo> reUserFollowVoList = new ArrayList<>();
        //如果没有关注任何人
        if (CollectionUtils.isEmpty(userFollowVoList) && CollectionUtils.isEmpty(starFansGroupRelationDos)) {
            return null;
        }

        //如果关注了用户
        if (CollectionUtils.isNotEmpty(userFollowVoList)) {
            for (UserFollowVo userFollowVo : userFollowVoList) {
                ReUserFollowVo reUserFollowVo = new ReUserFollowVo();

                //获取用户信息
                reUserFollowVo.setUserId(userFollowVo.getCreateUserId());
                reUserFollowVo.setNickName(commonUserInfoDo.getNickName());
                reUserFollowVo.setFollowType(userFollowVo.getFollowType());
                reUserFollowVo.setPersonImgUrlMin(commonUserInfoDo.getPersonImgUrlMin());

                if (userFollowVo.getFollowType().equals(FollowTypeEnums.USER_FOLLOW.getType())) {
                    //获取用户信息
                    CommonUserInfoDo userByUniId = commonUserInfoManager.findUserByUniId(userFollowVo.getFollowUserId());

                    if (userByUniId == null) {
                        //抛出异常，用户不存在
                        throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_NOT_FIND_USER_EXCEPTION.getCode());
                    }

                    reUserFollowVo.setFollowUserId(userFollowVo.getFollowUserId());
                    reUserFollowVo.setStarName(userByUniId.getNickName());
                    reUserFollowVo.setStarUrl(userByUniId.getPersonImgUrlMin());


                }


                reUserFollowVoList.add(reUserFollowVo);
            }
        }


        if (CollectionUtils.isNotEmpty(starFansGroupRelationDos)) {

            for (StarFansGroupRelationDo starFansGroupRelationDo : starFansGroupRelationDos) {
             
                StarFansGroupDo starFansGroup = starFansGroupManager.findStarFansGroup(starFansGroupRelationDo.getStarId());

                if (starFansGroup == null) {
                    //明星/粉丝会不存在
                   // throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
                    continue;
                }

                ReUserFollowVo reUserFollowVo = new ReUserFollowVo();

                //获取用户信息
                reUserFollowVo.setUserId(starFansGroupRelationDo.getUserUniId());
                reUserFollowVo.setNickName(commonUserInfoDo.getNickName());
                reUserFollowVo.setFollowType(FollowTypeEnums.STAR_FOLLOW.getType());
                reUserFollowVo.setPersonImgUrlMin(commonUserInfoDo.getPersonImgUrlMin());

                //获取粉丝会明星信息
                reUserFollowVo.setStarId(starFansGroup.getStarId());
                reUserFollowVo.setFollowUserId(starFansGroup.getMappingUserId());
                reUserFollowVo.setStarName(starFansGroup.getStarName());
                reUserFollowVo.setStarUrl(starFansGroup.getStarImg());

                reUserFollowVoList.add(reUserFollowVo);

            }


        }
        redisService.set(key, reUserFollowVoList, MgHdRedisKeyEnums.FOLLOW_USER_CACKE_KEY.getExpireTime());

        return CollectionUtils.isEmpty(reUserFollowVoList) ? new ArrayList<>() : reUserFollowVoList;

    }

    @Override
    public List<ReUserFollowVo> recommendedFollow() {
        List<StarDayRankDo> starDayRankDos = starDayRankManager.findStarDayRankByRankDate(LocalDateUtil.localDateToMilliSecond(LocalDate.now()), BaseConstants.ADD_FANSGROUP_MAX);
        List<ReUserFollowVo> reUserFollowVos = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(starDayRankDos)) {
            for (StarDayRankDo starDayRankDo : starDayRankDos) {
                ReUserFollowVo reUserFollowVo = new ReUserFollowVo();
                reUserFollowVo.setStarId(starDayRankDo.getStarId());
                reUserFollowVo.setStarName(starDayRankDo.getStarName());
                reUserFollowVo.setStarUrl(starDayRankDo.getStarImg());

                reUserFollowVos.add(reUserFollowVo);

            }

        }
        return CollectionUtils.isEmpty(reUserFollowVos) ? new ArrayList<>() : reUserFollowVos;
    }

    @Override
    public List<StarCallContentVo> findFollowCall(CommonUserInfoDo commonUserInfoDo, Integer pageNo) {

        //设置key
        String key = MgHdRedisKeyEnums.FOLLOW_CALL_CACKE_KEY.getCacheKey(commonUserInfoDo.getSysUniId());

        //获取缓存
        List<StarCallContentVo> starCallContentVoList = redisPageService.getKVList(key, pageNo, BaseConstants.DEFAULT_LIMIT);
        if (CollectionUtils.isNotEmpty(starCallContentVoList)) {
            return starFansCircleService.findLike(commonUserInfoDo, starCallContentVoList);
        }


        List<UserFollowVo> userFollowVoList = this.findFollowByUniId(commonUserInfoDo, FollowTypeEnums.USER_FOLLOW.getType());
        List<StarFansGroupRelationDo> starFansGroupRelationDos = starFansGroupRelationManager.findByUserUinId(commonUserInfoDo.getSysUniId());
        List<StarCallContentVo> starCallContentVos = new ArrayList<>();

        Set<Long> userIdList = new HashSet<>();


        if (CollectionUtils.isNotEmpty(userFollowVoList)) {
            Set<Long> collect = userFollowVoList.stream().filter(user -> user != null).map(user -> user.getFollowUserId()).collect(Collectors.toSet());
            if (userIdList.size() > MghdSysConstants.USER_FOLLOW_NUM) {
                userIdList.addAll(CollectionUtils.getSubStringByRandom(new ArrayList<>(collect), MghdSysConstants.USER_FOLLOW_NUM));
            } else {
                userIdList.addAll(collect);
            }
        }

        //没有关注任何明星和用户 获取明星日榜 前八名 爱豆说
        if (CollectionUtils.isNotEmpty(starFansGroupRelationDos)) {

            List<Long> starIdList = starFansGroupRelationDos.stream().map(relation -> relation.getStarId()).collect(Collectors.toList());

            List<StarFansGroupDo> starFansGroupById = starFansGroupManager.findStarFansGroupById(starIdList);

            Set<Long> collect = starFansGroupById.stream().filter(group -> group != null).map(group -> group.getMappingUserId()).collect(Collectors.toSet());

            userIdList.addAll(collect);
        }

        if (CollectionUtils.isEmpty(userIdList)) {
            return new ArrayList<>();
        }


        List<StarCallContentDo> userListCallContent = starCallContentManger.findUserListCallContent(userIdList, null, MghdSysConstants.ONE_HUNDRED_PAGE_LIMIT);

        if (CollectionUtils.isEmpty(userListCallContent)) {
            return new ArrayList<>();
        }

        starCallContentVos = SpringCglibBeanUtils.convertByList(userListCallContent, StarCallContentVo.class);

        Map<Long, StarFansGroupVo> starFansGroupMap = starFansGroupService.findStarFansGroupMap(starCallContentVos);

        starCallContentVos.stream().forEach(val -> val.setStarFansGroupVo(starFansGroupMap.get(val.getStarId())));

        starCallContentVos = starCallContentVos.stream().sorted(Comparator.comparing(StarCallContentVo::getCreateTime).reversed()).collect(Collectors.toList());

        redisService.set(key, starCallContentVos, MgHdRedisKeyEnums.FOLLOW_CALL_CACKE_KEY.getExpireTime());

        Integer limit = (BaseConstants.DEFAULT_LIMIT * pageNo) - BaseConstants.DEFAULT_LIMIT;

        return starFansCircleService.findLike(commonUserInfoDo, starCallContentVos.stream().skip(limit).limit(BaseConstants.DEFAULT_LIMIT).collect(Collectors.toList()));
    }


    @Override
    public FollowCountVo findFollowCount(CommonUserInfoDo commonUserInfoDo) {


        // 获取我关注的人信息
        List<StarFansGroupRelationDo> starFansGroupRelationDos = starFansGroupRelationManager.findByUserUinId(commonUserInfoDo.getSysUniId());

        int followCount = 0;
        List<UserInfoVo> followVos = new ArrayList<>();

        List<UserFollowDo> userFollowDos = userFollowManager.findFollowByUniId(commonUserInfoDo.getSysUniId(), FollowTypeEnums.USER_FOLLOW.getType(),null,null);

        if (CollectionUtils.isNotEmpty(userFollowDos)) {
            //获取用户头像和名字
            for (UserFollowDo userFollowDo : userFollowDos) {

                CommonUserInfoDo userInfoDo = commonUserInfoManager.findUserByUniId(userFollowDo.getFollowUserId());
                if (null == userInfoDo) {
                    continue;
                }
                UserInfoVo userInfoVo = new UserInfoVo();
                userInfoVo.setStarIdOrUniId(userInfoDo.getSysUniId());
                userInfoVo.setNikeName(userInfoDo.getNickName());
                userInfoVo.setImgUrl(userInfoDo.getPersonImgUrlMin());
                if (StringUtils.isBlank(userInfoDo.getPersonalAutograph())) {
                    userInfoVo.setDescription(MghdSysConstants.DEFAULT_SIGNATURE);
                } else {
                    userInfoVo.setDescription(userInfoDo.getPersonalAutograph());
                }
                userInfoVo.setState(userFollowManager.eachotherFollow(userInfoDo.getSysUniId(), commonUserInfoDo.getSysUniId()) ? MghdSysConstants.ONE : MghdSysConstants.ZERO);
                userInfoVo.setRoleType(FollowTypeEnums.USER_FOLLOW.getType());
                followVos.add(userInfoVo);


            }
            //获取我关注的用户个数
            followCount += userFollowDos.size();
        }

        if (CollectionUtils.isNotEmpty(starFansGroupRelationDos)) {
            //获取明星头像和名字
            for (StarFansGroupRelationDo starFansGroupRelationDo : starFansGroupRelationDos) {

                StarFansGroupDo starFansGroup = starFansGroupManager.findStarFansGroup(starFansGroupRelationDo.getStarId());
                if (null == starFansGroup) {
                    continue;
                }
                UserInfoVo userInfoVo = new UserInfoVo();
                userInfoVo.setNikeName(starFansGroup.getStarName());
                userInfoVo.setStarIdOrUniId(starFansGroup.getStarId());
                userInfoVo.setDescription(starFansGroup.getStarDescription());
                userInfoVo.setImgUrl(starFansGroup.getStarImg());
                userInfoVo.setState(MghdSysConstants.ZERO);
                userInfoVo.setRoleType(FollowTypeEnums.STAR_FOLLOW.getType());
                followVos.add(userInfoVo);
            }
            //获取我关注的用户个数加上粉丝会个数
            followCount += starFansGroupRelationDos.size();
        }

        // 获取关注我的信息（粉丝）
        int fansCount = 0;

        List<UserInfoVo> fansVos = new ArrayList<>();


        List<UserFollowDo> followDos = userFollowManager.findFollowByFollowId(commonUserInfoDo.getSysUniId(),null,MghdSysConstants.ZERO);

        if (CollectionUtils.isNotEmpty(followDos)) {

            for (UserFollowDo userFollowDo : followDos) {
                CommonUserInfoDo userInfoDo = commonUserInfoManager.findUserByUniId(userFollowDo.getCreateUserId());
                if (null == userInfoDo) {
                    continue;
                }
                UserInfoVo userInfoVo = new UserInfoVo();
                userInfoVo.setStarIdOrUniId(userInfoDo.getSysUniId());
                userInfoVo.setNikeName(userInfoDo.getNickName());
                userInfoVo.setImgUrl(userInfoDo.getPersonImgUrlMin());
                userInfoVo.setDescription(userInfoDo.getPersonalAutograph());
                userInfoVo.setRoleType(FollowTypeEnums.USER_FOLLOW.getType());
                userInfoVo.setState(userFollowManager.eachotherFollow(commonUserInfoDo.getSysUniId(), userInfoDo.getSysUniId()) ? MghdSysConstants.ONE : MghdSysConstants.ZERO);
                fansVos.add(userInfoVo);
            }
            //获取我的粉丝数
            fansCount += followDos.size();
        }

        FollowCountVo followCountVo = new FollowCountVo();
        followCountVo.setFollowCount(followCount);
        followCountVo.setFollowVos(followVos);
        followCountVo.setFansCount(fansCount);
        followCountVo.setFansVos(fansVos);

        return followCountVo == null ? null : followCountVo;
    }


}