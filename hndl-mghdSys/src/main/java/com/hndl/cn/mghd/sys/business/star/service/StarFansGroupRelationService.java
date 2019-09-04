package com.hndl.cn.mghd.sys.business.star.service;

import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupRelationVo;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupStatisticsVo;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupVo;
import com.hndl.cn.mghd.sys.business.star.vo.UserInfoVo;

import java.util.List;
import java.util.Map;

/**
 * @program: hndl-platform
 * @description: 粉丝会与粉丝关联信息 //前端
 * @author: 易成贤
 * @create: 2019-04-23 14:03
 * @Created by 湖南达联
 **/

public interface StarFansGroupRelationService {

    /**
     * 新建一个粉丝会关系//一个用户加入到粉丝会
     *
     * @param userUinId
     * @param starId
     */
    StarFansGroupVo addStarFansGroupRelation(Long userUinId, Long starId);

    /**
     * 用户退出粉丝会
     *
     * @param starId
     * @param sysUniId
     */
    void exitFansGroup(Long starId, Long sysUniId);


    /**
     * 更新累计打榜天数
     *
     * @param userUinId
     * @param starId
     */
    void updateVoteDayCount(Long userUinId, Long starId, VoteTypeEnums voteTypeEnums);

    /**
     * @param userUinId
     * @param starId
     * @return
     */
    StarFansGroupStatisticsVo findStarFansStatistics(Long userUinId, Long starId);

    /**
     * 粉丝大咖 守护大使 超级新粉
     *
     * @param
     * @param starId
     * @return
     */
    Map<String, List<UserInfoVo>> findGuard(Long starId);

    /**
     * 查询用户关注的粉丝会关系表
     * @param userUniId 用户唯一id
     * @return map集合 key 粉丝会id，val为关系表
     */
    Map<Long, StarFansGroupRelationVo> findstarFansGroupRelationMap(Long userUniId);

    /**
     * 批量加入粉丝会
     * @param sysUniId
     * @param starIds
     * @return
     */
    Result<List<StarFansGroupVo>> batchAddStarFansGroup(Long sysUniId, List<Long> starIds);
}
