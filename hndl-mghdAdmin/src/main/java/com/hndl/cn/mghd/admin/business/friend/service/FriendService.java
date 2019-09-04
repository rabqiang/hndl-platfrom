package com.hndl.cn.mghd.admin.business.friend.service;


import com.hndl.cn.mghd.admin.business.friend.vo.FriendsVo;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年6月20日14:04:45
 * @Created by 湖南达联
 * */

public interface FriendService {

    /**
     * 查询好友
     * */
    FriendsVo findFriendsByUserId(Long uniId,String id);
}
