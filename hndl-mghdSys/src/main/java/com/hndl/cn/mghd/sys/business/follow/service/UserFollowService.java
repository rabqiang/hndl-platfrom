package com.hndl.cn.mghd.sys.business.follow.service;

import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.call.vo.StarCallContentVo;
import com.hndl.cn.mghd.sys.business.follow.vo.FollowCountVo;
import com.hndl.cn.mghd.sys.business.follow.vo.ReUserFollowVo;
import com.hndl.cn.mghd.sys.business.follow.vo.UserFollowVo;

import java.util.List;


/**
 * @author 尹争鸣
 * @Description 关注功能
 * @Date 2019年5月28日11:45:22
 * @Created by 湖南达联
 */
public interface UserFollowService {
    /**
     * 添加关注
     * */
    void followUser(CommonUserInfoDo commonUserInfoDo,UserFollowVo userFollowVo);


    /**
     * 取消关注
     * */
    void cancelFollow(CommonUserInfoDo commonUserInfoDo,UserFollowVo userFollowVo);

    /**
     * 获取关注信息 by uNiId
     * */
    List<UserFollowVo> findFollowByUniId(CommonUserInfoDo commonUserInfoDo,int followType);

    /**
     * 获取关注信息 by uNiId
     * */
    List<ReUserFollowVo> findFollow(CommonUserInfoDo commonUserInfoDo);



    /**
     * 推荐日榜前八名
     * */
    List<ReUserFollowVo>  recommendedFollow();


    /**
     *  获取关注数and粉丝数相关信息
     * */
    FollowCountVo findFollowCount(CommonUserInfoDo commonUserInfoDo);


    /**
     *  获取用户关注人的CALL信息
     * */
    List<StarCallContentVo> findFollowCall(CommonUserInfoDo commonUserInfoDo, Integer pageNo);




}
