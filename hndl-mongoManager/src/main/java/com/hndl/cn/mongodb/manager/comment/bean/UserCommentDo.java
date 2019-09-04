package com.hndl.cn.mongodb.manager.comment.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description 评论类
 * @Date 2019/5/6 15:20
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_comment")
public class UserCommentDo implements Serializable {


    @Id
    private String id;

    @Indexed
    private Long userUniId;// 创建人的ID（我回复了 他 存我的ID）

    private Integer commentType;//评论类型 CommentType //暂时默认值1

    @Indexed
    private Long targetId;//评论对象id （动态的ID =帖子ID）

    private String userNickName;//用户昵称

    private String userImg;//用户头像

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long createTime;//创建时间

    private String content;//内容

    private Long repliesUserId;//回复人id （我回复了 他  存他的ID）

    private String repliesNickName;//回复人昵称

    @Indexed
    private Integer isDelete; //是否删除



}
