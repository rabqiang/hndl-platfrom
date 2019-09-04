package com.hndl.cn.mongodb.manager.follow.manager;

import com.hndl.cn.mongodb.manager.follow.bean.UserFollowDo;

import java.util.List;

/**
 * @author 尹争鸣
 * @Description  关注用户
 * @Date 2019年5月24日17:33:42
 * @Created by 湖南达联
 */
public interface UserFollowManager {


    /**
     * 关注用户
     * */
    void insertFollow(UserFollowDo userFollowDo);


    /**
     * 取消关注  isDelete =yes 1
     * */

    void delFollow(Long userUniId,Long followId);


    /**
     * 获取用户所关注的人   isDelete =NO 2
     * */
    List<UserFollowDo> findFollowByUniId(Long userUniId,int followType,String id,Integer limit);

  /**
     * 获取用户的粉丝   isDelete =NO 2
     * */
    List<UserFollowDo> findFollowByFollowId(Long followId,String id,int limit);


    /**
     *  判断是否关注
     * */

    boolean  eachotherFollow(Long userUniId,Long followId);

    /**
     * 查询指定关系
     * */

    UserFollowDo findFollowByUniIdAndFollowId(Long userUniId,Long followId);

    /**
     * 后台 获取用户所关注的人   isDelete =NO 2
     * */
    List<UserFollowDo> findPageFollowByUniId(Long userUniId,int followType,String id,Integer limit);

    /**
     *  后台获取用户的粉丝   isDelete =NO 2
     * */
    List<UserFollowDo> findPageFollowByFollowId(Long followId,String id,int limit);



    /**
     *  获取用户关注数  isDelete =NO 2
     * */
    int countFollowByUniId(Long userUniId);

    /**
     *  获取用户粉丝数  isDelete =NO 2
     * */
    int countFansByFollowId(Long followId);

    /**
     * 获取好友数（相互关注） isDelete=NO 2
     * */
     int countFriendByUniId(Long userUniId);




    /**
     *  批量插入：导数据用
     * */

    void insertFollowAll( List<UserFollowDo> userFollowDos);
}
