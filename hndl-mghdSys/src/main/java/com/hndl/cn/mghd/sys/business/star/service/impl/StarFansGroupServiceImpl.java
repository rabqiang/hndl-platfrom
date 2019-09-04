package com.hndl.cn.mghd.sys.business.star.service.impl;


import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.call.vo.StarCallContentVo;
import com.hndl.cn.mghd.sys.business.star.service.StarFansGroupService;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupVo;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarDayRankDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupRelationDo;
import com.hndl.cn.mongodb.manager.star.manager.StarDayRankManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupRelationManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: hndl-platform
 * @description: 粉丝会详细
 * @author: 易成贤
 * @create: 2019-04-23 16:09
 * @Created by 湖南达联
 **/
@Service
@Slf4j
public class StarFansGroupServiceImpl implements StarFansGroupService {

    @Resource
    StarFansGroupManager starFansGroupManager;

    @Resource
    StarFansGroupRelationManager starFansGroupRelationManager;
    @Resource
    StarDayRankManager starDayRankManager;

    @Resource
    RedisService redisService;

    /**
     * 查询粉丝详细资料
     *
     * @param starId
     * @return
     */
    @Override
    public StarFansGroupVo findStarFansGroupDetail(CommonUserInfoDo commonUserInfoDo, Long starId) {
        String redisKey = MgHdRedisKeyEnums.STAR_CACHE_KEY.getCacheKey(starId);

        StarFansGroupVo starFansGroupVo =  redisService.get(redisKey);

        if (null != starFansGroupVo) {
            //返回查询数据
            if (null != commonUserInfoDo) {
                //用户是否加入
                StarFansGroupRelationDo starFansGroupRelation = starFansGroupRelationManager.findStarFansGroupRelation(commonUserInfoDo.getSysUniId(), starId);
                Integer isRelation = (null == starFansGroupRelation || IsValidEnums.YES.getValue().equals(starFansGroupRelation.getIsDelete())) ? IsValidEnums.NO.getValue() : IsValidEnums.YES.getValue();
                starFansGroupVo.setIsRelation(isRelation);
            }else {
                starFansGroupVo.setIsRelation(IsValidEnums.NO.getValue());
            }
            return starFansGroupVo;
        } else {
            //查询粉丝会详细记录
            StarFansGroupDo group = starFansGroupManager.findStarFansGroup(starId);
            if (group == null) {
                //查询的粉丝会不存在
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
            }
            starFansGroupVo = SpringCglibBeanUtils.convert(group, StarFansGroupVo.class);
            StarDayRankDo starIdCurrentRank = starDayRankManager.findCurrentRankByStarId(starId);
            if (starIdCurrentRank != null) {
                //今日排名
                starFansGroupVo.setCurrentRank(starIdCurrentRank.getCurrentRank());
                //  今日票数
                starFansGroupVo.setVoteCount(starIdCurrentRank.getVoteCount());
            }
            //存入缓存
            redisService.set(redisKey, starFansGroupVo, MgHdRedisKeyEnums.STAR_CACHE_KEY.getExpireTime());
            //返回查询数据
            if (null != commonUserInfoDo) {
                //用户是否加入
                StarFansGroupRelationDo starFansGroupRelation = starFansGroupRelationManager.findStarFansGroupRelation(commonUserInfoDo.getSysUniId(), starId);
                Integer isRelation = (null == starFansGroupRelation || IsValidEnums.YES.getValue().equals(starFansGroupRelation.getIsDelete())) ? IsValidEnums.NO.getValue() : IsValidEnums.YES.getValue();
                starFansGroupVo.setIsRelation(isRelation);
            }else {
                starFansGroupVo.setIsRelation(IsValidEnums.NO.getValue());
            }
            return starFansGroupVo;
        }
    }

    /**
     * 通过打call数据获取粉丝会map集合
     * @param starCallContentVos 打call 数据的vo
     * @return 返回对应的粉丝会集合 key 为粉丝会id ，val为粉丝会的vo
     */
    @Override
    public  Map<Long,StarFansGroupVo> findStarFansGroupMap(List<StarCallContentVo> starCallContentVos) {
        //1，把所有call数据的粉丝会id提取去重
        Set starIds = new HashSet();
        for (StarCallContentVo contentVo : starCallContentVos) {
            starIds.add(contentVo.getStarId());
        }
        //2，查询相应的粉丝会
        List<StarFansGroupDo> groupDos = starFansGroupManager.findStarFansGroupById(starIds);
        //3，把粉丝会转换为vo
        List<StarFansGroupVo> starFansGroupVoList = SpringCglibBeanUtils.convertByList(groupDos, StarFansGroupVo.class);
        //3-1,如果转换获取的为空那么返回空
        if (CollectionUtils.isEmpty(starFansGroupVoList)) {
            return null;
        }
        //4，构建存储数据map集合
        Map<Long,StarFansGroupVo> starFansGroupVoMap = new HashMap<>(20);
        //5,把数据存入map集合
        for (StarFansGroupVo starFansGroupVo : starFansGroupVoList) {
            starFansGroupVoMap.put(starFansGroupVo.getStarId(),starFansGroupVo);
        }
        //6，返回map数据
        return starFansGroupVoMap;

    }

    /**
     * 查询个人关注的粉丝会
     *
     * @param sysUniId
     * @return
     */
    @Override
    public List<StarFansGroupVo> findListStarFansGroup(Long sysUniId) {
        //查询用户关注的粉丝会
        List<StarFansGroupRelationDo> starFansGroupRelationDos = starFansGroupRelationManager.findByUserUinId(sysUniId);

        //返回数据
        List<StarFansGroupVo> groupVos = new ArrayList<>(8);
        if (CollectionUtils.isEmpty(starFansGroupRelationDos)){
            return groupVos;
        }

        for (StarFansGroupRelationDo starFansGroupRelationDo : starFansGroupRelationDos) {
            StarFansGroupDo group = starFansGroupManager.findStarFansGroup(starFansGroupRelationDo.getStarId());
            //转换对象
            StarFansGroupVo convert = SpringCglibBeanUtils.convert(group, StarFansGroupVo.class);
            if (null == convert) {
                continue;
            }

            StarDayRankDo starIdCurrentRank = starDayRankManager.findCurrentRankByStarId(group.getStarId());
            if ( null != starIdCurrentRank) {
                //今日排名
                convert.setCurrentRank(starIdCurrentRank.getCurrentRank());
                //替换票数为今日票数
                convert.setVoteCount(starIdCurrentRank.getVoteCount());
            } else {
                //今日排名
                convert.setCurrentRank(0);
                //今日票数
                convert.setVoteCount(0L);
            }
            groupVos.add(convert);
        }
        return groupVos;
    }

    /**
     * 查询推荐的明星
     *
     * @return
     */
    @Override
    public List<StarFansGroupVo> findRecommendStar(CommonUserInfoDo commonUserInfoDo) {
        List<StarFansGroupDo> recommendStar = starFansGroupManager.findRecommendStar();
        List<StarFansGroupVo> starFansGroupVos = SpringCglibBeanUtils.convertByList(recommendStar, StarFansGroupVo.class);
        Map<Long, List<StarFansGroupRelationDo>> map = starFansGroupRelationManager.findByUserUinId(commonUserInfoDo.getSysUniId()).stream().collect(Collectors.groupingBy(StarFansGroupRelationDo::getStarId));
        //设置关注状态
        starFansGroupVos.forEach(
                v -> v.setIsRelation( map.get(v.getStarId()) == null ? IsValidEnums.NO.getValue() : IsValidEnums.YES.getValue())
        );

        return starFansGroupVos;
    }
}


