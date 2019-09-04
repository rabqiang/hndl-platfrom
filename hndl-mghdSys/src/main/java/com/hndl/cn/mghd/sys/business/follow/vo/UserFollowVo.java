package com.hndl.cn.mghd.sys.business.follow.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * @author 尹争鸣
 * @Description 关注信息VO
 * @Date 2019年5月28日11:45:22
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowVo implements Serializable {


    private Long createUserId;//关注者 userUniId

    @NotNull
    private Integer followType; //关注类型 star 10 or  user 20

    @NotNull
    private Long followUserId;//被关注者 userUniId


}
