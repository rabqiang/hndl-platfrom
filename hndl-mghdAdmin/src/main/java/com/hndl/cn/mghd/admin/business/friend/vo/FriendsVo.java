package com.hndl.cn.mghd.admin.business.friend.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendsVo implements Serializable {

    private List<FriendInfoVo>  friendInfoVoList;// 相关用户信息

    private Integer followCount;//关注人数

    private Integer fansCount;//粉丝人数

    private Integer friendCount;//好友人数

    private Long integralCount;//积分

    private Double coniCount;
}
