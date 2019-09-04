package com.hndl.cn.mghd.admin.business.friend.service.impl;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.follow.FollowTypeEnums;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.admin.business.friend.service.FriendService;
import com.hndl.cn.mghd.admin.business.friend.vo.FriendInfoVo;
import com.hndl.cn.mghd.admin.business.friend.vo.FriendsVo;
import com.hndl.cn.mghd.admin.common.constants.MgdAdminConstants;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mongodb.manager.follow.bean.UserFollowDo;
import com.hndl.cn.mongodb.manager.follow.manager.UserFollowManager;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.mongodb.manager.user.bean.UserStatisticsDo;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.page.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年6月24日14:04:45
 * @Created by 湖南达联
 */

@Service
public class FriendServiceImpl implements FriendService {

    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;

    @Resource
    private UserFollowManager userFollowManager;

    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    @Resource
    private UserDayTaskManager userDayTaskManager;

    @Override
    public FriendsVo  findFriendsByUserId(Long uniId, String id) {

        if (null!=id && !PageUtils.checkMongoDbObjId(id)) {
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        List<FriendInfoVo> friendInfoVoList = new ArrayList<>();

        //查询出好友信息

        int friendCount = userFollowManager.countFriendByUniId(uniId);//好友人数
        int followCount = userFollowManager.countFollowByUniId(uniId)-friendCount;//关注人数
        int fansCount =  userFollowManager.countFansByFollowId(uniId)-friendCount;//粉丝人数


        List<UserFollowDo> userFollowDos = new ArrayList<>();

        //获取关注信息
        //控制每页显示个数
        if ((followCount+friendCount)>=MgdAdminConstants.PAGE_LIMIT){
         userFollowDos = userFollowManager.findPageFollowByUniId(uniId, FollowTypeEnums.USER_FOLLOW.getType(),id,MgdAdminConstants.PAGE_LIMIT);
        }else{
            userFollowDos = userFollowManager.findPageFollowByUniId(uniId, FollowTypeEnums.USER_FOLLOW.getType(),id,null);
        }


        if (CollectionUtils.isNotEmpty(userFollowDos)) {
            //获取关注用户展示信息
            for (UserFollowDo userFollowDo : userFollowDos) {
                FriendInfoVo friendInfoVo = new FriendInfoVo();

                CommonUserInfoDo userInfoDo = commonUserInfoManager.findUserByUniId(userFollowDo.getFollowUserId());
                if (null == userInfoDo) {
                    continue;
                }

                friendInfoVo.setId(userFollowDo.getId());

                friendInfoVo.setUNiId(userInfoDo.getSysUniId());//长ID

                friendInfoVo.setNikeName(userInfoDo.getNickName());//用户名


                //如果是互相关注 （好友关系）
                if (userFollowManager.eachotherFollow(userFollowDo.getFollowUserId(), uniId)) {

                    UserFollowDo followByUniIdAndFollowId = userFollowManager.findFollowByUniIdAndFollowId(userFollowDo.getFollowUserId(), uniId);

                    if (userFollowDo.getCreateTime() > followByUniIdAndFollowId.getCreateTime()) {
                        friendInfoVo.setFriendTime(userFollowDo.getCreateTime());//建立关系时间
                    } else {
                        friendInfoVo.setFriendTime(followByUniIdAndFollowId.getCreateTime());
                    }
                    friendInfoVo.setState(2);

                } else {
                    friendInfoVo.setFriendTime(userFollowDo.getCreateTime());//建立关系时间
                    friendInfoVo.setState(0);
                }

                friendInfoVoList.add(friendInfoVo);

            }

        }

        // 获取关注我的信息（粉丝）
        List<UserFollowDo> followDos =new ArrayList<>();
        //获取粉丝信息
        //控制每页显示个数
        if (MgdAdminConstants.PAGE_LIMIT-(userFollowDos.size())>0){
        followDos = userFollowManager.findPageFollowByFollowId(uniId,id,MgdAdminConstants.PAGE_LIMIT-(followCount+friendCount));


        if (CollectionUtils.isNotEmpty(followDos)) {
            //获取粉丝展示信息
            for (UserFollowDo userFollowDo : followDos) {
                FriendInfoVo friendInfoVo = new FriendInfoVo();
                CommonUserInfoDo userInfoDo = commonUserInfoManager.findUserByUniId(userFollowDo.getCreateUserId());
                if (null == userInfoDo) {
                    continue;
                }

                if (userFollowManager.eachotherFollow(uniId, userFollowDo.getCreateUserId())) {
                    continue;
                }
                friendInfoVo.setId(userFollowDo.getId());
                friendInfoVo.setUNiId(userInfoDo.getSysUniId());//长ID
                friendInfoVo.setNikeName(userInfoDo.getNickName());//用户名
                friendInfoVo.setFriendTime(userFollowDo.getCreateTime());//建立关系时间
                friendInfoVo.setActiveTime(userDayTaskManager.getUserLastLoginTime(userInfoDo.getSysUniId()).getCreateTime());//最后活跃时间
                friendInfoVo.setState(1);

                friendInfoVoList.add(friendInfoVo);
            }

        }  }
        FriendsVo friendsVo = new FriendsVo();

        // 查询 积分余额 快乐币余额
        CommonUserInfoDo userByUserId = commonUserInfoManager.findUserByUniId(uniId);
        UserStatisticsDo userStatisticsByUserUinId = userStatisticsDoManager.findUserStatisticsByUserUinId(uniId);

        friendsVo.setFriendInfoVoList(friendInfoVoList);
        if (null!=userStatisticsByUserUinId) {
            friendsVo.setIntegralCount(userStatisticsByUserUinId.getIntegralCount());
        }
        if (null!=userByUserId) {
            friendsVo.setConiCount(userByUserId.getConiCount());
        }
        friendsVo.setFriendCount(friendCount);
        friendsVo.setFollowCount(followCount);
        friendsVo.setFansCount(fansCount);

        return friendsVo;

    }

}
