package com.hndl.cn.mongodb.manager.follow.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author 尹争鸣
 * @Description  关注用户
 * @Date 2019年5月24日17:33:42
 * @Created by 湖南达联
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_follow_info")
public class UserFollowDo {

    @Id
    private String id;

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long createTime;//创建时间

    @Indexed
    private Integer followType; //关注类型 FollowTypeEnums

    @Indexed
    private Long createUserId;//关注者 userUniId

    @Indexed
    private Long followUserId;//被关注者 userUniId


    private  Integer isDelete;//是否删除




}
