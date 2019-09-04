package com.hndl.cn.mghd.sys.business.follow.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 尹争鸣
 * @Description 返回关注相关信息VO
 * @Date 2019年5月31日11:01:40
 * @Created by 湖南达联
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FollowCountVo implements Serializable {

    private List<UserInfoVo> followVos;// 存储关注者信息

    private Integer  followCount;//统计 关注数

    private List<UserInfoVo>  fansVos;//存储粉丝用户名和头像

    private Integer  fansCount;//统计 粉丝数
}
