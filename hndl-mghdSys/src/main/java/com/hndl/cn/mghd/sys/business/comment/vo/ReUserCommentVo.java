package com.hndl.cn.mghd.sys.business.comment.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReUserCommentVo implements Serializable {

    private String id;

    private Long userUniId;// 创建人的ID（我回复了 他 存我的ID）

    private Integer commentType;//评论类型 CommentType //暂时默认值1

    private Long targetId;//评论对象id （动态的ID =帖子ID）

    private String userNickName;//用户昵称

    private String userImg;//用户头像

    private Long createTime;//创建时间

    private String content;//内容

    private Long repliesUserId;//回复人id （我回复了 他  存他的ID）

    private String repliesNickName;//回复人昵称
}
