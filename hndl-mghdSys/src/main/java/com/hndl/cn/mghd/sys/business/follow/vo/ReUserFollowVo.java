package com.hndl.cn.mghd.sys.business.follow.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author 尹争鸣
 * @Description 返回关注信息VO
 * @Date 2019年5月28日11:45:22
 * @Created by 湖南达联
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReUserFollowVo implements Serializable {

    private Long userId;//用户id

    private  Long starId;//明星id

    private Long followUserId;//被关注者 userUniId

    private String personImgUrlMin;//用户头像

    private String nickName;//用户姓名

    private Integer followType; //关注类型 star 10 or  user 20

    private String starName;//粉丝会名称

    private String starUrl;//粉丝会头像




}
