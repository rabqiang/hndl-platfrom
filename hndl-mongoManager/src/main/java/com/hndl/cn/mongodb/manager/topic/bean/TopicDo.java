package com.hndl.cn.mongodb.manager.topic.bean;

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
 * @program:hndl-platform
 * @description:TODO 话题do
 * @author: 易成贤
 * @create: 2019/7/29 11:29
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_topic_info")
@CompoundIndexes({
        @CompoundIndex(name="topic_index",def = "{endRecommendTime:1,isDelete:1,publishTime:1,audit:1}",background = true)
})
public class TopicDo implements Serializable {

    /**
     * id
     */
    @Id
    private String id;

    /**
     * 创建时间
     */
    @Indexed(direction = IndexDirection.DESCENDING)
    private Long createTime;

    /**
     * 创建者
     */
    private Long createAdminId;

    /**
     * 更新时间
     */
    @Indexed
    private Long updateTime;

    /**
     * 最后更新者
     */
    private Long updateAdminId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 审核状态【发布状态】
     */
    @Indexed
    private Integer audit;

    /**
     * 话题标题图
     */
    private String titleImgUrl;

    /**
     * 点赞数
     */
    @Indexed
    private Integer likeCount;


    /**
     * 发布时间
     */
    @Indexed
    private Long publishTime;


    /**
     * 结束推荐时间
     */
    @Indexed
    private Long endRecommendTime;

    /**
     * 推荐
     */
    @Indexed
    private Long isRecommen;

    /**
     * 评论数
     */
    private Integer commentCount;

    /**
     * 是否删除
     */

    private Integer isDelete;


}
