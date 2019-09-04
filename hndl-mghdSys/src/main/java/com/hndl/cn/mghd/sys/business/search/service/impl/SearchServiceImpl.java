package com.hndl.cn.mghd.sys.business.search.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.search.service.SearchService;
import com.hndl.cn.mghd.sys.business.search.vo.FansGroupVo;
import com.hndl.cn.mghd.sys.business.star.service.StarFansGroupService;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupVo;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarDayRankDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.manager.StarDayRankManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.MapUtils;
import com.hndl.cn.utils.date.LocalDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program:hndl-platform
 * @description:
 * @author: 易成贤
 * @create: 2019-05-27 17:43
 * @Created by湖南达联
 **/
@Service
@Slf4j
public class SearchServiceImpl implements SearchService {
    @Resource
    StarFansGroupManager starFansGroupManager;
    @Resource
    StarFansGroupService starFansGroupService;
    @Resource
    RedisService redisService;

    @Resource
    StarDayRankManager starDayRankManager;

    /**
     * 根据关键词匹配粉丝会
     *
     * @param keyWords
     * @return
     */
    @Override
    public List<FansGroupVo> searchFansGroup(CommonUserInfoDo commonUserInfoDo, String keyWords) {

        List<FansGroupVo> fansGoupVos = new ArrayList<>();
        Map<Long, List<StarFansGroupVo>> map = starFansGroupService.findListStarFansGroup(commonUserInfoDo.getSysUniId()).stream().collect(Collectors.groupingBy(StarFansGroupVo::getStarId));
        List<StarFansGroupDo> group = starFansGroupManager.findFansGroupByKeyword(keyWords);
        for (StarFansGroupDo starFansGroupDo : group) {
            FansGroupVo fansGoupVo = new FansGroupVo();
            //粉丝会id
            fansGoupVo.setStarId(starFansGroupDo.getStarId());
            //头像
            fansGoupVo.setStarImg(starFansGroupDo.getStarImg());
            //粉丝会名称
            fansGoupVo.setStarName(starFansGroupDo.getStarName());
            //明星描述
            fansGoupVo.setStarDescription(starFansGroupDo.getStarDescription());
            //是否加入
            Integer isRelation = map.get(starFansGroupDo.getStarId()) == null ? IsValidEnums.NO.getValue() : IsValidEnums.YES.getValue();
            fansGoupVo.setIsRelation(isRelation);
            fansGoupVos.add(fansGoupVo);
        }
        return fansGoupVos;

    }

    /**
     * 搜索推荐列表
     *
     * @param commonUserInfoDo
     * @return
     */
    @Override
    public Map<String, List<FansGroupVo>> searchRecommend(CommonUserInfoDo commonUserInfoDo) {


        String redisKey = MgHdRedisKeyEnums.SEARCH_FANSGROUP_CACHE_KEY.getCacheKey();
        Map<String, List<FansGroupVo>> searchMap = redisService.get(redisKey);
        //缓存有的情况
        if (MapUtils.isNotEmpty(searchMap)) {
            return isRelation(commonUserInfoDo, searchMap);
        } else {  //缓存没有的情况
            Map<String, List<FansGroupVo>> searchDate = new HashMap<>(2);
            //第一部分推荐搜索
            List<FansGroupVo> recommend = new ArrayList<>();

            List<FansGroupVo> topSearch = new ArrayList<>();
            // 第二部分热门搜索
            List<StarDayRankDo> rankDate = starDayRankManager.findStarDayRankByRankDate(LocalDateUtil.localDateToMilliSecond(LocalDate.now()), 50);
            List list = new ArrayList();
            for (StarDayRankDo aDo : rankDate) {
                list.add(aDo.getStarId());
            }
            List<StarFansGroupDo> starFansGroup = starFansGroupManager.findStarFansGroupById(list);
            for (StarFansGroupDo groupDo : starFansGroup) {
                FansGroupVo fansGoupVo = new FansGroupVo();
                //粉丝会id
                fansGoupVo.setStarId(groupDo.getStarId());
                //头像
                fansGoupVo.setStarImg(groupDo.getStarImg());
                //粉丝会名称
                fansGoupVo.setStarName(groupDo.getStarName());
                //明星描述
                fansGoupVo.setStarDescription(groupDo.getStarDescription());
                topSearch.add(fansGoupVo);
            }
            searchDate.put("recommend", recommend);
            searchDate.put("hot", topSearch);
            redisService.set(redisKey, searchDate, MgHdRedisKeyEnums.SEARCH_FANSGROUP_CACHE_KEY.getExpireTime());
            return isRelation(commonUserInfoDo, redisService.get(redisKey));
        }
    }

    /**
     * 是否关注//并且返回是否我已加入的粉丝会
     *
     * @param commonUserInfoDo
     * @param
     * @return
     */
    private Map<String, List<FansGroupVo>> isRelation(CommonUserInfoDo commonUserInfoDo, Map<String, List<FansGroupVo>> searchMap) {
        //判空
        if (MapUtils.isEmpty(searchMap)) {
            return null;
        }

        List<StarFansGroupVo> fansGroup = starFansGroupService.findListStarFansGroup(commonUserInfoDo.getSysUniId());
        Map<Long, List<StarFansGroupVo>> map = fansGroup.stream().collect(Collectors.groupingBy(StarFansGroupVo::getStarId));
        //推荐列表是否关注
        searchMap.get("recommend").stream().forEach(val -> {
            val.setIsRelation(map.get(val.getStarId()) == null ? IsValidEnums.NO.getValue() : IsValidEnums.YES.getValue());
        });

        //热门列表是否关注
        searchMap.get("hot").stream().forEach(val -> {
            val.setIsRelation(map.get(val.getStarId()) == null ? IsValidEnums.NO.getValue() : IsValidEnums.YES.getValue());
        });
        //展示用户自己关注的粉丝会
        List<FansGroupVo> list = new ArrayList<>(1);
        for (StarFansGroupVo groupVo : fansGroup) {
            FansGroupVo fansGoupVo = new FansGroupVo();
            //粉丝会id
            fansGoupVo.setStarId(groupVo.getStarId());
            //头像
            fansGoupVo.setStarImg(groupVo.getStarImg());
            //粉丝会名称
            fansGoupVo.setStarName(groupVo.getStarName());
            //明星描述
            fansGoupVo.setStarDescription(groupVo.getStarDescription());
            list.add(fansGoupVo);
        }
        searchMap.put("myStarFansGroup", list);
        return searchMap;
    }
}
