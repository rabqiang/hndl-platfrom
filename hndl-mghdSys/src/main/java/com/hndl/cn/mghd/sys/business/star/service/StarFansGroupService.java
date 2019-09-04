package com.hndl.cn.mghd.sys.business.star.service;

import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.call.vo.StarCallContentVo;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupVo;

import java.util.List;
import java.util.Map;

/**
 * @program: hndl-platform
 * @description: 粉丝会详细详细信息
 * @author: 易成贤
 * @create: 2019-04-23 16:08
 * @Created by 湖南达联
 **/
public interface StarFansGroupService {

    /**
     * 查询粉丝详细资料
     *
     * @param starId
     * @return
     */
    StarFansGroupVo findStarFansGroupDetail(CommonUserInfoDo commonUserInfoDo, Long starId);

    /**
     * 通过打call数据获取粉丝会map集合
     * @param starCallContentVos 打call 数据的vo
     * @return 返回对应的粉丝会集合 key 为粉丝会id ，val为粉丝会的vo
     */
    Map<Long,StarFansGroupVo> findStarFansGroupMap(List<StarCallContentVo> starCallContentVos);


    /***
     * 查询个人关注的粉丝会
     * @param sysUniId
     * @return
     */
    List<StarFansGroupVo> findListStarFansGroup(Long sysUniId);

    /**
     * 查询推荐的明星
     * @return
     */
    List<StarFansGroupVo> findRecommendStar(CommonUserInfoDo commonUserInfoDo);
}
