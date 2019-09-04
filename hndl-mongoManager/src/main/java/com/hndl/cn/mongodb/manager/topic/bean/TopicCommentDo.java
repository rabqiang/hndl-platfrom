package com.hndl.cn.mongodb.manager.topic.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
*  @author 尹争鸣
*  @Description  话题评论DO
*  @Date  2019年7月24日17:18:17
*  @Created by 湖南达联
*/


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_topic_comment")
public class TopicCommentDo {

    @Id
    private String id;

    @Indexed
    private Long commentId;//评论id

    @Indexed
    private Long userUniId;// 创建人的ID（我回复了 他 存我的ID）

    @Indexed
    private Long  replyCommentId;// 评论回复ID

    @Indexed
    private String topicId;// 话题id

    private String userNickName;//用户昵称

    private String userImg;//用户头像

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long createTime;//创建时间

    private String content;//内容

    private List<String> contentImgList;//内容图片

    @Indexed
    private Long repliesUserId;//回复人id （我回复了 他  存他的ID）

    private String repliesNickName;//回复人昵称

    @Indexed
    private Integer isDelete; //是否删除

    private Integer  commentCount;// 评论数

    private Integer  likeCount;//点赞数

    @Indexed
    private Integer hotCount;// 热度值
}
